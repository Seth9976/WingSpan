package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {
    public static enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        private static State[] $values() [...] // Inlined contents

        public boolean isFinished() [...] // 潜在的解密器
    }

    private final int mGeneration;
    private UUID mId;
    private Data mOutputData;
    private Data mProgress;
    private int mRunAttemptCount;
    private State mState;
    private Set mTags;

    public WorkInfo(UUID id, State state, Data outputData, List tags, Data progress, int runAttemptCount, int generation) {
        this.mId = id;
        this.mState = state;
        this.mOutputData = outputData;
        this.mTags = new HashSet(tags);
        this.mProgress = progress;
        this.mRunAttemptCount = runAttemptCount;
        this.mGeneration = generation;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass() || this.mRunAttemptCount != ((WorkInfo)o).mRunAttemptCount) {
            return false;
        }
        if(this.mGeneration != ((WorkInfo)o).mGeneration) {
            return false;
        }
        if(!this.mId.equals(((WorkInfo)o).mId)) {
            return false;
        }
        if(this.mState != ((WorkInfo)o).mState) {
            return false;
        }
        if(!this.mOutputData.equals(((WorkInfo)o).mOutputData)) {
            return false;
        }
        return this.mTags.equals(((WorkInfo)o).mTags) ? this.mProgress.equals(((WorkInfo)o).mProgress) : false;
    }

    public int getGeneration() {
        return this.mGeneration;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getOutputData() {
        return this.mOutputData;
    }

    public Data getProgress() {
        return this.mProgress;
    }

    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    public State getState() {
        return this.mState;
    }

    public Set getTags() {
        return this.mTags;
    }

    @Override
    public int hashCode() {
        return (((((this.mId.hashCode() * 0x1F + this.mState.hashCode()) * 0x1F + this.mOutputData.hashCode()) * 0x1F + this.mTags.hashCode()) * 0x1F + this.mProgress.hashCode()) * 0x1F + this.mRunAttemptCount) * 0x1F + this.mGeneration;
    }

    @Override
    public String toString() {
        return "WorkInfo{mId=\'" + this.mId + "\', mState=" + this.mState + ", mOutputData=" + this.mOutputData + ", mTags=" + this.mTags + ", mProgress=" + this.mProgress + '}';
    }
}

