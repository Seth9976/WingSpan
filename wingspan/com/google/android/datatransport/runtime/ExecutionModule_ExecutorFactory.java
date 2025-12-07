package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

public final class ExecutionModule_ExecutorFactory implements Factory {
    static final class InstanceHolder {
        private static final ExecutionModule_ExecutorFactory INSTANCE;

        static {
            InstanceHolder.INSTANCE = new ExecutionModule_ExecutorFactory();
        }
    }

    public static ExecutionModule_ExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Executor executor() {
        return (Executor)Preconditions.checkNotNull(ExecutionModule.executor(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public Executor get() {
        return ExecutionModule_ExecutorFactory.executor();
    }
}

