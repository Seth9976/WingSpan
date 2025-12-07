package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\n2\u001C\u0010\u000B\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\f2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\\\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\n2\'\u0010\u000B\u001A#\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001A\u0002H\u00112\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001A\u0010\u0003\u001A\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0003\u0010\u0007j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class CoroutineStart extends Enum {
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[CoroutineStart.values().length];
            arr_v[CoroutineStart.DEFAULT.ordinal()] = 1;
            arr_v[CoroutineStart.ATOMIC.ordinal()] = 2;
            arr_v[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            arr_v[CoroutineStart.LAZY.ordinal()] = 4;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private static final CoroutineStart[] $VALUES;
    public static final enum CoroutineStart ATOMIC;
    public static final enum CoroutineStart DEFAULT;
    public static final enum CoroutineStart LAZY;
    public static final enum CoroutineStart UNDISPATCHED;

    private static final CoroutineStart[] $values() [...] // Inlined contents

    static {
        CoroutineStart.DEFAULT = new CoroutineStart(UnityPlayerActivity.adjustValue("2A352B203B2D33"), 0);
        CoroutineStart.LAZY = new CoroutineStart(UnityPlayerActivity.adjustValue("22313738"), 1);
        CoroutineStart.ATOMIC = new CoroutineStart(UnityPlayerActivity.adjustValue("2F24222C2722"), 2);
        CoroutineStart.UNDISPATCHED = new CoroutineStart(UnityPlayerActivity.adjustValue("3B3E29283D31263131263529"), 3);
        CoroutineStart.$VALUES = new CoroutineStart[]{CoroutineStart.DEFAULT, CoroutineStart.LAZY, CoroutineStart.ATOMIC, CoroutineStart.UNDISPATCHED};
    }

    private CoroutineStart(String s, int v) {
        super(s, v);
    }

    public final void invoke(Function1 function10, Continuation continuation0) {
        switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                CancellableKt.startCoroutineCancellable(function10, continuation0);
                break;
            }
            case 2: {
                ContinuationKt.startCoroutine(function10, continuation0);
                return;
            }
            case 3: {
                UndispatchedKt.startCoroutineUndispatched(function10, continuation0);
                return;
            }
            case 4: {
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final void invoke(Function2 function20, Object object0, Continuation continuation0) {
        switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1: {
                CancellableKt.startCoroutineCancellable$default(function20, object0, continuation0, null, 4, null);
                break;
            }
            case 2: {
                ContinuationKt.startCoroutine(function20, object0, continuation0);
                return;
            }
            case 3: {
                UndispatchedKt.startCoroutineUndispatched(function20, object0, continuation0);
                return;
            }
            case 4: {
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final boolean isLazy() {
        return this == CoroutineStart.LAZY;
    }

    public static void isLazy$annotations() {
    }

    public static CoroutineStart valueOf(String s) {
        return (CoroutineStart)Enum.valueOf(CoroutineStart.class, s);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[])CoroutineStart.$VALUES.clone();
    }
}

