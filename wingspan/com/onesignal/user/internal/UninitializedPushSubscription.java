package com.onesignal.user.internal;

import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/onesignal/user/internal/UninitializedPushSubscription;", "Lcom/onesignal/user/internal/PushSubscription;", "()V", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UninitializedPushSubscription extends PushSubscription {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/UninitializedPushSubscription$Companion;", "", "()V", "createFakePushSub", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final SubscriptionModel createFakePushSub() {
            SubscriptionModel subscriptionModel0 = new SubscriptionModel();
            subscriptionModel0.setId("");
            subscriptionModel0.setType(SubscriptionType.PUSH);
            subscriptionModel0.setOptedIn(false);
            subscriptionModel0.setAddress("");
            return subscriptionModel0;
        }
    }

    public static final Companion Companion;

    static {
        UninitializedPushSubscription.Companion = new Companion(null);
    }

    public UninitializedPushSubscription() {
        super(UninitializedPushSubscription.Companion.createFakePushSub());
    }
}

