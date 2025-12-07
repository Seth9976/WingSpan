package com.onesignal.notifications.internal.common;

import android.content.Intent;
import android.os.Bundle;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001A\u0004\u0018\u00010\u00042\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0014\u0010\f\u001A\u0004\u0018\u00010\u00042\b\u0010\r\u001A\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0007\u001A\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/onesignal/notifications/internal/common/NotificationFormatHelper;", "", "()V", "PAYLOAD_OS_NOTIFICATION_ID", "", "PAYLOAD_OS_ROOT_CUSTOM", "getOSNotificationIdFromBundle", "bundle", "Landroid/os/Bundle;", "getOSNotificationIdFromJson", "jsonObject", "Lorg/json/JSONObject;", "getOSNotificationIdFromJsonString", "jsonStr", "isOneSignalBundle", "", "isOneSignalIntent", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationFormatHelper {
    public static final NotificationFormatHelper INSTANCE = null;
    public static final String PAYLOAD_OS_NOTIFICATION_ID = "i";
    public static final String PAYLOAD_OS_ROOT_CUSTOM = "custom";

    static {
        NotificationFormatHelper.INSTANCE = new NotificationFormatHelper();
    }

    private final String getOSNotificationIdFromBundle(Bundle bundle0) {
        if(bundle0 != null && !bundle0.isEmpty()) {
            String s = bundle0.getString("custom", null);
            if(s != null) {
                return this.getOSNotificationIdFromJsonString(s);
            }
            Logging.debug$default("Not a OneSignal formatted Bundle. No \'custom\' field in the bundle.", null, 2, null);
        }
        return null;
    }

    public final String getOSNotificationIdFromJson(JSONObject jSONObject0) {
        return jSONObject0 == null ? null : this.getOSNotificationIdFromJsonString(jSONObject0.optString("custom", null));
    }

    private final String getOSNotificationIdFromJsonString(String s) {
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            if(jSONObject0.has("i")) {
                return jSONObject0.optString("i", null);
            }
            Logging.debug$default("Not a OneSignal formatted JSON string. No \'i\' field in custom.", null, 2, null);
        }
        catch(JSONException unused_ex) {
            Logging.debug$default("Not a OneSignal formatted JSON String, error parsing string as JSON.", null, 2, null);
        }
        return null;
    }

    public final boolean isOneSignalBundle(Bundle bundle0) {
        return this.getOSNotificationIdFromBundle(bundle0) != null;
    }

    public final boolean isOneSignalIntent(Intent intent0) {
        return intent0 == null ? false : this.isOneSignalBundle(intent0.getExtras());
    }
}

