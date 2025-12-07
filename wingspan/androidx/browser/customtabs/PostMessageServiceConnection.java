package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback.Stub;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;
import android.util.Log;

public abstract class PostMessageServiceConnection implements ServiceConnection, PostMessageBackend {
    private static final String TAG = "PostMessageServConn";
    private final Object mLock;
    private boolean mMessageChannelCreated;
    private String mPackageName;
    private IPostMessageService mService;
    private final ICustomTabsCallback mSessionBinder;

    public PostMessageServiceConnection(CustomTabsSessionToken session) {
        this.mLock = new Object();
        IBinder iBinder0 = session.getCallbackBinder();
        if(iBinder0 == null) {
            throw new IllegalArgumentException("Provided session must have binder.");
        }
        this.mSessionBinder = Stub.asInterface(iBinder0);
    }

    public boolean bindSessionToPostMessageService(Context appContext) {
        String s = this.mPackageName;
        if(s == null) {
            throw new IllegalStateException("setPackageName must be called before bindSessionToPostMessageService.");
        }
        return this.bindSessionToPostMessageService(appContext, s);
    }

    public boolean bindSessionToPostMessageService(Context context, String packageName) {
        Intent intent0 = new Intent();
        intent0.setClassName(packageName, "androidx.browser.customtabs.PostMessageService");
        boolean z = context.bindService(intent0, this, 1);
        if(!z) {
            Log.w("PostMessageServConn", "Could not bind to PostMessageService in client.");
        }
        return z;
    }

    public void cleanup(Context context) {
        if(this.isBoundToService()) {
            this.unbindFromContext(context);
        }
    }

    private boolean isBoundToService() {
        return this.mService != null;
    }

    public final boolean notifyMessageChannelReady(Bundle extras) {
        this.mMessageChannelCreated = true;
        return this.notifyMessageChannelReadyInternal(extras);
    }

    private boolean notifyMessageChannelReadyInternal(Bundle extras) {
        if(this.mService == null) {
            return false;
        }
        synchronized(this.mLock) {
            try {
                this.mService.onMessageChannelReady(this.mSessionBinder, extras);
                return true;
            }
            catch(RemoteException unused_ex) {
                return false;
            }
        }
    }

    @Override  // androidx.browser.customtabs.PostMessageBackend
    public void onDisconnectChannel(Context appContext) {
        this.unbindFromContext(appContext);
    }

    @Override  // androidx.browser.customtabs.PostMessageBackend
    public final boolean onNotifyMessageChannelReady(Bundle extras) {
        return this.notifyMessageChannelReady(extras);
    }

    @Override  // androidx.browser.customtabs.PostMessageBackend
    public final boolean onPostMessage(String message, Bundle extras) {
        return this.postMessage(message, extras);
    }

    public void onPostMessageServiceConnected() {
        if(this.mMessageChannelCreated) {
            this.notifyMessageChannelReadyInternal(null);
        }
    }

    public void onPostMessageServiceDisconnected() {
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        this.mService = android.support.customtabs.IPostMessageService.Stub.asInterface(service);
        this.onPostMessageServiceConnected();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        this.mService = null;
    }

    public final boolean postMessage(String message, Bundle extras) {
        if(this.mService == null) {
            return false;
        }
        synchronized(this.mLock) {
            try {
                this.mService.onPostMessage(this.mSessionBinder, message, extras);
                return true;
            }
            catch(RemoteException unused_ex) {
                return false;
            }
        }
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public void unbindFromContext(Context context) {
        if(this.isBoundToService()) {
            context.unbindService(this);
            this.mService = null;
        }
    }
}

