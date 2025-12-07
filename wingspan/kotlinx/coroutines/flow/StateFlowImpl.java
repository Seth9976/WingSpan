package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001A\u00020\b2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001B\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00028\u0000H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001A\u0010\u001BJ-\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020\r2\u0006\u0010\u0018\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b&\u0010\'J!\u0010*\u001A\u00020\r2\b\u0010(\u001A\u0004\u0018\u00010\u00022\u0006\u0010)\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b*\u0010\u000FR\u001A\u0010.\u001A\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010-R\u0016\u0010/\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0018\u001A\u00028\u00008V@VX\u0096\u000E\u00A2\u0006\u0012\u0012\u0004\b4\u0010%\u001A\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class StateFlowImpl extends AbstractSharedFlow implements CancellableFlow, MutableStateFlow, FusibleFlow {
    private volatile Object _state;
    private int sequence;

    public StateFlowImpl(Object object0) {
        this._state = object0;
    }

    @Override  // kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.SharedFlow
    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
        Object object2;
        Job job0;
        FlowCollector flowCollector1;
        StateFlowSlot stateFlowSlot1;
        StateFlowImpl stateFlowImpl0;
        kotlinx.coroutines.flow.StateFlowImpl.collect.1 stateFlowImpl$collect$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.StateFlowImpl.collect.1) {
            stateFlowImpl$collect$10 = (kotlinx.coroutines.flow.StateFlowImpl.collect.1)continuation0;
            if((stateFlowImpl$collect$10.label & 0x80000000) == 0) {
                stateFlowImpl$collect$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.collect(null, this);
                    }
                };
            }
            else {
                stateFlowImpl$collect$10.label ^= 0x80000000;
            }
        }
        else {
            stateFlowImpl$collect$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.collect(null, this);
                }
            };
        }
        Object object0 = stateFlowImpl$collect$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(stateFlowImpl$collect$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                StateFlowSlot stateFlowSlot0 = (StateFlowSlot)this.allocateSlot();
                try {
                    if(flowCollector0 instanceof SubscribedFlowCollector) {
                        stateFlowImpl$collect$10.L$0 = this;
                        stateFlowImpl$collect$10.L$1 = flowCollector0;
                        stateFlowImpl$collect$10.L$2 = stateFlowSlot0;
                        stateFlowImpl$collect$10.label = 1;
                        if(((SubscribedFlowCollector)flowCollector0).onSubscription(stateFlowImpl$collect$10) == object1) {
                            return object1;
                        }
                    }
                    stateFlowImpl0 = this;
                    stateFlowSlot1 = stateFlowSlot0;
                    flowCollector1 = flowCollector0;
                    job0 = (Job)stateFlowImpl$collect$10.getContext().get(Job.Key);
                    object2 = null;
                    goto label_49;
                }
                catch(Throwable throwable0) {
                    stateFlowImpl0 = this;
                    stateFlowSlot1 = stateFlowSlot0;
                    break;
                }
            }
            case 1: {
                stateFlowSlot1 = (StateFlowSlot)stateFlowImpl$collect$10.L$2;
                flowCollector0 = (FlowCollector)stateFlowImpl$collect$10.L$1;
                stateFlowImpl0 = (StateFlowImpl)stateFlowImpl$collect$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    flowCollector1 = flowCollector0;
                    job0 = (Job)stateFlowImpl$collect$10.getContext().get(Job.Key);
                    object2 = null;
                    goto label_49;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                object2 = stateFlowImpl$collect$10.L$4;
                job0 = (Job)stateFlowImpl$collect$10.L$3;
                stateFlowSlot1 = (StateFlowSlot)stateFlowImpl$collect$10.L$2;
                flowCollector1 = (FlowCollector)stateFlowImpl$collect$10.L$1;
                stateFlowImpl0 = (StateFlowImpl)stateFlowImpl$collect$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    goto label_62;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 3: {
                object2 = stateFlowImpl$collect$10.L$4;
                job0 = (Job)stateFlowImpl$collect$10.L$3;
                stateFlowSlot1 = (StateFlowSlot)stateFlowImpl$collect$10.L$2;
                flowCollector1 = (FlowCollector)stateFlowImpl$collect$10.L$1;
                stateFlowImpl0 = (StateFlowImpl)stateFlowImpl$collect$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    do {
                        do {
                        label_49:
                            Object object3 = stateFlowImpl0._state;
                            if(job0 != null) {
                                JobKt.ensureActive(job0);
                            }
                            if(object2 == null || !Intrinsics.areEqual(object2, object3)) {
                                stateFlowImpl$collect$10.L$0 = stateFlowImpl0;
                                stateFlowImpl$collect$10.L$1 = flowCollector1;
                                stateFlowImpl$collect$10.L$2 = stateFlowSlot1;
                                stateFlowImpl$collect$10.L$3 = job0;
                                stateFlowImpl$collect$10.L$4 = object3;
                                stateFlowImpl$collect$10.label = 2;
                                if(flowCollector1.emit((object3 == NullSurrogateKt.NULL ? null : object3), stateFlowImpl$collect$10) == object1) {
                                    return object1;
                                }
                                object2 = object3;
                            }
                        label_62:
                        }
                        while(stateFlowSlot1.takePending());
                        stateFlowImpl$collect$10.L$0 = stateFlowImpl0;
                        stateFlowImpl$collect$10.L$1 = flowCollector1;
                        stateFlowImpl$collect$10.L$2 = stateFlowSlot1;
                        stateFlowImpl$collect$10.L$3 = job0;
                        stateFlowImpl$collect$10.L$4 = object2;
                        stateFlowImpl$collect$10.label = 3;
                    }
                    while(stateFlowSlot1.awaitPending(stateFlowImpl$collect$10) != object1);
                    return object1;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
            }
        }
        stateFlowImpl0.freeSlot(stateFlowSlot1);
        throw throwable0;
    }

    @Override  // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(Object object0, Object object1) {
        if(object0 == null) {
            object0 = NullSurrogateKt.NULL;
        }
        if(object1 == null) {
            object1 = NullSurrogateKt.NULL;
        }
        return this.updateState(object0, object1);
    }

    protected StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot createSlot() {
        return this.createSlot();
    }

    protected StateFlowSlot[] createSlotArray(int v) {
        return new StateFlowSlot[v];
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot[] createSlotArray(int v) {
        return this.createSlotArray(v);
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public Object emit(Object object0, Continuation continuation0) {
        this.setValue(object0);
        return Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow fuse(CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.SharedFlow
    public List getReplayCache() {
        return CollectionsKt.listOf(this.getValue());
    }

    @Override  // kotlinx.coroutines.flow.MutableStateFlow
    public Object getValue() {
        return this._state == NullSurrogateKt.NULL ? null : this._state;
    }

    public static void getValue$annotations() {
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("230519000C0D0236060F040827020E104B000B0308153C0417091317330C020604470C014E1E02154E12121502010219040A"));
    }

    @Override  // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(Object object0) {
        if(object0 == null) {
            object0 = NullSurrogateKt.NULL;
        }
        this.updateState(null, object0);
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(Object object0) {
        this.setValue(object0);
        return true;
    }

    private final boolean updateState(Object object0, Object object1) {
        AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot1;
        int v4;
        AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot;
        int v1;
        int v;
        synchronized(this) {
            Object object2 = this._state;
            if(object0 == null || Intrinsics.areEqual(object2, object0)) {
                if(!Intrinsics.areEqual(object2, object1)) {
                    this._state = object1;
                    v = this.sequence;
                    if((v & 1) == 0) {
                        v1 = v + 1;
                        this.sequence = v1;
                        arr_abstractSharedFlowSlot = this.getSlots();
                        goto label_10;
                    }
                    this.sequence = v + 2;
                    return true;
                }
                return true;
            }
            return false;
        }
    label_10:
        while(true) {
            StateFlowSlot[] arr_stateFlowSlot = (StateFlowSlot[])arr_abstractSharedFlowSlot;
            if(arr_stateFlowSlot != null) {
                int v2 = arr_stateFlowSlot.length;
                for(int v3 = 0; v3 < v2; ++v3) {
                    StateFlowSlot stateFlowSlot0 = arr_stateFlowSlot[v3];
                    if(stateFlowSlot0 != null) {
                        stateFlowSlot0.makePending();
                    }
                }
            }
            synchronized(this) {
                v4 = this.sequence;
                if(v4 == v1) {
                    this.sequence = v1 + 1;
                    return true;
                }
                goto label_27;
            }
            return true;
        label_27:
            arr_abstractSharedFlowSlot1 = this.getSlots();
            arr_abstractSharedFlowSlot = arr_abstractSharedFlowSlot1;
            v1 = v4;
        }
        this.sequence = v + 2;
        return true;
    }
}

