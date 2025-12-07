package androidx.browser.trusted;

import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

class FutureUtils {
    static ListenableFuture immediateFailedFuture(Throwable cause) {
        ListenableFuture listenableFuture0 = ResolvableFuture.create();
        ((ResolvableFuture)listenableFuture0).setException(cause);
        return listenableFuture0;
    }
}

