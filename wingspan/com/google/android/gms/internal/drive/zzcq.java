package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcq extends UnregisterListenerMethod {
    private final DriveResource zzfq;
    private final zzdi zzfr;

    zzcq(zzch zzch0, ListenerKey listenerHolder$ListenerKey0, DriveResource driveResource0, zzdi zzdi0) {
        this.zzfq = driveResource0;
        this.zzfr = zzdi0;
        super(listenerHolder$ListenerKey0);
    }

    @Override  // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    protected final void unregisterListener(AnyClient api$AnyClient0, TaskCompletionSource taskCompletionSource0) throws RemoteException {
        zzeo zzeo0 = (zzeo)((zzaw)api$AnyClient0).getService();
        zzgs zzgs0 = new zzgs(this.zzfq.getDriveId(), 1);
        zzhq zzhq0 = new zzhq(taskCompletionSource0);
        zzeo0.zza(zzgs0, this.zzfr.zzgh, null, zzhq0);
    }
}

