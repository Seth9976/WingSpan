package com.onesignal.notifications.internal.restoration.impl;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker.Result;
import androidx.work.OneTimeWorkRequest.Builder;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000BB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0004H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager;", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "()V", "restored", "", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "shouldDelay", "Companion", "NotificationRestoreWorker", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationRestoreWorkManager implements INotificationRestoreWorkManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager$Companion;", "", "()V", "NOTIFICATION_RESTORE_WORKER_IDENTIFIER", "", "kotlin.jvm.PlatformType", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001A\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager$NotificationRestoreWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class NotificationRestoreWorker extends CoroutineWorker {
        public NotificationRestoreWorker(Context context0, WorkerParameters workerParameters0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(workerParameters0, "workerParams");
            super(context0, workerParameters0);
        }

        @Override  // androidx.work.CoroutineWorker
        public Object doWork(Continuation continuation0) {
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.doWork.1 notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10;
            if(continuation0 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.doWork.1) {
                notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.doWork.1)continuation0;
                if((notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10.label & 0x80000000) == 0) {
                    notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.doWork(this);
                        }
                    };
                }
                else {
                    notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10.label ^= 0x80000000;
                }
            }
            else {
                notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.doWork(this);
                    }
                };
            }
            Object object0 = notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10.result;
            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10.label) {
                case 0: {
                    ResultKt.throwOnFailure(object0);
                    Context context0 = this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(context0, "applicationContext");
                    if(!OneSignal.initWithContext(context0)) {
                        Result listenableWorker$Result0 = Result.success();
                        Intrinsics.checkNotNullExpressionValue(listenableWorker$Result0, "success()");
                        return listenableWorker$Result0;
                    }
                    if(!NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, context0, null, 2, null)) {
                        Result listenableWorker$Result1 = Result.failure();
                        Intrinsics.checkNotNullExpressionValue(listenableWorker$Result1, "failure()");
                        return listenableWorker$Result1;
                    }
                    INotificationRestoreProcessor iNotificationRestoreProcessor0 = (INotificationRestoreProcessor)OneSignal.INSTANCE.getServices().getService(INotificationRestoreProcessor.class);
                    notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10.label = 1;
                    if(iNotificationRestoreProcessor0.process(notificationRestoreWorkManager$NotificationRestoreWorker$doWork$10) == object1) {
                        return object1;
                    }
                    break;
                }
                case 1: {
                    ResultKt.throwOnFailure(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            Result listenableWorker$Result2 = Result.success();
            Intrinsics.checkNotNullExpressionValue(listenableWorker$Result2, "success()");
            return listenableWorker$Result2;
        }
    }

    public static final Companion Companion;
    private static final String NOTIFICATION_RESTORE_WORKER_IDENTIFIER;
    private boolean restored;

    static {
        NotificationRestoreWorkManager.Companion = new Companion(null);
        NotificationRestoreWorkManager.NOTIFICATION_RESTORE_WORKER_IDENTIFIER = NotificationRestoreWorker.class.getCanonicalName();
    }

    @Override  // com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager
    public void beginEnqueueingWork(Context context0, boolean z) {
        Intrinsics.checkNotNullParameter(context0, "context");
        synchronized(Boolean.valueOf(this.restored)) {
            if(this.restored) {
                return;
            }
            this.restored = true;
        }
        OneTimeWorkRequest oneTimeWorkRequest0 = (OneTimeWorkRequest)((Builder)new Builder(NotificationRestoreWorker.class).setInitialDelay(((long)(z ? 15 : 0)), TimeUnit.SECONDS)).build();
        OSWorkManagerHelper.getInstance(context0).enqueueUniqueWork(NotificationRestoreWorkManager.NOTIFICATION_RESTORE_WORKER_IDENTIFIER, ExistingWorkPolicy.KEEP, oneTimeWorkRequest0);
    }
}

