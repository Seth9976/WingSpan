package com.onesignal.notifications.internal;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.IDisplayableNotification;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001A\u00020\rH\u0016R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationWillDisplayEvent;", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "notification", "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;)V", "isPreventDefault", "", "()Z", "setPreventDefault", "(Z)V", "getNotification", "()Lcom/onesignal/notifications/internal/Notification;", "preventDefault", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationWillDisplayEvent implements INotificationWillDisplayEvent {
    private boolean isPreventDefault;
    private final Notification notification;

    public NotificationWillDisplayEvent(Notification notification0) {
        Intrinsics.checkNotNullParameter(notification0, "notification");
        super();
        this.notification = notification0;
    }

    @Override  // com.onesignal.notifications.INotificationWillDisplayEvent
    public IDisplayableNotification getNotification() {
        return this.getNotification();
    }

    public Notification getNotification() {
        return this.notification;
    }

    public final boolean isPreventDefault() {
        return this.isPreventDefault;
    }

    @Override  // com.onesignal.notifications.INotificationWillDisplayEvent
    public void preventDefault() {
        Logging.debug$default("NotificationWillDisplayEvent.preventDefault()", null, 2, null);
        this.isPreventDefault = true;
    }

    public final void setPreventDefault(boolean z) {
        this.isPreventDefault = z;
    }
}

