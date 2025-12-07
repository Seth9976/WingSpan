package kotlinx.coroutines.internal;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DebugStringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0017\u0018\u00002\u00020C:\u0005JKLMNB\u0007\u00A2\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001A\u00020\u00052\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000B\u001A\u00020\t2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u00032\u000E\b\u0004\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00A2\u0006\u0004\b\u000B\u0010\fJ4\u0010\u000F\u001A\u00020\t2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u00032\u0016\u0010\u000E\u001A\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\u0086\b\u00A2\u0006\u0004\b\u000F\u0010\u0010JD\u0010\u0011\u001A\u00020\t2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u00032\u0016\u0010\u000E\u001A\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000E\b\u0004\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00A2\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0014\u001A\u00020\t2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001A\u00060\u0000j\u0002`\u0003H\u0001\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001A\u00020\t2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001A\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0082\u0010\u00A2\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D\"\f\b\u0000\u0010\u001C*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001A\u00028\u0000\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030 \u00A2\u0006\u0004\b!\u0010\"J \u0010$\u001A\u00060\u0000j\u0002`\u00032\n\u0010#\u001A\u00060\u0000j\u0002`\u0003H\u0082\u0010\u00A2\u0006\u0004\b$\u0010%J\u001B\u0010&\u001A\u00020\u00052\n\u0010\u0013\u001A\u00060\u0000j\u0002`\u0003H\u0002\u00A2\u0006\u0004\b&\u0010\u0007J\r\u0010\'\u001A\u00020\u0005\u00A2\u0006\u0004\b\'\u0010\u0002J\u000F\u0010(\u001A\u00020\u0005H\u0001\u00A2\u0006\u0004\b(\u0010\u0002J,\u0010*\u001A\u00020)2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u00032\u000E\b\u0004\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0081\b\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0014\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b.\u0010/J.\u00100\u001A\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001C\u0018\u00012\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\u0086\b\u00A2\u0006\u0004\b0\u00101J\u0015\u00102\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003\u00A2\u0006\u0004\b2\u0010-J\u0017\u00103\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0001\u00A2\u0006\u0004\b3\u0010-J\u000F\u00105\u001A\u000204H\u0002\u00A2\u0006\u0004\b5\u00106J\u000F\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b8\u00109J/\u0010<\u001A\u00020;2\n\u0010\u0004\u001A\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001A\u00060\u0000j\u0002`\u00032\u0006\u0010:\u001A\u00020)H\u0001\u00A2\u0006\u0004\b<\u0010=J\'\u0010A\u001A\u00020\u00052\n\u0010>\u001A\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001A\u00060\u0000j\u0002`\u0003H\u0000\u00A2\u0006\u0004\b?\u0010@R\u0014\u0010B\u001A\u00020\t8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bB\u0010/R\u0011\u0010\u0013\u001A\u00020C8F\u00A2\u0006\u0006\u001A\u0004\bD\u0010ER\u0015\u0010G\u001A\u00060\u0000j\u0002`\u00038F\u00A2\u0006\u0006\u001A\u0004\bF\u0010-R\u0015\u0010I\u001A\u00060\u0000j\u0002`\u00038F\u00A2\u0006\u0006\u001A\u0004\bH\u0010-\u00A8\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class LockFreeLinkedListNode {
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001C\u0010\n\u001A\u00020\u000B2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FJ\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\u0010\u0010\u001A\u00060\u0004j\u0002`\u0005H\u0014J \u0010\u0011\u001A\u00020\u000B2\n\u0010\u0010\u001A\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001A\u00060\u0004j\u0002`\u0005H$J\u0010\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u0015H&J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0014\u0010\u0017\u001A\u00020\u000B2\n\u0010\u0010\u001A\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0018\u001A\u0004\u0018\u00010\u000F2\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\rJ\u001C\u0010\u0019\u001A\u00020\u001A2\n\u0010\u0010\u001A\u00060\u0004j\u0002`\u00052\u0006\u0010\u0012\u001A\u00020\u000FH\u0014J\u0018\u0010\u001B\u001A\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\f\u001A\u00020\u001CH\u0014J \u0010\u001D\u001A\u00020\u000F2\n\u0010\u0010\u001A\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001A\u00060\u0004j\u0002`\u0005H&R\u001A\u0010\u0003\u001A\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007¨\u0006\u001E"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "", "affected", "finishOnSuccess", "next", "finishPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "onPrepare", "onRemoved", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        @Override  // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(AtomicOp atomicOp0, Object object0) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = this.getAffectedNode();
            if(lockFreeLinkedListNode0 == null) {
                return;
            }
            LockFreeLinkedListNode lockFreeLinkedListNode1 = this.getOriginalNext();
            if(lockFreeLinkedListNode1 == null) {
                return;
            }
            LockFreeLinkedListNode lockFreeLinkedListNode2 = object0 == null ? this.updatedNext(lockFreeLinkedListNode0, lockFreeLinkedListNode1) : lockFreeLinkedListNode1;
            if(WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode0, atomicOp0, lockFreeLinkedListNode2) && object0 == null) {
                this.finishOnSuccess(lockFreeLinkedListNode0, lockFreeLinkedListNode1);
            }
        }

        protected Object failure(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            return null;
        }

        protected abstract void finishOnSuccess(LockFreeLinkedListNode arg1, LockFreeLinkedListNode arg2);

        public abstract void finishPrepare(PrepareOp arg1);

        protected abstract LockFreeLinkedListNode getAffectedNode();

        protected abstract LockFreeLinkedListNode getOriginalNext();

        public Object onPrepare(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            this.finishPrepare(lockFreeLinkedListNode$PrepareOp0);
            return null;
        }

        public void onRemoved(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        }

        @Override  // kotlinx.coroutines.internal.AtomicDesc
        public final Object prepare(AtomicOp atomicOp0) {
            PrepareOp lockFreeLinkedListNode$PrepareOp0;
            Object object0;
            LockFreeLinkedListNode lockFreeLinkedListNode0;
            while(true) {
                while(true) {
                    while(true) {
                    label_0:
                        lockFreeLinkedListNode0 = this.takeAffectedNode(atomicOp0);
                        if(lockFreeLinkedListNode0 == null) {
                            return AtomicKt.RETRY_ATOMIC;
                        }
                        object0 = lockFreeLinkedListNode0._next;
                        if(object0 == atomicOp0) {
                            return null;
                        }
                        if(atomicOp0.isDecided()) {
                            return null;
                        }
                        if(object0 instanceof OpDescriptor) {
                            if(atomicOp0.isEarlierThan(((OpDescriptor)object0))) {
                                return AtomicKt.RETRY_ATOMIC;
                            }
                            ((OpDescriptor)object0).perform(lockFreeLinkedListNode0);
                        }
                        else {
                            Object object1 = this.failure(lockFreeLinkedListNode0);
                            if(object1 != null) {
                                return object1;
                            }
                            if(!this.retry(lockFreeLinkedListNode0, object0)) {
                                break;
                            }
                        }
                    }
                    lockFreeLinkedListNode$PrepareOp0 = new PrepareOp(lockFreeLinkedListNode0, ((LockFreeLinkedListNode)object0), this);
                    if(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode0, object0, lockFreeLinkedListNode$PrepareOp0)) {
                        goto label_0;
                    }
                    break;
                }
                try {
                    if(lockFreeLinkedListNode$PrepareOp0.perform(lockFreeLinkedListNode0) == LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                        goto label_0;
                    }
                    return null;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode0, lockFreeLinkedListNode$PrepareOp0, object0);
            throw throwable0;
        }

        protected boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode0, Object object0) {
            return false;
        }

        protected LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor0) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = this.getAffectedNode();
            Intrinsics.checkNotNull(lockFreeLinkedListNode0);
            return lockFreeLinkedListNode0;
        }

        public abstract Object updatedNext(LockFreeLinkedListNode arg1, LockFreeLinkedListNode arg2);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020!B\u001B\u0012\n\u0010\u0004\u001A\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0005\u001A\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\u000B\u001A\u00020\n2\n\u0010\b\u001A\u00060\u0001j\u0002`\u00022\n\u0010\t\u001A\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u000B\u0010\u0007J\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ#\u0010\u0012\u001A\u00020\u00112\n\u0010\b\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010\t\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0016\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0015\u001A\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u0018\u001A\u00020\u00102\n\u0010\b\u001A\u00060\u0001j\u0002`\u00022\n\u0010\t\u001A\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001C\u0010\u001C\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u0005\u001A\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001DR\u0018\u0010\u001F\u001A\u00060\u0001j\u0002`\u00028DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001BR\u0018\u0010\u0004\u001A\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001D¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", "queue", "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "next", "", "finishOnSuccess", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class AddLastDesc extends AbstractAtomicDesc {
        private volatile Object _affectedNode;
        private static final AtomicReferenceFieldUpdater _affectedNode$FU;
        public final LockFreeLinkedListNode node;
        public final LockFreeLinkedListNode queue;

        static {
            String s = UnityPlayerActivity.adjustValue("31110B070B02130016201F0904");
            AddLastDesc._affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, s);
        }

        public AddLastDesc(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
            this.queue = lockFreeLinkedListNode0;
            this.node = lockFreeLinkedListNode1;
            this._affectedNode = null;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
            this.node.finishAdd(this.queue);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public void finishPrepare(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            WorkSpec..ExternalSyntheticBackport0.m(AddLastDesc._affectedNode$FU, this, null, lockFreeLinkedListNode$PrepareOp0.affected);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode)this._affectedNode;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode0, Object object0) {
            return object0 != this.queue;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor0) {
            return this.queue.correctPrev(opDescriptor0);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
            WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._prev$FU, this.node, this.node, lockFreeLinkedListNode0);
            WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, this.node, this.node, this.queue);
            return this.node;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001E\u0010\u0007\u001A\u00020\b2\n\u0010\t\u001A\u00060\u0002j\u0002`\u00032\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0016R\u0014\u0010\u0004\u001A\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static abstract class CondAddOp extends AtomicOp {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            this.newNode = lockFreeLinkedListNode0;
        }

        @Override  // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object object0, Object object1) {
            this.complete(((LockFreeLinkedListNode)object0), object1);
        }

        public void complete(LockFreeLinkedListNode lockFreeLinkedListNode0, Object object0) {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = object0 == null ? this.oldNext : this.newNode;
            if(lockFreeLinkedListNode1 != null && WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode0, this, lockFreeLinkedListNode1) && object0 == null) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.oldNext;
                Intrinsics.checkNotNull(lockFreeLinkedListNode2);
                this.newNode.finishAdd(lockFreeLinkedListNode2);
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001A\u00020\u000EJ\u0014\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0002\u001A\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0014\u0010\u0002\u001A\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "next", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "finishPrepare", "", "perform", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class PrepareOp extends OpDescriptor {
        public final LockFreeLinkedListNode affected;
        public final AbstractAtomicDesc desc;
        public final LockFreeLinkedListNode next;

        public PrepareOp(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1, AbstractAtomicDesc lockFreeLinkedListNode$AbstractAtomicDesc0) {
            this.affected = lockFreeLinkedListNode0;
            this.next = lockFreeLinkedListNode1;
            this.desc = lockFreeLinkedListNode$AbstractAtomicDesc0;
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override  // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override  // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object object0) {
            Object object3;
            if(object0 == null) {
                throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E040F1A04150B13025E210E0D0A2117170B3C040F050403291B1D04230E0A041C451901040108001949061D1C1F1815070F02165C071E19041C0F06095C221F0E0A281302003E071E06040A2D0E16062504432F010502450F"));
            }
            Object object1 = this.desc.onPrepare(this);
            if(object1 == LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                LockFreeLinkedListNode lockFreeLinkedListNode0 = this.next;
                Removed removed0 = lockFreeLinkedListNode0.removed();
                if(WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, ((LockFreeLinkedListNode)object0), this, removed0)) {
                    this.desc.onRemoved(((LockFreeLinkedListNode)object0));
                    lockFreeLinkedListNode0.correctPrev(null);
                }
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object object2 = object1 == null ? this.getAtomicOp().getConsensus() : this.getAtomicOp().decide(object1);
            if(object2 == AtomicKt.NO_DECISION) {
                object3 = this.getAtomicOp();
            }
            else if(object2 == null) {
                object3 = this.desc.updatedNext(((LockFreeLinkedListNode)object0), this.next);
            }
            else {
                object3 = this.next;
            }
            WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, ((LockFreeLinkedListNode)object0), this, object3);
            return null;
        }

        @Override  // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return UnityPlayerActivity.adjustValue("3E0208110F13022A02461F1D5C") + this.getAtomicOp() + ')';
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020(B\u0013\u0012\n\u0010\u0004\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\t\u001A\u0004\u0018\u00010\b2\n\u0010\u0007\u001A\u00060\u0002j\u0002`\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\'\u0010\r\u001A\u00020\f2\n\u0010\u0007\u001A\u00060\u0002j\u0002`\u00032\n\u0010\u000B\u001A\u00060\u0002j\u0002`\u0003H\u0004¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001A\u00020\u00132\n\u0010\u0007\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010\u000B\u001A\u00020\bH\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0017\u001A\u00020\u0016H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001A\u001A\u00020\b2\n\u0010\u0007\u001A\u00060\u0002j\u0002`\u00032\n\u0010\u000B\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001E\u001A\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u001C\u0010 \u001A\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001DR\u0018\u0010\u0004\u001A\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0017\u0010&\u001A\u00028\u00008F¢\u0006\f\u0012\u0004\b$\u0010%\u001A\u0004\b\"\u0010#¨\u0006\'"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static class RemoveFirstDesc extends AbstractAtomicDesc {
        private volatile Object _affectedNode;
        private static final AtomicReferenceFieldUpdater _affectedNode$FU;
        private volatile Object _originalNext;
        private static final AtomicReferenceFieldUpdater _originalNext$FU;
        public final LockFreeLinkedListNode queue;

        static {
            String s = UnityPlayerActivity.adjustValue("31110B070B02130016201F0904");
            RemoveFirstDesc._affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, s);
            String s1 = UnityPlayerActivity.adjustValue("311F1F08090809041E20151515");
            RemoveFirstDesc._originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, s1);
        }

        public RemoveFirstDesc(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            this.queue = lockFreeLinkedListNode0;
            this._affectedNode = null;
            this._originalNext = null;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            return lockFreeLinkedListNode0 == this.queue ? LockFreeLinkedListKt.getLIST_EMPTY() : null;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final void finishOnSuccess(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
            lockFreeLinkedListNode1.correctPrev(null);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public void finishPrepare(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            WorkSpec..ExternalSyntheticBackport0.m(RemoveFirstDesc._affectedNode$FU, this, null, lockFreeLinkedListNode$PrepareOp0.affected);
            WorkSpec..ExternalSyntheticBackport0.m(RemoveFirstDesc._originalNext$FU, this, null, lockFreeLinkedListNode$PrepareOp0.next);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode)this._affectedNode;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode)this._originalNext;
        }

        public final Object getResult() {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = this.getAffectedNode();
            Intrinsics.checkNotNull(lockFreeLinkedListNode0);
            return lockFreeLinkedListNode0;
        }

        public static void getResult$annotations() {
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final boolean retry(LockFreeLinkedListNode lockFreeLinkedListNode0, Object object0) {
            if(!(object0 instanceof Removed)) {
                return false;
            }
            ((Removed)object0).ref.helpRemovePrev();
            return true;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor opDescriptor0) {
            Object object0;
            LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue;
            while(true) {
                object0 = lockFreeLinkedListNode0._next;
                if(!(object0 instanceof OpDescriptor)) {
                    break;
                }
                if(opDescriptor0.isEarlierThan(((OpDescriptor)object0))) {
                    return null;
                }
                ((OpDescriptor)object0).perform(this.queue);
            }
            return (LockFreeLinkedListNode)object0;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public final Object updatedNext(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
            return lockFreeLinkedListNode1.removed();
        }
    }

    volatile Object _next;
    static final AtomicReferenceFieldUpdater _next$FU;
    volatile Object _prev;
    static final AtomicReferenceFieldUpdater _prev$FU;
    private volatile Object _removedRef;
    private static final AtomicReferenceFieldUpdater _removedRef$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("311E08191A");
        LockFreeLinkedListNode._next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, s);
        String s1 = UnityPlayerActivity.adjustValue("31001F0418");
        LockFreeLinkedListNode._prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, s1);
        String s2 = UnityPlayerActivity.adjustValue("3102080C01170201200B16");
        LockFreeLinkedListNode._removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, s2);
    }

    public LockFreeLinkedListNode() {
        this._next = this;
        this._prev = this;
        this._removedRef = null;
    }

    public final void addLast(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        while(!this.getPrevNode().addNext(lockFreeLinkedListNode0, this)) {
        }
    }

    public final boolean addLastIf(LockFreeLinkedListNode lockFreeLinkedListNode0, Function0 function00) {
        CondAddOp lockFreeLinkedListNode$CondAddOp0 = new kotlinx.coroutines.internal.LockFreeLinkedListNode.makeCondAddOp.1(lockFreeLinkedListNode0, function00);
    alab1:
        while(true) {
            switch(this.getPrevNode().tryCondAddNext(lockFreeLinkedListNode0, this, lockFreeLinkedListNode$CondAddOp0)) {
                case 1: {
                    return true;
                }
                case 2: {
                    break alab1;
                }
            }
        }
        return false;
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode lockFreeLinkedListNode0, Function1 function10) {
        do {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = this.getPrevNode();
            if(!((Boolean)function10.invoke(lockFreeLinkedListNode1)).booleanValue()) {
                return false;
            }
        }
        while(!lockFreeLinkedListNode1.addNext(lockFreeLinkedListNode0, this));
        return true;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode lockFreeLinkedListNode0, Function1 function10, Function0 function00) {
        CondAddOp lockFreeLinkedListNode$CondAddOp0 = new kotlinx.coroutines.internal.LockFreeLinkedListNode.makeCondAddOp.1(lockFreeLinkedListNode0, function00);
    alab1:
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = this.getPrevNode();
            if(!((Boolean)function10.invoke(lockFreeLinkedListNode1)).booleanValue()) {
                return false;
            }
            switch(lockFreeLinkedListNode1.tryCondAddNext(lockFreeLinkedListNode0, this, lockFreeLinkedListNode$CondAddOp0)) {
                case 1: {
                    return true;
                }
                case 2: {
                    break alab1;
                }
            }
        }
        return false;
    }

    public final boolean addNext(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
        LockFreeLinkedListNode._prev$FU.lazySet(lockFreeLinkedListNode0, this);
        LockFreeLinkedListNode._next$FU.lazySet(lockFreeLinkedListNode0, lockFreeLinkedListNode1);
        if(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, this, lockFreeLinkedListNode1, lockFreeLinkedListNode0)) {
            return false;
        }
        lockFreeLinkedListNode0.finishAdd(lockFreeLinkedListNode1);
        return true;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        LockFreeLinkedListNode._prev$FU.lazySet(lockFreeLinkedListNode0, this);
        LockFreeLinkedListNode._next$FU.lazySet(lockFreeLinkedListNode0, this);
        do {
            if(this.getNext() != this) {
                return false;
            }
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, this, this, lockFreeLinkedListNode0));
        lockFreeLinkedListNode0.finishAdd(this);
        return true;
    }

    private final LockFreeLinkedListNode correctPrev(OpDescriptor opDescriptor0) {
        Object object0;
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        LockFreeLinkedListNode lockFreeLinkedListNode1;
        while(true) {
            while(true) {
            label_0:
                LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)this._prev;
                lockFreeLinkedListNode1 = lockFreeLinkedListNode0;
            label_2:
                lockFreeLinkedListNode2 = null;
            label_3:
                object0 = lockFreeLinkedListNode1._next;
                if(object0 != this) {
                    break;
                }
                if(lockFreeLinkedListNode0 == lockFreeLinkedListNode1) {
                    return lockFreeLinkedListNode1;
                }
                if(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._prev$FU, this, lockFreeLinkedListNode0, lockFreeLinkedListNode1)) {
                    continue;
                }
                return lockFreeLinkedListNode1;
            }
            if(this.isRemoved()) {
                return null;
            }
            if(object0 == opDescriptor0) {
                return lockFreeLinkedListNode1;
            }
            if(object0 instanceof OpDescriptor) {
                if(opDescriptor0 != null && opDescriptor0.isEarlierThan(((OpDescriptor)object0))) {
                    return null;
                }
                ((OpDescriptor)object0).perform(lockFreeLinkedListNode1);
                goto label_0;
            }
            if(!(object0 instanceof Removed)) {
                lockFreeLinkedListNode2 = lockFreeLinkedListNode1;
                lockFreeLinkedListNode1 = (LockFreeLinkedListNode)object0;
                goto label_3;
            }
            if(lockFreeLinkedListNode2 == null) {
                break;
            }
            if(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode2, lockFreeLinkedListNode1, ((Removed)object0).ref)) {
                goto label_0;
            }
            lockFreeLinkedListNode1 = lockFreeLinkedListNode2;
            goto label_2;
        }
        lockFreeLinkedListNode1 = (LockFreeLinkedListNode)lockFreeLinkedListNode1._prev;
        goto label_3;
    }

    public final AddLastDesc describeAddLast(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        return new AddLastDesc(this, lockFreeLinkedListNode0);
    }

    public final RemoveFirstDesc describeRemoveFirst() {
        return new RemoveFirstDesc(this);
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        while(lockFreeLinkedListNode0.isRemoved()) {
            lockFreeLinkedListNode0 = (LockFreeLinkedListNode)lockFreeLinkedListNode0._prev;
        }
        return lockFreeLinkedListNode0;
    }

    private final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        do {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = (LockFreeLinkedListNode)lockFreeLinkedListNode0._prev;
            if(this.getNext() != lockFreeLinkedListNode0) {
                return;
            }
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._prev$FU, lockFreeLinkedListNode0, lockFreeLinkedListNode1, this));
        if(this.isRemoved()) {
            lockFreeLinkedListNode0.correctPrev(null);
        }
    }

    public final Object getNext() {
        Object object0;
        while(true) {
            object0 = this._next;
            if(!(object0 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object0).perform(this);
        }
        return object0;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(this.getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.correctPrev(null);
        return lockFreeLinkedListNode0 == null ? this.findPrevNonRemoved(((LockFreeLinkedListNode)this._prev)) : lockFreeLinkedListNode0;
    }

    public final void helpRemove() {
        ((Removed)this.getNext()).ref.helpRemovePrev();
    }

    public final void helpRemovePrev() {
        while(true) {
            Object object0 = this.getNext();
            if(!(object0 instanceof Removed)) {
                break;
            }
            this = ((Removed)object0).ref;
        }
        this.correctPrev(null);
    }

    public boolean isRemoved() {
        return this.getNext() instanceof Removed;
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode lockFreeLinkedListNode0, Function0 function00) {
        return new CondAddOp(function00) {
            @Override  // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(Object object0) {
                return this.prepare(((LockFreeLinkedListNode)object0));
            }

            // 去混淆评级： 低(20)
            public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode0) {
                return ((Boolean)this.$condition.invoke()).booleanValue() ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
    }

    protected LockFreeLinkedListNode nextIfRemoved() {
        Object object0 = this.getNext();
        Removed removed0 = object0 instanceof Removed ? ((Removed)object0) : null;
        return removed0 == null ? null : removed0.ref;
    }

    public boolean remove() {
        return this.removeOrNext() == null;
    }

    public final Object removeFirstIfIsInstanceOfOrPeekIf(Function1 function10) {
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)this.getNext();
            if(lockFreeLinkedListNode0 == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, UnityPlayerActivity.adjustValue("3A"));
            if(!(lockFreeLinkedListNode0 instanceof Object)) {
                return null;
            }
            if(((Boolean)function10.invoke(lockFreeLinkedListNode0)).booleanValue() && !lockFreeLinkedListNode0.isRemoved()) {
                return lockFreeLinkedListNode0;
            }
            LockFreeLinkedListNode lockFreeLinkedListNode1 = lockFreeLinkedListNode0.removeOrNext();
            if(lockFreeLinkedListNode1 == null) {
                return lockFreeLinkedListNode0;
            }
            lockFreeLinkedListNode1.helpRemovePrev();
        }
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)this.getNext();
            if(lockFreeLinkedListNode0 == this) {
                return null;
            }
            if(lockFreeLinkedListNode0.remove()) {
                return lockFreeLinkedListNode0;
            }
            lockFreeLinkedListNode0.helpRemove();
        }
    }

    public final LockFreeLinkedListNode removeOrNext() {
        Object object0;
        do {
            object0 = this.getNext();
            if(object0 instanceof Removed) {
                return ((Removed)object0).ref;
            }
            if(object0 == this) {
                return (LockFreeLinkedListNode)object0;
            }
            Removed removed0 = ((LockFreeLinkedListNode)object0).removed();
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, this, object0, removed0));
        ((LockFreeLinkedListNode)object0).correctPrev(null);
        return null;
    }

    private final Removed removed() {
        Removed removed0 = (Removed)this._removedRef;
        if(removed0 == null) {
            removed0 = new Removed(this);
            LockFreeLinkedListNode._removedRef$FU.lazySet(this, removed0);
        }
        return removed0;
    }

    @Override
    public String toString() {
        return new PropertyReference0Impl() {
            {
                String s = UnityPlayerActivity.adjustValue("0D1C0C121D320E0802021523000304");
                super(object0, DebugStringsKt.class, s, "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
            }

            @Override  // kotlin.jvm.internal.PropertyReference0Impl
            public Object get() {
                return DebugStringsKt.getClassSimpleName(this.receiver);
            }
        } + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final int tryCondAddNext(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1, CondAddOp lockFreeLinkedListNode$CondAddOp0) {
        LockFreeLinkedListNode._prev$FU.lazySet(lockFreeLinkedListNode0, this);
        LockFreeLinkedListNode._next$FU.lazySet(lockFreeLinkedListNode0, lockFreeLinkedListNode1);
        lockFreeLinkedListNode$CondAddOp0.oldNext = lockFreeLinkedListNode1;
        if(!WorkSpec..ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, this, lockFreeLinkedListNode1, lockFreeLinkedListNode$CondAddOp0)) {
            return 0;
        }
        return lockFreeLinkedListNode$CondAddOp0.perform(this) == null ? 1 : 2;
    }

    // 去混淆评级： 中等(60)
    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode lockFreeLinkedListNode0, LockFreeLinkedListNode lockFreeLinkedListNode1) {
    }
}

