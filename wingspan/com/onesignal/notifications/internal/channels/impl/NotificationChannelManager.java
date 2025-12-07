package com.onesignal.notifications.internal.channels.impl;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0003J\u0010\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000FH\u0003J\u0010\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0010\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000FH\u0003J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0002J\u0012\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2 = {"Lcom/onesignal/notifications/internal/channels/impl/NotificationChannelManager;", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "hexPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "createChannel", "", "context", "Landroid/content/Context;", "notificationManager", "Landroid/app/NotificationManager;", "payload", "Lorg/json/JSONObject;", "createDefaultChannel", "createNotificationChannel", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "createRestoreChannel", "priorityToImportance", "", "priority", "processChannelList", "", "list", "Lorg/json/JSONArray;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationChannelManager implements INotificationChannelManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/channels/impl/NotificationChannelManager$Companion;", "", "()V", "CHANNEL_PREFIX", "", "DEFAULT_CHANNEL_ID", "RESTORE_CHANNEL_ID", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String CHANNEL_PREFIX = "OS_";
    public static final Companion Companion = null;
    private static final String DEFAULT_CHANNEL_ID = "fcm_fallback_notification_channel";
    private static final String RESTORE_CHANNEL_ID = "restored_OS_notifications";
    private final IApplicationService _applicationService;
    private final ILanguageContext _languageContext;
    private final Pattern hexPattern;

    static {
        NotificationChannelManager.Companion = new Companion(null);
    }

    public NotificationChannelManager(IApplicationService iApplicationService0, ILanguageContext iLanguageContext0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iLanguageContext0, "_languageContext");
        super();
        this._applicationService = iApplicationService0;
        this._languageContext = iLanguageContext0;
        this.hexPattern = Pattern.compile("^([A-Fa-f0-9]{8})$");
    }

    private final String createChannel(Context context0, NotificationManager notificationManager0, JSONObject jSONObject0) throws JSONException {
        JSONObject jSONObject3;
        JSONObject jSONObject1;
        Object object0 = jSONObject0.opt("chnl");
        if(object0 instanceof String) {
            jSONObject1 = new JSONObject(((String)object0));
        }
        else {
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type org.json.JSONObject");
            jSONObject1 = (JSONObject)object0;
        }
        String s = "fcm_fallback_notification_channel";
        String s1 = jSONObject1.optString("id", "fcm_fallback_notification_channel");
        if(!Intrinsics.areEqual(s1, "miscellaneous")) {
            s = s1;
        }
        if(jSONObject1.has("langs")) {
            JSONObject jSONObject2 = jSONObject1.getJSONObject("langs");
            String s2 = this._languageContext.getLanguage();
            jSONObject3 = jSONObject2.has(s2) ? jSONObject2.optJSONObject(s2) : jSONObject1;
        }
        else {
            jSONObject3 = jSONObject1;
        }
        Intrinsics.checkNotNull(jSONObject3);
        NotificationChannel notificationChannel0 = new NotificationChannel(s, jSONObject3.optString("nm", "Miscellaneous"), this.priorityToImportance(jSONObject0.optInt("pri", 6)));
        notificationChannel0.setDescription(jSONObject3.optString("dscr", null));
        if(jSONObject1.has("grp_id")) {
            String s3 = jSONObject1.optString("grp_id");
            String s4 = jSONObject3.optString("grp_nm");
            Intrinsics.checkNotNullExpressionValue(s4, "payloadWithText.optString(\"grp_nm\")");
            notificationManager0.createNotificationChannelGroup(new NotificationChannelGroup(s3, s4));
            notificationChannel0.setGroup(s3);
        }
        if(jSONObject0.has("ledc")) {
            String s5 = jSONObject0.optString("ledc");
            if(!this.hexPattern.matcher(s5).matches()) {
                Logging.warn$default("OneSignal LED Color Settings: ARGB Hex value incorrect format (E.g: FF9900FF)", null, 2, null);
                s5 = "FFFFFFFF";
            }
            try {
                notificationChannel0.setLightColor(new BigInteger(s5, 16).intValue());
            }
            catch(Throwable throwable0) {
                Logging.error("Couldn\'t convert ARGB Hex value to BigInteger:", throwable0);
            }
        }
        boolean z = true;
        notificationChannel0.enableLights(jSONObject0.optInt("led", 1) == 1);
        if(jSONObject0.has("vib_pt")) {
            long[] arr_v = NotificationHelper.INSTANCE.parseVibrationPattern(jSONObject0);
            if(arr_v != null) {
                notificationChannel0.setVibrationPattern(arr_v);
            }
        }
        notificationChannel0.enableVibration(jSONObject0.optInt("vib", 1) == 1);
        if(jSONObject0.has("sound")) {
            String s6 = jSONObject0.optString("sound", null);
            Uri uri0 = NotificationHelper.INSTANCE.getSoundUri(context0, s6);
            if(uri0 != null) {
                notificationChannel0.setSound(uri0, null);
            }
            else if(Intrinsics.areEqual("null", s6) || Intrinsics.areEqual("nil", s6)) {
                notificationChannel0.setSound(null, null);
            }
        }
        notificationChannel0.setLockscreenVisibility(jSONObject0.optInt("vis", 0));
        notificationChannel0.setShowBadge(jSONObject0.optInt("bdg", 1) == 1);
        if(jSONObject0.optInt("bdnd", 0) != 1) {
            z = false;
        }
        notificationChannel0.setBypassDnd(z);
        Logging.verbose$default(("Creating notification channel with channel:\n" + notificationChannel0), null, 2, null);
        try {
            notificationManager0.createNotificationChannel(notificationChannel0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            illegalArgumentException0.printStackTrace();
        }
        Intrinsics.checkNotNullExpressionValue(s, "channelId");
        return s;
    }

    private final String createDefaultChannel(NotificationManager notificationManager0) {
        NotificationChannel notificationChannel0 = new NotificationChannel("fcm_fallback_notification_channel", "Miscellaneous", 3);
        notificationChannel0.enableLights(true);
        notificationChannel0.enableVibration(true);
        notificationManager0.createNotificationChannel(notificationChannel0);
        return "fcm_fallback_notification_channel";
    }

    @Override  // com.onesignal.notifications.internal.channels.INotificationChannelManager
    public String createNotificationChannel(NotificationGenerationJob notificationGenerationJob0) {
        Intrinsics.checkNotNullParameter(notificationGenerationJob0, "notificationJob");
        if(Build.VERSION.SDK_INT < 26) {
            return "fcm_fallback_notification_channel";
        }
        Context context0 = this._applicationService.getAppContext();
        JSONObject jSONObject0 = notificationGenerationJob0.getJsonPayload();
        Intrinsics.checkNotNull(jSONObject0);
        NotificationManager notificationManager0 = NotificationHelper.INSTANCE.getNotificationManager(context0);
        if(notificationGenerationJob0.isRestoring()) {
            return this.createRestoreChannel(notificationManager0);
        }
        if(jSONObject0.has("oth_chnl")) {
            String s = jSONObject0.optString("oth_chnl");
            if(notificationManager0.getNotificationChannel(s) != null) {
                Intrinsics.checkNotNullExpressionValue(s, "otherChannel");
                return s;
            }
        }
        if(!jSONObject0.has("chnl")) {
            return this.createDefaultChannel(notificationManager0);
        }
        try {
            return this.createChannel(context0, notificationManager0, jSONObject0);
        }
        catch(JSONException jSONException0) {
            Logging.error("Could not create notification channel due to JSON payload error!", jSONException0);
            return "fcm_fallback_notification_channel";
        }
    }

    private final String createRestoreChannel(NotificationManager notificationManager0) {
        notificationManager0.createNotificationChannel(new NotificationChannel("restored_OS_notifications", "Restored", 2));
        return "restored_OS_notifications";
    }

    private final int priorityToImportance(int v) {
        if(v > 9) {
            return 5;
        }
        if(v > 7) {
            return 4;
        }
        if(v > 5) {
            return 3;
        }
        if(v > 3) {
            return 2;
        }
        return v > 1 ? 1 : 0;
    }

    @Override  // com.onesignal.notifications.internal.channels.INotificationChannelManager
    public void processChannelList(JSONArray jSONArray0) {
        if(Build.VERSION.SDK_INT < 26) {
            return;
        }
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            Context context0 = this._applicationService.getAppContext();
            NotificationManager notificationManager0 = NotificationHelper.INSTANCE.getNotificationManager(context0);
            Set set0 = new HashSet();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                try {
                    Context context1 = this._applicationService.getAppContext();
                    JSONObject jSONObject0 = jSONArray0.getJSONObject(v1);
                    Intrinsics.checkNotNullExpressionValue(jSONObject0, "list.getJSONObject(i)");
                    set0.add(this.createChannel(context1, notificationManager0, jSONObject0));
                }
                catch(JSONException jSONException0) {
                    Logging.error("Could not create notification channel due to JSON payload error!", jSONException0);
                }
            }
            if(set0.isEmpty()) {
                return;
            }
            List list0 = new ArrayList();
            try {
                List list1 = notificationManager0.getNotificationChannels();
                Intrinsics.checkNotNullExpressionValue(list1, "notificationManager.notificationChannels");
                list0 = list1;
            }
            catch(NullPointerException nullPointerException0) {
                Logging.error$default(("Error when trying to delete notification channel: " + nullPointerException0.getMessage()), null, 2, null);
            }
            for(Object object0: list0) {
                String s = ((NotificationChannel)object0).getId();
                Intrinsics.checkNotNullExpressionValue(s, "id");
                if(StringsKt.startsWith$default(s, "OS_", false, 2, null) && !set0.contains(s)) {
                    notificationManager0.deleteNotificationChannel(s);
                }
            }
        }
    }
}

