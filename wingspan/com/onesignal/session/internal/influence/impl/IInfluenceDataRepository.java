package com.onesignal.session.internal.influence.impl;

import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\u0010\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0007H&J\u0010\u0010$\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0007H&J\u0012\u0010%\u001A\u00020\"2\b\u0010&\u001A\u0004\u0018\u00010\u0003H&J\u0010\u0010\'\u001A\u00020\"2\u0006\u0010(\u001A\u00020\u0016H&J\u0010\u0010)\u001A\u00020\"2\u0006\u0010*\u001A\u00020\u0016H&R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u0012\u0010\u0013\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0012R\u0012\u0010\u0014\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u00168fX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u00168fX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0012\u0010\u001B\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\tR\u0012\u0010\u001D\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\rR\u0012\u0010\u001F\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b \u0010\r¨\u0006+"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/IInfluenceDataRepository;", "", "cachedNotificationOpenId", "", "getCachedNotificationOpenId", "()Ljava/lang/String;", "iamCachedInfluenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getIamCachedInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "iamIndirectAttributionWindow", "", "getIamIndirectAttributionWindow", "()I", "iamLimit", "getIamLimit", "isDirectInfluenceEnabled", "", "()Z", "isIndirectInfluenceEnabled", "isUnattributedInfluenceEnabled", "lastIAMsReceivedData", "Lorg/json/JSONArray;", "getLastIAMsReceivedData", "()Lorg/json/JSONArray;", "lastNotificationsReceivedData", "getLastNotificationsReceivedData", "notificationCachedInfluenceType", "getNotificationCachedInfluenceType", "notificationIndirectAttributionWindow", "getNotificationIndirectAttributionWindow", "notificationLimit", "getNotificationLimit", "cacheIAMInfluenceType", "", "influenceType", "cacheNotificationInfluenceType", "cacheNotificationOpenId", "id", "saveIAMs", "iams", "saveNotifications", "notifications", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInfluenceDataRepository {
    void cacheIAMInfluenceType(InfluenceType arg1);

    void cacheNotificationInfluenceType(InfluenceType arg1);

    void cacheNotificationOpenId(String arg1);

    String getCachedNotificationOpenId();

    InfluenceType getIamCachedInfluenceType();

    int getIamIndirectAttributionWindow();

    int getIamLimit();

    JSONArray getLastIAMsReceivedData() throws JSONException;

    JSONArray getLastNotificationsReceivedData() throws JSONException;

    InfluenceType getNotificationCachedInfluenceType();

    int getNotificationIndirectAttributionWindow();

    int getNotificationLimit();

    boolean isDirectInfluenceEnabled();

    boolean isIndirectInfluenceEnabled();

    boolean isUnattributedInfluenceEnabled();

    void saveIAMs(JSONArray arg1);

    void saveNotifications(JSONArray arg1);
}

