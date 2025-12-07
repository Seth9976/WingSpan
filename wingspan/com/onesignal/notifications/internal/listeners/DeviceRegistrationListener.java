package com.onesignal.notifications.internal.listeners;

import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.notifications.internal.pushtoken.PushTokenResponse;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.subscriptions.ISubscription;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B-\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0018\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J\u0010\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u001BH\u0016J\u0010\u0010\u001C\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\u001EH\u0016J\u0018\u0010\u001F\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J\u0010\u0010 \u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\u001EH\u0016J\b\u0010!\u001A\u00020\u0012H\u0002J\b\u0010\"\u001A\u00020\u0012H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/onesignal/notifications/internal/listeners/DeviceRegistrationListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/notifications/IPermissionObserver;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_channelManager", "Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;", "_pushTokenManager", "Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;", "_notificationsManager", "Lcom/onesignal/notifications/INotificationsManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/channels/INotificationChannelManager;Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;Lcom/onesignal/notifications/INotificationsManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "onModelReplaced", "", "model", "tag", "", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onNotificationPermissionChange", "permission", "", "onSubscriptionAdded", "subscription", "Lcom/onesignal/user/subscriptions/ISubscription;", "onSubscriptionChanged", "onSubscriptionRemoved", "retrievePushTokenAndUpdateSubscription", "start", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DeviceRegistrationListener implements ISingletonModelStoreChangeHandler, IStartableService, IPermissionObserver, ISubscriptionChangedHandler {
    private final INotificationChannelManager _channelManager;
    private final ConfigModelStore _configModelStore;
    private final INotificationsManager _notificationsManager;
    private final IPushTokenManager _pushTokenManager;
    private final ISubscriptionManager _subscriptionManager;

    public DeviceRegistrationListener(ConfigModelStore configModelStore0, INotificationChannelManager iNotificationChannelManager0, IPushTokenManager iPushTokenManager0, INotificationsManager iNotificationsManager0, ISubscriptionManager iSubscriptionManager0) {
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationChannelManager0, "_channelManager");
        Intrinsics.checkNotNullParameter(iPushTokenManager0, "_pushTokenManager");
        Intrinsics.checkNotNullParameter(iNotificationsManager0, "_notificationsManager");
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        super();
        this._configModelStore = configModelStore0;
        this._channelManager = iNotificationChannelManager0;
        this._pushTokenManager = iPushTokenManager0;
        this._notificationsManager = iNotificationsManager0;
        this._subscriptionManager = iSubscriptionManager0;
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(Model model0, String s) {
        this.onModelReplaced(((ConfigModel)model0), s);
    }

    public void onModelReplaced(ConfigModel configModel0, String s) {
        Intrinsics.checkNotNullParameter(configModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "HYDRATE")) {
            return;
        }
        JSONArray jSONArray0 = configModel0.getNotificationChannels();
        this._channelManager.processChannelList(jSONArray0);
        this.retrievePushTokenAndUpdateSubscription();
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
    }

    @Override  // com.onesignal.notifications.IPermissionObserver
    public void onNotificationPermissionChange(boolean z) {
        this.retrievePushTokenAndUpdateSubscription();
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionAdded(ISubscription iSubscription0) {
        Intrinsics.checkNotNullParameter(iSubscription0, "subscription");
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionChanged(ISubscription iSubscription0, ModelChangedArgs modelChangedArgs0) {
        Intrinsics.checkNotNullParameter(iSubscription0, "subscription");
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        if(Intrinsics.areEqual(modelChangedArgs0.getPath(), "optedIn") && Intrinsics.areEqual(modelChangedArgs0.getNewValue(), Boolean.TRUE) && !this._notificationsManager.getPermission()) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                int label;

                {
                    DeviceRegistrationListener.this = deviceRegistrationListener0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.notifications.internal.listeners.DeviceRegistrationListener.onSubscriptionChanged.2(DeviceRegistrationListener.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.notifications.internal.listeners.DeviceRegistrationListener.onSubscriptionChanged.2)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return DeviceRegistrationListener.this._notificationsManager.requestPermission(true, this) == object1 ? object1 : Unit.INSTANCE;
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
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionRemoved(ISubscription iSubscription0) {
        Intrinsics.checkNotNullParameter(iSubscription0, "subscription");
    }

    private final void retrievePushTokenAndUpdateSubscription() {
        if(this._subscriptionManager.getSubscriptions().getPush().getToken().length() > 0) {
            boolean z = this._notificationsManager.getPermission();
            this._subscriptionManager.addOrUpdatePushSubscriptionToken(null, (z ? SubscriptionStatus.SUBSCRIBED : SubscriptionStatus.NO_PERMISSION));
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                DeviceRegistrationListener.this = deviceRegistrationListener0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.internal.listeners.DeviceRegistrationListener.retrievePushTokenAndUpdateSubscription.1(DeviceRegistrationListener.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.internal.listeners.DeviceRegistrationListener.retrievePushTokenAndUpdateSubscription.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        object0 = DeviceRegistrationListener.this._pushTokenManager.retrievePushToken(this);
                        if(object0 == object1) {
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
                boolean z = DeviceRegistrationListener.this._notificationsManager.getPermission();
                String s = ((PushTokenResponse)object0).getToken();
                DeviceRegistrationListener.this._subscriptionManager.addOrUpdatePushSubscriptionToken(s, (z ? ((PushTokenResponse)object0).getStatus() : SubscriptionStatus.NO_PERMISSION));
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._configModelStore.subscribe(this);
        this._notificationsManager.addPermissionObserver(this);
        this._subscriptionManager.subscribe(this);
        this.retrievePushTokenAndUpdateSubscription();
    }
}

