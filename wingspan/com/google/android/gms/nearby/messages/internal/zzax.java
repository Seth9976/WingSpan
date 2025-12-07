package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzax implements ResultHolder {
    private final TaskCompletionSource zzib;

    zzax(zzak zzak0, TaskCompletionSource taskCompletionSource0) {
        this.zzib = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setFailedResult(Status status0) {
        ApiException apiException0 = new ApiException(status0);
        this.zzib.setException(apiException0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setResult(Object object0) {
        this.zzib.setResult(null);
    }
}

