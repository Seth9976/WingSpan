package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class OperationKt {
    public static final Object await(Operation operation0, Continuation continuation0) {
        Object object2;
        androidx.work.OperationKt.await.1 operationKt$await$10;
        if(continuation0 instanceof androidx.work.OperationKt.await.1) {
            operationKt$await$10 = (androidx.work.OperationKt.await.1)continuation0;
            if((operationKt$await$10.label & 0x80000000) == 0) {
                operationKt$await$10 = new ContinuationImpl(continuation0) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return OperationKt.await(null, this);
                    }
                };
            }
            else {
                operationKt$await$10.label ^= 0x80000000;
            }
        }
        else {
            operationKt$await$10 = new ContinuationImpl(continuation0) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return OperationKt.await(null, this);
                }
            };
        }
        Object object0 = operationKt$await$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(operationKt$await$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ListenableFuture listenableFuture0 = operation0.getResult();
                Intrinsics.checkNotNullExpressionValue(listenableFuture0, "result");
                if(listenableFuture0.isDone()) {
                    try {
                        object2 = listenableFuture0.get();
                    }
                    catch(ExecutionException executionException0) {
                        Throwable throwable0 = executionException0.getCause();
                        if(throwable0 == null) {
                            throwable0 = executionException0;
                        }
                        throw throwable0;
                    }
                }
                else {
                    operationKt$await$10.L$0 = listenableFuture0;
                    operationKt$await$10.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(operationKt$await$10), 1);
                    cancellableContinuationImpl0.initCancellability();
                    listenableFuture0.addListener(new androidx.work.ListenableFutureKt.await.2.1(cancellableContinuationImpl0, listenableFuture0), DirectExecutor.INSTANCE);
                    cancellableContinuationImpl0.invokeOnCancellation(new androidx.work.ListenableFutureKt.await.2.2(listenableFuture0));
                    object0 = cancellableContinuationImpl0.getResult();
                    if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(operationKt$await$10);
                    }
                    if(object0 == object1) {
                        return object1;
                    }
                    object2 = object0;
                }
                break;
            }
            case 1: {
                ListenableFuture listenableFuture1 = (ListenableFuture)operationKt$await$10.L$0;
                ResultKt.throwOnFailure(object0);
                object2 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Intrinsics.checkNotNullExpressionValue(object2, "result.await()");
        return object2;
    }

    private static final Object await$$forInline(Operation operation0, Continuation continuation0) {
        Object object0;
        ListenableFuture listenableFuture0 = operation0.getResult();
        Intrinsics.checkNotNullExpressionValue(listenableFuture0, "result");
        if(listenableFuture0.isDone()) {
            try {
                object0 = listenableFuture0.get();
            }
            catch(ExecutionException executionException0) {
                Throwable throwable0 = executionException0.getCause();
                if(throwable0 == null) {
                    throwable0 = executionException0;
                }
                throw throwable0;
            }
        }
        else {
            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation0), 1);
            cancellableContinuationImpl0.initCancellability();
            listenableFuture0.addListener(new androidx.work.ListenableFutureKt.await.2.1(cancellableContinuationImpl0, listenableFuture0), DirectExecutor.INSTANCE);
            cancellableContinuationImpl0.invokeOnCancellation(new androidx.work.ListenableFutureKt.await.2.2(listenableFuture0));
            object0 = cancellableContinuationImpl0.getResult();
            if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation0);
            }
        }
        Intrinsics.checkNotNullExpressionValue(object0, "result.await()");
        return object0;
    }
}

