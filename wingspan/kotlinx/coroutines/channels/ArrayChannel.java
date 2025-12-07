package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012 \u0010\t\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0013\u001A\u00020\u00122\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001C\u001A\u00020\u00172\u0006\u0010\r\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ#\u0010 \u001A\u00020\u00172\u0006\u0010\r\u001A\u00028\u00002\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030\u001EH\u0014\u00A2\u0006\u0004\b \u0010!J\u0017\u0010#\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b#\u0010$J\u0011\u0010%\u001A\u0004\u0018\u00010\u0017H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001D\u0010\'\u001A\u0004\u0018\u00010\u00172\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030\u001EH\u0014\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010*\u001A\u0004\u0018\u00010)2\u0006\u0010\f\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b*\u0010+R\u001E\u0010-\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001A\u00020/8TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b0\u00101R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001A\u00020\u00128DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\b5\u00106R\u0014\u00107\u001A\u00020\u00128DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\b7\u00106R\u0014\u00108\u001A\u00020\u00128DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u00106R\u0014\u00109\u001A\u00020\u00128DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\b9\u00106R\u0014\u0010:\u001A\u00020\u00128VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b:\u00106R\u0014\u0010;\u001A\u00020\u00128VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b;\u00106R\u0018\u0010>\u001A\u00060<j\u0002`=8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010@\u00A8\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", "", "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "", "buffer", "[Ljava/lang/Object;", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class ArrayChannel extends AbstractChannel {
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[BufferOverflow.values().length];
            arr_v[BufferOverflow.SUSPEND.ordinal()] = 1;
            arr_v[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            arr_v[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private final BufferOverflow onBufferOverflow;
    private volatile int size;

    public ArrayChannel(int v, BufferOverflow bufferOverflow0, Function1 function10) {
        super(function10);
        this.capacity = v;
        this.onBufferOverflow = bufferOverflow0;
        if(v < 1) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2F021F0017220F041C001501410D001704110704144103141411520C154D001A410B00131D044D5042410510064E") + v + UnityPlayerActivity.adjustValue("4E070C124E12170011071604040A")).toString());
        }
        this.lock = new ReentrantLock();
        Object[] arr_object = new Object[Math.min(v, 8)];
        ArraysKt.fill$default(arr_object, AbstractChannelKt.EMPTY, 0, 0, 6, null);
        this.buffer = arr_object;
        this.size = 0;
    }

    private final void enqueueElement(int v, Object object0) {
        if(v < this.capacity) {
            this.ensureCapacity(v);
            this.buffer[(this.head + v) % this.buffer.length] = object0;
            return;
        }
        Object[] arr_object = this.buffer;
        int v1 = this.head;
        arr_object[v1 % arr_object.length] = null;
        arr_object[(v + v1) % arr_object.length] = object0;
        this.head = (v1 + 1) % arr_object.length;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected boolean enqueueReceiveInternal(Receive receive0) {
        this.lock.lock();
        try {
            return super.enqueueReceiveInternal(receive0);
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object enqueueSend(Send send0) {
        this.lock.lock();
        try {
            return super.enqueueSend(send0);
        }
        finally {
            this.lock.unlock();
        }
    }

    private final void ensureCapacity(int v) {
        Object[] arr_object = this.buffer;
        if(v >= arr_object.length) {
            int v1 = Math.min(arr_object.length * 2, this.capacity);
            Object[] arr_object1 = new Object[v1];
            for(int v2 = 0; v2 < v; ++v2) {
                arr_object1[v2] = this.buffer[(this.head + v2) % this.buffer.length];
            }
            ArraysKt.fill(arr_object1, AbstractChannelKt.EMPTY, v, v1);
            this.buffer = arr_object1;
            this.head = 0;
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return UnityPlayerActivity.adjustValue("461218070804155F110F000C0207151E58") + this.capacity + UnityPlayerActivity.adjustValue("4203041B0B5C") + this.size + ')';
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return this.size == 0;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    public boolean isClosedForReceive() {
        this.lock.lock();
        try {
            return super.isClosedForReceive();
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    public boolean isEmpty() {
        this.lock.lock();
        try {
            return this.isEmptyImpl();
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(Object object0) {
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            int v1 = this.size;
            Closed closed0 = this.getClosedForSend();
            if(closed0 != null) {
                return closed0;
            }
            Symbol symbol0 = this.updateBufferSize(v1);
            if(symbol0 != null) {
                return symbol0;
            }
            if(v1 == 0) {
                ReceiveOrClosed receiveOrClosed0;
                while((receiveOrClosed0 = this.takeFirstReceiveOrPeekClosed()) != null) {
                    if(receiveOrClosed0 instanceof Closed) {
                        this.size = 0;
                        return receiveOrClosed0;
                    }
                    Intrinsics.checkNotNull(receiveOrClosed0);
                    if(receiveOrClosed0.tryResumeReceive(object0, null) != null) {
                        this.size = 0;
                        receiveOrClosed0.completeResumeReceive(object0);
                        return receiveOrClosed0.getOfferResult();
                    }
                }
            }
            this.enqueueElement(v1, object0);
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        finally {
            lock0.unlock();
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(Object object0, SelectInstance selectInstance0) {
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            int v1 = this.size;
            Closed closed0 = this.getClosedForSend();
            if(closed0 != null) {
                return closed0;
            }
            Symbol symbol0 = this.updateBufferSize(v1);
            if(symbol0 != null) {
                return symbol0;
            }
            if(v1 == 0) {
                while(true) {
                    TryOfferDesc abstractSendChannel$TryOfferDesc0 = this.describeTryOffer(object0);
                    Object object1 = selectInstance0.performAtomicTrySelect(abstractSendChannel$TryOfferDesc0);
                    if(object1 == null) {
                        this.size = 0;
                        Object object2 = abstractSendChannel$TryOfferDesc0.getResult();
                        Intrinsics.checkNotNull(object2);
                        ((ReceiveOrClosed)object2).completeResumeReceive(object0);
                        return ((ReceiveOrClosed)object2).getOfferResult();
                    }
                    if(object1 == AbstractChannelKt.OFFER_FAILED) {
                        break;
                    }
                    if(object1 != AtomicKt.RETRY_ATOMIC) {
                        if(object1 != SelectKt.getALREADY_SELECTED() && !(object1 instanceof Closed)) {
                            throw new IllegalStateException((UnityPlayerActivity.adjustValue("1E151F0701130A2406011D04023A131E361702150E1546050216111C190F043A131E2A1408151F484E130211071C1E08054E") + object1).toString());
                        }
                        this.size = 0;
                        return object1;
                    }
                }
            }
            if(!selectInstance0.trySelect()) {
                this.size = v1;
                return SelectKt.getALREADY_SELECTED();
            }
            this.enqueueElement(v1, object0);
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        finally {
            lock0.unlock();
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean z) {
        UndeliveredElementException undeliveredElementException0;
        Function1 function10 = this.onUndeliveredElement;
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            int v1 = this.size;
            undeliveredElementException0 = null;
            for(int v2 = 0; v2 < v1; ++v2) {
                Object object0 = this.buffer[this.head];
                if(function10 != null && object0 != AbstractChannelKt.EMPTY) {
                    undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function10, object0, undeliveredElementException0);
                }
                this.buffer[this.head] = AbstractChannelKt.EMPTY;
                this.head = (this.head + 1) % this.buffer.length;
            }
            this.size = 0;
        }
        finally {
            lock0.unlock();
        }
        super.onCancelIdempotent(z);
        if(undeliveredElementException0 != null) {
            throw undeliveredElementException0;
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        Send send0;
        Object object1;
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            int v1 = this.size;
            if(v1 == 0) {
                Object object0 = this.getClosedForSend();
                if(object0 == null) {
                    object0 = AbstractChannelKt.POLL_FAILED;
                }
                return object0;
            }
            Object[] arr_object = this.buffer;
            int v2 = this.head;
            object1 = arr_object[v2];
            send0 = null;
            arr_object[v2] = null;
            this.size = v1 - 1;
            Symbol symbol0 = AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if(v1 == this.capacity) {
                for(Send send1 = null; true; send1 = send2) {
                    Send send2 = this.takeFirstSendOrPeekClosed();
                    if(send2 == null) {
                        send0 = send1;
                        break;
                    }
                    Intrinsics.checkNotNull(send2);
                    if(send2.tryResumeSend(null) != null) {
                        symbol0 = send2.getPollResult();
                        z = true;
                        send0 = send2;
                        break;
                    }
                    send2.undeliveredElement();
                }
            }
            if(symbol0 != AbstractChannelKt.POLL_FAILED && !(symbol0 instanceof Closed)) {
                this.size = v1;
                this.buffer[(this.head + v1) % this.buffer.length] = symbol0;
            }
            this.head = (this.head + 1) % this.buffer.length;
        }
        finally {
            lock0.unlock();
        }
        if(z) {
            Intrinsics.checkNotNull(send0);
            send0.completeResumeSend();
        }
        return object1;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollSelectInternal(SelectInstance selectInstance0) {
        Symbol symbol0;
        Object object1;
        boolean z;
        Object object2;
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            int v1 = this.size;
            if(v1 == 0) {
                Object object0 = this.getClosedForSend();
                if(object0 == null) {
                    object0 = AbstractChannelKt.POLL_FAILED;
                }
                return object0;
            }
            Object[] arr_object = this.buffer;
            int v2 = this.head;
            object1 = arr_object[v2];
            symbol0 = null;
            arr_object[v2] = null;
            this.size = v1 - 1;
            Symbol symbol1 = AbstractChannelKt.POLL_FAILED;
            if(v1 == this.capacity) {
                do {
                    TryPollDesc abstractChannel$TryPollDesc0 = this.describeTryPoll();
                    object2 = selectInstance0.performAtomicTrySelect(abstractChannel$TryPollDesc0);
                    if(object2 == null) {
                        symbol0 = abstractChannel$TryPollDesc0.getResult();
                        Intrinsics.checkNotNull(symbol0);
                        symbol1 = ((Send)symbol0).getPollResult();
                        z = true;
                        goto label_43;
                    }
                    if(object2 == AbstractChannelKt.POLL_FAILED) {
                        goto label_42;
                    }
                }
                while(object2 == AtomicKt.RETRY_ATOMIC);
                if(object2 == SelectKt.getALREADY_SELECTED()) {
                    this.size = v1;
                    this.buffer[this.head] = object1;
                    return object2;
                }
                if(!(object2 instanceof Closed)) {
                    throw new IllegalStateException((UnityPlayerActivity.adjustValue("1E151F0701130A2406011D04023A131E361702150E1546050216111C190F043A131E2A1408151F484E130211071C1E08054E") + object2).toString());
                }
                z = true;
                symbol1 = object2;
                symbol0 = symbol1;
            }
            else {
            label_42:
                z = false;
            }
        label_43:
            if(symbol1 != AbstractChannelKt.POLL_FAILED && !(symbol1 instanceof Closed)) {
                this.size = v1;
                this.buffer[(this.head + v1) % this.buffer.length] = symbol1;
            }
            else if(!selectInstance0.trySelect()) {
                this.size = v1;
                this.buffer[this.head] = object1;
                return SelectKt.getALREADY_SELECTED();
            }
            this.head = (this.head + 1) % this.buffer.length;
        }
        finally {
            lock0.unlock();
        }
        if(z) {
            Intrinsics.checkNotNull(symbol0);
            ((Send)symbol0).completeResumeSend();
        }
        return object1;
    }

    private final Symbol updateBufferSize(int v) {
        if(v < this.capacity) {
            this.size = v + 1;
            return null;
        }
        switch(WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()]) {
            case 1: {
                return AbstractChannelKt.OFFER_FAILED;
            }
            case 2: {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            case 3: {
                return null;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}

