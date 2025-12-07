package com.onesignal.user.internal.operations.impl.listeners;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.ModelStoreListener;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0002\u0010\u000BJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\u0010\u0010\u000F\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J4\u0010\u0010\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0014\u001A\u0004\u0018\u00010\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/listeners/SubscriptionModelStoreListener;", "Lcom/onesignal/core/internal/operations/listeners/ModelStoreListener;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "store", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "getAddOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "getRemoveOperation", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionModelStoreListener extends ModelStoreListener {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001A\u00020\b¨\u0006\t"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/listeners/SubscriptionModelStoreListener$Companion;", "", "()V", "getSubscriptionEnabledAndStatus", "Lkotlin/Pair;", "", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final Pair getSubscriptionEnabledAndStatus(SubscriptionModel subscriptionModel0) {
            Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
            if(subscriptionModel0.getOptedIn() && subscriptionModel0.getStatus() == SubscriptionStatus.SUBSCRIBED && subscriptionModel0.getAddress().length() > 0) {
                return new Pair(Boolean.TRUE, SubscriptionStatus.SUBSCRIBED);
            }
            return subscriptionModel0.getOptedIn() ? new Pair(Boolean.FALSE, subscriptionModel0.getStatus()) : new Pair(Boolean.FALSE, SubscriptionStatus.UNSUBSCRIBE);
        }
    }

    public static final Companion Companion;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;

    static {
        SubscriptionModelStoreListener.Companion = new Companion(null);
    }

    public SubscriptionModelStoreListener(SubscriptionModelStore subscriptionModelStore0, IOperationRepo iOperationRepo0, IdentityModelStore identityModelStore0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(subscriptionModelStore0, "store");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "opRepo");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super(subscriptionModelStore0, iOperationRepo0);
        this._identityModelStore = identityModelStore0;
        this._configModelStore = configModelStore0;
    }

    @Override  // com.onesignal.core.internal.operations.listeners.ModelStoreListener
    public Operation getAddOperation(Model model0) {
        return this.getAddOperation(((SubscriptionModel)model0));
    }

    public Operation getAddOperation(SubscriptionModel subscriptionModel0) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        Pair pair0 = SubscriptionModelStoreListener.Companion.getSubscriptionEnabledAndStatus(subscriptionModel0);
        return new CreateSubscriptionOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), subscriptionModel0.getId(), subscriptionModel0.getType(), ((Boolean)pair0.getFirst()).booleanValue(), subscriptionModel0.getAddress(), ((SubscriptionStatus)pair0.getSecond()));
    }

    @Override  // com.onesignal.core.internal.operations.listeners.ModelStoreListener
    public Operation getRemoveOperation(Model model0) {
        return this.getRemoveOperation(((SubscriptionModel)model0));
    }

    public Operation getRemoveOperation(SubscriptionModel subscriptionModel0) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        return new DeleteSubscriptionOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), subscriptionModel0.getId());
    }

    @Override  // com.onesignal.core.internal.operations.listeners.ModelStoreListener
    public Operation getUpdateOperation(Model model0, String s, String s1, Object object0, Object object1) {
        return this.getUpdateOperation(((SubscriptionModel)model0), s, s1, object0, object1);
    }

    public Operation getUpdateOperation(SubscriptionModel subscriptionModel0, String s, String s1, Object object0, Object object1) {
        Intrinsics.checkNotNullParameter(subscriptionModel0, "model");
        Intrinsics.checkNotNullParameter(s, "path");
        Intrinsics.checkNotNullParameter(s1, "property");
        Pair pair0 = SubscriptionModelStoreListener.Companion.getSubscriptionEnabledAndStatus(subscriptionModel0);
        return new UpdateSubscriptionOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), subscriptionModel0.getId(), subscriptionModel0.getType(), ((Boolean)pair0.getFirst()).booleanValue(), subscriptionModel0.getAddress(), ((SubscriptionStatus)pair0.getSecond()));
    }
}

