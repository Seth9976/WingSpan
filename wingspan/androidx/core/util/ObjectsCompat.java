package androidx.core.util;

import java.util.Objects;

public class ObjectsCompat {
    static class Api19Impl {
        static boolean equals(Object object0, Object object1) {
            return Objects.equals(object0, object1);
        }

        static int hash(Object[] arr_object) {
            return Objects.hash(arr_object);
        }
    }

    public static boolean equals(Object object0, Object object1) {
        return Api19Impl.equals(object0, object1);
    }

    public static int hash(Object[] arr_object) {
        return Api19Impl.hash(arr_object);
    }

    public static int hashCode(Object object0) {
        return object0 == null ? 0 : object0.hashCode();
    }

    public static Object requireNonNull(Object object0) {
        object0.getClass();
        return object0;
    }

    public static Object requireNonNull(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
        return object0;
    }

    public static String toString(Object object0, String s) {
        return object0 == null ? s : object0.toString();
    }
}

