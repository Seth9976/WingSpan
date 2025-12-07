package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcv implements RemoteCall {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzcv(String s, String s1, String s2) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((TaskCompletionSource)object1).setResult(((zzce)((zzbz)object0).getService()).zzj(this.zza, this.zzb, this.zzc));
    }
}

