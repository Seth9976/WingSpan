package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\b\u0010\u0006\u001A\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "defaultMainDelayOptIn", "", "initializeDefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class DefaultExecutorKt {
    private static final Delay DefaultDelay;
    private static final boolean defaultMainDelayOptIn;

    static {
        DefaultExecutorKt.defaultMainDelayOptIn = SystemPropsKt.systemProp(UnityPlayerActivity.adjustValue("051F190D070F1F4B11010202141A08090001401D0C08004F03001E0F09"), false);
        DefaultExecutorKt.DefaultDelay = DefaultExecutorKt.initializeDefaultDelay();
    }

    public static final Delay getDefaultDelay() {
        return DefaultExecutorKt.DefaultDelay;
    }

    private static final Delay initializeDefaultDelay() {
        if(!DefaultExecutorKt.defaultMainDelayOptIn) {
            return DefaultExecutor.INSTANCE;
        }
        MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain();
        if(MainDispatchersKt.isMissing(mainCoroutineDispatcher0) || !(mainCoroutineDispatcher0 instanceof Delay)) {
            mainCoroutineDispatcher0 = DefaultExecutor.INSTANCE;
        }
        return (Delay)mainCoroutineDispatcher0;
    }
}

