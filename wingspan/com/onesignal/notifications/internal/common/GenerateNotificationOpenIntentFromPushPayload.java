package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.onesignal.common.AndroidUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bJ\u0014\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0002¨\u0006\r"}, d2 = {"Lcom/onesignal/notifications/internal/common/GenerateNotificationOpenIntentFromPushPayload;", "", "()V", "create", "Lcom/onesignal/notifications/internal/common/GenerateNotificationOpenIntent;", "context", "Landroid/content/Context;", "fcmPayload", "Lorg/json/JSONObject;", "openBrowserIntent", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class GenerateNotificationOpenIntentFromPushPayload {
    public static final GenerateNotificationOpenIntentFromPushPayload INSTANCE;

    static {
        GenerateNotificationOpenIntentFromPushPayload.INSTANCE = new GenerateNotificationOpenIntentFromPushPayload();
    }

    public final GenerateNotificationOpenIntent create(Context context0, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(jSONObject0, "fcmPayload");
        OSNotificationOpenBehaviorFromPushPayload oSNotificationOpenBehaviorFromPushPayload0 = new OSNotificationOpenBehaviorFromPushPayload(context0, jSONObject0);
        return new GenerateNotificationOpenIntent(context0, this.openBrowserIntent(oSNotificationOpenBehaviorFromPushPayload0.getUri()), oSNotificationOpenBehaviorFromPushPayload0.getShouldOpenApp());
    }

    private final Intent openBrowserIntent(Uri uri0) {
        return uri0 == null ? null : AndroidUtils.INSTANCE.openURLInBrowserIntent(uri0);
    }
}

