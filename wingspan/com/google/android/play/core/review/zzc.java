package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzc extends ResultReceiver {
    final TaskCompletionSource zza;

    zzc(zzd zzd0, Handler handler0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        this.zza.trySetResult(null);
    }
}

