package com.onesignal.session.internal.influence;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000BJ\u0006\u0010\u001A\u001A\u00020\u0000J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001E\u001A\u00020\u001FH\u0016J\u0006\u0010 \u001A\u00020\u0003J\b\u0010!\u001A\u00020\u0003H\u0016R\u0013\u0010\f\u001A\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0006@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/onesignal/session/internal/influence/Influence;", "", "jsonString", "", "(Ljava/lang/String;)V", "influenceChannel", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "ids", "Lorg/json/JSONArray;", "(Lcom/onesignal/session/internal/influence/InfluenceChannel;Lcom/onesignal/session/internal/influence/InfluenceType;Lorg/json/JSONArray;)V", "directId", "getDirectId", "()Ljava/lang/String;", "getIds", "()Lorg/json/JSONArray;", "setIds", "(Lorg/json/JSONArray;)V", "<set-?>", "getInfluenceChannel", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "setInfluenceType", "(Lcom/onesignal/session/internal/influence/InfluenceType;)V", "copy", "equals", "", "o", "hashCode", "", "toJSONString", "toString", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Influence {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/influence/Influence$Companion;", "", "()V", "INFLUENCE_CHANNEL", "", "INFLUENCE_IDS", "INFLUENCE_TYPE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final String INFLUENCE_CHANNEL = "influence_channel";
    public static final String INFLUENCE_IDS = "influence_ids";
    public static final String INFLUENCE_TYPE = "influence_type";
    private JSONArray ids;
    private InfluenceChannel influenceChannel;
    private InfluenceType influenceType;

    static {
        Influence.Companion = new Companion(null);
    }

    public Influence(InfluenceChannel influenceChannel0, InfluenceType influenceType0, JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(influenceChannel0, "influenceChannel");
        Intrinsics.checkNotNullParameter(influenceType0, "influenceType");
        super();
        this.influenceChannel = influenceChannel0;
        this.influenceType = influenceType0;
        this.ids = jSONArray0;
    }

    public Influence(String s) throws JSONException {
        Intrinsics.checkNotNullParameter(s, "jsonString");
        super();
        JSONObject jSONObject0 = new JSONObject(s);
        String s1 = jSONObject0.getString("influence_channel");
        String s2 = jSONObject0.getString("influence_type");
        String s3 = jSONObject0.getString("influence_ids");
        this.influenceChannel = InfluenceChannel.Companion.fromString(s1);
        this.influenceType = InfluenceType.Companion.fromString(s2);
        Intrinsics.checkNotNullExpressionValue(s3, "ids");
        this.ids = s3.length() == 0 ? new JSONArray(s3) : null;
    }

    public final Influence copy() {
        return new Influence(this.influenceChannel, this.influenceType, this.ids);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && Intrinsics.areEqual(this.getClass(), object0.getClass()) && (this.influenceChannel == ((Influence)object0).influenceChannel && this.influenceType == ((Influence)object0).influenceType);
    }

    public final String getDirectId() throws JSONException {
        JSONArray jSONArray0 = this.ids;
        return jSONArray0 == null || jSONArray0.length() <= 0 ? null : jSONArray0.getString(0);
    }

    public final JSONArray getIds() {
        return this.ids;
    }

    public final InfluenceChannel getInfluenceChannel() {
        return this.influenceChannel;
    }

    public final InfluenceType getInfluenceType() {
        return this.influenceType;
    }

    @Override
    public int hashCode() {
        return this.influenceChannel.hashCode() * 0x1F + this.influenceType.hashCode();
    }

    public final void setIds(JSONArray jSONArray0) {
        this.ids = jSONArray0;
    }

    public final void setInfluenceType(InfluenceType influenceType0) {
        Intrinsics.checkNotNullParameter(influenceType0, "<set-?>");
        this.influenceType = influenceType0;
    }

    public final String toJSONString() throws JSONException {
        String s = new JSONObject().put("influence_channel", this.influenceChannel.toString()).put("influence_type", this.influenceType.toString()).put("influence_ids", (this.ids == null ? "" : String.valueOf(this.ids))).toString();
        Intrinsics.checkNotNullExpressionValue(s, "JSONObject()\n           …)\n            .toString()");
        return s;
    }

    @Override
    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.influenceChannel + ", influenceType=" + this.influenceType + ", ids=" + this.ids + '}';
    }
}

