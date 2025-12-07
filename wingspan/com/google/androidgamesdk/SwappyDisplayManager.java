package com.google.androidgamesdk;

import android.app.Activity;
import android.hardware.display.DisplayManager.DisplayListener;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display.Mode;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    class b extends Thread {
        public Handler a;
        private Lock b;
        private Condition c;

        private b() {
            ReentrantLock reentrantLock0 = new ReentrantLock();
            this.b = reentrantLock0;
            this.c = reentrantLock0.newCondition();
        }

        b(SwappyDisplayManager.b-IA swappyDisplayManager$b-IA0) {
        }

        @Override
        public void run() {
            Log.i("SwappyDisplayManager", "Starting looper thread");
            this.b.lock();
            Looper.prepare();
            this.a = new Handler();
            this.c.signal();
            this.b.unlock();
            Looper.loop();
            Log.i("SwappyDisplayManager", "Terminating looper thread");
        }

        @Override
        public void start() {
            this.b.lock();
            super.start();
            try {
                this.c.await();
            }
            catch(InterruptedException interruptedException0) {
                interruptedException0.printStackTrace();
            }
            this.b.unlock();
        }
    }

    private final boolean DEBUG;
    private final String LOG_TAG;
    private final long ONE_MS_IN_NS;
    private final long ONE_S_IN_NS;
    private Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private b mLooper;
    private WindowManager mWindowManager;

    public SwappyDisplayManager(long v, Activity activity0) {
        this.LOG_TAG = "SwappyDisplayManager";
        this.DEBUG = false;
        this.ONE_MS_IN_NS = 1000000L;
        this.ONE_S_IN_NS = 1000000000L;
        try {
            Bundle bundle0 = activity0.getPackageManager().getActivityInfo(activity0.getIntent().getComponent(), 0x80).metaData;
            if(bundle0 != null) {
                String s = bundle0.getString("android.app.lib_name");
                if(s != null) {
                    System.loadLibrary(s);
                }
            }
        }
        catch(Throwable throwable0) {
            Log.e("SwappyDisplayManager", throwable0.getMessage());
        }
        this.mCookie = v;
        this.mActivity = activity0;
        WindowManager windowManager0 = (WindowManager)activity0.getSystemService(WindowManager.class);
        this.mWindowManager = windowManager0;
        Display display0 = windowManager0.getDefaultDisplay();
        this.mCurrentMode = display0.getMode();
        this.updateSupportedRefreshRates(display0);
        DisplayManager displayManager0 = (DisplayManager)this.mActivity.getSystemService(DisplayManager.class);
        synchronized(this) {
            b swappyDisplayManager$b0 = new b(this, null);
            this.mLooper = swappyDisplayManager$b0;
            swappyDisplayManager$b0.start();
            displayManager0.registerDisplayListener(this, this.mLooper.a);
        }
    }

    private boolean modeMatchesCurrentResolution(Display.Mode display$Mode0) {
        return display$Mode0.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && display$Mode0.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth();
    }

    private native void nOnRefreshPeriodChanged(long arg1, long arg2, long arg3, long arg4) {
    }

    private native void nSetSupportedRefreshPeriods(long arg1, long[] arg2, int[] arg3) {
    }

    @Override  // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayAdded(int v) {
    }

    @Override  // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayChanged(int v) {
        synchronized(this) {
            Display display0 = this.mWindowManager.getDefaultDisplay();
            float f = display0.getRefreshRate();
            Display.Mode display$Mode0 = display0.getMode();
            boolean z = true;
            int v2 = display$Mode0.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth() ? 0 : 1;
            int v3 = display$Mode0.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() ? 0 : 1;
            if(f == this.mCurrentMode.getRefreshRate()) {
                z = false;
            }
            this.mCurrentMode = display$Mode0;
            if((v2 | v3) != 0) {
                this.updateSupportedRefreshRates(display0);
            }
            if(z) {
                long v4 = display0.getAppVsyncOffsetNanos();
                long v5 = this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos();
                this.nOnRefreshPeriodChanged(this.mCookie, ((long)(1000000000.0f / f)), v4, ((long)(1000000000.0f / f)) - (v5 - 1000000L));
            }
        }
    }

    @Override  // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayRemoved(int v) {
    }

    public void setPreferredDisplayModeId(int v) {
        class a implements Runnable {
            final int a;
            final SwappyDisplayManager b;

            a(int v) {
                this.a = v;
                super();
            }

            @Override
            public void run() {
                Window window0 = SwappyDisplayManager.this.mActivity.getWindow();
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.preferredDisplayModeId = this.a;
                window0.setAttributes(windowManager$LayoutParams0);
            }
        }

        this.mActivity.runOnUiThread(new a(this, v));
    }

    public void terminate() {
        this.mLooper.a.getLooper().quit();
    }

    private void updateSupportedRefreshRates(Display display0) {
        Display.Mode[] arr_display$Mode = display0.getSupportedModes();
        int v2 = 0;
        for(int v1 = 0; v1 < arr_display$Mode.length; ++v1) {
            if(this.modeMatchesCurrentResolution(arr_display$Mode[v1])) {
                ++v2;
            }
        }
        long[] arr_v = new long[v2];
        int[] arr_v1 = new int[v2];
        int v3 = 0;
        for(int v = 0; v < arr_display$Mode.length; ++v) {
            if(this.modeMatchesCurrentResolution(arr_display$Mode[v])) {
                arr_v[v3] = (long)(1000000000.0f / arr_display$Mode[v].getRefreshRate());
                arr_v1[v3] = arr_display$Mode[v].getModeId();
                ++v3;
            }
        }
        this.nSetSupportedRefreshPeriods(this.mCookie, arr_v, arr_v1);
    }
}

