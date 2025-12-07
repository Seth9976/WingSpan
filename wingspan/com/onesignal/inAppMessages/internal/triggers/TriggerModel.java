package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0003\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "key", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TriggerModel extends Model {
    public TriggerModel() {
        super(null, null, 3, null);
    }

    public final String getKey() [...] // 潜在的解密器

    public final Object getValue() {
        return this.getAnyProperty("value", com.onesignal.inAppMessages.internal.triggers.TriggerModel.value.2.INSTANCE);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.inAppMessages.internal.triggers.TriggerModel.value.2 extends Lambda implements Function0 {
            public static final com.onesignal.inAppMessages.internal.triggers.TriggerModel.value.2 INSTANCE;

            static {
                com.onesignal.inAppMessages.internal.triggers.TriggerModel.value.2.INSTANCE = new com.onesignal.inAppMessages.internal.triggers.TriggerModel.value.2();
            }

            com.onesignal.inAppMessages.internal.triggers.TriggerModel.value.2() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "";
            }
        }

    }

    public final void setKey(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "key", s, null, false, 12, null);
    }

    public final void setValue(Object object0) {
        Intrinsics.checkNotNullParameter(object0, "value");
        Model.setAnyProperty$default(this, "value", object0, null, true, 4, null);
    }
}

