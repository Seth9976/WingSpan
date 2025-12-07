package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.List;

public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG;

    static {
        Schedulers.TAG = "WM-Schedulers";
    }

    static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkManagerImpl workManager) {
        Scheduler scheduler0 = new SystemJobScheduler(context, workManager);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger.get().debug("WM-Schedulers", "Created SystemJobScheduler and enabled SystemJobService");
        return scheduler0;
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List schedulers) {
        List list2;
        List list1;
        if(schedulers != null && schedulers.size() != 0) {
            WorkSpecDao workSpecDao0 = workDatabase.workSpecDao();
            workDatabase.beginTransaction();
            try {
                list1 = workSpecDao0.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());
                list2 = workSpecDao0.getAllEligibleWorkSpecsForScheduling(200);
                if(list1 != null && list1.size() > 0) {
                    long v1 = System.currentTimeMillis();
                    for(Object object0: list1) {
                        workSpecDao0.markWorkSpecScheduled(((WorkSpec)object0).id, v1);
                    }
                }
                workDatabase.setTransactionSuccessful();
            }
            finally {
                workDatabase.endTransaction();
            }
            if(list1 != null && list1.size() > 0) {
                WorkSpec[] arr_workSpec = (WorkSpec[])list1.toArray(new WorkSpec[list1.size()]);
                for(Object object1: schedulers) {
                    Scheduler scheduler0 = (Scheduler)object1;
                    if(scheduler0.hasLimitedSchedulingSlots()) {
                        scheduler0.schedule(arr_workSpec);
                    }
                }
            }
            if(list2 != null && list2.size() > 0) {
                WorkSpec[] arr_workSpec1 = (WorkSpec[])list2.toArray(new WorkSpec[list2.size()]);
                for(Object object2: schedulers) {
                    Scheduler scheduler1 = (Scheduler)object2;
                    if(!scheduler1.hasLimitedSchedulingSlots()) {
                        scheduler1.schedule(arr_workSpec1);
                    }
                }
            }
        }
    }

    private static Scheduler tryCreateGcmBasedScheduler(Context context) {
        try {
            Scheduler scheduler0 = (Scheduler)Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            Logger.get().debug("WM-Schedulers", "Created androidx.work.impl.background.gcm.GcmScheduler");
            return scheduler0;
        }
        catch(Throwable throwable0) {
            Logger.get().debug("WM-Schedulers", "Unable to create GCM Scheduler", throwable0);
            return null;
        }
    }
}

