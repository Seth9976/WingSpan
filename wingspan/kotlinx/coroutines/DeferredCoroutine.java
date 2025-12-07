package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\r\u001A\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000EJ\r\u0010\u000F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010JH\u0010\u0011\u001A\u00020\u0012\"\u0004\b\u0001\u0010\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00130\u00152\"\u0010\u0016\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001AR\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001B"}, d2 = {"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
class DeferredCoroutine extends AbstractCoroutine implements Deferred, SelectClause1 {
    public DeferredCoroutine(CoroutineContext coroutineContext0, boolean z) {
        super(coroutineContext0, true, z);
    }

    @Override  // kotlinx.coroutines.Deferred
    public Object await(Continuation continuation0) {
        return DeferredCoroutine.await$suspendImpl(this, continuation0);
    }

    static Object await$suspendImpl(DeferredCoroutine deferredCoroutine0, Continuation continuation0) {
        return deferredCoroutine0.awaitInternal$kotlinx_coroutines_core(continuation0);
    }

    @Override  // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return this.getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override  // kotlinx.coroutines.Deferred
    public SelectClause1 getOnAwait() {
        return this;
    }

    @Override  // kotlinx.coroutines.selects.SelectClause1
    public void registerSelectClause1(SelectInstance selectInstance0, Function2 function20) {
        this.registerSelectClause1Internal$kotlinx_coroutines_core(selectInstance0, function20);
    }
}

