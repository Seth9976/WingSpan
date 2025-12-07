package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Operation.State.FAILURE;
import androidx.work.Operation;
import androidx.work.WorkInfo.State;
import androidx.work.WorkManager.UpdateResult;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec.IdAndState;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AD\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0002\u001A\u001C\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0015H\u0007\u001A\u0014\u0010\u0016\u001A\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u000FH\u0002\u001A\u001A\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00010\u001A*\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0000¨\u0006\u001B"}, d2 = {"updateWorkImpl", "Landroidx/work/WorkManager$UpdateResult;", "processor", "Landroidx/work/impl/Processor;", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "configuration", "Landroidx/work/Configuration;", "schedulers", "", "Landroidx/work/impl/Scheduler;", "newWorkSpec", "Landroidx/work/impl/model/WorkSpec;", "tags", "", "", "enqueueUniquelyNamedPeriodic", "Landroidx/work/Operation;", "Landroidx/work/impl/WorkManagerImpl;", "name", "workRequest", "Landroidx/work/WorkRequest;", "failWorkTypeChanged", "", "Landroidx/work/impl/OperationImpl;", "message", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class WorkerUpdater {
    public static final Operation enqueueUniquelyNamedPeriodic(WorkManagerImpl workManagerImpl0, String s, WorkRequest workRequest0) {
        Intrinsics.checkNotNullParameter(workManagerImpl0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(workRequest0, "workRequest");
        OperationImpl operationImpl0 = new OperationImpl();
        androidx.work.impl.WorkerUpdater.enqueueUniquelyNamedPeriodic.enqueueNew.1 workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$10 = new Function0(workRequest0, workManagerImpl0, s, operationImpl0) {
            final String $name;
            final OperationImpl $operation;
            final WorkManagerImpl $this_enqueueUniquelyNamedPeriodic;
            final WorkRequest $workRequest;

            {
                this.$workRequest = workRequest0;
                this.$this_enqueueUniquelyNamedPeriodic = workManagerImpl0;
                this.$name = s;
                this.$operation = operationImpl0;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                this.invoke();
                return Unit.INSTANCE;
            }

            public final void invoke() {
                List list0 = CollectionsKt.listOf(this.$workRequest);
                new EnqueueRunnable(new WorkContinuationImpl(this.$this_enqueueUniquelyNamedPeriodic, this.$name, ExistingWorkPolicy.KEEP, list0), this.$operation).run();
            }
        };
        workManagerImpl0.getWorkTaskExecutor().getSerialTaskExecutor().execute(() -> {
            Intrinsics.checkNotNullParameter(workManagerImpl0, "$this_enqueueUniquelyNamedPeriodic");
            Intrinsics.checkNotNullParameter(s, "$name");
            Intrinsics.checkNotNullParameter(operationImpl0, "$operation");
            Intrinsics.checkNotNullParameter(workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$10, "$enqueueNew");
            Intrinsics.checkNotNullParameter(workRequest0, "$workRequest");
            WorkSpecDao workSpecDao0 = workManagerImpl0.getWorkDatabase().workSpecDao();
            List list0 = workSpecDao0.getWorkSpecIdAndStatesForName(s);
            if(list0.size() > 1) {
                WorkerUpdater.failWorkTypeChanged(operationImpl0, "Can\'t apply UPDATE policy to the chains of work.");
                return;
            }
            IdAndState workSpec$IdAndState0 = (IdAndState)CollectionsKt.firstOrNull(list0);
            if(workSpec$IdAndState0 == null) {
                workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$10.invoke();
                return;
            }
            WorkSpec workSpec0 = workSpecDao0.getWorkSpec(workSpec$IdAndState0.id);
            if(workSpec0 == null) {
                operationImpl0.markState(new FAILURE(new IllegalStateException("WorkSpec with " + workSpec$IdAndState0.id + ", that matches a name \"" + s + "\", wasn\'t found")));
                return;
            }
            if(!workSpec0.isPeriodic()) {
                WorkerUpdater.failWorkTypeChanged(operationImpl0, "Can\'t update OneTimeWorker to Periodic Worker. Update operation must preserve worker\'s type.");
                return;
            }
            if(workSpec$IdAndState0.state == State.CANCELLED) {
                workSpecDao0.delete(workSpec$IdAndState0.id);
                workerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$10.invoke();
                return;
            }
            WorkSpec workSpec1 = WorkSpec.copy$default(workRequest0.getWorkSpec(), workSpec$IdAndState0.id, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0xFFFFE, null);
            try {
                Processor processor0 = workManagerImpl0.getProcessor();
                Intrinsics.checkNotNullExpressionValue(processor0, "processor");
                WorkDatabase workDatabase0 = workManagerImpl0.getWorkDatabase();
                Intrinsics.checkNotNullExpressionValue(workDatabase0, "workDatabase");
                Configuration configuration0 = workManagerImpl0.getConfiguration();
                Intrinsics.checkNotNullExpressionValue(configuration0, "configuration");
                List list1 = workManagerImpl0.getSchedulers();
                Intrinsics.checkNotNullExpressionValue(list1, "schedulers");
                WorkerUpdater.updateWorkImpl(processor0, workDatabase0, configuration0, list1, workSpec1, workRequest0.getTags());
                operationImpl0.markState(Operation.SUCCESS);
            }
            catch(Throwable throwable0) {
                operationImpl0.markState(new FAILURE(throwable0));
            }
        });
        return operationImpl0;
    }

    // 检测为 Lambda 实现
    private static final void enqueueUniquelyNamedPeriodic$lambda$3(WorkManagerImpl workManagerImpl0, String s, OperationImpl operationImpl0, Function0 function00, WorkRequest workRequest0) [...]

    private static final void failWorkTypeChanged(OperationImpl operationImpl0, String s) {
        operationImpl0.markState(new FAILURE(new UnsupportedOperationException(s)));
    }

    private static final UpdateResult updateWorkImpl(Processor processor0, WorkDatabase workDatabase0, Configuration configuration0, List list0, WorkSpec workSpec0, Set set0) {
        String s = workSpec0.id;
        WorkSpec workSpec1 = workDatabase0.workSpecDao().getWorkSpec(s);
        if(workSpec1 == null) {
            throw new IllegalArgumentException("Worker with " + s + " doesn\'t exist");
        }
        if((workSpec1.isPeriodic() ^ workSpec0.isPeriodic()) != 0) {
            throw new UnsupportedOperationException("Can\'t update " + ((String)androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1.INSTANCE.invoke(workSpec1)) + " Worker to " + ((String)androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1.INSTANCE.invoke(workSpec0)) + " Worker. Update operation must preserve worker\'s type.");
        }
        boolean z = processor0.isEnqueued(s);
        if(!z) {
            for(Object object0: list0) {
                ((Scheduler)object0).cancel(s);
            }
        }
        workDatabase0.runInTransaction(() -> {
            Intrinsics.checkNotNullParameter(workDatabase0, "$workDatabase");
            Intrinsics.checkNotNullParameter(workSpec0, "$newWorkSpec");
            Intrinsics.checkNotNullParameter(workSpec1, "$oldWorkSpec");
            Intrinsics.checkNotNullParameter(list0, "$schedulers");
            Intrinsics.checkNotNullParameter(s, "$workSpecId");
            Intrinsics.checkNotNullParameter(set0, "$tags");
            WorkSpecDao workSpecDao0 = workDatabase0.workSpecDao();
            WorkTagDao workTagDao0 = workDatabase0.workTagDao();
            workSpecDao0.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(list0, WorkSpec.copy$default(workSpec0, null, workSpec1.state, null, null, null, null, 0L, 0L, 0L, null, workSpec1.runAttemptCount, null, 0L, workSpec1.lastEnqueueTime, 0L, 0L, false, null, 0, workSpec1.getGeneration() + 1, 0x7DBFD, null)));
            workTagDao0.deleteByWorkSpecId(s);
            workTagDao0.insertTags(s, set0);
            if(!z) {
                workSpecDao0.markWorkSpecScheduled(s, -1L);
                workDatabase0.workProgressDao().delete(s);
            }
        });
        if(!z) {
            Schedulers.schedule(configuration0, workDatabase0, list0);
        }
        return z ? UpdateResult.APPLIED_FOR_NEXT_RUN : UpdateResult.APPLIED_IMMEDIATELY;

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "spec", "Landroidx/work/impl/model/WorkSpec;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1 extends Lambda implements Function1 {
            public static final androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1 INSTANCE;

            static {
                androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1.INSTANCE = new androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1();
            }

            androidx.work.impl.WorkerUpdater.updateWorkImpl.type.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((WorkSpec)object0));
            }

            public final String invoke(WorkSpec workSpec0) {
                Intrinsics.checkNotNullParameter(workSpec0, "spec");
                return workSpec0.isPeriodic() ? "Periodic" : "OneTime";
            }
        }

    }

    public static final ListenableFuture updateWorkImpl(WorkManagerImpl workManagerImpl0, WorkRequest workRequest0) {
        Intrinsics.checkNotNullParameter(workManagerImpl0, "<this>");
        Intrinsics.checkNotNullParameter(workRequest0, "workRequest");
        SettableFuture settableFuture0 = SettableFuture.create();
        workManagerImpl0.getWorkTaskExecutor().getSerialTaskExecutor().execute(() -> {
            Intrinsics.checkNotNullParameter(workManagerImpl0, "$this_updateWorkImpl");
            Intrinsics.checkNotNullParameter(workRequest0, "$workRequest");
            if(settableFuture0.isCancelled()) {
                return;
            }
            try {
                Processor processor0 = workManagerImpl0.getProcessor();
                Intrinsics.checkNotNullExpressionValue(processor0, "processor");
                WorkDatabase workDatabase0 = workManagerImpl0.getWorkDatabase();
                Intrinsics.checkNotNullExpressionValue(workDatabase0, "workDatabase");
                Configuration configuration0 = workManagerImpl0.getConfiguration();
                Intrinsics.checkNotNullExpressionValue(configuration0, "configuration");
                List list0 = workManagerImpl0.getSchedulers();
                Intrinsics.checkNotNullExpressionValue(list0, "schedulers");
                settableFuture0.set(WorkerUpdater.updateWorkImpl(processor0, workDatabase0, configuration0, list0, workRequest0.getWorkSpec(), workRequest0.getTags()));
            }
            catch(Throwable throwable0) {
                settableFuture0.setException(throwable0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(settableFuture0, "future");
        return settableFuture0;
    }

    // 检测为 Lambda 实现
    private static final void updateWorkImpl$lambda$1(WorkDatabase workDatabase0, WorkSpec workSpec0, WorkSpec workSpec1, List list0, String s, Set set0, boolean z) [...]

    // 检测为 Lambda 实现
    private static final void updateWorkImpl$lambda$2(SettableFuture settableFuture0, WorkManagerImpl workManagerImpl0, WorkRequest workRequest0) [...]
}

