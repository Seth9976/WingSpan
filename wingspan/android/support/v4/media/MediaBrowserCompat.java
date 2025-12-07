package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession.Stub;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class MediaBrowserCompat {
    static class CallbackHandler extends Handler {
        private final WeakReference mCallbackImplRef;
        private WeakReference mCallbacksMessengerRef;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserCompat$MediaBrowserServiceCallbackImpl0) {
            this.mCallbackImplRef = new WeakReference(mediaBrowserCompat$MediaBrowserServiceCallbackImpl0);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            if(this.mCallbacksMessengerRef != null && this.mCallbacksMessengerRef.get() != null && this.mCallbackImplRef.get() != null) {
                Bundle bundle0 = message0.getData();
                MediaSessionCompat.ensureClassLoader(bundle0);
                MediaBrowserServiceCallbackImpl mediaBrowserCompat$MediaBrowserServiceCallbackImpl0 = (MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get();
                Messenger messenger0 = (Messenger)this.mCallbacksMessengerRef.get();
                try {
                    switch(message0.what) {
                        case 1: {
                            Bundle bundle1 = bundle0.getBundle("data_root_hints");
                            MediaSessionCompat.ensureClassLoader(bundle1);
                            mediaBrowserCompat$MediaBrowserServiceCallbackImpl0.onServiceConnected(messenger0, bundle0.getString("data_media_item_id"), ((Token)bundle0.getParcelable("data_media_session_token")), bundle1);
                            return;
                        }
                        case 2: {
                            mediaBrowserCompat$MediaBrowserServiceCallbackImpl0.onConnectionFailed(messenger0);
                            return;
                        }
                        case 3: {
                            Bundle bundle2 = bundle0.getBundle("data_options");
                            MediaSessionCompat.ensureClassLoader(bundle2);
                            Bundle bundle3 = bundle0.getBundle("data_notify_children_changed_options");
                            MediaSessionCompat.ensureClassLoader(bundle3);
                            mediaBrowserCompat$MediaBrowserServiceCallbackImpl0.onLoadChildren(messenger0, bundle0.getString("data_media_item_id"), bundle0.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                            return;
                        }
                        default: {
                            Log.w("MediaBrowserCompat", "Unhandled message: " + message0 + "\n  Client version: 1\n  Service version: " + message0.arg1);
                        }
                    }
                }
                catch(BadParcelableException unused_ex) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if(message0.what == 1) {
                        mediaBrowserCompat$MediaBrowserServiceCallbackImpl0.onConnectionFailed(messenger0);
                    }
                }
            }
        }

        void setCallbacksMessenger(Messenger messenger0) {
            this.mCallbacksMessengerRef = new WeakReference(messenger0);
        }
    }

    public static class ConnectionCallback {
        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        class StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback {
            @Override  // android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback
            public void onConnected() {
                if(ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override  // android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback
            public void onConnectionFailed() {
                if(ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            @Override  // android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback
            public void onConnectionSuspended() {
                if(ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        public ConnectionCallback() {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(this));
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        void setInternalConnectionCallback(ConnectionCallbackInternal mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal0) {
            this.mConnectionCallbackInternal = mediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal0;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(String s, Bundle bundle0, Bundle bundle1) {
        }

        public void onProgressUpdate(String s, Bundle bundle0, Bundle bundle1) {
        }

        public void onResult(String s, Bundle bundle0, Bundle bundle1) {
        }
    }

    static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String s, Bundle bundle0, CustomActionCallback mediaBrowserCompat$CustomActionCallback0, Handler handler0) {
            super(handler0);
            this.mAction = s;
            this.mExtras = bundle0;
            this.mCallback = mediaBrowserCompat$CustomActionCallback0;
        }

        @Override  // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int v, Bundle bundle0) {
            if(this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle0);
            switch(v) {
                case -1: {
                    return;
                }
                case 0: {
                    return;
                }
                default: {
                    if(v != 1) {
                        Log.w("MediaBrowserCompat", "Unknown result code: " + v + " (extras=" + this.mExtras + ", resultData=" + bundle0 + ")");
                    }
                }
            }
        }
    }

    public static abstract class ItemCallback {
        class StubApi23 implements android.support.v4.media.MediaBrowserCompatApi23.ItemCallback {
            @Override  // android.support.v4.media.MediaBrowserCompatApi23$ItemCallback
            public void onError(String s) {
            }

            @Override  // android.support.v4.media.MediaBrowserCompatApi23$ItemCallback
            public void onItemLoaded(Parcel parcel0) {
                if(parcel0 == null) {
                    return;
                }
                parcel0.setDataPosition(0);
                MediaItem mediaBrowserCompat$MediaItem0 = (MediaItem)MediaItem.CREATOR.createFromParcel(parcel0);
                parcel0.recycle();
            }
        }

        final Object mItemCallbackObj;

        public ItemCallback() {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23(this));
        }

        public void onError(String s) {
        }

        public void onItemLoaded(MediaItem mediaBrowserCompat$MediaItem0) {
        }
    }

    static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String s, ItemCallback mediaBrowserCompat$ItemCallback0, Handler handler0) {
            super(handler0);
            this.mMediaId = s;
            this.mCallback = mediaBrowserCompat$ItemCallback0;
        }

        @Override  // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int v, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            if(v == 0 && bundle0 != null && bundle0.containsKey("media_item")) {
                Parcelable parcelable0 = bundle0.getParcelable("media_item");
                if(parcelable0 != null && !(parcelable0 instanceof MediaItem)) {
                }
            }
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String arg1, ItemCallback arg2);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        Token getSessionToken();

        boolean isConnected();

        void search(String arg1, Bundle arg2, SearchCallback arg3);

        void sendCustomAction(String arg1, Bundle arg2, CustomActionCallback arg3);

        void subscribe(String arg1, Bundle arg2, SubscriptionCallback arg3);

        void unsubscribe(String arg1, SubscriptionCallback arg2);
    }

    static class MediaBrowserImplApi21 implements ConnectionCallbackInternal, MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler;
        private Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        private final ArrayMap mSubscriptions;

        MediaBrowserImplApi21(Context context0, ComponentName componentName0, ConnectionCallback mediaBrowserCompat$ConnectionCallback0, Bundle bundle0) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mContext = context0;
            Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
            this.mRootHints = bundle1;
            bundle1.putInt("extra_client_version", 1);
            mediaBrowserCompat$ConnectionCallback0.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(context0, componentName0, mediaBrowserCompat$ConnectionCallback0.mConnectionCallbackObj, bundle1);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void disconnect() {
            ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper0 = this.mServiceBinderWrapper;
            if(mediaBrowserCompat$ServiceBinderWrapper0 != null) {
                Messenger messenger0 = this.mCallbacksMessenger;
                if(messenger0 != null) {
                    try {
                        mediaBrowserCompat$ServiceBinderWrapper0.unregisterCallbackMessenger(messenger0);
                    }
                    catch(RemoteException unused_ex) {
                        Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                    }
                }
            }
            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void getItem(String s, ItemCallback mediaBrowserCompat$ItemCallback0) {
            if(TextUtils.isEmpty(s)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if(mediaBrowserCompat$ItemCallback0 == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if(!MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1 mediaBrowserCompat$MediaBrowserImplApi21$10 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$10);
                return;
            }
            if(this.mServiceBinderWrapper == null) {
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2 mediaBrowserCompat$MediaBrowserImplApi21$20 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$20);
                return;
            }
            ItemReceiver mediaBrowserCompat$ItemReceiver0 = new ItemReceiver(s, mediaBrowserCompat$ItemCallback0, this.mHandler);
            try {
                this.mServiceBinderWrapper.getMediaItem(s, mediaBrowserCompat$ItemReceiver0, this.mCallbacksMessenger);
            }
            catch(RemoteException unused_ex) {
                Log.i("MediaBrowserCompat", "Remote error getting media item: " + s);
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3 mediaBrowserCompat$MediaBrowserImplApi21$30 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$30);
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public Token getSessionToken() {
            if(this.mMediaSessionToken == null) {
                this.mMediaSessionToken = Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
            }
            return this.mMediaSessionToken;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal
        public void onConnected() {
            Bundle bundle0 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if(bundle0 == null) {
                return;
            }
            this.mServiceVersion = bundle0.getInt("extra_service_version", 0);
            IBinder iBinder0 = BundleCompat.getBinder(bundle0, "extra_messenger");
            if(iBinder0 != null) {
                this.mServiceBinderWrapper = new ServiceBinderWrapper(iBinder0, this.mRootHints);
                Messenger messenger0 = new Messenger(this.mHandler);
                this.mCallbacksMessenger = messenger0;
                this.mHandler.setCallbacksMessenger(messenger0);
                try {
                    this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                }
                catch(RemoteException unused_ex) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            IMediaSession iMediaSession0 = Stub.asInterface(BundleCompat.getBinder(bundle0, "extra_session_binder"));
            if(iMediaSession0 != null) {
                this.mMediaSessionToken = Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), iMediaSession0);
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger0) {
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger0, String s, List list0, Bundle bundle0, Bundle bundle1) {
            if(this.mCallbacksMessenger != messenger0) {
                return;
            }
            Subscription mediaBrowserCompat$Subscription0 = (Subscription)this.mSubscriptions.get(s);
            if(mediaBrowserCompat$Subscription0 == null) {
                if(MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn\'t subscribed id=" + s);
                }
                return;
            }
            if(mediaBrowserCompat$Subscription0.getCallback(bundle0) != null) {
                if(bundle0 == null) {
                    if(list0 == null) {
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = null;
                    return;
                }
                if(list0 == null) {
                    return;
                }
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger0, String s, Token mediaSessionCompat$Token0, Bundle bundle0) {
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void search(String s, Bundle bundle0, SearchCallback mediaBrowserCompat$SearchCallback0) {
            if(!this.isConnected()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if(this.mServiceBinderWrapper == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn\'t support search.");
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4 mediaBrowserCompat$MediaBrowserImplApi21$40 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$40);
                return;
            }
            SearchResultReceiver mediaBrowserCompat$SearchResultReceiver0 = new SearchResultReceiver(s, bundle0, mediaBrowserCompat$SearchCallback0, this.mHandler);
            try {
                this.mServiceBinderWrapper.search(s, bundle0, mediaBrowserCompat$SearchResultReceiver0, this.mCallbacksMessenger);
            }
            catch(RemoteException remoteException0) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + s, remoteException0);
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5 mediaBrowserCompat$MediaBrowserImplApi21$50 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$50);
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void sendCustomAction(String s, Bundle bundle0, CustomActionCallback mediaBrowserCompat$CustomActionCallback0) {
            if(!this.isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + s + ") with extras " + bundle0 + " because the browser is not connected to the service.");
            }
            if(this.mServiceBinderWrapper == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn\'t support sendCustomAction.");
                if(mediaBrowserCompat$CustomActionCallback0 != null) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6 mediaBrowserCompat$MediaBrowserImplApi21$60 = new Runnable() {
                        @Override
                        public void run() {
                        }
                    };
                    this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$60);
                }
            }
            CustomActionResultReceiver mediaBrowserCompat$CustomActionResultReceiver0 = new CustomActionResultReceiver(s, bundle0, mediaBrowserCompat$CustomActionCallback0, this.mHandler);
            try {
                this.mServiceBinderWrapper.sendCustomAction(s, bundle0, mediaBrowserCompat$CustomActionResultReceiver0, this.mCallbacksMessenger);
            }
            catch(RemoteException remoteException0) {
                Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + s + ", extras=" + bundle0, remoteException0);
                if(mediaBrowserCompat$CustomActionCallback0 != null) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7 mediaBrowserCompat$MediaBrowserImplApi21$70 = new Runnable() {
                        @Override
                        public void run() {
                        }
                    };
                    this.mHandler.post(mediaBrowserCompat$MediaBrowserImplApi21$70);
                }
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void subscribe(String s, Bundle bundle0, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            Subscription mediaBrowserCompat$Subscription0 = (Subscription)this.mSubscriptions.get(s);
            if(mediaBrowserCompat$Subscription0 == null) {
                mediaBrowserCompat$Subscription0 = new Subscription();
                this.mSubscriptions.put(s, mediaBrowserCompat$Subscription0);
            }
            mediaBrowserCompat$SubscriptionCallback0.setSubscription(mediaBrowserCompat$Subscription0);
            Bundle bundle1 = bundle0 == null ? null : new Bundle(bundle0);
            mediaBrowserCompat$Subscription0.putCallback(bundle1, mediaBrowserCompat$SubscriptionCallback0);
            ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper0 = this.mServiceBinderWrapper;
            if(mediaBrowserCompat$ServiceBinderWrapper0 == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, s, mediaBrowserCompat$SubscriptionCallback0.mSubscriptionCallbackObj);
                return;
            }
            try {
                mediaBrowserCompat$ServiceBinderWrapper0.addSubscription(s, mediaBrowserCompat$SubscriptionCallback0.mToken, bundle1, this.mCallbacksMessenger);
            }
            catch(RemoteException unused_ex) {
                Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + s);
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void unsubscribe(String s, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            Subscription mediaBrowserCompat$Subscription0 = (Subscription)this.mSubscriptions.get(s);
            if(mediaBrowserCompat$Subscription0 == null) {
                return;
            }
            ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper0 = this.mServiceBinderWrapper;
            if(mediaBrowserCompat$ServiceBinderWrapper0 != null) {
                try {
                    if(mediaBrowserCompat$SubscriptionCallback0 == null) {
                        mediaBrowserCompat$ServiceBinderWrapper0.removeSubscription(s, null, this.mCallbacksMessenger);
                    }
                    else {
                        List list2 = mediaBrowserCompat$Subscription0.getCallbacks();
                        List list3 = mediaBrowserCompat$Subscription0.getOptionsList();
                        int v1 = list2.size() - 1;
                    label_26:
                        while(v1 >= 0) {
                            if(list2.get(v1) == mediaBrowserCompat$SubscriptionCallback0) {
                                this.mServiceBinderWrapper.removeSubscription(s, mediaBrowserCompat$SubscriptionCallback0.mToken, this.mCallbacksMessenger);
                                list2.remove(v1);
                                list3.remove(v1);
                            }
                            --v1;
                        }
                    }
                }
                catch(RemoteException unused_ex) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + s);
                    if(true) {
                        goto label_35;
                    }
                    goto label_26;
                }
            }
            else if(mediaBrowserCompat$SubscriptionCallback0 == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, s);
            }
            else {
                List list0 = mediaBrowserCompat$Subscription0.getCallbacks();
                List list1 = mediaBrowserCompat$Subscription0.getOptionsList();
                for(int v = list0.size() - 1; v >= 0; --v) {
                    if(list0.get(v) == mediaBrowserCompat$SubscriptionCallback0) {
                        list0.remove(v);
                        list1.remove(v);
                    }
                }
                if(list0.size() == 0) {
                    MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, s);
                }
            }
        label_35:
            if(mediaBrowserCompat$Subscription0.isEmpty() || mediaBrowserCompat$SubscriptionCallback0 == null) {
                this.mSubscriptions.remove(s);
            }
        }
    }

    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context0, ComponentName componentName0, ConnectionCallback mediaBrowserCompat$ConnectionCallback0, Bundle bundle0) {
            super(context0, componentName0, mediaBrowserCompat$ConnectionCallback0, bundle0);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
        public void getItem(String s, ItemCallback mediaBrowserCompat$ItemCallback0) {
            if(this.mServiceBinderWrapper == null) {
                MediaBrowserCompatApi23.getItem(this.mBrowserObj, s, mediaBrowserCompat$ItemCallback0.mItemCallbackObj);
                return;
            }
            super.getItem(s, mediaBrowserCompat$ItemCallback0);
        }
    }

    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context0, ComponentName componentName0, ConnectionCallback mediaBrowserCompat$ConnectionCallback0, Bundle bundle0) {
            super(context0, componentName0, mediaBrowserCompat$ConnectionCallback0, bundle0);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
        public void subscribe(String s, Bundle bundle0, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            if(this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(s, bundle0, mediaBrowserCompat$SubscriptionCallback0);
                return;
            }
            if(bundle0 == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, s, mediaBrowserCompat$SubscriptionCallback0.mSubscriptionCallbackObj);
                return;
            }
            MediaBrowserCompatApi26.subscribe(this.mBrowserObj, s, bundle0, mediaBrowserCompat$SubscriptionCallback0.mSubscriptionCallbackObj);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21
        public void unsubscribe(String s, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            if(this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(s, mediaBrowserCompat$SubscriptionCallback0);
                return;
            }
            if(mediaBrowserCompat$SubscriptionCallback0 == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, s);
                return;
            }
            MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, s, mediaBrowserCompat$SubscriptionCallback0.mSubscriptionCallbackObj);
        }
    }

    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        class MediaServiceConnection implements ServiceConnection {
            boolean isCurrent(String s) {
                if(MediaBrowserImplBase.this.mServiceConnection == this && (MediaBrowserImplBase.this.mState != 0 && MediaBrowserImplBase.this.mState != 1)) {
                    return true;
                }
                if(MediaBrowserImplBase.this.mState != 0 && MediaBrowserImplBase.this.mState != 1) {
                    Log.i("MediaBrowserCompat", s + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                }
                return false;
            }

            @Override  // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
                this.postOrRun(new Runnable() {
                    @Override
                    public void run() {
                        if(MediaBrowserCompat.DEBUG) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName0 + " binder=" + iBinder0);
                            MediaBrowserImplBase.this.dump();
                        }
                        if(!MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            return;
                        }
                        MediaBrowserImplBase.this.mServiceBinderWrapper = new ServiceBinderWrapper(iBinder0, MediaBrowserImplBase.this.mRootHints);
                        MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                        MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(MediaBrowserImplBase.this.mCallbacksMessenger);
                        MediaBrowserImplBase.this.mState = 2;
                        try {
                            if(MediaBrowserCompat.DEBUG) {
                                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                MediaBrowserImplBase.this.dump();
                            }
                            MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserImplBase.this.mContext, MediaBrowserImplBase.this.mCallbacksMessenger);
                        }
                        catch(RemoteException unused_ex) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                            if(MediaBrowserCompat.DEBUG) {
                                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                MediaBrowserImplBase.this.dump();
                            }
                        }
                    }
                });
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName0) {
                this.postOrRun(new Runnable() {
                    @Override
                    public void run() {
                        if(MediaBrowserCompat.DEBUG) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName0 + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection);
                            MediaBrowserImplBase.this.dump();
                        }
                        if(!MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            return;
                        }
                        MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                        MediaBrowserImplBase.this.mCallbacksMessenger = null;
                        MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
                        MediaBrowserImplBase.this.mState = 4;
                        MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                    }
                });
            }

            private void postOrRun(Runnable runnable0) {
                if(Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable0.run();
                    return;
                }
                MediaBrowserImplBase.this.mHandler.post(runnable0);
            }
        }

        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler;
        private Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState;
        private final ArrayMap mSubscriptions;

        public MediaBrowserImplBase(Context context0, ComponentName componentName0, ConnectionCallback mediaBrowserCompat$ConnectionCallback0, Bundle bundle0) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mState = 1;
            if(context0 == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if(componentName0 == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if(mediaBrowserCompat$ConnectionCallback0 == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context0;
            this.mServiceComponent = componentName0;
            this.mCallback = mediaBrowserCompat$ConnectionCallback0;
            this.mRootHints = bundle0 == null ? null : new Bundle(bundle0);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void connect() {
            if(this.mState != 0 && this.mState != 1) {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }
            this.mState = 2;
            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1 mediaBrowserCompat$MediaBrowserImplBase$10 = new Runnable() {
                @Override
                public void run() {
                    boolean z;
                    if(MediaBrowserImplBase.this.mState == 0) {
                        return;
                    }
                    MediaBrowserImplBase.this.mState = 2;
                    if(MediaBrowserCompat.DEBUG && MediaBrowserImplBase.this.mServiceConnection != null) {
                        throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.mServiceConnection);
                    }
                    if(MediaBrowserImplBase.this.mServiceBinderWrapper != null) {
                        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.mServiceBinderWrapper);
                    }
                    if(MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.mCallbacksMessenger);
                    }
                    Intent intent0 = new Intent("android.media.browse.MediaBrowserService");
                    intent0.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                    MediaBrowserImplBase.this.mServiceConnection = new MediaServiceConnection(MediaBrowserImplBase.this);
                    try {
                        z = MediaBrowserImplBase.this.mContext.bindService(intent0, MediaBrowserImplBase.this.mServiceConnection, 1);
                    }
                    catch(Exception unused_ex) {
                        Log.e("MediaBrowserCompat", "Failed binding to service " + MediaBrowserImplBase.this.mServiceComponent);
                        z = false;
                    }
                    if(!z) {
                        MediaBrowserImplBase.this.forceCloseConnection();
                        MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                    }
                    if(MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "connect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            };
            this.mHandler.post(mediaBrowserCompat$MediaBrowserImplBase$10);
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2 mediaBrowserCompat$MediaBrowserImplBase$20 = new Runnable() {
                @Override
                public void run() {
                    if(MediaBrowserImplBase.this.mCallbacksMessenger != null) {
                        try {
                            MediaBrowserImplBase.this.mServiceBinderWrapper.disconnect(MediaBrowserImplBase.this.mCallbacksMessenger);
                        }
                        catch(RemoteException unused_ex) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                        }
                    }
                    int v = MediaBrowserImplBase.this.mState;
                    MediaBrowserImplBase.this.forceCloseConnection();
                    if(v != 0) {
                        MediaBrowserImplBase.this.mState = v;
                    }
                    if(MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            };
            this.mHandler.post(mediaBrowserCompat$MediaBrowserImplBase$20);
        }

        void dump() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
            Log.d("MediaBrowserCompat", "  mState=" + MediaBrowserImplBase.getStateLabel(this.mState));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        void forceCloseConnection() {
            MediaServiceConnection mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection0 = this.mServiceConnection;
            if(mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection0 != null) {
                this.mContext.unbindService(mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection0);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public Bundle getExtras() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getExtras() called while not connected (state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }
            return this.mExtras;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void getItem(String s, ItemCallback mediaBrowserCompat$ItemCallback0) {
            if(TextUtils.isEmpty(s)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if(mediaBrowserCompat$ItemCallback0 == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if(!this.isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3 mediaBrowserCompat$MediaBrowserImplBase$30 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplBase$30);
                return;
            }
            ItemReceiver mediaBrowserCompat$ItemReceiver0 = new ItemReceiver(s, mediaBrowserCompat$ItemCallback0, this.mHandler);
            try {
                this.mServiceBinderWrapper.getMediaItem(s, mediaBrowserCompat$ItemReceiver0, this.mCallbacksMessenger);
            }
            catch(RemoteException unused_ex) {
                Log.i("MediaBrowserCompat", "Remote error getting media item: " + s);
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4 mediaBrowserCompat$MediaBrowserImplBase$40 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplBase$40);
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public String getRoot() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getRoot() called while not connected(state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }
            return this.mRootId;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public ComponentName getServiceComponent() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
            }
            return this.mServiceComponent;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public Token getSessionToken() {
            if(!this.isConnected()) {
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
            }
            return this.mMediaSessionToken;
        }

        private static String getStateLabel(int v) {
            switch(v) {
                case 0: {
                    return "CONNECT_STATE_DISCONNECTING";
                }
                case 1: {
                    return "CONNECT_STATE_DISCONNECTED";
                }
                case 2: {
                    return "CONNECT_STATE_CONNECTING";
                }
                case 3: {
                    return "CONNECT_STATE_CONNECTED";
                }
                case 4: {
                    return "CONNECT_STATE_SUSPENDED";
                }
                default: {
                    return "UNKNOWN/" + v;
                }
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        private boolean isCurrent(Messenger messenger0, String s) {
            if(this.mCallbacksMessenger == messenger0 && (this.mState != 0 && this.mState != 1)) {
                return true;
            }
            if(this.mState != 0 && this.mState != 1) {
                Log.i("MediaBrowserCompat", s + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            }
            return false;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger0) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
            if(!this.isCurrent(messenger0, "onConnectFailed")) {
                return;
            }
            if(this.mState != 2) {
                Log.w("MediaBrowserCompat", "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(this.mState) + "... ignoring");
                return;
            }
            this.forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger0, String s, List list0, Bundle bundle0, Bundle bundle1) {
            if(!this.isCurrent(messenger0, "onLoadChildren")) {
                return;
            }
            if(MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "onLoadChildren for " + this.mServiceComponent + " id=" + s);
            }
            Subscription mediaBrowserCompat$Subscription0 = (Subscription)this.mSubscriptions.get(s);
            if(mediaBrowserCompat$Subscription0 == null) {
                if(MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn\'t subscribed id=" + s);
                }
                return;
            }
            if(mediaBrowserCompat$Subscription0.getCallback(bundle0) != null) {
                if(bundle0 == null) {
                    if(list0 == null) {
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = null;
                    return;
                }
                if(list0 == null) {
                    return;
                }
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger0, String s, Token mediaSessionCompat$Token0, Bundle bundle0) {
            if(!this.isCurrent(messenger0, "onConnect")) {
                return;
            }
            if(this.mState != 2) {
                Log.w("MediaBrowserCompat", "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(this.mState) + "... ignoring");
                return;
            }
            this.mRootId = s;
            this.mMediaSessionToken = mediaSessionCompat$Token0;
            this.mExtras = bundle0;
            this.mState = 3;
            if(MediaBrowserCompat.DEBUG) {
                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                this.dump();
            }
            this.mCallback.onConnected();
            try {
                Iterator iterator0 = this.mSubscriptions.entrySet().iterator();
                while(true) {
                label_14:
                    if(!iterator0.hasNext()) {
                        return;
                    }
                    Object object0 = iterator0.next();
                    String s1 = (String)((Map.Entry)object0).getKey();
                    Subscription mediaBrowserCompat$Subscription0 = (Subscription)((Map.Entry)object0).getValue();
                    List list0 = mediaBrowserCompat$Subscription0.getCallbacks();
                    List list1 = mediaBrowserCompat$Subscription0.getOptionsList();
                    for(int v = 0; v < list0.size(); ++v) {
                        this.mServiceBinderWrapper.addSubscription(s1, ((SubscriptionCallback)list0.get(v)).mToken, ((Bundle)list1.get(v)), this.mCallbacksMessenger);
                    }
                }
            }
            catch(RemoteException unused_ex) {
                Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                return;
            }
            goto label_14;
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void search(String s, Bundle bundle0, SearchCallback mediaBrowserCompat$SearchCallback0) {
            if(!this.isConnected()) {
                throw new IllegalStateException("search() called while not connected (state=" + MediaBrowserImplBase.getStateLabel(this.mState) + ")");
            }
            SearchResultReceiver mediaBrowserCompat$SearchResultReceiver0 = new SearchResultReceiver(s, bundle0, mediaBrowserCompat$SearchCallback0, this.mHandler);
            try {
                this.mServiceBinderWrapper.search(s, bundle0, mediaBrowserCompat$SearchResultReceiver0, this.mCallbacksMessenger);
            }
            catch(RemoteException remoteException0) {
                Log.i("MediaBrowserCompat", "Remote error searching items with query: " + s, remoteException0);
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5 mediaBrowserCompat$MediaBrowserImplBase$50 = new Runnable() {
                    @Override
                    public void run() {
                    }
                };
                this.mHandler.post(mediaBrowserCompat$MediaBrowserImplBase$50);
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void sendCustomAction(String s, Bundle bundle0, CustomActionCallback mediaBrowserCompat$CustomActionCallback0) {
            if(!this.isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + s + ") with extras " + bundle0 + " because the browser is not connected to the service.");
            }
            CustomActionResultReceiver mediaBrowserCompat$CustomActionResultReceiver0 = new CustomActionResultReceiver(s, bundle0, mediaBrowserCompat$CustomActionCallback0, this.mHandler);
            try {
                this.mServiceBinderWrapper.sendCustomAction(s, bundle0, mediaBrowserCompat$CustomActionResultReceiver0, this.mCallbacksMessenger);
            }
            catch(RemoteException remoteException0) {
                Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + s + ", extras=" + bundle0, remoteException0);
                if(mediaBrowserCompat$CustomActionCallback0 != null) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6 mediaBrowserCompat$MediaBrowserImplBase$60 = new Runnable() {
                        @Override
                        public void run() {
                        }
                    };
                    this.mHandler.post(mediaBrowserCompat$MediaBrowserImplBase$60);
                }
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void subscribe(String s, Bundle bundle0, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            Subscription mediaBrowserCompat$Subscription0 = (Subscription)this.mSubscriptions.get(s);
            if(mediaBrowserCompat$Subscription0 == null) {
                mediaBrowserCompat$Subscription0 = new Subscription();
                this.mSubscriptions.put(s, mediaBrowserCompat$Subscription0);
            }
            Bundle bundle1 = bundle0 == null ? null : new Bundle(bundle0);
            mediaBrowserCompat$Subscription0.putCallback(bundle1, mediaBrowserCompat$SubscriptionCallback0);
            if(this.isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(s, mediaBrowserCompat$SubscriptionCallback0.mToken, bundle1, this.mCallbacksMessenger);
                }
                catch(RemoteException unused_ex) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + s);
                }
            }
        }

        @Override  // android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl
        public void unsubscribe(String s, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            Subscription mediaBrowserCompat$Subscription0 = (Subscription)this.mSubscriptions.get(s);
            if(mediaBrowserCompat$Subscription0 == null) {
                return;
            }
            try {
                if(mediaBrowserCompat$SubscriptionCallback0 != null) {
                    List list0 = mediaBrowserCompat$Subscription0.getCallbacks();
                    List list1 = mediaBrowserCompat$Subscription0.getOptionsList();
                    int v = list0.size() - 1;
                label_10:
                    while(v >= 0) {
                        if(list0.get(v) == mediaBrowserCompat$SubscriptionCallback0) {
                            if(this.isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(s, mediaBrowserCompat$SubscriptionCallback0.mToken, this.mCallbacksMessenger);
                            }
                            list0.remove(v);
                            list1.remove(v);
                        }
                        --v;
                    }
                }
                else if(this.isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(s, null, this.mCallbacksMessenger);
                }
            }
            catch(RemoteException unused_ex) {
                Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + s);
                if(true) {
                    goto label_20;
                }
                goto label_10;
            }
        label_20:
            if(mediaBrowserCompat$Subscription0.isEmpty() || mediaBrowserCompat$SubscriptionCallback0 == null) {
                this.mSubscriptions.remove(s);
            }
        }
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger arg1);

        void onLoadChildren(Messenger arg1, String arg2, List arg3, Bundle arg4, Bundle arg5);

        void onServiceConnected(Messenger arg1, String arg2, Token arg3, Bundle arg4);
    }

    public static class MediaItem implements Parcelable {
        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        public static final Parcelable.Creator CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        static {
            MediaItem.CREATOR = new Parcelable.Creator() {
                public MediaItem createFromParcel(Parcel parcel0) {
                    return new MediaItem(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public MediaItem[] newArray(int v) {
                    return new MediaItem[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        MediaItem(Parcel parcel0) {
            this.mFlags = parcel0.readInt();
            this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
            if(mediaDescriptionCompat0 == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if(TextUtils.isEmpty(mediaDescriptionCompat0.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = v;
            this.mDescription = mediaDescriptionCompat0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static MediaItem fromMediaItem(Object object0) {
            if(object0 != null) {
                int v = android.support.v4.media.MediaBrowserCompatApi21.MediaItem.getFlags(object0);
                return new MediaItem(MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.MediaBrowserCompatApi21.MediaItem.getDescription(object0)), v);
            }
            return null;
        }

        public static List fromMediaItemList(List list0) {
            if(list0 != null) {
                List list1 = new ArrayList(list0.size());
                for(Object object0: list0) {
                    list1.add(MediaItem.fromMediaItem(object0));
                }
                return list1;
            }
            return null;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @Override
        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel0, v);
        }
    }

    public static abstract class SearchCallback {
        public void onError(String s, Bundle bundle0) {
        }

        public void onSearchResult(String s, Bundle bundle0, List list0) {
        }
    }

    static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String s, Bundle bundle0, SearchCallback mediaBrowserCompat$SearchCallback0, Handler handler0) {
            super(handler0);
            this.mQuery = s;
            this.mExtras = bundle0;
            this.mCallback = mediaBrowserCompat$SearchCallback0;
        }

        @Override  // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int v, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            if(v == 0 && bundle0 != null && bundle0.containsKey("search_results")) {
                Parcelable[] arr_parcelable = bundle0.getParcelableArray("search_results");
                if(arr_parcelable != null) {
                    ArrayList arrayList0 = new ArrayList();
                    for(int v1 = 0; v1 < arr_parcelable.length; ++v1) {
                        arrayList0.add(((MediaItem)arr_parcelable[v1]));
                    }
                }
            }
        }
    }

    static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder0, Bundle bundle0) {
            this.mMessenger = new Messenger(iBinder0);
            this.mRootHints = bundle0;
        }

        void addSubscription(String s, IBinder iBinder0, Bundle bundle0, Messenger messenger0) throws RemoteException {
            Bundle bundle1 = new Bundle();
            bundle1.putString("data_media_item_id", s);
            BundleCompat.putBinder(bundle1, "data_callback_token", iBinder0);
            bundle1.putBundle("data_options", bundle0);
            this.sendRequest(3, bundle1, messenger0);
        }

        void connect(Context context0, Messenger messenger0) throws RemoteException {
            Bundle bundle0 = new Bundle();
            bundle0.putString("data_package_name", "com.MonsterCouch.Wingspan");
            bundle0.putBundle("data_root_hints", this.mRootHints);
            this.sendRequest(1, bundle0, messenger0);
        }

        void disconnect(Messenger messenger0) throws RemoteException {
            this.sendRequest(2, null, messenger0);
        }

        void getMediaItem(String s, ResultReceiver resultReceiver0, Messenger messenger0) throws RemoteException {
            Bundle bundle0 = new Bundle();
            bundle0.putString("data_media_item_id", s);
            bundle0.putParcelable("data_result_receiver", resultReceiver0);
            this.sendRequest(5, bundle0, messenger0);
        }

        void registerCallbackMessenger(Context context0, Messenger messenger0) throws RemoteException {
            Bundle bundle0 = new Bundle();
            bundle0.putString("data_package_name", "com.MonsterCouch.Wingspan");
            bundle0.putBundle("data_root_hints", this.mRootHints);
            this.sendRequest(6, bundle0, messenger0);
        }

        void removeSubscription(String s, IBinder iBinder0, Messenger messenger0) throws RemoteException {
            Bundle bundle0 = new Bundle();
            bundle0.putString("data_media_item_id", s);
            BundleCompat.putBinder(bundle0, "data_callback_token", iBinder0);
            this.sendRequest(4, bundle0, messenger0);
        }

        void search(String s, Bundle bundle0, ResultReceiver resultReceiver0, Messenger messenger0) throws RemoteException {
            Bundle bundle1 = new Bundle();
            bundle1.putString("data_search_query", s);
            bundle1.putBundle("data_search_extras", bundle0);
            bundle1.putParcelable("data_result_receiver", resultReceiver0);
            this.sendRequest(8, bundle1, messenger0);
        }

        void sendCustomAction(String s, Bundle bundle0, ResultReceiver resultReceiver0, Messenger messenger0) throws RemoteException {
            Bundle bundle1 = new Bundle();
            bundle1.putString("data_custom_action", s);
            bundle1.putBundle("data_custom_action_extras", bundle0);
            bundle1.putParcelable("data_result_receiver", resultReceiver0);
            this.sendRequest(9, bundle1, messenger0);
        }

        private void sendRequest(int v, Bundle bundle0, Messenger messenger0) throws RemoteException {
            Message message0 = Message.obtain();
            message0.what = v;
            message0.arg1 = 1;
            message0.setData(bundle0);
            message0.replyTo = messenger0;
            this.mMessenger.send(message0);
        }

        void unregisterCallbackMessenger(Messenger messenger0) throws RemoteException {
            this.sendRequest(7, null, messenger0);
        }
    }

    static class Subscription {
        private final List mCallbacks;
        private final List mOptionsList;

        public Subscription() {
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public SubscriptionCallback getCallback(Bundle bundle0) {
            for(int v = 0; v < this.mOptionsList.size(); ++v) {
                if(MediaBrowserCompatUtils.areSameOptions(((Bundle)this.mOptionsList.get(v)), bundle0)) {
                    return (SubscriptionCallback)this.mCallbacks.get(v);
                }
            }
            return null;
        }

        public List getCallbacks() {
            return this.mCallbacks;
        }

        public List getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle bundle0, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
            for(int v = 0; v < this.mOptionsList.size(); ++v) {
                if(MediaBrowserCompatUtils.areSameOptions(((Bundle)this.mOptionsList.get(v)), bundle0)) {
                    this.mCallbacks.set(v, mediaBrowserCompat$SubscriptionCallback0);
                    return;
                }
            }
            this.mCallbacks.add(mediaBrowserCompat$SubscriptionCallback0);
            this.mOptionsList.add(bundle0);
        }
    }

    public static abstract class SubscriptionCallback {
        class android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21 implements android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback {
            List applyOptions(List list0, Bundle bundle0) {
                if(list0 == null) {
                    return null;
                }
                int v = bundle0.getInt("android.media.browse.extra.PAGE", -1);
                int v1 = bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if(v == -1 && v1 == -1) {
                    return list0;
                }
                int v2 = v1 * v;
                int v3 = v2 + v1;
                if(v >= 0 && v1 >= 1 && v2 < list0.size()) {
                    if(v3 > list0.size()) {
                        v3 = list0.size();
                    }
                    return list0.subList(v2, v3);
                }
                return Collections.emptyList();
            }

            @Override  // android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
            public void onChildrenLoaded(String s, List list0) {
                Subscription mediaBrowserCompat$Subscription0 = SubscriptionCallback.this.mSubscriptionRef == null ? null : ((Subscription)SubscriptionCallback.this.mSubscriptionRef.get());
                if(mediaBrowserCompat$Subscription0 == null) {
                    MediaItem.fromMediaItemList(list0);
                    return;
                }
                List list1 = MediaItem.fromMediaItemList(list0);
                List list2 = mediaBrowserCompat$Subscription0.getCallbacks();
                List list3 = mediaBrowserCompat$Subscription0.getOptionsList();
                for(int v = 0; v < list2.size(); ++v) {
                    Bundle bundle0 = (Bundle)list3.get(v);
                    if(bundle0 != null) {
                        this.applyOptions(list1, bundle0);
                    }
                }
            }

            @Override  // android.support.v4.media.MediaBrowserCompatApi21$SubscriptionCallback
            public void onError(String s) {
            }
        }

        class StubApi26 extends android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21 implements android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback {
            @Override  // android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallback
            public void onChildrenLoaded(String s, List list0, Bundle bundle0) {
                MediaItem.fromMediaItemList(list0);
            }

            @Override  // android.support.v4.media.MediaBrowserCompatApi26$SubscriptionCallback
            public void onError(String s, Bundle bundle0) {
            }
        }

        final Object mSubscriptionCallbackObj;
        WeakReference mSubscriptionRef;
        final IBinder mToken;

        public SubscriptionCallback() {
            this.mToken = new Binder();
            if(Build.VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26(this));
                return;
            }
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.StubApi21(this));
        }

        public void onChildrenLoaded(String s, List list0) {
        }

        public void onChildrenLoaded(String s, List list0, Bundle bundle0) {
        }

        public void onError(String s) {
        }

        public void onError(String s, Bundle bundle0) {
        }

        void setSubscription(Subscription mediaBrowserCompat$Subscription0) {
            this.mSubscriptionRef = new WeakReference(mediaBrowserCompat$Subscription0);
        }
    }

    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = false;
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    static {
        MediaBrowserCompat.DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public MediaBrowserCompat(Context context0, ComponentName componentName0, ConnectionCallback mediaBrowserCompat$ConnectionCallback0, Bundle bundle0) {
        if(Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserImplApi26(context0, componentName0, mediaBrowserCompat$ConnectionCallback0, bundle0);
            return;
        }
        this.mImpl = new MediaBrowserImplApi23(context0, componentName0, mediaBrowserCompat$ConnectionCallback0, bundle0);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(String s, ItemCallback mediaBrowserCompat$ItemCallback0) {
        this.mImpl.getItem(s, mediaBrowserCompat$ItemCallback0);
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(String s, Bundle bundle0, SearchCallback mediaBrowserCompat$SearchCallback0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if(mediaBrowserCompat$SearchCallback0 == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(s, bundle0, mediaBrowserCompat$SearchCallback0);
    }

    public void sendCustomAction(String s, Bundle bundle0, CustomActionCallback mediaBrowserCompat$CustomActionCallback0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(s, bundle0, mediaBrowserCompat$CustomActionCallback0);
    }

    public void subscribe(String s, Bundle bundle0, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if(mediaBrowserCompat$SubscriptionCallback0 == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if(bundle0 == null) {
            throw new IllegalArgumentException("options are null");
        }
        this.mImpl.subscribe(s, bundle0, mediaBrowserCompat$SubscriptionCallback0);
    }

    public void subscribe(String s, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if(mediaBrowserCompat$SubscriptionCallback0 == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(s, null, mediaBrowserCompat$SubscriptionCallback0);
    }

    public void unsubscribe(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(s, null);
    }

    public void unsubscribe(String s, SubscriptionCallback mediaBrowserCompat$SubscriptionCallback0) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if(mediaBrowserCompat$SubscriptionCallback0 == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.unsubscribe(s, mediaBrowserCompat$SubscriptionCallback0);
    }
}

