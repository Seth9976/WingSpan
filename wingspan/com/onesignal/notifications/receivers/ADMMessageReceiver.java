package com.onesignal.notifications.receivers;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.services.ADMMessageHandler;
import com.onesignal.notifications.services.ADMMessageHandlerJob;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/onesignal/notifications/receivers/ADMMessageReceiver;", "Lcom/amazon/device/messaging/ADMMessageReceiver;", "()V", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ADMMessageReceiver extends com.amazon.device.messaging.ADMMessageReceiver {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/receivers/ADMMessageReceiver$Companion;", "", "()V", "JOB_ID", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int JOB_ID = 0x1E3F3;

    static {
        ADMMessageReceiver.Companion = new Companion(null);
    }

    public ADMMessageReceiver() {
        super(ADMMessageHandler.class);
        boolean z = false;
        try {
            Class.forName("com.amazon.device.messaging.ADMMessageHandlerJobBase");
            z = true;
        }
        catch(ClassNotFoundException unused_ex) {
        }
        if(z) {
            this.registerJobServiceClass(ADMMessageHandlerJob.class, 0x1E3F3);
        }
        Logging.debug$default(("ADM latest available: " + z), null, 2, null);
    }
}

