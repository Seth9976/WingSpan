package com.gameanalytics.sdk.utilities;

public final class TaskRunner..ExternalSyntheticLambda1 implements Runnable {
    public final Callback f$0;
    public final Object f$1;

    public TaskRunner..ExternalSyntheticLambda1(Callback taskRunner$Callback0, Object object0) {
        this.f$0 = taskRunner$Callback0;
        this.f$1 = object0;
    }

    @Override
    public final void run() {
        TaskRunner.lambda$executeAsync$0(this.f$0, this.f$1);
    }
}

