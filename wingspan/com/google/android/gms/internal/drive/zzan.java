package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.drive.DriveId;

final class zzan extends zzl {
    private final ResultHolder zzdx;

    public zzan(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzao zzao0 = new zzao(status0, null);
        this.zzdx.setResult(zzao0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfn zzfn0) throws RemoteException {
        zzao zzao0 = new zzao(Status.RESULT_SUCCESS, zzfn0.zzdd);
        this.zzdx.setResult(zzao0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfy zzfy0) throws RemoteException {
        DriveId driveId0 = new zzaa(zzfy0.zzdn).getDriveId();
        zzao zzao0 = new zzao(Status.RESULT_SUCCESS, driveId0);
        this.zzdx.setResult(zzao0);
    }
}

