package androidx.work;

import android.content.Context;
import android.net.Network;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    public static abstract class Result {
        public static final class Failure extends Result {
            private final Data mOutputData;

            public Failure() {
                this(Data.EMPTY);
            }

            public Failure(Data outputData) {
                this.mOutputData = outputData;
            }

            @Override
            public boolean equals(Object o) {
                if(this == o) {
                    return true;
                }
                return o == null || this.getClass() != o.getClass() ? false : this.mOutputData.equals(((Failure)o).mOutputData);
            }

            @Override  // androidx.work.ListenableWorker$Result
            public Data getOutputData() {
                return this.mOutputData;
            }

            @Override
            public int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            @Override
            public String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }
        }

        public static final class Retry extends Result {
            // 去混淆评级： 低(20)
            @Override
            public boolean equals(Object o) {
                return this == o ? true : o != null && this.getClass() == o.getClass();
            }

            @Override  // androidx.work.ListenableWorker$Result
            public Data getOutputData() {
                return Data.EMPTY;
            }

            @Override
            public int hashCode() {
                return 0x18BE74E;
            }

            @Override
            public String toString() {
                return "Retry";
            }
        }

        public static final class Success extends Result {
            private final Data mOutputData;

            public Success() {
                this(Data.EMPTY);
            }

            public Success(Data outputData) {
                this.mOutputData = outputData;
            }

            @Override
            public boolean equals(Object o) {
                if(this == o) {
                    return true;
                }
                return o == null || this.getClass() != o.getClass() ? false : this.mOutputData.equals(((Success)o).mOutputData);
            }

            @Override  // androidx.work.ListenableWorker$Result
            public Data getOutputData() {
                return this.mOutputData;
            }

            @Override
            public int hashCode() {
                return this.mOutputData.hashCode() - 0x6FDE0E09;
            }

            @Override
            public String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }
        }

        public static Result failure() {
            return new Failure();
        }

        public static Result failure(Data outputData) {
            return new Failure(outputData);
        }

        public abstract Data getOutputData();

        public static Result retry() {
            return new Retry();
        }

        public static Result success() {
            return new Success();
        }

        public static Result success(Data outputData) {
            return new Success(outputData);
        }
    }

    private Context mAppContext;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public ListenableWorker(Context appContext, WorkerParameters workerParams) {
        if(appContext == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if(workerParams == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = appContext;
        this.mWorkerParams = workerParams;
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.getBackgroundExecutor();
    }

    public ListenableFuture getForegroundInfoAsync() {
        ListenableFuture listenableFuture0 = SettableFuture.create();
        ((SettableFuture)listenableFuture0).setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return listenableFuture0;
    }

    public final UUID getId() {
        return this.mWorkerParams.getId();
    }

    public final Data getInputData() {
        return this.mWorkerParams.getInputData();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.getNetwork();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.getRunAttemptCount();
    }

    public final Set getTags() {
        return this.mWorkerParams.getTags();
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.getTaskExecutor();
    }

    public final List getTriggeredContentAuthorities() {
        return this.mWorkerParams.getTriggeredContentAuthorities();
    }

    public final List getTriggeredContentUris() {
        return this.mWorkerParams.getTriggeredContentUris();
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.getWorkerFactory();
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ListenableFuture setForegroundAsync(ForegroundInfo foregroundInfo) {
        return this.mWorkerParams.getForegroundUpdater().setForegroundAsync(this.getApplicationContext(), this.getId(), foregroundInfo);
    }

    public ListenableFuture setProgressAsync(Data data) {
        return this.mWorkerParams.getProgressUpdater().updateProgress(this.getApplicationContext(), this.getId(), data);
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture startWork();

    public final void stop() {
        this.mStopped = true;
        this.onStopped();
    }
}

