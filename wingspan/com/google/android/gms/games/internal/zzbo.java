package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbo extends zza {
    final zzbz zza;
    private final TaskCompletionSource zzb;

    zzbo(zzbz zzbz0, TaskCompletionSource taskCompletionSource0) {
        this.zza = zzbz0;
        super();
        this.zzb = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzg(DataHolder dataHolder0) {
        this.zzm(dataHolder0);
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzm(DataHolder dataHolder0) {
        int v = dataHolder0.getStatusCode();
        if(v == 10003) {
            zzbz.zzL(this.zza, this.zzb);
            dataHolder0.close();
            return;
        }
        if(v != 0 && v != 3) {
            GamesStatusUtils.zza(this.zzb, v);
            dataHolder0.close();
            return;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(new PlayerBuffer(dataHolder0), v == 3);
        this.zzb.setResult(annotatedData0);
    }
}

