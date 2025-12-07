package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\u001C\u0010!\u001A\u00020\"2\u0012\u0010#\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030$H\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000BR(\u0010\u0014\u001A\u0004\u0018\u00010\u00032\b\u0010\t\u001A\u0004\u0018\u00010\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0015\u0010\u000B\"\u0004\b\u0016\u0010\rR(\u0010\u0005\u001A\u0004\u0018\u00010\u00032\b\u0010\t\u001A\u0004\u0018\u00010\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0017\u0010\u000B\"\u0004\b\u0018\u0010\rR\u0014\u0010\u0019\u001A\u00020\u001AX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u000BR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010\u000B\"\u0004\b \u0010\r¨\u0006%"}, d2 = {"Lcom/onesignal/user/internal/operations/LoginUserOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "externalId", "existingOneSignalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "value", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "existingOnesignalId", "getExistingOnesignalId", "setExistingOnesignalId", "getExternalId", "setExternalId", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LoginUserOperation extends Operation {
    private final GroupComparisonType groupComparisonType;
    private final String modifyComparisonKey;

    public LoginUserOperation() {
        super("login-user");
        this.modifyComparisonKey = "";
        this.groupComparisonType = GroupComparisonType.CREATE;
    }

    public LoginUserOperation(String s, String s1, String s2, String s3) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        this();
        this.setAppId(s);
        this.setOnesignalId(s1);
        this.setExternalId(s2);
        this.setExistingOnesignalId(s3);
    }

    public LoginUserOperation(String s, String s1, String s2, String s3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            s3 = null;
        }
        this(s, s1, s2, s3);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public boolean getCanStartExecute() {
        if(this.getExistingOnesignalId() != null) {
            String s = this.getExistingOnesignalId();
            Intrinsics.checkNotNull(s);
            return !IDManager.INSTANCE.isLocalId(s);
        }
        return true;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getCreateComparisonKey() {
        return this.getAppId() + ".User." + this.getOnesignalId();
    }

    public final String getExistingOnesignalId() {
        return Model.getOptStringProperty$default(this, "existingOnesignalId", null, 2, null);
    }

    public final String getExternalId() {
        return Model.getOptStringProperty$default(this, "externalId", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getModifyComparisonKey() {
        return this.modifyComparisonKey;
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    private final void setAppId(String s) {
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    private final void setExistingOnesignalId(String s) {
        Model.setOptStringProperty$default(this, "existingOnesignalId", s, null, false, 12, null);
    }

    private final void setExternalId(String s) {
        Model.setOptStringProperty$default(this, "externalId", s, null, false, 12, null);
    }

    private final void setOnesignalId(String s) {
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public void translateIds(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "map");
        if(map0.containsKey(this.getExistingOnesignalId())) {
            Object object0 = map0.get(this.getExistingOnesignalId());
            Intrinsics.checkNotNull(object0);
            this.setExistingOnesignalId(((String)object0));
        }
    }
}

