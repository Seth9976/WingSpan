package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public abstract class zzj extends ApiMethodImpl {
    public zzj(GoogleApiClient googleApiClient0) {
        super(Games.zza, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void setResult(Object object0) {
        super.setResult(((Result)object0));
    }
}

