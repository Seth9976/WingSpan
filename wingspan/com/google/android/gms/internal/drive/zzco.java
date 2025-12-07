package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzco extends TaskApiCall {
    zzco(zzch zzch0) {
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        if(((zzaw)api$AnyClient0).zzaf() == null) {
            taskCompletionSource0.setException(new ApiException(new Status(10, "Drive#SCOPE_APPFOLDER must be requested")));
            return;
        }
        taskCompletionSource0.setResult(new zzbs(((zzaw)api$AnyClient0).zzaf()));
    }
}

