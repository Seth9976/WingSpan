package androidx.work.impl.background.systemalarm;

public final class DelayMetCommandHandler..ExternalSyntheticLambda1 implements Runnable {
    public final DelayMetCommandHandler f$0;

    public DelayMetCommandHandler..ExternalSyntheticLambda1(DelayMetCommandHandler delayMetCommandHandler0) {
        this.f$0 = delayMetCommandHandler0;
    }

    @Override
    public final void run() {
        this.f$0.startWork();
    }
}

