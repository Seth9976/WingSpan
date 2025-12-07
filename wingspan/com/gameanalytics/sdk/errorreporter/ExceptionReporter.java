package com.gameanalytics.sdk.errorreporter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import com.gameanalytics.sdk.GAErrorSeverity;
import com.gameanalytics.sdk.GAPlatform.FunctionInfo;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.events.GAEvents;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import org.json.JSONException;

public final class ExceptionReporter {
    class Handler implements Thread.UncaughtExceptionHandler {
        private ExceptionReporter errorHandler;
        private Thread.UncaughtExceptionHandler subject;

        private Handler(Thread.UncaughtExceptionHandler subject) {
            this.subject = subject;
            this.errorHandler = this$0;
        }

        Handler(Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0, com.gameanalytics.sdk.errorreporter.ExceptionReporter.1 exceptionReporter$10) {
            this(thread$UncaughtExceptionHandler0);
        }

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            GALogger.d("ExceptionReporter uncaughtException");
            try {
                ExceptionReporter.this.reportException(thread, ex);
            }
            catch(Exception exception0) {
                GALogger.e(("Error while reporting exception: " + exception0.toString()));
            }
            Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = this.subject;
            if(thread$UncaughtExceptionHandler0 != null) {
                thread$UncaughtExceptionHandler0.uncaughtException(thread, ex);
            }
        }
    }

    private static HashMap ErrorTypeCountMap = null;
    private static final int FIXED_JOB_ID = 0x3039;
    private static final int MAX_ERROR_TYPE_COUNT = 20;
    private Context context;
    private Handler handler;

    static {
        ExceptionReporter.ErrorTypeCountMap = new HashMap();
    }

    private ExceptionReporter(Thread.UncaughtExceptionHandler defaultHandler, Context context) {
        this.handler = new Handler(this, defaultHandler, null);
        this.setContext(context);
    }

    private static long getAvailableBlocks(StatFs stat) {
        return ExceptionReporter.getAvailableBlocks18AndAbove(stat);
    }

    private static long getAvailableBlocks17AndBelow(StatFs stat) {
        return (long)stat.getAvailableBlocks();
    }

    private static long getAvailableBlocks18AndAbove(StatFs stat) {
        return stat.getAvailableBlocksLong();
    }

    private static long getBlockCount(StatFs stat) {
        return ExceptionReporter.getBlockCount18AndAbove(stat);
    }

    private static long getBlockCount17AndBelow(StatFs stat) {
        return (long)stat.getBlockCount();
    }

    private static long getBlockCount18AndAbove(StatFs stat) {
        return stat.getBlockCountLong();
    }

    private static long getBlockSize(StatFs stat) {
        return ExceptionReporter.getBlockSize18AndAbove(stat);
    }

    private static long getBlockSize17AndBelow(StatFs stat) {
        return (long)stat.getBlockSize();
    }

    private static long getBlockSize18AndAbove(StatFs stat) {
        return stat.getBlockSizeLong();
    }

    public static ExceptionReporter register(Context context) {
        GALogger.d("Registering ExceptionReporter");
        Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = Thread.getDefaultUncaughtExceptionHandler();
        if(thread$UncaughtExceptionHandler0 instanceof Handler) {
            ((Handler)thread$UncaughtExceptionHandler0).errorHandler.setContext(context);
            return ((Handler)thread$UncaughtExceptionHandler0).errorHandler;
        }
        ExceptionReporter exceptionReporter0 = new ExceptionReporter(thread$UncaughtExceptionHandler0, context);
        Thread.setDefaultUncaughtExceptionHandler(exceptionReporter0.handler);
        return exceptionReporter0;
    }

    public void reportException(Thread thread, Throwable ex) {
        this.reportException(thread, ex, null);
    }

    public void reportException(Thread thread, Throwable ex, String extraMessage) {
        StringWriter stringWriter0 = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter0));
        String s1 = stringWriter0.toString();
        Intent intent0 = new Intent();
        intent0.setData(Uri.parse(("custom://" + SystemClock.elapsedRealtime())));
        intent0.setAction(GameAnalyticsExceptionReportService.ACTION_SAVE_REPORT);
        String s2 = GAState.getGameKey();
        intent0.putExtra(GameAnalyticsExceptionReportService.EXTRA_GAME_KEY, s2);
        String s3 = GAState.getSecretKey();
        intent0.putExtra(GameAnalyticsExceptionReportService.EXTRA_SECRET_KEY, s3);
        intent0.putExtra(GameAnalyticsExceptionReportService.EXTRA_WRITABLE_PATH, GADevice.getWritableFilePath());
        intent0.putExtra(GameAnalyticsExceptionReportService.EXTRA_INFO_LOG_ENABLED, false);
        intent0.putExtra(GameAnalyticsExceptionReportService.EXTRA_VERBOSE_LOG_ENABLED, false);
        String s4 = ex.getClass().getName();
        String s5 = "# Type of exception: " + s4 + "\n" + "# Exception message: " + ex.getMessage() + "\n" + "# Thread name: " + thread.getName() + "\n";
        if(extraMessage != null) {
            s5 = s5 + "# Extra message: " + extraMessage + "\n";
        }
        String s6 = s5 + "# Stacktrace: " + s1;
        s6 = s6.length() <= 0x2000 ? s5 + "# Stacktrace: " + s1 : s6.substring(0, 0x2000);
        if(!ExceptionReporter.ErrorTypeCountMap.containsKey(s4)) {
            ExceptionReporter.ErrorTypeCountMap.put(s4, 0);
        }
        Integer integer0 = (Integer)ExceptionReporter.ErrorTypeCountMap.get(s4);
        if(integer0 != null && ((int)integer0) > 20) {
            return;
        }
        ExceptionReporter.ErrorTypeCountMap.put(s4, ((int)(((int)integer0) + 1)));
        FunctionInfo gAPlatform$FunctionInfo0 = new FunctionInfo();
        GAEvents.addErrorEvent(GAErrorSeverity.Critical, s6, null, false, "", gAPlatform$FunctionInfo0.line, "");
        GAEvents.cleanupEvents();
        try {
            GAEvents.fixMissingSessionEndEvents();
        }
        catch(JSONException unused_ex) {
        }
        intent0.setClass(this.context, GameAnalyticsExceptionReportService.class);
        GameAnalyticsExceptionReportService.enqueueWork(this.context, GameAnalyticsExceptionReportService.class, 0x3039, intent0);
    }

    private void setContext(Context context) {
        if(context.getApplicationContext() != null) {
            this.context = context.getApplicationContext();
            return;
        }
        this.context = context;
    }

    class com.gameanalytics.sdk.errorreporter.ExceptionReporter.1 {
    }

}

