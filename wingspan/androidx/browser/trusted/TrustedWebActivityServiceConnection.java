package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback.Stub;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import android.support.customtabs.trusted.ITrustedWebActivityService;

public final class TrustedWebActivityServiceConnection {
    static class ActiveNotificationsArgs {
        public final Parcelable[] notifications;

        ActiveNotificationsArgs(Parcelable[] notifications) {
            this.notifications = notifications;
        }

        public static ActiveNotificationsArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS");
            return new ActiveNotificationsArgs(bundle.getParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS"));
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", this.notifications);
            return bundle0;
        }
    }

    static class CancelNotificationArgs {
        public final int platformId;
        public final String platformTag;

        CancelNotificationArgs(String platformTag, int platformId) {
            this.platformTag = platformTag;
            this.platformId = platformId;
        }

        public static CancelNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            return new CancelNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putString("android.support.customtabs.trusted.PLATFORM_TAG", this.platformTag);
            bundle0.putInt("android.support.customtabs.trusted.PLATFORM_ID", this.platformId);
            return bundle0;
        }
    }

    static class NotificationsEnabledArgs {
        public final String channelName;

        NotificationsEnabledArgs(String channelName) {
            this.channelName = channelName;
        }

        public static NotificationsEnabledArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotificationsEnabledArgs(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putString("android.support.customtabs.trusted.CHANNEL_NAME", this.channelName);
            return bundle0;
        }
    }

    static class NotifyNotificationArgs {
        public final String channelName;
        public final Notification notification;
        public final int platformId;
        public final String platformTag;

        NotifyNotificationArgs(String platformTag, int platformId, Notification notification, String channelName) {
            this.platformTag = platformTag;
            this.platformId = platformId;
            this.notification = notification;
            this.channelName = channelName;
        }

        public static NotifyNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            return new NotifyNotificationArgs(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), ((Notification)bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION")), bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putString("android.support.customtabs.trusted.PLATFORM_TAG", this.platformTag);
            bundle0.putInt("android.support.customtabs.trusted.PLATFORM_ID", this.platformId);
            bundle0.putParcelable("android.support.customtabs.trusted.NOTIFICATION", this.notification);
            bundle0.putString("android.support.customtabs.trusted.CHANNEL_NAME", this.channelName);
            return bundle0;
        }
    }

    static class ResultArgs {
        public final boolean success;

        ResultArgs(boolean success) {
            this.success = success;
        }

        public static ResultArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION_SUCCESS");
            return new ResultArgs(bundle.getBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS"));
        }

        public Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", this.success);
            return bundle0;
        }
    }

    private static final String KEY_ACTIVE_NOTIFICATIONS = "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS";
    private static final String KEY_CHANNEL_NAME = "android.support.customtabs.trusted.CHANNEL_NAME";
    private static final String KEY_NOTIFICATION = "android.support.customtabs.trusted.NOTIFICATION";
    private static final String KEY_NOTIFICATION_SUCCESS = "android.support.customtabs.trusted.NOTIFICATION_SUCCESS";
    private static final String KEY_PLATFORM_ID = "android.support.customtabs.trusted.PLATFORM_ID";
    private static final String KEY_PLATFORM_TAG = "android.support.customtabs.trusted.PLATFORM_TAG";
    private final ComponentName mComponentName;
    private final ITrustedWebActivityService mService;

    TrustedWebActivityServiceConnection(ITrustedWebActivityService service, ComponentName componentName) {
        this.mService = service;
        this.mComponentName = componentName;
    }

    public boolean areNotificationsEnabled(String channelName) throws RemoteException {
        Bundle bundle0 = new NotificationsEnabledArgs(channelName).toBundle();
        return ResultArgs.fromBundle(this.mService.areNotificationsEnabled(bundle0)).success;
    }

    public void cancel(String platformTag, int platformId) throws RemoteException {
        Bundle bundle0 = new CancelNotificationArgs(platformTag, platformId).toBundle();
        this.mService.cancelNotification(bundle0);
    }

    static void ensureBundleContains(Bundle args, String key) {
        if(!args.containsKey(key)) {
            throw new IllegalArgumentException("Bundle must contain " + key);
        }
    }

    public Parcelable[] getActiveNotifications() throws RemoteException {
        return ActiveNotificationsArgs.fromBundle(this.mService.getActiveNotifications()).notifications;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public Bitmap getSmallIconBitmap() throws RemoteException {
        return (Bitmap)this.mService.getSmallIconBitmap().getParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP");
    }

    public int getSmallIconId() throws RemoteException {
        return this.mService.getSmallIconId();
    }

    public boolean notify(String platformTag, int platformId, Notification notification, String channel) throws RemoteException {
        Bundle bundle0 = new NotifyNotificationArgs(platformTag, platformId, notification, channel).toBundle();
        return ResultArgs.fromBundle(this.mService.notifyNotificationWithChannel(bundle0)).success;
    }

    public Bundle sendExtraCommand(String commandName, Bundle args, TrustedWebActivityCallback callback) throws RemoteException {
        ITrustedWebActivityCallback iTrustedWebActivityCallback0 = TrustedWebActivityServiceConnection.wrapCallback(callback);
        if(iTrustedWebActivityCallback0 == null) {
            return this.mService.extraCommand(commandName, args, null);
        }
        IBinder iBinder0 = iTrustedWebActivityCallback0.asBinder();
        return this.mService.extraCommand(commandName, args, iBinder0);
    }

    private static ITrustedWebActivityCallback wrapCallback(TrustedWebActivityCallback callback) {
        return callback == null ? null : new Stub() {
            @Override  // android.support.customtabs.trusted.ITrustedWebActivityCallback
            public void onExtraCallback(String callbackName, Bundle args) throws RemoteException {
                callback.onExtraCallback(callbackName, args);
            }
        };
    }
}

