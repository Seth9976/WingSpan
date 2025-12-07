package com.google.android.gms.internal.drive;

import java.util.Comparator;

final class zzje implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        zzjj zzjj0 = (zzjj)((zzjc)object0).iterator();
        zzjj zzjj1 = (zzjj)((zzjc)object1).iterator();
        while(zzjj0.hasNext() && zzjj1.hasNext()) {
            int v = Integer.compare(zzjc.zzb(zzjj0.nextByte()), zzjc.zzb(zzjj1.nextByte()));
            if(v != 0) {
                return v;
            }
            if(false) {
                break;
            }
        }
        return Integer.compare(((zzjc)object0).size(), ((zzjc)object1).size());
    }
}

