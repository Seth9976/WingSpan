package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat.Builder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager.RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {
    public static abstract class Callback {
        class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(Looper looper0) {
                super(looper0);
            }

            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                if(message0.what == 1) {
                    Callback.this.handleMediaPlayPauseKeySingleTapIfPending(((RemoteUserInfo)message0.obj));
                }
            }
        }

        class StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi21.Callback {
            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
                try {
                    IBinder iBinder0 = null;
                    if(s.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi211 = (MediaSessionImplApi21)Callback.this.mSessionImpl.get();
                        if(mediaSessionCompat$MediaSessionImplApi211 != null) {
                            Bundle bundle1 = new Bundle();
                            Token mediaSessionCompat$Token0 = mediaSessionCompat$MediaSessionImplApi211.getSessionToken();
                            IMediaSession iMediaSession0 = mediaSessionCompat$Token0.getExtraBinder();
                            if(iMediaSession0 != null) {
                                iBinder0 = iMediaSession0.asBinder();
                            }
                            BundleCompat.putBinder(bundle1, "android.support.v4.media.session.EXTRA_BINDER", iBinder0);
                            bundle1.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", mediaSessionCompat$Token0.getSessionToken2Bundle());
                            resultReceiver0.send(0, bundle1);
                        }
                    }
                    else {
                        if(s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                            MediaDescriptionCompat mediaDescriptionCompat0 = (MediaDescriptionCompat)bundle0.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                            return;
                        }
                        if(s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                            MediaDescriptionCompat mediaDescriptionCompat1 = (MediaDescriptionCompat)bundle0.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                            bundle0.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX");
                            return;
                        }
                        if(s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                            MediaDescriptionCompat mediaDescriptionCompat2 = (MediaDescriptionCompat)bundle0.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
                            return;
                        }
                        if(!s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                            return;
                        }
                        MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = (MediaSessionImplApi21)Callback.this.mSessionImpl.get();
                        if(mediaSessionCompat$MediaSessionImplApi210 != null && mediaSessionCompat$MediaSessionImplApi210.mQueue != null) {
                            int v = bundle0.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            if(v >= 0 && v < mediaSessionCompat$MediaSessionImplApi210.mQueue.size()) {
                                iBinder0 = (QueueItem)mediaSessionCompat$MediaSessionImplApi210.mQueue.get(v);
                            }
                            if(iBinder0 != null) {
                                Callback.this.onRemoveQueueItem(((QueueItem)iBinder0).getDescription());
                            }
                        }
                    }
                }
                catch(BadParcelableException unused_ex) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onCustomAction(String s, Bundle bundle0) {
                MediaSessionCompat.ensureClassLoader(bundle0.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                if(s.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                    Uri uri0 = (Uri)bundle0.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.PREPARE")) {
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    bundle0.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    bundle0.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    Uri uri1 = (Uri)bundle0.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                    bundle0.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    bundle0.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                    bundle0.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
                    return;
                }
                if(s.equals("android.support.v4.media.session.action.SET_RATING")) {
                    RatingCompat ratingCompat0 = (RatingCompat)bundle0.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                }
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onFastForward() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public boolean onMediaButtonEvent(Intent intent0) {
                return Callback.this.onMediaButtonEvent(intent0);
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onPause() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onPlay() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onPlayFromMediaId(String s, Bundle bundle0) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onPlayFromSearch(String s, Bundle bundle0) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onRewind() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onSeekTo(long v) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onSetRating(Object object0) {
                RatingCompat.fromRating(object0);
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onSetRating(Object object0, Bundle bundle0) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onSkipToNext() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onSkipToPrevious() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onSkipToQueueItem(long v) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi21$Callback
            public void onStop() {
            }
        }

        class StubApi23 extends StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23.Callback {
            @Override  // android.support.v4.media.session.MediaSessionCompatApi23$Callback
            public void onPlayFromUri(Uri uri0, Bundle bundle0) {
            }
        }

        class StubApi24 extends StubApi23 implements android.support.v4.media.session.MediaSessionCompatApi24.Callback {
            @Override  // android.support.v4.media.session.MediaSessionCompatApi24$Callback
            public void onPrepare() {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi24$Callback
            public void onPrepareFromMediaId(String s, Bundle bundle0) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi24$Callback
            public void onPrepareFromSearch(String s, Bundle bundle0) {
            }

            @Override  // android.support.v4.media.session.MediaSessionCompatApi24$Callback
            public void onPrepareFromUri(Uri uri0, Bundle bundle0) {
            }
        }

        private CallbackHandler mCallbackHandler;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference mSessionImpl;

        public Callback() {
            this.mCallbackHandler = null;
            if(Build.VERSION.SDK_INT >= 24) {
                this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
                return;
            }
            this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23(this));
        }

        void handleMediaPlayPauseKeySingleTapIfPending(RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
            if(!this.mMediaPlayPauseKeyPending) {
                return;
            }
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            MediaSessionImpl mediaSessionCompat$MediaSessionImpl0 = (MediaSessionImpl)this.mSessionImpl.get();
            if(mediaSessionCompat$MediaSessionImpl0 == null) {
                return;
            }
            PlaybackStateCompat playbackStateCompat0 = mediaSessionCompat$MediaSessionImpl0.getPlaybackState();
            if(playbackStateCompat0 != null) {
                boolean z = playbackStateCompat0.getState() != 3;
            }
            mediaSessionCompat$MediaSessionImpl0.setCurrentControllerInfo(mediaSessionManager$RemoteUserInfo0);
            mediaSessionCompat$MediaSessionImpl0.setCurrentControllerInfo(null);
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        }

        public void onCommand(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
        }

        public void onCustomAction(String s, Bundle bundle0) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent0) {
            if(Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            MediaSessionImpl mediaSessionCompat$MediaSessionImpl0 = (MediaSessionImpl)this.mSessionImpl.get();
            if(mediaSessionCompat$MediaSessionImpl0 != null && this.mCallbackHandler != null) {
                KeyEvent keyEvent0 = (KeyEvent)intent0.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if(keyEvent0 != null && keyEvent0.getAction() == 0) {
                    RemoteUserInfo mediaSessionManager$RemoteUserInfo0 = mediaSessionCompat$MediaSessionImpl0.getCurrentControllerInfo();
                    switch(keyEvent0.getKeyCode()) {
                        case 0x4F: 
                        case 85: {
                            if(keyEvent0.getRepeatCount() > 0) {
                                this.handleMediaPlayPauseKeySingleTapIfPending(mediaSessionManager$RemoteUserInfo0);
                                return true;
                            }
                            if(this.mMediaPlayPauseKeyPending) {
                                this.mCallbackHandler.removeMessages(1);
                                this.mMediaPlayPauseKeyPending = false;
                                return mediaSessionCompat$MediaSessionImpl0.getPlaybackState() == null ? true : true;
                            }
                            this.mMediaPlayPauseKeyPending = true;
                            this.mCallbackHandler.sendMessageDelayed(this.mCallbackHandler.obtainMessage(1, mediaSessionManager$RemoteUserInfo0), ((long)ViewConfiguration.getDoubleTapTimeout()));
                            return true;
                        }
                        default: {
                            this.handleMediaPlayPauseKeySingleTapIfPending(mediaSessionManager$RemoteUserInfo0);
                            return false;
                        }
                    }
                }
            }
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String s, Bundle bundle0) {
        }

        public void onPlayFromSearch(String s, Bundle bundle0) {
        }

        public void onPlayFromUri(Uri uri0, Bundle bundle0) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String s, Bundle bundle0) {
        }

        public void onPrepareFromSearch(String s, Bundle bundle0) {
        }

        public void onPrepareFromUri(Uri uri0, Bundle bundle0) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int v) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long v) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetRating(RatingCompat ratingCompat0) {
        }

        public void onSetRating(RatingCompat ratingCompat0, Bundle bundle0) {
        }

        public void onSetRepeatMode(int v) {
        }

        public void onSetShuffleMode(int v) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long v) {
        }

        public void onStop() {
        }

        void setSessionImpl(MediaSessionImpl mediaSessionCompat$MediaSessionImpl0, Handler handler0) {
            this.mSessionImpl = new WeakReference(mediaSessionCompat$MediaSessionImpl0);
            CallbackHandler mediaSessionCompat$Callback$CallbackHandler0 = this.mCallbackHandler;
            if(mediaSessionCompat$Callback$CallbackHandler0 != null) {
                mediaSessionCompat$Callback$CallbackHandler0.removeCallbacksAndMessages(null);
            }
            this.mCallbackHandler = new CallbackHandler(this, handler0.getLooper());
        }
    }

    interface MediaSessionImpl {
        String getCallingPackage();

        RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String arg1, Bundle arg2);

        void setActive(boolean arg1);

        void setCallback(Callback arg1, Handler arg2);

        void setCaptioningEnabled(boolean arg1);

        void setCurrentControllerInfo(RemoteUserInfo arg1);

        void setExtras(Bundle arg1);

        void setFlags(int arg1);

        void setMediaButtonReceiver(PendingIntent arg1);

        void setMetadata(MediaMetadataCompat arg1);

        void setPlaybackState(PlaybackStateCompat arg1);

        void setPlaybackToLocal(int arg1);

        void setPlaybackToRemote(VolumeProviderCompat arg1);

        void setQueue(List arg1);

        void setQueueTitle(CharSequence arg1);

        void setRatingType(int arg1);

        void setRepeatMode(int arg1);

        void setSessionActivity(PendingIntent arg1);

        void setShuffleMode(int arg1);
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        static {
        }

        MediaSessionImplApi18(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0) {
            super(context0, s, componentName0, pendingIntent0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long v) {
            int v1 = super.getRccTransportControlFlagsFromActions(v);
            return (v & 0x100L) == 0L ? v1 : v1 | 0x100;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        void registerMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            if(MediaSessionImplApi18.sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent0);
                }
                catch(NullPointerException unused_ex) {
                    Log.w("MediaSessionCompat", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    MediaSessionImplApi18.sIsMbrPendingIntentSupported = false;
                }
            }
            if(!MediaSessionImplApi18.sIsMbrPendingIntentSupported) {
                super.registerMediaButtonEventReceiver(pendingIntent0, componentName0);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            super.setCallback(mediaSessionCompat$Callback0, handler0);
            if(mediaSessionCompat$Callback0 == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
                return;
            }
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.1 mediaSessionCompat$MediaSessionImplApi18$10 = new RemoteControlClient.OnPlaybackPositionUpdateListener() {
                @Override  // android.media.RemoteControlClient$OnPlaybackPositionUpdateListener
                public void onPlaybackPositionUpdate(long v) {
                    MediaSessionImplApi18.this.postToHandler(18, -1, -1, v, null);
                }
            };
            this.mRcc.setPlaybackPositionUpdateListener(mediaSessionCompat$MediaSessionImplApi18$10);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        void setRccState(PlaybackStateCompat playbackStateCompat0) {
            long v = 0L;
            long v1 = playbackStateCompat0.getPosition();
            float f = playbackStateCompat0.getPlaybackSpeed();
            long v2 = playbackStateCompat0.getLastPositionUpdateTime();
            long v3 = SystemClock.elapsedRealtime();
            if(playbackStateCompat0.getState() == 3 && v1 > 0L) {
                if(v2 > 0L) {
                    v = v3 - v2;
                    if(f > 0.0f && f != 1.0f) {
                        v = (long)(((float)v) * f);
                    }
                }
                v1 += v;
            }
            this.mRcc.setPlaybackState(this.getRccStateFromState(playbackStateCompat0.getState()), v1, f);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            if(MediaSessionImplApi18.sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent0);
                return;
            }
            super.unregisterMediaButtonEventReceiver(pendingIntent0, componentName0);
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0) {
            super(context0, s, componentName0, pendingIntent0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle0) {
            RemoteControlClient.MetadataEditor remoteControlClient$MetadataEditor0 = super.buildRccMetadata(bundle0);
            if(Long.compare((this.mState == null ? 0L : this.mState.getActions()) & 0x80L, 0L) != 0) {
                remoteControlClient$MetadataEditor0.addEditableKey(0x10000001);
            }
            if(bundle0 == null) {
                return remoteControlClient$MetadataEditor0;
            }
            if(bundle0.containsKey("android.media.metadata.YEAR")) {
                remoteControlClient$MetadataEditor0.putLong(8, bundle0.getLong("android.media.metadata.YEAR"));
            }
            if(bundle0.containsKey("android.media.metadata.RATING")) {
                remoteControlClient$MetadataEditor0.putObject(101, bundle0.getParcelable("android.media.metadata.RATING"));
            }
            if(bundle0.containsKey("android.media.metadata.USER_RATING")) {
                remoteControlClient$MetadataEditor0.putObject(0x10000001, bundle0.getParcelable("android.media.metadata.USER_RATING"));
            }
            return remoteControlClient$MetadataEditor0;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
        int getRccTransportControlFlagsFromActions(long v) {
            int v1 = super.getRccTransportControlFlagsFromActions(v);
            return (v & 0x80L) == 0L ? v1 : v1 | 0x200;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            super.setCallback(mediaSessionCompat$Callback0, handler0);
            if(mediaSessionCompat$Callback0 == null) {
                this.mRcc.setMetadataUpdateListener(null);
                return;
            }
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.1 mediaSessionCompat$MediaSessionImplApi19$10 = new RemoteControlClient.OnMetadataUpdateListener() {
                @Override  // android.media.RemoteControlClient$OnMetadataUpdateListener
                public void onMetadataUpdate(int v, Object object0) {
                    if(v == 0x10000001 && object0 instanceof Rating) {
                        RatingCompat ratingCompat0 = RatingCompat.fromRating(object0);
                        MediaSessionImplApi19.this.postToHandler(19, -1, -1, ratingCompat0, null);
                    }
                }
            };
            this.mRcc.setMetadataUpdateListener(mediaSessionCompat$MediaSessionImplApi19$10);
        }
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
        class ExtraSession extends Stub {
            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int v, int v1, String s) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionCompat.getStateWithUpdatedPosition(MediaSessionImplApi21.this.mPlaybackState, MediaSessionImplApi21.this.mMetadata);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public List getQueue() {
                return null;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String s, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String s, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri0, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String s, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String s, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri0, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                if(!MediaSessionImplApi21.this.mDestroyed) {
                    String s = MediaSessionImplApi21.this.getCallingPackage();
                    if(s == null) {
                        s = "android.media.session.MediaController";
                    }
                    RemoteUserInfo mediaSessionManager$RemoteUserInfo0 = new RemoteUserInfo(s, ExtraSession.getCallingPid(), ExtraSession.getCallingUid());
                    MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback0, mediaSessionManager$RemoteUserInfo0);
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void seekTo(long v) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String s, Bundle bundle0) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent0) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int v) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int v) throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int v, int v1, String s) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long v) {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback0);
            }
        }

        boolean mCaptioningEnabled;
        boolean mDestroyed;
        final RemoteCallbackList mExtraControllerCallbacks;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List mQueue;
        int mRatingType;
        int mRepeatMode;
        final Object mSessionObj;
        int mShuffleMode;
        final Token mToken;

        MediaSessionImplApi21(Context context0, String s, Bundle bundle0) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object object0 = MediaSessionCompatApi21.createSession(context0, s);
            this.mSessionObj = object0;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(object0), new ExtraSession(this), bundle0);
        }

        MediaSessionImplApi21(Object object0) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object object1 = MediaSessionCompatApi21.verifySession(object0);
            this.mSessionObj = object1;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(object1), new ExtraSession(this));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public String getCallingPackage() {
            return Build.VERSION.SDK_INT >= 24 ? MediaSessionCompatApi24.getCallingPackage(this.mSessionObj) : null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public RemoteUserInfo getCurrentControllerInfo() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void sendSessionEvent(String s, Bundle bundle0) {
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, s, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setActive(boolean z) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, z);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            MediaSessionCompatApi21.setCallback(this.mSessionObj, (mediaSessionCompat$Callback0 == null ? null : mediaSessionCompat$Callback0.mCallbackObj), handler0);
            if(mediaSessionCompat$Callback0 != null) {
                mediaSessionCompat$Callback0.setSessionImpl(this, handler0);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            if(this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                for(int v = this.mExtraControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v);
                    try {
                        iMediaControllerCallback0.onCaptioningEnabledChanged(z);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCurrentControllerInfo(RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setExtras(Bundle bundle0) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setFlags(int v) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, v);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent0) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat0) {
            this.mMetadata = mediaMetadataCompat0;
            Object object0 = mediaMetadataCompat0 == null ? null : mediaMetadataCompat0.getMediaMetadata();
            MediaSessionCompatApi21.setMetadata(this.mSessionObj, object0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat0) {
            this.mPlaybackState = playbackStateCompat0;
            for(int v = this.mExtraControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onPlaybackStateChanged(playbackStateCompat0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
            Object object0 = playbackStateCompat0 == null ? null : playbackStateCompat0.getPlaybackState();
            MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, object0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToLocal(int v) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, v);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat0) {
            Object object0 = volumeProviderCompat0.getVolumeProvider();
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, object0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueue(List list0) {
            ArrayList arrayList0;
            this.mQueue = list0;
            if(list0 == null) {
                arrayList0 = null;
            }
            else {
                arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    arrayList0.add(((QueueItem)object0).getQueueItem());
                }
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence0) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRatingType(int v) {
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, v);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRepeatMode(int v) {
            if(this.mRepeatMode != v) {
                this.mRepeatMode = v;
                for(int v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onRepeatModeChanged(v);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent0) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setShuffleMode(int v) {
            if(this.mShuffleMode != v) {
                this.mShuffleMode = v;
                for(int v1 = this.mExtraControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                    IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mExtraControllerCallbacks.getBroadcastItem(v1);
                    try {
                        iMediaControllerCallback0.onShuffleModeChanged(v);
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        MediaSessionImplApi28(Context context0, String s, Bundle bundle0) {
            super(context0, s, bundle0);
        }

        MediaSessionImplApi28(Object object0) {
            super(object0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
        public final RemoteUserInfo getCurrentControllerInfo() {
            return new RemoteUserInfo(((MediaSession)this.mSessionObj).getCurrentControllerInfo());
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
        public void setCurrentControllerInfo(RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String s, Bundle bundle0, ResultReceiver resultReceiver0) {
                this.command = s;
                this.extras = bundle0;
                this.stub = resultReceiver0;
            }
        }

        class MediaSessionStub extends Stub {
            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                this.postToHandler(25, mediaDescriptionCompat0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
                this.postToHandler(26, mediaDescriptionCompat0, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int v, int v1, String s) {
                MediaSessionImplBase.this.adjustVolume(v, v1);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                this.postToHandler(16);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                synchronized(MediaSessionImplBase.this.mLock) {
                }
                return MediaSessionImplBase.this.mExtras;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                synchronized(MediaSessionImplBase.this.mLock) {
                }
                return (long)MediaSessionImplBase.this.mFlags;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                synchronized(MediaSessionImplBase.this.mLock) {
                }
                return MediaSessionImplBase.this.mSessionActivity;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                synchronized(MediaSessionImplBase.this.mLock) {
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(MediaSessionImplBase.this.mState, MediaSessionImplBase.this.mMetadata);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public List getQueue() {
                synchronized(MediaSessionImplBase.this.mLock) {
                }
                return MediaSessionImplBase.this.mQueue;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                int v3;
                int v2;
                int v1;
                int v5;
                int v4;
                synchronized(MediaSessionImplBase.this.mLock) {
                    v1 = MediaSessionImplBase.this.mVolumeType;
                    v2 = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat volumeProviderCompat0 = MediaSessionImplBase.this.mVolumeProvider;
                    v3 = 2;
                    if(v1 == 2) {
                        v3 = volumeProviderCompat0.getVolumeControl();
                        v4 = volumeProviderCompat0.getCurrentVolume();
                        v5 = volumeProviderCompat0.getMaxVolume();
                    }
                    else {
                        v5 = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(v2);
                        v4 = MediaSessionImplBase.this.mAudioManager.getStreamVolume(v2);
                    }
                }
                return new ParcelableVolumeInfo(v1, v2, v3, v5, v4);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.mFlags & 2) != 0;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                this.postToHandler(14);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                this.postToHandler(12);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                this.postToHandler(7);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String s, Bundle bundle0) throws RemoteException {
                this.postToHandler(8, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String s, Bundle bundle0) throws RemoteException {
                this.postToHandler(9, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri0, Bundle bundle0) throws RemoteException {
                this.postToHandler(10, uri0, bundle0);
            }

            void postToHandler(int v) {
                MediaSessionImplBase.this.postToHandler(v, 0, 0, null, null);
            }

            void postToHandler(int v, int v1) {
                MediaSessionImplBase.this.postToHandler(v, v1, 0, null, null);
            }

            void postToHandler(int v, Object object0) {
                MediaSessionImplBase.this.postToHandler(v, 0, 0, object0, null);
            }

            void postToHandler(int v, Object object0, int v1) {
                MediaSessionImplBase.this.postToHandler(v, v1, 0, object0, null);
            }

            void postToHandler(int v, Object object0, Bundle bundle0) {
                MediaSessionImplBase.this.postToHandler(v, 0, 0, object0, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                this.postToHandler(3);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String s, Bundle bundle0) throws RemoteException {
                this.postToHandler(4, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String s, Bundle bundle0) throws RemoteException {
                this.postToHandler(5, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri0, Bundle bundle0) throws RemoteException {
                this.postToHandler(6, uri0, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                this.postToHandler(15);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat0) throws RemoteException {
                this.postToHandler(19, ratingCompat0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) throws RemoteException {
                this.postToHandler(0x1F, ratingCompat0, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                if(MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback0.onSessionDestroyed();
                    }
                    catch(Exception unused_ex) {
                    }
                    return;
                }
                RemoteUserInfo mediaSessionManager$RemoteUserInfo0 = new RemoteUserInfo("android.media.session.MediaController", MediaSessionStub.getCallingPid(), MediaSessionStub.getCallingUid());
                MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback0, mediaSessionManager$RemoteUserInfo0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) {
                this.postToHandler(27, mediaDescriptionCompat0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int v) {
                this.postToHandler(28, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                this.postToHandler(17);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void seekTo(long v) throws RemoteException {
                this.postToHandler(18, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) {
                this.postToHandler(1, new Command(s, bundle0, mediaSessionCompat$ResultReceiverWrapper0.mResultReceiver));
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String s, Bundle bundle0) throws RemoteException {
                this.postToHandler(20, s, bundle0);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent0) {
                if((MediaSessionImplBase.this.mFlags & 1) != 0) {
                    this.postToHandler(21, keyEvent0);
                }
                return true;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                this.postToHandler(29, Boolean.valueOf(z));
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int v) throws RemoteException {
                this.postToHandler(23, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int v) throws RemoteException {
                this.postToHandler(30, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int v, int v1, String s) {
                MediaSessionImplBase.this.setVolumeTo(v, v1);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long v) {
                this.postToHandler(11, v);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                this.postToHandler(13);
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback0);
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 0x7F;
            private static final int KEYCODE_MEDIA_PLAY = 0x7E;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 0x1F;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper0) {
                super(looper0);
            }

            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                Callback mediaSessionCompat$Callback0 = MediaSessionImplBase.this.mCallback;
                if(mediaSessionCompat$Callback0 == null) {
                    return;
                }
                Bundle bundle0 = message0.getData();
                MediaSessionCompat.ensureClassLoader(bundle0);
                RemoteUserInfo mediaSessionManager$RemoteUserInfo0 = new RemoteUserInfo(bundle0.getString("data_calling_pkg"), bundle0.getInt("data_calling_pid"), bundle0.getInt("data_calling_uid"));
                MediaSessionImplBase.this.setCurrentControllerInfo(mediaSessionManager$RemoteUserInfo0);
                MediaSessionCompat.ensureClassLoader(bundle0.getBundle("data_extras"));
                try {
                    switch(message0.what) {
                        case 2: {
                            MediaSessionImplBase.this.adjustVolume(message0.arg1, 0);
                            break;
                        }
                        case 21: {
                            KeyEvent keyEvent0 = (KeyEvent)message0.obj;
                            Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent0.putExtra("android.intent.extra.KEY_EVENT", keyEvent0);
                            if(!mediaSessionCompat$Callback0.onMediaButtonEvent(intent0)) {
                                this.onMediaButtonEvent(keyEvent0, mediaSessionCompat$Callback0);
                            }
                            break;
                        }
                        case 22: {
                            MediaSessionImplBase.this.setVolumeTo(message0.arg1, 0);
                            break;
                        }
                        case 27: {
                            mediaSessionCompat$Callback0.onRemoveQueueItem(((MediaDescriptionCompat)message0.obj));
                            break;
                        }
                        case 28: {
                            if(MediaSessionImplBase.this.mQueue != null) {
                                QueueItem mediaSessionCompat$QueueItem0 = message0.arg1 < 0 || message0.arg1 >= MediaSessionImplBase.this.mQueue.size() ? null : ((QueueItem)MediaSessionImplBase.this.mQueue.get(message0.arg1));
                                if(mediaSessionCompat$QueueItem0 != null) {
                                    mediaSessionCompat$Callback0.onRemoveQueueItem(mediaSessionCompat$QueueItem0.getDescription());
                                }
                            }
                        }
                    }
                }
                finally {
                    MediaSessionImplBase.this.setCurrentControllerInfo(null);
                }
            }

            private void onMediaButtonEvent(KeyEvent keyEvent0, Callback mediaSessionCompat$Callback0) {
                if(keyEvent0 != null && keyEvent0.getAction() == 0) {
                    long v = MediaSessionImplBase.this.mState == null ? 0L : MediaSessionImplBase.this.mState.getActions();
                    switch(keyEvent0.getKeyCode()) {
                        case 0x4F: 
                        case 85: {
                            Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                            return;
                        }
                        case 86: {
                            if((v & 1L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 87: {
                            if((v & 0x20L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 88: {
                            if((v & 16L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 89: {
                            if((v & 8L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 90: {
                            if((v & 0x40L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 0x7E: {
                            if((v & 4L) != 0L) {
                                return;
                            }
                            break;
                        }
                        case 0x7F: {
                            if((v & 2L) != 0L) {
                                return;
                            }
                            break;
                        }
                    }
                }
            }
        }

        static final int RCC_PLAYSTATE_NONE;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList mControllerCallbacks;
        boolean mDestroyed;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive;
        private boolean mIsMbrRegistered;
        private boolean mIsRccRegistered;
        int mLocalStream;
        final Object mLock;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        private RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private androidx.media.VolumeProviderCompat.Callback mVolumeCallback;
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        public MediaSessionImplBase(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0) {
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
            this.mVolumeCallback = new androidx.media.VolumeProviderCompat.Callback() {
                @Override  // androidx.media.VolumeProviderCompat$Callback
                public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat0) {
                    if(MediaSessionImplBase.this.mVolumeProvider != volumeProviderCompat0) {
                        return;
                    }
                    ParcelableVolumeInfo parcelableVolumeInfo0 = new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, volumeProviderCompat0.getVolumeControl(), volumeProviderCompat0.getMaxVolume(), volumeProviderCompat0.getCurrentVolume());
                    MediaSessionImplBase.this.sendVolumeInfoChanged(parcelableVolumeInfo0);
                }
            };
            if(componentName0 == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.mContext = context0;
            this.mPackageName = "com.MonsterCouch.Wingspan";
            this.mAudioManager = (AudioManager)context0.getSystemService("audio");
            this.mTag = s;
            this.mMediaButtonReceiverComponentName = componentName0;
            this.mMediaButtonReceiverIntent = pendingIntent0;
            MediaSessionStub mediaSessionCompat$MediaSessionImplBase$MediaSessionStub0 = new MediaSessionStub(this);
            this.mStub = mediaSessionCompat$MediaSessionImplBase$MediaSessionStub0;
            this.mToken = new Token(mediaSessionCompat$MediaSessionImplBase$MediaSessionStub0);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(pendingIntent0);
        }

        void adjustVolume(int v, int v1) {
            if(this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, v, v1);
            }
            else if(this.mVolumeProvider != null) {
            }
        }

        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle0) {
            RemoteControlClient.MetadataEditor remoteControlClient$MetadataEditor0 = this.mRcc.editMetadata(true);
            if(bundle0 == null) {
                return remoteControlClient$MetadataEditor0;
            }
            if(bundle0.containsKey("android.media.metadata.ART")) {
                Bitmap bitmap0 = (Bitmap)bundle0.getParcelable("android.media.metadata.ART");
                if(bitmap0 != null) {
                    bitmap0 = bitmap0.copy(bitmap0.getConfig(), false);
                }
                remoteControlClient$MetadataEditor0.putBitmap(100, bitmap0);
            }
            else if(bundle0.containsKey("android.media.metadata.ALBUM_ART")) {
                Bitmap bitmap1 = (Bitmap)bundle0.getParcelable("android.media.metadata.ALBUM_ART");
                if(bitmap1 != null) {
                    bitmap1 = bitmap1.copy(bitmap1.getConfig(), false);
                }
                remoteControlClient$MetadataEditor0.putBitmap(100, bitmap1);
            }
            if(bundle0.containsKey("android.media.metadata.ALBUM")) {
                remoteControlClient$MetadataEditor0.putString(1, bundle0.getString("android.media.metadata.ALBUM"));
            }
            if(bundle0.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                remoteControlClient$MetadataEditor0.putString(13, bundle0.getString("android.media.metadata.ALBUM_ARTIST"));
            }
            if(bundle0.containsKey("android.media.metadata.ARTIST")) {
                remoteControlClient$MetadataEditor0.putString(2, bundle0.getString("android.media.metadata.ARTIST"));
            }
            if(bundle0.containsKey("android.media.metadata.AUTHOR")) {
                remoteControlClient$MetadataEditor0.putString(3, bundle0.getString("android.media.metadata.AUTHOR"));
            }
            if(bundle0.containsKey("android.media.metadata.COMPILATION")) {
                remoteControlClient$MetadataEditor0.putString(15, bundle0.getString("android.media.metadata.COMPILATION"));
            }
            if(bundle0.containsKey("android.media.metadata.COMPOSER")) {
                remoteControlClient$MetadataEditor0.putString(4, bundle0.getString("android.media.metadata.COMPOSER"));
            }
            if(bundle0.containsKey("android.media.metadata.DATE")) {
                remoteControlClient$MetadataEditor0.putString(5, bundle0.getString("android.media.metadata.DATE"));
            }
            if(bundle0.containsKey("android.media.metadata.DISC_NUMBER")) {
                remoteControlClient$MetadataEditor0.putLong(14, bundle0.getLong("android.media.metadata.DISC_NUMBER"));
            }
            if(bundle0.containsKey("android.media.metadata.DURATION")) {
                remoteControlClient$MetadataEditor0.putLong(9, bundle0.getLong("android.media.metadata.DURATION"));
            }
            if(bundle0.containsKey("android.media.metadata.GENRE")) {
                remoteControlClient$MetadataEditor0.putString(6, bundle0.getString("android.media.metadata.GENRE"));
            }
            if(bundle0.containsKey("android.media.metadata.TITLE")) {
                remoteControlClient$MetadataEditor0.putString(7, bundle0.getString("android.media.metadata.TITLE"));
            }
            if(bundle0.containsKey("android.media.metadata.TRACK_NUMBER")) {
                remoteControlClient$MetadataEditor0.putLong(0, bundle0.getLong("android.media.metadata.TRACK_NUMBER"));
            }
            if(bundle0.containsKey("android.media.metadata.WRITER")) {
                remoteControlClient$MetadataEditor0.putString(11, bundle0.getString("android.media.metadata.WRITER"));
            }
            return remoteControlClient$MetadataEditor0;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public RemoteUserInfo getCurrentControllerInfo() {
            synchronized(this.mLock) {
            }
            return this.mRemoteUserInfo;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            synchronized(this.mLock) {
            }
            return this.mState;
        }

        int getRccStateFromState(int v) {
            switch(v) {
                case 0: {
                    return 0;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 2;
                }
                case 3: {
                    return 3;
                }
                case 4: {
                    return 4;
                }
                case 5: {
                    return 5;
                }
                case 7: {
                    return 9;
                }
                case 6: 
                case 8: {
                    return 8;
                }
                case 9: {
                    return 7;
                }
                case 10: 
                case 11: {
                    return 6;
                }
                default: {
                    return -1;
                }
            }
        }

        int getRccTransportControlFlagsFromActions(long v) {
            int v1 = (1L & v) == 0L ? 0 : 0x20;
            if((2L & v) != 0L) {
                v1 |= 16;
            }
            if((4L & v) != 0L) {
                v1 |= 4;
            }
            if((8L & v) != 0L) {
                v1 |= 2;
            }
            if((16L & v) != 0L) {
                v1 |= 1;
            }
            if((0x20L & v) != 0L) {
                v1 |= 0x80;
            }
            if((0x40L & v) != 0L) {
                v1 |= 0x40;
            }
            return (v & 0x200L) == 0L ? v1 : v1 | 8;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        void postToHandler(int v, int v1, int v2, Object object0, Bundle bundle0) {
            synchronized(this.mLock) {
                MessageHandler mediaSessionCompat$MediaSessionImplBase$MessageHandler0 = this.mHandler;
                if(mediaSessionCompat$MediaSessionImplBase$MessageHandler0 != null) {
                    Message message0 = mediaSessionCompat$MediaSessionImplBase$MessageHandler0.obtainMessage(v, v1, v2, object0);
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("data_calling_pkg", "android.media.session.MediaController");
                    bundle1.putInt("data_calling_pid", Binder.getCallingPid());
                    bundle1.putInt("data_calling_uid", Binder.getCallingUid());
                    if(bundle0 != null) {
                        bundle1.putBundle("data_extras", bundle0);
                    }
                    message0.setData(bundle1);
                    message0.sendToTarget();
                }
            }
        }

        void registerMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            this.update();
            this.sendSessionDestroyed();
        }

        private void sendCaptioningEnabled(boolean z) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onCaptioningEnabledChanged(z);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendEvent(String s, Bundle bundle0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onEvent(s, bundle0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle bundle0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onExtrasChanged(bundle0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onMetadataChanged(mediaMetadataCompat0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List list0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onQueueChanged(list0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence charSequence0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onQueueTitleChanged(charSequence0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int v) {
            for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    iMediaControllerCallback0.onRepeatModeChanged(v);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onSessionDestroyed();
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void sendSessionEvent(String s, Bundle bundle0) {
            this.sendEvent(s, bundle0);
        }

        private void sendShuffleMode(int v) {
            for(int v1 = this.mControllerCallbacks.beginBroadcast() - 1; v1 >= 0; --v1) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v1);
                try {
                    iMediaControllerCallback0.onShuffleModeChanged(v);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat playbackStateCompat0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onPlaybackStateChanged(playbackStateCompat0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) {
            for(int v = this.mControllerCallbacks.beginBroadcast() - 1; v >= 0; --v) {
                IMediaControllerCallback iMediaControllerCallback0 = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(v);
                try {
                    iMediaControllerCallback0.onVolumeInfoChanged(parcelableVolumeInfo0);
                }
                catch(RemoteException unused_ex) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setActive(boolean z) {
            if(z == this.mIsActive) {
                return;
            }
            this.mIsActive = z;
            if(this.update()) {
                this.setMetadata(this.mMetadata);
                this.setPlaybackState(this.mState);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
            this.mCallback = mediaSessionCompat$Callback0;
            if(mediaSessionCompat$Callback0 != null) {
                if(handler0 == null) {
                    handler0 = new Handler();
                }
                synchronized(this.mLock) {
                    MessageHandler mediaSessionCompat$MediaSessionImplBase$MessageHandler0 = this.mHandler;
                    if(mediaSessionCompat$MediaSessionImplBase$MessageHandler0 != null) {
                        mediaSessionCompat$MediaSessionImplBase$MessageHandler0.removeCallbacksAndMessages(null);
                    }
                    this.mHandler = new MessageHandler(this, handler0.getLooper());
                    this.mCallback.setSessionImpl(this, handler0);
                }
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            if(this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                this.sendCaptioningEnabled(z);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setCurrentControllerInfo(RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
            synchronized(this.mLock) {
                this.mRemoteUserInfo = mediaSessionManager$RemoteUserInfo0;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setExtras(Bundle bundle0) {
            this.mExtras = bundle0;
            this.sendExtras(bundle0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setFlags(int v) {
            synchronized(this.mLock) {
                this.mFlags = v;
            }
            this.update();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent pendingIntent0) {
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat0) {
            if(mediaMetadataCompat0 != null) {
                mediaMetadataCompat0 = new Builder(mediaMetadataCompat0, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized(this.mLock) {
                this.mMetadata = mediaMetadataCompat0;
            }
            this.sendMetadata(mediaMetadataCompat0);
            if(!this.mIsActive) {
                return;
            }
            this.buildRccMetadata((mediaMetadataCompat0 == null ? null : mediaMetadataCompat0.getBundle())).apply();
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat0) {
            synchronized(this.mLock) {
                this.mState = playbackStateCompat0;
            }
            this.sendState(playbackStateCompat0);
            if(!this.mIsActive) {
                return;
            }
            if(playbackStateCompat0 == null) {
                this.mRcc.setPlaybackState(0);
                this.mRcc.setTransportControlFlags(0);
                return;
            }
            this.setRccState(playbackStateCompat0);
            this.mRcc.setTransportControlFlags(this.getRccTransportControlFlagsFromActions(playbackStateCompat0.getActions()));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToLocal(int v) {
            VolumeProviderCompat volumeProviderCompat0 = this.mVolumeProvider;
            if(volumeProviderCompat0 != null) {
                volumeProviderCompat0.setCallback(null);
            }
            this.mLocalStream = v;
            this.mVolumeType = 1;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(1, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat0) {
            if(volumeProviderCompat0 == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            VolumeProviderCompat volumeProviderCompat1 = this.mVolumeProvider;
            if(volumeProviderCompat1 != null) {
                volumeProviderCompat1.setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProviderCompat0;
            this.sendVolumeInfoChanged(new ParcelableVolumeInfo(2, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            volumeProviderCompat0.setCallback(this.mVolumeCallback);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueue(List list0) {
            this.mQueue = list0;
            this.sendQueue(list0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setQueueTitle(CharSequence charSequence0) {
            this.mQueueTitle = charSequence0;
            this.sendQueueTitle(charSequence0);
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRatingType(int v) {
            this.mRatingType = v;
        }

        void setRccState(PlaybackStateCompat playbackStateCompat0) {
            this.mRcc.setPlaybackState(this.getRccStateFromState(playbackStateCompat0.getState()));
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setRepeatMode(int v) {
            if(this.mRepeatMode != v) {
                this.mRepeatMode = v;
                this.sendRepeatMode(v);
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setSessionActivity(PendingIntent pendingIntent0) {
            synchronized(this.mLock) {
                this.mSessionActivity = pendingIntent0;
            }
        }

        @Override  // android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl
        public void setShuffleMode(int v) {
            if(this.mShuffleMode != v) {
                this.mShuffleMode = v;
                this.sendShuffleMode(v);
            }
        }

        void setVolumeTo(int v, int v1) {
            if(this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, v, v1);
            }
            else if(this.mVolumeProvider != null) {
            }
        }

        void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent0, ComponentName componentName0) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName0);
        }

        boolean update() {
            if(this.mIsActive) {
                boolean z = this.mIsMbrRegistered;
                if(!z && (this.mFlags & 1) != 0) {
                    this.registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = true;
                }
                else if(z && (this.mFlags & 1) == 0) {
                    this.unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                boolean z1 = this.mIsRccRegistered;
                if(!z1 && (this.mFlags & 2) != 0) {
                    this.mAudioManager.registerRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = true;
                    return true;
                }
                if(z1 && (this.mFlags & 2) == 0) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                    return false;
                }
            }
            else {
                if(this.mIsMbrRegistered) {
                    this.unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if(this.mIsRccRegistered) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                }
            }
            return false;
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        static {
            QueueItem.CREATOR = new Parcelable.Creator() {
                public QueueItem createFromParcel(Parcel parcel0) {
                    return new QueueItem(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public QueueItem[] newArray(int v) {
                    return new QueueItem[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        QueueItem(Parcel parcel0) {
            this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
            this.mId = parcel0.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat0, long v) {
            this(null, mediaDescriptionCompat0, v);
        }

        private QueueItem(Object object0, MediaDescriptionCompat mediaDescriptionCompat0, long v) {
            if(mediaDescriptionCompat0 == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if(v == -1L) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescriptionCompat0;
            this.mId = v;
            this.mItem = object0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static QueueItem fromQueueItem(Object object0) {
            return object0 == null ? null : new QueueItem(object0, MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.getDescription(object0)), android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.getQueueId(object0));
        }

        public static List fromQueueItemList(List list0) {
            if(list0 != null) {
                List list1 = new ArrayList();
                for(Object object0: list0) {
                    list1.add(QueueItem.fromQueueItem(object0));
                }
                return list1;
            }
            return null;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            Object object0 = this.mItem;
            if(object0 == null) {
                object0 = android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
                this.mItem = object0;
            }
            return object0;
        }

        @Override
        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            this.mDescription.writeToParcel(parcel0, v);
            parcel0.writeLong(this.mId);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        ResultReceiver mResultReceiver;

        static {
            ResultReceiverWrapper.CREATOR = new Parcelable.Creator() {
                public ResultReceiverWrapper createFromParcel(Parcel parcel0) {
                    return new ResultReceiverWrapper(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public ResultReceiverWrapper[] newArray(int v) {
                    return new ResultReceiverWrapper[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        ResultReceiverWrapper(Parcel parcel0) {
            this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel0);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver0) {
            this.mResultReceiver = resultReceiver0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            this.mResultReceiver.writeToParcel(parcel0, v);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        static {
            Token.CREATOR = new Parcelable.Creator() {
                public Token createFromParcel(Parcel parcel0) {
                    return new Token(parcel0.readParcelable(null));
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public Token[] newArray(int v) {
                    return new Token[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        Token(Object object0) {
            this(object0, null, null);
        }

        Token(Object object0, IMediaSession iMediaSession0) {
            this(object0, iMediaSession0, null);
        }

        Token(Object object0, IMediaSession iMediaSession0, Bundle bundle0) {
            this.mInner = object0;
            this.mExtraBinder = iMediaSession0;
            this.mSessionToken2Bundle = bundle0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Token)) {
                return false;
            }
            Object object1 = this.mInner;
            if(object1 == null) {
                return ((Token)object0).mInner == null;
            }
            Object object2 = ((Token)object0).mInner;
            return object2 == null ? false : object1.equals(object2);
        }

        public static Token fromBundle(Bundle bundle0) {
            if(bundle0 == null) {
                return null;
            }
            IMediaSession iMediaSession0 = Stub.asInterface(BundleCompat.getBinder(bundle0, "android.support.v4.media.session.EXTRA_BINDER"));
            Bundle bundle1 = bundle0.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            Token mediaSessionCompat$Token0 = (Token)bundle0.getParcelable("android.support.v4.media.session.TOKEN");
            return mediaSessionCompat$Token0 == null ? null : new Token(mediaSessionCompat$Token0.mInner, iMediaSession0, bundle1);
        }

        public static Token fromToken(Object object0) {
            return Token.fromToken(object0, null);
        }

        public static Token fromToken(Object object0, IMediaSession iMediaSession0) {
            return object0 == null ? null : new Token(MediaSessionCompatApi21.verifyToken(object0), iMediaSession0);
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        @Override
        public int hashCode() {
            return this.mInner == null ? 0 : this.mInner.hashCode();
        }

        public void setExtraBinder(IMediaSession iMediaSession0) {
            this.mExtraBinder = iMediaSession0;
        }

        public void setSessionToken2Bundle(Bundle bundle0) {
            this.mSessionToken2Bundle = bundle0;
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("android.support.v4.media.session.TOKEN", this);
            IMediaSession iMediaSession0 = this.mExtraBinder;
            if(iMediaSession0 != null) {
                BundleCompat.putBinder(bundle0, "android.support.v4.media.session.EXTRA_BINDER", iMediaSession0.asBinder());
            }
            Bundle bundle1 = this.mSessionToken2Bundle;
            if(bundle1 != null) {
                bundle0.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", bundle1);
            }
            return bundle0;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeParcelable(((Parcelable)this.mInner), v);
        }
    }

    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;
    static int sMaxBitmapSize;

    private MediaSessionCompat(Context context0, MediaSessionImpl mediaSessionCompat$MediaSessionImpl0) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = mediaSessionCompat$MediaSessionImpl0;
        if(!MediaSessionCompatApi21.hasCallback(mediaSessionCompat$MediaSessionImpl0.getMediaSession())) {
            this.setCallback(new Callback() {
            });
        }
        this.mController = new MediaControllerCompat(context0, this);
    }

    public MediaSessionCompat(Context context0, String s) {
        this(context0, s, null, null);
    }

    public MediaSessionCompat(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0) {
        this(context0, s, componentName0, pendingIntent0, null);
    }

    private MediaSessionCompat(Context context0, String s, ComponentName componentName0, PendingIntent pendingIntent0, Bundle bundle0) {
        this.mActiveListeners = new ArrayList();
        if(context0 == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        if(componentName0 == null) {
            componentName0 = MediaButtonReceiver.getMediaButtonReceiverComponent(context0);
            if(componentName0 == null) {
                Log.w("MediaSessionCompat", "Couldn\'t find a unique registered media button receiver in the given context.");
            }
        }
        if(componentName0 != null && pendingIntent0 == null) {
            Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
            intent0.setComponent(componentName0);
            pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent0, 0);
        }
        if(Build.VERSION.SDK_INT >= 28) {
            MediaSessionImplApi28 mediaSessionCompat$MediaSessionImplApi280 = new MediaSessionImplApi28(context0, s, bundle0);
            this.mImpl = mediaSessionCompat$MediaSessionImplApi280;
            this.setCallback(new Callback() {
            });
            mediaSessionCompat$MediaSessionImplApi280.setMediaButtonReceiver(pendingIntent0);
        }
        else {
            MediaSessionImplApi21 mediaSessionCompat$MediaSessionImplApi210 = new MediaSessionImplApi21(context0, s, bundle0);
            this.mImpl = mediaSessionCompat$MediaSessionImplApi210;
            this.setCallback(new Callback() {
            });
            mediaSessionCompat$MediaSessionImplApi210.setMediaButtonReceiver(pendingIntent0);
        }
        this.mController = new MediaControllerCompat(context0, this);
        if(MediaSessionCompat.sMaxBitmapSize == 0) {
            MediaSessionCompat.sMaxBitmapSize = (int)(TypedValue.applyDimension(1, 320.0f, context0.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    public MediaSessionCompat(Context context0, String s, Bundle bundle0) {
        this(context0, s, null, null, bundle0);
    }

    public void addOnActiveChangeListener(OnActiveChangeListener mediaSessionCompat$OnActiveChangeListener0) {
        if(mediaSessionCompat$OnActiveChangeListener0 == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(mediaSessionCompat$OnActiveChangeListener0);
    }

    public static void ensureClassLoader(Bundle bundle0) {
        if(bundle0 != null) {
            bundle0.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context0, Object object0) {
        return context0 == null || object0 == null ? null : new MediaSessionCompat(context0, new MediaSessionImplApi21(object0));
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat0, MediaMetadataCompat mediaMetadataCompat0) {
        long v = -1L;
        if(playbackStateCompat0 != null && playbackStateCompat0.getPosition() != -1L && (playbackStateCompat0.getState() == 3 || playbackStateCompat0.getState() == 4 || playbackStateCompat0.getState() == 5)) {
            long v1 = playbackStateCompat0.getLastPositionUpdateTime();
            if(v1 > 0L) {
                long v2 = SystemClock.elapsedRealtime();
                long v3 = ((long)(playbackStateCompat0.getPlaybackSpeed() * ((float)(v2 - v1)))) + playbackStateCompat0.getPosition();
                if(mediaMetadataCompat0 != null && mediaMetadataCompat0.containsKey("android.media.metadata.DURATION")) {
                    v = mediaMetadataCompat0.getLong("android.media.metadata.DURATION");
                }
                if(v >= 0L && v3 > v) {
                    return new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat0).setState(playbackStateCompat0.getState(), v, playbackStateCompat0.getPlaybackSpeed(), v2).build();
                }
                return v3 >= 0L ? new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat0).setState(playbackStateCompat0.getState(), v3, playbackStateCompat0.getPlaybackSpeed(), v2).build() : new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat0).setState(playbackStateCompat0.getState(), 0L, playbackStateCompat0.getPlaybackSpeed(), v2).build();
            }
        }
        return playbackStateCompat0;
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener mediaSessionCompat$OnActiveChangeListener0) {
        if(mediaSessionCompat$OnActiveChangeListener0 == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(mediaSessionCompat$OnActiveChangeListener0);
    }

    public void sendSessionEvent(String s, Bundle bundle0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(s, bundle0);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        for(Object object0: this.mActiveListeners) {
            ((OnActiveChangeListener)object0).onActiveChanged();
        }
    }

    public void setCallback(Callback mediaSessionCompat$Callback0) {
        this.setCallback(mediaSessionCompat$Callback0, null);
    }

    public void setCallback(Callback mediaSessionCompat$Callback0, Handler handler0) {
        if(mediaSessionCompat$Callback0 == null) {
            this.mImpl.setCallback(null, null);
            return;
        }
        MediaSessionImpl mediaSessionCompat$MediaSessionImpl0 = this.mImpl;
        if(handler0 == null) {
            handler0 = new Handler();
        }
        mediaSessionCompat$MediaSessionImpl0.setCallback(mediaSessionCompat$Callback0, handler0);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setExtras(Bundle bundle0) {
        this.mImpl.setExtras(bundle0);
    }

    public void setFlags(int v) {
        this.mImpl.setFlags(v);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent0) {
        this.mImpl.setMediaButtonReceiver(pendingIntent0);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat0) {
        this.mImpl.setMetadata(mediaMetadataCompat0);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat0) {
        this.mImpl.setPlaybackState(playbackStateCompat0);
    }

    public void setPlaybackToLocal(int v) {
        this.mImpl.setPlaybackToLocal(v);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat0) {
        if(volumeProviderCompat0 == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(volumeProviderCompat0);
    }

    public void setQueue(List list0) {
        this.mImpl.setQueue(list0);
    }

    public void setQueueTitle(CharSequence charSequence0) {
        this.mImpl.setQueueTitle(charSequence0);
    }

    public void setRatingType(int v) {
        this.mImpl.setRatingType(v);
    }

    public void setRepeatMode(int v) {
        this.mImpl.setRepeatMode(v);
    }

    public void setSessionActivity(PendingIntent pendingIntent0) {
        this.mImpl.setSessionActivity(pendingIntent0);
    }

    public void setShuffleMode(int v) {
        this.mImpl.setShuffleMode(v);
    }
}

