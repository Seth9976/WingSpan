package com.onesignal.core.internal.operations;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nR\u001F\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0019\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/onesignal/core/internal/operations/ExecutionResponse;", "", "result", "Lcom/onesignal/core/internal/operations/ExecutionResult;", "idTranslations", "", "", "operations", "", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/core/internal/operations/ExecutionResult;Ljava/util/Map;Ljava/util/List;)V", "getIdTranslations", "()Ljava/util/Map;", "getOperations", "()Ljava/util/List;", "getResult", "()Lcom/onesignal/core/internal/operations/ExecutionResult;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ExecutionResponse {
    private final Map idTranslations;
    private final List operations;
    private final ExecutionResult result;

    public ExecutionResponse(ExecutionResult executionResult0, Map map0, List list0) {
        Intrinsics.checkNotNullParameter(executionResult0, "result");
        super();
        this.result = executionResult0;
        this.idTranslations = map0;
        this.operations = list0;
    }

    public ExecutionResponse(ExecutionResult executionResult0, Map map0, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            map0 = null;
        }
        if((v & 4) != 0) {
            list0 = null;
        }
        this(executionResult0, map0, list0);
    }

    public final Map getIdTranslations() {
        return this.idTranslations;
    }

    public final List getOperations() {
        return this.operations;
    }

    public final ExecutionResult getResult() {
        return this.result;
    }
}

