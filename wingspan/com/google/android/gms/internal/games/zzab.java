package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.zzj;

abstract class zzab extends zzj {
    private final String zza;

    public zzab(String s, GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
        this.zza = s;
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzaa(this, status0);
    }
}

