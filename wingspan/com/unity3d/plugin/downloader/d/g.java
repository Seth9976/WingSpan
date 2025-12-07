package com.unity3d.plugin.downloader.d;

import android.util.Log;

final class g implements Runnable {
    final int a;
    final String b;
    final String c;
    final e d;

    g(e e0, int v, String s, String s1) {
        this.d = e0;
        this.a = v;
        this.b = s;
        this.c = s1;
        super();
    }

    @Override
    public final void run() {
        Log.i("LicenseChecker", "Received response.");
        if(this.d.a.i.contains(this.d.b)) {
            e.b(this.d);
            this.d.b.a(this.d.a.c, this.a, this.b, this.c);
            this.d.a.a(this.d.b);
        }
    }
}

