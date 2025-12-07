package com.onesignal.user.internal.backend;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/onesignal/user/internal/backend/PurchaseObject;", "", "sku", "", "iso", "amount", "Ljava/math/BigDecimal;", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;)V", "getAmount", "()Ljava/math/BigDecimal;", "getIso", "()Ljava/lang/String;", "getSku", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PurchaseObject {
    private final BigDecimal amount;
    private final String iso;
    private final String sku;

    public PurchaseObject(String s, String s1, BigDecimal bigDecimal0) {
        Intrinsics.checkNotNullParameter(s, "sku");
        Intrinsics.checkNotNullParameter(s1, "iso");
        Intrinsics.checkNotNullParameter(bigDecimal0, "amount");
        super();
        this.sku = s;
        this.iso = s1;
        this.amount = bigDecimal0;
    }

    public final BigDecimal getAmount() {
        return this.amount;
    }

    public final String getIso() {
        return this.iso;
    }

    public final String getSku() {
        return this.sku;
    }
}

