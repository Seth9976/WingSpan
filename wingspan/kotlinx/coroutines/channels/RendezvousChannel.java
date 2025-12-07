package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\'\u0012 \u0010\u0003\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\nR\u0014\u0010\u000B\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u0014\u0010\f\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\nR\u0014\u0010\r\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\n¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/channels/RendezvousChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class RendezvousChannel extends AbstractChannel {
    public RendezvousChannel(Function1 function10) {
        super(function10);
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return true;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return true;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return true;
    }
}

