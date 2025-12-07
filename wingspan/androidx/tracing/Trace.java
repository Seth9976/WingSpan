package androidx.tracing;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    public static void beginAsyncSection(String s, int v) {
        if(Trace.sAsyncTraceBeginMethod == null) {
            try {
                TraceApi29Impl.beginAsyncSection(s, v);
                return;
            }
            catch(NoSuchMethodError | NoClassDefFoundError unused_ex) {
            }
        }
        Trace.beginAsyncSectionFallback(s, v);
    }

    private static void beginAsyncSectionFallback(String s, int v) {
        try {
            if(Trace.sAsyncTraceBeginMethod == null) {
                Trace.sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            Trace.sAsyncTraceBeginMethod.invoke(null, Trace.sTraceTagApp, s, v);
        }
        catch(Exception exception0) {
            Trace.handleException("asyncTraceBegin", exception0);
        }
    }

    public static void beginSection(String s) {
        TraceApi18Impl.beginSection(s);
    }

    public static void endAsyncSection(String s, int v) {
        if(Trace.sAsyncTraceEndMethod == null) {
            try {
                TraceApi29Impl.endAsyncSection(s, v);
                return;
            }
            catch(NoSuchMethodError | NoClassDefFoundError unused_ex) {
            }
        }
        Trace.endAsyncSectionFallback(s, v);
    }

    private static void endAsyncSectionFallback(String s, int v) {
        try {
            if(Trace.sAsyncTraceEndMethod == null) {
                Trace.sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            Trace.sAsyncTraceEndMethod.invoke(null, Trace.sTraceTagApp, s, v);
        }
        catch(Exception exception0) {
            Trace.handleException("asyncTraceEnd", exception0);
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    private static void handleException(String s, Exception exception0) {
        if(exception0 instanceof InvocationTargetException) {
            Throwable throwable0 = exception0.getCause();
            throw throwable0 instanceof RuntimeException ? ((RuntimeException)throwable0) : new RuntimeException(throwable0);
        }
        Log.v("Trace", "Unable to call " + s + " via reflection", exception0);
    }

    public static boolean isEnabled() {
        if(Trace.sIsTagEnabledMethod == null) {
            try {
                return android.os.Trace.isEnabled();
            }
            catch(NoSuchMethodError | NoClassDefFoundError unused_ex) {
            }
        }
        return Trace.isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        try {
            if(Trace.sIsTagEnabledMethod == null) {
                Trace.sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Trace.sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean)Trace.sIsTagEnabledMethod.invoke(null, Trace.sTraceTagApp)).booleanValue();
        }
        catch(Exception exception0) {
            Trace.handleException("isTagEnabled", exception0);
            return false;
        }
    }

    public static void setCounter(String s, int v) {
        if(Trace.sTraceCounterMethod == null) {
            try {
                TraceApi29Impl.setCounter(s, v);
                return;
            }
            catch(NoSuchMethodError | NoClassDefFoundError unused_ex) {
            }
        }
        Trace.setCounterFallback(s, v);
    }

    private static void setCounterFallback(String s, int v) {
        try {
            if(Trace.sTraceCounterMethod == null) {
                Trace.sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            Trace.sTraceCounterMethod.invoke(null, Trace.sTraceTagApp, s, v);
        }
        catch(Exception exception0) {
            Trace.handleException("traceCounter", exception0);
        }
    }
}

