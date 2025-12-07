package kotlinx.coroutines.flow;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u001B\u0010\u0006\u001A\u00020\u00052\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001A\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000B2\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\b¢\u0006\u0004\b\u000F\u0010\u0002J\r\u0010\u0010\u001A\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class StateFlowSlot extends AbstractSharedFlowSlot {
    volatile Object _state;
    static final AtomicReferenceFieldUpdater _state$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("310319001A04");
        StateFlowSlot._state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, s);
    }

    public StateFlowSlot() {
        this._state = null;
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(Object object0) {
        return this.allocateLocked(((StateFlowImpl)object0));
    }

    public boolean allocateLocked(StateFlowImpl stateFlowImpl0) {
        if(this._state != null) {
            return false;
        }
        this._state = StateFlowKt.NONE;
        return true;
    }

    public final Object awaitPending(Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        if(!WorkSpec..ExternalSyntheticBackport0.m(StateFlowSlot._state$FU, this, StateFlowKt.NONE, cancellableContinuationImpl0)) {
            cancellableContinuationImpl0.resumeWith(Unit.INSTANCE);
        }
        Object object0 = cancellableContinuationImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation[] freeLocked(Object object0) {
        return this.freeLocked(((StateFlowImpl)object0));
    }

    public Continuation[] freeLocked(StateFlowImpl stateFlowImpl0) {
        this._state = null;
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        Object object0;
        do {
            while(true) {
                object0 = this._state;
                if(object0 == null) {
                    return;
                }
                if(object0 == StateFlowKt.PENDING) {
                    return;
                }
                if(object0 != StateFlowKt.NONE) {
                    break;
                }
                if(WorkSpec..ExternalSyntheticBackport0.m(StateFlowSlot._state$FU, this, object0, StateFlowKt.PENDING)) {
                    return;
                }
            }
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(StateFlowSlot._state$FU, this, object0, StateFlowKt.NONE));
        ((CancellableContinuationImpl)object0).resumeWith(Unit.INSTANCE);
    }

    public final boolean takePending() {
        Object object0 = StateFlowSlot._state$FU.getAndSet(this, StateFlowKt.NONE);
        Intrinsics.checkNotNull(object0);
        return object0 == StateFlowKt.PENDING;
    }
}

