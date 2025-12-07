package com.gameanalytics.sdk.utilities;

import java.util.concurrent.Callable;

public final class TaskRunner..ExternalSyntheticLambda0 implements Runnable {
    public final Callable f$0;
    public final Callback f$1;

    public TaskRunner..ExternalSyntheticLambda0(Callable callable0, Callback taskRunner$Callback0) {
        this.f$0 = callable0;
        this.f$1 = taskRunner$Callback0;
    }

    @Override
    public final void run() {
        TaskRunner.lambda$executeAsync$1(this.f$0, this.f$1);
    }
}

