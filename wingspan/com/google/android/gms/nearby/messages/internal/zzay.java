package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzay implements OnCompleteListener {
    private final TaskCompletionSource zzic;

    zzay(zzak zzak0, TaskCompletionSource taskCompletionSource0) {
        this.zzic = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        if(task0.isSuccessful()) {
            this.zzic.setResult(null);
            return;
        }
        Exception exception0 = task0.getException();
        this.zzic.setException(exception0);
    }
}

