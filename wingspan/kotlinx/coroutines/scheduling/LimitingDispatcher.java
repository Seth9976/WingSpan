package kotlinx.coroutines.scheduling;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020+2\u00020,2\u00020\u001FB)\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ#\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u000E2\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0013\u001A\u00020\n2\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u00112\u0006\u0010\u0016\u001A\u00020\u0015H\u0002¢\u0006\u0004\b\u0013\u0010\u0017J#\u0010\u0018\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u000E2\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u001B\u0010\u001A\u001A\u00020\n2\n\u0010\u0019\u001A\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\u0002\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001ER\u0014\u0010\"\u001A\u00020\u001F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010$R\u001E\u0010&\u001A\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\'R\u001A\u0010\u0007\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001A\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "", "name", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Ljava/lang/String;", "I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "()I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements Executor, TaskContext {
    private final ExperimentalCoroutineDispatcher dispatcher;
    private volatile int inFlightTasks;
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU;
    private final String name;
    private final int parallelism;
    private final ConcurrentLinkedQueue queue;
    private final int taskMode;

    static {
        String s = UnityPlayerActivity.adjustValue("071E2B0D07060F11260F030612");
        LimitingDispatcher.inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, s);
    }

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher0, int v, String s, int v1) {
        this.dispatcher = experimentalCoroutineDispatcher0;
        this.parallelism = v;
        this.name = s;
        this.taskMode = v1;
        this.queue = new ConcurrentLinkedQueue();
        this.inFlightTasks = 0;
    }

    @Override  // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable runnable0 = (Runnable)this.queue.poll();
        if(runnable0 != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable0, this, true);
            return;
        }
        LimitingDispatcher.inFlightTasks$FU.decrementAndGet(this);
        Runnable runnable1 = (Runnable)this.queue.poll();
        if(runnable1 == null) {
            return;
        }
        this.dispatch(runnable1, true);
    }

    @Override  // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public void close() {
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2D1C02120B4104041C001F19410C04470C1C181F06040A41080B52221900081A08090230021F0E0A070F00211B1D000C150D090217").toString());
    }

    private final void dispatch(Runnable runnable0, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = LimitingDispatcher.inFlightTasks$FU;
            if(atomicIntegerFieldUpdater0.incrementAndGet(this) <= this.parallelism) {
                this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable0, this, z);
                return;
            }
            this.queue.add(runnable0);
            if(atomicIntegerFieldUpdater0.decrementAndGet(this) >= this.parallelism) {
                return;
            }
            runnable0 = (Runnable)this.queue.poll();
        }
        while(runnable0 != null);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext0, Runnable runnable0) {
        this.dispatch(runnable0, false);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext0, Runnable runnable0) {
        this.dispatch(runnable0, true);
    }

    @Override
    public void execute(Runnable runnable0) {
        this.dispatch(runnable0, false);
    }

    @Override  // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this;
    }

    @Override  // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.taskMode;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return this.name == null ? super.toString() + UnityPlayerActivity.adjustValue("351404121E0013061A0B024D5C4E") + this.dispatcher + ']' : this.name;
    }
}

