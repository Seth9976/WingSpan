package com.onesignal.common.threading;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0006\u001A\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0002\u0010\u000BR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/common/threading/WaiterWithValue;", "TType", "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "waitForWake", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wake", "", "value", "(Ljava/lang/Object;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class WaiterWithValue {
    private final Channel channel;

    public WaiterWithValue() {
        this.channel = ChannelKt.Channel$default(-1, null, null, 6, null);
    }

    public final Object waitForWake(Continuation continuation0) {
        return this.channel.receive(continuation0);
    }

    public final void wake(Object object0) {
        Object object1 = this.channel.trySend-JP2dKIU(object0);
        if(ChannelResult.isFailure-impl(object1)) {
            throw new Exception("WaiterWithValue.wait failed", ChannelResult.exceptionOrNull-impl(object1));
        }
    }
}

