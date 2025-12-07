package com.onesignal.user.internal.backend;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/CreateUserResponse;", "", "identities", "", "", "properties", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "subscriptions", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "(Ljava/util/Map;Lcom/onesignal/user/internal/backend/PropertiesObject;Ljava/util/List;)V", "getIdentities", "()Ljava/util/Map;", "getProperties", "()Lcom/onesignal/user/internal/backend/PropertiesObject;", "getSubscriptions", "()Ljava/util/List;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class CreateUserResponse {
    private final Map identities;
    private final PropertiesObject properties;
    private final List subscriptions;

    public CreateUserResponse(Map map0, PropertiesObject propertiesObject0, List list0) {
        Intrinsics.checkNotNullParameter(map0, "identities");
        Intrinsics.checkNotNullParameter(propertiesObject0, "properties");
        Intrinsics.checkNotNullParameter(list0, "subscriptions");
        super();
        this.identities = map0;
        this.properties = propertiesObject0;
        this.subscriptions = list0;
    }

    public final Map getIdentities() {
        return this.identities;
    }

    public final PropertiesObject getProperties() {
        return this.properties;
    }

    public final List getSubscriptions() {
        return this.subscriptions;
    }
}

