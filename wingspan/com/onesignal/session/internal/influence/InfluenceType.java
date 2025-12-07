package com.onesignal.session.internal.influence;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004J\u0006\u0010\u0005\u001A\u00020\u0004J\u0006\u0010\u0006\u001A\u00020\u0004J\u0006\u0010\u0007\u001A\u00020\u0004J\u0006\u0010\b\u001A\u00020\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\u000E"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceType;", "", "(Ljava/lang/String;I)V", "isAttributed", "", "isDirect", "isDisabled", "isIndirect", "isUnattributed", "DIRECT", "INDIRECT", "UNATTRIBUTED", "DISABLED", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum InfluenceType {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceType$Companion;", "", "()V", "fromString", "Lcom/onesignal/session/internal/influence/InfluenceType;", "value", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @JvmStatic
        public final InfluenceType fromString(String s) {
            if(s != null) {
                InfluenceType[] arr_influenceType = InfluenceType.values();
                int v = arr_influenceType.length - 1;
                if(v >= 0) {
                    while(true) {
                        InfluenceType influenceType0 = arr_influenceType[v];
                        if(StringsKt.equals(influenceType0.name(), s, true)) {
                            return influenceType0 == null ? InfluenceType.UNATTRIBUTED : influenceType0;
                        }
                        if(v - 1 < 0) {
                            break;
                        }
                        --v;
                    }
                }
                return InfluenceType.UNATTRIBUTED;
            }
            return InfluenceType.UNATTRIBUTED;
        }
    }

    DIRECT,
    INDIRECT,
    UNATTRIBUTED,
    DISABLED;

    public static final Companion Companion;

    private static final InfluenceType[] $values() [...] // Inlined contents

    static {
        InfluenceType.Companion = new Companion(null);
    }

    @JvmStatic
    public static final InfluenceType fromString(String s) {
        return InfluenceType.Companion.fromString(s);
    }

    // 去混淆评级： 中等(60)
    public final boolean isAttributed() {
        return false;
    }

    public final boolean isDirect() [...] // 潜在的解密器

    public final boolean isDisabled() [...] // 潜在的解密器

    public final boolean isIndirect() [...] // 潜在的解密器

    public final boolean isUnattributed() [...] // 潜在的解密器
}

