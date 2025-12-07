package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;

public final class HandlerContext..ExternalSyntheticLambda0 implements DisposableHandle {
    public final HandlerContext f$0;
    public final Runnable f$1;

    public HandlerContext..ExternalSyntheticLambda0(HandlerContext handlerContext0, Runnable runnable0) {
        this.f$0 = handlerContext0;
        this.f$1 = runnable0;
    }

    @Override  // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        HandlerContext.$r8$lambda$-TOZof2GYGCn1P43qXNY1O5Gvm8(this.f$0, this.f$1);
    }
}

