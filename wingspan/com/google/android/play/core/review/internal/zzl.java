package com.google.android.play.core.review.internal;

import android.os.IBinder.DeathRecipient;

public final class zzl implements IBinder.DeathRecipient {
    public final zzt zza;

    public zzl(zzt zzt0) {
        this.zza = zzt0;
    }

    @Override  // android.os.IBinder$DeathRecipient
    public final void binderDied() {
        zzt.zzh(this.zza);
    }
}

