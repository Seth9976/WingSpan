package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BU\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u00A2\u0006\u0002\u0010\u0018J/\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001D2\u0006\u0010\u001F\u001A\u00020\u001B2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010!J\b\u0010\"\u001A\u00020#H\u0016J\u0010\u0010$\u001A\u00020#2\u0006\u0010%\u001A\u00020&H\u0016J\b\u0010\'\u001A\u00020#H\u0016J\u001C\u0010(\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0002J\u0019\u0010)\u001A\u00020#2\u0006\u0010*\u001A\u00020+H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010,J\u0010\u0010-\u001A\u00020#2\u0006\u0010*\u001A\u00020+H\u0002J\b\u0010.\u001A\u00020#H\u0002J\u0010\u0010/\u001A\u00020#2\u0006\u0010*\u001A\u00020+H\u0002J9\u00100\u001A\u0004\u0018\u0001012\u0006\u0010\u001F\u001A\u00020\u001B2\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u00020&2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00105J\u001B\u00106\u001A\u0004\u0018\u0001012\u0006\u0010\u001F\u001A\u00020\u001BH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00107J#\u00108\u001A\u0004\u0018\u0001012\u0006\u0010\u001F\u001A\u00020\u001B2\u0006\u00102\u001A\u000203H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00109J\u0019\u0010:\u001A\u00020#2\u0006\u0010;\u001A\u00020+H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010,J\u0011\u0010<\u001A\u00020#H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010=J\u001B\u0010>\u001A\u0004\u0018\u0001012\u0006\u0010%\u001A\u00020&H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010?J\u001B\u0010@\u001A\u0004\u0018\u0001012\u0006\u0010\u001F\u001A\u00020\u001BH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00107J)\u0010@\u001A\u0004\u0018\u0001012\u0006\u0010\u001F\u001A\u00020\u001B2\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001DH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010!J\u0018\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020\u001E2\u0006\u0010E\u001A\u00020CH\u0002J\b\u0010F\u001A\u00020#H\u0016R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001AX\u0082\u000E\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006G"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsController;", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_session", "Lcom/onesignal/session/internal/session/ISessionService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_outcomeEventsCache", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;", "_outcomeEventsPreferences", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;", "_outcomeEventsBackend", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsRepository;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsBackendService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/time/ITime;)V", "unattributedUniqueOutcomeEventsSentOnSession", "", "", "getUniqueIds", "", "Lcom/onesignal/session/internal/influence/Influence;", "name", "influences", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionActive", "", "onSessionEnded", "duration", "", "onSessionStarted", "removeDisabledInfluences", "requestMeasureOutcomeEvent", "eventParams", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAttributedUniqueOutcomeNotifications", "saveUnattributedUniqueOutcomeEvents", "saveUniqueOutcome", "sendAndCreateOutcomeEvent", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeEvent;", "weight", "", "sessionTime", "(Ljava/lang/String;FJLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEvent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEventWithValue", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSavedOutcomeEvent", "event", "sendSavedOutcomes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSessionEndOutcomeEvent", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUniqueOutcomeEvent", "sessionInfluences", "setSourceChannelIds", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeSourceBody;", "influence", "sourceBody", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeEventsController implements IStartableService, IOutcomeEventsController, ISessionLifecycleHandler {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[InfluenceType.values().length];
            arr_v[InfluenceType.DIRECT.ordinal()] = 1;
            arr_v[InfluenceType.INDIRECT.ordinal()] = 2;
            arr_v[InfluenceType.UNATTRIBUTED.ordinal()] = 3;
            arr_v[InfluenceType.DISABLED.ordinal()] = 4;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[InfluenceChannel.values().length];
            arr_v1[InfluenceChannel.IAM.ordinal()] = 1;
            arr_v1[InfluenceChannel.NOTIFICATION.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IInfluenceManager _influenceManager;
    private final IOutcomeEventsBackendService _outcomeEventsBackend;
    private final IOutcomeEventsRepository _outcomeEventsCache;
    private final IOutcomeEventsPreferences _outcomeEventsPreferences;
    private final ISessionService _session;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private Set unattributedUniqueOutcomeEventsSentOnSession;

    public OutcomeEventsController(ISessionService iSessionService0, IInfluenceManager iInfluenceManager0, IOutcomeEventsRepository iOutcomeEventsRepository0, IOutcomeEventsPreferences iOutcomeEventsPreferences0, IOutcomeEventsBackendService iOutcomeEventsBackendService0, ConfigModelStore configModelStore0, IdentityModelStore identityModelStore0, ISubscriptionManager iSubscriptionManager0, IDeviceService iDeviceService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iSessionService0, "_session");
        Set set1;
        Intrinsics.checkNotNullParameter(iInfluenceManager0, "_influenceManager");
        Intrinsics.checkNotNullParameter(iOutcomeEventsRepository0, "_outcomeEventsCache");
        Intrinsics.checkNotNullParameter(iOutcomeEventsPreferences0, "_outcomeEventsPreferences");
        Intrinsics.checkNotNullParameter(iOutcomeEventsBackendService0, "_outcomeEventsBackend");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._session = iSessionService0;
        this._influenceManager = iInfluenceManager0;
        this._outcomeEventsCache = iOutcomeEventsRepository0;
        this._outcomeEventsPreferences = iOutcomeEventsPreferences0;
        this._outcomeEventsBackend = iOutcomeEventsBackendService0;
        this._configModelStore = configModelStore0;
        this._identityModelStore = identityModelStore0;
        this._subscriptionManager = iSubscriptionManager0;
        this._deviceService = iDeviceService0;
        this._time = iTime0;
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        Set set0 = iOutcomeEventsPreferences0.getUnattributedUniqueOutcomeEventsSentByChannel();
        if(set0 == null) {
            set1 = new LinkedHashSet();
        }
        else {
            set1 = CollectionsKt.toMutableSet(set0);
            if(set1 == null) {
                set1 = new LinkedHashSet();
            }
        }
        this.unattributedUniqueOutcomeEventsSentOnSession = set1;
        iSessionService0.subscribe(this);
    }

    public static final Object access$requestMeasureOutcomeEvent(OutcomeEventsController outcomeEventsController0, OutcomeEventParams outcomeEventParams0, Continuation continuation0) {
        return outcomeEventsController0.requestMeasureOutcomeEvent(outcomeEventParams0, continuation0);
    }

    private final Object getUniqueIds(String s, List list0, Continuation continuation0) {
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.getUniqueIds.1 outcomeEventsController$getUniqueIds$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.getUniqueIds.1) {
            outcomeEventsController$getUniqueIds$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.getUniqueIds.1)continuation0;
            if((outcomeEventsController$getUniqueIds$10.label & 0x80000000) == 0) {
                outcomeEventsController$getUniqueIds$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getUniqueIds(null, null, this);
                    }
                };
            }
            else {
                outcomeEventsController$getUniqueIds$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsController$getUniqueIds$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getUniqueIds(null, null, this);
                }
            };
        }
        Object object0 = outcomeEventsController$getUniqueIds$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsController$getUniqueIds$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                outcomeEventsController$getUniqueIds$10.label = 1;
                object0 = this._outcomeEventsCache.getNotCachedUniqueInfluencesForOutcome(s, list0, outcomeEventsController$getUniqueIds$10);
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
        return ((List)object0).isEmpty() ? null : ((List)object0);
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long v) {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        Logging.debug$default("OutcomeEventsController.sessionStarted: Cleaning outcomes for new session", null, 2, null);
        this.unattributedUniqueOutcomeEventsSentOnSession = new LinkedHashSet();
        this.saveUnattributedUniqueOutcomeEvents();
    }

    private final List removeDisabledInfluences(List list0) {
        List list1 = CollectionsKt.toMutableList(list0);
        for(Object object0: list0) {
            Influence influence0 = (Influence)object0;
        }
        return list1;
    }

    private final Object requestMeasureOutcomeEvent(OutcomeEventParams outcomeEventParams0, Continuation continuation0) {
        Boolean boolean0;
        String s = ((ConfigModel)this._configModelStore.getModel()).getAppId();
        String s1 = this._subscriptionManager.getSubscriptions().getPush().getId();
        DeviceType iDeviceService$DeviceType0 = this._deviceService.getDeviceType();
        String s2 = SubscriptionObjectType.Companion.fromDeviceType(iDeviceService$DeviceType0).getValue();
        if(s1.length() == 0 || s2.length() == 0) {
            throw new BackendException(0, null, 2, null);
        }
        OutcomeEvent outcomeEvent0 = OutcomeEvent.Companion.fromOutcomeEventParamstoOutcomeEvent(outcomeEventParams0);
        switch(WhenMappings.$EnumSwitchMapping$0[outcomeEvent0.getSession().ordinal()]) {
            case 1: {
                boolean0 = Boxing.boxBoolean(true);
                break;
            }
            case 2: {
                boolean0 = Boxing.boxBoolean(false);
                break;
            }
            default: {
                boolean0 = null;
            }
        }
        String s3 = ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId();
        Object object0 = this._outcomeEventsBackend.sendOutcomeEvent(s, s3, s1, s2, boolean0, outcomeEvent0, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final void saveAttributedUniqueOutcomeNotifications(OutcomeEventParams outcomeEventParams0) {
        ThreadUtilsKt.suspendifyOnThread(10, new Function1(outcomeEventParams0, null) {
            final OutcomeEventParams $eventParams;
            int label;

            {
                OutcomeEventsController.this = outcomeEventsController0;
                this.$eventParams = outcomeEventParams0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.saveAttributedUniqueOutcomeNotifications.1(OutcomeEventsController.this, this.$eventParams, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.saveAttributedUniqueOutcomeNotifications.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return OutcomeEventsController.this._outcomeEventsCache.saveUniqueOutcomeEventParams(this.$eventParams, this) == object1 ? object1 : Unit.INSTANCE;
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
        });
    }

    private final void saveUnattributedUniqueOutcomeEvents() {
        this._outcomeEventsPreferences.setUnattributedUniqueOutcomeEventsSentByChannel(this.unattributedUniqueOutcomeEventsSentOnSession);
    }

    private final void saveUniqueOutcome(OutcomeEventParams outcomeEventParams0) {
        if(outcomeEventParams0.isUnattributed()) {
            this.saveUnattributedUniqueOutcomeEvents();
            return;
        }
        this.saveAttributedUniqueOutcomeNotifications(outcomeEventParams0);
    }

    private final Object sendAndCreateOutcomeEvent(String s, float f, long v, List list0, Continuation continuation0) {
        String s2;
        OutcomeEventsController outcomeEventsController1;
        long v3;
        OutcomeEventParams outcomeEventParams1;
        OutcomeEventsController outcomeEventsController0;
        BackendException backendException1;
        String s1;
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendAndCreateOutcomeEvent.1 outcomeEventsController$sendAndCreateOutcomeEvent$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendAndCreateOutcomeEvent.1) {
            outcomeEventsController$sendAndCreateOutcomeEvent$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendAndCreateOutcomeEvent.1)continuation0;
            if((outcomeEventsController$sendAndCreateOutcomeEvent$10.label & 0x80000000) == 0) {
                outcomeEventsController$sendAndCreateOutcomeEvent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendAndCreateOutcomeEvent(null, 0.0f, 0L, null, this);
                    }
                };
            }
            else {
                outcomeEventsController$sendAndCreateOutcomeEvent$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsController$sendAndCreateOutcomeEvent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                long J$0;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendAndCreateOutcomeEvent(null, 0.0f, 0L, null, this);
                }
            };
        }
        Object object0 = outcomeEventsController$sendAndCreateOutcomeEvent$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsController$sendAndCreateOutcomeEvent$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                long v1 = this._time.getCurrentTimeMillis() / 1000L;
                boolean z = false;
                OutcomeSourceBody outcomeSourceBody0 = null;
                OutcomeSourceBody outcomeSourceBody1 = null;
                for(Object object2: list0) {
                    Influence influence0 = (Influence)object2;
                    int v2 = WhenMappings.$EnumSwitchMapping$0[influence0.getInfluenceType().ordinal()];
                    switch(v2) {
                        case 1: {
                            if(outcomeSourceBody0 == null) {
                                outcomeSourceBody0 = new OutcomeSourceBody(null, null, 3, null);
                            }
                            outcomeSourceBody0 = this.setSourceChannelIds(influence0, outcomeSourceBody0);
                            break;
                        }
                        case 2: {
                            if(outcomeSourceBody1 == null) {
                                outcomeSourceBody1 = new OutcomeSourceBody(null, null, 3, null);
                            }
                            outcomeSourceBody1 = this.setSourceChannelIds(influence0, outcomeSourceBody1);
                            break;
                        }
                        case 3: {
                            z = true;
                            break;
                        }
                        default: {
                            if(v2 != 4) {
                                continue;
                            }
                            Logging.verbose$default(("OutcomeEventsController.sendAndCreateOutcomeEvent: Outcomes disabled for channel: " + influence0.getInfluenceChannel()), null, 2, null);
                        }
                    }
                }
                if(outcomeSourceBody0 == null && outcomeSourceBody1 == null && !z) {
                    Logging.verbose$default("OutcomeEventsController.sendAndCreateOutcomeEvent: Outcomes disabled for all channels", null, 2, null);
                    return null;
                }
                OutcomeEventParams outcomeEventParams0 = new OutcomeEventParams(s, new OutcomeSource(outcomeSourceBody0, outcomeSourceBody1), f, v, 0L);
                outcomeEventsController$sendAndCreateOutcomeEvent$10.L$0 = this;
                s1 = s;
                try {
                    outcomeEventsController$sendAndCreateOutcomeEvent$10.L$1 = s1;
                    outcomeEventsController$sendAndCreateOutcomeEvent$10.L$2 = outcomeEventParams0;
                    outcomeEventsController$sendAndCreateOutcomeEvent$10.J$0 = v1;
                    outcomeEventsController$sendAndCreateOutcomeEvent$10.label = 1;
                    if(this.requestMeasureOutcomeEvent(outcomeEventParams0, outcomeEventsController$sendAndCreateOutcomeEvent$10) == object1) {
                        return object1;
                    }
                }
                catch(BackendException backendException0) {
                    backendException1 = backendException0;
                    outcomeEventsController0 = this;
                    outcomeEventParams1 = outcomeEventParams0;
                    v3 = v1;
                    goto label_74;
                }
                outcomeEventsController1 = this;
                outcomeEventParams1 = outcomeEventParams0;
                v3 = v1;
                s2 = s1;
                goto label_68;
            }
            case 1: {
                v3 = outcomeEventsController$sendAndCreateOutcomeEvent$10.J$0;
                outcomeEventParams1 = (OutcomeEventParams)outcomeEventsController$sendAndCreateOutcomeEvent$10.L$2;
                s2 = (String)outcomeEventsController$sendAndCreateOutcomeEvent$10.L$1;
                outcomeEventsController1 = (OutcomeEventsController)outcomeEventsController$sendAndCreateOutcomeEvent$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_68:
                    outcomeEventsController1.saveUniqueOutcome(outcomeEventParams1);
                    return OutcomeEvent.Companion.fromOutcomeEventParamstoOutcomeEvent(outcomeEventParams1);
                }
                catch(BackendException backendException2) {
                    break;
                }
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return null;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        backendException1 = backendException2;
        outcomeEventsController0 = outcomeEventsController1;
        s1 = s2;
    label_74:
        Logging.warn$default(("OutcomeEventsController.sendAndCreateOutcomeEvent: Sending outcome with name: " + s1 + " failed with status code: " + backendException1.getStatusCode() + " and response: " + backendException1.getResponse() + "\nOutcome event was cached and will be reattempted on app cold start"), null, 2, null);
        outcomeEventParams1.setTimestamp(v3);
        outcomeEventsController$sendAndCreateOutcomeEvent$10.L$0 = null;
        outcomeEventsController$sendAndCreateOutcomeEvent$10.L$1 = null;
        outcomeEventsController$sendAndCreateOutcomeEvent$10.L$2 = null;
        outcomeEventsController$sendAndCreateOutcomeEvent$10.label = 2;
        return outcomeEventsController0._outcomeEventsCache.saveOutcomeEvent(outcomeEventParams1, outcomeEventsController$sendAndCreateOutcomeEvent$10) == object1 ? object1 : null;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendOutcomeEvent(String s, Continuation continuation0) {
        return this.sendAndCreateOutcomeEvent(s, 0.0f, 0L, this._influenceManager.getInfluences(), continuation0);
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendOutcomeEventWithValue(String s, float f, Continuation continuation0) {
        return this.sendAndCreateOutcomeEvent(s, f, 0L, this._influenceManager.getInfluences(), continuation0);
    }

    private final Object sendSavedOutcomeEvent(OutcomeEventParams outcomeEventParams0, Continuation continuation0) {
        OutcomeEventsController outcomeEventsController0;
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomeEvent.1 outcomeEventsController$sendSavedOutcomeEvent$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomeEvent.1) {
            outcomeEventsController$sendSavedOutcomeEvent$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomeEvent.1)continuation0;
            if((outcomeEventsController$sendSavedOutcomeEvent$10.label & 0x80000000) == 0) {
                outcomeEventsController$sendSavedOutcomeEvent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendSavedOutcomeEvent(null, this);
                    }
                };
            }
            else {
                outcomeEventsController$sendSavedOutcomeEvent$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsController$sendSavedOutcomeEvent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendSavedOutcomeEvent(null, this);
                }
            };
        }
        Object object0 = outcomeEventsController$sendSavedOutcomeEvent$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsController$sendSavedOutcomeEvent$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    outcomeEventsController$sendSavedOutcomeEvent$10.L$0 = this;
                    outcomeEventsController$sendSavedOutcomeEvent$10.L$1 = outcomeEventParams0;
                    outcomeEventsController$sendSavedOutcomeEvent$10.label = 1;
                    if(this.requestMeasureOutcomeEvent(outcomeEventParams0, outcomeEventsController$sendSavedOutcomeEvent$10) == object1) {
                        return object1;
                    }
                    outcomeEventsController0 = this;
                    outcomeEventsController$sendSavedOutcomeEvent$10.L$0 = outcomeEventParams0;
                    outcomeEventsController$sendSavedOutcomeEvent$10.L$1 = null;
                    outcomeEventsController$sendSavedOutcomeEvent$10.label = 2;
                    return outcomeEventsController0._outcomeEventsCache.deleteOldOutcomeEvent(outcomeEventParams0, outcomeEventsController$sendSavedOutcomeEvent$10) == object1 ? object1 : Unit.INSTANCE;
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            case 1: {
                outcomeEventParams0 = (OutcomeEventParams)outcomeEventsController$sendSavedOutcomeEvent$10.L$1;
                outcomeEventsController0 = (OutcomeEventsController)outcomeEventsController$sendSavedOutcomeEvent$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    outcomeEventsController$sendSavedOutcomeEvent$10.L$0 = outcomeEventParams0;
                    outcomeEventsController$sendSavedOutcomeEvent$10.L$1 = null;
                    outcomeEventsController$sendSavedOutcomeEvent$10.label = 2;
                    return outcomeEventsController0._outcomeEventsCache.deleteOldOutcomeEvent(outcomeEventParams0, outcomeEventsController$sendSavedOutcomeEvent$10) == object1 ? object1 : Unit.INSTANCE;
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            case 2: {
                outcomeEventParams0 = (OutcomeEventParams)outcomeEventsController$sendSavedOutcomeEvent$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return Unit.INSTANCE;
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Logging.warn$default(("OutcomeEventsController.sendSavedOutcomeEvent: Sending outcome with name: " + outcomeEventParams0.getOutcomeId() + " failed with status code: " + backendException0.getStatusCode() + " and response: " + backendException0.getResponse() + "\nOutcome event was cached and will be reattempted on app cold start"), null, 2, null);
        return Unit.INSTANCE;
    }

    private final Object sendSavedOutcomes(Continuation continuation0) {
        Iterator iterator0;
        OutcomeEventsController outcomeEventsController0;
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomes.1 outcomeEventsController$sendSavedOutcomes$10;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomes.1) {
            outcomeEventsController$sendSavedOutcomes$10 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendSavedOutcomes.1)continuation0;
            if((outcomeEventsController$sendSavedOutcomes$10.label & 0x80000000) == 0) {
                outcomeEventsController$sendSavedOutcomes$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendSavedOutcomes(this);
                    }
                };
            }
            else {
                outcomeEventsController$sendSavedOutcomes$10.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsController$sendSavedOutcomes$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendSavedOutcomes(this);
                }
            };
        }
        Object object0 = outcomeEventsController$sendSavedOutcomes$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsController$sendSavedOutcomes$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                outcomeEventsController$sendSavedOutcomes$10.L$0 = this;
                outcomeEventsController$sendSavedOutcomes$10.label = 1;
                object0 = this._outcomeEventsCache.getAllEventsToSend(outcomeEventsController$sendSavedOutcomes$10);
                if(object0 == object1) {
                    return object1;
                }
                outcomeEventsController0 = this;
                iterator0 = ((List)object0).iterator();
                break;
            }
            case 1: {
                OutcomeEventsController outcomeEventsController1 = (OutcomeEventsController)outcomeEventsController$sendSavedOutcomes$10.L$0;
                ResultKt.throwOnFailure(object0);
                outcomeEventsController0 = outcomeEventsController1;
                iterator0 = ((List)object0).iterator();
                break;
            }
            case 2: {
                iterator0 = (Iterator)outcomeEventsController$sendSavedOutcomes$10.L$1;
                outcomeEventsController0 = (OutcomeEventsController)outcomeEventsController$sendSavedOutcomes$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            outcomeEventsController$sendSavedOutcomes$10.L$0 = outcomeEventsController0;
            outcomeEventsController$sendSavedOutcomes$10.L$1 = iterator0;
            outcomeEventsController$sendSavedOutcomes$10.label = 2;
            if(outcomeEventsController0.sendSavedOutcomeEvent(((OutcomeEventParams)object2), outcomeEventsController$sendSavedOutcomes$10) == object1) {
                return object1;
            }
            if(false) {
                break;
            }
        }
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendSessionEndOutcomeEvent(long v, Continuation continuation0) {
        List list0 = this._influenceManager.getInfluences();
        for(Object object0: list0) {
            if(((Influence)object0).getIds() != null) {
                return this.sendAndCreateOutcomeEvent("os__session_duration", 0.0f, v, list0, continuation0);
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    private final Object sendUniqueOutcomeEvent(String s, List list0, Continuation continuation0) {
        List list2;
        String s1;
        OutcomeEventsController outcomeEventsController0;
        com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendUniqueOutcomeEvent.2 outcomeEventsController$sendUniqueOutcomeEvent$20;
        if(continuation0 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendUniqueOutcomeEvent.2) {
            outcomeEventsController$sendUniqueOutcomeEvent$20 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.sendUniqueOutcomeEvent.2)continuation0;
            if((outcomeEventsController$sendUniqueOutcomeEvent$20.label & 0x80000000) == 0) {
                outcomeEventsController$sendUniqueOutcomeEvent$20 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendUniqueOutcomeEvent(null, null, this);
                    }
                };
            }
            else {
                outcomeEventsController$sendUniqueOutcomeEvent$20.label ^= 0x80000000;
            }
        }
        else {
            outcomeEventsController$sendUniqueOutcomeEvent$20 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendUniqueOutcomeEvent(null, null, this);
                }
            };
        }
        Object object0 = outcomeEventsController$sendUniqueOutcomeEvent$20.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(outcomeEventsController$sendUniqueOutcomeEvent$20.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                List list1 = this.removeDisabledInfluences(list0);
                if(list1.isEmpty()) {
                    Logging.debug$default("OutcomeEventsController.sendUniqueOutcomeEvent: Unique Outcome disabled for current session", null, 2, null);
                    return null;
                }
                boolean z = false;
                for(Object object2: list1) {
                    if(((Influence)object2).getInfluenceType().isAttributed()) {
                        z = true;
                        break;
                    }
                }
                if(z) {
                    outcomeEventsController$sendUniqueOutcomeEvent$20.L$0 = this;
                    outcomeEventsController$sendUniqueOutcomeEvent$20.L$1 = s;
                    outcomeEventsController$sendUniqueOutcomeEvent$20.L$2 = list1;
                    outcomeEventsController$sendUniqueOutcomeEvent$20.label = 1;
                    object0 = this.getUniqueIds(s, list1, outcomeEventsController$sendUniqueOutcomeEvent$20);
                    if(object0 == object1) {
                        return object1;
                    }
                    outcomeEventsController0 = this;
                    s1 = s;
                    list2 = list1;
                    break;
                }
                if(this.unattributedUniqueOutcomeEventsSentOnSession.contains(s)) {
                    Logging.debug$default(StringsKt.trimIndent(("\n                    Measure endpoint will not send because unique outcome already sent for: \n                    Session: " + InfluenceType.UNATTRIBUTED + "\n                    Outcome name: " + s + "\n                    ")), null, 2, null);
                    return null;
                }
                this.unattributedUniqueOutcomeEventsSentOnSession.add(s);
                outcomeEventsController$sendUniqueOutcomeEvent$20.label = 3;
                object0 = this.sendAndCreateOutcomeEvent(s, 0.0f, 0L, list1, outcomeEventsController$sendUniqueOutcomeEvent$20);
                return object0 == object1 ? object1 : object0;
            }
            case 1: {
                list2 = (List)outcomeEventsController$sendUniqueOutcomeEvent$20.L$2;
                s1 = (String)outcomeEventsController$sendUniqueOutcomeEvent$20.L$1;
                outcomeEventsController0 = (OutcomeEventsController)outcomeEventsController$sendUniqueOutcomeEvent$20.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return object0;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((List)object0) == null) {
            Logging.debug$default(StringsKt.trimIndent(("\n                    Measure endpoint will not send because unique outcome already sent for: \n                    SessionInfluences: " + list2 + "\n                    Outcome name: " + s1 + "\n                    ")), null, 2, null);
            return null;
        }
        outcomeEventsController$sendUniqueOutcomeEvent$20.L$0 = null;
        outcomeEventsController$sendUniqueOutcomeEvent$20.L$1 = null;
        outcomeEventsController$sendUniqueOutcomeEvent$20.L$2 = null;
        outcomeEventsController$sendUniqueOutcomeEvent$20.label = 2;
        object0 = outcomeEventsController0.sendAndCreateOutcomeEvent(s1, 0.0f, 0L, ((List)object0), outcomeEventsController$sendUniqueOutcomeEvent$20);
        return object0 == object1 ? object1 : object0;
    }

    @Override  // com.onesignal.session.internal.outcomes.IOutcomeEventsController
    public Object sendUniqueOutcomeEvent(String s, Continuation continuation0) {
        return this.sendUniqueOutcomeEvent(s, this._influenceManager.getInfluences(), continuation0);
    }

    private final OutcomeSourceBody setSourceChannelIds(Influence influence0, OutcomeSourceBody outcomeSourceBody0) {
        switch(WhenMappings.$EnumSwitchMapping$1[influence0.getInfluenceChannel().ordinal()]) {
            case 1: {
                outcomeSourceBody0.setInAppMessagesIds(influence0.getIds());
                return outcomeSourceBody0;
            }
            case 2: {
                outcomeSourceBody0.setNotificationIds(influence0.getIds());
                return outcomeSourceBody0;
            }
            default: {
                return outcomeSourceBody0;
            }
        }
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                OutcomeEventsController.this = outcomeEventsController0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.start.1(OutcomeEventsController.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.session.internal.outcomes.impl.OutcomeEventsController.start.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        if(OutcomeEventsController.this.sendSavedOutcomes(this) == object1) {
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
                this.label = 2;
                return OutcomeEventsController.this._outcomeEventsCache.cleanCachedUniqueOutcomeEventNotifications(this) == object1 ? object1 : Unit.INSTANCE;
            }
        }, 1, null);
    }
}

