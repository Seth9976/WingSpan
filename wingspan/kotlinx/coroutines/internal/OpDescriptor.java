package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0000J\u0014\u0010\n\u001A\u0004\u0018\u00010\u00012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001H&J\b\u0010\f\u001A\u00020\rH\u0016R\u0018\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/internal/OpDescriptor;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", "", "that", "perform", "affected", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class OpDescriptor {
    public abstract AtomicOp getAtomicOp();

    public final boolean isEarlierThan(OpDescriptor opDescriptor0) {
        AtomicOp atomicOp0 = this.getAtomicOp();
        if(atomicOp0 == null) {
            return false;
        }
        AtomicOp atomicOp1 = opDescriptor0.getAtomicOp();
        return atomicOp1 == null ? false : atomicOp0.getOpSequence() < atomicOp1.getOpSequence();
    }

    public abstract Object perform(Object arg1);

    @Override
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}

