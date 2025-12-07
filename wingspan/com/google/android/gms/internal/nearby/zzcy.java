package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzcy extends zzcv {
    private zzcy(GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    zzcy(GoogleApiClient googleApiClient0, zzcb zzcb0) {
        this(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public Result createFailedResult(Status status0) {
        return status0;
    }
}

