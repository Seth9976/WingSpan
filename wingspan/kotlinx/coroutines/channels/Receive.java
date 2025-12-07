package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\r\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000EJ\u0014\u0010\u000F\u001A\u00020\f2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0011H&R\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/Receive;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "()V", "offerResult", "Lkotlinx/coroutines/internal/Symbol;", "getOfferResult", "()Lkotlinx/coroutines/internal/Symbol;", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class Receive extends LockFreeLinkedListNode implements ReceiveOrClosed {
    @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
    public Object getOfferResult() {
        return this.getOfferResult();
    }

    public Symbol getOfferResult() {
        return AbstractChannelKt.OFFER_SUCCESS;
    }

    public Function1 resumeOnCancellationFun(Object object0) {
        return null;
    }

    public abstract void resumeReceiveClosed(Closed arg1);
}

