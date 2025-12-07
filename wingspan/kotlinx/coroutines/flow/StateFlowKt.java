package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A\u001F\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001A\u0002H\b¢\u0006\u0002\u0010\n\u001A6\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0000\u001A2\u0010\u0014\u001A\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u0016H\u0086\b¢\u0006\u0002\u0010\u0017\u001A-\u0010\u0018\u001A\u00020\u0019\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u0016H\u0086\b\u001A2\u0010\u001A\u001A\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00072\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u0016H\u0086\b¢\u0006\u0002\u0010\u0017\"\u0016\u0010\u0000\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003¨\u0006\u001B"}, d2 = {"NONE", "Lkotlinx/coroutines/internal/Symbol;", "getNONE$annotations", "()V", "PENDING", "getPENDING$annotations", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "getAndUpdate", "function", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "update", "", "updateAndGet", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class StateFlowKt {
    private static final Symbol NONE;
    private static final Symbol PENDING;

    static {
        StateFlowKt.NONE = new Symbol(UnityPlayerActivity.adjustValue("203F2324"));
        StateFlowKt.PENDING = new Symbol(UnityPlayerActivity.adjustValue("3E352325272F20"));
    }

    public static final MutableStateFlow MutableStateFlow(Object object0) {
        if(object0 == null) {
            object0 = NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(object0);
    }

    // 去混淆评级： 低(20)
    public static final Flow fuseStateFlow(StateFlow stateFlow0, CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        return (v >= 0 && v < 2 || v == -2) && bufferOverflow0 == BufferOverflow.DROP_OLDEST ? stateFlow0 : SharedFlowKt.fuseSharedFlow(stateFlow0, coroutineContext0, v, bufferOverflow0);
    }

    public static final Object getAndUpdate(MutableStateFlow mutableStateFlow0, Function1 function10) {
        Object object0;
        do {
            object0 = mutableStateFlow0.getValue();
        }
        while(!mutableStateFlow0.compareAndSet(object0, function10.invoke(object0)));
        return object0;
    }

    private static void getNONE$annotations() {
    }

    private static void getPENDING$annotations() {
    }

    public static final void update(MutableStateFlow mutableStateFlow0, Function1 function10) {
        do {
            Object object0 = mutableStateFlow0.getValue();
        }
        while(!mutableStateFlow0.compareAndSet(object0, function10.invoke(object0)));
    }

    public static final Object updateAndGet(MutableStateFlow mutableStateFlow0, Function1 function10) {
        Object object1;
        do {
            Object object0 = mutableStateFlow0.getValue();
            object1 = function10.invoke(object0);
        }
        while(!mutableStateFlow0.compareAndSet(object0, object1));
        return object1;
    }
}

