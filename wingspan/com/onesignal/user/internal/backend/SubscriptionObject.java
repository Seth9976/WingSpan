package com.onesignal.user.internal.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u001B\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0014R\u0013\u0010\f\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0014R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0014R\u0015\u0010\u000F\u001A\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001E\u001A\u0004\b\u001C\u0010\u001DR\u0015\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001E\u001A\u0004\b\u001F\u0010\u001DR\u0015\u0010\u000E\u001A\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b \u0010\u0019R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0014R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0014R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/onesignal/user/internal/backend/SubscriptionObject;", "", "id", "", "type", "Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "token", "enabled", "", "notificationTypes", "", "sdk", "deviceModel", "deviceOS", "rooted", "netType", "carrier", "appVersion", "(Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObjectType;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getCarrier", "getDeviceModel", "getDeviceOS", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getNetType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNotificationTypes", "getRooted", "getSdk", "getToken", "getType", "()Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionObject {
    private final String appVersion;
    private final String carrier;
    private final String deviceModel;
    private final String deviceOS;
    private final Boolean enabled;
    private final String id;
    private final Integer netType;
    private final Integer notificationTypes;
    private final Boolean rooted;
    private final String sdk;
    private final String token;
    private final SubscriptionObjectType type;

    public SubscriptionObject() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0xFFF, null);
    }

    public SubscriptionObject(String s, SubscriptionObjectType subscriptionObjectType0, String s1, Boolean boolean0, Integer integer0, String s2, String s3, String s4, Boolean boolean1, Integer integer1, String s5, String s6) {
        this.id = s;
        this.type = subscriptionObjectType0;
        this.token = s1;
        this.enabled = boolean0;
        this.notificationTypes = integer0;
        this.sdk = s2;
        this.deviceModel = s3;
        this.deviceOS = s4;
        this.rooted = boolean1;
        this.netType = integer1;
        this.carrier = s5;
        this.appVersion = s6;
    }

    public SubscriptionObject(String s, SubscriptionObjectType subscriptionObjectType0, String s1, Boolean boolean0, Integer integer0, String s2, String s3, String s4, Boolean boolean1, Integer integer1, String s5, String s6, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v & 1) == 0 ? s : null), ((v & 2) == 0 ? subscriptionObjectType0 : null), ((v & 4) == 0 ? s1 : null), ((v & 8) == 0 ? boolean0 : null), ((v & 16) == 0 ? integer0 : null), ((v & 0x20) == 0 ? s2 : null), ((v & 0x40) == 0 ? s3 : null), ((v & 0x80) == 0 ? s4 : null), ((v & 0x100) == 0 ? boolean1 : null), ((v & 0x200) == 0 ? integer1 : null), ((v & 0x400) == 0 ? s5 : null), ((v & 0x800) == 0 ? s6 : null));
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDeviceOS() {
        return this.deviceOS;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getNetType() {
        return this.netType;
    }

    public final Integer getNotificationTypes() {
        return this.notificationTypes;
    }

    public final Boolean getRooted() {
        return this.rooted;
    }

    public final String getSdk() {
        return this.sdk;
    }

    public final String getToken() {
        return this.token;
    }

    public final SubscriptionObjectType getType() {
        return this.type;
    }
}

