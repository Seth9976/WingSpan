package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.content.Context;
import com.voxelbusters.essentialkit.notificationservices.NotificationStore;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationSettings {
    private boolean allowVibration;
    private boolean isCustomIconAllowed;
    private boolean notificationDisplayAllowedInForeground;
    private NotificationType type;

    public NotificationSettings(Context context0, JSONObject jSONObject0) {
        NotificationType[] arr_notificationType = NotificationType.values();
        this.type = arr_notificationType[jSONObject0.optInt("type", NotificationType.Unknown.ordinal())];
        this.allowVibration = ResourcesUtil.getBoolean(context0, "NOTIFICATION_SERVICES_NEEDS_VIBRATION");
        this.notificationDisplayAllowedInForeground = ResourcesUtil.getBoolean(context0, "NOTIFICATION_SERVICES_ALLOW_NOTIFICATION_DISPLAY_WHEN_APP_IS_FOREGROUND");
        this.isCustomIconAllowed = ResourcesUtil.getBoolean(context0, "NOTIFICATION_SERVICES_NEEDS_CUSTOM_ICON");
    }

    public JSONObject getJson() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("type", this.type.ordinal());
            jSONObject0.put("allowVibration", this.allowVibration);
            jSONObject0.put("displayNotificationsInForeground", this.notificationDisplayAllowedInForeground);
            jSONObject0.put("isCustomIconAllowed", this.isCustomIconAllowed);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    public NotificationType getType() {
        return this.type;
    }

    public boolean isCustomIconAllowed() {
        return this.isCustomIconAllowed;
    }

    public boolean isNotificationDisplayAllowedInForeground() {
        return this.notificationDisplayAllowedInForeground;
    }

    public boolean isVibrationAllowed() {
        return this.allowVibration;
    }

    public static NotificationSettings load(Context context0) {
        return NotificationStore.getSettings(context0);
    }

    public void save(Context context0) {
        NotificationStore.saveSettings(context0, this);
    }

    public void setType(NotificationType notificationType0) {
        this.type = notificationType0;
    }
}

