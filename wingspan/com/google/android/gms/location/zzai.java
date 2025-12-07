package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzai implements RemoteCall {
    private final Location zza;

    zzai(Location location0) {
        this.zza = location0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzaz)object0).zzJ(this.zza);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

