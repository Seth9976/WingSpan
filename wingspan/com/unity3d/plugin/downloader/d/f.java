package com.unity3d.plugin.downloader.d;

import android.util.Log;

final class f implements Runnable {
    final d a;
    final e b;

    f(e e0, d d0) {
        this.b = e0;
        this.a = d0;
        super();
    }

    @Override
    public final void run() {
        Log.i("LicenseChecker", "Check timed out.");
        i i0 = this.b.b;
        this.b.a.b(i0);
        i i1 = this.b.b;
        this.b.a.a(i1);
    }
}

