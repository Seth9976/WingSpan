package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.internal.zzt;
import com.google.android.play.core.review.internal.zzw;

public final class zzi {
    zzt zza;
    private static final com.google.android.play.core.review.internal.zzi zzb;
    private final String zzc;

    static {
        zzi.zzb = new com.google.android.play.core.review.internal.zzi("ReviewService");
    }

    public zzi(Context context0) {
        this.zzc = "com.MonsterCouch.Wingspan";
        if(zzw.zza(context0)) {
            Intent intent0 = new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending");
            this.zza = new zzt(context0, zzi.zzb, "com.google.android.finsky.inappreviewservice.InAppReviewService", intent0, zze.zza, null, null);
        }
    }

    public final Task zza() {
        com.google.android.play.core.review.internal.zzi zzi0 = zzi.zzb;
        zzi0.zzd("requestInAppReview (%s)", new Object[]{this.zzc});
        if(this.zza == null) {
            zzi0.zzb("Play Store app is either not installed or not the official version", new Object[0]);
            return Tasks.forException(new ReviewException(-1));
        }
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        this.zza.zzp(new zzf(this, taskCompletionSource0, taskCompletionSource0), taskCompletionSource0);
        return taskCompletionSource0.getTask();
    }
}

