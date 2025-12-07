package com.voxelbusters.essentialkit.notificationservices;

import android.content.Context;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationSettings;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationStore {
    public static final String ACTIVE_NOTIFICATIONS = "active-notification";
    public static final String NOTIFICATION_SETTINGS = "notification-settings";
    public static final String SAVED_KEYS_FILE = "essential-kit-notification-store";
    public static final String SCHEDULED_NOTIFICATIONS = "scheduled-notification";

    public static void deleteActiveNotification(Context context0, String s) {
        NotificationStore.deleteNotification(context0, s, "active-notification");
    }

    private static void deleteNotification(Context context0, String s, String s1) {
        JSONObject jSONObject0 = SharedPreferencesUtil.getJSONObject("essential-kit-notification-store", 0, context0, s1);
        jSONObject0.remove(s);
        SharedPreferencesUtil.setJSONObject("essential-kit-notification-store", 0, context0, s1, jSONObject0);
    }

    public static void deleteScheduledNotification(Context context0, Notification notification0) {
        NotificationStore.deleteScheduledNotification(context0, notification0.getPersistenceId());
    }

    private static void deleteScheduledNotification(Context context0, String s) {
        NotificationStore.deleteNotification(context0, s, "scheduled-notification");
    }

    public static Notification getActiveNotification(Context context0, String s) {
        return NotificationStore.getNotification(context0, s, "active-notification");
    }

    public static ArrayList getActiveNotifications(Context context0) {
        return NotificationStore.getNotifications(context0, "active-notification");
    }

    private static Notification getNotification(Context context0, String s, String s1) {
        JSONObject jSONObject0 = SharedPreferencesUtil.getJSONObject("essential-kit-notification-store", 0, context0, s1).optJSONObject(s);
        return jSONObject0 == null ? null : Notification.fromJson(context0, jSONObject0);
    }

    private static ArrayList getNotifications(Context context0, String s) {
        JSONObject jSONObject0 = SharedPreferencesUtil.getJSONObject("essential-kit-notification-store", 0, context0, s);
        int v = jSONObject0.length();
        ArrayList arrayList0 = new ArrayList();
        if(v > 0) {
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                String s1 = (String)object0;
                try {
                    arrayList0.add(Notification.fromJson(context0, jSONObject0.getJSONObject(s1)));
                }
                catch(JSONException jSONException0) {
                    jSONException0.printStackTrace();
                }
            }
        }
        return arrayList0;
    }

    private static Notification getScheduledNotification(Context context0, String s) {
        return NotificationStore.getNotification(context0, s, "scheduled-notification");
    }

    public static ArrayList getScheduledNotifications(Context context0) {
        return NotificationStore.getNotifications(context0, "scheduled-notification");
    }

    public static NotificationSettings getSettings(Context context0) {
        JSONObject jSONObject0 = SharedPreferencesUtil.getJSONObject("essential-kit-notification-store", 0, context0, "notification-settings");
        Logger.debug(("[Notification Store][Get Settings] : " + jSONObject0.toString()));
        return new NotificationSettings(context0, jSONObject0);
    }

    public static void saveActiveNotification(Context context0, Notification notification0) {
        NotificationStore.saveNotification(context0, notification0, "active-notification");
    }

    private static void saveNotification(Context context0, Notification notification0, String s) {
        if(NotificationStore.getNotification(context0, notification0.getPersistenceId(), s) != null) {
            NotificationStore.deleteNotification(context0, notification0.getPersistenceId(), s);
        }
        JSONObject jSONObject0 = SharedPreferencesUtil.getJSONObject("essential-kit-notification-store", 0, context0, s);
        try {
            jSONObject0.put(notification0.getPersistenceId(), Notification.toJson(context0, notification0));
        }
        catch(JSONException | Exception jSONException0) {
            jSONException0.printStackTrace();
        }
        SharedPreferencesUtil.setJSONObject("essential-kit-notification-store", 0, context0, s, jSONObject0);
    }

    public static void saveScheduledNotification(Context context0, Notification notification0) {
        NotificationStore.saveNotification(context0, notification0, "scheduled-notification");
    }

    public static void saveSettings(Context context0, NotificationSettings notificationSettings0) {
        Logger.debug(("[Notification Store][Save Settings] : " + notificationSettings0.getJson()));
        SharedPreferencesUtil.setJSONObject("essential-kit-notification-store", 0, context0, "notification-settings", notificationSettings0.getJson());
    }
}

