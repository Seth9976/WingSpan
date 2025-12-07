package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

class MediaBrowserCompatApi21 {
    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    static class ConnectionCallbackProxy extends MediaBrowser.ConnectionCallback {
        protected final ConnectionCallback mConnectionCallback;

        public ConnectionCallbackProxy(ConnectionCallback mediaBrowserCompatApi21$ConnectionCallback0) {
            this.mConnectionCallback = mediaBrowserCompatApi21$ConnectionCallback0;
        }

        @Override  // android.media.browse.MediaBrowser$ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override  // android.media.browse.MediaBrowser$ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        @Override  // android.media.browse.MediaBrowser$ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }
    }

    static class MediaItem {
        public static Object getDescription(Object object0) {
            return ((MediaBrowser.MediaItem)object0).getDescription();
        }

        public static int getFlags(Object object0) {
            return ((MediaBrowser.MediaItem)object0).getFlags();
        }
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(String arg1, List arg2);

        void onError(String arg1);
    }

    static class SubscriptionCallbackProxy extends MediaBrowser.SubscriptionCallback {
        protected final SubscriptionCallback mSubscriptionCallback;

        public SubscriptionCallbackProxy(SubscriptionCallback mediaBrowserCompatApi21$SubscriptionCallback0) {
            this.mSubscriptionCallback = mediaBrowserCompatApi21$SubscriptionCallback0;
        }

        @Override  // android.media.browse.MediaBrowser$SubscriptionCallback
        public void onChildrenLoaded(String s, List list0) {
            this.mSubscriptionCallback.onChildrenLoaded(s, list0);
        }

        @Override  // android.media.browse.MediaBrowser$SubscriptionCallback
        public void onError(String s) {
            this.mSubscriptionCallback.onError(s);
        }
    }

    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    public static void connect(Object object0) {
        ((MediaBrowser)object0).connect();
    }

    public static Object createBrowser(Context context0, ComponentName componentName0, Object object0, Bundle bundle0) {
        return new MediaBrowser(context0, componentName0, ((MediaBrowser.ConnectionCallback)object0), bundle0);
    }

    public static Object createConnectionCallback(ConnectionCallback mediaBrowserCompatApi21$ConnectionCallback0) {
        return new ConnectionCallbackProxy(mediaBrowserCompatApi21$ConnectionCallback0);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback mediaBrowserCompatApi21$SubscriptionCallback0) {
        return new SubscriptionCallbackProxy(mediaBrowserCompatApi21$SubscriptionCallback0);
    }

    public static void disconnect(Object object0) {
        ((MediaBrowser)object0).disconnect();
    }

    public static Bundle getExtras(Object object0) {
        return ((MediaBrowser)object0).getExtras();
    }

    public static String getRoot(Object object0) {
        return ((MediaBrowser)object0).getRoot();
    }

    public static ComponentName getServiceComponent(Object object0) {
        return ((MediaBrowser)object0).getServiceComponent();
    }

    public static Object getSessionToken(Object object0) {
        return ((MediaBrowser)object0).getSessionToken();
    }

    public static boolean isConnected(Object object0) {
        return ((MediaBrowser)object0).isConnected();
    }

    public static void subscribe(Object object0, String s, Object object1) {
        ((MediaBrowser)object0).subscribe(s, ((MediaBrowser.SubscriptionCallback)object1));
    }

    public static void unsubscribe(Object object0, String s) {
        ((MediaBrowser)object0).unsubscribe(s);
    }
}

