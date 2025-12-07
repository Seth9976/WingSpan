package com.onesignal.inAppMessages;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "IN_APP_WEBVIEW", "BROWSER", "REPLACE_CONTENT", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum InAppMessageActionUrlType {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/InAppMessageActionUrlType$Companion;", "", "()V", "fromString", "Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "text", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final InAppMessageActionUrlType fromString(String s) {
            InAppMessageActionUrlType[] arr_inAppMessageActionUrlType = InAppMessageActionUrlType.values();
            for(int v = 0; v < arr_inAppMessageActionUrlType.length; ++v) {
                InAppMessageActionUrlType inAppMessageActionUrlType0 = arr_inAppMessageActionUrlType[v];
                if(StringsKt.equals(inAppMessageActionUrlType0.text, s, true)) {
                    return inAppMessageActionUrlType0;
                }
            }
            return null;
        }
    }

    IN_APP_WEBVIEW("webview"),
    BROWSER("browser"),
    REPLACE_CONTENT("replacement");

    public static final Companion Companion;
    private final String text;

    private static final InAppMessageActionUrlType[] $values() [...] // Inlined contents

    static {
        InAppMessageActionUrlType.Companion = new Companion(null);
    }

    private InAppMessageActionUrlType(String s1) {
        this.text = s1;
    }

    @Override
    public String toString() {
        return this.text;
    }
}

