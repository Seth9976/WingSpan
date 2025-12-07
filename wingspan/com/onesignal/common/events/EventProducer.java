package com.onesignal.common.events;

import com.onesignal.common.threading.ThreadUtilsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001A\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000B0\rJ\u001A\u0010\u000E\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000B0\rJ\u0015\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001A\u00020\u000B2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J5\u0010\u0014\u001A\u00020\u000B2\"\u0010\f\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001A\u00020\u000B2\"\u0010\f\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001B"}, d2 = {"Lcom/onesignal/common/events/EventProducer;", "THandler", "Lcom/onesignal/common/events/IEventNotifier;", "()V", "hasSubscribers", "", "getHasSubscribers", "()Z", "subscribers", "", "fire", "", "callback", "Lkotlin/Function1;", "fireOnMain", "subscribe", "handler", "(Ljava/lang/Object;)V", "subscribeAll", "from", "suspendingFire", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendingFireOnMain", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class EventProducer implements IEventNotifier {
    private final List subscribers;

    public EventProducer() {
        List list0 = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(list0, "synchronizedList(mutableListOf())");
        this.subscribers = list0;
    }

    public final void fire(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "callback");
        synchronized(this.subscribers) {
            List list0 = CollectionsKt.toList(this.subscribers);
        }
        for(Object object0: list0) {
            function10.invoke(object0);
        }
    }

    public final void fireOnMain(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "callback");
        ThreadUtilsKt.suspendifyOnMain(new Function1(function10, null) {
            final Function1 $callback;
            int label;

            {
                EventProducer.this = eventProducer0;
                this.$callback = function10;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.common.events.EventProducer.fireOnMain.1(EventProducer.this, this.$callback, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.common.events.EventProducer.fireOnMain.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                synchronized(EventProducer.this.subscribers) {
                    List list1 = CollectionsKt.toList(EventProducer.this.subscribers);
                }
                for(Object object1: list1) {
                    this.$callback.invoke(object1);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return CollectionsKt.any(this.subscribers);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        synchronized(this.subscribers) {
            this.subscribers.add(object0);
        }
    }

    public final void subscribeAll(EventProducer eventProducer0) {
        Intrinsics.checkNotNullParameter(eventProducer0, "from");
        synchronized(this.subscribers) {
            for(Object object0: eventProducer0.subscribers) {
                this.subscribe(object0);
            }
        }
    }

    public final Object suspendingFire(Function2 function20, Continuation continuation0) {
        List list0;
        Iterator iterator0;
        Function2 function21;
        com.onesignal.common.events.EventProducer.suspendingFire.1 eventProducer$suspendingFire$10;
        if(continuation0 instanceof com.onesignal.common.events.EventProducer.suspendingFire.1) {
            eventProducer$suspendingFire$10 = (com.onesignal.common.events.EventProducer.suspendingFire.1)continuation0;
            if((eventProducer$suspendingFire$10.label & 0x80000000) == 0) {
                eventProducer$suspendingFire$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.suspendingFire(null, this);
                    }
                };
            }
            else {
                eventProducer$suspendingFire$10.label ^= 0x80000000;
            }
        }
        else {
            eventProducer$suspendingFire$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.suspendingFire(null, this);
                }
            };
        }
        Object object0 = eventProducer$suspendingFire$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(eventProducer$suspendingFire$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                synchronized(this.subscribers) {
                    list0 = CollectionsKt.toList(this.subscribers);
                }
                function21 = function20;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                iterator0 = (Iterator)eventProducer$suspendingFire$10.L$1;
                Function2 function22 = (Function2)eventProducer$suspendingFire$10.L$0;
                ResultKt.throwOnFailure(object0);
                function21 = function22;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            eventProducer$suspendingFire$10.L$0 = function21;
            eventProducer$suspendingFire$10.L$1 = iterator0;
            eventProducer$suspendingFire$10.label = 1;
            if(function21.invoke(object2, eventProducer$suspendingFire$10) == object1) {
                return object1;
            }
            if(false) {
                break;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object suspendingFireOnMain(Function2 function20, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(function20, null) {
            final Function2 $callback;
            Object L$0;
            int label;

            {
                EventProducer.this = eventProducer0;
                this.$callback = function20;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.common.events.EventProducer.suspendingFireOnMain.2(EventProducer.this, this.$callback, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.common.events.EventProducer.suspendingFireOnMain.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                List list1;
                Iterator iterator0;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        synchronized(EventProducer.this.subscribers) {
                            list1 = CollectionsKt.toList(EventProducer.this.subscribers);
                        }
                        iterator0 = list1.iterator();
                        break;
                    }
                    case 1: {
                        iterator0 = (Iterator)this.L$0;
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(iterator0.hasNext()) {
                    Object object2 = iterator0.next();
                    this.L$0 = iterator0;
                    this.label = 1;
                    if(this.$callback.invoke(object2, this) == object1) {
                        return object1;
                    }
                    if(false) {
                        break;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        synchronized(this.subscribers) {
            this.subscribers.remove(object0);
        }
    }
}

