package com.onesignal.common.services;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\u0005H\u0016R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\b¨\u0006\f"}, d2 = {"Lcom/onesignal/common/services/ServiceRegistrationLambda;", "T", "Lcom/onesignal/common/services/ServiceRegistration;", "create", "Lkotlin/Function1;", "Lcom/onesignal/common/services/IServiceProvider;", "(Lkotlin/jvm/functions/Function1;)V", "obj", "Ljava/lang/Object;", "resolve", "", "provider", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ServiceRegistrationLambda extends ServiceRegistration {
    private final Function1 create;
    private Object obj;

    public ServiceRegistrationLambda(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "create");
        super();
        this.create = function10;
    }

    @Override  // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider iServiceProvider0) {
        Intrinsics.checkNotNullParameter(iServiceProvider0, "provider");
        Object object0 = this.obj;
        if(object0 != null) {
            return object0;
        }
        Object object1 = this.create.invoke(iServiceProvider0);
        this.obj = object1;
        return object1;
    }
}

