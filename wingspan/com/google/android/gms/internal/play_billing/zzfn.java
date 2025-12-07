package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

public final class zzfn {
    private static final zzfn zza;
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    static {
        zzfn.zza = new zzfn(0, new int[0], new Object[0], false);
    }

    private zzfn() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfn(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.zze = -1;
        this.zzb = v;
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zzf = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzfn)) {
            return false;
        }
        int v = this.zzb;
        if(v == ((zzfn)object0).zzb) {
            int[] arr_v = this.zzc;
            int[] arr_v1 = ((zzfn)object0).zzc;
            for(int v1 = 0; v1 < v; ++v1) {
                if(arr_v[v1] != arr_v1[v1]) {
                    return false;
                }
            }
            Object[] arr_object = this.zzd;
            Object[] arr_object1 = ((zzfn)object0).zzd;
            int v2 = this.zzb;
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!arr_object[v3].equals(arr_object1[v3])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.zzb;
        int[] arr_v = this.zzc;
        int v2 = 17;
        int v4 = 17;
        for(int v3 = 0; v3 < v; ++v3) {
            v4 = v4 * 0x1F + arr_v[v3];
        }
        Object[] arr_object = this.zzd;
        int v5 = this.zzb;
        for(int v1 = 0; v1 < v5; ++v1) {
            v2 = v2 * 0x1F + arr_object[v1].hashCode();
        }
        return ((v + 0x20F) * 0x1F + v4) * 0x1F + v2;
    }

    public final int zza() {
        int v5;
        int v = this.zze;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.zzb; ++v1) {
                int v3 = this.zzc[v1];
                int v4 = v3 >>> 3;
                switch(v3 & 7) {
                    case 0: {
                        v5 = zzck.zzw(v4 << 3) + zzck.zzx(((long)(((Long)this.zzd[v1]))));
                        break;
                    }
                    case 1: {
                        ((Long)this.zzd[v1]).longValue();
                        v5 = zzck.zzw(v4 << 3) + 8;
                        break;
                    }
                    case 2: {
                        int v7 = ((zzcc)this.zzd[v1]).zzd();
                        v5 = zzck.zzw(v4 << 3) + (zzck.zzw(v7) + v7);
                        break;
                    }
                    case 3: {
                        int v6 = zzck.zzw(v4 << 3);
                        v5 = v6 + v6 + ((zzfn)this.zzd[v1]).zza();
                        break;
                    }
                    case 5: {
                        ((Integer)this.zzd[v1]).intValue();
                        v5 = zzck.zzw(v4 << 3) + 4;
                        break;
                    }
                    default: {
                        throw new IllegalStateException(zzdn.zza());
                    }
                }
                v2 += v5;
            }
            this.zze = v2;
            return v2;
        }
        return v;
    }

    public final int zzb() {
        int v = this.zze;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.zzb; ++v1) {
                int v3 = zzck.zzw(this.zzc[v1] >>> 3);
                int v4 = ((zzcc)this.zzd[v1]).zzd();
                v2 = zzck.zzw(v4) + v2 + v3 + v4 + 4;
            }
            this.zze = v2;
            return v2;
        }
        return v;
    }

    public static zzfn zzc() {
        return zzfn.zza;
    }

    final zzfn zzd(zzfn zzfn0) {
        if(zzfn0.equals(zzfn.zza)) {
            return this;
        }
        this.zzg();
        int v = this.zzb + zzfn0.zzb;
        this.zzl(v);
        System.arraycopy(zzfn0.zzc, 0, this.zzc, this.zzb, zzfn0.zzb);
        System.arraycopy(zzfn0.zzd, 0, this.zzd, this.zzb, zzfn0.zzb);
        this.zzb = v;
        return this;
    }

    static zzfn zze(zzfn zzfn0, zzfn zzfn1) {
        int v = zzfn0.zzb + zzfn1.zzb;
        int[] arr_v = Arrays.copyOf(zzfn0.zzc, v);
        System.arraycopy(zzfn1.zzc, 0, arr_v, zzfn0.zzb, zzfn1.zzb);
        Object[] arr_object = Arrays.copyOf(zzfn0.zzd, v);
        System.arraycopy(zzfn1.zzd, 0, arr_object, zzfn0.zzb, zzfn1.zzb);
        return new zzfn(v, arr_v, arr_object, true);
    }

    static zzfn zzf() {
        return new zzfn(0, new int[8], new Object[8], true);
    }

    final void zzg() {
        if(!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if(this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < this.zzb; ++v1) {
            zzem.zzb(stringBuilder0, v, String.valueOf(this.zzc[v1] >>> 3), this.zzd[v1]);
        }
    }

    final void zzj(int v, Object object0) {
        this.zzg();
        this.zzl(this.zzb + 1);
        int v1 = this.zzb;
        this.zzc[v1] = v;
        this.zzd[v1] = object0;
        this.zzb = v1 + 1;
    }

    public final void zzk(zzge zzge0) throws IOException {
        if(this.zzb != 0) {
            for(int v = 0; v < this.zzb; ++v) {
                int v1 = this.zzc[v];
                Object object0 = this.zzd[v];
                int v2 = v1 & 7;
                int v3 = v1 >>> 3;
                switch(v2) {
                    case 0: {
                        zzge0.zzt(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 1: {
                        zzge0.zzm(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 2: {
                        zzge0.zzd(v3, ((zzcc)object0));
                        break;
                    }
                    case 3: {
                        zzge0.zzE(v3);
                        ((zzfn)object0).zzk(zzge0);
                        zzge0.zzh(v3);
                        break;
                    }
                    default: {
                        if(v2 != 5) {
                            throw new RuntimeException(zzdn.zza());
                        }
                        zzge0.zzk(v3, ((int)(((Integer)object0))));
                        break;
                    }
                }
            }
        }
    }

    private final void zzl(int v) {
        int[] arr_v = this.zzc;
        if(v > arr_v.length) {
            int v1 = this.zzb + this.zzb / 2;
            if(v1 >= v) {
                v = v1;
            }
            if(v < 8) {
                v = 8;
            }
            this.zzc = Arrays.copyOf(arr_v, v);
            this.zzd = Arrays.copyOf(this.zzd, v);
        }
    }
}

