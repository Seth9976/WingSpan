package com.onesignal.user.internal.subscriptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u001A2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001AB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001B"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SUBSCRIBED", "NO_PERMISSION", "UNSUBSCRIBE", "MISSING_ANDROID_SUPPORT_LIBRARY", "MISSING_FIREBASE_FCM_LIBRARY", "OUTDATED_ANDROID_SUPPORT_LIBRARY", "INVALID_FCM_SENDER_ID", "OUTDATED_GOOGLE_PLAY_SERVICES_APP", "FIREBASE_FCM_INIT_ERROR", "FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE", "FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER", "FIREBASE_FCM_ERROR_MISC_EXCEPTION", "HMS_TOKEN_TIMEOUT", "HMS_ARGUMENTS_INVALID", "HMS_API_EXCEPTION_OTHER", "MISSING_HMS_PUSHKIT_LIBRARY", "FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED", "DISABLED_FROM_REST_API_DEFAULT_REASON", "ERROR", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum SubscriptionStatus {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus$Companion;", "", "()V", "fromInt", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "value", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final SubscriptionStatus fromInt(int v) {
            SubscriptionStatus[] arr_subscriptionStatus = SubscriptionStatus.values();
            int v1 = 0;
            while(v1 < arr_subscriptionStatus.length) {
                SubscriptionStatus subscriptionStatus0 = arr_subscriptionStatus[v1];
                if(subscriptionStatus0.getValue() != v) {
                    ++v1;
                    continue;
                }
                return subscriptionStatus0;
            }
            return null;
        }
    }

    SUBSCRIBED(1),
    NO_PERMISSION(0),
    UNSUBSCRIBE(-2),
    MISSING_ANDROID_SUPPORT_LIBRARY(-3),
    MISSING_FIREBASE_FCM_LIBRARY(-4),
    OUTDATED_ANDROID_SUPPORT_LIBRARY(-5),
    INVALID_FCM_SENDER_ID(-6),
    OUTDATED_GOOGLE_PLAY_SERVICES_APP(-7),
    FIREBASE_FCM_INIT_ERROR(-8),
    FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE(-9),
    FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER(-11),
    FIREBASE_FCM_ERROR_MISC_EXCEPTION(-12),
    HMS_TOKEN_TIMEOUT(-25),
    HMS_ARGUMENTS_INVALID(-26),
    HMS_API_EXCEPTION_OTHER(-27),
    MISSING_HMS_PUSHKIT_LIBRARY(-28),
    FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED(-29),
    DISABLED_FROM_REST_API_DEFAULT_REASON(-30),
    ERROR(0x270F);

    public static final Companion Companion;
    private final int value;

    private static final SubscriptionStatus[] $values() [...] // Inlined contents

    static {
        SubscriptionStatus.Companion = new Companion(null);
    }

    private SubscriptionStatus(int v1) {
        this.value = v1;
    }

    public final int getValue() {
        return this.value;
    }
}

