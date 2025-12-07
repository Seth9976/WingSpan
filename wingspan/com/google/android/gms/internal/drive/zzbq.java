package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

final class zzbq implements Notifier {
    private final long zzfb;
    private final long zzfc;

    zzbq(zzbp zzbp0, long v, long v1) {
        this.zzfb = v;
        this.zzfc = v1;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        ((DownloadProgressListener)object0).onProgress(this.zzfb, this.zzfc);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void onNotifyListenerFailed() {
    }
}

