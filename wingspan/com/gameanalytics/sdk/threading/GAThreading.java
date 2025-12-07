package com.gameanalytics.sdk.threading;

import com.gameanalytics.sdk.logging.GALogger;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public final class GAThreading extends Timer {
    private static final GAThreading INSTANCE = null;
    private static final long THREAD_WAIT_TIME_IN_MS = 1000L;
    private final FIFOPriorityQueue blocks;
    private TimerTask task;

    static {
        GAThreading.INSTANCE = new GAThreading();
    }

    private GAThreading() {
        super("GA Thread");
        this.blocks = new FIFOPriorityQueue();
        this.task = null;
        this.startInternal();
    }

    private void addTimedBlock(TimedBlock timedBlock) {
        this.blocks.add(timedBlock);
    }

    private static TimerTask createTask() {
        return new TimerTask() {
            @Override
            public void run() {
                while(true) {
                    try {
                        TimedBlock timedBlock0 = GAThreading.getNextBlock();
                        if(timedBlock0 == null) {
                            break;
                        }
                        timedBlock0.block.execute();
                    }
                    catch(Exception exception0) {
                        GALogger.e("Error on GA thread");
                        exception0.printStackTrace();
                        break;
                    }
                }
            }
        };
    }

    private static GAThreading getInstance() {
        return GAThreading.INSTANCE;
    }

    private static TimedBlock getNextBlock() {
        synchronized(GAThreading.getInstance()) {
            Date date0 = new Date();
            return !GAThreading.getInstance().blocks.isEmpty() && ((TimedBlock)GAThreading.getInstance().blocks.peek()).deadLine.compareTo(date0) <= 0 ? ((TimedBlock)GAThreading.getInstance().blocks.poll()) : null;
        }
    }

    public static void performTaskDelayed(IBlock taskBlock, long delayInSeconds) {
        synchronized(GAThreading.getInstance()) {
            Date date0 = new Date();
            date0.setTime(date0.getTime() + delayInSeconds * 1000L);
            GAThreading.getInstance().addTimedBlock(new TimedBlock(date0, taskBlock));
        }
    }

    public static void performTaskOnGAThread(IBlock taskBlock) {
        GAThreading.performTaskDelayed(taskBlock, 0L);
    }

    public static void scheduleTimer(double interval, IBlock callback) {
        synchronized(GAThreading.getInstance()) {
            Date date0 = new Date();
            date0.setTime(date0.getTime() + ((long)(((long)interval) * 0x408F400000000000L)));
            GAThreading.getInstance().addTimedBlock(new TimedBlock(date0, callback));
        }
    }

    public static void start() {
        GAThreading.getInstance().startInternal();
    }

    private void startInternal() {
        if(this.task == null) {
            GALogger.d("Starting GA Thread");
            synchronized(this) {
                TimerTask timerTask0 = GAThreading.createTask();
                this.task = timerTask0;
                this.scheduleAtFixedRate(timerTask0, 0L, 1000L);
            }
        }
    }

    public static void stop() {
        if(GAThreading.getInstance().task != null) {
            GALogger.d("Stopping GA Thread");
            GAThreading gAThreading0 = GAThreading.getInstance();
            synchronized(gAThreading0) {
                GAThreading.getInstance().task.cancel();
                GAThreading.getInstance().task = null;
            }
        }
    }
}

