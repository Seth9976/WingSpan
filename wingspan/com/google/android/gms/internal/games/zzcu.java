package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcu implements RemoteCall {
    public final String zza;
    public final boolean zzb;

    public zzcu(String s, boolean z) {
        this.zza = s;
        this.zzb = z;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaw(((TaskCompletionSource)object1), this.zza, this.zzb);
    }
}

