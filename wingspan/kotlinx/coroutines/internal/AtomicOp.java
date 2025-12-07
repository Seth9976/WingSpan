package kotlinx.coroutines.internal;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\b\'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00028\u00002\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00052\b\u0010\n\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\r\u001A\u0004\u0018\u00010\u00052\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000E\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001A\u00028\u0000H&¢\u0006\u0004\b\u000E\u0010\fR\u0018\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0014\u001A\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001B\u001A\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class AtomicOp extends OpDescriptor {
    private volatile Object _consensus;
    private static final AtomicReferenceFieldUpdater _consensus$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("3113020F1D040916071D");
        AtomicOp._consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, s);
    }

    public AtomicOp() {
        this._consensus = AtomicKt.NO_DECISION;
    }

    public abstract void complete(Object arg1, Object arg2);

    public final Object decide(Object object0) {
        Object object1 = this._consensus;
        if(object1 != AtomicKt.NO_DECISION) {
            return object1;
        }
        return WorkSpec..ExternalSyntheticBackport0.m(AtomicOp._consensus$FU, this, AtomicKt.NO_DECISION, object0) ? object0 : this._consensus;
    }

    @Override  // kotlinx.coroutines.internal.OpDescriptor
    public AtomicOp getAtomicOp() {
        return this;
    }

    public final Object getConsensus() {
        return this._consensus;
    }

    public long getOpSequence() {
        return 0L;
    }

    public final boolean isDecided() {
        return this._consensus != AtomicKt.NO_DECISION;
    }

    @Override  // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object object0) {
        Object object1 = this._consensus == AtomicKt.NO_DECISION ? this.decide(this.prepare(object0)) : this._consensus;
        this.complete(object0, object1);
        return object1;
    }

    public abstract Object prepare(Object arg1);
}

