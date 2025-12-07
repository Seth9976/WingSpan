package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver.PendingResult;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    static class MediaButtonConnectionCallback extends ConnectionCallback {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        MediaButtonConnectionCallback(Context context0, Intent intent0, BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0) {
            this.mContext = context0;
            this.mIntent = intent0;
            this.mPendingResult = broadcastReceiver$PendingResult0;
        }

        private void finish() {
            this.mMediaBrowser.disconnect();
            this.mPendingResult.finish();
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback
        public void onConnected() {
            try {
                Token mediaSessionCompat$Token0 = this.mMediaBrowser.getSessionToken();
                new MediaControllerCompat(this.mContext, mediaSessionCompat$Token0).dispatchMediaButtonEvent(((KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT")));
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", remoteException0);
            }
            this.finish();
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback
        public void onConnectionFailed() {
            this.finish();
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback
        public void onConnectionSuspended() {
            this.finish();
        }

        void setMediaBrowser(MediaBrowserCompat mediaBrowserCompat0) {
            this.mMediaBrowser = mediaBrowserCompat0;
        }
    }

    private static final String TAG = "MediaButtonReceiver";

    public static PendingIntent buildMediaButtonPendingIntent(Context context0, long v) {
        ComponentName componentName0 = MediaButtonReceiver.getMediaButtonReceiverComponent(context0);
        if(componentName0 == null) {
            Log.w("MediaButtonReceiver", "A unique media button receiver could not be found in the given context, so couldn\'t build a pending intent.");
            return null;
        }
        return MediaButtonReceiver.buildMediaButtonPendingIntent(context0, componentName0, v);
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context0, ComponentName componentName0, long v) {
        if(componentName0 == null) {
            Log.w("MediaButtonReceiver", "The component name of media button receiver should be provided.");
            return null;
        }
        int v1 = PlaybackStateCompat.toKeyCode(v);
        if(v1 == 0) {
            Log.w("MediaButtonReceiver", "Cannot build a media button pending intent with the given action: " + v);
            return null;
        }
        Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent0.setComponent(componentName0);
        intent0.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, v1));
        return PendingIntent.getBroadcast(context0, v1, intent0, 0);
    }

    public static ComponentName getMediaButtonReceiverComponent(Context context0) {
        Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent0.setPackage("com.MonsterCouch.Wingspan");
        List list0 = context0.getPackageManager().queryBroadcastReceivers(intent0, 0);
        if(list0.size() == 1) {
            ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(0);
            return new ComponentName(resolveInfo0.activityInfo.packageName, resolveInfo0.activityInfo.name);
        }
        if(list0.size() > 1) {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        }
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context context0, String s) {
        PackageManager packageManager0 = context0.getPackageManager();
        Intent intent0 = new Intent(s);
        intent0.setPackage("com.MonsterCouch.Wingspan");
        List list0 = packageManager0.queryIntentServices(intent0, 0);
        if(list0.size() == 1) {
            ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(0);
            return new ComponentName(resolveInfo0.serviceInfo.packageName, resolveInfo0.serviceInfo.name);
        }
        if(!list0.isEmpty()) {
            throw new IllegalStateException("Expected 1 service that handles " + s + ", found " + list0.size());
        }
        return null;
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat0, Intent intent0) {
        if(mediaSessionCompat0 != null && intent0 != null && "android.intent.action.MEDIA_BUTTON".equals(intent0.getAction()) && intent0.hasExtra("android.intent.extra.KEY_EVENT")) {
            KeyEvent keyEvent0 = (KeyEvent)intent0.getParcelableExtra("android.intent.extra.KEY_EVENT");
            mediaSessionCompat0.getController().dispatchMediaButtonEvent(keyEvent0);
            return keyEvent0;
        }
        return null;
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        if(intent0 != null && "android.intent.action.MEDIA_BUTTON".equals(intent0.getAction()) && intent0.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName componentName0 = MediaButtonReceiver.getServiceComponentByAction(context0, "android.intent.action.MEDIA_BUTTON");
            if(componentName0 != null) {
                intent0.setComponent(componentName0);
                MediaButtonReceiver.startForegroundService(context0, intent0);
                return;
            }
            ComponentName componentName1 = MediaButtonReceiver.getServiceComponentByAction(context0, "android.media.browse.MediaBrowserService");
            if(componentName1 == null) {
                throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            }
            BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.goAsync();
            Context context1 = context0.getApplicationContext();
            MediaButtonConnectionCallback mediaButtonReceiver$MediaButtonConnectionCallback0 = new MediaButtonConnectionCallback(context1, intent0, broadcastReceiver$PendingResult0);
            MediaBrowserCompat mediaBrowserCompat0 = new MediaBrowserCompat(context1, componentName1, mediaButtonReceiver$MediaButtonConnectionCallback0, null);
            mediaButtonReceiver$MediaButtonConnectionCallback0.setMediaBrowser(mediaBrowserCompat0);
            mediaBrowserCompat0.connect();
            return;
        }
        Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent0);
    }

    private static void startForegroundService(Context context0, Intent intent0) {
        if(Build.VERSION.SDK_INT >= 26) {
            context0.startForegroundService(intent0);
            return;
        }
        context0.startService(intent0);
    }
}

