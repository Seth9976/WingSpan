package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\b \u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u001BB!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\f\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\tH\u0000¢\u0006\u0004\b\u0010\u0010\u000BR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u00058&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u000B¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "", "decPointers$kotlinx_coroutines_core", "()Z", "decPointers", "", "onSlotCleaned", "()V", "tryIncPointers$kotlinx_coroutines_core", "tryIncPointers", "J", "getId", "()J", "getMaxSlots", "()I", "maxSlots", "getRemoved", "removed", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class Segment extends ConcurrentLinkedListNode {
    private volatile int cleanedAndPointers;
    private static final AtomicIntegerFieldUpdater cleanedAndPointers$FU;
    private final long id;

    static {
        String s = UnityPlayerActivity.adjustValue("0D1C0800000403241C0A2002080015021701");
        Segment.cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, s);
    }

    public Segment(long v, Segment segment0, int v1) {
        super(segment0);
        this.id = v;
        this.cleanedAndPointers = v1 << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return Segment.cleanedAndPointers$FU.addAndGet(this, 0xFFFF0000) == this.getMaxSlots() && !this.isTail();
    }

    public final long getId() {
        return this.id;
    }

    public abstract int getMaxSlots();

    @Override  // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean getRemoved() {
        return this.cleanedAndPointers == this.getMaxSlots() && !this.isTail();
    }

    public final void onSlotCleaned() {
        if(Segment.cleanedAndPointers$FU.incrementAndGet(this) == this.getMaxSlots() && !this.isTail()) {
            this.remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        while(true) {
            int v = this.cleanedAndPointers;
            if(v == this.getMaxSlots() && !this.isTail()) {
                break;
            }
            if(Segment.cleanedAndPointers$FU.compareAndSet(this, v, v + 0x10000)) {
                return true;
            }
        }
        return false;
    }
}

