package com.unity3d.player;

import java.util.Set;

class b implements Runnable {
    private Set a;
    private String b;
    private int c;
    private long d;
    private long e;
    private int f;
    private int g;

    b(Set set0, String s, int v, long v1, long v2, int v3, int v4) {
        this.a = set0;
        this.b = s;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.f = v3;
        this.g = v4;
    }

    @Override
    public void run() {
        for(Object object0: this.a) {
            ((IAssetPackManagerDownloadStatusCallback)object0).onStatusUpdate(this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }
}

