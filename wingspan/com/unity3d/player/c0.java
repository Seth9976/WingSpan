package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class c0 {
    public interface a {
    }

    private UnityPlayer a;
    private Context b;
    private a c;
    private final Semaphore d;
    private final Lock e;
    private V f;
    private int g;
    private boolean h;
    private boolean i;

    static UnityPlayer -$$Nest$fgeta(c0 c00) {
        return c00.a;
    }

    static Context -$$Nest$fgetb(c0 c00) {
        return c00.b;
    }

    static Semaphore -$$Nest$fgetd(c0 c00) {
        return c00.d;
    }

    static Lock -$$Nest$fgete(c0 c00) {
        return c00.e;
    }

    static V -$$Nest$fgetf(c0 c00) {
        return c00.f;
    }

    static boolean -$$Nest$fgeti(c0 c00) {
        return c00.i;
    }

    static void -$$Nest$fputf(c0 c00, V v0) {
        c00.f = v0;
    }

    static void -$$Nest$fputg(c0 c00, int v) {
        c00.g = v;
    }

    static void -$$Nest$fputi(c0 c00, boolean z) {
        c00.i = z;
    }

    static void -$$Nest$ma(c0 c00) {
        c00.a();
    }

    c0(UnityPlayer unityPlayer0) {
        this.a = null;
        this.b = null;
        this.d = new Semaphore(0);
        this.e = new ReentrantLock();
        this.f = null;
        this.g = 2;
        this.h = false;
        this.i = false;
        this.a = unityPlayer0;
    }

    private void a() {
        V v0 = this.f;
        if(v0 != null) {
            this.a.removeViewFromPlayer(v0);
            this.i = false;
            this.f.destroyPlayer();
            this.f = null;
            a c0$a0 = this.c;
            if(c0$a0 != null) {
                ((n)c0$a0).a();
            }
        }
    }

    public boolean a(Context context0, String s, int v, int v1, int v2, boolean z, long v3, long v4, a c0$a0) {
        this.e.lock();
        this.c = c0$a0;
        this.b = context0;
        this.d.drainPermits();
        this.g = 2;
        this.runOnUiThread(new Y(this, s, v, v1, v2, z, v3, v4));
        try {
            this.e.unlock();
            this.d.acquire();
            this.e.lock();
        }
        catch(InterruptedException unused_ex) {
        }
        this.runOnUiThread(new Z(this));
        this.runOnUiThread(new b0(this));
        this.e.unlock();
        return false;
    }

    public void b() {
        this.e.lock();
        V v0 = this.f;
        if(v0 != null) {
            v0.updateVideoLayout();
        }
        this.e.unlock();
    }

    public void c() {
        this.e.lock();
        V v0 = this.f;
        if(v0 != null) {
            if(this.g == 0) {
                v0.cancelOnPrepare();
            }
            else if(this.i) {
                boolean z = v0.a();
                this.h = z;
                if(!z) {
                    this.f.pause();
                }
            }
        }
        this.e.unlock();
    }

    public void d() {
        this.e.lock();
        V v0 = this.f;
        if(v0 != null && this.i && !this.h) {
            v0.start();
        }
        this.e.unlock();
    }

    protected void runOnUiThread(Runnable runnable0) {
        Context context0 = this.b;
        if(context0 instanceof Activity) {
            ((Activity)context0).runOnUiThread(runnable0);
            return;
        }
        u.Log(5, "Not running from an Activity; Ignoring execution request...");
    }
}

