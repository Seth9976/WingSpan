package androidx.work.impl.utils.taskexecutor;

public final class TaskExecutor.-CC {
    public static void $default$executeOnTaskThread(TaskExecutor _this, Runnable runnable0) {
        _this.getSerialTaskExecutor().execute(runnable0);
    }
}

