package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0016J\u0011\u0010\t\u001A\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\u000B\u001A\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016R\u0014\u0010\u0003\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/NullLocationController;", "Lcom/onesignal/location/internal/controller/ILocationController;", "()V", "hasSubscribers", "", "getHasSubscribers", "()Z", "getLastLocation", "Landroid/location/Location;", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "", "subscribe", "handler", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "unsubscribe", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NullLocationController implements ILocationController {
    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return false;
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Location getLastLocation() {
        return null;
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Object start(Continuation continuation0) {
        return Boxing.boxBoolean(false);
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Object stop(Continuation continuation0) {
        return Unit.INSTANCE;
    }

    public void subscribe(ILocationUpdatedHandler iLocationUpdatedHandler0) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "handler");
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ILocationUpdatedHandler)object0));
    }

    public void unsubscribe(ILocationUpdatedHandler iLocationUpdatedHandler0) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "handler");
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ILocationUpdatedHandler)object0));
    }
}

