package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes.Builder;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession.Callback;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class MediaSessionCompatApi21 {
    interface Callback {
        void onCommand(String arg1, Bundle arg2, ResultReceiver arg3);

        void onCustomAction(String arg1, Bundle arg2);

        void onFastForward();

        boolean onMediaButtonEvent(Intent arg1);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String arg1, Bundle arg2);

        void onPlayFromSearch(String arg1, Bundle arg2);

        void onRewind();

        void onSeekTo(long arg1);

        void onSetRating(Object arg1);

        void onSetRating(Object arg1, Bundle arg2);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long arg1);

        void onStop();
    }

    static class CallbackProxy extends MediaSession.Callback {
        protected final Callback mCallback;

        public CallbackProxy(Callback mediaSessionCompatApi21$Callback0) {
            this.mCallback = mediaSessionCompatApi21$Callback0;
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            this.mCallback.onCommand(s, bundle0, resultReceiver0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onCustomAction(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            this.mCallback.onCustomAction(s, bundle0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        // 去混淆评级： 低(20)
        @Override  // android.media.session.MediaSession$Callback
        public boolean onMediaButtonEvent(Intent intent0) {
            return this.mCallback.onMediaButtonEvent(intent0) || super.onMediaButtonEvent(intent0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPause() {
            this.mCallback.onPause();
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPlay() {
            this.mCallback.onPlay();
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPlayFromMediaId(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            this.mCallback.onPlayFromMediaId(s, bundle0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPlayFromSearch(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            this.mCallback.onPlayFromSearch(s, bundle0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onRewind() {
            this.mCallback.onRewind();
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onSeekTo(long v) {
            this.mCallback.onSeekTo(v);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onSetRating(Rating rating0) {
            this.mCallback.onSetRating(rating0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onSkipToQueueItem(long v) {
            this.mCallback.onSkipToQueueItem(v);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onStop() {
            this.mCallback.onStop();
        }
    }

    static class QueueItem {
        public static Object createItem(Object object0, long v) {
            return new MediaSession.QueueItem(((MediaDescription)object0), v);
        }

        public static Object getDescription(Object object0) {
            return ((MediaSession.QueueItem)object0).getDescription();
        }

        public static long getQueueId(Object object0) {
            return ((MediaSession.QueueItem)object0).getQueueId();
        }
    }

    static final String TAG = "MediaSessionCompatApi21";

    public static Object createCallback(Callback mediaSessionCompatApi21$Callback0) {
        return new CallbackProxy(mediaSessionCompatApi21$Callback0);
    }

    public static Object createSession(Context context0, String s) {
        return new MediaSession(context0, s);
    }

    public static Parcelable getSessionToken(Object object0) {
        return ((MediaSession)object0).getSessionToken();
    }

    public static boolean hasCallback(Object object0) {
        try {
            Field field0 = object0.getClass().getDeclaredField("mCallback");
            if(field0 != null) {
                field0.setAccessible(true);
                return field0.get(object0) != null;
            }
        }
        catch(NoSuchFieldException | IllegalAccessException unused_ex) {
            Log.w("MediaSessionCompatApi21", "Failed to get mCallback object.");
        }
        return false;
    }

    public static boolean isActive(Object object0) {
        return ((MediaSession)object0).isActive();
    }

    public static void release(Object object0) {
        ((MediaSession)object0).release();
    }

    public static void sendSessionEvent(Object object0, String s, Bundle bundle0) {
        ((MediaSession)object0).sendSessionEvent(s, bundle0);
    }

    public static void setActive(Object object0, boolean z) {
        ((MediaSession)object0).setActive(z);
    }

    public static void setCallback(Object object0, Object object1, Handler handler0) {
        ((MediaSession)object0).setCallback(((MediaSession.Callback)object1), handler0);
    }

    public static void setExtras(Object object0, Bundle bundle0) {
        ((MediaSession)object0).setExtras(bundle0);
    }

    public static void setFlags(Object object0, int v) {
        ((MediaSession)object0).setFlags(v);
    }

    public static void setMediaButtonReceiver(Object object0, PendingIntent pendingIntent0) {
        ((MediaSession)object0).setMediaButtonReceiver(pendingIntent0);
    }

    public static void setMetadata(Object object0, Object object1) {
        ((MediaSession)object0).setMetadata(((MediaMetadata)object1));
    }

    public static void setPlaybackState(Object object0, Object object1) {
        ((MediaSession)object0).setPlaybackState(((PlaybackState)object1));
    }

    public static void setPlaybackToLocal(Object object0, int v) {
        AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder();
        audioAttributes$Builder0.setLegacyStreamType(v);
        ((MediaSession)object0).setPlaybackToLocal(audioAttributes$Builder0.build());
    }

    public static void setPlaybackToRemote(Object object0, Object object1) {
        ((MediaSession)object0).setPlaybackToRemote(((VolumeProvider)object1));
    }

    public static void setQueue(Object object0, List list0) {
        if(list0 == null) {
            ((MediaSession)object0).setQueue(null);
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: list0) {
            arrayList0.add(((MediaSession.QueueItem)object1));
        }
        ((MediaSession)object0).setQueue(arrayList0);
    }

    public static void setQueueTitle(Object object0, CharSequence charSequence0) {
        ((MediaSession)object0).setQueueTitle(charSequence0);
    }

    public static void setSessionActivity(Object object0, PendingIntent pendingIntent0) {
        ((MediaSession)object0).setSessionActivity(pendingIntent0);
    }

    public static Object verifySession(Object object0) {
        if(!(object0 instanceof MediaSession)) {
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }
        return object0;
    }

    public static Object verifyToken(Object object0) {
        if(!(object0 instanceof MediaSession.Token)) {
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }
        return object0;
    }
}

