package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.video.CaptureState;

final class zzk extends zzbr {
    zzk(ResultHolder baseImplementation$ResultHolder0) {
        super(baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zze(int v, Bundle bundle0) {
        this.zzw(new zzaf(new Status(v), CaptureState.zza(bundle0)));
    }
}

