package com.unity3d.plugin.downloader.c;

import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.unity3d.plugin.downloader.d.b;
import com.unity3d.plugin.downloader.d.h;

final class n implements h {
    final b a;
    final m b;

    n(m m0, b b0) {
        this.b = m0;
        this.a = b0;
        super();
    }

    @Override  // com.unity3d.plugin.downloader.d.h
    public final void a() {
        int v3;
        try {
            int v1 = this.a.b();
            o o0 = o.a(this.b.a);
            if(v1 == 0) {
                v3 = 0;
            }
            else {
                v3 = 0;
                for(int v2 = 0; v2 < v1; ++v2) {
                    String s = this.a.b(v2);
                    if(s != null) {
                        this.b.a.getPackageName();
                        c c0 = new c(v2, s);
                        long v4 = this.a.c(v2);
                        if(this.b.b.a(o0, s, v4)) {
                            v3 = -1;
                            c0.f = 0L;
                            c0.d = "";
                            c0.g = 0L;
                            c0.h = 0;
                            c0.i = 0;
                            c0.j = 0;
                            c0.k = 0;
                            c0.l = 0;
                            c0.a = this.a.a(v2);
                            c0.e = v4;
                            c0.h = -1;
                            o0.a(c0);
                        }
                        else {
                            c c1 = o0.a(c0.c);
                            if(c1 == null) {
                                Log.d("LVLDL", "file " + c0.c + " found. Not downloading.");
                                c0.h = 200;
                                c0.e = v4;
                                c0.f = v4;
                                c0.a = this.a.a(v2);
                                o0.a(c0);
                            }
                            else if(c1.h != 200) {
                                c1.a = this.a.a(v2);
                                o0.a(c1);
                                v3 = -1;
                            }
                        }
                    }
                }
            }
            try {
                o0.a(this.b.a.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0).versionCode, v3);
                Class class0 = this.b.b.getClass();
                switch(j.a(this.b.a, this.b.b.mPendingIntent, class0)) {
                    case 0: {
                        this.b.b.mNotification.a(5);
                        break;
                    }
                    case 1: {
                        Log.e("LVLDL", "In LVL checking loop!");
                        this.b.b.mNotification.a(15);
                        throw new RuntimeException("Error with LVL checking and database integrity");
                    }
                }
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                packageManager$NameNotFoundException0.printStackTrace();
                throw new RuntimeException("Error with getting information from package name");
            }
        }
        finally {
            j.b(false);
        }
    }

    @Override  // com.unity3d.plugin.downloader.d.h
    public final void a(int v) {
        try {
            switch(v) {
                case 291: {
                    this.b.b.mNotification.a(16);
                    break;
                }
                case 561: {
                    this.b.b.mNotification.a(15);
                }
            }
        }
        finally {
            j.b(false);
        }
    }

    @Override  // com.unity3d.plugin.downloader.d.h
    public final void b() {
        try {
            this.b.b.mNotification.a(16);
        }
        finally {
            j.b(false);
        }
    }
}

