package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u001C\u0010\u001D\u001A\u00020\u001E2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 H\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001A\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\nR$\u0010\u0005\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\n\"\u0004\b\u001A\u0010\fR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\n\"\u0004\b\u001C\u0010\f¨\u0006!"}, d2 = {"Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "subscriptionId", "onesignalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "value", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getSubscriptionId", "setSubscriptionId", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TransferSubscriptionOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public TransferSubscriptionOperation() {
        super("transfer-subscription");
        this.groupComparisonType = GroupComparisonType.NONE;
    }

    public TransferSubscriptionOperation(String s, String s1, String s2) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "subscriptionId");
        Intrinsics.checkNotNullParameter(s2, "onesignalId");
        this();
        this.setAppId(s);
        this.setSubscriptionId(s1);
        this.setOnesignalId(s2);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public boolean getCanStartExecute() {
        String s = this.getOnesignalId();
        if(!IDManager.INSTANCE.isLocalId(s)) {
            String s1 = this.getSubscriptionId();
            return !IDManager.INSTANCE.isLocalId(s1);
        }
        return false;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getCreateComparisonKey() {
        return this.getAppId() + ".User." + this.getOnesignalId();
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getModifyComparisonKey() {
        return this.getAppId() + ".Subscription." + this.getSubscriptionId() + ".Transfer";
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    public final String getSubscriptionId() {
        return Model.getStringProperty$default(this, "subscriptionId", null, 2, null);
    }

    private final void setAppId(String s) {
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    private final void setOnesignalId(String s) {
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    private final void setSubscriptionId(String s) {
        Model.setStringProperty$default(this, "subscriptionId", s, null, false, 12, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public void translateIds(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "map");
        if(map0.containsKey(this.getSubscriptionId())) {
            Object object0 = map0.get(this.getSubscriptionId());
            Intrinsics.checkNotNull(object0);
            this.setSubscriptionId(((String)object0));
        }
        if(map0.containsKey(this.getOnesignalId())) {
            Object object1 = map0.get(this.getOnesignalId());
            Intrinsics.checkNotNull(object1);
            this.setOnesignalId(((String)object1));
        }
    }
}

