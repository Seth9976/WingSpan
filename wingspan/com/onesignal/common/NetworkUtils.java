package com.onesignal.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0004R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/onesignal/common/NetworkUtils;", "", "()V", "maxNetworkRequestAttemptCount", "", "getMaxNetworkRequestAttemptCount", "()I", "setMaxNetworkRequestAttemptCount", "(I)V", "getResponseStatusType", "Lcom/onesignal/common/NetworkUtils$ResponseStatusType;", "statusCode", "ResponseStatusType", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NetworkUtils {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/onesignal/common/NetworkUtils$ResponseStatusType;", "", "(Ljava/lang/String;I)V", "INVALID", "RETRYABLE", "UNAUTHORIZED", "MISSING", "CONFLICT", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum ResponseStatusType {
        INVALID,
        RETRYABLE,
        UNAUTHORIZED,
        MISSING,
        CONFLICT;

        private static final ResponseStatusType[] $values() [...] // Inlined contents
    }

    public static final NetworkUtils INSTANCE;
    private static int maxNetworkRequestAttemptCount;

    static {
        NetworkUtils.INSTANCE = new NetworkUtils();
        NetworkUtils.maxNetworkRequestAttemptCount = 3;
    }

    public final int getMaxNetworkRequestAttemptCount() [...] // 潜在的解密器

    public final ResponseStatusType getResponseStatusType(int v) {
        switch(v) {
            case 400: 
            case 402: {
                return ResponseStatusType.INVALID;
            }
            case 401: 
            case 403: {
                return ResponseStatusType.UNAUTHORIZED;
            }
            case 409: {
                return ResponseStatusType.CONFLICT;
            }
            case 404: 
            case 410: {
                return ResponseStatusType.MISSING;
            }
            default: {
                return ResponseStatusType.RETRYABLE;
            }
        }
    }

    public final void setMaxNetworkRequestAttemptCount(int v) {
        NetworkUtils.maxNetworkRequestAttemptCount = v;
    }
}

