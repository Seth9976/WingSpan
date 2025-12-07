package androidx.arch.core.executor;

import java.util.concurrent.Executor;

public class ArchTaskExecutor extends TaskExecutor {
    private TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;
    private static final Executor sIOThreadExecutor;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor;

    static {
        ArchTaskExecutor.sMainThreadExecutor = (Runnable runnable0) -> ArchTaskExecutor.getInstance().mDelegate.postToMainThread(runnable0);
        ArchTaskExecutor.sIOThreadExecutor = (Runnable runnable0) -> ArchTaskExecutor.getInstance().mDelegate.executeOnDiskIO(runnable0);
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor0 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor0;
        this.mDelegate = defaultTaskExecutor0;
    }

    // 检测为 Lambda 实现
    @Override  // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable0) [...]

    public static Executor getIOThreadExecutor() {
        return ArchTaskExecutor.sIOThreadExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if(ArchTaskExecutor.sInstance != null) {
            return ArchTaskExecutor.sInstance;
        }
        synchronized(ArchTaskExecutor.class) {
            if(ArchTaskExecutor.sInstance == null) {
                ArchTaskExecutor.sInstance = new ArchTaskExecutor();
            }
            return ArchTaskExecutor.sInstance;
        }
    }

    public static Executor getMainThreadExecutor() {
        return ArchTaskExecutor.sMainThreadExecutor;
    }

    @Override  // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    // 检测为 Lambda 实现
    @Override  // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable0) [...]

    public void setDelegate(TaskExecutor taskExecutor0) {
        if(taskExecutor0 == null) {
            taskExecutor0 = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor0;
    }

    final class androidx.arch.core.executor.ArchTaskExecutor.1 implements Executor {
        @Override
        public void execute(Runnable runnable0) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable0);
        }
    }


    final class androidx.arch.core.executor.ArchTaskExecutor.2 implements Executor {
        @Override
        public void execute(Runnable runnable0) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable0);
        }
    }

}

