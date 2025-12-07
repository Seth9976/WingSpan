package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.user.subscriptions.ISubscription;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0018\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH&J\u0010\u0010\t\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "", "onSubscriptionAdded", "", "subscription", "Lcom/onesignal/user/subscriptions/ISubscription;", "onSubscriptionChanged", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSubscriptionRemoved", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISubscriptionChangedHandler {
    void onSubscriptionAdded(ISubscription arg1);

    void onSubscriptionChanged(ISubscription arg1, ModelChangedArgs arg2);

    void onSubscriptionRemoved(ISubscription arg1);
}

