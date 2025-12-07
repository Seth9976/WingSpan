package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzby implements ResultHolder {
    private final TaskCompletionSource zzcu;

    zzby(zzbd zzbd0, TaskCompletionSource taskCompletionSource0) {
        this.zzcu = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setFailedResult(Status status0) {
        ApiException apiException0 = new ApiException(status0);
        this.zzcu.setException(apiException0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setResult(Object object0) {
        this.zzcu.setResult(null);
    }
}

