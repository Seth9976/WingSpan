package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB\'\u0012 \u0010\u0004\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007\u00A2\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0007J\u0016\u0010\u0019\u001A\u00020\u00062\u000E\u0010\u001A\u001A\n\u0018\u00010\u001Cj\u0004\u0018\u0001`\u001DJ\u0017\u0010\u001E\u001A\u00020\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0000\u00A2\u0006\u0002\b\u001FJ\u000E\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001A\u00020\n2\f\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001A\u00020\n2\f\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001A\u00020\n\"\u0004\b\u0001\u0010\'2\f\u0010(\u001A\b\u0012\u0004\u0012\u0002H\'0)2$\u0010*\u001A \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001A\u00020/H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u00100J\u000F\u00101\u001A\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001A\u00020\u00062\u0006\u00104\u001A\u00020\nH\u0014J/\u00105\u001A\u00020\u00062\f\u00106\u001A\b\u0012\u0004\u0012\u000208072\n\u00109\u001A\u0006\u0012\u0002\b\u00030:H\u0014\u00F8\u0001\u0000\u00F8\u0001\u0001\u00A2\u0006\u0004\b;\u0010<J\b\u0010=\u001A\u00020\u0006H\u0014J\b\u0010>\u001A\u00020\u0006H\u0014J\n\u0010?\u001A\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001A\u0004\u0018\u00010,2\n\u0010(\u001A\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001A\u00028\u0000H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010AJ\"\u0010B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@\u00F8\u0001\u0000\u00F8\u0001\u0000\u00F8\u0001\u0002\u00F8\u0001\u0001\u00A2\u0006\u0004\bC\u0010AJ\u001F\u0010D\u001A\u0002H\'\"\u0004\b\u0001\u0010\'2\u0006\u0010.\u001A\u00020/H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010EJR\u0010F\u001A\u00020\u0006\"\u0004\b\u0001\u0010\'2\f\u0010(\u001A\b\u0012\u0004\u0012\u0002H\'0)2\u0006\u0010.\u001A\u00020/2$\u0010*\u001A \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010GJ \u0010H\u001A\u00020\u00062\n\u0010I\u001A\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001A\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001C\u0010M\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017\u00F8\u0001\u0000\u00F8\u0001\u0002\u00F8\u0001\u0001\u00A2\u0006\u0004\bN\u0010OJX\u0010P\u001A\u00020\u0006\"\u0004\b\u0001\u0010\'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001A\b\u0012\u0004\u0012\u0002H\'0)2\u0006\u0010.\u001A\u00020/2\b\u0010Q\u001A\u0004\u0018\u00010,H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010RR\u0014\u0010\t\u001A\u00020\n8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0012\u0010\r\u001A\u00020\nX\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\b\r\u0010\fR\u0012\u0010\u000E\u001A\u00020\nX\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000E\u0010\fR\u0014\u0010\u000F\u001A\u00020\n8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\fR\u0014\u0010\u0010\u001A\u00020\n8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001A\u00020\n8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00138F\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138F\u00F8\u0001\u0000\u00A2\u0006\u0006\u001A\u0004\b\u0018\u0010\u0015\u0082\u0002\u000F\n\u0002\b\u0019\n\u0005\b\u00A1\u001E0\u0001\n\u0002\b!\u00A8\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class AbstractChannel extends AbstractSendChannel implements Channel {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001A\u00020\rH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000EJ\u0012\u0010\u000F\u001A\u00020\r2\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001A\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000EJ\u000E\u0010\u0011\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class Itr implements ChannelIterator {
        public final AbstractChannel channel;
        private Object result;

        public Itr(AbstractChannel abstractChannel0) {
            this.channel = abstractChannel0;
            this.result = AbstractChannelKt.POLL_FAILED;
        }

        public static final Object access$hasNextSuspend(Itr abstractChannel$Itr0, Continuation continuation0) {
            return abstractChannel$Itr0.hasNextSuspend(continuation0);
        }

        public final Object getResult() {
            return this.result;
        }

        @Override  // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation continuation0) {
            if(this.result != AbstractChannelKt.POLL_FAILED) {
                return Boxing.boxBoolean(this.hasNextResult(this.result));
            }
            Object object0 = this.channel.pollInternal();
            this.result = object0;
            return object0 != AbstractChannelKt.POLL_FAILED ? Boxing.boxBoolean(this.hasNextResult(this.result)) : this.hasNextSuspend(continuation0);
        }

        private final boolean hasNextResult(Object object0) {
            if(object0 instanceof Closed) {
                if(((Closed)object0).closeCause != null) {
                    throw StackTraceRecoveryKt.recoverStackTrace(((Closed)object0).getReceiveException());
                }
                return false;
            }
            return true;
        }

        private final Object hasNextSuspend(Continuation continuation0) {
            CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation0));
            ReceiveHasNext abstractChannel$ReceiveHasNext0 = new ReceiveHasNext(this, cancellableContinuationImpl0);
            while(true) {
                if(this.channel.enqueueReceive(abstractChannel$ReceiveHasNext0)) {
                    this.channel.removeReceiveOnCancel(cancellableContinuationImpl0, abstractChannel$ReceiveHasNext0);
                    break;
                }
                Object object0 = this.channel.pollInternal();
                this.setResult(object0);
                if(object0 instanceof Closed) {
                    if(((Closed)object0).closeCause == null) {
                        cancellableContinuationImpl0.resumeWith(Boxing.boxBoolean(false));
                        break;
                    }
                    cancellableContinuationImpl0.resumeWith(Result.constructor-impl(ResultKt.createFailure(((Closed)object0).getReceiveException())));
                    break;
                }
                if(object0 != AbstractChannelKt.POLL_FAILED) {
                    Function1 function10 = this.channel.onUndeliveredElement;
                    cancellableContinuationImpl0.resume(Boxing.boxBoolean(true), (function10 == null ? null : OnUndeliveredElementKt.bindCancellationFun(function10, object0, cancellableContinuationImpl0.getContext())));
                    break;
                }
            }
            Object object1 = cancellableContinuationImpl0.getResult();
            if(object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation0);
            }
            return object1;
        }

        @Override  // kotlinx.coroutines.channels.ChannelIterator
        public Object next() {
            Object object0 = this.result;
            if(object0 instanceof Closed) {
                throw StackTraceRecoveryKt.recoverStackTrace(((Closed)object0).getReceiveException());
            }
            if(object0 == AbstractChannelKt.POLL_FAILED) {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("49180C1220041F11554E03050E1B0D0345100B500E00020D0201521E02040E1C41130A52491E08191A46470C1C181F0E001A08080B"));
            }
            this.result = AbstractChannelKt.POLL_FAILED;
            return object0;
        }

        @Override  // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public Object next(Continuation continuation0) {
            return DefaultImpls.next(this, continuation0);
        }

        public final void setResult(Object object0) {
            this.result = object0;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001A\u00020\n2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u000FH\u0016J\u0015\u0010\u0010\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000B\u001A\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0013H\u0016J!\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u000B\u001A\u00028\u00012\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static class ReceiveElement extends Receive {
        public final CancellableContinuation cont;
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation cancellableContinuation0, int v) {
            this.cont = cancellableContinuation0;
            this.receiveMode = v;
        }

        @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(Object object0) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override  // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed closed0) {
            if(this.receiveMode == 1) {
                Object object0 = Result.constructor-impl(ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(closed0.closeCause)));
                this.cont.resumeWith(object0);
                return;
            }
            Object object1 = Result.constructor-impl(ResultKt.createFailure(closed0.getReceiveException()));
            this.cont.resumeWith(object1);
        }

        public final Object resumeValue(Object object0) {
            return this.receiveMode == 1 ? ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(object0)) : object0;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("3C150E04071702201E0B1D080F1A21") + DebugStringsKt.getHexAddress(this) + UnityPlayerActivity.adjustValue("350208020B0811003F0114085C") + this.receiveMode + ']';
        }

        @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(Object object0, PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            Object object1 = this.resumeValue(object0);
            if(this.cont.tryResume(object1, (lockFreeLinkedListNode$PrepareOp0 == null ? null : lockFreeLinkedListNode$PrepareOp0.desc), this.resumeOnCancellationFun(object0)) == null) {
                return null;
            }
            if(lockFreeLinkedListNode$PrepareOp0 != null) {
                lockFreeLinkedListNode$PrepareOp0.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000B¢\u0006\u0002\u0010\fJ#\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000F\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001A\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000B8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class ReceiveElementWithUndeliveredHandler extends ReceiveElement {
        public final Function1 onUndeliveredElement;

        public ReceiveElementWithUndeliveredHandler(CancellableContinuation cancellableContinuation0, int v, Function1 function10) {
            super(cancellableContinuation0, v);
            this.onUndeliveredElement = function10;
        }

        @Override  // kotlinx.coroutines.channels.Receive
        public Function1 resumeOnCancellationFun(Object object0) {
            CoroutineContext coroutineContext0 = this.cont.getContext();
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, object0, coroutineContext0);
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\n\u0018\u00010\u000E2\u0006\u0010\u000B\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001A\u00020\n2\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0015H\u0016J!\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u000B\u001A\u00028\u00012\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001AR\u0016\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static class ReceiveHasNext extends Receive {
        public final CancellableContinuation cont;
        public final Itr iterator;

        public ReceiveHasNext(Itr abstractChannel$Itr0, CancellableContinuation cancellableContinuation0) {
            this.iterator = abstractChannel$Itr0;
            this.cont = cancellableContinuation0;
        }

        @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(Object object0) {
            this.iterator.setResult(object0);
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override  // kotlinx.coroutines.channels.Receive
        public Function1 resumeOnCancellationFun(Object object0) {
            Function1 function10 = this.iterator.channel.onUndeliveredElement;
            return function10 == null ? null : OnUndeliveredElementKt.bindCancellationFun(function10, object0, this.cont.getContext());
        }

        @Override  // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed closed0) {
            Object object0;
            if(closed0.closeCause == null) {
                object0 = kotlinx.coroutines.CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Boolean.FALSE, null, 2, null);
            }
            else {
                Throwable throwable0 = closed0.getReceiveException();
                object0 = this.cont.tryResumeWithException(throwable0);
            }
            if(object0 != null) {
                this.iterator.setResult(closed0);
                this.cont.completeResume(object0);
            }
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("3C150E040717022D131D3E08191A21") + DebugStringsKt.getHexAddress(this);
        }

        @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(Object object0, PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            if(this.cont.tryResume(Boolean.TRUE, (lockFreeLinkedListNode$PrepareOp0 == null ? null : lockFreeLinkedListNode$PrepareOp0.desc), this.resumeOnCancellationFun(object0)) == null) {
                return null;
            }
            if(lockFreeLinkedListNode$PrepareOp0 != null) {
                lockFreeLinkedListNode$PrepareOp0.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BR\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\b\u0012$\u0010\t\u001A \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n\u0012\u0006\u0010\r\u001A\u00020\u000Eø\u0001\u0000¢\u0006\u0002\u0010\u000FJ\u0015\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0012H\u0016J#\u0010\u0016\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001A\u001A\u00020\u00122\n\u0010\u001B\u001A\u0006\u0012\u0002\b\u00030\u001CH\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016J!\u0010\u001F\u001A\u0004\u0018\u00010 2\u0006\u0010\u0013\u001A\u00028\u00022\b\u0010!\u001A\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#R3\u0010\t\u001A \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u00020\u000E8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "dispose", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class ReceiveSelect extends Receive implements DisposableHandle {
        public final Function2 block;
        public final AbstractChannel channel;
        public final int receiveMode;
        public final SelectInstance select;

        public ReceiveSelect(AbstractChannel abstractChannel0, SelectInstance selectInstance0, Function2 function20, int v) {
            this.channel = abstractChannel0;
            this.select = selectInstance0;
            this.block = function20;
            this.receiveMode = v;
        }

        @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(Object object0) {
            Function2 function20 = this.block;
            ChannelResult channelResult0 = this.receiveMode == 1 ? ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(object0)) : object0;
            CancellableKt.startCoroutineCancellable(function20, channelResult0, this.select.getCompletion(), this.resumeOnCancellationFun(object0));
        }

        @Override  // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            boolean z = !this.remove();
        }

        @Override  // kotlinx.coroutines.channels.Receive
        public Function1 resumeOnCancellationFun(Object object0) {
            Function1 function10 = this.channel.onUndeliveredElement;
            return function10 == null ? null : OnUndeliveredElementKt.bindCancellationFun(function10, object0, this.select.getCompletion().getContext());
        }

        @Override  // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed closed0) {
            if(!this.select.trySelect()) {
                return;
            }
            switch(this.receiveMode) {
                case 0: {
                    Throwable throwable0 = closed0.getReceiveException();
                    this.select.resumeSelectWithException(throwable0);
                    return;
                }
                case 1: {
                    ChannelResult channelResult0 = ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(closed0.closeCause));
                    Continuation continuation0 = this.select.getCompletion();
                    CancellableKt.startCoroutineCancellable$default(this.block, channelResult0, continuation0, null, 4, null);
                }
            }
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("3C150E04071702361702150E152E") + DebugStringsKt.getHexAddress(this) + '[' + this.select + UnityPlayerActivity.adjustValue("420208020B0811003F0114085C") + this.receiveMode + ']';
        }

        @Override  // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(Object object0, PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            return (Symbol)this.select.trySelectOther(lockFreeLinkedListNode$PrepareOp0);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001A\u00020\nH\u0016R\u0012\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        private final Receive receive;

        public RemoveReceiveOnCancel(Receive receive0) {
            this.receive = receive0;
        }

        @Override  // kotlin.jvm.functions.Function1
        public Object invoke(Object object0) {
            this.invoke(((Throwable)object0));
            return Unit.INSTANCE;
        }

        @Override  // kotlinx.coroutines.CancelHandlerBase
        public void invoke(Throwable throwable0) {
            boolean z = !this.receive.remove();
        }

        @Override
        public String toString() {
            return UnityPlayerActivity.adjustValue("3C15000E18043500110B191B04210F24041C0D15013A") + this.receive + ']';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\r\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0014J\u0016\u0010\f\u001A\u0004\u0018\u00010\t2\n\u0010\r\u001A\u00060\u000Ej\u0002`\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "onRemoved", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class TryPollDesc extends RemoveFirstDesc {
        public TryPollDesc(LockFreeLinkedListHead lockFreeLinkedListHead0) {
            super(lockFreeLinkedListHead0);
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$RemoveFirstDesc
        protected Object failure(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            if(!(lockFreeLinkedListNode0 instanceof Closed)) {
                return !(lockFreeLinkedListNode0 instanceof Send) ? AbstractChannelKt.POLL_FAILED : null;
            }
            return lockFreeLinkedListNode0;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public Object onPrepare(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            Symbol symbol0 = ((Send)lockFreeLinkedListNode$PrepareOp0.affected).tryResumeSend(lockFreeLinkedListNode$PrepareOp0);
            if(symbol0 == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            return symbol0 == AtomicKt.RETRY_ATOMIC ? AtomicKt.RETRY_ATOMIC : null;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public void onRemoved(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            ((Send)lockFreeLinkedListNode0).undeliveredElement();
        }
    }

    public AbstractChannel(Function1 function10) {
        super(function10);
    }

    public static final Object access$receiveSuspend(AbstractChannel abstractChannel0, int v, Continuation continuation0) {
        return abstractChannel0.receiveSuspend(v, continuation0);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public void cancel() {
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel(this);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException0) {
        if(this.isClosedForReceive()) {
            return;
        }
        if(cancellationException0 == null) {
            cancellationException0 = new CancellationException(DebugStringsKt.getClassSimpleName(this) + UnityPlayerActivity.adjustValue("4E070C124E02060B110B1C01040A"));
        }
        this.cancelInternal$kotlinx_coroutines_core(cancellationException0);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final boolean cancel(Throwable throwable0) {
        return this.cancelInternal$kotlinx_coroutines_core(throwable0);
    }

    public final boolean cancelInternal$kotlinx_coroutines_core(Throwable throwable0) {
        boolean z = this.close(throwable0);
        this.onCancelIdempotent(z);
        return z;
    }

    protected final TryPollDesc describeTryPoll() {
        return new TryPollDesc(this.getQueue());
    }

    private final boolean enqueueReceive(Receive receive0) {
        return this.enqueueReceiveInternal(receive0);
    }

    protected boolean enqueueReceiveInternal(Receive receive0) {
        if(this.isBufferAlwaysEmpty()) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = this.getQueue();
            do {
                LockFreeLinkedListNode lockFreeLinkedListNode1 = lockFreeLinkedListNode0.getPrevNode();
                if(!(lockFreeLinkedListNode1 instanceof Send) == 0) {
                    return false;
                }
            }
            while(!lockFreeLinkedListNode1.addNext(receive0, lockFreeLinkedListNode0));
            return true;
        }
        else {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = this.getQueue();
            kotlinx.coroutines.channels.AbstractChannel.enqueueReceiveInternal..inlined.addLastIfPrevAndIf.1 abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$10 = new CondAddOp(this) {
                @Override  // kotlinx.coroutines.internal.AtomicOp
                public Object prepare(Object object0) {
                    return this.prepare(((LockFreeLinkedListNode)object0));
                }

                // 去混淆评级： 低(20)
                public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode0) {
                    return AbstractChannel.this.isBufferEmpty() ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
                }
            };
        alab1:
            while(true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode2.getPrevNode();
                if(!(lockFreeLinkedListNode3 instanceof Send) == 0) {
                    break;
                }
                switch(lockFreeLinkedListNode3.tryCondAddNext(receive0, lockFreeLinkedListNode2, abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$10)) {
                    case 1: {
                        return true;
                    }
                    case 2: {
                        break alab1;
                    }
                }
            }
        }
        return false;
    }

    private final boolean enqueueReceiveSelect(SelectInstance selectInstance0, Function2 function20, int v) {
        ReceiveSelect abstractChannel$ReceiveSelect0 = new ReceiveSelect(this, selectInstance0, function20, v);
        boolean z = this.enqueueReceive(abstractChannel$ReceiveSelect0);
        if(z) {
            selectInstance0.disposeOnSelect(abstractChannel$ReceiveSelect0);
        }
        return z;
    }

    protected final boolean getHasReceiveOrClosed() {
        return this.getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        return (SelectInstance selectInstance0, Function2 function20) -> while(true) {
            if(selectInstance0.isSelected()) {
                return;
            }
            if(AbstractChannel.this.isEmptyImpl()) {
                if(!AbstractChannel.this.enqueueReceiveSelect(selectInstance0, function20, 0)) {
                    continue;
                }
                return;
            }
            Object object0 = AbstractChannel.this.pollSelectInternal(selectInstance0);
            if(object0 == SelectKt.getALREADY_SELECTED()) {
                return;
            }
            if(object0 != AbstractChannelKt.POLL_FAILED && object0 != AtomicKt.RETRY_ATOMIC) {
                AbstractChannel.this.tryStartBlockUnintercepted(function20, selectInstance0, 0, object0);
            }
        };

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JH\u0010\u0002\u001A\u00020\u0003\"\u0004\b\u0001\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00062\"\u0010\u0007\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$onReceive$1", "Lkotlinx/coroutines/selects/SelectClause1;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.channels.AbstractChannel.onReceive.1 implements SelectClause1 {
            kotlinx.coroutines.channels.AbstractChannel.onReceive.1(AbstractChannel abstractChannel0) {
            }

            @Override  // kotlinx.coroutines.selects.SelectClause1
            public void registerSelectClause1(SelectInstance selectInstance0, Function2 function20) {
                AbstractChannel.this.registerSelectReceiveMode(selectInstance0, 0, function20);
            }
        }

    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveCatching() {
        return (SelectInstance selectInstance0, Function2 function20) -> while(true) {
            if(selectInstance0.isSelected()) {
                return;
            }
            if(AbstractChannel.this.isEmptyImpl()) {
                if(!AbstractChannel.this.enqueueReceiveSelect(selectInstance0, function20, 1)) {
                    continue;
                }
                return;
            }
            Object object0 = AbstractChannel.this.pollSelectInternal(selectInstance0);
            if(object0 == SelectKt.getALREADY_SELECTED()) {
                return;
            }
            if(object0 != AbstractChannelKt.POLL_FAILED && object0 != AtomicKt.RETRY_ATOMIC) {
                AbstractChannel.this.tryStartBlockUnintercepted(function20, selectInstance0, 1, object0);
            }
        };

        @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JQ\u0010\u0003\u001A\u00020\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u00072(\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\tH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\fø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"kotlinx/coroutines/channels/AbstractChannel$onReceiveCatching$1", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlinx/coroutines/channels/ChannelResult;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.channels.AbstractChannel.onReceiveCatching.1 implements SelectClause1 {
            kotlinx.coroutines.channels.AbstractChannel.onReceiveCatching.1(AbstractChannel abstractChannel0) {
            }

            @Override  // kotlinx.coroutines.selects.SelectClause1
            public void registerSelectClause1(SelectInstance selectInstance0, Function2 function20) {
                AbstractChannel.this.registerSelectReceiveMode(selectInstance0, 1, function20);
            }
        }

    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveOrNull() {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.getOnReceiveOrNull(this);
    }

    protected abstract boolean isBufferAlwaysEmpty();

    protected abstract boolean isBufferEmpty();

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.getClosedForReceive() != null && this.isBufferEmpty();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.isEmptyImpl();
    }

    // 去混淆评级： 低(20)
    protected final boolean isEmptyImpl() {
        return !(this.getQueue().getNextNode() instanceof Send) && this.isBufferEmpty();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        return new Itr(this);
    }

    protected void onCancelIdempotent(boolean z) {
        Closed closed0 = this.getClosedForSend();
        if(closed0 != null) {
            Object object0 = InlineList.constructor-impl$default(null, 1, null);
            while(true) {
                LockFreeLinkedListNode lockFreeLinkedListNode0 = closed0.getPrevNode();
                if(lockFreeLinkedListNode0 instanceof LockFreeLinkedListHead) {
                    this.onCancelIdempotentList-w-w6eGU(object0, closed0);
                    return;
                }
                if(DebugKt.getASSERTIONS_ENABLED() && !(lockFreeLinkedListNode0 instanceof Send)) {
                    throw new AssertionError();
                }
                if(lockFreeLinkedListNode0.remove()) {
                    object0 = InlineList.plus-FjFbRPM(object0, ((Send)lockFreeLinkedListNode0));
                }
                else {
                    lockFreeLinkedListNode0.helpRemove();
                }
            }
        }
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("2D11030F0115470D131E00080F").toString());
    }

    protected void onCancelIdempotentList-w-w6eGU(Object object0, Closed closed0) {
        if(object0 != null) {
            if(!(object0 instanceof ArrayList)) {
                ((Send)object0).resumeSendClosed(closed0);
                return;
            }
            if(object0 == null) {
                throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F12111B025E2C131C001E291B1D0451244E0E01451901040108001949061D1C1F1815070F02165C071E19041C0F06095C271E010800042B0C011A4E1641050E13091B005E0E0E020D020606071F031240351E15172F1C04001D04142E0640311F130F182B0C011A4C28410107470E1D1A1C040F164F040A00010519080004144B1B0004081300000B4B3B001C040F0B2D0E1606505010"));
            }
            for(int v = ((ArrayList)object0).size() - 1; -1 < v; --v) {
                ((Send)((ArrayList)object0).get(v)).resumeSendClosed(closed0);
            }
        }
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of \'tryReceive\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'poll\' did, for the precise replacement please refer to the \'poll\' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public Object poll() {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.poll(this);
    }

    protected Object pollInternal() {
        while(true) {
            Send send0 = this.takeFirstSendOrPeekClosed();
            if(send0 == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            if(send0.tryResumeSend(null) != null) {
                send0.completeResumeSend();
                return send0.getPollResult();
            }
            send0.undeliveredElement();
        }
    }

    protected Object pollSelectInternal(SelectInstance selectInstance0) {
        TryPollDesc abstractChannel$TryPollDesc0 = this.describeTryPoll();
        Object object0 = selectInstance0.performAtomicTrySelect(abstractChannel$TryPollDesc0);
        if(object0 != null) {
            return object0;
        }
        ((Send)abstractChannel$TryPollDesc0.getResult()).completeResumeSend();
        return ((Send)abstractChannel$TryPollDesc0.getResult()).getPollResult();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation0) {
        Object object0 = this.pollInternal();
        return object0 == AbstractChannelKt.POLL_FAILED || object0 instanceof Closed ? this.receiveSuspend(0, continuation0) : object0;
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receiveCatching-JP2dKIU(Continuation continuation0) {
        kotlinx.coroutines.channels.AbstractChannel.receiveCatching.1 abstractChannel$receiveCatching$10;
        if(continuation0 instanceof kotlinx.coroutines.channels.AbstractChannel.receiveCatching.1) {
            abstractChannel$receiveCatching$10 = (kotlinx.coroutines.channels.AbstractChannel.receiveCatching.1)continuation0;
            if((abstractChannel$receiveCatching$10.label & 0x80000000) == 0) {
                abstractChannel$receiveCatching$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        Object object1 = continuation0.receiveCatching-JP2dKIU(this);
                        return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : ChannelResult.box-impl(object1);
                    }
                };
            }
            else {
                abstractChannel$receiveCatching$10.label ^= 0x80000000;
            }
        }
        else {
            abstractChannel$receiveCatching$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    Object object1 = continuation0.receiveCatching-JP2dKIU(this);
                    return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : ChannelResult.box-impl(object1);
                }
            };
        }
        Object object0 = abstractChannel$receiveCatching$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(abstractChannel$receiveCatching$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Object object2 = this.pollInternal();
                if(object2 != AbstractChannelKt.POLL_FAILED) {
                    return object2 instanceof Closed ? ChannelResult.Companion.closed-JP2dKIU(((Closed)object2).closeCause) : ChannelResult.Companion.success-JP2dKIU(object2);
                }
                abstractChannel$receiveCatching$10.label = 1;
                object0 = this.receiveSuspend(1, abstractChannel$receiveCatching$10);
                return object0 == object1 ? object1 : ((ChannelResult)object0).unbox-impl();
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                return ((ChannelResult)object0).unbox-impl();
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
            }
        }
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of \'receiveCatching\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'receiveOrNull\' did, for the detailed replacement please refer to the \'receiveOrNull\' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation continuation0) {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.receiveOrNull(this, continuation0);
    }

    private final Object receiveSuspend(int v, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation0));
        ReceiveElement abstractChannel$ReceiveElement0 = this.onUndeliveredElement == null ? new ReceiveElement(cancellableContinuationImpl0, v) : new ReceiveElementWithUndeliveredHandler(cancellableContinuationImpl0, v, this.onUndeliveredElement);
        while(true) {
            if(this.enqueueReceive(abstractChannel$ReceiveElement0)) {
                this.removeReceiveOnCancel(cancellableContinuationImpl0, abstractChannel$ReceiveElement0);
                break;
            }
            Object object0 = this.pollInternal();
            if(object0 instanceof Closed) {
                abstractChannel$ReceiveElement0.resumeReceiveClosed(((Closed)object0));
                break;
            }
            if(object0 != AbstractChannelKt.POLL_FAILED) {
                cancellableContinuationImpl0.resume(abstractChannel$ReceiveElement0.resumeValue(object0), abstractChannel$ReceiveElement0.resumeOnCancellationFun(object0));
                break;
            }
        }
        Object object1 = cancellableContinuationImpl0.getResult();
        if(object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object1;
    }

    // 检测为 Lambda 实现
    private final void registerSelectReceiveMode(SelectInstance selectInstance0, int v, Function2 function20) [...]

    private final void removeReceiveOnCancel(CancellableContinuation cancellableContinuation0, Receive receive0) {
        cancellableContinuation0.invokeOnCancellation(new RemoveReceiveOnCancel(this, receive0));
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected ReceiveOrClosed takeFirstReceiveOrPeekClosed() {
        return super.takeFirstReceiveOrPeekClosed();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final Object tryReceive-PtdJZtk() {
        Object object0 = this.pollInternal();
        if(object0 == AbstractChannelKt.POLL_FAILED) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        return object0 instanceof Closed ? ChannelResult.Companion.closed-JP2dKIU(((Closed)object0).closeCause) : ChannelResult.Companion.success-JP2dKIU(object0);
    }

    private final void tryStartBlockUnintercepted(Function2 function20, SelectInstance selectInstance0, int v, Object object0) {
        if(object0 instanceof Closed) {
            switch(v) {
                case 0: {
                    throw StackTraceRecoveryKt.recoverStackTrace(((Closed)object0).getReceiveException());
                }
                case 1: {
                    if(!selectInstance0.trySelect()) {
                        return;
                    }
                    UndispatchedKt.startCoroutineUnintercepted(function20, ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(((Closed)object0).closeCause)), selectInstance0.getCompletion());
                    return;
                }
                default: {
                    return;
                }
            }
        }
        if(v == 1) {
            UndispatchedKt.startCoroutineUnintercepted(function20, ChannelResult.box-impl((object0 instanceof Closed ? ChannelResult.Companion.closed-JP2dKIU(((Closed)object0).closeCause) : ChannelResult.Companion.success-JP2dKIU(object0))), selectInstance0.getCompletion());
            return;
        }
        UndispatchedKt.startCoroutineUnintercepted(function20, object0, selectInstance0.getCompletion());
    }
}

