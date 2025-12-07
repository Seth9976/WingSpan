package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007\u001A\u0010\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class ThreadPoolDispatcherKt {
    // 检测为 Lambda 实现
    public static Thread $r8$lambda$IYX-93i18CF3E6e1K_suGGxRFcI(int v, String s, AtomicInteger atomicInteger0, Runnable runnable0) [...]

    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int v, String s) {
        if(v < 1) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2B081D040D150201520F044D0D0B00141152011E08411A091500130A5C4D031B1547") + v + UnityPlayerActivity.adjustValue("4E031D040D08010C170A")).toString());
        }
        return ExecutorsKt.from(Executors.newScheduledThreadPool(v, (Runnable runnable0) -> ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda-1(v, s, new AtomicInteger(), runnable0)));
    }

    private static final Thread newFixedThreadPoolContext$lambda-1(int v, String s, AtomicInteger atomicInteger0, Runnable runnable0) {
        if(v != 1) {
            s = s + '-' + atomicInteger0.incrementAndGet();
        }
        Thread thread0 = new Thread(runnable0, s);
        thread0.setDaemon(true);
        return thread0;
    }

    public static final ExecutorCoroutineDispatcher newSingleThreadContext(String s) {
        return ThreadPoolDispatcherKt.newFixedThreadPoolContext(1, s);
    }
}

