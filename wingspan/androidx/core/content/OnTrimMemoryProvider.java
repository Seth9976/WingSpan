package androidx.core.content;

import androidx.core.util.Consumer;

public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(Consumer arg1);

    void removeOnTrimMemoryListener(Consumer arg1);
}

