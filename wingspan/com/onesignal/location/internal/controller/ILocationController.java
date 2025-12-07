package com.onesignal.location.internal.controller;

import android.location.Location;
import com.onesignal.common.events.IEventNotifier;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001A\u0004\u0018\u00010\u0004H&J\u0011\u0010\u0005\u001A\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/location/internal/controller/ILocationController;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "getLastLocation", "Landroid/location/Location;", "start", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ILocationController extends IEventNotifier {
    Location getLastLocation();

    Object start(Continuation arg1);

    Object stop(Continuation arg1);
}

