package com.onesignal.notifications.internal.receivereceipt.impl;

import android.content.Context;
import androidx.work.Constraints.Builder;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker.Result;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.OneSignal;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001A\u00020\rH\u0002J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager;", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "maxDelay", "", "minDelay", "buildConstraints", "Landroidx/work/Constraints;", "enqueueReceiveReceipt", "", "notificationId", "", "Companion", "ReceiveReceiptWorker", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ReceiveReceiptWorkManager implements IReceiveReceiptWorkManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager$Companion;", "", "()V", "OS_APP_ID", "", "OS_NOTIFICATION_ID", "OS_SUBSCRIPTION_ID", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001A\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager$ReceiveReceiptWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ReceiveReceiptWorker extends CoroutineWorker {
        public ReceiveReceiptWorker(Context context0, WorkerParameters workerParameters0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(workerParameters0, "workerParams");
            super(context0, workerParameters0);
        }

        @Override  // androidx.work.CoroutineWorker
        public Object doWork(Continuation continuation0) {
            com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.doWork.1 receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10;
            if(continuation0 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.doWork.1) {
                receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.doWork.1)continuation0;
                if((receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10.label & 0x80000000) == 0) {
                    receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
                    receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10.label ^= 0x80000000;
                }
            }
            else {
                receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
            Object object0 = receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10.result;
            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10.label) {
                case 0: {
                    ResultKt.throwOnFailure(object0);
                    Context context0 = this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(context0, "applicationContext");
                    if(!OneSignal.initWithContext(context0)) {
                        Result listenableWorker$Result0 = Result.success();
                        Intrinsics.checkNotNullExpressionValue(listenableWorker$Result0, "success()");
                        return listenableWorker$Result0;
                    }
                    String s = this.getInputData().getString("os_notification_id");
                    Intrinsics.checkNotNull(s);
                    String s1 = this.getInputData().getString("os_app_id");
                    Intrinsics.checkNotNull(s1);
                    String s2 = this.getInputData().getString("os_subscription_id");
                    Intrinsics.checkNotNull(s2);
                    IReceiveReceiptProcessor iReceiveReceiptProcessor0 = (IReceiveReceiptProcessor)OneSignal.INSTANCE.getServices().getService(IReceiveReceiptProcessor.class);
                    receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10.label = 1;
                    if(iReceiveReceiptProcessor0.sendReceiveReceipt(s1, s2, s, receiveReceiptWorkManager$ReceiveReceiptWorker$doWork$10) == object1) {
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
            Result listenableWorker$Result1 = Result.success();
            Intrinsics.checkNotNullExpressionValue(listenableWorker$Result1, "success()");
            return listenableWorker$Result1;
        }
    }

    public static final Companion Companion = null;
    private static final String OS_APP_ID = "os_app_id";
    private static final String OS_NOTIFICATION_ID = "os_notification_id";
    private static final String OS_SUBSCRIPTION_ID = "os_subscription_id";
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final int maxDelay;
    private final int minDelay;

    static {
        ReceiveReceiptWorkManager.Companion = new Companion(null);
    }

    public ReceiveReceiptWorkManager(IApplicationService iApplicationService0, ConfigModelStore configModelStore0, ISubscriptionManager iSubscriptionManager0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        super();
        this._applicationService = iApplicationService0;
        this._configModelStore = configModelStore0;
        this._subscriptionManager = iSubscriptionManager0;
        this.maxDelay = 25;
    }

    private final Constraints buildConstraints() {
        return new Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
    }

    @Override  // com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager
    public void enqueueReceiveReceipt(String s) {
        Intrinsics.checkNotNullParameter(s, "notificationId");
        if(!((ConfigModel)this._configModelStore.getModel()).getReceiveReceiptEnabled()) {
            Logging.debug$default("sendReceiveReceipt disabled", null, 2, null);
            return;
        }
        String s1 = ((ConfigModel)this._configModelStore.getModel()).getAppId();
        String s2 = this._subscriptionManager.getSubscriptions().getPush().getId();
        if(s2.length() == 0 || s1.length() == 0) {
            Logging.debug$default("ReceiveReceiptWorkManager: No push subscription or appId!", null, 2, null);
        }
        int v = AndroidUtils.INSTANCE.getRandomDelay(this.minDelay, this.maxDelay);
        Data data0 = new androidx.work.Data.Builder().putString("os_notification_id", s).putString("os_app_id", s1).putString("os_subscription_id", s2).build();
        Intrinsics.checkNotNullExpressionValue(data0, "Builder()\n              …\n                .build()");
        Constraints constraints0 = this.buildConstraints();
        OneTimeWorkRequest oneTimeWorkRequest0 = (OneTimeWorkRequest)((androidx.work.OneTimeWorkRequest.Builder)((androidx.work.OneTimeWorkRequest.Builder)((androidx.work.OneTimeWorkRequest.Builder)new androidx.work.OneTimeWorkRequest.Builder(ReceiveReceiptWorker.class).setConstraints(constraints0)).setInitialDelay(((long)v), TimeUnit.SECONDS)).setInputData(data0)).build();
        Logging.debug$default(("OSReceiveReceiptController enqueueing send receive receipt work with notificationId: " + s + " and delay: " + v + " seconds"), null, 2, null);
        OSWorkManagerHelper.getInstance(this._applicationService.getAppContext()).enqueueUniqueWork(s + "_receive_receipt", ExistingWorkPolicy.KEEP, oneTimeWorkRequest0);
    }
}

