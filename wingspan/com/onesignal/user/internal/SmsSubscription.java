package com.onesignal.user.internal;

import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.subscriptions.ISmsSubscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/SmsSubscription;", "Lcom/onesignal/user/internal/Subscription;", "Lcom/onesignal/user/subscriptions/ISmsSubscription;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;)V", "number", "", "getNumber", "()Ljava/lang/String;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SmsSubscription extends Subscription implements ISmsSubscription {
    public SmsSubscription(SubscriptionModel subscriptionModel0) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        super(subscriptionModel0);
    }

    @Override  // com.onesignal.user.subscriptions.ISmsSubscription
    public String getNumber() {
        return this.getModel().getAddress();
    }
}

