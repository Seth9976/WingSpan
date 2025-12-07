package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.debug.internal.logging.Logging;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n¨\u0006\u000B"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerTimer;", "", "()V", "scheduleTrigger", "", "task", "Ljava/util/TimerTask;", "triggerId", "", "delay", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DynamicTriggerTimer {
    public static final DynamicTriggerTimer INSTANCE;

    static {
        DynamicTriggerTimer.INSTANCE = new DynamicTriggerTimer();
    }

    public final void scheduleTrigger(TimerTask timerTask0, String s, long v) {
        Intrinsics.checkNotNullParameter(s, "triggerId");
        Logging.debug$default(("scheduleTrigger: " + s + " delay: " + v), null, 2, null);
        new Timer("trigger_timer:" + s).schedule(timerTask0, v);
    }
}

