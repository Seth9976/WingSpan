package kotlinx.coroutines.selects;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A2\u0010\u0000\u001A\u00020\u00012\u001F\b\u0004\u0010\u0002\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class WhileSelectKt {
    public static final Object whileSelect(Function1 function10, Continuation continuation0) {
        kotlinx.coroutines.selects.WhileSelectKt.whileSelect.1 whileSelectKt$whileSelect$10;
        if(continuation0 instanceof kotlinx.coroutines.selects.WhileSelectKt.whileSelect.1) {
            whileSelectKt$whileSelect$10 = (kotlinx.coroutines.selects.WhileSelectKt.whileSelect.1)continuation0;
            if((whileSelectKt$whileSelect$10.label & 0x80000000) == 0) {
                whileSelectKt$whileSelect$10 = new ContinuationImpl(continuation0) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return WhileSelectKt.whileSelect(null, this);
                    }
                };
            }
            else {
                whileSelectKt$whileSelect$10.label ^= 0x80000000;
            }
        }
        else {
            whileSelectKt$whileSelect$10 = new ContinuationImpl(continuation0) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return WhileSelectKt.whileSelect(null, this);
                }
            };
        }
        Object object0 = whileSelectKt$whileSelect$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(whileSelectKt$whileSelect$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                goto label_18;
            }
            case 1: {
                function10 = (Function1)whileSelectKt$whileSelect$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("0D11010D4E150845551C151E1403044045100B1602130B41400C1C181F06044941100C0606500E0E1C0E12111B0015"));
            }
        }
        while(true) {
            if(!((Boolean)object0).booleanValue()) {
                return Unit.INSTANCE;
            }
        label_18:
            whileSelectKt$whileSelect$10.L$0 = function10;
            whileSelectKt$whileSelect$10.label = 1;
            SelectBuilderImpl selectBuilderImpl0 = new SelectBuilderImpl(whileSelectKt$whileSelect$10);
            try {
                function10.invoke(selectBuilderImpl0);
            }
            catch(Throwable throwable0) {
                selectBuilderImpl0.handleBuilderException(throwable0);
            }
            Object object2 = selectBuilderImpl0.getResult();
            if(object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(whileSelectKt$whileSelect$10);
            }
            if(object2 == object1) {
                return object1;
            }
            object0 = object2;
        }
    }

    private static final Object whileSelect$$forInline(Function1 function10, Continuation continuation0) {
        do {
            SelectBuilderImpl selectBuilderImpl0 = new SelectBuilderImpl(continuation0);
            try {
                function10.invoke(selectBuilderImpl0);
            }
            catch(Throwable throwable0) {
                selectBuilderImpl0.handleBuilderException(throwable0);
            }
            Object object0 = selectBuilderImpl0.getResult();
            if(object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation0);
            }
        }
        while(((Boolean)object0).booleanValue());
        return Unit.INSTANCE;
    }
}

