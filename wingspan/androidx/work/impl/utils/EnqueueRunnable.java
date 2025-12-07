package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation.State.FAILURE;
import androidx.work.Operation;
import androidx.work.WorkInfo.State;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec.IdAndState;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG;
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    static {
        EnqueueRunnable.TAG = "WM-EnqueueRunnable";
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuation) {
        this(workContinuation, new OperationImpl());
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuation, OperationImpl result) {
        this.mWorkContinuation = workContinuation;
        this.mOperation = result;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase0 = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase0.beginTransaction();
        try {
            boolean z = EnqueueRunnable.processContinuation(this.mWorkContinuation);
            workDatabase0.setTransactionSuccessful();
            return z;
        }
        finally {
            workDatabase0.endTransaction();
        }
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuation) {
        boolean z = EnqueueRunnable.enqueueWorkWithPrerequisites(workContinuation.getWorkManagerImpl(), workContinuation.getWork(), ((String[])WorkContinuationImpl.prerequisitesFor(workContinuation).toArray(new String[0])), workContinuation.getName(), workContinuation.getExistingWorkPolicy());
        workContinuation.markEnqueued();
        return z;
    }

    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, List workList, String[] prerequisiteIds, String name, ExistingWorkPolicy existingWorkPolicy) {
        boolean z4;
        boolean z2;
        boolean z1;
        int v2;
        long v = System.currentTimeMillis();
        WorkDatabase workDatabase0 = workManagerImpl.getWorkDatabase();
        boolean z = prerequisiteIds != null && prerequisiteIds.length > 0;
        if(z) {
            int v1 = prerequisiteIds.length;
            v2 = 1;
            z1 = false;
            z2 = false;
            for(int v3 = 0; v3 < v1; ++v3) {
                String s1 = prerequisiteIds[v3];
                WorkSpec workSpec0 = workDatabase0.workSpecDao().getWorkSpec(s1);
                if(workSpec0 == null) {
                    Logger.get().error("WM-EnqueueRunnable", "Prerequisite " + s1 + " doesn\'t exist; not enqueuing");
                    return false;
                }
                State workInfo$State0 = workSpec0.state;
                v2 &= (workInfo$State0 == State.SUCCEEDED ? 1 : 0);
                if(workInfo$State0 == State.FAILED) {
                    z2 = true;
                }
                else if(workInfo$State0 == State.CANCELLED) {
                    z1 = true;
                }
            }
        }
        else {
            v2 = 1;
            z1 = false;
            z2 = false;
        }
        boolean z3 = TextUtils.isEmpty(name);
        if(!z3 == 0 || z) {
            z4 = false;
        }
        else {
            List list1 = workDatabase0.workSpecDao().getWorkSpecIdAndStatesForName(name);
            if(list1.isEmpty()) {
                z4 = false;
            }
            else if(existingWorkPolicy != ExistingWorkPolicy.APPEND && existingWorkPolicy != ExistingWorkPolicy.APPEND_OR_REPLACE) {
                if(existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                    for(Object object0: list1) {
                        if(((IdAndState)object0).state == State.ENQUEUED || ((IdAndState)object0).state == State.RUNNING) {
                            return false;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                CancelWorkRunnable.forName(name, workManagerImpl, false).run();
                WorkSpecDao workSpecDao0 = workDatabase0.workSpecDao();
                for(Object object1: list1) {
                    workSpecDao0.delete(((IdAndState)object1).id);
                }
                z4 = true;
            }
            else {
                DependencyDao dependencyDao0 = workDatabase0.dependencyDao();
                List list2 = new ArrayList();
                for(Object object2: list1) {
                    IdAndState workSpec$IdAndState0 = (IdAndState)object2;
                    if(!dependencyDao0.hasDependents(workSpec$IdAndState0.id)) {
                        int v4 = workSpec$IdAndState0.state == State.SUCCEEDED ? 1 : 0;
                        if(workSpec$IdAndState0.state == State.FAILED) {
                            z2 = true;
                        }
                        else if(workSpec$IdAndState0.state == State.CANCELLED) {
                            z1 = true;
                        }
                        list2.add(workSpec$IdAndState0.id);
                        v2 &= v4;
                    }
                }
                if(existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE && (z1 || z2)) {
                    WorkSpecDao workSpecDao1 = workDatabase0.workSpecDao();
                    for(Object object3: workSpecDao1.getWorkSpecIdAndStatesForName(name)) {
                        workSpecDao1.delete(((IdAndState)object3).id);
                    }
                    list2 = Collections.emptyList();
                    z1 = false;
                    z2 = false;
                }
                prerequisiteIds = (String[])list2.toArray(prerequisiteIds);
                z = prerequisiteIds.length > 0;
                z4 = false;
            }
        }
        for(Object object4: workList) {
            WorkRequest workRequest0 = (WorkRequest)object4;
            WorkSpec workSpec1 = workRequest0.getWorkSpec();
            if(!z || v2 != 0) {
                workSpec1.lastEnqueueTime = v;
            }
            else if(z2) {
                workSpec1.state = State.FAILED;
            }
            else if(z1) {
                workSpec1.state = State.CANCELLED;
            }
            else {
                workSpec1.state = State.BLOCKED;
            }
            if(workSpec1.state == State.ENQUEUED) {
                z4 = true;
            }
            workDatabase0.workSpecDao().insertWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(workManagerImpl.getSchedulers(), workSpec1));
            if(z) {
                for(int v5 = 0; v5 < prerequisiteIds.length; ++v5) {
                    String s2 = prerequisiteIds[v5];
                    Dependency dependency0 = new Dependency(workRequest0.getStringId(), s2);
                    workDatabase0.dependencyDao().insertDependency(dependency0);
                }
            }
            workDatabase0.workTagDao().insertTags(workRequest0.getStringId(), workRequest0.getTags());
            if(!z3 != 0) {
                workDatabase0.workNameDao().insert(new WorkName(name, workRequest0.getStringId()));
            }
        }
        return z4;
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuation) {
        List list0 = workContinuation.getParents();
        boolean z = false;
        if(list0 != null) {
            for(Object object0: list0) {
                WorkContinuationImpl workContinuationImpl1 = (WorkContinuationImpl)object0;
                if(workContinuationImpl1.isEnqueued()) {
                    Logger.get().warning("WM-EnqueueRunnable", "Already enqueued work ids (" + TextUtils.join(", ", workContinuationImpl1.getIds()) + ")");
                }
                else {
                    z |= EnqueueRunnable.processContinuation(workContinuationImpl1);
                }
            }
        }
        return EnqueueRunnable.enqueueContinuation(workContinuation) | z;
    }

    @Override
    public void run() {
        try {
            if(this.mWorkContinuation.hasCycles()) {
                throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
            }
            if(this.addToDatabase()) {
                PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                this.scheduleWorkInBackground();
            }
            this.mOperation.markState(Operation.SUCCESS);
        }
        catch(Throwable throwable0) {
            FAILURE operation$State$FAILURE0 = new FAILURE(throwable0);
            this.mOperation.markState(operation$State$FAILURE0);
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl0 = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl0.getConfiguration(), workManagerImpl0.getWorkDatabase(), workManagerImpl0.getSchedulers());
    }
}

