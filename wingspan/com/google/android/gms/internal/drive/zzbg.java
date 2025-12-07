package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbg extends TaskApiCall {
    private final CreateFileActivityOptions zzer;

    zzbg(zzbb zzbb0, CreateFileActivityOptions createFileActivityOptions0) {
        this.zzer = createFileActivityOptions0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void doExecute(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzeo zzeo0 = (zzeo)((zzaw)api$AnyClient0).getService();
        this.zzer.zzde.zza(((zzaw)api$AnyClient0).getContext());
        taskCompletionSource0.setResult(zzeo0.zza(new zzu(this.zzer.zzde, ((int)this.zzer.zzdk), this.zzer.zzba, this.zzer.zzbd, this.zzer.zzdl)));
    }
}

