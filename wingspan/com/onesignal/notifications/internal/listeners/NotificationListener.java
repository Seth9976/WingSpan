package com.onesignal.notifications.internal.listeners;

import android.app.Activity;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.common.OSNotificationOpenAppSettings;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B]\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0018\u00A2\u0006\u0002\u0010\u0019J)\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u001CH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010$J\u0019\u0010%\u001A\u00020\u001E2\u0006\u0010&\u001A\u00020\'H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010(J\u0010\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020 H\u0002J\b\u0010,\u001A\u00020\u001EH\u0016R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006-"}, d2 = {"Lcom/onesignal/notifications/internal/listeners/NotificationListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationLifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_backend", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "_receiveReceiptWorkManager", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;", "_activityOpener", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "_analyticsTracker", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/notifications/internal/backend/INotificationBackendService;Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;Lcom/onesignal/notifications/internal/INotificationActivityOpener;Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;Lcom/onesignal/core/internal/time/ITime;)V", "postedOpenedNotifIds", "", "", "onNotificationOpened", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONArray;", "notificationId", "(Landroid/app/Activity;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onNotificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldInitDirectSessionFromNotificationOpen", "", "context", "start", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationListener implements IStartableService, INotificationLifecycleEventHandler {
    private final INotificationActivityOpener _activityOpener;
    private final IAnalyticsTracker _analyticsTracker;
    private final IApplicationService _applicationService;
    private final INotificationBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IInfluenceManager _influenceManager;
    private final INotificationLifecycleService _notificationLifecycleService;
    private final IReceiveReceiptWorkManager _receiveReceiptWorkManager;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final Set postedOpenedNotifIds;

    public NotificationListener(IApplicationService iApplicationService0, INotificationLifecycleService iNotificationLifecycleService0, ConfigModelStore configModelStore0, IInfluenceManager iInfluenceManager0, ISubscriptionManager iSubscriptionManager0, IDeviceService iDeviceService0, INotificationBackendService iNotificationBackendService0, IReceiveReceiptWorkManager iReceiveReceiptWorkManager0, INotificationActivityOpener iNotificationActivityOpener0, IAnalyticsTracker iAnalyticsTracker0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService0, "_notificationLifecycleService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iInfluenceManager0, "_influenceManager");
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(iNotificationBackendService0, "_backend");
        Intrinsics.checkNotNullParameter(iReceiveReceiptWorkManager0, "_receiveReceiptWorkManager");
        Intrinsics.checkNotNullParameter(iNotificationActivityOpener0, "_activityOpener");
        Intrinsics.checkNotNullParameter(iAnalyticsTracker0, "_analyticsTracker");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._notificationLifecycleService = iNotificationLifecycleService0;
        this._configModelStore = configModelStore0;
        this._influenceManager = iInfluenceManager0;
        this._subscriptionManager = iSubscriptionManager0;
        this._deviceService = iDeviceService0;
        this._backend = iNotificationBackendService0;
        this._receiveReceiptWorkManager = iReceiveReceiptWorkManager0;
        this._activityOpener = iNotificationActivityOpener0;
        this._analyticsTracker = iAnalyticsTracker0;
        this._time = iTime0;
        this.postedOpenedNotifIds = new LinkedHashSet();
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler
    public Object onNotificationOpened(Activity activity0, JSONArray jSONArray0, String s, Continuation continuation0) {
        NotificationListener notificationListener1;
        Activity activity2;
        JSONArray jSONArray2;
        String s7;
        String s6;
        DeviceType iDeviceService$DeviceType1;
        int v3;
        int v2;
        String s5;
        String s4;
        NotificationListener notificationListener0;
        String s3;
        JSONArray jSONArray1;
        Activity activity1;
        int v1;
        int v;
        DeviceType iDeviceService$DeviceType0;
        Object object2;
        com.onesignal.notifications.internal.listeners.NotificationListener.onNotificationOpened.1 notificationListener$onNotificationOpened$11;
        com.onesignal.notifications.internal.listeners.NotificationListener.onNotificationOpened.1 notificationListener$onNotificationOpened$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.listeners.NotificationListener.onNotificationOpened.1) {
            notificationListener$onNotificationOpened$10 = (com.onesignal.notifications.internal.listeners.NotificationListener.onNotificationOpened.1)continuation0;
            if((notificationListener$onNotificationOpened$10.label & 0x80000000) == 0) {
                notificationListener$onNotificationOpened$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.onNotificationOpened(null, null, null, this);
                    }
                };
            }
            else {
                notificationListener$onNotificationOpened$10.label ^= 0x80000000;
            }
        }
        else {
            notificationListener$onNotificationOpened$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.onNotificationOpened(null, null, null, this);
                }
            };
        }
        Object object0 = notificationListener$onNotificationOpened$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationListener$onNotificationOpened$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s1 = ((ConfigModel)this._configModelStore.getModel()).getAppId();
                if(s1 == null) {
                    s1 = "";
                }
                String s2 = this._subscriptionManager.getSubscriptions().getPush().getId();
                notificationListener$onNotificationOpened$11 = notificationListener$onNotificationOpened$10;
                object2 = object1;
                iDeviceService$DeviceType0 = this._deviceService.getDeviceType();
                v = jSONArray0.length();
                v1 = 0;
                activity1 = activity0;
                jSONArray1 = jSONArray0;
                s3 = s1;
                notificationListener0 = this;
                s4 = s2;
                s5 = s;
                goto label_55;
            }
            case 1: {
                v2 = notificationListener$onNotificationOpened$10.I$1;
                v3 = notificationListener$onNotificationOpened$10.I$0;
                iDeviceService$DeviceType1 = (DeviceType)notificationListener$onNotificationOpened$10.L$6;
                s4 = (String)notificationListener$onNotificationOpened$10.L$5;
                s6 = (String)notificationListener$onNotificationOpened$10.L$4;
                s7 = (String)notificationListener$onNotificationOpened$10.L$3;
                jSONArray2 = (JSONArray)notificationListener$onNotificationOpened$10.L$2;
                activity2 = (Activity)notificationListener$onNotificationOpened$10.L$1;
                notificationListener1 = (NotificationListener)notificationListener$onNotificationOpened$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    break;
                }
                catch(BackendException backendException0) {
                    goto label_81;
                }
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    alab1:
        while(true) {
            notificationListener$onNotificationOpened$11 = notificationListener$onNotificationOpened$10;
            activity1 = activity2;
            object2 = object1;
            jSONArray1 = jSONArray2;
            v = v2;
            s5 = s7;
            v1 = v3;
            notificationListener0 = notificationListener1;
            iDeviceService$DeviceType0 = iDeviceService$DeviceType1;
            s3 = s6;
            do {
                ++v1;
            label_55:
                if(v1 >= v) {
                    break alab1;
                }
            }
            while(notificationListener0.postedOpenedNotifIds.contains(s5));
            notificationListener0.postedOpenedNotifIds.add(s5);
            notificationListener$onNotificationOpened$11.L$0 = notificationListener0;
            notificationListener$onNotificationOpened$11.L$1 = activity1;
            notificationListener$onNotificationOpened$11.L$2 = jSONArray1;
            notificationListener$onNotificationOpened$11.L$3 = s5;
            notificationListener$onNotificationOpened$11.L$4 = s3;
            notificationListener$onNotificationOpened$11.L$5 = s4;
            notificationListener$onNotificationOpened$11.L$6 = iDeviceService$DeviceType0;
            notificationListener$onNotificationOpened$11.I$0 = v1;
            notificationListener$onNotificationOpened$11.I$1 = v;
            notificationListener$onNotificationOpened$11.label = 1;
            try {
                if(notificationListener0._backend.updateNotificationAsOpened(s3, s5, s4, iDeviceService$DeviceType0, notificationListener$onNotificationOpened$11) == object2) {
                    return object2;
                }
                goto label_84;
            }
            catch(BackendException backendException0) {
                jSONArray2 = jSONArray1;
                s7 = s5;
                object1 = object2;
                notificationListener1 = notificationListener0;
                s6 = s3;
                iDeviceService$DeviceType1 = iDeviceService$DeviceType0;
                v3 = v1;
                v2 = v;
                activity2 = activity1;
                notificationListener$onNotificationOpened$10 = notificationListener$onNotificationOpened$11;
            }
        label_81:
            Logging.error$default(("Notification opened confirmation failed with statusCode: " + backendException0.getStatusCode() + " response: " + backendException0.getResponse()), null, 2, null);
            continue;
        label_84:
            jSONArray2 = jSONArray1;
            s7 = s5;
            object1 = object2;
            notificationListener1 = notificationListener0;
            s6 = s3;
            iDeviceService$DeviceType1 = iDeviceService$DeviceType0;
            v3 = v1;
            v2 = v;
            activity2 = activity1;
            notificationListener$onNotificationOpened$10 = notificationListener$onNotificationOpened$11;
        }
        NotificationClickEvent notificationClickEvent0 = NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications(jSONArray1, notificationListener0._time);
        String s8 = notificationClickEvent0.getNotification().getNotificationId();
        Intrinsics.checkNotNull(s8);
        String s9 = NotificationHelper.INSTANCE.getCampaignNameFromNotification(notificationClickEvent0.getNotification());
        notificationListener0._analyticsTracker.trackOpenedEvent(s8, s9);
        if(notificationListener0.shouldInitDirectSessionFromNotificationOpen(activity1)) {
            notificationListener0._applicationService.setEntryState(AppEntryAction.NOTIFICATION_CLICK);
            notificationListener0._influenceManager.onDirectInfluenceFromNotification(s5);
        }
        notificationListener$onNotificationOpened$11.L$0 = null;
        notificationListener$onNotificationOpened$11.L$1 = null;
        notificationListener$onNotificationOpened$11.L$2 = null;
        notificationListener$onNotificationOpened$11.L$3 = null;
        notificationListener$onNotificationOpened$11.L$4 = null;
        notificationListener$onNotificationOpened$11.L$5 = null;
        notificationListener$onNotificationOpened$11.L$6 = null;
        notificationListener$onNotificationOpened$11.label = 2;
        return notificationListener0._activityOpener.openDestinationActivity(activity1, jSONArray1, notificationListener$onNotificationOpened$11) == object2 ? object2 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler
    public Object onNotificationReceived(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        String s = notificationGenerationJob0.getApiNotificationId();
        this._receiveReceiptWorkManager.enqueueReceiveReceipt(s);
        String s1 = notificationGenerationJob0.getApiNotificationId();
        this._influenceManager.onNotificationReceived(s1);
        try {
            JSONObject jSONObject0 = new JSONObject(notificationGenerationJob0.getJsonPayload().toString());
            jSONObject0.put("androidNotificationId", notificationGenerationJob0.getAndroidId());
            JSONArray jSONArray0 = JSONUtils.INSTANCE.wrapInJsonArray(jSONObject0);
            NotificationClickEvent notificationClickEvent0 = NotificationHelper.INSTANCE.generateNotificationOpenedResult$com_onesignal_notifications(jSONArray0, this._time);
            String s2 = notificationClickEvent0.getNotification().getNotificationId();
            Intrinsics.checkNotNull(s2);
            String s3 = NotificationHelper.INSTANCE.getCampaignNameFromNotification(notificationClickEvent0.getNotification());
            this._analyticsTracker.trackReceivedEvent(s2, s3);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldInitDirectSessionFromNotificationOpen(Activity activity0) {
        if(this._applicationService.isInForeground()) {
            return false;
        }
        try {
            return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(activity0);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            return true;
        }
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._notificationLifecycleService.addInternalNotificationLifecycleEventHandler(this);
    }
}

