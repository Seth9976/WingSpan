package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

final class zzbu implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        zzbt zzbt0 = new zzbt(((zzcc)object0));
        zzbt zzbt1 = new zzbt(((zzcc)object1));
        while(zzbt0.hasNext() && zzbt1.hasNext()) {
            int v = ((int)(zzbt0.zza() & 0xFF)).compareTo(((int)(zzbt1.zza() & 0xFF)));
            if(v != 0) {
                return v;
            }
            if(false) {
                break;
            }
        }
        return ((zzcc)object0).zzd().compareTo(((zzcc)object1).zzd());
    }
}

