package androidx.work.impl.utils;

import androidx.work.Operation.State.FAILURE;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

public class PruneWorkRunnable implements Runnable {
    private final OperationImpl mOperation;
    private final WorkManagerImpl mWorkManagerImpl;

    public PruneWorkRunnable(WorkManagerImpl workManagerImpl) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mOperation = new OperationImpl();
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    @Override
    public void run() {
        try {
            this.mWorkManagerImpl.getWorkDatabase().workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
            this.mOperation.markState(Operation.SUCCESS);
        }
        catch(Throwable throwable0) {
            FAILURE operation$State$FAILURE0 = new FAILURE(throwable0);
            this.mOperation.markState(operation$State$FAILURE0);
        }
    }
}

