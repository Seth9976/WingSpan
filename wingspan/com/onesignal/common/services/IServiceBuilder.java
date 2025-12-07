package com.onesignal.common.services;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J(\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00060\bH&J!\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\n\u001A\u0002H\u0006H&¢\u0006\u0002\u0010\u000BJ\"\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00060\rH&¨\u0006\u000E"}, d2 = {"Lcom/onesignal/common/services/IServiceBuilder;", "", "build", "Lcom/onesignal/common/services/ServiceProvider;", "register", "Lcom/onesignal/common/services/ServiceRegistration;", "T", "create", "Lkotlin/Function1;", "Lcom/onesignal/common/services/IServiceProvider;", "obj", "(Ljava/lang/Object;)Lcom/onesignal/common/services/ServiceRegistration;", "c", "Ljava/lang/Class;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IServiceBuilder {
    ServiceProvider build();

    ServiceRegistration register(Class arg1);

    ServiceRegistration register(Object arg1);

    ServiceRegistration register(Function1 arg1);
}

