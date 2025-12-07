package androidx.work.impl.foreground;

import androidx.work.ForegroundInfo;

public interface ForegroundProcessor {
    boolean isEnqueuedInForeground(String arg1);

    void startForeground(String arg1, ForegroundInfo arg2);

    void stopForeground(String arg1);
}

