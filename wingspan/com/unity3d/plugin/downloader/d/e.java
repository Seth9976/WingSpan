package com.unity3d.plugin.downloader.d;

import android.util.Log;
import com.unity3d.plugin.downloader.a.b;

final class e extends b {
    final d a;
    private final i b;
    private Runnable c;

    public e(d d0, i i0) {
        this.a = d0;
        super();
        this.b = i0;
        this.c = new f(this, d0);
        Log.i("LicenseChecker", "Start monitoring timeout.");
        d0.f.postDelayed(this.c, 10000L);
    }

    @Override  // com.unity3d.plugin.downloader.a.a
    public final void a(int v, String s, String s1) {
        g g0 = new g(this, v, s, s1);
        this.a.f.post(g0);
    }

    static void b(e e0) {
        Log.i("LicenseChecker", "Clearing timeout.");
        e0.a.f.removeCallbacks(e0.c);
    }
}

