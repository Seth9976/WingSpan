package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J)\u0010\b\u001A\u00020\t2\u000E\u0010\n\u001A\n \f*\u0004\u0018\u00010\u000B0\u000B2\u000E\u0010\r\u001A\n \f*\u0004\u0018\u00010\u000E0\u000EH\u0096\u0001J\u0011\u0010\u000F\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\u0010H\u0096\u0001J\u0013\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00028\u0000¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001A\n \f*\u0004\u0018\u00018\u00008\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0015J.\u0010\u0014\u001A\n \f*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\n\u001A\u00020\u00162\u000E\u0010\r\u001A\n \f*\u0004\u0018\u00010\u00170\u0017H\u0096\u0003¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001A\u00020\u0010H\u0096\u0001J\t\u0010\u001A\u001A\u00020\u0010H\u0096\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Landroidx/work/JobListenableFuture;", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "job", "Lkotlinx/coroutines/Job;", "underlying", "Landroidx/work/impl/utils/futures/SettableFuture;", "(Lkotlinx/coroutines/Job;Landroidx/work/impl/utils/futures/SettableFuture;)V", "addListener", "", "p0", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "p1", "Ljava/util/concurrent/Executor;", "cancel", "", "complete", "result", "(Ljava/lang/Object;)V", "get", "()Ljava/lang/Object;", "", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", "work-runtime-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class JobListenableFuture implements ListenableFuture {
    private final Job job;
    private final SettableFuture underlying;

    public JobListenableFuture(Job job0, SettableFuture settableFuture0) {
        Intrinsics.checkNotNullParameter(job0, "job");
        Intrinsics.checkNotNullParameter(settableFuture0, "underlying");
        super();
        this.job = job0;
        this.underlying = settableFuture0;
        job0.invokeOnCompletion(new Function1() {
            {
                JobListenableFuture.this = jobListenableFuture0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((Throwable)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable throwable0) {
                if(throwable0 != null) {
                    if(throwable0 instanceof CancellationException) {
                        JobListenableFuture.this.underlying.cancel(true);
                        return;
                    }
                    SettableFuture settableFuture0 = JobListenableFuture.this.underlying;
                    Throwable throwable1 = throwable0.getCause();
                    if(throwable1 != null) {
                        throwable0 = throwable1;
                    }
                    settableFuture0.setException(throwable0);
                }
                else if(!JobListenableFuture.this.underlying.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
        });
    }

    public JobListenableFuture(Job job0, SettableFuture settableFuture0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            settableFuture0 = SettableFuture.create();
            Intrinsics.checkNotNullExpressionValue(settableFuture0, "create()");
        }
        this(job0, settableFuture0);
    }

    @Override  // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable0, Executor executor0) {
        this.underlying.addListener(runnable0, executor0);
    }

    @Override
    public boolean cancel(boolean z) {
        return this.underlying.cancel(z);
    }

    public final void complete(Object object0) {
        this.underlying.set(object0);
    }

    @Override
    public Object get() {
        return this.underlying.get();
    }

    @Override
    public Object get(long v, TimeUnit timeUnit0) {
        return this.underlying.get(v, timeUnit0);
    }

    @Override
    public boolean isCancelled() {
        return this.underlying.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.underlying.isDone();
    }
}

