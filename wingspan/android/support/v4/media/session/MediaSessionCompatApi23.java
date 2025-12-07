package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi23 {
    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri arg1, Bundle arg2);
    }

    static class CallbackProxy extends android.support.v4.media.session.MediaSessionCompatApi21.CallbackProxy {
        public CallbackProxy(Callback mediaSessionCompatApi23$Callback0) {
            super(mediaSessionCompatApi23$Callback0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPlayFromUri(Uri uri0, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((Callback)this.mCallback).onPlayFromUri(uri0, bundle0);
        }
    }

    public static Object createCallback(Callback mediaSessionCompatApi23$Callback0) {
        return new CallbackProxy(mediaSessionCompatApi23$Callback0);
    }
}

