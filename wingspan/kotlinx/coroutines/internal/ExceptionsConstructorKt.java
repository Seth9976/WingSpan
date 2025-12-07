package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CopyableThrowable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\u001A2\u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001A*\u0010\u000B\u001A\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\rH\u0002\u001A1\u0010\u000E\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001A!\u0010\u0010\u001A\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001A\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001A\u001B\u0010\u0013\u001A\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001A\u00020\u0003H\u0082\u0010\u001A\u0018\u0010\u0015\u001A\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001A\u00020\u0003H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields;

    static {
        ExceptionsConstructorKt.throwableFields = ExceptionsConstructorKt.fieldsCountOrDefault(Throwable.class, -1);
        ExceptionsConstructorKt.ctorCache = ClassValueCtorCache.INSTANCE;
    }

    private static final Function1 createConstructor(Class class0) {
        Function1 function10 = kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1.INSTANCE;
        int v = ExceptionsConstructorKt.fieldsCountOrDefault(class0, 0);
        if(ExceptionsConstructorKt.throwableFields != v) {
            return function10;
        }
        for(Object object0: ArraysKt.sortedWith(class0.getConstructors(), new Comparator() {
            @Override
            public final int compare(Object object0, Object object1) {
                Class[] arr_class = ((Constructor)object1).getParameterTypes();
                Class[] arr_class1 = ((Constructor)object0).getParameterTypes();
                return ComparisonsKt.compareValues(((int)arr_class.length), ((int)arr_class1.length));
            }
        })) {
            Function1 function11 = ExceptionsConstructorKt.createSafeConstructor(((Constructor)object0));
            if(function11 != null) {
                return function11;
            }
            if(false) {
                break;
            }
        }
        return function10;

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001A\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 0x30)
        final class kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1 extends Lambda implements Function1 {
            public static final kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1 INSTANCE;

            static {
                kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1.INSTANCE = new kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1();
            }

            kotlinx.coroutines.internal.ExceptionsConstructorKt.createConstructor.nullResult.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Throwable)object0));
            }

            public final Void invoke(Throwable throwable0) {
                return null;
            }
        }

    }

    private static final Function1 createSafeConstructor(Constructor constructor0) {
        Class[] arr_class = constructor0.getParameterTypes();
        if(arr_class.length != 0) {
            switch(arr_class.length) {
                case 1: {
                    Class class0 = arr_class[0];
                    if(Intrinsics.areEqual(class0, Throwable.class)) {
                        return new Function1(constructor0) {
                            final Constructor $constructor$inlined;

                            {
                                this.$constructor$inlined = constructor0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                return this.invoke(((Throwable)object0));
                            }

                            public final Throwable invoke(Throwable throwable0) {
                                Object object1;
                                try {
                                    Object object0 = this.$constructor$inlined.newInstance(throwable0);
                                    if(object0 == null) {
                                        throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B26060202160F030B00"));
                                    }
                                    object1 = Result.constructor-impl(((Throwable)object0));
                                }
                                catch(Throwable throwable1) {
                                    object1 = Result.constructor-impl(ResultKt.createFailure(throwable1));
                                }
                                if(Result.isFailure-impl(object1)) {
                                    object1 = null;
                                }
                                return (Throwable)object1;
                            }
                        };
                    }
                    if(Intrinsics.areEqual(class0, String.class)) {
                        return new Function1(constructor0) {
                            final Constructor $constructor$inlined;

                            {
                                this.$constructor$inlined = constructor0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                return this.invoke(((Throwable)object0));
                            }

                            public final Throwable invoke(Throwable throwable0) {
                                Object object1;
                                try {
                                    Object object0 = this.$constructor$inlined.newInstance(throwable0.getMessage());
                                    if(object0 == null) {
                                        throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B26060202160F030B00"));
                                    }
                                    ((Throwable)object0).initCause(throwable0);
                                    object1 = Result.constructor-impl(((Throwable)object0));
                                }
                                catch(Throwable throwable1) {
                                    object1 = Result.constructor-impl(ResultKt.createFailure(throwable1));
                                }
                                if(Result.isFailure-impl(object1)) {
                                    object1 = null;
                                }
                                return (Throwable)object1;
                            }
                        };
                    }
                    break;
                }
                case 2: {
                    if(Intrinsics.areEqual(arr_class[0], String.class) && Intrinsics.areEqual(arr_class[1], Throwable.class)) {
                        return new Function1(constructor0) {
                            final Constructor $constructor$inlined;

                            {
                                this.$constructor$inlined = constructor0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                return this.invoke(((Throwable)object0));
                            }

                            public final Throwable invoke(Throwable throwable0) {
                                Object object1;
                                try {
                                    Object object0 = this.$constructor$inlined.newInstance(throwable0.getMessage(), throwable0);
                                    if(object0 == null) {
                                        throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B26060202160F030B00"));
                                    }
                                    object1 = Result.constructor-impl(((Throwable)object0));
                                }
                                catch(Throwable throwable1) {
                                    object1 = Result.constructor-impl(ResultKt.createFailure(throwable1));
                                }
                                if(Result.isFailure-impl(object1)) {
                                    object1 = null;
                                }
                                return (Throwable)object1;
                            }
                        };
                    }
                    break;
                }
                default: {
                    return null;
                }
            }
            return null;
        }
        return new Function1(constructor0) {
            final Constructor $constructor$inlined;

            {
                this.$constructor$inlined = constructor0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Throwable)object0));
            }

            public final Throwable invoke(Throwable throwable0) {
                Object object1;
                try {
                    Object object0 = this.$constructor$inlined.newInstance();
                    if(object0 == null) {
                        throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B26060202160F030B00"));
                    }
                    ((Throwable)object0).initCause(throwable0);
                    object1 = Result.constructor-impl(((Throwable)object0));
                }
                catch(Throwable throwable1) {
                    object1 = Result.constructor-impl(ResultKt.createFailure(throwable1));
                }
                if(Result.isFailure-impl(object1)) {
                    object1 = null;
                }
                return (Throwable)object1;
            }
        };
    }

    private static final int fieldsCount(Class class0, int v) {
        do {
            Field[] arr_field = class0.getDeclaredFields();
            int v2 = 0;
            for(int v1 = 0; v1 < arr_field.length; ++v1) {
                if(!Modifier.isStatic(arr_field[v1].getModifiers()) != 0) {
                    ++v2;
                }
            }
            v += v2;
            class0 = class0.getSuperclass();
        }
        while(class0 != null);
        return v;
    }

    static int fieldsCount$default(Class class0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        return ExceptionsConstructorKt.fieldsCount(class0, v);
    }

    private static final int fieldsCountOrDefault(Class class0, int v) {
        Integer integer0;
        JvmClassMappingKt.getKotlinClass(class0);
        try {
            integer0 = Result.constructor-impl(ExceptionsConstructorKt.fieldsCount$default(class0, 0, 1, null));
        }
        catch(Throwable throwable0) {
            integer0 = Result.constructor-impl(ResultKt.createFailure(throwable0));
        }
        Integer integer1 = v;
        if(Result.isFailure-impl(integer0)) {
            integer0 = integer1;
        }
        return integer0.intValue();
    }

    private static final Function1 safeCtor(Function1 function10) {
        return new Function1(function10) {
            final Function1 $block;

            {
                this.$block = function10;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Throwable)object0));
            }

            public final Throwable invoke(Throwable throwable0) {
                Object object0;
                try {
                    object0 = Result.constructor-impl(((Throwable)this.$block.invoke(throwable0)));
                }
                catch(Throwable throwable1) {
                    object0 = Result.constructor-impl(ResultKt.createFailure(throwable1));
                }
                if(Result.isFailure-impl(object0)) {
                    object0 = null;
                }
                return (Throwable)object0;
            }
        };
    }

    public static final Throwable tryCopyException(Throwable throwable0) {
        Object object0;
        if(throwable0 instanceof CopyableThrowable) {
            try {
                object0 = Result.constructor-impl(((CopyableThrowable)throwable0).createCopy());
            }
            catch(Throwable throwable1) {
                object0 = Result.constructor-impl(ResultKt.createFailure(throwable1));
            }
            if(Result.isFailure-impl(object0)) {
                object0 = null;
            }
            return (Throwable)object0;
        }
        Class class0 = throwable0.getClass();
        return (Throwable)ExceptionsConstructorKt.ctorCache.get(class0).invoke(throwable0);
    }
}

