package com.onesignal.user.internal.identity;

import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.common.modeling.SingletonModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/onesignal/user/internal/identity/IdentityModelStore;", "Lcom/onesignal/common/modeling/SingletonModelStore;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class IdentityModelStore extends SingletonModelStore {
    public IdentityModelStore(IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "prefs");
        super(new SimpleModelStore(com.onesignal.user.internal.identity.IdentityModelStore.1.INSTANCE, "identity", iPreferencesService0));

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/onesignal/user/internal/identity/IdentityModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.user.internal.identity.IdentityModelStore.1 extends Lambda implements Function0 {
            public static final com.onesignal.user.internal.identity.IdentityModelStore.1 INSTANCE;

            static {
                com.onesignal.user.internal.identity.IdentityModelStore.1.INSTANCE = new com.onesignal.user.internal.identity.IdentityModelStore.1();
            }

            com.onesignal.user.internal.identity.IdentityModelStore.1() {
                super(0);
            }

            public final IdentityModel invoke() {
                return new IdentityModel();
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }
}

