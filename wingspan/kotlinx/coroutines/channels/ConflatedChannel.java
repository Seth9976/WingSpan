package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\'\u0012 \u0010\u0003\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001A\u00020\r2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0014J\u0015\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001DJ!\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00028\u00002\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\rH\u0014J\n\u0010$\u001A\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001A\u0004\u0018\u00010\u00172\n\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030 H\u0014J\u0014\u0010&\u001A\u0004\u0018\u00010\'2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\b\u001A\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000ER\u0014\u0010\u0011\u001A\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000ER\u0014\u0010\u0012\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u000ER\u0012\u0010\u0013\u001A\u00060\u0014j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", "", "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class ConflatedChannel extends AbstractChannel {
    private final ReentrantLock lock;
    private Object value;

    public ConflatedChannel(Function1 function10) {
        super(function10);
        this.lock = new ReentrantLock();
        this.value = AbstractChannelKt.EMPTY;
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
    protected String getBufferDebugString() {
        String s = UnityPlayerActivity.adjustValue("46060C0D1B045A");
        this.lock.lock();
        String s1 = s + this.value + ')';
        this.lock.unlock();
        return s1;
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
        this.lock.lock();
        boolean z = this.value == AbstractChannelKt.EMPTY;
        this.lock.unlock();
        return z;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
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
        UndeliveredElementException undeliveredElementException0;
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            Closed closed0 = this.getClosedForSend();
            if(closed0 != null) {
                return closed0;
            }
            if(this.value == AbstractChannelKt.EMPTY) {
                ReceiveOrClosed receiveOrClosed0;
                while((receiveOrClosed0 = this.takeFirstReceiveOrPeekClosed()) != null) {
                    if(receiveOrClosed0 instanceof Closed) {
                        return receiveOrClosed0;
                    }
                    Intrinsics.checkNotNull(receiveOrClosed0);
                    if(receiveOrClosed0.tryResumeReceive(object0, null) != null) {
                        receiveOrClosed0.completeResumeReceive(object0);
                        return receiveOrClosed0.getOfferResult();
                    }
                }
            }
            undeliveredElementException0 = this.updateValueLocked(object0);
            if(undeliveredElementException0 == null) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        }
        finally {
            lock0.unlock();
        }
        throw undeliveredElementException0;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(Object object0, SelectInstance selectInstance0) {
        UndeliveredElementException undeliveredElementException0;
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            Closed closed0 = this.getClosedForSend();
            if(closed0 != null) {
                return closed0;
            }
            if(this.value == AbstractChannelKt.EMPTY) {
                while(true) {
                    TryOfferDesc abstractSendChannel$TryOfferDesc0 = this.describeTryOffer(object0);
                    Object object1 = selectInstance0.performAtomicTrySelect(abstractSendChannel$TryOfferDesc0);
                    if(object1 == null) {
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
                        return object1;
                    }
                }
            }
            if(!selectInstance0.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            }
            undeliveredElementException0 = this.updateValueLocked(object0);
            if(undeliveredElementException0 == null) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        }
        finally {
            lock0.unlock();
        }
        throw undeliveredElementException0;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean z) {
        UndeliveredElementException undeliveredElementException0;
        this.lock.lock();
        try {
            undeliveredElementException0 = this.updateValueLocked(AbstractChannelKt.EMPTY);
        }
        finally {
            this.lock.unlock();
        }
        super.onCancelIdempotent(z);
        if(undeliveredElementException0 != null) {
            throw undeliveredElementException0;
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            if(this.value == AbstractChannelKt.EMPTY) {
                Object object0 = this.getClosedForSend();
                if(object0 == null) {
                    object0 = AbstractChannelKt.POLL_FAILED;
                }
                return object0;
            }
            Object object1 = this.value;
            this.value = AbstractChannelKt.EMPTY;
            return object1;
        }
        finally {
            lock0.unlock();
        }
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollSelectInternal(SelectInstance selectInstance0) {
        Lock lock0 = this.lock;
        lock0.lock();
        try {
            if(this.value == AbstractChannelKt.EMPTY) {
                Object object0 = this.getClosedForSend();
                if(object0 == null) {
                    object0 = AbstractChannelKt.POLL_FAILED;
                }
                return object0;
            }
            if(!selectInstance0.trySelect()) {
                return SelectKt.getALREADY_SELECTED();
            }
            Object object1 = this.value;
            this.value = AbstractChannelKt.EMPTY;
            return object1;
        }
        finally {
            lock0.unlock();
        }
    }

    private final UndeliveredElementException updateValueLocked(Object object0) {
        Object object1 = this.value;
        UndeliveredElementException undeliveredElementException0 = null;
        if(object1 != AbstractChannelKt.EMPTY) {
            Function1 function10 = this.onUndeliveredElement;
            if(function10 != null) {
                undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function10, object1, null, 2, null);
            }
        }
        this.value = object0;
        return undeliveredElementException0;
    }
}

