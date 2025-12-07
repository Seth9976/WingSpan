package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_UptimeClockFactory implements Factory {
    static final class InstanceHolder {
        private static final TimeModule_UptimeClockFactory INSTANCE;

        static {
            InstanceHolder.INSTANCE = new TimeModule_UptimeClockFactory();
        }
    }

    public static TimeModule_UptimeClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public Clock get() {
        return TimeModule_UptimeClockFactory.uptimeClock();
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static Clock uptimeClock() {
        return (Clock)Preconditions.checkNotNull(TimeModule.uptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

