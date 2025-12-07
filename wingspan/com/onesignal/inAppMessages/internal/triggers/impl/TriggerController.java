package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.Trigger.OSTriggerKind;
import com.onesignal.inAppMessages.internal.Trigger.OSTriggerOperator;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0016\u001A\u00020\u0010H\u0002J\u0016\u0010\u0017\u001A\u00020\n2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019H\u0002J\u0010\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0010\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001AH\u0002J\u001E\u0010 \u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001D2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u000F0\"H\u0016J\u0010\u0010#\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0018\u0010$\u001A\u00020\u00142\u0006\u0010%\u001A\u00020\u00032\u0006\u0010&\u001A\u00020\u000FH\u0016J\u0018\u0010\'\u001A\u00020\u00142\u0006\u0010%\u001A\u00020\u00032\u0006\u0010&\u001A\u00020\u000FH\u0016J\u0018\u0010(\u001A\u00020\u00142\u0006\u0010)\u001A\u00020*2\u0006\u0010&\u001A\u00020\u000FH\u0016J\u0010\u0010+\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000FH\u0002J\u0010\u0010,\u001A\u00020\u00142\u0006\u0010-\u001A\u00020.H\u0016J\"\u0010/\u001A\u00020\n2\b\u00100\u001A\u0004\u0018\u00010\u00102\u0006\u00101\u001A\u00020\u00102\u0006\u00102\u001A\u000203H\u0002J \u00104\u001A\u00020\n2\u0006\u00100\u001A\u0002052\u0006\u00101\u001A\u0002052\u0006\u00102\u001A\u000203H\u0002J \u00106\u001A\u00020\n2\u0006\u00100\u001A\u0002052\u0006\u00101\u001A\u00020\u000F2\u0006\u00102\u001A\u000203H\u0002J \u00107\u001A\u00020\n2\u0006\u00100\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\u000F2\u0006\u00102\u001A\u000203H\u0002J\u0010\u00108\u001A\u00020\u00142\u0006\u0010-\u001A\u00020.H\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000B\u0010\fR!\u0010\r\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012\u00A8\u00069"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/TriggerController;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "triggerModelStore", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "_dynamicTriggerController", "Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;", "(Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;)V", "hasSubscribers", "", "getHasSubscribers", "()Z", "triggers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getTriggers", "()Ljava/util/concurrent/ConcurrentHashMap;", "addTriggers", "", "key", "value", "evaluateAndTriggers", "andConditions", "", "Lcom/onesignal/inAppMessages/internal/Trigger;", "evaluateMessageTriggers", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "evaluateTrigger", "trigger", "isTriggerOnMessage", "triggersKeys", "", "messageHasOnlyDynamicTriggers", "onModelAdded", "model", "tag", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "removeTriggersForKeys", "subscribe", "handler", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "triggerMatchesFlex", "triggerValue", "deviceValue", "operator", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "triggerMatchesNumericValue", "", "triggerMatchesNumericValueFlex", "triggerMatchesStringValue", "unsubscribe", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TriggerController implements IModelStoreChangeHandler, ITriggerController {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[OSTriggerOperator.values().length];
            arr_v[OSTriggerOperator.EQUAL_TO.ordinal()] = 1;
            arr_v[OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 2;
            arr_v[OSTriggerOperator.EXISTS.ordinal()] = 3;
            arr_v[OSTriggerOperator.CONTAINS.ordinal()] = 4;
            arr_v[OSTriggerOperator.NOT_EXISTS.ordinal()] = 5;
            arr_v[OSTriggerOperator.LESS_THAN.ordinal()] = 6;
            arr_v[OSTriggerOperator.GREATER_THAN.ordinal()] = 7;
            arr_v[OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 8;
            arr_v[OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 9;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private DynamicTriggerController _dynamicTriggerController;
    private final ConcurrentHashMap triggers;

    public TriggerController(TriggerModelStore triggerModelStore0, DynamicTriggerController dynamicTriggerController0) {
        Intrinsics.checkNotNullParameter(triggerModelStore0, "triggerModelStore");
        Intrinsics.checkNotNullParameter(dynamicTriggerController0, "_dynamicTriggerController");
        super();
        this._dynamicTriggerController = dynamicTriggerController0;
        this.triggers = new ConcurrentHashMap();
        triggerModelStore0.subscribe(this);
    }

    private final void addTriggers(String s, Object object0) {
        synchronized(this.triggers) {
            this.triggers.put(s, object0);
        }
    }

    private final boolean evaluateAndTriggers(List list0) {
        for(Object object0: list0) {
            if(!this.evaluateTrigger(((Trigger)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // com.onesignal.inAppMessages.internal.triggers.ITriggerController
    public boolean evaluateMessageTriggers(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        if(inAppMessage0.getTriggers().isEmpty()) {
            return true;
        }
        for(Object object0: inAppMessage0.getTriggers()) {
            if(this.evaluateAndTriggers(((List)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private final boolean evaluateTrigger(Trigger trigger0) {
        if(trigger0.getKind() == OSTriggerKind.UNKNOWN) {
            return false;
        }
        if(trigger0.getKind() != OSTriggerKind.CUSTOM) {
            return this._dynamicTriggerController.dynamicTriggerShouldFire(trigger0);
        }
        OSTriggerOperator trigger$OSTriggerOperator0 = trigger0.getOperatorType();
        Object object0 = this.triggers.get(trigger0.getProperty());
        if(object0 == null) {
            return trigger$OSTriggerOperator0 == OSTriggerOperator.NOT_EXISTS ? true : trigger$OSTriggerOperator0 == OSTriggerOperator.NOT_EQUAL_TO && trigger0.getValue() != null;
        }
        if(trigger$OSTriggerOperator0 == OSTriggerOperator.EXISTS) {
            return true;
        }
        if(trigger$OSTriggerOperator0 == OSTriggerOperator.NOT_EXISTS) {
            return false;
        }
        if(trigger$OSTriggerOperator0 == OSTriggerOperator.CONTAINS) {
            return object0 instanceof Collection && ((Collection)object0).contains(trigger0.getValue());
        }
        if(object0 instanceof String && trigger0.getValue() instanceof String) {
            String s = (String)trigger0.getValue();
            Intrinsics.checkNotNull(s);
            if(this.triggerMatchesStringValue(s, ((String)object0), trigger$OSTriggerOperator0)) {
                return true;
            }
        }
        if(trigger0.getValue() instanceof Number && object0 instanceof Number) {
            Number number0 = (Number)trigger0.getValue();
            Intrinsics.checkNotNull(number0);
            return this.triggerMatchesNumericValue(number0, ((Number)object0), trigger$OSTriggerOperator0) ? true : this.triggerMatchesFlex(trigger0.getValue(), object0, trigger$OSTriggerOperator0);
        }
        return this.triggerMatchesFlex(trigger0.getValue(), object0, trigger$OSTriggerOperator0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this._dynamicTriggerController.getHasSubscribers();
    }

    public final ConcurrentHashMap getTriggers() {
        return this.triggers;
    }

    @Override  // com.onesignal.inAppMessages.internal.triggers.ITriggerController
    public boolean isTriggerOnMessage(InAppMessage inAppMessage0, Collection collection0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(collection0, "triggersKeys");
        if(inAppMessage0.getTriggers() == null) {
            return false;
        }
        for(Object object0: collection0) {
            String s = (String)object0;
            for(Object object1: inAppMessage0.getTriggers()) {
                for(Object object2: ((List)object1)) {
                    if(Intrinsics.areEqual(s, ((Trigger)object2).getProperty()) || Intrinsics.areEqual(s, ((Trigger)object2).getTriggerId())) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
                if(false) {
                    break;
                }
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // com.onesignal.inAppMessages.internal.triggers.ITriggerController
    public boolean messageHasOnlyDynamicTriggers(InAppMessage inAppMessage0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        if(inAppMessage0.getTriggers() != null && !inAppMessage0.getTriggers().isEmpty()) {
            for(Object object0: inAppMessage0.getTriggers()) {
                for(Object object1: ((List)object0)) {
                    if(((Trigger)object1).getKind() == OSTriggerKind.CUSTOM || ((Trigger)object1).getKind() == OSTriggerKind.UNKNOWN) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
                if(false) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(Model model0, String s) {
        this.onModelAdded(((TriggerModel)model0), s);
    }

    public void onModelAdded(TriggerModel triggerModel0, String s) {
        Intrinsics.checkNotNullParameter(triggerModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        this.addTriggers("", triggerModel0.getValue());
        this._dynamicTriggerController.getEvents().fire(new Function1() {
            final TriggerModel $model;

            {
                this.$model = triggerModel0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ITriggerHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ITriggerHandler iTriggerHandler0) {
                Intrinsics.checkNotNullParameter(iTriggerHandler0, "it");
                iTriggerHandler0.onTriggerChanged("");
            }
        });
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(Model model0, String s) {
        this.onModelRemoved(((TriggerModel)model0), s);
    }

    public void onModelRemoved(TriggerModel triggerModel0, String s) {
        Intrinsics.checkNotNullParameter(triggerModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        this.removeTriggersForKeys("");
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        Model model0 = modelChangedArgs0.getModel();
        Intrinsics.checkNotNull(model0, "null cannot be cast to non-null type com.onesignal.inAppMessages.internal.triggers.TriggerModel");
        this.addTriggers("", ((TriggerModel)model0).getValue());
        this._dynamicTriggerController.getEvents().fire(new Function1() {
            final TriggerModel $model;

            {
                this.$model = triggerModel0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ITriggerHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ITriggerHandler iTriggerHandler0) {
                Intrinsics.checkNotNullParameter(iTriggerHandler0, "it");
                iTriggerHandler0.onTriggerChanged("");
            }
        });
    }

    private final void removeTriggersForKeys(String s) {
        synchronized(this.triggers) {
            this.triggers.remove(s);
        }
    }

    public void subscribe(ITriggerHandler iTriggerHandler0) {
        Intrinsics.checkNotNullParameter(iTriggerHandler0, "handler");
        this._dynamicTriggerController.subscribe(iTriggerHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ITriggerHandler)object0));
    }

    // 去混淆评级： 低(20)
    private final boolean triggerMatchesFlex(Object object0, Object object1, OSTriggerOperator trigger$OSTriggerOperator0) {
        if(object0 == null) {
            return false;
        }
        return !(object1 instanceof String) || !(object0 instanceof Number) ? false : this.triggerMatchesNumericValueFlex(((Number)object0), ((String)object1), trigger$OSTriggerOperator0);
    }

    private final boolean triggerMatchesNumericValue(Number number0, Number number1, OSTriggerOperator trigger$OSTriggerOperator0) {
        double f = number0.doubleValue();
        double f1 = number1.doubleValue();
        switch(WhenMappings.$EnumSwitchMapping$0[trigger$OSTriggerOperator0.ordinal()]) {
            case 1: {
                return f1 == f;
            }
            case 2: {
                return f1 != f;
            }
            case 3: 
            case 4: 
            case 5: {
                Logging.error$default(("Attempted to use an invalid operator with a numeric value: " + trigger$OSTriggerOperator0), null, 2, null);
                return false;
            }
            case 6: {
                return f1 < f;
            }
            case 7: {
                return f1 > f;
            }
            case 8: {
                int v = Double.compare(f1, f);
                return v < 0 ? true : v == 0;
            }
            case 9: {
                return f1 > f ? true : f1 == f;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final boolean triggerMatchesNumericValueFlex(Number number0, String s, OSTriggerOperator trigger$OSTriggerOperator0) {
        try {
            return this.triggerMatchesNumericValue(number0.doubleValue(), Double.parseDouble(s), trigger$OSTriggerOperator0);
        }
        catch(NumberFormatException unused_ex) {
            return false;
        }
    }

    private final boolean triggerMatchesStringValue(String s, String s1, OSTriggerOperator trigger$OSTriggerOperator0) {
        switch(WhenMappings.$EnumSwitchMapping$0[trigger$OSTriggerOperator0.ordinal()]) {
            case 1: {
                return Intrinsics.areEqual(s, s1);
            }
            case 2: {
                return !Intrinsics.areEqual(s, s1);
            }
            default: {
                Logging.error$default(("Attempted to use an invalid operator for a string trigger comparison: " + trigger$OSTriggerOperator0), null, 2, null);
                return false;
            }
        }
    }

    public void unsubscribe(ITriggerHandler iTriggerHandler0) {
        Intrinsics.checkNotNullParameter(iTriggerHandler0, "handler");
        this._dynamicTriggerController.unsubscribe(iTriggerHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ITriggerHandler)object0));
    }
}

