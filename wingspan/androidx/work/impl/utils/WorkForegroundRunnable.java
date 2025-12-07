package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundRunnable implements Runnable {
    static final String TAG;
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture mFuture;
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    static {
        WorkForegroundRunnable.TAG = "WM-WorkForegroundRunnab";
    }

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker worker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.mFuture = SettableFuture.create();
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = worker;
        this.mForegroundUpdater = foregroundUpdater;
        this.mTaskExecutor = taskExecutor;
    }

    public ListenableFuture getFuture() {
        return this.mFuture;
    }

    // 检测为 Lambda 实现
    void lambda$run$0$androidx-work-impl-utils-WorkForegroundRunnable(SettableFuture settableFuture0) [...]

    @Override
    public void run() {
        if(this.mWorkSpec.expedited && Build.VERSION.SDK_INT < 0x1F) {
            SettableFuture settableFuture0 = SettableFuture.create();
            this.mTaskExecutor.getMainThreadExecutor().execute(() -> {
                if(!this.mFuture.isCancelled()) {
                    settableFuture0.setFuture(this.mWorker.getForegroundInfoAsync());
                    return;
                }
                settableFuture0.cancel(true);
            });
            settableFuture0.addListener(new Runnable() {
                @Override
                public void run() {
                    if(WorkForegroundRunnable.this.mFuture.isCancelled()) {
                        return;
                    }
                    try {
                        ForegroundInfo foregroundInfo0 = (ForegroundInfo)settableFuture0.get();
                        if(foregroundInfo0 == null) {
                            throw new IllegalStateException("Worker was marked important (" + WorkForegroundRunnable.this.mWorkSpec.workerClassName + ") but did not provide ForegroundInfo");
                        }
                        Logger.get().debug("WM-WorkForegroundRunnab", "Updating notification for " + WorkForegroundRunnable.this.mWorkSpec.workerClassName);
                        UUID uUID0 = WorkForegroundRunnable.this.mWorker.getId();
                        ListenableFuture listenableFuture0 = WorkForegroundRunnable.this.mForegroundUpdater.setForegroundAsync(WorkForegroundRunnable.this.mContext, uUID0, foregroundInfo0);
                        WorkForegroundRunnable.this.mFuture.setFuture(listenableFuture0);
                    }
                    catch(Throwable throwable0) {
                        WorkForegroundRunnable.this.mFuture.setException(throwable0);
                    }
                }
            }, this.mTaskExecutor.getMainThreadExecutor());
            return;
        }
        this.mFuture.set(null);
    }
}

