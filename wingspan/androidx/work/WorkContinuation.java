package androidx.work;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public abstract class WorkContinuation {
    public static WorkContinuation combine(List continuations) {
        return ((WorkContinuation)continuations.get(0)).combineInternal(continuations);
    }

    protected abstract WorkContinuation combineInternal(List arg1);

    public abstract Operation enqueue();

    public abstract ListenableFuture getWorkInfos();

    public abstract LiveData getWorkInfosLiveData();

    public final WorkContinuation then(OneTimeWorkRequest work) {
        return this.then(Collections.singletonList(work));
    }

    public abstract WorkContinuation then(List arg1);
}

