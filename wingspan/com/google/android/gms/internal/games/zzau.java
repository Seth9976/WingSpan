package com.google.android.gms.internal.games;

import android.view.View;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzau implements RemoteCall {
    public final View zza;

    public zzau(View view0) {
        this.zza = view0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaT(this.zza);
        ((TaskCompletionSource)object1).setResult(null);
    }
}

