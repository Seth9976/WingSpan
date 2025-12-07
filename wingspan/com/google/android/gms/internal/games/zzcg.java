package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.zzj;

abstract class zzcg extends zzj {
    zzcg(GoogleApiClient googleApiClient0, zzcf zzcf0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzce(this, status0);
    }
}

