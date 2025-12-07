package com.onesignal.notifications.internal.registration.impl;

import com.amazon.device.messaging.ADM;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001B\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001A\u00020\u000EH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000FR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorADM;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerForPush", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PushRegistratorADM implements IPushRegistrator, IPushRegistratorCallback {
    private final IApplicationService _applicationService;
    private WaiterWithValue waiter;

    public PushRegistratorADM(IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        super();
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

    @Override  // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(Continuation continuation0) {
        ObjectRef ref$ObjectRef1;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush.1 pushRegistratorADM$registerForPush$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush.1) {
            pushRegistratorADM$registerForPush$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush.1)continuation0;
            if((pushRegistratorADM$registerForPush$10.label & 0x80000000) == 0) {
                pushRegistratorADM$registerForPush$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
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
                pushRegistratorADM$registerForPush$10.label ^= 0x80000000;
            }
        }
        else {
            pushRegistratorADM$registerForPush$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
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
        Object object0 = pushRegistratorADM$registerForPush$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(pushRegistratorADM$registerForPush$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                this.waiter = new WaiterWithValue();
                ADM aDM0 = new ADM(this._applicationService.getAppContext());
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                ref$ObjectRef0.element = aDM0.getRegistrationId();
                if(ref$ObjectRef0.element != null) {
                    Logging.debug$default(("ADM Already registered with ID:" + ((String)ref$ObjectRef0.element)), null, 2, null);
                    return new RegisterResult(((String)ref$ObjectRef0.element), SubscriptionStatus.SUBSCRIBED);
                }
                aDM0.startRegister();
                Function2 function20 = new Function2(this, null) {
                    final ObjectRef $registrationId;
                    Object L$0;
                    int label;

                    {
                        this.$registrationId = ref$ObjectRef0;
                        PushRegistratorADM.this = pushRegistratorADM0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush.2(this.$registrationId, PushRegistratorADM.this, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        String s;
                        ObjectRef ref$ObjectRef0;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                ref$ObjectRef0 = this.$registrationId;
                                WaiterWithValue waiterWithValue0 = PushRegistratorADM.this.waiter;
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
                pushRegistratorADM$registerForPush$10.L$0 = ref$ObjectRef0;
                pushRegistratorADM$registerForPush$10.label = 1;
                if(TimeoutKt.withTimeout(30000L, function20, pushRegistratorADM$registerForPush$10) == object1) {
                    return object1;
                }
                ref$ObjectRef1 = ref$ObjectRef0;
                break;
            }
            case 1: {
                ref$ObjectRef1 = (ObjectRef)pushRegistratorADM$registerForPush$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(ref$ObjectRef1.element != null) {
            Logging.error$default(("ADM registered with ID:" + ((String)ref$ObjectRef1.element)), null, 2, null);
            return new RegisterResult(((String)ref$ObjectRef1.element), SubscriptionStatus.SUBSCRIBED);
        }
        Logging.error$default("com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.", null, 2, null);
        return new RegisterResult(null, SubscriptionStatus.ERROR);
    }
}

