package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001A\u00020\u0003J\b\u0010\u0017\u001A\u00020\u000EH\u0016R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001A"}, d2 = {"Lcom/onesignal/inAppMessages/internal/Trigger;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "kind", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerKind;", "getKind", "()Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerKind;", "operatorType", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "getOperatorType", "()Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "property", "", "getProperty", "()Ljava/lang/String;", "triggerId", "getTriggerId", "value", "getValue", "()Ljava/lang/Object;", "toJSONObject", "toString", "OSTriggerKind", "OSTriggerOperator", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Trigger {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000B"}, d2 = {"Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerKind;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "TIME_SINCE_LAST_IN_APP", "SESSION_TIME", "CUSTOM", "UNKNOWN", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum OSTriggerKind {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerKind$Companion;", "", "()V", "fromString", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerKind;", "value", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public final OSTriggerKind fromString(String s) {
                OSTriggerKind[] arr_trigger$OSTriggerKind = OSTriggerKind.values();
                for(int v = 0; v < arr_trigger$OSTriggerKind.length; ++v) {
                    OSTriggerKind trigger$OSTriggerKind0 = arr_trigger$OSTriggerKind[v];
                    if(StringsKt.equals(trigger$OSTriggerKind0.value, s, true)) {
                        return trigger$OSTriggerKind0;
                    }
                }
                return OSTriggerKind.UNKNOWN;
            }
        }

        TIME_SINCE_LAST_IN_APP("min_time_since"),
        SESSION_TIME("session_time"),
        CUSTOM("custom"),
        UNKNOWN("unknown");

        public static final Companion Companion;
        private final String value;

        private static final OSTriggerKind[] $values() [...] // Inlined contents

        static {
            OSTriggerKind.Companion = new Companion(null);
        }

        private OSTriggerKind(String s1) {
            this.value = s1;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001A\u00020\u0006J\b\u0010\u0007\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "checksEquality", "", "toString", "GREATER_THAN", "LESS_THAN", "EQUAL_TO", "NOT_EQUAL_TO", "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN_OR_EQUAL_TO", "EXISTS", "NOT_EXISTS", "CONTAINS", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum OSTriggerOperator {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator$Companion;", "", "()V", "fromString", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "text", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
        public static final class com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator.Companion {
            private com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator.Companion() {
            }

            public com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public final OSTriggerOperator fromString(String s) {
                OSTriggerOperator[] arr_trigger$OSTriggerOperator = OSTriggerOperator.values();
                for(int v = 0; v < arr_trigger$OSTriggerOperator.length; ++v) {
                    OSTriggerOperator trigger$OSTriggerOperator0 = arr_trigger$OSTriggerOperator[v];
                    if(StringsKt.equals(trigger$OSTriggerOperator0.text, s, true)) {
                        return trigger$OSTriggerOperator0;
                    }
                }
                return OSTriggerOperator.EQUAL_TO;
            }
        }

        GREATER_THAN("greater"),
        LESS_THAN("less"),
        EQUAL_TO("equal"),
        NOT_EQUAL_TO("not_equal"),
        LESS_THAN_OR_EQUAL_TO("less_or_equal"),
        GREATER_THAN_OR_EQUAL_TO("greater_or_equal"),
        EXISTS("exists"),
        NOT_EXISTS("not_exists"),
        CONTAINS("in");

        public static final com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator.Companion Companion;
        private final String text;

        private static final OSTriggerOperator[] $values() [...] // Inlined contents

        static {
            OSTriggerOperator.Companion = new com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator.Companion(null);
        }

        private OSTriggerOperator(String s1) {
            this.text = s1;
        }

        public final boolean checksEquality() [...] // 潜在的解密器

        @Override
        public String toString() {
            return this.text;
        }
    }

    private final OSTriggerKind kind;
    private final OSTriggerOperator operatorType;
    private final String property;
    private final String triggerId;
    private final Object value;

    public Trigger(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        super();
        String s = jSONObject0.getString("id");
        Intrinsics.checkNotNullExpressionValue(s, "json.getString(\"id\")");
        this.triggerId = s;
        String s1 = jSONObject0.getString("kind");
        this.kind = OSTriggerKind.Companion.fromString(s1);
        this.property = jSONObject0.optString("property", null);
        String s2 = jSONObject0.getString("operator");
        this.operatorType = OSTriggerOperator.Companion.fromString(s2);
        this.value = jSONObject0.opt("value");
    }

    public final OSTriggerKind getKind() {
        return this.kind;
    }

    public final OSTriggerOperator getOperatorType() {
        return this.operatorType;
    }

    public final String getProperty() {
        return this.property;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    public final Object getValue() {
        return this.value;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("id", this.triggerId);
            jSONObject0.put("kind", this.kind);
            jSONObject0.put("property", this.property);
            jSONObject0.put("operator", this.operatorType.toString());
            jSONObject0.put("value", this.value);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "Trigger{triggerId=\'" + this.triggerId + "\', kind=" + this.kind + ", property=\'" + this.property + "\', operatorType=" + this.operatorType + ", value=" + this.value + '}';
    }
}

