package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

class MediaSessionCompatApi24 {
    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String arg1, Bundle arg2);

        void onPrepareFromSearch(String arg1, Bundle arg2);

        void onPrepareFromUri(Uri arg1, Bundle arg2);
    }

    static class CallbackProxy extends android.support.v4.media.session.MediaSessionCompatApi23.CallbackProxy {
        public CallbackProxy(Callback mediaSessionCompatApi24$Callback0) {
            super(mediaSessionCompatApi24$Callback0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPrepare() {
            ((Callback)this.mCallback).onPrepare();
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPrepareFromMediaId(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((Callback)this.mCallback).onPrepareFromMediaId(s, bundle0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPrepareFromSearch(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((Callback)this.mCallback).onPrepareFromSearch(s, bundle0);
        }

        @Override  // android.media.session.MediaSession$Callback
        public void onPrepareFromUri(Uri uri0, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((Callback)this.mCallback).onPrepareFromUri(uri0, bundle0);
        }
    }

    private static final String TAG = "MediaSessionCompatApi24";

    public static Object createCallback(Callback mediaSessionCompatApi24$Callback0) {
        return new CallbackProxy(mediaSessionCompatApi24$Callback0);
    }

    public static String getCallingPackage(Object object0) {
        MediaSession mediaSession0 = (MediaSession)object0;
        try {
            return (String)mediaSession0.getClass().getMethod("getCallingPackage").invoke(mediaSession0);
        }
        catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException noSuchMethodException0) {
            Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", noSuchMethodException0);
            return null;
        }
    }
}

