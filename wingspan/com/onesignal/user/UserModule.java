package com.onesignal.user;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.UserManager;
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.impl.IdentityBackendService;
import com.onesignal.user.internal.backend.impl.SubscriptionBackendService;
import com.onesignal.user.internal.backend.impl.UserBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.builduser.impl.RebuildUserService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.migrations.RecoverFromDroppedLoginBug;
import com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor;
import com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor;
import com.onesignal.user.internal.operations.impl.listeners.IdentityModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.PropertiesModelStoreListener;
import com.onesignal.user.internal.operations.impl.listeners.SubscriptionModelStoreListener;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.service.UserRefreshService;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.impl.SubscriptionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/onesignal/user/UserModule;", "Lcom/onesignal/common/modules/IModule;", "()V", "register", "", "builder", "Lcom/onesignal/common/services/ServiceBuilder;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserModule implements IModule {
    @Override  // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder serviceBuilder0) {
        Intrinsics.checkNotNullParameter(serviceBuilder0, "builder");
        serviceBuilder0.register(PropertiesModelStore.class).provides(PropertiesModelStore.class);
        serviceBuilder0.register(PropertiesModelStoreListener.class).provides(IBootstrapService.class);
        serviceBuilder0.register(IdentityModelStore.class).provides(IdentityModelStore.class);
        serviceBuilder0.register(IdentityModelStoreListener.class).provides(IBootstrapService.class);
        serviceBuilder0.register(IdentityBackendService.class).provides(IIdentityBackendService.class);
        serviceBuilder0.register(IdentityOperationExecutor.class).provides(IdentityOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder0.register(SubscriptionModelStore.class).provides(SubscriptionModelStore.class);
        serviceBuilder0.register(SubscriptionModelStoreListener.class).provides(IBootstrapService.class);
        serviceBuilder0.register(SubscriptionBackendService.class).provides(ISubscriptionBackendService.class);
        serviceBuilder0.register(SubscriptionOperationExecutor.class).provides(SubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder0.register(SubscriptionManager.class).provides(ISubscriptionManager.class);
        serviceBuilder0.register(RebuildUserService.class).provides(IRebuildUserService.class);
        serviceBuilder0.register(UserBackendService.class).provides(IUserBackendService.class);
        serviceBuilder0.register(UpdateUserOperationExecutor.class).provides(UpdateUserOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder0.register(LoginUserOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder0.register(LoginUserFromSubscriptionOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder0.register(RefreshUserOperationExecutor.class).provides(IOperationExecutor.class);
        serviceBuilder0.register(UserManager.class).provides(IUserManager.class);
        serviceBuilder0.register(UserRefreshService.class).provides(IStartableService.class);
        serviceBuilder0.register(RecoverFromDroppedLoginBug.class).provides(IStartableService.class);
    }
}

