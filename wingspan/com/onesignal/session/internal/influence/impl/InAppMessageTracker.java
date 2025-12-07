package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0012\u0010\u001B\u001A\u00020\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001D\u001A\u00020\u001AH\u0016J\u0010\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u0016H\u0016R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InAppMessageTracker;", "Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;Lcom/onesignal/core/internal/time/ITime;)V", "channelLimit", "", "getChannelLimit", "()I", "channelType", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getChannelType", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "idTag", "", "getIdTag", "()Ljava/lang/String;", "indirectAttributionWindow", "getIndirectAttributionWindow", "lastChannelObjects", "Lorg/json/JSONArray;", "getLastChannelObjects", "()Lorg/json/JSONArray;", "cacheState", "", "getLastChannelObjectsReceivedByNewId", "id", "initInfluencedTypeFromCache", "saveChannelObjects", "channelObjects", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageTracker extends ChannelTracker {
    public InAppMessageTracker(InfluenceDataRepository influenceDataRepository0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(influenceDataRepository0, "dataRepository");
        Intrinsics.checkNotNullParameter(iTime0, "timeProvider");
        super(influenceDataRepository0, iTime0);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void cacheState() {
        InfluenceType influenceType0 = this.getInfluenceType();
        if(influenceType0 == null) {
            influenceType0 = InfluenceType.UNATTRIBUTED;
        }
        InfluenceDataRepository influenceDataRepository0 = this.getDataRepository();
        if(influenceType0 == InfluenceType.DIRECT) {
            influenceType0 = InfluenceType.INDIRECT;
        }
        influenceDataRepository0.cacheIAMInfluenceType(influenceType0);
    }

    @Override  // com.onesignal.session.internal.influence.impl.ChannelTracker
    public int getChannelLimit() {
        return this.getDataRepository().getIamLimit();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public InfluenceChannel getChannelType() {
        return InfluenceChannel.IAM;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public String getIdTag() [...] // Inlined contents

    @Override  // com.onesignal.session.internal.influence.impl.ChannelTracker
    public int getIndirectAttributionWindow() {
        return this.getDataRepository().getIamIndirectAttributionWindow();
    }

    @Override  // com.onesignal.session.internal.influence.impl.ChannelTracker
    public JSONArray getLastChannelObjects() throws JSONException {
        return this.getDataRepository().getLastIAMsReceivedData();
    }

    @Override  // com.onesignal.session.internal.influence.impl.ChannelTracker
    public JSONArray getLastChannelObjectsReceivedByNewId(String s) {
        JSONArray jSONArray0;
        try {
            jSONArray0 = this.getLastChannelObjects();
        }
        catch(JSONException jSONException0) {
            Logging.error("Generating IAM tracker getLastChannelObjects JSONObject ", jSONException0);
            return new JSONArray();
        }
        try {
            JSONArray jSONArray1 = new JSONArray();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                if(!Intrinsics.areEqual(s, jSONArray0.getJSONObject(v1).getString("iam_id"))) {
                    jSONArray1.put(jSONArray0.getJSONObject(v1));
                }
            }
            return jSONArray1;
        }
        catch(JSONException jSONException1) {
            Logging.error("Generating tracker lastChannelObjectReceived get JSONObject ", jSONException1);
            return jSONArray0;
        }
    }

    @Override  // com.onesignal.session.internal.influence.impl.ChannelTracker
    public void initInfluencedTypeFromCache() {
        this.setInfluenceType(this.getDataRepository().getIamCachedInfluenceType());
        Logging.debug$default(("InAppMessageTracker.initInfluencedTypeFromCache: " + this), null, 2, null);
    }

    @Override  // com.onesignal.session.internal.influence.impl.ChannelTracker
    public void saveChannelObjects(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "channelObjects");
        this.getDataRepository().saveIAMs(jSONArray0);
    }
}

