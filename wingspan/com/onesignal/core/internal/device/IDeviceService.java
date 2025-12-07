package com.onesignal.core.internal.device;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\bf\u0018\u00002\u00020\u0001:\u0002\u0014\u0015R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0012\u0010\u0010\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\rR\u0012\u0010\u0011\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\rR\u0012\u0010\u0012\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\rR\u0012\u0010\u0013\u001A\u00020\u000BX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/device/IDeviceService;", "", "androidSupportLibraryStatus", "Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "getAndroidSupportLibraryStatus", "()Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "deviceType", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "getDeviceType", "()Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "hasAllHMSLibrariesForPushKit", "", "getHasAllHMSLibrariesForPushKit", "()Z", "hasFCMLibrary", "getHasFCMLibrary", "isAndroidDeviceType", "isFireOSDeviceType", "isGMSInstalledAndEnabled", "isHuaweiDeviceType", "AndroidSupportLibraryStatus", "DeviceType", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IDeviceService {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "", "(Ljava/lang/String;I)V", "MISSING", "OUTDATED", "OK", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum AndroidSupportLibraryStatus {
        MISSING,
        OUTDATED,
        OK;

        private static final AndroidSupportLibraryStatus[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Fire", "Android", "Huawei", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum DeviceType {
        Fire(2),
        Android(1),
        Huawei(13);

        private final int value;

        private static final DeviceType[] $values() [...] // Inlined contents

        private DeviceType(int v1) {
            this.value = v1;
        }

        public final int getValue() {
            return this.value;
        }
    }

    AndroidSupportLibraryStatus getAndroidSupportLibraryStatus();

    DeviceType getDeviceType();

    boolean getHasAllHMSLibrariesForPushKit();

    boolean getHasFCMLibrary();

    boolean isAndroidDeviceType();

    boolean isFireOSDeviceType();

    boolean isGMSInstalledAndEnabled();

    boolean isHuaweiDeviceType();
}

