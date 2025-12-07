package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdk implements RemoteCall {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;

    public zzdk(String s, boolean z, boolean z1, int v) {
        this.zza = s;
        this.zzb = z;
        this.zzc = z1;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzB(this.zza, this.zzb, this.zzc, this.zzd));
    }
}

