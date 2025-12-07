package com.onesignal.session.internal.session.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.session.internal.session.SessionModelStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B%\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010 \u001A\u00020!H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u0010#\u001A\u00020!H\u0016J\b\u0010$\u001A\u00020!H\u0016J\b\u0010%\u001A\u00020!H\u0016J\u0010\u0010&\u001A\u00020!2\u0006\u0010\'\u001A\u00020\u001CH\u0016J\u0010\u0010(\u001A\u00020!2\u0006\u0010\'\u001A\u00020\u001CH\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001A\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001D\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/onesignal/session/internal/session/impl/SessionService;", "Lcom/onesignal/session/internal/session/ISessionService;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/background/IBackgroundService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_sessionModelStore", "Lcom/onesignal/session/internal/session/SessionModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/session/internal/session/SessionModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "config", "Lcom/onesignal/core/internal/config/ConfigModel;", "hasSubscribers", "", "getHasSubscribers", "()Z", "scheduleBackgroundRunIn", "", "getScheduleBackgroundRunIn", "()Ljava/lang/Long;", "session", "Lcom/onesignal/session/internal/session/SessionModel;", "sessionLifeCycleNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "startTime", "getStartTime", "()J", "backgroundRun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocus", "onUnfocused", "start", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SessionService implements IApplicationLifecycleHandler, IBackgroundService, IStartableService, ISessionService {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final SessionModelStore _sessionModelStore;
    private final ITime _time;
    private ConfigModel config;
    private SessionModel session;
    private final EventProducer sessionLifeCycleNotifier;

    public SessionService(IApplicationService iApplicationService0, ConfigModelStore configModelStore0, SessionModelStore sessionModelStore0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(sessionModelStore0, "_sessionModelStore");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._configModelStore = configModelStore0;
        this._sessionModelStore = sessionModelStore0;
        this._time = iTime0;
        this.sessionLifeCycleNotifier = new EventProducer();
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundService
    public Object backgroundRun(Continuation continuation0) {
        Logging.log(LogLevel.DEBUG, "SessionService.backgroundRun()");
        SessionModel sessionModel0 = this.session;
        Intrinsics.checkNotNull(sessionModel0);
        if(!sessionModel0.isValid()) {
            return Unit.INSTANCE;
        }
        SessionModel sessionModel1 = this.session;
        Intrinsics.checkNotNull(sessionModel1);
        Logging.debug$default(("SessionService: Session ended. activeDuration: " + sessionModel1.getActiveDuration()), null, 2, null);
        SessionModel sessionModel2 = this.session;
        Intrinsics.checkNotNull(sessionModel2);
        sessionModel2.setValid(false);
        Function1 function10 = new Function1() {
            {
                SessionService.this = sessionService0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISessionLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISessionLifecycleHandler iSessionLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iSessionLifecycleHandler0, "it");
                SessionModel sessionModel0 = SessionService.this.session;
                Intrinsics.checkNotNull(sessionModel0);
                iSessionLifecycleHandler0.onSessionEnded(sessionModel0.getActiveDuration());
            }
        };
        this.sessionLifeCycleNotifier.fire(function10);
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.sessionLifeCycleNotifier.getHasSubscribers();
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundService
    public Long getScheduleBackgroundRunIn() {
        SessionModel sessionModel0 = this.session;
        Intrinsics.checkNotNull(sessionModel0);
        if(sessionModel0.isValid()) {
            ConfigModel configModel0 = this.config;
            Intrinsics.checkNotNull(configModel0);
            return configModel0.getSessionFocusTimeout();
        }
        return null;
    }

    @Override  // com.onesignal.session.internal.session.ISessionService
    public long getStartTime() {
        SessionModel sessionModel0 = this.session;
        Intrinsics.checkNotNull(sessionModel0);
        return sessionModel0.getStartTime();
    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus() {
        Logging.log(LogLevel.DEBUG, "SessionService.onFocus()");
        SessionModel sessionModel0 = this.session;
        Intrinsics.checkNotNull(sessionModel0);
        if(!sessionModel0.isValid()) {
            SessionModel sessionModel1 = this.session;
            Intrinsics.checkNotNull(sessionModel1);
            Intrinsics.checkNotNullExpressionValue("f22939ea-5144-4ac8-a9aa-0bf023fa1eff", "randomUUID().toString()");
            sessionModel1.setSessionId("f22939ea-5144-4ac8-a9aa-0bf023fa1eff");
            SessionModel sessionModel2 = this.session;
            Intrinsics.checkNotNull(sessionModel2);
            sessionModel2.setStartTime(this._time.getCurrentTimeMillis());
            SessionModel sessionModel3 = this.session;
            Intrinsics.checkNotNull(sessionModel3);
            SessionModel sessionModel4 = this.session;
            Intrinsics.checkNotNull(sessionModel4);
            sessionModel3.setFocusTime(sessionModel4.getStartTime());
            SessionModel sessionModel5 = this.session;
            Intrinsics.checkNotNull(sessionModel5);
            sessionModel5.setActiveDuration(0L);
            SessionModel sessionModel6 = this.session;
            Intrinsics.checkNotNull(sessionModel6);
            sessionModel6.setValid(true);
            SessionModel sessionModel7 = this.session;
            Intrinsics.checkNotNull(sessionModel7);
            Logging.debug$default(("SessionService: New session started at " + sessionModel7.getStartTime()), null, 2, null);
            this.sessionLifeCycleNotifier.fire(com.onesignal.session.internal.session.impl.SessionService.onFocus.1.INSTANCE);
            return;
        }
        SessionModel sessionModel8 = this.session;
        Intrinsics.checkNotNull(sessionModel8);
        sessionModel8.setFocusTime(this._time.getCurrentTimeMillis());
        this.sessionLifeCycleNotifier.fire(com.onesignal.session.internal.session.impl.SessionService.onFocus.2.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.session.internal.session.impl.SessionService.onFocus.1 extends Lambda implements Function1 {
            public static final com.onesignal.session.internal.session.impl.SessionService.onFocus.1 INSTANCE;

            static {
                com.onesignal.session.internal.session.impl.SessionService.onFocus.1.INSTANCE = new com.onesignal.session.internal.session.impl.SessionService.onFocus.1();
            }

            com.onesignal.session.internal.session.impl.SessionService.onFocus.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISessionLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISessionLifecycleHandler iSessionLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iSessionLifecycleHandler0, "it");
                iSessionLifecycleHandler0.onSessionStarted();
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.session.internal.session.impl.SessionService.onFocus.2 extends Lambda implements Function1 {
            public static final com.onesignal.session.internal.session.impl.SessionService.onFocus.2 INSTANCE;

            static {
                com.onesignal.session.internal.session.impl.SessionService.onFocus.2.INSTANCE = new com.onesignal.session.internal.session.impl.SessionService.onFocus.2();
            }

            com.onesignal.session.internal.session.impl.SessionService.onFocus.2() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ISessionLifecycleHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISessionLifecycleHandler iSessionLifecycleHandler0) {
                Intrinsics.checkNotNullParameter(iSessionLifecycleHandler0, "it");
                iSessionLifecycleHandler0.onSessionActive();
            }
        }

    }

    @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        Logging.log(LogLevel.DEBUG, "SessionService.onUnfocused()");
        long v = this._time.getCurrentTimeMillis();
        SessionModel sessionModel0 = this.session;
        Intrinsics.checkNotNull(sessionModel0);
        long v1 = sessionModel0.getFocusTime();
        SessionModel sessionModel1 = this.session;
        Intrinsics.checkNotNull(sessionModel1);
        sessionModel1.setActiveDuration(sessionModel1.getActiveDuration() + (v - v1));
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.session = (SessionModel)this._sessionModelStore.getModel();
        this.config = (ConfigModel)this._configModelStore.getModel();
        this._applicationService.addApplicationLifecycleHandler(this);
    }

    public void subscribe(ISessionLifecycleHandler iSessionLifecycleHandler0) {
        Intrinsics.checkNotNullParameter(iSessionLifecycleHandler0, "handler");
        this.sessionLifeCycleNotifier.subscribe(iSessionLifecycleHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ISessionLifecycleHandler)object0));
    }

    public void unsubscribe(ISessionLifecycleHandler iSessionLifecycleHandler0) {
        Intrinsics.checkNotNullParameter(iSessionLifecycleHandler0, "handler");
        this.sessionLifeCycleNotifier.unsubscribe(iSessionLifecycleHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ISessionLifecycleHandler)object0));
    }
}

