package com.onesignal.user.internal;

import com.onesignal.common.IDManager;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.subscriptions.ISubscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/onesignal/user/internal/Subscription;", "Lcom/onesignal/user/subscriptions/ISubscription;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;)V", "id", "", "getId", "()Ljava/lang/String;", "getModel", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class Subscription implements ISubscription {
    private final SubscriptionModel model;

    public Subscription(SubscriptionModel subscriptionModel0) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        super();
        this.model = subscriptionModel0;
    }

    @Override  // com.onesignal.user.subscriptions.ISubscription
    public String getId() {
        String s = this.model.getId();
        return IDManager.INSTANCE.isLocalId(s) ? "" : this.model.getId();
    }

    public final SubscriptionModel getModel() {
        return this.model;
    }
}

