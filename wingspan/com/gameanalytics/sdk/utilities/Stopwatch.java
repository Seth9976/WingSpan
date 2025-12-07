package com.gameanalytics.sdk.utilities;

import com.gameanalytics.sdk.logging.GALogger;
import java.util.HashMap;

public class Stopwatch {
    private boolean isRunning;
    private long startTimestamp;
    private static HashMap timers;
    private long totalTime;

    static {
        Stopwatch.timers = new HashMap();
    }

    public Stopwatch() {
        this.totalTime = 0L;
        this.isRunning = false;
        this.start();
    }

    public long getTime() {
        this.updateTotalTime();
        return this.totalTime;
    }

    public static String getTimeString(long timeMillis) {
        return timeMillis >= 10000L ? ((double)timeMillis) / 1000.0 + " s" : timeMillis + " ms";
    }

    public String getTimeString() {
        return Stopwatch.getTimeString(this.getTime());
    }

    public void pause() {
        if(this.isRunning) {
            this.updateTotalTime();
            this.isRunning = false;
        }
    }

    public static void pauseTimer(String key) {
        if(Stopwatch.timers.containsKey(key)) {
            ((Stopwatch)Stopwatch.timers.get(key)).pause();
            return;
        }
        GALogger.w(("pauseTimer: no value found for key=" + key));
    }

    public void reset() {
        this.totalTime = 0L;
        this.startTimestamp = System.currentTimeMillis();
    }

    public void resume() {
        this.start();
    }

    public static void resumeTimer(String key) {
        if(Stopwatch.timers.containsKey(key)) {
            ((Stopwatch)Stopwatch.timers.get(key)).resume();
            return;
        }
        GALogger.w(("resumeTimer: no value found for key=" + key));
    }

    public long split() {
        if(this.isRunning) {
            this.updateTotalTime();
        }
        return this.totalTime;
    }

    public void start() {
        if(this.isRunning) {
            return;
        }
        this.startTimestamp = System.currentTimeMillis();
        this.isRunning = true;
    }

    public static void startTimer(String key) {
        if(Stopwatch.timers.containsKey(key)) {
            GALogger.w(("startTimer: overriding old value for key=" + key));
        }
        Stopwatch.timers.put(key, new Stopwatch());
    }

    public long stop() {
        if(this.isRunning) {
            this.updateTotalTime();
            this.isRunning = false;
        }
        return this.totalTime;
    }

    public static long stopTimer(String key) {
        if(Stopwatch.timers.containsKey(key)) {
            return ((Stopwatch)Stopwatch.timers.get(key)).stop();
        }
        GALogger.w(("stopTimer: no value found for key=" + key));
        return 0L;
    }

    private void updateTotalTime() {
        long v = System.currentTimeMillis();
        long v1 = v - this.startTimestamp;
        this.startTimestamp = v;
        this.totalTime += v1;
    }
}

