package com.onesignal.debug;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000B"}, d2 = {"Lcom/onesignal/debug/LogLevel;", "", "(Ljava/lang/String;I)V", "NONE", "FATAL", "ERROR", "WARN", "INFO", "DEBUG", "VERBOSE", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum LogLevel {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/onesignal/debug/LogLevel$Companion;", "", "()V", "fromInt", "Lcom/onesignal/debug/LogLevel;", "value", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @JvmStatic
        public final LogLevel fromInt(int v) {
            return LogLevel.values()[v];
        }
    }

    NONE,
    FATAL,
    ERROR,
    WARN,
    INFO,
    DEBUG,
    VERBOSE;

    public static final Companion Companion;

    private static final LogLevel[] $values() [...] // Inlined contents

    static {
        LogLevel.Companion = new Companion(null);
    }

    @JvmStatic
    public static final LogLevel fromInt(int v) {
        return LogLevel.Companion.fromInt(v);
    }
}

