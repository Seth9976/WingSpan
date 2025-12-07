package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdm implements zzdg {
    private final zzfl zzgn;

    zzdm(zzfl zzfl0) {
        this.zzgn = zzfl0;
    }

    @Override  // com.google.android.gms.internal.drive.zzdg
    public final void accept(Object object0) {
        ((OpenFileCallback)object0).onProgress(this.zzgn.zzhy, this.zzgn.zzhz);
    }
}

