package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.internal.ICancelToken.Stub;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcu extends RegisterListenerMethod {
    private final DriveFile zzfs;
    private final int zzft;
    private final zzg zzfu;
    private final ListenerHolder zzfv;
    private final zzch zzfw;

    zzcu(zzch zzch0, ListenerHolder listenerHolder0, DriveFile driveFile0, int v, zzg zzg0, ListenerHolder listenerHolder1) {
        this.zzfw = zzch0;
        this.zzfs = driveFile0;
        this.zzft = v;
        this.zzfu = zzg0;
        this.zzfv = listenerHolder1;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final void registerListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzgj zzgj0 = new zzgj(this.zzfs.getDriveId(), this.zzft, 0);
        ICancelToken iCancelToken0 = Stub.asInterface(((zzeo)((zzaw)api$AnyClient0).getService()).zza(zzgj0, new zzdk(this.zzfw, this.zzfu, this.zzfv)).zzgs);
        this.zzfu.setCancelToken(iCancelToken0);
        taskCompletionSource0.setResult(null);
    }
}

