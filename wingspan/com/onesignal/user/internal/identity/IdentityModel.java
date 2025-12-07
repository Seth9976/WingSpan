package com.onesignal.user.internal.identity;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.Model;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R(\u0010\u0005\u001A\u0004\u0018\u00010\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u00028F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00028F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/onesignal/user/internal/identity/IdentityModel;", "Lcom/onesignal/common/modeling/MapModel;", "", "()V", "value", "externalId", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "onesignalId", "getOnesignalId", "setOnesignalId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class IdentityModel extends MapModel {
    public IdentityModel() {
        super(null, null, 3, null);
    }

    @Override  // com.onesignal.common.modeling.MapModel
    public final boolean containsValue(Object object0) {
        return object0 instanceof String ? this.containsValue(((String)object0)) : false;
    }

    public boolean containsValue(String s) {
        return super.containsValue(s);
    }

    public final String get(Object object0) {
        return object0 instanceof String ? this.get(((String)object0)) : null;
    }

    public String get(String s) {
        return (String)super.get(s);
    }

    public final String getExternalId() {
        return Model.getOptStringProperty$default(this, "external_id", null, 2, null);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignal_id", null, 2, null);
    }

    public final String getOrDefault(Object object0, String s) {
        return object0 instanceof String ? this.getOrDefault(((String)object0), s) : s;
    }

    public String getOrDefault(String s, String s1) {
        return (String)super.getOrDefault(s, s1);
    }

    public final String remove(Object object0) {
        return object0 instanceof String ? this.remove(((String)object0)) : null;
    }

    public String remove(String s) {
        return (String)super.remove(s);
    }

    public final void setExternalId(String s) {
        Model.setOptStringProperty$default(this, "external_id", s, null, false, 12, null);
    }

    public final void setOnesignalId(String s) [...] // 潜在的解密器
}

