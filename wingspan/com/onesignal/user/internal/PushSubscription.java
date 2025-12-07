package com.onesignal.user.internal;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.Model;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.IPushSubscriptionObserver;
import com.onesignal.user.subscriptions.PushSubscriptionState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\bH\u0016J\b\u0010\u001B\u001A\u00020\u0010H\u0002J\b\u0010\u001C\u001A\u00020\u0019H\u0016J\b\u0010\u001D\u001A\u00020\u0019H\u0016J\u0006\u0010\u001E\u001A\u00020\u0010J\u0010\u0010\u001F\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\bH\u0016R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u001E\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u0010@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/onesignal/user/internal/PushSubscription;", "Lcom/onesignal/user/internal/Subscription;", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;)V", "changeHandlersNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/subscriptions/IPushSubscriptionObserver;", "getChangeHandlersNotifier", "()Lcom/onesignal/common/events/EventProducer;", "optedIn", "", "getOptedIn", "()Z", "<set-?>", "Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "savedState", "getSavedState", "()Lcom/onesignal/user/subscriptions/PushSubscriptionState;", "token", "", "getToken", "()Ljava/lang/String;", "addObserver", "", "observer", "fetchState", "optIn", "optOut", "refreshState", "removeObserver", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class PushSubscription extends Subscription implements IPushSubscription {
    private final EventProducer changeHandlersNotifier;
    private PushSubscriptionState savedState;

    public PushSubscription(SubscriptionModel subscriptionModel0) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        super(subscriptionModel0);
        this.changeHandlersNotifier = new EventProducer();
        this.savedState = this.fetchState();
    }

    @Override  // com.onesignal.user.subscriptions.IPushSubscription
    public void addObserver(IPushSubscriptionObserver iPushSubscriptionObserver0) {
        Intrinsics.checkNotNullParameter(iPushSubscriptionObserver0, "observer");
        this.changeHandlersNotifier.subscribe(iPushSubscriptionObserver0);
    }

    private final PushSubscriptionState fetchState() {
        return new PushSubscriptionState(this.getId(), this.getToken(), this.getOptedIn());
    }

    public final EventProducer getChangeHandlersNotifier() {
        return this.changeHandlersNotifier;
    }

    @Override  // com.onesignal.user.subscriptions.IPushSubscription
    public boolean getOptedIn() {
        return this.getModel().getOptedIn() && this.getModel().getStatus() != SubscriptionStatus.NO_PERMISSION;
    }

    public final PushSubscriptionState getSavedState() {
        return this.savedState;
    }

    @Override  // com.onesignal.user.subscriptions.IPushSubscription
    public String getToken() {
        return this.getModel().getAddress();
    }

    @Override  // com.onesignal.user.subscriptions.IPushSubscription
    public void optIn() {
        Model.setBooleanProperty$default(this.getModel(), "optedIn", true, null, true, 4, null);
    }

    @Override  // com.onesignal.user.subscriptions.IPushSubscription
    public void optOut() {
        this.getModel().setOptedIn(false);
    }

    public final PushSubscriptionState refreshState() {
        PushSubscriptionState pushSubscriptionState0 = this.fetchState();
        this.savedState = pushSubscriptionState0;
        return pushSubscriptionState0;
    }

    @Override  // com.onesignal.user.subscriptions.IPushSubscription
    public void removeObserver(IPushSubscriptionObserver iPushSubscriptionObserver0) {
        Intrinsics.checkNotNullParameter(iPushSubscriptionObserver0, "observer");
        this.changeHandlersNotifier.unsubscribe(iPushSubscriptionObserver0);
    }
}

