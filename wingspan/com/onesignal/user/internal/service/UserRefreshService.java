package com.onesignal.user.internal.service;

import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0002\u0010\u000BJ\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u000FH\u0016J\b\u0010\u0011\u001A\u00020\u000FH\u0002J\b\u0010\u0012\u001A\u00020\u000FH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/onesignal/user/internal/service/UserRefreshService;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "onFocusCalled", "", "onFocus", "", "onUnfocused", "refreshUser", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserRefreshService implements IApplicationLifecycleHandler, IStartableService {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private boolean onFocusCalled;

    public UserRefreshService(IApplicationService iApplicationService0, IOperationRepo iOperationRepo0, ConfigModelStore configModelStore0, IdentityModelStore identityModelStore0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "_operationRepo");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        super();
        this._applicationService = iApplicationService0;
        this._operationRepo = iOperationRepo0;
        this._configModelStore = configModelStore0;
        this._identityModelStore = identityModelStore0;
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        if(this.onFocusCalled) {
            return;
        }
        this.onFocusCalled = true;
        this.refreshUser();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    private final void refreshUser() {
        RefreshUserOperation refreshUserOperation0 = new RefreshUserOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId());
        DefaultImpls.enqueue$default(this._operationRepo, refreshUserOperation0, false, 2, null);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        if(this._applicationService.isInForeground()) {
            this.refreshUser();
            return;
        }
        this._applicationService.addApplicationLifecycleHandler(this);
    }
}

