package com.onesignal.notifications.internal.display.impl;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.onesignal.notifications.activities.NotificationOpenedActivity;
import com.onesignal.notifications.activities.NotificationOpenedActivityAndroid22AndOlder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FJ\u000E\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\rJ\b\u0010\u0012\u001A\u00020\u000FH\u0003J\b\u0010\u0013\u001A\u00020\u000FH\u0003R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/notifications/internal/display/impl/IntentGeneratorForAttachingToNotifications;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "notificationOpenedClassAndroid22AndOlder", "Ljava/lang/Class;", "notificationOpenedClassAndroid23Plus", "getNewActionPendingIntent", "Landroid/app/PendingIntent;", "requestCode", "", "oneSignalIntent", "Landroid/content/Intent;", "getNewBaseIntent", "notificationId", "getNewBaseIntentAndroidAPI22AndOlder", "getNewBaseIntentAndroidAPI23Plus", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class IntentGeneratorForAttachingToNotifications {
    private final Context context;
    private final Class notificationOpenedClassAndroid22AndOlder;
    private final Class notificationOpenedClassAndroid23Plus;

    public IntentGeneratorForAttachingToNotifications(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        super();
        this.context = context0;
        this.notificationOpenedClassAndroid23Plus = NotificationOpenedActivity.class;
        this.notificationOpenedClassAndroid22AndOlder = NotificationOpenedActivityAndroid22AndOlder.class;
    }

    public final Context getContext() {
        return this.context;
    }

    public final PendingIntent getNewActionPendingIntent(int v, Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "oneSignalIntent");
        return PendingIntent.getActivity(this.context, v, intent0, 0xC000000);
    }

    public final Intent getNewBaseIntent(int v) {
        Intent intent0 = this.getNewBaseIntentAndroidAPI23Plus().putExtra("androidNotificationId", v).addFlags(0x24000000);
        Intrinsics.checkNotNullExpressionValue(intent0, "intent\n            .putE…_CLEAR_TOP,\n            )");
        return intent0;
    }

    @Deprecated(message = "Use getNewBaseIntentAndroidAPI23Plus instead for Android 6+")
    private final Intent getNewBaseIntentAndroidAPI22AndOlder() {
        Intent intent0 = new Intent(this.context, this.notificationOpenedClassAndroid22AndOlder);
        intent0.addFlags(0x18080000);
        return intent0;
    }

    private final Intent getNewBaseIntentAndroidAPI23Plus() {
        return new Intent(this.context, this.notificationOpenedClassAndroid23Plus);
    }
}

