package androidx.work.impl;

import androidx.work.WorkRequest;
import androidx.work.impl.utils.futures.SettableFuture;

public final class WorkerUpdater..ExternalSyntheticLambda1 implements Runnable {
    public final SettableFuture f$0;
    public final WorkManagerImpl f$1;
    public final WorkRequest f$2;

    public WorkerUpdater..ExternalSyntheticLambda1(SettableFuture settableFuture0, WorkManagerImpl workManagerImpl0, WorkRequest workRequest0) {
        this.f$0 = settableFuture0;
        this.f$1 = workManagerImpl0;
        this.f$2 = workRequest0;
    }

    @Override
    public final void run() {
        WorkerUpdater.updateWorkImpl$lambda$2(this.f$0, this.f$1, this.f$2);
    }
}

