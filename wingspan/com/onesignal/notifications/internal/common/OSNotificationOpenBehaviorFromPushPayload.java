package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/common/OSNotificationOpenBehaviorFromPushPayload;", "", "context", "Landroid/content/Context;", "fcmPayload", "Lorg/json/JSONObject;", "(Landroid/content/Context;Lorg/json/JSONObject;)V", "shouldOpenApp", "", "getShouldOpenApp", "()Z", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OSNotificationOpenBehaviorFromPushPayload {
    private final Context context;
    private final JSONObject fcmPayload;

    public OSNotificationOpenBehaviorFromPushPayload(Context context0, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(jSONObject0, "fcmPayload");
        super();
        this.context = context0;
        this.fcmPayload = jSONObject0;
    }

    public final boolean getShouldOpenApp() {
        return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(this.context) && this.getUri() == null;
    }

    public final Uri getUri() {
        if(!OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(this.context)) {
            return null;
        }
        if(OSNotificationOpenAppSettings.INSTANCE.getSuppressLaunchURL(this.context)) {
            return null;
        }
        JSONObject jSONObject0 = new JSONObject(this.fcmPayload.optString("custom"));
        if(jSONObject0.has("u")) {
            String s = jSONObject0.optString("u");
            if(!Intrinsics.areEqual(s, "")) {
                Intrinsics.checkNotNullExpressionValue(s, "url");
                int v = s.length() - 1;
                int v1 = 0;
                boolean z = false;
                while(v1 <= v) {
                    boolean z1 = Intrinsics.compare(s.charAt((z ? v : v1)), 0x20) <= 0;
                    if(z) {
                        if(!z1) {
                            break;
                        }
                        --v;
                    }
                    else if(z1) {
                        ++v1;
                    }
                    else {
                        z = true;
                    }
                }
                return Uri.parse(s.subSequence(v1, v + 1).toString());
            }
        }
        return null;
    }
}

