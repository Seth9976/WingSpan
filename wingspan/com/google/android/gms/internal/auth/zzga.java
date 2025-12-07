package com.google.android.gms.internal.auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import sun.misc.Unsafe;

final class zzga implements zzgi {
    private static final int[] zza;
    private static final Unsafe zzb;
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    static {
        zzga.zza = new int[0];
        zzga.zzb = zzhj.zzg();
    }

    private zzga(int[] arr_v, Object[] arr_object, int v, int v1, zzfx zzfx0, int v2, boolean z, int[] arr_v1, int v3, int v4, zzgc zzgc0, zzfl zzfl0, zzgz zzgz0, zzem zzem0, zzfs zzfs0) {
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zze = v;
        this.zzf = v1;
        this.zzh = arr_v1;
        this.zzi = v3;
        this.zzj = v4;
        this.zzn = zzgc0;
        this.zzk = zzfl0;
        this.zzl = zzgz0;
        this.zzm = zzem0;
        this.zzg = zzfx0;
        this.zzo = zzfs0;
    }

    private final void zzA(Object object0, int v, int v1) {
        zzhj.zzn(object0, ((long)(this.zzl(v1) & 0xFFFFF)), v);
    }

    private final void zzB(Object object0, int v, Object object1) {
        int v1 = this.zzo(v);
        zzga.zzb.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.zzz(object0, v);
    }

    private final void zzC(Object object0, int v, int v1, Object object1) {
        int v2 = this.zzo(v1);
        zzga.zzb.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.zzA(object0, v, v1);
    }

    private final boolean zzD(Object object0, Object object1, int v) {
        return this.zzE(object0, v) == this.zzE(object1, v);
    }

