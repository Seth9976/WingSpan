package com.onesignal.debug.internal.logging;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.util.Log;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\fH\u0007J\u001C\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007J\u001C\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007J\u001C\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007J\u001C\u0010 \u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007J\u0018\u0010!\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u0004H\u0007J\"\u0010!\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u00042\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007J\u001C\u0010\"\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007J\u001C\u0010#\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00042\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000B\u001A\u00020\f8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001A\u00020\f8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001A\u0004\b\u0014\u0010\u000F\"\u0004\b\u0015\u0010\u0011¨\u0006$"}, d2 = {"Lcom/onesignal/debug/internal/logging/Logging;", "", "()V", "TAG", "", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "getApplicationService", "()Lcom/onesignal/core/internal/application/IApplicationService;", "setApplicationService", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "logLevel", "Lcom/onesignal/debug/LogLevel;", "getLogLevel$annotations", "getLogLevel", "()Lcom/onesignal/debug/LogLevel;", "setLogLevel", "(Lcom/onesignal/debug/LogLevel;)V", "visualLogLevel", "getVisualLogLevel$annotations", "getVisualLogLevel", "setVisualLogLevel", "atLogLevel", "", "level", "debug", "", "message", "throwable", "", "error", "fatal", "info", "log", "verbose", "warn", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Logging {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[LogLevel.values().length];
            arr_v[LogLevel.VERBOSE.ordinal()] = 1;
            arr_v[LogLevel.DEBUG.ordinal()] = 2;
            arr_v[LogLevel.INFO.ordinal()] = 3;
            arr_v[LogLevel.WARN.ordinal()] = 4;
            arr_v[LogLevel.ERROR.ordinal()] = 5;
            arr_v[LogLevel.FATAL.ordinal()] = 6;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final Logging INSTANCE = null;
    private static final String TAG = "OneSignal";
    private static IApplicationService applicationService;
    private static LogLevel logLevel;
    private static LogLevel visualLogLevel;

    static {
        Logging.INSTANCE = new Logging();
        Logging.logLevel = LogLevel.WARN;
        Logging.visualLogLevel = LogLevel.NONE;
    }

    @JvmStatic
    public static final boolean atLogLevel(LogLevel logLevel0) {
        Intrinsics.checkNotNullParameter(logLevel0, "level");
        return logLevel0.compareTo(Logging.visualLogLevel) < 1 || logLevel0.compareTo(Logging.logLevel) < 1;
    }

    @JvmStatic
    public static final void debug(String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(LogLevel.DEBUG, s, throwable0);
    }

    public static void debug$default(String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        Logging.debug(s, throwable0);
    }

    @JvmStatic
    public static final void error(String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(LogLevel.ERROR, s, throwable0);
    }

    public static void error$default(String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        Logging.error(s, throwable0);
    }

    @JvmStatic
    public static final void fatal(String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(LogLevel.FATAL, s, throwable0);
    }

    public static void fatal$default(String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        Logging.fatal(s, throwable0);
    }

    public final IApplicationService getApplicationService() {
        return Logging.applicationService;
    }

    public static final LogLevel getLogLevel() {
        return Logging.logLevel;
    }

    @JvmStatic
    public static void getLogLevel$annotations() {
    }

    public static final LogLevel getVisualLogLevel() {
        return Logging.visualLogLevel;
    }

    @JvmStatic
    public static void getVisualLogLevel$annotations() {
    }

    @JvmStatic
    public static final void info(String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(LogLevel.INFO, s, throwable0);
    }

    public static void info$default(String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        Logging.info(s, throwable0);
    }

    @JvmStatic
    public static final void log(LogLevel logLevel0, String s) {
        Intrinsics.checkNotNullParameter(logLevel0, "level");
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(logLevel0, s, null);
    }

    @JvmStatic
    public static final void log(LogLevel logLevel0, String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(logLevel0, "level");
        Intrinsics.checkNotNullParameter(s, "message");
        if(logLevel0.compareTo(Logging.logLevel) < 1) {
            switch(WhenMappings.$EnumSwitchMapping$0[logLevel0.ordinal()]) {
                case 1: {
                    Log.v("OneSignal", "[jeb-dexdec-sb-st-705] " + s, throwable0);
                    break;
                }
                case 2: {
                    Log.d("OneSignal", "[jeb-dexdec-sb-st-705] " + s, throwable0);
                    break;
                }
                case 3: {
                    Log.i("OneSignal", "[jeb-dexdec-sb-st-705] " + s, throwable0);
                    break;
                }
                case 4: {
                    Log.w("OneSignal", "[jeb-dexdec-sb-st-705] " + s, throwable0);
                    break;
                }
                case 5: 
                case 6: {
                    Log.e("OneSignal", s, throwable0);
                }
            }
        }
        if(logLevel0.compareTo(Logging.visualLogLevel) < 1 && (Logging.applicationService == null ? null : Logging.applicationService.getCurrent()) != null) {
            try {
                String s1 = StringsKt.trimIndent((s + '\n'));
                if(throwable0 != null) {
                    StringWriter stringWriter0 = new StringWriter();
                    throwable0.printStackTrace(new PrintWriter(stringWriter0));
                    s1 = s1 + throwable0.getMessage() + stringWriter0;
                }
                ThreadUtilsKt.suspendifyOnMain(new Function1(logLevel0, s1, null) {
                    final String $finalFullMessage;
                    final LogLevel $level;
                    int label;

                    {
                        this.$level = logLevel0;
                        this.$finalFullMessage = s;
                        super(1, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Continuation continuation0) {
                        return new com.onesignal.debug.internal.logging.Logging.log.1(this.$level, this.$finalFullMessage, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.onesignal.debug.internal.logging.Logging.log.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        IApplicationService iApplicationService0 = Logging.INSTANCE.getApplicationService();
                        Activity activity0 = iApplicationService0 == null ? null : iApplicationService0.getCurrent();
                        if(activity0 != null) {
                            new AlertDialog.Builder(activity0).setTitle(this.$level.toString()).setMessage(this.$finalFullMessage).show();
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            catch(Throwable throwable1) {
                Log.e("OneSignal", "Error showing logging message.", throwable1);
            }
        }
    }

    public final void setApplicationService(IApplicationService iApplicationService0) {
        Logging.applicationService = iApplicationService0;
    }

    public static final void setLogLevel(LogLevel logLevel0) {
        Intrinsics.checkNotNullParameter(logLevel0, "<set-?>");
        Logging.logLevel = logLevel0;
    }

    public static final void setVisualLogLevel(LogLevel logLevel0) {
        Intrinsics.checkNotNullParameter(logLevel0, "<set-?>");
        Logging.visualLogLevel = logLevel0;
    }

    @JvmStatic
    public static final void verbose(String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(LogLevel.VERBOSE, s, throwable0);
    }

    public static void verbose$default(String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        Logging.verbose(s, throwable0);
    }

    @JvmStatic
    public static final void warn(String s, Throwable throwable0) {
        Intrinsics.checkNotNullParameter(s, "message");
        Logging.log(LogLevel.WARN, s, throwable0);
    }

    public static void warn$default(String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        Logging.warn(s, throwable0);
    }
}

