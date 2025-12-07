package androidx.activity.contextaware;

import android.content.Context;

public interface ContextAware {
    void addOnContextAvailableListener(OnContextAvailableListener arg1);

    Context peekAvailableContext();

    void removeOnContextAvailableListener(OnContextAvailableListener arg1);
}

