package com.onesignal.user.internal.operations;

import com.onesignal.common.modeling.Model;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\u0018\u00002\u00020\u0001B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bR$\u0010\u0005\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00068F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R$\u0010\u0002\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0012\u0010\u000F\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/onesignal/user/internal/operations/PurchaseInfo;", "Lcom/onesignal/common/modeling/Model;", "sku", "", "iso", "amount", "Ljava/math/BigDecimal;", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;)V", "()V", "value", "getAmount", "()Ljava/math/BigDecimal;", "setAmount", "(Ljava/math/BigDecimal;)V", "getIso", "()Ljava/lang/String;", "setIso", "(Ljava/lang/String;)V", "getSku", "setSku", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PurchaseInfo extends Model {
    public PurchaseInfo() {
        super(null, null, 3, null);
    }

    public PurchaseInfo(String s, String s1, BigDecimal bigDecimal0) {
        Intrinsics.checkNotNullParameter(s, "sku");
        Intrinsics.checkNotNullParameter(s1, "iso");
        Intrinsics.checkNotNullParameter(bigDecimal0, "amount");
        this();
        this.setSku(s);
        this.setIso(s1);
        this.setAmount(bigDecimal0);
    }

    public final BigDecimal getAmount() {
        return Model.getBigDecimalProperty$default(this, "amount", null, 2, null);
    }

    public final String getIso() {
        return Model.getStringProperty$default(this, "iso", null, 2, null);
    }

    public final String getSku() {
        return Model.getStringProperty$default(this, "sku", null, 2, null);
    }

    private final void setAmount(BigDecimal bigDecimal0) {
        Model.setBigDecimalProperty$default(this, "amount", bigDecimal0, null, false, 12, null);
    }

    private final void setIso(String s) {
        Model.setStringProperty$default(this, "iso", s, null, false, 12, null);
    }

    private final void setSku(String s) {
        Model.setStringProperty$default(this, "sku", s, null, false, 12, null);
    }
}

