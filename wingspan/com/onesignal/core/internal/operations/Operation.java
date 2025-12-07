package com.onesignal.core.internal.operations;

import com.onesignal.common.modeling.Model;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001A\u00020\u0003H\u0016J\u001C\u0010\u0016\u001A\u00020\u00172\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\u0016R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000BR$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0013\u0010\u000B\"\u0004\b\u0014\u0010\u0004¨\u0006\u001A"}, d2 = {"Lcom/onesignal/core/internal/operations/Operation;", "Lcom/onesignal/common/modeling/Model;", "name", "", "(Ljava/lang/String;)V", "canStartExecute", "", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "()Ljava/lang/String;", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "value", "getName", "setName", "toString", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class Operation extends Model {
    public Operation(String s) {
        Intrinsics.checkNotNullParameter(s, "name");
        super(null, null, 3, null);
        this.setName(s);
    }

    public abstract boolean getCanStartExecute();

    public abstract String getCreateComparisonKey();

    public abstract GroupComparisonType getGroupComparisonType();

    public abstract String getModifyComparisonKey();

    public final String getName() {
        return Model.getStringProperty$default(this, "name", null, 2, null);
    }

    private final void setName(String s) {
        Model.setStringProperty$default(this, "name", s, null, false, 12, null);
    }

    @Override
    public String toString() {
        String s = this.toJSON().toString();
        Intrinsics.checkNotNullExpressionValue(s, "toJSON().toString()");
        return s;
    }

    public void translateIds(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "map");
    }
}

