package com.onesignal.common.services;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\u001B\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\t0\u0005\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\nH\u0086\bJ(\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\t0\u0005\"\u0004\b\u0000\u0010\t2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\t0\fH\u0016J!\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\t0\u0005\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000E\u001A\u0002H\tH\u0016¢\u0006\u0002\u0010\u000FJ\"\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\t0\u0005\"\u0004\b\u0000\u0010\t2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\t0\u0011H\u0016R\u0018\u0010\u0003\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/onesignal/common/services/ServiceBuilder;", "Lcom/onesignal/common/services/IServiceBuilder;", "()V", "registrations", "", "Lcom/onesignal/common/services/ServiceRegistration;", "build", "Lcom/onesignal/common/services/ServiceProvider;", "register", "T", "", "create", "Lkotlin/Function1;", "Lcom/onesignal/common/services/IServiceProvider;", "obj", "(Ljava/lang/Object;)Lcom/onesignal/common/services/ServiceRegistration;", "c", "Ljava/lang/Class;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ServiceBuilder implements IServiceBuilder {
    private final List registrations;

    public ServiceBuilder() {
        this.registrations = new ArrayList();
    }

    @Override  // com.onesignal.common.services.IServiceBuilder
    public ServiceProvider build() {
        return new ServiceProvider(this.registrations);
    }

    public final ServiceRegistration register() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return this.register(Object.class);
    }

    @Override  // com.onesignal.common.services.IServiceBuilder
    public ServiceRegistration register(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        ServiceRegistrationReflection serviceRegistrationReflection0 = new ServiceRegistrationReflection(class0);
        this.registrations.add(serviceRegistrationReflection0);
        return serviceRegistrationReflection0;
    }

    @Override  // com.onesignal.common.services.IServiceBuilder
    public ServiceRegistration register(Object object0) {
        ServiceRegistrationSingleton serviceRegistrationSingleton0 = new ServiceRegistrationSingleton(object0);
        this.registrations.add(serviceRegistrationSingleton0);
        return serviceRegistrationSingleton0;
    }

    @Override  // com.onesignal.common.services.IServiceBuilder
    public ServiceRegistration register(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, "create");
        ServiceRegistrationLambda serviceRegistrationLambda0 = new ServiceRegistrationLambda(function10);
        this.registrations.add(serviceRegistrationLambda0);
        return serviceRegistrationLambda0;
    }
}

