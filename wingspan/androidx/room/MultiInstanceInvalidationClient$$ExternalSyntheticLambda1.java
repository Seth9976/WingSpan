package androidx.room;

public final class MultiInstanceInvalidationClient..ExternalSyntheticLambda1 implements Runnable {
    public final MultiInstanceInvalidationClient f$0;

    public MultiInstanceInvalidationClient..ExternalSyntheticLambda1(MultiInstanceInvalidationClient multiInstanceInvalidationClient0) {
        this.f$0 = multiInstanceInvalidationClient0;
    }

    @Override
    public final void run() {
        MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(this.f$0);
    }
}

