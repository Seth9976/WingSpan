package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {
    private volatile Context mContext;
    private final Set mListeners;

    public ContextAwareHelper() {
        this.mListeners = new CopyOnWriteArraySet();
    }

    public void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener0) {
        if(this.mContext != null) {
            onContextAvailableListener0.onContextAvailable(this.mContext);
        }
        this.mListeners.add(onContextAvailableListener0);
    }

    public void clearAvailableContext() {
        this.mContext = null;
    }

    public void dispatchOnContextAvailable(Context context0) {
        this.mContext = context0;
        for(Object object0: this.mListeners) {
            ((OnContextAvailableListener)object0).onContextAvailable(context0);
        }
    }

    public Context peekAvailableContext() {
        return this.mContext;
    }

    public void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener0) {
        this.mListeners.remove(onContextAvailableListener0);
    }
}

