package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcp implements RemoteCall {
    public final String zza;
    public final int zzb;
    public final boolean zzc;

    public zzcp(String s, int v, boolean z) {
        this.zza = s;
        this.zzb = v;
        this.zzc = z;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaD(((TaskCompletionSource)object1), this.zza, this.zzb, false, this.zzc);
    }
}

