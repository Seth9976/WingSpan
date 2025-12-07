package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

final class zzay extends zzan {
    private ResultHolder zza;

    public zzay(ResultHolder baseImplementation$ResultHolder0) {
        Preconditions.checkArgument(baseImplementation$ResultHolder0 != null, "listener can\'t be null.");
        this.zza = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.internal.location.zzao
    public final void zzb(LocationSettingsResult locationSettingsResult0) throws RemoteException {
        this.zza.setResult(locationSettingsResult0);
        this.zza = null;
    }
}

