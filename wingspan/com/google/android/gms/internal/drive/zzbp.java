package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

final class zzbp implements DownloadProgressListener {
    private final ListenerHolder zzfa;

    public zzbp(ListenerHolder listenerHolder0) {
        this.zzfa = listenerHolder0;
    }

    @Override  // com.google.android.gms.drive.DriveFile$DownloadProgressListener
    public final void onProgress(long v, long v1) {
        zzbq zzbq0 = new zzbq(this, v, v1);
        this.zzfa.notifyListener(zzbq0);
    }
}

