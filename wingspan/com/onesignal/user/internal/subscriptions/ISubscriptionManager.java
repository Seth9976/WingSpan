package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.events.IEventNotifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H&J\u001A\u0010\u0011\u001A\u00020\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001A\u00020\u0014H&J\u0010\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0010H&J\u0010\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0010\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0010H&R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001A\u00020\bX¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "pushSubscriptionModel", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "getPushSubscriptionModel", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "setSubscriptions", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionList;)V", "addEmailSubscription", "", "email", "", "addOrUpdatePushSubscriptionToken", "pushToken", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "addSmsSubscription", "sms", "removeEmailSubscription", "removeSmsSubscription", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISubscriptionManager extends IEventNotifier {
    void addEmailSubscription(String arg1);

    void addOrUpdatePushSubscriptionToken(String arg1, SubscriptionStatus arg2);

    void addSmsSubscription(String arg1);

    SubscriptionModel getPushSubscriptionModel();

    SubscriptionList getSubscriptions();

    void removeEmailSubscription(String arg1);

    void removeSmsSubscription(String arg1);

    void setSubscriptions(SubscriptionList arg1);
}

