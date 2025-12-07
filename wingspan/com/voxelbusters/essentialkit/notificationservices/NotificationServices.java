package com.voxelbusters.essentialkit.notificationservices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationManagerCompat;
import com.voxelbusters.essentialkit.notificationservices.datatypes.CalendarNotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.datatypes.LocationNotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationAccessState;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationSettings;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationType;
import com.voxelbusters.essentialkit.notificationservices.datatypes.TimeIntervalNotificationTrigger;
import com.voxelbusters.essentialkit.notificationservices.fcm.FCM;
import com.voxelbusters.essentialkit.utilities.ApplicationUtil;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.PermissionUtil;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;
import com.voxelbusters.essentialkit.utilities.helpers.interfaces.IPermissionRequestCallback;
import java.util.ArrayList;

public class NotificationServices implements IFeature {
    private final String TAG;
    private AlarmScheduler alarmScheduler;
    private Context context;
    private FCM fcmService;
    public static INotificationReceivedListener listener;
    public static Notification pendingLaunchNotification;
    private NotificationSettings settings;

    public NotificationServices(Context context0) {
        public final class a implements Runnable {
            public a() {
                super();
            }

            @Override
            public final void run() {
                Notification notification0 = NotificationServices.pendingLaunchNotification;
                if(notification0 != null) {
                    NotificationServices.processLaunchNotification(notification0);
                }
            }
        }

        this.TAG = "[Native Plugins : Notification Services]";
        this.context = context0;
        if(ResourcesUtil.getBoolean(context0, "NOTIFICATION_SERVICES_USES_PUSH_NOTIFICATION_SERVICE")) {
            this.fcmService = new FCM(context0);
        }
        else {
            Logger.warning("Push notifications(Remote) are disabled. If you want to enable them, set PushServiceNotificationType to other than None in Essential Kit Settings.");
        }
        this.settings = NotificationSettings.load(context0);
        this.alarmScheduler = new AlarmScheduler(context0);
        this.refreshActiveNotificationsStore();
        new Handler().postDelayed(new a(), 1000L);
    }

    public void UnregisterRemoteNotifications(IUnregisterRemoteNotificationServiceListener iNotificationServices$IUnregisterRemoteNotificationServiceListener0) {
        FCM fCM0 = this.fcmService;
        if(fCM0 != null) {
            fCM0.Unregister(iNotificationServices$IUnregisterRemoteNotificationServiceListener0);
            return;
        }
        iNotificationServices$IUnregisterRemoteNotificationServiceListener0.onFailure("Push notifications are not enabled");
    }

    public boolean areNotificationsAllowedByUser() {
        return NotificationManagerCompat.from(this.context).areNotificationsEnabled();
    }

    public boolean areRemoteNotificationsAvailable() {
        return this.fcmService == null ? false : this.fcmService.isAvailable();
    }

    public boolean areRemoteNotificationsRegistered() {
        return this.fcmService == null ? false : this.fcmService.isRegistered();
    }

    public boolean areSoundsEnabledByUser() {
        NotificationManager notificationManager0 = (NotificationManager)this.context.getSystemService("notification");
        int v = Build.VERSION.SDK_INT < 24 ? 3 : notificationManager0.getImportance();
        return v < 0 || v >= 3;
    }

    public void cancelAllScheduledNotifications() {
        for(Object object0: NotificationStore.getScheduledNotifications(this.context)) {
            this.cancelScheduledNotification(((Notification)object0));
        }
    }

    private void cancelScheduledNotification(Notification notification0) {
        this.alarmScheduler.cancel(notification0);
    }

    public void cancelScheduledNotification(String s) {
        this.alarmScheduler.cancel(s);
    }

    public void clearAllActiveNotifications() {
        NotificationManagerCompat.from(this.context).cancelAll();
        for(Object object0: NotificationStore.getActiveNotifications(this.context)) {
            NotificationStore.deleteActiveNotification(this.context, ((Notification)object0).getPersistenceId());
        }
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Notification Services";
    }

    public NotificationType getNotificationType() {
        return this.settings.getType();
    }

    private Object[] getStatusBarNotifications() {
        Object[] arr_object = ((NotificationManager)this.context.getSystemService("notification")).getActiveNotifications();
        System.out.println("Status bar notifications : " + arr_object.length);
        return arr_object;
    }

    public static void processLaunchNotification(Notification notification0) {
        INotificationReceivedListener iNotificationServices$INotificationReceivedListener0 = NotificationServices.listener;
        if(iNotificationServices$INotificationReceivedListener0 != null) {
            iNotificationServices$INotificationReceivedListener0.onNotificationReceived(notification0);
            notification0 = null;
        }
        NotificationServices.pendingLaunchNotification = notification0;
    }

