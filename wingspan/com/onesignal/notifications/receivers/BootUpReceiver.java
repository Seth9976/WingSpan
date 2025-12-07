package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/receivers/BootUpReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BootUpReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(intent0, "intent");
        Context context1 = context0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context1, "context.applicationContext");
        if(!OneSignal.initWithContext(context1)) {
            return;
        }
        ((INotificationRestoreWorkManager)OneSignal.INSTANCE.getServices().getService(INotificationRestoreWorkManager.class)).beginEnqueueingWork(context0, true);
    }
}

