package kotlinx.coroutines.flow.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0011\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0081\b\u001A\u0018\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0007H\u0000¨\u0006\b"}, d2 = {"checkIndexOverflow", "", "index", "checkOwnership", "", "Lkotlinx/coroutines/flow/internal/AbortFlowException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class FlowExceptions_commonKt {
    public static final int checkIndexOverflow(int v) {
        if(v < 0) {
            throw new ArithmeticException(UnityPlayerActivity.adjustValue("271E090416410813171C16010E19410F04014E180C111E04090016"));
        }
        return v;
    }

    public static final void checkOwnership(AbortFlowException abortFlowException0, FlowCollector flowCollector0) {
        if(abortFlowException0.owner != flowCollector0) {
            throw abortFlowException0;
        }
    }
}

