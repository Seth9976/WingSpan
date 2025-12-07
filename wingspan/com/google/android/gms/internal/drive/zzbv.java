package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzbv extends zzl {
    private final ResultHolder zzdx;

    public zzbv(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzbx zzbx0 = new zzbx(status0, null);
        this.zzdx.setResult(zzbx0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfn zzfn0) throws RemoteException {
        zzbn zzbn0 = new zzbn(zzfn0.zzdd);
        zzbx zzbx0 = new zzbx(Status.RESULT_SUCCESS, zzbn0);
        this.zzdx.setResult(zzbx0);
    }
}