    private final boolean zzE(Object object0, int v) {
        int v1 = this.zzl(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.zzo(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(zzhj.zza(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(zzhj.zzb(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zzhj.zzt(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zzhj.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzef)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzef.zzb.equals(object1);
                }
                case 9: {
                    return zzhj.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zzhj.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    return !zzef.zzb.equals(object2);
                }
                case 11: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zzhj.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (zzhj.zzc(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final boolean zzF(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.zzE(object0, v) : (v2 & v3) != 0;
    }

    private static boolean zzG(Object object0, int v, zzgi zzgi0) {
        return zzgi0.zzi(zzhj.zzf(object0, ((long)(v & 0xFFFFF))));
    }

    private static boolean zzH(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof zzev ? ((zzev)object0).zzm() : true;
    }

    private final boolean zzI(Object object0, int v, int v1) {
        return zzhj.zzc(object0, ((long)(this.zzl(v1) & 0xFFFFF))) == v;
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object object0) {
        int v8;
        long v7;
        int v6;
        int v1 = 0;
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v2 = this.zzo(v);
            int v3 = this.zzc[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = Double.doubleToLongBits(zzhj.zza(object0, v4));
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 1: {
                    v6 = v1 * 53;
                    v8 = Float.floatToIntBits(zzhj.zzb(object0, v4));
                    v1 = v6 + v8;
                    break;
                }
                case 2: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 3: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 4: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 5: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 6: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 7: {
                    v6 = v1 * 53;
                    v8 = zzfa.zza(zzhj.zzt(object0, v4));
                    v1 = v6 + v8;
                    break;
                }
                case 8: {
                    v6 = v1 * 53;
                    v8 = ((String)zzhj.zzf(object0, v4)).hashCode();
                    v1 = v6 + v8;
                    break;
                }
                case 9: {
                    Object object1 = zzhj.zzf(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzf(object0, v4).hashCode();
                    v1 = v6 + v8;
                    break;
                }
                case 11: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 12: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 13: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 14: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 15: {
                    v1 = v1 * 53 + zzhj.zzc(object0, v4);
                    break;
                }
                case 16: {
                    v7 = zzhj.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 17: {
                    Object object2 = zzhj.zzf(object0, v4);
                    if(object2 != null) {
                        v5 = object2.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    v1 = v1 * 53 + zzhj.zzf(object0, v4).hashCode();
                    break;
                }
                case 50: {
                    v1 = v1 * 53 + zzhj.zzf(object0, v4).hashCode();
                    break;
                }
                case 51: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = Double.doubleToLongBits(((double)(((Double)zzhj.zzf(object0, v4)))));
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + Float.floatToIntBits(((float)(((Float)zzhj.zzf(object0, v4)))));
                    }
                    break;
                }
                case 53: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzfa.zza(((Boolean)zzhj.zzf(object0, v4)).booleanValue());
                    }
                    break;
                }
                case 59: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + ((String)zzhj.zzf(object0, v4)).hashCode();
                    }
                    break;
                }
                case 60: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzhj.zzf(object0, v4).hashCode();
                    }
                    break;
                }
                case 61: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzhj.zzf(object0, v4).hashCode();
                    }
                    break;
                }
                case 62: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzhj.zzf(object0, v4).hashCode();
                    }
                }
            }
        }
        return v1 * 53 + this.zzl.zzb(object0).hashCode();
    }

    final int zzb(Object object0, byte[] arr_b, int v, int v1, int v2, zzdt zzdt0) throws IOException {
        Unsafe unsafe8;
        int v110;
        int v107;
        zzdt zzdt3;
        int v104;
        int v103;
        zzdt zzdt2;
        int v102;
        Unsafe unsafe4;
        int v57;
        int v56;
        int v55;
        int v95;
        int v94;
        int v89;
        int v87;
        int v68;
        Unsafe unsafe5;
        int v67;
        int v66;
        int v82;
        int v81;
        zzez zzez3;
        int v53;
        int v52;
        int v51;
        int v50;
        int v30;
        int v29;
        int v33;
        int v35;
        Unsafe unsafe2;
        int v34;
        int v20;
        int v19;
        Unsafe unsafe1;
        int v18;
        int v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v3 = v1;
        int v4 = v2;
        zzdt zzdt1 = zzdt0;
        zzga.zzw(object0);
        Unsafe unsafe0 = zzga.zzb;
        int v5 = 0;
        int v6 = v;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = -1;
        int v11 = 0xFFFFF;
        while(true) {
            if(v6 >= v3) {
                v19 = v4;
                v110 = v3;
                unsafe8 = unsafe0;
                break;
            }
            int v12 = arr_b[v6];
            if(v12 < 0) {
                v13 = zzdu.zzi(v12, arr_b, v6 + 1, zzdt1);
                v8 = zzdt1.zza;
            }
            else {
                v8 = v12;
                v13 = v6 + 1;
            }
            if(v8 >>> 3 > v10) {
                v14 = v8 >>> 3 < this.zze || v8 >>> 3 > this.zzf ? -1 : this.zzm(v8 >>> 3, v7 / 3);
            }
            else {
                v14 = v8 >>> 3 < this.zze || v8 >>> 3 > this.zzf ? -1 : this.zzm(v8 >>> 3, 0);
            }
            if(v14 == -1) {
                v15 = v13;
                v16 = v9;
                v17 = v11;
                v18 = v8 >>> 3;
                unsafe1 = unsafe0;
                v19 = v4;
                v20 = v3;
            }
            else {
                int v21 = v8 & 7;
                int[] arr_v = this.zzc;
                int v22 = arr_v[v14 + 1];
                int v23 = v22 >>> 20 & 0xFF;
                long v24 = (long)(v22 & 0xFFFFF);
                int v25 = v8 >>> 3;
                if(v23 <= 17) {
                    int v26 = arr_v[v14 + 2];
                    int v27 = 1 << (v26 >>> 20);
                    int v28 = v26 & 0xFFFFF;
                    if(v28 == v11) {
                        v16 = v9;
                        v17 = v11;
                    }
                    else {
                        if(v11 != 0xFFFFF) {
                            unsafe0.putInt(object0, ((long)v11), v9);
                        }
                        v16 = v28 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v28));
                        v17 = v28;
                    }
                    switch(v23) {
                        case 0: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 1) {
                                zzhj.zzl(object0, v24, Double.longBitsToDouble(zzdu.zzn(arr_b, v13)));
                                v6 = v13 + 8;
                                goto label_200;
                            }
                            v20 = v1;
                            goto label_126;
                        }
                        case 1: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 5) {
                                zzhj.zzm(object0, v24, Float.intBitsToFloat(zzdu.zzb(arr_b, v13)));
                                v6 = v13 + 4;
                                goto label_200;
                            }
                            v20 = v1;
                            goto label_126;
                        }
                        case 2: 
                        case 3: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 0) {
                                int v32 = zzdu.zzk(arr_b, v13, zzdt1);
                                unsafe0.putLong(object0, v24, zzdt1.zzb);
                                v9 = v16 | v27;
                                v3 = v1;
                                v4 = v2;
                                v8 = v30;
                                v7 = v29;
                                v6 = v32;
                                v10 = v25;
                                v11 = v17;
                                v5 = 0;
                                continue;
                            }
                            v20 = v1;
                            goto label_126;
                        }
                        case 7: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 0) {
                                v6 = zzdu.zzk(arr_b, v13, zzdt1);
                                zzhj.zzk(object0, v24, zzdt1.zzb != 0L);
                                goto label_200;
                            }
                            else {
                                v20 = v1;
                            }
                        label_126:
                            v34 = v30;
                            v14 = v29;
                            unsafe2 = unsafe0;
                            v35 = v25;
                            break;
                        }
                        case 8: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 2) {
                                if((v22 & 0x20000000) == 0) {
                                    v6 = zzdu.zzh(arr_b, v13, zzdt1);
                                    int v43 = zzdt1.zza;
                                    if(v43 >= 0) {
                                        if(v43 == 0) {
                                            zzdt1.zzc = "";
                                        }
                                        else {
                                            zzdt1.zzc = new String(arr_b, v6, v43, zzfa.zzb);
                                            v6 += v43;
                                        }
                                    label_199:
                                        unsafe0.putObject(object0, v24, zzdt1.zzc);
                                    label_200:
                                        v9 = v16 | v27;
                                        v3 = v1;
                                        v4 = v2;
                                        v8 = v30;
                                        v7 = v29;
                                        v10 = v25;
                                        v11 = v17;
                                        v5 = 0;
                                        continue;
                                    }
                                }
                                else {
                                    v6 = zzdu.zzh(arr_b, v13, zzdt1);
                                    int v36 = zzdt1.zza;
                                    if(v36 >= 0) {
                                        if(v36 == 0) {
                                            zzdt1.zzc = "";
                                        }
                                        else {
                                            if((arr_b.length - v6 - v36 | (v6 | v36)) < 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v6, v36));
                                            }
                                            int v37 = v6 + v36;
                                            char[] arr_c = new char[v36];
                                            int v38;
                                            for(v38 = 0; v6 < v37; ++v38) {
                                                int v39 = arr_b[v6];
                                                if(!zzhk.zzd(((byte)v39))) {
                                                    break;
                                                }
                                                ++v6;
                                                arr_c[v38] = (char)v39;
                                            }
                                        label_152:
                                            while(v6 < v37) {
                                                int v40 = arr_b[v6];
                                                if(zzhk.zzd(((byte)v40))) {
                                                    int v41 = v38 + 1;
                                                    arr_c[v38] = (char)v40;
                                                    ++v6;
                                                    while(true) {
                                                        v38 = v41;
                                                        if(v6 >= v37) {
                                                            continue label_152;
                                                        }
                                                        int v42 = arr_b[v6];
                                                        if(!zzhk.zzd(((byte)v42))) {
                                                            continue label_152;
                                                        }
                                                        ++v6;
                                                        v41 = v38 + 1;
                                                        arr_c[v38] = (char)v42;
                                                    }
                                                }
                                                if(v40 < 0xFFFFFFE0) {
                                                    if(v6 + 1 < v37) {
                                                        zzhk.zzc(((byte)v40), arr_b[v6 + 1], arr_c, v38);
                                                        v6 += 2;
                                                        ++v38;
                                                        continue;
                                                    }
                                                }
                                                else if(v40 >= -16) {
                                                    if(v6 + 1 < v37 - 2) {
                                                        zzhk.zza(((byte)v40), arr_b[v6 + 1], arr_b[v6 + 2], arr_b[v6 + 3], arr_c, v38);
                                                        v38 += 2;
                                                        v6 += 4;
                                                        continue;
                                                    }
                                                }
                                                else if(v6 + 1 < v37 - 1) {
                                                    zzhk.zzb(((byte)v40), arr_b[v6 + 1], arr_b[v6 + 2], arr_c, v38);
                                                    v6 += 3;
                                                    ++v38;
                                                    continue;
                                                }
                                                throw zzfb.zzb();
                                            }
                                            zzdt1.zzc = new String(arr_c, 0, v38);
                                            v6 = v37;
                                        }
                                        goto label_199;
                                    }
                                }
                                throw zzfb.zzc();
                            }
                            else {
                                v20 = v1;
                                v34 = v30;
                                v14 = v29;
                                unsafe2 = unsafe0;
                                v35 = v25;
                                break;
                            }
                            goto label_212;
                        }
                        case 9: {
                        label_212:
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 2) {
                                Object object2 = this.zzt(object0, v29);
                                v6 = zzdu.zzm(object2, this.zzr(v29), arr_b, v13, v1, zzdt0);
                                this.zzB(object0, v29, object2);
                                v9 = v16 | v27;
                                v3 = v1;
                                v4 = v2;
                                goto label_264;
                            }
                            goto label_251;
                        }
                        case 10: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 2) {
                                v6 = zzdu.zza(arr_b, v13, zzdt1);
                                unsafe0.putObject(object0, v24, zzdt1.zzc);
                                v9 = v16 | v27;
                                v3 = v1;
                                v4 = v2;
                                goto label_264;
                            }
                            goto label_251;
                        }
                        case 4: 
                        case 11: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 0) {
                                v6 = zzdu.zzh(arr_b, v13, zzdt1);
                                unsafe0.putInt(object0, v24, zzdt1.zza);
                                goto label_200;
                            }
                            else {
                                v20 = v1;
                                goto label_126;
                            }
                            goto label_102;
                        }
                        case 12: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 0) {
                                v6 = zzdu.zzh(arr_b, v13, zzdt1);
                                int v44 = zzdt1.zza;
                                zzey zzey0 = this.zzq(v29);
                                if((v22 & 0x80000000) == 0 || zzey0 == null || zzey0.zza()) {
                                    unsafe0.putInt(object0, v24, v44);
                                    v9 = v16 | v27;
                                    v3 = v1;
                                    v4 = v2;
                                    goto label_264;
                                }
                                else {
                                    zzga.zzc(object0).zzh(v30, ((long)v44));
                                    v3 = v1;
                                    v4 = v2;
                                    v8 = v30;
                                    v7 = v29;
                                    v10 = v25;
                                    v9 = v16;
                                    v11 = v17;
                                    v5 = 0;
                                    continue;
                                }
                                goto label_242;
                            }
                            goto label_251;
                        }
                        case 6: 
                        case 13: {
                            v33 = v13;
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 5) {
                                unsafe0.putInt(object0, v24, zzdu.zzb(arr_b, v33));
                                v6 = v33 + 4;
                                goto label_200;
                            }
                            v20 = v1;
                            v13 = v33;
                            goto label_126;
                        }
                        case 5: 
                        case 14: {
                        label_102:
                            v33 = v13;
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 1) {
                                unsafe0.putLong(object0, v24, zzdu.zzn(arr_b, v33));
                                v6 = v33 + 8;
                                goto label_200;
                            }
                            v20 = v1;
                            v13 = v33;
                            goto label_126;
                        }
                        case 15: {
                        label_242:
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 0) {
                                v6 = zzdu.zzh(arr_b, v13, zzdt1);
                                unsafe0.putInt(object0, v24, zzdt1.zza >>> 1 ^ -(zzdt1.zza & 1));
                                v9 = v16 | v27;
                                v3 = v1;
                                v4 = v2;
                                goto label_264;
                            }
                        label_251:
                            v20 = v1;
                            v34 = v30;
                            v14 = v29;
                            unsafe2 = unsafe0;
                            v35 = v25;
                            break;
                        }
                        case 16: {
                            if(v21 == 0) {
                                int v45 = zzdu.zzk(arr_b, v13, zzdt1);
                                v29 = v14;
                                v30 = v8;
                                unsafe0.putLong(object0, v24, zzdt1.zzb >>> 1 ^ -(1L & zzdt1.zzb));
                                v9 = v16 | v27;
                                v3 = v1;
                                v4 = v2;
                                v6 = v45;
                            label_264:
                                v8 = v30;
                                v7 = v29;
                                v10 = v25;
                                v11 = v17;
                                v5 = 0;
                                continue;
                            }
                            else {
                                v20 = v1;
                                v34 = v8;
                            }
                            unsafe2 = unsafe0;
                            v35 = v25;
                            break;
                        }
                        default: {
                            v29 = v14;
                            v30 = v8;
                            if(v21 == 3) {
                                Object object1 = this.zzt(object0, v29);
                                v7 = v29;
                                int v31 = zzdu.zzl(object1, this.zzr(v29), arr_b, v13, v1, v25 << 3 | 4, zzdt0);
                                this.zzB(object0, v7, object1);
                                v4 = v2;
                                v3 = v1;
                                v6 = v31;
                                v5 = 0;
                                v11 = v17;
                                v9 = v16 | v27;
                                v10 = v25;
                                v8 = v30;
                                continue;
                            }
                            v20 = v1;
                            goto label_126;
                        }
                    }
                    v19 = v2;
                    v5 = v14;
                    unsafe1 = unsafe2;
                    v15 = v13;
                    v18 = v35;
                    v8 = v34;
                }
                else {
                    v17 = v11;
                    int v46 = v8;
                    int v47 = v25;
                    v20 = v1;
                    int v48 = 10;
                    if(v23 == 27) {
                        if(v21 == 2) {
                            zzez zzez0 = (zzez)unsafe0.getObject(object0, v24);
                            if(!zzez0.zzc()) {
                                int v49 = zzez0.size();
                                if(v49 != 0) {
                                    v48 = v49 + v49;
                                }
                                zzez0 = zzez0.zzd(v48);
                                unsafe0.putObject(object0, v24, zzez0);
                            }
                            v10 = v47;
                            v6 = zzdu.zze(this.zzr(v14), v46, arr_b, v13, v1, zzez0, zzdt0);
                            v4 = v2;
                            v7 = v14;
                            v3 = v20;
                            v5 = 0;
                            v8 = v46;
                            v11 = v17;
                            continue;
                        }
                        else {
                            v50 = v47;
                            unsafe1 = unsafe0;
                            v51 = v46;
                            v16 = v9;
                            v52 = v13;
                            v53 = v14;
                            goto label_803;
                        }
                        goto label_311;
                    }
                    else {
                    label_311:
                        if(v23 <= 49) {
                            Unsafe unsafe3 = zzga.zzb;
                            zzez zzez1 = (zzez)unsafe3.getObject(object0, v24);
                            if(zzez1.zzc()) {
                                zzez3 = zzez1;
                            }
                            else {
                                int v54 = zzez1.size();
                                if(v54 != 0) {
                                    v48 = v54 + v54;
                                }
                                zzez zzez2 = zzez1.zzd(v48);
                                unsafe3.putObject(object0, v24, zzez2);
                                zzez3 = zzez2;
                            }
                        alab4:
                            switch(v23) {
                                case 26: {
                                    v66 = v47;
                                    v67 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe5 = unsafe0;
                                    if(v21 == 2) {
                                        if((((long)v22) & 0x20000000L) == 0L) {
                                            v68 = zzdu.zzh(arr_b, v13, zzdt1);
                                            int v75 = zzdt1.zza;
                                            if(v75 >= 0) {
                                                if(v75 == 0) {
                                                    zzez3.add("");
                                                    goto label_536;
                                                }
                                                else {
                                                    zzez3.add(new String(arr_b, v68, v75, zzfa.zzb));
                                                }
                                            alab1:
                                                while(true) {
                                                    v68 += v75;
                                                    while(true) {
                                                    label_536:
                                                        if(v68 >= v20) {
                                                            goto label_574;
                                                        }
                                                        int v76 = zzdu.zzh(arr_b, v68, zzdt1);
                                                        if(v57 != zzdt1.zza) {
                                                            goto label_574;
                                                        }
                                                        v68 = zzdu.zzh(arr_b, v76, zzdt1);
                                                        v75 = zzdt1.zza;
                                                        if(v75 < 0) {
                                                            break alab1;
                                                        }
                                                        if(v75 != 0) {
                                                            zzez3.add(new String(arr_b, v68, v75, zzfa.zzb));
                                                            break;
                                                        }
                                                        zzez3.add("");
                                                    }
                                                }
                                                throw zzfb.zzc();
                                            }
                                        }
                                        else {
                                            v68 = zzdu.zzh(arr_b, v13, zzdt1);
                                            int v77 = zzdt1.zza;
                                            if(v77 >= 0) {
                                                if(v77 == 0) {
                                                    zzez3.add("");
                                                    goto label_559;
                                                }
                                                else {
                                                    int v78 = v68 + v77;
                                                    if(!zzhn.zzc(arr_b, v68, v78)) {
                                                        throw zzfb.zzb();
                                                    }
                                                    zzez3.add(new String(arr_b, v68, v77, zzfa.zzb));
                                                alab2:
                                                    while(true) {
                                                        v68 = v78;
                                                        while(true) {
                                                        label_559:
                                                            if(v68 >= v20) {
                                                                goto label_574;
                                                            }
                                                            int v79 = zzdu.zzh(arr_b, v68, zzdt1);
                                                            if(v57 != zzdt1.zza) {
                                                                goto label_574;
                                                            }
                                                            v68 = zzdu.zzh(arr_b, v79, zzdt1);
                                                            int v80 = zzdt1.zza;
                                                            if(v80 < 0) {
                                                                throw zzfb.zzc();
                                                            }
                                                            if(v80 != 0) {
                                                                v78 = v68 + v80;
                                                                if(!zzhn.zzc(arr_b, v68, v78)) {
                                                                    break alab2;
                                                                }
                                                                zzez3.add(new String(arr_b, v68, v80, zzfa.zzb));
                                                                break;
                                                            }
                                                            zzez3.add("");
                                                        }
                                                    }
                                                    throw zzfb.zzb();
                                                label_574:
                                                    v55 = v13;
                                                    v6 = v68;
                                                    unsafe4 = unsafe5;
                                                    v56 = v66;
                                                    v5 = v67;
                                                    v3 = v20;
                                                    goto label_768;
                                                }
                                            }
                                        }
                                        throw zzfb.zzc();
                                    }
                                label_582:
                                    v55 = v13;
                                    unsafe4 = unsafe5;
                                    v56 = v66;
                                    v5 = v67;
                                    v3 = v20;
                                    v6 = v55;
                                    goto label_768;
                                }
                                case 28: {
                                    v55 = v13;
                                    v81 = v20;
                                    v82 = v14;
                                    int v83 = v46;
                                    v16 = v9;
                                    if(v21 == 2) {
                                        int v84 = zzdu.zzh(arr_b, v55, zzdt1);
                                        int v85 = zzdt1.zza;
                                        if(v85 < 0) {
                                            throw zzfb.zzc();
                                        }
                                        if(v85 > arr_b.length - v84) {
                                            throw zzfb.zzf();
                                        }
                                        if(v85 == 0) {
                                            zzez3.add(zzef.zzb);
                                            goto label_603;
                                        }
                                        else {
                                            zzez3.add(zzef.zzk(arr_b, v84, v85));
                                        }
                                    alab3:
                                        while(true) {
                                            v84 += v85;
                                            while(true) {
                                            label_603:
                                                if(v84 >= v81) {
                                                    v6 = v84;
                                                    v57 = v83;
                                                    goto label_684;
                                                }
                                                int v86 = zzdu.zzh(arr_b, v84, zzdt1);
                                                if(v83 != zzdt1.zza) {
                                                    v6 = v84;
                                                    v57 = v83;
                                                    goto label_684;
                                                }
                                                v84 = zzdu.zzh(arr_b, v86, zzdt1);
                                                v85 = zzdt1.zza;
                                                if(v85 < 0) {
                                                    throw zzfb.zzc();
                                                }
                                                if(v85 > arr_b.length - v84) {
                                                    break alab3;
                                                }
                                                if(v85 != 0) {
                                                    zzez3.add(zzef.zzk(arr_b, v84, v85));
                                                    break;
                                                }
                                                zzez3.add(zzef.zzb);
                                            }
                                        }
                                        throw zzfb.zzf();
                                    }
                                    else {
                                        v57 = v83;
                                        v3 = v81;
                                        unsafe4 = unsafe0;
                                        v5 = v82;
                                        v56 = v47;
                                        v6 = v55;
                                        goto label_768;
                                    }
                                    goto label_628;
                                }
                                case 18: 
                                case 35: {
                                    v55 = v13;
                                    v3 = v20;
                                    v56 = v47;
                                    v5 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe4 = unsafe0;
                                    if(v21 == 2) {
                                        zzek zzek0 = (zzek)zzez3;
                                        v6 = zzdu.zzh(arr_b, v55, zzdt1);
                                        int v60 = zzdt1.zza + v6;
                                        while(v6 < v60) {
                                            zzek0.zze(Double.longBitsToDouble(zzdu.zzn(arr_b, v6)));
                                            v6 += 8;
                                        }
                                        if(v6 != v60) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_768;
                                    }
                                    else if(v21 == 1) {
                                        zzek zzek1 = (zzek)zzez3;
                                        zzek1.zze(Double.longBitsToDouble(zzdu.zzn(arr_b, v55)));
                                        for(v6 = v55 + 8; v6 < v3; v6 = v61 + 8) {
                                            int v61 = zzdu.zzh(arr_b, v6, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            zzek1.zze(Double.longBitsToDouble(zzdu.zzn(arr_b, v61)));
                                        }
                                        goto label_768;
                                    }
                                    v6 = v55;
                                    goto label_768;
                                }
                                case 19: 
                                case 36: {
                                    v55 = v13;
                                    v3 = v20;
                                    v56 = v47;
                                    v5 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe4 = unsafe0;
                                    if(v21 == 2) {
                                        zzer zzer0 = (zzer)zzez3;
                                        v6 = zzdu.zzh(arr_b, v55, zzdt1);
                                        int v62 = zzdt1.zza + v6;
                                        while(v6 < v62) {
                                            zzer0.zze(Float.intBitsToFloat(zzdu.zzb(arr_b, v6)));
                                            v6 += 4;
                                        }
                                        if(v6 != v62) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_768;
                                    }
                                    else if(v21 == 5) {
                                        zzer zzer1 = (zzer)zzez3;
                                        zzer1.zze(Float.intBitsToFloat(zzdu.zzb(arr_b, v55)));
                                        for(v6 = v55 + 4; v6 < v3; v6 = v63 + 4) {
                                            int v63 = zzdu.zzh(arr_b, v6, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            zzer1.zze(Float.intBitsToFloat(zzdu.zzb(arr_b, v63)));
                                        }
                                        goto label_768;
                                    }
                                    v6 = v55;
                                    goto label_768;
                                }
                                case 20: 
                                case 21: 
                                case 37: 
                                case 38: {
                                    v55 = v13;
                                    v3 = v20;
                                    v56 = v47;
                                    v5 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe4 = unsafe0;
                                    if(v21 == 2) {
                                        zzfm zzfm0 = (zzfm)zzez3;
                                        v6 = zzdu.zzh(arr_b, v55, zzdt1);
                                        int v64 = zzdt1.zza + v6;
                                        while(v6 < v64) {
                                            v6 = zzdu.zzk(arr_b, v6, zzdt1);
                                            zzfm0.zze(zzdt1.zzb);
                                        }
                                        if(v6 != v64) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_768;
                                    }
                                    else if(v21 == 0) {
                                        zzfm zzfm1 = (zzfm)zzez3;
                                        v6 = zzdu.zzk(arr_b, v55, zzdt1);
                                        zzfm1.zze(zzdt1.zzb);
                                        while(v6 < v3) {
                                            int v65 = zzdu.zzh(arr_b, v6, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            v6 = zzdu.zzk(arr_b, v65, zzdt1);
                                            zzfm1.zze(zzdt1.zzb);
                                        }
                                        goto label_768;
                                    }
                                    v6 = v55;
                                    goto label_768;
                                }
                                case 25: 
                                case 42: {
                                    v66 = v47;
                                    v67 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe5 = unsafe0;
                                    if(v21 == 2) {
                                        zzdv zzdv0 = (zzdv)zzez3;
                                        v68 = zzdu.zzh(arr_b, v13, zzdt1);
                                        int v73 = zzdt1.zza + v68;
                                        while(v68 < v73) {
                                            v68 = zzdu.zzk(arr_b, v68, zzdt1);
                                            zzdv0.zze(zzdt1.zzb != 0L);
                                        }
                                        if(v68 != v73) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_574;
                                    }
                                    else if(v21 == 0) {
                                        zzdv zzdv1 = (zzdv)zzez3;
                                        v68 = zzdu.zzk(arr_b, v13, zzdt1);
                                        zzdv1.zze(zzdt1.zzb != 0L);
                                        while(v68 < v20) {
                                            int v74 = zzdu.zzh(arr_b, v68, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            v68 = zzdu.zzk(arr_b, v74, zzdt1);
                                            zzdv1.zze(zzdt1.zzb != 0L);
                                        }
                                        goto label_574;
                                    }
                                    goto label_582;
                                }
                                case 22: 
                                case 29: 
                                case 39: 
                                case 43: {
                                    v66 = v47;
                                    v67 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe5 = unsafe0;
                                    if(v21 == 2) {
                                        v68 = zzdu.zzf(arr_b, v13, zzez3, zzdt1);
                                        goto label_574;
                                    }
                                    else if(v21 == 0) {
                                        v55 = v13;
                                        unsafe4 = unsafe5;
                                        v56 = v66;
                                        v5 = v67;
                                        v3 = v20;
                                        v6 = zzdu.zzj(v57, arr_b, v55, v1, zzez3, zzdt0);
                                        goto label_768;
                                    }
                                    goto label_582;
                                }
                                case 30: 
                                case 44: {
                                label_628:
                                    switch(v21) {
                                        case 0: {
                                            v55 = v13;
                                            v82 = v14;
                                            v16 = v9;
                                            v81 = v20;
                                            v87 = zzdu.zzj(v46, arr_b, v55, v1, zzez3, zzdt0);
                                            break;
                                        }
                                        case 2: {
                                            v87 = zzdu.zzf(arr_b, v13, zzez3, zzdt1);
                                            v55 = v13;
                                            v81 = v20;
                                            v82 = v14;
                                            v16 = v9;
                                            break;
                                        }
                                        default: {
                                            v16 = v9;
                                            v55 = v13;
                                            v56 = v47;
                                            v57 = v46;
                                            v5 = v14;
                                            unsafe4 = unsafe0;
                                            v3 = v20;
                                            v6 = v55;
                                            goto label_768;
                                        }
                                    }
                                    zzey zzey1 = this.zzq(v82);
                                    zzgz zzgz0 = this.zzl;
                                    if(zzey1 == null) {
                                        v89 = v87;
                                    }
                                    else if(zzez3 instanceof RandomAccess) {
                                        int v88 = zzez3.size();
                                        v89 = v87;
                                        Object object3 = null;
                                        int v91 = 0;
                                        for(int v90 = 0; v90 < v88; ++v90) {
                                            int v92 = (int)(((Integer)zzez3.get(v90)));
                                            if(zzey1.zza()) {
                                                if(v90 != v91) {
                                                    zzez3.set(v91, v92);
                                                }
                                                ++v91;
                                            }
                                            else {
                                                object3 = zzgk.zzc(object0, v47, v92, object3, zzgz0);
                                            }
                                        }
                                        if(v91 != v88) {
                                            zzez3.subList(v91, v88).clear();
                                        }
                                    }
                                    else {
                                        v89 = v87;
                                        Object object4 = null;
                                        Iterator iterator0 = zzez3.iterator();
                                        while(iterator0.hasNext()) {
                                            Object object5 = iterator0.next();
                                            int v93 = (int)(((Integer)object5));
                                            if(!zzey1.zza()) {
                                                object4 = zzgk.zzc(object0, v47, v93, object4, zzgz0);
                                                iterator0.remove();
                                            }
                                        }
                                    }
                                    v6 = v89;
                                    v57 = v46;
                                label_684:
                                    v3 = v81;
                                    unsafe4 = unsafe0;
                                    v5 = v82;
                                    v56 = v47;
                                    goto label_768;
                                }
                                case 24: 
                                case 0x1F: 
                                case 41: 
                                case 45: {
                                    v66 = v47;
                                    v67 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe5 = unsafe0;
                                    if(v21 == 2) {
                                        zzew zzew0 = (zzew)zzez3;
                                        v68 = zzdu.zzh(arr_b, v13, zzdt1);
                                        int v71 = zzdt1.zza + v68;
                                        while(v68 < v71) {
                                            zzew0.zze(zzdu.zzb(arr_b, v68));
                                            v68 += 4;
                                        }
                                        if(v68 != v71) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_574;
                                    }
                                    else if(v21 == 5) {
                                        zzew zzew1 = (zzew)zzez3;
                                        zzew1.zze(zzdu.zzb(arr_b, v13));
                                        for(v68 = v13 + 4; v68 < v20; v68 = v72 + 4) {
                                            int v72 = zzdu.zzh(arr_b, v68, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            zzew1.zze(zzdu.zzb(arr_b, v72));
                                        }
                                        goto label_574;
                                    }
                                    goto label_582;
                                }
                                case 23: 
                                case 0x20: 
                                case 40: 
                                case 46: {
                                    v66 = v47;
                                    v67 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe5 = unsafe0;
                                    if(v21 == 2) {
                                        zzfm zzfm2 = (zzfm)zzez3;
                                        v68 = zzdu.zzh(arr_b, v13, zzdt1);
                                        int v69 = zzdt1.zza + v68;
                                        while(v68 < v69) {
                                            zzfm2.zze(zzdu.zzn(arr_b, v68));
                                            v68 += 8;
                                        }
                                        if(v68 != v69) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_574;
                                    }
                                    else if(v21 == 1) {
                                        zzfm zzfm3 = (zzfm)zzez3;
                                        zzfm3.zze(zzdu.zzn(arr_b, v13));
                                        for(v68 = v13 + 8; v68 < v20; v68 = v70 + 8) {
                                            int v70 = zzdu.zzh(arr_b, v68, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            zzfm3.zze(zzdu.zzn(arr_b, v70));
                                        }
                                        goto label_574;
                                    }
                                    goto label_582;
                                }
                                case 33: 
                                case 0x2F: {
                                    v94 = v46;
                                    if(v21 == 2) {
                                        zzew zzew2 = (zzew)zzez3;
                                        v95 = zzdu.zzh(arr_b, v13, zzdt1);
                                        int v96 = zzdt1.zza + v95;
                                        while(v95 < v96) {
                                            v95 = zzdu.zzh(arr_b, v95, zzdt1);
                                            zzew2.zze(zzdt1.zza >>> 1 ^ -(zzdt1.zza & 1));
                                        }
                                        if(v95 != v96) {
                                            throw zzfb.zzf();
                                        }
                                        goto label_743;
                                    }
                                    else if(v21 == 0) {
                                        zzew zzew3 = (zzew)zzez3;
                                        v95 = zzdu.zzh(arr_b, v13, zzdt1);
                                        zzew3.zze(zzdt1.zza >>> 1 ^ -(zzdt1.zza & 1));
                                        while(v95 < v20) {
                                            int v97 = zzdu.zzh(arr_b, v95, zzdt1);
                                            if(v94 != zzdt1.zza) {
                                                break;
                                            }
                                            v95 = zzdu.zzh(arr_b, v97, zzdt1);
                                            zzew3.zze(zzdt1.zza >>> 1 ^ -(zzdt1.zza & 1));
                                        }
                                        goto label_743;
                                    }
                                    else {
                                        v55 = v13;
                                        v56 = v47;
                                        v57 = v94;
                                        v5 = v14;
                                        v16 = v9;
                                        unsafe4 = unsafe0;
                                        v3 = v20;
                                    }
                                    v6 = v55;
                                    goto label_768;
                                }
                                case 34: 
                                case 0x30: {
                                    switch(v21) {
                                        case 0: {
                                            zzfm zzfm4 = (zzfm)zzez3;
                                            v95 = zzdu.zzk(arr_b, v13, zzdt1);
                                            zzfm4.zze(zzdt1.zzb >>> 1 ^ -(1L & zzdt1.zzb));
                                            while(true) {
                                                if(v95 < v20) {
                                                    int v98 = zzdu.zzh(arr_b, v95, zzdt1);
                                                    v94 = v46;
                                                    if(v94 == zzdt1.zza) {
                                                        v95 = zzdu.zzk(arr_b, v98, zzdt1);
                                                        zzfm4.zze(zzdt1.zzb >>> 1 ^ -(1L & zzdt1.zzb));
                                                        v46 = v94;
                                                        continue;
                                                    }
                                                    else {
                                                        break;
                                                    }
                                                }
                                                v94 = v46;
                                                break;
                                            }
                                        label_743:
                                            v55 = v13;
                                            v6 = v95;
                                            v56 = v47;
                                            v57 = v94;
                                            v5 = v14;
                                            v16 = v9;
                                            unsafe4 = unsafe0;
                                            v3 = v20;
                                            goto label_768;
                                        }
                                        case 2: {
                                            zzfm zzfm5 = (zzfm)zzez3;
                                            int v99 = zzdu.zzh(arr_b, v13, zzdt1);
                                            int v100 = zzdt1.zza + v99;
                                            while(v99 < v100) {
                                                v99 = zzdu.zzk(arr_b, v99, zzdt1);
                                                zzfm5.zze(zzdt1.zzb >>> 1 ^ -(1L & zzdt1.zzb));
                                            }
                                            if(v99 == v100) {
                                                v55 = v13;
                                                v6 = v99;
                                                v3 = v20;
                                                v56 = v47;
                                                v5 = v14;
                                                v57 = v46;
                                                v16 = v9;
                                                unsafe4 = unsafe0;
                                            label_768:
                                                if(v6 == v55) {
                                                    v15 = v6;
                                                    v8 = v57;
                                                    unsafe1 = unsafe4;
                                                    v18 = v56;
                                                    v20 = v3;
                                                    v19 = v2;
                                                    break alab4;
                                                }
                                                else {
                                                    v4 = v2;
                                                    v8 = v57;
                                                    unsafe0 = unsafe4;
                                                    v10 = v56;
                                                    v7 = v5;
                                                    v5 = 0;
                                                    v9 = v16;
                                                    v11 = v17;
                                                    continue;
                                                }
                                            }
                                            throw zzfb.zzf();
                                        }
                                        default: {
                                            v55 = v13;
                                            v3 = v20;
                                            v56 = v47;
                                            v5 = v14;
                                            v57 = v46;
                                            v16 = v9;
                                            unsafe4 = unsafe0;
                                            v6 = v55;
                                            goto label_768;
                                        }
                                    }
                                }
                                default: {
                                    v55 = v13;
                                    v3 = v20;
                                    v56 = v47;
                                    v5 = v14;
                                    v57 = v46;
                                    v16 = v9;
                                    unsafe4 = unsafe0;
                                    if(v21 == 3) {
                                        zzgi zzgi0 = this.zzr(v5);
                                        int v58 = v57 & -8 | 4;
                                        v6 = zzdu.zzc(zzgi0, arr_b, v55, v1, v58, zzdt0);
                                        zzez3.add(zzdt1.zzc);
                                        while(v6 < v3) {
                                            int v59 = zzdu.zzh(arr_b, v6, zzdt1);
                                            if(v57 != zzdt1.zza) {
                                                break;
                                            }
                                            v6 = zzdu.zzc(zzgi0, arr_b, v59, v1, v58, zzdt0);
                                            zzez3.add(zzdt1.zzc);
                                        }
                                        goto label_768;
                                    }
                                    v6 = v55;
                                    goto label_768;
                                }
                            }
                        }
                        else {
                            unsafe1 = unsafe0;
                            v16 = v9;
                            v52 = v13;
                            v53 = v14;
                            v50 = v47;
                            if(v23 == 50) {
                                if(v21 == 2) {
                                    Unsafe unsafe6 = zzga.zzb;
                                    Object object6 = this.zzs(v53);
                                    Object object7 = unsafe6.getObject(object0, v24);
                                    if(!((zzfr)object7).zze()) {
                                        zzfr zzfr0 = zzfr.zza().zzb();
                                        zzfs.zza(zzfr0, object7);
                                        unsafe6.putObject(object0, v24, zzfr0);
                                    }
                                    zzfq zzfq0 = (zzfq)object6;
                                    throw null;
                                }
                                v51 = v46;
                            label_803:
                                v19 = v2;
                                v5 = v53;
                                v18 = v50;
                                v8 = v51;
                                v15 = v52;
                            }
                            else {
                                Unsafe unsafe7 = zzga.zzb;
                                long v101 = (long)(arr_v[v53 + 2] & 0xFFFFF);
                                switch(v23) {
                                    case 51: {
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 1) {
                                            unsafe7.putObject(object0, v24, Double.longBitsToDouble(zzdu.zzn(arr_b, v102)));
                                            v104 = v102 + 8;
                                            unsafe7.putInt(object0, v101, v18);
                                            break;
                                        }
                                        v104 = v102;
                                        break;
                                    }
                                    case 52: {
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 5) {
                                            unsafe7.putObject(object0, v24, Float.intBitsToFloat(zzdu.zzb(arr_b, v102)));
                                            v104 = v102 + 4;
                                            unsafe7.putInt(object0, v101, v18);
                                            break;
                                        }
                                        v104 = v102;
                                        break;
                                    }
                                    case 53: 
                                    case 54: {
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 0) {
                                            v104 = zzdu.zzk(arr_b, v102, zzdt2);
                                            unsafe7.putObject(object0, v24, zzdt2.zzb);
                                            unsafe7.putInt(object0, v101, v18);
                                            break;
                                        }
                                        v104 = v102;
                                        break;
                                    }
                                    case 58: {
                                        v34 = v46;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 0) {
                                            v104 = zzdu.zzk(arr_b, v52, zzdt2);
                                            v102 = v52;
                                            unsafe7.putObject(object0, v24, Boolean.valueOf(zzdt2.zzb != 0L));
                                            unsafe7.putInt(object0, v101, v18);
                                        }
                                        else {
                                            v102 = v52;
                                            v104 = v102;
                                        }
                                        break;
                                    }
                                    case 59: {
                                        v20 = v1;
                                        v103 = v53;
                                        v18 = v50;
                                        zzdt2 = zzdt1;
                                        if(v21 == 2) {
                                            v104 = zzdu.zzh(arr_b, v52, zzdt2);
                                            int v105 = zzdt2.zza;
                                            if(v105 == 0) {
                                                unsafe7.putObject(object0, v24, "");
                                            }
                                            else {
                                                if((v22 & 0x20000000) != 0 && !zzhn.zzc(arr_b, v104, v104 + v105)) {
                                                    throw zzfb.zzb();
                                                }
                                                unsafe7.putObject(object0, v24, new String(arr_b, v104, v105, zzfa.zzb));
                                                v104 += v105;
                                            }
                                            unsafe7.putInt(object0, v101, v18);
                                            v34 = v46;
                                            v102 = v52;
                                        }
                                        else {
                                            v34 = v46;
                                            v102 = v52;
                                            v104 = v102;
                                        }
                                        break;
                                    }
                                    case 60: {
                                        if(v21 == 2) {
                                            Object object8 = this.zzu(object0, v50, v53);
                                            int v106 = zzdu.zzm(object8, this.zzr(v53), arr_b, v52, v1, zzdt0);
                                            this.zzC(object0, v50, v53, object8);
                                            zzdt2 = zzdt0;
                                            v104 = v106;
                                            v103 = v53;
                                            v18 = v50;
                                            v102 = v52;
                                            v34 = v46;
                                            v20 = v1;
                                        }
                                        else {
                                            v103 = v53;
                                            v18 = v50;
                                            v34 = v46;
                                            v102 = v52;
                                            v20 = v1;
                                            zzdt2 = zzdt0;
                                            v104 = v102;
                                        }
                                        break;
                                    }
                                    case 61: {
                                        zzdt3 = zzdt1;
                                        v107 = v52;
                                        if(v21 == 2) {
                                            v104 = zzdu.zza(arr_b, v107, zzdt3);
                                            unsafe7.putObject(object0, v24, zzdt3.zzc);
                                            unsafe7.putInt(object0, v101, v50);
                                            goto label_965;
                                        }
                                        goto label_972;
                                    }
                                    case 55: 
                                    case 62: {
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 0) {
                                            v104 = zzdu.zzh(arr_b, v102, zzdt2);
                                            unsafe7.putObject(object0, v24, zzdt2.zza);
                                            unsafe7.putInt(object0, v101, v18);
                                            break;
                                        }
                                        v104 = v102;
                                        break;
                                    }
                                    case 0x3F: {
                                        zzdt3 = zzdt1;
                                        v107 = v52;
                                        if(v21 == 0) {
                                            v104 = zzdu.zzh(arr_b, v107, zzdt3);
                                            int v108 = zzdt3.zza;
                                            zzey zzey2 = this.zzq(v53);
                                            if(zzey2 == null || zzey2.zza()) {
                                                unsafe7.putObject(object0, v24, v108);
                                                unsafe7.putInt(object0, v101, v50);
                                            }
                                            else {
                                                zzga.zzc(object0).zzh(v46, ((long)v108));
                                            }
                                            goto label_965;
                                        }
                                        goto label_972;
                                    }
                                    case 57: 
                                    case 0x40: {
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 5) {
                                            unsafe7.putObject(object0, v24, zzdu.zzb(arr_b, v102));
                                            v104 = v102 + 4;
                                            unsafe7.putInt(object0, v101, v18);
                                            break;
                                        }
                                        v104 = v102;
                                        break;
                                    }
                                    case 56: 
                                    case 65: {
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v103 = v53;
                                        v18 = v50;
                                        v20 = v1;
                                        if(v21 == 1) {
                                            unsafe7.putObject(object0, v24, zzdu.zzn(arr_b, v102));
                                            v104 = v102 + 8;
                                            unsafe7.putInt(object0, v101, v18);
                                            break;
                                        }
                                        v104 = v102;
                                        break;
                                    }
                                    case 66: {
                                        zzdt3 = zzdt1;
                                        v107 = v52;
                                        if(v21 == 0) {
                                            v104 = zzdu.zzh(arr_b, v107, zzdt3);
                                            unsafe7.putObject(object0, v24, ((int)(zzdt3.zza >>> 1 ^ -(zzdt3.zza & 1))));
                                            unsafe7.putInt(object0, v101, v50);
                                            goto label_965;
                                        }
                                        goto label_972;
                                    }
                                    case 67: {
                                        zzdt3 = zzdt1;
                                        v107 = v52;
                                        if(v21 == 0) {
                                            v104 = zzdu.zzk(arr_b, v107, zzdt3);
                                            unsafe7.putObject(object0, v24, ((long)(zzdt3.zzb >>> 1 ^ -(1L & zzdt3.zzb))));
                                            unsafe7.putInt(object0, v101, v50);
                                        label_965:
                                            v103 = v53;
                                            v18 = v50;
                                            v34 = v46;
                                            v102 = v107;
                                            v20 = v1;
                                            zzdt2 = zzdt3;
                                            break;
                                        }
                                    label_972:
                                        v103 = v53;
                                        v18 = v50;
                                        v34 = v46;
                                        v102 = v107;
                                        v20 = v1;
                                        zzdt2 = zzdt3;
                                        v104 = v102;
                                        break;
                                    }
                                    case 68: {
                                        if(v21 == 3) {
                                            Object object9 = this.zzu(object0, v50, v53);
                                            int v109 = zzdu.zzl(object9, this.zzr(v53), arr_b, v52, v1, v46 & -8 | 4, zzdt0);
                                            this.zzC(object0, v50, v53, object9);
                                            v103 = v53;
                                            v18 = v50;
                                            v34 = v46;
                                            v104 = v109;
                                            zzdt2 = zzdt1;
                                            v102 = v52;
                                            v20 = v1;
                                            break;
                                        }
                                    label_991:
                                        v20 = v1;
                                        v103 = v53;
                                        v18 = v50;
                                        v34 = v46;
                                        v102 = v52;
                                        zzdt2 = zzdt1;
                                        v104 = v102;
                                        break;
                                    }
                                    default: {
                                        goto label_991;
                                    }
                                }
                                if(v104 == v102) {
                                    v19 = v2;
                                    v15 = v104;
                                    v5 = v103;
                                    v8 = v34;
                                }
                                else {
                                    v4 = v2;
                                    zzdt1 = zzdt2;
                                    v3 = v20;
                                    v7 = v103;
                                    v5 = 0;
                                    v8 = v34;
                                    v9 = v16;
                                    unsafe0 = unsafe1;
                                    v11 = v17;
                                    v10 = v18;
                                    v6 = v104;
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            if(v8 != v19 || v19 == 0) {
                v6 = zzdu.zzg(v8, arr_b, v15, v1, zzga.zzc(object0), zzdt0);
                v3 = v20;
                v7 = v5;
                v10 = v18;
                unsafe0 = unsafe1;
                v5 = 0;
                v9 = v16;
                v11 = v17;
                zzdt1 = zzdt0;
                v4 = v19;
                continue;
            }
            else {
                v6 = v15;
                v110 = v20;
                v9 = v16;
                unsafe8 = unsafe1;
                v11 = v17;
            }
            break;
        }
        if(v11 != 0xFFFFF) {
            unsafe8.putInt(object0, ((long)v11), v9);
        }
        int v111 = this.zzi;
        while(v111 < this.zzj) {
            int v112 = this.zzh[v111];
            int v113 = this.zzc[v112];
            Object object10 = zzhj.zzf(object0, ((long)(this.zzo(v112) & 0xFFFFF)));
            if(object10 == null || this.zzq(v112) == null) {
                ++v111;
                continue;
            }
            zzfr zzfr1 = (zzfr)object10;
            zzfq zzfq1 = (zzfq)this.zzs(v112);
            throw null;
        }
        if(v19 == 0) {
            if(v6 != v110) {
                throw zzfb.zzd();
            }
            return v6;
        }
        if(v6 > v110 || v8 != v19) {
            throw zzfb.zzd();
        }
        return v6;
    }

    static zzha zzc(Object object0) {
        zzha zzha0 = ((zzev)object0).zzc;
        if(zzha0 == zzha.zza()) {
            zzha0 = zzha.zzd();
            ((zzev)object0).zzc = zzha0;
        }
        return zzha0;
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev)this.zzg).zzc();
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object object0) {
        if(!zzga.zzH(object0)) {
            return;
        }
        if(object0 instanceof zzev) {
            ((zzev)object0).zzl(0x7FFFFFFF);
            ((zzev)object0).zza = 0;
            ((zzev)object0).zzj();
        }
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v1 = this.zzo(v);
            long v2 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzE(object0, v)) {
                        this.zzr(v).zze(zzga.zzb.getObject(object0, v2));
                    }
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    this.zzk.zza(object0, v2);
                    break;
                }
                case 50: {
                    Unsafe unsafe0 = zzga.zzb;
                    Object object1 = unsafe0.getObject(object0, v2);
                    if(object1 != null) {
                        ((zzfr)object1).zzc();
                        unsafe0.putObject(object0, v2, object1);
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzI(object0, this.zzc[v], v)) {
                        this.zzr(v).zze(zzga.zzb.getObject(object0, v2));
                    }
                }
            }
        }
        this.zzl.zze(object0);
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object object0, Object object1) {
        zzga.zzw(object0);
        object1.getClass();
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v1 = this.zzo(v);
            int v2 = this.zzc[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzl(object0, v3, zzhj.zza(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzm(object0, v3, zzhj.zzb(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzk(object0, v3, zzhj.zzt(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zzx(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zzx(object0, object1, v);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    this.zzk.zzb(object0, object1, v3);
                    break;
                }
                case 50: {
                    zzhj.zzp(object0, v3, zzfs.zza(zzhj.zzf(object0, v3), zzhj.zzf(object1, v3)));
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if(this.zzI(object1, v2, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzA(object0, v2, v);
                    }
                    break;
                }
                case 60: {
                    this.zzy(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zzI(object1, v2, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzA(object0, v2, v);
                    }
                    break;
                }
                case 68: {
                    this.zzy(object0, object1, v);
                }
            }
        }
        zzgk.zzd(this.zzl, object0, object1);
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object object0, byte[] arr_b, int v, int v1, zzdt zzdt0) throws IOException {
        this.zzb(object0, arr_b, v, v1, 0, zzdt0);
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object object0, Object object1) {
        boolean z;
        int v = 0;
        while(v < this.zzc.length) {
            int v1 = this.zzo(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(!this.zzD(object0, object1, v) || Double.doubleToLongBits(zzhj.zza(object0, v2)) != Double.doubleToLongBits(zzhj.zza(object1, v2))) {
                        return false;
                    }
                    break;
                }
                case 1: {
                    if(this.zzD(object0, object1, v) && Float.floatToIntBits(zzhj.zzb(object0, v2)) == Float.floatToIntBits(zzhj.zzb(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.zzD(object0, object1, v) && zzhj.zzt(object0, v2) == zzhj.zzt(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    z = zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2));
                    goto label_45;
                }
                case 50: {
                    z = zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2));
                label_45:
                    if(!z) {
                        return false;
                    }
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: 
                case 68: {
                    int v3 = this.zzl(v);
                    if(zzhj.zzc(object0, ((long)(v3 & 0xFFFFF))) != zzhj.zzc(object1, ((long)(v3 & 0xFFFFF))) || !zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        return false;
                    }
                }
            }
            v += 3;
        }
        return this.zzl.zzb(object0).equals(this.zzl.zzb(object1));
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object object0) {
        int v10;
        int v9;
        int v1 = 0;
        int v2 = 0xFFFFF;
        for(int v = 0; v1 < this.zzi; v = v9) {
            int v3 = this.zzh[v1];
            int v4 = this.zzc[v3];
            int v5 = this.zzo(v3);
            int v6 = this.zzc[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v2) {
                v10 = v2;
                v9 = v;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v = zzga.zzb.getInt(object0, ((long)v7));
                }
                v9 = v;
                v10 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.zzF(object0, v3, v10, v9, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzF(object0, v3, v10, v9, v8) && !zzga.zzG(object0, v5, this.zzr(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zzhj.zzf(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zzgi zzgi0 = this.zzr(v3);
                        for(int v11 = 0; v11 < list0.size(); ++v11) {
                            if(!zzgi0.zzi(list0.get(v11))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    if(!((zzfr)zzhj.zzf(object0, ((long)(v5 & 0xFFFFF)))).isEmpty()) {
                        zzfq zzfq0 = (zzfq)this.zzs(v3);
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzI(object0, v4, v3) && !zzga.zzG(object0, v5, this.zzr(v3))) {
                        return false;
                    }
                }
            }
            ++v1;
            v2 = v10;
        }
        return true;
    }

    static zzga zzj(Class class0, zzfu zzfu0, zzgc zzgc0, zzfl zzfl0, zzgz zzgz0, zzem zzem0, zzfs zzfs0) {
        int v93;
        Field field3;
        int v91;
        String s1;
        int v82;
        int v81;
        int v80;
        int v79;
        Field field1;
        int v78;
        int v77;
        Field field0;
        int v72;
        int v69;
        int v63;
        int v14;
        int[] arr_v;
        int v13;
        int v12;
        int v11;
        int v10;
        int v9;
        int v8;
        int v2;
        if(zzfu0 instanceof zzgh) {
            String s = ((zzgh)zzfu0).zzd();
            int v = s.length();
            if(s.charAt(0) >= 0xD800) {
                for(int v1 = 1; true; v1 = v2) {
                    v2 = v1 + 1;
                    if(s.charAt(v1) < 0xD800) {
                        break;
                    }
                }
            }
            else {
                v2 = 1;
            }
            int v3 = v2 + 1;
            int v4 = s.charAt(v2);
            if(v4 >= 0xD800) {
                int v5 = v4 & 0x1FFF;
                int v6 = 13;
                int v7;
                while((v7 = s.charAt(v3)) >= 0xD800) {
                    v5 |= (v7 & 0x1FFF) << v6;
                    v6 += 13;
                    ++v3;
                }
                v4 = v5 | v7 << v6;
                ++v3;
            }
            if(v4 == 0) {
                v8 = 0;
                v9 = 0;
                v10 = 0;
                v11 = 0;
                v12 = 0;
                v13 = 0;
                arr_v = zzga.zza;
                v14 = 0;
            }
            else {
                int v15 = v3 + 1;
                int v16 = s.charAt(v3);
                if(v16 >= 0xD800) {
                    int v17 = v16 & 0x1FFF;
                    int v18 = 13;
                    int v19;
                    while((v19 = s.charAt(v15)) >= 0xD800) {
                        v17 |= (v19 & 0x1FFF) << v18;
                        v18 += 13;
                        ++v15;
                    }
                    v16 = v17 | v19 << v18;
                    ++v15;
                }
                int v20 = v15 + 1;
                int v21 = s.charAt(v15);
                if(v21 >= 0xD800) {
                    int v22 = v21 & 0x1FFF;
                    int v23 = 13;
                    int v24;
                    while((v24 = s.charAt(v20)) >= 0xD800) {
                        v22 |= (v24 & 0x1FFF) << v23;
                        v23 += 13;
                        ++v20;
                    }
                    v21 = v22 | v24 << v23;
                    ++v20;
                }
                int v25 = v20 + 1;
                int v26 = s.charAt(v20);
                if(v26 >= 0xD800) {
                    int v27 = v26 & 0x1FFF;
                    int v28 = 13;
                    int v29;
                    while((v29 = s.charAt(v25)) >= 0xD800) {
                        v27 |= (v29 & 0x1FFF) << v28;
                        v28 += 13;
                        ++v25;
                    }
                    v26 = v27 | v29 << v28;
                    ++v25;
                }
                int v30 = v25 + 1;
                int v31 = s.charAt(v25);
                if(v31 >= 0xD800) {
                    int v32 = v31 & 0x1FFF;
                    int v33 = 13;
                    int v34;
                    while((v34 = s.charAt(v30)) >= 0xD800) {
                        v32 |= (v34 & 0x1FFF) << v33;
                        v33 += 13;
                        ++v30;
                    }
                    v31 = v32 | v34 << v33;
                    ++v30;
                }
                int v35 = v30 + 1;
                v8 = s.charAt(v30);
                if(v8 >= 0xD800) {
                    int v36 = v8 & 0x1FFF;
                    int v37 = 13;
                    int v38;
                    while((v38 = s.charAt(v35)) >= 0xD800) {
                        v36 |= (v38 & 0x1FFF) << v37;
                        v37 += 13;
                        ++v35;
                    }
                    v8 = v36 | v38 << v37;
                    ++v35;
                }
                int v39 = v35 + 1;
                v9 = s.charAt(v35);
                if(v9 >= 0xD800) {
                    int v40 = v9 & 0x1FFF;
                    int v41 = 13;
                    int v42;
                    while((v42 = s.charAt(v39)) >= 0xD800) {
                        v40 |= (v42 & 0x1FFF) << v41;
                        v41 += 13;
                        ++v39;
                    }
                    v9 = v40 | v42 << v41;
                    ++v39;
                }
                int v43 = v39 + 1;
                int v44 = s.charAt(v39);
                if(v44 >= 0xD800) {
                    int v45 = v44 & 0x1FFF;
                    int v46 = 13;
                    int v47;
                    while((v47 = s.charAt(v43)) >= 0xD800) {
                        v45 |= (v47 & 0x1FFF) << v46;
                        v46 += 13;
                        ++v43;
                    }
                    v44 = v45 | v47 << v46;
                    ++v43;
                }
                int v48 = v43 + 1;
                int v49 = s.charAt(v43);
                if(v49 >= 0xD800) {
                    int v50 = v49 & 0x1FFF;
                    int v51 = 13;
                    int v52;
                    while((v52 = s.charAt(v48)) >= 0xD800) {
                        v50 |= (v52 & 0x1FFF) << v51;
                        v51 += 13;
                        ++v48;
                    }
                    v49 = v50 | v52 << v51;
                    ++v48;
                }
                v12 = v16 * 2 + v21;
                arr_v = new int[v49 + v9 + v44];
                v10 = v26;
                v13 = v49;
                v14 = v16;
                v11 = v31;
                v3 = v48;
            }
            Unsafe unsafe0 = zzga.zzb;
            Object[] arr_object = ((zzgh)zzfu0).zze();
            Class class1 = ((zzgh)zzfu0).zza().getClass();
            int v53 = v13 + v9;
            int[] arr_v1 = new int[v8 * 3];
            Object[] arr_object1 = new Object[v8 + v8];
            int v54 = 0;
            int v55 = 0;
            int v56 = v13;
            int v57 = v53;
            while(v3 < v) {
                int v58 = s.charAt(v3);
                if(v58 >= 0xD800) {
                    int v59 = v58 & 0x1FFF;
                    int v60 = v3 + 1;
                    int v61 = 13;
                    int v62;
                    while((v62 = s.charAt(v60)) >= 0xD800) {
                        v59 |= (v62 & 0x1FFF) << v61;
                        v61 += 13;
                        ++v60;
                    }
                    v58 = v59 | v62 << v61;
                    v63 = v60 + 1;
                }
                else {
                    v63 = v3 + 1;
                }
                int v64 = s.charAt(v63);
                if(v64 >= 0xD800) {
                    int v65 = v64 & 0x1FFF;
                    int v66 = v63 + 1;
                    int v67 = 13;
                    int v68;
                    while((v68 = s.charAt(v66)) >= 0xD800) {
                        v65 |= (v68 & 0x1FFF) << v67;
                        v67 += 13;
                        ++v66;
                    }
                    v64 = v65 | v68 << v67;
                    v69 = v66 + 1;
                }
                else {
                    v69 = v63 + 1;
                }
                if((v64 & 0x400) != 0) {
                    arr_v[v54] = v55;
                    ++v54;
                }
                if((v64 & 0xFF) >= 51) {
                    int v70 = v69 + 1;
                    int v71 = s.charAt(v69);
                    v72 = v;
                    if(v71 >= 0xD800) {
                        int v73 = v71 & 0x1FFF;
                        int v74 = 13;
                        int v75;
                        while((v75 = s.charAt(v70)) >= 0xD800) {
                            v73 |= (v75 & 0x1FFF) << v74;
                            v74 += 13;
                            ++v70;
                        }
                        v71 = v73 | v75 << v74;
                        ++v70;
                    }
                    switch((v64 & 0xFF) - 51) {
                        case 12: {
                            if(((zzgh)zzfu0).zzc() == 1 || (v64 & 0x800) != 0) {
                                arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v12];
                                ++v12;
                            }
                            break;
                        }
                        case 9: 
                        case 17: {
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v12];
                            ++v12;
                        }
                    }
                    int v76 = v71 + v71;
                    Object object0 = arr_object[v76];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = zzga.zzv(class1, ((String)object0));
                        arr_object[v76] = field0;
                    }
                    v77 = v11;
                    v78 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v76 + 1];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzga.zzv(class1, ((String)object1));
                        arr_object[v76 + 1] = field1;
                    }
                    v79 = v10;
                    v80 = (int)unsafe0.objectFieldOffset(field1);
                    v81 = v70;
                    v82 = 0;
                    s1 = s;
                }
                else {
                    v72 = v;
                    v77 = v11;
                    int v83 = v12 + 1;
                    Field field2 = zzga.zzv(class1, ((String)arr_object[v12]));
                    switch(v64 & 0xFF) {
                        case 9: 
                        case 17: {
                            v79 = v10;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = field2.getType();
                            break;
                        }
                        case 12: 
                        case 30: 
                        case 44: {
                            v79 = v10;
                            if(((zzgh)zzfu0).zzc() == 1 || (v64 & 0x800) != 0) {
                                arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v83];
                                ++v83;
                            }
                            break;
                        }
                        case 27: 
                        case 49: {
                            v79 = v10;
                            arr_object1[v55 / 3 + v55 / 3 + 1] = arr_object[v83];
                            ++v83;
                            break;
                        }
                        case 50: {
                            arr_v[v56] = v55;
                            int v84 = v83 + 1;
                            int v85 = v55 / 3 + v55 / 3;
                            arr_object1[v85] = arr_object[v83];
                            if((v64 & 0x800) == 0) {
                                ++v56;
                                v83 = v84;
                                v79 = v10;
                            }
                            else {
                                v83 = v84 + 1;
                                arr_object1[v85 + 1] = arr_object[v84];
                                v79 = v10;
                                ++v56;
                            }
                            break;
                        }
                        default: {
                            v79 = v10;
                        }
                    }
                    int v86 = (int)unsafe0.objectFieldOffset(field2);
                    v80 = 0xFFFFF;
                    if((v64 & 0x1000) == 0 || (v64 & 0xFF) > 17) {
                        s1 = s;
                        v93 = v83;
                        v81 = v69;
                        v82 = 0;
                    }
                    else {
                        int v87 = v69 + 1;
                        int v88 = s.charAt(v69);
                        if(v88 >= 0xD800) {
                            int v89 = v88 & 0x1FFF;
                            int v90 = 13;
                            while(true) {
                                v81 = v87 + 1;
                                v91 = s.charAt(v87);
                                if(v91 < 0xD800) {
                                    break;
                                }
                                v89 |= (v91 & 0x1FFF) << v90;
                                v90 += 13;
                                v87 = v81;
                            }
                            v88 = v89 | v91 << v90;
                        }
                        else {
                            v81 = v87;
                        }
                        int v92 = v88 / 0x20 + v14 * 2;
                        Object object2 = arr_object[v92];
                        s1 = s;
                        if(object2 instanceof Field) {
                            field3 = (Field)object2;
                        }
                        else {
                            field3 = zzga.zzv(class1, ((String)object2));
                            arr_object[v92] = field3;
                        }
                        v93 = v83;
                        v82 = v88 % 0x20;
                        v80 = (int)unsafe0.objectFieldOffset(field3);
                    }
                    if((v64 & 0xFF) >= 18 && (v64 & 0xFF) <= 49) {
                        arr_v[v57] = v86;
                        ++v57;
                    }
                    v78 = v86;
                    v12 = v93;
                }
                arr_v1[v55] = v58;
                int v94 = v55 + 2;
                arr_v1[v55 + 1] = v78 | (((v64 & 0x800) == 0 ? 0 : 0x80000000) | (((v64 & 0x200) == 0 ? 0 : 0x20000000) | ((v64 & 0x100) == 0 ? 0 : 0x10000000)) | (v64 & 0xFF) << 20);
                v55 = v94 + 1;
                arr_v1[v94] = v82 << 20 | v80;
                v3 = v81;
                v = v72;
                v10 = v79;
                s = s1;
                v11 = v77;
            }
            return new zzga(arr_v1, arr_object1, v10, v11, ((zzgh)zzfu0).zza(), ((zzgh)zzfu0).zzc(), false, arr_v, v13, v53, zzgc0, zzfl0, zzgz0, zzem0, zzfs0);
        }
        zzgw zzgw0 = (zzgw)zzfu0;
        throw null;
    }

    private static int zzk(Object object0, long v) {
        return (int)(((Integer)zzhj.zzf(object0, v)));
    }

    private final int zzl(int v) {
        return this.zzc[v + 2];
    }

    private final int zzm(int v, int v1) {
        int v2 = this.zzc.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = this.zzc[v4];
            if(v == v5) {
                return v4;
            }
            if(v < v5) {
                v2 = v3 - 1;
            }
            else {
                v1 = v3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int v) [...] // Inlined contents

    private final int zzo(int v) {
        return this.zzc[v + 1];
    }

    private static long zzp(Object object0, long v) {
        return (long)(((Long)zzhj.zzf(object0, v)));
    }

    private final zzey zzq(int v) {
        return (zzey)this.zzd[v / 3 * 2 + 1];
    }

    private final zzgi zzr(int v) {
        int v1 = v / 3 + v / 3;
        zzgi zzgi0 = (zzgi)this.zzd[v1];
        if(zzgi0 != null) {
            return zzgi0;
        }
        zzgi zzgi1 = zzgf.zza().zzb(((Class)this.zzd[v1 + 1]));
        this.zzd[v1] = zzgi1;
        return zzgi1;
    }

    private final Object zzs(int v) {
        return this.zzd[v / 3 + v / 3];
    }

    private final Object zzt(Object object0, int v) {
        zzgi zzgi0 = this.zzr(v);
        int v1 = this.zzo(v);
        if(!this.zzE(object0, v)) {
            return zzgi0.zzd();
        }
        Object object1 = zzga.zzb.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(zzga.zzH(object1)) {
            return object1;
        }
        Object object2 = zzgi0.zzd();
        if(object1 != null) {
            zzgi0.zzf(object2, object1);
        }
        return object2;
    }

    private final Object zzu(Object object0, int v, int v1) {
        zzgi zzgi0 = this.zzr(v1);
        if(!this.zzI(object0, v, v1)) {
            return zzgi0.zzd();
        }
        int v2 = this.zzo(v1);
        Object object1 = zzga.zzb.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(zzga.zzH(object1)) {
            return object1;
        }
        Object object2 = zzgi0.zzd();
        if(object1 != null) {
            zzgi0.zzf(object2, object1);
        }
        return object2;
    }

    private static Field zzv(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException unused_ex) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(s.equals(field0.getName())) {
                    return field0;
                }
            }
            throw new RuntimeException("Field " + s + " for " + class0.getName() + " not found. Known fields are " + Arrays.toString(arr_field));
        }
    }

    private static void zzw(Object object0) {
        if(!zzga.zzH(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    private final void zzx(Object object0, Object object1, int v) {
        if(!this.zzE(object1, v)) {
            return;
        }
        int v1 = this.zzo(v);
        Unsafe unsafe0 = zzga.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.zzc[v] + " is present but null: " + object1.toString());
        }
        zzgi zzgi0 = this.zzr(v);
        if(!this.zzE(object0, v)) {
            if(zzga.zzH(object2)) {
                Object object3 = zzgi0.zzd();
                zzgi0.zzf(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.zzz(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!zzga.zzH(object4)) {
            Object object5 = zzgi0.zzd();
            zzgi0.zzf(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzgi0.zzf(object4, object2);
    }

    private final void zzy(Object object0, Object object1, int v) {
        int v1 = this.zzc[v];
        if(!this.zzI(object1, v1, v)) {
            return;
        }
        int v2 = this.zzo(v);
        Unsafe unsafe0 = zzga.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.zzc[v] + " is present but null: " + object1.toString());
        }
        zzgi zzgi0 = this.zzr(v);
        if(!this.zzI(object0, v1, v)) {
            if(zzga.zzH(object2)) {
                Object object3 = zzgi0.zzd();
                zzgi0.zzf(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.zzA(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!zzga.zzH(object4)) {
            Object object5 = zzgi0.zzd();
            zzgi0.zzf(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzgi0.zzf(object4, object2);
    }

    private final void zzz(Object object0, int v) {
        int v1 = this.zzl(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        zzhj.zzn(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | zzhj.zzc(object0, ((long)(0xFFFFF & v1))));
    }
}

