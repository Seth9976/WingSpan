package com.onesignal.notifications.internal.display.impl;

import android.R.drawable;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.Extender;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.AndroidSupportV4Compat.ContextCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.exceptions.MainThreadException;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.R.id;
import com.onesignal.notifications.R.layout;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u00A2\u0006\u0002\u0010\nJ\u001A\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0002J\u001A\u0010\u001F\u001A\u00020\u00142\u0006\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u001EH\u0002J*\u0010#\u001A\u00020$2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\u001C2\u0006\u0010(\u001A\u00020)H\u0002J\u0019\u0010*\u001A\u00020+2\u0006\u0010 \u001A\u00020!H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010,J\u0019\u0010-\u001A\u00020+2\u0006\u0010 \u001A\u00020!H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010,J\u0014\u0010.\u001A\u0004\u0018\u00010/2\b\u00100\u001A\u0004\u0018\u00010\u0017H\u0002J\u0012\u00101\u001A\u0004\u0018\u00010/2\u0006\u00102\u001A\u00020\u0017H\u0002J\u0012\u00103\u001A\u0004\u0018\u00010/2\u0006\u00104\u001A\u00020\u0017H\u0002J\u0010\u00105\u001A\u00020)2\u0006\u00100\u001A\u00020\u0017H\u0002J\u0012\u00106\u001A\u00020)2\b\u00107\u001A\u0004\u0018\u00010\u0017H\u0002J!\u00108\u001A\u0004\u0018\u00010)2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u00109\u001A\u00020\u0017H\u0002\u00A2\u0006\u0002\u0010:J2\u0010;\u001A\u00020\u00142\u0006\u0010<\u001A\u00020=2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010>\u001A\u00020)2\u0006\u0010?\u001A\u00020\u00172\u0006\u0010@\u001A\u00020\u0017H\u0002J\u0019\u0010A\u001A\u00020+2\u0006\u0010 \u001A\u00020!H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010,R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\u0004\u0018\u00010\f8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00108BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u00148F\u00A2\u0006\u0006\u001A\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0016\u001A\u0004\u0018\u00010\u00178BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006B"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayer;", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationLimitManager", "Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;", "_summaryNotificationDisplayer", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_notificationDisplayBuilder", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;)V", "contextResources", "Landroid/content/res/Resources;", "getContextResources", "()Landroid/content/res/Resources;", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "isRunningOnMainThreadCheck", "", "()Lkotlin/Unit;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "addBackgroundImage", "fcmJson", "Lorg/json/JSONObject;", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "applyNotificationExtender", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "notificationBuilder", "createGenericPendingIntentsForNotif", "Landroid/app/Notification;", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "gcmBundle", "notificationId", "", "displayIAMPreviewNotification", "", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayNotification", "getBitmap", "Landroid/graphics/Bitmap;", "name", "getBitmapFromAssetsOrResourceName", "bitmapStr", "getBitmapFromURL", "location", "getDrawableId", "getResourceIcon", "iconName", "safeGetColorFromHex", "colorKey", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "setTextColor", "customView", "Landroid/widget/RemoteViews;", "viewId", "colorPayloadKey", "colorDefaultResource", "showNotification", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationDisplayer implements INotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;
    private final INotificationLimitManager _notificationLimitManager;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;

    public NotificationDisplayer(IApplicationService iApplicationService0, INotificationLimitManager iNotificationLimitManager0, ISummaryNotificationDisplayer iSummaryNotificationDisplayer0, INotificationDisplayBuilder iNotificationDisplayBuilder0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationLimitManager0, "_notificationLimitManager");
        Intrinsics.checkNotNullParameter(iSummaryNotificationDisplayer0, "_summaryNotificationDisplayer");
        Intrinsics.checkNotNullParameter(iNotificationDisplayBuilder0, "_notificationDisplayBuilder");
        super();
        this._applicationService = iApplicationService0;
        this._notificationLimitManager = iNotificationLimitManager0;
        this._summaryNotificationDisplayer = iSummaryNotificationDisplayer0;
        this._notificationDisplayBuilder = iNotificationDisplayBuilder0;
    }

    private final void addBackgroundImage(JSONObject jSONObject0, Builder notificationCompat$Builder0) throws Throwable {
        String s1;
        Bitmap bitmap0;
        JSONObject jSONObject1;
        if(Build.VERSION.SDK_INT >= 0x1F) {
            Logging.verbose$default(("Cannot use background images in notifications for device on version: " + Build.VERSION.SDK_INT), null, 2, null);
            return;
        }
        String s = jSONObject0.optString("bg_img", null);
        if(s == null) {
            bitmap0 = null;
            jSONObject1 = null;
        }
        else {
            jSONObject1 = new JSONObject(s);
            bitmap0 = this.getBitmap(jSONObject1.optString("img", null));
        }
        if(bitmap0 == null) {
            bitmap0 = this.getBitmapFromAssetsOrResourceName("onesignal_bgimage_default_image");
        }
        if(bitmap0 != null) {
            Intrinsics.checkNotNull(this.getCurrentContext());
            RemoteViews remoteViews0 = new RemoteViews("com.MonsterCouch.Wingspan", layout.onesignal_bgimage_notif_layout);
            CharSequence charSequence0 = this._notificationDisplayBuilder.getTitle(jSONObject0);
            remoteViews0.setTextViewText(id.os_bgimage_notif_title, charSequence0);
            CharSequence charSequence1 = jSONObject0.optString("alert");
            remoteViews0.setTextViewText(id.os_bgimage_notif_body, charSequence1);
            this.setTextColor(remoteViews0, jSONObject1, id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
            this.setTextColor(remoteViews0, jSONObject1, id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
            if(jSONObject1 == null || !jSONObject1.has("img_align")) {
                Resources resources0 = this.getContextResources();
                Intrinsics.checkNotNull(resources0);
                int v = resources0.getIdentifier("onesignal_bgimage_notif_image_align", "string", this.getPackageName());
                if(v == 0) {
                    s1 = null;
                }
                else {
                    Resources resources1 = this.getContextResources();
                    Intrinsics.checkNotNull(resources1);
                    s1 = resources1.getString(v);
                }
            }
            else {
                s1 = jSONObject1.getString("img_align");
            }
            if(Intrinsics.areEqual("right", s1)) {
                remoteViews0.setViewPadding(id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                remoteViews0.setImageViewBitmap(id.os_bgimage_notif_bgimage_right_aligned, bitmap0);
                remoteViews0.setViewVisibility(id.os_bgimage_notif_bgimage_right_aligned, 0);
                remoteViews0.setViewVisibility(id.os_bgimage_notif_bgimage, 8);
            }
            else {
                remoteViews0.setImageViewBitmap(id.os_bgimage_notif_bgimage, bitmap0);
            }
            Intrinsics.checkNotNull(notificationCompat$Builder0);
            notificationCompat$Builder0.setContent(remoteViews0);
            notificationCompat$Builder0.setStyle(null);
        }
    }

    private final void applyNotificationExtender(NotificationGenerationJob notificationGenerationJob0, Builder notificationCompat$Builder0) {
        if(!notificationGenerationJob0.hasExtender()) {
            return;
        }
        Builder.class.getDeclaredField("mNotification").setAccessible(true);
        Notification notification0 = notificationCompat$Builder0.mNotification;
        Intrinsics.checkNotNull(notification0, "null cannot be cast to non-null type android.app.Notification");
        notificationGenerationJob0.setOrgFlags(notification0.flags);
        notificationGenerationJob0.setOrgSound(notification0.sound);
        Intrinsics.checkNotNull(notificationCompat$Builder0);
        com.onesignal.notifications.internal.Notification notification1 = notificationGenerationJob0.getNotification();
        Intrinsics.checkNotNull(notification1);
        Extender notificationCompat$Extender0 = notification1.getNotificationExtender();
        Intrinsics.checkNotNull(notificationCompat$Extender0);
        notificationCompat$Builder0.extend(notificationCompat$Extender0);
        Notification notification2 = notificationCompat$Builder0.mNotification;
        Intrinsics.checkNotNull(notification2, "null cannot be cast to non-null type android.app.Notification");
        Builder.class.getDeclaredField("mContentText").setAccessible(true);
        CharSequence charSequence0 = notificationCompat$Builder0.mContentText;
        Builder.class.getDeclaredField("mContentTitle").setAccessible(true);
        CharSequence charSequence1 = notificationCompat$Builder0.mContentTitle;
        notificationGenerationJob0.setOverriddenBodyFromExtender(charSequence0);
        notificationGenerationJob0.setOverriddenTitleFromExtender(charSequence1);
        if(!notificationGenerationJob0.isRestoring()) {
            notificationGenerationJob0.setOverriddenFlags(notification2.flags);
            notificationGenerationJob0.setOverriddenSound(notification2.sound);
        }
    }

    private final Notification createGenericPendingIntentsForNotif(Builder notificationCompat$Builder0, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0, JSONObject jSONObject0, int v) {
        Random random0 = new SecureRandom();
        int v1 = random0.nextInt();
        Intent intent0 = intentGeneratorForAttachingToNotifications0.getNewBaseIntent(v).putExtra("onesignalData", jSONObject0.toString());
        Intrinsics.checkNotNullExpressionValue(intent0, "intentGenerator.getNewBa…TA, gcmBundle.toString())");
        PendingIntent pendingIntent0 = intentGeneratorForAttachingToNotifications0.getNewActionPendingIntent(v1, intent0);
        Intrinsics.checkNotNull(notificationCompat$Builder0);
        notificationCompat$Builder0.setContentIntent(pendingIntent0);
        int v2 = random0.nextInt();
        Intent intent1 = this._notificationDisplayBuilder.getNewBaseDismissIntent(v);
        notificationCompat$Builder0.setDeleteIntent(this._notificationDisplayBuilder.getNewDismissActionPendingIntent(v2, intent1));
        Notification notification0 = notificationCompat$Builder0.build();
        Intrinsics.checkNotNullExpressionValue(notification0, "notifBuilder.build()");
        return notification0;
    }

    public final Object displayIAMPreviewNotification(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        return this.showNotification(notificationGenerationJob0, continuation0);
    }

    @Override  // com.onesignal.notifications.internal.display.INotificationDisplayer
    public Object displayNotification(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        this.isRunningOnMainThreadCheck();
        return this.showNotification(notificationGenerationJob0, continuation0);
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

    private final int getDrawableId(String s) {
        Resources resources0 = this.getContextResources();
        Intrinsics.checkNotNull(resources0);
        return resources0.getIdentifier(s, "drawable", this.getPackageName());
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

    public final Unit isRunningOnMainThreadCheck() {
        if(AndroidUtils.INSTANCE.isRunningOnMainThread()) {
            throw new MainThreadException("Process for showing a notification should never been done on Main Thread!");
        }
        return Unit.INSTANCE;
    }

    private final Integer safeGetColorFromHex(JSONObject jSONObject0, String s) {
        if(jSONObject0 != null) {
            try {
                return jSONObject0.has(s) ? new BigInteger(jSONObject0.optString(s), 16).intValue() : null;
            }
            catch(Throwable unused_ex) {
            }
        }
        return null;
    }

    private final void setTextColor(RemoteViews remoteViews0, JSONObject jSONObject0, int v, String s, String s1) {
        Integer integer0 = this.safeGetColorFromHex(jSONObject0, s);
        if(integer0 != null) {
            remoteViews0.setTextColor(v, ((int)integer0));
            return;
        }
        Resources resources0 = this.getContextResources();
        Intrinsics.checkNotNull(resources0);
        int v1 = resources0.getIdentifier(s1, "color", this.getPackageName());
        if(v1 != 0) {
            Context context0 = this.getCurrentContext();
            Intrinsics.checkNotNull(context0);
            remoteViews0.setTextColor(v, ContextCompat.INSTANCE.getColor(context0, v1));
        }
    }

    private final Object showNotification(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        Notification notification1;
        IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications1;
        Builder notificationCompat$Builder1;
        int v1;
        NotificationGenerationJob notificationGenerationJob1;
        NotificationDisplayer notificationDisplayer0;
        String s2;
        OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder0;
        String s1;
        ArrayList arrayList1;
        JSONObject jSONObject0;
        com.onesignal.notifications.internal.display.impl.NotificationDisplayer.showNotification.1 notificationDisplayer$showNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.display.impl.NotificationDisplayer.showNotification.1) {
            notificationDisplayer$showNotification$10 = (com.onesignal.notifications.internal.display.impl.NotificationDisplayer.showNotification.1)continuation0;
            if((notificationDisplayer$showNotification$10.label & 0x80000000) == 0) {
                notificationDisplayer$showNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.showNotification(null, this);
                    }
                };
            }
            else {
                notificationDisplayer$showNotification$10.label ^= 0x80000000;
            }
        }
        else {
            notificationDisplayer$showNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.showNotification(null, this);
                }
            };
        }
        Object object0 = notificationDisplayer$showNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationDisplayer$showNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                int v = notificationGenerationJob0.getAndroidId();
                jSONObject0 = notificationGenerationJob0.getJsonPayload();
                Intrinsics.checkNotNull(jSONObject0);
                String s = JSONObjectExtensionsKt.safeString(jSONObject0, "grp");
                IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0 = new IntentGeneratorForAttachingToNotifications(this.getCurrentContext());
                ArrayList arrayList0 = new ArrayList();
                if(Build.VERSION.SDK_INT >= 24) {
                    Context context0 = this.getCurrentContext();
                    arrayList0 = NotificationHelper.INSTANCE.getActiveGrouplessNotifications(context0);
                    if(s != null || arrayList0.size() < 3) {
                        arrayList1 = arrayList0;
                        s1 = s;
                    }
                    else {
                        Context context1 = this.getCurrentContext();
                        NotificationHelper.INSTANCE.assignGrouplessNotifications(context1, arrayList0);
                        arrayList1 = arrayList0;
                        s1 = "os_group_undefined";
                    }
                }
                else {
                    arrayList1 = arrayList0;
                    s1 = s;
                }
                notificationDisplayBuilder$OneSignalNotificationBuilder0 = this._notificationDisplayBuilder.getBaseOneSignalNotificationBuilder(notificationGenerationJob0);
                Builder notificationCompat$Builder0 = notificationDisplayBuilder$OneSignalNotificationBuilder0.getCompatBuilder();
                this._notificationDisplayBuilder.addNotificationActionButtons(jSONObject0, intentGeneratorForAttachingToNotifications0, notificationCompat$Builder0, v, null);
                try {
                    this.addBackgroundImage(jSONObject0, notificationCompat$Builder0);
                }
                catch(Throwable throwable0) {
                    Logging.error("Could not set background notification image!", throwable0);
                }
                this.applyNotificationExtender(notificationGenerationJob0, notificationCompat$Builder0);
                if(notificationGenerationJob0.isRestoring()) {
                    this._notificationDisplayBuilder.removeNotifyOptions(notificationCompat$Builder0);
                }
                notificationDisplayer$showNotification$10.L$0 = this;
                notificationDisplayer$showNotification$10.L$1 = notificationGenerationJob0;
                notificationDisplayer$showNotification$10.L$2 = jSONObject0;
                notificationDisplayer$showNotification$10.L$3 = s1;
                notificationDisplayer$showNotification$10.L$4 = intentGeneratorForAttachingToNotifications0;
                notificationDisplayer$showNotification$10.L$5 = arrayList1;
                notificationDisplayer$showNotification$10.L$6 = notificationDisplayBuilder$OneSignalNotificationBuilder0;
                notificationDisplayer$showNotification$10.L$7 = notificationCompat$Builder0;
                notificationDisplayer$showNotification$10.I$0 = v;
                notificationDisplayer$showNotification$10.label = 1;
                if(this._notificationLimitManager.clearOldestOverLimit((s1 == null ? 1 : 2), notificationDisplayer$showNotification$10) == object1) {
                    return object1;
                }
                s2 = s1;
                notificationDisplayer0 = this;
                notificationGenerationJob1 = notificationGenerationJob0;
                v1 = v;
                notificationCompat$Builder1 = notificationCompat$Builder0;
                intentGeneratorForAttachingToNotifications1 = intentGeneratorForAttachingToNotifications0;
                goto label_72;
            }
            case 1: {
                v1 = notificationDisplayer$showNotification$10.I$0;
                notificationCompat$Builder1 = (Builder)notificationDisplayer$showNotification$10.L$7;
                notificationDisplayBuilder$OneSignalNotificationBuilder0 = (OneSignalNotificationBuilder)notificationDisplayer$showNotification$10.L$6;
                arrayList1 = (ArrayList)notificationDisplayer$showNotification$10.L$5;
                intentGeneratorForAttachingToNotifications1 = (IntentGeneratorForAttachingToNotifications)notificationDisplayer$showNotification$10.L$4;
                s2 = (String)notificationDisplayer$showNotification$10.L$3;
                jSONObject0 = (JSONObject)notificationDisplayer$showNotification$10.L$2;
                notificationGenerationJob1 = (NotificationGenerationJob)notificationDisplayer$showNotification$10.L$1;
                notificationDisplayer0 = (NotificationDisplayer)notificationDisplayer$showNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_72:
                if(s2 == null) {
                    notification1 = notificationDisplayer0.createGenericPendingIntentsForNotif(notificationCompat$Builder1, intentGeneratorForAttachingToNotifications1, jSONObject0, v1);
                }
                else {
                    notificationDisplayer0._summaryNotificationDisplayer.createGenericPendingIntentsForGroup(notificationCompat$Builder1, intentGeneratorForAttachingToNotifications1, jSONObject0, s2, v1);
                    Notification notification0 = notificationDisplayer0._summaryNotificationDisplayer.createSingleNotificationBeforeSummaryBuilder(notificationGenerationJob1, notificationCompat$Builder1);
                    if(Build.VERSION.SDK_INT < 24 || !Intrinsics.areEqual(s2, "os_group_undefined")) {
                        int v3 = notificationDisplayer0._notificationDisplayBuilder.getGroupAlertBehavior();
                        notificationDisplayer$showNotification$10.L$0 = notificationDisplayer0;
                        notificationDisplayer$showNotification$10.L$1 = s2;
                        notificationDisplayer$showNotification$10.L$2 = notificationDisplayBuilder$OneSignalNotificationBuilder0;
                        notificationDisplayer$showNotification$10.L$3 = notification0;
                        notificationDisplayer$showNotification$10.L$4 = null;
                        notificationDisplayer$showNotification$10.L$5 = null;
                        notificationDisplayer$showNotification$10.L$6 = null;
                        notificationDisplayer$showNotification$10.L$7 = null;
                        notificationDisplayer$showNotification$10.I$0 = v1;
                        notificationDisplayer$showNotification$10.label = 3;
                        if(notificationDisplayer0._summaryNotificationDisplayer.createSummaryNotification(notificationGenerationJob1, notificationDisplayBuilder$OneSignalNotificationBuilder0, v3, notificationDisplayer$showNotification$10) == object1) {
                            return object1;
                        }
                    }
                    else {
                        int v2 = notificationDisplayer0._notificationDisplayBuilder.getGroupAlertBehavior();
                        notificationDisplayer$showNotification$10.L$0 = notificationDisplayer0;
                        notificationDisplayer$showNotification$10.L$1 = s2;
                        notificationDisplayer$showNotification$10.L$2 = notificationDisplayBuilder$OneSignalNotificationBuilder0;
                        notificationDisplayer$showNotification$10.L$3 = notification0;
                        notificationDisplayer$showNotification$10.L$4 = null;
                        notificationDisplayer$showNotification$10.L$5 = null;
                        notificationDisplayer$showNotification$10.L$6 = null;
                        notificationDisplayer$showNotification$10.L$7 = null;
                        notificationDisplayer$showNotification$10.I$0 = v1;
                        notificationDisplayer$showNotification$10.label = 2;
                        if(notificationDisplayer0._summaryNotificationDisplayer.createGrouplessSummaryNotification(notificationGenerationJob1, intentGeneratorForAttachingToNotifications1, arrayList1.size() + 1, v2, notificationDisplayer$showNotification$10) == object1) {
                            return object1;
                        }
                    }
                    notification1 = notification0;
                }
                break;
            }
            case 2: 
            case 3: {
                v1 = notificationDisplayer$showNotification$10.I$0;
                notification1 = (Notification)notificationDisplayer$showNotification$10.L$3;
                OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder1 = (OneSignalNotificationBuilder)notificationDisplayer$showNotification$10.L$2;
                String s3 = (String)notificationDisplayer$showNotification$10.L$1;
                NotificationDisplayer notificationDisplayer1 = (NotificationDisplayer)notificationDisplayer$showNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                notificationDisplayBuilder$OneSignalNotificationBuilder0 = notificationDisplayBuilder$OneSignalNotificationBuilder1;
                notificationDisplayer0 = notificationDisplayer1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        notificationDisplayer0._notificationDisplayBuilder.addXiaomiSettings(notificationDisplayBuilder$OneSignalNotificationBuilder0, notification1);
        Context context2 = notificationDisplayer0.getCurrentContext();
        Intrinsics.checkNotNull(context2);
        NotificationManagerCompat.from(context2).notify(v1, notification1);
        if(Build.VERSION.SDK_INT >= 26) {
            Context context3 = notificationDisplayer0.getCurrentContext();
            Intrinsics.checkNotNull(context3);
            String s4 = notification1.getChannelId();
            return Boxing.boxBoolean(NotificationHelper.INSTANCE.areNotificationsEnabled(context3, s4));
        }
        return Boxing.boxBoolean(true);
    }
}

