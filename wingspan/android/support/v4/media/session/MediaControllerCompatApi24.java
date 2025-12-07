package android.support.v4.media.session;

import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;

class MediaControllerCompatApi24 {
    public static class TransportControls {
        public static void prepare(Object object0) {
            ((MediaController.TransportControls)object0).prepare();
        }

        public static void prepareFromMediaId(Object object0, String s, Bundle bundle0) {
            ((MediaController.TransportControls)object0).prepareFromMediaId(s, bundle0);
        }

        public static void prepareFromSearch(Object object0, String s, Bundle bundle0) {
            ((MediaController.TransportControls)object0).prepareFromSearch(s, bundle0);
        }

        public static void prepareFromUri(Object object0, Uri uri0, Bundle bundle0) {
            ((MediaController.TransportControls)object0).prepareFromUri(uri0, bundle0);
        }
    }

}

