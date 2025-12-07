package com.unity3d.player;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

final class ReflectionHelper {
    static class b {
        private final Class a;
        private final String b;
        private final String c;
        private final int d;
        public volatile Member e;

        static int -$$Nest$fgetd(b reflectionHelper$b0) {
            return reflectionHelper$b0.d;
        }

        b(Class class0, String s, String s1) {
            this.a = class0;
            this.b = s;
            this.c = s1;
            this.d = ((class0.hashCode() + 0x20F) * 0x1F + s.hashCode()) * 0x1F + s1.hashCode();
        }

        // 去混淆评级： 中等(50)
        @Override
        public boolean equals(Object object0) {
            return object0 == this ? true : object0 instanceof b && (this.d == ((b)object0).d && this.c.equals(((b)object0).c) && this.b.equals(((b)object0).b) && this.a.equals(((b)object0).a));
        }

        @Override
        public int hashCode() {
            return this.d;
        }
    }

    static final class c {
        private long a;
        private boolean b;

        static long -$$Nest$fgeta(c reflectionHelper$c0) {
            return reflectionHelper$c0.a;
        }

        static boolean -$$Nest$fgetb(c reflectionHelper$c0) {
            return reflectionHelper$c0.b;
        }

        static void -$$Nest$fputa(c reflectionHelper$c0, long v) {
            reflectionHelper$c0.a = v;
        }

        public c(long v, boolean z) {
            this.a = v;
            this.b = z;
        }
    }

    static class d implements Runnable {
        final long a;
        final long b;

        public d(long v, long v1) {
            this.a = v;
            this.b = v1;
        }

        @Override
        public void run() {
            if(!ReflectionHelper.beginProxyCall(this.a)) {
                return;
            }
            try {
                ReflectionHelper.nativeProxyFinalize(this.b);
            }
            finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }

    protected static boolean LOG;
    protected static final boolean LOGV;
    private static b[] a;
    private static long b;
    private static long c;
    private static boolean d;

    static long -$$Nest$sfgetb() [...] // 潜在的解密器

    static {
        ReflectionHelper.a = new b[0x1000];
    }

    private static float a(Class class0, Class class1) {
        if(class0.equals(class1)) {
            return 1.0f;
        }
        if(!class0.isPrimitive() && !class1.isPrimitive()) {
            try {
                if(class0.asSubclass(class1) != null) {
                    return 0.5f;
                }
            }
            catch(ClassCastException unused_ex) {
            }
            try {
                if(class1.asSubclass(class0) != null) {
                    return 0.1f;
                }
            }
            catch(ClassCastException unused_ex) {
            }
        }
        return 0.0f;
    }

    private static float a(Class class0, Class[] arr_class, Class[] arr_class1) {
        float f = 1.0f;
        int v = 0;
        if(arr_class1.length == 0) {
            return 0.1f;
        }
        if((arr_class == null ? 0 : arr_class.length) + 1 != arr_class1.length) {
            return 0.0f;
        }
        if(arr_class != null) {
            float f1 = 1.0f;
            for(int v1 = 0; v < arr_class.length; ++v1) {
                f1 *= ReflectionHelper.a(arr_class[v], arr_class1[v1]);
                ++v;
            }
            f = f1;
        }
        return f * ReflectionHelper.a(class0, arr_class1[arr_class1.length - 1]);
    }

