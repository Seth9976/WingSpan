package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkProgressUpdater implements ProgressUpdater {
    static final String TAG;
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    static {
        WorkProgressUpdater.TAG = "WM-WorkProgressUpdater";
    }

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.mWorkDatabase = workDatabase;
        this.mTaskExecutor = taskExecutor;
    }

    @Override  // androidx.work.ProgressUpdater
    public ListenableFuture updateProgress(Context context, UUID id, Data data) {
        ListenableFuture listenableFuture0 = SettableFuture.create();
        androidx.work.impl.utils.WorkProgressUpdater.1 workProgressUpdater$10 = new androidx.work.impl.utils.WorkProgressUpdater.1(this, id, data, ((SettableFuture)listenableFuture0));
        this.mTaskExecutor.executeOnTaskThread(workProgressUpdater$10);
        return listenableFuture0;
    }
}

