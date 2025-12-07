package com.onesignal.notifications.internal.permissions.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.notifications.R.string;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001A\u00020\fH\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\fH\u0016J\u0019\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001EJ\b\u0010\u001F\u001A\u00020\fH\u0002J\u0010\u0010 \u001A\u00020\u001A2\u0006\u0010!\u001A\u00020\u0011H\u0016J\u0010\u0010\"\u001A\u00020\u001A2\u0006\u0010!\u001A\u00020\u0011H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000ER\u0016\u0010\u0014\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000ER\u0014\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/onesignal/notifications/internal/permissions/impl/NotificationPermissionController;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionController;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "_requestPermission", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_applicationService", "_preferenceService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/permissions/IRequestPermissionService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "events", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "hasSubscribers", "getHasSubscribers", "supportsNativePrompt", "getSupportsNativePrompt", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "notificationsEnabled", "onAccept", "", "onReject", "fallbackToSettings", "prompt", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFallbackAlertDialog", "subscribe", "handler", "unsubscribe", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationPermissionController implements PermissionCallback, INotificationPermissionController {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/permissions/impl/NotificationPermissionController$Companion;", "", "()V", "ANDROID_PERMISSION_STRING", "", "PERMISSION_TYPE", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String ANDROID_PERMISSION_STRING = "android.permission.POST_NOTIFICATIONS";
    public static final Companion Companion = null;
    private static final String PERMISSION_TYPE = "NOTIFICATION";
    private final IApplicationService _application;
    private final IApplicationService _applicationService;
    private final IPreferencesService _preferenceService;
    private final IRequestPermissionService _requestPermission;
    private final EventProducer events;
    private final boolean supportsNativePrompt;
    private final WaiterWithValue waiter;

    static {
        NotificationPermissionController.Companion = new Companion(null);
    }

    public NotificationPermissionController(IApplicationService iApplicationService0, IRequestPermissionService iRequestPermissionService0, IApplicationService iApplicationService1, IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_application");
        boolean z;
        Intrinsics.checkNotNullParameter(iRequestPermissionService0, "_requestPermission");
        Intrinsics.checkNotNullParameter(iApplicationService1, "_applicationService");
        Intrinsics.checkNotNullParameter(iPreferencesService0, "_preferenceService");
        super();
        this._application = iApplicationService0;
        this._requestPermission = iRequestPermissionService0;
        this._applicationService = iApplicationService1;
        this._preferenceService = iPreferencesService0;
        this.waiter = new WaiterWithValue();
        this.events = new EventProducer();
        iRequestPermissionService0.registerAsCallback("NOTIFICATION", this);
        if(Build.VERSION.SDK_INT > 0x20) {
            Context context0 = iApplicationService0.getAppContext();
            z = AndroidUtils.INSTANCE.getTargetSdkVersion(context0) > 0x20;
        }
        else {
            z = false;
        }
        this.supportsNativePrompt = z;
    }

    @Override  // com.onesignal.notifications.internal.permissions.INotificationPermissionController
    public boolean getCanRequestPermission() {
        Boolean boolean0 = this._preferenceService.getBool("OneSignal", "USER_RESOLVED_PERMISSION_android.permission.POST_NOTIFICATIONS", Boolean.FALSE);
        Intrinsics.checkNotNull(boolean0);
        return !boolean0.booleanValue();
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    public final boolean getSupportsNativePrompt() {
        return this.supportsNativePrompt;
    }

    private final boolean notificationsEnabled() {
        Context context0 = this._application.getAppContext();
        return NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, context0, null, 2, null);
    }

    @Override  // com.onesignal.core.internal.permissions.IRequestPermissionService$PermissionCallback
    public void onAccept() {
        this.waiter.wake(Boolean.TRUE);
        this.events.fire(com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onAccept.1.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onAccept.1 extends Lambda implements Function1 {
            public static final com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onAccept.1 INSTANCE;

            static {
                com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onAccept.1.INSTANCE = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onAccept.1();
            }

            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onAccept.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((INotificationPermissionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler0, "it");
                iNotificationPermissionChangedHandler0.onNotificationPermissionChanged(true);
            }
        }

    }

    @Override  // com.onesignal.core.internal.permissions.IRequestPermissionService$PermissionCallback
    public void onReject(boolean z) {
        if(!(z ? this.showFallbackAlertDialog() : false)) {
            this.waiter.wake(Boolean.FALSE);
            this.events.fire(com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onReject.1.INSTANCE);
        }

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onReject.1 extends Lambda implements Function1 {
            public static final com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onReject.1 INSTANCE;

            static {
                com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onReject.1.INSTANCE = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onReject.1();
            }

            com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.onReject.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((INotificationPermissionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler0, "it");
                iNotificationPermissionChangedHandler0.onNotificationPermissionChanged(false);
            }
        }

    }

    @Override  // com.onesignal.notifications.internal.permissions.INotificationPermissionController
    public Object prompt(boolean z, Continuation continuation0) {
        if(this.notificationsEnabled()) {
            return Boxing.boxBoolean(true);
        }
        if(this.supportsNativePrompt) {
            Class class0 = this.getClass();
            this._requestPermission.startPrompt(z, "NOTIFICATION", "android.permission.POST_NOTIFICATIONS", class0);
            return this.waiter.waitForWake(continuation0);
        }
        if(z) {
            this.showFallbackAlertDialog();
            return this.waiter.waitForWake(continuation0);
        }
        return Boxing.boxBoolean(false);
    }

    private final boolean showFallbackAlertDialog() {
        Activity activity0 = this._application.getCurrent();
        if(activity0 == null) {
            return false;
        }
        String s = activity0.getString(string.notification_permission_name_for_title);
        Intrinsics.checkNotNullExpressionValue(s, "activity.getString(R.str…ermission_name_for_title)");
        String s1 = activity0.getString(string.notification_permission_settings_message);
        Intrinsics.checkNotNullExpressionValue(s1, "activity.getString(R.str…mission_settings_message)");
        Callback alertDialogPrepromptForAndroidSettings$Callback0 = new Callback() {
            @Override  // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings$Callback
            public void onAccept() {
                activity0._applicationService.addApplicationLifecycleHandler(new ApplicationLifecycleHandlerBase() {
                    @Override  // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase
                    public void onFocus() {
                        super.onFocus();
                        NotificationPermissionController.this._applicationService.removeApplicationLifecycleHandler(this);
                        boolean z = AndroidUtils.INSTANCE.hasPermission("android.permission.POST_NOTIFICATIONS", true, NotificationPermissionController.this._applicationService);
                        NotificationPermissionController.this.waiter.wake(Boolean.valueOf(z));
                        NotificationPermissionController.this.events.fire(new Function1() {
                            final boolean $hasPermission;

                            {
                                this.$hasPermission = z;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((INotificationPermissionChangedHandler)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler0) {
                                Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler0, "it");
                                iNotificationPermissionChangedHandler0.onNotificationPermissionChanged(this.$hasPermission);
                            }
                        });
                    }
                });
                NavigateToAndroidSettingsForNotifications.INSTANCE.show(this.$activity);
            }

            @Override  // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings$Callback
            public void onDecline() {
                activity0.waiter.wake(Boolean.FALSE);
                activity0.events.fire(com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1.onDecline.1.INSTANCE);

                @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
                final class com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1.onDecline.1 extends Lambda implements Function1 {
                    public static final com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1.onDecline.1 INSTANCE;

                    static {
                        com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1.onDecline.1.INSTANCE = new com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1.onDecline.1();
                    }

                    com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController.showFallbackAlertDialog.1.onDecline.1() {
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((INotificationPermissionChangedHandler)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler0) {
                        Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler0, "it");
                        iNotificationPermissionChangedHandler0.onNotificationPermissionChanged(false);
                    }
                }

            }
        };
        AlertDialogPrepromptForAndroidSettings.INSTANCE.show(activity0, s, s1, alertDialogPrepromptForAndroidSettings$Callback0);
        return true;
    }

    public void subscribe(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler0) {
        Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler0, "handler");
        this.events.subscribe(iNotificationPermissionChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((INotificationPermissionChangedHandler)object0));
    }

    public void unsubscribe(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler0) {
        Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler0, "handler");
        this.events.subscribe(iNotificationPermissionChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((INotificationPermissionChangedHandler)object0));
    }
}

