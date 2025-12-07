package com.onesignal.location.internal;

import com.onesignal.location.ILocationManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\b\u0000\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001A\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nR$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/location/internal/MisconfiguredLocationManager;", "Lcom/onesignal/location/ILocationManager;", "()V", "value", "", "isShared", "()Z", "setShared", "(Z)V", "requestPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MisconfiguredLocationManager implements ILocationManager {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/location/internal/MisconfiguredLocationManager$Companion;", "", "()V", "EXCEPTION", "Ljava/lang/Exception;", "Lkotlin/Exception;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion;
    private static final Exception EXCEPTION;

    static {
        MisconfiguredLocationManager.Companion = new Companion(null);
        MisconfiguredLocationManager.EXCEPTION = new Exception("Must include gradle module com.onesignal:Location in order to use this functionality!");
    }

    @Override  // com.onesignal.location.ILocationManager
    public boolean isShared() {
        throw MisconfiguredLocationManager.EXCEPTION;
    }

    @Override  // com.onesignal.location.ILocationManager
    public Object requestPermission(Continuation continuation0) {
        throw MisconfiguredLocationManager.EXCEPTION;
    }

    @Override  // com.onesignal.location.ILocationManager
    public void setShared(boolean z) {
        throw MisconfiguredLocationManager.EXCEPTION;
    }
}

