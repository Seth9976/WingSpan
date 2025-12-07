package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcw implements RemoteCall {
    public final String zza;
    public final int zzb;

    public zzcw(String s, int v) {
        this.zza = s;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaD(((TaskCompletionSource)object1), this.zza, this.zzb, true, false);
    }
}

