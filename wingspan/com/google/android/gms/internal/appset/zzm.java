package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.zza;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzm implements RemoteCall {
    public final zzp zza;

    public zzm(zzp zzp0) {
        this.zza = zzp0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzg)((zzd)object0).getService()).zzc(new zza(null, null), new zzo(this.zza, ((TaskCompletionSource)object1)));
    }
}

