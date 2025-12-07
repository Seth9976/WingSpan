package com.onesignal.notifications.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/activities/NotificationOpenedActivityBase;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class NotificationOpenedActivityBase extends Activity {
    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Context context0 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context0, "applicationContext");
        if(!OneSignal.initWithContext(context0)) {
            return;
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = this;
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(this, null) {
            final ObjectRef $self;
            int label;

            {
                this.$self = ref$ObjectRef0;
                NotificationOpenedActivityBase.this = notificationOpenedActivityBase0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.activities.NotificationOpenedActivityBase.onCreate.1(this.$self, NotificationOpenedActivityBase.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.activities.NotificationOpenedActivityBase.onCreate.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        INotificationOpenedProcessor iNotificationOpenedProcessor0 = (INotificationOpenedProcessor)OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessor.class);
                        Context context0 = (Context)this.$self.element;
                        Intent intent0 = NotificationOpenedActivityBase.this.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent0, "intent");
                        this.label = 1;
                        return iNotificationOpenedProcessor0.processFromContext(context0, intent0, this) == object1 ? object1 : Unit.INSTANCE;
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
        this.finish();
    }

    @Override  // android.app.Activity
    protected void onNewIntent(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        super.onNewIntent(intent0);
        Context context0 = this.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context0, "applicationContext");
        if(!OneSignal.initWithContext(context0)) {
            return;
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ref$ObjectRef0.element = this;
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(this, null) {
            final ObjectRef $self;
            int label;

            {
                this.$self = ref$ObjectRef0;
                NotificationOpenedActivityBase.this = notificationOpenedActivityBase0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.notifications.activities.NotificationOpenedActivityBase.onNewIntent.1(this.$self, NotificationOpenedActivityBase.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.notifications.activities.NotificationOpenedActivityBase.onNewIntent.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        INotificationOpenedProcessor iNotificationOpenedProcessor0 = (INotificationOpenedProcessor)OneSignal.INSTANCE.getServices().getService(INotificationOpenedProcessor.class);
                        Context context0 = (Context)this.$self.element;
                        Intent intent0 = NotificationOpenedActivityBase.this.getIntent();
                        Intrinsics.checkNotNullExpressionValue(intent0, "getIntent()");
                        this.label = 1;
                        return iNotificationOpenedProcessor0.processFromContext(context0, intent0, this) == object1 ? object1 : Unit.INSTANCE;
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
        this.finish();
    }
}

