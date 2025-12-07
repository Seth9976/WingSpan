package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.review.internal.zzi;
import com.google.android.play.core.review.internal.zzt;

class zzg extends com.google.android.play.core.review.internal.zzg {
    final zzi zza;
    final TaskCompletionSource zzb;
    final com.google.android.play.core.review.zzi zzc;

    zzg(com.google.android.play.core.review.zzi zzi0, zzi zzi1, TaskCompletionSource taskCompletionSource0) {
        this.zzc = zzi0;
        super();
        this.zza = zzi1;
        this.zzb = taskCompletionSource0;
    }

    @Override  // com.google.android.play.core.review.internal.zzh
    public void zzb(Bundle bundle0) throws RemoteException {
        zzt zzt0 = this.zzc.zza;
        if(zzt0 != null) {
            zzt0.zzr(this.zzb);
        }
        this.zza.zzd("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}

