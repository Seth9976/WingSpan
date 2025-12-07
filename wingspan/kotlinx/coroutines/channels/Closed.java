package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000F\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0012H\u0016J\u0014\u0010\u0016\u001A\u00020\u00122\n\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u001F\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0013\u001A\u00028\u00002\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0016¢\u0006\u0002\u0010\u001EJ\u0012\u0010\u001F\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0016R\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000E¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class Closed extends Send implements ReceiveOrClosed {
    public final Throwable closeCause;

    public Closed(Throwable throwable0) {
        this.closeCause = throwable0;
    }

    @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(Object object0) {
    }

    @Override  // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
    }

    @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
    public Object getOfferResult() {
        return this;
    }

    public Closed getOfferResult() [...] // Inlined contents

    @Override  // kotlinx.coroutines.channels.Send
    public Object getPollResult() {
        return this;
    }

    public Closed getPollResult() [...] // Inlined contents

    public final Throwable getReceiveException() {
        Throwable throwable0 = this.closeCause;
        return throwable0 == null ? new ClosedReceiveChannelException(UnityPlayerActivity.adjustValue("2D180C0F00040B45050F034D02020E140016")) : throwable0;
    }

    public final Throwable getSendException() {
        Throwable throwable0 = this.closeCause;
        return throwable0 == null ? new ClosedSendChannelException(UnityPlayerActivity.adjustValue("2D180C0F00040B45050F034D02020E140016")) : throwable0;
    }

    @Override  // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed closed0) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            throw new AssertionError();
        }
    }

    @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return UnityPlayerActivity.adjustValue("2D1C02120B0527") + DebugStringsKt.getHexAddress(this) + '[' + this.closeCause + ']';
    }

    @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
    public Symbol tryResumeReceive(Object object0, PrepareOp lockFreeLinkedListNode$PrepareOp0) {
        Symbol symbol0 = CancellableContinuationImplKt.RESUME_TOKEN;
        if(lockFreeLinkedListNode$PrepareOp0 != null) {
            lockFreeLinkedListNode$PrepareOp0.finishPrepare();
        }
        return symbol0;
    }

    @Override  // kotlinx.coroutines.channels.Send
    public Symbol tryResumeSend(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
        Symbol symbol0 = CancellableContinuationImplKt.RESUME_TOKEN;
        if(lockFreeLinkedListNode$PrepareOp0 != null) {
            lockFreeLinkedListNode$PrepareOp0.finishPrepare();
        }
        return symbol0;
    }
}

