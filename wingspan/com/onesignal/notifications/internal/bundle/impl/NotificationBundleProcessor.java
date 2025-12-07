package com.onesignal.notifications.internal.bundle.impl;

import android.content.Context;
import android.os.Bundle;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor.ProcessedBundleResult;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002J\u001A\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\nH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/notifications/internal/bundle/impl/NotificationBundleProcessor;", "Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor;", "_workManager", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;Lcom/onesignal/core/internal/time/ITime;)V", "maximizeButtonsFromBundle", "", "fcmBundle", "Landroid/os/Bundle;", "processBundleFromReceiver", "Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor$ProcessedBundleResult;", "context", "Landroid/content/Context;", "bundle", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationBundleProcessor implements INotificationBundleProcessor {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/internal/bundle/impl/NotificationBundleProcessor$Companion;", "", "()V", "ANDROID_NOTIFICATION_ID", "", "DEFAULT_ACTION", "PUSH_ADDITIONAL_DATA_KEY", "PUSH_MINIFIED_BUTTONS_LIST", "PUSH_MINIFIED_BUTTON_ICON", "PUSH_MINIFIED_BUTTON_ID", "PUSH_MINIFIED_BUTTON_TEXT", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String ANDROID_NOTIFICATION_ID = "android_notif_id";
    public static final Companion Companion = null;
    public static final String DEFAULT_ACTION = "__DEFAULT__";
    public static final String PUSH_ADDITIONAL_DATA_KEY = "a";
    public static final String PUSH_MINIFIED_BUTTONS_LIST = "o";
    public static final String PUSH_MINIFIED_BUTTON_ICON = "p";
    public static final String PUSH_MINIFIED_BUTTON_ID = "i";
    public static final String PUSH_MINIFIED_BUTTON_TEXT = "n";
    private final ITime _time;
    private final INotificationGenerationWorkManager _workManager;

    static {
        NotificationBundleProcessor.Companion = new Companion(null);
    }

    public NotificationBundleProcessor(INotificationGenerationWorkManager iNotificationGenerationWorkManager0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iNotificationGenerationWorkManager0, "_workManager");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._workManager = iNotificationGenerationWorkManager0;
        this._time = iTime0;
    }

    private final void maximizeButtonsFromBundle(Bundle bundle0) {
        String s1;
        JSONObject jSONObject1;
        if(!bundle0.containsKey("o")) {
            return;
        }
        try {
            JSONObject jSONObject0 = new JSONObject(bundle0.getString("custom"));
            if(jSONObject0.has("a")) {
                jSONObject1 = jSONObject0.getJSONObject("a");
                Intrinsics.checkNotNullExpressionValue(jSONObject1, "{\n                    cu…      )\n                }");
            }
            else {
                jSONObject1 = new JSONObject();
            }
            JSONArray jSONArray0 = new JSONArray(bundle0.getString("o"));
            bundle0.remove("o");
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject2 = jSONArray0.getJSONObject(v1);
                String s = jSONObject2.getString("n");
                jSONObject2.remove("n");
                if(jSONObject2.has("i")) {
                    s1 = jSONObject2.getString("i");
                    jSONObject2.remove("i");
                }
                else {
                    s1 = s;
                }
                jSONObject2.put("id", s1);
                jSONObject2.put("text", s);
                if(jSONObject2.has("p")) {
                    jSONObject2.put("icon", jSONObject2.getString("p"));
                    jSONObject2.remove("p");
                }
            }
            jSONObject1.put("actionButtons", jSONArray0);
            jSONObject1.put("actionId", "__DEFAULT__");
            if(!jSONObject0.has("a")) {
                jSONObject0.put("a", jSONObject1);
            }
            bundle0.putString("custom", jSONObject0.toString());
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    @Override  // com.onesignal.notifications.internal.bundle.INotificationBundleProcessor
    public ProcessedBundleResult processBundleFromReceiver(Context context0, Bundle bundle0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(bundle0, "bundle");
        ProcessedBundleResult iNotificationBundleProcessor$ProcessedBundleResult0 = new ProcessedBundleResult();
        if(!NotificationFormatHelper.INSTANCE.isOneSignalBundle(bundle0)) {
            return iNotificationBundleProcessor$ProcessedBundleResult0;
        }
        iNotificationBundleProcessor$ProcessedBundleResult0.setOneSignalPayload(true);
        this.maximizeButtonsFromBundle(bundle0);
        JSONObject jSONObject0 = JSONUtils.INSTANCE.bundleAsJSONObject(bundle0);
        long v = this._time.getCurrentTimeMillis();
        boolean z = bundle0.getBoolean("is_restoring", false);
        String s = bundle0.getString("pri", "0");
        Intrinsics.checkNotNullExpressionValue(s, "bundle.getString(\"pri\", \"0\")");
        boolean z1 = Integer.parseInt(s) > 9;
        String s1 = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject0);
        int v1 = bundle0.containsKey("android_notif_id") ? bundle0.getInt("android_notif_id") : 0;
        Intrinsics.checkNotNull(s1);
        iNotificationBundleProcessor$ProcessedBundleResult0.setWorkManagerProcessing(this._workManager.beginEnqueueingWork(context0, s1, v1, jSONObject0, v / 1000L, z, z1));
        return iNotificationBundleProcessor$ProcessedBundleResult0;
    }
}

