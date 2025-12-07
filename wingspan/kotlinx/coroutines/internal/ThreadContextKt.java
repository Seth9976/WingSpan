package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001A\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0000\u001A\u0010\u0010\u000F\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\rH\u0000\u001A\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u00042\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001A \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class ThreadContextKt {
    public static final Symbol NO_THREAD_ELEMENTS;
    private static final Function2 countAll;
    private static final Function2 findOne;
    private static final Function2 updateState;

    static {
        ThreadContextKt.NO_THREAD_ELEMENTS = new Symbol(UnityPlayerActivity.adjustValue("203F32352633222436313521242324293121"));
        ThreadContextKt.countAll = ThreadContextKt.countAll.1.INSTANCE;
        ThreadContextKt.findOne = ThreadContextKt.findOne.1.INSTANCE;
        ThreadContextKt.updateState = ThreadContextKt.updateState.1.INSTANCE;
    }

    public static final void restoreThreadContext(CoroutineContext coroutineContext0, Object object0) {
        if(object0 == ThreadContextKt.NO_THREAD_ELEMENTS) {
            return;
        }
        if(object0 instanceof ThreadState) {
            ((ThreadState)object0).restore(coroutineContext0);
            return;
        }
        Object object1 = coroutineContext0.fold(null, ThreadContextKt.findOne);
        if(object1 == null) {
            throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E39091C04060131011E1904161522091703150315520A08111E071E43200018585B"));
        }
        ((ThreadContextElement)object1).restoreThreadContext(coroutineContext0, object0);
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext0) {
        Object object0 = coroutineContext0.fold(0, ThreadContextKt.countAll);
        Intrinsics.checkNotNull(object0);
        return object0;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext0, Object object0) {
        if(object0 == null) {
            object0 = ThreadContextKt.threadContextElements(coroutineContext0);
        }
        if(object0 == 0) {
            return ThreadContextKt.NO_THREAD_ELEMENTS;
        }
        return object0 instanceof Integer ? coroutineContext0.fold(new ThreadState(coroutineContext0, ((Number)object0).intValue()), ThreadContextKt.updateState) : ((ThreadContextElement)object0).updateThreadContext(coroutineContext0);
    }
}

