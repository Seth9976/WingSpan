package androidx.work;

import android.net.Network;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {
    public static class RuntimeExtras {
        public Network network;
        public List triggeredContentAuthorities;
        public List triggeredContentUris;

        public RuntimeExtras() {
            this.triggeredContentAuthorities = Collections.emptyList();
            this.triggeredContentUris = Collections.emptyList();
        }
    }

    private Executor mBackgroundExecutor;
    private ForegroundUpdater mForegroundUpdater;
    private int mGeneration;
    private UUID mId;
    private Data mInputData;
    private ProgressUpdater mProgressUpdater;
    private int mRunAttemptCount;
    private RuntimeExtras mRuntimeExtras;
    private Set mTags;
    private TaskExecutor mWorkTaskExecutor;
    private WorkerFactory mWorkerFactory;

    public WorkerParameters(UUID id, Data inputData, Collection tags, RuntimeExtras runtimeExtras, int runAttemptCount, int generation, Executor backgroundExecutor, TaskExecutor workTaskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.mId = id;
        this.mInputData = inputData;
        this.mTags = new HashSet(tags);
        this.mRuntimeExtras = runtimeExtras;
        this.mRunAttemptCount = runAttemptCount;
        this.mGeneration = generation;
        this.mBackgroundExecutor = backgroundExecutor;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkerFactory = workerFactory;
        this.mProgressUpdater = progressUpdater;
        this.mForegroundUpdater = foregroundUpdater;
    }

    public Executor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    public ForegroundUpdater getForegroundUpdater() {
        return this.mForegroundUpdater;
    }

    public int getGeneration() {
        return this.mGeneration;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getInputData() {
        return this.mInputData;
    }

    public Network getNetwork() {
        return this.mRuntimeExtras.network;
    }

    public ProgressUpdater getProgressUpdater() {
        return this.mProgressUpdater;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public RuntimeExtras getRuntimeExtras() {
        return this.mRuntimeExtras;
    }

    public Set getTags() {
        return this.mTags;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public List getTriggeredContentAuthorities() {
        return this.mRuntimeExtras.triggeredContentAuthorities;
    }

    public List getTriggeredContentUris() {
        return this.mRuntimeExtras.triggeredContentUris;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }
}

