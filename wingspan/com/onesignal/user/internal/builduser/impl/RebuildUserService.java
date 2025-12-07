package com.onesignal.user.internal.builduser.impl;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/builduser/impl/RebuildUserService;", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "getRebuildOperationsIfCurrentUser", "", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class RebuildUserService implements IRebuildUserService {
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;

    public RebuildUserService(IdentityModelStore identityModelStore0, PropertiesModelStore propertiesModelStore0, SubscriptionModelStore subscriptionModelStore0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(subscriptionModelStore0, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super();
        this._identityModelStore = identityModelStore0;
        this._propertiesModelStore = propertiesModelStore0;
        this._subscriptionsModelStore = subscriptionModelStore0;
        this._configModelStore = configModelStore0;
    }

    @Override  // com.onesignal.user.internal.builduser.IRebuildUserService
    public List getRebuildOperationsIfCurrentUser(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        IdentityModel identityModel0 = new IdentityModel();
        Object object0 = null;
        identityModel0.initializeFromModel(null, this._identityModelStore.getModel());
        new PropertiesModel().initializeFromModel(null, this._propertiesModelStore.getModel());
        List list0 = new ArrayList();
        for(Object object1: this._subscriptionsModelStore.list()) {
            SubscriptionModel subscriptionModel0 = new SubscriptionModel();
            subscriptionModel0.initializeFromModel(null, ((SubscriptionModel)object1));
            list0.add(subscriptionModel0);
        }
        if(!Intrinsics.areEqual(identityModel0.getOnesignalId(), s1)) {
            return null;
        }
        List list1 = new ArrayList();
        list1.add(new LoginUserOperation(s, s1, identityModel0.getExternalId(), null, 8, null));
        for(Object object2: list0) {
            if(Intrinsics.areEqual(((SubscriptionModel)object2).getId(), ((ConfigModel)this._configModelStore.getModel()).getPushSubscriptionId())) {
                object0 = object2;
                break;
            }
            if(false) {
                break;
            }
        }
        if(((SubscriptionModel)object0) != null) {
            list1.add(new CreateSubscriptionOperation(s, s1, ((SubscriptionModel)object0).getId(), ((SubscriptionModel)object0).getType(), ((SubscriptionModel)object0).getOptedIn(), ((SubscriptionModel)object0).getAddress(), ((SubscriptionModel)object0).getStatus()));
        }
        list1.add(new RefreshUserOperation(s, s1));
        return list1;
    }
}

