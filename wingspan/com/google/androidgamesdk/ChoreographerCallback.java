package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;

public class ChoreographerCallback implements Choreographer.FrameCallback {
    class b extends Thread {
        public Handler a;

        private b() {
        }

        b(ChoreographerCallback.b-IA choreographerCallback$b-IA0) {
        }

        @Override
        public void run() {
            Log.i("ChoreographerCallback", "Starting looper thread");
            Looper.prepare();
            this.a = new Handler();
            Looper.loop();
            Log.i("ChoreographerCallback", "Terminating looper thread");
        }
    }

    private static final String LOG_TAG = "ChoreographerCallback";
    private long mCookie;
    private b mLooper;

    public ChoreographerCallback(long v) {
        this.mCookie = v;
        b choreographerCallback$b0 = new b(this, null);
        this.mLooper = choreographerCallback$b0;
        choreographerCallback$b0.start();
    }

    @Override  // android.view.Choreographer$FrameCallback
    public void doFrame(long v) {
        this.nOnChoreographer(this.mCookie, v);
    }

    public native void nOnChoreographer(long arg1, long arg2) {
    }

    public void postFrameCallback() {
        class a implements Runnable {
            final ChoreographerCallback a;

            @Override
            public void run() {
                Choreographer.getInstance().postFrameCallback(ChoreographerCallback.this);
            }
        }

        this.mLooper.a.post(new a(this));
    }

    public void postFrameCallbackDelayed(long v) {
        Choreographer.getInstance().postFrameCallbackDelayed(this, v);
    }

    public void terminate() {
        this.mLooper.a.getLooper().quit();
    }
}

