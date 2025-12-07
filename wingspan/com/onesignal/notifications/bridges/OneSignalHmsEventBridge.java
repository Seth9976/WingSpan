package com.onesignal.notifications.bridges;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.push.RemoteMessage;
import com.onesignal.OneSignal;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rJ\u0018\u0010\u000E\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0004H\u0007J \u0010\u000E\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/onesignal/notifications/bridges/OneSignalHmsEventBridge;", "", "()V", "HMS_SENT_TIME_KEY", "", "HMS_TTL_KEY", "firstToken", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onMessageReceived", "", "context", "Landroid/content/Context;", "message", "Lcom/huawei/hms/push/RemoteMessage;", "onNewToken", "token", "bundle", "Landroid/os/Bundle;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignalHmsEventBridge {
    public static final String HMS_SENT_TIME_KEY = "hms.sent_time";
    public static final String HMS_TTL_KEY = "hms.ttl";
    public static final OneSignalHmsEventBridge INSTANCE;
    private static final AtomicBoolean firstToken;

    static {
        OneSignalHmsEventBridge.INSTANCE = new OneSignalHmsEventBridge();
        OneSignalHmsEventBridge.firstToken = new AtomicBoolean(true);
    }

    public final void onMessageReceived(Context context0, RemoteMessage remoteMessage0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(remoteMessage0, "message");
        if(!OneSignal.initWithContext(context0)) {
            return;
        }
        ITime iTime0 = (ITime)OneSignal.INSTANCE.getServices().getService(ITime.class);
        INotificationBundleProcessor iNotificationBundleProcessor0 = (INotificationBundleProcessor)OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
        String s = remoteMessage0.getData();
        try {
            JSONObject jSONObject0 = new JSONObject(remoteMessage0.getData());
            if(remoteMessage0.getTtl() == 0) {
                jSONObject0.put("hms.ttl", 0x3F480);
            }
            else {
                jSONObject0.put("hms.ttl", remoteMessage0.getTtl());
            }
            if(Long.compare(remoteMessage0.getSentTime(), 0L) == 0) {
                jSONObject0.put("hms.sent_time", iTime0.getCurrentTimeMillis());
            }
            else {
                jSONObject0.put("hms.sent_time", remoteMessage0.getSentTime());
            }
            s = jSONObject0.toString();
        }
        catch(JSONException unused_ex) {
            Logging.error$default("OneSignalHmsEventBridge error when trying to create RemoteMessage data JSON", null, 2, null);
        }
        if(s == null) {
            return;
        }
        Bundle bundle0 = JSONUtils.INSTANCE.jsonStringToBundle(s);
        if(bundle0 == null) {
            return;
        }
        iNotificationBundleProcessor0.processBundleFromReceiver(context0, bundle0);
    }

    @Deprecated(message = "")
    public final void onNewToken(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(s, "token");
        this.onNewToken(context0, s, null);
    }

    public final void onNewToken(Context context0, String s, Bundle bundle0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(s, "token");
        if(OneSignalHmsEventBridge.firstToken.compareAndSet(true, false)) {
            Logging.info$default(("OneSignalHmsEventBridge onNewToken - HMS token: " + s + " Bundle: " + bundle0), null, 2, null);
            ObjectRef ref$ObjectRef0 = new ObjectRef();
            ref$ObjectRef0.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, null) {
                final ObjectRef $registerer;
                final String $token;
                int label;

                {
                    this.$registerer = ref$ObjectRef0;
                    this.$token = s;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.notifications.bridges.OneSignalHmsEventBridge.onNewToken.1(this.$registerer, this.$token, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.notifications.bridges.OneSignalHmsEventBridge.onNewToken.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return ((IPushRegistratorCallback)this.$registerer.element).fireCallback(this.$token, this) == object1 ? object1 : Unit.INSTANCE;
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
            return;
        }
        Logging.info$default(("OneSignalHmsEventBridge ignoring onNewToken - HMS token: " + s + " Bundle: " + bundle0), null, 2, null);
    }
}

