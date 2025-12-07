package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\u001C\u0010 \u001A\u00020!2\u0012\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030#H\u0016R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000BR\u0014\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u000BR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u000B\"\u0004\b\u001B\u0010\rR$\u0010\u0005\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00068F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006$"}, d2 = {"Lcom/onesignal/user/internal/operations/TrackSessionEndOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "sessionTime", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "()V", "value", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getSessionTime", "()J", "setSessionTime", "(J)V", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TrackSessionEndOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public TrackSessionEndOperation() {
        super("track-session-end");
        this.groupComparisonType = GroupComparisonType.ALTER;
    }

    public TrackSessionEndOperation(String s, String s1, long v) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        this();
        this.setAppId(s);
        this.setOnesignalId(s1);
        this.setSessionTime(v);
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

    public final long getSessionTime() {
        return Model.getLongProperty$default(this, "sessionTime", null, 2, null);
    }

    private final void setAppId(String s) {
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    private final void setOnesignalId(String s) {
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    private final void setSessionTime(long v) {
        Model.setLongProperty$default(this, "sessionTime", v, null, false, 12, null);
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

