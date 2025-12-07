package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos.CaptureStateResult;

final class zzfh implements CaptureStateResult {
    final Status zza;

    zzfh(zzfj zzfj0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.video.Videos$CaptureStateResult
    public final CaptureState getCaptureState() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

