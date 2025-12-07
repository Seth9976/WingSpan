package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhr extends zzhh {
    public zzhr(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void onSuccess() throws RemoteException {
        TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, this.zzay());
    }
}

