package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001A\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/RemoveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class RemoveOnCancel extends BeforeResumeCancelHandler {
    private final LockFreeLinkedListNode node;

    public RemoveOnCancel(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        this.node = lockFreeLinkedListNode0;
    }

    @Override  // kotlin.jvm.functions.Function1
    public Object invoke(Object object0) {
        this.invoke(((Throwable)object0));
        return Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.CancelHandlerBase
    public void invoke(Throwable throwable0) {
        this.node.remove();
    }

    @Override
    public String toString() {
        return UnityPlayerActivity.adjustValue("3C15000E1804280B310F1E0E04023A") + this.node + ']';
    }
}

