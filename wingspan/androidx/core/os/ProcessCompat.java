package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

public final class ProcessCompat {
    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock;

        static {
            Api16Impl.sResolvedLock = new Object();
        }

        static boolean isApplicationUid(int v) {
            try {
                Object object0 = Api16Impl.sResolvedLock;
                synchronized(object0) {
                    if(!Api16Impl.sResolved) {
                        Api16Impl.sResolved = true;
                        Api16Impl.sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method0 = Api16Impl.sMethodUserIdIsAppMethod;
                if(method0 != null) {
                    Boolean boolean0 = (Boolean)method0.invoke(null, v);
                    if(boolean0 == null) {
                        throw new NullPointerException();
                    }
                    return boolean0.booleanValue();
                }
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
            return true;
        }
    }

    static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock;

        static {
            Api17Impl.sResolvedLock = new Object();
        }

        static boolean isApplicationUid(int v) {
            try {
                Object object0 = Api17Impl.sResolvedLock;
                synchronized(object0) {
                    if(!Api17Impl.sResolved) {
                        Api17Impl.sResolved = true;
                        Api17Impl.sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method0 = Api17Impl.sMethodUserHandleIsAppMethod;
                if(method0 != null) {
                    Boolean boolean0 = (Boolean)method0.invoke(null, v);
                    if(boolean0 == null) {
                        throw new NullPointerException();
                    }
                    return boolean0.booleanValue();
                }
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
            return true;
        }
    }

    static class Api24Impl {
        static boolean isApplicationUid(int v) {
            return Process.isApplicationUid(v);
        }
    }

    public static boolean isApplicationUid(int v) {
        return Build.VERSION.SDK_INT < 24 ? Api17Impl.isApplicationUid(v) : Api24Impl.isApplicationUid(v);
    }
}

