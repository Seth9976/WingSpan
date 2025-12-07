package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001F\b\u0007\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001A\u00020\rJ\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u0007\"\u0004\b\u000B\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "", "notificationIds", "Lorg/json/JSONArray;", "inAppMessagesIds", "(Lorg/json/JSONArray;Lorg/json/JSONArray;)V", "getInAppMessagesIds", "()Lorg/json/JSONArray;", "setInAppMessagesIds", "(Lorg/json/JSONArray;)V", "getNotificationIds", "setNotificationIds", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeSourceBody {
    private JSONArray inAppMessagesIds;
    private JSONArray notificationIds;

    public OutcomeSourceBody() {
        this(null, null, 3, null);
    }

    public OutcomeSourceBody(JSONArray jSONArray0) {
        this(jSONArray0, null, 2, null);
    }

    public OutcomeSourceBody(JSONArray jSONArray0, JSONArray jSONArray1) {
        this.notificationIds = jSONArray0;
        this.inAppMessagesIds = jSONArray1;
    }

    public OutcomeSourceBody(JSONArray jSONArray0, JSONArray jSONArray1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            jSONArray0 = new JSONArray();
        }
        if((v & 2) != 0) {
            jSONArray1 = new JSONArray();
        }
        this(jSONArray0, jSONArray1);
    }

    public final JSONArray getInAppMessagesIds() {
        return this.inAppMessagesIds;
    }

    public final JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    public final void setInAppMessagesIds(JSONArray jSONArray0) {
        this.inAppMessagesIds = jSONArray0;
    }

    public final void setNotificationIds(JSONArray jSONArray0) {
        this.notificationIds = jSONArray0;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject0 = new JSONObject().put("notification_ids", this.notificationIds).put("in_app_message_ids", this.inAppMessagesIds);
        Intrinsics.checkNotNullExpressionValue(jSONObject0, "JSONObject()\n           …AM_IDS, inAppMessagesIds)");
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OutcomeSourceBody{notificationIds=" + this.notificationIds + ", inAppMessagesIds=" + this.inAppMessagesIds + '}';
    }
}

