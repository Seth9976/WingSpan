package androidx.lifecycle;

public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(LifecycleOwner arg1, Event arg2);
}

