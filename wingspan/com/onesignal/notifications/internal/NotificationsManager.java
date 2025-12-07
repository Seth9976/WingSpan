package com.onesignal.notifications.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.common.GenerateNotificationOpenIntentFromPushPayload;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u00A2\u0006\u0002\u0010\u0011J\u0010\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0016J\u0010\u0010!\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\"H\u0016J\u0010\u0010#\u001A\u00020\u001E2\u0006\u0010$\u001A\u00020\u001CH\u0016J\b\u0010%\u001A\u00020\u001EH\u0016J\b\u0010&\u001A\u00020\u001EH\u0016J\u0010\u0010\'\u001A\u00020\u001E2\u0006\u0010(\u001A\u00020\u0013H\u0016J\b\u0010)\u001A\u00020\u001EH\u0016J!\u0010*\u001A\u00020\u001E2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010/J\b\u00100\u001A\u00020\u001EH\u0002J\u0010\u00101\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0016J\u0010\u00102\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\"H\u0016J\u0010\u00103\u001A\u00020\u001E2\u0006\u00104\u001A\u000205H\u0016J\u0010\u00106\u001A\u00020\u001E2\u0006\u00107\u001A\u000208H\u0016J\u0010\u00109\u001A\u00020\u001E2\u0006\u0010$\u001A\u00020\u001CH\u0016J\u0019\u0010:\u001A\u00020\u00132\u0006\u0010;\u001A\u00020\u0013H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010<J\u0010\u0010=\u001A\u00020\u001E2\u0006\u0010>\u001A\u00020\u0013H\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u0013X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006?"}, d2 = {"Lcom/onesignal/notifications/internal/NotificationsManager;", "Lcom/onesignal/notifications/INotificationsManager;", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationPermissionController", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;", "_notificationRestoreWorkManager", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "_notificationLifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_notificationDataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_summaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;)V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "setPermission", "(Z)V", "permissionChangedNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/IPermissionObserver;", "addClickListener", "", "listener", "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "clearAllNotifications", "onFocus", "onNotificationPermissionChanged", "enabled", "onUnfocused", "openDestinationActivity", "activity", "Landroid/app/Activity;", "pushPayloads", "Lorg/json/JSONArray;", "(Landroid/app/Activity;Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshNotificationState", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPermissionStatusAndFire", "isEnabled", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationsManager implements IApplicationLifecycleHandler, INotificationsManager, INotificationActivityOpener, INotificationPermissionChangedHandler {
    private final IApplicationService _applicationService;
    private final INotificationRepository _notificationDataController;
    private final INotificationLifecycleService _notificationLifecycleService;
    private final INotificationPermissionController _notificationPermissionController;
    private final INotificationRestoreWorkManager _notificationRestoreWorkManager;
    private final INotificationSummaryManager _summaryManager;
    private boolean permission;
    private final EventProducer permissionChangedNotifier;

    public NotificationsManager(IApplicationService iApplicationService0, INotificationPermissionController iNotificationPermissionController0, INotificationRestoreWorkManager iNotificationRestoreWorkManager0, INotificationLifecycleService iNotificationLifecycleService0, INotificationRepository iNotificationRepository0, INotificationSummaryManager iNotificationSummaryManager0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationPermissionController0, "_notificationPermissionController");
        Intrinsics.checkNotNullParameter(iNotificationRestoreWorkManager0, "_notificationRestoreWorkManager");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService0, "_notificationLifecycleService");
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_notificationDataController");
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager0, "_summaryManager");
        super();
        this._applicationService = iApplicationService0;
        this._notificationPermissionController = iNotificationPermissionController0;
        this._notificationRestoreWorkManager = iNotificationRestoreWorkManager0;
        this._notificationLifecycleService = iNotificationLifecycleService0;
        this._notificationDataController = iNotificationRepository0;
        this._summaryManager = iNotificationSummaryManager0;
        Context context0 = iApplicationService0.getAppContext();
        this.permission = NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, context0, null, 2, null);
        this.permissionChangedNotifier = new EventProducer();
        iApplicationService0.addApplicationLifecycleHandler(this);
        iNotificationPermissionController0.subscribe(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                NotificationsManager.this = notificationsManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.internal.NotificationsManager.1(NotificationsManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.internal.NotificationsManager.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return NotificationsManager.this._notificationDataController.deleteExpiredNotifications(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void addClickListener(INotificationClickListener iNotificationClickListener0) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "listener");
        Logging.debug$default(("NotificationsManager.addClickListener(handler: " + iNotificationClickListener0 + ')'), null, 2, null);
        this._notificationLifecycleService.addExternalClickListener(iNotificationClickListener0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void addForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "listener");
        Logging.debug$default(("NotificationsManager.addForegroundLifecycleListener(listener: " + iNotificationLifecycleListener0 + ')'), null, 2, null);
        this._notificationLifecycleService.addExternalForegroundLifecycleListener(iNotificationLifecycleListener0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void addPermissionObserver(IPermissionObserver iPermissionObserver0) {
        Intrinsics.checkNotNullParameter(iPermissionObserver0, "observer");
        Logging.debug$default(("NotificationsManager.addPermissionObserver(observer: " + iPermissionObserver0 + ')'), null, 2, null);
        this.permissionChangedNotifier.subscribe(iPermissionObserver0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void clearAllNotifications() {
        Logging.debug$default("NotificationsManager.clearAllNotifications()", null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                NotificationsManager.this = notificationsManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.internal.NotificationsManager.clearAllNotifications.1(NotificationsManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.internal.NotificationsManager.clearAllNotifications.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return NotificationsManager.this._notificationDataController.markAsDismissedForOutstanding(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public boolean getCanRequestPermission() {
        return this._notificationPermissionController.getCanRequestPermission();
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public boolean getPermission() {
        return this.permission;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        this.refreshNotificationState();
    }

    @Override  // com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler
    public void onNotificationPermissionChanged(boolean z) {
        this.setPermissionStatusAndFire(z);
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    @Override  // com.onesignal.notifications.internal.INotificationActivityOpener
    public Object openDestinationActivity(Activity activity0, JSONArray jSONArray0, Continuation continuation0) {
        try {
            JSONObject jSONObject0 = jSONArray0.getJSONObject(0);
            Intrinsics.checkNotNullExpressionValue(jSONObject0, "firstPayloadItem");
            Intent intent0 = GenerateNotificationOpenIntentFromPushPayload.INSTANCE.create(activity0, jSONObject0).getIntentVisible();
            if(intent0 != null) {
                Logging.info$default(("SDK running startActivity with Intent: " + intent0), null, 2, null);
                activity0.startActivity(intent0);
                return Unit.INSTANCE;
            }
            Logging.info$default("SDK not showing an Activity automatically due to it\'s settings.", null, 2, null);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    private final void refreshNotificationState() {
        Context context0 = this._applicationService.getAppContext();
        this._notificationRestoreWorkManager.beginEnqueueingWork(context0, false);
        Context context1 = this._applicationService.getAppContext();
        this.setPermissionStatusAndFire(NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, context1, null, 2, null));
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeClickListener(INotificationClickListener iNotificationClickListener0) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "listener");
        Logging.debug$default(("NotificationsManager.removeClickListener(listener: " + iNotificationClickListener0 + ')'), null, 2, null);
        this._notificationLifecycleService.removeExternalClickListener(iNotificationClickListener0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "listener");
        Logging.debug$default(("NotificationsManager.removeForegroundLifecycleListener(listener: " + iNotificationLifecycleListener0 + ')'), null, 2, null);
        this._notificationLifecycleService.removeExternalForegroundLifecycleListener(iNotificationLifecycleListener0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeGroupedNotifications(String s) {
        Intrinsics.checkNotNullParameter(s, "group");
        Logging.debug$default(("NotificationsManager.removeGroupedNotifications(group: " + s + ')'), null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, null) {
            final String $group;
            int label;

            {
                NotificationsManager.this = notificationsManager0;
                this.$group = s;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.internal.NotificationsManager.removeGroupedNotifications.1(NotificationsManager.this, this.$group, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.internal.NotificationsManager.removeGroupedNotifications.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return NotificationsManager.this._notificationDataController.markAsDismissedForGroup(this.$group, this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removeNotification(int v) {
        Logging.debug$default(("NotificationsManager.removeNotification(id: " + v + ')'), null, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(v, null) {
            final int $id;
            int label;

            {
                NotificationsManager.this = notificationsManager0;
                this.$id = v;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.internal.NotificationsManager.removeNotification.1(NotificationsManager.this, this.$id, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.internal.NotificationsManager.removeNotification.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        object0 = NotificationsManager.this._notificationDataController.markAsDismissed(this.$id, this);
                        if(object0 == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    case 2: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((Boolean)object0).booleanValue()) {
                    this.label = 2;
                    if(NotificationsManager.this._summaryManager.updatePossibleDependentSummaryOnDismiss(this.$id, this) == object1) {
                        return object1;
                    }
                }
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public void removePermissionObserver(IPermissionObserver iPermissionObserver0) {
        Intrinsics.checkNotNullParameter(iPermissionObserver0, "observer");
        Logging.debug$default(("NotificationsManager.removePermissionObserver(observer: " + iPermissionObserver0 + ')'), null, 2, null);
        this.permissionChangedNotifier.unsubscribe(iPermissionObserver0);
    }

    @Override  // com.onesignal.notifications.INotificationsManager
    public Object requestPermission(boolean z, Continuation continuation0) {
        Logging.debug$default("NotificationsManager.requestPermission()", null, 2, null);
        return BuildersKt.withContext(Dispatchers.getMain(), new Function2(z, null) {
            final boolean $fallbackToSettings;
            int label;

            {
                NotificationsManager.this = notificationsManager0;
                this.$fallbackToSettings = z;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.NotificationsManager.requestPermission.2(NotificationsManager.this, this.$fallbackToSettings, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.NotificationsManager.requestPermission.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        object0 = NotificationsManager.this._notificationPermissionController.prompt(this.$fallbackToSettings, this);
                        return object0 == object1 ? object1 : object0;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, continuation0);
    }

    public void setPermission(boolean z) {
        this.permission = z;
    }

    private final void setPermissionStatusAndFire(boolean z) {
        this.setPermission(z);
        if(this.getPermission() != z) {
            Function1 function10 = new Function1() {
                final boolean $isEnabled;

                {
                    this.$isEnabled = z;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IPermissionObserver)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IPermissionObserver iPermissionObserver0) {
                    Intrinsics.checkNotNullParameter(iPermissionObserver0, "it");
                    iPermissionObserver0.onNotificationPermissionChange(this.$isEnabled);
                }
            };
            this.permissionChangedNotifier.fireOnMain(function10);
        }
    }
}

