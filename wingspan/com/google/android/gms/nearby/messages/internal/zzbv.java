package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.Nearby;

abstract class zzbv extends ApiMethodImpl {
    private final ListenerHolder zzir;

    public zzbv(GoogleApiClient googleApiClient0) {
        super(Nearby.MESSAGES_API, googleApiClient0);
        this.zzir = googleApiClient0.registerListener(this);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public Result createFailedResult(Status status0) {
        return status0;
    }

    final ListenerHolder zzah() {
        return this.zzir;
    }
}

