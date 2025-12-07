package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdm implements RemoteCall {
    public final String zza;
    public final boolean zzb;
    public final int zzc;

    public zzdm(String s, boolean z, int v) {
        this.zza = s;
        this.zzb = z;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaJ(((TaskCompletionSource)object1), this.zza, this.zzb, this.zzc);
    }
}

