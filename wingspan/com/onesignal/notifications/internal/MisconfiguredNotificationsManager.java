package com.onesignal.notifications.internal;

import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u000EH\u0016J\u0010\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\nH\u0016J\u0010\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u000EH\u0016J\u0010\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0019\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001ER\u0014\u0010\u0003\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/notifications/internal/MisconfiguredNotificationsManager;", "Lcom/onesignal/notifications/INotificationsManager;", "()V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "addClickListener", "", "listener", "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "Lcom/onesignal/notifications/IPermissionObserver;", "clearAllNotifications", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MisconfiguredNotificationsManager implements INotificationsManager {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/MisconfiguredNotificationsManager$Companion;", "", "()V", "EXCEPTION", "Ljava/lang/Exception;", "Lkotlin/Exception;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion;
    private static final Exception EXCEPTION;

    static {
        MisconfiguredNotificationsManager.Companion = new Companion(null);
        MisconfiguredNotificationsManager.EXCEPTION = new Exception("Must include gradle module com.onesignal:Notification in order to use this functionality!");
    }

    public Void addClickListener(INotificationClickListener iNotificationClickListener0) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "listener");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void addClickListener(INotificationClickListener iNotificationClickListener0) {
        this.addClickListener(iNotificationClickListener0);
    }

    public Void addForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "listener");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void addForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        this.addForegroundLifecycleListener(iNotificationLifecycleListener0);
    }

    public Void addPermissionObserver(IPermissionObserver iPermissionObserver0) {
        Intrinsics.checkNotNullParameter(iPermissionObserver0, "observer");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void addPermissionObserver(IPermissionObserver iPermissionObserver0) {
        this.addPermissionObserver(iPermissionObserver0);
    }

    public Void clearAllNotifications() {
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void clearAllNotifications() {
        this.clearAllNotifications();
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public boolean getCanRequestPermission() {
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public boolean getPermission() {
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    public Void removeClickListener(INotificationClickListener iNotificationClickListener0) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "listener");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeClickListener(INotificationClickListener iNotificationClickListener0) {
        this.removeClickListener(iNotificationClickListener0);
    }

    public Void removeForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "listener");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        this.removeForegroundLifecycleListener(iNotificationLifecycleListener0);
    }

    public Void removeGroupedNotifications(String s) {
        Intrinsics.checkNotNullParameter(s, "group");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeGroupedNotifications(String s) {
        this.removeGroupedNotifications(s);
    }

    public Void removeNotification(int v) {
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeNotification(int v) {
        this.removeNotification(v);
    }

    public Void removePermissionObserver(IPermissionObserver iPermissionObserver0) {
        Intrinsics.checkNotNullParameter(iPermissionObserver0, "observer");
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removePermissionObserver(IPermissionObserver iPermissionObserver0) {
        this.removePermissionObserver(iPermissionObserver0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public Object requestPermission(boolean z, Continuation continuation0) {
        throw MisconfiguredNotificationsManager.EXCEPTION;
    }
}

