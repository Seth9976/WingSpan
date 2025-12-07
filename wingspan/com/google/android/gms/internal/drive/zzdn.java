package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdn implements zzdg {
    private final zzdk zzgl;
    private final zzfh zzgo;

    zzdn(zzdk zzdk0, zzfh zzfh0) {
        this.zzgl = zzdk0;
        this.zzgo = zzfh0;
    }

    @Override  // com.google.android.gms.internal.drive.zzdg
    public final void accept(Object object0) {
        this.zzgl.zza(this.zzgo, ((OpenFileCallback)object0));
    }
}

