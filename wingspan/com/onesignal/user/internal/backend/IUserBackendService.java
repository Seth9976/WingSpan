package com.onesignal.user.internal.backend;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ)\u0010\r\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010JA\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/onesignal/user/internal/backend/IUserBackendService;", "", "createUser", "Lcom/onesignal/user/internal/backend/CreateUserResponse;", "appId", "", "identities", "", "subscriptions", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "properties", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "aliasLabel", "aliasValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "refreshDeviceMetadata", "", "propertyiesDelta", "Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/PropertiesObject;ZLcom/onesignal/user/internal/backend/PropertiesDeltasObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IUserBackendService {
    Object createUser(String arg1, Map arg2, List arg3, Map arg4, Continuation arg5);

    Object getUser(String arg1, String arg2, String arg3, Continuation arg4);

    Object updateUser(String arg1, String arg2, String arg3, PropertiesObject arg4, boolean arg5, PropertiesDeltasObject arg6, Continuation arg7);
}

