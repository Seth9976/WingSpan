package com.onesignal.notifications.internal.open.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0019"}, d2 = {"Lcom/onesignal/notifications/internal/open/impl/NotificationIntentExtras;", "", "dataArray", "Lorg/json/JSONArray;", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONArray;Lorg/json/JSONObject;)V", "getDataArray", "()Lorg/json/JSONArray;", "setDataArray", "(Lorg/json/JSONArray;)V", "getJsonData", "()Lorg/json/JSONObject;", "setJsonData", "(Lorg/json/JSONObject;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationIntentExtras {
    private JSONArray dataArray;
    private JSONObject jsonData;

    public NotificationIntentExtras(JSONArray jSONArray0, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "dataArray");
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonData");
        super();
        this.dataArray = jSONArray0;
        this.jsonData = jSONObject0;
    }

    public final JSONArray component1() {
        return this.dataArray;
    }

    public final JSONObject component2() {
        return this.jsonData;
    }

    public final NotificationIntentExtras copy(JSONArray jSONArray0, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "dataArray");
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonData");
        return new NotificationIntentExtras(jSONArray0, jSONObject0);
    }

    public static NotificationIntentExtras copy$default(NotificationIntentExtras notificationIntentExtras0, JSONArray jSONArray0, JSONObject jSONObject0, int v, Object object0) {
        if((v & 1) != 0) {
            jSONArray0 = notificationIntentExtras0.dataArray;
        }
        if((v & 2) != 0) {
            jSONObject0 = notificationIntentExtras0.jsonData;
        }
        return notificationIntentExtras0.copy(jSONArray0, jSONObject0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof NotificationIntentExtras)) {
            return false;
        }
        return Intrinsics.areEqual(this.dataArray, ((NotificationIntentExtras)object0).dataArray) ? Intrinsics.areEqual(this.jsonData, ((NotificationIntentExtras)object0).jsonData) : false;
    }

    public final JSONArray getDataArray() {
        return this.dataArray;
    }

    public final JSONObject getJsonData() {
        return this.jsonData;
    }

    @Override
    public int hashCode() {
        return this.dataArray.hashCode() * 0x1F + this.jsonData.hashCode();
    }

    public final void setDataArray(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "<set-?>");
        this.dataArray = jSONArray0;
    }

    public final void setJsonData(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<set-?>");
        this.jsonData = jSONObject0;
    }

    @Override
    public String toString() {
        return "NotificationIntentExtras(dataArray=" + this.dataArray + ", jsonData=" + this.jsonData + ')';
    }
}

