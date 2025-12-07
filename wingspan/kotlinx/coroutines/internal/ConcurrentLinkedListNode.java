package kotlinx.coroutines.internal;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\t\b \u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u001AB\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000E\u001A\u0004\u0018\u00018\u00002\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0086\b¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007J\u0015\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\nR\u0016\u0010\u0017\u001A\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001D\u001A\u0004\u0018\u00010\u001A8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0013\u0010\u0002\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0016R\u0014\u0010 \u001A\u00020\b8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\nR\u0014\u0010\"\u001A\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0016¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "", "cleanPrev", "()V", "", "markAsClosed", "()Z", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "value", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "getLeftmostAliveNode", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "leftmostAliveNode", "getNext", "next", "", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getPrev", "getRemoved", "removed", "getRightmostAliveNode", "rightmostAliveNode", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class ConcurrentLinkedListNode {
    private volatile Object _next;
    private static final AtomicReferenceFieldUpdater _next$FU;
    private volatile Object _prev;
    private static final AtomicReferenceFieldUpdater _prev$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("311E08191A");
        ConcurrentLinkedListNode._next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, s);
        String s1 = UnityPlayerActivity.adjustValue("31001F0418");
        ConcurrentLinkedListNode._prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, s1);
    }

    public ConcurrentLinkedListNode(ConcurrentLinkedListNode concurrentLinkedListNode0) {
        this._next = null;
        this._prev = concurrentLinkedListNode0;
    }

    public final void cleanPrev() {
        ConcurrentLinkedListNode._prev$FU.lazySet(this, null);
    }

    private final ConcurrentLinkedListNode getLeftmostAliveNode() {
        ConcurrentLinkedListNode concurrentLinkedListNode0;
        for(concurrentLinkedListNode0 = this.getPrev(); concurrentLinkedListNode0 != null && concurrentLinkedListNode0.getRemoved(); concurrentLinkedListNode0 = (ConcurrentLinkedListNode)concurrentLinkedListNode0._prev) {
        }
        return concurrentLinkedListNode0;
    }

    public final ConcurrentLinkedListNode getNext() {
        Object object0 = this.getNextOrClosed();
        return object0 == ConcurrentLinkedListKt.CLOSED ? null : ((ConcurrentLinkedListNode)object0);
    }

    private final Object getNextOrClosed() {
        return this._next;
    }

    public final ConcurrentLinkedListNode getPrev() {
        return (ConcurrentLinkedListNode)this._prev;
    }

    public abstract boolean getRemoved();

    private final ConcurrentLinkedListNode getRightmostAliveNode() {
        if(DebugKt.getASSERTIONS_ENABLED() && !this.isTail() == 0) {
            throw new AssertionError();
        }
        ConcurrentLinkedListNode concurrentLinkedListNode0 = this.getNext();
        Intrinsics.checkNotNull(concurrentLinkedListNode0);
        while(concurrentLinkedListNode0.getRemoved()) {
            concurrentLinkedListNode0 = concurrentLinkedListNode0.getNext();
            Intrinsics.checkNotNull(concurrentLinkedListNode0);
        }
        return concurrentLinkedListNode0;
    }

    public final boolean isTail() {
        return this.getNext() == null;
    }

    public final boolean markAsClosed() {
        return WorkSpec..ExternalSyntheticBackport0.m(ConcurrentLinkedListNode._next$FU, this, null, ConcurrentLinkedListKt.CLOSED);
    }

    public final ConcurrentLinkedListNode nextOrIfClosed(Function0 function00) {
        Object object0 = this.getNextOrClosed();
        if(object0 != ConcurrentLinkedListKt.CLOSED) {
            return (ConcurrentLinkedListNode)object0;
        }
        function00.invoke();
        throw new KotlinNothingValueException();
    }

    public final void remove() {
        do {
            ConcurrentLinkedListNode concurrentLinkedListNode0 = this.getLeftmostAliveNode();
            ConcurrentLinkedListNode concurrentLinkedListNode1 = this.getRightmostAliveNode();
            concurrentLinkedListNode1._prev = concurrentLinkedListNode0;
            if(concurrentLinkedListNode0 != null) {
                concurrentLinkedListNode0._next = concurrentLinkedListNode1;
            }
        }
        while(concurrentLinkedListNode1.getRemoved() || concurrentLinkedListNode0 != null && concurrentLinkedListNode0.getRemoved());
    }

    public final boolean trySetNext(ConcurrentLinkedListNode concurrentLinkedListNode0) {
        return WorkSpec..ExternalSyntheticBackport0.m(ConcurrentLinkedListNode._next$FU, this, null, concurrentLinkedListNode0);
    }
}

