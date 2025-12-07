package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbo implements RemoteCall {
    public final String zza;
    public final long zzb;
    public final String zzc;

    public zzbo(String s, long v, String s1) {
        this.zza = s;
        this.zzb = v;
        this.zzc = s1;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaY(((TaskCompletionSource)object1), this.zza, this.zzb, this.zzc);
    }
}

