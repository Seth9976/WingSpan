package com.onesignal.session.internal;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0018\u0010\t\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/onesignal/session/internal/SessionManager;", "Lcom/onesignal/session/ISessionManager;", "_outcomeController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "(Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;)V", "addOutcome", "", "name", "", "addOutcomeWithValue", "value", "", "addUniqueOutcome", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class SessionManager implements ISessionManager {
    private final IOutcomeEventsController _outcomeController;

    public SessionManager(IOutcomeEventsController iOutcomeEventsController0) {
        Intrinsics.checkNotNullParameter(iOutcomeEventsController0, "_outcomeController");
        super();
        this._outcomeController = iOutcomeEventsController0;
    }

    @Override  // com.onesignal.session.ISessionManager
    public void addOutcome(String s) {
        Intrinsics.checkNotNullParameter(s, "name");
        Logging.log(LogLevel.DEBUG, "sendOutcome(name: " + s + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, null) {
            final String $name;
            int label;

            {
                SessionManager.this = sessionManager0;
                this.$name = s;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.session.internal.SessionManager.addOutcome.1(SessionManager.this, this.$name, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.session.internal.SessionManager.addOutcome.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return SessionManager.this._outcomeController.sendOutcomeEvent(this.$name, this) == object1 ? object1 : Unit.INSTANCE;
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

    @Override  // com.onesignal.session.ISessionManager
    public void addOutcomeWithValue(String s, float f) {
        Intrinsics.checkNotNullParameter(s, "name");
        Logging.log(LogLevel.DEBUG, "sendOutcomeWithValue(name: " + s + ", value: " + f + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, f, null) {
            final String $name;
            final float $value;
            int label;

            {
                SessionManager.this = sessionManager0;
                this.$name = s;
                this.$value = f;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.session.internal.SessionManager.addOutcomeWithValue.1(SessionManager.this, this.$name, this.$value, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.session.internal.SessionManager.addOutcomeWithValue.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return SessionManager.this._outcomeController.sendOutcomeEventWithValue(this.$name, this.$value, this) == object1 ? object1 : Unit.INSTANCE;
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

    @Override  // com.onesignal.session.ISessionManager
    public void addUniqueOutcome(String s) {
        Intrinsics.checkNotNullParameter(s, "name");
        Logging.log(LogLevel.DEBUG, "sendUniqueOutcome(name: " + s + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(s, null) {
            final String $name;
            int label;

            {
                SessionManager.this = sessionManager0;
                this.$name = s;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.session.internal.SessionManager.addUniqueOutcome.1(SessionManager.this, this.$name, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.session.internal.SessionManager.addUniqueOutcome.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return SessionManager.this._outcomeController.sendUniqueOutcomeEvent(this.$name, this) == object1 ? object1 : Unit.INSTANCE;
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
}

