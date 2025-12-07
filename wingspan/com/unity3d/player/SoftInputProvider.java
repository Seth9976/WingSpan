package com.unity3d.player;

abstract class SoftInputProvider {
    public static F a() {
        int v = SoftInputProvider.nativeGetSoftInputType();
        F[] arr_f = (F[])F.c.clone();
        int v1 = 0;
        while(v1 < arr_f.length) {
            F f0 = arr_f[v1];
            if(f0.a != v) {
                ++v1;
                continue;
            }
            return f0;
        }
        return F.b;
    }

    private static final native int nativeGetSoftInputType() {
    }
}

