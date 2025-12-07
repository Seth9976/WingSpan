package androidx.lifecycle;

public interface DefaultLifecycleObserver extends FullLifecycleObserver {
    @Override  // androidx.lifecycle.FullLifecycleObserver
    void onCreate(LifecycleOwner arg1);

    @Override  // androidx.lifecycle.FullLifecycleObserver
    void onDestroy(LifecycleOwner arg1);

    @Override  // androidx.lifecycle.FullLifecycleObserver
    void onPause(LifecycleOwner arg1);

    @Override  // androidx.lifecycle.FullLifecycleObserver
    void onResume(LifecycleOwner arg1);

    @Override  // androidx.lifecycle.FullLifecycleObserver
    void onStart(LifecycleOwner arg1);

    @Override  // androidx.lifecycle.FullLifecycleObserver
    void onStop(LifecycleOwner arg1);
}

