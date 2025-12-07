package com.onesignal.notifications.internal.common;

import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotification;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.NotificationClickResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0006J*\u0010\f\u001A\u00020\r2\b\u0010\t\u001A\u0004\u0018\u00010\n2\u0016\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u00020\u00100\u000Fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0007J\u001D\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J \u0010\u0019\u001A\u0012\u0012\u0004\u0012\u00020\u00100\u000Fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\t\u001A\u00020\nH\u0007J\u001B\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00100\u001B2\u0006\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0002\u0010\u001CJ\u000E\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u001FJ\u000E\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020!J\u0010\u0010#\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\nH\u0007J\u0012\u0010$\u001A\u0004\u0018\u00010\u00062\b\u0010%\u001A\u0004\u0018\u00010!J\u000E\u0010&\u001A\u00020\'2\u0006\u0010\t\u001A\u00020\nJ\u001A\u0010(\u001A\u0004\u0018\u00010)2\u0006\u0010\t\u001A\u00020\n2\b\u0010*\u001A\u0004\u0018\u00010\u0006J\u0010\u0010+\u001A\u00020\b2\u0006\u0010,\u001A\u00020\u0010H\u0007J\u0010\u0010-\u001A\u0004\u0018\u00010.2\u0006\u0010/\u001A\u00020!R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/onesignal/notifications/internal/common/NotificationHelper;", "", "()V", "GROUPLESS_SUMMARY_ID", "", "GROUPLESS_SUMMARY_KEY", "", "areNotificationsEnabled", "", "context", "Landroid/content/Context;", "channelId", "assignGrouplessNotifications", "", "grouplessNotifs", "Ljava/util/ArrayList;", "Landroid/service/notification/StatusBarNotification;", "Lkotlin/collections/ArrayList;", "generateNotificationOpenedResult", "Lcom/onesignal/notifications/internal/NotificationClickEvent;", "jsonArray", "Lorg/json/JSONArray;", "time", "Lcom/onesignal/core/internal/time/ITime;", "generateNotificationOpenedResult$com_onesignal_notifications", "getActiveGrouplessNotifications", "getActiveNotifications", "", "(Landroid/content/Context;)[Landroid/service/notification/StatusBarNotification;", "getCampaignNameFromNotification", "notification", "Lcom/onesignal/notifications/INotification;", "getCustomJSONObject", "Lorg/json/JSONObject;", "jsonObject", "getGrouplessNotifsCount", "getNotificationIdFromFCMJson", "fcmJson", "getNotificationManager", "Landroid/app/NotificationManager;", "getSoundUri", "Landroid/net/Uri;", "sound", "isGroupSummary", "notif", "parseVibrationPattern", "", "fcmBundle", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationHelper {
    public static final int GROUPLESS_SUMMARY_ID = 0xD52D1DDE;
    public static final String GROUPLESS_SUMMARY_KEY = "os_group_undefined";
    public static final NotificationHelper INSTANCE;

    static {
        NotificationHelper.INSTANCE = new NotificationHelper();
    }

    public final boolean areNotificationsEnabled(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "context");
        try {
            if(!NotificationManagerCompat.from(context0).areNotificationsEnabled()) {
                return false;
            }
            if(s != null && Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager0 = this.getNotificationManager(context0);
                NotificationChannel notificationChannel0 = notificationManager0 == null ? null : notificationManager0.getNotificationChannel(s);
                return notificationChannel0 == null || notificationChannel0.getImportance() != 0;
            }
        }
        catch(Throwable unused_ex) {
        }
        return true;
    }

    public static boolean areNotificationsEnabled$default(NotificationHelper notificationHelper0, Context context0, String s, int v, Object object0) {
        if((v & 2) != 0) {
            s = null;
        }
        return notificationHelper0.areNotificationsEnabled(context0, s);
    }

    public final void assignGrouplessNotifications(Context context0, ArrayList arrayList0) {
        Intrinsics.checkNotNullParameter(arrayList0, "grouplessNotifs");
        for(Object object0: arrayList0) {
            Notification.Builder notification$Builder0 = Notification.Builder.recoverBuilder(context0, ((StatusBarNotification)object0).getNotification());
            Intrinsics.checkNotNullExpressionValue(notification$Builder0, "recoverBuilder(context, …uplessNotif.notification)");
            Notification notification0 = notification$Builder0.setGroup("os_group_undefined").setOnlyAlertOnce(true).build();
            Intrinsics.checkNotNullExpressionValue(notification0, "grouplessNotifBuilder\n  …                 .build()");
            Intrinsics.checkNotNull(context0);
            NotificationManagerCompat.from(context0).notify(((StatusBarNotification)object0).getId(), notification0);
        }
    }

    public final NotificationClickEvent generateNotificationOpenedResult$com_onesignal_notifications(JSONArray jSONArray0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "jsonArray");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        int v = jSONArray0.length();
        int v1 = jSONArray0.optJSONObject(0).optInt("androidNotificationId");
        List list0 = new ArrayList();
        boolean z = true;
        JSONObject jSONObject0 = null;
        String s = null;
        for(int v2 = 0; v2 < v; ++v2) {
            try {
                jSONObject0 = jSONArray0.getJSONObject(v2);
                if(s == null && jSONObject0.has("actionId")) {
                    s = jSONObject0.optString("actionId", null);
                }
                if(z) {
                    z = false;
                }
                else {
                    list0.add(new com.onesignal.notifications.internal.Notification(jSONObject0, iTime0));
                }
            }
            catch(Throwable throwable0) {
                Logging.error(("Error parsing JSON item " + v2 + '/' + v + " for callback."), throwable0);
            }
        }
        Intrinsics.checkNotNull(jSONObject0);
        com.onesignal.notifications.internal.Notification notification0 = new com.onesignal.notifications.internal.Notification(list0, jSONObject0, v1, iTime0);
        return new NotificationClickEvent(notification0, new NotificationClickResult(s, notification0.getLaunchURL()));
    }

    public final ArrayList getActiveGrouplessNotifications(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        ArrayList arrayList0 = new ArrayList();
        StatusBarNotification[] arr_statusBarNotification = this.getActiveNotifications(context0);
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            StatusBarNotification statusBarNotification0 = arr_statusBarNotification[v];
            Notification notification0 = statusBarNotification0.getNotification();
            if(!this.isGroupSummary(statusBarNotification0) && (notification0.getGroup() == null || Intrinsics.areEqual(notification0.getGroup(), "os_group_undefined"))) {
                arrayList0.add(statusBarNotification0);
            }
        }
        return arrayList0;
    }

    public final StatusBarNotification[] getActiveNotifications(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        try {
            StatusBarNotification[] arr_statusBarNotification = this.getNotificationManager(context0).getActiveNotifications();
            Intrinsics.checkNotNullExpressionValue(arr_statusBarNotification, "getNotificationManager(c…text).activeNotifications");
            return arr_statusBarNotification;
        }
        catch(Throwable unused_ex) {
            return new StatusBarNotification[0];
        }
    }

    public final String getCampaignNameFromNotification(INotification iNotification0) {
        Intrinsics.checkNotNullParameter(iNotification0, "notification");
        String s = iNotification0.getTemplateName();
        if(s == null || s.length() != 0) {
            String s1 = iNotification0.getTemplateId();
            if(s1 == null || s1.length() != 0) {
                return iNotification0.getTemplateName() + " - " + iNotification0.getTemplateId();
            }
        }
        if(iNotification0.getTitle() != null) {
            String s2 = iNotification0.getTitle();
            Intrinsics.checkNotNull(s2);
            String s3 = iNotification0.getTitle();
            Intrinsics.checkNotNull(s3);
            String s4 = s2.substring(0, Math.min(10, s3.length()));
            Intrinsics.checkNotNullExpressionValue(s4, "this as java.lang.String…ing(startIndex, endIndex)");
            return s4;
        }
        return "";
    }

    public final JSONObject getCustomJSONObject(JSONObject jSONObject0) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        return new JSONObject(jSONObject0.optString("custom"));
    }

    public final int getGrouplessNotifsCount(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        StatusBarNotification[] arr_statusBarNotification = this.getActiveNotifications(context0);
        int v1 = 0;
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            StatusBarNotification statusBarNotification0 = arr_statusBarNotification[v];
            if(!NotificationCompat.isGroupSummary(statusBarNotification0.getNotification()) && Intrinsics.areEqual("os_group_undefined", statusBarNotification0.getNotification().getGroup())) {
                ++v1;
            }
        }
        return v1;
    }

    public final String getNotificationIdFromFCMJson(JSONObject jSONObject0) {
        if(jSONObject0 == null) {
            return null;
        }
        try {
            JSONObject jSONObject1 = new JSONObject(jSONObject0.getString("custom"));
            if(jSONObject1.has("i")) {
                return jSONObject1.optString("i", null);
            }
            Logging.debug$default("Not a OneSignal formatted FCM message. No \'i\' field in custom.", null, 2, null);
        }
        catch(JSONException unused_ex) {
            Logging.debug$default("Not a OneSignal formatted FCM message. No \'custom\' field in the JSONObject.", null, 2, null);
        }
        return null;
    }

    public final NotificationManager getNotificationManager(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Object object0 = context0.getSystemService("notification");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager)object0;
    }

    public final Uri getSoundUri(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Resources resources0 = context0.getResources();
        if(AndroidUtils.INSTANCE.isValidResourceName(s)) {
            int v = resources0.getIdentifier(s, "raw", "com.MonsterCouch.Wingspan");
            if(v != 0) {
                return Uri.parse(("android.resource://com.MonsterCouch.Wingspan" + '/' + v));
            }
        }
        int v1 = resources0.getIdentifier("onesignal_default_sound", "raw", "com.MonsterCouch.Wingspan");
        return v1 == 0 ? null : Uri.parse(("android.resource://com.MonsterCouch.Wingspan" + '/' + v1));
    }

    public final boolean isGroupSummary(StatusBarNotification statusBarNotification0) {
        Intrinsics.checkNotNullParameter(statusBarNotification0, "notif");
        return (statusBarNotification0.getNotification().flags & 0x200) != 0;
    }

    public final long[] parseVibrationPattern(JSONObject jSONObject0) {
        JSONArray jSONArray0;
        Intrinsics.checkNotNullParameter(jSONObject0, "fcmBundle");
        try {
            Object object0 = jSONObject0.opt("vib_pt");
            if(object0 instanceof String) {
                jSONArray0 = new JSONArray(((String)object0));
            }
            else {
                Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type org.json.JSONArray");
                jSONArray0 = (JSONArray)object0;
            }
            long[] arr_v = new long[jSONArray0.length()];
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                arr_v[v1] = jSONArray0.optLong(v1);
            }
            return arr_v;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }
}

