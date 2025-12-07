package androidx.work.impl.utils;

import androidx.work.impl.utils.futures.SettableFuture;

public final class WorkForegroundRunnable..ExternalSyntheticLambda0 implements Runnable {
    public final WorkForegroundRunnable f$0;
    public final SettableFuture f$1;

    public WorkForegroundRunnable..ExternalSyntheticLambda0(WorkForegroundRunnable workForegroundRunnable0, SettableFuture settableFuture0) {
        this.f$0 = workForegroundRunnable0;
        this.f$1 = settableFuture0;
    }

    @Override
    public final void run() {
        this.f$0.lambda$run$0$androidx-work-impl-utils-WorkForegroundRunnable(this.f$1);
    }
}

