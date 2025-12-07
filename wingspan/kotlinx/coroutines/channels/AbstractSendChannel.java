package kotlinx.coroutines.channels;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
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
import kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000\u00A6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ#\u0010\u0013\u001A\u000E\u0012\u0002\b\u00030\u0011j\u0006\u0012\u0002\b\u0003`\u00122\u0006\u0010\u0010\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001D\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010\u001F\u001A\u00020\u00032\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001DH\u0002\u00A2\u0006\u0004\b\u001F\u0010 J#\u0010!\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00028\u00002\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001DH\u0002\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010!\u001A\u00020\b2\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001DH\u0002\u00A2\u0006\u0004\b!\u0010#J)\u0010&\u001A\u00020\u00032\u0018\u0010%\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016\u00A2\u0006\u0004\b&\u0010\u0007J\u0019\u0010\'\u001A\u00020\u00032\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b+\u0010,J#\u0010/\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00028\u00002\n\u0010.\u001A\u0006\u0012\u0002\b\u00030-H\u0014\u00A2\u0006\u0004\b/\u00100J\u0017\u00102\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u000201H\u0014\u00A2\u0006\u0004\b2\u00103JX\u00109\u001A\u00020\u0003\"\u0004\b\u0001\u001042\f\u0010.\u001A\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001A\u00028\u00002(\u00108\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001A05H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0004\b9\u0010:J\u001B\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00028\u0000H\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0019\u0010;J\u001D\u0010=\u001A\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010\u0010\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\b=\u0010>J\u001B\u0010?\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00028\u0000H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b?\u0010;J\u0017\u0010@\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014\u00A2\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001A\u0004\u0018\u00010\u0018H\u0004\u00A2\u0006\u0004\bB\u0010CJ\u000F\u0010E\u001A\u00020DH\u0016\u00A2\u0006\u0004\bE\u0010FJ$\u0010I\u001A\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001A\u00028\u0000\u00F8\u0001\u0000\u00F8\u0001\u0001\u00F8\u0001\u0002\u00A2\u0006\u0004\bH\u0010,J+\u0010J\u001A\u00020\u0003*\u0006\u0012\u0002\b\u0003072\u0006\u0010\u0010\u001A\u00028\u00002\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001DH\u0002\u00A2\u0006\u0004\bJ\u0010KR\u0014\u0010M\u001A\u00020D8TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\bL\u0010FR\u001A\u0010P\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001D8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bN\u0010OR\u001A\u0010R\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001D8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bQ\u0010OR\u0014\u0010S\u001A\u00020\n8$X\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\bS\u0010TR\u0014\u0010U\u001A\u00020\n8$X\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\bU\u0010TR\u0011\u0010V\u001A\u00020\n8F\u00A2\u0006\u0006\u001A\u0004\bV\u0010TR\u0014\u0010W\u001A\u00020\n8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bW\u0010TR#\u0010[\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060X8F\u00A2\u0006\u0006\u001A\u0004\bY\u0010ZR.\u0010\u0005\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004X\u0085\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\\R\u001A\u0010^\u001A\u00020]8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b^\u0010_\u001A\u0004\b`\u0010aR\u0014\u0010c\u001A\u00020D8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bb\u0010F\u0082\u0002\u000F\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00A1\u001E0\u0001\u00A8\u0006h"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "", "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class AbstractSendChannel implements SendChannel {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001A\u00020\u000BH\u0016J\u0014\u0010\f\u001A\u00020\u000B2\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0014\u0010\u0011\u001A\u0004\u0018\u00010\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001A\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class SendBuffered extends Send {
        public final Object element;

        public SendBuffered(Object object0) {
            this.element = object0;
        }

        @Override  // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
        }

        @Override  // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.element;
        }

        @Override  // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed closed0) {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                throw new AssertionError();
            }
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("3D1503052C140103171C150921") + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }

        @Override  // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            Symbol symbol0 = CancellableContinuationImplKt.RESUME_TOKEN;
            if(lockFreeLinkedListNode$PrepareOp0 != null) {
                lockFreeLinkedListNode$PrepareOp0.finishPrepare();
            }
            return symbol0;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00028\u0001¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\fH\u0014¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "element", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static class SendBufferedDesc extends AddLastDesc {
        public SendBufferedDesc(LockFreeLinkedListHead lockFreeLinkedListHead0, Object object0) {
            super(lockFreeLinkedListHead0, new SendBuffered(object0));
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            if(!(lockFreeLinkedListNode0 instanceof Closed)) {
                return lockFreeLinkedListNode0 instanceof ReceiveOrClosed ? AbstractChannelKt.OFFER_FAILED : null;
            }
            return lockFreeLinkedListNode0;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BV\u0012\u0006\u0010\u0005\u001A\u00028\u0001\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\t\u0012(\u0010\n\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u000Bø\u0001\u0000¢\u0006\u0002\u0010\u000FJ\b\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0015H\u0016J\u0014\u0010\u0017\u001A\u00020\u00152\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\u0014\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0016J\b\u0010 \u001A\u00020\u0015H\u0016R7\u0010\n\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u000B8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "channel", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "", "dispose", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class SendSelect extends Send implements DisposableHandle {
        public final Function2 block;
        public final AbstractSendChannel channel;
        private final Object pollResult;
        public final SelectInstance select;

        public SendSelect(Object object0, AbstractSendChannel abstractSendChannel0, SelectInstance selectInstance0, Function2 function20) {
            this.pollResult = object0;
            this.channel = abstractSendChannel0;
            this.select = selectInstance0;
            this.block = function20;
        }

        @Override  // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
            Continuation continuation0 = this.select.getCompletion();
            CancellableKt.startCoroutineCancellable$default(this.block, this.channel, continuation0, null, 4, null);
        }

        @Override  // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if(!this.remove()) {
                return;
            }
            this.undeliveredElement();
        }

        @Override  // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.pollResult;
        }

        @Override  // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed closed0) {
            if(this.select.trySelect()) {
                Throwable throwable0 = closed0.getSendException();
                this.select.resumeSelectWithException(throwable0);
            }
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return UnityPlayerActivity.adjustValue("3D1503053D040B00111A30") + DebugStringsKt.getHexAddress(this) + '(' + this.getPollResult() + UnityPlayerActivity.adjustValue("472B") + this.channel + UnityPlayerActivity.adjustValue("4250") + this.select + ']';
        }

        @Override  // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            return (Symbol)this.select.trySelectOther(lockFreeLinkedListNode$PrepareOp0);
        }

        @Override  // kotlinx.coroutines.channels.Send
        public void undeliveredElement() {
            Function1 function10 = this.channel.onUndeliveredElement;
            if(function10 != null) {
                OnUndeliveredElementKt.callUndeliveredElement(function10, this.getPollResult(), this.select.getCompletion().getContext());
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004B\u0015\u0012\u0006\u0010\u0005\u001A\u00028\u0001\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0014J\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\n\u0010\u000F\u001A\u00060\u0010j\u0002`\u0011H\u0016R\u0012\u0010\u0005\u001A\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Ljava/lang/Object;", "failure", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class TryOfferDesc extends RemoveFirstDesc {
        public final Object element;

        public TryOfferDesc(Object object0, LockFreeLinkedListHead lockFreeLinkedListHead0) {
            super(lockFreeLinkedListHead0);
            this.element = object0;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$RemoveFirstDesc
        protected Object failure(LockFreeLinkedListNode lockFreeLinkedListNode0) {
            if(!(lockFreeLinkedListNode0 instanceof Closed)) {
                return !(lockFreeLinkedListNode0 instanceof ReceiveOrClosed) ? AbstractChannelKt.OFFER_FAILED : null;
            }
            return lockFreeLinkedListNode0;
        }

        @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc
        public Object onPrepare(PrepareOp lockFreeLinkedListNode$PrepareOp0) {
            Symbol symbol0 = ((ReceiveOrClosed)lockFreeLinkedListNode$PrepareOp0.affected).tryResumeReceive(this.element, lockFreeLinkedListNode$PrepareOp0);
            if(symbol0 == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            return symbol0 == AtomicKt.RETRY_ATOMIC ? AtomicKt.RETRY_ATOMIC : null;
        }
    }

    private volatile Object onCloseHandler;
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU;
    protected final Function1 onUndeliveredElement;
    private final LockFreeLinkedListHead queue;

    static {
        String s = UnityPlayerActivity.adjustValue("011E2E0D0112022D13001401041C");
        AbstractSendChannel.onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, s);
    }

    public AbstractSendChannel(Function1 function10) {
        this.onUndeliveredElement = function10;
        this.queue = new LockFreeLinkedListHead();
        this.onCloseHandler = null;
    }

    public static final Object access$sendSuspend(AbstractSendChannel abstractSendChannel0, Object object0, Continuation continuation0) {
        return abstractSendChannel0.sendSuspend(object0, continuation0);
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable throwable0) {
        boolean z;
        Closed closed0 = new Closed(throwable0);
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue;
        do {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = lockFreeLinkedListNode0.getPrevNode();
            z = true;
            if(!(lockFreeLinkedListNode1 instanceof Closed) == 0) {
                z = false;
                break;
            }
        }
        while(!lockFreeLinkedListNode1.addNext(closed0, lockFreeLinkedListNode0));
        if(!z) {
            closed0 = (Closed)this.queue.getPrevNode();
        }
        this.helpClose(closed0);
        if(z) {
            this.invokeOnCloseHandler(throwable0);
        }
        return z;
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead0 = this.queue;
        LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)lockFreeLinkedListHead0.getNext();
        int v = 0;
        while(!Intrinsics.areEqual(lockFreeLinkedListNode0, lockFreeLinkedListHead0)) {
            if(lockFreeLinkedListNode0 instanceof LockFreeLinkedListNode) {
                ++v;
            }
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
        }
        return v;
    }

    protected final AddLastDesc describeSendBuffered(Object object0) {
        return new SendBufferedDesc(this.queue, object0);
    }

    protected final TryOfferDesc describeTryOffer(Object object0) {
        return new TryOfferDesc(object0, this.queue);
    }

    protected Object enqueueSend(Send send0) {
        boolean z;
        if(this.isBufferAlwaysFull()) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue;
            do {
                LockFreeLinkedListNode lockFreeLinkedListNode1 = lockFreeLinkedListNode0.getPrevNode();
                if(lockFreeLinkedListNode1 instanceof ReceiveOrClosed) {
                    return lockFreeLinkedListNode1;
                }
            }
            while(!lockFreeLinkedListNode1.addNext(send0, lockFreeLinkedListNode0));
            return null;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
        kotlinx.coroutines.channels.AbstractSendChannel.enqueueSend..inlined.addLastIfPrevAndIf.1 abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$10 = new CondAddOp(this) {
            @Override  // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(Object object0) {
                return this.prepare(((LockFreeLinkedListNode)object0));
            }

            // 去混淆评级： 低(20)
            public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode0) {
                return AbstractSendChannel.this.isBufferFull() ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode2.getPrevNode();
            if(lockFreeLinkedListNode3 instanceof ReceiveOrClosed) {
                return lockFreeLinkedListNode3;
            }
            int v = lockFreeLinkedListNode3.tryCondAddNext(send0, lockFreeLinkedListNode2, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$10);
            z = true;
            if(v == 1) {
                break;
            }
            if(v == 2) {
                z = false;
                break;
            }
        }
        return !z ? AbstractChannelKt.ENQUEUE_FAILED : null;
    }

    protected String getBufferDebugString() {
        return UnityPlayerActivity.adjustValue("");
    }

    protected final Closed getClosedForReceive() {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue.getNextNode();
        Closed closed0 = lockFreeLinkedListNode0 instanceof Closed ? ((Closed)lockFreeLinkedListNode0) : null;
        if(closed0 != null) {
            this.helpClose(closed0);
            return closed0;
        }
        return null;
    }

    protected final Closed getClosedForSend() {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue.getPrevNode();
        Closed closed0 = lockFreeLinkedListNode0 instanceof Closed ? ((Closed)lockFreeLinkedListNode0) : null;
        if(closed0 != null) {
            this.helpClose(closed0);
            return closed0;
        }
        return null;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        return (SelectInstance selectInstance0, Object object0, Function2 function20) -> {
            Object object2;
            do {
                if(selectInstance0.isSelected()) {
                    return;
                }
                if(AbstractSendChannel.this.isFullImpl()) {
                    SendSelect abstractSendChannel$SendSelect0 = new SendSelect(object0, AbstractSendChannel.this, selectInstance0, function20);
                    Object object1 = AbstractSendChannel.this.enqueueSend(abstractSendChannel$SendSelect0);
                    if(object1 == null) {
                        selectInstance0.disposeOnSelect(abstractSendChannel$SendSelect0);
                        return;
                    }
                    if(object1 instanceof Closed) {
                        throw StackTraceRecoveryKt.recoverStackTrace(AbstractSendChannel.this.helpCloseAndGetSendException(object0, ((Closed)object1)));
                    }
                    if(object1 != AbstractChannelKt.ENQUEUE_FAILED && !(object1 instanceof Receive)) {
                        throw new IllegalStateException((UnityPlayerActivity.adjustValue("0B1E1C140B1402361700144D130B1512171C0B144D") + object1 + ' ').toString());
                    }
                }
                object2 = AbstractSendChannel.this.offerSelectInternal(object0, selectInstance0);
                if(object2 == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
            }
            while(object2 == AbstractChannelKt.OFFER_FAILED || object2 == AtomicKt.RETRY_ATOMIC);
            if(object2 == AbstractChannelKt.OFFER_SUCCESS) {
                UndispatchedKt.startCoroutineUnintercepted(function20, AbstractSendChannel.this, selectInstance0.getCompletion());
                return;
            }
            if(object2 instanceof Closed) {
                throw StackTraceRecoveryKt.recoverStackTrace(AbstractSendChannel.this.helpCloseAndGetSendException(object0, ((Closed)object2)));
            }
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("01160B041C320209170D04240F1A04150B1302501F041A14150B170A50") + object2).toString());
        };

        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JV\u0010\u0003\u001A\u00020\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001A\u00028\u00002(\u0010\t\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000E"}, d2 = {"kotlinx/coroutines/channels/AbstractSendChannel$onSend$1", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "registerSelectClause2", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.channels.AbstractSendChannel.onSend.1 implements SelectClause2 {
            kotlinx.coroutines.channels.AbstractSendChannel.onSend.1(AbstractSendChannel abstractSendChannel0) {
            }

            @Override  // kotlinx.coroutines.selects.SelectClause2
            public void registerSelectClause2(SelectInstance selectInstance0, Object object0, Function2 function20) {
                AbstractSendChannel.this.registerSelectSend(selectInstance0, object0, function20);
            }
        }

    }

    protected final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    private final String getQueueDebugStateString() {
        String s;
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue.getNextNode();
        if(lockFreeLinkedListNode0 == this.queue) {
            return UnityPlayerActivity.adjustValue("2B1D1D1517301200070B");
        }
        if(lockFreeLinkedListNode0 instanceof Closed) {
            s = lockFreeLinkedListNode0.toString();
        }
        else if(lockFreeLinkedListNode0 instanceof Receive) {
            s = UnityPlayerActivity.adjustValue("3C150E0407170234070B050805");
        }
        else {
            s = lockFreeLinkedListNode0 instanceof Send ? UnityPlayerActivity.adjustValue("3D1503053F140210170A") : UnityPlayerActivity.adjustValue("3B3E28393E242431372A4A") + lockFreeLinkedListNode0;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode1 = this.queue.getPrevNode();
        if(lockFreeLinkedListNode1 != lockFreeLinkedListNode0) {
            s = s + UnityPlayerActivity.adjustValue("420118041B04340C080B4D") + this.countQueueSize();
            return lockFreeLinkedListNode1 instanceof Closed ? s + UnityPlayerActivity.adjustValue("4213010E1D0403231D1C23080F0A5C") + lockFreeLinkedListNode1 : s;
        }
        return s;
    }

    private final void helpClose(Closed closed0) {
        Object object0 = InlineList.constructor-impl$default(null, 1, null);
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = closed0.getPrevNode();
            Receive receive0 = lockFreeLinkedListNode0 instanceof Receive ? ((Receive)lockFreeLinkedListNode0) : null;
            if(receive0 == null) {
                break;
            }
            if(receive0.remove()) {
                object0 = InlineList.plus-FjFbRPM(object0, receive0);
            }
            else {
                receive0.helpRemove();
            }
        }
        if(object0 != null) {
            if(!(object0 instanceof ArrayList)) {
                ((Receive)object0).resumeReceiveClosed(closed0);
                return;
            }
            if(object0 == null) {
                throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F12111B025E2C131C001E291B1D0451244E0E01451901040108001949061D1C1F1815070F02165C071E19041C0F06095C271E010800042B0C011A4E1641050E13091B005E0E0E020D020606071F031240351E15172F1C04001D04142E0640311F130F182B0C011A4C28410107470E1D1A1C040F164F040A00010519080004144B1B0004081300000B4B3B001C040F0B2D0E1606505010"));
            }
            for(int v = ((ArrayList)object0).size() - 1; -1 < v; --v) {
                ((Receive)((ArrayList)object0).get(v)).resumeReceiveClosed(closed0);
            }
        }
    }

    private final Throwable helpCloseAndGetSendException(Object object0, Closed closed0) {
        this.helpClose(closed0);
        Function1 function10 = this.onUndeliveredElement;
        if(function10 != null) {
            UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function10, object0, null, 2, null);
            if(undeliveredElementException0 != null) {
                ExceptionsKt.addSuppressed(undeliveredElementException0, closed0.getSendException());
                throw undeliveredElementException0;
            }
        }
        return closed0.getSendException();
    }

    private final Throwable helpCloseAndGetSendException(Closed closed0) {
        this.helpClose(closed0);
        return closed0.getSendException();
    }

    private final void helpCloseAndResumeWithSendException(Continuation continuation0, Object object0, Closed closed0) {
        this.helpClose(closed0);
        Throwable throwable0 = closed0.getSendException();
        Function1 function10 = this.onUndeliveredElement;
        if(function10 != null) {
            UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function10, object0, null, 2, null);
            if(undeliveredElementException0 != null) {
                ExceptionsKt.addSuppressed(undeliveredElementException0, throwable0);
                continuation0.resumeWith(Result.constructor-impl(ResultKt.createFailure(undeliveredElementException0)));
                return;
            }
        }
        continuation0.resumeWith(Result.constructor-impl(ResultKt.createFailure(throwable0)));
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 function10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = AbstractSendChannel.onCloseHandler$FU;
        if(!WorkSpec..ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater0, this, null, function10)) {
            Object object0 = this.onCloseHandler;
            throw object0 == AbstractChannelKt.HANDLER_INVOKED ? new IllegalStateException(UnityPlayerActivity.adjustValue("2F1E0215060415451A0F1E090D0B134712131D500C0D1C0406010B4E02080607121300000B144D0000054716070D1308121D0712091E1750040F180E0C0016")) : new IllegalStateException(UnityPlayerActivity.adjustValue("2F1E0215060415451A0F1E090D0B134712131D500C0D1C0406010B4E02080607121300000B145741") + object0);
        }
        Closed closed0 = this.getClosedForSend();
        if(closed0 != null && WorkSpec..ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater0, this, function10, AbstractChannelKt.HANDLER_INVOKED)) {
            function10.invoke(closed0.closeCause);
        }
    }

    private final void invokeOnCloseHandler(Throwable throwable0) {
        Object object0 = this.onCloseHandler;
        if(object0 != null && object0 != AbstractChannelKt.HANDLER_INVOKED && WorkSpec..ExternalSyntheticBackport0.m(AbstractSendChannel.onCloseHandler$FU, this, object0, AbstractChannelKt.HANDLER_INVOKED)) {
            ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(object0, 1)).invoke(throwable0);
        }
    }

    protected abstract boolean isBufferAlwaysFull();

    protected abstract boolean isBufferFull();

    @Override  // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this.getClosedForSend() != null;
    }

    // 去混淆评级： 低(20)
    private final boolean isFullImpl() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && this.isBufferFull();
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean offer(Object object0) {
        try {
            return DefaultImpls.offer(this, object0);
        }
        catch(Throwable throwable0) {
            Function1 function10 = this.onUndeliveredElement;
            if(function10 != null) {
                UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function10, object0, null, 2, null);
                if(undeliveredElementException0 != null) {
                    ExceptionsKt.addSuppressed(undeliveredElementException0, throwable0);
                    throw undeliveredElementException0;
                }
            }
            throw throwable0;
        }
    }

    protected Object offerInternal(Object object0) {
        ReceiveOrClosed receiveOrClosed0;
        do {
            receiveOrClosed0 = this.takeFirstReceiveOrPeekClosed();
            if(receiveOrClosed0 == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
        }
        while(receiveOrClosed0.tryResumeReceive(object0, null) == null);
        receiveOrClosed0.completeResumeReceive(object0);
        return receiveOrClosed0.getOfferResult();
    }

    protected Object offerSelectInternal(Object object0, SelectInstance selectInstance0) {
        TryOfferDesc abstractSendChannel$TryOfferDesc0 = this.describeTryOffer(object0);
        Object object1 = selectInstance0.performAtomicTrySelect(abstractSendChannel$TryOfferDesc0);
        if(object1 != null) {
            return object1;
        }
        ReceiveOrClosed receiveOrClosed0 = (ReceiveOrClosed)abstractSendChannel$TryOfferDesc0.getResult();
        receiveOrClosed0.completeResumeReceive(object0);
        return receiveOrClosed0.getOfferResult();
    }

    protected void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode0) {
    }

    // 检测为 Lambda 实现
    private final void registerSelectSend(SelectInstance selectInstance0, Object object0, Function2 function20) [...]

    @Override  // kotlinx.coroutines.channels.SendChannel
    public final Object send(Object object0, Continuation continuation0) {
        if(this.offerInternal(object0) == AbstractChannelKt.OFFER_SUCCESS) {
            return Unit.INSTANCE;
        }
        Object object1 = this.sendSuspend(object0, continuation0);
        return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : Unit.INSTANCE;
    }

    protected final ReceiveOrClosed sendBuffered(Object object0) {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue;
        LockFreeLinkedListNode lockFreeLinkedListNode1 = new SendBuffered(object0);
        do {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode0.getPrevNode();
            if(lockFreeLinkedListNode2 instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed)lockFreeLinkedListNode2;
            }
        }
        while(!lockFreeLinkedListNode2.addNext(lockFreeLinkedListNode1, lockFreeLinkedListNode0));
        return null;
    }

    private final Object sendSuspend(Object object0, Continuation continuation0) {
        Object object2;
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation0));
        do {
            if(this.isFullImpl()) {
                SendElement sendElement0 = this.onUndeliveredElement == null ? new SendElement(object0, cancellableContinuationImpl0) : new SendElementWithUndeliveredHandler(object0, cancellableContinuationImpl0, this.onUndeliveredElement);
                Object object1 = this.enqueueSend(sendElement0);
                if(object1 == null) {
                    CancellableContinuationKt.removeOnCancellation(cancellableContinuationImpl0, sendElement0);
                    goto label_22;
                }
                if(object1 instanceof Closed) {
                    this.helpCloseAndResumeWithSendException(cancellableContinuationImpl0, object0, ((Closed)object1));
                    goto label_22;
                }
                if(object1 != AbstractChannelKt.ENQUEUE_FAILED && !(object1 instanceof Receive)) {
                    throw new IllegalStateException((UnityPlayerActivity.adjustValue("0B1E1C140B1402361700144D130B1512171C0B144D") + object1).toString());
                }
            }
            object2 = this.offerInternal(object0);
            if(object2 == AbstractChannelKt.OFFER_SUCCESS) {
                cancellableContinuationImpl0.resumeWith(Unit.INSTANCE);
                goto label_22;
            }
        }
        while(object2 == AbstractChannelKt.OFFER_FAILED);
        if(!(object2 instanceof Closed)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("01160B041C280911171C1E0C0D4E130211071C1E08054E") + object2).toString());
        }
        this.helpCloseAndResumeWithSendException(cancellableContinuationImpl0, object0, ((Closed)object2));
    label_22:
        Object object3 = cancellableContinuationImpl0.getResult();
        if(object3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation0);
        }
        return object3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object3 : Unit.INSTANCE;
    }

    protected ReceiveOrClosed takeFirstReceiveOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue;
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = (LockFreeLinkedListNode)lockFreeLinkedListNode0.getNext();
            if(lockFreeLinkedListNode1 == lockFreeLinkedListNode0 || !(lockFreeLinkedListNode1 instanceof ReceiveOrClosed)) {
                break;
            }
            if(!(((ReceiveOrClosed)lockFreeLinkedListNode1) instanceof Closed) || lockFreeLinkedListNode1.isRemoved()) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode1.removeOrNext();
                if(lockFreeLinkedListNode2 == null) {
                    return (ReceiveOrClosed)lockFreeLinkedListNode1;
                }
                lockFreeLinkedListNode2.helpRemovePrev();
                continue;
            }
            return (ReceiveOrClosed)lockFreeLinkedListNode1;
        }
        return null;
    }

    protected final Send takeFirstSendOrPeekClosed() {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.queue;
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = (LockFreeLinkedListNode)lockFreeLinkedListNode0.getNext();
            if(lockFreeLinkedListNode1 == lockFreeLinkedListNode0 || !(lockFreeLinkedListNode1 instanceof Send)) {
                break;
            }
            if(!(((Send)lockFreeLinkedListNode1) instanceof Closed) || lockFreeLinkedListNode1.isRemoved()) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode1.removeOrNext();
                if(lockFreeLinkedListNode2 == null) {
                    return (Send)lockFreeLinkedListNode1;
                }
                lockFreeLinkedListNode2.helpRemovePrev();
                continue;
            }
            return (Send)lockFreeLinkedListNode1;
        }
        return null;
    }

    @Override
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '{' + this.getQueueDebugStateString() + '}' + this.getBufferDebugString();
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public final Object trySend-JP2dKIU(Object object0) {
        Object object1 = this.offerInternal(object0);
        if(object1 == AbstractChannelKt.OFFER_SUCCESS) {
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        if(object1 == AbstractChannelKt.OFFER_FAILED) {
            Closed closed0 = this.getClosedForSend();
            if(closed0 == null) {
                return ChannelResult.Companion.failure-PtdJZtk();
            }
            Throwable throwable0 = this.helpCloseAndGetSendException(closed0);
            return ChannelResult.Companion.closed-JP2dKIU(throwable0);
        }
        if(!(object1 instanceof Closed)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("1A0214320B0F0345000B04181300040345") + object1).toString());
        }
        Throwable throwable1 = this.helpCloseAndGetSendException(((Closed)object1));
        return ChannelResult.Companion.closed-JP2dKIU(throwable1);
    }
}

