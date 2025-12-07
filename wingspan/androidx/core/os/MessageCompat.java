package androidx.core.os;

import android.os.Message;

public final class MessageCompat {
    static class Api22Impl {
        static boolean isAsynchronous(Message message0) {
            return message0.isAsynchronous();
        }

        static void setAsynchronous(Message message0, boolean z) {
            message0.setAsynchronous(z);
        }
    }

    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    static {
    }

    public static boolean isAsynchronous(Message message0) {
        return Api22Impl.isAsynchronous(message0);
    }

    public static void setAsynchronous(Message message0, boolean z) {
        Api22Impl.setAsynchronous(message0, z);
    }
}

