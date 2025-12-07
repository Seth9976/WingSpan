package com.onesignal.session.internal.outcomes;

import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import org.json.JSONArray;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001A\u00020\u000FX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/onesignal/session/internal/outcomes/IOutcomeEvent;", "", "name", "", "getName", "()Ljava/lang/String;", "notificationIds", "Lorg/json/JSONArray;", "getNotificationIds", "()Lorg/json/JSONArray;", "session", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getSession", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "sessionTime", "", "getSessionTime", "()J", "timestamp", "getTimestamp", "weight", "", "getWeight", "()F", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IOutcomeEvent {
    String getName();

    JSONArray getNotificationIds();

    InfluenceType getSession();

    long getSessionTime();

    long getTimestamp();

    float getWeight();
}

