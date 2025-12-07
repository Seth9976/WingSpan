package kotlinx.coroutines.sync;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&\'()B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\n\u001A\u00020\t2\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\f\u001A\u00020\t2\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000BJT\u0010\u0014\u001A\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\"\u0010\u0013\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001A\u00020\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001A\u001A\u00020\t2\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001F\u001A\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001DR\"\u0010#\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class MutexImpl implements SelectClause2, Mutex {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001D\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001A\u00020\u0007H\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class LockCont extends LockWaiter {
        private final CancellableContinuation cont;

        public LockCont(Object object0, CancellableContinuation cancellableContinuation0) {
            super(object0);
            this.cont = cancellableContinuation0;
        }

        @Override  // kotlinx.coroutines.sync.MutexImpl$LockWaiter
        public void completeResumeLockWaiter() {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("221F0E0A2D0E091129") + this.owner + UnityPlayerActivity.adjustValue("4250") + this.cont + UnityPlayerActivity.adjustValue("33500B0E1C41") + MutexImpl.this;
        }

        @Override  // kotlinx.coroutines.sync.MutexImpl$LockWaiter
        public boolean tryResumeLockWaiter() {
            if(!this.take()) {
                return false;
            }
            kotlinx.coroutines.sync.MutexImpl.LockCont.tryResumeLockWaiter.1 mutexImpl$LockCont$tryResumeLockWaiter$10 = new Function1(this) {
                {
                    MutexImpl.this = mutexImpl0;
                    LockCont.this = mutexImpl$LockCont0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((Throwable)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable throwable0) {
                    MutexImpl.this.unlock(LockCont.this.owner);
                }
            };
            return this.cont.tryResume(Unit.INSTANCE, null, mutexImpl$LockCont$tryResumeLockWaiter$10) != null;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BD\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\"\u0010\b\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016R1\u0010\b\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class LockSelect extends LockWaiter {
        public final Function2 block;
        public final SelectInstance select;

        public LockSelect(Object object0, SelectInstance selectInstance0, Function2 function20) {
            super(object0);
            this.select = selectInstance0;
            this.block = function20;
        }

        @Override  // kotlinx.coroutines.sync.MutexImpl$LockWaiter
        public void completeResumeLockWaiter() {
            Continuation continuation0 = this.select.getCompletion();
            kotlinx.coroutines.sync.MutexImpl.LockSelect.completeResumeLockWaiter.1 mutexImpl$LockSelect$completeResumeLockWaiter$10 = new Function1(this) {
                {
                    MutexImpl.this = mutexImpl0;
                    LockSelect.this = mutexImpl$LockSelect0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((Throwable)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable throwable0) {
                    MutexImpl.this.unlock(LockSelect.this.owner);
                }
            };
            CancellableKt.startCoroutineCancellable(this.block, MutexImpl.this, continuation0, mutexImpl$LockSelect$completeResumeLockWaiter$10);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("221F0E0A3D040B00111A2B") + this.owner + UnityPlayerActivity.adjustValue("4250") + this.select + UnityPlayerActivity.adjustValue("33500B0E1C41") + MutexImpl.this;
        }

        // 去混淆评级： 低(20)
        @Override  // kotlinx.coroutines.sync.MutexImpl$LockWaiter
        public boolean tryResumeLockWaiter() {
            return this.take() && this.select.trySelect();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000F2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH&¢\u0006\u0004\b\f\u0010\u000BR\u0016\u0010\u0002\u001A\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        private volatile int isTaken;
        private static final AtomicIntegerFieldUpdater isTaken$FU;
        public final Object owner;

        static {
            String s = UnityPlayerActivity.adjustValue("07033900050409");
            LockWaiter.isTaken$FU = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, s);
        }

        public LockWaiter(Object object0) {
            this.owner = object0;
            this.isTaken = 0;
        }

        public abstract void completeResumeLockWaiter();

        @Override  // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            this.remove();
        }

        public final boolean take() {
            return LockWaiter.isTaken$FU.compareAndSet(this, 0, 1);
        }

        public abstract boolean tryResumeLockWaiter();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0016R\u0012\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class LockedQueue extends LockFreeLinkedListHead {
        public volatile Object owner;

        public LockedQueue(Object object0) {
            this.owner = object0;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("221F0E0A0B053610171B1536") + this.owner + ']';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001E\u0010\u0007\u001A\u00020\b2\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\f\u001A\u0004\u0018\u00010\u00052\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\nH\u0016R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class TryLockDesc extends AtomicDesc {
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        final class PrepareOp extends OpDescriptor {
            private final AtomicOp atomicOp;

            public PrepareOp(AtomicOp atomicOp0) {
                this.atomicOp = atomicOp0;
            }

            @Override  // kotlinx.coroutines.internal.OpDescriptor
            public AtomicOp getAtomicOp() {
                return this.atomicOp;
            }

            @Override  // kotlinx.coroutines.internal.OpDescriptor
            public Object perform(Object object0) {
                Empty empty0 = this.getAtomicOp().isDecided() ? MutexKt.EMPTY_UNLOCKED : this.getAtomicOp();
                if(object0 == null) {
                    throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E1E1800024928071A15152803110B"));
                }
                WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, ((MutexImpl)object0), this, empty0);
                return null;
            }
        }

        public final MutexImpl mutex;
        public final Object owner;

        public TryLockDesc(MutexImpl mutexImpl0, Object object0) {
            this.mutex = mutexImpl0;
            this.owner = object0;
        }

        @Override  // kotlinx.coroutines.internal.AtomicDesc
        public void complete(AtomicOp atomicOp0, Object object0) {
            Empty empty0;
            if(object0 == null) {
                empty0 = this.owner == null ? MutexKt.EMPTY_LOCKED : new Empty(this.owner);
            }
            else {
                empty0 = MutexKt.EMPTY_UNLOCKED;
            }
            WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this.mutex, atomicOp0, empty0);
        }

        @Override  // kotlinx.coroutines.internal.AtomicDesc
        public Object prepare(AtomicOp atomicOp0) {
            PrepareOp mutexImpl$TryLockDesc$PrepareOp0 = new PrepareOp(this, atomicOp0);
            return !WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this.mutex, MutexKt.EMPTY_UNLOCKED, mutexImpl$TryLockDesc$PrepareOp0) ? MutexKt.LOCK_FAIL : mutexImpl$TryLockDesc$PrepareOp0.perform(this.mutex);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001A\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00022\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\b\u001A\u00020\u0002H\u0016R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class UnlockOp extends AtomicOp {
        public final LockedQueue queue;

        public UnlockOp(LockedQueue mutexImpl$LockedQueue0) {
            this.queue = mutexImpl$LockedQueue0;
        }

        @Override  // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object object0, Object object1) {
            this.complete(((MutexImpl)object0), object1);
        }

        public void complete(MutexImpl mutexImpl0, Object object0) {
            Empty empty0 = object0 == null ? MutexKt.EMPTY_UNLOCKED : this.queue;
            WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, mutexImpl0, this, empty0);
        }

        @Override  // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(Object object0) {
            return this.prepare(((MutexImpl)object0));
        }

        // 去混淆评级： 低(20)
        public Object prepare(MutexImpl mutexImpl0) {
            return this.queue.isEmpty() ? null : MutexKt.UNLOCK_FAIL;
        }
    }

    volatile Object _state;
    static final AtomicReferenceFieldUpdater _state$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("310319001A04");
        MutexImpl._state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, s);
    }

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.access$getEMPTY_LOCKED$p() : MutexKt.access$getEMPTY_UNLOCKED$p();
    }

    public static final Object access$lockSuspend(MutexImpl mutexImpl0, Object object0, Continuation continuation0) {
        return mutexImpl0.lockSuspend(object0, continuation0);
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public SelectClause2 getOnLock() {
        return this;
    }

    // 去混淆评级： 低(30)
    @Override  // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(Object object0) {
        return this._state instanceof Empty ? ((Empty)this._state).locked == object0 : this._state instanceof LockedQueue && ((LockedQueue)this._state).owner == object0;
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        Object object0;
        while(true) {
            object0 = this._state;
            if(object0 instanceof Empty) {
                return ((Empty)object0).locked != MutexKt.access$getUNLOCKED$p();
            }
            if(object0 instanceof LockedQueue) {
                return true;
            }
            if(!(object0 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object0).perform(this);
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + object0).toString());
    }

    // 去混淆评级： 低(20)
    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        return this._state instanceof LockedQueue && ((LockedQueue)this._state).isEmpty();
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public Object lock(Object object0, Continuation continuation0) {
        if(this.tryLock(object0)) {
            return Unit.INSTANCE;
        }
        Object object1 = this.lockSuspend(object0, continuation0);
        return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : Unit.INSTANCE;
    }

    private final Object lockSuspend(Object object0, Continuation continuation0) {
        Object object1;
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation0));
        LockCont mutexImpl$LockCont0 = new LockCont(this, object0, cancellableContinuationImpl0);
        while(true) {
            object1 = this._state;
            if(object1 instanceof Empty) {
                if(((Empty)object1).locked == MutexKt.access$getUNLOCKED$p()) {
                    Empty empty0 = object0 == null ? MutexKt.access$getEMPTY_LOCKED$p() : new Empty(object0);
                    if(!WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this, object1, empty0)) {
                        continue;
                    }
                    Function1 function10 = new Function1(object0) {
                        final Object $owner;

                        {
                            MutexImpl.this = mutexImpl0;
                            this.$owner = object0;
                            super(1);
                        }

                        @Override  // kotlin.jvm.functions.Function1
                        public Object invoke(Object object0) {
                            this.invoke(((Throwable)object0));
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable throwable0) {
                            MutexImpl.this.unlock(this.$owner);
                        }
                    };
                    cancellableContinuationImpl0.resume(Unit.INSTANCE, function10);
                    goto label_20;
                }
                else {
                    LockedQueue mutexImpl$LockedQueue0 = new LockedQueue(((Empty)object1).locked);
                    WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this, object1, mutexImpl$LockedQueue0);
                    continue;
                }
            }
            if(object1 instanceof LockedQueue) {
                if(((LockedQueue)object1).owner == object0) {
                    throw new IllegalStateException((UnityPlayerActivity.adjustValue("2F1C1F040F051E451E011306040A41051C52") + object0).toString());
                }
                ((LockedQueue)object1).addLast(mutexImpl$LockCont0);
                if(this._state == object1 || !mutexImpl$LockCont0.take()) {
                    CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl0, mutexImpl$LockCont0);
                }
                else {
                    mutexImpl$LockCont0 = new LockCont(this, object0, cancellableContinuationImpl0);
                    continue;
                }
            label_20:
                Object object2 = cancellableContinuationImpl0.getResult();
                if(object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation0);
                }
                return object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object2 : Unit.INSTANCE;
            }
            if(!(object1 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object1).perform(this);
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + object1).toString());
    }

    @Override  // kotlinx.coroutines.selects.SelectClause2
    public void registerSelectClause2(SelectInstance selectInstance0, Object object0, Function2 function20) {
        Object object1;
        while(true) {
            if(selectInstance0.isSelected()) {
                return;
            }
            object1 = this._state;
            if(!(object1 instanceof Empty)) {
                if(object1 instanceof LockedQueue) {
                    if(((LockedQueue)object1).owner == object0) {
                        throw new IllegalStateException((UnityPlayerActivity.adjustValue("2F1C1F040F051E451E011306040A41051C52") + object0).toString());
                    }
                    LockSelect mutexImpl$LockSelect0 = new LockSelect(this, object0, selectInstance0, function20);
                    ((LockedQueue)object1).addLast(mutexImpl$LockSelect0);
                    if(this._state != object1 && mutexImpl$LockSelect0.take()) {
                        continue;
                    }
                    selectInstance0.disposeOnSelect(mutexImpl$LockSelect0);
                    return;
                }
                if(!(object1 instanceof OpDescriptor)) {
                    break;
                }
                ((OpDescriptor)object1).perform(this);
            }
            else if(((Empty)object1).locked == MutexKt.UNLOCKED) {
                Object object2 = selectInstance0.performAtomicTrySelect(new TryLockDesc(this, object0));
                if(object2 == null) {
                    UndispatchedKt.startCoroutineUnintercepted(function20, this, selectInstance0.getCompletion());
                    return;
                }
                if(object2 == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if(object2 != MutexKt.LOCK_FAIL && object2 != AtomicKt.RETRY_ATOMIC) {
                    throw new IllegalStateException((UnityPlayerActivity.adjustValue("1E151F0701130A2406011D04023A131E361702150E154635151C3E011306250B12044C521C1519141C0F020152") + object2).toString());
                }
            }
            else {
                LockedQueue mutexImpl$LockedQueue0 = new LockedQueue(((Empty)object1).locked);
                WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this, object1, mutexImpl$LockedQueue0);
            }
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + object1).toString());
    }

    @Override
    public String toString() {
        String s;
        Object object0;
        while(true) {
            object0 = this._state;
            s = UnityPlayerActivity.adjustValue("23051904163A");
            if(object0 instanceof Empty) {
                return s + ((Empty)object0).locked + ']';
            }
            if(!(object0 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object0).perform(this);
        }
        if(!(object0 instanceof LockedQueue)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + object0).toString());
        }
        return s + ((LockedQueue)object0).owner + ']';
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object object0) {
        Object object1;
        while(true) {
            object1 = this._state;
            if(object1 instanceof Empty) {
                if(((Empty)object1).locked != MutexKt.access$getUNLOCKED$p()) {
                    return false;
                }
                Empty empty0 = object0 == null ? MutexKt.access$getEMPTY_LOCKED$p() : new Empty(object0);
                if(!WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this, object1, empty0)) {
                    continue;
                }
                return true;
            }
            if(object1 instanceof LockedQueue) {
                if(((LockedQueue)object1).owner == object0) {
                    throw new IllegalStateException((UnityPlayerActivity.adjustValue("2F1C1F040F051E451E011306040A41051C52") + object0).toString());
                }
                return false;
            }
            if(!(object1 instanceof OpDescriptor)) {
                break;
            }
            ((OpDescriptor)object1).perform(this);
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + object1).toString());
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public void unlock(Object object0) {
        LockFreeLinkedListNode lockFreeLinkedListNode0;
        String s;
        Object object1;
    alab1:
        while(true) {
            while(true) {
                do {
                label_0:
                    object1 = this._state;
                    s = UnityPlayerActivity.adjustValue("4E1218154E041F15170D0408054E");
                    if(!(object1 instanceof Empty)) {
                        goto label_10;
                    }
                    if(object0 != null) {
                        if(((Empty)object1).locked != object0) {
                            throw new IllegalStateException(("Mutex is locked by " + ((Empty)object1).locked + s + object0).toString());
                        }
                        continue;
                    }
                    else if(((Empty)object1).locked == MutexKt.UNLOCKED) {
                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2305190416410E1652001F1941020E040E170A").toString());
                    }
                }
                while(!WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this, object1, MutexKt.EMPTY_UNLOCKED));
                return;
            label_10:
                if(object1 instanceof OpDescriptor) {
                    ((OpDescriptor)object1).perform(this);
                    goto label_0;
                }
                if(!(object1 instanceof LockedQueue)) {
                    break alab1;
                }
                if(object0 != null && ((LockedQueue)object1).owner != object0) {
                    throw new IllegalStateException(("Mutex is locked by " + ((LockedQueue)object1).owner + s + object0).toString());
                }
                lockFreeLinkedListNode0 = ((LockedQueue)object1).removeFirstOrNull();
                if(lockFreeLinkedListNode0 != null) {
                    goto label_21;
                }
                UnlockOp mutexImpl$UnlockOp0 = new UnlockOp(((LockedQueue)object1));
                if(!WorkSpec..ExternalSyntheticBackport0.m(MutexImpl._state$FU, this, object1, mutexImpl$UnlockOp0) || mutexImpl$UnlockOp0.perform(this) != null) {
                    goto label_0;
                }
                break;
            }
            return;
        label_21:
            if(((LockWaiter)lockFreeLinkedListNode0).tryResumeLockWaiter()) {
                Symbol symbol0 = ((LockWaiter)lockFreeLinkedListNode0).owner;
                if(symbol0 == null) {
                    symbol0 = MutexKt.LOCKED;
                }
                ((LockedQueue)object1).owner = symbol0;
                ((LockWaiter)lockFreeLinkedListNode0).completeResumeLockWaiter();
                return;
            }
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + object1).toString());
    }
}

