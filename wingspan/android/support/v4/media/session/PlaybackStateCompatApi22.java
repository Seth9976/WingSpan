package android.support.v4.media.session;

import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

class PlaybackStateCompatApi22 {
    public static Bundle getExtras(Object object0) {
        return ((PlaybackState)object0).getExtras();
    }

    public static Object newInstance(int v, long v1, long v2, float f, long v3, CharSequence charSequence0, long v4, List list0, long v5, Bundle bundle0) {
        PlaybackState.Builder playbackState$Builder0 = new PlaybackState.Builder();
        playbackState$Builder0.setState(v, v1, f, v4);
        playbackState$Builder0.setBufferedPosition(v2);
        playbackState$Builder0.setActions(v3);
        playbackState$Builder0.setErrorMessage(charSequence0);
        for(Object object0: list0) {
            playbackState$Builder0.addCustomAction(((PlaybackState.CustomAction)object0));
        }
        playbackState$Builder0.setActiveQueueItemId(v5);
        playbackState$Builder0.setExtras(bundle0);
        return playbackState$Builder0.build();
    }
}

