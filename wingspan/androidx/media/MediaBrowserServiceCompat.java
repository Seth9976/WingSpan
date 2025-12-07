package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(String s, Bundle bundle0) {
            if(s == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = s;
            this.mExtras = bundle0;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    class ConnectionRecord implements IBinder.DeathRecipient {
        public final RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap subscriptions;
        public final int uid;

        ConnectionRecord(String s, int v, int v1, Bundle bundle0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            this.subscriptions = new HashMap();
            this.pkg = s;
            this.pid = v;
            this.uid = v1;
            this.browserInfo = new RemoteUserInfo(s, v, v1);
            this.rootHints = bundle0;
            this.callbacks = mediaBrowserServiceCompat$ServiceCallbacks0;
        }

        @Override  // android.os.IBinder$DeathRecipient
        public void binderDied() {
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1 mediaBrowserServiceCompat$ConnectionRecord$10 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = ConnectionRecord.this.callbacks.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(iBinder0);
                }
            };
            MediaBrowserServiceCompat.this.mHandler.post(mediaBrowserServiceCompat$ConnectionRecord$10);
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(RemoteUserInfo arg1, String arg2, Bundle arg3);

        void notifyChildrenChanged(String arg1, Bundle arg2);

        IBinder onBind(Intent arg1);

        void onCreate();

        void setSessionToken(Token arg1);
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, ServiceCompatProxy {
        Messenger mMessenger;
        final List mRootExtrasList;
        Object mServiceObj;

        MediaBrowserServiceImplApi21() {
            this.mRootExtrasList = new ArrayList();
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if(this.mMessenger == null) {
                return null;
            }
            if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public RemoteUserInfo getCurrentBrowserInfo() {
            if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void notifyChildrenChanged(RemoteUserInfo mediaSessionManager$RemoteUserInfo0, String s, Bundle bundle0) {
            this.notifyChildrenChangedForCompat(mediaSessionManager$RemoteUserInfo0, s, bundle0);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void notifyChildrenChanged(String s, Bundle bundle0) {
            this.notifyChildrenChangedForFramework(s, bundle0);
            this.notifyChildrenChangedForCompat(s, bundle0);
        }

        void notifyChildrenChangedForCompat(RemoteUserInfo mediaSessionManager$RemoteUserInfo0, String s, Bundle bundle0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.4 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$40 = new Runnable() {
                @Override
                public void run() {
                    for(int v = 0; v < MediaBrowserServiceCompat.this.mConnections.size(); ++v) {
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(v);
                        if(mediaBrowserServiceCompat$ConnectionRecord0.browserInfo.equals(mediaSessionManager$RemoteUserInfo0)) {
                            MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(mediaBrowserServiceCompat$ConnectionRecord0, s, bundle0);
                        }
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$40);
        }

        void notifyChildrenChangedForCompat(String s, Bundle bundle0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$30 = new Runnable() {
                @Override
                public void run() {
                    for(Object object0: MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(((IBinder)object0));
                        MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(mediaBrowserServiceCompat$ConnectionRecord0, s, bundle0);
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$30);
        }

        void notifyChildrenChangedForCompatOnHandler(ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, String s, Bundle bundle0) {
            List list0 = (List)mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.get(s);
            if(list0 != null) {
                for(Object object0: list0) {
                    Pair pair0 = (Pair)object0;
                    if(MediaBrowserCompatUtils.hasDuplicatedItems(bundle0, ((Bundle)pair0.second))) {
                        MediaBrowserServiceCompat.this.performLoadChildren(s, mediaBrowserServiceCompat$ConnectionRecord0, ((Bundle)pair0.second), bundle0);
                    }
                }
            }
        }

        void notifyChildrenChangedForFramework(String s, Bundle bundle0) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, s);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public IBinder onBind(Intent intent0) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent0);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void onCreate() {
            Object object0 = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            this.mServiceObj = object0;
            MediaBrowserServiceCompatApi21.onCreate(object0);
        }

        @Override  // androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
        public androidx.media.MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String s, int v, Bundle bundle0) {
            Bundle bundle1;
            if(bundle0 == null || bundle0.getInt("extra_client_version", 0) == 0) {
                bundle1 = null;
            }
            else {
                bundle0.remove("extra_client_version");
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                bundle1 = new Bundle();
                bundle1.putInt("extra_service_version", 2);
                BundleCompat.putBinder(bundle1, "extra_messenger", this.mMessenger.getBinder());
                if(MediaBrowserServiceCompat.this.mSession == null) {
                    this.mRootExtrasList.add(bundle1);
                }
                else {
                    IMediaSession iMediaSession0 = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
                    BundleCompat.putBinder(bundle1, "extra_session_binder", (iMediaSession0 == null ? null : iMediaSession0.asBinder()));
                }
            }
            MediaBrowserServiceCompat.this.mCurConnection = new ConnectionRecord(MediaBrowserServiceCompat.this, s, -1, v, bundle0, null);
            BrowserRoot mediaBrowserServiceCompat$BrowserRoot0 = MediaBrowserServiceCompat.this.onGetRoot(s, v, bundle0);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if(mediaBrowserServiceCompat$BrowserRoot0 == null) {
                return null;
            }
            if(bundle1 == null) {
                return new androidx.media.MediaBrowserServiceCompatApi21.BrowserRoot(mediaBrowserServiceCompat$BrowserRoot0.getRootId(), mediaBrowserServiceCompat$BrowserRoot0.getExtras());
            }
            if(mediaBrowserServiceCompat$BrowserRoot0.getExtras() != null) {
                bundle1.putAll(mediaBrowserServiceCompat$BrowserRoot0.getExtras());
            }
            return new androidx.media.MediaBrowserServiceCompatApi21.BrowserRoot(mediaBrowserServiceCompat$BrowserRoot0.getRootId(), bundle1);
        }

        @Override  // androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
        public void onLoadChildren(String s, ResultWrapper mediaBrowserServiceCompatApi21$ResultWrapper0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$20 = new Result(s) {
                @Override  // androidx.media.MediaBrowserServiceCompat$Result
                public void detach() {
                    mediaBrowserServiceCompatApi21$ResultWrapper0.detach();
                }

                @Override  // androidx.media.MediaBrowserServiceCompat$Result
                void onResultSent(Object object0) {
                    this.onResultSent(((List)object0));
                }

                void onResultSent(List list0) {
                    ArrayList arrayList0;
                    if(list0 == null) {
                        arrayList0 = null;
                    }
                    else {
                        arrayList0 = new ArrayList();
                        for(Object object0: list0) {
                            Parcel parcel0 = Parcel.obtain();
                            ((MediaItem)object0).writeToParcel(parcel0, 0);
                            arrayList0.add(parcel0);
                        }
                    }
                    mediaBrowserServiceCompatApi21$ResultWrapper0.sendResult(arrayList0);
                }
            };
            MediaBrowserServiceCompat.this.onLoadChildren(s, mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$20);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void setSessionToken(Token mediaSessionCompat$Token0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$10 = new Runnable() {
                @Override
                public void run() {
                    if(!MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                        IMediaSession iMediaSession0 = mediaSessionCompat$Token0.getExtraBinder();
                        if(iMediaSession0 != null) {
                            for(Object object0: MediaBrowserServiceImplApi21.this.mRootExtrasList) {
                                BundleCompat.putBinder(((Bundle)object0), "extra_session_binder", iMediaSession0.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.mServiceObj, mediaSessionCompat$Token0.getToken());
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$10);
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override  // androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
        public void onLoadItem(String s, ResultWrapper mediaBrowserServiceCompatApi21$ResultWrapper0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$10 = new Result(s) {
                @Override  // androidx.media.MediaBrowserServiceCompat$Result
                public void detach() {
                    mediaBrowserServiceCompatApi21$ResultWrapper0.detach();
                }

                void onResultSent(MediaItem mediaBrowserCompat$MediaItem0) {
                    if(mediaBrowserCompat$MediaItem0 == null) {
                        mediaBrowserServiceCompatApi21$ResultWrapper0.sendResult(null);
                        return;
                    }
                    Parcel parcel0 = Parcel.obtain();
                    mediaBrowserCompat$MediaItem0.writeToParcel(parcel0, 0);
                    mediaBrowserServiceCompatApi21$ResultWrapper0.sendResult(parcel0);
                }

                @Override  // androidx.media.MediaBrowserServiceCompat$Result
                void onResultSent(Object object0) {
                    this.onResultSent(((MediaItem)object0));
                }
            };
            MediaBrowserServiceCompat.this.onLoadItem(s, mediaBrowserServiceCompat$MediaBrowserServiceImplApi23$10);
        }
    }

    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
        public Bundle getBrowserRootHints() {
            if(MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
        void notifyChildrenChangedForFramework(String s, Bundle bundle0) {
            if(bundle0 != null) {
                MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, s, bundle0);
                return;
            }
            super.notifyChildrenChangedForFramework(s, null);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override  // androidx.media.MediaBrowserServiceCompatApi26$ServiceCompatProxy
        public void onLoadChildren(String s, androidx.media.MediaBrowserServiceCompatApi26.ResultWrapper mediaBrowserServiceCompatApi26$ResultWrapper0, Bundle bundle0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$10 = new Result(s) {
                @Override  // androidx.media.MediaBrowserServiceCompat$Result
                public void detach() {
                    mediaBrowserServiceCompatApi26$ResultWrapper0.detach();
                }

                @Override  // androidx.media.MediaBrowserServiceCompat$Result
                void onResultSent(Object object0) {
                    this.onResultSent(((List)object0));
                }

                void onResultSent(List list0) {
                    ArrayList arrayList0;
                    if(list0 == null) {
                        arrayList0 = null;
                    }
                    else {
                        arrayList0 = new ArrayList();
                        for(Object object0: list0) {
                            Parcel parcel0 = Parcel.obtain();
                            ((MediaItem)object0).writeToParcel(parcel0, 0);
                            arrayList0.add(parcel0);
                        }
                    }
                    int v = this.getFlags();
                    mediaBrowserServiceCompatApi26$ResultWrapper0.sendResult(arrayList0, v);
                }
            };
            MediaBrowserServiceCompat.this.onLoadChildren(s, mediaBrowserServiceCompat$MediaBrowserServiceImplApi26$10, bundle0);
        }
    }

    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
        public RemoteUserInfo getCurrentBrowserInfo() {
            return MediaBrowserServiceCompat.this.mCurConnection == null ? new RemoteUserInfo(((MediaBrowserService)this.mServiceObj).getCurrentBrowserInfo()) : MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.rootHints == null ? null : new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public RemoteUserInfo getCurrentBrowserInfo() {
            if(MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void notifyChildrenChanged(RemoteUserInfo mediaSessionManager$RemoteUserInfo0, String s, Bundle bundle0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.3 mediaBrowserServiceCompat$MediaBrowserServiceImplBase$30 = new Runnable() {
                @Override
                public void run() {
                    for(int v = 0; v < MediaBrowserServiceCompat.this.mConnections.size(); ++v) {
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(v);
                        if(mediaBrowserServiceCompat$ConnectionRecord0.browserInfo.equals(mediaSessionManager$RemoteUserInfo0)) {
                            MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(mediaBrowserServiceCompat$ConnectionRecord0, s, bundle0);
                            return;
                        }
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplBase$30);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void notifyChildrenChanged(String s, Bundle bundle0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2 mediaBrowserServiceCompat$MediaBrowserServiceImplBase$20 = new Runnable() {
                @Override
                public void run() {
                    for(Object object0: MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(((IBinder)object0));
                        MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(mediaBrowserServiceCompat$ConnectionRecord0, s, bundle0);
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplBase$20);
        }

        void notifyChildrenChangedOnHandler(ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, String s, Bundle bundle0) {
            List list0 = (List)mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.get(s);
            if(list0 != null) {
                for(Object object0: list0) {
                    Pair pair0 = (Pair)object0;
                    if(MediaBrowserCompatUtils.hasDuplicatedItems(bundle0, ((Bundle)pair0.second))) {
                        MediaBrowserServiceCompat.this.performLoadChildren(s, mediaBrowserServiceCompat$ConnectionRecord0, ((Bundle)pair0.second), bundle0);
                    }
                }
            }
        }

        // 去混淆评级： 低(20)
        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public IBinder onBind(Intent intent0) {
            return "android.media.browse.MediaBrowserService".equals(intent0.getAction()) ? this.mMessenger.getBinder() : null;
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
        public void setSessionToken(Token mediaSessionCompat$Token0) {
            androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1 mediaBrowserServiceCompat$MediaBrowserServiceImplBase$10 = new Runnable() {
                @Override
                public void run() {
                    Iterator iterator0 = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)object0;
                        try {
                            mediaBrowserServiceCompat$ConnectionRecord0.callbacks.onConnect(mediaBrowserServiceCompat$ConnectionRecord0.root.getRootId(), mediaSessionCompat$Token0, mediaBrowserServiceCompat$ConnectionRecord0.root.getExtras());
                        }
                        catch(RemoteException unused_ex) {
                            Log.w("MBServiceCompat", "Connection for " + mediaBrowserServiceCompat$ConnectionRecord0.pkg + " is no longer valid.");
                            iterator0.remove();
                        }
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplBase$10);
        }
    }

    public static class Result {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object object0) {
            this.mDebug = object0;
        }

        private void checkExtraFields(Bundle bundle0) {
            if(bundle0 == null) {
                return;
            }
            if(bundle0.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS")) {
                float f = bundle0.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
                if(f < -0.00001f || f > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void detach() {
            if(this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
            if(this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }
            if(this.mSendErrorCalled) {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
            }
            this.mDetachCalled = true;
        }

        int getFlags() {
            return this.mFlags;
        }

        // 去混淆评级： 低(30)
        boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        void onErrorSent(Bundle bundle0) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        void onProgressUpdateSent(Bundle bundle0) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onResultSent(Object object0) {
        }

        public void sendError(Bundle bundle0) {
            if(this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendErrorCalled = true;
            this.onErrorSent(bundle0);
        }

        public void sendProgressUpdate(Bundle bundle0) {
            if(this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.checkExtraFields(bundle0);
            this.mSendProgressUpdateCalled = true;
            this.onProgressUpdateSent(bundle0);
        }

        public void sendResult(Object object0) {
            if(this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            this.onResultSent(object0);
        }

        void setFlags(int v) {
            this.mFlags = v;
        }
    }

    class ServiceBinderImpl {
        public void addSubscription(String s, IBinder iBinder0, Bundle bundle0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3 mediaBrowserServiceCompat$ServiceBinderImpl$30 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                    ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(iBinder0);
                    if(mediaBrowserServiceCompat$ConnectionRecord0 == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn\'t registered id=" + s);
                        return;
                    }
                    MediaBrowserServiceCompat.this.addSubscription(s, mediaBrowserServiceCompat$ConnectionRecord0, iBinder0, bundle0);
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$30);
        }

        public void connect(String s, int v, int v1, Bundle bundle0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            if(!MediaBrowserServiceCompat.this.isValidPackage(s, v1)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + v1 + " package=" + s);
            }
            androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1 mediaBrowserServiceCompat$ServiceBinderImpl$10 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(iBinder0);
                    ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = new ConnectionRecord(MediaBrowserServiceCompat.this, s, v, v1, bundle0, mediaBrowserServiceCompat$ServiceCallbacks0);
                    MediaBrowserServiceCompat.this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord0;
                    mediaBrowserServiceCompat$ConnectionRecord0.root = MediaBrowserServiceCompat.this.onGetRoot(s, v1, bundle0);
                    MediaBrowserServiceCompat.this.mCurConnection = null;
                    if(mediaBrowserServiceCompat$ConnectionRecord0.root == null) {
                        Log.i("MBServiceCompat", "No root for client " + s + " from service " + this.getClass().getName());
                        try {
                            mediaBrowserServiceCompat$ServiceCallbacks0.onConnectFailed();
                        }
                        catch(RemoteException unused_ex) {
                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + s);
                        }
                        return;
                    }
                    try {
                        MediaBrowserServiceCompat.this.mConnections.put(iBinder0, mediaBrowserServiceCompat$ConnectionRecord0);
                        iBinder0.linkToDeath(mediaBrowserServiceCompat$ConnectionRecord0, 0);
                        if(MediaBrowserServiceCompat.this.mSession != null) {
                            mediaBrowserServiceCompat$ServiceCallbacks0.onConnect(mediaBrowserServiceCompat$ConnectionRecord0.root.getRootId(), MediaBrowserServiceCompat.this.mSession, mediaBrowserServiceCompat$ConnectionRecord0.root.getExtras());
                        }
                    }
                    catch(RemoteException unused_ex) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + s);
                        MediaBrowserServiceCompat.this.mConnections.remove(iBinder0);
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$10);
        }

        public void disconnect(ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2 mediaBrowserServiceCompat$ServiceBinderImpl$20 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                    ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(iBinder0);
                    if(mediaBrowserServiceCompat$ConnectionRecord0 != null) {
                        mediaBrowserServiceCompat$ConnectionRecord0.callbacks.asBinder().unlinkToDeath(mediaBrowserServiceCompat$ConnectionRecord0, 0);
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$20);
        }

        public void getMediaItem(String s, ResultReceiver resultReceiver0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            if(!TextUtils.isEmpty(s) && resultReceiver0 != null) {
                androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5 mediaBrowserServiceCompat$ServiceBinderImpl$50 = new Runnable() {
                    @Override
                    public void run() {
                        IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(iBinder0);
                        if(mediaBrowserServiceCompat$ConnectionRecord0 == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn\'t registered id=" + s);
                            return;
                        }
                        MediaBrowserServiceCompat.this.performLoadItem(s, mediaBrowserServiceCompat$ConnectionRecord0, resultReceiver0);
                    }
                };
                MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$50);
            }
        }

        public void registerCallbacks(ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0, String s, int v, int v1, Bundle bundle0) {
            androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6 mediaBrowserServiceCompat$ServiceBinderImpl$60 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(iBinder0);
                    ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = new ConnectionRecord(MediaBrowserServiceCompat.this, s, v, v1, bundle0, mediaBrowserServiceCompat$ServiceCallbacks0);
                    MediaBrowserServiceCompat.this.mConnections.put(iBinder0, mediaBrowserServiceCompat$ConnectionRecord0);
                    try {
                        iBinder0.linkToDeath(mediaBrowserServiceCompat$ConnectionRecord0, 0);
                    }
                    catch(RemoteException unused_ex) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$60);
        }

        public void removeSubscription(String s, IBinder iBinder0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4 mediaBrowserServiceCompat$ServiceBinderImpl$40 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                    ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(iBinder0);
                    if(mediaBrowserServiceCompat$ConnectionRecord0 == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn\'t registered id=" + s);
                        return;
                    }
                    if(!MediaBrowserServiceCompat.this.removeSubscription(s, mediaBrowserServiceCompat$ConnectionRecord0, iBinder0)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + s + " which is not subscribed");
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$40);
        }

        public void search(String s, Bundle bundle0, ResultReceiver resultReceiver0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            if(!TextUtils.isEmpty(s) && resultReceiver0 != null) {
                androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8 mediaBrowserServiceCompat$ServiceBinderImpl$80 = new Runnable() {
                    @Override
                    public void run() {
                        IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(iBinder0);
                        if(mediaBrowserServiceCompat$ConnectionRecord0 == null) {
                            Log.w("MBServiceCompat", "search for callback that isn\'t registered query=" + s);
                            return;
                        }
                        MediaBrowserServiceCompat.this.performSearch(s, bundle0, mediaBrowserServiceCompat$ConnectionRecord0, resultReceiver0);
                    }
                };
                MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$80);
            }
        }

        public void sendCustomAction(String s, Bundle bundle0, ResultReceiver resultReceiver0, ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            if(!TextUtils.isEmpty(s) && resultReceiver0 != null) {
                androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9 mediaBrowserServiceCompat$ServiceBinderImpl$90 = new Runnable() {
                    @Override
                    public void run() {
                        IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                        ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(iBinder0);
                        if(mediaBrowserServiceCompat$ConnectionRecord0 == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn\'t registered action=" + s + ", extras=" + bundle0);
                            return;
                        }
                        MediaBrowserServiceCompat.this.performCustomAction(s, bundle0, mediaBrowserServiceCompat$ConnectionRecord0, resultReceiver0);
                    }
                };
                MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$90);
            }
        }

        public void unregisterCallbacks(ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks0) {
            androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7 mediaBrowserServiceCompat$ServiceBinderImpl$70 = new Runnable() {
                @Override
                public void run() {
                    IBinder iBinder0 = mediaBrowserServiceCompat$ServiceCallbacks0.asBinder();
                    ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0 = (ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(iBinder0);
                    if(mediaBrowserServiceCompat$ConnectionRecord0 != null) {
                        iBinder0.unlinkToDeath(mediaBrowserServiceCompat$ConnectionRecord0, 0);
                    }
                }
            };
            MediaBrowserServiceCompat.this.mHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$70);
        }
    }

    interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String arg1, Token arg2, Bundle arg3) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String arg1, List arg2, Bundle arg3, Bundle arg4) throws RemoteException;
    }

    static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger messenger0) {
            this.mCallbacks = messenger0;
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
        public void onConnect(String s, Token mediaSessionCompat$Token0, Bundle bundle0) throws RemoteException {
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putInt("extra_service_version", 2);
            Bundle bundle1 = new Bundle();
            bundle1.putString("data_media_item_id", s);
            bundle1.putParcelable("data_media_session_token", mediaSessionCompat$Token0);
            bundle1.putBundle("data_root_hints", bundle0);
            this.sendRequest(1, bundle1);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            this.sendRequest(2, null);
        }

        @Override  // androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
        public void onLoadChildren(String s, List list0, Bundle bundle0, Bundle bundle1) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", s);
            bundle2.putBundle("data_options", bundle0);
            bundle2.putBundle("data_notify_children_changed_options", bundle1);
            if(list0 != null) {
                bundle2.putParcelableArrayList("data_media_item_list", (list0 instanceof ArrayList ? ((ArrayList)list0) : new ArrayList(list0)));
            }
            this.sendRequest(3, bundle2);
        }

        private void sendRequest(int v, Bundle bundle0) throws RemoteException {
            Message message0 = Message.obtain();
            message0.what = v;
            message0.arg1 = 2;
            message0.setData(bundle0);
            this.mCallbacks.send(message0);
        }
    }

    final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;

        ServiceHandler() {
            this.mServiceBinderImpl = new ServiceBinderImpl(mediaBrowserServiceCompat0);
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            Bundle bundle0 = message0.getData();
            switch(message0.what) {
                case 1: {
                    Bundle bundle1 = bundle0.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle1);
                    String s = bundle0.getString("data_package_name");
                    int v = bundle0.getInt("data_calling_pid");
                    int v1 = bundle0.getInt("data_calling_uid");
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat0 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.connect(s, v, v1, bundle1, mediaBrowserServiceCompat$ServiceCallbacksCompat0);
                    return;
                }
                case 2: {
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat1 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.disconnect(mediaBrowserServiceCompat$ServiceCallbacksCompat1);
                    return;
                }
                case 3: {
                    Bundle bundle2 = bundle0.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    String s1 = bundle0.getString("data_media_item_id");
                    IBinder iBinder0 = BundleCompat.getBinder(bundle0, "data_callback_token");
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat2 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.addSubscription(s1, iBinder0, bundle2, mediaBrowserServiceCompat$ServiceCallbacksCompat2);
                    return;
                }
                case 4: {
                    String s2 = bundle0.getString("data_media_item_id");
                    IBinder iBinder1 = BundleCompat.getBinder(bundle0, "data_callback_token");
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat3 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.removeSubscription(s2, iBinder1, mediaBrowserServiceCompat$ServiceCallbacksCompat3);
                    return;
                }
                case 5: {
                    String s3 = bundle0.getString("data_media_item_id");
                    ResultReceiver resultReceiver0 = (ResultReceiver)bundle0.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat4 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.getMediaItem(s3, resultReceiver0, mediaBrowserServiceCompat$ServiceCallbacksCompat4);
                    return;
                }
                case 6: {
                    Bundle bundle3 = bundle0.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat5 = new ServiceCallbacksCompat(message0.replyTo);
                    String s4 = bundle0.getString("data_package_name");
                    int v2 = bundle0.getInt("data_calling_pid");
                    int v3 = bundle0.getInt("data_calling_uid");
                    this.mServiceBinderImpl.registerCallbacks(mediaBrowserServiceCompat$ServiceCallbacksCompat5, s4, v2, v3, bundle3);
                    return;
                }
                case 7: {
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat6 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.unregisterCallbacks(mediaBrowserServiceCompat$ServiceCallbacksCompat6);
                    return;
                }
                case 8: {
                    Bundle bundle4 = bundle0.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    String s5 = bundle0.getString("data_search_query");
                    ResultReceiver resultReceiver1 = (ResultReceiver)bundle0.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat7 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.search(s5, bundle4, resultReceiver1, mediaBrowserServiceCompat$ServiceCallbacksCompat7);
                    return;
                }
                case 9: {
                    Bundle bundle5 = bundle0.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    String s6 = bundle0.getString("data_custom_action");
                    ResultReceiver resultReceiver2 = (ResultReceiver)bundle0.getParcelable("data_result_receiver");
                    ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat8 = new ServiceCallbacksCompat(message0.replyTo);
                    this.mServiceBinderImpl.sendCustomAction(s6, bundle5, resultReceiver2, mediaBrowserServiceCompat$ServiceCallbacksCompat8);
                    return;
                }
                default: {
                    Log.w("MBServiceCompat", "Unhandled message: " + message0 + "\n  Service version: 2\n  Client version: " + message0.arg1);
                }
            }
        }

        public void postOrRun(Runnable runnable0) {
            if(Thread.currentThread() == this.getLooper().getThread()) {
                runnable0.run();
                return;
            }
            this.post(runnable0);
        }

        @Override  // android.os.Handler
        public boolean sendMessageAtTime(Message message0, long v) {
            Bundle bundle0 = message0.getData();
            bundle0.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            bundle0.putInt("data_calling_uid", Binder.getCallingUid());
            bundle0.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message0, v);
        }
    }

    static final boolean DEBUG = false;
    private static final float EPSILON = 0.00001f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap mConnections;
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler;
    private MediaBrowserServiceImpl mImpl;
    Token mSession;

    static {
        MediaBrowserServiceCompat.DEBUG = Log.isLoggable("MBServiceCompat", 3);
    }

    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler(this);
    }

    void addSubscription(String s, ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, IBinder iBinder0, Bundle bundle0) {
        List list0 = (List)mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.get(s);
        if(list0 == null) {
            list0 = new ArrayList();
        }
        for(Object object0: list0) {
            if(iBinder0 == ((Pair)object0).first && MediaBrowserCompatUtils.areSameOptions(bundle0, ((Bundle)((Pair)object0).second))) {
                return;
            }
            if(false) {
                break;
            }
        }
        list0.add(new Pair(iBinder0, bundle0));
        mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.put(s, list0);
        this.performLoadChildren(s, mediaBrowserServiceCompat$ConnectionRecord0, bundle0, null);
        this.mCurConnection = null;
    }

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

    public void attachToBaseContext(Context context0) {
        this.attachBaseContext(context0);
    }

    @Override  // android.app.Service
    public void dump(FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String s, int v) {
        if(s == null) {
            return false;
        }
        String[] arr_s = this.getPackageManager().getPackagesForUid(v);
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            if(arr_s[v1].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void notifyChildrenChanged(RemoteUserInfo mediaSessionManager$RemoteUserInfo0, String s, Bundle bundle0) {
        if(mediaSessionManager$RemoteUserInfo0 == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if(s == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if(bundle0 == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(mediaSessionManager$RemoteUserInfo0, s, bundle0);
    }

    public void notifyChildrenChanged(String s) {
        if(s == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(s, null);
    }

    public void notifyChildrenChanged(String s, Bundle bundle0) {
        if(s == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if(bundle0 == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(s, bundle0);
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        return this.mImpl.onBind(intent0);
    }

    @Override  // android.app.Service
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaBrowserServiceImplApi28(this);
        }
        else if(Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi26(this);
        }
        else {
            this.mImpl = new MediaBrowserServiceImplApi23(this);
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(String s, Bundle bundle0, Result mediaBrowserServiceCompat$Result0) {
        mediaBrowserServiceCompat$Result0.sendError(null);
    }

    public abstract BrowserRoot onGetRoot(String arg1, int arg2, Bundle arg3);

    public abstract void onLoadChildren(String arg1, Result arg2);

    public void onLoadChildren(String s, Result mediaBrowserServiceCompat$Result0, Bundle bundle0) {
        mediaBrowserServiceCompat$Result0.setFlags(1);
        this.onLoadChildren(s, mediaBrowserServiceCompat$Result0);
    }

    public void onLoadItem(String s, Result mediaBrowserServiceCompat$Result0) {
        mediaBrowserServiceCompat$Result0.setFlags(2);
        mediaBrowserServiceCompat$Result0.sendResult(null);
    }

    public void onSearch(String s, Bundle bundle0, Result mediaBrowserServiceCompat$Result0) {
        mediaBrowserServiceCompat$Result0.setFlags(4);
        mediaBrowserServiceCompat$Result0.sendResult(null);
    }

    public void onSubscribe(String s, Bundle bundle0) {
    }

    public void onUnsubscribe(String s) {
    }

    void performCustomAction(String s, Bundle bundle0, ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, ResultReceiver resultReceiver0) {
        androidx.media.MediaBrowserServiceCompat.4 mediaBrowserServiceCompat$40 = new Result(s) {
            @Override  // androidx.media.MediaBrowserServiceCompat$Result
            void onErrorSent(Bundle bundle0) {
                resultReceiver0.send(-1, bundle0);
            }

            @Override  // androidx.media.MediaBrowserServiceCompat$Result
            void onProgressUpdateSent(Bundle bundle0) {
                resultReceiver0.send(1, bundle0);
            }

            void onResultSent(Bundle bundle0) {
                resultReceiver0.send(0, bundle0);
            }

            @Override  // androidx.media.MediaBrowserServiceCompat$Result
            void onResultSent(Object object0) {
                this.onResultSent(((Bundle)object0));
            }
        };
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord0;
        this.onCustomAction(s, bundle0, mediaBrowserServiceCompat$40);
        this.mCurConnection = null;
        if(!mediaBrowserServiceCompat$40.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + s + " extras=" + bundle0);
        }
    }

    void performLoadChildren(String s, ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, Bundle bundle0, Bundle bundle1) {
        androidx.media.MediaBrowserServiceCompat.1 mediaBrowserServiceCompat$10 = new Result(s) {
            @Override  // androidx.media.MediaBrowserServiceCompat$Result
            void onResultSent(Object object0) {
                this.onResultSent(((List)object0));
            }

            void onResultSent(List list0) {
                IBinder iBinder0 = mediaBrowserServiceCompat$ConnectionRecord0.callbacks.asBinder();
                if(MediaBrowserServiceCompat.this.mConnections.get(iBinder0) != mediaBrowserServiceCompat$ConnectionRecord0) {
                    if(MediaBrowserServiceCompat.DEBUG) {
                        Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + mediaBrowserServiceCompat$ConnectionRecord0.pkg + " id=" + s);
                    }
                    return;
                }
                if((this.getFlags() & 1) != 0) {
                    list0 = MediaBrowserServiceCompat.this.applyOptions(list0, bundle0);
                }
                try {
                    mediaBrowserServiceCompat$ConnectionRecord0.callbacks.onLoadChildren(s, list0, bundle0, bundle1);
                }
                catch(RemoteException unused_ex) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + s + " package=" + mediaBrowserServiceCompat$ConnectionRecord0.pkg);
                }
            }
        };
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord0;
        if(bundle0 == null) {
            this.onLoadChildren(s, mediaBrowserServiceCompat$10);
        }
        else {
            this.onLoadChildren(s, mediaBrowserServiceCompat$10, bundle0);
        }
        this.mCurConnection = null;
        if(!mediaBrowserServiceCompat$10.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + mediaBrowserServiceCompat$ConnectionRecord0.pkg + " id=" + s);
        }
    }

    void performLoadItem(String s, ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, ResultReceiver resultReceiver0) {
        androidx.media.MediaBrowserServiceCompat.2 mediaBrowserServiceCompat$20 = new Result(s) {
            void onResultSent(MediaItem mediaBrowserCompat$MediaItem0) {
                if((this.getFlags() & 2) != 0) {
                    resultReceiver0.send(-1, null);
                    return;
                }
                Bundle bundle0 = new Bundle();
                bundle0.putParcelable("media_item", mediaBrowserCompat$MediaItem0);
                resultReceiver0.send(0, bundle0);
            }

            @Override  // androidx.media.MediaBrowserServiceCompat$Result
            void onResultSent(Object object0) {
                this.onResultSent(((MediaItem)object0));
            }
        };
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord0;
        this.onLoadItem(s, mediaBrowserServiceCompat$20);
        this.mCurConnection = null;
        if(!mediaBrowserServiceCompat$20.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + s);
        }
    }

    void performSearch(String s, Bundle bundle0, ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, ResultReceiver resultReceiver0) {
        androidx.media.MediaBrowserServiceCompat.3 mediaBrowserServiceCompat$30 = new Result(s) {
            @Override  // androidx.media.MediaBrowserServiceCompat$Result
            void onResultSent(Object object0) {
                this.onResultSent(((List)object0));
            }

            void onResultSent(List list0) {
                if((this.getFlags() & 4) == 0 && list0 != null) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putParcelableArray("search_results", ((Parcelable[])list0.toArray(new MediaItem[0])));
                    resultReceiver0.send(0, bundle0);
                    return;
                }
                resultReceiver0.send(-1, null);
            }
        };
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord0;
        this.onSearch(s, bundle0, mediaBrowserServiceCompat$30);
        this.mCurConnection = null;
        if(!mediaBrowserServiceCompat$30.isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + s);
        }
    }

    boolean removeSubscription(String s, ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord0, IBinder iBinder0) {
        try {
            boolean z = true;
            boolean z1 = false;
            if(iBinder0 == null) {
                if(mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.remove(s) == null) {
                    z = false;
                }
                return z;
            }
            List list0 = (List)mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.get(s);
            if(list0 != null) {
                Iterator iterator0 = list0.iterator();
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    if(iBinder0 == ((Pair)object0).first) {
                        iterator0.remove();
                        z1 = true;
                    }
                }
                if(list0.size() == 0) {
                    mediaBrowserServiceCompat$ConnectionRecord0.subscriptions.remove(s);
                }
            }
            return z1;
        }
        finally {
            this.mCurConnection = null;
        }
    }

    public void setSessionToken(Token mediaSessionCompat$Token0) {
        if(mediaSessionCompat$Token0 == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if(this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = mediaSessionCompat$Token0;
        this.mImpl.setSessionToken(mediaSessionCompat$Token0);
    }
}

