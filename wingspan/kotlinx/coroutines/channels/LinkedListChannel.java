package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\'\u0012 \u0010\u0003\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u00002\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001A\u00020\u00052\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\n\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u001BH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\b\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\nR\u0014\u0010\u000B\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nR\u0014\u0010\f\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\nR\u0014\u0010\r\u001A\u00020\t8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\n\u0082\u0002\u000B\n\u0002\b\u0019\n\u0005\b¡\u001E0\u0001¨\u0006\u001E"}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class LinkedListChannel extends AbstractChannel {
    public LinkedListChannel(Function1 function10) {
        super(function10);
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return true;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(Object object0) {
        Object object1;
        while(true) {
            object1 = super.offerInternal(object0);
            if(object1 == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if(object1 != AbstractChannelKt.OFFER_FAILED) {
                break;
            }
            ReceiveOrClosed receiveOrClosed0 = this.sendBuffered(object0);
            if(receiveOrClosed0 == null) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if(receiveOrClosed0 instanceof Closed) {
                return receiveOrClosed0;
            }
        }
        if(!(object1 instanceof Closed)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B00020803451D08160813270F130000001101411C0414101E1A50") + object1).toString());
        }
        return object1;
    }

    @Override  // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerSelectInternal(Object object0, SelectInstance selectInstance0) {
        Symbol symbol0;
        do {
            if(this.getHasReceiveOrClosed()) {
                symbol0 = super.offerSelectInternal(object0, selectInstance0);
            }
            else {
                Symbol symbol1 = selectInstance0.performAtomicTrySelect(this.describeSendBuffered(object0));
                symbol0 = symbol1 == null ? AbstractChannelKt.OFFER_SUCCESS : symbol1;
            }
            if(symbol0 == SelectKt.getALREADY_SELECTED()) {
                return SelectKt.getALREADY_SELECTED();
            }
            if(symbol0 == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        }
        while(symbol0 == AbstractChannelKt.OFFER_FAILED || symbol0 == AtomicKt.RETRY_ATOMIC);
        if(!(symbol0 instanceof Closed)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345000B03180D1A41") + symbol0).toString());
        }
        return symbol0;
    }

    @Override  // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotentList-w-w6eGU(Object object0, Closed closed0) {
        Throwable throwable0 = null;
        if(object0 != null) {
            if(object0 instanceof ArrayList) {
                if(object0 == null) {
                    throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F12111B025E2C131C001E291B1D0451244E0E01451901040108001949061D1C1F1815070F02165C071E19041C0F06095C271E010800042B0C011A4E1641050E13091B005E0E0E020D020606071F031240351E15172F1C04001D04142E0640311F130F182B0C011A4C28410107470E1D1A1C040F164F040A00010519080004144B1B0004081300000B4B3B001C040F0B2D0E1606505010"));
                }
                int v = ((ArrayList)object0).size() - 1;
                Throwable throwable1 = null;
                while(-1 < v) {
                    Send send0 = (Send)((ArrayList)object0).get(v);
                    if(send0 instanceof SendBuffered) {
                        Function1 function11 = this.onUndeliveredElement;
                        throwable1 = function11 == null ? null : OnUndeliveredElementKt.callUndeliveredElementCatchingException(function11, ((SendBuffered)send0).element, ((UndeliveredElementException)throwable1));
                    }
                    else {
                        send0.resumeSendClosed(closed0);
                    }
                    --v;
                }
                throwable0 = throwable1;
            }
            else if(((Send)object0) instanceof SendBuffered) {
                Function1 function10 = this.onUndeliveredElement;
                if(function10 != null) {
                    throwable0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function10, ((SendBuffered)(((Send)object0))).element, null);
                }
            }
            else {
                ((Send)object0).resumeSendClosed(closed0);
            }
        }
        if(throwable0 != null) {
            throw throwable0;
        }
    }
}

