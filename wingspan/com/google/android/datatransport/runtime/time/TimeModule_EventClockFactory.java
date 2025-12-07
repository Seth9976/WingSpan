package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

public final class TimeModule_EventClockFactory implements Factory {
    static final class InstanceHolder {
        private static final TimeModule_EventClockFactory INSTANCE;

        static {
            InstanceHolder.INSTANCE = new TimeModule_EventClockFactory();
        }
    }

    public static TimeModule_EventClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Clock eventClock() {
        return (Clock)Preconditions.checkNotNull(TimeModule.eventClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Clock get() {
        return TimeModule_EventClockFactory.eventClock();
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }
}

