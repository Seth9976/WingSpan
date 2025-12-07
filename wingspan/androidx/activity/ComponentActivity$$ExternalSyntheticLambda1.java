package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;

public final class ComponentActivity..ExternalSyntheticLambda1 implements SavedStateProvider {
    public final ComponentActivity f$0;

    public ComponentActivity..ExternalSyntheticLambda1(ComponentActivity componentActivity0) {
        this.f$0 = componentActivity0;
    }

    @Override  // androidx.savedstate.SavedStateRegistry$SavedStateProvider
    public final Bundle saveState() {
        return this.f$0.lambda$new$0$androidx-activity-ComponentActivity();
    }
}

