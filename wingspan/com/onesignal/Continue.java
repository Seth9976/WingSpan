package com.onesignal;

import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005H\u0007J2\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t0\b2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¨\u0006\f"}, d2 = {"Lcom/onesignal/Continue;", "", "()V", "none", "Lkotlin/coroutines/Continuation;", "R", "with", "onFinished", "Ljava/util/function/Consumer;", "Lcom/onesignal/ContinueResult;", "context", "Lkotlin/coroutines/CoroutineContext;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Continue {
    public static final Continue INSTANCE;

    static {
        Continue.INSTANCE = new Continue();
    }

    @JvmStatic
    public static final Continuation none() {
        return new Continuation() {
            @Override  // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return Dispatchers.getMain();
            }

            @Override  // kotlin.coroutines.Continuation
            public void resumeWith(Object object0) {
            }
        };
    }

    @JvmStatic
    public static final Continuation with(Consumer consumer0) {
        Intrinsics.checkNotNullParameter(consumer0, "onFinished");
        return Continue.with$default(consumer0, null, 2, null);
    }

    @JvmStatic
    public static final Continuation with(Consumer consumer0, CoroutineContext coroutineContext0) {
        Intrinsics.checkNotNullParameter(consumer0, "onFinished");
        Intrinsics.checkNotNullParameter(coroutineContext0, "context");
        return new Continuation() {
            @Override  // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return coroutineContext0;
            }

            @Override  // kotlin.coroutines.Continuation
            public void resumeWith(Object object0) {
                ContinueResult continueResult0 = new ContinueResult(Result.isSuccess-impl(object0), (Result.isFailure-impl(object0) ? null : object0), Result.exceptionOrNull-impl(object0));
                consumer0.accept(continueResult0);
            }
        };
    }

    public static Continuation with$default(Consumer consumer0, CoroutineContext coroutineContext0, int v, Object object0) {
        if((v & 2) != 0) {
            coroutineContext0 = Dispatchers.getMain();
        }
        return Continue.with(consumer0, coroutineContext0);
    }
}

