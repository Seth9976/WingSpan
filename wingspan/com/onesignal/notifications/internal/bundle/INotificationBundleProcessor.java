package com.onesignal.notifications.internal.bundle;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\bJ\u001A\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor;", "", "processBundleFromReceiver", "Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor$ProcessedBundleResult;", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "ProcessedBundleResult", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationBundleProcessor {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0004J\u000E\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0004R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/internal/bundle/INotificationBundleProcessor$ProcessedBundleResult;", "", "()V", "isDeniedByLifecycleCallback", "", "isOneSignalPayload", "isProcessed", "()Z", "isWorkManagerProcessing", "setWorkManagerProcessing", "(Z)V", "setDeniedByLifecycleCallback", "", "deniedByLifecycleCallback", "setOneSignalPayload", "oneSignalPayload", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ProcessedBundleResult {
        private boolean isDeniedByLifecycleCallback;
        private boolean isOneSignalPayload;
        private boolean isWorkManagerProcessing;

        // 去混淆评级： 低(30)
        public final boolean isProcessed() {
            return !this.isOneSignalPayload || this.isDeniedByLifecycleCallback || this.isWorkManagerProcessing;
        }

        public final boolean isWorkManagerProcessing() {
            return this.isWorkManagerProcessing;
        }

        public final void setDeniedByLifecycleCallback(boolean z) {
            this.isDeniedByLifecycleCallback = z;
        }

        public final void setOneSignalPayload(boolean z) {
            this.isOneSignalPayload = z;
        }

        public final void setWorkManagerProcessing(boolean z) {
            this.isWorkManagerProcessing = z;
        }
    }

    ProcessedBundleResult processBundleFromReceiver(Context arg1, Bundle arg2);
}

