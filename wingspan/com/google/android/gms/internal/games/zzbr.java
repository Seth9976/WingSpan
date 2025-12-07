package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbr implements RemoteCall {
    public final String zza;
    public final long zzb;

    public zzbr(String s, long v) {
        this.zza = s;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        TaskCompletionSource taskCompletionSource0 = (TaskCompletionSource)object1;
        ((zzbz)object0).zzaW(this.zza, this.zzb, null);
    }
}

