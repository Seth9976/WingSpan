package com.google.android.gms.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzj implements ResultHolder {
    private final TaskCompletionSource zza;

    public zzj(TaskCompletionSource taskCompletionSource0) {
        Preconditions.checkNotNull(taskCompletionSource0);
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setFailedResult(Status status0) {
        if(status0 == null) {
            return;
        }
        ApiException apiException0 = new ApiException(status0);
        this.zza.setException(apiException0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final void setResult(Object object0) {
        TaskUtil.setResultOrApiException(((Status)object0), null, this.zza);
    }
}

