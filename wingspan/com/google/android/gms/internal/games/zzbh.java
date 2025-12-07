package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbh implements RemoteCall {
    public final String zza;
    public final int zzb;
    public final int zzc;

    public zzbh(String s, int v, int v1) {
        this.zza = s;
        this.zzb = v;
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((TaskCompletionSource)object1).setResult(((zzce)((zzbz)object0).getService()).zzk(this.zza, this.zzb, this.zzc));
    }
}

