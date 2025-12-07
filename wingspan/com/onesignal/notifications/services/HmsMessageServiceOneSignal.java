package com.onesignal.notifications.services;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.bridges.OneSignalHmsEventBridge;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0017J\u0018\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/services/HmsMessageServiceOneSignal;", "Lcom/huawei/hms/push/HmsMessageService;", "()V", "onMessageReceived", "", "message", "Lcom/huawei/hms/push/RemoteMessage;", "onNewToken", "token", "", "bundle", "Landroid/os/Bundle;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class HmsMessageServiceOneSignal extends HmsMessageService {
    public void onMessageReceived(RemoteMessage remoteMessage0) {
        Intrinsics.checkNotNullParameter(remoteMessage0, "message");
        OneSignalHmsEventBridge.INSTANCE.onMessageReceived(((Context)this), remoteMessage0);
    }

    @Deprecated(message = "")
    public void onNewToken(String s) {
        Intrinsics.checkNotNullParameter(s, "token");
        Logging.debug$default(("HmsMessageServiceOneSignal onNewToken refresh token:" + s), null, 2, null);
        OneSignalHmsEventBridge.INSTANCE.onNewToken(((Context)this), s);
    }

    public void onNewToken(String s, Bundle bundle0) {
        Intrinsics.checkNotNullParameter(s, "token");
        Intrinsics.checkNotNullParameter(bundle0, "bundle");
        Logging.debug$default(("HmsMessageServiceOneSignal onNewToken refresh token:" + s), null, 2, null);
        OneSignalHmsEventBridge.INSTANCE.onNewToken(((Context)this), s, bundle0);
    }
}

