package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhi extends zzhh {
    public zzhi(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfh zzfh0) throws RemoteException {
        this.zzay().setResult(new zzbi(zzfh0.zzar()));
    }
}

