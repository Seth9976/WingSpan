package com.onesignal.notifications.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0014J\b\u0010\n\u001A\u00020\u0004H\u0002J\u0012\u0010\u000B\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0002¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/activities/NotificationOpenedActivityHMS;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "processIntent", "processOpen", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationOpenedActivityHMS extends Activity {
    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.processIntent();
    }

    @Override  // android.app.Activity
    protected void onNewIntent(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        super.onNewIntent(intent0);
        this.processIntent();
    }

    private final void processIntent() {
        this.processOpen(this.getIntent());
        this.finish();
    }

    private final void processOpen(Intent intent0) {
        Context context0 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context0, "applicationContext");
        if(!OneSignal.initWithContext(context0)) {
            return;
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessorHMS.class);
        ThreadUtilsKt.suspendifyBlocking(new Function1(this, intent0, null) {
            final Intent $intent;
            final ObjectRef $notificationPayloadProcessorHMS;
            final NotificationOpenedActivityHMS $self;
            int label;

            {
                this.$notificationPayloadProcessorHMS = ref$ObjectRef0;
                this.$self = notificationOpenedActivityHMS0;
                this.$intent = intent0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.activities.NotificationOpenedActivityHMS.processOpen.1(this.$notificationPayloadProcessorHMS, this.$self, this.$intent, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.activities.NotificationOpenedActivityHMS.processOpen.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return ((INotificationOpenedProcessorHMS)this.$notificationPayloadProcessorHMS.element).handleHMSNotificationOpenIntent(this.$self, this.$intent, this) == object1 ? object1 : Unit.INSTANCE;
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

