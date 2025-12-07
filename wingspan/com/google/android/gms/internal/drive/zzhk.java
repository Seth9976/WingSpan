package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhk extends zzhh {
    public zzhk(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfn zzfn0) throws RemoteException {
        this.zzay().setResult(zzfn0.getDriveId().asDriveFolder());
    }
}

