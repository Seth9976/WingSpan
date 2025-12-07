package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001B\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000BH\u0014J\u0006\u0010\u000F\u001A\u00020\u0010J\u0018\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\u00042\b\u0010\u0012\u001A\u0004\u0018\u00010\u000BR\"\u0010\b\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n0\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", "state", "clearThreadContext", "", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class UndispatchedCoroutine extends ScopeCoroutine {
    private ThreadLocal threadStateToRecover;

    public UndispatchedCoroutine(CoroutineContext coroutineContext0, Continuation continuation0) {
        super((coroutineContext0.get(UndispatchedMarker.INSTANCE) == null ? coroutineContext0.plus(UndispatchedMarker.INSTANCE) : coroutineContext0), continuation0);
        this.threadStateToRecover = new ThreadLocal();
        if(!(continuation0.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher)) {
            Object object0 = ThreadContextKt.updateThreadContext(coroutineContext0, null);
            ThreadContextKt.restoreThreadContext(coroutineContext0, object0);
            this.saveThreadContext(coroutineContext0, object0);
        }
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    protected void afterResume(Object object0) {
        Pair pair0 = (Pair)this.threadStateToRecover.get();
        UndispatchedCoroutine undispatchedCoroutine0 = null;
        if(pair0 != null) {
            ThreadContextKt.restoreThreadContext(((CoroutineContext)pair0.component1()), pair0.component2());
            this.threadStateToRecover.set(null);
        }
        Object object1 = CompletionStateKt.recoverResult(object0, this.uCont);
        Continuation continuation0 = this.uCont;
        CoroutineContext coroutineContext0 = continuation0.getContext();
        Object object2 = ThreadContextKt.updateThreadContext(coroutineContext0, null);
        if(object2 != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCoroutine0 = CoroutineContextKt.updateUndispatchedCompletion(continuation0, coroutineContext0, object2);
        }
        try {
            this.uCont.resumeWith(object1);
        }
        finally {
            if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(coroutineContext0, object2);
            }
        }
    }

    public final boolean clearThreadContext() {
        if(this.threadStateToRecover.get() == null) {
            return false;
        }
        this.threadStateToRecover.set(null);
        return true;
    }

    public final void saveThreadContext(CoroutineContext coroutineContext0, Object object0) {
        this.threadStateToRecover.set(TuplesKt.to(coroutineContext0, object0));
    }
}

