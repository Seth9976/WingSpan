package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

final class zzai extends zzap {
    private final String zzdw;

    zzai(zzaf zzaf0, GoogleApiClient googleApiClient0, String s) {
        this.zzdw = s;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzek(DriveId.zza(this.zzdw), false), new zzan(this));
    }
}

