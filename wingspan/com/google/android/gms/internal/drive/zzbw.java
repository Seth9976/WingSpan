package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzbw extends zzl {
    private final ResultHolder zzdx;

    public zzbw(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzbz zzbz0 = new zzbz(status0, null);
        this.zzdx.setResult(zzbz0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfn zzfn0) throws RemoteException {
        zzbs zzbs0 = new zzbs(zzfn0.zzdd);
        zzbz zzbz0 = new zzbz(Status.RESULT_SUCCESS, zzbs0);
        this.zzdx.setResult(zzbz0);
    }
}

