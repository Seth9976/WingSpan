package android.support.v4.media.session;

import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;

class MediaControllerCompatApi23 {
    public static class TransportControls {
        public static void playFromUri(Object object0, Uri uri0, Bundle bundle0) {
            ((MediaController.TransportControls)object0).playFromUri(uri0, bundle0);
        }
    }

}

