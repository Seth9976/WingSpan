package com.google.android.gms.location;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzaa implements Continuation {
    private final TaskCompletionSource zza;

    zzaa(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        TaskCompletionSource taskCompletionSource0 = this.zza;
        if(!task0.isSuccessful()) {
            if(task0.getException() == null) {
                taskCompletionSource0.trySetResult(null);
            }
            else {
                Exception exception0 = task0.getException();
                if(exception0 != null) {
                    taskCompletionSource0.setException(exception0);
                    return taskCompletionSource0.getTask();
                }
            }
        }
        return taskCompletionSource0.getTask();
    }
}

