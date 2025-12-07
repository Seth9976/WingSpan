package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u000E:\u0002\u000B\fB\u001D\u0012\u0014\u0010\u0004\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class AwaitAll {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0082\u0004\u0018\u00002\u00020\u001CB\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR \u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000BR<\u0010\u0013\u001A\u000E\u0018\u00010\fR\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000E\u001A\u000E\u0018\u00010\fR\b\u0012\u0004\u0012\u00028\u00000\r8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001A\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class AwaitAllNode extends JobNode {
        private volatile Object _disposer;
        private final CancellableContinuation continuation;
        public DisposableHandle handle;

        public AwaitAllNode(CancellableContinuation cancellableContinuation0) {
            this.continuation = cancellableContinuation0;
            this._disposer = null;
        }

        public final DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel)this._disposer;
        }

        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle0 = this.handle;
            if(disposableHandle0 != null) {
                return disposableHandle0;
            }
            Intrinsics.throwUninitializedPropertyAccessException(UnityPlayerActivity.adjustValue("061103050204"));
            return null;
        }

        @Override  // kotlin.jvm.functions.Function1
        public Object invoke(Object object0) {
            this.invoke(((Throwable)object0));
            return Unit.INSTANCE;
        }

        @Override  // kotlinx.coroutines.CompletionHandlerBase
        public void invoke(Throwable throwable0) {
            if(throwable0 != null) {
                Object object0 = this.continuation.tryResumeWithException(throwable0);
                if(object0 != null) {
                    this.continuation.completeResume(object0);
                    DisposeHandlersOnCancel awaitAll$DisposeHandlersOnCancel0 = this.getDisposer();
                    if(awaitAll$DisposeHandlersOnCancel0 != null) {
                        awaitAll$DisposeHandlersOnCancel0.disposeAll();
                    }
                }
            }
            else if(AwaitAll.notCompletedCount$FU.decrementAndGet(AwaitAll.this) == 0) {
                Continuation continuation0 = this.continuation;
                Deferred[] arr_deferred = AwaitAll.this.deferreds;
                ArrayList arrayList0 = new ArrayList(arr_deferred.length);
                for(int v = 0; v < arr_deferred.length; ++v) {
                    arrayList0.add(arr_deferred[v].getCompleted());
                }
                continuation0.resumeWith(arrayList0);
            }
        }

        public final void setDisposer(DisposeHandlersOnCancel awaitAll$DisposeHandlersOnCancel0) {
            this._disposer = awaitAll$DisposeHandlersOnCancel0;
        }

        public final void setHandle(DisposableHandle disposableHandle0) {
            this.handle = disposableHandle0;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0016\u0010\u0002\u001A\u0012\u0012\u000E\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001A\u00020\tJ\u0013\u0010\n\u001A\u00020\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001A\u00020\u000EH\u0016R \u0010\u0002\u001A\u0012\u0012\u000E\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class DisposeHandlersOnCancel extends CancelHandler {
        private final AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAllNode[] arr_awaitAll$AwaitAllNode) {
            this.nodes = arr_awaitAll$AwaitAllNode;
        }

        public final void disposeAll() {
            AwaitAllNode[] arr_awaitAll$AwaitAllNode = this.nodes;
            for(int v = 0; v < arr_awaitAll$AwaitAllNode.length; ++v) {
                arr_awaitAll$AwaitAllNode[v].getHandle().dispose();
            }
        }

        @Override  // kotlin.jvm.functions.Function1
        public Object invoke(Object object0) {
            this.invoke(((Throwable)object0));
            return Unit.INSTANCE;
        }

        @Override  // kotlinx.coroutines.CancelHandlerBase
        public void invoke(Throwable throwable0) {
            this.disposeAll();
        }

        @Override
        public String toString() {
            return UnityPlayerActivity.adjustValue("2A191E110112022D13001401041C12280B310F1E0E04023A") + this.nodes + ']';
        }
    }

    private final Deferred[] deferreds;
    volatile int notCompletedCount;
    static final AtomicIntegerFieldUpdater notCompletedCount$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("001F1922010C1709171A15092201140911");
        AwaitAll.notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, s);
    }

    public AwaitAll(Deferred[] arr_deferred) {
        this.deferreds = arr_deferred;
        this.notCompletedCount = arr_deferred.length;
    }

    public final Object await(Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        Deferred[] arr_deferred = this.deferreds;
        AwaitAllNode[] arr_awaitAll$AwaitAllNode = new AwaitAllNode[arr_deferred.length];
        for(int v1 = 0; v1 < arr_deferred.length; ++v1) {
            Deferred deferred0 = this.deferreds[v1];
            deferred0.start();
            AwaitAllNode awaitAll$AwaitAllNode0 = new AwaitAllNode(this, cancellableContinuationImpl0);
            awaitAll$AwaitAllNode0.setHandle(deferred0.invokeOnCompletion(awaitAll$AwaitAllNode0));
            arr_awaitAll$AwaitAllNode[v1] = awaitAll$AwaitAllNode0;
        }
        DisposeHandlersOnCancel awaitAll$DisposeHandlersOnCancel0 = new DisposeHandlersOnCancel(this, arr_awaitAll$AwaitAllNode);
        for(int v = 0; v < arr_deferred.length; ++v) {
            arr_awaitAll$AwaitAllNode[v].setDisposer(awaitAll$DisposeHandlersOnCancel0);
        }
        if(cancellableContinuationImpl0.isCompleted()) {
            awaitAll$DisposeHandlersOnCancel0.disposeAll();
        }
        else {
            cancellableContinuationImpl0.invokeOnCancellation(awaitAll$DisposeHandlersOnCancel0);
        }
        Object object0 = cancellableContinuationImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }
}

