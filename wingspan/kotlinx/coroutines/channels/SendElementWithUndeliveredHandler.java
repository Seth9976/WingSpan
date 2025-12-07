package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0002\u0010\nJ\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u0006H\u0016R&\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00028\u0000`\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/channels/SendElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/SendElement;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "onUndeliveredElement", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)V", "remove", "", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class SendElementWithUndeliveredHandler extends SendElement {
    public final Function1 onUndeliveredElement;

    public SendElementWithUndeliveredHandler(Object object0, CancellableContinuation cancellableContinuation0, Function1 function10) {
        super(object0, cancellableContinuation0);
        this.onUndeliveredElement = function10;
    }

    @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean remove() {
        if(!super.remove()) {
            return false;
        }
        this.undeliveredElement();
        return true;
    }

    @Override  // kotlinx.coroutines.channels.Send
    public void undeliveredElement() {
        Object object0 = this.getPollResult();
        CoroutineContext coroutineContext0 = this.cont.getContext();
        OnUndeliveredElementKt.callUndeliveredElement(this.onUndeliveredElement, object0, coroutineContext0);
    }
}

