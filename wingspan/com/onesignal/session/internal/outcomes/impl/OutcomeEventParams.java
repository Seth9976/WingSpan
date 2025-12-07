package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0002\u0010\u000BJ\u0006\u0010\u001A\u001A\u00020\u001BJ\u0006\u0010\u001C\u001A\u00020\u001DJ\b\u0010\u001E\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\n\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001F"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "", "outcomeId", "", "outcomeSource", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "weight", "", "sessionTime", "", "timestamp", "(Ljava/lang/String;Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;FJJ)V", "getOutcomeId", "()Ljava/lang/String;", "getOutcomeSource", "()Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "getSessionTime", "()J", "setSessionTime", "(J)V", "getTimestamp", "setTimestamp", "getWeight", "()F", "setWeight", "(F)V", "isUnattributed", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeEventParams {
    private final String outcomeId;
    private final OutcomeSource outcomeSource;
    private long sessionTime;
    private long timestamp;
    private float weight;

    public OutcomeEventParams(String s, OutcomeSource outcomeSource0, float f, long v, long v1) {
        Intrinsics.checkNotNullParameter(s, "outcomeId");
        super();
        this.outcomeId = s;
        this.outcomeSource = outcomeSource0;
        this.weight = f;
        this.sessionTime = v;
        this.timestamp = v1;
    }

    public final String getOutcomeId() {
        return this.outcomeId;
    }

    public final OutcomeSource getOutcomeSource() {
        return this.outcomeSource;
    }

    public final long getSessionTime() {
        return this.sessionTime;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final boolean isUnattributed() {
        return this.outcomeSource == null || this.outcomeSource.getDirectBody() == null && this.outcomeSource.getIndirectBody() == null;
    }

    public final void setSessionTime(long v) {
        this.sessionTime = v;
    }

    public final void setTimestamp(long v) {
        this.timestamp = v;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject0 = new JSONObject().put("id", this.outcomeId);
        OutcomeSource outcomeSource0 = this.outcomeSource;
        if(outcomeSource0 != null) {
            jSONObject0.put("sources", outcomeSource0.toJSONObject());
        }
        float f = this.weight;
        if(f > 0.0f) {
            jSONObject0.put("weight", f);
        }
        long v = this.timestamp;
        if(v > 0L) {
            jSONObject0.put("timestamp", v);
        }
        long v1 = this.sessionTime;
        if(v1 > 0L) {
            jSONObject0.put("session_time", v1);
        }
        Intrinsics.checkNotNullExpressionValue(jSONObject0, "json");
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OutcomeEventParams{outcomeId=\'" + this.outcomeId + "\', outcomeSource=" + this.outcomeSource + ", weight=" + this.weight + ", timestamp=" + this.timestamp + ", sessionTime=" + this.sessionTime + '}';
    }
}

