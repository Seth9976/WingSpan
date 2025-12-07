package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class Worker extends ListenableWorker {
    SettableFuture mFuture;

    public Worker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    public abstract Result doWork();

    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override  // androidx.work.ListenableWorker
    public ListenableFuture getForegroundInfoAsync() {
        ListenableFuture listenableFuture0 = SettableFuture.create();
        this.getBackgroundExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ForegroundInfo foregroundInfo0 = Worker.this.getForegroundInfo();
                    ((SettableFuture)listenableFuture0).set(foregroundInfo0);
                }
                catch(Throwable throwable0) {
                    ((SettableFuture)listenableFuture0).setException(throwable0);
                }
            }
        });
        return listenableFuture0;
    }

    @Override  // androidx.work.ListenableWorker
    public final ListenableFuture startWork() {
        this.mFuture = SettableFuture.create();
        this.getBackgroundExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Result listenableWorker$Result0 = Worker.this.doWork();
                    Worker.this.mFuture.set(listenableWorker$Result0);
                }
                catch(Throwable throwable0) {
                    Worker.this.mFuture.setException(throwable0);
                }
            }
        });
        return this.mFuture;
    }
}

