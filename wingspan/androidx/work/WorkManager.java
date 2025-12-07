package androidx.work;

import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class WorkManager {
    public static enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN;

        private static UpdateResult[] $values() [...] // Inlined contents
    }

    public final WorkContinuation beginUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest work) {
        return this.beginUniqueWork(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    public abstract WorkContinuation beginUniqueWork(String arg1, ExistingWorkPolicy arg2, List arg3);

    public final WorkContinuation beginWith(OneTimeWorkRequest work) {
        return this.beginWith(Collections.singletonList(work));
    }

    public abstract WorkContinuation beginWith(List arg1);

    public abstract Operation cancelAllWork();

    public abstract Operation cancelAllWorkByTag(String arg1);

    public abstract Operation cancelUniqueWork(String arg1);

    public abstract Operation cancelWorkById(UUID arg1);

    public abstract PendingIntent createCancelPendingIntent(UUID arg1);

    public final Operation enqueue(WorkRequest workRequest) {
        return this.enqueue(Collections.singletonList(workRequest));
    }

    public abstract Operation enqueue(List arg1);

    public abstract Operation enqueueUniquePeriodicWork(String arg1, ExistingPeriodicWorkPolicy arg2, PeriodicWorkRequest arg3);

    public Operation enqueueUniqueWork(String uniqueWorkName, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest work) {
        return this.enqueueUniqueWork(uniqueWorkName, existingWorkPolicy, Collections.singletonList(work));
    }

    public abstract Operation enqueueUniqueWork(String arg1, ExistingWorkPolicy arg2, List arg3);

    public abstract Configuration getConfiguration();

    @Deprecated
    public static WorkManager getInstance() {
        WorkManager workManager0 = WorkManagerImpl.getInstance();
        if(workManager0 == null) {
            throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
        }
        return workManager0;
    }

    public static WorkManager getInstance(Context context) {
        return WorkManagerImpl.getInstance(context);
    }

    public abstract ListenableFuture getLastCancelAllTimeMillis();

    public abstract LiveData getLastCancelAllTimeMillisLiveData();

    public abstract ListenableFuture getWorkInfoById(UUID arg1);

    public abstract LiveData getWorkInfoByIdLiveData(UUID arg1);

    public abstract ListenableFuture getWorkInfos(WorkQuery arg1);

    public abstract ListenableFuture getWorkInfosByTag(String arg1);

    public abstract LiveData getWorkInfosByTagLiveData(String arg1);

    public abstract ListenableFuture getWorkInfosForUniqueWork(String arg1);

    public abstract LiveData getWorkInfosForUniqueWorkLiveData(String arg1);

    public abstract LiveData getWorkInfosLiveData(WorkQuery arg1);

    public static void initialize(Context context, Configuration configuration) {
        WorkManagerImpl.initialize(context, configuration);
    }

    public static boolean isInitialized() {
        return WorkManagerImpl.isInitialized();
    }

    public abstract Operation pruneWork();

    public abstract ListenableFuture updateWork(WorkRequest arg1);
}

