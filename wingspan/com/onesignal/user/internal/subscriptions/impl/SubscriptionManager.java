package com.onesignal.user.internal.subscriptions.impl;

import android.content.Context;
import android.os.Build.VERSION;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore.DefaultImpls;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.EmailSubscription;
import com.onesignal.user.internal.PushSubscription;
import com.onesignal.user.internal.SmsSubscription;
import com.onesignal.user.internal.Subscription;
import com.onesignal.user.internal.UninitializedPushSubscription;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.IPushSubscriptionObserver;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import com.onesignal.user.subscriptions.PushSubscriptionChangedState;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000B\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u001D\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u00A2\u0006\u0002\u0010\u000BJ\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u001A\u0010 \u001A\u00020\u001D2\b\u0010!\u001A\u0004\u0018\u00010\u001F2\u0006\u0010\"\u001A\u00020#H\u0016J\u0010\u0010$\u001A\u00020\u001D2\u0006\u0010%\u001A\u00020\u001FH\u0016J$\u0010&\u001A\u00020\u001D2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020\u001F2\n\b\u0002\u0010*\u001A\u0004\u0018\u00010#H\u0002J\u0010\u0010+\u001A\u00020\u001D2\u0006\u0010,\u001A\u00020\u0003H\u0002J\u0010\u0010-\u001A\u00020.2\u0006\u0010,\u001A\u00020\u0003H\u0002J\u0018\u0010/\u001A\u00020\u001D2\u0006\u00100\u001A\u00020\u00032\u0006\u00101\u001A\u00020\u001FH\u0016J\u0018\u00102\u001A\u00020\u001D2\u0006\u00100\u001A\u00020\u00032\u0006\u00101\u001A\u00020\u001FH\u0016J\u0018\u00103\u001A\u00020\u001D2\u0006\u00104\u001A\u0002052\u0006\u00101\u001A\u00020\u001FH\u0016J\b\u00106\u001A\u00020\u001DH\u0016J\u0010\u00107\u001A\u00020\u001D2\u0006\u00108\u001A\u000209H\u0016J\b\u0010:\u001A\u00020\u001DH\u0016J\b\u0010;\u001A\u00020\u001DH\u0002J\u0010\u0010<\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u0010\u0010=\u001A\u00020\u001D2\u0006\u0010%\u001A\u00020\u001FH\u0016J\u0010\u0010>\u001A\u00020\u001D2\u0006\u0010?\u001A\u00020.H\u0002J\u0010\u0010@\u001A\u00020\u001D2\u0006\u0010?\u001A\u00020.H\u0002J\u0010\u0010A\u001A\u00020\u001D2\u0006\u0010B\u001A\u00020\u000EH\u0016J\u0010\u0010C\u001A\u00020\u001D2\u0006\u0010B\u001A\u00020\u000EH\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00038VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u0017X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B\u00A8\u0006D"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/impl/SubscriptionManager;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;)V", "events", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "hasSubscribers", "", "getHasSubscribers", "()Z", "pushSubscriptionModel", "getPushSubscriptionModel", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "setSubscriptions", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionList;)V", "addEmailSubscription", "", "email", "", "addOrUpdatePushSubscriptionToken", "pushToken", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "addSmsSubscription", "sms", "addSubscriptionToModels", "type", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "address", "status", "createSubscriptionAndAddToSubscriptionList", "subscriptionModel", "createSubscriptionFromModel", "Lcom/onesignal/user/subscriptions/ISubscription;", "onModelAdded", "model", "tag", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSessionActive", "onSessionEnded", "duration", "", "onSessionStarted", "refreshPushSubscriptionState", "removeEmailSubscription", "removeSmsSubscription", "removeSubscriptionFromModels", "subscription", "removeSubscriptionFromSubscriptionList", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionManager implements IModelStoreChangeHandler, ISessionLifecycleHandler, ISubscriptionManager {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[SubscriptionType.values().length];
            arr_v[SubscriptionType.SMS.ordinal()] = 1;
            arr_v[SubscriptionType.EMAIL.ordinal()] = 2;
            arr_v[SubscriptionType.PUSH.ordinal()] = 3;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private final IApplicationService _applicationService;
    private final ISessionService _sessionService;
    private final SubscriptionModelStore _subscriptionModelStore;
    private final EventProducer events;
    private SubscriptionList subscriptions;

    public SubscriptionManager(IApplicationService iApplicationService0, ISessionService iSessionService0, SubscriptionModelStore subscriptionModelStore0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iSessionService0, "_sessionService");
        Intrinsics.checkNotNullParameter(subscriptionModelStore0, "_subscriptionModelStore");
        super();
        this._applicationService = iApplicationService0;
        this._sessionService = iSessionService0;
        this._subscriptionModelStore = subscriptionModelStore0;
        this.events = new EventProducer();
        this.subscriptions = new SubscriptionList(CollectionsKt.emptyList(), new UninitializedPushSubscription());
        for(Object object0: subscriptionModelStore0.list()) {
            this.createSubscriptionAndAddToSubscriptionList(((SubscriptionModel)object0));
        }
        this._subscriptionModelStore.subscribe(this);
        this._sessionService.subscribe(this);
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addEmailSubscription(String s) {
        Intrinsics.checkNotNullParameter(s, "email");
        SubscriptionManager.addSubscriptionToModels$default(this, SubscriptionType.EMAIL, s, null, 4, null);
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addOrUpdatePushSubscriptionToken(String s, SubscriptionStatus subscriptionStatus0) {
        Intrinsics.checkNotNullParameter(subscriptionStatus0, "pushTokenStatus");
        IPushSubscription iPushSubscription0 = this.getSubscriptions().getPush();
        if(iPushSubscription0 instanceof UninitializedPushSubscription) {
            SubscriptionType subscriptionType0 = SubscriptionType.PUSH;
            if(s == null) {
                s = "";
            }
            this.addSubscriptionToModels(subscriptionType0, s, subscriptionStatus0);
            return;
        }
        Intrinsics.checkNotNull(iPushSubscription0, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel subscriptionModel0 = ((Subscription)iPushSubscription0).getModel();
        if(s != null) {
            subscriptionModel0.setAddress(s);
        }
        subscriptionModel0.setStatus(subscriptionStatus0);
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addSmsSubscription(String s) {
        Intrinsics.checkNotNullParameter(s, "sms");
        SubscriptionManager.addSubscriptionToModels$default(this, SubscriptionType.SMS, s, null, 4, null);
    }

    private final void addSubscriptionToModels(SubscriptionType subscriptionType0, String s, SubscriptionStatus subscriptionStatus0) {
        Logging.log(LogLevel.DEBUG, "SubscriptionManager.addSubscription(type: " + subscriptionType0 + ", address: " + s + ')');
        SubscriptionModel subscriptionModel0 = new SubscriptionModel();
        subscriptionModel0.setId("local-1d9b6ab3-3d6f-4a05-b0f1-7c44046915c7");
        subscriptionModel0.setOptedIn(true);
        subscriptionModel0.setType(subscriptionType0);
        subscriptionModel0.setAddress(s);
        if(subscriptionStatus0 == null) {
            subscriptionStatus0 = SubscriptionStatus.SUBSCRIBED;
        }
        subscriptionModel0.setStatus(subscriptionStatus0);
        DefaultImpls.add$default(this._subscriptionModelStore, subscriptionModel0, null, 2, null);
    }

    static void addSubscriptionToModels$default(SubscriptionManager subscriptionManager0, SubscriptionType subscriptionType0, String s, SubscriptionStatus subscriptionStatus0, int v, Object object0) {
        if((v & 4) != 0) {
            subscriptionStatus0 = null;
        }
        subscriptionManager0.addSubscriptionToModels(subscriptionType0, s, subscriptionStatus0);
    }

    private final void createSubscriptionAndAddToSubscriptionList(SubscriptionModel subscriptionModel0) {
        ISubscription iSubscription0 = this.createSubscriptionFromModel(subscriptionModel0);
        List list0 = CollectionsKt.toMutableList(this.getSubscriptions().getCollection());
        if(subscriptionModel0.getType() == SubscriptionType.PUSH) {
            IPushSubscription iPushSubscription0 = this.getSubscriptions().getPush();
            Intrinsics.checkNotNull(iPushSubscription0, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            Intrinsics.checkNotNull(iSubscription0, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            ((PushSubscription)iSubscription0).getChangeHandlersNotifier().subscribeAll(((PushSubscription)iPushSubscription0).getChangeHandlersNotifier());
            list0.remove(((PushSubscription)iPushSubscription0));
        }
        list0.add(iSubscription0);
        this.setSubscriptions(new SubscriptionList(list0, new UninitializedPushSubscription()));
        Function1 function10 = new Function1() {
            final ISubscription $subscription;

            {
                this.$subscription = iSubscription0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISubscriptionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler0, "it");
                iSubscriptionChangedHandler0.onSubscriptionAdded(this.$subscription);
            }
        };
        this.events.fire(function10);
    }

    private final ISubscription createSubscriptionFromModel(SubscriptionModel subscriptionModel0) {
        switch(WhenMappings.$EnumSwitchMapping$0[subscriptionModel0.getType().ordinal()]) {
            case 1: {
                return new SmsSubscription(subscriptionModel0);
            }
            case 2: {
                return new EmailSubscription(subscriptionModel0);
            }
            case 3: {
                return new PushSubscription(subscriptionModel0);
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public SubscriptionModel getPushSubscriptionModel() {
        IPushSubscription iPushSubscription0 = this.getSubscriptions().getPush();
        Intrinsics.checkNotNull(iPushSubscription0, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
        return ((PushSubscription)iPushSubscription0).getModel();
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public SubscriptionList getSubscriptions() {
        return this.subscriptions;
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(Model model0, String s) {
        this.onModelAdded(((SubscriptionModel)model0), s);
    }

    public void onModelAdded(SubscriptionModel subscriptionModel0, String s) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        this.createSubscriptionAndAddToSubscriptionList(subscriptionModel0);
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(Model model0, String s) {
        this.onModelRemoved(((SubscriptionModel)model0), s);
    }

    public void onModelRemoved(SubscriptionModel subscriptionModel0, String s) {
        Object object0 = null;
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        for(Object object1: this.getSubscriptions().getCollection()) {
            if(Intrinsics.areEqual(((ISubscription)object1).getId(), subscriptionModel0.getId())) {
                object0 = object1;
                break;
            }
        }
        if(((ISubscription)object0) != null) {
            this.removeSubscriptionFromSubscriptionList(((ISubscription)object0));
        }
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        for(Object object0: this.getSubscriptions().getCollection()) {
            Intrinsics.checkNotNull(((ISubscription)object0), "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
            if(!Intrinsics.areEqual(modelChangedArgs0.getModel(), ((Subscription)(((ISubscription)object0))).getModel())) {
                continue;
            }
            goto label_9;
        }
        object0 = null;
    label_9:
        if(((ISubscription)object0) == null) {
            Model model0 = modelChangedArgs0.getModel();
            Intrinsics.checkNotNull(model0, "null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionModel");
            this.createSubscriptionAndAddToSubscriptionList(((SubscriptionModel)model0));
            return;
        }
        if(((ISubscription)object0) instanceof PushSubscription) {
            ((PushSubscription)(((ISubscription)object0))).getChangeHandlersNotifier().fireOnMain(new Function1() {
                final ISubscription $subscription;

                {
                    this.$subscription = iSubscription0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IPushSubscriptionObserver)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IPushSubscriptionObserver iPushSubscriptionObserver0) {
                    Intrinsics.checkNotNullParameter(iPushSubscriptionObserver0, "it");
                    iPushSubscriptionObserver0.onPushSubscriptionChange(new PushSubscriptionChangedState(((PushSubscription)this.$subscription).getSavedState(), ((PushSubscription)this.$subscription).refreshState()));
                }
            });
        }
        Function1 function10 = new Function1(modelChangedArgs0) {
            final ModelChangedArgs $args;
            final ISubscription $subscription;

            {
                this.$subscription = iSubscription0;
                this.$args = modelChangedArgs0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISubscriptionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler0, "it");
                iSubscriptionChangedHandler0.onSubscriptionChanged(this.$subscription, this.$args);
            }
        };
        this.events.fire(function10);
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long v) {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        this.refreshPushSubscriptionState();
    }

    private final void refreshPushSubscriptionState() {
        IPushSubscription iPushSubscription0 = this.getSubscriptions().getPush();
        if(iPushSubscription0 instanceof UninitializedPushSubscription) {
            return;
        }
        Intrinsics.checkNotNull(iPushSubscription0, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel subscriptionModel0 = ((Subscription)iPushSubscription0).getModel();
        subscriptionModel0.setSdk("050109");
        String s = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(s, "RELEASE");
        subscriptionModel0.setDeviceOS(s);
        Context context0 = this._applicationService.getAppContext();
        String s1 = DeviceUtils.INSTANCE.getCarrierName(context0);
        if(s1 != null) {
            subscriptionModel0.setCarrier(s1);
        }
        Context context1 = this._applicationService.getAppContext();
        String s2 = AndroidUtils.INSTANCE.getAppVersion(context1);
        if(s2 != null) {
            subscriptionModel0.setAppVersion(s2);
        }
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void removeEmailSubscription(String s) {
        Object object0 = null;
        Intrinsics.checkNotNullParameter(s, "email");
        for(Object object1: this.getSubscriptions().getEmails()) {
            if(((IEmailSubscription)object1) instanceof EmailSubscription && Intrinsics.areEqual(((IEmailSubscription)object1).getEmail(), s)) {
                object0 = object1;
                break;
            }
        }
        if(((IEmailSubscription)object0) != null) {
            this.removeSubscriptionFromModels(((IEmailSubscription)object0));
        }
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void removeSmsSubscription(String s) {
        Object object0 = null;
        Intrinsics.checkNotNullParameter(s, "sms");
        for(Object object1: this.getSubscriptions().getSmss()) {
            if(((ISmsSubscription)object1) instanceof SmsSubscription && Intrinsics.areEqual(((ISmsSubscription)object1).getNumber(), s)) {
                object0 = object1;
                break;
            }
        }
        if(((ISmsSubscription)object0) != null) {
            this.removeSubscriptionFromModels(((ISmsSubscription)object0));
        }
    }

    private final void removeSubscriptionFromModels(ISubscription iSubscription0) {
        Logging.log(LogLevel.DEBUG, "SubscriptionManager.removeSubscription(subscription: " + iSubscription0 + ')');
        String s = iSubscription0.getId();
        DefaultImpls.remove$default(this._subscriptionModelStore, s, null, 2, null);
    }

    private final void removeSubscriptionFromSubscriptionList(ISubscription iSubscription0) {
        List list0 = CollectionsKt.toMutableList(this.getSubscriptions().getCollection());
        list0.remove(iSubscription0);
        this.setSubscriptions(new SubscriptionList(list0, new UninitializedPushSubscription()));
        Function1 function10 = new Function1() {
            final ISubscription $subscription;

            {
                this.$subscription = iSubscription0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISubscriptionChangedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler0) {
                Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler0, "it");
                iSubscriptionChangedHandler0.onSubscriptionRemoved(this.$subscription);
            }
        };
        this.events.fire(function10);
    }

    @Override  // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void setSubscriptions(SubscriptionList subscriptionList0) {
        Intrinsics.checkNotNullParameter(subscriptionList0, "<set-?>");
        this.subscriptions = subscriptionList0;
    }

    public void subscribe(ISubscriptionChangedHandler iSubscriptionChangedHandler0) {
        Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler0, "handler");
        this.events.subscribe(iSubscriptionChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ISubscriptionChangedHandler)object0));
    }

    public void unsubscribe(ISubscriptionChangedHandler iSubscriptionChangedHandler0) {
        Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler0, "handler");
        this.events.unsubscribe(iSubscriptionChangedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ISubscriptionChangedHandler)object0));
    }
}

