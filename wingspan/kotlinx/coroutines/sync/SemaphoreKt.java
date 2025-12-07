package kotlinx.coroutines.sync;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00072\b\b\u0002\u0010\u0012\u001A\u00020\u0007\u001A\u001A\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0014H\u0002\u001A6\u0010\u0018\u001A\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\u00020\u00102\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00190\u001BH\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001C\"\u0016\u0010\u0000\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000B\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000E\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001D"}, d2 = {"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "getBROKEN$annotations", "()V", "CANCELLED", "getCANCELLED$annotations", "MAX_SPIN_CYCLES", "", "getMAX_SPIN_CYCLES$annotations", "PERMIT", "getPERMIT$annotations", "SEGMENT_SIZE", "getSEGMENT_SIZE$annotations", "TAKEN", "getTAKEN$annotations", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class SemaphoreKt {
    private static final Symbol BROKEN;
    private static final Symbol CANCELLED;
    private static final int MAX_SPIN_CYCLES;
    private static final Symbol PERMIT;
    private static final int SEGMENT_SIZE;
    private static final Symbol TAKEN;

    static {
        SemaphoreKt.MAX_SPIN_CYCLES = SystemPropsKt__SystemProps_commonKt.systemProp$default(UnityPlayerActivity.adjustValue("051F190D070F1F4B11010202141A080900014003080C0F110F0A000B5E00001632170C1C2D090E0D0B12"), 100, 0, 0, 12, null);
        SemaphoreKt.PERMIT = new Symbol(UnityPlayerActivity.adjustValue("3E353F2C2735"));
        SemaphoreKt.TAKEN = new Symbol(UnityPlayerActivity.adjustValue("3A31262420"));
        SemaphoreKt.BROKEN = new Symbol(UnityPlayerActivity.adjustValue("2C22222A2B2F"));
        SemaphoreKt.CANCELLED = new Symbol(UnityPlayerActivity.adjustValue("2D3123222B2D2B2036"));
        SemaphoreKt.SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default(UnityPlayerActivity.adjustValue("051F190D070F1F4B11010202141A080900014003080C0F110F0A000B5E1E04090C020B063D191704"), 16, 0, 0, 12, null);
    }

    public static final Semaphore Semaphore(int v, int v1) {
        return new SemaphoreImpl(v, v1);
    }

    public static Semaphore Semaphore$default(int v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v1 = 0;
        }
        return SemaphoreKt.Semaphore(v, v1);
    }

    public static final Symbol access$getBROKEN$p() {
        return SemaphoreKt.BROKEN;
    }

    public static final int access$getMAX_SPIN_CYCLES$p() [...] // 潜在的解密器

    public static final Symbol access$getPERMIT$p() {
        return SemaphoreKt.PERMIT;
    }

    public static final Symbol access$getTAKEN$p() {
        return SemaphoreKt.TAKEN;
    }

    private static final SemaphoreSegment createSegment(long v, SemaphoreSegment semaphoreSegment0) {
        return new SemaphoreSegment(v, semaphoreSegment0, 0);
    }

    private static void getBROKEN$annotations() {
    }

    private static void getCANCELLED$annotations() {
    }

    private static void getMAX_SPIN_CYCLES$annotations() {
    }

    private static void getPERMIT$annotations() {
    }

    private static void getSEGMENT_SIZE$annotations() {
    }

    private static void getTAKEN$annotations() {
    }

    public static final Object withPermit(Semaphore semaphore0, Function0 function00, Continuation continuation0) {
        kotlinx.coroutines.sync.SemaphoreKt.withPermit.1 semaphoreKt$withPermit$10;
        if(continuation0 instanceof kotlinx.coroutines.sync.SemaphoreKt.withPermit.1) {
            semaphoreKt$withPermit$10 = (kotlinx.coroutines.sync.SemaphoreKt.withPermit.1)continuation0;
            if((semaphoreKt$withPermit$10.label & 0x80000000) == 0) {
                semaphoreKt$withPermit$10 = new ContinuationImpl(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return SemaphoreKt.withPermit(null, null, this);
                    }
                };
            }
            else {
                semaphoreKt$withPermit$10.label ^= 0x80000000;
            }
        }
        else {
            semaphoreKt$withPermit$10 = new ContinuationImpl(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return SemaphoreKt.withPermit(null, null, this);
                }
            };
        }
        Object object0 = semaphoreKt$withPermit$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(semaphoreKt$withPermit$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                semaphoreKt$withPermit$10.L$0 = semaphore0;
                semaphoreKt$withPermit$10.L$1 = function00;
                semaphoreKt$withPermit$10.label = 1;
                if(semaphore0.acquire(semaphoreKt$withPermit$10) == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                function00 = (Function0)semaphoreKt$withPermit$10.L$1;
                semaphore0 = (Semaphore)semaphoreKt$withPermit$10.L$0;
                ResultKt.throwOnFailure(object0);
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
            semaphore0.release();
        }
    }

    private static final Object withPermit$$forInline(Semaphore semaphore0, Function0 function00, Continuation continuation0) {
        semaphore0.acquire(continuation0);
        try {
            return function00.invoke();
        }
        finally {
            semaphore0.release();
        }
    }
}

