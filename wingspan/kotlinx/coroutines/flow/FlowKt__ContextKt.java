package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow.DefaultImpls;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0015\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¢\u0006\u0002\b\u0004\u001A(\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001A\u00020\tH\u0007\u001A0\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B\u001A\u001C\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001A\u001C\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001A$\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u000F"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__ContextKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final Flow buffer(Flow flow0, int v) {
        return FlowKt__ContextKt.buffer$default(flow0, v, null, 2, null);
    }

    public static final Flow buffer(Flow flow0, int v, BufferOverflow bufferOverflow0) {
        int v1;
        BufferOverflow bufferOverflow1;
        if(v < 0 && (v != -2 && v != -1)) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2C050B070B1347161B14154D12060E1209164E120841000E09481C0B170C1507170249522C252B272B3322215E4E1F1F412D2E29233E2F24282542410510064E070C124E") + v).toString());
        }
        if(v == -1 && bufferOverflow0 != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D3F232722203320364E130C110F020E110B4E130C0F000E1345100B5018120B0547121B1A184D0F010F4A01170811180D1A41080B301B160B041C2E110000081C0216").toString());
        }
        if(v == -1) {
            bufferOverflow1 = BufferOverflow.DROP_OLDEST;
            v1 = 0;
        }
        else {
            v1 = v;
            bufferOverflow1 = bufferOverflow0;
        }
        return flow0 instanceof FusibleFlow ? DefaultImpls.fuse$default(((FusibleFlow)flow0), null, v1, bufferOverflow1, 1, null) : new ChannelFlowOperatorImpl(flow0, null, v1, bufferOverflow1, 2, null);
    }

    public static Flow buffer$default(Flow flow0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = -2;
        }
        return FlowKt__ContextKt.buffer(flow0, v);
    }

    public static Flow buffer$default(Flow flow0, int v, BufferOverflow bufferOverflow0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = -2;
        }
        if((v1 & 2) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow0, v, bufferOverflow0);
    }

    public static final Flow cancellable(Flow flow0) {
        return !(flow0 instanceof CancellableFlow) ? new CancellableFlowImpl(flow0) : flow0;
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext0) {
        if(coroutineContext0.get(Job.Key) != null) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("281C02164E02080B060B0819410D00090B1D1A500E0E0015060C1C4E1A02034E0809451B1A5E4D290F0547") + coroutineContext0).toString());
        }
    }

    public static final Flow conflate(Flow flow0) {
        return FlowKt__ContextKt.buffer$default(flow0, -1, null, 2, null);
    }

    public static final Flow flowOn(Flow flow0, CoroutineContext coroutineContext0) {
        FlowKt__ContextKt.checkFlowContext$FlowKt__ContextKt(coroutineContext0);
        if(!Intrinsics.areEqual(coroutineContext0, EmptyCoroutineContext.INSTANCE)) {
            return flow0 instanceof FusibleFlow ? DefaultImpls.fuse$default(((FusibleFlow)flow0), coroutineContext0, 0, null, 6, null) : new ChannelFlowOperatorImpl(flow0, coroutineContext0, 0, null, 12, null);
        }
        return flow0;
    }
}

