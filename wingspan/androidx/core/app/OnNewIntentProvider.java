package androidx.core.app;

import androidx.core.util.Consumer;

public interface OnNewIntentProvider {
    void addOnNewIntentListener(Consumer arg1);

    void removeOnNewIntentListener(Consumer arg1);
}

