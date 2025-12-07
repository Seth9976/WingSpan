package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;

final class zzlm implements zzll {
    @Override  // com.google.android.gms.internal.drive.zzll
    public final int zzb(int v, Object object0, Object object1) {
        if(((zzlk)object0).isEmpty()) {
            return 0;
        }
        Iterator iterator0 = ((zzlk)object0).entrySet().iterator();
        if(!iterator0.hasNext()) {
            return 0;
        }
        Object object2 = iterator0.next();
        ((Map.Entry)object2).getKey();
        ((Map.Entry)object2).getValue();
        throw new NoSuchMethodError();
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final Object zzb(Object object0, Object object1) {
        zzlk zzlk0 = (zzlk)object0;
        if(!((zzlk)object1).isEmpty()) {
            if(!zzlk0.isMutable()) {
                zzlk0 = zzlk0.zzdx();
            }
            zzlk0.zza(((zzlk)object1));
        }
        return zzlk0;
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final Map zzh(Object object0) {
        return (zzlk)object0;
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final Map zzi(Object object0) {
        return (zzlk)object0;
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final boolean zzj(Object object0) {
        return !((zzlk)object0).isMutable();
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final Object zzk(Object object0) {
        ((zzlk)object0).zzbp();
        return object0;
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final Object zzl(Object object0) {
        return zzlk.zzdw().zzdx();
    }

    @Override  // com.google.android.gms.internal.drive.zzll
    public final zzlj zzm(Object object0) {
        throw new NoSuchMethodError();
    }
}

