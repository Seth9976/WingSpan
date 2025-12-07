package com.onesignal.notifications.internal.registration.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0015\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001B\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000EJ\u0019\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001A\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorHMS;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/application/IApplicationService;)V", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHMSTokenTask", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerForPush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PushRegistratorHMS implements IPushRegistrator, IPushRegistratorCallback {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorHMS$Companion;", "", "()V", "HMS_CLIENT_APP_ID", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String HMS_CLIENT_APP_ID = "client/app_id";
    private final IApplicationService _applicationService;
    private final IDeviceService _deviceService;
    private WaiterWithValue waiter;

    static {
        PushRegistratorHMS.Companion = new Companion(null);
    }

    public PushRegistratorHMS(IDeviceService iDeviceService0, IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        super();
        this._deviceService = iDeviceService0;
        this._applicationService = iApplicationService0;
    }

    @Override  // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String s, Continuation continuation0) {
        WaiterWithValue waiterWithValue0 = this.waiter;
        if(waiterWithValue0 != null) {
            waiterWithValue0.wake(s);
        }
        return Unit.INSTANCE;
    }

    private final Object getHMSTokenTask(Context context0, Continuation continuation0) throws ApiException {
        RegisterResult iPushRegistrator$RegisterResult2;
        ObjectRef ref$ObjectRef1;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask.1 pushRegistratorHMS$getHMSTokenTask$10;
        synchronized(this) {
            if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask.1) {
                pushRegistratorHMS$getHMSTokenTask$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask.1)continuation0;
                if((pushRegistratorHMS$getHMSTokenTask$10.label & 0x80000000) == 0) {
                    pushRegistratorHMS$getHMSTokenTask$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        int label;
                        Object result;

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.getHMSTokenTask(null, this);
                        }
                    };
                }
                else {
                    pushRegistratorHMS$getHMSTokenTask$10.label ^= 0x80000000;
                }
            }
            else {
                pushRegistratorHMS$getHMSTokenTask$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getHMSTokenTask(null, this);
                    }
                };
            }
            Object object0 = pushRegistratorHMS$getHMSTokenTask$10.result;
            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(pushRegistratorHMS$getHMSTokenTask$10.label) {
                case 0: {
                    ResultKt.throwOnFailure(object0);
                    if(!this._deviceService.getHasAllHMSLibrariesForPushKit()) {
                        return new RegisterResult(null, SubscriptionStatus.MISSING_HMS_PUSHKIT_LIBRARY);
                    }
                    this.waiter = new WaiterWithValue();
                    String s = AGConnectServicesConfig.fromContext(context0).getString("client/app_id");
                    HmsInstanceId hmsInstanceId0 = HmsInstanceId.getInstance(context0);
                    ObjectRef ref$ObjectRef0 = new ObjectRef();
                    ref$ObjectRef0.element = hmsInstanceId0.getToken(s, "HCM");
                    if(!TextUtils.isEmpty(((CharSequence)ref$ObjectRef0.element))) {
                        Logging.info$default(("Device registered for HMS, push token = " + ((String)ref$ObjectRef0.element)), null, 2, null);
                        return new RegisterResult(((String)ref$ObjectRef0.element), SubscriptionStatus.SUBSCRIBED);
                    }
                    Function2 function20 = new Function2(this, null) {
                        final ObjectRef $pushToken;
                        Object L$0;
                        int label;

                        {
                            this.$pushToken = ref$ObjectRef0;
                            PushRegistratorHMS.this = pushRegistratorHMS0;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask.2(this.$pushToken, PushRegistratorHMS.this, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            String s;
                            ObjectRef ref$ObjectRef0;
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    ref$ObjectRef0 = this.$pushToken;
                                    WaiterWithValue waiterWithValue0 = PushRegistratorHMS.this.waiter;
                                    if(waiterWithValue0 == null) {
                                        s = null;
                                    }
                                    else {
                                        this.L$0 = ref$ObjectRef0;
                                        this.label = 1;
                                        Object object2 = waiterWithValue0.waitForWake(this);
                                        if(object2 == object1) {
                                            return object1;
                                        }
                                        s = (String)object2;
                                    }
                                    break;
                                }
                                case 1: {
                                    ObjectRef ref$ObjectRef1 = (ObjectRef)this.L$0;
                                    ResultKt.throwOnFailure(object0);
                                    s = (String)object0;
                                    ref$ObjectRef0 = ref$ObjectRef1;
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            ref$ObjectRef0.element = s;
                            return Unit.INSTANCE;
                        }
                    };
                    pushRegistratorHMS$getHMSTokenTask$10.L$0 = ref$ObjectRef0;
                    pushRegistratorHMS$getHMSTokenTask$10.label = 1;
                    if(TimeoutKt.withTimeout(30000L, function20, pushRegistratorHMS$getHMSTokenTask$10) == object1) {
                        return object1;
                    }
                    ref$ObjectRef1 = ref$ObjectRef0;
                    break;
                }
                case 1: {
                    ref$ObjectRef1 = (ObjectRef)pushRegistratorHMS$getHMSTokenTask$10.L$0;
                    ResultKt.throwOnFailure(object0);
                    break;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            if(ref$ObjectRef1.element == null) {
                Logging.error$default("HmsMessageServiceOneSignal.onNewToken timed out.", null, 2, null);
                iPushRegistrator$RegisterResult2 = new RegisterResult(null, SubscriptionStatus.HMS_TOKEN_TIMEOUT);
            }
            else {
                Logging.error$default(("HMS registered with ID:" + ((String)ref$ObjectRef1.element)), null, 2, null);
                iPushRegistrator$RegisterResult2 = new RegisterResult(((String)ref$ObjectRef1.element), SubscriptionStatus.SUBSCRIBED);
            }
            return iPushRegistrator$RegisterResult2;
        }
    }

    @Override  // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(Continuation continuation0) {
        RegisterResult iPushRegistrator$RegisterResult0;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.registerForPush.1 pushRegistratorHMS$registerForPush$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.registerForPush.1) {
            pushRegistratorHMS$registerForPush$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.registerForPush.1)continuation0;
            if((pushRegistratorHMS$registerForPush$10.label & 0x80000000) == 0) {
                pushRegistratorHMS$registerForPush$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.registerForPush(this);
                    }
                };
            }
            else {
                pushRegistratorHMS$registerForPush$10.label ^= 0x80000000;
            }
        }
        else {
            pushRegistratorHMS$registerForPush$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.registerForPush(this);
                }
            };
        }
        Object object0 = pushRegistratorHMS$registerForPush$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(pushRegistratorHMS$registerForPush$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    Context context0 = this._applicationService.getAppContext();
                    pushRegistratorHMS$registerForPush$10.label = 1;
                    object0 = this.getHMSTokenTask(context0, pushRegistratorHMS$registerForPush$10);
                    if(object0 == object1) {
                        return object1;
                    label_18:
                        ResultKt.throwOnFailure(object0);
                    }
                    iPushRegistrator$RegisterResult0 = (RegisterResult)object0;
                    goto label_24;
                }
                catch(ApiException apiException0) {
                }
                break;
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Logging.error("HMS ApiException getting Huawei push token!", ((Throwable)apiException0));
        iPushRegistrator$RegisterResult0 = new RegisterResult(null, (apiException0.getStatusCode() == 907135000 ? SubscriptionStatus.HMS_ARGUMENTS_INVALID : SubscriptionStatus.HMS_API_EXCEPTION_OTHER));
    label_24:
        Intrinsics.checkNotNull(iPushRegistrator$RegisterResult0);
        return iPushRegistrator$RegisterResult0;
    }
}

