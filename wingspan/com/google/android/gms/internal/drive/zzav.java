package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class zzav extends zzau {
    public zzav(GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    protected Result createFailedResult(Status status0) {
        return status0;
    }
}

