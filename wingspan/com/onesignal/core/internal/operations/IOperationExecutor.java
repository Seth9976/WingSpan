package com.onesignal.core.internal.operations;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\b2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\t0\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000B"}, d2 = {"Lcom/onesignal/core/internal/operations/IOperationExecutor;", "", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IOperationExecutor {
    Object execute(List arg1, Continuation arg2);

    List getOperations();
}

