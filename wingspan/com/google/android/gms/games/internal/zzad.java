package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;

final class zzad implements CaptureAvailableResult {
    private final Status zza;
    private final boolean zzb;

    zzad(Status status0, boolean z) {
        this.zza = status0;
        this.zzb = z;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.video.Videos$CaptureAvailableResult
    public final boolean isAvailable() {
        return this.zzb;
    }
}

