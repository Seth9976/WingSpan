package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo.State;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler implements Scheduler {
    private static final String TAG;
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    static {
        SystemJobScheduler.TAG = "WM-SystemJobScheduler";
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManager) {
        this(context, workManager, ((JobScheduler)context.getSystemService("jobscheduler")), new SystemJobInfoConverter(context));
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManager, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.mContext = context;
        this.mWorkManager = workManager;
        this.mJobScheduler = jobScheduler;
        this.mSystemJobInfoConverter = systemJobInfoConverter;
    }

    @Override  // androidx.work.impl.Scheduler
    public void cancel(String workSpecId) {
        List list0 = SystemJobScheduler.getPendingJobIds(this.mContext, this.mJobScheduler, workSpecId);
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                SystemJobScheduler.cancelJobById(this.mJobScheduler, ((int)(((Integer)object0))));
            }
            this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(workSpecId);
        }
    }

    public static void cancelAll(Context context) {
        JobScheduler jobScheduler0 = (JobScheduler)context.getSystemService("jobscheduler");
        if(jobScheduler0 != null) {
            List list0 = SystemJobScheduler.getPendingJobs(context, jobScheduler0);
            if(list0 != null && !list0.isEmpty()) {
                for(Object object0: list0) {
                    SystemJobScheduler.cancelJobById(jobScheduler0, ((JobInfo)object0).getId());
                }
            }
        }
    }

    private static void cancelJobById(JobScheduler jobScheduler, int id) {
        try {
            jobScheduler.cancel(id);
        }
        catch(Throwable throwable0) {
            Logger.get().error("WM-SystemJobScheduler", String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", id), throwable0);
        }
    }

    private static List getPendingJobIds(Context context, JobScheduler jobScheduler, String workSpecId) {
        List list0 = SystemJobScheduler.getPendingJobs(context, jobScheduler);
        if(list0 == null) {
            return null;
        }
        List list1 = new ArrayList(2);
        for(Object object0: list0) {
            JobInfo jobInfo0 = (JobInfo)object0;
            WorkGenerationalId workGenerationalId0 = SystemJobScheduler.getWorkGenerationalIdFromJobInfo(jobInfo0);
            if(workGenerationalId0 != null && workSpecId.equals(workGenerationalId0.getWorkSpecId())) {
                list1.add(jobInfo0.getId());
            }
        }
        return list1;
    }

    private static List getPendingJobs(Context context, JobScheduler jobScheduler) {
        List list0;
        try {
            list0 = jobScheduler.getAllPendingJobs();
        }
        catch(Throwable throwable0) {
            Logger.get().error("WM-SystemJobScheduler", "getAllPendingJobs() is not reliable on this device.", throwable0);
            list0 = null;
        }
        if(list0 == null) {
            return null;
        }
        List list1 = new ArrayList(list0.size());
        ComponentName componentName0 = new ComponentName(context, SystemJobService.class);
        for(Object object0: list0) {
            JobInfo jobInfo0 = (JobInfo)object0;
            if(componentName0.equals(jobInfo0.getService())) {
                list1.add(jobInfo0);
            }
        }
        return list1;
    }

    private static WorkGenerationalId getWorkGenerationalIdFromJobInfo(JobInfo jobInfo) {
        PersistableBundle persistableBundle0 = jobInfo.getExtras();
        if(persistableBundle0 != null) {
            try {
                if(persistableBundle0.containsKey("EXTRA_WORK_SPEC_ID")) {
                    int v = persistableBundle0.getInt("EXTRA_WORK_SPEC_GENERATION", 0);
                    return new WorkGenerationalId(persistableBundle0.getString("EXTRA_WORK_SPEC_ID"), v);
                }
                return null;
            }
            catch(NullPointerException unused_ex) {
            }
        }
        return null;
    }

    @Override  // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public static boolean reconcileJobs(Context context, WorkManagerImpl workManager) {
        JobScheduler jobScheduler0 = (JobScheduler)context.getSystemService("jobscheduler");
        List list0 = SystemJobScheduler.getPendingJobs(context, jobScheduler0);
        List list1 = workManager.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean z = false;
        HashSet hashSet0 = new HashSet((list0 == null ? 0 : list0.size()));
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                JobInfo jobInfo0 = (JobInfo)object0;
                WorkGenerationalId workGenerationalId0 = SystemJobScheduler.getWorkGenerationalIdFromJobInfo(jobInfo0);
                if(workGenerationalId0 == null) {
                    SystemJobScheduler.cancelJobById(jobScheduler0, jobInfo0.getId());
                }
                else {
                    hashSet0.add(workGenerationalId0.getWorkSpecId());
                }
            }
        }
        for(Object object1: list1) {
            if(!hashSet0.contains(((String)object1))) {
                Logger.get().debug("WM-SystemJobScheduler", "Reconciling jobs");
                z = true;
                break;
            }
            if(false) {
                break;
            }
        }
        if(z) {
            WorkDatabase workDatabase0 = workManager.getWorkDatabase();
            workDatabase0.beginTransaction();
            try {
                WorkSpecDao workSpecDao0 = workDatabase0.workSpecDao();
                for(Object object2: list1) {
                    workSpecDao0.markWorkSpecScheduled(((String)object2), -1L);
                }
                workDatabase0.setTransactionSuccessful();
                return true;
            }
            finally {
                workDatabase0.endTransaction();
            }
        }
        return false;
    }

    @Override  // androidx.work.impl.Scheduler
    public void schedule(WorkSpec[] workSpecs) {
        WorkDatabase workDatabase0 = this.mWorkManager.getWorkDatabase();
        IdGenerator idGenerator0 = new IdGenerator(workDatabase0);
        for(int v = 0; v < workSpecs.length; ++v) {
            WorkSpec workSpec0 = workSpecs[v];
            workDatabase0.beginTransaction();
            try {
                WorkSpec workSpec1 = workDatabase0.workSpecDao().getWorkSpec(workSpec0.id);
                if(workSpec1 == null) {
                    Logger.get().warning("WM-SystemJobScheduler", "Skipping scheduling " + workSpec0.id + " because it\'s no longer in the DB");
                }
                else if(workSpec1.state == State.ENQUEUED) {
                    WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(workSpec0);
                    SystemIdInfo systemIdInfo0 = workDatabase0.systemIdInfoDao().getSystemIdInfo(workGenerationalId0);
                    int v2 = systemIdInfo0 == null ? idGenerator0.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId()) : systemIdInfo0.systemId;
                    if(systemIdInfo0 == null) {
                        SystemIdInfo systemIdInfo1 = SystemIdInfoKt.systemIdInfo(workGenerationalId0, v2);
                        this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(systemIdInfo1);
                    }
                    this.scheduleInternal(workSpec0, v2);
                    if(Build.VERSION.SDK_INT == 23) {
                        List list0 = SystemJobScheduler.getPendingJobIds(this.mContext, this.mJobScheduler, workSpec0.id);
                        if(list0 != null) {
                            int v3 = list0.indexOf(v2);
                            if(v3 >= 0) {
                                list0.remove(v3);
                            }
                            this.scheduleInternal(workSpec0, (list0.isEmpty() ? idGenerator0.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId()) : ((int)(((Integer)list0.get(0))))));
                        }
                    }
                }
                else {
                    Logger.get().warning("WM-SystemJobScheduler", "Skipping scheduling " + workSpec0.id + " because it is no longer enqueued");
                }
                workDatabase0.setTransactionSuccessful();
            }
            finally {
                workDatabase0.endTransaction();
            }
        }
    }

    public void scheduleInternal(WorkSpec workSpec, int jobId) {
        JobInfo jobInfo0 = this.mSystemJobInfoConverter.convert(workSpec, jobId);
        Logger.get().debug("WM-SystemJobScheduler", "Scheduling work ID " + workSpec.id + "Job ID " + jobId);
        try {
            if(this.mJobScheduler.schedule(jobInfo0) == 0) {
                Logger.get().warning("WM-SystemJobScheduler", "Unable to schedule work ID " + workSpec.id);
                if(workSpec.expedited && workSpec.outOfQuotaPolicy == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.expedited = false;
                    Logger.get().debug("WM-SystemJobScheduler", String.format("Scheduling a non-expedited job (work ID %s)", workSpec.id));
                    this.scheduleInternal(workSpec, jobId);
                }
            }
        }
        catch(IllegalStateException illegalStateException0) {
            List list0 = SystemJobScheduler.getPendingJobs(this.mContext, this.mJobScheduler);
            String s = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", ((int)(list0 == null ? 0 : list0.size())), this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size(), this.mWorkManager.getConfiguration().getMaxSchedulerLimit());
            Logger.get().error("WM-SystemJobScheduler", s);
            IllegalStateException illegalStateException1 = new IllegalStateException(s, illegalStateException0);
            Consumer consumer0 = this.mWorkManager.getConfiguration().getSchedulingExceptionHandler();
            if(consumer0 == null) {
                throw illegalStateException1;
            }
            consumer0.accept(illegalStateException1);
        }
        catch(Throwable throwable0) {
            Logger.get().error("WM-SystemJobScheduler", "Unable to schedule " + workSpec, throwable0);
        }
    }
}

