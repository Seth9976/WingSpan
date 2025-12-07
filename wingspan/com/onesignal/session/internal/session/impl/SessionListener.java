package com.onesignal.session.internal.session.impl;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u000FH\u0016J\b\u0010\u0014\u001A\u00020\u000FH\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/onesignal/session/internal/session/impl/SessionListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_outcomeEventsController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "(Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;)V", "onSessionActive", "", "onSessionEnded", "duration", "", "onSessionStarted", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SessionListener implements IStartableService, ISessionLifecycleHandler {
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final IOutcomeEventsController _outcomeEventsController;
    private final ISessionService _sessionService;

    public SessionListener(IOperationRepo iOperationRepo0, ISessionService iSessionService0, ConfigModelStore configModelStore0, IdentityModelStore identityModelStore0, IOutcomeEventsController iOutcomeEventsController0) {
        Intrinsics.checkNotNullParameter(iOperationRepo0, "_operationRepo");
        Intrinsics.checkNotNullParameter(iSessionService0, "_sessionService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(iOutcomeEventsController0, "_outcomeEventsController");
        super();
        this._operationRepo = iOperationRepo0;
        this._sessionService = iSessionService0;
        this._configModelStore = configModelStore0;
        this._identityModelStore = identityModelStore0;
        this._outcomeEventsController = iOutcomeEventsController0;
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long v) {
        TrackSessionEndOperation trackSessionEndOperation0 = new TrackSessionEndOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId(), v / 1000L);
        DefaultImpls.enqueue$default(this._operationRepo, trackSessionEndOperation0, false, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(v / 1000L, null) {
            final long $durationInSeconds;
            int label;

            {
                SessionListener.this = sessionListener0;
                this.$durationInSeconds = v;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.session.internal.session.impl.SessionListener.onSessionEnded.1(SessionListener.this, this.$durationInSeconds, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.session.internal.session.impl.SessionListener.onSessionEnded.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return SessionListener.this._outcomeEventsController.sendSessionEndOutcomeEvent(this.$durationInSeconds, this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        TrackSessionStartOperation trackSessionStartOperation0 = new TrackSessionStartOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), ((IdentityModel)this._identityModelStore.getModel()).getOnesignalId());
        DefaultImpls.enqueue$default(this._operationRepo, trackSessionStartOperation0, false, 2, null);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._sessionService.subscribe(this);
    }
}

