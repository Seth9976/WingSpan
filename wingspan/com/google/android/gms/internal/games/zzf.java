package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzf implements RemoteCall {
    public final String zza;

    public zzf(String s) {
        this.zza = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        TaskCompletionSource taskCompletionSource0 = (TaskCompletionSource)object1;
        ((zzbz)object0).zzba(null, this.zza);
    }
}

