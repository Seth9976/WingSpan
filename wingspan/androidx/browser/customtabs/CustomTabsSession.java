package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService.Stub;
import android.support.customtabs.ICustomTabsService;
import android.widget.RemoteViews;
import java.util.List;

public final class CustomTabsSession {
    static class MockSession extends Stub {
        @Override  // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String commandName, Bundle args) throws RemoteException {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List otherLikelyBundles) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback callback) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
            return 0;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean warmup(long flags) throws RemoteException {
            return false;
        }
    }

    public static class PendingSession {
        private final CustomTabsCallback mCallback;
        private final PendingIntent mId;

        PendingSession(CustomTabsCallback callback, PendingIntent sessionId) {
            this.mCallback = callback;
            this.mId = sessionId;
        }

        CustomTabsCallback getCallback() {
            return this.mCallback;
        }

        PendingIntent getId() {
            return this.mId;
        }
    }

    private static final String TAG = "CustomTabsSession";
    private final ICustomTabsCallback mCallback;
    private final ComponentName mComponentName;
    private final PendingIntent mId;
    private final Object mLock;
    private final ICustomTabsService mService;

    CustomTabsSession(ICustomTabsService service, ICustomTabsCallback callback, ComponentName componentName, PendingIntent sessionId) {
        this.mLock = new Object();
        this.mService = service;
        this.mCallback = callback;
        this.mComponentName = componentName;
        this.mId = sessionId;
    }

    private void addIdToBundle(Bundle bundle) {
        PendingIntent pendingIntent0 = this.mId;
        if(pendingIntent0 != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent0);
        }
    }

    private Bundle createBundleWithId(Bundle bundle) {
        Bundle bundle1 = new Bundle();
        if(bundle != null) {
            bundle1.putAll(bundle);
        }
        this.addIdToBundle(bundle1);
        return bundle1;
    }

    public static CustomTabsSession createMockSessionForTesting(ComponentName componentName) {
        return new CustomTabsSession(new MockSession(), new MockCallback(), componentName, null);
    }

    IBinder getBinder() {
        return this.mCallback.asBinder();
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    PendingIntent getId() {
        return this.mId;
    }

    public boolean mayLaunchUrl(Uri url, Bundle extras, List otherLikelyBundles) {
        Bundle bundle1 = this.createBundleWithId(extras);
        try {
            return this.mService.mayLaunchUrl(this.mCallback, url, bundle1, otherLikelyBundles);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    public int postMessage(String message, Bundle extras) {
        Bundle bundle1 = this.createBundleWithId(extras);
        synchronized(this.mLock) {
            try {
                return this.mService.postMessage(this.mCallback, message, bundle1);
            }
            catch(RemoteException unused_ex) {
                return -2;
            }
        }
    }

    public boolean receiveFile(Uri uri, int purpose, Bundle extras) {
        Bundle bundle1 = this.createBundleWithId(extras);
        try {
            return this.mService.receiveFile(this.mCallback, uri, purpose, bundle1);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    public boolean requestPostMessageChannel(Uri postMessageOrigin) {
        try {
            if(this.mId != null) {
                Bundle bundle0 = this.createBundleWithId(null);
                return this.mService.requestPostMessageChannelWithExtras(this.mCallback, postMessageOrigin, bundle0);
            }
            return this.mService.requestPostMessageChannel(this.mCallback, postMessageOrigin);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    public boolean setActionButton(Bitmap icon, String description) {
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("android.support.customtabs.customaction.ICON", icon);
        bundle0.putString("android.support.customtabs.customaction.DESCRIPTION", description);
        Bundle bundle1 = new Bundle();
        bundle1.putBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle0);
        this.addIdToBundle(bundle0);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle1);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    public boolean setSecondaryToolbarViews(RemoteViews remoteViews, int[] clickableIDs, PendingIntent pendingIntent) {
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", remoteViews);
        bundle0.putIntArray("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", clickableIDs);
        bundle0.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", pendingIntent);
        this.addIdToBundle(bundle0);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle0);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    @Deprecated
    public boolean setToolbarItem(int id, Bitmap icon, String description) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("android.support.customtabs.customaction.ID", id);
        bundle0.putParcelable("android.support.customtabs.customaction.ICON", icon);
        bundle0.putString("android.support.customtabs.customaction.DESCRIPTION", description);
        Bundle bundle1 = new Bundle();
        bundle1.putBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle0);
        this.addIdToBundle(bundle1);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle1);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    public boolean validateRelationship(int relation, Uri origin, Bundle extras) {
        if(relation >= 1 && relation <= 2) {
            Bundle bundle1 = this.createBundleWithId(extras);
            try {
                return this.mService.validateRelationship(this.mCallback, relation, origin, bundle1);
            }
            catch(RemoteException unused_ex) {
            }
        }
        return false;
    }
}

