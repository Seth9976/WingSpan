package com.onesignal.notifications.internal.display;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat.Builder;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J4\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001A\u00020\u00072\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H&J\u001A\u0010\u0015\u001A\u00020\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001A\u00020\u0019H&J\u0010\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u001CH&J\b\u0010\u001D\u001A\u00020\u0007H&J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0012\u001A\u00020\u0007H&J\u0018\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u00072\u0006\u0010#\u001A\u00020\u001FH&J\u0010\u0010$\u001A\u00020%2\u0006\u0010\f\u001A\u00020\rH&J\u0012\u0010&\u001A\u00020\u000B2\b\u0010\'\u001A\u0004\u0018\u00010\u0011H&R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006("}, d2 = {"Lcom/onesignal/notifications/internal/display/INotificationDisplayBuilder;", "", "defaultLargeIcon", "Landroid/graphics/Bitmap;", "getDefaultLargeIcon", "()Landroid/graphics/Bitmap;", "defaultSmallIconId", "", "getDefaultSmallIconId", "()I", "addNotificationActionButtons", "", "fcmJson", "Lorg/json/JSONObject;", "intentGenerator", "Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "notificationId", "groupSummary", "", "addXiaomiSettings", "oneSignalNotificationBuilder", "Lcom/onesignal/notifications/internal/display/impl/NotificationDisplayBuilder$OneSignalNotificationBuilder;", "notification", "Landroid/app/Notification;", "getBaseOneSignalNotificationBuilder", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "getGroupAlertBehavior", "getNewBaseDismissIntent", "Landroid/content/Intent;", "getNewDismissActionPendingIntent", "Landroid/app/PendingIntent;", "requestCode", "intent", "getTitle", "", "removeNotifyOptions", "builder", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationDisplayBuilder {
    void addNotificationActionButtons(JSONObject arg1, IntentGeneratorForAttachingToNotifications arg2, Builder arg3, int arg4, String arg5);

    void addXiaomiSettings(OneSignalNotificationBuilder arg1, Notification arg2);

    OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob arg1);

    Bitmap getDefaultLargeIcon();

    int getDefaultSmallIconId();

    int getGroupAlertBehavior();

    Intent getNewBaseDismissIntent(int arg1);

    PendingIntent getNewDismissActionPendingIntent(int arg1, Intent arg2);

    CharSequence getTitle(JSONObject arg1);

    void removeNotifyOptions(Builder arg1);
}

