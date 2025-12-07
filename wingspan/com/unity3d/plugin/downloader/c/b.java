package com.unity3d.plugin.downloader.c;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class b extends Handler {
    final a a;

    public b(a a0, Looper looper0) {
        this.a = a0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        this.a.a(((Intent)message0.obj));
        if(this.a.e()) {
            Log.d("CustomIntentService", "stopSelf");
            this.a.stopSelf(message0.arg1);
            Log.d("CustomIntentService", "afterStopSelf");
        }
    }
}

