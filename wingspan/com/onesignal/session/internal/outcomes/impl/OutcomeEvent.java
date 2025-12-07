package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\u0006\u0010\u001F\u001A\u00020 J\b\u0010!\u001A\u00020\u0007H\u0016R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "Lcom/onesignal/session/internal/outcomes/IOutcomeEvent;", "session", "Lcom/onesignal/session/internal/influence/InfluenceType;", "notificationIds", "Lorg/json/JSONArray;", "name", "", "timestamp", "", "sessionTime", "weight", "", "(Lcom/onesignal/session/internal/influence/InfluenceType;Lorg/json/JSONArray;Ljava/lang/String;JJF)V", "getName", "()Ljava/lang/String;", "getNotificationIds", "()Lorg/json/JSONArray;", "getSession", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "getSessionTime", "()J", "getTimestamp", "getWeight", "()F", "equals", "", "o", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeEvent implements IOutcomeEvent {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent$Companion;", "", "()V", "NOTIFICATION_IDS", "", "OUTCOME_ID", "SESSION", "SESSION_TIME", "TIMESTAMP", "WEIGHT", "fromOutcomeEventParamstoOutcomeEvent", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "outcomeEventParams", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final OutcomeEvent fromOutcomeEventParamstoOutcomeEvent(OutcomeEventParams outcomeEventParams0) {
            Intrinsics.checkNotNullParameter(outcomeEventParams0, "outcomeEventParams");
            InfluenceType influenceType0 = InfluenceType.UNATTRIBUTED;
            if(outcomeEventParams0.getOutcomeSource() != null) {
                OutcomeSource outcomeSource0 = outcomeEventParams0.getOutcomeSource();
                if(outcomeSource0.getDirectBody() != null) {
                    OutcomeSourceBody outcomeSourceBody0 = outcomeSource0.getDirectBody();
                    Intrinsics.checkNotNull(outcomeSourceBody0);
                    if(outcomeSourceBody0.getNotificationIds() != null) {
                        OutcomeSourceBody outcomeSourceBody1 = outcomeSource0.getDirectBody();
                        Intrinsics.checkNotNull(outcomeSourceBody1);
                        JSONArray jSONArray0 = outcomeSourceBody1.getNotificationIds();
                        Intrinsics.checkNotNull(jSONArray0);
                        if(jSONArray0.length() > 0) {
                            OutcomeSourceBody outcomeSourceBody2 = outcomeSource0.getDirectBody();
                            Intrinsics.checkNotNull(outcomeSourceBody2);
                            return new OutcomeEvent(InfluenceType.DIRECT, outcomeSourceBody2.getNotificationIds(), outcomeEventParams0.getOutcomeId(), outcomeEventParams0.getTimestamp(), outcomeEventParams0.getSessionTime(), outcomeEventParams0.getWeight());
                        }
                    }
                }
                if(outcomeSource0.getIndirectBody() != null) {
                    OutcomeSourceBody outcomeSourceBody3 = outcomeSource0.getIndirectBody();
                    Intrinsics.checkNotNull(outcomeSourceBody3);
                    if(outcomeSourceBody3.getNotificationIds() != null) {
                        OutcomeSourceBody outcomeSourceBody4 = outcomeSource0.getIndirectBody();
                        Intrinsics.checkNotNull(outcomeSourceBody4);
                        JSONArray jSONArray1 = outcomeSourceBody4.getNotificationIds();
                        Intrinsics.checkNotNull(jSONArray1);
                        if(jSONArray1.length() > 0) {
                            OutcomeSourceBody outcomeSourceBody5 = outcomeSource0.getIndirectBody();
                            Intrinsics.checkNotNull(outcomeSourceBody5);
                            return new OutcomeEvent(InfluenceType.INDIRECT, outcomeSourceBody5.getNotificationIds(), outcomeEventParams0.getOutcomeId(), outcomeEventParams0.getTimestamp(), outcomeEventParams0.getSessionTime(), outcomeEventParams0.getWeight());
                        }
                    }
                }
            }
            return new OutcomeEvent(influenceType0, null, outcomeEventParams0.getOutcomeId(), outcomeEventParams0.getTimestamp(), outcomeEventParams0.getSessionTime(), outcomeEventParams0.getWeight());
        }
    }

    public static final Companion Companion = null;
    private static final String NOTIFICATION_IDS = "notification_ids";
    private static final String OUTCOME_ID = "id";
    private static final String SESSION = "session";
    private static final String SESSION_TIME = "session_time";
    private static final String TIMESTAMP = "timestamp";
    private static final String WEIGHT = "weight";
    private final String name;
    private final JSONArray notificationIds;
    private final InfluenceType session;
    private final long sessionTime;
    private final long timestamp;
    private final float weight;

    static {
        OutcomeEvent.Companion = new Companion(null);
    }

    public OutcomeEvent(InfluenceType influenceType0, JSONArray jSONArray0, String s, long v, long v1, float f) {
        Intrinsics.checkNotNullParameter(influenceType0, "session");
        Intrinsics.checkNotNullParameter(s, "name");
        super();
        this.session = influenceType0;
        this.notificationIds = jSONArray0;
        this.name = s;
        this.timestamp = v;
        this.sessionTime = v1;
        this.weight = f;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 == null || !Intrinsics.areEqual(this.getClass(), object0.getClass()) || (this.getSession() != ((OutcomeEvent)object0).getSession() || !Intrinsics.areEqual(this.getNotificationIds(), ((OutcomeEvent)object0).getNotificationIds()) || !Intrinsics.areEqual(this.getName(), ((OutcomeEvent)object0).getName()) || this.getTimestamp() != ((OutcomeEvent)object0).getTimestamp() || this.getSessionTime() != ((OutcomeEvent)object0).getSessionTime()) ? false : this.getWeight() == ((OutcomeEvent)object0).getWeight();
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public String getName() {
        return this.name;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public InfluenceType getSession() {
        return this.session;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public long getSessionTime() {
        return this.sessionTime;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public float getWeight() {
        return this.weight;
    }

    @Override
    public int hashCode() {
        Object[] arr_object = new Object[6];
        arr_object[0] = this.getSession();
        int v = 1;
        arr_object[1] = this.getNotificationIds();
        arr_object[2] = this.getName();
        arr_object[3] = this.getTimestamp();
        arr_object[4] = this.getSessionTime();
        arr_object[5] = this.getWeight();
        for(int v1 = 0; v1 < 6; ++v1) {
            Object object0 = arr_object[v1];
            v = v * 0x1F + (object0 == null ? 0 : object0.hashCode());
        }
        return v;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("session", this.getSession());
        jSONObject0.put("notification_ids", this.getNotificationIds());
        jSONObject0.put("id", this.getName());
        jSONObject0.put("timestamp", this.getTimestamp());
        jSONObject0.put("session_time", this.getSessionTime());
        jSONObject0.put("weight", this.getWeight());
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OutcomeEvent{session=" + this.getSession() + ", notificationIds=" + this.getNotificationIds() + ", name=\'" + this.getName() + "\', timestamp=" + this.getTimestamp() + ", sessionTime=" + this.getSessionTime() + ", weight=" + this.getWeight() + '}';
    }
}

