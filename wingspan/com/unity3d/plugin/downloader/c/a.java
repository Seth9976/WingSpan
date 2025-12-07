package com.unity3d.plugin.downloader.c;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public abstract class a extends Service {
    private static final String LOG_TAG = "CustomIntentService";
    private static final int WHAT_MESSAGE = -10;
    private String mName;
    private boolean mRedelivery;
    private volatile b mServiceHandler;
    private volatile Looper mServiceLooper;

    public a(String s) {
        this.mName = s;
    }

    protected abstract void a(Intent arg1);

    protected abstract boolean e();

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        return null;
    }

    @Override  // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread0 = new HandlerThread("IntentService[" + this.mName + "]");
        handlerThread0.start();
        this.mServiceLooper = handlerThread0.getLooper();
        this.mServiceHandler = new b(this, this.mServiceLooper);
    }

    @Override  // android.app.Service
    public void onDestroy() {
        Thread thread0 = this.mServiceLooper.getThread();
        if(thread0 != null && thread0.isAlive()) {
            thread0.interrupt();
        }
        this.mServiceLooper.quit();
        Log.d("CustomIntentService", "onDestroy");
    }

    @Override  // android.app.Service
    public void onStart(Intent intent0, int v) {
        if(!this.mServiceHandler.hasMessages(-10)) {
            Message message0 = this.mServiceHandler.obtainMessage();
            message0.arg1 = v;
            message0.obj = intent0;
            message0.what = -10;
            this.mServiceHandler.sendMessage(message0);
        }
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        this.onStart(intent0, v1);
        return this.mRedelivery ? 3 : 2;
    }
}

