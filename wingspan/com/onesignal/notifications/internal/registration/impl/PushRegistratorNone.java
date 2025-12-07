package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001B\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001A\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorNone;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "()V", "fireCallback", "", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerForPush", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PushRegistratorNone implements IPushRegistrator, IPushRegistratorCallback {
    @Override  // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String s, Continuation continuation0) {
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(Continuation continuation0) {
        return new RegisterResult(null, SubscriptionStatus.ERROR);
    }
}

