package com.onesignal.user.internal.operations;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000EX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001A\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\nR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\n\"\u0004\b\u001A\u0010\fR$\u0010\u0005\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\n\"\u0004\b\u001C\u0010\f¨\u0006\u001D"}, d2 = {"Lcom/onesignal/user/internal/operations/LoginUserFromSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "value", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getSubscriptionId", "setSubscriptionId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LoginUserFromSubscriptionOperation extends Operation {
    private final boolean canStartExecute;
    private final GroupComparisonType groupComparisonType;

    public LoginUserFromSubscriptionOperation() {
        super("login-user-from-subscription");
        this.groupComparisonType = GroupComparisonType.NONE;
        this.canStartExecute = true;
    }

    public LoginUserFromSubscriptionOperation(String s, String s1, String s2) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        Intrinsics.checkNotNullParameter(s2, "subscriptionId");
        this();
        this.setAppId(s);
        this.setOnesignalId(s1);
        this.setSubscriptionId(s2);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public boolean getCanStartExecute() {
        return this.canStartExecute;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getCreateComparisonKey() {
        return this.getAppId() + ".Subscription." + this.getSubscriptionId() + ".Login";
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getModifyComparisonKey() {
        return this.getAppId() + ".Subscription." + this.getSubscriptionId() + ".Login";
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
}

