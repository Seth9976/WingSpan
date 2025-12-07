package com.onesignal.session;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.session.internal.SessionManager;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.impl.InfluenceManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.outcomes.impl.IOutcomeEventsBackendService;
import com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences;
import com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsController;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsPreferences;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.session.internal.session.SessionModelStore;
import com.onesignal.session.internal.session.impl.SessionListener;
import com.onesignal.session.internal.session.impl.SessionService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/SessionModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SessionModule implements IModule {
    @Override  // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder serviceBuilder0) {
        Intrinsics.checkNotNullParameter(serviceBuilder0, "builder");
        serviceBuilder0.register(OutcomeEventsPreferences.class).provides(IOutcomeEventsPreferences.class);
        serviceBuilder0.register(OutcomeEventsRepository.class).provides(IOutcomeEventsRepository.class);
        serviceBuilder0.register(OutcomeEventsBackendService.class).provides(IOutcomeEventsBackendService.class);
        serviceBuilder0.register(OutcomeEventsController.class).provides(IOutcomeEventsController.class).provides(IStartableService.class);
        serviceBuilder0.register(InfluenceManager.class).provides(IInfluenceManager.class);
        serviceBuilder0.register(SessionModelStore.class).provides(SessionModelStore.class);
        serviceBuilder0.register(SessionService.class).provides(ISessionService.class).provides(IStartableService.class).provides(IBackgroundService.class);
        serviceBuilder0.register(SessionListener.class).provides(IStartableService.class);
        serviceBuilder0.register(SessionManager.class).provides(ISessionManager.class);
    }
}