    private static Class a(String s, int[] arr_v) {
    label_0:
        if(arr_v[0] < s.length()) {
            int v = arr_v[0];
            arr_v[0] = v + 1;
            int v1 = s.charAt(v);
            switch(v1) {
                case 40: 
                case 41: {
                    goto label_0;
                }
                case 66: {
                    return Byte.TYPE;
                }
                case 67: {
                    return Character.TYPE;
                }
                case 68: {
                    return Double.TYPE;
                }
                case 70: {
                    return Float.TYPE;
                }
                case 73: {
                    return Integer.TYPE;
                }
                case 74: {
                    return Long.TYPE;
                }
                case 76: {
                    int v2 = s.indexOf(59, arr_v[0]);
                    if(v2 != -1) {
                        String s1 = s.substring(arr_v[0], v2);
                        arr_v[0] = v2 + 1;
                        String s2 = s1.replace('/', '.');
                        try {
                            return Class.forName(s2);
                        }
                        catch(ClassNotFoundException unused_ex) {
                        }
                    }
                    break;
                }
                case 83: {
                    return Short.TYPE;
                }
                case 86: {
                    return Void.TYPE;
                }
                case 90: {
                    return Boolean.TYPE;
                }
                case 91: {
                    return Array.newInstance(ReflectionHelper.a(s, arr_v), 0).getClass();
                }
                default: {
                    u.Log(5, "! parseType; " + ((char)v1) + " is not known!");
                    return null;
                }
            }
        }
        return null;
    }

    private static void a(b reflectionHelper$b0, Member member0) {
        synchronized(ReflectionHelper.class) {
            reflectionHelper$b0.e = member0;
            ReflectionHelper.a[b.-$$Nest$fgetd(reflectionHelper$b0) & ReflectionHelper.a.length - 1] = reflectionHelper$b0;
        }
    }

    private static boolean a(b reflectionHelper$b0) {
        synchronized(ReflectionHelper.class) {
            b reflectionHelper$b1 = ReflectionHelper.a[b.-$$Nest$fgetd(reflectionHelper$b0) & ReflectionHelper.a.length - 1];
            if(!reflectionHelper$b0.equals(reflectionHelper$b1)) {
                return false;
            }
            reflectionHelper$b0.e = reflectionHelper$b1.e;
            return true;
        }
    }

    private static Class[] a(String s) {
        int[] arr_v = {0};
        int v = 0;
        ArrayList arrayList0 = new ArrayList();
        while(arr_v[0] < s.length()) {
            Class class0 = ReflectionHelper.a(s, arr_v);
            if(class0 == null) {
                break;
            }
            arrayList0.add(class0);
        }
        Class[] arr_class = new Class[arrayList0.size()];
        for(Object object0: arrayList0) {
            arr_class[v] = (Class)object0;
            ++v;
        }
        return arr_class;
    }

    protected static boolean beginProxyCall(long v) {
        synchronized(ReflectionHelper.class) {
            if(v == ReflectionHelper.b) {
                ++ReflectionHelper.c;
                return true;
            }
        }
        return false;
    }

    protected static Object createInvocationError(long v, boolean z) {
        return new c(v, z);
    }

    protected static void endProxyCall() {
        synchronized(ReflectionHelper.class) {
            long v1 = ReflectionHelper.c - 1L;
            ReflectionHelper.c = v1;
            if(0L == v1 && ReflectionHelper.d) {
                ReflectionHelper.class.notifyAll();
            }
        }
    }

    protected static void endUnityLaunch() {
        synchronized(ReflectionHelper.class) {
            try {
                ++ReflectionHelper.b;
                ReflectionHelper.d = true;
            label_5:
                while(ReflectionHelper.c > 0L) {
                    ReflectionHelper.class.wait();
                }
            }
            catch(InterruptedException unused_ex) {
                u.Log(6, "Interrupted while waiting for all proxies to exit.");
                if(true) {
                    ReflectionHelper.d = false;
                    return;
                }
                goto label_5;
            }
        }
        ReflectionHelper.d = false;
    }

    protected static Constructor getConstructorID(Class class0, String s) {
        Constructor constructor0;
        b reflectionHelper$b0 = new b(class0, "", s);
        if(ReflectionHelper.a(reflectionHelper$b0)) {
            constructor0 = (Constructor)reflectionHelper$b0.e;
        }
        else {
            Class[] arr_class = ReflectionHelper.a(s);
            Constructor[] arr_constructor = class0.getConstructors();
            Constructor constructor1 = null;
            float f = 0.0f;
            for(int v = 0; v < arr_constructor.length; ++v) {
                Constructor constructor2 = arr_constructor[v];
                float f1 = ReflectionHelper.a(Void.TYPE, constructor2.getParameterTypes(), arr_class);
                if(f1 > f) {
                    if(f1 == 1.0f) {
                        constructor1 = constructor2;
                        break;
                    }
                    constructor1 = constructor2;
                    f = f1;
                }
            }
            ReflectionHelper.a(reflectionHelper$b0, constructor1);
            constructor0 = constructor1;
        }
        if(constructor0 == null) {
            throw new NoSuchMethodError("<init>" + s + " in class " + class0.getName());
        }
        return constructor0;
    }

