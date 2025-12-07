package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzh extends zzg {
    final String zzd;

    zzh(zzi zzi0, TaskCompletionSource taskCompletionSource0, String s) {
        super(zzi0, new com.google.android.play.core.review.internal.zzi("OnRequestInstallCallback"), taskCompletionSource0);
        this.zzd = s;
    }

    @Override  // com.google.android.play.core.review.zzg
    public final void zzb(Bundle bundle0) throws RemoteException {
        super.zzb(bundle0);
        PendingIntent pendingIntent0 = (PendingIntent)bundle0.get("confirmation_intent");
        boolean z = bundle0.getBoolean("is_review_no_op");
        this.zzb.trySetResult(new zza(pendingIntent0, z));
    }
}

