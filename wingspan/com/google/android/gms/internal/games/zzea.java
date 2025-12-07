package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.zzj;

abstract class zzea extends zzj {
    zzea(GoogleApiClient googleApiClient0, zzdz zzdz0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzdy(this, status0);
    }
}

