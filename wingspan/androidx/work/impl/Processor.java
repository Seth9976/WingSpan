package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Processor implements ExecutionListener, ForegroundProcessor {
    static class FutureListener implements Runnable {
        private ExecutionListener mExecutionListener;
        private ListenableFuture mFuture;
        private final WorkGenerationalId mWorkGenerationalId;

        FutureListener(ExecutionListener executionListener, WorkGenerationalId workGenerationalId, ListenableFuture future) {
            this.mExecutionListener = executionListener;
            this.mWorkGenerationalId = workGenerationalId;
            this.mFuture = future;
        }

        @Override
        public void run() {
            boolean z;
            try {
                z = ((Boolean)this.mFuture.get()).booleanValue();
            }
            catch(InterruptedException | ExecutionException unused_ex) {
                z = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkGenerationalId, z);
        }
    }

    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG;
    private Context mAppContext;
    private Set mCancelledIds;
    private Configuration mConfiguration;
    private Map mEnqueuedWorkMap;
    private PowerManager.WakeLock mForegroundLock;
    private Map mForegroundWorkMap;
    private final Object mLock;
    private final List mOuterListeners;
    private List mSchedulers;
    private WorkDatabase mWorkDatabase;
    private Map mWorkRuns;
    private TaskExecutor mWorkTaskExecutor;

    static {
        Processor.TAG = "WM-Processor";
    }

    public Processor(Context appContext, Configuration configuration, TaskExecutor workTaskExecutor, WorkDatabase workDatabase, List schedulers) {
        this.mAppContext = appContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mEnqueuedWorkMap = new HashMap();
        this.mForegroundWorkMap = new HashMap();
        this.mSchedulers = schedulers;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
        this.mWorkRuns = new HashMap();
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized(this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public WorkSpec getRunningWorkSpec(String workSpecId) {
        synchronized(this.mLock) {
            WorkerWrapper workerWrapper0 = (WorkerWrapper)this.mForegroundWorkMap.get(workSpecId);
            if(workerWrapper0 == null) {
                workerWrapper0 = (WorkerWrapper)this.mEnqueuedWorkMap.get(workSpecId);
            }
            return workerWrapper0 != null ? workerWrapper0.getWorkSpec() : null;
        }
    }

    public boolean hasWork() {
        synchronized(this.mLock) {
            return !this.mEnqueuedWorkMap.isEmpty() || !this.mForegroundWorkMap.isEmpty();
        }
    }

    private static boolean interrupt(String id, WorkerWrapper wrapper) {
        if(wrapper != null) {
            wrapper.interrupt();
            Logger.get().debug("WM-Processor", "WorkerWrapper interrupted for " + id);
            return true;
        }
        Logger.get().debug("WM-Processor", "WorkerWrapper could not be found for " + id);
        return false;
    }

    public boolean isCancelled(String id) {
        synchronized(this.mLock) {
        }
        return this.mCancelledIds.contains(id);
    }

    public boolean isEnqueued(String workSpecId) {
        synchronized(this.mLock) {
            return this.mEnqueuedWorkMap.containsKey(workSpecId) || this.mForegroundWorkMap.containsKey(workSpecId);
        }
    }

    @Override  // androidx.work.impl.foreground.ForegroundProcessor
    public boolean isEnqueuedInForeground(String workSpecId) {
        synchronized(this.mLock) {
        }
        return this.mForegroundWorkMap.containsKey(workSpecId);
    }

    // 检测为 Lambda 实现
    void lambda$runOnExecuted$1$androidx-work-impl-Processor(WorkGenerationalId workGenerationalId0, boolean z) [...]

    // 检测为 Lambda 实现
    WorkSpec lambda$startWork$0$androidx-work-impl-Processor(ArrayList arrayList0, String s) throws Exception [...]

    @Override  // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        synchronized(this.mLock) {
            WorkerWrapper workerWrapper0 = (WorkerWrapper)this.mEnqueuedWorkMap.get(id.getWorkSpecId());
            if(workerWrapper0 != null && id.equals(workerWrapper0.getWorkGenerationalId())) {
                this.mEnqueuedWorkMap.remove(id.getWorkSpecId());
            }
            Logger.get().debug("WM-Processor", this.getClass().getSimpleName() + " " + id.getWorkSpecId() + " executed; reschedule = " + needsReschedule);
            for(Object object1: this.mOuterListeners) {
                ((ExecutionListener)object1).onExecuted(id, needsReschedule);
            }
        }
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized(this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    private void runOnExecuted(WorkGenerationalId id, boolean needsReschedule) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(() -> this.onExecuted(id, needsReschedule));
    }

    @Override  // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String workSpecId, ForegroundInfo foregroundInfo) {
        synchronized(this.mLock) {
            Logger.get().info("WM-Processor", "Moving WorkSpec (" + workSpecId + ") to the foreground");
            WorkerWrapper workerWrapper0 = (WorkerWrapper)this.mEnqueuedWorkMap.remove(workSpecId);
            if(workerWrapper0 != null) {
                if(this.mForegroundLock == null) {
                    PowerManager.WakeLock powerManager$WakeLock0 = WakeLocks.newWakeLock(this.mAppContext, "ProcessorForegroundLck");
                    this.mForegroundLock = powerManager$WakeLock0;
                    powerManager$WakeLock0.acquire();
                }
                this.mForegroundWorkMap.put(workSpecId, workerWrapper0);
                Intent intent0 = SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, workerWrapper0.getWorkGenerationalId(), foregroundInfo);
                ContextCompat.startForegroundService(this.mAppContext, intent0);
            }
        }
    }

    public boolean startWork(StartStopToken id) {
        return this.startWork(id, null);
    }

    public boolean startWork(StartStopToken startStopToken, RuntimeExtras runtimeExtras) {
        WorkerWrapper workerWrapper0;
        WorkGenerationalId workGenerationalId0 = startStopToken.getId();
        String s = workGenerationalId0.getWorkSpecId();
        ArrayList arrayList0 = new ArrayList();
        WorkSpec workSpec0 = (WorkSpec)this.mWorkDatabase.runInTransaction(() -> {
            arrayList0.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(s));
            return this.mWorkDatabase.workSpecDao().getWorkSpec(s);
        });
        if(workSpec0 == null) {
            Logger.get().warning("WM-Processor", "Didn\'t find WorkSpec for id " + workGenerationalId0);
            this.runOnExecuted(workGenerationalId0, false);
            return false;
        }
        synchronized(this.mLock) {
            if(this.isEnqueued(s)) {
                Set set0 = (Set)this.mWorkRuns.get(s);
                Object object1 = set0.iterator().next();
                if(((StartStopToken)object1).getId().getGeneration() == workGenerationalId0.getGeneration()) {
                    set0.add(startStopToken);
                    Logger.get().debug("WM-Processor", "Work " + workGenerationalId0 + " is already enqueued for processing");
                }
                else {
                    this.runOnExecuted(workGenerationalId0, false);
                }
                return false;
            }
            if(workSpec0.getGeneration() != workGenerationalId0.getGeneration()) {
                this.runOnExecuted(workGenerationalId0, false);
                return false;
            }
            workerWrapper0 = new Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, workSpec0, arrayList0).withSchedulers(this.mSchedulers).withRuntimeExtras(runtimeExtras).build();
            ListenableFuture listenableFuture0 = workerWrapper0.getFuture();
            listenableFuture0.addListener(new FutureListener(this, startStopToken.getId(), listenableFuture0), this.mWorkTaskExecutor.getMainThreadExecutor());
            this.mEnqueuedWorkMap.put(s, workerWrapper0);
            HashSet hashSet0 = new HashSet();
            hashSet0.add(startStopToken);
            this.mWorkRuns.put(s, hashSet0);
        }
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(workerWrapper0);
        Logger.get().debug("WM-Processor", this.getClass().getSimpleName() + ": processing " + workGenerationalId0);
        return true;
    }

    public boolean stopAndCancelWork(String id) {
        WorkerWrapper workerWrapper0;
        synchronized(this.mLock) {
            Logger.get().debug("WM-Processor", "Processor cancelling " + id);
            this.mCancelledIds.add(id);
            workerWrapper0 = (WorkerWrapper)this.mForegroundWorkMap.remove(id);
            boolean z = workerWrapper0 != null;
            if(workerWrapper0 == null) {
                workerWrapper0 = (WorkerWrapper)this.mEnqueuedWorkMap.remove(id);
            }
            if(workerWrapper0 != null) {
                this.mWorkRuns.remove(id);
            }
        }
        boolean z1 = Processor.interrupt(id, workerWrapper0);
        if(z) {
            this.stopForegroundService();
        }
        return z1;
    }

    @Override  // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(String workSpecId) {
        synchronized(this.mLock) {
            this.mForegroundWorkMap.remove(workSpecId);
            this.stopForegroundService();
        }
    }

    private void stopForegroundService() {
        synchronized(this.mLock) {
            if(!this.mForegroundWorkMap.isEmpty() == 0) {
                Intent intent0 = SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext);
                try {
                    this.mAppContext.startService(intent0);
                }
                catch(Throwable throwable0) {
                    Logger.get().error("WM-Processor", "Unable to stop foreground service", throwable0);
                }
                PowerManager.WakeLock powerManager$WakeLock0 = this.mForegroundLock;
                if(powerManager$WakeLock0 != null) {
                    powerManager$WakeLock0.release();
                    this.mForegroundLock = null;
                }
            }
        }
    }

    public boolean stopForegroundWork(StartStopToken token) {
        WorkerWrapper workerWrapper0;
        String s = token.getId().getWorkSpecId();
        synchronized(this.mLock) {
            Logger.get().debug("WM-Processor", "Processor stopping foreground work " + s);
            workerWrapper0 = (WorkerWrapper)this.mForegroundWorkMap.remove(s);
            if(workerWrapper0 != null) {
                this.mWorkRuns.remove(s);
            }
        }
        return Processor.interrupt(s, workerWrapper0);
    }

    public boolean stopWork(StartStopToken runId) {
        String s = runId.getId().getWorkSpecId();
        synchronized(this.mLock) {
            WorkerWrapper workerWrapper0 = (WorkerWrapper)this.mEnqueuedWorkMap.remove(s);
            if(workerWrapper0 == null) {
                Logger.get().debug("WM-Processor", "WorkerWrapper could not be found for " + s);
                return false;
            }
            Set set0 = (Set)this.mWorkRuns.get(s);
            if(set0 != null && set0.contains(runId)) {
                Logger.get().debug("WM-Processor", "Processor stopping background work " + s);
                this.mWorkRuns.remove(s);
                return Processor.interrupt(s, workerWrapper0);
            }
            return false;
        }
    }
}

