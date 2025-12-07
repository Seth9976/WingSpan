package com.google.android.gms.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbt implements ResultHolder {
    private final TaskCompletionSource zza;

    public zzbt(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setFailedResult(Status status0) {
        ApiException apiException0 = new ApiException(status0);
        this.zza.setException(apiException0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setResult(Object object0) {
        Status status0 = ((LocationSettingsResult)object0).getStatus();
        if(status0.isSuccess()) {
            LocationSettingsResponse locationSettingsResponse0 = new LocationSettingsResponse(((LocationSettingsResult)object0));
            this.zza.setResult(locationSettingsResponse0);
            return;
        }
        if(status0.hasResolution()) {
            ResolvableApiException resolvableApiException0 = new ResolvableApiException(status0);
            this.zza.setException(resolvableApiException0);
            return;
        }
        ApiException apiException0 = new ApiException(status0);
        this.zza.setException(apiException0);
    }
}

