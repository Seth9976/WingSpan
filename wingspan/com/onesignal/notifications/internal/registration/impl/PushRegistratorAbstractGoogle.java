package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b \u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ#\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001B\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u000BH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0012\u0010\u001A\u001A\u00020\u001B2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000BH\u0002J\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0002J\u0011\u0010 \u001A\u00020\u000FH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000BH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_upgradePrompt", "Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;)V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "attemptRegistration", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "senderId", "currentRetry", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "internalRegisterForPush", "isValidProjectNumber", "", "pushStatusFromThrowable", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "throwable", "", "registerForPush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerInBackground", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class PushRegistratorAbstractGoogle implements IPushRegistrator, IPushRegistratorCallback {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle$Companion;", "", "()V", "REGISTRATION_RETRY_BACKOFF_MS", "", "REGISTRATION_RETRY_COUNT", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int REGISTRATION_RETRY_BACKOFF_MS = 10000;
    private static final int REGISTRATION_RETRY_COUNT = 5;
    private ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final GooglePlayServicesUpgradePrompt _upgradePrompt;

    static {
        PushRegistratorAbstractGoogle.Companion = new Companion(null);
    }

    public PushRegistratorAbstractGoogle(IDeviceService iDeviceService0, ConfigModelStore configModelStore0, GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt0) {
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(googlePlayServicesUpgradePrompt0, "_upgradePrompt");
        super();
        this._deviceService = iDeviceService0;
        this._configModelStore = configModelStore0;
        this._upgradePrompt = googlePlayServicesUpgradePrompt0;
    }

    private final Object attemptRegistration(String s, int v, Continuation continuation0) {
        PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle0;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.attemptRegistration.1 pushRegistratorAbstractGoogle$attemptRegistration$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.attemptRegistration.1) {
            pushRegistratorAbstractGoogle$attemptRegistration$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.attemptRegistration.1)continuation0;
            if((pushRegistratorAbstractGoogle$attemptRegistration$10.label & 0x80000000) == 0) {
                pushRegistratorAbstractGoogle$attemptRegistration$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.attemptRegistration(null, 0, this);
                    }
                };
            }
            else {
                pushRegistratorAbstractGoogle$attemptRegistration$10.label ^= 0x80000000;
            }
        }
        else {
            pushRegistratorAbstractGoogle$attemptRegistration$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.attemptRegistration(null, 0, this);
                }
            };
        }
        Object object0 = pushRegistratorAbstractGoogle$attemptRegistration$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(pushRegistratorAbstractGoogle$attemptRegistration$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    pushRegistratorAbstractGoogle$attemptRegistration$10.L$0 = this;
                    pushRegistratorAbstractGoogle$attemptRegistration$10.I$0 = v;
                    pushRegistratorAbstractGoogle$attemptRegistration$10.label = 1;
                    object0 = this.getToken(s, pushRegistratorAbstractGoogle$attemptRegistration$10);
                }
                catch(IOException iOException0) {
                    pushRegistratorAbstractGoogle0 = this;
                    break;
                }
                catch(Throwable throwable0) {
                    pushRegistratorAbstractGoogle0 = this;
                    Logging.error(("Unknown error getting " + pushRegistratorAbstractGoogle0.getProviderName() + " Token"), throwable0);
                    return new RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION);
                }
                if(object0 == object1) {
                    return object1;
                }
                pushRegistratorAbstractGoogle0 = this;
                goto label_31;
            }
            case 1: {
                v = pushRegistratorAbstractGoogle$attemptRegistration$10.I$0;
                pushRegistratorAbstractGoogle0 = (PushRegistratorAbstractGoogle)pushRegistratorAbstractGoogle$attemptRegistration$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_31:
                    Logging.info$default(("Device registered, push token = " + ((String)object0)), null, 2, null);
                    return new RegisterResult(((String)object0), SubscriptionStatus.SUBSCRIBED);
                }
                catch(IOException iOException0) {
                    break;
                }
                catch(Throwable throwable0) {
                    Logging.error(("Unknown error getting " + pushRegistratorAbstractGoogle0.getProviderName() + " Token"), throwable0);
                    return new RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION);
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        SubscriptionStatus subscriptionStatus0 = pushRegistratorAbstractGoogle0.pushStatusFromThrowable(iOException0);
        String s1 = AndroidUtils.INSTANCE.getRootCauseMessage(iOException0);
        if(Intrinsics.areEqual("SERVICE_NOT_AVAILABLE", s1) || Intrinsics.areEqual("AUTHENTICATION_FAILED", s1)) {
            Exception exception0 = new Exception(iOException0);
            if(v >= 4) {
                Logging.error(("Retry count of 5 exceed! Could not get a " + pushRegistratorAbstractGoogle0.getProviderName() + " Token."), exception0);
                return null;
            }
            Logging.info(("\'Google Play services\' returned " + s1 + " error. Current retry count: " + v), exception0);
            return v == 2 ? new RegisterResult(null, subscriptionStatus0) : null;
        }
        Exception exception1 = new Exception(iOException0);
        Logging.error(("Error Getting " + pushRegistratorAbstractGoogle0.getProviderName() + " Token"), exception1);
        return new RegisterResult(null, subscriptionStatus0);
    }

    @Override  // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String s, Continuation continuation0) {
        return PushRegistratorAbstractGoogle.fireCallback$suspendImpl(this, s, continuation0);
    }

    static Object fireCallback$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle0, String s, Continuation continuation0) {
        throw new Exception("Google has no callback mechanism for push registration!");
    }

    public abstract String getProviderName();

    public abstract Object getToken(String arg1, Continuation arg2) throws ExecutionException, InterruptedException, IOException;

    private final Object internalRegisterForPush(String s, Continuation continuation0) {
        PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle0;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.internalRegisterForPush.1 pushRegistratorAbstractGoogle$internalRegisterForPush$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.internalRegisterForPush.1) {
            pushRegistratorAbstractGoogle$internalRegisterForPush$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.internalRegisterForPush.1)continuation0;
            if((pushRegistratorAbstractGoogle$internalRegisterForPush$10.label & 0x80000000) == 0) {
                pushRegistratorAbstractGoogle$internalRegisterForPush$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.internalRegisterForPush(null, this);
                    }
                };
            }
            else {
                pushRegistratorAbstractGoogle$internalRegisterForPush$10.label ^= 0x80000000;
            }
        }
        else {
            pushRegistratorAbstractGoogle$internalRegisterForPush$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.internalRegisterForPush(null, this);
                }
            };
        }
        Object object0 = pushRegistratorAbstractGoogle$internalRegisterForPush$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(pushRegistratorAbstractGoogle$internalRegisterForPush$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    if(this._deviceService.isGMSInstalledAndEnabled()) {
                        pushRegistratorAbstractGoogle$internalRegisterForPush$10.L$0 = this;
                        pushRegistratorAbstractGoogle$internalRegisterForPush$10.label = 1;
                        object0 = this.registerInBackground(s, pushRegistratorAbstractGoogle$internalRegisterForPush$10);
                        if(object0 == object1) {
                            return object1;
                        }
                        pushRegistratorAbstractGoogle0 = this;
                        return (RegisterResult)object0;
                    }
                    pushRegistratorAbstractGoogle$internalRegisterForPush$10.L$0 = this;
                    pushRegistratorAbstractGoogle$internalRegisterForPush$10.label = 2;
                    if(this._upgradePrompt.showUpdateGPSDialog(pushRegistratorAbstractGoogle$internalRegisterForPush$10) == object1) {
                        return object1;
                    }
                }
                catch(Throwable throwable0) {
                    pushRegistratorAbstractGoogle0 = this;
                    break;
                }
                pushRegistratorAbstractGoogle0 = this;
                goto label_36;
            }
            case 1: {
                pushRegistratorAbstractGoogle0 = (PushRegistratorAbstractGoogle)pushRegistratorAbstractGoogle$internalRegisterForPush$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return (RegisterResult)object0;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                pushRegistratorAbstractGoogle0 = (PushRegistratorAbstractGoogle)pushRegistratorAbstractGoogle$internalRegisterForPush$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_36:
                    Logging.error$default("\'Google Play services\' app not installed or disabled on the device.", null, 2, null);
                    return new RegisterResult(null, SubscriptionStatus.OUTDATED_GOOGLE_PLAY_SERVICES_APP);
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Logging.error(("Could not register with " + pushRegistratorAbstractGoogle0.getProviderName() + " due to an issue with your AndroidManifest.xml or with \'Google Play services\'."), throwable0);
        return new RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_INIT_ERROR);
    }

    private final boolean isValidProjectNumber(String s) {
        boolean z;
        try {
            Intrinsics.checkNotNull(s);
            z = false;
            Float.parseFloat(s);
            return true;
        }
        catch(Throwable unused_ex) {
            return z;
        }
    }

    private final SubscriptionStatus pushStatusFromThrowable(Throwable throwable0) {
        String s = AndroidUtils.INSTANCE.getRootCauseMessage(throwable0);
        if(throwable0 instanceof IOException) {
            if(Intrinsics.areEqual(s, "SERVICE_NOT_AVAILABLE")) {
                return SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE;
            }
            return Intrinsics.areEqual(s, "AUTHENTICATION_FAILED") ? SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED : SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER;
        }
        return SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION;
    }

    @Override  // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(Continuation continuation0) {
        return PushRegistratorAbstractGoogle.registerForPush$suspendImpl(this, continuation0);
    }

    static Object registerForPush$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle0, Continuation continuation0) {
        if(!((ConfigModel)pushRegistratorAbstractGoogle0._configModelStore.getModel()).isInitializedWithRemote()) {
            return new RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_INIT_ERROR);
        }
        if(!pushRegistratorAbstractGoogle0._deviceService.getHasFCMLibrary()) {
            Logging.fatal$default("The Firebase FCM library is missing! Please make sure to include it in your project.", null, 2, null);
            return new RegisterResult(null, SubscriptionStatus.MISSING_FIREBASE_FCM_LIBRARY);
        }
        if(!pushRegistratorAbstractGoogle0.isValidProjectNumber(((ConfigModel)pushRegistratorAbstractGoogle0._configModelStore.getModel()).getGoogleProjectNumber())) {
            Logging.error$default("Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.", null, 2, null);
            return new RegisterResult(null, SubscriptionStatus.INVALID_FCM_SENDER_ID);
        }
        String s = ((ConfigModel)pushRegistratorAbstractGoogle0._configModelStore.getModel()).getGoogleProjectNumber();
        Intrinsics.checkNotNull(s);
        return pushRegistratorAbstractGoogle0.internalRegisterForPush(s, continuation0);
    }

    private final Object registerInBackground(String s, Continuation continuation0) {
        PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle1;
        String s1;
        int v1;
        int v;
        PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle0;
        com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.registerInBackground.1 pushRegistratorAbstractGoogle$registerInBackground$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.registerInBackground.1) {
            pushRegistratorAbstractGoogle$registerInBackground$10 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.registerInBackground.1)continuation0;
            if((pushRegistratorAbstractGoogle$registerInBackground$10.label & 0x80000000) == 0) {
                pushRegistratorAbstractGoogle$registerInBackground$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.registerInBackground(null, this);
                    }
                };
            }
            else {
                pushRegistratorAbstractGoogle$registerInBackground$10.label ^= 0x80000000;
            }
        }
        else {
            pushRegistratorAbstractGoogle$registerInBackground$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.registerInBackground(null, this);
                }
            };
        }
        Object object0 = pushRegistratorAbstractGoogle$registerInBackground$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(pushRegistratorAbstractGoogle$registerInBackground$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                pushRegistratorAbstractGoogle0 = this;
                v = 0;
                goto label_28;
            }
            case 1: {
                v1 = pushRegistratorAbstractGoogle$registerInBackground$10.I$0;
                s1 = (String)pushRegistratorAbstractGoogle$registerInBackground$10.L$1;
                pushRegistratorAbstractGoogle1 = (PushRegistratorAbstractGoogle)pushRegistratorAbstractGoogle$registerInBackground$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_40;
            }
            case 2: {
                v1 = pushRegistratorAbstractGoogle$registerInBackground$10.I$0;
                s1 = (String)pushRegistratorAbstractGoogle$registerInBackground$10.L$1;
                pushRegistratorAbstractGoogle1 = (PushRegistratorAbstractGoogle)pushRegistratorAbstractGoogle$registerInBackground$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            v = v1 + 1;
            s = s1;
            pushRegistratorAbstractGoogle0 = pushRegistratorAbstractGoogle1;
        label_28:
            if(v >= 5) {
                break;
            }
            pushRegistratorAbstractGoogle$registerInBackground$10.L$0 = pushRegistratorAbstractGoogle0;
            pushRegistratorAbstractGoogle$registerInBackground$10.L$1 = s;
            pushRegistratorAbstractGoogle$registerInBackground$10.I$0 = v;
            pushRegistratorAbstractGoogle$registerInBackground$10.label = 1;
            Object object2 = pushRegistratorAbstractGoogle0.attemptRegistration(s, v, pushRegistratorAbstractGoogle$registerInBackground$10);
            if(object2 == object1) {
                return object1;
            }
            s1 = s;
            v1 = v;
            object0 = object2;
            pushRegistratorAbstractGoogle1 = pushRegistratorAbstractGoogle0;
        label_40:
            if(((RegisterResult)object0) != null) {
                return (RegisterResult)object0;
            }
            pushRegistratorAbstractGoogle$registerInBackground$10.L$0 = pushRegistratorAbstractGoogle1;
            pushRegistratorAbstractGoogle$registerInBackground$10.L$1 = s1;
            pushRegistratorAbstractGoogle$registerInBackground$10.I$0 = v1;
            pushRegistratorAbstractGoogle$registerInBackground$10.label = 2;
            if(DelayKt.delay((v1 + 1) * 10000, pushRegistratorAbstractGoogle$registerInBackground$10) != object1) {
                continue;
            }
            return object1;
        }
        return new RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_INIT_ERROR);
    }
}

