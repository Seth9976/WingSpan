package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbs implements RemoteCall {
    private final LocationSettingsRequest zza;

    zzbs(LocationSettingsRequest locationSettingsRequest0) {
        this.zza = locationSettingsRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbt zzbt0 = new zzbt(((TaskCompletionSource)object1));
        ((zzaz)object0).zzL(this.zza, zzbt0, null);
    }
}

