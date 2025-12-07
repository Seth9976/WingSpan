package kotlinx.coroutines;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u00B6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\t\u0012\u0004\u0012\u00028\u00000\u008A\u00012\t\u0012\u0004\u0012\u00028\u00000\u008B\u00012\u00060tj\u0002`uB\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F\u00A2\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0012\u001A\u00020\u00112\'\u0010\u000E\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0018J\u001E\u0010\u001B\u001A\u00020\u00112\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\b\u00A2\u0006\u0004\b\u001B\u0010\u001CJ8\u0010\u001E\u001A\u00020\u00112!\u0010\u001D\u001A\u001D\u0012\u0013\u0012\u00110\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u001E\u0010\u0018J\u0019\u0010 \u001A\u00020\u001F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b \u0010!J!\u0010%\u001A\u00020\u00112\b\u0010\"\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0010\u00A2\u0006\u0004\b#\u0010$J\u0017\u0010&\u001A\u00020\u001F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b&\u0010!J\u0017\u0010(\u001A\u00020\u00112\u0006\u0010\'\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010,\u001A\u00020\u0011H\u0000\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b-\u0010+J\u0017\u0010/\u001A\u00020\u00112\u0006\u0010.\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b/\u00100J\u0017\u00103\u001A\u00020\u000F2\u0006\u00102\u001A\u000201H\u0016\u00A2\u0006\u0004\b3\u00104J\u001B\u00108\u001A\u0004\u0018\u00010\u000F2\b\u00105\u001A\u0004\u0018\u00010\bH\u0010\u00A2\u0006\u0004\b6\u00107J\u0011\u00109\u001A\u0004\u0018\u00010\bH\u0001\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010=\u001A\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016\u00A2\u0006\u0004\b=\u0010>J\u001F\u0010A\u001A\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u00105\u001A\u0004\u0018\u00010\bH\u0010\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010B\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bB\u0010+J\u0011\u0010D\u001A\u0004\u0018\u00010CH\u0002\u00A2\u0006\u0004\bD\u0010EJ8\u0010F\u001A\u00020\u00112\'\u0010\u000E\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0016\u00A2\u0006\u0004\bF\u0010GJ\u000F\u0010H\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\bH\u0010IJ8\u0010J\u001A\u00020\r2\'\u0010\u000E\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0002\u00A2\u0006\u0004\bJ\u0010KJB\u0010L\u001A\u00020\u00112\'\u0010\u000E\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u00105\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\bL\u0010MJ\u000F\u0010O\u001A\u00020NH\u0014\u00A2\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0000\u00A2\u0006\u0004\bQ\u0010RJ\u000F\u0010T\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\bT\u0010+J\u000F\u0010U\u001A\u00020\u001FH\u0001\u00A2\u0006\u0004\bU\u0010IJ<\u0010W\u001A\u00020\u00112\u0006\u0010V\u001A\u00028\u00002#\u0010\u001D\u001A\u001F\u0012\u0013\u0012\u00110\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\bW\u0010XJH\u0010Y\u001A\u00020\u00112\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u00042%\b\u0002\u0010\u001D\u001A\u001F\u0012\u0013\u0012\u00110\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\bY\u0010ZJ \u0010]\u001A\u00020\u00112\f\u0010\\\u001A\b\u0012\u0004\u0012\u00028\u00000[H\u0016\u00F8\u0001\u0000\u00A2\u0006\u0004\b]\u0010)JZ\u0010`\u001A\u0004\u0018\u00010\b2\u0006\u00105\u001A\u00020^2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u00042#\u0010\u001D\u001A\u001F\u0012\u0013\u0012\u00110\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\u0010_\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b`\u0010aJ\u0011\u0010c\u001A\u0004\u0018\u00010\bH\u0010\u00A2\u0006\u0004\bb\u0010:J\u000F\u0010d\u001A\u00020NH\u0016\u00A2\u0006\u0004\bd\u0010PJ\u000F\u0010e\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\be\u0010IJ#\u0010e\u001A\u0004\u0018\u00010\b2\u0006\u0010V\u001A\u00028\u00002\b\u0010_\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\be\u0010fJH\u0010e\u001A\u0004\u0018\u00010\b2\u0006\u0010V\u001A\u00028\u00002\b\u0010_\u001A\u0004\u0018\u00010\b2#\u0010\u001D\u001A\u001F\u0012\u0013\u0012\u00110\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\be\u0010gJJ\u0010i\u001A\u0004\u0018\u00010h2\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010_\u001A\u0004\u0018\u00010\b2#\u0010\u001D\u001A\u001F\u0012\u0013\u0012\u00110\u000F\u00A2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\bi\u0010jJ\u0019\u0010l\u001A\u0004\u0018\u00010\b2\u0006\u0010k\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\bl\u0010mJ\u000F\u0010n\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\bn\u0010IJ\u001B\u0010p\u001A\u00020\u0011*\u00020o2\u0006\u0010V\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\bp\u0010qJ\u001B\u0010r\u001A\u00020\u0011*\u00020o2\u0006\u0010k\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\br\u0010sR\u001C\u0010x\u001A\n\u0018\u00010tj\u0004\u0018\u0001`u8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bv\u0010wR\u001A\u0010z\u001A\u00020y8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\bz\u0010{\u001A\u0004\b|\u0010}R!\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0080\u0004\u00A2\u0006\r\n\u0004\b\u0003\u0010~\u001A\u0005\b\u007F\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001A\u00020\u001F8VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0081\u0001\u0010IR\u0016\u0010\u0082\u0001\u001A\u00020\u001F8VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0082\u0001\u0010IR\u0016\u0010\u0083\u0001\u001A\u00020\u001F8VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0083\u0001\u0010IR\u001B\u0010\u0084\u0001\u001A\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u00105\u001A\u0004\u0018\u00010\b8@X\u0080\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0086\u0001\u0010:R\u0016\u0010\u0088\u0001\u001A\u00020N8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0087\u0001\u0010P\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006\u0089\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class CancellableContinuationImpl extends DispatchedTask implements CoroutineStackFrame, CancellableContinuation {
    private volatile int _decision;
    private static final AtomicIntegerFieldUpdater _decision$FU;
    private volatile Object _state;
    private static final AtomicReferenceFieldUpdater _state$FU;
    private final CoroutineContext context;
    private final Continuation delegate;
    private DisposableHandle parentHandle;

    static {
        String s = UnityPlayerActivity.adjustValue("3114080207120E0A1C");
        CancellableContinuationImpl._decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, s);
        String s1 = UnityPlayerActivity.adjustValue("310319001A04");
        CancellableContinuationImpl._state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, s1);
    }

    public CancellableContinuationImpl(Continuation continuation0, int v) {
        super(v);
        this.delegate = continuation0;
        this.context = continuation0.getContext();
        this._decision = 0;
        this._state = Active.INSTANCE;
    }

    private final Void alreadyResumedError(Object object0) {
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B054B45101B044D111C0E170A010B144D1607150F45071E140C150B41") + object0).toString());
    }

    private final void callCancelHandler(Function1 function10, Throwable throwable0) {
        try {
            function10.invoke(throwable0);
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E190341070F110A190B3F03220F0F04001E02111908010F470D13001401041C41010A004E") + this, throwable1));
        }
    }

    public final void callCancelHandler(CancelHandler cancelHandler0, Throwable throwable0) {
        try {
            cancelHandler0.invoke(throwable0);
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E190341070F110A190B3F03220F0F04001E02111908010F470D13001401041C41010A004E") + this, throwable1));
        }
    }

    private final void callCancelHandlerSafely(Function0 function00) {
        try {
            function00.invoke();
        }
        catch(Throwable throwable0) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E190341070F110A190B3F03220F0F04001E02111908010F470D13001401041C41010A004E") + this, throwable0));
        }
    }

    public final void callOnCancellation(Function1 function10, Throwable throwable0) {
        try {
            function10.invoke(throwable0);
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException(UnityPlayerActivity.adjustValue("2B080E041E150E0A1C4E1903411C0414101F0B50020F2D00090617021C0C15070E09451A0F1E090D0B1347031D1C50") + this, throwable1));
        }
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(Throwable throwable0) {
        Object object0;
        do {
            object0 = this._state;
            if(!(object0 instanceof NotCompleted)) {
                return false;
            }
            CancelledContinuation cancelledContinuation0 = new CancelledContinuation(this, throwable0, object0 instanceof CancelHandler);
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object0, cancelledContinuation0));
        CancelHandler cancelHandler0 = object0 instanceof CancelHandler ? ((CancelHandler)object0) : null;
        if(cancelHandler0 != null) {
            this.callCancelHandler(cancelHandler0, throwable0);
        }
        this.detachChildIfNonResuable();
        this.dispatchResume(this.resumeMode);
        return true;
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object object0, Throwable throwable0) {
        Object object1;
    alab1:
        while(true) {
            do {
                object1 = this._state;
                if(object1 instanceof NotCompleted) {
                    break alab1;
                }
                if(object1 instanceof CompletedExceptionally) {
                    return;
                }
                if(!(object1 instanceof CompletedContinuation)) {
                    goto label_11;
                }
                if(!((CompletedContinuation)object1).getCancelled() == 0) {
                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("23051E154E030245110F1C01040A41061152031F1E154E0E090617").toString());
                }
                CompletedContinuation completedContinuation0 = CompletedContinuation.copy$default(((CompletedContinuation)object1), null, null, null, null, throwable0, 15, null);
            }
            while(!WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object1, completedContinuation0));
            ((CompletedContinuation)object1).invokeHandlers(this, throwable0);
            return;
        label_11:
            CompletedContinuation completedContinuation1 = new CompletedContinuation(object1, null, null, null, throwable0, 14, null);
            if(WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object1, completedContinuation1)) {
                return;
            }
        }
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("201F19410D0E0A151E0B040805").toString());
    }

    private final boolean cancelLater(Throwable throwable0) {
        return this.isReusable() ? ((DispatchedContinuation)this.delegate).postponeCancellation(throwable0) : false;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object object0) {
        this.dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle0 = this.parentHandle;
        if(disposableHandle0 == null) {
            return;
        }
        disposableHandle0.dispose();
        this.parentHandle = NonDisposableHandle.INSTANCE;
    }

    private final void detachChildIfNonResuable() {
        if(!this.isReusable()) {
            this.detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int v) {
        if(this.tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, v);
    }

    // 去混淆评级： 低(20)
    @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.delegate instanceof CoroutineStackFrame ? ((CoroutineStackFrame)this.delegate) : null;
    }

    @Override  // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    public Throwable getContinuationCancellationCause(Job job0) {
        return job0.getCancellationException();
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object object0) {
        Throwable throwable0 = super.getExceptionalResult$kotlinx_coroutines_core(object0);
        return throwable0 == null ? null : throwable0;
    }

    public final Object getResult() {
        boolean z = this.isReusable();
        if(this.trySuspend()) {
            if(this.parentHandle == null) {
                this.installParentHandle();
            }
            if(z) {
                this.releaseClaimedReusableContinuation();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if(z) {
            this.releaseClaimedReusableContinuation();
        }
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        if(DispatchedTaskKt.isCancellableMode(this.resumeMode)) {
            Job job0 = (Job)this.getContext().get(Job.Key);
            if(job0 != null && !job0.isActive()) {
                Throwable throwable0 = job0.getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(object0, throwable0);
                throw throwable0;
            }
        }
        return this.getSuccessfulResult$kotlinx_coroutines_core(object0);
    }

    @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    private final String getStateDebugRepresentation() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof NotCompleted) {
            return UnityPlayerActivity.adjustValue("2F1319081804");
        }
        return object0 instanceof CancelledContinuation ? UnityPlayerActivity.adjustValue("2D1103020B0D0B0016") : UnityPlayerActivity.adjustValue("2D1F00110204130016");
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.DispatchedTask
    public Object getSuccessfulResult$kotlinx_coroutines_core(Object object0) {
        return object0 instanceof CompletedContinuation ? ((CompletedContinuation)object0).result : object0;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        DisposableHandle disposableHandle0 = this.installParentHandle();
        if(disposableHandle0 == null) {
            return;
        }
        if(this.isCompleted()) {
            disposableHandle0.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    private final DisposableHandle installParentHandle() {
        Element coroutineContext$Element0 = this.getContext().get(Job.Key);
        if(((Job)coroutineContext$Element0) == null) {
            return null;
        }
        DisposableHandle disposableHandle0 = DefaultImpls.invokeOnCompletion$default(((Job)coroutineContext$Element0), true, false, new ChildContinuation(this), 2, null);
        this.parentHandle = disposableHandle0;
        return disposableHandle0;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1 function10) {
        Object object0;
        CancelHandler cancelHandler0 = this.makeCancelHandler(function10);
        while(true) {
            while(true) {
                while(true) {
                label_1:
                    object0 = this._state;
                    if(!(object0 instanceof Active)) {
                        break;
                    }
                    if(WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object0, cancelHandler0)) {
                        return;
                    }
                }
                if(object0 instanceof CancelHandler) {
                    this.multipleHandlersError(function10, object0);
                    goto label_1;
                }
                if(object0 instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally0 = (CompletedExceptionally)object0;
                    if(!completedExceptionally0.makeHandled()) {
                        this.multipleHandlersError(function10, object0);
                    }
                    Throwable throwable0 = null;
                    if(object0 instanceof CancelledContinuation) {
                        if(!(object0 instanceof CompletedExceptionally)) {
                            completedExceptionally0 = null;
                        }
                        if(completedExceptionally0 != null) {
                            throwable0 = completedExceptionally0.cause;
                        }
                        this.callCancelHandler(function10, throwable0);
                    }
                    return;
                }
                if(!(object0 instanceof CompletedContinuation)) {
                    break;
                }
                if(((CompletedContinuation)object0).cancelHandler != null) {
                    this.multipleHandlersError(function10, object0);
                }
                if(cancelHandler0 instanceof BeforeResumeCancelHandler) {
                    return;
                }
                if(((CompletedContinuation)object0).getCancelled()) {
                    this.callCancelHandler(function10, ((CompletedContinuation)object0).cancelCause);
                    return;
                }
                CompletedContinuation completedContinuation0 = CompletedContinuation.copy$default(((CompletedContinuation)object0), null, cancelHandler0, null, null, null, 29, null);
                if(WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object0, completedContinuation0)) {
                    return;
                }
            }
            if(cancelHandler0 instanceof BeforeResumeCancelHandler) {
                return;
            }
            CompletedContinuation completedContinuation1 = new CompletedContinuation(object0, cancelHandler0, null, null, null, 28, null);
            if(!WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object0, completedContinuation1)) {
                goto label_1;
            }
            break;
        }
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return this.getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    // 去混淆评级： 低(20)
    private final boolean isReusable() {
        return DispatchedTaskKt.isReusableMode(this.resumeMode) && ((DispatchedContinuation)this.delegate).isReusable();
    }

    private final CancelHandler makeCancelHandler(Function1 function10) {
        return function10 instanceof CancelHandler ? ((CancelHandler)function10) : new InvokeOnCancel(function10);
    }

    private final void multipleHandlersError(Function1 function10, Object object0) {
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("27044A124E11150A1A071204150B0547111D4E02080607121300004E1D180D1A081709174E180C0F0A0D02170142501913070403450601501F0409081411171C50") + function10 + UnityPlayerActivity.adjustValue("42500C0D1C0406010B4E180C124E") + object0).toString());
    }

    protected String nameString() {
        return UnityPlayerActivity.adjustValue("2D1103020B0D0B041002152E0E00150E0B070F04040E00");
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable throwable0) {
        if(this.cancelLater(throwable0)) {
            return;
        }
        this.cancel(throwable0);
        this.detachChildIfNonResuable();
    }

    private final void releaseClaimedReusableContinuation() {
        DispatchedContinuation dispatchedContinuation0 = this.delegate instanceof DispatchedContinuation ? ((DispatchedContinuation)this.delegate) : null;
        if(dispatchedContinuation0 != null) {
            Throwable throwable0 = dispatchedContinuation0.tryReleaseClaimedContinuation(this);
            if(throwable0 != null) {
                this.detachChild$kotlinx_coroutines_core();
                this.cancel(throwable0);
            }
        }
    }

    public final boolean resetStateReusable() {
        if(this._state instanceof CompletedContinuation && ((CompletedContinuation)this._state).idempotentResume != null) {
            this.detachChild$kotlinx_coroutines_core();
            return false;
        }
        this._decision = 0;
        this._state = Active.INSTANCE;
        return true;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void resume(Object object0, Function1 function10) {
        this.resumeImpl(object0, this.resumeMode, function10);
    }

    private final void resumeImpl(Object object0, int v, Function1 function10) {
        Object object1;
        while(true) {
            object1 = this._state;
            if(!(object1 instanceof NotCompleted)) {
                break;
            }
            Object object2 = this.resumedState(((NotCompleted)object1), object0, v, function10, null);
            if(WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object1, object2)) {
                this.detachChildIfNonResuable();
                this.dispatchResume(v);
                return;
            }
        }
        if(object1 instanceof CancelledContinuation && ((CancelledContinuation)object1).makeResumed()) {
            if(function10 != null) {
                this.callOnCancellation(function10, ((CancelledContinuation)object1).cause);
            }
            return;
        }
        this.alreadyResumedError(object0);
        throw new KotlinNothingValueException();
    }

    static void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl0, Object object0, int v, Function1 function10, int v1, Object object1) {
        if(object1 != null) {
            throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D130B12120817271D1D0D"));
        }
        if((v1 & 4) != 0) {
            function10 = null;
        }
        cancellableContinuationImpl0.resumeImpl(object0, v, function10);
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher0, Object object0) {
        CoroutineDispatcher coroutineDispatcher1 = null;
        DispatchedContinuation dispatchedContinuation0 = this.delegate instanceof DispatchedContinuation ? ((DispatchedContinuation)this.delegate) : null;
        if(dispatchedContinuation0 != null) {
            coroutineDispatcher1 = dispatchedContinuation0.dispatcher;
        }
        CancellableContinuationImpl.resumeImpl$default(this, object0, (coroutineDispatcher1 == coroutineDispatcher0 ? 4 : this.resumeMode), null, 4, null);
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(CoroutineDispatcher coroutineDispatcher0, Throwable throwable0) {
        CoroutineDispatcher coroutineDispatcher1 = null;
        DispatchedContinuation dispatchedContinuation0 = this.delegate instanceof DispatchedContinuation ? ((DispatchedContinuation)this.delegate) : null;
        CompletedExceptionally completedExceptionally0 = new CompletedExceptionally(throwable0, false, 2, null);
        if(dispatchedContinuation0 != null) {
            coroutineDispatcher1 = dispatchedContinuation0.dispatcher;
        }
        CancellableContinuationImpl.resumeImpl$default(this, completedExceptionally0, (coroutineDispatcher1 == coroutineDispatcher0 ? 4 : this.resumeMode), null, 4, null);
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(Object object0) {
        CancellableContinuationImpl.resumeImpl$default(this, CompletionStateKt.toState(object0, this), this.resumeMode, null, 4, null);
    }

    // 去混淆评级： 低(40)
    private final Object resumedState(NotCompleted notCompleted0, Object object0, int v, Function1 function10, Object object1) {
        if(!(object0 instanceof CompletedExceptionally) && ((DispatchedTaskKt.isCancellableMode(v) || object1 != null) && (function10 != null || notCompleted0 instanceof CancelHandler && !(notCompleted0 instanceof BeforeResumeCancelHandler) || object1 != null))) {
            return notCompleted0 instanceof CancelHandler ? new CompletedContinuation(object0, ((CancelHandler)notCompleted0), function10, object1, null, 16, null) : new CompletedContinuation(object0, null, function10, object1, null, 16, null);
        }
        return object0;
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return this.getState$kotlinx_coroutines_core();
    }

    @Override
    public String toString() {
        return this.nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + UnityPlayerActivity.adjustValue("470B") + this.getStateDebugRepresentation() + UnityPlayerActivity.adjustValue("1330") + DebugStringsKt.getHexAddress(this);
    }

    private final boolean tryResume() {
    alab1:
        while(true) {
            switch(this._decision) {
                case 0: {
                    if(!CancellableContinuationImpl._decision$FU.compareAndSet(this, 0, 2)) {
                        break;
                    }
                    break alab1;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45000B03180C0B05").toString());
                }
            }
        }
        return true;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(Object object0, Object object1) {
        return this.tryResumeImpl(object0, object1, null);
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(Object object0, Object object1, Function1 function10) {
        return this.tryResumeImpl(object0, object1, function10);
    }

    private final Symbol tryResumeImpl(Object object0, Object object1, Function1 function10) {
        while(true) {
            Object object2 = this._state;
            if(!(object2 instanceof NotCompleted)) {
                break;
            }
            Object object3 = this.resumedState(((NotCompleted)object2), object0, this.resumeMode, function10, object1);
            if(WorkSpec..ExternalSyntheticBackport0.m(CancellableContinuationImpl._state$FU, this, object2, object3)) {
                this.detachChildIfNonResuable();
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
        }
        if(object2 instanceof CompletedContinuation && object1 != null && ((CompletedContinuation)object2).idempotentResume == object1) {
            if(DebugKt.getASSERTIONS_ENABLED() && !Intrinsics.areEqual(((CompletedContinuation)object2).result, object0)) {
                throw new AssertionError();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
        return null;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public Object tryResumeWithException(Throwable throwable0) {
        return this.tryResumeImpl(new CompletedExceptionally(throwable0, false, 2, null), null, null);
    }

    private final boolean trySuspend() {
    alab1:
        while(true) {
            switch(this._decision) {
                case 0: {
                    if(!CancellableContinuationImpl._decision$FU.compareAndSet(this, 0, 1)) {
                        break;
                    }
                    break alab1;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("2F1C1F040F051E45011B031D0400050201").toString());
                }
            }
        }
        return true;
    }
}

