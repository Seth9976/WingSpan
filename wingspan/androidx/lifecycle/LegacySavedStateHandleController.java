package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry.AutoRecreated;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

class LegacySavedStateHandleController {
    static final class OnRecreation implements AutoRecreated {
        @Override  // androidx.savedstate.SavedStateRegistry$AutoRecreated
        public void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner0) {
            if(!(savedStateRegistryOwner0 instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore0 = ((ViewModelStoreOwner)savedStateRegistryOwner0).getViewModelStore();
            SavedStateRegistry savedStateRegistry0 = savedStateRegistryOwner0.getSavedStateRegistry();
            for(Object object0: viewModelStore0.keys()) {
                LegacySavedStateHandleController.attachHandleIfNeeded(viewModelStore0.get(((String)object0)), savedStateRegistry0, savedStateRegistryOwner0.getLifecycle());
            }
            if(!viewModelStore0.keys().isEmpty()) {
                savedStateRegistry0.runOnNextRecreation(OnRecreation.class);
            }
        }
    }

    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    static void attachHandleIfNeeded(ViewModel viewModel0, SavedStateRegistry savedStateRegistry0, Lifecycle lifecycle0) {
        SavedStateHandleController savedStateHandleController0 = (SavedStateHandleController)viewModel0.getTag("androidx.lifecycle.savedstate.vm.tag");
        if(savedStateHandleController0 != null && !savedStateHandleController0.isAttached()) {
            savedStateHandleController0.attachToLifecycle(savedStateRegistry0, lifecycle0);
            LegacySavedStateHandleController.tryToAddRecreator(savedStateRegistry0, lifecycle0);
        }
    }

    static SavedStateHandleController create(SavedStateRegistry savedStateRegistry0, Lifecycle lifecycle0, String s, Bundle bundle0) {
        SavedStateHandleController savedStateHandleController0 = new SavedStateHandleController(s, SavedStateHandle.createHandle(savedStateRegistry0.consumeRestoredStateForKey(s), bundle0));
        savedStateHandleController0.attachToLifecycle(savedStateRegistry0, lifecycle0);
        LegacySavedStateHandleController.tryToAddRecreator(savedStateRegistry0, lifecycle0);
        return savedStateHandleController0;
    }

    private static void tryToAddRecreator(SavedStateRegistry savedStateRegistry0, Lifecycle lifecycle0) {
        State lifecycle$State0 = lifecycle0.getCurrentState();
        if(lifecycle$State0 != State.INITIALIZED && !lifecycle$State0.isAtLeast(State.STARTED)) {
            lifecycle0.addObserver(new LifecycleEventObserver() {
                @Override  // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
                    if(lifecycle$Event0 == Event.ON_START) {
                        lifecycle0.removeObserver(this);
                        savedStateRegistry0.runOnNextRecreation(OnRecreation.class);
                    }
                }
            });
            return;
        }
        savedStateRegistry0.runOnNextRecreation(OnRecreation.class);
    }
}

