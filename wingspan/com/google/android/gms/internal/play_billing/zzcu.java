package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class zzcu {
    final zzfi zza;
    private static final zzcu zzb;
    private boolean zzc;
    private boolean zzd;

    static {
        zzcu.zzb = new zzcu(true);
    }

    private zzcu() {
        this.zza = new zzey(16);
    }

    private zzcu(boolean z) {
        zzey zzey0 = new zzey(0);
        super();
        this.zza = zzey0;
        this.zzb();
        this.zzb();
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        zzcu zzcu0 = new zzcu();
        for(int v = 0; v < this.zza.zzb(); ++v) {
            Map.Entry map$Entry0 = this.zza.zzg(v);
            zzcu0.zzc(((zzct)map$Entry0.getKey()), map$Entry0.getValue());
        }
        for(Object object0: this.zza.zzc()) {
            zzcu0.zzc(((zzct)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        zzcu0.zzd = this.zzd;
        return zzcu0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzcu ? this.zza.equals(((zzcu)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static zzcu zza() {
        throw null;
    }

    public final void zzb() {
        if(!this.zzc) {
            for(int v = 0; v < this.zza.zzb(); ++v) {
                Map.Entry map$Entry0 = this.zza.zzg(v);
                if(map$Entry0.getValue() instanceof zzdd) {
                    ((zzdd)map$Entry0.getValue()).zzr();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzct zzct0, Object object0) {
        if(zzct0.zzc()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(((List)object0));
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                zzcu.zzd(zzct0, arrayList0.get(v1));
            }
            object0 = arrayList0;
        }
        else {
            zzcu.zzd(zzct0, object0);
        }
        if(object0 instanceof zzdp) {
            this.zzd = true;
        }
        this.zza.zze(zzct0, object0);
    }

    private static final void zzd(zzct zzct0, Object object0) {
        boolean z;
        zzgc zzgc0 = zzct0.zzb();
        object0.getClass();
        switch(zzgc0.zza().ordinal()) {
            case 0: {
                z = object0 instanceof Integer;
                goto label_15;
            }
            case 1: {
                z = object0 instanceof Long;
                goto label_15;
            }
            case 2: {
                z = object0 instanceof Float;
                goto label_15;
            }
            case 3: {
                z = object0 instanceof Double;
                goto label_15;
            }
            case 4: {
                z = object0 instanceof Boolean;
                goto label_15;
            }
            case 5: {
                z = object0 instanceof String;
            label_15:
                if(z) {
                    return;
                }
                break;
            }
            case 6: {
                if(object0 instanceof zzcc || object0 instanceof byte[]) {
                    return;
                }
                break;
            }
            case 7: {
                if(object0 instanceof Integer || object0 instanceof zzdf) {
                    return;
                }
                break;
            }
            case 8: {
                if(object0 instanceof zzek || object0 instanceof zzdp) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", zzct0.zza(), zzct0.zzb().zza(), object0.getClass().getName()));
    }
}

