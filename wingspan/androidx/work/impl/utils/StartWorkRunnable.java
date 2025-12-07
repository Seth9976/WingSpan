package androidx.work.impl.utils;

import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;

public class StartWorkRunnable implements Runnable {
    private RuntimeExtras mRuntimeExtras;
    private WorkManagerImpl mWorkManagerImpl;
    private StartStopToken mWorkSpecId;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, StartStopToken workSpecId, RuntimeExtras runtimeExtras) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = workSpecId;
        this.mRuntimeExtras = runtimeExtras;
    }

    @Override
    public void run() {
        this.mWorkManagerImpl.getProcessor().startWork(this.mWorkSpecId, this.mRuntimeExtras);
    }
}

