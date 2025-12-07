package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzce extends zzl {
    private final ResultHolder zzdx;
    private final zzcb zzfk;

    private zzce(zzcb zzcb0, ResultHolder baseImplementation$ResultHolder0) {
        this.zzfk = zzcb0;
        super();
        this.zzdx = baseImplementation$ResultHolder0;
    }

    zzce(zzcb zzcb0, ResultHolder baseImplementation$ResultHolder0, zzcc zzcc0) {
        this(zzcb0, baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzcf zzcf0 = new zzcf(this.zzfk, status0, null, null);
        this.zzdx.setResult(zzcf0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfj zzfj0) throws RemoteException {
        zzcf zzcf0 = new zzcf(this.zzfk, Status.RESULT_SUCCESS, zzfj0.zzhw, null);
        this.zzdx.setResult(zzcf0);
    }
}

