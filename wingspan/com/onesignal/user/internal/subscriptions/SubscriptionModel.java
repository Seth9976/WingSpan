package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR$\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0003\u001A\u00020\u00138F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR$\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0003\u001A\u00020\u001C8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R$\u0010#\u001A\u00020\"2\u0006\u0010\u0003\u001A\u00020\"8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'¨\u0006("}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "address", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "carrier", "getCarrier", "setCarrier", "deviceOS", "getDeviceOS", "setDeviceOS", "", "optedIn", "getOptedIn", "()Z", "setOptedIn", "(Z)V", "sdk", "getSdk", "setSdk", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "status", "getStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "type", "getType", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "setType", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionType;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionModel extends Model {
    public SubscriptionModel() {
        super(null, null, 3, null);
    }

    public final String getAddress() {
        return Model.getStringProperty$default(this, "address", null, 2, null);
    }

    public final String getAppVersion() [...] // 潜在的解密器

    public final String getCarrier() [...] // 潜在的解密器

    public final String getDeviceOS() [...] // 潜在的解密器

    public final boolean getOptedIn() {
        return Model.getBooleanProperty$default(this, "optedIn", null, 2, null);
    }

    public final String getSdk() [...] // 潜在的解密器

    public final SubscriptionStatus getStatus() {
        Enum enum0 = null;
        if(!this.hasProperty("status")) {
            Enum enum1 = SubscriptionStatus.SUBSCRIBED;
            if(enum1 != null) {
                enum1.toString();
            }
            this.setOptAnyProperty("status", "SUBSCRIBED", "NORMAL", false);
        }
        Object object0 = Model.getOptAnyProperty$default(this, "status", null, 2, null);
        if(object0 != null) {
            if(object0 instanceof SubscriptionStatus) {
                enum0 = (Enum)object0;
            }
            else if(object0 instanceof String) {
                enum0 = SubscriptionStatus.valueOf(((String)object0));
            }
            else {
                if(object0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
                }
                enum0 = (SubscriptionStatus)object0;
            }
        }
        if(enum0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionStatus");
        }
        return (SubscriptionStatus)enum0;
    }

    public final SubscriptionType getType() {
        Enum enum0 = null;
        Object object0 = Model.getOptAnyProperty$default(this, "type", null, 2, null);
        if(object0 != null) {
            if(object0 instanceof SubscriptionType) {
                enum0 = (Enum)object0;
            }
            else if(object0 instanceof String) {
                enum0 = SubscriptionType.valueOf(((String)object0));
            }
            else {
                if(object0 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
                }
                enum0 = (SubscriptionType)object0;
            }
        }
        if(enum0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionType");
        }
        return (SubscriptionType)enum0;
    }

    public final void setAddress(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "address", s, null, false, 12, null);
    }

    public final void setAppVersion(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "appVersion", s, null, false, 12, null);
    }

    public final void setCarrier(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "carrier", s, null, false, 12, null);
    }

    public final void setDeviceOS(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "deviceOS", s, null, false, 12, null);
    }

    public final void setOptedIn(boolean z) {
        Model.setBooleanProperty$default(this, "optedIn", z, null, false, 12, null);
    }

    public final void setSdk(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "sdk", s, null, false, 12, null);
    }

    public final void setStatus(SubscriptionStatus subscriptionStatus0) {
        Intrinsics.checkNotNullParameter(subscriptionStatus0, "value");
        this.setOptAnyProperty("status", subscriptionStatus0.toString(), "NORMAL", false);
    }

    public final void setType(SubscriptionType subscriptionType0) {
        Intrinsics.checkNotNullParameter(subscriptionType0, "value");
        this.setOptAnyProperty("type", subscriptionType0.toString(), "NORMAL", false);
    }
}

