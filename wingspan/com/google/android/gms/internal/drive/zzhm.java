package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.TransferPreferencesBuilder;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhm extends zzhh {
    public zzhm(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfj zzfj0) throws RemoteException {
        this.zzay().setResult(new TransferPreferencesBuilder(zzfj0.zzas()).build());
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzga zzga0) throws RemoteException {
        this.zzay().setResult(zzga0.zzax());
    }
}

