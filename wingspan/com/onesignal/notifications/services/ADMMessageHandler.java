package com.onesignal.notifications.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0014J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0014J\u0010\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\tH\u0014J\u0010\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\tH\u0014¨\u0006\u000E"}, d2 = {"Lcom/onesignal/notifications/services/ADMMessageHandler;", "Lcom/amazon/device/messaging/ADMMessageHandlerBase;", "()V", "onMessage", "", "intent", "Landroid/content/Intent;", "onRegistered", "newRegistrationId", "", "onRegistrationError", "error", "onUnregistered", "info", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ADMMessageHandler extends ADMMessageHandlerBase {
    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    protected void onMessage(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        Context context0 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context0, "context");
        if(!OneSignal.initWithContext(context0)) {
            return;
        }
        Bundle bundle0 = intent0.getExtras();
        INotificationBundleProcessor iNotificationBundleProcessor0 = (INotificationBundleProcessor)OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
        Intrinsics.checkNotNull(bundle0);
        iNotificationBundleProcessor0.processBundleFromReceiver(context0, bundle0);
    }

    protected void onRegistered(String s) {
        Intrinsics.checkNotNullParameter(s, "newRegistrationId");
        Logging.info$default(("ADM registration ID: " + s), null, 2, null);
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, null) {
            final String $newRegistrationId;
            final ObjectRef $registerer;
            int label;

            {
                this.$registerer = ref$ObjectRef0;
                this.$newRegistrationId = s;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.services.ADMMessageHandler.onRegistered.1(this.$registerer, this.$newRegistrationId, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.services.ADMMessageHandler.onRegistered.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return ((IPushRegistratorCallback)this.$registerer.element).fireCallback(this.$newRegistrationId, this) == object1 ? object1 : Unit.INSTANCE;
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

    protected void onRegistrationError(String s) {
        Intrinsics.checkNotNullParameter(s, "error");
        Logging.error$default(("ADM:onRegistrationError: " + s), null, 2, null);
        if(Intrinsics.areEqual("INVALID_SENDER", s)) {
            Logging.error$default("Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.", null, 2, null);
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            final ObjectRef $registerer;
            int label;

            {
                this.$registerer = ref$ObjectRef0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.services.ADMMessageHandler.onRegistrationError.1(this.$registerer, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.services.ADMMessageHandler.onRegistrationError.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return ((IPushRegistratorCallback)this.$registerer.element).fireCallback(null, this) == object1 ? object1 : Unit.INSTANCE;
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

    protected void onUnregistered(String s) {
        Intrinsics.checkNotNullParameter(s, "info");
        Logging.info$default(("ADM:onUnregistered: " + s), null, 2, null);
    }
}

