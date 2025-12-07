package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdq implements RemoteCall {
    public final Snapshot zza;

    public zzdq(Snapshot snapshot0) {
        this.zza = snapshot0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzS(this.zza);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

