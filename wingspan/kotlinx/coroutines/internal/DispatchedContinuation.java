package kotlinx.coroutines.internal;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000O2\u00060?j\u0002`@2\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\t\u0010\nJ!\u0010\u0011\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0010\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u001A\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00028\u0000H\u0000\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001D\u001A\n\u0018\u00010\u001Bj\u0004\u0018\u0001`\u001CH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\r\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b \u0010!J\u0015\u0010\"\u001A\u00020\u001F2\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\b\u00A2\u0006\u0004\b$\u0010\nJH\u0010+\u001A\u00020\b2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000%2%\b\b\u0010*\u001A\u001F\u0012\u0013\u0012\u00110\r\u00A2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\b\u0018\u00010\'H\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b+\u0010,J\u001A\u0010.\u001A\u00020\u001F2\b\u0010-\u001A\u0004\u0018\u00010\u000BH\u0086\b\u00A2\u0006\u0004\b.\u0010/J!\u00100\u001A\u00020\b2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b0\u00101J \u00102\u001A\u00020\b2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0016\u00F8\u0001\u0000\u00A2\u0006\u0004\b2\u00101J\u0011\u00105\u001A\u0004\u0018\u00010\u000BH\u0010\u00A2\u0006\u0004\b3\u00104J\u000F\u00107\u001A\u000206H\u0016\u00A2\u0006\u0004\b7\u00108J\u001B\u0010:\u001A\u0004\u0018\u00010\r2\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u000309\u00A2\u0006\u0004\b:\u0010;R\u001E\u0010<\u001A\u0004\u0018\u00010\u000B8\u0000@\u0000X\u0081\u000E\u00A2\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010\nR\u001C\u0010C\u001A\n\u0018\u00010?j\u0004\u0018\u0001`@8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bA\u0010BR\u0014\u0010\u0016\u001A\u00020\u00158\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\bD\u0010ER\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010FR\u0014\u0010G\u001A\u00020\u000B8\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010=R\u001A\u0010J\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048PX\u0090\u0004\u00A2\u0006\u0006\u001A\u0004\bH\u0010IR\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010KR\u001A\u0010M\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00128BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bL\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006N"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "awaitReusability", "()V", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable", "()Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class DispatchedContinuation extends DispatchedTask implements Continuation, CoroutineStackFrame {
    private volatile Object _reusableCancellableContinuation;
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU;
    public Object _state;
    public final Continuation continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    static {
        String s = UnityPlayerActivity.adjustValue("310208141D000509172D1103020B0D0B041002152E0E00150E0B070F04040E00");
        DispatchedContinuation._reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, s);
    }

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher0, Continuation continuation0) {
        super(-1);
        this.dispatcher = coroutineDispatcher0;
        this.continuation = continuation0;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(this.getContext());
        this._reusableCancellableContinuation = null;
    }

    public final void awaitReusability() {
        while(this._reusableCancellableContinuation == DispatchedContinuationKt.REUSABLE_CLAIMED) {
        }
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object object0, Throwable throwable0) {
        if(object0 instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation)object0).onCancellation.invoke(throwable0);
        }
    }

    public final CancellableContinuationImpl claimReusableCancellableContinuation() {
        Object object0;
        do {
            while(true) {
                object0 = this._reusableCancellableContinuation;
                if(object0 == null) {
                    this._reusableCancellableContinuation = DispatchedContinuationKt.REUSABLE_CLAIMED;
                    return null;
                }
                if(!(object0 instanceof CancellableContinuationImpl)) {
                    break;
                }
                if(WorkSpec..ExternalSyntheticBackport0.m(DispatchedContinuation._reusableCancellableContinuation$FU, this, object0, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                    return (CancellableContinuationImpl)object0;
                }
            }
        }
        while(object0 == DispatchedContinuationKt.REUSABLE_CLAIMED || object0 instanceof Throwable);
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E0E0E00120E16060B1E19411D150611174E") + object0).toString());
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext coroutineContext0, Object object0) {
        this._state = object0;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext0, this);
    }

    // 去混淆评级： 低(20)
    @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.continuation instanceof CoroutineStackFrame ? ((CoroutineStackFrame)this.continuation) : null;
    }

    @Override  // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public Continuation getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    // 去混淆评级： 低(20)
    private final CancellableContinuationImpl getReusableCancellableContinuation() {
        return this._reusableCancellableContinuation instanceof CancellableContinuationImpl ? ((CancellableContinuationImpl)this._reusableCancellableContinuation) : null;
    }

    @Override  // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public static void get_state$kotlinx_coroutines_core$annotations() {
    }

    public final boolean isReusable() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean postponeCancellation(Throwable throwable0) {
        do {
            while(true) {
                Object object0 = this._reusableCancellableContinuation;
                if(!Intrinsics.areEqual(object0, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                    break;
                }
                if(WorkSpec..ExternalSyntheticBackport0.m(DispatchedContinuation._reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, throwable0)) {
                    return true;
                }
            }
            if(object0 instanceof Throwable) {
                return true;
            }
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(DispatchedContinuation._reusableCancellableContinuation$FU, this, object0, null));
        return false;
    }

    public final void release() {
        CancellableContinuationImpl cancellableContinuationImpl0 = this.getReusableCancellableContinuation();
        if(cancellableContinuationImpl0 != null) {
            cancellableContinuationImpl0.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void resumeCancellableWith(Object object0, Function1 function10) {
        boolean z;
        Object object1 = CompletionStateKt.toState(object0, function10);
        CoroutineContext coroutineContext0 = this.getContext();
        if(this.dispatcher.isDispatchNeeded(coroutineContext0)) {
            this._state = object1;
            this.resumeMode = 1;
            CoroutineContext coroutineContext1 = this.getContext();
            this.dispatcher.dispatch(coroutineContext1, this);
            return;
        }
        EventLoop eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(eventLoop0.isUnconfinedLoopActive()) {
            this._state = object1;
            this.resumeMode = 1;
            eventLoop0.dispatchUnconfined(this);
            return;
        }
        eventLoop0.incrementUseCount(true);
        try {
            Job job0 = (Job)this.getContext().get(Job.Key);
            if(job0 == null || job0.isActive()) {
                z = false;
            }
            else {
                CancellationException cancellationException0 = job0.getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(object1, cancellationException0);
                this.resumeWith(Result.constructor-impl(ResultKt.createFailure(cancellationException0)));
                z = true;
            }
            if(!z) {
                CoroutineContext coroutineContext2 = this.continuation.getContext();
                Object object2 = ThreadContextKt.updateThreadContext(coroutineContext2, this.countOrElement);
                UndispatchedCoroutine undispatchedCoroutine0 = object2 == ThreadContextKt.NO_THREAD_ELEMENTS ? null : CoroutineContextKt.updateUndispatchedCompletion(this.continuation, coroutineContext2, object2);
                try {
                    this.continuation.resumeWith(object0);
                }
                catch(Throwable throwable1) {
                    if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                        ThreadContextKt.restoreThreadContext(coroutineContext2, object2);
                    }
                    throw throwable1;
                }
                if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(coroutineContext2, object2);
                }
            }
            while(eventLoop0.processUnconfinedEvent()) {
            }
        }
        catch(Throwable throwable0) {
            this.handleFatalException(throwable0, null);
        }
        finally {
            eventLoop0.decrementUseCount(true);
        }
    }

    public final boolean resumeCancelled(Object object0) {
        Job job0 = (Job)this.getContext().get(Job.Key);
        if(job0 != null && !job0.isActive()) {
            Throwable throwable0 = job0.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(object0, throwable0);
            this.resumeWith(Result.constructor-impl(ResultKt.createFailure(throwable0)));
            return true;
        }
        return false;
    }

    public final void resumeUndispatchedWith(Object object0) {
        CoroutineContext coroutineContext0 = this.continuation.getContext();
        Object object1 = ThreadContextKt.updateThreadContext(coroutineContext0, this.countOrElement);
        UndispatchedCoroutine undispatchedCoroutine0 = object1 == ThreadContextKt.NO_THREAD_ELEMENTS ? null : CoroutineContextKt.updateUndispatchedCompletion(this.continuation, coroutineContext0, object1);
        try {
            this.continuation.resumeWith(object0);
        }
        finally {
            if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(coroutineContext0, object1);
            }
        }
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(Object object0) {
        CoroutineContext coroutineContext0 = this.continuation.getContext();
        Object object1 = CompletionStateKt.toState$default(object0, null, 1, null);
        if(this.dispatcher.isDispatchNeeded(coroutineContext0)) {
            this._state = object1;
            this.resumeMode = 0;
            this.dispatcher.dispatch(coroutineContext0, this);
            return;
        }
        EventLoop eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(eventLoop0.isUnconfinedLoopActive()) {
            this._state = object1;
            this.resumeMode = 0;
            eventLoop0.dispatchUnconfined(this);
            return;
        }
        eventLoop0.incrementUseCount(true);
        try {
            CoroutineContext coroutineContext1 = this.getContext();
            Object object2 = ThreadContextKt.updateThreadContext(coroutineContext1, this.countOrElement);
            try {
                this.continuation.resumeWith(object0);
            }
            finally {
                ThreadContextKt.restoreThreadContext(coroutineContext1, object2);
            }
            while(eventLoop0.processUnconfinedEvent()) {
            }
        }
        catch(Throwable throwable0) {
            this.handleFatalException(throwable0, null);
        }
        finally {
            eventLoop0.decrementUseCount(true);
        }
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        Object object0 = this._state;
        this._state = DispatchedContinuationKt.UNDEFINED;
        return object0;
    }

    @Override
    public String toString() {
        return UnityPlayerActivity.adjustValue("2A191E110F15040D170A33020F1A080910131A19020F35") + this.dispatcher + UnityPlayerActivity.adjustValue("4250") + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    public final Throwable tryReleaseClaimedContinuation(CancellableContinuation cancellableContinuation0) {
        Object object0;
        while(true) {
            object0 = this._reusableCancellableContinuation;
            if(object0 != DispatchedContinuationKt.REUSABLE_CLAIMED) {
                break;
            }
            if(WorkSpec..ExternalSyntheticBackport0.m(DispatchedContinuation._reusableCancellableContinuation$FU, this, DispatchedContinuationKt.REUSABLE_CLAIMED, cancellableContinuation0)) {
                return null;
            }
        }
        if(!(object0 instanceof Throwable)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E0E0E00120E16060B1E19411D150611174E") + object0).toString());
        }
        if(!WorkSpec..ExternalSyntheticBackport0.m(DispatchedContinuation._reusableCancellableContinuation$FU, this, object0, null)) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2811040D0B054717171F0504130B0C020B0640").toString());
        }
        return (Throwable)object0;
    }
}

