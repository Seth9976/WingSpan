package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001JJ\u0010\u0002\u001A\u00020\u0003\"\u0004\b\u0001\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u00062$\u0010\u0007\u001A \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u000B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"kotlinx/coroutines/channels/ReceiveChannel$onReceiveOrNull$1", "Lkotlinx/coroutines/selects/SelectClause1;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class ReceiveChannel.onReceiveOrNull.1 implements SelectClause1 {
    ReceiveChannel.onReceiveOrNull.1(ReceiveChannel receiveChannel0) {
        ReceiveChannel.this = receiveChannel0;
        super();
    }

    @Override  // kotlinx.coroutines.selects.SelectClause1
    public void registerSelectClause1(SelectInstance selectInstance0, Function2 function20) {
        ReceiveChannel.this.getOnReceiveCatching().registerSelectClause1(selectInstance0, new Function2(null) {
            final Function2 $block;
            Object L$0;
            int label;

            {
                this.$block = function20;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                kotlinx.coroutines.channels.ReceiveChannel.onReceiveOrNull.1.registerSelectClause1.1 receiveChannel$onReceiveOrNull$1$registerSelectClause1$10 = new kotlinx.coroutines.channels.ReceiveChannel.onReceiveOrNull.1.registerSelectClause1.1(this.$block, continuation0);
                receiveChannel$onReceiveOrNull$1$registerSelectClause1$10.L$0 = object0;
                return receiveChannel$onReceiveOrNull$1$registerSelectClause1$10;
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke-WpGqRn0(((ChannelResult)object0).unbox-impl(), ((Continuation)object1));
            }

            public final Object invoke-WpGqRn0(Object object0, Continuation continuation0) {
                return ((kotlinx.coroutines.channels.ReceiveChannel.onReceiveOrNull.1.registerSelectClause1.1)this.create(ChannelResult.box-impl(object0), continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        Object object2 = ((ChannelResult)this.L$0).unbox-impl();
                        Throwable throwable0 = ChannelResult.exceptionOrNull-impl(object2);
                        if(throwable0 != null) {
                            throw throwable0;
                        }
                        this.label = 1;
                        object0 = this.$block.invoke(ChannelResult.getOrNull-impl(object2), this);
                        return object0 == object1 ? object1 : object0;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
                    }
                }
            }
        });
    }
}

