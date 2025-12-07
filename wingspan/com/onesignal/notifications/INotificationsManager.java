package com.onesignal.notifications;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\rH&J\u0010\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010H&J\b\u0010\u0011\u001A\u00020\tH&J\u0010\u0010\u0012\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&J\u0010\u0010\u0013\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\rH&J\u0010\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u0016H&J\u0010\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u0019H&J\u0010\u0010\u001A\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0019\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001DR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001E"}, d2 = {"Lcom/onesignal/notifications/INotificationsManager;", "", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "addClickListener", "", "listener", "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "Lcom/onesignal/notifications/IPermissionObserver;", "clearAllNotifications", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationsManager {
    void addClickListener(INotificationClickListener arg1);

    void addForegroundLifecycleListener(INotificationLifecycleListener arg1);

    void addPermissionObserver(IPermissionObserver arg1);

    void clearAllNotifications();

    boolean getCanRequestPermission();

    boolean getPermission();

    void removeClickListener(INotificationClickListener arg1);

    void removeForegroundLifecycleListener(INotificationLifecycleListener arg1);

    void removeGroupedNotifications(String arg1);

    void removeNotification(int arg1);

    void removePermissionObserver(IPermissionObserver arg1);

    Object requestPermission(boolean arg1, Continuation arg2);
}

