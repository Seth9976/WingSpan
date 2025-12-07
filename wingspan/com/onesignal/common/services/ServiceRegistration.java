package com.onesignal.common.services;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001B\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u0002H\u0086\bJ \u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\n0\u0006J\u0012\u0010\f\u001A\u0004\u0018\u00010\u00022\u0006\u0010\r\u001A\u00020\u000EH&R\u001B\u0010\u0004\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000F"}, d2 = {"Lcom/onesignal/common/services/ServiceRegistration;", "T", "", "()V", "services", "", "Ljava/lang/Class;", "getServices", "()Ljava/util/Set;", "provides", "TService", "c", "resolve", "provider", "Lcom/onesignal/common/services/IServiceProvider;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class ServiceRegistration {
    private final Set services;

    public ServiceRegistration() {
        this.services = new LinkedHashSet();
    }

    public final Set getServices() {
        return this.services;
    }

    public final ServiceRegistration provides() {
        Intrinsics.reifiedOperationMarker(4, "TService");
        return this.provides(Object.class);
    }

    public final ServiceRegistration provides(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        this.services.add(class0);
        return this;
    }

    public abstract Object resolve(IServiceProvider arg1);
}

