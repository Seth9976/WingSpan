package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;

final class zzfb implements CaptureAvailableResult {
    final Status zza;

    zzfb(zzfd zzfd0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.video.Videos$CaptureAvailableResult
    public final boolean isAvailable() {
        return false;
    }
}

