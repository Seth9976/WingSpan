package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;

public class StopWorkRunnable implements Runnable {
    private static final String TAG;
    private final boolean mStopInForeground;
    private final StartStopToken mToken;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        StopWorkRunnable.TAG = "WM-StopWorkRunnable";
    }

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, StartStopToken startStopToken, boolean stopInForeground) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mToken = startStopToken;
        this.mStopInForeground = stopInForeground;
    }

    @Override
    public void run() {
        boolean z = this.mStopInForeground ? this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mToken) : this.mWorkManagerImpl.getProcessor().stopWork(this.mToken);
        Logger.get().debug("WM-StopWorkRunnable", "StopWorkRunnable for " + this.mToken.getId().getWorkSpecId() + "; Processor.stopWork = " + z);
    }
}

