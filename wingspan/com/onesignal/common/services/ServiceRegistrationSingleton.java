package com.onesignal.common.services;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH\u0016R\u0010\u0010\u0003\u001A\u00028\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/onesignal/common/services/ServiceRegistrationSingleton;", "T", "Lcom/onesignal/common/services/ServiceRegistration;", "obj", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "resolve", "", "provider", "Lcom/onesignal/common/services/IServiceProvider;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ServiceRegistrationSingleton extends ServiceRegistration {
    private Object obj;

    public ServiceRegistrationSingleton(Object object0) {
        this.obj = object0;
    }

    @Override  // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider iServiceProvider0) {
        Intrinsics.checkNotNullParameter(iServiceProvider0, "provider");
        return this.obj;
    }
}

