package com.onesignal.location;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0007\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/onesignal/location/ILocationManager;", "", "isShared", "", "()Z", "setShared", "(Z)V", "requestPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ILocationManager {
    boolean isShared();

    Object requestPermission(Continuation arg1);

    void setShared(boolean arg1);
}

