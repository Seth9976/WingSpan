package com.google.android.play.core.review.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class zzs implements ServiceConnection {
    final zzt zza;

    zzs(zzt zzt0, zzr zzr0) {
        this.zza = zzt0;
        super();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        zzt.zzf(this.zza).zzd("ServiceConnectionImpl.onServiceConnected(%s)", new Object[]{componentName0});
        zzp zzp0 = new zzp(this, iBinder0);
        this.zza.zzc().post(zzp0);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        zzt.zzf(this.zza).zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", new Object[]{componentName0});
        zzq zzq0 = new zzq(this);
        this.zza.zzc().post(zzq0);
    }
}

