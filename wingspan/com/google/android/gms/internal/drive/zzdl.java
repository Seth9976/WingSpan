package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdl implements zzdg {
    private final zzdk zzgl;
    private final Status zzgm;

    zzdl(zzdk zzdk0, Status status0) {
        this.zzgl = zzdk0;
        this.zzgm = status0;
    }

    @Override  // com.google.android.gms.internal.drive.zzdg
    public final void accept(Object object0) {
        this.zzgl.zza(this.zzgm, ((OpenFileCallback)object0));
    }
}

