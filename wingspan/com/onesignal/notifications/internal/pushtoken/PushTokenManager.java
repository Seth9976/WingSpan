package com.onesignal.notifications.internal.pushtoken;

import com.onesignal.core.internal.device.IDeviceService.AndroidSupportLibraryStatus;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000EH\u0002J\u0011\u0010\u0016\u001A\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/onesignal/notifications/internal/pushtoken/PushTokenManager;", "Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;", "_pushRegistrator", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "(Lcom/onesignal/notifications/internal/registration/IPushRegistrator;Lcom/onesignal/core/internal/device/IDeviceService;)V", "pushToken", "", "getPushToken", "()Ljava/lang/String;", "setPushToken", "(Ljava/lang/String;)V", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "getPushTokenStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setPushTokenStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "pushStatusRuntimeError", "", "status", "retrievePushToken", "Lcom/onesignal/notifications/internal/pushtoken/PushTokenResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PushTokenManager implements IPushTokenManager {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[AndroidSupportLibraryStatus.values().length];
            arr_v[AndroidSupportLibraryStatus.MISSING.ordinal()] = 1;
            arr_v[AndroidSupportLibraryStatus.OUTDATED.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private final IDeviceService _deviceService;
    private final IPushRegistrator _pushRegistrator;
    private String pushToken;
    private SubscriptionStatus pushTokenStatus;

    public PushTokenManager(IPushRegistrator iPushRegistrator0, IDeviceService iDeviceService0) {
        Intrinsics.checkNotNullParameter(iPushRegistrator0, "_pushRegistrator");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        super();
        this._pushRegistrator = iPushRegistrator0;
        this._deviceService = iDeviceService0;
        this.pushTokenStatus = SubscriptionStatus.NO_PERMISSION;
    }

    public final String getPushToken() {
        return this.pushToken;
    }

    public final SubscriptionStatus getPushTokenStatus() {
        return this.pushTokenStatus;
    }

    private final boolean pushStatusRuntimeError(SubscriptionStatus subscriptionStatus0) {
        return subscriptionStatus0.getValue() < -6;
    }

    @Override  // com.onesignal.notifications.internal.pushtoken.IPushTokenManager
    public Object retrievePushToken(Continuation continuation0) {
        PushTokenManager pushTokenManager0;
        com.onesignal.notifications.internal.pushtoken.PushTokenManager.retrievePushToken.1 pushTokenManager$retrievePushToken$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.pushtoken.PushTokenManager.retrievePushToken.1) {
            pushTokenManager$retrievePushToken$10 = (com.onesignal.notifications.internal.pushtoken.PushTokenManager.retrievePushToken.1)continuation0;
            if((pushTokenManager$retrievePushToken$10.label & 0x80000000) == 0) {
                pushTokenManager$retrievePushToken$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.retrievePushToken(this);
                    }
                };
            }
            else {
                pushTokenManager$retrievePushToken$10.label ^= 0x80000000;
            }
        }
        else {
            pushTokenManager$retrievePushToken$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.retrievePushToken(this);
                }
            };
        }
        Object object0 = pushTokenManager$retrievePushToken$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    alab1:
        switch(pushTokenManager$retrievePushToken$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                switch(WhenMappings.$EnumSwitchMapping$0[this._deviceService.getAndroidSupportLibraryStatus().ordinal()]) {
                    case 1: {
                        Logging.fatal$default("Could not find the Android Support Library. Please make sure it has been correctly added to your project.", null, 2, null);
                        this.pushTokenStatus = SubscriptionStatus.MISSING_ANDROID_SUPPORT_LIBRARY;
                        return new PushTokenResponse(this.pushToken, this.pushTokenStatus);
                    }
                    case 2: {
                        Logging.fatal$default("The included Android Support Library is too old or incomplete. Please update to the 26.0.0 revision or newer.", null, 2, null);
                        this.pushTokenStatus = SubscriptionStatus.OUTDATED_ANDROID_SUPPORT_LIBRARY;
                        return new PushTokenResponse(this.pushToken, this.pushTokenStatus);
                    label_21:
                        pushTokenManager$retrievePushToken$10.L$0 = this;
                        pushTokenManager$retrievePushToken$10.label = 1;
                        object0 = this._pushRegistrator.registerForPush(pushTokenManager$retrievePushToken$10);
                        if(object0 == object1) {
                            return object1;
                        }
                        pushTokenManager0 = this;
                        break alab1;
                    }
                    default: {
                        goto label_21;
                    }
                }
            }
            case 1: {
                pushTokenManager0 = (PushTokenManager)pushTokenManager$retrievePushToken$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((RegisterResult)object0).getStatus().getValue() == SubscriptionStatus.SUBSCRIBED.getValue()) {
            pushTokenManager0.pushTokenStatus = ((RegisterResult)object0).getStatus();
        }
        else if(((RegisterResult)object0).getStatus().getValue() >= SubscriptionStatus.SUBSCRIBED.getValue()) {
            if(pushTokenManager0.pushStatusRuntimeError(pushTokenManager0.pushTokenStatus)) {
                pushTokenManager0.pushTokenStatus = ((RegisterResult)object0).getStatus();
            }
        }
        else if(pushTokenManager0.pushToken == null && (pushTokenManager0.pushTokenStatus == SubscriptionStatus.NO_PERMISSION || pushTokenManager0.pushStatusRuntimeError(pushTokenManager0.pushTokenStatus))) {
            pushTokenManager0.pushTokenStatus = ((RegisterResult)object0).getStatus();
        }
        pushTokenManager0.pushToken = ((RegisterResult)object0).getId();
        return new PushTokenResponse(pushTokenManager0.pushToken, pushTokenManager0.pushTokenStatus);
    }

    public final void setPushToken(String s) {
        this.pushToken = s;
    }

    public final void setPushTokenStatus(SubscriptionStatus subscriptionStatus0) {
        Intrinsics.checkNotNullParameter(subscriptionStatus0, "<set-?>");
        this.pushTokenStatus = subscriptionStatus0;
    }
}

