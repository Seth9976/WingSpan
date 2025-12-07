package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzak extends zzl {
    private final ResultHolder zzdx;

    zzak(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzal zzal0 = new zzal(status0, null);
        this.zzdx.setResult(zzal0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfh zzfh0) throws RemoteException {
        zzbi zzbi0 = new zzbi(zzfh0.zzes);
        zzal zzal0 = new zzal(Status.RESULT_SUCCESS, zzbi0);
        this.zzdx.setResult(zzal0);
    }
}

