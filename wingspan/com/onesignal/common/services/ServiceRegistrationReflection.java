package com.onesignal.common.services;

import com.onesignal.debug.internal.logging.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u001C\u0010\b\u001A\u00020\t2\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u000B2\u0006\u0010\f\u001A\u00020\rH\u0002J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\rH\u0016R\u0012\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/services/ServiceRegistrationReflection;", "T", "Lcom/onesignal/common/services/ServiceRegistration;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "obj", "Ljava/lang/Object;", "doesHaveAllParameters", "", "constructor", "Ljava/lang/reflect/Constructor;", "provider", "Lcom/onesignal/common/services/IServiceProvider;", "resolve", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ServiceRegistrationReflection extends ServiceRegistration {
    private final Class clazz;
    private Object obj;

    public ServiceRegistrationReflection(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "clazz");
        super();
        this.clazz = class0;
    }

    private final boolean doesHaveAllParameters(Constructor constructor0, IServiceProvider iServiceProvider0) {
        Type[] arr_type = constructor0.getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(arr_type, "constructor.genericParameterTypes");
        int v = 0;
        while(v < arr_type.length) {
            Type type0 = arr_type[v];
            if(type0 instanceof ParameterizedType) {
                Type[] arr_type1 = ((ParameterizedType)type0).getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(arr_type1, "param.actualTypeArguments");
                Type type1 = (Type)ArraysKt.firstOrNull(arr_type1);
                if(type1 instanceof WildcardType) {
                    Type[] arr_type2 = ((WildcardType)type1).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(arr_type2, "argType.upperBounds");
                    Type type2 = (Type)ArraysKt.first(arr_type2);
                    if(type2 instanceof Class && !iServiceProvider0.hasService(((Class)type2))) {
                        Logging.debug$default(("Constructor " + constructor0 + " could not find service: " + type2), null, 2, null);
                        return false;
                    }
                }
                else {
                    if(type1 instanceof Class) {
                        if(iServiceProvider0.hasService(((Class)type1))) {
                            ++v;
                            continue;
                        }
                        else {
                            Logging.debug$default(("Constructor " + constructor0 + " could not find service: " + type1), null, 2, null);
                        }
                    }
                    return false;
                }
            }
            else {
                if(!(type0 instanceof Class)) {
                    Logging.debug$default(("Constructor " + constructor0 + " could not identify param type: " + type0), null, 2, null);
                    return false;
                }
                if(!iServiceProvider0.hasService(((Class)type0))) {
                    Logging.debug$default(("Constructor " + constructor0 + " could not find service: " + type0), null, 2, null);
                    return false;
                }
            }
            ++v;
        }
        return true;
    }

    @Override  // com.onesignal.common.services.ServiceRegistration
    public Object resolve(IServiceProvider iServiceProvider0) {
        Intrinsics.checkNotNullParameter(iServiceProvider0, "provider");
        if(this.obj != null) {
            Logging.debug$default(("Already instantiated: " + this.obj), null, 2, null);
            return this.obj;
        }
        Constructor[] arr_constructor = this.clazz.getConstructors();
        Intrinsics.checkNotNullExpressionValue(arr_constructor, "clazz.constructors");
        for(int v = 0; v < arr_constructor.length; ++v) {
            Constructor constructor0 = arr_constructor[v];
            Intrinsics.checkNotNullExpressionValue(constructor0, "constructor");
            if(this.doesHaveAllParameters(constructor0, iServiceProvider0)) {
                Logging.debug$default(("Found constructor: " + constructor0), null, 2, null);
                List list0 = new ArrayList();
                Type[] arr_type = constructor0.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(arr_type, "constructor.genericParameterTypes");
                for(int v1 = 0; v1 < arr_type.length; ++v1) {
                    Type type0 = arr_type[v1];
                    if(type0 instanceof ParameterizedType) {
                        Type[] arr_type1 = ((ParameterizedType)type0).getActualTypeArguments();
                        Intrinsics.checkNotNullExpressionValue(arr_type1, "param.actualTypeArguments");
                        Type type1 = (Type)ArraysKt.firstOrNull(arr_type1);
                        if(type1 instanceof WildcardType) {
                            Type[] arr_type2 = ((WildcardType)type1).getUpperBounds();
                            Intrinsics.checkNotNullExpressionValue(arr_type2, "argType.upperBounds");
                            Type type2 = (Type)ArraysKt.first(arr_type2);
                            if(type2 instanceof Class) {
                                list0.add(iServiceProvider0.getAllServices(((Class)type2)));
                            }
                            else {
                                list0.add(null);
                            }
                        }
                        else if(type1 instanceof Class) {
                            list0.add(iServiceProvider0.getAllServices(((Class)type1)));
                        }
                        else {
                            list0.add(null);
                        }
                    }
                    else if(type0 instanceof Class) {
                        list0.add(iServiceProvider0.getService(((Class)type0)));
                    }
                    else {
                        list0.add(null);
                    }
                }
                Object[] arr_object = list0.toArray(new Object[0]);
                Intrinsics.checkNotNull(arr_object, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.obj = constructor0.newInstance(Arrays.copyOf(arr_object, arr_object.length));
                return this.obj;
            }
        }
        return this.obj;
    }
}

