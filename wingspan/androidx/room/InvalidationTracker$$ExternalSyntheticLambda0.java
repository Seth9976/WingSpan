package androidx.room;

public final class InvalidationTracker..ExternalSyntheticLambda0 implements Runnable {
    public final InvalidationTracker f$0;

    public InvalidationTracker..ExternalSyntheticLambda0(InvalidationTracker invalidationTracker0) {
        this.f$0 = invalidationTracker0;
    }

    @Override
    public final void run() {
        this.f$0.onAutoCloseCallback$room_runtime_release();
    }
}

