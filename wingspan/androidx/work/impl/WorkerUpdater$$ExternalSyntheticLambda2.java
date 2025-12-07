package androidx.work.impl;

import androidx.work.WorkRequest;
import kotlin.jvm.functions.Function0;

public final class WorkerUpdater..ExternalSyntheticLambda2 implements Runnable {
    public final WorkManagerImpl f$0;
    public final String f$1;
    public final OperationImpl f$2;
    public final Function0 f$3;
    public final WorkRequest f$4;

    public WorkerUpdater..ExternalSyntheticLambda2(WorkManagerImpl workManagerImpl0, String s, OperationImpl operationImpl0, Function0 function00, WorkRequest workRequest0) {
        this.f$0 = workManagerImpl0;
        this.f$1 = s;
        this.f$2 = operationImpl0;
        this.f$3 = function00;
        this.f$4 = workRequest0;
    }

    @Override
    public final void run() {
        WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

