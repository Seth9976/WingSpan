package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.location.zzaa;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzal extends zzah {
    final TaskCompletionSource zza;

    zzal(FusedLocationProviderClient fusedLocationProviderClient0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaa0) throws RemoteException {
        Status status0 = zzaa0.getStatus();
        if(status0 == null) {
            ApiException apiException0 = new ApiException(new Status(8, "Got null status from location service"));
            this.zza.trySetException(apiException0);
            return;
        }
        if(status0.getStatusCode() == 0) {
            this.zza.setResult(Boolean.TRUE);
            return;
        }
        ApiException apiException1 = ApiExceptionUtil.fromStatus(status0);
        this.zza.trySetException(apiException1);
    }

    @Override  // com.google.android.gms.internal.location.zzai
    public final void zzc() {
    }
}

