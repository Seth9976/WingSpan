package androidx.core.content;

import androidx.core.util.Consumer;

public interface OnConfigurationChangedProvider {
    void addOnConfigurationChangedListener(Consumer arg1);

    void removeOnConfigurationChangedListener(Consumer arg1);
}

