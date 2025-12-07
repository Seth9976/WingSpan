package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzcg extends zzau {
    private final zzcb zzfk;

    public zzcg(zzcb zzcb0, GoogleApiClient googleApiClient0) {
        this.zzfk = zzcb0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    protected Result createFailedResult(Status status0) {
        return new zzcf(this.zzfk, status0, null, null);
    }
}

