package androidx.work.impl.workers;

import com.google.common.util.concurrent.ListenableFuture;

public final class ConstraintTrackingWorker..ExternalSyntheticLambda1 implements Runnable {
    public final ConstraintTrackingWorker f$0;
    public final ListenableFuture f$1;

    public ConstraintTrackingWorker..ExternalSyntheticLambda1(ConstraintTrackingWorker constraintTrackingWorker0, ListenableFuture listenableFuture0) {
        this.f$0 = constraintTrackingWorker0;
        this.f$1 = listenableFuture0;
    }

    @Override
    public final void run() {
        ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$2(this.f$0, this.f$1);
    }
}

