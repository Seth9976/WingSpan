package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;

class l {
    private final Context a;
    private final AudioManager b;
    private j c;

    public l(Context context0) {
        this.a = context0;
        this.b = (AudioManager)context0.getSystemService("audio");
    }

    public void a() {
        if(this.c != null) {
            this.a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public void a(int v, k k0) {
        this.c = new j(this, new Handler(Looper.getMainLooper()), this.b, v, k0);
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}

