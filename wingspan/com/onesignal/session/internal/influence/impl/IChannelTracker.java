package com.onesignal.session.internal.influence.impl;

import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010 \u001A\u00020!H&J\b\u0010\"\u001A\u00020!H&J\u0012\u0010#\u001A\u00020!2\b\u0010$\u001A\u0004\u0018\u00010\u000BH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u0004\u0018\u00010\u000BX¦\u000E¢\u0006\f\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\rR\u001A\u0010\u0012\u001A\u0004\u0018\u00010\u0013X¦\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u0004\u0018\u00010\u0019X¦\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u0012\u0010\u001E\u001A\u00020\u0013X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0015¨\u0006%"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "", "channelType", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getChannelType", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "currentSessionInfluence", "Lcom/onesignal/session/internal/influence/Influence;", "getCurrentSessionInfluence", "()Lcom/onesignal/session/internal/influence/Influence;", "directId", "", "getDirectId", "()Ljava/lang/String;", "setDirectId", "(Ljava/lang/String;)V", "idTag", "getIdTag", "indirectIds", "Lorg/json/JSONArray;", "getIndirectIds", "()Lorg/json/JSONArray;", "setIndirectIds", "(Lorg/json/JSONArray;)V", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "setInfluenceType", "(Lcom/onesignal/session/internal/influence/InfluenceType;)V", "lastReceivedIds", "getLastReceivedIds", "cacheState", "", "resetAndInitInfluence", "saveLastId", "id", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IChannelTracker {
    void cacheState();

    InfluenceChannel getChannelType();

    Influence getCurrentSessionInfluence();

    String getDirectId();

    String getIdTag();

    JSONArray getIndirectIds();

    InfluenceType getInfluenceType();

    JSONArray getLastReceivedIds();

    void resetAndInitInfluence();

    void saveLastId(String arg1);

    void setDirectId(String arg1);

    void setIndirectIds(JSONArray arg1);

    void setInfluenceType(InfluenceType arg1);
}

