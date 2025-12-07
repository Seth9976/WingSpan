package kotlinx.coroutines.sync;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u001FB!\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0004¢\u0006\u0004\b\n\u0010\u000BJ,\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0012\u001A\u0004\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001A\u0004\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0016\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001D\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "index", "", "cancel", "(I)V", "", "expected", "value", "", "cas", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "get", "(I)Ljava/lang/Object;", "getAndSet", "(ILjava/lang/Object;)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "getMaxSlots", "()I", "maxSlots", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/Segment;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class SemaphoreSegment extends Segment {
    AtomicReferenceArray acquirers;

    public SemaphoreSegment(long v, SemaphoreSegment semaphoreSegment0, int v1) {
        super(v, semaphoreSegment0, v1);
        this.acquirers = new AtomicReferenceArray(SemaphoreKt.SEGMENT_SIZE);
    }

    public final void cancel(int v) {
        this.acquirers.set(v, SemaphoreKt.CANCELLED);
        this.onSlotCleaned();
    }

    public final boolean cas(int v, Object object0, Object object1) {
        return WorkSpec..ExternalSyntheticBackport0.m(this.acquirers, v, object0, object1);
    }

    public final Object get(int v) {
        return this.acquirers.get(v);
    }

    public final Object getAndSet(int v, Object object0) {
        return this.acquirers.getAndSet(v, object0);
    }

    @Override  // kotlinx.coroutines.internal.Segment
    public int getMaxSlots() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    public final void set(int v, Object object0) {
        this.acquirers.set(v, object0);
    }

    @Override
    public String toString() {
        return UnityPlayerActivity.adjustValue("3D1500001E090817173D150A0C0B0F133E1B0A4D") + this.getId() + UnityPlayerActivity.adjustValue("425005001D09240A160B4D") + this.hashCode() + ']';
    }
}

