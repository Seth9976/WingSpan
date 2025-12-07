package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001A\u00020\u0003J\b\u0010\u0017\u001A\u00020\u000BH\u0016R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "isUnique", "", "()Z", "setUnique", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "weight", "", "getWeight", "()F", "setWeight", "(F)V", "toJSONObject", "toString", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageOutcome {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome$Companion;", "", "()V", "OUTCOME_NAME", "", "OUTCOME_UNIQUE", "OUTCOME_WEIGHT", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String OUTCOME_NAME = "name";
    private static final String OUTCOME_UNIQUE = "unique";
    private static final String OUTCOME_WEIGHT = "weight";
    private boolean isUnique;
    private String name;
    private float weight;

    static {
        InAppMessageOutcome.Companion = new Companion(null);
    }

    public InAppMessageOutcome(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        super();
        String s = jSONObject0.getString("name");
        Intrinsics.checkNotNullExpressionValue(s, "json.getString(OUTCOME_NAME)");
        this.name = s;
        this.weight = jSONObject0.has("weight") ? ((float)jSONObject0.getDouble("weight")) : 0.0f;
        this.isUnique = jSONObject0.has("unique") && jSONObject0.getBoolean("unique");
    }

    public final String getName() {
        return this.name;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final boolean isUnique() {
        return this.isUnique;
    }

    public final void setName(String s) {
        Intrinsics.checkNotNullParameter(s, "<set-?>");
        this.name = s;
    }

    public final void setUnique(boolean z) {
        this.isUnique = z;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("name", this.name);
            jSONObject0.put("weight", ((double)this.weight));
            jSONObject0.put("unique", this.isUnique);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OSInAppMessageOutcome{name=\'" + this.name + "\', weight=" + this.weight + ", unique=" + this.isUnique + '}';
    }
}

