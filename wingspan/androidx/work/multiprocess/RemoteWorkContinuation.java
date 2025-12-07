package androidx.work.multiprocess;

import androidx.work.OneTimeWorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public abstract class RemoteWorkContinuation {
    public static RemoteWorkContinuation combine(List continuations) {
        return ((RemoteWorkContinuation)continuations.get(0)).combineInternal(continuations);
    }

    protected abstract RemoteWorkContinuation combineInternal(List arg1);

    public abstract ListenableFuture enqueue();

    public final RemoteWorkContinuation then(OneTimeWorkRequest work) {
        return this.then(Collections.singletonList(work));
    }

    public abstract RemoteWorkContinuation then(List arg1);
}

