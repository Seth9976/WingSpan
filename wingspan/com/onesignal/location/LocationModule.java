package com.onesignal.location;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.location.internal.LocationManager;
import com.onesignal.location.internal.background.LocationBackgroundService;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.capture.impl.LocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.impl.FusedLocationApiWrapperImpl;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import com.onesignal.location.internal.controller.impl.HmsLocationController;
import com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper;
import com.onesignal.location.internal.controller.impl.NullLocationController;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.location.internal.preferences.impl.LocationPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/location/LocationModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationModule implements IModule {
    @Override  // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder serviceBuilder0) {
        Intrinsics.checkNotNullParameter(serviceBuilder0, "builder");
        serviceBuilder0.register(LocationPermissionController.class).provides(LocationPermissionController.class).provides(IStartableService.class);
        serviceBuilder0.register(FusedLocationApiWrapperImpl.class).provides(IFusedLocationApiWrapper.class);
        serviceBuilder0.register(com.onesignal.location.LocationModule.register.1.INSTANCE).provides(ILocationController.class);
        serviceBuilder0.register(LocationPreferencesService.class).provides(ILocationPreferencesService.class);
        serviceBuilder0.register(LocationCapturer.class).provides(ILocationCapturer.class);
        serviceBuilder0.register(LocationBackgroundService.class).provides(IBackgroundService.class);
        serviceBuilder0.register(LocationManager.class).provides(ILocationManager.class).provides(IStartableService.class);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/onesignal/location/internal/controller/ILocationController;", "it", "Lcom/onesignal/common/services/IServiceProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.location.LocationModule.register.1 extends Lambda implements Function1 {
            public static final com.onesignal.location.LocationModule.register.1 INSTANCE;

            static {
                com.onesignal.location.LocationModule.register.1.INSTANCE = new com.onesignal.location.LocationModule.register.1();
            }

            com.onesignal.location.LocationModule.register.1() {
                super(1);
            }

            public final ILocationController invoke(IServiceProvider iServiceProvider0) {
                Intrinsics.checkNotNullParameter(iServiceProvider0, "it");
                IDeviceService iDeviceService0 = (IDeviceService)iServiceProvider0.getService(IDeviceService.class);
                if(iDeviceService0.isAndroidDeviceType() && LocationUtils.INSTANCE.hasGMSLocationLibrary()) {
                    return new GmsLocationController(((IApplicationService)iServiceProvider0.getService(IApplicationService.class)), ((IFusedLocationApiWrapper)iServiceProvider0.getService(IFusedLocationApiWrapper.class)));
                }
                return iDeviceService0.isHuaweiDeviceType() && LocationUtils.INSTANCE.hasHMSLocationLibrary() ? new HmsLocationController(((IApplicationService)iServiceProvider0.getService(IApplicationService.class))) : new NullLocationController();
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((IServiceProvider)object0));
            }
        }

    }
}

