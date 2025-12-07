package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001A0\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000B\u001A6\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00060\r\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000BH\u0000\u001A#\u0010\u0012\u001A\u0004\u0018\u00010\u0013*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017\u001A+\u0010\u0018\u001A\u00020\u0019*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u001A\u001A\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001B\"\u0016\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u001C"}, d2 = {"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "getNO_VALUE$annotations", "()V", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class SharedFlowKt {
    public static final Symbol NO_VALUE;

    static {
        SharedFlowKt.NO_VALUE = new Symbol(UnityPlayerActivity.adjustValue("203F32372F2D3220"));
    }

    public static final MutableSharedFlow MutableSharedFlow(int v, int v1, BufferOverflow bufferOverflow0) {
        if(v < 0) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("1C151D0D0F18470613001E02154E0302451C0B170C1507170249520C05194119001445") + v).toString());
        }
        if(v1 < 0) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("0B0819130F231203140B022E001E00040C0617500E00000F0811520C154D0F0B0606111B181541410C141345050F034D") + v1).toString());
        }
        if(v <= 0 && v1 <= 0 && bufferOverflow0 != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("1C151D0D0F18470A004E1515151C0025101408151F220F1106061B1A094D0C1B121345100B501D0E1D08130C040B501A081A09470B1D005D090408001209064E1F03231B0701000021060813080D0812521D041F001A04001C52") + bufferOverflow0).toString());
        }
        return new SharedFlowImpl(v, (v1 + v >= 0 ? v1 + v : 0x7FFFFFFF), bufferOverflow0);
    }

    public static MutableSharedFlow MutableSharedFlow$default(int v, int v1, BufferOverflow bufferOverflow0, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = 0;
        }
        if((v2 & 4) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        return SharedFlowKt.MutableSharedFlow(v, v1, bufferOverflow0);
    }

    public static final Flow fuseSharedFlow(SharedFlow sharedFlow0, CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        return (v == -3 || v == 0) && bufferOverflow0 == BufferOverflow.SUSPEND ? sharedFlow0 : new ChannelFlowOperatorImpl(sharedFlow0, coroutineContext0, v, bufferOverflow0);
    }

    private static final Object getBufferAt(Object[] arr_object, long v) {
        return arr_object[((int)v) & arr_object.length - 1];
    }

    public static void getNO_VALUE$annotations() {
    }

    private static final void setBufferAt(Object[] arr_object, long v, Object object0) {
        arr_object[((int)v) & arr_object.length - 1] = object0;
    }
}

