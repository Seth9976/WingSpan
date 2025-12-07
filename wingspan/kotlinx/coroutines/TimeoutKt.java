package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A_\u0010\u0006\u001A\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u0002H\b2\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\n2\'\u0010\u000B\u001A#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00A2\u0006\u0002\b\u000FH\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0010\u001AU\u0010\u0011\u001A\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001A\u00020\u00032\'\u0010\u000B\u001A#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00A2\u0006\u0002\b\u000FH\u0086@\u00F8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00A2\u0006\u0002\u0010\u0013\u001A]\u0010\u0011\u001A\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001A\u00020\u00152\'\u0010\u000B\u001A#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00A2\u0006\u0002\b\u000FH\u0086@\u00F8\u0001\u0000\u00F8\u0001\u0000\u00F8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00A2\u0006\u0004\b\u0016\u0010\u0013\u001AJ\u0010\u0017\u001A\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001A\u00020\u00032\'\u0010\u000B\u001A#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00A2\u0006\u0002\b\u000FH\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0013\u001AR\u0010\u0017\u001A\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001A\u00020\u00152\'\u0010\u000B\u001A#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00A2\u0006\u0002\b\u000FH\u0086@\u00F8\u0001\u0000\u00F8\u0001\u0000\u00F8\u0001\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0013\u0082\u0002\u000B\n\u0002\b\u0019\n\u0005\b\u00A1\u001E0\u0001\u00A8\u0006\u0019"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class TimeoutKt {
    public static final TimeoutCancellationException TimeoutCancellationException(long v, Job job0) {
        return new TimeoutCancellationException(UnityPlayerActivity.adjustValue("3A1900040A410810064E070C081A08090252081F1F41") + v + UnityPlayerActivity.adjustValue("4E1D1E"), job0);
    }

    private static final Object setupTimeout(TimeoutCoroutine timeoutCoroutine0, Function2 function20) {
        Delay delay0 = DelayKt.getDelay(timeoutCoroutine0.uCont.getContext());
        CoroutineContext coroutineContext0 = timeoutCoroutine0.getContext();
        JobKt.disposeOnCompletion(timeoutCoroutine0, delay0.invokeOnTimeout(timeoutCoroutine0.time, timeoutCoroutine0, coroutineContext0));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine0, timeoutCoroutine0, function20);
    }

    public static final Object withTimeout(long v, Function2 function20, Continuation continuation0) {
        if(v <= 0L) {
            throw new TimeoutCancellationException(UnityPlayerActivity.adjustValue("3A1900040A410810064E19000C0B050E04060B1C14"));
        }
        Object object0 = TimeoutKt.setupTimeout(new TimeoutCoroutine(v, continuation0), function20);
        if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object0;
    }

    public static final Object withTimeout-KLykuaI(long v, Function2 function20, Continuation continuation0) {
        return TimeoutKt.withTimeout(DelayKt.toDelayMillis-LRDsOJo(v), function20, continuation0);
    }

    public static final Object withTimeoutOrNull(long v, Function2 function20, Continuation continuation0) {
        ObjectRef ref$ObjectRef1;
        kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1 timeoutKt$withTimeoutOrNull$10;
        if(continuation0 instanceof kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1) {
            timeoutKt$withTimeoutOrNull$10 = (kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1)continuation0;
            if((timeoutKt$withTimeoutOrNull$10.label & 0x80000000) == 0) {
                timeoutKt$withTimeoutOrNull$10 = new ContinuationImpl(continuation0) {
                    long J$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return TimeoutKt.withTimeoutOrNull(0L, null, this);
                    }
                };
            }
            else {
                timeoutKt$withTimeoutOrNull$10.label ^= 0x80000000;
            }
        }
        else {
            timeoutKt$withTimeoutOrNull$10 = new ContinuationImpl(continuation0) {
                long J$0;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return TimeoutKt.withTimeoutOrNull(0L, null, this);
                }
            };
        }
        Object object0 = timeoutKt$withTimeoutOrNull$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(timeoutKt$withTimeoutOrNull$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(v <= 0L) {
                    return null;
                }
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                try {
                    timeoutKt$withTimeoutOrNull$10.L$0 = function20;
                    timeoutKt$withTimeoutOrNull$10.L$1 = ref$ObjectRef0;
                    timeoutKt$withTimeoutOrNull$10.J$0 = v;
                    timeoutKt$withTimeoutOrNull$10.label = 1;
                    TimeoutCoroutine timeoutCoroutine0 = new TimeoutCoroutine(v, timeoutKt$withTimeoutOrNull$10);
                    ref$ObjectRef0.element = timeoutCoroutine0;
                    Object object2 = TimeoutKt.setupTimeout(timeoutCoroutine0, function20);
                    if(object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(timeoutKt$withTimeoutOrNull$10);
                    }
                    return object2 == object1 ? object1 : object2;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    ref$ObjectRef1 = ref$ObjectRef0;
                    goto label_34;
                }
            }
            case 1: {
                ref$ObjectRef1 = (ObjectRef)timeoutKt$withTimeoutOrNull$10.L$1;
                Function2 function21 = (Function2)timeoutKt$withTimeoutOrNull$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return object0;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                }
            label_34:
                if(timeoutCancellationException0.coroutine != ref$ObjectRef1.element) {
                    throw timeoutCancellationException0;
                }
                return null;
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
            }
        }
    }

    public static final Object withTimeoutOrNull-KLykuaI(long v, Function2 function20, Continuation continuation0) {
        return TimeoutKt.withTimeoutOrNull(DelayKt.toDelayMillis-LRDsOJo(v), function20, continuation0);
    }
}

