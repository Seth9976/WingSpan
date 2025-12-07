package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

public final class SettableFuture extends AbstractFuture {
    public static SettableFuture create() {
        return new SettableFuture();
    }

    @Override  // androidx.work.impl.utils.futures.AbstractFuture
    public boolean set(Object value) {
        return super.set(value);
    }

    @Override  // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    @Override  // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setFuture(ListenableFuture future) {
        return super.setFuture(future);
    }
}

