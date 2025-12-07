package com.onesignal.user.internal.operations;

import com.onesignal.common.IDManager;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.Operation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\u0010\fB\u0005¢\u0006\u0002\u0010\rJ\u001E\u0010+\u001A\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010,\u001A\u00020\u00032\u0006\u0010-\u001A\u00020.H\u0014J\u001C\u0010/\u001A\u0002002\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000302H\u0016R$\u0010\u0007\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\b8F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0014R\u0014\u0010\u001C\u001A\u00020\u001DX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0014R$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R0\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R$\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00068F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b(\u0010\u0019\"\u0004\b)\u0010*¨\u00063"}, d2 = {"Lcom/onesignal/user/internal/operations/TrackPurchaseOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "appId", "", "onesignalId", "treatNewAsExisting", "", "amountSpent", "Ljava/math/BigDecimal;", "purchases", "", "Lcom/onesignal/user/internal/operations/PurchaseInfo;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/math/BigDecimal;Ljava/util/List;)V", "()V", "value", "getAmountSpent", "()Ljava/math/BigDecimal;", "setAmountSpent", "(Ljava/math/BigDecimal;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "canStartExecute", "getCanStartExecute", "()Z", "createComparisonKey", "getCreateComparisonKey", "groupComparisonType", "Lcom/onesignal/core/internal/operations/GroupComparisonType;", "getGroupComparisonType", "()Lcom/onesignal/core/internal/operations/GroupComparisonType;", "modifyComparisonKey", "getModifyComparisonKey", "getOnesignalId", "setOnesignalId", "getPurchases", "()Ljava/util/List;", "setPurchases", "(Ljava/util/List;)V", "getTreatNewAsExisting", "setTreatNewAsExisting", "(Z)V", "createListForProperty", "property", "jsonArray", "Lorg/json/JSONArray;", "translateIds", "", "map", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TrackPurchaseOperation extends Operation {
    private final GroupComparisonType groupComparisonType;

    public TrackPurchaseOperation() {
        super("track-purchase");
        this.groupComparisonType = GroupComparisonType.ALTER;
    }

    public TrackPurchaseOperation(String s, String s1, boolean z, BigDecimal bigDecimal0, List list0) {
        Intrinsics.checkNotNullParameter(s, "appId");
        Intrinsics.checkNotNullParameter(s1, "onesignalId");
        Intrinsics.checkNotNullParameter(bigDecimal0, "amountSpent");
        Intrinsics.checkNotNullParameter(list0, "purchases");
        this();
        this.setAppId(s);
        this.setOnesignalId(s1);
        this.setTreatNewAsExisting(z);
        this.setAmountSpent(bigDecimal0);
        this.setPurchases(list0);
    }

    @Override  // com.onesignal.common.modeling.Model
    protected List createListForProperty(String s, JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(s, "property");
        Intrinsics.checkNotNullParameter(jSONArray0, "jsonArray");
        if(Intrinsics.areEqual(s, "purchases")) {
            List list0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                PurchaseInfo purchaseInfo0 = new PurchaseInfo();
                JSONObject jSONObject0 = jSONArray0.getJSONObject(v1);
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "jsonArray.getJSONObject(item)");
                purchaseInfo0.initializeFromJson(jSONObject0);
                list0.add(purchaseInfo0);
            }
            return list0;
        }
        return null;
    }

    public final BigDecimal getAmountSpent() {
        return Model.getBigDecimalProperty$default(this, "amountSpent", null, 2, null);
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

    public final List getPurchases() {
        return Model.getListProperty$default(this, "purchases", null, 2, null);
    }

    public final boolean getTreatNewAsExisting() {
        return Model.getBooleanProperty$default(this, "treatNewAsExisting", null, 2, null);
    }

    private final void setAmountSpent(BigDecimal bigDecimal0) {
        Model.setBigDecimalProperty$default(this, "amountSpent", bigDecimal0, null, false, 12, null);
    }

    private final void setAppId(String s) {
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    private final void setOnesignalId(String s) {
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    private final void setPurchases(List list0) {
        Model.setListProperty$default(this, "purchases", list0, null, false, 12, null);
    }

    private final void setTreatNewAsExisting(boolean z) {
        Model.setBooleanProperty$default(this, "treatNewAsExisting", z, null, false, 12, null);
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

