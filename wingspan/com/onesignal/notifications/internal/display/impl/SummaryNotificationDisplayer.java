package com.onesignal.notifications.internal.display.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.InboxStyle;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository.NotificationData;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J2\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u0010H\u0016J1\u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u00102\u0006\u0010!\u001A\u00020\u0010H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001A\u0010#\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u001F2\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0016J+\u0010%\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001F2\b\u0010\u0019\u001A\u0004\u0018\u00010&2\u0006\u0010!\u001A\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\'J\u0019\u0010(\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001FH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/SummaryNotificationDisplayer;", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_notificationDisplayBuilder", "Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;)V", "currentContext", "Landroid/content/Context;", "getCurrentContext", "()Landroid/content/Context;", "createBaseSummaryIntent", "Landroid/content/Intent;", "summaryNotificationId", "", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "fcmJson", "Lorg/json/JSONObject;", "group", "", "createGenericPendingIntentsForGroup", "", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "gcmBundle", "notificationId", "createGrouplessSummaryNotification", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "grouplessNotifCount", "groupAlertBehavior", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSingleNotificationBeforeSummaryBuilder", "Landroid/app/Notification;", "createSummaryNotification", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotification", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SummaryNotificationDisplayer implements ISummaryNotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;

    public SummaryNotificationDisplayer(IApplicationService iApplicationService0, INotificationRepository iNotificationRepository0, INotificationDisplayBuilder iNotificationDisplayBuilder0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_dataController");
        Intrinsics.checkNotNullParameter(iNotificationDisplayBuilder0, "_notificationDisplayBuilder");
        super();
        this._applicationService = iApplicationService0;
        this._dataController = iNotificationRepository0;
        this._notificationDisplayBuilder = iNotificationDisplayBuilder0;
    }

    private final Intent createBaseSummaryIntent(int v, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0, JSONObject jSONObject0, String s) {
        Intent intent0 = intentGeneratorForAttachingToNotifications0.getNewBaseIntent(v).putExtra("onesignalData", jSONObject0.toString()).putExtra("summary", s);
        Intrinsics.checkNotNullExpressionValue(intent0, "intentGenerator.getNewBa…utExtra(\"summary\", group)");
        return intent0;
    }

    @Override  // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public void createGenericPendingIntentsForGroup(Builder notificationCompat$Builder0, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0, JSONObject jSONObject0, String s, int v) {
        Intrinsics.checkNotNullParameter(intentGeneratorForAttachingToNotifications0, "intentGenerator");
        Intrinsics.checkNotNullParameter(jSONObject0, "gcmBundle");
        Intrinsics.checkNotNullParameter(s, "group");
        Random random0 = new SecureRandom();
        int v1 = random0.nextInt();
        Intent intent0 = intentGeneratorForAttachingToNotifications0.getNewBaseIntent(v).putExtra("onesignalData", jSONObject0.toString()).putExtra("grp", s);
        Intrinsics.checkNotNullExpressionValue(intent0, "intentGenerator.getNewBa…)).putExtra(\"grp\", group)");
        PendingIntent pendingIntent0 = intentGeneratorForAttachingToNotifications0.getNewActionPendingIntent(v1, intent0);
        Intrinsics.checkNotNull(notificationCompat$Builder0);
        notificationCompat$Builder0.setContentIntent(pendingIntent0);
        int v2 = random0.nextInt();
        Intent intent1 = this._notificationDisplayBuilder.getNewBaseDismissIntent(v).putExtra("grp", s);
        Intrinsics.checkNotNullExpressionValue(intent1, "_notificationDisplayBuil…d).putExtra(\"grp\", group)");
        notificationCompat$Builder0.setDeleteIntent(this._notificationDisplayBuilder.getNewDismissActionPendingIntent(v2, intent1));
        notificationCompat$Builder0.setGroup(s);
        try {
            notificationCompat$Builder0.setGroupAlertBehavior(this._notificationDisplayBuilder.getGroupAlertBehavior());
        }
        catch(Throwable unused_ex) {
        }
    }

    @Override  // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Object createGrouplessSummaryNotification(NotificationGenerationJob notificationGenerationJob0, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0, int v, int v1, Continuation continuation0) {
        int v2;
        NotificationGenerationJob notificationGenerationJob1;
        String s1;
        SummaryNotificationDisplayer summaryNotificationDisplayer0;
        String s;
        SecureRandom secureRandom0;
        JSONObject jSONObject0;
        com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createGrouplessSummaryNotification.1 summaryNotificationDisplayer$createGrouplessSummaryNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createGrouplessSummaryNotification.1) {
            summaryNotificationDisplayer$createGrouplessSummaryNotification$10 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createGrouplessSummaryNotification.1)continuation0;
            if((summaryNotificationDisplayer$createGrouplessSummaryNotification$10.label & 0x80000000) == 0) {
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    int I$2;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.createGrouplessSummaryNotification(null, null, 0, 0, this);
                    }
                };
            }
            else {
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.label ^= 0x80000000;
            }
        }
        else {
            summaryNotificationDisplayer$createGrouplessSummaryNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                int I$2;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.createGrouplessSummaryNotification(null, null, 0, 0, this);
                }
            };
        }
        Object object0 = summaryNotificationDisplayer$createGrouplessSummaryNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(summaryNotificationDisplayer$createGrouplessSummaryNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                jSONObject0 = notificationGenerationJob0.getJsonPayload();
                Intrinsics.checkNotNull(jSONObject0);
                secureRandom0 = new SecureRandom();
                s = v + " new messages";
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$0 = this;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$1 = notificationGenerationJob0;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$2 = intentGeneratorForAttachingToNotifications0;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$3 = jSONObject0;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$4 = secureRandom0;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$5 = "os_group_undefined";
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$6 = s;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.I$0 = v;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.I$1 = v1;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.I$2 = 0xD52D1DDE;
                summaryNotificationDisplayer$createGrouplessSummaryNotification$10.label = 1;
                if(this._dataController.createSummaryNotification(0xD52D1DDE, "os_group_undefined", summaryNotificationDisplayer$createGrouplessSummaryNotification$10) == object1) {
                    return object1;
                }
                summaryNotificationDisplayer0 = this;
                s1 = "os_group_undefined";
                notificationGenerationJob1 = notificationGenerationJob0;
                v2 = 0xD52D1DDE;
                break;
            }
            case 1: {
                v2 = summaryNotificationDisplayer$createGrouplessSummaryNotification$10.I$2;
                v1 = summaryNotificationDisplayer$createGrouplessSummaryNotification$10.I$1;
                v = summaryNotificationDisplayer$createGrouplessSummaryNotification$10.I$0;
                String s2 = (String)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$6;
                s1 = (String)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$5;
                secureRandom0 = (SecureRandom)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$4;
                jSONObject0 = (JSONObject)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$3;
                IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications1 = (IntentGeneratorForAttachingToNotifications)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$2;
                notificationGenerationJob1 = (NotificationGenerationJob)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$1;
                summaryNotificationDisplayer0 = (SummaryNotificationDisplayer)summaryNotificationDisplayer$createGrouplessSummaryNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                s = s2;
                intentGeneratorForAttachingToNotifications0 = intentGeneratorForAttachingToNotifications1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        PendingIntent pendingIntent0 = intentGeneratorForAttachingToNotifications0.getNewActionPendingIntent(secureRandom0.nextInt(), summaryNotificationDisplayer0.createBaseSummaryIntent(v2, intentGeneratorForAttachingToNotifications0, jSONObject0, s1));
        int v3 = secureRandom0.nextInt();
        Intent intent0 = summaryNotificationDisplayer0._notificationDisplayBuilder.getNewBaseDismissIntent(0).putExtra("summary", s1);
        Intrinsics.checkNotNullExpressionValue(intent0, "_notificationDisplayBuil…utExtra(\"summary\", group)");
        PendingIntent pendingIntent1 = summaryNotificationDisplayer0._notificationDisplayBuilder.getNewDismissActionPendingIntent(v3, intent0);
        Builder notificationCompat$Builder0 = summaryNotificationDisplayer0._notificationDisplayBuilder.getBaseOneSignalNotificationBuilder(notificationGenerationJob1).getCompatBuilder();
        if(notificationGenerationJob1.getOverriddenSound() != null) {
            Intrinsics.checkNotNull(notificationCompat$Builder0);
            notificationCompat$Builder0.setSound(notificationGenerationJob1.getOverriddenSound());
        }
        if(notificationGenerationJob1.getOverriddenFlags() != null) {
            Intrinsics.checkNotNull(notificationCompat$Builder0);
            Integer integer0 = notificationGenerationJob1.getOverriddenFlags();
            Intrinsics.checkNotNull(integer0);
            notificationCompat$Builder0.setDefaults(((int)integer0));
        }
        Intrinsics.checkNotNull(notificationCompat$Builder0);
        Builder notificationCompat$Builder1 = notificationCompat$Builder0.setContentIntent(pendingIntent0).setDeleteIntent(pendingIntent1);
        Context context0 = summaryNotificationDisplayer0.getCurrentContext();
        Intrinsics.checkNotNull(context0);
        PackageManager packageManager0 = context0.getPackageManager();
        Context context1 = summaryNotificationDisplayer0.getCurrentContext();
        Intrinsics.checkNotNull(context1);
        notificationCompat$Builder1.setContentTitle(packageManager0.getApplicationLabel(context1.getApplicationInfo())).setContentText(s).setNumber(v).setSmallIcon(summaryNotificationDisplayer0._notificationDisplayBuilder.getDefaultSmallIconId()).setLargeIcon(summaryNotificationDisplayer0._notificationDisplayBuilder.getDefaultLargeIcon()).setOnlyAlertOnce(true).setAutoCancel(false).setGroup(s1).setGroupSummary(true);
        try {
            notificationCompat$Builder0.setGroupAlertBehavior(v1);
        }
        catch(Throwable unused_ex) {
        }
        InboxStyle notificationCompat$InboxStyle0 = new InboxStyle();
        notificationCompat$InboxStyle0.setBigContentTitle(s);
        notificationCompat$Builder0.setStyle(notificationCompat$InboxStyle0);
        Notification notification0 = notificationCompat$Builder0.build();
        Intrinsics.checkNotNullExpressionValue(notification0, "summaryBuilder.build()");
        Context context2 = summaryNotificationDisplayer0.getCurrentContext();
        Intrinsics.checkNotNull(context2);
        NotificationManagerCompat.from(context2).notify(v2, notification0);
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationGenerationJob0, Builder notificationCompat$Builder0) {
        Intrinsics.checkNotNullParameter(notificationGenerationJob0, "notificationJob");
        boolean z = Build.VERSION.SDK_INT < 24 && !notificationGenerationJob0.isRestoring();
        if(z && notificationGenerationJob0.getOverriddenSound() != null) {
            Uri uri0 = notificationGenerationJob0.getOverriddenSound();
            Intrinsics.checkNotNull(uri0);
            if(!uri0.equals(notificationGenerationJob0.getOrgSound())) {
                Intrinsics.checkNotNull(notificationCompat$Builder0);
                notificationCompat$Builder0.setSound(null);
            }
        }
        Intrinsics.checkNotNull(notificationCompat$Builder0);
        Notification notification0 = notificationCompat$Builder0.build();
        Intrinsics.checkNotNullExpressionValue(notification0, "notifBuilder!!.build()");
        if(z) {
            notificationCompat$Builder0.setSound(notificationGenerationJob0.getOverriddenSound());
        }
        return notification0;
    }

    @Override  // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Object createSummaryNotification(NotificationGenerationJob notificationGenerationJob0, OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder0, int v, Continuation continuation0) {
        Notification notification0;
        String s8;
        PendingIntent pendingIntent4;
        int v6;
        String s5;
        OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder4;
        JSONObject jSONObject3;
        int v5;
        SummaryNotificationDisplayer summaryNotificationDisplayer2;
        boolean z2;
        String s3;
        Integer integer2;
        NotificationGenerationJob notificationGenerationJob4;
        IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications4;
        SecureRandom secureRandom4;
        OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder3;
        PendingIntent pendingIntent3;
        NotificationGenerationJob notificationGenerationJob3;
        String s2;
        OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder2;
        SecureRandom secureRandom3;
        Integer integer1;
        IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications3;
        int v4;
        SummaryNotificationDisplayer summaryNotificationDisplayer0;
        SecureRandom secureRandom1;
        IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications1;
        PendingIntent pendingIntent1;
        boolean z1;
        JSONObject jSONObject1;
        int v2;
        OneSignalNotificationBuilder notificationDisplayBuilder$OneSignalNotificationBuilder1;
        NotificationGenerationJob notificationGenerationJob1;
        String s;
        com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createSummaryNotification.1 summaryNotificationDisplayer$createSummaryNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createSummaryNotification.1) {
            summaryNotificationDisplayer$createSummaryNotification$10 = (com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createSummaryNotification.1)continuation0;
            if((summaryNotificationDisplayer$createSummaryNotification$10.label & 0x80000000) == 0) {
                summaryNotificationDisplayer$createSummaryNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.createSummaryNotification(null, null, 0, this);
                    }
                };
            }
            else {
                summaryNotificationDisplayer$createSummaryNotification$10.label ^= 0x80000000;
            }
        }
        else {
            summaryNotificationDisplayer$createSummaryNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                Object L$8;
                boolean Z$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.createSummaryNotification(null, null, 0, this);
                }
            };
        }
        Object object0 = summaryNotificationDisplayer$createSummaryNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(summaryNotificationDisplayer$createSummaryNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                boolean z = notificationGenerationJob0.isRestoring();
                JSONObject jSONObject0 = notificationGenerationJob0.getJsonPayload();
                Intrinsics.checkNotNull(jSONObject0);
                Context context0 = this.getCurrentContext();
                Intrinsics.checkNotNull(context0);
                IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications0 = new IntentGeneratorForAttachingToNotifications(context0);
                s = jSONObject0.optString("grp", null);
                SecureRandom secureRandom0 = new SecureRandom();
                int v1 = secureRandom0.nextInt();
                Intent intent0 = this._notificationDisplayBuilder.getNewBaseDismissIntent(0).putExtra("summary", s);
                Intrinsics.checkNotNullExpressionValue(intent0, "_notificationDisplayBuil…utExtra(\"summary\", group)");
                PendingIntent pendingIntent0 = this._notificationDisplayBuilder.getNewDismissActionPendingIntent(v1, intent0);
                Intrinsics.checkNotNullExpressionValue(s, "group");
                summaryNotificationDisplayer$createSummaryNotification$10.L$0 = this;
                notificationGenerationJob1 = notificationGenerationJob0;
                summaryNotificationDisplayer$createSummaryNotification$10.L$1 = notificationGenerationJob1;
                notificationDisplayBuilder$OneSignalNotificationBuilder1 = notificationDisplayBuilder$OneSignalNotificationBuilder0;
                summaryNotificationDisplayer$createSummaryNotification$10.L$2 = notificationDisplayBuilder$OneSignalNotificationBuilder1;
                summaryNotificationDisplayer$createSummaryNotification$10.L$3 = jSONObject0;
                summaryNotificationDisplayer$createSummaryNotification$10.L$4 = intentGeneratorForAttachingToNotifications0;
                summaryNotificationDisplayer$createSummaryNotification$10.L$5 = s;
                summaryNotificationDisplayer$createSummaryNotification$10.L$6 = secureRandom0;
                summaryNotificationDisplayer$createSummaryNotification$10.L$7 = pendingIntent0;
                v2 = v;
                summaryNotificationDisplayer$createSummaryNotification$10.I$0 = v2;
                summaryNotificationDisplayer$createSummaryNotification$10.Z$0 = z;
                summaryNotificationDisplayer$createSummaryNotification$10.label = 1;
                Object object2 = this._dataController.getAndroidIdForGroup(s, true, summaryNotificationDisplayer$createSummaryNotification$10);
                if(object2 == object1) {
                    return object1;
                }
                jSONObject1 = jSONObject0;
                z1 = z;
                object0 = object2;
                pendingIntent1 = pendingIntent0;
                intentGeneratorForAttachingToNotifications1 = intentGeneratorForAttachingToNotifications0;
                secureRandom1 = secureRandom0;
                summaryNotificationDisplayer0 = this;
                goto label_70;
            }
            case 1: {
                z1 = summaryNotificationDisplayer$createSummaryNotification$10.Z$0;
                int v3 = summaryNotificationDisplayer$createSummaryNotification$10.I$0;
                PendingIntent pendingIntent2 = (PendingIntent)summaryNotificationDisplayer$createSummaryNotification$10.L$7;
                SecureRandom secureRandom2 = (SecureRandom)summaryNotificationDisplayer$createSummaryNotification$10.L$6;
                String s1 = (String)summaryNotificationDisplayer$createSummaryNotification$10.L$5;
                IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications2 = (IntentGeneratorForAttachingToNotifications)summaryNotificationDisplayer$createSummaryNotification$10.L$4;
                JSONObject jSONObject2 = (JSONObject)summaryNotificationDisplayer$createSummaryNotification$10.L$3;
                notificationDisplayBuilder$OneSignalNotificationBuilder1 = (OneSignalNotificationBuilder)summaryNotificationDisplayer$createSummaryNotification$10.L$2;
                NotificationGenerationJob notificationGenerationJob2 = (NotificationGenerationJob)summaryNotificationDisplayer$createSummaryNotification$10.L$1;
                SummaryNotificationDisplayer summaryNotificationDisplayer1 = (SummaryNotificationDisplayer)summaryNotificationDisplayer$createSummaryNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                v2 = v3;
                secureRandom1 = secureRandom2;
                summaryNotificationDisplayer0 = summaryNotificationDisplayer1;
                jSONObject1 = jSONObject2;
                notificationGenerationJob1 = notificationGenerationJob2;
                pendingIntent1 = pendingIntent2;
                s = s1;
                intentGeneratorForAttachingToNotifications1 = intentGeneratorForAttachingToNotifications2;
            label_70:
                if(((Integer)object0) == null) {
                    Integer integer0 = Boxing.boxInt(secureRandom1.nextInt());
                    Intrinsics.checkNotNullExpressionValue(s, "group");
                    summaryNotificationDisplayer$createSummaryNotification$10.L$0 = summaryNotificationDisplayer0;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$1 = notificationGenerationJob1;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$2 = notificationDisplayBuilder$OneSignalNotificationBuilder1;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$3 = jSONObject1;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$4 = intentGeneratorForAttachingToNotifications1;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$5 = s;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$6 = secureRandom1;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$7 = pendingIntent1;
                    summaryNotificationDisplayer$createSummaryNotification$10.L$8 = integer0;
                    summaryNotificationDisplayer$createSummaryNotification$10.I$0 = v2;
                    summaryNotificationDisplayer$createSummaryNotification$10.Z$0 = z1;
                    summaryNotificationDisplayer$createSummaryNotification$10.label = 2;
                    if(summaryNotificationDisplayer0._dataController.createSummaryNotification(((int)integer0), s, summaryNotificationDisplayer$createSummaryNotification$10) == object1) {
                        return object1;
                    }
                    v4 = v2;
                    intentGeneratorForAttachingToNotifications3 = intentGeneratorForAttachingToNotifications1;
                    integer1 = integer0;
                    secureRandom3 = secureRandom1;
                    notificationDisplayBuilder$OneSignalNotificationBuilder2 = notificationDisplayBuilder$OneSignalNotificationBuilder1;
                    s2 = s;
                    notificationGenerationJob3 = notificationGenerationJob1;
                    goto label_115;
                }
                else {
                    pendingIntent3 = pendingIntent1;
                    notificationDisplayBuilder$OneSignalNotificationBuilder3 = notificationDisplayBuilder$OneSignalNotificationBuilder1;
                    secureRandom4 = secureRandom1;
                    intentGeneratorForAttachingToNotifications4 = intentGeneratorForAttachingToNotifications1;
                    notificationGenerationJob4 = notificationGenerationJob1;
                    integer2 = (Integer)object0;
                    s3 = s;
                }
                goto label_123;
            }
            case 2: {
                z1 = summaryNotificationDisplayer$createSummaryNotification$10.Z$0;
                v4 = summaryNotificationDisplayer$createSummaryNotification$10.I$0;
                integer1 = (Integer)summaryNotificationDisplayer$createSummaryNotification$10.L$8;
                pendingIntent1 = (PendingIntent)summaryNotificationDisplayer$createSummaryNotification$10.L$7;
                secureRandom3 = (SecureRandom)summaryNotificationDisplayer$createSummaryNotification$10.L$6;
                s2 = (String)summaryNotificationDisplayer$createSummaryNotification$10.L$5;
                intentGeneratorForAttachingToNotifications3 = (IntentGeneratorForAttachingToNotifications)summaryNotificationDisplayer$createSummaryNotification$10.L$4;
                jSONObject1 = (JSONObject)summaryNotificationDisplayer$createSummaryNotification$10.L$3;
                notificationDisplayBuilder$OneSignalNotificationBuilder2 = (OneSignalNotificationBuilder)summaryNotificationDisplayer$createSummaryNotification$10.L$2;
                notificationGenerationJob3 = (NotificationGenerationJob)summaryNotificationDisplayer$createSummaryNotification$10.L$1;
                summaryNotificationDisplayer0 = (SummaryNotificationDisplayer)summaryNotificationDisplayer$createSummaryNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_115:
                notificationDisplayBuilder$OneSignalNotificationBuilder3 = notificationDisplayBuilder$OneSignalNotificationBuilder2;
                integer2 = integer1;
                notificationGenerationJob4 = notificationGenerationJob3;
                v2 = v4;
                pendingIntent3 = pendingIntent1;
                secureRandom4 = secureRandom3;
                s3 = s2;
                intentGeneratorForAttachingToNotifications4 = intentGeneratorForAttachingToNotifications3;
            label_123:
                Intrinsics.checkNotNullExpressionValue(s3, "group");
                summaryNotificationDisplayer$createSummaryNotification$10.L$0 = summaryNotificationDisplayer0;
                summaryNotificationDisplayer$createSummaryNotification$10.L$1 = notificationGenerationJob4;
                summaryNotificationDisplayer$createSummaryNotification$10.L$2 = notificationDisplayBuilder$OneSignalNotificationBuilder3;
                summaryNotificationDisplayer$createSummaryNotification$10.L$3 = jSONObject1;
                summaryNotificationDisplayer$createSummaryNotification$10.L$4 = intentGeneratorForAttachingToNotifications4;
                summaryNotificationDisplayer$createSummaryNotification$10.L$5 = s3;
                summaryNotificationDisplayer$createSummaryNotification$10.L$6 = secureRandom4;
                summaryNotificationDisplayer$createSummaryNotification$10.L$7 = pendingIntent3;
                summaryNotificationDisplayer$createSummaryNotification$10.L$8 = integer2;
                summaryNotificationDisplayer$createSummaryNotification$10.I$0 = v2;
                summaryNotificationDisplayer$createSummaryNotification$10.Z$0 = z1;
                summaryNotificationDisplayer$createSummaryNotification$10.label = 3;
                object0 = summaryNotificationDisplayer0._dataController.listNotificationsForGroup(s3, summaryNotificationDisplayer$createSummaryNotification$10);
                if(object0 == object1) {
                    return object1;
                }
                z2 = z1;
                summaryNotificationDisplayer2 = summaryNotificationDisplayer0;
                v5 = v2;
                jSONObject3 = jSONObject1;
                notificationDisplayBuilder$OneSignalNotificationBuilder4 = notificationDisplayBuilder$OneSignalNotificationBuilder3;
                break;
            }
            case 3: {
                z2 = summaryNotificationDisplayer$createSummaryNotification$10.Z$0;
                v5 = summaryNotificationDisplayer$createSummaryNotification$10.I$0;
                integer2 = (Integer)summaryNotificationDisplayer$createSummaryNotification$10.L$8;
                pendingIntent3 = (PendingIntent)summaryNotificationDisplayer$createSummaryNotification$10.L$7;
                secureRandom4 = (SecureRandom)summaryNotificationDisplayer$createSummaryNotification$10.L$6;
                s3 = (String)summaryNotificationDisplayer$createSummaryNotification$10.L$5;
                intentGeneratorForAttachingToNotifications4 = (IntentGeneratorForAttachingToNotifications)summaryNotificationDisplayer$createSummaryNotification$10.L$4;
                jSONObject3 = (JSONObject)summaryNotificationDisplayer$createSummaryNotification$10.L$3;
                notificationDisplayBuilder$OneSignalNotificationBuilder4 = (OneSignalNotificationBuilder)summaryNotificationDisplayer$createSummaryNotification$10.L$2;
                notificationGenerationJob4 = (NotificationGenerationJob)summaryNotificationDisplayer$createSummaryNotification$10.L$1;
                summaryNotificationDisplayer2 = (SummaryNotificationDisplayer)summaryNotificationDisplayer$createSummaryNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Collection collection0 = new ArrayList();
        Iterator iterator0 = ((List)object0).iterator();
        String s4 = null;
        while(true) {
            s5 = "";
            if(!iterator0.hasNext()) {
                break;
            }
            Object object3 = iterator0.next();
            NotificationData iNotificationRepository$NotificationData0 = (NotificationData)object3;
            if(z2) {
                v6 = v5;
            }
            else {
                v6 = v5;
                if(iNotificationRepository$NotificationData0.getAndroidId() == notificationGenerationJob4.getAndroidId()) {
                    pendingIntent4 = pendingIntent3;
                    goto label_180;
                }
            }
            String s6 = iNotificationRepository$NotificationData0.getTitle();
            if(s6 != null) {
                s5 = s6 + ' ';
            }
            pendingIntent4 = pendingIntent3;
            SpannableString spannableString0 = new SpannableString(s5 + iNotificationRepository$NotificationData0.getMessage());
            if(s5.length() > 0) {
                spannableString0.setSpan(new StyleSpan(1), 0, s5.length(), 0);
            }
            ((ArrayList)collection0).add(spannableString0);
            if(s4 == null) {
                s4 = iNotificationRepository$NotificationData0.getFullData();
            }
        label_180:
            v5 = v6;
            pendingIntent3 = pendingIntent4;
        }
        int v7 = secureRandom4.nextInt();
        Intrinsics.checkNotNull(integer2);
        Intrinsics.checkNotNullExpressionValue(s3, "group");
        PendingIntent pendingIntent5 = intentGeneratorForAttachingToNotifications4.getNewActionPendingIntent(v7, summaryNotificationDisplayer2.createBaseSummaryIntent(((int)integer2), intentGeneratorForAttachingToNotifications4, jSONObject3, s3));
        if((!z2 || ((ArrayList)collection0).size() <= 1) && (z2 || ((ArrayList)collection0).size() <= 0)) {
            Intrinsics.checkNotNull(notificationDisplayBuilder$OneSignalNotificationBuilder4);
            Builder notificationCompat$Builder2 = notificationDisplayBuilder$OneSignalNotificationBuilder4.getCompatBuilder();
            Intrinsics.checkNotNull(notificationCompat$Builder2);
            notificationCompat$Builder2.mActions.clear();
            summaryNotificationDisplayer2._notificationDisplayBuilder.addNotificationActionButtons(jSONObject3, intentGeneratorForAttachingToNotifications4, notificationCompat$Builder2, ((int)integer2), s3);
            notificationCompat$Builder2.setContentIntent(pendingIntent5).setDeleteIntent(pendingIntent3).setOnlyAlertOnce(z2).setAutoCancel(false).setGroup(s3).setGroupSummary(true);
            try {
                notificationCompat$Builder2.setGroupAlertBehavior(v5);
            }
            catch(Throwable unused_ex) {
            }
            notification0 = notificationCompat$Builder2.build();
            Intrinsics.checkNotNullExpressionValue(notification0, "summaryBuilder.build()");
            summaryNotificationDisplayer2._notificationDisplayBuilder.addXiaomiSettings(notificationDisplayBuilder$OneSignalNotificationBuilder4, notification0);
        }
        else {
            int v8 = ((ArrayList)collection0).size() + !z2;
            String s7 = JSONObjectExtensionsKt.safeString(jSONObject3, "grp_msg");
            if(s7 == null) {
                s8 = v8 + " new messages";
            }
            else {
                s8 = StringsKt.replace$default(s7, "$[notif_count]", "" + v8, false, 4, null);
                if(s8 == null) {
                    s8 = v8 + " new messages";
                }
            }
            Builder notificationCompat$Builder0 = summaryNotificationDisplayer2._notificationDisplayBuilder.getBaseOneSignalNotificationBuilder(notificationGenerationJob4).getCompatBuilder();
            if(z2) {
                summaryNotificationDisplayer2._notificationDisplayBuilder.removeNotifyOptions(notificationCompat$Builder0);
            }
            else {
                if(notificationGenerationJob4.getOverriddenSound() != null) {
                    Intrinsics.checkNotNull(notificationCompat$Builder0);
                    notificationCompat$Builder0.setSound(notificationGenerationJob4.getOverriddenSound());
                }
                if(notificationGenerationJob4.getOverriddenFlags() != null) {
                    Intrinsics.checkNotNull(notificationCompat$Builder0);
                    Integer integer3 = notificationGenerationJob4.getOverriddenFlags();
                    Intrinsics.checkNotNull(integer3);
                    notificationCompat$Builder0.setDefaults(((int)integer3));
                }
            }
            Intrinsics.checkNotNull(notificationCompat$Builder0);
            Builder notificationCompat$Builder1 = notificationCompat$Builder0.setContentIntent(pendingIntent5).setDeleteIntent(pendingIntent3);
            Context context1 = summaryNotificationDisplayer2.getCurrentContext();
            Intrinsics.checkNotNull(context1);
            PackageManager packageManager0 = context1.getPackageManager();
            Context context2 = summaryNotificationDisplayer2.getCurrentContext();
            Intrinsics.checkNotNull(context2);
            notificationCompat$Builder1.setContentTitle(packageManager0.getApplicationLabel(context2.getApplicationInfo())).setContentText(s8).setNumber(v8).setSmallIcon(summaryNotificationDisplayer2._notificationDisplayBuilder.getDefaultSmallIconId()).setLargeIcon(summaryNotificationDisplayer2._notificationDisplayBuilder.getDefaultLargeIcon()).setOnlyAlertOnce(z2).setAutoCancel(false).setGroup(s3).setGroupSummary(true);
            try {
                notificationCompat$Builder0.setGroupAlertBehavior(v5);
            }
            catch(Throwable unused_ex) {
            }
            if(!z2) {
                notificationCompat$Builder0.setTicker(s8);
            }
            InboxStyle notificationCompat$InboxStyle0 = new InboxStyle();
            if(!z2) {
                String s9 = notificationGenerationJob4.getTitle() == null ? null : String.valueOf(notificationGenerationJob4.getTitle());
                String s10 = s9 == null ? "" : s9 + ' ';
                CharSequence charSequence0 = notificationGenerationJob4.getBody();
                if(charSequence0 != null) {
                    String s11 = charSequence0.toString();
                    if(s11 != null) {
                        s5 = s11;
                    }
                }
                SpannableString spannableString1 = new SpannableString(s10 + s5);
                if(s10.length() > 0) {
                    spannableString1.setSpan(new StyleSpan(1), 0, s10.length(), 0);
                }
                notificationCompat$InboxStyle0.addLine(spannableString1);
            }
            for(Object object4: ((ArrayList)collection0)) {
                notificationCompat$InboxStyle0.addLine(((SpannableString)object4));
            }
            notificationCompat$InboxStyle0.setBigContentTitle(s8);
            notificationCompat$Builder0.setStyle(notificationCompat$InboxStyle0);
            notification0 = notificationCompat$Builder0.build();
            Intrinsics.checkNotNullExpressionValue(notification0, "summaryBuilder.build()");
        }
        Context context3 = summaryNotificationDisplayer2.getCurrentContext();
        Intrinsics.checkNotNull(context3);
        NotificationManagerCompat.from(context3).notify(((int)integer2), notification0);
        return Unit.INSTANCE;
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    @Override  // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Object updateSummaryNotification(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        Object object0 = this.createSummaryNotification(notificationGenerationJob0, null, this._notificationDisplayBuilder.getGroupAlertBehavior(), continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

