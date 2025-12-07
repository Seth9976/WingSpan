package com.onesignal.notifications.internal;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.notifications.INotificationClickResult;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001A\u00020\nR\u0016\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationClickResult;", "Lcom/onesignal/notifications/INotificationClickResult;", "actionId", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/String;", "getUrl", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationClickResult implements INotificationClickResult {
    private final String actionId;
    private final String url;

    public NotificationClickResult(String s, String s1) {
        this.actionId = s;
        this.url = s1;
    }

    @Override  // com.onesignal.notifications.INotificationClickResult
    public String getActionId() {
        return this.actionId;
    }

    @Override  // com.onesignal.notifications.INotificationClickResult
    public String getUrl() {
        return this.url;
    }

    public final JSONObject toJSONObject() {
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), "actionId", this.getActionId()), "url", this.getUrl());
    }
}

