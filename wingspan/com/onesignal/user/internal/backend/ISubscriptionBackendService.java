package com.onesignal.user.internal.backend;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ-\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000F2\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ1\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J)\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "", "createSubscription", "", "appId", "aliasLabel", "aliasValue", "subscription", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdentityFromSubscription", "", "transferSubscription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "(Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISubscriptionBackendService {
    Object createSubscription(String arg1, String arg2, String arg3, SubscriptionObject arg4, Continuation arg5);

    Object deleteSubscription(String arg1, String arg2, Continuation arg3);

    Object getIdentityFromSubscription(String arg1, String arg2, Continuation arg3);

    Object transferSubscription(String arg1, String arg2, String arg3, String arg4, Continuation arg5);

    Object updateSubscription(String arg1, String arg2, SubscriptionObject arg3, Continuation arg4);
}

