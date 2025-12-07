package kotlinx.coroutines.selects;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AE\u0010\u0010\u001A\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u001F\b\u0004\u0010\u0012\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0017\u001AN\u0010\u0018\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00142\u0006\u0010\u0019\u001A\u00020\u001A2\u001C\u0010\u001B\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u001C\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0007ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001D\u0010\u001E\"\u001C\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001A\u0004\b\u0004\u0010\u0005\"\u001C\u0010\u0006\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001A\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000B\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001A\u00020\u000E8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000F\u0010\u0003\u0082\u0002\u000B\n\u0002\b\u0019\n\u0005\b¡\u001E0\u0001¨\u0006\u001F"}, d2 = {"ALREADY_SELECTED", "", "getALREADY_SELECTED$annotations", "()V", "getALREADY_SELECTED", "()Ljava/lang/Object;", "NOT_SELECTED", "getNOT_SELECTED$annotations", "getNOT_SELECTED", "RESUMED", "getRESUMED$annotations", "UNDECIDED", "getUNDECIDED$annotations", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;", "getSelectOpSequenceNumber$annotations", "select", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTimeout", "timeout", "Lkotlin/time/Duration;", "block", "Lkotlin/coroutines/Continuation;", "onTimeout-8Mi8wO0", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class SelectKt {
    private static final Object ALREADY_SELECTED;
    private static final Object NOT_SELECTED;
    private static final Object RESUMED;
    private static final Object UNDECIDED;
    private static final SeqNumber selectOpSequenceNumber;

    static {
        SelectKt.NOT_SELECTED = new Symbol(UnityPlayerActivity.adjustValue("203F393E3D242B20313A3529"));
        SelectKt.ALREADY_SELECTED = new Symbol(UnityPlayerActivity.adjustValue("2F3C3F242F253E3A212B3C28223A2423"));
        SelectKt.UNDECIDED = new Symbol(UnityPlayerActivity.adjustValue("3B3E29242D28232036"));
        SelectKt.RESUMED = new Symbol(UnityPlayerActivity.adjustValue("3C353E34232423"));
        SelectKt.selectOpSequenceNumber = new SeqNumber();
    }

    public static final Object getALREADY_SELECTED() {
        return SelectKt.ALREADY_SELECTED;
    }

    public static void getALREADY_SELECTED$annotations() {
    }

    public static final Object getNOT_SELECTED() {
        return SelectKt.NOT_SELECTED;
    }

    public static void getNOT_SELECTED$annotations() {
    }

    private static void getRESUMED$annotations() {
    }

    private static void getSelectOpSequenceNumber$annotations() {
    }

    private static void getUNDECIDED$annotations() {
    }

    public static final void onTimeout-8Mi8wO0(SelectBuilder selectBuilder0, long v, Function1 function10) {
        selectBuilder0.onTimeout(DelayKt.toDelayMillis-LRDsOJo(v), function10);
    }

    public static final Object select(Function1 function10, Continuation continuation0) {
        SelectBuilderImpl selectBuilderImpl0 = new SelectBuilderImpl(continuation0);
        try {
            function10.invoke(selectBuilderImpl0);
        }
        catch(Throwable throwable0) {
            selectBuilderImpl0.handleBuilderException(throwable0);
        }
        Object object0 = selectBuilderImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }

    private static final Object select$$forInline(Function1 function10, Continuation continuation0) {
        SelectBuilderImpl selectBuilderImpl0 = new SelectBuilderImpl(continuation0);
        try {
            function10.invoke(selectBuilderImpl0);
        }
        catch(Throwable throwable0) {
            selectBuilderImpl0.handleBuilderException(throwable0);
        }
        Object object0 = selectBuilderImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }
}

