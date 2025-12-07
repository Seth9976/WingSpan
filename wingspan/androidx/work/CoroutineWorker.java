package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0016\u001A\u00020\u000FH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001A\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u001BJ\u0006\u0010\u001C\u001A\u00020\u001DJ\u0019\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001A\u00020\u001D2\u0006\u0010\"\u001A\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$J\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\u000F0\u001BR\u001C\u0010\u0007\u001A\u00020\b8\u0016X\u0097\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "coroutineContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlinx/coroutines/CoroutineDispatcher;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "getFuture$work_runtime_ktx_release", "()Landroidx/work/impl/utils/futures/SettableFuture;", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob$work_runtime_ktx_release", "()Lkotlinx/coroutines/CompletableJob;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundInfo", "Landroidx/work/ForegroundInfo;", "getForegroundInfoAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", "onStopped", "", "setForeground", "foregroundInfo", "(Landroidx/work/ForegroundInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setProgress", "data", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWork", "work-runtime-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture future;
    private final CompletableJob job;

    public CoroutineWorker(Context context0, WorkerParameters workerParameters0) {
        Intrinsics.checkNotNullParameter(context0, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters0, "params");
        super(context0, workerParameters0);
        this.job = JobKt__JobKt.Job$default(null, 1, null);
        SettableFuture settableFuture0 = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue(settableFuture0, "create()");
        this.future = settableFuture0;
        settableFuture0.addListener(() -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            if(this.future.isCancelled()) {
                DefaultImpls.cancel$default(this.job, null, 1, null);
            }
        }, this.getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = Dispatchers.getDefault();
    }

    // 检测为 Lambda 实现
    private static final void _init_$lambda$0(CoroutineWorker coroutineWorker0) [...]

    public abstract Object doWork(Continuation arg1);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @Deprecated(message = "use withContext(...) inside doWork() instead.")
    public static void getCoroutineContext$annotations() {
    }

    public Object getForegroundInfo(Continuation continuation0) {
        return CoroutineWorker.getForegroundInfo$suspendImpl(this, continuation0);
    }

    static Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker0, Continuation continuation0) {
        throw new IllegalStateException("Not implemented");
    }

    @Override  // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        CompletableJob completableJob0 = JobKt__JobKt.Job$default(null, 1, null);
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(this.getCoroutineContext().plus(completableJob0));
        JobListenableFuture jobListenableFuture0 = new JobListenableFuture(completableJob0, null, 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Function2(this, null) {
            final JobListenableFuture $jobFuture;
            Object L$0;
            int label;

            {
                this.$jobFuture = jobListenableFuture0;
                CoroutineWorker.this = coroutineWorker0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new androidx.work.CoroutineWorker.getForegroundInfoAsync.1(this.$jobFuture, CoroutineWorker.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((androidx.work.CoroutineWorker.getForegroundInfoAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                JobListenableFuture jobListenableFuture1;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        JobListenableFuture jobListenableFuture0 = this.$jobFuture;
                        this.L$0 = jobListenableFuture0;
                        this.label = 1;
                        Object object2 = CoroutineWorker.this.getForegroundInfo(this);
                        if(object2 == object1) {
                            return object1;
                        }
                        jobListenableFuture1 = jobListenableFuture0;
                        object0 = object2;
                        break;
                    }
                    case 1: {
                        jobListenableFuture1 = (JobListenableFuture)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                jobListenableFuture1.complete(object0);
                return Unit.INSTANCE;
            }
        }, 3, null);
        return jobListenableFuture0;
    }

    public final SettableFuture getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    public final CompletableJob getJob$work_runtime_ktx_release() {
        return this.job;
    }

    @Override  // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo foregroundInfo0, Continuation continuation0) {
        ListenableFuture listenableFuture0 = this.setForegroundAsync(foregroundInfo0);
        Intrinsics.checkNotNullExpressionValue(listenableFuture0, "setForegroundAsync(foregroundInfo)");
        if(listenableFuture0.isDone()) {
            try {
                listenableFuture0.get();
                return Unit.INSTANCE;
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
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    public final Object setProgress(Data data0, Continuation continuation0) {
        ListenableFuture listenableFuture0 = this.setProgressAsync(data0);
        Intrinsics.checkNotNullExpressionValue(listenableFuture0, "setProgressAsync(data)");
        if(listenableFuture0.isDone()) {
            try {
                listenableFuture0.get();
                return Unit.INSTANCE;
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
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getCoroutineContext().plus(this.job)), null, null, new Function2(null) {
            int label;

            {
                CoroutineWorker.this = coroutineWorker0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new androidx.work.CoroutineWorker.startWork.1(CoroutineWorker.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((androidx.work.CoroutineWorker.startWork.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        try {
                            this.label = 1;
                            object0 = CoroutineWorker.this.doWork(this);
                            if(object0 == object1) {
                                return object1;
                            label_8:
                                ResultKt.throwOnFailure(object0);
                            }
                            CoroutineWorker.this.getFuture$work_runtime_ktx_release().set(((Result)object0));
                            return Unit.INSTANCE;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        goto label_8;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                CoroutineWorker.this.getFuture$work_runtime_ktx_release().setException(throwable0);
                return Unit.INSTANCE;
            }
        }, 3, null);
        return this.future;
    }
}

