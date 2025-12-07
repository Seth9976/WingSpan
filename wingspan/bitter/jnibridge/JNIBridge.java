package bitter.jnibridge;

import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import jeb.synthetic.FIN;

public class JNIBridge {
    static class a implements InvocationHandler {
        private Object a;
        private long b;
        private Constructor c;

        public a(long v) {
            this.a = new Object[0];
            this.b = v;
            try {
                Constructor constructor0 = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                this.c = constructor0;
                constructor0.setAccessible(true);
            }
            catch(NoClassDefFoundError | NoSuchMethodException unused_ex) {
                this.c = null;
            }
        }

        @Override
        public Object invoke(Object object0, Method method0, Object[] arr_object) {
            Object object1 = this.a;
            __monitor_enter(object1);
            int v = FIN.finallyOpen$NT();
            long v1 = this.b;
            if(v1 == 0L) {
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(object1);
                FIN.finallyCodeEnd$NT(v);
                return null;
            }
            try {
                Object object2 = JNIBridge.invoke(v1, method0.getDeclaringClass(), method0, arr_object);
                FIN.finallyExec$NT(v);
                return object2;
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                if(this.c != null) {
                    if((method0.getModifiers() & 0x400) == 0) {
                        if(arr_object == null) {
                            arr_object = new Object[0];
                        }
                        Class class0 = method0.getDeclaringClass();
                        FIN.finallyExec$NT(v);
                        return ((MethodHandles.Lookup)this.c.newInstance(class0, 2)).in(class0).unreflectSpecial(method0, class0).bindTo(object0).invokeWithArguments(arr_object);
                    }
                    FIN.finallyExec$NT(v);
                    throw noSuchMethodError0;
                }
                System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                FIN.finallyExec$NT(v);
                throw noSuchMethodError0;
            }
        }
    }

    static void disableInterfaceProxy(Object object0) {
        if(object0 != null) {
            a jNIBridge$a0 = (a)Proxy.getInvocationHandler(object0);
            Object object1 = jNIBridge$a0.a;
            synchronized(object1) {
                jNIBridge$a0.b = 0L;
            }
        }
    }

    static native Object invoke(long arg0, Class arg1, Method arg2, Object[] arg3) {
    }

    static Object newInterfaceProxy(long v, Class[] arr_class) {
        a jNIBridge$a0 = new a(v);
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), arr_class, jNIBridge$a0);
    }
}

