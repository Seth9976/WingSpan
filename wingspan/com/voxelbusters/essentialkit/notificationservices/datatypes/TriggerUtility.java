package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.util.Log;
import org.json.JSONObject;

public class TriggerUtility {
    public NotificationTrigger fromJson(JSONObject jSONObject0) {
        if(this.isTimeIntervalTrigger(jSONObject0)) {
            return TimeIntervalNotificationTrigger.fromJson(jSONObject0);
        }
        if(this.isCalendarNotificationTrigger(jSONObject0)) {
            return CalendarNotificationTrigger.fromJson(jSONObject0);
        }
        if(this.isLocationNotificationTrigger(jSONObject0)) {
            return LocationNotificationTrigger.fromJson(jSONObject0);
        }
        Log.w("TriggerUtility", "No trigger matched.");
        return null;
    }

    // 去混淆评级： 低(20)
    private boolean isCalendarNotificationTrigger(JSONObject jSONObject0) {
        return "CALENDAR".equals(jSONObject0.optString("type"));
    }

    private boolean isLocationNotificationTrigger(JSONObject jSONObject0) {
        return "LOCATION".equals(jSONObject0.optString("type"));
    }

    private boolean isTimeIntervalTrigger(JSONObject jSONObject0) {
        return "TIME_INTERVAL".equals(jSONObject0.optString("type"));
    }
}

