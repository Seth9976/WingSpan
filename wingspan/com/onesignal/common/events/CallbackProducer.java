package com.onesignal.common.events;

import com.onesignal.common.threading.ThreadUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001A\u0010\n\u001A\u00020\u000B2\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000B0\fJ\u001A\u0010\r\u001A\u00020\u000B2\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000B0\fJ\u0017\u0010\u000E\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0010J5\u0010\u0011\u001A\u00020\u000B2\"\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J5\u0010\u0016\u001A\u00020\u000B2\"\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/common/events/CallbackProducer;", "THandler", "Lcom/onesignal/common/events/ICallbackNotifier;", "()V", "callback", "Ljava/lang/Object;", "hasCallback", "", "getHasCallback", "()Z", "fire", "", "Lkotlin/Function1;", "fireOnMain", "set", "handler", "(Ljava/lang/Object;)V", "suspendingFire", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendingFireOnMain", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class CallbackProducer implements ICallbackNotifier {
    private Object callback;

    public final void fire(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "callback");
        Object object0 = this.callback;
        if(object0 != null) {
            Intrinsics.checkNotNull(object0);
            function10.invoke(object0);
        }
    }

    public final void fireOnMain(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "callback");
        ThreadUtilsKt.suspendifyOnMain(new Function1(function10, null) {
            final Function1 $callback;
            int label;

            {
                CallbackProducer.this = callbackProducer0;
                this.$callback = function10;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.common.events.CallbackProducer.fireOnMain.1(CallbackProducer.this, this.$callback, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.common.events.CallbackProducer.fireOnMain.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                if(CallbackProducer.this.callback != null) {
                    Object object1 = CallbackProducer.this.callback;
                    Intrinsics.checkNotNull(object1);
                    this.$callback.invoke(object1);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override  // com.onesignal.common.events.ICallbackNotifier
    public boolean getHasCallback() {
        return this.callback != null;
    }

    @Override  // com.onesignal.common.events.ICallbackNotifier
    public void set(Object object0) {
        this.callback = object0;
    }

    public final Object suspendingFire(Function2 function20, Continuation continuation0) {
        Object object0 = this.callback;
        if(object0 != null) {
            Intrinsics.checkNotNull(object0);
            Object object1 = function20.invoke(object0, continuation0);
            return object1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object1 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object suspendingFireOnMain(Function2 function20, Continuation continuation0) {
        if(this.callback != null) {
            Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(this, null) {
                final Function2 $callback;
                int label;

                {
                    this.$callback = function20;
                    CallbackProducer.this = callbackProducer0;
                    super(2, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.onesignal.common.events.CallbackProducer.suspendingFireOnMain.2(this.$callback, CallbackProducer.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function2
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.onesignal.common.events.CallbackProducer.suspendingFireOnMain.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            Object object2 = CallbackProducer.this.callback;
                            Intrinsics.checkNotNull(object2);
                            this.label = 1;
                            return this.$callback.invoke(object2, this) == object1 ? object1 : Unit.INSTANCE;
                        }
                        case 1: {
                            ResultKt.throwOnFailure(object0);
                            return Unit.INSTANCE;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}

