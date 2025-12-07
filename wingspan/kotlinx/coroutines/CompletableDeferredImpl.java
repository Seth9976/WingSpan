package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u000F\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000F\u001A\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\r\u0010\u0017\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018JH\u0010\u0019\u001A\u00020\u001A\"\u0004\b\u0001\u0010\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001B0\u001D2\"\u0010\u001E\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001B0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001FH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\"R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlinx/coroutines/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class CompletableDeferredImpl extends JobSupport implements CompletableDeferred, SelectClause1 {
    public CompletableDeferredImpl(Job job0) {
        super(true);
        this.initParentJob(job0);
    }

    @Override  // kotlinx.coroutines.Deferred
    public Object await(Continuation continuation0) {
        return this.awaitInternal$kotlinx_coroutines_core(continuation0);
    }

    @Override  // kotlinx.coroutines.CompletableDeferred
    public boolean complete(Object object0) {
        return this.makeCompleting$kotlinx_coroutines_core(object0);
    }

    @Override  // kotlinx.coroutines.CompletableDeferred
    public boolean completeExceptionally(Throwable throwable0) {
        return this.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(throwable0, false, 2, null));
    }

    @Override  // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return this.getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override  // kotlinx.coroutines.Deferred
    public SelectClause1 getOnAwait() {
        return this;
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    @Override  // kotlinx.coroutines.selects.SelectClause1
    public void registerSelectClause1(SelectInstance selectInstance0, Function2 function20) {
        this.registerSelectClause1Internal$kotlinx_coroutines_core(selectInstance0, function20);
    }
}

