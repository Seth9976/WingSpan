package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbn implements RemoteCall {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;

    public zzbn(String s, int v, int v1, int v2, boolean z) {
        this.zza = s;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
        this.zze = z;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzay(((TaskCompletionSource)object1), this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}

