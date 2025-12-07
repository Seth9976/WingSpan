package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B?\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\f\u00A2\u0006\u0002\u0010\rB\u0005\u00A2\u0006\u0002\u0010\u000EJ\u001C\u00100\u001A\u0002012\u0012\u00102\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000303H\u0016R$\u0010\n\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00038F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00038F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\t8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u00038VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\u0011R$\u0010\b\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\t8F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u001B\u0010\u0018\"\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u001FX\u0096\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00038VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b#\u0010\u0011R$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00038F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R$\u0010\u000B\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f8F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R$\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00038F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R$\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00078F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/\u00A8\u00064"}, d2 = {"Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "subscriptionId", "type", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "enabled", "", "address", "status", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/subscriptions/SubscriptionType;ZLjava/lang/String;Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "()V", "value", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAppId", "setAppId", "canStartExecute", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "getEnabled", "setEnabled", "(Z)V", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "getSubscriptionId", "setSubscriptionId", "getType", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "setType", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionType;)V", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UpdateSubscriptionOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public UpdateSubscriptionOperation() {
        super("update-subscription");
        this.groupComparisonType = GroupComparisonType.ALTER;
    }

    public UpdateSubscriptionOperation(String s, String s1, String s2, SubscriptionType subscriptionType0, boolean z, String s3, SubscriptionStatus subscriptionStatus0) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        Intrinsics.checkNotNullParameter(s2, "subscriptionId");
        Intrinsics.checkNotNullParameter(subscriptionType0, "type");
        Intrinsics.checkNotNullParameter(s3, "address");
        Intrinsics.checkNotNullParameter(subscriptionStatus0, "status");
        this();
        this.setAppId(s);
        this.setOnesignalId(s1);
        this.setSubscriptionId(s2);
        this.setType(subscriptionType0);
        this.setEnabled(z);
        this.setAddress(s3);
        this.setStatus(subscriptionStatus0);
    }

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", null, 2, null);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public boolean getCanStartExecute() {
        String s = this.getOnesignalId();
        if(!IDManager.INSTANCE.isLocalId(s)) {
            String s1 = this.getOnesignalId();
            return !IDManager.INSTANCE.isLocalId(s1);
        }
        return false;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getCreateComparisonKey() {
        return this.getAppId() + ".User." + this.getOnesignalId();
    }

    public final boolean getEnabled() {
        return Model.getBooleanProperty$default(this, "enabled", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getModifyComparisonKey() {
        return this.getAppId() + ".User." + this.getOnesignalId() + ".Subscription." + this.getSubscriptionId();
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    public final SubscriptionStatus getStatus() {
        Enum enum0 = null;
        Object object0 = Model.getOptAnyProperty$default(this, "status", null, 2, null);
        if(object0 != null) {
            if(object0 instanceof SubscriptionStatus) {
                enum0 = (Enum)object0;
            }
            else if(object0 instanceof String) {
                enum0 = SubscriptionStatus.valueOf(((String)object0));
            }
            else {
                if(object0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
                }
                enum0 = (SubscriptionStatus)object0;
            }
        }
        if(enum0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
        }
        return (SubscriptionStatus)enum0;
    }

    public final String getSubscriptionId() {
        return Model.getStringProperty$default(this, "subscriptionId", null, 2, null);
    }

    public final SubscriptionType getType() {
        Enum enum0 = null;
        Object object0 = Model.getOptAnyProperty$default(this, "type", null, 2, null);
        if(object0 != null) {
            if(object0 instanceof SubscriptionType) {
                enum0 = (Enum)object0;
            }
            else if(object0 instanceof String) {
                enum0 = SubscriptionType.valueOf(((String)object0));
            }
            else {
                if(object0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
                }
                enum0 = (SubscriptionType)object0;
            }
        }
        if(enum0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
        }
        return (SubscriptionType)enum0;
    }

    private final void setAddress(String s) {
        Model.setStringProperty$default(this, "address", s, null, false, 12, null);
    }

    private final void setAppId(String s) {
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    private final void setEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "enabled", z, null, false, 12, null);
    }

    private final void setOnesignalId(String s) {
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    private final void setStatus(SubscriptionStatus subscriptionStatus0) {
        this.setOptAnyProperty("status", (subscriptionStatus0 == null ? null : subscriptionStatus0.toString()), "NORMAL", false);
    }

    private final void setSubscriptionId(String s) {
        Model.setStringProperty$default(this, "subscriptionId", s, null, false, 12, null);
    }

    private final void setType(SubscriptionType subscriptionType0) {
        this.setOptAnyProperty("type", (subscriptionType0 == null ? null : subscriptionType0.toString()), "NORMAL", false);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public void translateIds(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "map");
        if(map0.containsKey(this.getOnesignalId())) {
            Object object0 = map0.get(this.getOnesignalId());
            Intrinsics.checkNotNull(object0);
            this.setOnesignalId(((String)object0));
        }
        if(map0.containsKey(this.getSubscriptionId())) {
            Object object1 = map0.get(this.getSubscriptionId());
            Intrinsics.checkNotNull(object1);
            this.setSubscriptionId(((String)object1));
        }
    }
}

