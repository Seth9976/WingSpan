package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG;
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    static {
        WorkForegroundUpdater.TAG = "WM-WMFgUpdater";
    }

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.mForegroundProcessor = foregroundProcessor;
        this.mTaskExecutor = taskExecutor;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }

    @Override  // androidx.work.ForegroundUpdater
    public ListenableFuture setForegroundAsync(Context context, UUID id, ForegroundInfo foregroundInfo) {
        ListenableFuture listenableFuture0 = SettableFuture.create();
        androidx.work.impl.utils.WorkForegroundUpdater.1 workForegroundUpdater$10 = new androidx.work.impl.utils.WorkForegroundUpdater.1(this, ((SettableFuture)listenableFuture0), id, foregroundInfo, context);
        this.mTaskExecutor.executeOnTaskThread(workForegroundUpdater$10);
        return listenableFuture0;
    }
}

