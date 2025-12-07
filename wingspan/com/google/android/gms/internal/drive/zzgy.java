package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

public final class zzgy extends zzl {
    private final ResultHolder zzdx;

    public zzgy(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void onSuccess() throws RemoteException {
        this.zzdx.setResult(Status.RESULT_SUCCESS);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        this.zzdx.setResult(status0);
    }
}

