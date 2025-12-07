package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.video.VideoCapabilities;

final class zzj extends zzbr {
    zzj(ResultHolder baseImplementation$ResultHolder0) {
        super(baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzv(int v, VideoCapabilities videoCapabilities0) {
        this.zzw(new zzae(new Status(v), videoCapabilities0));
    }
}

