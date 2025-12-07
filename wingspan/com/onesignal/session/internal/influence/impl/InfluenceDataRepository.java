package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\fH\u0016J\u0010\u0010)\u001A\u00020\'2\u0006\u0010(\u001A\u00020\fH\u0016J\u0012\u0010*\u001A\u00020\'2\b\u0010+\u001A\u0004\u0018\u00010\bH\u0016J\u0010\u0010,\u001A\u00020\'2\u0006\u0010-\u001A\u00020\u001BH\u0016J\u0010\u0010.\u001A\u00020\'2\u0006\u0010/\u001A\u00020\u001BH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001DR\u0014\u0010 \u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u000ER\u0014\u0010\"\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u0012R\u0014\u0010$\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010\u0012R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "Lcom/onesignal/session/internal/influence/impl/IInfluenceDataRepository;", "preferences", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "cachedNotificationOpenId", "", "getCachedNotificationOpenId", "()Ljava/lang/String;", "iamCachedInfluenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "getIamCachedInfluenceType", "()Lcom/onesignal/session/internal/influence/InfluenceType;", "iamIndirectAttributionWindow", "", "getIamIndirectAttributionWindow", "()I", "iamLimit", "getIamLimit", "isDirectInfluenceEnabled", "", "()Z", "isIndirectInfluenceEnabled", "isUnattributedInfluenceEnabled", "lastIAMsReceivedData", "Lorg/json/JSONArray;", "getLastIAMsReceivedData", "()Lorg/json/JSONArray;", "lastNotificationsReceivedData", "getLastNotificationsReceivedData", "notificationCachedInfluenceType", "getNotificationCachedInfluenceType", "notificationIndirectAttributionWindow", "getNotificationIndirectAttributionWindow", "notificationLimit", "getNotificationLimit", "cacheIAMInfluenceType", "", "influenceType", "cacheNotificationInfluenceType", "cacheNotificationOpenId", "id", "saveIAMs", "iams", "saveNotifications", "notifications", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InfluenceDataRepository implements IInfluenceDataRepository {
    private final ConfigModelStore _configModelStore;
    private final IPreferencesService preferences;

    public InfluenceDataRepository(IPreferencesService iPreferencesService0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "preferences");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super();
        this.preferences = iPreferencesService0;
        this._configModelStore = configModelStore0;
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void cacheIAMInfluenceType(InfluenceType influenceType0) {
        Intrinsics.checkNotNullParameter(influenceType0, "influenceType");
        this.preferences.saveString("OneSignal", "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", influenceType0.toString());
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void cacheNotificationInfluenceType(InfluenceType influenceType0) {
        Intrinsics.checkNotNullParameter(influenceType0, "influenceType");
        this.preferences.saveString("OneSignal", "PREFS_OS_OUTCOMES_CURRENT_SESSION", influenceType0.toString());
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void cacheNotificationOpenId(String s) {
        this.preferences.saveString("OneSignal", "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", s);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public String getCachedNotificationOpenId() {
        return this.preferences.getString("OneSignal", "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", null);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public InfluenceType getIamCachedInfluenceType() {
        String s = this.preferences.getString("OneSignal", "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", "UNATTRIBUTED");
        return InfluenceType.Companion.fromString(s);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getIamIndirectAttributionWindow() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().getIndirectIAMAttributionWindow();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getIamLimit() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().getIamLimit();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public JSONArray getLastIAMsReceivedData() throws JSONException {
        String s = this.preferences.getString("OneSignal", "PREFS_OS_LAST_IAMS_RECEIVED", "[]");
        return s == null ? new JSONArray() : new JSONArray(s);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public JSONArray getLastNotificationsReceivedData() throws JSONException {
        String s = this.preferences.getString("OneSignal", "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", "[]");
        return s == null ? new JSONArray() : new JSONArray(s);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public InfluenceType getNotificationCachedInfluenceType() {
        String s = this.preferences.getString("OneSignal", "PREFS_OS_OUTCOMES_CURRENT_SESSION", "UNATTRIBUTED");
        return InfluenceType.Companion.fromString(s);
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getNotificationIndirectAttributionWindow() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().getIndirectNotificationAttributionWindow();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public int getNotificationLimit() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().getNotificationLimit();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public boolean isDirectInfluenceEnabled() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().isDirectEnabled();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public boolean isIndirectInfluenceEnabled() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().isIndirectEnabled();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public boolean isUnattributedInfluenceEnabled() {
        return ((ConfigModel)this._configModelStore.getModel()).getInfluenceParams().isUnattributedEnabled();
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void saveIAMs(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "iams");
        this.preferences.saveString("OneSignal", "PREFS_OS_LAST_IAMS_RECEIVED", jSONArray0.toString());
    }

    @Override  // com.onesignal.session.internal.influence.impl.IInfluenceDataRepository
    public void saveNotifications(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "notifications");
        this.preferences.saveString("OneSignal", "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", jSONArray0.toString());
    }
}