    protected static Field getFieldID(Class class0, String s, String s1, boolean z) {
        Field field0;
        b reflectionHelper$b0 = new b(class0, s, s1);
        if(ReflectionHelper.a(reflectionHelper$b0)) {
            field0 = (Field)reflectionHelper$b0.e;
        }
        else {
            Class[] arr_class = ReflectionHelper.a(s1);
            float f = 0.0f;
            Field field1 = null;
            while(class0 != null) {
                Field[] arr_field = class0.getDeclaredFields();
                for(int v = 0; v < arr_field.length; ++v) {
                    Field field2 = arr_field[v];
                    if(z == Modifier.isStatic(field2.getModifiers()) && field2.getName().compareTo(s) == 0) {
                        float f1 = ReflectionHelper.a(field2.getType(), null, arr_class);
                        if(f1 > f) {
                            field1 = field2;
                            if(Float.compare(f1, 1.0f) == 0) {
                                f = f1;
                                break;
                            }
                            else {
                                f = f1;
                            }
                        }
                    }
                }
                if(f == 1.0f || class0.isPrimitive() || class0.isInterface() || class0.equals(Object.class) || class0.equals(Void.TYPE)) {
                    ReflectionHelper.a(reflectionHelper$b0, field1);
                    field0 = field1;
                }
                else {
                    class0 = class0.getSuperclass();
                    continue;
                }
                goto label_30;
            }
            ReflectionHelper.a(reflectionHelper$b0, field1);
            field0 = field1;
        }
    label_30:
        if(field0 == null) {
            throw new NoSuchFieldError(String.format("no %s field with name=\'%s\' signature=\'%s\' in class L%s;", (z ? "static" : "non-static"), s, s1, class0.getName()));
        }
        return field0;
    }

    protected static String getFieldSignature(Field field0) {
        Class class0 = field0.getType();
        if(class0.isPrimitive()) {
            String s = class0.getName();
            if("boolean".equals(s)) {
                return "Z";
            }
            if("byte".equals(s)) {
                return "B";
            }
            if("char".equals(s)) {
                return "C";
            }
            if("double".equals(s)) {
                return "D";
            }
            if("float".equals(s)) {
                return "F";
            }
            if("int".equals(s)) {
                return "I";
            }
            if("long".equals(s)) {
                return "J";
            }
            return "short".equals(s) ? "S" : s;
        }
        return class0.isArray() ? class0.getName().replace('.', '/') : "L" + class0.getName().replace('.', '/') + ";";
    }

    protected static Method getMethodID(Class class0, String s, String s1, boolean z) {
        Method method0;
        b reflectionHelper$b0 = new b(class0, s, s1);
        if(ReflectionHelper.a(reflectionHelper$b0)) {
            method0 = (Method)reflectionHelper$b0.e;
        }
        else {
            Class[] arr_class = ReflectionHelper.a(s1);
            Method method1 = null;
            float f = 0.0f;
            while(class0 != null) {
                Method[] arr_method = class0.getDeclaredMethods();
                for(int v = 0; v < arr_method.length; ++v) {
                    Method method2 = arr_method[v];
                    if(z == Modifier.isStatic(method2.getModifiers()) && method2.getName().compareTo(s) == 0) {
                        float f1 = ReflectionHelper.a(method2.getReturnType(), method2.getParameterTypes(), arr_class);
                        if(f1 > f) {
                            if(f1 == 1.0f) {
                                method1 = method2;
                                f = 1.0f;
                                break;
                            }
                            else {
                                method1 = method2;
                                f = f1;
                            }
                        }
                    }
                }
                if(f == 1.0f || class0.isPrimitive() || class0.isInterface() || class0.equals(Object.class) || class0.equals(Void.TYPE)) {
                    ReflectionHelper.a(reflectionHelper$b0, method1);
                    method0 = method1;
                }
                else {
                    class0 = class0.getSuperclass();
                    continue;
                }
                goto label_31;
            }
            ReflectionHelper.a(reflectionHelper$b0, method1);
            method0 = method1;
        }
    label_31:
        if(method0 == null) {
            throw new NoSuchMethodError(String.format("no %s method with name=\'%s\' signature=\'%s\' in class L%s;", (z ? "static" : "non-static"), s, s1, class0.getName()));
        }
        return method0;
    }

