package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

public final class zzak {
    Object[] zza;
    int zzb;
    zzaj zzc;

    public zzak() {
        this.zza = new Object[8];
        this.zzb = 0;
    }

    public final zzak zza(Object object0, Object object1) {
        int v = this.zzb + 1;
        Object[] arr_object = this.zza;
        int v1 = v + v;
        if(v1 > arr_object.length) {
            int v2 = arr_object.length + (arr_object.length >> 1) + 1;
            if(v2 < v1) {
                int v3 = Integer.highestOneBit(v1 - 1);
                v2 = v3 + v3;
            }
            if(v2 < 0) {
                v2 = 0x7FFFFFFF;
            }
            this.zza = Arrays.copyOf(arr_object, v2);
        }
        zzad.zza(object0, object1);
        Object[] arr_object1 = this.zza;
        int v4 = this.zzb;
        int v5 = v4 + v4;
        arr_object1[v5] = object0;
        arr_object1[v5 + 1] = object1;
        this.zzb = v4 + 1;
        return this;
    }

    public final zzal zzb() {
        zzaj zzaj0 = this.zzc;
        if(zzaj0 != null) {
            throw zzaj0.zza();
        }
        zzal zzal0 = zzau.zzg(this.zzb, this.zza, this);
        zzaj zzaj1 = this.zzc;
        if(zzaj1 != null) {
            throw zzaj1.zza();
        }
        return zzal0;
    }
}

