package com.onesignal.user.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001A\u00020\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u000B"}, d2 = {"Lcom/onesignal/user/state/UserState;", "", "onesignalId", "", "externalId", "(Ljava/lang/String;Ljava/lang/String;)V", "getExternalId", "()Ljava/lang/String;", "getOnesignalId", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserState {
    private final String externalId;
    private final String onesignalId;

    public UserState(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "onesignalId");
        Intrinsics.checkNotNullParameter(s1, "externalId");
        super();
        this.onesignalId = s;
        this.externalId = s1;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getOnesignalId() {
        return this.onesignalId;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject().put("onesignalId", this.onesignalId).put("externalId", this.externalId);
        Intrinsics.checkNotNullExpressionValue(jSONObject0, "JSONObject()\n           …\"externalId\", externalId)");
        return jSONObject0;
    }
}

