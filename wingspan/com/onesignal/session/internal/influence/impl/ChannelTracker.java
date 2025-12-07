package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0006J\u0013\u00100\u001A\u00020(2\b\u00101\u001A\u0004\u0018\u000102H\u0096\u0002J\u0012\u00103\u001A\u00020\u001C2\b\u00104\u001A\u0004\u0018\u00010\u0014H&J\b\u00105\u001A\u00020\bH\u0016J\b\u00106\u001A\u000207H&J\b\u00108\u001A\u000207H\u0016J\u0010\u00109\u001A\u0002072\u0006\u0010:\u001A\u00020\u001CH&J\u0012\u0010;\u001A\u0002072\b\u00104\u001A\u0004\u0018\u00010\u0014H\u0016J\b\u0010<\u001A\u00020\u0014H\u0016R\u0012\u0010\u0007\u001A\u00020\bX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\u0002\u001A\u00020\u0003X\u0084\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001A\u00020\bX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\nR\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u001C\u0010!\u001A\u0004\u0018\u00010\"X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020(8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\'\u0010)R\u0014\u0010*\u001A\u00020(8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b*\u0010)R\u0014\u0010+\u001A\u00020(8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b+\u0010)R\u0014\u0010,\u001A\u00020\u001C8fX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b-\u0010\u001ER\u0014\u0010.\u001A\u00020\u001C8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b/\u0010\u001ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E\u00A2\u0006\u0002\n\u0000\u00A8\u0006="}, d2 = {"Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;Lcom/onesignal/core/internal/time/ITime;)V", "channelLimit", "", "getChannelLimit", "()I", "currentSessionInfluence", "Lcom/onesignal/session/internal/influence/Influence;", "getCurrentSessionInfluence", "()Lcom/onesignal/session/internal/influence/Influence;", "getDataRepository", "()Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "setDataRepository", "(Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;)V", "directId", "", "getDirectId", "()Ljava/lang/String;", "setDirectId", "(Ljava/lang/String;)V", "indirectAttributionWindow", "getIndirectAttributionWindow", "indirectIds", "Lorg/json/JSONArray;", "getIndirectIds", "()Lorg/json/JSONArray;", "setIndirectIds", "(Lorg/json/JSONArray;)V", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "setInfluenceType", "(Lcom/onesignal/session/internal/influence/InfluenceType;)V", "isDirectSessionEnabled", "", "()Z", "isIndirectSessionEnabled", "isUnattributedSessionEnabled", "lastChannelObjects", "getLastChannelObjects", "lastReceivedIds", "getLastReceivedIds", "equals", "other", "", "getLastChannelObjectsReceivedByNewId", "id", "hashCode", "initInfluencedTypeFromCache", "", "resetAndInitInfluence", "saveChannelObjects", "channelObjects", "saveLastId", "toString", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class ChannelTracker implements IChannelTracker {
    private InfluenceDataRepository dataRepository;
    private String directId;
    private JSONArray indirectIds;
    private InfluenceType influenceType;
    private ITime timeProvider;

    public ChannelTracker(InfluenceDataRepository influenceDataRepository0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(influenceDataRepository0, "dataRepository");
        Intrinsics.checkNotNullParameter(iTime0, "timeProvider");
        super();
        this.dataRepository = influenceDataRepository0;
        this.timeProvider = iTime0;
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && Intrinsics.areEqual(this.getClass(), object0.getClass()) && (this.getInfluenceType() == ((ChannelTracker)object0).getInfluenceType() && Intrinsics.areEqual(((ChannelTracker)object0).getIdTag(), this.getIdTag()));
    }

    public abstract int getChannelLimit();

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public Influence getCurrentSessionInfluence() {
        Influence influence0 = new Influence(this.getChannelType(), InfluenceType.DISABLED, null);
        if(this.getInfluenceType() == null) {
            this.initInfluencedTypeFromCache();
        }
        if(this.isUnattributedSessionEnabled()) {
            influence0.setInfluenceType(InfluenceType.UNATTRIBUTED);
        }
        return influence0;
    }

    protected final InfluenceDataRepository getDataRepository() {
        return this.dataRepository;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public String getDirectId() {
        return this.directId;
    }

    public abstract int getIndirectAttributionWindow();

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public JSONArray getIndirectIds() {
        return this.indirectIds;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public InfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public abstract JSONArray getLastChannelObjects() throws JSONException;

    public abstract JSONArray getLastChannelObjectsReceivedByNewId(String arg1);

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public JSONArray getLastReceivedIds() {
        JSONArray jSONArray0 = new JSONArray();
        try {
            JSONArray jSONArray1 = this.getLastChannelObjects();
            Logging.debug$default(("ChannelTracker.getLastReceivedIds: lastChannelObjectReceived: " + jSONArray1), null, 2, null);
            int v = this.getIndirectAttributionWindow();
            long v1 = this.timeProvider.getCurrentTimeMillis();
            int v2 = jSONArray1.length();
        label_7:
            for(int v3 = 0; v3 < v2; ++v3) {
                JSONObject jSONObject0 = jSONArray1.getJSONObject(v3);
                if(v1 - jSONObject0.getLong("time") <= ((long)(v * 60)) * 1000L) {
                    jSONArray0.put(jSONObject0.getString(this.getIdTag()));
                }
            }
        }
        catch(JSONException jSONException0) {
            Logging.error("ChannelTracker.getLastReceivedIds: Generating tracker getLastReceivedIds JSONObject ", jSONException0);
            if(true) {
                return jSONArray0;
            }
            goto label_7;
        }
        return jSONArray0;
    }

    @Override
    public int hashCode() {
        InfluenceType influenceType0 = this.getInfluenceType();
        return influenceType0 == null ? this.getIdTag().hashCode() : influenceType0.hashCode() * 0x1F + this.getIdTag().hashCode();
    }

    public abstract void initInfluencedTypeFromCache();

    private final boolean isDirectSessionEnabled() {
        return this.dataRepository.isDirectInfluenceEnabled();
    }

    private final boolean isIndirectSessionEnabled() {
        return this.dataRepository.isIndirectInfluenceEnabled();
    }

    private final boolean isUnattributedSessionEnabled() {
        return this.dataRepository.isUnattributedInfluenceEnabled();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void resetAndInitInfluence() {
        this.setDirectId(null);
        this.setIndirectIds(this.getLastReceivedIds());
        JSONArray jSONArray0 = this.getIndirectIds();
        this.setInfluenceType(((jSONArray0 == null ? 0 : jSONArray0.length()) <= 0 ? InfluenceType.UNATTRIBUTED : InfluenceType.INDIRECT));
        this.cacheState();
        Logging.debug$default(("ChannelTracker.resetAndInitInfluence: " + this.getIdTag() + " finish with influenceType: " + this.getInfluenceType()), null, 2, null);
    }

    public abstract void saveChannelObjects(JSONArray arg1);

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void saveLastId(String s) {
        Logging.debug$default(("ChannelTracker.saveLastId(id: " + s + "): idTag=" + this.getIdTag()), null, 2, null);
        if(s != null && s.length() != 0) {
            JSONArray jSONArray0 = this.getLastChannelObjectsReceivedByNewId(s);
            Logging.debug$default(("ChannelTracker.saveLastId: for " + this.getIdTag() + " saveLastId with lastChannelObjectsReceived: " + jSONArray0), null, 2, null);
            try {
                ITime iTime0 = this.timeProvider;
                jSONArray0.put(new JSONObject().put(this.getIdTag(), s).put("time", iTime0.getCurrentTimeMillis()));
            }
            catch(JSONException jSONException0) {
                Logging.error("ChannelTracker.saveLastId: Generating tracker newInfluenceId JSONObject ", jSONException0);
                return;
            }
            if(jSONArray0.length() > this.getChannelLimit()) {
                int v = jSONArray0.length() - this.getChannelLimit();
                JSONArray jSONArray1 = new JSONArray();
                int v1 = jSONArray0.length();
                while(v < v1) {
                    try {
                        jSONArray1.put(jSONArray0.get(v));
                    }
                    catch(JSONException jSONException1) {
                        Logging.error("ChannelTracker.saveLastId: Generating tracker lastChannelObjectsReceived get JSONObject ", jSONException1);
                    }
                    ++v;
                }
                jSONArray0 = jSONArray1;
            }
            Logging.debug$default(("ChannelTracker.saveLastId: for " + this.getIdTag() + " with channelObjectToSave: " + jSONArray0), null, 2, null);
            this.saveChannelObjects(jSONArray0);
        }
    }

    protected final void setDataRepository(InfluenceDataRepository influenceDataRepository0) {
        Intrinsics.checkNotNullParameter(influenceDataRepository0, "<set-?>");
        this.dataRepository = influenceDataRepository0;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void setDirectId(String s) {
        this.directId = s;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void setIndirectIds(JSONArray jSONArray0) {
        this.indirectIds = jSONArray0;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void setInfluenceType(InfluenceType influenceType0) {
        this.influenceType = influenceType0;
    }

    @Override
    public String toString() {
        return "ChannelTracker{tag=" + this.getIdTag() + ", influenceType=" + this.getInfluenceType() + ", indirectIds=" + this.getIndirectIds() + ", directId=" + this.getDirectId() + '}';
    }
}

