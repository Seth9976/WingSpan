package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;

public interface TaskExecutor {
    void executeOnTaskThread(Runnable arg1);

    Executor getMainThreadExecutor();

    SerialExecutor getSerialTaskExecutor();
}

