package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.modeling.SimpleModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "Lcom/onesignal/common/modeling/SimpleModelStore;", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "()V", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class TriggerModelStore extends SimpleModelStore {
    public TriggerModelStore() {
        super(com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1.INSTANCE, null, null, 6, null);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1 extends Lambda implements Function0 {
            public static final com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1 INSTANCE;

            static {
                com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1.INSTANCE = new com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1();
            }

            com.onesignal.inAppMessages.internal.triggers.TriggerModelStore.1() {
                super(0);
            }

            public final TriggerModel invoke() {
                return new TriggerModel();
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }
}

