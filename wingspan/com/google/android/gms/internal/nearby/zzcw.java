package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzcw extends zzcv {
    private zzcw(GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    zzcw(GoogleApiClient googleApiClient0, zzcb zzcb0) {
        this(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public Result createFailedResult(Status status0) {
        return new zzcx(this, status0);
    }
}

