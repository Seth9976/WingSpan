package com.onesignal.core;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.application.impl.ApplicationService;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.impl.ParamsBackendService;
import com.onesignal.core.internal.background.IBackgroundManager;
import com.onesignal.core.internal.background.impl.BackgroundManager;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.config.impl.ConfigModelStoreListener;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.DatabaseProvider;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.device.impl.DeviceService;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.core.internal.http.impl.HttpClient;
import com.onesignal.core.internal.http.impl.HttpConnectionFactory;
import com.onesignal.core.internal.http.impl.IHttpConnectionFactory;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.language.impl.LanguageContext;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.impl.OperationModelStore;
import com.onesignal.core.internal.operations.impl.OperationRepo;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.permissions.impl.RequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.impl.PreferencesService;
import com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase;
import com.onesignal.core.internal.purchases.impl.TrackGooglePurchase;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.startup.StartupService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.core.internal.time.impl.Time;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.inAppMessages.internal.MisconfiguredIAMManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.MisconfiguredLocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.internal.MisconfiguredNotificationsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/CoreModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class CoreModule implements IModule {
    @Override  // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder serviceBuilder0) {
        Intrinsics.checkNotNullParameter(serviceBuilder0, "builder");
        serviceBuilder0.register(PreferencesService.class).provides(IPreferencesService.class).provides(IStartableService.class);
        serviceBuilder0.register(HttpConnectionFactory.class).provides(IHttpConnectionFactory.class);
        serviceBuilder0.register(HttpClient.class).provides(IHttpClient.class);
        serviceBuilder0.register(ApplicationService.class).provides(IApplicationService.class);
        serviceBuilder0.register(DeviceService.class).provides(IDeviceService.class);
        serviceBuilder0.register(Time.class).provides(ITime.class);
        serviceBuilder0.register(DatabaseProvider.class).provides(IDatabaseProvider.class);
        serviceBuilder0.register(StartupService.class).provides(StartupService.class);
        serviceBuilder0.register(ConfigModelStore.class).provides(ConfigModelStore.class);
        serviceBuilder0.register(ParamsBackendService.class).provides(IParamsBackendService.class);
        serviceBuilder0.register(ConfigModelStoreListener.class).provides(IStartableService.class);
        serviceBuilder0.register(OperationModelStore.class).provides(OperationModelStore.class);
        serviceBuilder0.register(OperationRepo.class).provides(IOperationRepo.class).provides(IStartableService.class);
        serviceBuilder0.register(RequestPermissionService.class).provides(RequestPermissionService.class).provides(IRequestPermissionService.class);
        serviceBuilder0.register(LanguageContext.class).provides(ILanguageContext.class);
        serviceBuilder0.register(BackgroundManager.class).provides(IBackgroundManager.class).provides(IStartableService.class);
        serviceBuilder0.register(TrackAmazonPurchase.class).provides(IStartableService.class);
        serviceBuilder0.register(TrackGooglePurchase.class).provides(IStartableService.class);
        serviceBuilder0.register(MisconfiguredNotificationsManager.class).provides(INotificationsManager.class);
        serviceBuilder0.register(MisconfiguredIAMManager.class).provides(IInAppMessagesManager.class);
        serviceBuilder0.register(MisconfiguredLocationManager.class).provides(ILocationManager.class);
    }
}

