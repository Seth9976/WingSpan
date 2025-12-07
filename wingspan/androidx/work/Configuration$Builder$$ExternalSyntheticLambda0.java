package androidx.work;

import androidx.core.util.Consumer;

public final class Configuration.Builder..ExternalSyntheticLambda0 implements Consumer {
    public final InitializationExceptionHandler f$0;

    public Configuration.Builder..ExternalSyntheticLambda0(InitializationExceptionHandler initializationExceptionHandler0) {
        this.f$0 = initializationExceptionHandler0;
    }

    @Override  // androidx.core.util.Consumer
    public final void accept(Object object0) {
        this.f$0.handleException(((Throwable)object0));
    }
}

