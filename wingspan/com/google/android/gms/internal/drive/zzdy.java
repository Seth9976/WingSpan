package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzdy extends zzl {
    private final ResultHolder zzdx;

    public zzdy(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzdz zzdz0 = new zzdz(status0, null);
        this.zzdx.setResult(zzdz0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfy zzfy0) throws RemoteException {
        zzaa zzaa0 = new zzaa(zzfy0.zzdn);
        zzdz zzdz0 = new zzdz(Status.RESULT_SUCCESS, zzaa0);
        this.zzdx.setResult(zzdz0);
    }
}

