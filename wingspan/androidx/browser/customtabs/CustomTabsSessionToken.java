package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback.Stub;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;
import androidx.core.app.BundleCompat;

public class CustomTabsSessionToken {
    static class MockCallback extends Stub {
        @Override  // android.support.customtabs.ICustomTabsCallback$Stub
        public IBinder asBinder() {
            return this;
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String callbackName, Bundle args) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String callbackName, Bundle args) {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle extras) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int navigationEvent, Bundle extras) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String message, Bundle extras) {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int relation, Uri requestedOrigin, boolean result, Bundle extras) {
        }
    }

    private static final String TAG = "CustomTabsSessionToken";
    private final CustomTabsCallback mCallback;
    final ICustomTabsCallback mCallbackBinder;
    private final PendingIntent mSessionId;

    CustomTabsSessionToken(ICustomTabsCallback callbackBinder, PendingIntent sessionId) {
        if(callbackBinder == null && sessionId == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.mCallbackBinder = callbackBinder;
        this.mSessionId = sessionId;
        this.mCallback = callbackBinder == null ? null : new CustomTabsCallback() {
            @Override  // androidx.browser.customtabs.CustomTabsCallback
            public void extraCallback(String callbackName, Bundle args) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.extraCallback(callbackName, args);
                }
                catch(RemoteException unused_ex) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override  // androidx.browser.customtabs.CustomTabsCallback
            public Bundle extraCallbackWithResult(String callbackName, Bundle args) {
                try {
                    return CustomTabsSessionToken.this.mCallbackBinder.extraCallbackWithResult(callbackName, args);
                }
                catch(RemoteException unused_ex) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override  // androidx.browser.customtabs.CustomTabsCallback
            public void onMessageChannelReady(Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(extras);
                }
                catch(RemoteException unused_ex) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override  // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int navigationEvent, Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(navigationEvent, extras);
                }
                catch(RemoteException unused_ex) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override  // androidx.browser.customtabs.CustomTabsCallback
            public void onPostMessage(String message, Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(message, extras);
                }
                catch(RemoteException unused_ex) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override  // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int relation, Uri origin, boolean result, Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(relation, origin, result, extras);
                }
                catch(RemoteException unused_ex) {
                    Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), null);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof CustomTabsSessionToken)) {
            return false;
        }
        PendingIntent pendingIntent0 = ((CustomTabsSessionToken)o).getId();
        PendingIntent pendingIntent1 = this.mSessionId;
        if((pendingIntent1 == null ? 1 : 0) != (pendingIntent0 == null ? 1 : 0)) {
            return false;
        }
        return pendingIntent1 == null ? this.getCallbackBinderAssertNotNull().equals(((CustomTabsSessionToken)o).getCallbackBinderAssertNotNull()) : pendingIntent1.equals(pendingIntent0);
    }

    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    IBinder getCallbackBinder() {
        return this.mCallbackBinder == null ? null : this.mCallbackBinder.asBinder();
    }

    private IBinder getCallbackBinderAssertNotNull() {
        ICustomTabsCallback iCustomTabsCallback0 = this.mCallbackBinder;
        if(iCustomTabsCallback0 == null) {
            throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
        }
        return iCustomTabsCallback0.asBinder();
    }

    PendingIntent getId() {
        return this.mSessionId;
    }

    public static CustomTabsSessionToken getSessionTokenFromIntent(Intent intent) {
        Bundle bundle0 = intent.getExtras();
        ICustomTabsCallback iCustomTabsCallback0 = null;
        if(bundle0 == null) {
            return null;
        }
        IBinder iBinder0 = BundleCompat.getBinder(bundle0, "android.support.customtabs.extra.SESSION");
        PendingIntent pendingIntent0 = (PendingIntent)intent.getParcelableExtra("android.support.customtabs.extra.SESSION_ID");
        if(iBinder0 == null && pendingIntent0 == null) {
            return null;
        }
        if(iBinder0 != null) {
            iCustomTabsCallback0 = Stub.asInterface(iBinder0);
        }
        return new CustomTabsSessionToken(iCustomTabsCallback0, pendingIntent0);
    }

    public boolean hasCallback() {
        return this.mCallbackBinder != null;
    }

    public boolean hasId() {
        return this.mSessionId != null;
    }

    @Override
    public int hashCode() {
        return this.mSessionId == null ? this.getCallbackBinderAssertNotNull().hashCode() : this.mSessionId.hashCode();
    }

    public boolean isAssociatedWith(CustomTabsSession session) {
        return session.getBinder().equals(this.mCallbackBinder);
    }
}

