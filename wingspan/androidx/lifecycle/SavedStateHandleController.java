package androidx.lifecycle;

import androidx.savedstate.SavedStateRegistry;

final class SavedStateHandleController implements LifecycleEventObserver {
    private final SavedStateHandle mHandle;
    private boolean mIsAttached;
    private final String mKey;

    SavedStateHandleController(String s, SavedStateHandle savedStateHandle0) {
        this.mIsAttached = false;
        this.mKey = s;
        this.mHandle = savedStateHandle0;
    }

    void attachToLifecycle(SavedStateRegistry savedStateRegistry0, Lifecycle lifecycle0) {
        if(this.mIsAttached) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.mIsAttached = true;
        lifecycle0.addObserver(this);
        savedStateRegistry0.registerSavedStateProvider(this.mKey, this.mHandle.savedStateProvider());
    }

    SavedStateHandle getHandle() {
        return this.mHandle;
    }

    boolean isAttached() {
        return this.mIsAttached;
    }

    @Override  // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
        if(lifecycle$Event0 == Event.ON_DESTROY) {
            this.mIsAttached = false;
            lifecycleOwner0.getLifecycle().removeObserver(this);
        }
    }
}

