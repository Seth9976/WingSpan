package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzag implements RemoteCall {
    public final boolean zza;
    public final String[] zzb;

    public zzag(boolean z, String[] arr_s) {
        this.zza = z;
        this.zzb = arr_s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzal(((TaskCompletionSource)object1), this.zza, this.zzb);
    }
}

