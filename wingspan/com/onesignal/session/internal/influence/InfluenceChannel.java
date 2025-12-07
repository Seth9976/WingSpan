package com.onesignal.session.internal.influence;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u000B2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000BB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000E\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0003J\b\u0010\b\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceChannel;", "", "nameValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "equalsName", "", "otherName", "toString", "IAM", "NOTIFICATION", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum InfluenceChannel {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceChannel$Companion;", "", "()V", "fromString", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "value", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @JvmStatic
        public final InfluenceChannel fromString(String s) {
            if(s != null) {
                InfluenceChannel[] arr_influenceChannel = InfluenceChannel.values();
                int v = arr_influenceChannel.length - 1;
                if(v >= 0) {
                    while(true) {
                        InfluenceChannel influenceChannel0 = arr_influenceChannel[v];
                        if(influenceChannel0.equalsName(s)) {
                            return influenceChannel0 == null ? InfluenceChannel.NOTIFICATION : influenceChannel0;
                        }
                        if(v - 1 < 0) {
                            break;
                        }
                        --v;
                    }
                }
                return InfluenceChannel.NOTIFICATION;
            }
            return InfluenceChannel.NOTIFICATION;
        }
    }

    IAM("iam"),
    NOTIFICATION("notification");

    public static final Companion Companion;
    private final String nameValue;

    private static final InfluenceChannel[] $values() [...] // Inlined contents

    static {
        InfluenceChannel.Companion = new Companion(null);
    }

    private InfluenceChannel(String s1) {
        this.nameValue = s1;
    }

    public final boolean equalsName(String s) {
        Intrinsics.checkNotNullParameter(s, "otherName");
        return Intrinsics.areEqual(this.nameValue, s);
    }

    @JvmStatic
    public static final InfluenceChannel fromString(String s) {
        return InfluenceChannel.Companion.fromString(s);
    }

    @Override
    public String toString() {
        return this.nameValue;
    }
}

