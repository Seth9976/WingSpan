package com.google.android.gms.internal.play_billing;

public final class zzao {
    static Object[] zza(Object[] arr_object, int v) {
        for(int v1 = 0; v1 < v; ++v1) {
            if(arr_object[v1] == null) {
                throw new NullPointerException("at index " + v1);
            }
        }
        return arr_object;
    }
}

