package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcp extends RegisterListenerMethod {
    private final DriveResource zzfq;
    private final zzdi zzfr;

    zzcp(zzch zzch0, ListenerHolder listenerHolder0, DriveResource driveResource0, zzdi zzdi0) {
        this.zzfq = driveResource0;
        this.zzfr = zzdi0;
        super(listenerHolder0);
    }

    @Override  // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final void registerListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        ((zzeo)((zzaw)api$AnyClient0).getService()).zza(new zzj(1, this.zzfq.getDriveId()), this.zzfr.zzgh, null, new zzhr(taskCompletionSource0));
    }
}

