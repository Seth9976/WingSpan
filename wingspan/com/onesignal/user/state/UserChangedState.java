package com.onesignal.user.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001A\u00020\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/onesignal/user/state/UserChangedState;", "", "current", "Lcom/onesignal/user/state/UserState;", "(Lcom/onesignal/user/state/UserState;)V", "getCurrent", "()Lcom/onesignal/user/state/UserState;", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserChangedState {
    private final UserState current;

    public UserChangedState(UserState userState0) {
        Intrinsics.checkNotNullParameter(userState0, "current");
        super();
        this.current = userState0;
    }

    public final UserState getCurrent() {
        return this.current;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject().put("current", this.current.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(jSONObject0, "JSONObject()\n           …, current.toJSONObject())");
        return jSONObject0;
    }
}

