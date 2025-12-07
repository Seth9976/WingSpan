package com.onesignal.notifications;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.NotificationsManager;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.FirebaseAnalyticsTracker;
import com.onesignal.notifications.internal.analytics.impl.NoAnalyticsTracker;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.backend.impl.NotificationBackendService;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.badges.impl.BadgeCountUpdater;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.channels.impl.NotificationChannelManager;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.data.impl.NotificationQueryHelper;
import com.onesignal.notifications.internal.data.impl.NotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.impl.NotificationDisplayer;
import com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager;
import com.onesignal.notifications.internal.listeners.DeviceRegistrationListener;
import com.onesignal.notifications.internal.listeners.NotificationListener;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor;
import com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS;
import com.onesignal.notifications.internal.permissions.INotificationPermissionController;
import com.onesignal.notifications.internal.permissions.impl.NotificationPermissionController;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.notifications.internal.pushtoken.PushTokenManager;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor;
import com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorADM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS;
import com.onesignal.notifications.internal.registration.impl.PushRegistratorNone;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor;
import com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/NotificationsModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationsModule implements IModule {
    @Override  // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder serviceBuilder0) {
        Intrinsics.checkNotNullParameter(serviceBuilder0, "builder");
        serviceBuilder0.register(NotificationBackendService.class).provides(INotificationBackendService.class);
        serviceBuilder0.register(NotificationRestoreWorkManager.class).provides(INotificationRestoreWorkManager.class);
        serviceBuilder0.register(NotificationQueryHelper.class).provides(INotificationQueryHelper.class);
        serviceBuilder0.register(BadgeCountUpdater.class).provides(IBadgeCountUpdater.class);
        serviceBuilder0.register(NotificationRepository.class).provides(INotificationRepository.class);
        serviceBuilder0.register(NotificationGenerationWorkManager.class).provides(INotificationGenerationWorkManager.class);
        serviceBuilder0.register(NotificationBundleProcessor.class).provides(INotificationBundleProcessor.class);
        serviceBuilder0.register(NotificationChannelManager.class).provides(INotificationChannelManager.class);
        serviceBuilder0.register(NotificationLimitManager.class).provides(INotificationLimitManager.class);
        serviceBuilder0.register(NotificationDisplayer.class).provides(INotificationDisplayer.class);
        serviceBuilder0.register(SummaryNotificationDisplayer.class).provides(ISummaryNotificationDisplayer.class);
        serviceBuilder0.register(NotificationDisplayBuilder.class).provides(INotificationDisplayBuilder.class);
        serviceBuilder0.register(NotificationGenerationProcessor.class).provides(INotificationGenerationProcessor.class);
        serviceBuilder0.register(NotificationRestoreProcessor.class).provides(INotificationRestoreProcessor.class);
        serviceBuilder0.register(NotificationSummaryManager.class).provides(INotificationSummaryManager.class);
        serviceBuilder0.register(NotificationOpenedProcessor.class).provides(INotificationOpenedProcessor.class);
        serviceBuilder0.register(NotificationOpenedProcessorHMS.class).provides(INotificationOpenedProcessorHMS.class);
        serviceBuilder0.register(NotificationPermissionController.class).provides(INotificationPermissionController.class);
        serviceBuilder0.register(NotificationLifecycleService.class).provides(INotificationLifecycleService.class);
        serviceBuilder0.register(com.onesignal.notifications.NotificationsModule.register.1.INSTANCE).provides(IAnalyticsTracker.class);
        serviceBuilder0.register(com.onesignal.notifications.NotificationsModule.register.2.INSTANCE).provides(IPushRegistrator.class).provides(IPushRegistratorCallback.class);
        serviceBuilder0.register(GooglePlayServicesUpgradePrompt.class).provides(GooglePlayServicesUpgradePrompt.class);
        serviceBuilder0.register(PushTokenManager.class).provides(IPushTokenManager.class);
        serviceBuilder0.register(ReceiveReceiptWorkManager.class).provides(IReceiveReceiptWorkManager.class);
        serviceBuilder0.register(ReceiveReceiptProcessor.class).provides(IReceiveReceiptProcessor.class);
        serviceBuilder0.register(DeviceRegistrationListener.class).provides(IStartableService.class);
        serviceBuilder0.register(NotificationListener.class).provides(IStartableService.class);
        serviceBuilder0.register(NotificationsManager.class).provides(INotificationsManager.class).provides(INotificationActivityOpener.class);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "it", "Lcom/onesignal/common/services/IServiceProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.notifications.NotificationsModule.register.1 extends Lambda implements Function1 {
            public static final com.onesignal.notifications.NotificationsModule.register.1 INSTANCE;

            static {
                com.onesignal.notifications.NotificationsModule.register.1.INSTANCE = new com.onesignal.notifications.NotificationsModule.register.1();
            }

            com.onesignal.notifications.NotificationsModule.register.1() {
                super(1);
            }

            public final IAnalyticsTracker invoke(IServiceProvider iServiceProvider0) {
                Intrinsics.checkNotNullParameter(iServiceProvider0, "it");
                return FirebaseAnalyticsTracker.Companion.canTrack() ? new FirebaseAnalyticsTracker(((IApplicationService)iServiceProvider0.getService(IApplicationService.class)), ((ConfigModelStore)iServiceProvider0.getService(ConfigModelStore.class)), ((ITime)iServiceProvider0.getService(ITime.class))) : new NoAnalyticsTracker();
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((IServiceProvider)object0));
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/common/services/IServiceProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.notifications.NotificationsModule.register.2 extends Lambda implements Function1 {
            public static final com.onesignal.notifications.NotificationsModule.register.2 INSTANCE;

            static {
                com.onesignal.notifications.NotificationsModule.register.2.INSTANCE = new com.onesignal.notifications.NotificationsModule.register.2();
            }

            com.onesignal.notifications.NotificationsModule.register.2() {
                super(1);
            }

            public final Object invoke(IServiceProvider iServiceProvider0) {
                Intrinsics.checkNotNullParameter(iServiceProvider0, "it");
                IDeviceService iDeviceService0 = (IDeviceService)iServiceProvider0.getService(IDeviceService.class);
                if(iDeviceService0.isFireOSDeviceType()) {
                    return new PushRegistratorADM(((IApplicationService)iServiceProvider0.getService(IApplicationService.class)));
                }
                if(iDeviceService0.isAndroidDeviceType()) {
                    return iDeviceService0.getHasFCMLibrary() ? new PushRegistratorFCM(((ConfigModelStore)iServiceProvider0.getService(ConfigModelStore.class)), ((IApplicationService)iServiceProvider0.getService(IApplicationService.class)), ((GooglePlayServicesUpgradePrompt)iServiceProvider0.getService(GooglePlayServicesUpgradePrompt.class)), iDeviceService0) : new PushRegistratorNone();
                }
                return new PushRegistratorHMS(iDeviceService0, ((IApplicationService)iServiceProvider0.getService(IApplicationService.class)));
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((IServiceProvider)object0));
            }
        }

    }
}

