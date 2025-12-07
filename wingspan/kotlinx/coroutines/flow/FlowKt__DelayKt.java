package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ChannelResult.Failed;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A2\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u001A:\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\b\b\u001A&\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0005H\u0007\u001A3\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001A7\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\b\r\u001A$\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F*\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00052\b\b\u0002\u0010\u0013\u001A\u00020\u0005H\u0000\u001A&\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u0005H\u0007\u001A3\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\n\u0082\u0002\u000B\n\u0002\b\u0019\n\u0005\b¡\u001E0\u0001¨\u0006\u0018"}, d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "Lkotlin/Function1;", "", "timeout", "Lkotlin/time/Duration;", "debounceDuration", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "period", "sample-HG0u8IE", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DelayKt {
    public static final Flow debounce(Flow flow0, long v) {
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2A150F0E1B0F0400521A1900040114134501061F180D0A41090A064E1208410004000406070608").toString());
        }
        return v1 == 0 ? flow0 : FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow0, new Function1(v) {
            final long $timeoutMillis;

            {
                this.$timeoutMillis = v;
                super(1);
            }

            public final Long invoke(Object object0) {
                return this.$timeoutMillis;
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(object0);
            }
        });
    }

    public static final Flow debounce(Flow flow0, Function1 function10) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow0, function10);
    }

    public static final Flow debounce-HG0u8IE(Flow flow0, long v) {
        return FlowKt.debounce(flow0, DelayKt.toDelayMillis-LRDsOJo(v));
    }

    public static final Flow debounceDuration(Flow flow0, Function1 function10) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow0, new Function1(function10) {
            final Function1 $timeout;

            {
                this.$timeout = function10;
                super(1);
            }

            public final Long invoke(Object object0) {
                return DelayKt.toDelayMillis-LRDsOJo(((Duration)this.$timeout.invoke(object0)).unbox-impl());
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(object0);
            }
        });
    }

    private static final Flow debounceInternal$FlowKt__DelayKt(Flow flow0, Function1 function10) {
        return FlowCoroutineKt.scopedFlow(new Function3(function10, flow0, null) {
            final Flow $this_debounceInternal;
            final Function1 $timeoutMillisSelector;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                this.$timeoutMillisSelector = function10;
                this.$this_debounceInternal = flow0;
                super(3, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function3
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((CoroutineScope)object0), ((FlowCollector)object1), ((Continuation)object2));
            }

            public final Object invoke(CoroutineScope coroutineScope0, FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1 flowKt__DelayKt$debounceInternal$10 = new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation0);
                flowKt__DelayKt$debounceInternal$10.L$0 = coroutineScope0;
                flowKt__DelayKt$debounceInternal$10.L$1 = flowCollector0;
                return flowKt__DelayKt$debounceInternal$10.invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                LongRef ref$LongRef1;
                ObjectRef ref$ObjectRef0;
                ReceiveChannel receiveChannel0;
                FlowCollector flowCollector0;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        flowCollector0 = (FlowCollector)this.L$1;
                        receiveChannel0 = ProduceKt.produce$default(coroutineScope0, null, 0, new Function2(null) {
                            final Flow $this_debounceInternal;
                            private Object L$0;
                            int label;

                            {
                                this.$this_debounceInternal = flow0;
                                super(2, continuation0);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object object0, Continuation continuation0) {
                                kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1 flowKt__DelayKt$debounceInternal$1$values$10 = new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1(this.$this_debounceInternal, continuation0);
                                flowKt__DelayKt$debounceInternal$1$values$10.L$0 = object0;
                                return flowKt__DelayKt$debounceInternal$1$values$10;
                            }

                            @Override  // kotlin.jvm.functions.Function2
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1)this.create(producerScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object object0) {
                                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch(this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure(object0);
                                        FlowCollector flowCollector0 = new FlowCollector() {
                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public final Object emit(Object object0, Continuation continuation0) {
                                                kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1.emit.1 flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10;
                                                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1.emit.1) {
                                                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1.emit.1)continuation0;
                                                    if((flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label & 0x80000000) == 0) {
                                                        flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                                                            int label;
                                                            Object result;

                                                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object object0) {
                                                                this.result = object0;
                                                                this.label |= 0x80000000;
                                                                return continuation0.emit(null, this);
                                                            }
                                                        };
                                                    }
                                                    else {
                                                        flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label ^= 0x80000000;
                                                    }
                                                }
                                                else {
                                                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                                                        int label;
                                                        Object result;

                                                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object object0) {
                                                            this.result = object0;
                                                            this.label |= 0x80000000;
                                                            return continuation0.emit(null, this);
                                                        }
                                                    };
                                                }
                                                Object object1 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.result;
                                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch(flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label) {
                                                    case 0: {
                                                        ResultKt.throwOnFailure(object1);
                                                        ProducerScope producerScope0 = this.$$this$produce;
                                                        if(object0 == null) {
                                                            object0 = NullSurrogateKt.NULL;
                                                        }
                                                        flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label = 1;
                                                        return producerScope0.send(object0, flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10) == object2 ? object2 : Unit.INSTANCE;
                                                    }
                                                    case 1: {
                                                        ResultKt.throwOnFailure(object1);
                                                        return Unit.INSTANCE;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                                    }
                                                }
                                            }
                                        };
                                        this.label = 1;
                                        return this.$this_debounceInternal.collect(flowCollector0, this) == object1 ? object1 : Unit.INSTANCE;
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure(object0);
                                        return Unit.INSTANCE;
                                    }
                                    default: {
                                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                    }
                                }
                            }
                        }, 3, null);
                        ref$ObjectRef0 = new ObjectRef();
                        break;
                    }
                    case 1: {
                        LongRef ref$LongRef0 = (LongRef)this.L$3;
                        ref$ObjectRef0 = (ObjectRef)this.L$2;
                        receiveChannel0 = (ReceiveChannel)this.L$1;
                        flowCollector0 = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        ref$LongRef1 = ref$LongRef0;
                        ref$ObjectRef0.element = null;
                        goto label_41;
                    }
                    case 2: {
                        LongRef ref$LongRef2 = (LongRef)this.L$3;
                        ObjectRef ref$ObjectRef1 = (ObjectRef)this.L$2;
                        ReceiveChannel receiveChannel1 = (ReceiveChannel)this.L$1;
                        FlowCollector flowCollector1 = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        flowCollector0 = flowCollector1;
                        receiveChannel0 = receiveChannel1;
                        ref$ObjectRef0 = ref$ObjectRef1;
                        break;
                    }
                    default: {
                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                    }
                }
                while(ref$ObjectRef0.element != NullSurrogateKt.DONE) {
                    ref$LongRef1 = new LongRef();
                    if(ref$ObjectRef0.element != null) {
                        ref$LongRef1.element = ((Number)this.$timeoutMillisSelector.invoke((ref$ObjectRef0.element == NullSurrogateKt.NULL ? null : ref$ObjectRef0.element))).longValue();
                        if(ref$LongRef1.element < 0L) {
                            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2A150F0E1B0F0400521A1900040114134501061F180D0A41090A064E1208410004000406070608").toString());
                        }
                        if(ref$LongRef1.element == 0L) {
                            this.L$0 = flowCollector0;
                            this.L$1 = receiveChannel0;
                            this.L$2 = ref$ObjectRef0;
                            this.L$3 = ref$LongRef1;
                            this.label = 1;
                            if(flowCollector0.emit((ref$ObjectRef0.element == NullSurrogateKt.NULL ? null : ref$ObjectRef0.element), this) == object1) {
                                return object1;
                            }
                            ref$ObjectRef0.element = null;
                        }
                    }
                label_41:
                    this.L$0 = flowCollector0;
                    this.L$1 = receiveChannel0;
                    this.L$2 = ref$ObjectRef0;
                    this.L$3 = ref$LongRef1;
                    this.label = 2;
                    SelectBuilderImpl selectBuilderImpl0 = new SelectBuilderImpl(this);
                    try {
                        if(ref$ObjectRef0.element != null) {
                            selectBuilderImpl0.onTimeout(ref$LongRef1.element, new Function1(ref$ObjectRef0, null) {
                                final FlowCollector $downstream;
                                final ObjectRef $lastValue;
                                int label;

                                {
                                    this.$downstream = flowCollector0;
                                    this.$lastValue = ref$ObjectRef0;
                                    super(1, continuation0);
                                }

                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Continuation continuation0) {
                                    return new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.1(this.$downstream, this.$lastValue, continuation0);
                                }

                                @Override  // kotlin.jvm.functions.Function1
                                public Object invoke(Object object0) {
                                    return this.invoke(((Continuation)object0));
                                }

                                public final Object invoke(Continuation continuation0) {
                                    return ((kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object object0) {
                                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch(this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure(object0);
                                            this.label = 1;
                                            if(this.$downstream.emit((this.$lastValue.element == NullSurrogateKt.NULL ? null : this.$lastValue.element), this) == object1) {
                                                return object1;
                                            }
                                            break;
                                        }
                                        case 1: {
                                            ResultKt.throwOnFailure(object0);
                                            break;
                                        }
                                        default: {
                                            throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                        }
                                    }
                                    this.$lastValue.element = null;
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        selectBuilderImpl0.invoke(receiveChannel0.getOnReceiveCatching(), new Function2(flowCollector0, null) {
                            final FlowCollector $downstream;
                            final ObjectRef $lastValue;
                            Object L$0;
                            Object L$1;
                            int label;

                            {
                                this.$lastValue = ref$ObjectRef0;
                                this.$downstream = flowCollector0;
                                super(2, continuation0);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object object0, Continuation continuation0) {
                                kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.2 flowKt__DelayKt$debounceInternal$1$3$20 = new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.2(this.$lastValue, this.$downstream, continuation0);
                                flowKt__DelayKt$debounceInternal$1$3$20.L$0 = object0;
                                return flowKt__DelayKt$debounceInternal$1$3$20;
                            }

                            @Override  // kotlin.jvm.functions.Function2
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke-WpGqRn0(((ChannelResult)object0).unbox-impl(), ((Continuation)object1));
                            }

                            public final Object invoke-WpGqRn0(Object object0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.2)this.create(ChannelResult.box-impl(object0), continuation0)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object object0) {
                                ObjectRef ref$ObjectRef1;
                                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch(this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure(object0);
                                        Object object2 = ((ChannelResult)this.L$0).unbox-impl();
                                        ObjectRef ref$ObjectRef0 = this.$lastValue;
                                        if(!(object2 instanceof Failed)) {
                                            ref$ObjectRef0.element = object2;
                                        }
                                        ref$ObjectRef1 = this.$lastValue;
                                        FlowCollector flowCollector0 = this.$downstream;
                                        if(!(object2 instanceof Failed)) {
                                            return Unit.INSTANCE;
                                        }
                                        Throwable throwable0 = ChannelResult.exceptionOrNull-impl(object2);
                                        if(throwable0 != null) {
                                            throw throwable0;
                                        }
                                        if(ref$ObjectRef1.element != null) {
                                            this.L$0 = object2;
                                            this.L$1 = ref$ObjectRef1;
                                            this.label = 1;
                                            if(flowCollector0.emit((ref$ObjectRef1.element == NullSurrogateKt.NULL ? null : ref$ObjectRef1.element), this) == object1) {
                                                return object1;
                                            }
                                        }
                                        break;
                                    }
                                    case 1: {
                                        ObjectRef ref$ObjectRef2 = (ObjectRef)this.L$1;
                                        ResultKt.throwOnFailure(object0);
                                        ref$ObjectRef1 = ref$ObjectRef2;
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                    }
                                }
                                ref$ObjectRef1.element = NullSurrogateKt.DONE;
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    catch(Throwable throwable0) {
                        selectBuilderImpl0.handleBuilderException(throwable0);
                    }
                    Object object2 = selectBuilderImpl0.getResult();
                    if(object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
                    if(object2 != object1) {
                        continue;
                    }
                    return object1;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final ReceiveChannel fixedPeriodTicker(CoroutineScope coroutineScope0, long v, long v1) {
        String s = UnityPlayerActivity.adjustValue("4E1D1E");
        if(Long.compare(v, 0L) < 0) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2B081D040D15020152001F034C0004000406070608410A040B040B42500F141A410F04014E") + v + s).toString());
        }
        if(v1 < 0L) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2B081D040D15020152001F034C000400040607060841070F0E111B0F1C4D050B0D061C5E4E1218154E09061652") + v1 + s).toString());
        }
        return ProduceKt.produce$default(coroutineScope0, null, 0, new Function2(v1, v, null) {
            final long $delayMillis;
            final long $initialDelayMillis;
            private Object L$0;
            int label;

            {
                this.$initialDelayMillis = v;
                this.$delayMillis = v1;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker.3 flowKt__DelayKt$fixedPeriodTicker$30 = new kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker.3(this.$initialDelayMillis, this.$delayMillis, continuation0);
                flowKt__DelayKt$fixedPeriodTicker$30.L$0 = object0;
                return flowKt__DelayKt$fixedPeriodTicker$30;
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker.3)this.create(producerScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                ProducerScope producerScope0;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        producerScope0 = (ProducerScope)this.L$0;
                        this.L$0 = producerScope0;
                        this.label = 1;
                        if(DelayKt.delay(this.$initialDelayMillis, this) != object1) {
                            goto label_18;
                        }
                        return object1;
                    }
                    case 2: {
                        producerScope0 = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    case 1: 
                    case 3: {
                        producerScope0 = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        goto label_18;
                    }
                    default: {
                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                    }
                }
                do {
                    this.L$0 = producerScope0;
                    this.label = 3;
                    if(DelayKt.delay(this.$delayMillis, this) == object1) {
                        return object1;
                    }
                label_18:
                    SendChannel sendChannel0 = producerScope0.getChannel();
                    this.L$0 = producerScope0;
                    this.label = 2;
                }
                while(sendChannel0.send(Unit.INSTANCE, this) != object1);
                return object1;
            }
        }, 1, null);
    }

    public static ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope0, long v, long v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v1 = v;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope0, v, v1);
    }

    public static final Flow sample(Flow flow0, long v) {
        if(v <= 0L) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("3D11001102044715171C1902054E120F0A0702144D030B41170A01070404170B").toString());
        }
        return FlowCoroutineKt.scopedFlow(new Function3(v, flow0, null) {
            final long $periodMillis;
            final Flow $this_sample;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                this.$periodMillis = v;
                this.$this_sample = flow0;
                super(3, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function3
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((CoroutineScope)object0), ((FlowCollector)object1), ((Continuation)object2));
            }

            public final Object invoke(CoroutineScope coroutineScope0, FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2 flowKt__DelayKt$sample$20 = new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2(this.$periodMillis, this.$this_sample, continuation0);
                flowKt__DelayKt$sample$20.L$0 = coroutineScope0;
                flowKt__DelayKt$sample$20.L$1 = flowCollector0;
                return flowKt__DelayKt$sample$20.invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                ReceiveChannel receiveChannel1;
                ObjectRef ref$ObjectRef0;
                ReceiveChannel receiveChannel0;
                FlowCollector flowCollector0;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        flowCollector0 = (FlowCollector)this.L$1;
                        receiveChannel0 = ProduceKt.produce$default(coroutineScope0, null, -1, new Function2(null) {
                            final Flow $this_sample;
                            private Object L$0;
                            int label;

                            {
                                this.$this_sample = flow0;
                                super(2, continuation0);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object object0, Continuation continuation0) {
                                kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1 flowKt__DelayKt$sample$2$values$10 = new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1(this.$this_sample, continuation0);
                                flowKt__DelayKt$sample$2$values$10.L$0 = object0;
                                return flowKt__DelayKt$sample$2$values$10;
                            }

                            @Override  // kotlin.jvm.functions.Function2
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1)this.create(producerScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object object0) {
                                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch(this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure(object0);
                                        FlowCollector flowCollector0 = new FlowCollector() {
                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public final Object emit(Object object0, Continuation continuation0) {
                                                kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1.emit.1 flowKt__DelayKt$sample$2$values$1$1$emit$10;
                                                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1.emit.1) {
                                                    flowKt__DelayKt$sample$2$values$1$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1.emit.1)continuation0;
                                                    if((flowKt__DelayKt$sample$2$values$1$1$emit$10.label & 0x80000000) == 0) {
                                                        flowKt__DelayKt$sample$2$values$1$1$emit$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                                                            int label;
                                                            Object result;

                                                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object object0) {
                                                                this.result = object0;
                                                                this.label |= 0x80000000;
                                                                return continuation0.emit(null, this);
                                                            }
                                                        };
                                                    }
                                                    else {
                                                        flowKt__DelayKt$sample$2$values$1$1$emit$10.label ^= 0x80000000;
                                                    }
                                                }
                                                else {
                                                    flowKt__DelayKt$sample$2$values$1$1$emit$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                                                        int label;
                                                        Object result;

                                                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object object0) {
                                                            this.result = object0;
                                                            this.label |= 0x80000000;
                                                            return continuation0.emit(null, this);
                                                        }
                                                    };
                                                }
                                                Object object1 = flowKt__DelayKt$sample$2$values$1$1$emit$10.result;
                                                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch(flowKt__DelayKt$sample$2$values$1$1$emit$10.label) {
                                                    case 0: {
                                                        ResultKt.throwOnFailure(object1);
                                                        ProducerScope producerScope0 = this.$$this$produce;
                                                        if(object0 == null) {
                                                            object0 = NullSurrogateKt.NULL;
                                                        }
                                                        flowKt__DelayKt$sample$2$values$1$1$emit$10.label = 1;
                                                        return producerScope0.send(object0, flowKt__DelayKt$sample$2$values$1$1$emit$10) == object2 ? object2 : Unit.INSTANCE;
                                                    }
                                                    case 1: {
                                                        ResultKt.throwOnFailure(object1);
                                                        return Unit.INSTANCE;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                                    }
                                                }
                                            }
                                        };
                                        this.label = 1;
                                        return this.$this_sample.collect(flowCollector0, this) == object1 ? object1 : Unit.INSTANCE;
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure(object0);
                                        return Unit.INSTANCE;
                                    }
                                    default: {
                                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                    }
                                }
                            }
                        }, 1, null);
                        ref$ObjectRef0 = new ObjectRef();
                        receiveChannel1 = FlowKt__DelayKt.fixedPeriodTicker$default(coroutineScope0, this.$periodMillis, 0L, 2, null);
                        break;
                    }
                    case 1: {
                        receiveChannel1 = (ReceiveChannel)this.L$3;
                        ref$ObjectRef0 = (ObjectRef)this.L$2;
                        receiveChannel0 = (ReceiveChannel)this.L$1;
                        flowCollector0 = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                    }
                }
                while(ref$ObjectRef0.element != NullSurrogateKt.DONE) {
                    this.L$0 = flowCollector0;
                    this.L$1 = receiveChannel0;
                    this.L$2 = ref$ObjectRef0;
                    this.L$3 = receiveChannel1;
                    this.label = 1;
                    SelectBuilderImpl selectBuilderImpl0 = new SelectBuilderImpl(this);
                    try {
                        selectBuilderImpl0.invoke(receiveChannel0.getOnReceiveCatching(), new Function2(receiveChannel1, null) {
                            final ObjectRef $lastValue;
                            final ReceiveChannel $ticker;
                            Object L$0;
                            int label;

                            {
                                this.$lastValue = ref$ObjectRef0;
                                this.$ticker = receiveChannel0;
                                super(2, continuation0);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object object0, Continuation continuation0) {
                                kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.1 flowKt__DelayKt$sample$2$1$10 = new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.1(this.$lastValue, this.$ticker, continuation0);
                                flowKt__DelayKt$sample$2$1$10.L$0 = object0;
                                return flowKt__DelayKt$sample$2$1$10;
                            }

                            @Override  // kotlin.jvm.functions.Function2
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke-WpGqRn0(((ChannelResult)object0).unbox-impl(), ((Continuation)object1));
                            }

                            public final Object invoke-WpGqRn0(Object object0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.1)this.create(ChannelResult.box-impl(object0), continuation0)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                }
                                ResultKt.throwOnFailure(object0);
                                Object object1 = ((ChannelResult)this.L$0).unbox-impl();
                                ObjectRef ref$ObjectRef0 = this.$lastValue;
                                if(!(object1 instanceof Failed)) {
                                    ref$ObjectRef0.element = object1;
                                }
                                ReceiveChannel receiveChannel0 = this.$ticker;
                                ObjectRef ref$ObjectRef1 = this.$lastValue;
                                if(object1 instanceof Failed) {
                                    Throwable throwable0 = ChannelResult.exceptionOrNull-impl(object1);
                                    if(throwable0 != null) {
                                        throw throwable0;
                                    }
                                    receiveChannel0.cancel(new ChildCancelledException());
                                    ref$ObjectRef1.element = NullSurrogateKt.DONE;
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        selectBuilderImpl0.invoke(receiveChannel1.getOnReceive(), new Function2(flowCollector0, null) {
                            final FlowCollector $downstream;
                            final ObjectRef $lastValue;
                            int label;

                            {
                                this.$lastValue = ref$ObjectRef0;
                                this.$downstream = flowCollector0;
                                super(2, continuation0);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.2(this.$lastValue, this.$downstream, continuation0);
                            }

                            @Override  // kotlin.jvm.functions.Function2
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Unit)object0), ((Continuation)object1));
                            }

                            public final Object invoke(Unit unit0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.2)this.create(unit0, continuation0)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object object0) {
                                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch(this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure(object0);
                                        Object object2 = this.$lastValue.element;
                                        if(object2 == null) {
                                            return Unit.INSTANCE;
                                        }
                                        this.$lastValue.element = null;
                                        FlowCollector flowCollector0 = this.$downstream;
                                        if(object2 == NullSurrogateKt.NULL) {
                                            object2 = null;
                                        }
                                        this.label = 1;
                                        return flowCollector0.emit(object2, this) == object1 ? object1 : Unit.INSTANCE;
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure(object0);
                                        return Unit.INSTANCE;
                                    }
                                    default: {
                                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                                    }
                                }
                            }
                        });
                    }
                    catch(Throwable throwable0) {
                        selectBuilderImpl0.handleBuilderException(throwable0);
                    }
                    Object object2 = selectBuilderImpl0.getResult();
                    if(object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(this);
                    }
                    if(object2 == object1) {
                        return object1;
                    }
                    if(false) {
                        break;
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final Flow sample-HG0u8IE(Flow flow0, long v) {
        return FlowKt.sample(flow0, DelayKt.toDelayMillis-LRDsOJo(v));
    }
}

