package com.onesignal.user.internal.migrations;

import com.onesignal.common.IDManager;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001A\u00020\nH\u0002J\b\u0010\u000B\u001A\u00020\fH\u0002J\b\u0010\r\u001A\u00020\fH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/onesignal/user/internal/migrations/RecoverFromDroppedLoginBug;", "Lcom/onesignal/core/internal/startup/IStartableService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "isInBadState", "", "recoverByAddingBackDroppedLoginOperation", "", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class RecoverFromDroppedLoginBug implements IStartableService {
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;

    public RecoverFromDroppedLoginBug(IOperationRepo iOperationRepo0, IdentityModelStore identityModelStore0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(iOperationRepo0, "_operationRepo");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super();
        this._operationRepo = iOperationRepo0;
        this._identityModelStore = identityModelStore0;
        this._configModelStore = configModelStore0;
    }

    private final boolean isInBadState() {
        String s = ((IdentityModel)this._identityModelStore.getModel()).getExternalId();
        String s1 = ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId();
        if(s != null && IDManager.INSTANCE.isLocalId(s1)) {
            KClass kClass0 = Reflection.getOrCreateKotlinClass(LoginUserOperation.class);
            return !this._operationRepo.containsInstanceOf(kClass0);
        }
        return false;
    }

    private final void recoverByAddingBackDroppedLoginOperation() {
        LoginUserOperation loginUserOperation0 = new LoginUserOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), ((IdentityModel)this._identityModelStore.getModel()).getExternalId(), null);
        DefaultImpls.enqueue$default(this._operationRepo, loginUserOperation0, false, 2, null);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        if(this.isInBadState()) {
            Logging.warn$default(("User with externalId:" + ((IdentityModel)this._identityModelStore.getModel()).getExternalId() + " was in a bad state, causing it to not update on OneSignal\'s backend! We are recovering and replaying all unsent operations now."), null, 2, null);
            this.recoverByAddingBackDroppedLoginOperation();
        }
    }
}

