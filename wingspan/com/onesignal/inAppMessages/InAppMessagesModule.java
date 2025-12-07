package com.onesignal.inAppMessages;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.inAppMessages.internal.InAppMessagesManager;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer;
import com.onesignal.inAppMessages.internal.hydrators.InAppHydrator;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.preferences.impl.InAppPreferencesController;
import com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePromptFactory;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController;
import com.onesignal.inAppMessages.internal.triggers.impl.TriggerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/InAppMessagesModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessagesModule implements IModule {
    @Override  // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder serviceBuilder0) {
        Intrinsics.checkNotNullParameter(serviceBuilder0, "builder");
        serviceBuilder0.register(InAppStateService.class).provides(InAppStateService.class);
        serviceBuilder0.register(InAppHydrator.class).provides(InAppHydrator.class);
        serviceBuilder0.register(InAppPreferencesController.class).provides(IInAppPreferencesController.class);
        serviceBuilder0.register(InAppRepository.class).provides(IInAppRepository.class);
        serviceBuilder0.register(InAppBackendService.class).provides(IInAppBackendService.class);
        serviceBuilder0.register(IAMLifecycleService.class).provides(IInAppLifecycleService.class);
        serviceBuilder0.register(TriggerModelStore.class).provides(TriggerModelStore.class);
        serviceBuilder0.register(TriggerController.class).provides(ITriggerController.class);
        serviceBuilder0.register(DynamicTriggerController.class).provides(DynamicTriggerController.class);
        serviceBuilder0.register(InAppDisplayer.class).provides(IInAppDisplayer.class);
        serviceBuilder0.register(InAppMessagePreviewHandler.class).provides(IStartableService.class);
        serviceBuilder0.register(InAppMessagePromptFactory.class).provides(IInAppMessagePromptFactory.class);
        serviceBuilder0.register(InAppMessagesManager.class).provides(IInAppMessagesManager.class).provides(IStartableService.class);
    }
}