    private static native void nativeProxyFinalize(long arg0) {
    }

    private static native Object nativeProxyInvoke(long arg0, String arg1, Object[] arg2) {
    }

    private static native void nativeProxyJNIFreeGCHandle(long arg0) {
    }

    private static native void nativeProxyLogJNIInvokeException(long arg0) {
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer0, long v, Class class0) {
        return ReflectionHelper.newProxyInstance(unityPlayer0, v, new Class[]{class0});
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer0, long v, Class[] arr_class) {
        class a implements InvocationHandler {
            private Runnable a;
            private UnityPlayer b;
            private long c;
            final long d;

            a(long v, UnityPlayer unityPlayer0, Class[] arr_class) {
                this.a = new d(0L, v);
                this.b = unityPlayer0;
                this.c = 0L;
            }

            private Object a(Object object0, Method method0, Object[] arr_object, c reflectionHelper$c0) {
                long v;
                Object object1;
                try {
                    try {
                        if(arr_object == null) {
                            arr_object = new Object[0];
                        }
                        Class class0 = method0.getDeclaringClass();
                        Constructor constructor0 = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                        constructor0.setAccessible(true);
                        object1 = ((MethodHandles.Lookup)constructor0.newInstance(class0, 2)).in(class0).unreflectSpecial(method0, class0).bindTo(object0).invokeWithArguments(arr_object);
                        v = c.-$$Nest$fgeta(reflectionHelper$c0);
                    }
                    catch(NoClassDefFoundError unused_ex) {
                        u.Log(6, "Java interface default methods are only supported since Android Oreo");
                        ReflectionHelper.nativeProxyLogJNIInvokeException(c.-$$Nest$fgeta(reflectionHelper$c0));
                        c.-$$Nest$fputa(reflectionHelper$c0, 0L);
                        return null;
                    }
                }
                catch(Throwable throwable0) {
                    long v1 = c.-$$Nest$fgeta(reflectionHelper$c0);
                    if(v1 != 0L) {
                        ReflectionHelper.nativeProxyJNIFreeGCHandle(v1);
                    }
                    throw throwable0;
                }
                if(v != 0L) {
                    ReflectionHelper.nativeProxyJNIFreeGCHandle(v);
                }
                return object1;
            }

            @Override
            protected void finalize() {
                this.b.queueGLThreadEvent(this.a);
                super.finalize();
            }

            @Override
            public Object invoke(Object object0, Method method0, Object[] arr_object) {
                if(!ReflectionHelper.beginProxyCall(this.c)) {
                    u.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
                    return null;
                }
                try {
                    String s = method0.getName();
                    Object object1 = ReflectionHelper.nativeProxyInvoke(this.d, s, arr_object);
                    if(object1 instanceof c) {
                        if(c.-$$Nest$fgetb(((c)object1)) && (method0.getModifiers() & 0x400) == 0) {
                            return this.a(object0, method0, arr_object, ((c)object1));
                        }
                        ReflectionHelper.nativeProxyLogJNIInvokeException(c.-$$Nest$fgeta(((c)object1)));
                        return null;
                    }
                    return object1;
                }
                finally {
                    ReflectionHelper.endProxyCall();
                }
            }
        }

        a reflectionHelper$a0 = new a(v, unityPlayer0, arr_class);
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), arr_class, reflectionHelper$a0);
    }
}

