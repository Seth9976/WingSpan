package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.work.Logger;
import androidx.work.WorkerParameters.RuntimeExtras;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements ExecutionListener {
    static class Api24Impl {
        static String[] getTriggeredContentAuthorities(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        static Uri[] getTriggeredContentUris(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    static class Api28Impl {
        static Network getNetwork(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    private static final String TAG;
    private final Map mJobParameters;
    private final StartStopTokens mStartStopTokens;
    private WorkManagerImpl mWorkManagerImpl;

    static {
        SystemJobService.TAG = "WM-SystemJobService";
    }

    public SystemJobService() {
        this.mJobParameters = new HashMap();
        this.mStartStopTokens = new StartStopTokens();
    }

    @Override  // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImpl0 = WorkManagerImpl.getInstance(this.getApplicationContext());
            this.mWorkManagerImpl = workManagerImpl0;
            workManagerImpl0.getProcessor().addExecutionListener(this);
        }
        catch(IllegalStateException unused_ex) {
            Class class0 = this.getApplication().getClass();
            if(!Application.class.equals(class0)) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            Logger.get().warning("WM-SystemJobService", "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override  // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl0 = this.mWorkManagerImpl;
        if(workManagerImpl0 != null) {
            workManagerImpl0.getProcessor().removeExecutionListener(this);
        }
    }

    @Override  // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        JobParameters jobParameters0;
        Logger.get().debug("WM-SystemJobService", id.getWorkSpecId() + " executed on JobScheduler");
        synchronized(this.mJobParameters) {
            jobParameters0 = (JobParameters)this.mJobParameters.remove(id);
        }
        this.mStartStopTokens.remove(id);
        if(jobParameters0 != null) {
            this.jobFinished(jobParameters0, needsReschedule);
        }
    }

    @Override  // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        RuntimeExtras workerParameters$RuntimeExtras0;
        if(this.mWorkManagerImpl == null) {
            Logger.get().debug("WM-SystemJobService", "WorkManager is not initialized; requesting retry.");
            this.jobFinished(params, true);
            return false;
        }
        WorkGenerationalId workGenerationalId0 = SystemJobService.workGenerationalIdFromJobParameters(params);
        if(workGenerationalId0 == null) {
            Logger.get().error("WM-SystemJobService", "WorkSpec id not found!");
            return false;
        }
        synchronized(this.mJobParameters) {
            if(this.mJobParameters.containsKey(workGenerationalId0)) {
                Logger.get().debug("WM-SystemJobService", "Job is already being executed by SystemJobService: " + workGenerationalId0);
                return false;
            }
            Logger.get().debug("WM-SystemJobService", "onStartJob for " + workGenerationalId0);
            this.mJobParameters.put(workGenerationalId0, params);
        }
        if(Build.VERSION.SDK_INT >= 24) {
            workerParameters$RuntimeExtras0 = new RuntimeExtras();
            if(Api24Impl.getTriggeredContentUris(params) != null) {
                workerParameters$RuntimeExtras0.triggeredContentUris = Arrays.asList(Api24Impl.getTriggeredContentUris(params));
            }
            if(Api24Impl.getTriggeredContentAuthorities(params) != null) {
                workerParameters$RuntimeExtras0.triggeredContentAuthorities = Arrays.asList(Api24Impl.getTriggeredContentAuthorities(params));
            }
            if(Build.VERSION.SDK_INT >= 28) {
                workerParameters$RuntimeExtras0.network = Api28Impl.getNetwork(params);
            }
        }
        else {
            workerParameters$RuntimeExtras0 = null;
        }
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(workGenerationalId0), workerParameters$RuntimeExtras0);
        return true;
    }

    @Override  // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        if(this.mWorkManagerImpl == null) {
            Logger.get().debug("WM-SystemJobService", "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId workGenerationalId0 = SystemJobService.workGenerationalIdFromJobParameters(params);
        if(workGenerationalId0 == null) {
            Logger.get().error("WM-SystemJobService", "WorkSpec id not found!");
            return false;
        }
        Logger.get().debug("WM-SystemJobService", "onStopJob for " + workGenerationalId0);
        synchronized(this.mJobParameters) {
            this.mJobParameters.remove(workGenerationalId0);
        }
        StartStopToken startStopToken0 = this.mStartStopTokens.remove(workGenerationalId0);
        if(startStopToken0 != null) {
            this.mWorkManagerImpl.stopWork(startStopToken0);
        }
        return !this.mWorkManagerImpl.getProcessor().isCancelled(workGenerationalId0.getWorkSpecId());
    }

    private static WorkGenerationalId workGenerationalIdFromJobParameters(JobParameters parameters) {
        try {
            PersistableBundle persistableBundle0 = parameters.getExtras();
            return persistableBundle0 == null || !persistableBundle0.containsKey("EXTRA_WORK_SPEC_ID") ? null : new WorkGenerationalId(persistableBundle0.getString("EXTRA_WORK_SPEC_ID"), persistableBundle0.getInt("EXTRA_WORK_SPEC_GENERATION"));
        }
        catch(NullPointerException unused_ex) {
        }
        return null;
    }
}

