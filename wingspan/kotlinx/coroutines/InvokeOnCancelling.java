package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u000FB0\u0012\'\u0010\b\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001A\u0010\u000B\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000B\u0010\fR5\u0010\b\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class InvokeOnCancelling extends JobCancellingNode {
    private volatile int _invoked;
    private static final AtomicIntegerFieldUpdater _invoked$FU;
    private final Function1 handler;

    static {
        String s = UnityPlayerActivity.adjustValue("31190317010A0201");
        InvokeOnCancelling._invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, s);
    }

    public InvokeOnCancelling(Function1 function10) {
        this.handler = function10;
        this._invoked = 0;
    }

    @Override  // kotlin.jvm.functions.Function1
    public Object invoke(Object object0) {
        this.invoke(((Throwable)object0));
        return Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.CompletionHandlerBase
    public void invoke(Throwable throwable0) {
        if(InvokeOnCancelling._invoked$FU.compareAndSet(this, 0, 1)) {
            this.handler.invoke(throwable0);
        }
    }
}

