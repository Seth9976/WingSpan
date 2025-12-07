package com.onesignal.user.subscriptions;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH&J\b\u0010\u000E\u001A\u00020\u000BH&J\b\u0010\u000F\u001A\u00020\u000BH&J\u0010\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/subscriptions/IPushSubscription;", "Lcom/onesignal/user/subscriptions/ISubscription;", "optedIn", "", "getOptedIn", "()Z", "token", "", "getToken", "()Ljava/lang/String;", "addObserver", "", "observer", "Lcom/onesignal/user/subscriptions/IPushSubscriptionObserver;", "optIn", "optOut", "removeObserver", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IPushSubscription extends ISubscription {
    void addObserver(IPushSubscriptionObserver arg1);

    boolean getOptedIn();

    String getToken();

    void optIn();

    void optOut();

    void removeObserver(IPushSubscriptionObserver arg1);
}

