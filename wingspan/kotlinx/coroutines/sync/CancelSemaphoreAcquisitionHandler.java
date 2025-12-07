package kotlinx.coroutines.sync;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/sync/CancelSemaphoreAcquisitionHandler;", "Lkotlinx/coroutines/CancelHandler;", "segment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "index", "", "(Lkotlinx/coroutines/sync/SemaphoreSegment;I)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class CancelSemaphoreAcquisitionHandler extends CancelHandler {
    private final int index;
    private final SemaphoreSegment segment;

    public CancelSemaphoreAcquisitionHandler(SemaphoreSegment semaphoreSegment0, int v) {
        this.segment = semaphoreSegment0;
        this.index = v;
    }

    @Override  // kotlin.jvm.functions.Function1
    public Object invoke(Object object0) {
        this.invoke(((Throwable)object0));
        return Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.CancelHandlerBase
    public void invoke(Throwable throwable0) {
        this.segment.cancel(this.index);
    }

    @Override
    public String toString() {
        return UnityPlayerActivity.adjustValue("2D1103020B0D34001F0F00050E1C042606031B191E081A08080B3A0F1E090D0B133C") + this.segment + UnityPlayerActivity.adjustValue("4250") + this.index + ']';
    }
}

