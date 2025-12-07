package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BU\u0012-\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000Fø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0014R:\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class CallbackFlowBuilder extends ChannelFlowBuilder {
    private final Function2 block;

    public CallbackFlowBuilder(Function2 function20, CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        super(function20, coroutineContext0, v, bufferOverflow0);
        this.block = function20;
    }

    public CallbackFlowBuilder(Function2 function20, CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            coroutineContext0 = EmptyCoroutineContext.INSTANCE;
        }
        if((v1 & 4) != 0) {
            v = -2;
        }
        if((v1 & 8) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(function20, coroutineContext0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.ChannelFlowBuilder
    protected Object collectTo(ProducerScope producerScope0, Continuation continuation0) {
        kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1 callbackFlowBuilder$collectTo$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1) {
            callbackFlowBuilder$collectTo$10 = (kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1)continuation0;
            if((callbackFlowBuilder$collectTo$10.label & 0x80000000) == 0) {
                callbackFlowBuilder$collectTo$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.collectTo(null, this);
                    }
                };
            }
            else {
                callbackFlowBuilder$collectTo$10.label ^= 0x80000000;
            }
        }
        else {
            callbackFlowBuilder$collectTo$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.collectTo(null, this);
                }
            };
        }
        Object object0 = callbackFlowBuilder$collectTo$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(callbackFlowBuilder$collectTo$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                callbackFlowBuilder$collectTo$10.L$0 = producerScope0;
                callbackFlowBuilder$collectTo$10.label = 1;
                if(super.collectTo(producerScope0, callbackFlowBuilder$collectTo$10) == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                producerScope0 = (ProducerScope)callbackFlowBuilder$collectTo$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
            }
        }
        if(!producerScope0.isClosedForSend()) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("49111A00071524091D1D154D1A4E180810002D11010D0C00040E3D1C3C04121A0409000040130C0F0D040B4D5B4E0D4A411D0908101E0A500F044E141400164E1903411A0902451700144D0E084104041E02120C0205270B0A054E12010E0D0A496F3D1A180813190814005E4E114D020F0D0B07130D1B420D071213001C0B024D0C0F184709170F1B4D0800410404010B5002074E041F11171C1E0C0D4E02060B110B1C01001A08080B5C642308044E0206091E0C110E0A280D0812522F2024410A0E04101F0B1E19001A08080B52081F1F411A090245160B040C08021249"));
        }
        return Unit.INSTANCE;
    }

    @Override  // kotlinx.coroutines.flow.ChannelFlowBuilder
    protected ChannelFlow create(CoroutineContext coroutineContext0, int v, BufferOverflow bufferOverflow0) {
        return new CallbackFlowBuilder(this.block, coroutineContext0, v, bufferOverflow0);
    }
}

