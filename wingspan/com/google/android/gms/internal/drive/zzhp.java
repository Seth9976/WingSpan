package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhp extends zzhh {
    public zzhp(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfy zzfy0) throws RemoteException {
        this.zzay().setResult(new zzaa(zzfy0.zzaw()));
    }
}

