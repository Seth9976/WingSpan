package androidx.work;

import android.util.Log;

public abstract class Logger {
    public static class LogcatLogger extends Logger {
        private final int mLoggingLevel;

        public LogcatLogger(int loggingLevel) {
            super(loggingLevel);
            this.mLoggingLevel = loggingLevel;
        }

        @Override  // androidx.work.Logger
        public void debug(String tag, String message) {
            if(this.mLoggingLevel <= 3) {
                Log.d(tag, message);
            }
        }

        @Override  // androidx.work.Logger
        public void debug(String tag, String message, Throwable throwable) {
            if(this.mLoggingLevel <= 3) {
                Log.d(tag, message, throwable);
            }
        }

        @Override  // androidx.work.Logger
        public void error(String tag, String message) {
            if(this.mLoggingLevel <= 6) {
                Log.e(tag, message);
            }
        }

        @Override  // androidx.work.Logger
        public void error(String tag, String message, Throwable throwable) {
            if(this.mLoggingLevel <= 6) {
                Log.e(tag, message, throwable);
            }
        }

        @Override  // androidx.work.Logger
        public void info(String tag, String message) {
            if(this.mLoggingLevel <= 4) {
                Log.i(tag, message);
            }
        }

        @Override  // androidx.work.Logger
        public void info(String tag, String message, Throwable throwable) {
            if(this.mLoggingLevel <= 4) {
                Log.i(tag, message, throwable);
            }
        }

        @Override  // androidx.work.Logger
        public void verbose(String tag, String message) {
            if(this.mLoggingLevel <= 2) {
                Log.v(tag, message);
            }
        }

        @Override  // androidx.work.Logger
        public void verbose(String tag, String message, Throwable throwable) {
            if(this.mLoggingLevel <= 2) {
                Log.v(tag, message, throwable);
            }
        }

        @Override  // androidx.work.Logger
        public void warning(String tag, String message) {
            if(this.mLoggingLevel <= 5) {
                Log.w(tag, message);
            }
        }

        @Override  // androidx.work.Logger
        public void warning(String tag, String message, Throwable throwable) {
            if(this.mLoggingLevel <= 5) {
                Log.w(tag, message, throwable);
            }
        }
    }

    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static final Object sLock;
    private static volatile Logger sLogger;

    static {
        Logger.sLock = new Object();
    }

    public Logger(int loggingLevel) {
    }

    public abstract void debug(String arg1, String arg2);

    public abstract void debug(String arg1, String arg2, Throwable arg3);

    public abstract void error(String arg1, String arg2);

    public abstract void error(String arg1, String arg2, Throwable arg3);

    public static Logger get() {
        synchronized(Logger.sLock) {
            if(Logger.sLogger == null) {
                Logger.sLogger = new LogcatLogger(3);
            }
            return Logger.sLogger;
        }
    }

    public abstract void info(String arg1, String arg2);

    public abstract void info(String arg1, String arg2, Throwable arg3);

    public static void setLogger(Logger logger) {
        synchronized(Logger.sLock) {
            Logger.sLogger = logger;
        }
    }

    public static String tagWithPrefix(String tag) {
        StringBuilder stringBuilder0 = new StringBuilder(23);
        stringBuilder0.append("WM-");
        if(tag.length() >= Logger.MAX_PREFIXED_TAG_LENGTH) {
            stringBuilder0.append(tag.substring(0, 20));
            return stringBuilder0.toString();
        }
        stringBuilder0.append(tag);
        return stringBuilder0.toString();
    }

    public abstract void verbose(String arg1, String arg2);

    public abstract void verbose(String arg1, String arg2, Throwable arg3);

    public abstract void warning(String arg1, String arg2);

    public abstract void warning(String arg1, String arg2, Throwable arg3);
}

