package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

public final class EventStoreModule_DbNameFactory implements Factory {
    static final class InstanceHolder {
        private static final EventStoreModule_DbNameFactory INSTANCE;

        static {
            InstanceHolder.INSTANCE = new EventStoreModule_DbNameFactory();
        }
    }

    public static EventStoreModule_DbNameFactory create() {
        return InstanceHolder.INSTANCE;
    }

    // 去混淆评级： 低(20)
    public static String dbName() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @Override  // javax.inject.Provider
    public Object get() {
        return "com.google.android.datatransport.events";
    }

    // 去混淆评级： 低(20)
    public String get() [...] // 潜在的解密器
}

