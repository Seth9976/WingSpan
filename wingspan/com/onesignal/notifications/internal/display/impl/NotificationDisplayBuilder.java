package com.onesignal.notifications.internal.display.impl;

import android.R.drawable;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.R.dimen;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.receivers.NotificationDismissReceiver;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00A4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001UB\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0006J4\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010 \u001A\u00020!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001A0#2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u001A0#H\u0002J,\u0010%\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001A0#2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u001A0#H\u0002J4\u0010&\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020!2\u0006\u0010\'\u001A\u00020(2\b\u0010)\u001A\u0004\u0018\u00010*2\u0006\u0010+\u001A\u00020\u00142\b\u0010,\u001A\u0004\u0018\u00010\u001AH\u0016J\u001A\u0010-\u001A\u00020\u001E2\b\u0010.\u001A\u0004\u0018\u00010/2\u0006\u00100\u001A\u000201H\u0016J\u0010\u00102\u001A\u00020\u00142\u0006\u00103\u001A\u00020\u0014H\u0002J\u0012\u00104\u001A\u0004\u0018\u0001052\u0006\u0010 \u001A\u00020!H\u0002J\u0010\u00106\u001A\u00020/2\u0006\u00107\u001A\u000208H\u0016J\u0014\u00109\u001A\u0004\u0018\u00010\u00102\b\u0010:\u001A\u0004\u0018\u00010\u001AH\u0002J\u0012\u0010;\u001A\u0004\u0018\u00010\u00102\u0006\u0010<\u001A\u00020\u001AH\u0002J\u0012\u0010=\u001A\u0004\u0018\u00010\u00102\u0006\u0010>\u001A\u00020\u001AH\u0002J\u0010\u0010?\u001A\u00020\u00142\u0006\u0010:\u001A\u00020\u001AH\u0002J\b\u0010@\u001A\u00020\u0014H\u0016J\u0012\u0010A\u001A\u0004\u0018\u00010\u00102\u0006\u0010 \u001A\u00020!H\u0002J\u0010\u0010B\u001A\u00020C2\u0006\u0010+\u001A\u00020\u0014H\u0016J\u0018\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020\u00142\u0006\u0010G\u001A\u00020CH\u0016J\u0012\u0010H\u001A\u00020\u00142\b\u0010I\u001A\u0004\u0018\u00010\u001AH\u0002J\u0010\u0010J\u001A\u00020\u00142\u0006\u0010 \u001A\u00020!H\u0002J\u0010\u0010K\u001A\u00020L2\u0006\u0010 \u001A\u00020!H\u0016J\u0010\u0010M\u001A\u00020N2\u0006\u0010 \u001A\u00020!H\u0002J\u0012\u0010O\u001A\u00020\u001E2\b\u0010P\u001A\u0004\u0018\u00010*H\u0016J\u0014\u0010Q\u001A\u0004\u0018\u00010\u00102\b\u0010R\u001A\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010S\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020!2\u0006\u0010T\u001A\u00020*H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\b8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u000F\u001A\u0004\u0018\u00010\u00108VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\u0018X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001A\u0004\u0018\u00010\u001A8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C\u00A8\u0006V"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder;", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationChannelManager", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;)V", "contextResources", "Landroid/content/res/Resources;", "getContextResources", "()Landroid/content/res/Resources;", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "defaultLargeIcon", "Landroid/graphics/Bitmap;", "getDefaultLargeIcon", "()Landroid/graphics/Bitmap;", "defaultSmallIconId", "", "getDefaultSmallIconId", "()I", "notificationDismissedClass", "Ljava/lang/Class;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "addAlertButtons", "", "context", "fcmJson", "Lorg/json/JSONObject;", "buttonsLabels", "", "buttonsIds", "addCustomAlertButtons", "addNotificationActionButtons", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "notificationId", "groupSummary", "addXiaomiSettings", "oneSignalNotificationBuilder", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "notification", "Landroid/app/Notification;", "convertOSToAndroidPriority", "priority", "getAccentColor", "Ljava/math/BigInteger;", "getBaseOneSignalNotificationBuilder", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "getBitmap", "name", "getBitmapFromAssetsOrResourceName", "bitmapStr", "getBitmapFromURL", "location", "getDrawableId", "getGroupAlertBehavior", "getLargeIcon", "getNewBaseDismissIntent", "Landroid/content/Intent;", "getNewDismissActionPendingIntent", "Landroid/app/PendingIntent;", "requestCode", "intent", "getResourceIcon", "iconName", "getSmallIconId", "getTitle", "", "isSoundEnabled", "", "removeNotifyOptions", "builder", "resizeBitmapForLargeIconArea", "bitmap", "setAlertnessOptions", "notifBuilder", "OneSignalNotificationBuilder", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationDisplayBuilder implements INotificationDisplayBuilder {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "", "()V", "compatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getCompatBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "setCompatBuilder", "(Landroidx/core/app/NotificationCompat$Builder;)V", "hasLargeIcon", "", "getHasLargeIcon", "()Z", "setHasLargeIcon", "(Z)V", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class OneSignalNotificationBuilder {
        private Builder compatBuilder;
        private boolean hasLargeIcon;

        public final Builder getCompatBuilder() {
            return this.compatBuilder;
        }

        public final boolean getHasLargeIcon() {
            return this.hasLargeIcon;
        }

        public final void setCompatBuilder(Builder notificationCompat$Builder0) {
            this.compatBuilder = notificationCompat$Builder0;
        }

        public final void setHasLargeIcon(boolean z) {
            this.hasLargeIcon = z;
        }
    }

    private final IApplicationService _applicationService;
    private final INotificationChannelManager _notificationChannelManager;
    private final Class notificationDismissedClass;

    public NotificationDisplayBuilder(IApplicationService iApplicationService0, INotificationChannelManager iNotificationChannelManager0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationChannelManager0, "_notificationChannelManager");
        super();
        this._applicationService = iApplicationService0;
        this._notificationChannelManager = iNotificationChannelManager0;
        this.notificationDismissedClass = NotificationDismissReceiver.class;
    }

    private final void addAlertButtons(Context context0, JSONObject jSONObject0, List list0, List list1) {
        try {
            this.addCustomAlertButtons(jSONObject0, list0, list1);
        }
        catch(Throwable throwable0) {
            Logging.error("Failed to parse JSON for custom buttons for alert dialog.", throwable0);
        }
        if(list0.size() == 0 || list0.size() < 3) {
            String s = AndroidUtils.INSTANCE.getResourceString(context0, "onesignal_in_app_alert_ok_button_text", "Ok");
            Intrinsics.checkNotNull(s);
            list0.add(s);
            list1.add("__DEFAULT__");
        }
    }

    private final void addCustomAlertButtons(JSONObject jSONObject0, List list0, List list1) throws JSONException {
        JSONObject jSONObject1 = new JSONObject(jSONObject0.optString("custom"));
        if(!jSONObject1.has("a")) {
            return;
        }
        JSONObject jSONObject2 = jSONObject1.getJSONObject("a");
        if(!jSONObject2.has("actionButtons")) {
            return;
        }
        JSONArray jSONArray0 = jSONObject2.optJSONArray("actionButtons");
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            JSONObject jSONObject3 = jSONArray0.getJSONObject(v1);
            String s = jSONObject3.optString("text");
            Intrinsics.checkNotNullExpressionValue(s, "button.optString(\"text\")");
            list0.add(s);
            String s1 = jSONObject3.optString("id");
            Intrinsics.checkNotNullExpressionValue(s1, "button.optString(\"id\")");
            list1.add(s1);
        }
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void addNotificationActionButtons(JSONObject jSONObject0, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0, Builder notificationCompat$Builder0, int v, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "fcmJson");
        Intrinsics.checkNotNullParameter(intentGeneratorForAttachingToNotifications0, "intentGenerator");
        try {
            JSONObject jSONObject1 = new JSONObject(jSONObject0.optString("custom"));
            if(!jSONObject1.has("a")) {
                return;
            }
            JSONObject jSONObject2 = jSONObject1.getJSONObject("a");
            if(!jSONObject2.has("actionButtons")) {
                return;
            }
            JSONArray jSONArray0 = jSONObject2.getJSONArray("actionButtons");
            int v1 = jSONArray0.length();
        label_11:
            for(int v2 = 0; v2 < v1; ++v2) {
                JSONObject jSONObject3 = jSONArray0.optJSONObject(v2);
                JSONObject jSONObject4 = new JSONObject(jSONObject0.toString());
                Intent intent0 = intentGeneratorForAttachingToNotifications0.getNewBaseIntent(v);
                intent0.setAction("" + v2);
                intent0.putExtra("action_button", true);
                jSONObject4.put("actionId", jSONObject3.optString("id"));
                intent0.putExtra("onesignalData", jSONObject4.toString());
                if(s != null) {
                    intent0.putExtra("summary", s);
                }
                else if(jSONObject0.has("grp")) {
                    intent0.putExtra("grp", jSONObject0.optString("grp"));
                }
                PendingIntent pendingIntent0 = intentGeneratorForAttachingToNotifications0.getNewActionPendingIntent(v, intent0);
                int v3 = jSONObject3.has("icon") ? this.getResourceIcon(jSONObject3.optString("icon")) : 0;
                Intrinsics.checkNotNull(notificationCompat$Builder0);
                notificationCompat$Builder0.addAction(v3, jSONObject3.optString("text"), pendingIntent0);
            }
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
            if(true) {
                return;
            }
            goto label_11;
        }
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void addXiaomiSettings(OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder0, Notification notification0) {
        Intrinsics.checkNotNullParameter(notification0, "notification");
        Intrinsics.checkNotNull(notificationDisplayBuilder$OneSignalNotificationBuilder0);
        if(!notificationDisplayBuilder$OneSignalNotificationBuilder0.getHasLargeIcon()) {
            return;
        }
        try {
            Object object0 = Class.forName("android.app.MiuiNotification").newInstance();
            Field field0 = object0.getClass().getDeclaredField("customizedIcon");
            field0.setAccessible(true);
            field0.set(object0, Boolean.TRUE);
            Field field1 = notification0.getClass().getField("extraNotification");
            field1.setAccessible(true);
            field1.set(notification0, object0);
        }
        catch(Throwable unused_ex) {
        }
    }

    private final int convertOSToAndroidPriority(int v) {
        if(v > 9) {
            return 2;
        }
        if(v > 7) {
            return 1;
        }
        if(v > 4) {
            return 0;
        }
        return v <= 2 ? -2 : -1;
    }

    private final BigInteger getAccentColor(JSONObject jSONObject0) {
        try {
            if(jSONObject0.has("bgac")) {
                return new BigInteger(jSONObject0.optString("bgac", null), 16);
            }
            goto label_2;
        }
        catch(Throwable unused_ex) {
            try {
            label_2:
                Context context0 = this._applicationService.getAppContext();
                String s = AndroidUtils.INSTANCE.getResourceString(context0, "onesignal_notification_accent_color", null);
                if(s != null) {
                    return new BigInteger(s, 16);
                }
                goto label_6;
            }
            catch(Throwable unused_ex) {
                try {
                label_6:
                    Context context1 = this._applicationService.getAppContext();
                    String s1 = AndroidUtils.INSTANCE.getManifestMeta(context1, "com.onesignal.NotificationAccentColor.DEFAULT");
                    return s1 == null ? null : new BigInteger(s1, 16);
                }
                catch(Throwable unused_ex) {
                }
                return null;
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob notificationGenerationJob0) {
        int v;
        Builder notificationCompat$Builder0;
        Intrinsics.checkNotNullParameter(notificationGenerationJob0, "notificationJob");
        JSONObject jSONObject0 = notificationGenerationJob0.getJsonPayload();
        Intrinsics.checkNotNull(jSONObject0);
        OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder0 = new OneSignalNotificationBuilder();
        try {
            String s = this._notificationChannelManager.createNotificationChannel(notificationGenerationJob0);
            Context context0 = this.getCurrentContext();
            Intrinsics.checkNotNull(context0);
            notificationCompat$Builder0 = new Builder(context0, s);
        }
        catch(Throwable unused_ex) {
            Context context1 = this.getCurrentContext();
            Intrinsics.checkNotNull(context1);
            notificationCompat$Builder0 = new Builder(context1);
        }
        String s1 = jSONObject0.optString("alert", null);
        notificationCompat$Builder0.setAutoCancel(true).setSmallIcon(this.getSmallIconId(jSONObject0)).setStyle(new BigTextStyle().bigText(s1)).setContentText(s1).setTicker(s1);
        if(Build.VERSION.SDK_INT < 24 || !Intrinsics.areEqual(jSONObject0.optString("title"), "")) {
            notificationCompat$Builder0.setContentTitle(this.getTitle(jSONObject0));
        }
        try {
            BigInteger bigInteger0 = this.getAccentColor(jSONObject0);
            if(bigInteger0 != null) {
                notificationCompat$Builder0.setColor(bigInteger0.intValue());
            }
        }
        catch(Throwable unused_ex) {
        }
        try {
            if(jSONObject0.has("vis")) {
                String s2 = jSONObject0.optString("vis");
                Intrinsics.checkNotNullExpressionValue(s2, "fcmJson.optString(\"vis\")");
                v = Integer.parseInt(s2);
            }
            else {
                v = 1;
            }
            notificationCompat$Builder0.setVisibility(v);
        }
        catch(Throwable unused_ex) {
        }
        Bitmap bitmap0 = this.getLargeIcon(jSONObject0);
        if(bitmap0 != null) {
            notificationDisplayBuilder$OneSignalNotificationBuilder0.setHasLargeIcon(true);
            notificationCompat$Builder0.setLargeIcon(bitmap0);
        }
        Bitmap bitmap1 = this.getBitmap(jSONObject0.optString("bicon", null));
        if(bitmap1 != null) {
            notificationCompat$Builder0.setStyle(new BigPictureStyle().bigPicture(bitmap1).setSummaryText(s1));
        }
        if(notificationGenerationJob0.getShownTimeStamp() != null) {
            try {
                Long long0 = notificationGenerationJob0.getShownTimeStamp();
                Intrinsics.checkNotNull(long0);
                notificationCompat$Builder0.setWhen(((long)long0) * 1000L);
            }
            catch(Throwable unused_ex) {
            }
        }
        this.setAlertnessOptions(jSONObject0, notificationCompat$Builder0);
        notificationDisplayBuilder$OneSignalNotificationBuilder0.setCompatBuilder(notificationCompat$Builder0);
        return notificationDisplayBuilder$OneSignalNotificationBuilder0;
    }

    private final Bitmap getBitmap(String s) {
        if(s == null) {
            return null;
        }
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
        String s1 = s.subSequence(v1, v + 1).toString();
        return StringsKt.startsWith$default(s1, "http://", false, 2, null) || StringsKt.startsWith$default(s1, "https://", false, 2, null) ? this.getBitmapFromURL(s1) : this.getBitmapFromAssetsOrResourceName(s);
    }

    private final Bitmap getBitmapFromAssetsOrResourceName(String s) {
        String s1;
        Bitmap bitmap0;
        try {
            Context context0 = this.getCurrentContext();
            Intrinsics.checkNotNull(context0);
            bitmap0 = null;
            bitmap0 = BitmapFactory.decodeStream(context0.getAssets().open(s));
        }
        catch(Throwable unused_ex) {
        }
        if(bitmap0 != null) {
            return bitmap0;
        }
        try {
            Iterator iterator0 = Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"}).iterator();
            while(true) {
            label_7:
                if(!iterator0.hasNext()) {
                    int v = this.getResourceIcon(s);
                    return v == 0 ? null : BitmapFactory.decodeResource(this.getContextResources(), v);
                }
                Object object0 = iterator0.next();
                s1 = (String)object0;
                break;
            }
        }
        catch(Throwable unused_ex) {
            return null;
        }
        try {
            Context context1 = this.getCurrentContext();
            Intrinsics.checkNotNull(context1);
            bitmap0 = BitmapFactory.decodeStream(context1.getAssets().open(s + s1));
        }
        catch(Throwable unused_ex) {
        }
        try {
            if(bitmap0 == null) {
                goto label_7;
            }
            return bitmap0;
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    private final Bitmap getBitmapFromURL(String s) {
        try {
            return BitmapFactory.decodeStream(new URL(s).openConnection().getInputStream());
        }
        catch(Throwable throwable0) {
            Logging.warn("Could not download image!", throwable0);
            return null;
        }
    }

    private final Resources getContextResources() {
        return this._applicationService.getAppContext().getResources();
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public Bitmap getDefaultLargeIcon() {
        return this.resizeBitmapForLargeIconArea(this.getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default"));
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public int getDefaultSmallIconId() {
        int v = this.getDrawableId("ic_stat_onesignal_default");
        if(v != 0) {
            return v;
        }
        int v1 = this.getDrawableId("corona_statusbar_icon_default");
        if(v1 != 0) {
            return v1;
        }
        int v2 = this.getDrawableId("ic_os_notification_fallback_white_24dp");
        return v2 == 0 ? 0x108005E : v2;
    }

    private final int getDrawableId(String s) {
        Resources resources0 = this.getContextResources();
        Intrinsics.checkNotNull(resources0);
        return resources0.getIdentifier(s, "drawable", this.getPackageName());
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public int getGroupAlertBehavior() {
        return Build.VERSION.SDK_INT < 24 ? 1 : 2;
    }

    private final Bitmap getLargeIcon(JSONObject jSONObject0) {
        Bitmap bitmap0 = this.getBitmap(jSONObject0.optString("licon"));
        if(bitmap0 == null) {
            bitmap0 = this.getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default");
        }
        return bitmap0 == null ? null : this.resizeBitmapForLargeIconArea(bitmap0);
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public Intent getNewBaseDismissIntent(int v) {
        Intent intent0 = new Intent(this.getCurrentContext(), this.notificationDismissedClass).putExtra("androidNotificationId", v).putExtra("dismissed", true);
        Intrinsics.checkNotNullExpressionValue(intent0, "Intent(currentContext, n…tExtra(\"dismissed\", true)");
        return intent0;
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public PendingIntent getNewDismissActionPendingIntent(int v, Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(this.getCurrentContext(), v, intent0, 0xC000000);
        Intrinsics.checkNotNullExpressionValue(pendingIntent0, "getBroadcast(\n          …FLAG_IMMUTABLE,\n        )");
        return pendingIntent0;
    }

    private final String getPackageName() {
        return "com.MonsterCouch.Wingspan";
    }

    private final int getResourceIcon(String s) {
        if(s == null) {
            return 0;
        }
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
        String s1 = s.subSequence(v1, v + 1).toString();
        if(!AndroidUtils.INSTANCE.isValidResourceName(s1)) {
            return 0;
        }
        int v2 = this.getDrawableId(s1);
        if(v2 != 0) {
            return v2;
        }
        try {
            return R.drawable.class.getField(s).getInt(null);
        }
        catch(Throwable unused_ex) {
            return 0;
        }
    }

    private final int getSmallIconId(JSONObject jSONObject0) {
        int v = this.getResourceIcon(jSONObject0.optString("sicon", null));
        return v == 0 ? this.getDefaultSmallIconId() : v;
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public CharSequence getTitle(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "fcmJson");
        CharSequence charSequence0 = jSONObject0.optString("title", null);
        if(charSequence0 == null) {
            Context context0 = this.getCurrentContext();
            Intrinsics.checkNotNull(context0);
            PackageManager packageManager0 = context0.getPackageManager();
            Context context1 = this.getCurrentContext();
            Intrinsics.checkNotNull(context1);
            charSequence0 = packageManager0.getApplicationLabel(context1.getApplicationInfo());
            Intrinsics.checkNotNullExpressionValue(charSequence0, "currentContext!!.package…cationInfo,\n            )");
        }
        return charSequence0;
    }

    private final boolean isSoundEnabled(JSONObject jSONObject0) {
        String s = jSONObject0.optString("sound", null);
        return !Intrinsics.areEqual("null", s) && !Intrinsics.areEqual("nil", s);
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void removeNotifyOptions(Builder notificationCompat$Builder0) {
        Intrinsics.checkNotNull(notificationCompat$Builder0);
        notificationCompat$Builder0.setOnlyAlertOnce(true).setDefaults(0).setSound(null).setVibrate(null).setTicker(null);
    }

    private final Bitmap resizeBitmapForLargeIconArea(Bitmap bitmap0) {
        if(bitmap0 == null) {
            return null;
        }
        try {
            Resources resources0 = this.getContextResources();
            Intrinsics.checkNotNull(resources0);
            int v = (int)resources0.getDimension(dimen.notification_large_icon_height);
            Resources resources1 = this.getContextResources();
            Intrinsics.checkNotNull(resources1);
            int v1 = (int)resources1.getDimension(dimen.notification_large_icon_width);
            int v2 = bitmap0.getHeight();
            int v3 = bitmap0.getWidth();
            if(v3 > v1 || v2 > v) {
                if(v2 > v3) {
                    v1 = (int)(((float)v) * (((float)v3) / ((float)v2)));
                }
                else if(v3 > v2) {
                    v = (int)(((float)v1) * (((float)v2) / ((float)v3)));
                }
                return Bitmap.createScaledBitmap(bitmap0, v1, v, true);
            }
        }
        catch(Throwable unused_ex) {
        }
        return bitmap0;
    }

    private final void setAlertnessOptions(JSONObject jSONObject0, Builder notificationCompat$Builder0) {
        int v = this.convertOSToAndroidPriority(jSONObject0.optInt("pri", 6));
        notificationCompat$Builder0.setPriority(v);
        int v1 = 0;
        if(v < 0) {
            return;
        }
        if(!jSONObject0.has("ledc") || jSONObject0.optInt("led", 1) != 1) {
        label_8:
            v1 = 4;
        }
        else {
            try {
                notificationCompat$Builder0.setLights(new BigInteger(jSONObject0.optString("ledc"), 16).intValue(), 2000, 5000);
                goto label_9;
            }
            catch(Throwable unused_ex) {
            }
            goto label_8;
        }
    label_9:
        if(jSONObject0.optInt("vib", 1) == 1) {
            if(jSONObject0.has("vib_pt")) {
                long[] arr_v = NotificationHelper.INSTANCE.parseVibrationPattern(jSONObject0);
                if(arr_v != null) {
                    notificationCompat$Builder0.setVibrate(arr_v);
                }
            }
            else {
                v1 |= 2;
            }
        }
        if(this.isSoundEnabled(jSONObject0)) {
            Context context0 = this.getCurrentContext();
            Intrinsics.checkNotNull(context0);
            String s = jSONObject0.optString("sound", null);
            Uri uri0 = NotificationHelper.INSTANCE.getSoundUri(context0, s);
            if(uri0 == null) {
                v1 |= 1;
            }
            else {
                notificationCompat$Builder0.setSound(uri0);
            }
        }
        notificationCompat$Builder0.setDefaults(v1);
    }
}

