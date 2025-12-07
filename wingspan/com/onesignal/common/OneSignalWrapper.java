package com.onesignal.common;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u000B\u0010\u0002\u001A\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/onesignal/common/OneSignalWrapper;", "", "()V", "sdkType", "", "getSdkType$annotations", "getSdkType", "()Ljava/lang/String;", "setSdkType", "(Ljava/lang/String;)V", "sdkVersion", "getSdkVersion$annotations", "getSdkVersion", "setSdkVersion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignalWrapper {
    public static final OneSignalWrapper INSTANCE;
    private static String sdkType;
    private static String sdkVersion;

    static {
        OneSignalWrapper.INSTANCE = new OneSignalWrapper();
    }

    public static final String getSdkType() {
        return OneSignalWrapper.sdkType;
    }

    @JvmStatic
    public static void getSdkType$annotations() {
    }

    public static final String getSdkVersion() {
        return OneSignalWrapper.sdkVersion;
    }

    @JvmStatic
    public static void getSdkVersion$annotations() {
    }

    public static final void setSdkType(String s) {
        OneSignalWrapper.sdkType = s;
    }

    public static final void setSdkVersion(String s) {
        OneSignalWrapper.sdkVersion = s;
    }
}

