package com.onesignal.location.internal.permissions;

import android.app.Activity;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings.Callback;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.R.string;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000  2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001 B\u0015\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001A\u00020\u0015H\u0016J\u0010\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u000FH\u0016J!\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u000BH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u000FH\u0002J\b\u0010\u001C\u001A\u00020\u0015H\u0016J\u0010\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u0004H\u0016J\u0010\u0010\u001F\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u0004H\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00040\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/onesignal/location/internal/permissions/LocationPermissionController;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "_requestPermission", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/permissions/IRequestPermissionService;Lcom/onesignal/core/internal/application/IApplicationService;)V", "currPermission", "", "events", "Lcom/onesignal/common/events/EventProducer;", "hasSubscribers", "", "getHasSubscribers", "()Z", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "onAccept", "", "onReject", "fallbackToSettings", "prompt", "androidPermissionString", "(ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFallbackAlertDialog", "start", "subscribe", "handler", "unsubscribe", "Companion", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationPermissionController implements IEventNotifier, PermissionCallback, IStartableService {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/location/internal/permissions/LocationPermissionController$Companion;", "", "()V", "PERMISSION_TYPE", "", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String PERMISSION_TYPE = "LOCATION";
    private final IApplicationService _applicationService;
    private final IRequestPermissionService _requestPermission;
    private String currPermission;
    private final EventProducer events;
    private final WaiterWithValue waiter;

    static {
        LocationPermissionController.Companion = new Companion(null);
    }

    public LocationPermissionController(IRequestPermissionService iRequestPermissionService0, IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iRequestPermissionService0, "_requestPermission");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        super();
        this._requestPermission = iRequestPermissionService0;
        this._applicationService = iApplicationService0;
        this.waiter = new WaiterWithValue();
        this.events = new EventProducer();
        this.currPermission = "";
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override  // com.onesignal.core.internal.permissions.IRequestPermissionService$PermissionCallback
    public void onAccept() {
        this.waiter.wake(Boolean.TRUE);
        this.events.fire(com.onesignal.location.internal.permissions.LocationPermissionController.onAccept.1.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.location.internal.permissions.LocationPermissionController.onAccept.1 extends Lambda implements Function1 {
            public static final com.onesignal.location.internal.permissions.LocationPermissionController.onAccept.1 INSTANCE;

            static {
                com.onesignal.location.internal.permissions.LocationPermissionController.onAccept.1.INSTANCE = new com.onesignal.location.internal.permissions.LocationPermissionController.onAccept.1();
            }

            com.onesignal.location.internal.permissions.LocationPermissionController.onAccept.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ILocationPermissionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ILocationPermissionChangedHandler iLocationPermissionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler0, "it");
                iLocationPermissionChangedHandler0.onLocationPermissionChanged(true);
            }
        }

    }

    @Override  // com.onesignal.core.internal.permissions.IRequestPermissionService$PermissionCallback
    public void onReject(boolean z) {
        if(!(z ? this.showFallbackAlertDialog() : false)) {
            this.waiter.wake(Boolean.FALSE);
            this.events.fire(com.onesignal.location.internal.permissions.LocationPermissionController.onReject.1.INSTANCE);
        }

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.location.internal.permissions.LocationPermissionController.onReject.1 extends Lambda implements Function1 {
            public static final com.onesignal.location.internal.permissions.LocationPermissionController.onReject.1 INSTANCE;

            static {
                com.onesignal.location.internal.permissions.LocationPermissionController.onReject.1.INSTANCE = new com.onesignal.location.internal.permissions.LocationPermissionController.onReject.1();
            }

            com.onesignal.location.internal.permissions.LocationPermissionController.onReject.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ILocationPermissionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ILocationPermissionChangedHandler iLocationPermissionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler0, "it");
                iLocationPermissionChangedHandler0.onLocationPermissionChanged(false);
            }
        }

    }

    public final Object prompt(boolean z, String s, Continuation continuation0) {
        this.currPermission = s;
        Class class0 = this.getClass();
        this._requestPermission.startPrompt(z, "LOCATION", s, class0);
        return this.waiter.waitForWake(continuation0);
    }

    private final boolean showFallbackAlertDialog() {
        Activity activity0 = this._applicationService.getCurrent();
        if(activity0 == null) {
            return false;
        }
        String s = activity0.getString(string.location_permission_name_for_title);
        Intrinsics.checkNotNullExpressionValue(s, "activity.getString(R.str…ermission_name_for_title)");
        String s1 = activity0.getString(string.location_permission_settings_message);
        Intrinsics.checkNotNullExpressionValue(s1, "activity.getString(R.str…mission_settings_message)");
        Callback alertDialogPrepromptForAndroidSettings$Callback0 = new Callback() {
            @Override  // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings$Callback
            public void onAccept() {
                activity0._applicationService.addApplicationLifecycleHandler(new ApplicationLifecycleHandlerBase() {
                    @Override  // com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase
                    public void onFocus() {
                        super.onFocus();
                        LocationPermissionController.this._applicationService.removeApplicationLifecycleHandler(this);
                        boolean z = AndroidUtils.INSTANCE.hasPermission(LocationPermissionController.this.currPermission, true, LocationPermissionController.this._applicationService);
                        LocationPermissionController.this.waiter.wake(Boolean.valueOf(z));
                        LocationPermissionController.this.events.fire(new Function1() {
                            final boolean $hasPermission;

                            {
                                this.$hasPermission = z;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ILocationPermissionChangedHandler)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ILocationPermissionChangedHandler iLocationPermissionChangedHandler0) {
                                Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler0, "it");
                                iLocationPermissionChangedHandler0.onLocationPermissionChanged(this.$hasPermission);
                            }
                        });
                    }
                });
                NavigateToAndroidSettingsForLocation.INSTANCE.show(this.$activity);
            }

            @Override  // com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings$Callback
            public void onDecline() {
                activity0.waiter.wake(Boolean.FALSE);
                activity0.events.fire(com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1.onDecline.1.INSTANCE);

                @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
                final class com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1.onDecline.1 extends Lambda implements Function1 {
                    public static final com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1.onDecline.1 INSTANCE;

                    static {
                        com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1.onDecline.1.INSTANCE = new com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1.onDecline.1();
                    }

                    com.onesignal.location.internal.permissions.LocationPermissionController.showFallbackAlertDialog.1.onDecline.1() {
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((ILocationPermissionChangedHandler)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ILocationPermissionChangedHandler iLocationPermissionChangedHandler0) {
                        Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler0, "it");
                        iLocationPermissionChangedHandler0.onLocationPermissionChanged(false);
                    }
                }

            }
        };
        AlertDialogPrepromptForAndroidSettings.INSTANCE.show(activity0, s, s1, alertDialogPrepromptForAndroidSettings$Callback0);
        return true;
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._requestPermission.registerAsCallback("LOCATION", this);
    }

    public void subscribe(ILocationPermissionChangedHandler iLocationPermissionChangedHandler0) {
        Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler0, "handler");
        this.events.subscribe(iLocationPermissionChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ILocationPermissionChangedHandler)object0));
    }

    public void unsubscribe(ILocationPermissionChangedHandler iLocationPermissionChangedHandler0) {
        Intrinsics.checkNotNullParameter(iLocationPermissionChangedHandler0, "handler");
        this.events.subscribe(iLocationPermissionChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ILocationPermissionChangedHandler)object0));
    }
}

