package com.onesignal.core.internal.operations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0019\u0010\u0000\u001A\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"containsInstanceOf", "", "T", "Lcom/onesignal/core/internal/operations/Operation;", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "com.onesignal.core"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class IOperationRepoKt {
    public static final boolean containsInstanceOf(IOperationRepo iOperationRepo0) {
        Intrinsics.checkNotNullParameter(iOperationRepo0, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return iOperationRepo0.containsInstanceOf(Reflection.getOrCreateKotlinClass(Operation.class));
    }
}

