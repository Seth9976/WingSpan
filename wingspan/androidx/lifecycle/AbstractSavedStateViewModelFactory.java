package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory extends OnRequeryFactory implements Factory {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private Bundle mDefaultArgs;
    private Lifecycle mLifecycle;
    private SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory() {
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner0, Bundle bundle0) {
        this.mSavedStateRegistry = savedStateRegistryOwner0.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner0.getLifecycle();
        this.mDefaultArgs = bundle0;
    }

    private ViewModel create(String s, Class class0) {
        SavedStateHandleController savedStateHandleController0 = LegacySavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, s, this.mDefaultArgs);
        ViewModel viewModel0 = this.create(s, class0, savedStateHandleController0.getHandle());
        viewModel0.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController0);
        return viewModel0;
    }

    @Override  // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class class0) {
        String s = class0.getCanonicalName();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if(this.mLifecycle == null) {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        return this.create(s, class0);
    }

    @Override  // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class class0, CreationExtras creationExtras0) {
        String s = (String)creationExtras0.get(NewInstanceFactory.VIEW_MODEL_KEY);
        if(s == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        return this.mSavedStateRegistry == null ? this.create(s, class0, SavedStateHandleSupport.createSavedStateHandle(creationExtras0)) : this.create(s, class0);
    }

    protected abstract ViewModel create(String arg1, Class arg2, SavedStateHandle arg3);

    @Override  // androidx.lifecycle.ViewModelProvider$OnRequeryFactory
    public void onRequery(ViewModel viewModel0) {
        SavedStateRegistry savedStateRegistry0 = this.mSavedStateRegistry;
        if(savedStateRegistry0 != null) {
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel0, savedStateRegistry0, this.mLifecycle);
        }
    }
}

