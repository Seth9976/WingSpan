package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzk implements OnCompleteListener {
    public final zzt zza;
    public final TaskCompletionSource zzb;

    public zzk(zzt zzt0, TaskCompletionSource taskCompletionSource0) {
        this.zza = zzt0;
        this.zzb = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        this.zza.zzq(this.zzb, task0);
    }
}

