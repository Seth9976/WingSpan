package com.unity3d.plugin.downloader.c;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class l extends BroadcastReceiver {
    final Service a;
    final j b;

    l(j j0, Service service0) {
        this.b = j0;
        super();
        this.a = service0;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        this.b.f();
        if(this.b.mStateChanged && !j.m()) {
            Log.d("LVLDL", "InnerBroadcastReceiver Called");
            Intent intent1 = new Intent(context0, this.a.getClass());
            intent1.putExtra("EPI", this.b.mPendingIntent);
            context0.startService(intent1);
        }
    }
}

