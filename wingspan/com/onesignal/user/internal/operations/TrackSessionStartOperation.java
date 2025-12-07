package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001C\u0010\u001A\u001A\u00020\u001B2\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001DH\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001A\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\tR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000B¨\u0006\u001E"}, d2 = {"Lcom/onesignal/user/internal/operations/TrackSessionStartOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "(Ljava/lang/String;Ljava/lang/String;)V", "()V", "value", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TrackSessionStartOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public TrackSessionStartOperation() {
        super("track-session-start");
        this.groupComparisonType = GroupComparisonType.ALTER;
    }

    public TrackSessionStartOperation(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        this();
        this.setAppId(s);
        this.setOnesignalId(s1);
    }

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", null, 2, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public boolean getCanStartExecute() {
        String s = this.getOnesignalId();
        return !IDManager.INSTANCE.isLocalId(s);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getCreateComparisonKey() {
        return "";
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public GroupComparisonType getGroupComparisonType() {
        return this.groupComparisonType;
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public String getModifyComparisonKey() {
        return this.getAppId() + ".User." + this.getOnesignalId();
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    private final void setAppId(String s) {
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    private final void setOnesignalId(String s) {
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    @Override  // com.onesignal.core.internal.operations.Operation
    public void translateIds(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "map");
        if(map0.containsKey(this.getOnesignalId())) {
            Object object0 = map0.get(this.getOnesignalId());
            Intrinsics.checkNotNull(object0);
            this.setOnesignalId(((String)object0));
        }
    }
}

