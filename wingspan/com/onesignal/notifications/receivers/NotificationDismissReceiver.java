package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/receivers/NotificationDismissReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationDismissReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(intent0, "intent");
        Context context1 = context0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context1, "context.applicationContext");
        if(!OneSignal.initWithContext(context1)) {
            return;
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessor.class);
        ThreadUtilsKt.suspendifyBlocking(new Function1(context0, intent0, null) {
            final Context $context;
            final Intent $intent;
            final ObjectRef $notificationOpenedProcessor;
            int label;

            {
                this.$notificationOpenedProcessor = ref$ObjectRef0;
                this.$context = context0;
                this.$intent = intent0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.receivers.NotificationDismissReceiver.onReceive.1(this.$notificationOpenedProcessor, this.$context, this.$intent, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.receivers.NotificationDismissReceiver.onReceive.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return ((INotificationOpenedProcessor)this.$notificationOpenedProcessor.element).processFromContext(this.$context, this.$intent, this) == object1 ? object1 : Unit.INSTANCE;
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
}

