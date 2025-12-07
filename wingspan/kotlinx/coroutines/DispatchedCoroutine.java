package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0015B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\r\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000E\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class DispatchedCoroutine extends ScopeCoroutine {
    private volatile int _decision;
    private static final AtomicIntegerFieldUpdater _decision$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("3114080207120E0A1C");
        DispatchedCoroutine._decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, s);
    }

    public DispatchedCoroutine(CoroutineContext coroutineContext0, Continuation continuation0) {
        super(coroutineContext0, continuation0);
        this._decision = 0;
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    protected void afterCompletion(Object object0) {
        this.afterResume(object0);
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    protected void afterResume(Object object0) {
        if(this.tryResume()) {
            return;
        }
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted(this.uCont), CompletionStateKt.recoverResult(object0, this.uCont), null, 2, null);
    }

    public final Object getResult() {
        if(this.trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object object0 = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        return object0;
    }

    private final boolean tryResume() {
    alab1:
        while(true) {
            switch(this._decision) {
                case 0: {
                    if(!DispatchedCoroutine._decision$FU.compareAndSet(this, 0, 2)) {
                        break;
                    }
                    break alab1;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B05").toString());
                }
            }
        }
        return true;
    }

    private final boolean trySuspend() {
    alab1:
        while(true) {
            switch(this._decision) {
                case 0: {
                    if(!DispatchedCoroutine._decision$FU.compareAndSet(this, 0, 1)) {
                        break;
                    }
                    break alab1;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45011B031D0400050201").toString());
                }
            }
        }
        return true;
    }
}

