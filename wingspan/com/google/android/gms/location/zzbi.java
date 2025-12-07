package com.google.android.gms.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public abstract class zzbi extends ApiMethodImpl {
    public zzbi(GoogleApiClient googleApiClient0) {
        super(LocationServices.API, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void setResult(Object object0) {
        super.setResult(((Result)object0));
    }
}

