package androidx.savedstate;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final class SavedStateRegistry..ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final SavedStateRegistry f$0;

    public SavedStateRegistry..ExternalSyntheticLambda0(SavedStateRegistry savedStateRegistry0) {
        this.f$0 = savedStateRegistry0;
    }

    @Override  // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
        SavedStateRegistry.performAttach$lambda-4(this.f$0, lifecycleOwner0, lifecycle$Event0);
    }
}

