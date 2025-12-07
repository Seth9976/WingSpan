package com.onesignal.core.internal.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\f\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000BR\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u000F\u0010\rR\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0010\u0010\rR\u0015\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0007\u0010\u0011R\u0015\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\t\u0010\u0011R\u0015\u0010\n\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\n\u0010\u0011R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "", "indirectNotificationAttributionWindow", "", "notificationLimit", "indirectIAMAttributionWindow", "iamLimit", "isDirectEnabled", "", "isIndirectEnabled", "isUnattributedEnabled", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getIamLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIndirectIAMAttributionWindow", "getIndirectNotificationAttributionWindow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNotificationLimit", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InfluenceParamsObject {
    private final Integer iamLimit;
    private final Integer indirectIAMAttributionWindow;
    private final Integer indirectNotificationAttributionWindow;
    private final Boolean isDirectEnabled;
    private final Boolean isIndirectEnabled;
    private final Boolean isUnattributedEnabled;
    private final Integer notificationLimit;

    public InfluenceParamsObject() {
        this(null, null, null, null, null, null, null, 0x7F, null);
    }

    public InfluenceParamsObject(Integer integer0, Integer integer1, Integer integer2, Integer integer3, Boolean boolean0, Boolean boolean1, Boolean boolean2) {
        this.indirectNotificationAttributionWindow = integer0;
        this.notificationLimit = integer1;
        this.indirectIAMAttributionWindow = integer2;
        this.iamLimit = integer3;
        this.isDirectEnabled = boolean0;
        this.isIndirectEnabled = boolean1;
        this.isUnattributedEnabled = boolean2;
    }

    public InfluenceParamsObject(Integer integer0, Integer integer1, Integer integer2, Integer integer3, Boolean boolean0, Boolean boolean1, Boolean boolean2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v & 1) == 0 ? integer0 : null), ((v & 2) == 0 ? integer1 : null), ((v & 4) == 0 ? integer2 : null), ((v & 8) == 0 ? integer3 : null), ((v & 16) == 0 ? boolean0 : null), ((v & 0x20) == 0 ? boolean1 : null), ((v & 0x40) == 0 ? boolean2 : null));
    }

    public final Integer getIamLimit() {
        return this.iamLimit;
    }

    public final Integer getIndirectIAMAttributionWindow() {
        return this.indirectIAMAttributionWindow;
    }

    public final Integer getIndirectNotificationAttributionWindow() {
        return this.indirectNotificationAttributionWindow;
    }

    public final Integer getNotificationLimit() {
        return this.notificationLimit;
    }

    public final Boolean isDirectEnabled() {
        return this.isDirectEnabled;
    }

    public final Boolean isIndirectEnabled() {
        return this.isIndirectEnabled;
    }

    public final Boolean isUnattributedEnabled() {
        return this.isUnattributedEnabled;
    }
}

