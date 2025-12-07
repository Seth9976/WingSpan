package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzj;

final class zzf extends zzj {
    final TaskCompletionSource zza;
    final zzi zzb;

    zzf(zzi zzi0, TaskCompletionSource taskCompletionSource0, TaskCompletionSource taskCompletionSource1) {
        this.zzb = zzi0;
        this.zza = taskCompletionSource1;
        super(taskCompletionSource0);
    }

    @Override  // com.google.android.play.core.review.internal.zzj
    protected final void zza() {
        try {
            IInterface iInterface0 = this.zzb.zza.zze();
            Bundle bundle0 = com.google.android.play.core.review.zzj.zza();
            ((com.google.android.play.core.review.internal.zzf)iInterface0).zzc(this.zzb.zzc, bundle0, new zzh(this.zzb, this.zza, this.zzb.zzc));
        }
        catch(RemoteException remoteException0) {
            zzi.zzb.zzc(remoteException0, "error requesting in-app review for %s", new Object[]{this.zzb.zzc});
            RuntimeException runtimeException0 = new RuntimeException(remoteException0);
            this.zza.trySetException(runtimeException0);
        }
    }
}

