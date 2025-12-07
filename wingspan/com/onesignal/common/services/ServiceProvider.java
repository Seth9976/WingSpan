package com.onesignal.common.services;

import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0010\u0010\u0002\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0003\"\n\b\u0000\u0010\u000B\u0018\u0001*\u00020\fH\u0080\b¢\u0006\u0002\b\rJ\"\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0003\"\u0004\b\u0000\u0010\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u000B0\bH\u0016J\u001C\u0010\u000F\u001A\u0002H\u000B\"\n\b\u0000\u0010\u000B\u0018\u0001*\u00020\fH\u0080\b¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u000F\u001A\u0002H\u000B\"\u0004\b\u0000\u0010\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u000B0\bH\u0016¢\u0006\u0002\u0010\u0012J\u001E\u0010\u0013\u001A\u0004\u0018\u0001H\u000B\"\n\b\u0000\u0010\u000B\u0018\u0001*\u00020\fH\u0080\b¢\u0006\u0004\b\u0014\u0010\u0011J#\u0010\u0013\u001A\u0004\u0018\u0001H\u000B\"\u0004\b\u0000\u0010\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u000B0\bH\u0016¢\u0006\u0002\u0010\u0012J\u001A\u0010\u0015\u001A\u00020\u0016\"\n\b\u0000\u0010\u000B\u0018\u0001*\u00020\fH\u0080\b¢\u0006\u0002\b\u0017J\u001C\u0010\u0015\u001A\u00020\u0016\"\u0004\b\u0000\u0010\u000B2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u000B0\bH\u0016R(\u0010\u0006\u001A\u001C\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/onesignal/common/services/ServiceProvider;", "Lcom/onesignal/common/services/IServiceProvider;", "registrations", "", "Lcom/onesignal/common/services/ServiceRegistration;", "(Ljava/util/List;)V", "serviceMap", "", "Ljava/lang/Class;", "", "getAllServices", "T", "", "getAllServices$com_onesignal_core", "c", "getService", "getService$com_onesignal_core", "()Ljava/lang/Object;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getServiceOrNull", "getServiceOrNull$com_onesignal_core", "hasService", "", "hasService$com_onesignal_core", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ServiceProvider implements IServiceProvider {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/onesignal/common/services/ServiceProvider$Companion;", "", "()V", "indent", "", "getIndent", "()Ljava/lang/String;", "setIndent", "(Ljava/lang/String;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        public final String getIndent() [...] // 潜在的解密器

        public final void setIndent(String s) {
            Intrinsics.checkNotNullParameter(s, "<set-?>");
            ServiceProvider.indent = s;
        }
    }

    public static final Companion Companion;
    private static String indent;
    private final Map serviceMap;

    static {
        ServiceProvider.Companion = new Companion(null);
        ServiceProvider.indent = "";
    }

    public ServiceProvider(List list0) {
        Intrinsics.checkNotNullParameter(list0, "registrations");
        super();
        this.serviceMap = new LinkedHashMap();
        for(Object object0: list0) {
            ServiceRegistration serviceRegistration0 = (ServiceRegistration)object0;
            for(Object object1: serviceRegistration0.getServices()) {
                Class class0 = (Class)object1;
                if(this.serviceMap.containsKey(class0)) {
                    Object object2 = this.serviceMap.get(class0);
                    Intrinsics.checkNotNull(object2);
                    ((List)object2).add(serviceRegistration0);
                }
                else {
                    List list1 = CollectionsKt.mutableListOf(new ServiceRegistration[]{serviceRegistration0});
                    this.serviceMap.put(class0, list1);
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    public static final String access$getIndent$cp() [...] // 潜在的解密器

    @Override  // com.onesignal.common.services.IServiceProvider
    public List getAllServices(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        synchronized(this.serviceMap) {
            List list0 = new ArrayList();
            if(this.serviceMap.containsKey(class0)) {
                Intrinsics.checkNotNull(this.serviceMap);
                Object object0 = this.serviceMap.get(class0);
                Intrinsics.checkNotNull(object0);
                for(Object object1: ((List)object0)) {
                    ServiceRegistration serviceRegistration0 = (ServiceRegistration)object1;
                    Object object2 = serviceRegistration0.resolve(this);
                    if(object2 == null) {
                        throw new Exception("Could not instantiate service: " + serviceRegistration0);
                    }
                    list0.add(object2);
                }
            }
            return list0;
        }
    }

    public final List getAllServices$com_onesignal_core() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return this.getAllServices(Object.class);
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public Object getService(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        Object object0 = this.getServiceOrNull(class0);
        if(object0 != null) {
            return object0;
        }
        Logging.warn$default(("Service not found: " + class0), null, 2, null);
        throw new Exception("Service " + class0 + " could not be instantiated");
    }

    public final Object getService$com_onesignal_core() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return this.getService(Object.class);
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public Object getServiceOrNull(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        synchronized(this.serviceMap) {
            Object object0 = null;
            Logging.debug$default(("Retrieving service " + class0), null, 2, null);
            List list0 = (List)this.serviceMap.get(class0);
            if(list0 != null) {
                ServiceRegistration serviceRegistration0 = (ServiceRegistration)CollectionsKt.last(list0);
                if(serviceRegistration0 != null) {
                    object0 = serviceRegistration0.resolve(this);
                }
            }
            return object0;
        }
    }

    public final Object getServiceOrNull$com_onesignal_core() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return this.getServiceOrNull(Object.class);
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public boolean hasService(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        synchronized(this.serviceMap) {
            return this.serviceMap.containsKey(class0);
        }
    }

    public final boolean hasService$com_onesignal_core() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return this.hasService(Object.class);
    }
}

