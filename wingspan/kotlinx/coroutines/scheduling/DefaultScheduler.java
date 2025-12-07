package kotlinx.coroutines.scheduling;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0016J\r\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u0006J\b\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "()V", "close", "", "shutdown", "shutdown$kotlinx_coroutines_core", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;

    static {
        DefaultScheduler.INSTANCE = new DefaultScheduler();
    }

    private DefaultScheduler() {
        String s = UnityPlayerActivity.adjustValue("2A150B001B0D13211B1D000C150D090217");
        super(TasksKt.CORE_POOL_SIZE, TasksKt.MAX_POOL_SIZE, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, s);
    }

    @Override  // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher
    public void close() {
        throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("2A191E110F15040D171C0343250B0706101E1A500E00000F0811520C154D02020E140016"));
    }

    public final void shutdown$kotlinx_coroutines_core() {
        super.close();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return UnityPlayerActivity.adjustValue("2A191E110F15040D171C0343250B0706101E1A");
    }
}

