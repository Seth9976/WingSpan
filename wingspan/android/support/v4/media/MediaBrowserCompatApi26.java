package android.support.v4.media;

import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

class MediaBrowserCompatApi26 {
    interface SubscriptionCallback extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(String arg1, List arg2, Bundle arg3);

        void onError(String arg1, Bundle arg2);
    }

    static class SubscriptionCallbackProxy extends android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallbackProxy {
        SubscriptionCallbackProxy(SubscriptionCallback mediaBrowserCompatApi26$SubscriptionCallback0) {
            super(mediaBrowserCompatApi26$SubscriptionCallback0);
        }

        @Override  // android.media.browse.MediaBrowser$SubscriptionCallback
        public void onChildrenLoaded(String s, List list0, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((SubscriptionCallback)this.mSubscriptionCallback).onChildrenLoaded(s, list0, bundle0);
        }

        @Override  // android.media.browse.MediaBrowser$SubscriptionCallback
        public void onError(String s, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((SubscriptionCallback)this.mSubscriptionCallback).onError(s, bundle0);
        }
    }

    static Object createSubscriptionCallback(SubscriptionCallback mediaBrowserCompatApi26$SubscriptionCallback0) {
        return new SubscriptionCallbackProxy(mediaBrowserCompatApi26$SubscriptionCallback0);
    }

    public static void subscribe(Object object0, String s, Bundle bundle0, Object object1) {
        ((MediaBrowser)object0).subscribe(s, bundle0, ((MediaBrowser.SubscriptionCallback)object1));
    }

    public static void unsubscribe(Object object0, String s, Object object1) {
        ((MediaBrowser)object0).unsubscribe(s, ((MediaBrowser.SubscriptionCallback)object1));
    }
}

