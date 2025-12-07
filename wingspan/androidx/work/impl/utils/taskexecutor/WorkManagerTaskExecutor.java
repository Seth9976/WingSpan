package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;

public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutorImpl mBackgroundExecutor;
    private final Executor mMainThreadExecutor;
    final Handler mMainThreadHandler;

    public WorkManagerTaskExecutor(Executor backgroundExecutor) {
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        this.mMainThreadExecutor = new Executor() {
            @Override
            public void execute(Runnable command) {
                WorkManagerTaskExecutor.this.mMainThreadHandler.post(command);
            }
        };
        this.mBackgroundExecutor = new SerialExecutorImpl(backgroundExecutor);
    }

    @Override  // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public void executeOnTaskThread(Runnable runnable0) {
        TaskExecutor.-CC.$default$executeOnTaskThread(this, runnable0);
    }

    @Override  // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    public SerialExecutorImpl getSerialTaskExecutor() {
        return this.mBackgroundExecutor;
    }

    @Override  // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public SerialExecutor getSerialTaskExecutor() {
        return this.getSerialTaskExecutor();
    }
}

