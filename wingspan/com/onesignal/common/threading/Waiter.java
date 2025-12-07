package com.onesignal.common.threading;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001A\u00020\bR\u0016\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/onesignal/common/threading/Waiter;", "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "waitForWake", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wake", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Waiter {
    private final Channel channel;

    public Waiter() {
        this.channel = ChannelKt.Channel$default(-1, null, null, 6, null);
    }

    public final Object waitForWake(Continuation continuation0) {
        return this.channel.receive(continuation0);
    }

    public final void wake() {
        Object object0 = this.channel.trySend-JP2dKIU(null);
        if(ChannelResult.isFailure-impl(object0)) {
            throw new Exception("Waiter.wait failed", ChannelResult.exceptionOrNull-impl(object0));
        }
    }
}

