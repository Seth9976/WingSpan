package androidx.core.app;

import androidx.core.util.Consumer;

public interface OnMultiWindowModeChangedProvider {
    void addOnMultiWindowModeChangedListener(Consumer arg1);

    void removeOnMultiWindowModeChangedListener(Consumer arg1);
}

