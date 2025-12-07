package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Map.Entry;

final class zzlw implements zzmf {
    private final zzlq zzuh;
    private final boolean zzui;
    private final zzmx zzur;
    private final zzjy zzus;

    private zzlw(zzmx zzmx0, zzjy zzjy0, zzlq zzlq0) {
        this.zzur = zzmx0;
        this.zzui = zzjy0.zze(zzlq0);
        this.zzus = zzjy0;
        this.zzuh = zzlq0;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final boolean equals(Object object0, Object object1) {
        if(!this.zzur.zzr(object0).equals(this.zzur.zzr(object1))) {
            return false;
        }
        return this.zzui ? this.zzus.zzb(object0).equals(this.zzus.zzb(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final int hashCode(Object object0) {
        int v = this.zzur.zzr(object0).hashCode();
        return this.zzui ? v * 53 + this.zzus.zzb(object0).hashCode() : v;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final Object newInstance() {
        return this.zzuh.zzcz().zzde();
    }

    static zzlw zza(zzmx zzmx0, zzjy zzjy0, zzlq zzlq0) {
        return new zzlw(zzmx0, zzjy0, zzlq0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zza(Object object0, zzns zzns0) throws IOException {
        for(Object object1: this.zzus.zzb(object0)) {
            Map.Entry map$Entry0 = (Map.Entry)object1;
            zzkd zzkd0 = (zzkd)map$Entry0.getKey();
            if(zzkd0.zzcr() != zznr.zzxx || zzkd0.zzcs() || zzkd0.zzct()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if(map$Entry0 instanceof zzkv) {
                zzns0.zza(zzkd0.zzcp(), ((zzkv)map$Entry0).zzdq().zzbl());
            }
            else {
                zzns0.zza(zzkd0.zzcp(), map$Entry0.getValue());
            }
        }
        Object object2 = this.zzur.zzr(object0);
        this.zzur.zzc(object2, zzns0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zza(Object object0, byte[] arr_b, int v, int v1, zziz zziz0) throws IOException {
        zzmy zzmy0 = ((zzkk)object0).zzrq;
        if(zzmy0 == zzmy.zzfa()) {
            zzmy0 = zzmy.zzfb();
            ((zzkk)object0).zzrq = zzmy0;
        }
        ((zzc)object0).zzdg();
        zzd zzkk$zzd0 = null;
        while(v < v1) {
            int v2 = zziy.zza(arr_b, v, zziz0);
            int v3 = zziz0.zznk;
            if(v3 == 11) {
                int v4 = 0;
                zzjc zzjc0 = null;
                while(v2 < v1) {
                    v2 = zziy.zza(arr_b, v2, zziz0);
                    int v5 = zziz0.zznk;
                    int v6 = v5 & 7;
                    switch(v5 >>> 3) {
                        case 2: {
                            if(v6 == 0) {
                                v2 = zziy.zza(arr_b, v2, zziz0);
                                v4 = zziz0.zznk;
                                zzkk$zzd0 = (zzd)this.zzus.zza(zziz0.zznn, this.zzuh, v4);
                                continue;
                            }
                            break;
                        }
                        case 3: {
                            if(zzkk$zzd0 != null) {
                                throw new NoSuchMethodError();
                            }
                            if(v6 == 2) {
                                v2 = zziy.zze(arr_b, v2, zziz0);
                                zzjc0 = (zzjc)zziz0.zznm;
                                continue;
                            }
                        }
                    }
                    if(v5 == 12) {
                        break;
                    }
                    v2 = zziy.zza(v5, arr_b, v2, v1, zziz0);
                }
                if(zzjc0 != null) {
                    zzmy0.zzb(v4 << 3 | 2, zzjc0);
                }
                v = v2;
            }
            else if((v3 & 7) == 2) {
                zzkk$zzd0 = (zzd)this.zzus.zza(zziz0.zznn, this.zzuh, v3 >>> 3);
                if(zzkk$zzd0 != null) {
                    throw new NoSuchMethodError();
                }
                v = zziy.zza(v3, arr_b, v2, v1, zzmy0, zziz0);
            }
            else {
                v = zziy.zza(v3, arr_b, v2, v1, zziz0);
            }
        }
        if(v != v1) {
            throw zzkq.zzdm();
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zzc(Object object0, Object object1) {
        zzmh.zza(this.zzur, object0, object1);
        if(this.zzui) {
            zzmh.zza(this.zzus, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zzd(Object object0) {
        this.zzur.zzd(object0);
        this.zzus.zzd(object0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final int zzn(Object object0) {
        Object object1 = this.zzur.zzr(object0);
        int v = this.zzur.zzs(object1);
        return this.zzui ? v + this.zzus.zzb(object0).zzco() : v;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final boolean zzp(Object object0) {
        return this.zzus.zzb(object0).isInitialized();
    }
}

