package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A!\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class ListenableFutureKt {
    public static final Object await(ListenableFuture listenableFuture0, Continuation continuation0) {
        if(listenableFuture0.isDone()) {
            try {
                return listenableFuture0.get();
            }
            catch(ExecutionException executionException0) {
                Throwable throwable0 = executionException0.getCause();
                if(throwable0 == null) {
                    throwable0 = executionException0;
                }
                throw throwable0;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        listenableFuture0.addListener(new Runnable() {
            @Override
            public final void run() {
                try {
                    Object object0 = Result.constructor-impl(listenableFuture0.get());
                    cancellableContinuationImpl0.resumeWith(object0);
                }
                catch(Throwable throwable0) {
                    Throwable throwable1 = throwable0.getCause();
                    if(throwable1 == null) {
                        throwable1 = throwable0;
                    }
                    if(throwable0 instanceof CancellationException) {
                        cancellableContinuationImpl0.cancel(throwable1);
                        return;
                    }
                    Object object1 = Result.constructor-impl(ResultKt.createFailure(throwable1));
                    cancellableContinuationImpl0.resumeWith(object1);
                }
            }
        }, DirectExecutor.INSTANCE);
        cancellableContinuationImpl0.invokeOnCancellation(new Function1(listenableFuture0) {
            final ListenableFuture $this_await;

            {
                this.$this_await = listenableFuture0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((Throwable)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable throwable0) {
                this.$this_await.cancel(false);
            }
        });
        Object object0 = cancellableContinuationImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }

    private static final Object await$$forInline(ListenableFuture listenableFuture0, Continuation continuation0) {
        if(listenableFuture0.isDone()) {
            try {
                return listenableFuture0.get();
            }
            catch(ExecutionException executionException0) {
                Throwable throwable0 = executionException0.getCause();
                if(throwable0 == null) {
                    throwable0 = executionException0;
                }
                throw throwable0;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        listenableFuture0.addListener(new androidx.work.ListenableFutureKt.await.2.1(cancellableContinuationImpl0, listenableFuture0), DirectExecutor.INSTANCE);
        cancellableContinuationImpl0.invokeOnCancellation(new androidx.work.ListenableFutureKt.await.2.2(listenableFuture0));
        Object object0 = cancellableContinuationImpl0.getResult();
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }
}

