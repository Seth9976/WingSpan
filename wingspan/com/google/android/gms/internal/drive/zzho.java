package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzho extends zzhh {
    public zzho(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfv zzfv0) throws RemoteException {
        this.zzay().setResult(new MetadataBuffer(zzfv0.zzav()));
    }
}

