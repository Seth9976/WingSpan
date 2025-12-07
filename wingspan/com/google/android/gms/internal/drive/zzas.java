package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.drive.MetadataBuffer;

final class zzas extends zzl {
    private final ResultHolder zzdx;

    zzas(ResultHolder baseImplementation$ResultHolder0) {
        this.zzdx = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        zzaq zzaq0 = new zzaq(status0, null, false);
        this.zzdx.setResult(zzaq0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzft zzft0) throws RemoteException {
        MetadataBuffer metadataBuffer0 = new MetadataBuffer(zzft0.zzii);
        zzaq zzaq0 = new zzaq(Status.RESULT_SUCCESS, metadataBuffer0, zzft0.zzea);
        this.zzdx.setResult(zzaq0);
    }
}

