package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001A\u00020\u0001\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\u0002\u0010\bJ\u0014\u0010\u000F\u001A\u00020\u00102\n\u0010\u0011\u001A\u00060\u0002j\u0002`\u0003H\u0002J\u0019\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0097A\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0016J\u001C\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u00192\n\u0010\u0011\u001A\u00060\u0002j\u0002`\u0003H\u0016J#\u0010\u001A\u001A\u00020\u00132\n\u0010\u0011\u001A\u00060\u0002j\u0002`\u00032\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00130\u001BH\u0082\bJ\u001C\u0010\u001C\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u00192\n\u0010\u0011\u001A\u00060\u0002j\u0002`\u0003H\u0017J%\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u00152\n\u0010\u0011\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010\u0018\u001A\u00020\u0019H\u0096\u0001J\u0010\u0010 \u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0017J\b\u0010!\u001A\u00020\u0013H\u0016J\u001F\u0010\"\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\u00152\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00130$H\u0096\u0001J\b\u0010%\u001A\u00020\u0010H\u0002R\u000E\u0010\u0005\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0018\u0010\t\u001A\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u00060\rj\u0002`\u000EX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "runningWorkers", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "addAndTryDispatching", "", "block", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatchInternal", "Lkotlin/Function0;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "run", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {
    private final Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue queue;
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher0, int v) {
        this.dispatcher = coroutineDispatcher0;
        this.parallelism = v;
        Delay delay0 = coroutineDispatcher0 instanceof Delay ? ((Delay)coroutineDispatcher0) : null;
        if(delay0 == null) {
            delay0 = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = delay0;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
    }

    private final boolean addAndTryDispatching(Runnable runnable0) {
        this.queue.addLast(runnable0);
        return this.runningWorkers >= this.parallelism;
    }

    @Override  // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long v, Continuation continuation0) {
        return this.$$delegate_0.delay(v, continuation0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext0, Runnable runnable0) {
        if(!this.addAndTryDispatching(runnable0) && this.tryAllocateWorker()) {
            this.dispatcher.dispatch(this, this);
        }
    }

    private final void dispatchInternal(Runnable runnable0, Function0 function00) {
        if(this.addAndTryDispatching(runnable0)) {
            return;
        }
        if(!this.tryAllocateWorker()) {
            return;
        }
        function00.invoke();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext0, Runnable runnable0) {
        if(!this.addAndTryDispatching(runnable0) && this.tryAllocateWorker()) {
            this.dispatcher.dispatchYield(this, this);
        }
    }

    @Override  // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long v, Runnable runnable0, CoroutineContext coroutineContext0) {
        return this.$$delegate_0.invokeOnTimeout(v, runnable0, coroutineContext0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int v) {
        LimitedDispatcherKt.checkParallelism(v);
        return v >= this.parallelism ? this : super.limitedParallelism(v);
    }

    @Override
    public void run() {
        while(true) {
            int v = 0;
            Runnable runnable0;
            while((runnable0 = (Runnable)this.queue.removeFirstOrNull()) != null) {
                try {
                    runnable0.run();
                }
                catch(Throwable throwable0) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, throwable0);
                }
                ++v;
                if(v >= 16 && this.dispatcher.isDispatchNeeded(this)) {
                    this.dispatcher.dispatch(this, this);
                    return;
                }
            }
            Object object0 = this.workerAllocationLock;
            synchronized(object0) {
                --this.runningWorkers;
                if(this.queue.getSize() == 0) {
                    return;
                }
                ++this.runningWorkers;
            }
        }
    }

    @Override  // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, CancellableContinuation cancellableContinuation0) {
        this.$$delegate_0.scheduleResumeAfterDelay(v, cancellableContinuation0);
    }

    private final boolean tryAllocateWorker() {
        synchronized(this.workerAllocationLock) {
            if(this.runningWorkers >= this.parallelism) {
                return false;
            }
            ++this.runningWorkers;
        }
        return true;
    }
}

