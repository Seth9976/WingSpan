package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdk extends zzl {
    private final zzch zzfw;
    private final ListenerToken zzgj;
    private final ListenerHolder zzgk;

    zzdk(zzch zzch0, ListenerToken listenerToken0, ListenerHolder listenerHolder0) {
        this.zzfw = zzch0;
        super();
        this.zzgj = listenerToken0;
        this.zzgk = listenerHolder0;
    }

    private final void zza(zzdg zzdg0) {
        zzdo zzdo0 = new zzdo(this, zzdg0);
        this.zzgk.notifyListener(zzdo0);
    }

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(Status status0) throws RemoteException {
        this.zza((OpenFileCallback openFileCallback0) -> {
            openFileCallback0.onError(ApiExceptionUtil.fromStatus(status0));
            this.zzfw.cancelOpenFileCallback(this.zzgj);
        });
    }

    // 检测为 Lambda 实现
    final void zza(Status status0, OpenFileCallback openFileCallback0) [...]

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfh zzfh0) throws RemoteException {
        this.zza((OpenFileCallback openFileCallback0) -> {
            openFileCallback0.onContents(new zzbi(zzfh0.zzes));
            this.zzfw.cancelOpenFileCallback(this.zzgj);
        });
    }

    // 检测为 Lambda 实现
    final void zza(zzfh zzfh0, OpenFileCallback openFileCallback0) [...]

    @Override  // com.google.android.gms.internal.drive.zzl
    public final void zza(zzfl zzfl0) throws RemoteException {
        this.zza(new zzdm(zzfl0));
    }
}

