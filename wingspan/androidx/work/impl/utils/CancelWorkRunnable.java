package androidx.work.impl.utils;

import androidx.work.Operation.State.FAILURE;
import androidx.work.Operation;
import androidx.work.WorkInfo.State;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;

public abstract class CancelWorkRunnable implements Runnable {
    private final OperationImpl mOperation;

    public CancelWorkRunnable() {
        this.mOperation = new OperationImpl();
    }

    void cancel(WorkManagerImpl workManagerImpl, String workSpecId) {
        this.iterativelyCancelWorkAndDependents(workManagerImpl.getWorkDatabase(), workSpecId);
        workManagerImpl.getProcessor().stopAndCancelWork(workSpecId);
        for(Object object0: workManagerImpl.getSchedulers()) {
            ((Scheduler)object0).cancel(workSpecId);
        }
    }

    public static CancelWorkRunnable forAll(WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            @Override  // androidx.work.impl.utils.CancelWorkRunnable
            void runInternal() {
                WorkDatabase workDatabase0 = workManagerImpl.getWorkDatabase();
                workDatabase0.beginTransaction();
                try {
                    for(Object object0: workDatabase0.workSpecDao().getAllUnfinishedWork()) {
                        this.cancel(workManagerImpl, ((String)object0));
                    }
                    new PreferenceUtils(workManagerImpl.getWorkDatabase()).setLastCancelAllTimeMillis(System.currentTimeMillis());
                    workDatabase0.setTransactionSuccessful();
                }
                finally {
                    workDatabase0.endTransaction();
                }
            }
        };
    }

    public static CancelWorkRunnable forId(UUID id, WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            @Override  // androidx.work.impl.utils.CancelWorkRunnable
            void runInternal() {
                WorkDatabase workDatabase0 = workManagerImpl.getWorkDatabase();
                workDatabase0.beginTransaction();
                try {
                    this.cancel(workManagerImpl, id.toString());
                    workDatabase0.setTransactionSuccessful();
                }
                finally {
                    workDatabase0.endTransaction();
                }
                this.reschedulePendingWorkers(workManagerImpl);
            }
        };
    }

    public static CancelWorkRunnable forName(String name, WorkManagerImpl workManagerImpl, boolean allowReschedule) {
        return new CancelWorkRunnable() {
            @Override  // androidx.work.impl.utils.CancelWorkRunnable
            void runInternal() {
                WorkDatabase workDatabase0 = workManagerImpl.getWorkDatabase();
                workDatabase0.beginTransaction();
                try {
                    for(Object object0: workDatabase0.workSpecDao().getUnfinishedWorkWithName(name)) {
                        this.cancel(workManagerImpl, ((String)object0));
                    }
                    workDatabase0.setTransactionSuccessful();
                }
                finally {
                    workDatabase0.endTransaction();
                }
                if(allowReschedule) {
                    this.reschedulePendingWorkers(workManagerImpl);
                }
            }
        };
    }

    public static CancelWorkRunnable forTag(String tag, WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() {
            @Override  // androidx.work.impl.utils.CancelWorkRunnable
            void runInternal() {
                WorkDatabase workDatabase0 = workManagerImpl.getWorkDatabase();
                workDatabase0.beginTransaction();
                try {
                    for(Object object0: workDatabase0.workSpecDao().getUnfinishedWorkWithTag(tag)) {
                        this.cancel(workManagerImpl, ((String)object0));
                    }
                    workDatabase0.setTransactionSuccessful();
                }
                finally {
                    workDatabase0.endTransaction();
                }
                this.reschedulePendingWorkers(workManagerImpl);
            }
        };
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String workSpecId) {
        WorkSpecDao workSpecDao0 = workDatabase.workSpecDao();
        DependencyDao dependencyDao0 = workDatabase.dependencyDao();
        LinkedList linkedList0 = new LinkedList();
        linkedList0.add(workSpecId);
        while(!linkedList0.isEmpty()) {
            String s1 = (String)linkedList0.remove();
            State workInfo$State0 = workSpecDao0.getState(s1);
            if(workInfo$State0 != State.SUCCEEDED && workInfo$State0 != State.FAILED) {
                workSpecDao0.setState(State.CANCELLED, s1);
            }
            linkedList0.addAll(dependencyDao0.getDependentWorkIds(s1));
        }
    }

    void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    @Override
    public void run() {
        try {
            this.runInternal();
            this.mOperation.markState(Operation.SUCCESS);
        }
        catch(Throwable throwable0) {
            FAILURE operation$State$FAILURE0 = new FAILURE(throwable0);
            this.mOperation.markState(operation$State$FAILURE0);
        }
    }

    abstract void runInternal();
}

