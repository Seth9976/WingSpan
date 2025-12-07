package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u001AB;\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0014\u001A\u00020\u00132\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001A\u00020\u00132\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001A2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0013H\u0002¢\u0006\u0004\b \u0010!J\u001D\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0017\u001A\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\'"}, d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "consume", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "markConsumed", "()V", "Lkotlinx/coroutines/CoroutineScope;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class ChannelAsFlow extends ChannelFlow {
    private final ReceiveChannel channel;
    private final boolean consume;
    private volatile int consumed;
    private static final AtomicIntegerFieldUpdater consumed$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("0D1F03121B0C0201");
        ChannelAsFlow.consumed$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, s);
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel0, boolean z, CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        super(coroutineContext0, v, bufferOverflow0);
        this.channel = receiveChannel0;
        this.consume = z;
        this.consumed = 0;
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel0, boolean z, CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            coroutineContext0 = EmptyCoroutineContext.INSTANCE;
        }
        if((v1 & 8) != 0) {
            v = -3;
        }
        if((v1 & 16) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(receiveChannel0, z, coroutineContext0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String additionalToStringProps() {
        return UnityPlayerActivity.adjustValue("0D180C0F00040B58") + this.channel;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
        if(this.capacity == -3) {
            this.markConsumed();
            Object object0 = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(flowCollector0, this.channel, this.consume, continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        Object object1 = super.collect(flowCollector0, continuation0);
        return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object collectTo(ProducerScope producerScope0, Continuation continuation0) {
        Object object0 = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(new SendingCollector(producerScope0), this.channel, this.consume, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow create(CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        return new ChannelAsFlow(this.channel, this.consume, coroutineContext0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    public Flow dropChannelOperators() {
        return new ChannelAsFlow(this.channel, this.consume, null, 0, null, 28, null);
    }

    private final void markConsumed() {
        if(this.consume && ChannelAsFlow.consumed$FU.getAndSet(this, 1) != 0) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("3C150E04071702261A0F1E0304024F040A1C1D0500042F1221091D19500E0000410500520D1F010D0B021300164E1A18121A41080B110B").toString());
        }
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel produceImpl(CoroutineScope coroutineScope0) {
        this.markConsumed();
        return this.capacity == -3 ? this.channel : super.produceImpl(coroutineScope0);
    }
}