    public void refreshActiveNotificationsStore() {
        StatusBarNotification[] arr_statusBarNotification = (StatusBarNotification[])this.getStatusBarNotifications();
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            arrayList0.add(String.valueOf(arr_statusBarNotification[v].getId()));
        }
        for(Object object0: NotificationStore.getActiveNotifications(this.context)) {
            Notification notification0 = (Notification)object0;
            if(!arrayList0.contains(notification0.getPersistenceId())) {
                NotificationStore.deleteActiveNotification(this.context, notification0.getPersistenceId());
            }
        }
    }

    public void registerRemoteNotifications(IRegisterRemoteNotificationsListener iNotificationServices$IRegisterRemoteNotificationsListener0) {
        FCM fCM0 = this.fcmService;
        if(fCM0 != null) {
            fCM0.register(iNotificationServices$IRegisterRemoteNotificationsListener0);
            return;
        }
        iNotificationServices$IRegisterRemoteNotificationsListener0.onFailure("Push notifications are not enabled");
    }

    public void requestActiveNotifications(INotificationsRequestListener iNotificationServices$INotificationsRequestListener0) {
        NotificationManager notificationManager0 = (NotificationManager)this.context.getSystemService("notification");
        ArrayList arrayList0 = new ArrayList();
        StatusBarNotification[] arr_statusBarNotification = (StatusBarNotification[])this.getStatusBarNotifications();
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            int v1 = arr_statusBarNotification[v].getId();
            System.out.println("statusBarNotification id : " + v1);
            Notification notification0 = NotificationStore.getActiveNotification(this.context, String.valueOf(v1));
            if(notification0 != null) {
                arrayList0.add(notification0);
            }
        }
        iNotificationServices$INotificationsRequestListener0.onSuccess(arrayList0);
    }

    public void requestNotificationPermissions(IRequestNotificationPermissionsListener iNotificationServices$IRequestNotificationPermissionsListener0) {
        public final class b implements IPermissionRequestCallback {
            public final IRequestNotificationPermissionsListener a;

            public b(IRequestNotificationPermissionsListener iNotificationServices$IRequestNotificationPermissionsListener0) {
            }

            @Override  // com.voxelbusters.essentialkit.utilities.helpers.interfaces.IPermissionRequestCallback
            public final void onPermissionDeny() {
                this.a.onSuccess(NotificationAccessState.Denied);
            }

            @Override  // com.voxelbusters.essentialkit.utilities.helpers.interfaces.IPermissionRequestCallback
            public final void onPermissionGrant() {
                this.a.onSuccess(NotificationAccessState.Authorized);
            }
        }

        if(!NotificationManagerCompat.from(this.context).areNotificationsEnabled() && Build.VERSION.SDK_INT >= 33) {
            PermissionUtil.requestPermission(this.context, "android.permission.POST_NOTIFICATIONS", "Application wants to post notifications", new b(iNotificationServices$IRequestNotificationPermissionsListener0));
            return;
        }
        iNotificationServices$IRequestNotificationPermissionsListener0.onSuccess(NotificationAccessState.Authorized);
    }

    public void requestScheduledNotifications(INotificationsRequestListener iNotificationServices$INotificationsRequestListener0) {
        ArrayList arrayList0 = NotificationStore.getScheduledNotifications(this.context);
        if(iNotificationServices$INotificationsRequestListener0 != null) {
            iNotificationServices$INotificationsRequestListener0.onSuccess(arrayList0);
        }
    }

    public void scheduleNotification(Notification notification0, IScheduleNotificationListener iNotificationServices$IScheduleNotificationListener0) {
        NotificationTrigger notificationTrigger0 = notification0.trigger;
        if(notificationTrigger0 == null || notificationTrigger0 instanceof TimeIntervalNotificationTrigger || notificationTrigger0 instanceof CalendarNotificationTrigger) {
            this.alarmScheduler.schedule(notification0, iNotificationServices$IScheduleNotificationListener0);
        }
        else if(!(notificationTrigger0 instanceof LocationNotificationTrigger)) {
            Logger.error("Unknown trigger type!");
            iNotificationServices$IScheduleNotificationListener0.onFailure("Unknown trigger type");
        }
    }

    @RunOnUiThread
    public void setApplicationIconBadgeNumber(int v) {
        if(v <= 0 && Build.VERSION.SDK_INT >= 26) {
            new NotificationChannel("com.MonsterCouch.Wingspan", ApplicationUtil.getApplicationName(this.context), 3).setShowBadge(false);
        }
    }

    public void setNotificationListener(INotificationReceivedListener iNotificationServices$INotificationReceivedListener0) {
        NotificationServices.listener = iNotificationServices$INotificationReceivedListener0;
    }

    public void setNotificationType(NotificationType notificationType0) {
        this.settings.setType(notificationType0);
        this.settings.save(this.context);
    }
}

