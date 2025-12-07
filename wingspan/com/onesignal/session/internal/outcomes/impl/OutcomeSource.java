package com.onesignal.session.internal.outcomes.impl;

import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001A\u00020\u00002\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003J\u0010\u0010\u000B\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003J\u0006\u0010\f\u001A\u00020\rJ\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u0007\"\u0004\b\u000B\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeSource;", "", "directBody", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "indirectBody", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;)V", "getDirectBody", "()Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "setDirectBody", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;)V", "getIndirectBody", "setIndirectBody", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeSource {
    private OutcomeSourceBody directBody;
    private OutcomeSourceBody indirectBody;

    public OutcomeSource(OutcomeSourceBody outcomeSourceBody0, OutcomeSourceBody outcomeSourceBody1) {
        this.directBody = outcomeSourceBody0;
        this.indirectBody = outcomeSourceBody1;
    }

    public final OutcomeSourceBody getDirectBody() {
        return this.directBody;
    }

    public final OutcomeSourceBody getIndirectBody() {
        return this.indirectBody;
    }

    public final OutcomeSource setDirectBody(OutcomeSourceBody outcomeSourceBody0) {
        this.directBody = outcomeSourceBody0;
        return this;
    }

    public final void setDirectBody(OutcomeSourceBody outcomeSourceBody0) {
        this.directBody = outcomeSourceBody0;
    }

    public final OutcomeSource setIndirectBody(OutcomeSourceBody outcomeSourceBody0) {
        this.indirectBody = outcomeSourceBody0;
        return this;
    }

    public final void setIndirectBody(OutcomeSourceBody outcomeSourceBody0) {
        this.indirectBody = outcomeSourceBody0;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject0 = new JSONObject();
        OutcomeSourceBody outcomeSourceBody0 = this.directBody;
        if(outcomeSourceBody0 != null) {
            jSONObject0.put("direct", outcomeSourceBody0.toJSONObject());
        }
        OutcomeSourceBody outcomeSourceBody1 = this.indirectBody;
        if(outcomeSourceBody1 != null) {
            jSONObject0.put("indirect", outcomeSourceBody1.toJSONObject());
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OutcomeSource{directBody=" + this.directBody + ", indirectBody=" + this.indirectBody + '}';
    }
}

