package androidx.work.impl;

import com.google.common.util.concurrent.ListenableFuture;

public final class WorkerWrapper..ExternalSyntheticLambda0 implements Runnable {
    public final WorkerWrapper f$0;
    public final ListenableFuture f$1;

    public WorkerWrapper..ExternalSyntheticLambda0(WorkerWrapper workerWrapper0, ListenableFuture listenableFuture0) {
        this.f$0 = workerWrapper0;
        this.f$1 = listenableFuture0;
    }

    @Override
    public final void run() {
        this.f$0.lambda$runWorker$0$androidx-work-impl-WorkerWrapper(this.f$1);
    }
}

