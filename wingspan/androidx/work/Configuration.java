package androidx.work;

import android.os.Build.VERSION;
import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class Configuration {
    public static final class Builder {
        String mDefaultProcessName;
        Consumer mExceptionHandler;
        Executor mExecutor;
        InputMergerFactory mInputMergerFactory;
        int mLoggingLevel;
        int mMaxJobSchedulerId;
        int mMaxSchedulerLimit;
        int mMinJobSchedulerId;
        RunnableScheduler mRunnableScheduler;
        Consumer mSchedulingExceptionHandler;
        Executor mTaskExecutor;
        WorkerFactory mWorkerFactory;

        public Builder() {
            this.mLoggingLevel = 4;
            this.mMinJobSchedulerId = 0;
            this.mMaxJobSchedulerId = 0x7FFFFFFF;
            this.mMaxSchedulerLimit = 20;
        }

        public Builder(Configuration configuration) {
            this.mExecutor = configuration.mExecutor;
            this.mWorkerFactory = configuration.mWorkerFactory;
            this.mInputMergerFactory = configuration.mInputMergerFactory;
            this.mTaskExecutor = configuration.mTaskExecutor;
            this.mLoggingLevel = configuration.mLoggingLevel;
            this.mMinJobSchedulerId = configuration.mMinJobSchedulerId;
            this.mMaxJobSchedulerId = configuration.mMaxJobSchedulerId;
            this.mMaxSchedulerLimit = configuration.mMaxSchedulerLimit;
            this.mRunnableScheduler = configuration.mRunnableScheduler;
            this.mExceptionHandler = configuration.mExceptionHandler;
            this.mSchedulingExceptionHandler = configuration.mSchedulingExceptionHandler;
            this.mDefaultProcessName = configuration.mDefaultProcessName;
        }

        public Configuration build() {
            return new Configuration(this);
        }

        public Builder setDefaultProcessName(String processName) {
            this.mDefaultProcessName = processName;
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.mExecutor = executor;
            return this;
        }

        public Builder setInitializationExceptionHandler(Consumer exceptionHandler) {
            this.mExceptionHandler = exceptionHandler;
            return this;
        }

        public Builder setInitializationExceptionHandler(InitializationExceptionHandler exceptionHandler) {
            Objects.requireNonNull(exceptionHandler);
            this.mExceptionHandler = new Configuration.Builder..ExternalSyntheticLambda0(exceptionHandler);
            return this;
        }

        public Builder setInputMergerFactory(InputMergerFactory inputMergerFactory) {
            this.mInputMergerFactory = inputMergerFactory;
            return this;
        }

        public Builder setJobSchedulerJobIdRange(int minJobSchedulerId, int maxJobSchedulerId) {
            if(maxJobSchedulerId - minJobSchedulerId < 1000) {
                throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
            }
            this.mMinJobSchedulerId = minJobSchedulerId;
            this.mMaxJobSchedulerId = maxJobSchedulerId;
            return this;
        }

        public Builder setMaxSchedulerLimit(int maxSchedulerLimit) {
            if(maxSchedulerLimit < 20) {
                throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
            }
            this.mMaxSchedulerLimit = Math.min(maxSchedulerLimit, 50);
            return this;
        }

        public Builder setMinimumLoggingLevel(int loggingLevel) {
            this.mLoggingLevel = loggingLevel;
            return this;
        }

        public Builder setRunnableScheduler(RunnableScheduler runnableScheduler) {
            this.mRunnableScheduler = runnableScheduler;
            return this;
        }

        public Builder setSchedulingExceptionHandler(Consumer schedulingExceptionHandler) {
            this.mSchedulingExceptionHandler = schedulingExceptionHandler;
            return this;
        }

        public Builder setTaskExecutor(Executor taskExecutor) {
            this.mTaskExecutor = taskExecutor;
            return this;
        }

        public Builder setWorkerFactory(WorkerFactory workerFactory) {
            this.mWorkerFactory = workerFactory;
            return this;
        }
    }

    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public static final int MIN_SCHEDULER_LIMIT = 20;
    final String mDefaultProcessName;
    final Consumer mExceptionHandler;
    final Executor mExecutor;
    final InputMergerFactory mInputMergerFactory;
    private final boolean mIsUsingDefaultTaskExecutor;
    final int mLoggingLevel;
    final int mMaxJobSchedulerId;
    final int mMaxSchedulerLimit;
    final int mMinJobSchedulerId;
    final RunnableScheduler mRunnableScheduler;
    final Consumer mSchedulingExceptionHandler;
    final Executor mTaskExecutor;
    final WorkerFactory mWorkerFactory;

    Configuration(Builder builder) {
        this.mExecutor = builder.mExecutor == null ? this.createDefaultExecutor(false) : builder.mExecutor;
        if(builder.mTaskExecutor == null) {
            this.mIsUsingDefaultTaskExecutor = true;
            this.mTaskExecutor = this.createDefaultExecutor(true);
        }
        else {
            this.mIsUsingDefaultTaskExecutor = false;
            this.mTaskExecutor = builder.mTaskExecutor;
        }
        this.mWorkerFactory = builder.mWorkerFactory == null ? WorkerFactory.getDefaultWorkerFactory() : builder.mWorkerFactory;
        this.mInputMergerFactory = builder.mInputMergerFactory == null ? InputMergerFactory.getDefaultInputMergerFactory() : builder.mInputMergerFactory;
        this.mRunnableScheduler = builder.mRunnableScheduler == null ? new DefaultRunnableScheduler() : builder.mRunnableScheduler;
        this.mLoggingLevel = builder.mLoggingLevel;
        this.mMinJobSchedulerId = builder.mMinJobSchedulerId;
        this.mMaxJobSchedulerId = builder.mMaxJobSchedulerId;
        this.mMaxSchedulerLimit = builder.mMaxSchedulerLimit;
        this.mExceptionHandler = builder.mExceptionHandler;
        this.mSchedulingExceptionHandler = builder.mSchedulingExceptionHandler;
        this.mDefaultProcessName = builder.mDefaultProcessName;
    }

    private Executor createDefaultExecutor(boolean isTaskExecutor) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), this.createDefaultThreadFactory(isTaskExecutor));
    }

    private ThreadFactory createDefaultThreadFactory(boolean isTaskExecutor) {
        return new ThreadFactory() {
            private final AtomicInteger mThreadCount;

            {
                boolean val$isTaskExecutor = isTaskExecutor;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.mThreadCount = new AtomicInteger(0);
            }

            // 去混淆评级： 低(20)
            @Override
            public Thread newThread(Runnable runnable) {
                return isTaskExecutor ? new Thread(runnable, "WM.task-" + this.mThreadCount.incrementAndGet()) : new Thread(runnable, "androidx.work-" + this.mThreadCount.incrementAndGet());
            }
        };
    }

    public String getDefaultProcessName() {
        return this.mDefaultProcessName;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public Consumer getInitializationExceptionHandler() {
        return this.mExceptionHandler;
    }

    public InputMergerFactory getInputMergerFactory() {
        return this.mInputMergerFactory;
    }

    public int getMaxJobSchedulerId() {
        return this.mMaxJobSchedulerId;
    }

    public int getMaxSchedulerLimit() {
        return Build.VERSION.SDK_INT == 23 ? this.mMaxSchedulerLimit / 2 : this.mMaxSchedulerLimit;
    }

    public int getMinJobSchedulerId() {
        return this.mMinJobSchedulerId;
    }

    public int getMinimumLoggingLevel() {
        return this.mLoggingLevel;
    }

    public RunnableScheduler getRunnableScheduler() {
        return this.mRunnableScheduler;
    }

    public Consumer getSchedulingExceptionHandler() {
        return this.mSchedulingExceptionHandler;
    }

    public Executor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }

    public boolean isUsingDefaultTaskExecutor() {
        return this.mIsUsingDefaultTaskExecutor;
    }
}

