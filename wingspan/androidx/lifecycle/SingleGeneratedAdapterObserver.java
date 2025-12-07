package androidx.lifecycle;

class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    private final GeneratedAdapter mGeneratedAdapter;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter0) {
        this.mGeneratedAdapter = generatedAdapter0;
    }

    @Override  // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
        this.mGeneratedAdapter.callMethods(lifecycleOwner0, lifecycle$Event0, false, null);
        this.mGeneratedAdapter.callMethods(lifecycleOwner0, lifecycle$Event0, true, null);
    }
}

