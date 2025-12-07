package android.support.v4.media.session;

import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class PlaybackStateCompatApi21 {
    static final class CustomAction {
        public static String getAction(Object object0) {
            return ((PlaybackState.CustomAction)object0).getAction();
        }

        public static Bundle getExtras(Object object0) {
            return ((PlaybackState.CustomAction)object0).getExtras();
        }

        public static int getIcon(Object object0) {
            return ((PlaybackState.CustomAction)object0).getIcon();
        }

        public static CharSequence getName(Object object0) {
            return ((PlaybackState.CustomAction)object0).getName();
        }

        public static Object newInstance(String s, CharSequence charSequence0, int v, Bundle bundle0) {
            PlaybackState.CustomAction.Builder playbackState$CustomAction$Builder0 = new PlaybackState.CustomAction.Builder(s, charSequence0, v);
            playbackState$CustomAction$Builder0.setExtras(bundle0);
            return playbackState$CustomAction$Builder0.build();
        }
    }

    public static long getActions(Object object0) {
        return ((PlaybackState)object0).getActions();
    }

    public static long getActiveQueueItemId(Object object0) {
        return ((PlaybackState)object0).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object object0) {
        return ((PlaybackState)object0).getBufferedPosition();
    }

    public static List getCustomActions(Object object0) {
        return ((PlaybackState)object0).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object object0) {
        return ((PlaybackState)object0).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object object0) {
        return ((PlaybackState)object0).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object object0) {
        return ((PlaybackState)object0).getPlaybackSpeed();
    }

    public static long getPosition(Object object0) {
        return ((PlaybackState)object0).getPosition();
    }

    public static int getState(Object object0) {
        return ((PlaybackState)object0).getState();
    }

    public static Object newInstance(int v, long v1, long v2, float f, long v3, CharSequence charSequence0, long v4, List list0, long v5) {
        PlaybackState.Builder playbackState$Builder0 = new PlaybackState.Builder();
        playbackState$Builder0.setState(v, v1, f, v4);
        playbackState$Builder0.setBufferedPosition(v2);
        playbackState$Builder0.setActions(v3);
        playbackState$Builder0.setErrorMessage(charSequence0);
        for(Object object0: list0) {
            playbackState$Builder0.addCustomAction(((PlaybackState.CustomAction)object0));
        }
        playbackState$Builder0.setActiveQueueItemId(v5);
        return playbackState$Builder0.build();
    }
}

