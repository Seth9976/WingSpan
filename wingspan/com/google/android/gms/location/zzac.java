package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzac implements Continuation {
    private final TaskCompletionSource zza;

    zzac(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        TaskCompletionSource taskCompletionSource0 = this.zza;
        if(task0.isSuccessful()) {
            taskCompletionSource0.trySetResult(((Location)task0.getResult()));
            return taskCompletionSource0.getTask();
        }
        Exception exception0 = task0.getException();
        if(exception0 != null) {
            taskCompletionSource0.setException(exception0);
        }
        return taskCompletionSource0.getTask();
    }
}

