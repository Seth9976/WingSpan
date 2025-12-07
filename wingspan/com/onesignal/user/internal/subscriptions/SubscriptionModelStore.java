package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001E\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\f"}, d2 = {"Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "Lcom/onesignal/common/modeling/SimpleModelStore;", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "replaceAll", "", "models", "", "tag", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class SubscriptionModelStore extends SimpleModelStore {
    public SubscriptionModelStore(IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "prefs");
        super(com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1.INSTANCE, "subscriptions", iPreferencesService0);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1 extends Lambda implements Function0 {
            public static final com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1 INSTANCE;

            static {
                com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1.INSTANCE = new com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1();
            }

            com.onesignal.user.internal.subscriptions.SubscriptionModelStore.1() {
                super(0);
            }

            public final SubscriptionModel invoke() {
                return new SubscriptionModel();
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    @Override  // com.onesignal.common.modeling.ModelStore
    public void replaceAll(List list0, String s) {
        Intrinsics.checkNotNullParameter(list0, "models");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "HYDRATE")) {
            super.replaceAll(list0, s);
            return;
        }
        synchronized(list0) {
            for(Object object0: list0) {
                SubscriptionModel subscriptionModel0 = (SubscriptionModel)object0;
                if(subscriptionModel0.getType() == SubscriptionType.PUSH) {
                    SubscriptionModel subscriptionModel1 = (SubscriptionModel)this.get(subscriptionModel0.getId());
                    if(subscriptionModel1 == null) {
                        break;
                    }
                    subscriptionModel0.setSdk("");
                    subscriptionModel0.setDeviceOS("");
                    subscriptionModel0.setCarrier("");
                    subscriptionModel0.setAppVersion("");
                    subscriptionModel0.setStatus(subscriptionModel1.getStatus());
                    break;
                }
                if(false) {
                    break;
                }
            }
            super.replaceAll(list0, s);
        }
    }
}

