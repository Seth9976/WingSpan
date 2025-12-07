package kotlinx.coroutines.channels;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\b\u0007\u0018\u0000 B*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000G:\u0004CBDEB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00028\u0000\u00A2\u0006\u0004\b\u0003\u0010\u0004B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0005J?\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\u0014\u0010\b\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0017\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u000F\u001A\u00020\u00132\u000E\u0010\r\u001A\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0014J\u0019\u0010\u0015\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0010J\u001D\u0010\u0016\u001A\u00020\u00132\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001B\u001A\u00020\u00132\u0018\u0010\u001A\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00130\u0018j\u0002`\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001D\u001A\u00020\u00132\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0019\u0010!\u001A\u0004\u0018\u00010 2\u0006\u0010\u001F\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000#H\u0016\u00A2\u0006\u0004\b$\u0010%JX\u0010.\u001A\u00020\u0013\"\u0004\b\u0001\u0010&2\f\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\'2\u0006\u0010\u001F\u001A\u00028\u00002(\u0010-\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+\u0012\u0006\u0012\u0004\u0018\u00010,0)H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0004\b.\u0010/J?\u00100\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0018\u00010\u00062\u0012\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002\u00A2\u0006\u0004\b0\u0010\u000BJ\u001B\u00101\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00028\u0000H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b1\u00102J&\u00106\u001A\b\u0012\u0004\u0012\u00020\u0013032\u0006\u0010\u001F\u001A\u00028\u0000H\u0016\u00F8\u0001\u0000\u00F8\u0001\u0001\u00F8\u0001\u0002\u00A2\u0006\u0004\b4\u00105R\u0014\u00107\u001A\u00020\u000E8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b7\u00108R&\u0010<\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*098VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b:\u0010;R\u0017\u0010\u0002\u001A\u00028\u00008F\u00A2\u0006\f\u0012\u0004\b?\u0010\u0005\u001A\u0004\b=\u0010>R\u0013\u0010A\u001A\u0004\u0018\u00018\u00008F\u00A2\u0006\u0006\u001A\u0004\b@\u0010>\u0082\u0002\u000F\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00A1\u001E0\u0001\u00A8\u0006F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/BroadcastChannel;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class ConflatedBroadcastChannel implements BroadcastChannel {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable throwable0) {
            this.closeCause = throwable0;
        }

        public final Throwable getSendException() {
            Throwable throwable0 = this.closeCause;
            return throwable0 == null ? new ClosedSendChannelException(UnityPlayerActivity.adjustValue("2D180C0F00040B45050F034D02020E140016")) : throwable0;
        }

        public final Throwable getValueException() {
            Throwable throwable0 = this.closeCause;
            return throwable0 == null ? new IllegalStateException(UnityPlayerActivity.adjustValue("2D180C0F00040B45050F034D02020E140016")) : throwable0;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "E", "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class State {
        public final Subscriber[] subscribers;
        public final Object value;

        public State(Object object0, Subscriber[] arr_conflatedBroadcastChannel$Subscriber) {
            this.value = object0;
            this.subscribers = arr_conflatedBroadcastChannel$Subscriber;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\nJ\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0014R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "onCancelIdempotent", "", "wasClosed", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class Subscriber extends ConflatedChannel implements ReceiveChannel {
        private final ConflatedBroadcastChannel broadcastChannel;

        public Subscriber(ConflatedBroadcastChannel conflatedBroadcastChannel0) {
            super(null);
            this.broadcastChannel = conflatedBroadcastChannel0;
        }

        @Override  // kotlinx.coroutines.channels.ConflatedChannel
        public Object offerInternal(Object object0) {
            return super.offerInternal(object0);
        }

        @Override  // kotlinx.coroutines.channels.ConflatedChannel
        protected void onCancelIdempotent(boolean z) {
            if(z) {
                this.broadcastChannel.closeSubscriber(this);
            }
        }
    }

    @Deprecated
    private static final Closed CLOSED;
    private static final Companion Companion;
    @Deprecated
    private static final State INITIAL_STATE;
    @Deprecated
    private static final Symbol UNDEFINED;
    private volatile Object _state;
    private static final AtomicReferenceFieldUpdater _state$FU;
    private volatile int _updating;
    private static final AtomicIntegerFieldUpdater _updating$FU;
    private volatile Object onCloseHandler;
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU;

    static {
        ConflatedBroadcastChannel.Companion = new Companion(null);
        ConflatedBroadcastChannel.CLOSED = new Closed(null);
        Symbol symbol0 = new Symbol(UnityPlayerActivity.adjustValue("3B3E29242828292036"));
        ConflatedBroadcastChannel.UNDEFINED = symbol0;
        ConflatedBroadcastChannel.INITIAL_STATE = new State(symbol0, null);
        String s = UnityPlayerActivity.adjustValue("310319001A04");
        ConflatedBroadcastChannel._state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, s);
        String s1 = UnityPlayerActivity.adjustValue("31051D050F150E0B15");
        ConflatedBroadcastChannel._updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, s1);
        String s2 = UnityPlayerActivity.adjustValue("011E2E0D0112022D13001401041C");
        ConflatedBroadcastChannel.onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, s2);
    }

    public ConflatedBroadcastChannel() {
        this._state = ConflatedBroadcastChannel.INITIAL_STATE;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    public ConflatedBroadcastChannel(Object object0) {
        State conflatedBroadcastChannel$State0 = new State(object0, null);
        ConflatedBroadcastChannel._state$FU.lazySet(this, conflatedBroadcastChannel$State0);
    }

    private final Subscriber[] addSubscriber(Subscriber[] arr_conflatedBroadcastChannel$Subscriber, Subscriber conflatedBroadcastChannel$Subscriber0) {
        return arr_conflatedBroadcastChannel$Subscriber == null ? new Subscriber[]{conflatedBroadcastChannel$Subscriber0} : ((Subscriber[])ArraysKt.plus(arr_conflatedBroadcastChannel$Subscriber, conflatedBroadcastChannel$Subscriber0));
    }

    @Override  // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException0) {
        this.close(cancellationException0);
    }

    @Override  // kotlinx.coroutines.channels.BroadcastChannel
    @kotlin.Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public boolean cancel(Throwable throwable0) {
        return this.close(throwable0);
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable throwable0) {
        Object object0;
        while(true) {
            object0 = this._state;
            if(object0 instanceof Closed) {
                return false;
            }
            if(!(object0 instanceof State)) {
                break;
            }
            Closed conflatedBroadcastChannel$Closed0 = throwable0 == null ? ConflatedBroadcastChannel.CLOSED : new Closed(throwable0);
            if(WorkSpec..ExternalSyntheticBackport0.m(ConflatedBroadcastChannel._state$FU, this, object0, conflatedBroadcastChannel$Closed0)) {
                Subscriber[] arr_conflatedBroadcastChannel$Subscriber = ((State)object0).subscribers;
                if(arr_conflatedBroadcastChannel$Subscriber != null) {
                    for(int v = 0; v < arr_conflatedBroadcastChannel$Subscriber.length; ++v) {
                        arr_conflatedBroadcastChannel$Subscriber[v].close(throwable0);
                    }
                }
                this.invokeOnCloseHandler(throwable0);
                return true;
            }
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345011A1119044E") + object0).toString());
    }

    private final void closeSubscriber(Subscriber conflatedBroadcastChannel$Subscriber0) {
        Object object0;
        while(true) {
            object0 = this._state;
            if(object0 instanceof Closed) {
                return;
            }
            if(!(object0 instanceof State)) {
                break;
            }
            Intrinsics.checkNotNull(((State)object0).subscribers);
            Subscriber[] arr_conflatedBroadcastChannel$Subscriber = this.removeSubscriber(((State)object0).subscribers, conflatedBroadcastChannel$Subscriber0);
            State conflatedBroadcastChannel$State0 = new State(((State)object0).value, arr_conflatedBroadcastChannel$Subscriber);
            if(WorkSpec..ExternalSyntheticBackport0.m(ConflatedBroadcastChannel._state$FU, this, object0, conflatedBroadcastChannel$State0)) {
                return;
            }
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345011A1119044E") + object0).toString());
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 getOnSend() {
        return (SelectInstance selectInstance0, Object object0, Function2 function20) -> {
            if(!selectInstance0.trySelect()) {
                return;
            }
            Closed conflatedBroadcastChannel$Closed0 = ConflatedBroadcastChannel.this.offerInternal(object0);
            if(conflatedBroadcastChannel$Closed0 != null) {
                selectInstance0.resumeSelectWithException(conflatedBroadcastChannel$Closed0.getSendException());
                return;
            }
            UndispatchedKt.startCoroutineUnintercepted(function20, ConflatedBroadcastChannel.this, selectInstance0.getCompletion());
        };

        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JV\u0010\u0003\u001A\u00020\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001A\u00028\u00002(\u0010\t\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000E"}, d2 = {"kotlinx/coroutines/channels/ConflatedBroadcastChannel$onSend$1", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "registerSelectClause2", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
        public final class kotlinx.coroutines.channels.ConflatedBroadcastChannel.onSend.1 implements SelectClause2 {
            kotlinx.coroutines.channels.ConflatedBroadcastChannel.onSend.1(ConflatedBroadcastChannel conflatedBroadcastChannel0) {
            }

            @Override  // kotlinx.coroutines.selects.SelectClause2
            public void registerSelectClause2(SelectInstance selectInstance0, Object object0, Function2 function20) {
                ConflatedBroadcastChannel.this.registerSelectSend(selectInstance0, object0, function20);
            }
        }

    }

    public final Object getValue() {
        Object object0 = this._state;
        if(object0 instanceof Closed) {
            throw ((Closed)object0).getValueException();
        }
        if(!(object0 instanceof State)) {
            throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345011A1119044E") + object0).toString());
        }
        if(((State)object0).value == ConflatedBroadcastChannel.UNDEFINED) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("201F4D170F0D1200"));
        }
        return ((State)object0).value;
    }

    public static void getValue$annotations() {
    }

    public final Object getValueOrNull() {
        Object object0 = this._state;
        if(!(object0 instanceof Closed)) {
            if(!(object0 instanceof State)) {
                throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345011A1119044E") + object0).toString());
            }
            Object object1 = ((State)object0).value;
            return object1 == ConflatedBroadcastChannel.UNDEFINED ? null : object1;
        }
        return null;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 function10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = ConflatedBroadcastChannel.onCloseHandler$FU;
        if(!WorkSpec..ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater0, this, null, function10)) {
            Object object0 = this.onCloseHandler;
            throw object0 == AbstractChannelKt.HANDLER_INVOKED ? new IllegalStateException(UnityPlayerActivity.adjustValue("2F1E0215060415451A0F1E090D0B134712131D500C0D1C0406010B4E02080607121300000B144D0000054716070D1308121D0712091E1750040F180E0C0016")) : new IllegalStateException(UnityPlayerActivity.adjustValue("2F1E0215060415451A0F1E090D0B134712131D500C0D1C0406010B4E02080607121300000B145741") + object0);
        }
        Object object1 = this._state;
        if(object1 instanceof Closed && WorkSpec..ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater0, this, function10, AbstractChannelKt.HANDLER_INVOKED)) {
            function10.invoke(((Closed)object1).closeCause);
        }
    }

    private final void invokeOnCloseHandler(Throwable throwable0) {
        Object object0 = this.onCloseHandler;
        if(object0 != null && object0 != AbstractChannelKt.HANDLER_INVOKED && WorkSpec..ExternalSyntheticBackport0.m(ConflatedBroadcastChannel.onCloseHandler$FU, this, object0, AbstractChannelKt.HANDLER_INVOKED)) {
            ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(object0, 1)).invoke(throwable0);
        }
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    @kotlin.Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of \'trySend\' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(Object object0) {
        return DefaultImpls.offer(this, object0);
    }

    private final Closed offerInternal(Object object0) {
        Object object1;
        if(!ConflatedBroadcastChannel._updating$FU.compareAndSet(this, 0, 1)) {
            return null;
        }
        try {
            do {
                object1 = this._state;
                if(object1 instanceof Closed) {
                    this._updating = 0;
                    return (Closed)object1;
                }
                if(!(object1 instanceof State)) {
                    throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345011A1119044E") + object1).toString());
                }
                State conflatedBroadcastChannel$State0 = new State(object0, ((State)object1).subscribers);
            }
            while(!WorkSpec..ExternalSyntheticBackport0.m(ConflatedBroadcastChannel._state$FU, this, object1, conflatedBroadcastChannel$State0));
            Subscriber[] arr_conflatedBroadcastChannel$Subscriber = ((State)object1).subscribers;
            if(arr_conflatedBroadcastChannel$Subscriber != null) {
                for(int v = 0; v < arr_conflatedBroadcastChannel$Subscriber.length; ++v) {
                    arr_conflatedBroadcastChannel$Subscriber[v].offerInternal(object0);
                }
            }
            this._updating = 0;
            return null;
        }
        catch(Throwable throwable0) {
            this._updating = 0;
            throw throwable0;
        }
    }

    @Override  // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel openSubscription() {
        Object object0;
        Subscriber conflatedBroadcastChannel$Subscriber0 = new Subscriber(this);
        while(true) {
            object0 = this._state;
            if(object0 instanceof Closed) {
                conflatedBroadcastChannel$Subscriber0.close(((Closed)object0).closeCause);
                return conflatedBroadcastChannel$Subscriber0;
            }
            if(!(object0 instanceof State)) {
                break;
            }
            if(((State)object0).value != ConflatedBroadcastChannel.UNDEFINED) {
                conflatedBroadcastChannel$Subscriber0.offerInternal(((State)object0).value);
            }
            Subscriber[] arr_conflatedBroadcastChannel$Subscriber = this.addSubscriber(((State)object0).subscribers, conflatedBroadcastChannel$Subscriber0);
            State conflatedBroadcastChannel$State0 = new State(((State)object0).value, arr_conflatedBroadcastChannel$Subscriber);
            if(WorkSpec..ExternalSyntheticBackport0.m(ConflatedBroadcastChannel._state$FU, this, object0, conflatedBroadcastChannel$State0)) {
                return conflatedBroadcastChannel$Subscriber0;
            }
        }
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271E1B0002080345011A1119044E") + object0).toString());
    }

    // 检测为 Lambda 实现
    private final void registerSelectSend(SelectInstance selectInstance0, Object object0, Function2 function20) [...]

    private final Subscriber[] removeSubscriber(Subscriber[] arr_conflatedBroadcastChannel$Subscriber, Subscriber conflatedBroadcastChannel$Subscriber0) {
        int v = ArraysKt.indexOf(arr_conflatedBroadcastChannel$Subscriber, conflatedBroadcastChannel$Subscriber0);
        if(arr_conflatedBroadcastChannel$Subscriber.length == 1) {
            return null;
        }
        Subscriber[] arr_conflatedBroadcastChannel$Subscriber1 = new Subscriber[arr_conflatedBroadcastChannel$Subscriber.length - 1];
        ArraysKt.copyInto$default(arr_conflatedBroadcastChannel$Subscriber, arr_conflatedBroadcastChannel$Subscriber1, 0, 0, v, 6, null);
        ArraysKt.copyInto$default(arr_conflatedBroadcastChannel$Subscriber, arr_conflatedBroadcastChannel$Subscriber1, v, v + 1, 0, 8, null);
        return arr_conflatedBroadcastChannel$Subscriber1;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public Object send(Object object0, Continuation continuation0) {
        Closed conflatedBroadcastChannel$Closed0 = this.offerInternal(object0);
        if(conflatedBroadcastChannel$Closed0 != null) {
            throw conflatedBroadcastChannel$Closed0.getSendException();
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED() == null ? null : Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public Object trySend-JP2dKIU(Object object0) {
        Closed conflatedBroadcastChannel$Closed0 = this.offerInternal(object0);
        if(conflatedBroadcastChannel$Closed0 != null) {
            Throwable throwable0 = conflatedBroadcastChannel$Closed0.getSendException();
            return ChannelResult.Companion.closed-JP2dKIU(throwable0);
        }
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    }
}

