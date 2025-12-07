package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaController.TransportControls;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class MediaControllerCompatApi21 {
    public interface Callback {
        void onAudioInfoChanged(int arg1, int arg2, int arg3, int arg4, int arg5);

        void onExtrasChanged(Bundle arg1);

        void onMetadataChanged(Object arg1);

        void onPlaybackStateChanged(Object arg1);

        void onQueueChanged(List arg1);

        void onQueueTitleChanged(CharSequence arg1);

        void onSessionDestroyed();

        void onSessionEvent(String arg1, Bundle arg2);
    }

    static class CallbackProxy extends MediaController.Callback {
        protected final Callback mCallback;

        public CallbackProxy(Callback mediaControllerCompatApi21$Callback0) {
            this.mCallback = mediaControllerCompatApi21$Callback0;
        }

        @Override  // android.media.session.MediaController$Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo mediaController$PlaybackInfo0) {
            int v = mediaController$PlaybackInfo0.getPlaybackType();
            int v1 = PlaybackInfo.getLegacyAudioStream(mediaController$PlaybackInfo0);
            int v2 = mediaController$PlaybackInfo0.getVolumeControl();
            int v3 = mediaController$PlaybackInfo0.getMaxVolume();
            int v4 = mediaController$PlaybackInfo0.getCurrentVolume();
            this.mCallback.onAudioInfoChanged(v, v1, v2, v3, v4);
        }

        @Override  // android.media.session.MediaController$Callback
        public void onExtrasChanged(Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            this.mCallback.onExtrasChanged(bundle0);
        }

        @Override  // android.media.session.MediaController$Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata0) {
            this.mCallback.onMetadataChanged(mediaMetadata0);
        }

        @Override  // android.media.session.MediaController$Callback
        public void onPlaybackStateChanged(PlaybackState playbackState0) {
            this.mCallback.onPlaybackStateChanged(playbackState0);
        }

        @Override  // android.media.session.MediaController$Callback
        public void onQueueChanged(List list0) {
            this.mCallback.onQueueChanged(list0);
        }

        @Override  // android.media.session.MediaController$Callback
        public void onQueueTitleChanged(CharSequence charSequence0) {
            this.mCallback.onQueueTitleChanged(charSequence0);
        }

        @Override  // android.media.session.MediaController$Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        @Override  // android.media.session.MediaController$Callback
        public void onSessionEvent(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            this.mCallback.onSessionEvent(s, bundle0);
        }
    }

    public static class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        public static AudioAttributes getAudioAttributes(Object object0) {
            return ((MediaController.PlaybackInfo)object0).getAudioAttributes();
        }

        public static int getCurrentVolume(Object object0) {
            return ((MediaController.PlaybackInfo)object0).getCurrentVolume();
        }

        public static int getLegacyAudioStream(Object object0) {
            return PlaybackInfo.toLegacyStreamType(PlaybackInfo.getAudioAttributes(object0));
        }

        public static int getMaxVolume(Object object0) {
            return ((MediaController.PlaybackInfo)object0).getMaxVolume();
        }

        public static int getPlaybackType(Object object0) {
            return ((MediaController.PlaybackInfo)object0).getPlaybackType();
        }

        public static int getVolumeControl(Object object0) {
            return ((MediaController.PlaybackInfo)object0).getVolumeControl();
        }

        private static int toLegacyStreamType(AudioAttributes audioAttributes0) {
            if((audioAttributes0.getFlags() & 1) == 1) {
                return 7;
            }
            if((audioAttributes0.getFlags() & 4) == 4) {
                return 6;
            }
            int v = audioAttributes0.getUsage();
            if(v != 13) {
                switch(v) {
                    case 2: {
                        return 0;
                    }
                    case 3: {
                        return 8;
                    }
                    case 4: {
                        return 4;
                    }
                    case 6: {
                        return 2;
                    }
                    case 5: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: {
                        return 5;
                    }
                    default: {
                        return 3;
                    }
                }
            }
            return 1;
        }
    }

    public static class TransportControls {
        public static void fastForward(Object object0) {
            ((MediaController.TransportControls)object0).fastForward();
        }

        public static void pause(Object object0) {
            ((MediaController.TransportControls)object0).pause();
        }

        public static void play(Object object0) {
            ((MediaController.TransportControls)object0).play();
        }

        public static void playFromMediaId(Object object0, String s, Bundle bundle0) {
            ((MediaController.TransportControls)object0).playFromMediaId(s, bundle0);
        }

        public static void playFromSearch(Object object0, String s, Bundle bundle0) {
            ((MediaController.TransportControls)object0).playFromSearch(s, bundle0);
        }

        public static void rewind(Object object0) {
            ((MediaController.TransportControls)object0).rewind();
        }

        public static void seekTo(Object object0, long v) {
            ((MediaController.TransportControls)object0).seekTo(v);
        }

        public static void sendCustomAction(Object object0, String s, Bundle bundle0) {
            ((MediaController.TransportControls)object0).sendCustomAction(s, bundle0);
        }

        public static void setRating(Object object0, Object object1) {
            ((MediaController.TransportControls)object0).setRating(((Rating)object1));
        }

        public static void skipToNext(Object object0) {
            ((MediaController.TransportControls)object0).skipToNext();
        }

        public static void skipToPrevious(Object object0) {
            ((MediaController.TransportControls)object0).skipToPrevious();
        }

        public static void skipToQueueItem(Object object0, long v) {
            ((MediaController.TransportControls)object0).skipToQueueItem(v);
        }

        public static void stop(Object object0) {
            ((MediaController.TransportControls)object0).stop();
        }
    }

    public static void adjustVolume(Object object0, int v, int v1) {
        ((MediaController)object0).adjustVolume(v, v1);
    }

    public static Object createCallback(Callback mediaControllerCompatApi21$Callback0) {
        return new CallbackProxy(mediaControllerCompatApi21$Callback0);
    }

    public static boolean dispatchMediaButtonEvent(Object object0, KeyEvent keyEvent0) {
        return ((MediaController)object0).dispatchMediaButtonEvent(keyEvent0);
    }

    public static Object fromToken(Context context0, Object object0) {
        return new MediaController(context0, ((MediaSession.Token)object0));
    }

    public static Bundle getExtras(Object object0) {
        return ((MediaController)object0).getExtras();
    }

    public static long getFlags(Object object0) {
        return ((MediaController)object0).getFlags();
    }

    public static Object getMediaController(Activity activity0) {
        return activity0.getMediaController();
    }

    public static Object getMetadata(Object object0) {
        return ((MediaController)object0).getMetadata();
    }

    public static String getPackageName(Object object0) {
        return ((MediaController)object0).getPackageName();
    }

    public static Object getPlaybackInfo(Object object0) {
        return ((MediaController)object0).getPlaybackInfo();
    }

    public static Object getPlaybackState(Object object0) {
        return ((MediaController)object0).getPlaybackState();
    }

    public static List getQueue(Object object0) {
        List list0 = ((MediaController)object0).getQueue();
        return list0 == null ? null : new ArrayList(list0);
    }

    public static CharSequence getQueueTitle(Object object0) {
        return ((MediaController)object0).getQueueTitle();
    }

    public static int getRatingType(Object object0) {
        return ((MediaController)object0).getRatingType();
    }

    public static PendingIntent getSessionActivity(Object object0) {
        return ((MediaController)object0).getSessionActivity();
    }

    public static Object getSessionToken(Object object0) {
        return ((MediaController)object0).getSessionToken();
    }

    public static Object getTransportControls(Object object0) {
        return ((MediaController)object0).getTransportControls();
    }

    public static void registerCallback(Object object0, Object object1, Handler handler0) {
        ((MediaController)object0).registerCallback(((MediaController.Callback)object1), handler0);
    }

    public static void sendCommand(Object object0, String s, Bundle bundle0, ResultReceiver resultReceiver0) {
        ((MediaController)object0).sendCommand(s, bundle0, resultReceiver0);
    }

    public static void setMediaController(Activity activity0, Object object0) {
        activity0.setMediaController(((MediaController)object0));
    }

    public static void setVolumeTo(Object object0, int v, int v1) {
        ((MediaController)object0).setVolumeTo(v, v1);
    }

    public static void unregisterCallback(Object object0, Object object1) {
        ((MediaController)object0).unregisterCallback(((MediaController.Callback)object1));
    }
}

