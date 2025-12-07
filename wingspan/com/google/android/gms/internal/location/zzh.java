package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

final class zzh implements zzbg {
    final zzi zza;

    zzh(zzi zzi0) {
        this.zza = zzi0;
        super();
    }

    public final zzam zza() throws DeadObjectException {
        return (zzam)this.zza.getService();
    }
}

