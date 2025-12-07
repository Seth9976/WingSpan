package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzea extends zzau {
    private zzea(zzdp zzdp0, GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    zzea(zzdp zzdp0, GoogleApiClient googleApiClient0, zzdq zzdq0) {
        this(zzdp0, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public Result createFailedResult(Status status0) {
        return new zzdz(status0, null);
    }
}

