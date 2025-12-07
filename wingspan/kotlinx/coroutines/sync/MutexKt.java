package kotlinx.coroutines.sync;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0010\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u001AB\u0010\u0013\u001A\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0018H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0000\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000B\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000E\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001A"}, d2 = {"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "getEMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "getEMPTY_UNLOCKED$annotations", "LOCKED", "Lkotlinx/coroutines/internal/Symbol;", "getLOCKED$annotations", "LOCK_FAIL", "getLOCK_FAIL$annotations", "UNLOCKED", "getUNLOCKED$annotations", "UNLOCK_FAIL", "getUNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class MutexKt {
    private static final Empty EMPTY_LOCKED;
    private static final Empty EMPTY_UNLOCKED;
    private static final Symbol LOCKED;
    private static final Symbol LOCK_FAIL;
    private static final Symbol UNLOCKED;
    private static final Symbol UNLOCK_FAIL;

    static {
        MutexKt.LOCK_FAIL = new Symbol(UnityPlayerActivity.adjustValue("223F2E2A3127262C3E"));
        MutexKt.UNLOCK_FAIL = new Symbol(UnityPlayerActivity.adjustValue("3B3E212E2D2A382333273C"));
        Symbol symbol0 = new Symbol(UnityPlayerActivity.adjustValue("223F2E2A2B25"));
        MutexKt.LOCKED = symbol0;
        Symbol symbol1 = new Symbol(UnityPlayerActivity.adjustValue("3B3E212E2D2A2221"));
        MutexKt.UNLOCKED = symbol1;
        MutexKt.EMPTY_LOCKED = new Empty(symbol0);
        MutexKt.EMPTY_UNLOCKED = new Empty(symbol1);
    }

    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    public static Mutex Mutex$default(boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        return MutexKt.Mutex(z);
    }

    private static void getEMPTY_LOCKED$annotations() {
    }

    private static void getEMPTY_UNLOCKED$annotations() {
    }

    private static void getLOCKED$annotations() {
    }

    private static void getLOCK_FAIL$annotations() {
    }

    private static void getUNLOCKED$annotations() {
    }

    private static void getUNLOCK_FAIL$annotations() {
    }

    public static final Object withLock(Mutex mutex0, Object object0, Function0 function00, Continuation continuation0) {
        kotlinx.coroutines.sync.MutexKt.withLock.1 mutexKt$withLock$10;
        if(continuation0 instanceof kotlinx.coroutines.sync.MutexKt.withLock.1) {
            mutexKt$withLock$10 = (kotlinx.coroutines.sync.MutexKt.withLock.1)continuation0;
            if((mutexKt$withLock$10.label & 0x80000000) == 0) {
                mutexKt$withLock$10 = new ContinuationImpl(continuation0) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MutexKt.withLock(null, null, null, this);
                    }
                };
            }
            else {
                mutexKt$withLock$10.label ^= 0x80000000;
            }
        }
        else {
            mutexKt$withLock$10 = new ContinuationImpl(continuation0) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MutexKt.withLock(null, null, null, this);
                }
            };
        }
        Object object1 = mutexKt$withLock$10.result;
        Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(mutexKt$withLock$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object1);
                mutexKt$withLock$10.L$0 = mutex0;
                mutexKt$withLock$10.L$1 = object0;
                mutexKt$withLock$10.L$2 = function00;
                mutexKt$withLock$10.label = 1;
                if(mutex0.lock(object0, mutexKt$withLock$10) == object2) {
                    return object2;
                }
                break;
            }
            case 1: {
                function00 = (Function0)mutexKt$withLock$10.L$2;
                object0 = mutexKt$withLock$10.L$1;
                mutex0 = (Mutex)mutexKt$withLock$10.L$0;
                ResultKt.throwOnFailure(object1);
                break;
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
            }
        }
        try {
            return function00.invoke();
        }
        finally {
            mutex0.unlock(object0);
        }
    }

    private static final Object withLock$$forInline(Mutex mutex0, Object object0, Function0 function00, Continuation continuation0) {
        mutex0.lock(object0, continuation0);
        try {
            return function00.invoke();
        }
        finally {
            mutex0.unlock(object0);
        }
    }

    public static Object withLock$default(Mutex mutex0, Object object0, Function0 function00, Continuation continuation0, int v, Object object1) {
        if((v & 1) != 0) {
            object0 = null;
        }
        mutex0.lock(object0, continuation0);
        try {
            return function00.invoke();
        }
        finally {
            mutex0.unlock(object0);
        }
    }
}

