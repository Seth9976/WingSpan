package com.onesignal.core.internal.background.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.common.AndroidSupportV4Compat.ContextCompat;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.core.services.SyncJobService;
import com.onesignal.core.services.SyncService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/B#\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u00A2\u0006\u0002\u0010\u000BJ\b\u0010\u001B\u001A\u00020\u001CH\u0002J\b\u0010\u001D\u001A\u00020\u0011H\u0016J\b\u0010\u001E\u001A\u00020\u001CH\u0002J\b\u0010\u001F\u001A\u00020\u0011H\u0002J\b\u0010 \u001A\u00020\u0011H\u0003J\b\u0010!\u001A\u00020\u001CH\u0016J\b\u0010\"\u001A\u00020\u001CH\u0016J\u0011\u0010#\u001A\u00020\u001CH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010$J\b\u0010%\u001A\u00020\u001CH\u0002J\u0010\u0010&\u001A\u00020\u001C2\u0006\u0010\'\u001A\u00020\u0017H\u0002J\u0010\u0010(\u001A\u00020\u001C2\u0006\u0010\'\u001A\u00020\u0017H\u0002J\u0010\u0010)\u001A\u00020\u001C2\u0006\u0010\'\u001A\u00020\u0017H\u0003J\u0010\u0010*\u001A\u00020\u001C2\u0006\u0010\'\u001A\u00020\u0017H\u0002J\b\u0010+\u001A\u00020\u001CH\u0016J\b\u0010,\u001A\u00020-H\u0002J\b\u0010.\u001A\u00020\u0011H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u00020\u0011X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u00198\u0002X\u0083\u0004\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u0019X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00060"}, d2 = {"Lcom/onesignal/core/internal/background/impl/BackgroundManager;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "Lcom/onesignal/core/internal/background/IBackgroundManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_backgroundServices", "", "Lcom/onesignal/core/internal/background/IBackgroundService;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;Ljava/util/List;)V", "backgroundSyncJob", "Lkotlinx/coroutines/Job;", "lock", "", "needsJobReschedule", "", "getNeedsJobReschedule", "()Z", "setNeedsJobReschedule", "(Z)V", "nextScheduledSyncTimeMs", "", "syncServiceJobClass", "Ljava/lang/Class;", "syncServicePendingIntentClass", "cancelBackgroundSyncTask", "", "cancelRunBackgroundServices", "cancelSyncTask", "hasBootPermission", "isJobIdRunning", "onFocus", "onUnfocused", "runBackgroundServices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleBackground", "scheduleBackgroundSyncTask", "delayMs", "scheduleSyncServiceAsAlarm", "scheduleSyncServiceAsJob", "scheduleSyncTask", "start", "syncServicePendingIntent", "Landroid/app/PendingIntent;", "useJob", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BackgroundManager implements IApplicationLifecycleHandler, IBackgroundManager, IStartableService {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/background/impl/BackgroundManager$Companion;", "", "()V", "SYNC_TASK_ID", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int SYNC_TASK_ID = 2071862118;
    private final IApplicationService _applicationService;
    private final List _backgroundServices;
    private final ITime _time;
    private Job backgroundSyncJob;
    private final Object lock;
    private boolean needsJobReschedule;
    private long nextScheduledSyncTimeMs;
    private final Class syncServiceJobClass;
    private final Class syncServicePendingIntentClass;

    static {
        BackgroundManager.Companion = new Companion(null);
    }

    public BackgroundManager(IApplicationService iApplicationService0, ITime iTime0, List list0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        Intrinsics.checkNotNullParameter(list0, "_backgroundServices");
        super();
        this._applicationService = iApplicationService0;
        this._time = iTime0;
        this._backgroundServices = list0;
        this.lock = new Object();
        this.syncServiceJobClass = SyncJobService.class;
        this.syncServicePendingIntentClass = SyncService.class;
    }

    private final void cancelBackgroundSyncTask() {
        Logging.debug$default((this.getClass().getSimpleName() + " cancel background sync"), null, 2, null);
        synchronized(this.lock) {
            Object object0 = this._applicationService.getAppContext().getSystemService("jobscheduler");
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.app.job.JobScheduler");
            ((JobScheduler)object0).cancel(2071862118);
        }
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundManager
    public boolean cancelRunBackgroundServices() {
        Job job0 = this.backgroundSyncJob;
        if(job0 == null) {
            return false;
        }
        Intrinsics.checkNotNull(job0);
        if(!job0.isActive()) {
            return false;
        }
        Job job1 = this.backgroundSyncJob;
        Intrinsics.checkNotNull(job1);
        DefaultImpls.cancel$default(job1, null, 1, null);
        return true;
    }

    private final void cancelSyncTask() {
        synchronized(this.lock) {
            this.nextScheduledSyncTimeMs = 0L;
            this.cancelBackgroundSyncTask();
        }
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundManager
    public boolean getNeedsJobReschedule() {
        return this.needsJobReschedule;
    }

    private final boolean hasBootPermission() {
        Context context0 = this._applicationService.getAppContext();
        return ContextCompat.INSTANCE.checkSelfPermission(context0, "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    private final boolean isJobIdRunning() {
        Object object0 = this._applicationService.getAppContext().getSystemService("jobscheduler");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.app.job.JobScheduler");
        for(Object object1: ((JobScheduler)object0).getAllPendingJobs()) {
            if(((JobInfo)object1).getId() == 2071862118) {
                Job job0 = this.backgroundSyncJob;
                if(job0 != null) {
                    Intrinsics.checkNotNull(job0);
                    if(job0.isActive()) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        this.cancelSyncTask();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        this.scheduleBackground();
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundManager
    public Object runBackgroundServices(Continuation continuation0) {
        Object object0 = CoroutineScopeKt.coroutineScope(new Function2(null) {
            private Object L$0;
            int label;

            {
                BackgroundManager.this = backgroundManager0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                com.onesignal.core.internal.background.impl.BackgroundManager.runBackgroundServices.2 backgroundManager$runBackgroundServices$20 = new com.onesignal.core.internal.background.impl.BackgroundManager.runBackgroundServices.2(BackgroundManager.this, continuation0);
                backgroundManager$runBackgroundServices$20.L$0 = object0;
                return backgroundManager$runBackgroundServices$20;
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.core.internal.background.impl.BackgroundManager.runBackgroundServices.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                Logging.debug$default("OSBackground sync, calling initWithContext", null, 2, null);
                Job job0 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getUnconfined(), null, new Function2(null) {
                    Object L$0;
                    int label;

                    {
                        BackgroundManager.this = backgroundManager0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.core.internal.background.impl.BackgroundManager.runBackgroundServices.2.1(BackgroundManager.this, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.core.internal.background.impl.BackgroundManager.runBackgroundServices.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        Iterator iterator0;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                synchronized(BackgroundManager.this.lock) {
                                    BackgroundManager.this.nextScheduledSyncTimeMs = 0L;
                                }
                                iterator0 = BackgroundManager.this._backgroundServices.iterator();
                                break;
                            }
                            case 1: {
                                iterator0 = (Iterator)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        while(iterator0.hasNext()) {
                            Object object3 = iterator0.next();
                            this.L$0 = iterator0;
                            this.label = 1;
                            if(((IBackgroundService)object3).backgroundRun(this) == object1) {
                                return object1;
                            }
                            if(false) {
                                break;
                            }
                        }
                        BackgroundManager.this.scheduleBackground();
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                BackgroundManager.this.backgroundSyncJob = job0;
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final void scheduleBackground() {
        Long long0 = null;
        for(Object object0: this._backgroundServices) {
            Long long1 = ((IBackgroundService)object0).getScheduleBackgroundRunIn();
            if(long1 != null && (long0 == null || ((long)long1) < ((long)long0))) {
                long0 = long1;
            }
        }
        if(long0 != null) {
            this.scheduleSyncTask(((long)long0));
        }
    }

    private final void scheduleBackgroundSyncTask(long v) {
        synchronized(this.lock) {
            this.scheduleSyncServiceAsJob(v);
        }
    }

    private final void scheduleSyncServiceAsAlarm(long v) {
        Logging.verbose$default((this.getClass().getSimpleName() + " scheduleServiceSyncTask:atTime: " + v), null, 2, null);
        PendingIntent pendingIntent0 = this.syncServicePendingIntent();
        Object object0 = this._applicationService.getAppContext().getSystemService("alarm");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager)object0).set(0, this._time.getCurrentTimeMillis() + v, pendingIntent0);
    }

    private final void scheduleSyncServiceAsJob(long v) {
        Logging.debug$default(("OSBackgroundSync scheduleSyncServiceAsJob:atTime: " + v), null, 2, null);
        if(this.isJobIdRunning()) {
            Logging.verbose$default("OSBackgroundSync scheduleSyncServiceAsJob Scheduler already running!", null, 2, null);
            this.setNeedsJobReschedule(true);
            return;
        }
        Context context0 = this._applicationService.getAppContext();
        Intrinsics.checkNotNull(context0);
        Intrinsics.checkNotNull(this.syncServiceJobClass);
        JobInfo.Builder jobInfo$Builder0 = new JobInfo.Builder(2071862118, new ComponentName(context0, this.syncServiceJobClass));
        jobInfo$Builder0.setMinimumLatency(v).setRequiredNetworkType(1);
        if(this.hasBootPermission()) {
            jobInfo$Builder0.setPersisted(true);
        }
        Context context1 = this._applicationService.getAppContext();
        Intrinsics.checkNotNull(context1);
        Object object0 = context1.getSystemService("jobscheduler");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.app.job.JobScheduler");
        JobScheduler jobScheduler0 = (JobScheduler)object0;
        try {
            Logging.info$default(("OSBackgroundSync scheduleSyncServiceAsJob:result: " + jobScheduler0.schedule(jobInfo$Builder0.build())), null, 2, null);
        }
        catch(NullPointerException nullPointerException0) {
            Logging.error("scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", nullPointerException0);
        }
    }

    private final void scheduleSyncTask(long v) {
        synchronized(this.lock) {
            if(this.nextScheduledSyncTimeMs != 0L && this._time.getCurrentTimeMillis() + v > this.nextScheduledSyncTimeMs) {
                Logging.debug$default(("OSSyncService scheduleSyncTask already update scheduled nextScheduledSyncTimeMs: " + this.nextScheduledSyncTimeMs), null, 2, null);
                return;
            }
            if(v < 5000L) {
                v = 5000L;
            }
            this.scheduleBackgroundSyncTask(v);
            this.nextScheduledSyncTimeMs = this._time.getCurrentTimeMillis() + v;
        }
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundManager
    public void setNeedsJobReschedule(boolean z) {
        this.needsJobReschedule = z;
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._applicationService.addApplicationLifecycleHandler(this);
    }

    private final PendingIntent syncServicePendingIntent() {
        PendingIntent pendingIntent0 = PendingIntent.getService(this._applicationService.getAppContext(), 2071862118, new Intent(this._applicationService.getAppContext(), this.syncServicePendingIntentClass), 0xC000000);
        Intrinsics.checkNotNullExpressionValue(pendingIntent0, "getService(\n            …FLAG_IMMUTABLE,\n        )");
        return pendingIntent0;
    }

    private final boolean useJob() [...] // Inlined contents
}

