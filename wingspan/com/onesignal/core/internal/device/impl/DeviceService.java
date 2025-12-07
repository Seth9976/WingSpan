package com.onesignal.core.internal.device.impl;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService.AndroidSupportLibraryStatus;
import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import com.onesignal.core.internal.device.IDeviceService;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001A\u00020\u000EH\u0002J\b\u0010\u001A\u001A\u00020\u000EH\u0002J\b\u0010\u001B\u001A\u00020\u000EH\u0002J\b\u0010\u001C\u001A\u00020\u000EH\u0002J\b\u0010\u001D\u001A\u00020\u000EH\u0002J\u0010\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020 H\u0002J\b\u0010!\u001A\u00020\u000EH\u0002J\b\u0010\"\u001A\u00020\u000EH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001A\u00020\u000E8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0010¨\u0006$"}, d2 = {"Lcom/onesignal/core/internal/device/impl/DeviceService;", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "androidSupportLibraryStatus", "Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "getAndroidSupportLibraryStatus", "()Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "deviceType", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "getDeviceType", "()Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "hasAllHMSLibrariesForPushKit", "", "getHasAllHMSLibrariesForPushKit", "()Z", "hasFCMLibrary", "getHasFCMLibrary", "isAndroidDeviceType", "isFireOSDeviceType", "isGMSInstalledAndEnabled", "isHuaweiDeviceType", "supportsHMS", "getSupportsHMS", "hasHMSAGConnectLibrary", "hasHMSAvailabilityLibrary", "hasHMSPushKitLibrary", "isHMSCoreInstalledAndEnabled", "isHMSCoreInstalledAndEnabledFallback", "packageInstalledAndEnabled", "packageName", "", "supportsADM", "supportsGooglePush", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DeviceService implements IDeviceService {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/device/impl/DeviceService$Companion;", "", "()V", "GOOGLE_PLAY_SERVICES_PACKAGE", "", "HMS_AVAILABLE_SUCCESSFUL", "", "HMS_CORE_SERVICES_PACKAGE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    private static final int HMS_AVAILABLE_SUCCESSFUL = 0;
    private static final String HMS_CORE_SERVICES_PACKAGE = "com.huawei.hwid";
    private final IApplicationService _applicationService;

    static {
        DeviceService.Companion = new Companion(null);
    }

    public DeviceService(IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        super();
        this._applicationService = iApplicationService0;
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public AndroidSupportLibraryStatus getAndroidSupportLibraryStatus() {
        if(Build.VERSION.SDK_INT >= 26) {
            Context context0 = this._applicationService.getAppContext();
            boolean z = AndroidUtils.INSTANCE.getTargetSdkVersion(context0) < 26;
        }
        return AndroidSupportLibraryStatus.OK;
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public DeviceType getDeviceType() {
        if(this.supportsADM()) {
            return DeviceType.Fire;
        }
        if(this.supportsGooglePush()) {
            return DeviceType.Android;
        }
        if(this.getSupportsHMS()) {
            return DeviceType.Huawei;
        }
        if(this.isGMSInstalledAndEnabled()) {
            return DeviceType.Android;
        }
        return this.isHMSCoreInstalledAndEnabledFallback() ? DeviceType.Huawei : DeviceType.Android;
    }

    // 去混淆评级： 低(20)
    @Override  // com.onesignal.core.internal.device.IDeviceService
    public boolean getHasAllHMSLibrariesForPushKit() {
        return this.hasHMSAGConnectLibrary() && this.hasHMSPushKitLibrary();
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public boolean getHasFCMLibrary() {
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessaging");
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    // 去混淆评级： 低(20)
    private final boolean getSupportsHMS() {
        return !this.hasHMSAvailabilityLibrary() || !this.getHasAllHMSLibrariesForPushKit() ? false : this.isHMSCoreInstalledAndEnabled();
    }

    private final boolean hasHMSAGConnectLibrary() {
        try {
            Class.forName("com.huawei.agconnect.config.AGConnectServicesConfig");
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    private final boolean hasHMSAvailabilityLibrary() {
        try {
            Class.forName("com.huawei.hms.api.HuaweiApiAvailability");
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    private final boolean hasHMSPushKitLibrary() {
        try {
            Class.forName("com.huawei.hms.aaid.HmsInstanceId");
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public boolean isAndroidDeviceType() {
        return this.getDeviceType() == DeviceType.Android;
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public boolean isFireOSDeviceType() {
        return this.getDeviceType() == DeviceType.Fire;
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public boolean isGMSInstalledAndEnabled() {
        return this.packageInstalledAndEnabled("com.google.android.gms");
    }

    private final boolean isHMSCoreInstalledAndEnabled() {
        try {
            Class class0 = Class.forName("com.huawei.hms.api.HuaweiApiAvailability");
            Method method0 = class0.getMethod("getInstance");
            Object object0 = class0.getMethod("isHuaweiMobileServicesAvailable", Context.class).invoke(method0.invoke(null), this._applicationService.getAppContext());
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type kotlin.Int");
            if(((int)(((Integer)object0))) == 0) {
                return true;
            }
        }
        catch(ClassNotFoundException unused_ex) {
        }
        return false;
    }

    private final boolean isHMSCoreInstalledAndEnabledFallback() {
        return this.packageInstalledAndEnabled("com.huawei.hwid");
    }

    @Override  // com.onesignal.core.internal.device.IDeviceService
    public boolean isHuaweiDeviceType() {
        return this.getDeviceType() == DeviceType.Huawei;
    }

    private final boolean packageInstalledAndEnabled(String s) {
        try {
            return this._applicationService.getAppContext().getPackageManager().getPackageInfo(s, 0x80).applicationInfo.enabled;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return false;
        }
    }

    private final boolean supportsADM() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    private final boolean supportsGooglePush() {
        return this.getHasFCMLibrary() ? this.isGMSInstalledAndEnabled() : false;
    }
}

