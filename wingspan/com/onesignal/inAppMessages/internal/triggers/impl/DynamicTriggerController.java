package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.Trigger.OSTriggerKind;
import com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\u000E\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\u0017J \u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001DH\u0002J\u0018\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001F\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020\u001AH\u0002J\u0010\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0002H\u0016J\u0010\u0010$\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0002H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_session", "Lcom/onesignal/session/internal/session/ISessionService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/time/ITime;)V", "events", "Lcom/onesignal/common/events/EventProducer;", "getEvents", "()Lcom/onesignal/common/events/EventProducer;", "hasSubscribers", "", "getHasSubscribers", "()Z", "scheduledMessages", "", "", "dynamicTriggerShouldFire", "trigger", "Lcom/onesignal/inAppMessages/internal/Trigger;", "evaluateTimeIntervalWithOperator", "timeInterval", "", "currentTimeInterval", "operator", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "roughlyEqual", "left", "right", "subscribe", "", "handler", "unsubscribe", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DynamicTriggerController implements IEventNotifier {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController$Companion;", "", "()V", "DEFAULT_LAST_IN_APP_TIME_AGO", "", "REQUIRED_ACCURACY", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[OSTriggerKind.values().length];
            arr_v[OSTriggerKind.SESSION_TIME.ordinal()] = 1;
            arr_v[OSTriggerKind.TIME_SINCE_LAST_IN_APP.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[OSTriggerOperator.values().length];
            arr_v1[OSTriggerOperator.LESS_THAN.ordinal()] = 1;
            arr_v1[OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 2;
            arr_v1[OSTriggerOperator.GREATER_THAN.ordinal()] = 3;
            arr_v1[OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 4;
            arr_v1[OSTriggerOperator.EQUAL_TO.ordinal()] = 5;
            arr_v1[OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 6;
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final Companion Companion = null;
    private static final long DEFAULT_LAST_IN_APP_TIME_AGO = 0xF423FL;
    private static final double REQUIRED_ACCURACY = 0.3;
    private final ISessionService _session;
    private final InAppStateService _state;
    private final ITime _time;
    private final EventProducer events;
    private final List scheduledMessages;

    static {
        DynamicTriggerController.Companion = new Companion(null);
    }

    public DynamicTriggerController(InAppStateService inAppStateService0, ISessionService iSessionService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(inAppStateService0, "_state");
        Intrinsics.checkNotNullParameter(iSessionService0, "_session");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._state = inAppStateService0;
        this._session = iSessionService0;
        this._time = iTime0;
        this.events = new EventProducer();
        this.scheduledMessages = new ArrayList();
    }

    public final boolean dynamicTriggerShouldFire(Trigger trigger0) {
        long v1;
        Intrinsics.checkNotNullParameter(trigger0, "trigger");
        if(trigger0.getValue() == null) {
            return false;
        }
        synchronized(this.scheduledMessages) {
            if(!(trigger0.getValue() instanceof Number)) {
                return false;
            }
            switch(WhenMappings.$EnumSwitchMapping$0[trigger0.getKind().ordinal()]) {
                case 1: {
                    v1 = this._time.getCurrentTimeMillis() - this._session.getStartTime();
                    break;
                }
                case 2: {
                    if(this._state.getInAppMessageIdShowing() != null) {
                        return false;
                    }
                    Long long0 = this._state.getLastTimeInAppDismissed();
                    v1 = long0 == null ? 0xF423FL : this._time.getCurrentTimeMillis() - ((long)long0);
                    break;
                }
                default: {
                    v1 = 0L;
                }
            }
            String s = trigger0.getTriggerId();
            Number number0 = (Number)trigger0.getValue();
            Intrinsics.checkNotNull(number0);
            long v2 = (long)(number0.doubleValue() * 1000.0);
            if(this.evaluateTimeIntervalWithOperator(((double)v2), ((double)v1), trigger0.getOperatorType())) {
                Function1 function10 = new Function1() {
                    final String $triggerId;

                    {
                        this.$triggerId = s;
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((ITriggerHandler)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ITriggerHandler iTriggerHandler0) {
                        Intrinsics.checkNotNullParameter(iTriggerHandler0, "it");
                        iTriggerHandler0.onTriggerCompleted(this.$triggerId);
                    }
                };
                this.events.fire(function10);
                return true;
            }
            long v3 = v2 - v1;
            if(v3 <= 0L) {
                return false;
            }
            if(this.scheduledMessages.contains(s)) {
                return false;
            }
            TimerTask timerTask0 = new TimerTask() {
                @Override
                public void run() {
                    s.scheduledMessages.remove(this.$triggerId);
                    s.getEvents().fire(com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire.1.2.run.1.INSTANCE);

                    @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
                    final class com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire.1.2.run.1 extends Lambda implements Function1 {
                        public static final com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire.1.2.run.1 INSTANCE;

                        static {
                            com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire.1.2.run.1.INSTANCE = new com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire.1.2.run.1();
                        }

                        com.onesignal.inAppMessages.internal.triggers.impl.DynamicTriggerController.dynamicTriggerShouldFire.1.2.run.1() {
                            super(1);
                        }

                        @Override  // kotlin.jvm.functions.Function1
                        public Object invoke(Object object0) {
                            this.invoke(((ITriggerHandler)object0));
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ITriggerHandler iTriggerHandler0) {
                            Intrinsics.checkNotNullParameter(iTriggerHandler0, "it");
                            iTriggerHandler0.onTriggerConditionChanged();
                        }
                    }

                }
            };
            DynamicTriggerTimer.INSTANCE.scheduleTrigger(timerTask0, s, v3);
            this.scheduledMessages.add(s);
            return false;
        }
    }

    private final boolean evaluateTimeIntervalWithOperator(double f, double f1, OSTriggerOperator trigger$OSTriggerOperator0) {
        switch(WhenMappings.$EnumSwitchMapping$1[trigger$OSTriggerOperator0.ordinal()]) {
            case 1: {
                return f1 < f;
            }
            case 2: {
                return f1 <= f || this.roughlyEqual(f, f1);
            }
            case 3: {
                return f1 >= f;
            }
            case 4: {
                return f1 >= f || this.roughlyEqual(f, f1);
            }
            case 5: {
                return this.roughlyEqual(f, f1);
            }
            case 6: {
                return !this.roughlyEqual(f, f1);
            }
            default: {
                Logging.error$default(("Attempted to apply an invalid operator on a time-based in-app-message trigger: " + trigger$OSTriggerOperator0), null, 2, null);
                return false;
            }
        }
    }

    public final EventProducer getEvents() {
        return this.events;
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    private final boolean roughlyEqual(double f, double f1) {
        return Math.abs(f - f1) < 0.3;
    }

    public void subscribe(ITriggerHandler iTriggerHandler0) {
        Intrinsics.checkNotNullParameter(iTriggerHandler0, "handler");
        this.events.subscribe(iTriggerHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ITriggerHandler)object0));
    }

    public void unsubscribe(ITriggerHandler iTriggerHandler0) {
        Intrinsics.checkNotNullParameter(iTriggerHandler0, "handler");
        this.events.unsubscribe(iTriggerHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ITriggerHandler)object0));
    }
}

