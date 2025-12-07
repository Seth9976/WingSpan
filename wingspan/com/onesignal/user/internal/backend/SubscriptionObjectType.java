package com.onesignal.user.internal.backend;

import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IOS_PUSH", "ANDROID_PUSH", "FIREOS_PUSH", "CHROME_EXTENSION", "CHROME_PUSH", "WINDOWS_PUSH", "SAFARI_PUSH", "SAFARI_PUSH_LEGACY", "FIREFOX_PUSH", "MACOS_PUSH", "EMAIL", "HUAWEI_PUSH", "SMS", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum SubscriptionObjectType {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\b¨\u0006\t"}, d2 = {"Lcom/onesignal/user/internal/backend/SubscriptionObjectType$Companion;", "", "()V", "fromDeviceType", "Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "type", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "fromString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[DeviceType.values().length];
                arr_v[DeviceType.Android.ordinal()] = 1;
                arr_v[DeviceType.Fire.ordinal()] = 2;
                arr_v[DeviceType.Huawei.ordinal()] = 3;
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final SubscriptionObjectType fromDeviceType(DeviceType iDeviceService$DeviceType0) {
            Intrinsics.checkNotNullParameter(iDeviceService$DeviceType0, "type");
            switch(WhenMappings.$EnumSwitchMapping$0[iDeviceService$DeviceType0.ordinal()]) {
                case 1: {
                    return SubscriptionObjectType.ANDROID_PUSH;
                }
                case 2: {
                    return SubscriptionObjectType.FIREOS_PUSH;
                }
                case 3: {
                    return SubscriptionObjectType.HUAWEI_PUSH;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        public final SubscriptionObjectType fromString(String s) {
            Intrinsics.checkNotNullParameter(s, "type");
            SubscriptionObjectType[] arr_subscriptionObjectType = SubscriptionObjectType.values();
            int v = 0;
            while(v < arr_subscriptionObjectType.length) {
                SubscriptionObjectType subscriptionObjectType0 = arr_subscriptionObjectType[v];
                if(!StringsKt.equals(subscriptionObjectType0.getValue(), s, true)) {
                    ++v;
                    continue;
                }
                return subscriptionObjectType0;
            }
            return null;
        }
    }

    IOS_PUSH("iOSPush"),
    ANDROID_PUSH("AndroidPush"),
    FIREOS_PUSH("FireOSPush"),
    CHROME_EXTENSION("ChromeExtensionPush"),
    CHROME_PUSH("ChromePush"),
    WINDOWS_PUSH("WindowsPush"),
    SAFARI_PUSH("SafariPush"),
    SAFARI_PUSH_LEGACY("SafariLegacyPush"),
    FIREFOX_PUSH("FirefoxPush"),
    MACOS_PUSH("macOSPush"),
    EMAIL("Email"),
    HUAWEI_PUSH("HuaweiPush"),
    SMS("SMS");

    public static final Companion Companion;
    private final String value;

    private static final SubscriptionObjectType[] $values() [...] // Inlined contents

    static {
        SubscriptionObjectType.Companion = new Companion(null);
    }

    private SubscriptionObjectType(String s1) {
        this.value = s1;
    }

    public final String getValue() {
        return this.value;
    }
}

