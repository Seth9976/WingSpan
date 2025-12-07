package com.onesignal.user.internal.backend;

import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u000B\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000BR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", "", "sessionTime", "", "sessionCount", "", "amountSpent", "Ljava/math/BigDecimal;", "purchases", "", "Lcom/onesignal/user/internal/backend/PurchaseObject;", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/util/List;)V", "getAmountSpent", "()Ljava/math/BigDecimal;", "hasAtLeastOnePropertySet", "", "getHasAtLeastOnePropertySet", "()Z", "getPurchases", "()Ljava/util/List;", "getSessionCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSessionTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PropertiesDeltasObject {
    private final BigDecimal amountSpent;
    private final List purchases;
    private final Integer sessionCount;
    private final Long sessionTime;

    public PropertiesDeltasObject() {
        this(null, null, null, null, 15, null);
    }

    public PropertiesDeltasObject(Long long0, Integer integer0, BigDecimal bigDecimal0, List list0) {
        this.sessionTime = long0;
        this.sessionCount = integer0;
        this.amountSpent = bigDecimal0;
        this.purchases = list0;
    }

    public PropertiesDeltasObject(Long long0, Integer integer0, BigDecimal bigDecimal0, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            long0 = null;
        }
        if((v & 2) != 0) {
            integer0 = null;
        }
        if((v & 4) != 0) {
            bigDecimal0 = null;
        }
        if((v & 8) != 0) {
            list0 = null;
        }
        this(long0, integer0, bigDecimal0, list0);
    }

    public final BigDecimal getAmountSpent() {
        return this.amountSpent;
    }

    public final boolean getHasAtLeastOnePropertySet() {
        return this.sessionTime != null || this.sessionCount != null || this.amountSpent != null || this.purchases != null;
    }

    public final List getPurchases() {
        return this.purchases;
    }

    public final Integer getSessionCount() {
        return this.sessionCount;
    }

    public final Long getSessionTime() {
        return this.sessionTime;
    }
}

