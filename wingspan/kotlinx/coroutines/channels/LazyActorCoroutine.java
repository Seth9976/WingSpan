package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003BM\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b\u0012-\u0010\t\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\n\u00A2\u0006\u0002\b\u000F\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0010J\u0012\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0016J\u0015\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00028\u0000H\u0016\u00A2\u0006\u0002\u0010\u001BJ\b\u0010\u001C\u001A\u00020\rH\u0014JV\u0010\u001D\u001A\u00020\r\"\u0004\b\u0001\u0010\u001E2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u001E0 2\u0006\u0010!\u001A\u00028\u00002(\u0010\t\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001E0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\nH\u0016\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\"J\u0019\u0010#\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00028\u0000H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010$J&\u0010%\u001A\b\u0012\u0004\u0012\u00020\r0&2\u0006\u0010\u001A\u001A\u00028\u0000H\u0016\u00F8\u0001\u0000\u00F8\u0001\u0001\u00F8\u0001\u0002\u00A2\u0006\u0004\b\'\u0010(R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000E\u00A2\u0006\u0002\n\u0000R&\u0010\u0012\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014\u0082\u0002\u000F\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00A1\u001E0\u0001\u00A8\u0006)"}, d2 = {"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "continuation", "onSend", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "", "cause", "", "offer", "element", "(Ljava/lang/Object;)Z", "onStart", "registerSelectClause2", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class LazyActorCoroutine extends ActorCoroutine implements SelectClause2 {
    private Continuation continuation;

    public LazyActorCoroutine(CoroutineContext coroutineContext0, Channel channel0, Function2 function20) {
        super(coroutineContext0, channel0, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(function20, this, this);
    }

    @Override  // kotlinx.coroutines.channels.ChannelCoroutine
    public boolean close(Throwable throwable0) {
        boolean z = super.close(throwable0);
        this.start();
        return z;
    }

    @Override  // kotlinx.coroutines.channels.ChannelCoroutine
    public SelectClause2 getOnSend() {
        return this;
    }

    @Override  // kotlinx.coroutines.channels.ChannelCoroutine
    public boolean offer(Object object0) {
        this.start();
        return super.offer(object0);
    }

    @Override  // kotlinx.coroutines.JobSupport
    protected void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }

    @Override  // kotlinx.coroutines.selects.SelectClause2
    public void registerSelectClause2(SelectInstance selectInstance0, Object object0, Function2 function20) {
        this.start();
        super.getOnSend().registerSelectClause2(selectInstance0, object0, function20);
    }

    @Override  // kotlinx.coroutines.channels.ChannelCoroutine
    public Object send(Object object0, Continuation continuation0) {
        this.start();
        Object object1 = super.send(object0, continuation0);
        return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.channels.ChannelCoroutine
    public Object trySend-JP2dKIU(Object object0) {
        this.start();
        return super.trySend-JP2dKIU(object0);
    }
}

