package com.onesignal.notifications.internal.display;

import android.app.Notification;
import androidx.core.app.NotificationCompat.Builder;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH&J1\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001A\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H&J+\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0004\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001A\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001A\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001B"}, d2 = {"Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "", "createGenericPendingIntentsForGroup", "", "notifBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "gcmBundle", "Lorg/json/JSONObject;", "group", "", "notificationId", "", "createGrouplessSummaryNotification", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "grouplessNotifCount", "groupAlertBehavior", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSingleNotificationBeforeSummaryBuilder", "Landroid/app/Notification;", "createSummaryNotification", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotification", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISummaryNotificationDisplayer {
    void createGenericPendingIntentsForGroup(Builder arg1, IntentGeneratorForAttachingToNotifications arg2, JSONObject arg3, String arg4, int arg5);

    Object createGrouplessSummaryNotification(NotificationGenerationJob arg1, IntentGeneratorForAttachingToNotifications arg2, int arg3, int arg4, Continuation arg5);

    Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob arg1, Builder arg2);

    Object createSummaryNotification(NotificationGenerationJob arg1, OneSignalNotificationBuilder arg2, int arg3, Continuation arg4);

    Object updateSummaryNotification(NotificationGenerationJob arg1, Continuation arg2);
}

