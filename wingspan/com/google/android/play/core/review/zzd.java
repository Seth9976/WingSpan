package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

public final class zzd implements ReviewManager {
    private final zzi zza;
    private final Handler zzb;

    zzd(zzi zzi0) {
        this.zzb = new Handler(Looper.getMainLooper());
        this.zza = zzi0;
    }

    @Override  // com.google.android.play.core.review.ReviewManager
    public final Task launchReviewFlow(Activity activity0, ReviewInfo reviewInfo0) {
        if(reviewInfo0.zzb()) {
            return Tasks.forResult(null);
        }
        Intent intent0 = new Intent(activity0, PlayCoreDialogWrapperActivity.class);
        intent0.putExtra("confirmation_intent", reviewInfo0.zza());
        intent0.putExtra("window_flags", activity0.getWindow().getDecorView().getWindowSystemUiVisibility());
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        intent0.putExtra("result_receiver", new zzc(this, this.zzb, taskCompletionSource0));
        activity0.startActivity(intent0);
        return taskCompletionSource0.getTask();
    }

    @Override  // com.google.android.play.core.review.ReviewManager
    public final Task requestReviewFlow() {
        return this.zza.zza();
    }
}

