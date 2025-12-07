package kotlinx.coroutines.selects;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1 = {"\u0000\u00AE\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020Y2\b\u0012\u0004\u0012\u00028\u00000Z2\b\u0012\u0004\u0012\u00028\u00000[2\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060Bj\u0002`C:\u0004TUVWB\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ.\u0010\u0011\u001A\u00020\b2\u000E\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\b0\rH\u0082\b\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001A\u0004\u0018\u00010\u000EH\u0001\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\u0019H\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u001D\u0010\fJ8\u0010!\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u001E2\u001C\u0010\u0010\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000E0 H\u0016\u00F8\u0001\u0000\u00A2\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001A\u0004\u0018\u00010\u000E2\u0006\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b(\u0010\u001CJ \u0010+\u001A\u00020\b2\f\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000)H\u0016\u00F8\u0001\u0000\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010.\u001A\u00020-H\u0016\u00A2\u0006\u0004\b.\u0010/J\u000F\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b1\u00102J\u001B\u00105\u001A\u0004\u0018\u00010\u000E2\b\u00104\u001A\u0004\u0018\u000103H\u0016\u00A2\u0006\u0004\b5\u00106J5\u00108\u001A\u00020\b*\u0002072\u001C\u0010\u0010\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000E0 H\u0096\u0002\u00F8\u0001\u0000\u00A2\u0006\u0004\b8\u00109JG\u00108\u001A\u00020\b\"\u0004\b\u0001\u0010:*\b\u0012\u0004\u0012\u00028\u00010;2\"\u0010\u0010\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000E0<H\u0096\u0002\u00F8\u0001\u0000\u00A2\u0006\u0004\b8\u0010=J[\u00108\u001A\u00020\b\"\u0004\b\u0001\u0010>\"\u0004\b\u0002\u0010:*\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?2\u0006\u0010@\u001A\u00028\u00012\"\u0010\u0010\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000E0<H\u0096\u0002\u00F8\u0001\u0000\u00A2\u0006\u0004\b8\u0010AR\u001C\u0010F\u001A\n\u0018\u00010Bj\u0004\u0018\u0001`C8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bD\u0010ER\u001A\u0010I\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bG\u0010HR\u0014\u0010M\u001A\u00020J8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bK\u0010LR\u0014\u0010N\u001A\u0002008VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bN\u00102R(\u0010R\u001A\u0004\u0018\u00010\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u00068B@BX\u0082\u000E\u00A2\u0006\f\u001A\u0004\bO\u0010P\"\u0004\bQ\u0010\nR\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010S\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006X"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class SelectBuilderImpl extends LockFreeLinkedListHead implements Continuation, CoroutineStackFrame, SelectBuilder, SelectInstance {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001C\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00022\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001A\u00020\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0011\u001A\u0004\u0018\u00010\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0012\u001A\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\rH\u0002R\u0010\u0010\u0005\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "opSequence", "", "getOpSequence", "()J", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareSelectOp", "toString", "", "undoPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class AtomicSelectOp extends AtomicOp {
        public final AtomicDesc desc;
        public final SelectBuilderImpl impl;
        private final long opSequence;

        public AtomicSelectOp(SelectBuilderImpl selectBuilderImpl0, AtomicDesc atomicDesc0) {
            this.impl = selectBuilderImpl0;
            this.desc = atomicDesc0;
            this.opSequence = SelectKt.selectOpSequenceNumber.next();
            atomicDesc0.setAtomicOp(this);
        }

        @Override  // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object object0, Object object1) {
            this.completeSelect(object1);
            this.desc.complete(this, object1);
        }

        private final void completeSelect(Object object0) {
            boolean z = object0 == null;
            if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, this.impl, this, (z ? null : SelectKt.getNOT_SELECTED())) && z) {
                this.impl.doAfterSelect();
            }
        }

        @Override  // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override  // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(Object object0) {
            if(object0 == null) {
                Object object1 = this.prepareSelectOp();
                if(object1 != null) {
                    return object1;
                }
            }
            try {
                return this.desc.prepare(this);
            }
            catch(Throwable throwable0) {
                if(object0 == null) {
                    this.undoPrepare();
                }
                throw throwable0;
            }
        }

        private final Object prepareSelectOp() {
            SelectBuilderImpl selectBuilderImpl0 = this.impl;
            while(true) {
                Object object0 = selectBuilderImpl0._state;
                if(object0 == this) {
                    return null;
                }
                if(object0 instanceof OpDescriptor) {
                    ((OpDescriptor)object0).perform(this.impl);
                }
                else {
                    if(object0 != SelectKt.getNOT_SELECTED()) {
                        break;
                    }
                    if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, this.impl, SelectKt.getNOT_SELECTED(), this)) {
                        return null;
                    }
                }
            }
            return SelectKt.getALREADY_SELECTED();
        }

        @Override  // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return UnityPlayerActivity.adjustValue("2F04020C070234001E0B13192E1E491400031B1503020B5C") + this.getOpSequence() + ')';
        }

        private final void undoPrepare() {
            WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, this.impl, this, SelectKt.getNOT_SELECTED());
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle disposableHandle0) {
            this.handle = disposableHandle0;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class PairSelectOp extends OpDescriptor {
        public final PrepareOp otherOp;

        public PairSelectOp(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            this.otherOp = lockFreeLinkedListNode$PrepareOp0;
        }

        @Override  // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }

        @Override  // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object object0) {
            if(object0 == null) {
                throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E1E0402040411014023080D0B02132707071C09041C280A151E525A53"));
            }
            this.otherOp.finishPrepare();
            Object object1 = this.otherOp.getAtomicOp().decide(null);
            AbstractAtomicDesc lockFreeLinkedListNode$AbstractAtomicDesc0 = object1 == null ? this.otherOp.desc : SelectKt.getNOT_SELECTED();
            WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, ((SelectBuilderImpl)object0), this, lockFreeLinkedListNode$AbstractAtomicDesc0);
            return object1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0096\u0002¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class SelectOnCancelling extends JobCancellingNode {
        @Override  // kotlin.jvm.functions.Function1
        public Object invoke(Object object0) {
            this.invoke(((Throwable)object0));
            return Unit.INSTANCE;
        }

        @Override  // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(Throwable throwable0) {
            if(SelectBuilderImpl.this.trySelect()) {
                Throwable throwable1 = this.getJob().getCancellationException();
                SelectBuilderImpl.this.resumeSelectWithException(throwable1);
            }
        }
    }

    private volatile Object _parentHandle;
    private volatile Object _result;
    private static final AtomicReferenceFieldUpdater _result$FU;
    volatile Object _state;
    static final AtomicReferenceFieldUpdater _state$FU;
    private final Continuation uCont;

    static {
        String s = UnityPlayerActivity.adjustValue("310319001A04");
        SelectBuilderImpl._state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, s);
        String s1 = UnityPlayerActivity.adjustValue("310208121B0D13");
        SelectBuilderImpl._result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, s1);
    }

    public SelectBuilderImpl(Continuation continuation0) {
        this.uCont = continuation0;
        this._state = SelectKt.getNOT_SELECTED();
        this._result = SelectKt.access$getUNDECIDED$p();
        this._parentHandle = null;
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(DisposableHandle disposableHandle0) {
        DisposeNode selectBuilderImpl$DisposeNode0 = new DisposeNode(disposableHandle0);
        if(!this.isSelected()) {
            this.addLast(selectBuilderImpl$DisposeNode0);
            if(!this.isSelected()) {
                return;
            }
        }
        disposableHandle0.dispose();
    }

    private final void doAfterSelect() {
        DisposableHandle disposableHandle0 = this.getParentHandle();
        if(disposableHandle0 != null) {
            disposableHandle0.dispose();
        }
        for(LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)this.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode0, this); lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode()) {
            if(lockFreeLinkedListNode0 instanceof DisposeNode) {
                ((DisposeNode)lockFreeLinkedListNode0).handle.dispose();
            }
        }
    }

    private final void doResume(Function0 function00, Function0 function01) {
        while(true) {
            Object object0;
            while((object0 = this._result) == SelectKt.access$getUNDECIDED$p()) {
                Object object1 = function00.invoke();
                if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, SelectKt.access$getUNDECIDED$p(), object1)) {
                    return;
                }
            }
            if(object0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                break;
            }
            Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, object2, SelectKt.access$getRESUMED$p())) {
                function01.invoke();
                return;
            }
        }
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B05"));
    }

    // 去混淆评级： 低(20)
    @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.uCont instanceof CoroutineStackFrame ? ((CoroutineStackFrame)this.uCont) : null;
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public Continuation getCompletion() [...] // Inlined contents

    @Override  // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle)this._parentHandle;
    }

    public final Object getResult() {
        if(!this.isSelected()) {
            this.initCancellability();
        }
        Object object0 = this._result;
        if(object0 == SelectKt.access$getUNDECIDED$p()) {
            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, SelectKt.access$getUNDECIDED$p(), object1)) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            object0 = this._result;
        }
        if(object0 == SelectKt.access$getRESUMED$p()) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B05"));
        }
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        return object0;
    }

    @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void handleBuilderException(Throwable throwable0) {
        if(this.trySelect()) {
            this.resumeWith(Result.constructor-impl(ResultKt.createFailure(throwable0)));
            return;
        }
        if(!(throwable0 instanceof CancellationException)) {
            Object object0 = this.getResult();
            if(!(object0 instanceof CompletedExceptionally) || ((CompletedExceptionally)object0).cause != throwable0) {
                CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), throwable0);
            }
        }
    }

    private final void initCancellability() {
        Element coroutineContext$Element0 = this.getContext().get(Job.Key);
        if(((Job)coroutineContext$Element0) == null) {
            return;
        }
        DisposableHandle disposableHandle0 = DefaultImpls.invokeOnCompletion$default(((Job)coroutineContext$Element0), true, false, new SelectOnCancelling(this), 2, null);
        this.setParentHandle(disposableHandle0);
        if(this.isSelected()) {
            disposableHandle0.dispose();
        }
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause00, Function1 function10) {
        selectClause00.registerSelectClause0(this, function10);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause1 selectClause10, Function2 function20) {
        selectClause10.registerSelectClause1(this, function20);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause2 selectClause20, Object object0, Function2 function20) {
        selectClause20.registerSelectClause2(this, object0, function20);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause2 selectClause20, Function2 function20) {
        kotlinx.coroutines.selects.SelectBuilder.DefaultImpls.invoke(this, selectClause20, function20);
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while(true) {
            Object object0 = this._state;
            if(object0 == SelectKt.getNOT_SELECTED()) {
                return false;
            }
            if(!(object0 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object0).perform(this);
        }
        return true;
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long v, Function1 function10) {
        if(v <= 0L) {
            if(this.trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(function10, this);
            }
            return;
        }
        Runnable runnable0 = new Runnable() {
            @Override
            public final void run() {
                if(function10.trySelect()) {
                    CancellableKt.startCoroutineCancellable(this.$block$inlined, function10);
                }
            }
        };
        this.disposeOnSelect(DelayKt.getDelay(this.getContext()).invokeOnTimeout(v, runnable0, this.getContext()));
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public Object performAtomicTrySelect(AtomicDesc atomicDesc0) {
        return new AtomicSelectOp(this, atomicDesc0).perform(null);
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(Throwable throwable0) {
        while(true) {
            Object object0;
            while((object0 = this._result) == SelectKt.UNDECIDED) {
                CompletedExceptionally completedExceptionally0 = new CompletedExceptionally(throwable0, false, 2, null);
                if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, SelectKt.UNDECIDED, completedExceptionally0)) {
                    return;
                }
            }
            if(object0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                break;
            }
            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, object1, SelectKt.RESUMED)) {
                IntrinsicsKt.intercepted(this.uCont).resumeWith(Result.constructor-impl(ResultKt.createFailure(throwable0)));
                return;
            }
        }
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B05"));
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(Object object0) {
        while(true) {
            Object object1;
            while((object1 = this._result) == SelectKt.UNDECIDED) {
                Object object2 = CompletionStateKt.toState$default(object0, null, 1, null);
                if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, SelectKt.UNDECIDED, object2)) {
                    return;
                }
            }
            if(object1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                break;
            }
            Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if(WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._result$FU, this, object3, SelectKt.RESUMED)) {
                if(Result.isFailure-impl(object0)) {
                    Throwable throwable0 = Result.exceptionOrNull-impl(object0);
                    Intrinsics.checkNotNull(throwable0);
                    this.uCont.resumeWith(Result.constructor-impl(ResultKt.createFailure(throwable0)));
                    return;
                }
                this.uCont.resumeWith(object0);
                return;
            }
        }
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B05"));
    }

    private final void setParentHandle(DisposableHandle disposableHandle0) {
        this._parentHandle = disposableHandle0;
    }

    @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return UnityPlayerActivity.adjustValue("3D1501040D152E0B011A1103020B491411131A1550") + this._state + UnityPlayerActivity.adjustValue("42501F041D140B114F") + this._result + ')';
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object object0 = this.trySelectOther(null);
        if(object0 == CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if(object0 != null) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("3B1E08191E040411170A50191317320209170D0424050B0C170A060B1E19411C0414101E1A50") + object0).toString());
        }
        return false;
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public Object trySelectOther(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
        Object object0;
        while(true) {
            object0 = this._state;
            if(object0 == SelectKt.getNOT_SELECTED()) {
                if(lockFreeLinkedListNode$PrepareOp0 != null) {
                    PairSelectOp selectBuilderImpl$PairSelectOp0 = new PairSelectOp(lockFreeLinkedListNode$PrepareOp0);
                    if(!WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, this, SelectKt.getNOT_SELECTED(), selectBuilderImpl$PairSelectOp0)) {
                        continue;
                    }
                    Object object1 = selectBuilderImpl$PairSelectOp0.perform(this);
                    if(object1 != null) {
                        return object1;
                    }
                }
                else if(!WorkSpec..ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, this, SelectKt.getNOT_SELECTED(), null)) {
                    continue;
                }
                this.doAfterSelect();
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
            if(!(object0 instanceof OpDescriptor)) {
                break;
            }
            if(lockFreeLinkedListNode$PrepareOp0 != null) {
                AtomicOp atomicOp0 = lockFreeLinkedListNode$PrepareOp0.getAtomicOp();
                if(atomicOp0 instanceof AtomicSelectOp && ((AtomicSelectOp)atomicOp0).impl == this) {
                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("2D11030F01154710010B5000001A020F0C1C09501E0402040411520D1C0C141D0414451D005019090B4114041F0B50020304040411").toString());
                }
                if(atomicOp0.isEarlierThan(((OpDescriptor)object0))) {
                    return AtomicKt.RETRY_ATOMIC;
                }
            }
            ((OpDescriptor)object0).perform(this);
        }
        if(lockFreeLinkedListNode$PrepareOp0 == null) {
            return null;
        }
        return object0 == lockFreeLinkedListNode$PrepareOp0.desc ? CancellableContinuationImplKt.RESUME_TOKEN : null;
    }
}

