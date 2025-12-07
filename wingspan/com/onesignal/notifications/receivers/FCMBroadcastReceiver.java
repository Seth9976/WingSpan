package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor.ProcessedBundleResult;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\b\u0010\t\u001A\u00020\u0004H\u0002J\b\u0010\n\u001A\u00020\u0004H\u0002¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/receivers/FCMBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "setAbort", "setSuccessfulResultCode", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class FCMBroadcastReceiver extends BroadcastReceiver {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/receivers/FCMBroadcastReceiver$Companion;", "", "()V", "FCM_RECEIVE_ACTION", "", "FCM_TYPE", "MESSAGE_TYPE_EXTRA_KEY", "isFCMMessage", "", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final boolean isFCMMessage(Intent intent0) {
            if(Intrinsics.areEqual("com.google.android.c2dm.intent.RECEIVE", intent0.getAction())) {
                String s = intent0.getStringExtra("message_type");
                return s == null || Intrinsics.areEqual("gcm", s);
            }
            return false;
        }
    }

    public static final Companion Companion = null;
    private static final String FCM_RECEIVE_ACTION = "com.google.android.c2dm.intent.RECEIVE";
    private static final String FCM_TYPE = "gcm";
    private static final String MESSAGE_TYPE_EXTRA_KEY = "message_type";

    static {
        FCMBroadcastReceiver.Companion = new Companion(null);
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(intent0, "intent");
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 != null && !Intrinsics.areEqual("google.com/iid", bundle0.getString("from"))) {
            Context context1 = context0.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context1, "context.applicationContext");
            if(!OneSignal.initWithContext(context1)) {
                return;
            }
            INotificationBundleProcessor iNotificationBundleProcessor0 = (INotificationBundleProcessor)OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
            if(!FCMBroadcastReceiver.Companion.isFCMMessage(intent0)) {
                this.setSuccessfulResultCode();
                return;
            }
            ProcessedBundleResult iNotificationBundleProcessor$ProcessedBundleResult0 = iNotificationBundleProcessor0.processBundleFromReceiver(context0, bundle0);
            Intrinsics.checkNotNull(iNotificationBundleProcessor$ProcessedBundleResult0);
            if(iNotificationBundleProcessor$ProcessedBundleResult0.isWorkManagerProcessing()) {
                this.setAbort();
                return;
            }
            this.setSuccessfulResultCode();
        }
    }

    private final void setAbort() {
        if(this.isOrderedBroadcast()) {
            this.abortBroadcast();
            this.setResultCode(-1);
        }
    }

    private final void setSuccessfulResultCode() {
        if(this.isOrderedBroadcast()) {
            this.setResultCode(-1);
        }
    }
}

