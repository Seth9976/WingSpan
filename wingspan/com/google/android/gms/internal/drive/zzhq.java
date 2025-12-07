package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzhq extends zzhh {
    public zzhq(TaskCompletionSource taskCompletionSource0) {
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void onSuccess() throws RemoteException {
        this.zzay().setResult(Boolean.TRUE);
    }
}

