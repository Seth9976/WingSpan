package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zze extends zzf {
    final PendingIntent zza;

    zze(zzg zzg0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzaz)api$AnyClient0).zzt(this.zza);
        this.setResult(Status.RESULT_SUCCESS);
    }
}

