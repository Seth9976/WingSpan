package com.onesignal.notifications.internal;

import com.onesignal.notifications.INotification;
import com.onesignal.notifications.INotificationClickEvent;
import com.onesignal.notifications.INotificationClickResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000F\u001A\u00020\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0011"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationClickEvent;", "Lcom/onesignal/notifications/INotificationClickEvent;", "_notification", "Lcom/onesignal/notifications/internal/Notification;", "_result", "Lcom/onesignal/notifications/internal/NotificationClickResult;", "(Lcom/onesignal/notifications/internal/Notification;Lcom/onesignal/notifications/internal/NotificationClickResult;)V", "notification", "Lcom/onesignal/notifications/INotification;", "getNotification", "()Lcom/onesignal/notifications/INotification;", "result", "Lcom/onesignal/notifications/INotificationClickResult;", "getResult", "()Lcom/onesignal/notifications/INotificationClickResult;", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationClickEvent implements INotificationClickEvent {
    private final Notification _notification;
    private final NotificationClickResult _result;

    public NotificationClickEvent(Notification notification0, NotificationClickResult notificationClickResult0) {
        Intrinsics.checkNotNullParameter(notification0, "_notification");
        Intrinsics.checkNotNullParameter(notificationClickResult0, "_result");
        super();
        this._notification = notification0;
        this._result = notificationClickResult0;
    }

    @Override  // com.onesignal.notifications.INotificationClickEvent
    public INotification getNotification() {
        return this._notification;
    }

    @Override  // com.onesignal.notifications.INotificationClickEvent
    public INotificationClickResult getResult() {
        return this._result;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject().put("notification", this._notification.toJSONObject()).put("action", this._result.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(jSONObject0, "JSONObject()\n           …, _result.toJSONObject())");
        return jSONObject0;
    }
}

