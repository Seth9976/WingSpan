package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001A\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class CoroutineExceptionHandlerImplKt {
    private static final List handlers;

    static {
        CoroutineExceptionHandlerImplKt.handlers = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    }

    public static final void handleCoroutineExceptionImpl(CoroutineContext coroutineContext0, Throwable throwable0) {
        Thread thread1;
        for(Object object0: CoroutineExceptionHandlerImplKt.handlers) {
            CoroutineExceptionHandler coroutineExceptionHandler0 = (CoroutineExceptionHandler)object0;
            try {
                coroutineExceptionHandler0.handleException(coroutineContext0, throwable0);
            }
            catch(Throwable throwable1) {
                Thread thread0 = Thread.currentThread();
                thread0.getUncaughtExceptionHandler().uncaughtException(thread0, CoroutineExceptionHandlerKt.handlerException(throwable0, throwable1));
            }
        }
        try {
            thread1 = Thread.currentThread();
            ExceptionsKt.addSuppressed(throwable0, new DiagnosticCoroutineContextException(coroutineContext0));
        }
        catch(Throwable throwable2) {
            ResultKt.createFailure(throwable2);
        }
        thread1.getUncaughtExceptionHandler().uncaughtException(thread1, throwable0);
    }
}

