package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001B\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000B\u001A\u00020\u0006H\u0016J\u0014\u0010\f\u001A\u00020\u00062\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0014\u0010\u0011\u001A\u0004\u0018\u00010\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001A\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/SendElement;", "E", "Lkotlinx/coroutines/channels/Send;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class SendElement extends Send {
    public final CancellableContinuation cont;
    private final Object pollResult;

    public SendElement(Object object0, CancellableContinuation cancellableContinuation0) {
        this.pollResult = object0;
        this.cont = cancellableContinuation0;
    }

    @Override  // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
        this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
    }

    @Override  // kotlinx.coroutines.channels.Send
    public Object getPollResult() {
        return this.pollResult;
    }

    @Override  // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed closed0) {
        Object object0 = Result.constructor-impl(ResultKt.createFailure(closed0.getSendException()));
        this.cont.resumeWith(object0);
    }

    @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '(' + this.getPollResult() + ')';
    }

    @Override  // kotlinx.coroutines.channels.Send
    public Symbol tryResumeSend(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
        if(this.cont.tryResume(Unit.INSTANCE, (lockFreeLinkedListNode$PrepareOp0 == null ? null : lockFreeLinkedListNode$PrepareOp0.desc)) == null) {
            return null;
        }
        if(lockFreeLinkedListNode$PrepareOp0 != null) {
            lockFreeLinkedListNode$PrepareOp0.finishPrepare();
        }
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }
}

