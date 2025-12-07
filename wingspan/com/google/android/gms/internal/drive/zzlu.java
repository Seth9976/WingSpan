package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import sun.misc.Unsafe;

final class zzlu implements zzmf {
    private static final int[] zzub;
    private static final Unsafe zzuc;
    private final int[] zzud;
    private final Object[] zzue;
    private final int zzuf;
    private final int zzug;
    private final zzlq zzuh;
    private final boolean zzui;
    private final boolean zzuj;
    private final boolean zzuk;
    private final boolean zzul;
    private final int[] zzum;
    private final int zzun;
    private final int zzuo;
    private final zzly zzup;
    private final zzla zzuq;
    private final zzmx zzur;
    private final zzjy zzus;
    private final zzll zzut;

    static {
        zzlu.zzub = new int[0];
        zzlu.zzuc = zznd.zzff();
    }

    private zzlu(int[] arr_v, Object[] arr_object, int v, int v1, zzlq zzlq0, boolean z, boolean z1, int[] arr_v1, int v2, int v3, zzly zzly0, zzla zzla0, zzmx zzmx0, zzjy zzjy0, zzll zzll0) {
        this.zzud = arr_v;
        this.zzue = arr_object;
        this.zzuf = v;
        this.zzug = v1;
        this.zzuj = zzlq0 instanceof zzkk;
        this.zzuk = z;
        this.zzui = zzjy0 != null && zzjy0.zze(zzlq0);
        this.zzul = false;
        this.zzum = arr_v1;
        this.zzun = v2;
        this.zzuo = v3;
        this.zzup = zzly0;
        this.zzuq = zzla0;
        this.zzur = zzmx0;
        this.zzus = zzjy0;
        this.zzuh = zzlq0;
        this.zzut = zzll0;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final boolean equals(Object object0, Object object1) {
        for(int v = 0; true; v += 3) {
            boolean z = true;
            if(v >= this.zzud.length) {
                break;
            }
            int v1 = this.zzas(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    if(!this.zzc(object0, object1, v) || Double.doubleToLongBits(zznd.zzn(object0, v2)) != Double.doubleToLongBits(zznd.zzn(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 1: {
                    if(!this.zzc(object0, object1, v) || Float.floatToIntBits(zznd.zzm(object0, v2)) != Float.floatToIntBits(zznd.zzm(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 2: {
                    if(!this.zzc(object0, object1, v) || zznd.zzk(object0, v2) != zznd.zzk(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 3: {
                    if(!this.zzc(object0, object1, v) || zznd.zzk(object0, v2) != zznd.zzk(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 4: {
                    if(!this.zzc(object0, object1, v) || zznd.zzj(object0, v2) != zznd.zzj(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 5: {
                    if(!this.zzc(object0, object1, v) || zznd.zzk(object0, v2) != zznd.zzk(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 6: {
                    if(!this.zzc(object0, object1, v) || zznd.zzj(object0, v2) != zznd.zzj(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 7: {
                    if(!this.zzc(object0, object1, v) || zznd.zzl(object0, v2) != zznd.zzl(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 8: {
                    if(!this.zzc(object0, object1, v) || !zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 9: {
                    if(!this.zzc(object0, object1, v) || !zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 10: {
                    if(!this.zzc(object0, object1, v) || !zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2))) {
                        z = false;
                    }
                    break;
                }
                case 11: {
                    if(!this.zzc(object0, object1, v) || zznd.zzj(object0, v2) != zznd.zzj(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 12: {
                    if(!this.zzc(object0, object1, v) || zznd.zzj(object0, v2) != zznd.zzj(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 13: {
                    if(!this.zzc(object0, object1, v) || zznd.zzj(object0, v2) != zznd.zzj(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 14: {
                    if(!this.zzc(object0, object1, v) || zznd.zzk(object0, v2) != zznd.zzk(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 15: {
                    if(!this.zzc(object0, object1, v) || zznd.zzj(object0, v2) != zznd.zzj(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 16: {
                    if(!this.zzc(object0, object1, v) || zznd.zzk(object0, v2) != zznd.zzk(object1, v2)) {
                        z = false;
                    }
                    break;
                }
                case 17: {
                    if(!this.zzc(object0, object1, v) || !zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2))) {
                        z = false;
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
                    z = zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2));
                    break;
                }
                case 50: {
                    z = zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2));
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
                    int v3 = this.zzat(v);
                    if(zznd.zzj(object0, ((long)(v3 & 0xFFFFF))) != zznd.zzj(object1, ((long)(v3 & 0xFFFFF))) || !zzmh.zzd(zznd.zzo(object0, v2), zznd.zzo(object1, v2))) {
                        z = false;
                    }
                }
            }
            if(!z) {
                return false;
            }
        }
        if(!this.zzur.zzr(object0).equals(this.zzur.zzr(object1))) {
            return false;
        }
        return this.zzui ? this.zzus.zzb(object0).equals(this.zzus.zzb(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final int hashCode(Object object0) {
        int v7;
        int v6;
        int v1 = 0;
        for(int v = 0; v < this.zzud.length; v += 3) {
            int v2 = this.zzas(v);
            int v3 = this.zzud[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch((v2 & 0xFF00000) >>> 20) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = zzkm.zzu(Double.doubleToLongBits(zznd.zzn(object0, v4)));
                    v1 = v6 + v7;
                    break;
                }
                case 1: {
                    v6 = v1 * 53;
                    v7 = Float.floatToIntBits(zznd.zzm(object0, v4));
                    v1 = v6 + v7;
                    break;
                }
                case 2: {
                    v1 = v1 * 53 + zzkm.zzu(zznd.zzk(object0, v4));
                    break;
                }
                case 3: {
                    v1 = v1 * 53 + zzkm.zzu(zznd.zzk(object0, v4));
                    break;
                }
                case 4: {
                    v1 = v1 * 53 + zznd.zzj(object0, v4);
                    break;
                }
                case 5: {
                    v1 = v1 * 53 + zzkm.zzu(zznd.zzk(object0, v4));
                    break;
                }
                case 6: {
                    v1 = v1 * 53 + zznd.zzj(object0, v4);
                    break;
                }
                case 7: {
                    v1 = v1 * 53 + zzkm.zze(zznd.zzl(object0, v4));
                    break;
                }
                case 8: {
                    v1 = v1 * 53 + ((String)zznd.zzo(object0, v4)).hashCode();
                    break;
                }
                case 9: {
                    Object object1 = zznd.zzo(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v1 = v1 * 53 + zznd.zzo(object0, v4).hashCode();
                    break;
                }
                case 11: {
                    v1 = v1 * 53 + zznd.zzj(object0, v4);
                    break;
                }
                case 12: {
                    v1 = v1 * 53 + zznd.zzj(object0, v4);
                    break;
                }
                case 13: {
                    v1 = v1 * 53 + zznd.zzj(object0, v4);
                    break;
                }
                case 14: {
                    v1 = v1 * 53 + zzkm.zzu(zznd.zzk(object0, v4));
                    break;
                }
                case 15: {
                    v1 = v1 * 53 + zznd.zzj(object0, v4);
                    break;
                }
                case 16: {
                    v1 = v1 * 53 + zzkm.zzu(zznd.zzk(object0, v4));
                    break;
                }
                case 17: {
                    Object object2 = zznd.zzo(object0, v4);
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
                    v1 = v1 * 53 + zznd.zzo(object0, v4).hashCode();
                    break;
                }
                case 50: {
                    v1 = v1 * 53 + zznd.zzo(object0, v4).hashCode();
                    break;
                }
                case 51: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zzu(Double.doubleToLongBits(zzlu.zze(object0, v4)));
                    }
                    break;
                }
                case 52: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + Float.floatToIntBits(zzlu.zzf(object0, v4));
                    }
                    break;
                }
                case 53: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zzu(zzlu.zzh(object0, v4));
                    }
                    break;
                }
                case 54: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zzu(zzlu.zzh(object0, v4));
                    }
                    break;
                }
                case 55: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzlu.zzg(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zzu(zzlu.zzh(object0, v4));
                    }
                    break;
                }
                case 57: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzlu.zzg(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zze(zzlu.zzi(object0, v4));
                    }
                    break;
                }
                case 59: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + ((String)zznd.zzo(object0, v4)).hashCode();
                    }
                    break;
                }
                case 60: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zznd.zzo(object0, v4).hashCode();
                    }
                    break;
                }
                case 61: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zznd.zzo(object0, v4).hashCode();
                    }
                    break;
                }
                case 62: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzlu.zzg(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzlu.zzg(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzlu.zzg(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zzu(zzlu.zzh(object0, v4));
                    }
                    break;
                }
                case 66: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzlu.zzg(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zzkm.zzu(zzlu.zzh(object0, v4));
                    }
                    break;
                }
                case 68: {
                    if(this.zza(object0, v3, v)) {
                        v1 = v1 * 53 + zznd.zzo(object0, v4).hashCode();
                    }
                }
            }
        }
        int v8 = v1 * 53 + this.zzur.zzr(object0).hashCode();
        return this.zzui ? v8 * 53 + this.zzus.zzb(object0).hashCode() : v8;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final Object newInstance() {
        return this.zzup.newInstance(this.zzuh);
    }

    private static int zza(zzmx zzmx0, Object object0) {
        return zzmx0.zzn(zzmx0.zzr(object0));
    }

    private final int zza(Object object0, byte[] arr_b, int v, int v1, int v2, int v3, int v4, int v5, int v6, long v7, int v8, zziz zziz0) throws IOException {
        int v10;
        Unsafe unsafe0 = zzlu.zzuc;
        long v9 = (long)(this.zzud[v8 + 2] & 0xFFFFF);
        switch(v6) {
            case 51: {
                if(v4 == 1) {
                    unsafe0.putObject(object0, v7, zziy.zzc(arr_b, v));
                    v10 = v + 8;
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 52: {
                if(v4 == 5) {
                    unsafe0.putObject(object0, v7, zziy.zzd(arr_b, v));
                    v10 = v + 4;
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 53: 
            case 54: {
                if(v4 == 0) {
                    v10 = zziy.zzb(arr_b, v, zziz0);
                    unsafe0.putObject(object0, v7, zziz0.zznl);
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 58: {
                if(v4 == 0) {
                    v10 = zziy.zzb(arr_b, v, zziz0);
                    unsafe0.putObject(object0, v7, Boolean.valueOf(zziz0.zznl != 0L));
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 59: {
                if(v4 == 2) {
                    v10 = zziy.zza(arr_b, v, zziz0);
                    int v11 = zziz0.zznk;
                    if(v11 == 0) {
                        unsafe0.putObject(object0, v7, "");
                    }
                    else {
                        if((v5 & 0x20000000) != 0 && !zznf.zze(arr_b, v10, v10 + v11)) {
                            throw zzkq.zzdn();
                        }
                        unsafe0.putObject(object0, v7, new String(arr_b, v10, v11, zzkm.UTF_8));
                        v10 += v11;
                    }
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 60: {
                if(v4 == 2) {
                    v10 = zziy.zza(this.zzap(v8), arr_b, v, v1, zziz0);
                    Object object1 = unsafe0.getInt(object0, v9) == v3 ? unsafe0.getObject(object0, v7) : null;
                    if(object1 == null) {
                        unsafe0.putObject(object0, v7, zziz0.zznm);
                    }
                    else {
                        unsafe0.putObject(object0, v7, zzkm.zza(object1, zziz0.zznm));
                    }
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 61: {
                if(v4 == 2) {
                    v10 = zziy.zze(arr_b, v, zziz0);
                    unsafe0.putObject(object0, v7, zziz0.zznm);
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 55: 
            case 62: {
                if(v4 == 0) {
                    v10 = zziy.zza(arr_b, v, zziz0);
                    unsafe0.putObject(object0, v7, zziz0.zznk);
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 0x3F: {
                if(v4 == 0) {
                    int v12 = zziy.zza(arr_b, v, zziz0);
                    int v13 = zziz0.zznk;
                    zzko zzko0 = this.zzar(v8);
                    if(zzko0 != null && !zzko0.zzan(v13)) {
                        zzlu.zzo(object0).zzb(v2, ((long)v13));
                        return v12;
                    }
                    unsafe0.putObject(object0, v7, v13);
                    unsafe0.putInt(object0, v9, v3);
                    return v12;
                }
                break;
            }
            case 57: 
            case 0x40: {
                if(v4 == 5) {
                    unsafe0.putObject(object0, v7, zziy.zza(arr_b, v));
                    v10 = v + 4;
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 56: 
            case 65: {
                if(v4 == 1) {
                    unsafe0.putObject(object0, v7, zziy.zzb(arr_b, v));
                    v10 = v + 8;
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 66: {
                if(v4 == 0) {
                    v10 = zziy.zza(arr_b, v, zziz0);
                    unsafe0.putObject(object0, v7, ((int)(-(zziz0.zznk & 1) ^ zziz0.zznk >>> 1)));
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 67: {
                if(v4 == 0) {
                    v10 = zziy.zzb(arr_b, v, zziz0);
                    unsafe0.putObject(object0, v7, ((long)(-(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1)));
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            case 68: {
                if(v4 == 3) {
                    v10 = zziy.zza(this.zzap(v8), arr_b, v, v1, v2 & -8 | 4, zziz0);
                    Object object2 = unsafe0.getInt(object0, v9) == v3 ? unsafe0.getObject(object0, v7) : null;
                    if(object2 == null) {
                        unsafe0.putObject(object0, v7, zziz0.zznm);
                    }
                    else {
                        unsafe0.putObject(object0, v7, zzkm.zza(object2, zziz0.zznm));
                    }
                    unsafe0.putInt(object0, v9, v3);
                    return v10;
                }
                break;
            }
            default: {
                return v;
            }
        }
        return v;
    }

    private final int zza(Object object0, byte[] arr_b, int v, int v1, int v2, int v3, int v4, int v5, long v6, int v7, long v8, zziz zziz0) throws IOException {
        int v19;
        int v11;
        int v9 = v;
        Unsafe unsafe0 = zzlu.zzuc;
        zzkp zzkp0 = (zzkp)unsafe0.getObject(object0, v8);
        if(!zzkp0.zzbo()) {
            int v10 = zzkp0.size();
            zzkp0 = zzkp0.zzr((v10 == 0 ? 10 : v10 << 1));
            unsafe0.putObject(object0, v8, zzkp0);
        }
    alab4:
        switch(v7) {
            case 26: {
                if(v4 == 2) {
                    if(Long.compare(v6 & 0x20000000L, 0L) == 0) {
                        v11 = zziy.zza(arr_b, v9, zziz0);
                        int v21 = zziz0.zznk;
                        if(v21 < 0) {
                            throw zzkq.zzdj();
                        }
                        if(v21 == 0) {
                            zzkp0.add("");
                            goto label_129;
                        }
                        else {
                            zzkp0.add(new String(arr_b, v11, v21, zzkm.UTF_8));
                        }
                    alab1:
                        while(true) {
                            v11 += v21;
                            while(true) {
                            label_129:
                                if(v11 >= v1) {
                                    return v11;
                                }
                                int v22 = zziy.zza(arr_b, v11, zziz0);
                                if(v2 != zziz0.zznk) {
                                    return v11;
                                }
                                v11 = zziy.zza(arr_b, v22, zziz0);
                                v21 = zziz0.zznk;
                                if(v21 < 0) {
                                    break alab1;
                                }
                                if(v21 != 0) {
                                    zzkp0.add(new String(arr_b, v11, v21, zzkm.UTF_8));
                                    break;
                                }
                                zzkp0.add("");
                            }
                        }
                        throw zzkq.zzdj();
                    }
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v23 = zziz0.zznk;
                    if(v23 < 0) {
                        throw zzkq.zzdj();
                    }
                    if(v23 == 0) {
                        zzkp0.add("");
                        goto label_152;
                    }
                    int v24 = v11 + v23;
                    if(!zznf.zze(arr_b, v11, v24)) {
                        throw zzkq.zzdn();
                    }
                    zzkp0.add(new String(arr_b, v11, v23, zzkm.UTF_8));
                alab2:
                    while(true) {
                        v11 = v24;
                        while(true) {
                        label_152:
                            if(v11 >= v1) {
                                return v11;
                            }
                            int v25 = zziy.zza(arr_b, v11, zziz0);
                            if(v2 != zziz0.zznk) {
                                return v11;
                            }
                            v11 = zziy.zza(arr_b, v25, zziz0);
                            int v26 = zziz0.zznk;
                            if(v26 < 0) {
                                throw zzkq.zzdj();
                            }
                            if(v26 != 0) {
                                v24 = v11 + v26;
                                if(!zznf.zze(arr_b, v11, v24)) {
                                    break alab2;
                                }
                                zzkp0.add(new String(arr_b, v11, v26, zzkm.UTF_8));
                                break;
                            }
                            zzkp0.add("");
                        }
                    }
                    throw zzkq.zzdn();
                }
                break;
            }
            case 27: {
                return v4 == 2 ? zziy.zza(this.zzap(v5), v2, arr_b, v, v1, zzkp0, zziz0) : v9;
            }
            case 28: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v27 = zziz0.zznk;
                    if(v27 < 0) {
                        throw zzkq.zzdj();
                    }
                    if(v27 > arr_b.length - v11) {
                        throw zzkq.zzdi();
                    }
                    if(v27 == 0) {
                        zzkp0.add(zzjc.zznq);
                        goto label_179;
                    }
                    else {
                        zzkp0.add(zzjc.zzb(arr_b, v11, v27));
                    }
                alab3:
                    while(true) {
                        v11 += v27;
                        while(true) {
                        label_179:
                            if(v11 >= v1) {
                                return v11;
                            }
                            int v28 = zziy.zza(arr_b, v11, zziz0);
                            if(v2 != zziz0.zznk) {
                                return v11;
                            }
                            v11 = zziy.zza(arr_b, v28, zziz0);
                            v27 = zziz0.zznk;
                            if(v27 < 0) {
                                throw zzkq.zzdj();
                            }
                            if(v27 > arr_b.length - v11) {
                                break alab3;
                            }
                            if(v27 != 0) {
                                zzkp0.add(zzjc.zzb(arr_b, v11, v27));
                                break;
                            }
                            zzkp0.add(zzjc.zznq);
                        }
                    }
                    throw zzkq.zzdi();
                }
                break;
            }
            case 18: 
            case 35: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v12 = zziz0.zznk + v11;
                    while(v11 < v12) {
                        ((zzju)zzkp0).zzc(zziy.zzc(arr_b, v11));
                        v11 += 8;
                    }
                    if(v11 != v12) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 1) {
                    ((zzju)zzkp0).zzc(zziy.zzc(arr_b, v));
                    while(true) {
                        v11 = v9 + 8;
                        if(v11 >= v1) {
                            return v11;
                        }
                        v9 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            return v11;
                        }
                        ((zzju)zzkp0).zzc(zziy.zzc(arr_b, v9));
                    }
                }
                break;
            }
            case 19: 
            case 36: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v13 = zziz0.zznk + v11;
                    while(v11 < v13) {
                        ((zzkh)zzkp0).zzc(zziy.zzd(arr_b, v11));
                        v11 += 4;
                    }
                    if(v11 != v13) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 5) {
                    ((zzkh)zzkp0).zzc(zziy.zzd(arr_b, v));
                    while(true) {
                        v11 = v9 + 4;
                        if(v11 >= v1) {
                            return v11;
                        }
                        v9 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            return v11;
                        }
                        ((zzkh)zzkp0).zzc(zziy.zzd(arr_b, v9));
                    }
                }
                break;
            }
            case 20: 
            case 21: 
            case 37: 
            case 38: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v14 = zziz0.zznk + v11;
                    while(v11 < v14) {
                        v11 = zziy.zzb(arr_b, v11, zziz0);
                        ((zzle)zzkp0).zzv(zziz0.zznl);
                    }
                    if(v11 != v14) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 0) {
                    v11 = zziy.zzb(arr_b, v9, zziz0);
                    ((zzle)zzkp0).zzv(zziz0.zznl);
                    while(v11 < v1) {
                        int v15 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            return v11;
                        }
                        v11 = zziy.zzb(arr_b, v15, zziz0);
                        ((zzle)zzkp0).zzv(zziz0.zznl);
                    }
                    return v11;
                }
                break;
            }
            case 25: 
            case 42: {
                switch(v4) {
                    case 0: {
                        v9 = zziy.zzb(arr_b, v9, zziz0);
                        ((zzja)zzkp0).addBoolean(zziz0.zznl != 0L);
                        while(v9 < v1) {
                            int v18 = zziy.zza(arr_b, v9, zziz0);
                            if(v2 != zziz0.zznk) {
                                break alab4;
                            }
                            v9 = zziy.zzb(arr_b, v18, zziz0);
                            ((zzja)zzkp0).addBoolean(zziz0.zznl != 0L);
                        }
                        return v9;
                    }
                    case 2: {
                        v19 = zziy.zza(arr_b, v9, zziz0);
                        int v20 = zziz0.zznk + v19;
                        while(v19 < v20) {
                            v19 = zziy.zzb(arr_b, v19, zziz0);
                            ((zzja)zzkp0).addBoolean(zziz0.zznl != 0L);
                        }
                        if(v19 != v20) {
                            throw zzkq.zzdi();
                        }
                        return v19;
                    }
                    default: {
                        return v9;
                    }
                }
            }
            case 22: 
            case 29: 
            case 39: 
            case 43: {
                if(v4 == 2) {
                    return zziy.zza(arr_b, v9, zzkp0, zziz0);
                }
                return v4 == 0 ? zziy.zza(v2, arr_b, v, v1, zzkp0, zziz0) : v9;
            }
            case 30: 
            case 44: {
                if(v4 == 2) {
                    v19 = zziy.zza(arr_b, v9, zzkp0, zziz0);
                }
                else if(v4 == 0) {
                    v19 = zziy.zza(v2, arr_b, v, v1, zzkp0, zziz0);
                }
                else {
                    break;
                }
                zzmy zzmy0 = ((zzkk)object0).zzrq;
                if(zzmy0 == zzmy.zzfa()) {
                    zzmy0 = null;
                }
                zzmy zzmy1 = (zzmy)zzmh.zza(v3, zzkp0, this.zzar(v5), zzmy0, this.zzur);
                if(zzmy1 != null) {
                    ((zzkk)object0).zzrq = zzmy1;
                }
                return v19;
            }
            case 24: 
            case 0x1F: 
            case 41: 
            case 45: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v17 = zziz0.zznk + v11;
                    while(v11 < v17) {
                        ((zzkl)zzkp0).zzam(zziy.zza(arr_b, v11));
                        v11 += 4;
                    }
                    if(v11 != v17) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 5) {
                    ((zzkl)zzkp0).zzam(zziy.zza(arr_b, v));
                    while(true) {
                        v11 = v9 + 4;
                        if(v11 >= v1) {
                            return v11;
                        }
                        v9 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            return v11;
                        }
                        ((zzkl)zzkp0).zzam(zziy.zza(arr_b, v9));
                    }
                }
                break;
            }
            case 23: 
            case 0x20: 
            case 40: 
            case 46: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v16 = zziz0.zznk + v11;
                    while(v11 < v16) {
                        ((zzle)zzkp0).zzv(zziy.zzb(arr_b, v11));
                        v11 += 8;
                    }
                    if(v11 != v16) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 1) {
                    ((zzle)zzkp0).zzv(zziy.zzb(arr_b, v));
                    while(true) {
                        v11 = v9 + 8;
                        if(v11 >= v1) {
                            return v11;
                        }
                        v9 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            return v11;
                        }
                        ((zzle)zzkp0).zzv(zziy.zzb(arr_b, v9));
                    }
                }
                break;
            }
            case 33: 
            case 0x2F: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v29 = zziz0.zznk + v11;
                    while(v11 < v29) {
                        v11 = zziy.zza(arr_b, v11, zziz0);
                        ((zzkl)zzkp0).zzam(-(zziz0.zznk & 1) ^ zziz0.zznk >>> 1);
                    }
                    if(v11 != v29) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 0) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    ((zzkl)zzkp0).zzam(-(zziz0.zznk & 1) ^ zziz0.zznk >>> 1);
                    while(v11 < v1) {
                        int v30 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            return v11;
                        }
                        v11 = zziy.zza(arr_b, v30, zziz0);
                        ((zzkl)zzkp0).zzam(-(zziz0.zznk & 1) ^ zziz0.zznk >>> 1);
                    }
                    return v11;
                }
                break;
            }
            case 34: 
            case 0x30: {
                if(v4 == 2) {
                    v11 = zziy.zza(arr_b, v9, zziz0);
                    int v31 = zziz0.zznk + v11;
                    while(v11 < v31) {
                        v11 = zziy.zzb(arr_b, v11, zziz0);
                        ((zzle)zzkp0).zzv(-(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1);
                    }
                    if(v11 != v31) {
                        throw zzkq.zzdi();
                    }
                    return v11;
                }
                if(v4 == 0) {
                    v11 = zziy.zzb(arr_b, v9, zziz0);
                    ((zzle)zzkp0).zzv(-(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1);
                    while(v11 < v1) {
                        int v32 = zziy.zza(arr_b, v11, zziz0);
                        if(v2 != zziz0.zznk) {
                            break;
                        }
                        v11 = zziy.zzb(arr_b, v32, zziz0);
                        ((zzle)zzkp0).zzv(-(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1);
                    }
                    return v11;
                }
                break;
            }
            case 49: {
                if(v4 == 3) {
                    zzmf zzmf0 = this.zzap(v5);
                    int v33 = v2 & -8 | 4;
                    v9 = zziy.zza(zzmf0, arr_b, v, v1, v33, zziz0);
                    zzkp0.add(zziz0.zznm);
                    while(true) {
                        if(v9 >= v1) {
                            break;
                        }
                        int v34 = zziy.zza(arr_b, v9, zziz0);
                        if(v2 != zziz0.zznk) {
                            break;
                        }
                        v9 = zziy.zza(zzmf0, arr_b, v34, v1, v33, zziz0);
                        zzkp0.add(zziz0.zznm);
                    }
                }
                break;
            }
            default: {
                return v9;
            }
        }
        return v9;
    }

    private final int zza(Object object0, byte[] arr_b, int v, int v1, int v2, long v3, zziz zziz0) throws IOException {
        Unsafe unsafe0 = zzlu.zzuc;
        Object object1 = this.zzaq(v2);
        Object object2 = unsafe0.getObject(object0, v3);
        if(this.zzut.zzj(object2)) {
            Object object3 = this.zzut.zzl(object1);
            this.zzut.zzb(object3, object2);
            unsafe0.putObject(object0, v3, object3);
            object2 = object3;
        }
        zzlj zzlj0 = this.zzut.zzm(object1);
        Map map0 = this.zzut.zzh(object2);
        int v4 = zziy.zza(arr_b, v, zziz0);
        int v5 = zziz0.zznk;
        if(v5 < 0 || v5 > v1 - v4) {
            throw zzkq.zzdi();
        }
        int v6 = v5 + v4;
        Object object4 = zzlj0.zztv;
        Object object5 = zzlj0.zztx;
        while(v4 < v6) {
            int v7 = v4 + 1;
            int v8 = arr_b[v4];
            if(v8 < 0) {
                v7 = zziy.zza(v8, arr_b, v7, zziz0);
                v8 = zziz0.zznk;
            }
            switch(v8 >>> 3) {
                case 1: {
                    if((v8 & 7) == zzlj0.zztu.zzfk()) {
                        v4 = zzlu.zza(arr_b, v7, v1, zzlj0.zztu, null, zziz0);
                        object4 = zziz0.zznm;
                        continue;
                    }
                    break;
                }
                case 2: {
                    if((v8 & 7) == zzlj0.zztw.zzfk()) {
                        Class class0 = zzlj0.zztx.getClass();
                        v4 = zzlu.zza(arr_b, v7, v1, zzlj0.zztw, class0, zziz0);
                        object5 = zziz0.zznm;
                        continue;
                    }
                }
            }
            v4 = zziy.zza(v8, arr_b, v7, v1, zziz0);
        }
        if(v4 != v6) {
            throw zzkq.zzdm();
        }
        map0.put(object4, object5);
        return v6;
    }

    private static int zza(byte[] arr_b, int v, int v1, zznm zznm0, Class class0, zziz zziz0) throws IOException {
        int v2;
        switch(zznm0) {
            case 1: {
                v2 = zziy.zzb(arr_b, v, zziz0);
                zziz0.zznm = Boolean.valueOf(zziz0.zznl != 0L);
                return v2;
            }
            case 2: {
                return zziy.zze(arr_b, v, zziz0);
            }
            case 3: {
                zziz0.zznm = zziy.zzc(arr_b, v);
                return v + 8;
            }
            case 4: 
            case 5: {
                zziz0.zznm = zziy.zza(arr_b, v);
                return v + 4;
            }
            case 6: 
            case 7: {
                zziz0.zznm = zziy.zzb(arr_b, v);
                return v + 8;
            }
            case 8: {
                zziz0.zznm = zziy.zzd(arr_b, v);
                return v + 4;
            }
            case 9: 
            case 10: 
            case 11: {
                v2 = zziy.zza(arr_b, v, zziz0);
                zziz0.zznm = zziz0.zznk;
                return v2;
            }
            case 12: 
            case 13: {
                v2 = zziy.zzb(arr_b, v, zziz0);
                zziz0.zznm = zziz0.zznl;
                return v2;
            }
            case 14: {
                return zziy.zza(zzmd.zzej().zzf(class0), arr_b, v, v1, zziz0);
            }
            case 15: {
                v2 = zziy.zza(arr_b, v, zziz0);
                zziz0.zznm = (int)(-(zziz0.zznk & 1) ^ zziz0.zznk >>> 1);
                return v2;
            }
            case 16: {
                v2 = zziy.zzb(arr_b, v, zziz0);
                zziz0.zznm = (long)(-(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1);
                return v2;
            }
            case 17: {
                return zziy.zzd(arr_b, v, zziz0);
            }
            default: {
                throw new RuntimeException("unsupported field type.");
            }
        }
    }

    static zzlu zza(Class class0, zzlo zzlo0, zzly zzly0, zzla zzla0, zzmx zzmx0, zzjy zzjy0, zzll zzll0) {
        Field field3;
        int v89;
        int v88;
        int v87;
        int v86;
        String s1;
        int v85;
        Class class2;
        Field field1;
        zzme zzme1;
        Field field0;
        int v77;
        boolean z1;
        int v76;
        int v71;
        int v70;
        int v69;
        int v52;
        int v18;
        int[] arr_v;
        int v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v7;
        int v6;
        if(zzlo0 instanceof zzme) {
            zzme zzme0 = (zzme)zzlo0;
            int v = 0;
            boolean z = zzme0.zzec() == zze.zzsg;
            String s = zzme0.zzek();
            int v1 = s.length();
            int v2 = s.charAt(0);
            if(v2 >= 0xD800) {
                int v3 = v2 & 0x1FFF;
                int v5 = 13;
                for(int v4 = 1; true; v4 = v6) {
                    v6 = v4 + 1;
                    v7 = s.charAt(v4);
                    if(v7 < 0xD800) {
                        break;
                    }
                    v3 |= (v7 & 0x1FFF) << v5;
                    v5 += 13;
                }
                v2 = v3 | v7 << v5;
            }
            else {
                v6 = 1;
            }
            int v8 = v6 + 1;
            int v9 = s.charAt(v6);
            if(v9 >= 0xD800) {
                int v10 = v9 & 0x1FFF;
                int v11 = 13;
                int v12;
                while((v12 = s.charAt(v8)) >= 0xD800) {
                    v10 |= (v12 & 0x1FFF) << v11;
                    v11 += 13;
                    ++v8;
                }
                v9 = v10 | v12 << v11;
                ++v8;
            }
            if(v9 == 0) {
                v13 = 0;
                v14 = 0;
                v15 = 0;
                v16 = 0;
                v17 = 0;
                arr_v = zzlu.zzub;
                v18 = 0;
            }
            else {
                int v19 = v8 + 1;
                int v20 = s.charAt(v8);
                if(v20 >= 0xD800) {
                    int v21 = v20 & 0x1FFF;
                    int v22 = 13;
                    int v23;
                    while((v23 = s.charAt(v19)) >= 0xD800) {
                        v21 |= (v23 & 0x1FFF) << v22;
                        v22 += 13;
                        ++v19;
                    }
                    v20 = v21 | v23 << v22;
                    ++v19;
                }
                int v24 = v19 + 1;
                int v25 = s.charAt(v19);
                if(v25 >= 0xD800) {
                    int v26 = v25 & 0x1FFF;
                    int v27 = 13;
                    int v28;
                    while((v28 = s.charAt(v24)) >= 0xD800) {
                        v26 |= (v28 & 0x1FFF) << v27;
                        v27 += 13;
                        ++v24;
                    }
                    v25 = v26 | v28 << v27;
                    ++v24;
                }
                int v29 = v24 + 1;
                v14 = s.charAt(v24);
                if(v14 >= 0xD800) {
                    int v30 = v14 & 0x1FFF;
                    int v31 = 13;
                    int v32;
                    while((v32 = s.charAt(v29)) >= 0xD800) {
                        v30 |= (v32 & 0x1FFF) << v31;
                        v31 += 13;
                        ++v29;
                    }
                    v14 = v30 | v32 << v31;
                    ++v29;
                }
                int v33 = v29 + 1;
                int v34 = s.charAt(v29);
                if(v34 >= 0xD800) {
                    int v35 = v34 & 0x1FFF;
                    int v36 = 13;
                    int v37;
                    while((v37 = s.charAt(v33)) >= 0xD800) {
                        v35 |= (v37 & 0x1FFF) << v36;
                        v36 += 13;
                        ++v33;
                    }
                    v34 = v35 | v37 << v36;
                    ++v33;
                }
                int v38 = v33 + 1;
                v16 = s.charAt(v33);
                if(v16 >= 0xD800) {
                    int v39 = v16 & 0x1FFF;
                    int v40 = 13;
                    int v41;
                    while((v41 = s.charAt(v38)) >= 0xD800) {
                        v39 |= (v41 & 0x1FFF) << v40;
                        v40 += 13;
                        ++v38;
                    }
                    v16 = v39 | v41 << v40;
                    ++v38;
                }
                int v42 = v38 + 1;
                int v43 = s.charAt(v38);
                if(v43 >= 0xD800) {
                    int v44 = v43 & 0x1FFF;
                    int v45 = 13;
                    int v46;
                    while((v46 = s.charAt(v42)) >= 0xD800) {
                        v44 |= (v46 & 0x1FFF) << v45;
                        v45 += 13;
                        ++v42;
                    }
                    v43 = v44 | v46 << v45;
                    ++v42;
                }
                int v47 = s.charAt(v42);
                if(v47 >= 0xD800) {
                    int v48 = v47 & 0x1FFF;
                    int v49 = v42 + 1;
                    int v50 = 13;
                    int v51;
                    while((v51 = s.charAt(v49)) >= 0xD800) {
                        v48 |= (v51 & 0x1FFF) << v50;
                        v50 += 13;
                        ++v49;
                    }
                    v47 = v48 | v51 << v50;
                    v52 = v49 + 1;
                }
                else {
                    v52 = v42 + 1;
                }
                int v53 = v52 + 1;
                int v54 = s.charAt(v52);
                if(v54 >= 0xD800) {
                    int v55 = v54 & 0x1FFF;
                    int v56 = v53;
                    int v57 = 13;
                    int v58;
                    while((v58 = s.charAt(v56)) >= 0xD800) {
                        v55 |= (v58 & 0x1FFF) << v57;
                        v57 += 13;
                        ++v56;
                    }
                    v54 = v55 | v58 << v57;
                    v53 = v56 + 1;
                }
                v18 = v34;
                v15 = (v20 << 1) + v25;
                v17 = v54;
                v = v20;
                v8 = v53;
                arr_v = new int[v54 + v43 + v47];
                v13 = v43;
            }
            Unsafe unsafe0 = zzlu.zzuc;
            Object[] arr_object = zzme0.zzel();
            Class class1 = zzme0.zzee().getClass();
            int[] arr_v1 = new int[v16 * 3];
            Object[] arr_object1 = new Object[v16 << 1];
            int v59 = v17 + v13;
            int v60 = v17;
            int v61 = v8;
            int v62 = v59;
            int v63 = 0;
            int v64 = 0;
            while(v61 < v1) {
                int v65 = s.charAt(v61);
                if(v65 >= 0xD800) {
                    int v66 = v65 & 0x1FFF;
                    int v67 = v61 + 1;
                    int v68 = 13;
                    while(true) {
                        v69 = s.charAt(v67);
                        v70 = v17;
                        if(v69 < 0xD800) {
                            break;
                        }
                        v66 |= (v69 & 0x1FFF) << v68;
                        v68 += 13;
                        ++v67;
                        v17 = v70;
                    }
                    v65 = v66 | v69 << v68;
                    v71 = v67 + 1;
                }
                else {
                    v70 = v17;
                    v71 = v61 + 1;
                }
                int v72 = s.charAt(v71);
                if(v72 >= 0xD800) {
                    int v73 = v72 & 0x1FFF;
                    int v74 = v71 + 1;
                    int v75 = 13;
                    while(true) {
                        v76 = s.charAt(v74);
                        z1 = z;
                        if(v76 < 0xD800) {
                            break;
                        }
                        v73 |= (v76 & 0x1FFF) << v75;
                        v75 += 13;
                        ++v74;
                        z = z1;
                    }
                    v72 = v73 | v76 << v75;
                    v77 = v74 + 1;
                }
                else {
                    z1 = z;
                    v77 = v71 + 1;
                }
                if((v72 & 0x400) != 0) {
                    arr_v[v63] = v64;
                    ++v63;
                }
                if((v72 & 0xFF) >= 51) {
                    int v78 = v77 + 1;
                    int v79 = s.charAt(v77);
                    if(v79 >= 0xD800) {
                        int v80 = v79 & 0x1FFF;
                        int v81 = 13;
                        int v82;
                        while((v82 = s.charAt(v78)) >= 0xD800) {
                            v80 |= (v82 & 0x1FFF) << v81;
                            v81 += 13;
                            ++v78;
                        }
                        v79 = v80 | v82 << v81;
                        ++v78;
                    }
                    switch((v72 & 0xFF) - 51) {
                        case 12: {
                            if((v2 & 1) == 1) {
                                arr_object1[(v64 / 3 << 1) + 1] = arr_object[v15];
                                ++v15;
                            }
                            break;
                        }
                        case 9: 
                        case 17: {
                            arr_object1[(v64 / 3 << 1) + 1] = arr_object[v15];
                            ++v15;
                        }
                    }
                    Object object0 = arr_object[v79 << 1];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = zzlu.zza(class1, ((String)object0));
                        arr_object[v79 << 1] = field0;
                    }
                    zzme1 = zzme0;
                    int v83 = (int)unsafe0.objectFieldOffset(field0);
                    int v84 = (v79 << 1) + 1;
                    Object object1 = arr_object[v84];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzlu.zza(class1, ((String)object1));
                        arr_object[v84] = field1;
                    }
                    class2 = class1;
                    v85 = v15;
                    v77 = v78;
                    s1 = s;
                    v86 = 0;
                    v87 = (int)unsafe0.objectFieldOffset(field1);
                    v88 = v83;
                    v89 = v;
                }
                else {
                    zzme1 = zzme0;
                    int v90 = v15 + 1;
                    Field field2 = zzlu.zza(class1, ((String)arr_object[v15]));
                    if((v72 & 0xFF) == 9 || (v72 & 0xFF) == 17) {
                        arr_object1[(v64 / 3 << 1) + 1] = field2.getType();
                    }
                    else if((v72 & 0xFF) != 27 && (v72 & 0xFF) != 49) {
                        switch(v72 & 0xFF) {
                            case 12: 
                            case 30: 
                            case 44: {
                                if((v2 & 1) == 1) {
                                    arr_object1[(v64 / 3 << 1) + 1] = arr_object[v90];
                                    ++v90;
                                }
                                break;
                            }
                            case 50: {
                                arr_v[v60] = v64;
                                int v91 = v64 / 3 << 1;
                                int v92 = v90 + 1;
                                arr_object1[v91] = arr_object[v90];
                                if((v72 & 0x800) == 0) {
                                    v90 = v92;
                                }
                                else {
                                    v90 = v92 + 1;
                                    arr_object1[v91 + 1] = arr_object[v92];
                                }
                                ++v60;
                            }
                        }
                    }
                    else {
                        arr_object1[(v64 / 3 << 1) + 1] = arr_object[v90];
                        ++v90;
                    }
                    v88 = (int)unsafe0.objectFieldOffset(field2);
                    if((v2 & 1) == 1) {
                        if((v72 & 0xFF) <= 17) {
                            int v93 = v77 + 1;
                            s1 = s;
                            int v94 = s1.charAt(v77);
                            if(v94 >= 0xD800) {
                                int v95 = v94 & 0x1FFF;
                                int v96 = 13;
                                int v97;
                                while((v97 = s1.charAt(v93)) >= 0xD800) {
                                    v95 |= (v97 & 0x1FFF) << v96;
                                    v96 += 13;
                                    ++v93;
                                }
                                v94 = v95 | v97 << v96;
                                ++v93;
                            }
                            int v98 = (v << 1) + v94 / 0x20;
                            Object object2 = arr_object[v98];
                            v85 = v90;
                            if(object2 instanceof Field) {
                                field3 = (Field)object2;
                            }
                            else {
                                field3 = zzlu.zza(class1, ((String)object2));
                                arr_object[v98] = field3;
                            }
                            v89 = v;
                            class2 = class1;
                            v86 = v94 % 0x20;
                            v87 = (int)unsafe0.objectFieldOffset(field3);
                            v77 = v93;
                            goto label_323;
                        }
                        else {
                            v85 = v90;
                            v89 = v;
                            class2 = class1;
                            s1 = s;
                            goto label_321;
                        }
                        goto label_317;
                    }
                    else {
                    label_317:
                        v85 = v90;
                        v89 = v;
                        class2 = class1;
                        s1 = s;
                    }
                label_321:
                    v87 = 0;
                    v86 = 0;
                label_323:
                    if((v72 & 0xFF) >= 18 && (v72 & 0xFF) <= 49) {
                        arr_v[v62] = v88;
                        ++v62;
                    }
                }
                arr_v1[v64] = v65;
                int v99 = v64 + 2;
                arr_v1[v64 + 1] = v88 | (((v72 & 0x100) == 0 ? 0 : 0x10000000) | ((v72 & 0x200) == 0 ? 0 : 0x20000000) | (v72 & 0xFF) << 20);
                v64 = v99 + 1;
                arr_v1[v99] = v86 << 20 | v87;
                v = v89;
                s = s1;
                v61 = v77;
                class1 = class2;
                v17 = v70;
                z = z1;
                v15 = v85;
                zzme0 = zzme1;
            }
            return new zzlu(arr_v1, arr_object1, v14, v18, zzme0.zzee(), z, false, arr_v, v17, v59, zzly0, zzla0, zzmx0, zzjy0, zzll0);
        }
        ((zzms)zzlo0).zzec();
        throw new NoSuchMethodError();
    }

    private final Object zza(int v, int v1, Map map0, zzko zzko0, Object object0, zzmx zzmx0) {
        Object object1 = this.zzaq(v);
        zzlj zzlj0 = this.zzut.zzm(object1);
        Iterator iterator0 = map0.entrySet().iterator();
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            Map.Entry map$Entry0 = (Map.Entry)object2;
            if(!zzko0.zzan(((int)(((Integer)map$Entry0.getValue()))))) {
                if(object0 == null) {
                    object0 = zzmx0.zzez();
                }
                zzjk zzjk0 = zzjc.zzu(zzli.zza(zzlj0, map$Entry0.getKey(), map$Entry0.getValue()));
                zzjr zzjr0 = zzjk0.zzby();
                try {
                    zzli.zza(zzjr0, zzlj0, map$Entry0.getKey(), map$Entry0.getValue());
                }
                catch(IOException iOException0) {
                    throw new RuntimeException(iOException0);
                }
                zzmx0.zza(object0, v1, zzjk0.zzbx());
                iterator0.remove();
            }
        }
        return object0;
    }

    private static Field zza(Class class0, String s) {
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

    private static void zza(int v, Object object0, zzns zzns0) throws IOException {
        if(object0 instanceof String) {
            zzns0.zza(v, ((String)object0));
            return;
        }
        zzns0.zza(v, ((zzjc)object0));
    }

    private static void zza(zzmx zzmx0, Object object0, zzns zzns0) throws IOException {
        zzmx0.zza(zzmx0.zzr(object0), zzns0);
    }

    private final void zza(zzns zzns0, int v, Object object0, int v1) throws IOException {
        if(object0 != null) {
            Object object1 = this.zzaq(v1);
            zzns0.zza(v, this.zzut.zzm(object1), this.zzut.zzi(object0));
        }
    }

    private final void zza(Object object0, Object object1, int v) {
        int v1 = this.zzas(v);
        if(!this.zza(object1, v)) {
            return;
        }
        Object object2 = zznd.zzo(object0, ((long)(v1 & 0xFFFFF)));
        Object object3 = zznd.zzo(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 != null && object3 != null) {
            zznd.zza(object0, ((long)(v1 & 0xFFFFF)), zzkm.zza(object2, object3));
            this.zzb(object0, v);
            return;
        }
        if(object3 != null) {
            zznd.zza(object0, ((long)(v1 & 0xFFFFF)), object3);
            this.zzb(object0, v);
        }
    }

    private final boolean zza(Object object0, int v) {
        if(this.zzuk) {
            int v1 = this.zzas(v);
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    return zznd.zzn(object0, ((long)(v1 & 0xFFFFF))) != 0.0;
                }
                case 1: {
                    return zznd.zzm(object0, ((long)(v1 & 0xFFFFF))) != 0.0f;
                }
                case 2: {
                    return zznd.zzk(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zznd.zzk(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zznd.zzk(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zznd.zzl(object0, ((long)(v1 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zznd.zzo(object0, ((long)(v1 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzjc)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzjc.zznq.equals(object1);
                }
                case 9: {
                    return zznd.zzo(object0, ((long)(v1 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zznd.zzo(object0, ((long)(v1 & 0xFFFFF)));
                    return !zzjc.zznq.equals(object2);
                }
                case 11: {
                    return zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zznd.zzk(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zznd.zzk(object0, ((long)(v1 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zznd.zzo(object0, ((long)(v1 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        int v2 = this.zzat(v);
        return (zznd.zzj(object0, ((long)(v2 & 0xFFFFF))) & 1 << (v2 >>> 20)) != 0;
    }

    private final boolean zza(Object object0, int v, int v1) {
        return zznd.zzj(object0, ((long)(this.zzat(v1) & 0xFFFFF))) == v;
    }

    // 去混淆评级： 低(20)
    private final boolean zza(Object object0, int v, int v1, int v2) {
        return this.zzuk ? this.zza(object0, v) : (v1 & v2) != 0;
    }

    private static boolean zza(Object object0, int v, zzmf zzmf0) {
        return zzmf0.zzp(zznd.zzo(object0, ((long)(v & 0xFFFFF))));
    }

    final int zza(Object object0, byte[] arr_b, int v, int v1, int v2, zziz zziz0) throws IOException {
        int v41;
        int v40;
        int v39;
        int v38;
        int v37;
        int v31;
        int v30;
        int v29;
        int v28;
        int v27;
        int v19;
        int v18;
        int v17;
        int v16;
        int v15;
        int v12;
        int v11;
        int v3 = v2;
        Unsafe unsafe0 = zzlu.zzuc;
        int v4 = v;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = -1;
        int v9 = -1;
        while(true) {
            if(v4 < v1) {
                int v10 = arr_b[v4];
                if(v10 < 0) {
                    v11 = zziy.zza(v10, arr_b, v4 + 1, zziz0);
                    v12 = zziz0.zznk;
                }
                else {
                    v12 = v10;
                    v11 = v4 + 1;
                }
                int v13 = v12 >>> 3;
                int v14 = v13 <= v8 ? this.zzau(v13) : this.zzp(v13, v5 / 3);
                if(v14 == -1) {
                    v15 = v13;
                    v16 = v11;
                    v17 = v12;
                    v18 = v3;
                    v19 = 0;
                    goto label_261;
                }
                else {
                    int[] arr_v = this.zzud;
                    int v20 = arr_v[v14 + 1];
                    int v21 = (v20 & 0xFF00000) >>> 20;
                    long v22 = (long)(v20 & 0xFFFFF);
                    int v23 = v20;
                    if(v21 <= 17) {
                        int v24 = arr_v[v14 + 2];
                        int v25 = 1 << (v24 >>> 20);
                        int v26 = v24 & 0xFFFFF;
                        if(v26 != v9) {
                            if(v9 != -1) {
                                unsafe0.putInt(object0, ((long)v9), v7);
                            }
                            v7 = unsafe0.getInt(object0, ((long)v26));
                            v9 = v26;
                        }
                        switch(v21) {
                            case 0: {
                                v27 = v14;
                                v28 = v13;
                                v29 = v9;
                                v30 = v12;
                                v31 = v11;
                                if((v12 & 7) == 1) {
                                    zznd.zza(object0, v22, zziy.zzc(arr_b, v31));
                                    v4 = v31 + 8;
                                    v7 |= v25;
                                    v9 = v29;
                                    goto label_174;
                                }
                                break;
                            }
                            case 1: {
                                v27 = v14;
                                v28 = v13;
                                v29 = v9;
                                v30 = v12;
                                v31 = v11;
                                if((v12 & 7) == 5) {
                                    zznd.zza(object0, v22, zziy.zzd(arr_b, v31));
                                    v4 = v31 + 4;
                                    v7 |= v25;
                                    v9 = v29;
                                    goto label_174;
                                }
                                break;
                            }
                            case 2: 
                            case 3: {
                                v27 = v14;
                                v28 = v13;
                                v29 = v9;
                                v30 = v12;
                                v31 = v11;
                                if((v12 & 7) == 0) {
                                    int v32 = zziy.zzb(arr_b, v31, zziz0);
                                    unsafe0.putLong(object0, v22, zziz0.zznl);
                                    v7 |= v25;
                                    v4 = v32;
                                    v6 = v30;
                                    v5 = v27;
                                    v8 = v28;
                                    v9 = v29;
                                    v3 = v2;
                                    continue;
                                }
                                break;
                            }
                            case 7: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 0) {
                                    int v33 = zziy.zzb(arr_b, v11, zziz0);
                                    zznd.zza(object0, v22, zziz0.zznl != 0L);
                                    v7 |= v25;
                                    v4 = v33;
                                    goto label_133;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 8: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 2) {
                                    v4 = (v23 & 0x20000000) == 0 ? zziy.zzc(arr_b, v11, zziz0) : zziy.zzd(arr_b, v11, zziz0);
                                    goto label_129;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 9: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 2) {
                                    v4 = zziy.zza(this.zzap(v27), arr_b, v11, v1, zziz0);
                                    if((v7 & v25) == 0) {
                                    label_129:
                                        unsafe0.putObject(object0, v22, zziz0.zznm);
                                    }
                                    else {
                                        unsafe0.putObject(object0, v22, zzkm.zza(unsafe0.getObject(object0, v22), zziz0.zznm));
                                    }
                                label_132:
                                    v7 |= v25;
                                label_133:
                                    v6 = v30;
                                    v5 = v27;
                                    v8 = v28;
                                    v3 = v2;
                                    continue;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 10: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 2) {
                                    v4 = zziy.zze(arr_b, v11, zziz0);
                                    unsafe0.putObject(object0, v22, zziz0.zznm);
                                    v7 |= v25;
                                    goto label_174;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 4: 
                            case 11: {
                                v27 = v14;
                                v28 = v13;
                                v29 = v9;
                                v30 = v12;
                                v31 = v11;
                                if((v12 & 7) == 0) {
                                    v4 = zziy.zza(arr_b, v31, zziz0);
                                    unsafe0.putInt(object0, v22, zziz0.zznk);
                                    v7 |= v25;
                                    v9 = v29;
                                    goto label_174;
                                }
                                break;
                            }
                            case 12: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 0) {
                                    v4 = zziy.zza(arr_b, v11, zziz0);
                                    int v34 = zziz0.zznk;
                                    zzko zzko0 = this.zzar(v27);
                                    if(zzko0 == null || zzko0.zzan(v34)) {
                                        unsafe0.putInt(object0, v22, v34);
                                    }
                                    else {
                                        zzlu.zzo(object0).zzb(v30, ((long)v34));
                                        goto label_174;
                                    }
                                    v7 |= v25;
                                    goto label_174;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 6: 
                            case 13: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 5) {
                                    unsafe0.putInt(object0, v22, zziy.zza(arr_b, v11));
                                    v4 = v11 + 4;
                                    goto label_132;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 5: 
                            case 14: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 1) {
                                    unsafe0.putLong(object0, v22, zziy.zzb(arr_b, v11));
                                    v4 = v11 + 8;
                                    v7 |= v25;
                                    goto label_174;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 15: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 0) {
                                    v4 = zziy.zza(arr_b, v11, zziz0);
                                    unsafe0.putInt(object0, v22, -(zziz0.zznk & 1) ^ zziz0.zznk >>> 1);
                                    v7 |= v25;
                                    goto label_174;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 16: {
                                v27 = v14;
                                v28 = v13;
                                v30 = v12;
                                if((v12 & 7) == 0) {
                                    int v35 = zziy.zzb(arr_b, v11, zziz0);
                                    unsafe0.putLong(object0, v22, -(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1);
                                    v7 |= v25;
                                    v4 = v35;
                                label_174:
                                    v6 = v30;
                                    v5 = v27;
                                    v8 = v28;
                                    v3 = v2;
                                    continue;
                                }
                                v29 = v9;
                                v31 = v11;
                                break;
                            }
                            case 17: {
                                if((v12 & 7) == 3) {
                                    v4 = zziy.zza(this.zzap(v14), arr_b, v11, v1, v13 << 3 | 4, zziz0);
                                    if((v7 & v25) == 0) {
                                        unsafe0.putObject(object0, v22, zziz0.zznm);
                                    }
                                    else {
                                        unsafe0.putObject(object0, v22, zzkm.zza(unsafe0.getObject(object0, v22), zziz0.zznm));
                                    }
                                    v7 |= v25;
                                    v6 = v12;
                                    v5 = v14;
                                    v8 = v13;
                                    v3 = v2;
                                    continue;
                                }
                                else {
                                    v27 = v14;
                                    v28 = v13;
                                    v30 = v12;
                                    v29 = v9;
                                    v31 = v11;
                                }
                                break;
                            }
                            default: {
                                v27 = v14;
                                v28 = v13;
                                v29 = v9;
                                v30 = v12;
                                v31 = v11;
                            }
                        }
                        v16 = v31;
                        v19 = v27;
                        v9 = v29;
                        v17 = v30;
                        v15 = v28;
                        v18 = v2;
                        goto label_261;
                    }
                    else if(v21 == 27) {
                        if((v12 & 7) == 2) {
                            zzkp zzkp0 = (zzkp)unsafe0.getObject(object0, v22);
                            if(!zzkp0.zzbo()) {
                                int v36 = zzkp0.size();
                                zzkp0 = zzkp0.zzr((v36 == 0 ? 10 : v36 << 1));
                                unsafe0.putObject(object0, v22, zzkp0);
                            }
                            v4 = zziy.zza(this.zzap(v14), v12, arr_b, v11, v1, zzkp0, zziz0);
                            v3 = v2;
                            v8 = v13;
                            v6 = v12;
                            v5 = v14;
                            continue;
                        }
                        else {
                            v37 = v7;
                            v15 = v13;
                            v38 = v12;
                            v19 = v14;
                            v18 = v2;
                            v16 = v11;
                            v7 = v37;
                            v17 = v38;
                            goto label_261;
                        }
                        goto label_226;
                    }
                    else {
                    label_226:
                        v37 = v7;
                        if(v21 <= 49) {
                            v15 = v13;
                            v38 = v12;
                            v19 = v14;
                            v4 = this.zza(object0, arr_b, v11, v1, v12, v15, v12 & 7, v14, ((long)v23), v21, v22, zziz0);
                            if(v4 == v11) {
                                goto label_247;
                            }
                            else {
                                goto label_241;
                            }
                            goto label_234;
                        }
                        else {
                        label_234:
                            v15 = v13;
                            v38 = v12;
                            v19 = v14;
                            if(v21 == 50) {
                                if((v12 & 7) == 2) {
                                    v4 = this.zza(object0, arr_b, v11, v1, v19, v22, zziz0);
                                    if(v4 != v11) {
                                    label_241:
                                        v8 = v15;
                                        v3 = v2;
                                        v5 = v19;
                                        v7 = v37;
                                        v6 = v38;
                                        continue;
                                    }
                                label_247:
                                    v18 = v2;
                                    v16 = v4;
                                }
                                else {
                                    v18 = v2;
                                    v16 = v11;
                                }
                                v7 = v37;
                                v17 = v38;
                                goto label_261;
                            }
                            else {
                                v4 = this.zza(object0, arr_b, v11, v1, v38, v15, v12 & 7, v23, v21, v22, v19, zziz0);
                                if(v4 == v11) {
                                    v18 = v2;
                                    v16 = v4;
                                    v7 = v37;
                                    v17 = v38;
                                label_261:
                                    if(v17 == v18 && v18 != 0) {
                                        v39 = v9;
                                        v40 = v16;
                                        break;
                                    }
                                    if(this.zzui) {
                                        zzjx zzjx0 = zzjx.zzci();
                                        if(zziz0.zznn == zzjx0) {
                                            v41 = v15;
                                            goto label_279;
                                        }
                                        else {
                                            if(zziz0.zznn.zza(this.zzuh, v15) == null) {
                                                v4 = zziy.zza(v17, arr_b, v16, v1, zzlu.zzo(object0), zziz0);
                                                v6 = v17;
                                                v8 = v15;
                                                v5 = v19;
                                                v3 = v18;
                                                continue;
                                            }
                                            ((zzc)object0).zzdg();
                                            throw new NoSuchMethodError();
                                        }
                                        goto label_278;
                                    }
                                    else {
                                    label_278:
                                        v41 = v15;
                                    }
                                label_279:
                                    v4 = zziy.zza(v17, arr_b, v16, v1, zzlu.zzo(object0), zziz0);
                                    v6 = v17;
                                    v8 = v41;
                                    v5 = v19;
                                    v3 = v18;
                                }
                                else {
                                    v3 = v2;
                                    v6 = v38;
                                    v8 = v15;
                                    v5 = v19;
                                    v7 = v37;
                                }
                                continue;
                            }
                        }
                    }
                }
            }
            v18 = v3;
            v40 = v4;
            v17 = v6;
            v39 = v9;
            break;
        }
        if(v39 != -1) {
            unsafe0.putInt(object0, ((long)v39), v7);
        }
        int v42 = this.zzun;
        zzmy zzmy0 = null;
        while(v42 < this.zzuo) {
            int v43 = this.zzum[v42];
            zzmx zzmx0 = this.zzur;
            int v44 = this.zzud[v43];
            Object object1 = zznd.zzo(object0, ((long)(this.zzas(v43) & 0xFFFFF)));
            if(object1 != null) {
                zzko zzko1 = this.zzar(v43);
                if(zzko1 != null) {
                    zzmy0 = this.zza(v43, v44, this.zzut.zzh(object1), zzko1, zzmy0, zzmx0);
                }
            }
            ++v42;
        }
        if(zzmy0 != null) {
            this.zzur.zzf(object0, zzmy0);
        }
        if(v18 == 0) {
            if(v40 != v1) {
                throw zzkq.zzdm();
            }
            return v40;
        }
        if(v40 > v1 || v17 != v18) {
            throw zzkq.zzdm();
        }
        return v40;
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zza(Object object0, zzns zzns0) throws IOException {
        Map.Entry map$Entry1;
        Iterator iterator1;
        Map.Entry map$Entry0;
        Iterator iterator0;
        if(zzns0.zzcd() == zze.zzsj) {
            zzlu.zza(this.zzur, object0, zzns0);
            if(this.zzui) {
                zzkb zzkb0 = this.zzus.zzb(object0);
                if(zzkb0.zzos.isEmpty()) {
                    iterator0 = null;
                    map$Entry0 = null;
                }
                else {
                    iterator0 = zzkb0.descendingIterator();
                    Object object1 = iterator0.next();
                    map$Entry0 = (Map.Entry)object1;
                }
            }
            else {
                iterator0 = null;
                map$Entry0 = null;
            }
            for(int v = this.zzud.length - 3; v >= 0; v -= 3) {
                int v1 = this.zzas(v);
                int v2 = this.zzud[v];
                while(map$Entry0 != null && this.zzus.zza(map$Entry0) > v2) {
                    this.zzus.zza(zzns0, map$Entry0);
                    if(iterator0.hasNext()) {
                        Object object2 = iterator0.next();
                        map$Entry0 = (Map.Entry)object2;
                    }
                    else {
                        map$Entry0 = null;
                    }
                }
                switch((v1 & 0xFF00000) >>> 20) {
                    case 0: {
                        if(this.zza(object0, v)) {
                            zzns0.zza(v2, zznd.zzn(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 1: {
                        if(this.zza(object0, v)) {
                            zzns0.zza(v2, zznd.zzm(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 2: {
                        if(this.zza(object0, v)) {
                            zzns0.zzi(v2, zznd.zzk(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 3: {
                        if(this.zza(object0, v)) {
                            zzns0.zza(v2, zznd.zzk(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 4: {
                        if(this.zza(object0, v)) {
                            zzns0.zzc(v2, zznd.zzj(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 5: {
                        if(this.zza(object0, v)) {
                            zzns0.zzc(v2, zznd.zzk(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 6: {
                        if(this.zza(object0, v)) {
                            zzns0.zzf(v2, zznd.zzj(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 7: {
                        if(this.zza(object0, v)) {
                            zzns0.zzb(v2, zznd.zzl(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 8: {
                        if(this.zza(object0, v)) {
                            zzlu.zza(v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), zzns0);
                        }
                        break;
                    }
                    case 9: {
                        if(this.zza(object0, v)) {
                            zzns0.zza(v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), this.zzap(v));
                        }
                        break;
                    }
                    case 10: {
                        if(this.zza(object0, v)) {
                            zzns0.zza(v2, ((zzjc)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 11: {
                        if(this.zza(object0, v)) {
                            zzns0.zzd(v2, zznd.zzj(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 12: {
                        if(this.zza(object0, v)) {
                            zzns0.zzn(v2, zznd.zzj(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 13: {
                        if(this.zza(object0, v)) {
                            zzns0.zzm(v2, zznd.zzj(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 14: {
                        if(this.zza(object0, v)) {
                            zzns0.zzj(v2, zznd.zzk(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 15: {
                        if(this.zza(object0, v)) {
                            zzns0.zze(v2, zznd.zzj(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 16: {
                        if(this.zza(object0, v)) {
                            zzns0.zzb(v2, zznd.zzk(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 17: {
                        if(this.zza(object0, v)) {
                            zzns0.zzb(v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), this.zzap(v));
                        }
                        break;
                    }
                    case 18: {
                        zzmh.zza(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 19: {
                        zzmh.zzb(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 20: {
                        zzmh.zzc(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 21: {
                        zzmh.zzd(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 22: {
                        zzmh.zzh(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 23: {
                        zzmh.zzf(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 24: {
                        zzmh.zzk(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 25: {
                        zzmh.zzn(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 26: {
                        zzmh.zza(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0);
                        break;
                    }
                    case 27: {
                        zzmh.zza(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, this.zzap(v));
                        break;
                    }
                    case 28: {
                        zzmh.zzb(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0);
                        break;
                    }
                    case 29: {
                        zzmh.zzi(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 30: {
                        zzmh.zzm(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 0x1F: {
                        zzmh.zzl(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 0x20: {
                        zzmh.zzg(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 33: {
                        zzmh.zzj(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 34: {
                        zzmh.zze(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 35: {
                        zzmh.zza(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 36: {
                        zzmh.zzb(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 37: {
                        zzmh.zzc(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 38: {
                        zzmh.zzd(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 39: {
                        zzmh.zzh(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 40: {
                        zzmh.zzf(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 41: {
                        zzmh.zzk(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 42: {
                        zzmh.zzn(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 43: {
                        zzmh.zzi(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 44: {
                        zzmh.zzm(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 45: {
                        zzmh.zzl(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 46: {
                        zzmh.zzg(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 0x2F: {
                        zzmh.zzj(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 0x30: {
                        zzmh.zze(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 49: {
                        zzmh.zzb(this.zzud[v], ((List)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))), zzns0, this.zzap(v));
                        break;
                    }
                    case 50: {
                        this.zza(zzns0, v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), v);
                        break;
                    }
                    case 51: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zza(v2, zzlu.zze(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 52: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zza(v2, zzlu.zzf(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 53: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzi(v2, zzlu.zzh(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 54: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zza(v2, zzlu.zzh(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 55: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzc(v2, zzlu.zzg(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 56: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzc(v2, zzlu.zzh(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 57: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzf(v2, zzlu.zzg(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 58: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzb(v2, zzlu.zzi(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 59: {
                        if(this.zza(object0, v2, v)) {
                            zzlu.zza(v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), zzns0);
                        }
                        break;
                    }
                    case 60: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zza(v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), this.zzap(v));
                        }
                        break;
                    }
                    case 61: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zza(v2, ((zzjc)zznd.zzo(object0, ((long)(v1 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 62: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzd(v2, zzlu.zzg(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzn(v2, zzlu.zzg(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzm(v2, zzlu.zzg(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 65: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzj(v2, zzlu.zzh(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 66: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zze(v2, zzlu.zzg(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 67: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzb(v2, zzlu.zzh(object0, ((long)(v1 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 68: {
                        if(this.zza(object0, v2, v)) {
                            zzns0.zzb(v2, zznd.zzo(object0, ((long)(v1 & 0xFFFFF))), this.zzap(v));
                        }
                    }
                }
            }
            while(map$Entry0 != null) {
                this.zzus.zza(zzns0, map$Entry0);
                if(iterator0.hasNext()) {
                    Object object3 = iterator0.next();
                    map$Entry0 = (Map.Entry)object3;
                }
                else {
                    map$Entry0 = null;
                }
            }
            return;
        }
        if(this.zzuk) {
            if(this.zzui) {
                zzkb zzkb1 = this.zzus.zzb(object0);
                if(zzkb1.zzos.isEmpty()) {
                    iterator1 = null;
                    map$Entry1 = null;
                }
                else {
                    iterator1 = zzkb1.iterator();
                    Object object4 = iterator1.next();
                    map$Entry1 = (Map.Entry)object4;
                }
            }
            else {
                iterator1 = null;
                map$Entry1 = null;
            }
            for(int v3 = 0; v3 < this.zzud.length; v3 += 3) {
                int v4 = this.zzas(v3);
                int v5 = this.zzud[v3];
                while(map$Entry1 != null && this.zzus.zza(map$Entry1) <= v5) {
                    this.zzus.zza(zzns0, map$Entry1);
                    if(iterator1.hasNext()) {
                        Object object5 = iterator1.next();
                        map$Entry1 = (Map.Entry)object5;
                    }
                    else {
                        map$Entry1 = null;
                    }
                }
                switch((v4 & 0xFF00000) >>> 20) {
                    case 0: {
                        if(this.zza(object0, v3)) {
                            zzns0.zza(v5, zznd.zzn(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 1: {
                        if(this.zza(object0, v3)) {
                            zzns0.zza(v5, zznd.zzm(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 2: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzi(v5, zznd.zzk(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 3: {
                        if(this.zza(object0, v3)) {
                            zzns0.zza(v5, zznd.zzk(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 4: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzc(v5, zznd.zzj(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 5: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzc(v5, zznd.zzk(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 6: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzf(v5, zznd.zzj(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 7: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzb(v5, zznd.zzl(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 8: {
                        if(this.zza(object0, v3)) {
                            zzlu.zza(v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), zzns0);
                        }
                        break;
                    }
                    case 9: {
                        if(this.zza(object0, v3)) {
                            zzns0.zza(v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), this.zzap(v3));
                        }
                        break;
                    }
                    case 10: {
                        if(this.zza(object0, v3)) {
                            zzns0.zza(v5, ((zzjc)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 11: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzd(v5, zznd.zzj(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 12: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzn(v5, zznd.zzj(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 13: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzm(v5, zznd.zzj(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 14: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzj(v5, zznd.zzk(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 15: {
                        if(this.zza(object0, v3)) {
                            zzns0.zze(v5, zznd.zzj(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 16: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzb(v5, zznd.zzk(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 17: {
                        if(this.zza(object0, v3)) {
                            zzns0.zzb(v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), this.zzap(v3));
                        }
                        break;
                    }
                    case 18: {
                        zzmh.zza(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 19: {
                        zzmh.zzb(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 20: {
                        zzmh.zzc(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 21: {
                        zzmh.zzd(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 22: {
                        zzmh.zzh(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 23: {
                        zzmh.zzf(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 24: {
                        zzmh.zzk(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 25: {
                        zzmh.zzn(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 26: {
                        zzmh.zza(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0);
                        break;
                    }
                    case 27: {
                        zzmh.zza(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, this.zzap(v3));
                        break;
                    }
                    case 28: {
                        zzmh.zzb(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0);
                        break;
                    }
                    case 29: {
                        zzmh.zzi(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 30: {
                        zzmh.zzm(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 0x1F: {
                        zzmh.zzl(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 0x20: {
                        zzmh.zzg(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 33: {
                        zzmh.zzj(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 34: {
                        zzmh.zze(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, false);
                        break;
                    }
                    case 35: {
                        zzmh.zza(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 36: {
                        zzmh.zzb(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 37: {
                        zzmh.zzc(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 38: {
                        zzmh.zzd(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 39: {
                        zzmh.zzh(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 40: {
                        zzmh.zzf(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 41: {
                        zzmh.zzk(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 42: {
                        zzmh.zzn(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 43: {
                        zzmh.zzi(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 44: {
                        zzmh.zzm(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 45: {
                        zzmh.zzl(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 46: {
                        zzmh.zzg(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 0x2F: {
                        zzmh.zzj(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 0x30: {
                        zzmh.zze(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, true);
                        break;
                    }
                    case 49: {
                        zzmh.zzb(this.zzud[v3], ((List)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))), zzns0, this.zzap(v3));
                        break;
                    }
                    case 50: {
                        this.zza(zzns0, v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), v3);
                        break;
                    }
                    case 51: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zza(v5, zzlu.zze(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 52: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zza(v5, zzlu.zzf(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 53: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzi(v5, zzlu.zzh(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 54: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zza(v5, zzlu.zzh(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 55: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzc(v5, zzlu.zzg(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 56: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzc(v5, zzlu.zzh(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 57: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzf(v5, zzlu.zzg(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 58: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzb(v5, zzlu.zzi(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 59: {
                        if(this.zza(object0, v5, v3)) {
                            zzlu.zza(v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), zzns0);
                        }
                        break;
                    }
                    case 60: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zza(v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), this.zzap(v3));
                        }
                        break;
                    }
                    case 61: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zza(v5, ((zzjc)zznd.zzo(object0, ((long)(v4 & 0xFFFFF)))));
                        }
                        break;
                    }
                    case 62: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzd(v5, zzlu.zzg(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzn(v5, zzlu.zzg(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzm(v5, zzlu.zzg(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 65: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzj(v5, zzlu.zzh(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 66: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zze(v5, zzlu.zzg(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 67: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzb(v5, zzlu.zzh(object0, ((long)(v4 & 0xFFFFF))));
                        }
                        break;
                    }
                    case 68: {
                        if(this.zza(object0, v5, v3)) {
                            zzns0.zzb(v5, zznd.zzo(object0, ((long)(v4 & 0xFFFFF))), this.zzap(v3));
                        }
                    }
                }
            }
            while(map$Entry1 != null) {
                this.zzus.zza(zzns0, map$Entry1);
                if(iterator1.hasNext()) {
                    Object object6 = iterator1.next();
                    map$Entry1 = (Map.Entry)object6;
                }
                else {
                    map$Entry1 = null;
                }
            }
            zzlu.zza(this.zzur, object0, zzns0);
            return;
        }
        this.zzb(object0, zzns0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zza(Object object0, byte[] arr_b, int v, int v1, zziz zziz0) throws IOException {
        int v17;
        int v15;
        int v14;
        int v10;
        Unsafe unsafe1;
        int v9;
        int v7;
        int v6;
        if(this.zzuk) {
            Unsafe unsafe0 = zzlu.zzuc;
            int v2 = v;
            int v3 = -1;
            int v4 = 0;
            while(v2 < v1) {
                int v5 = arr_b[v2];
                if(v5 < 0) {
                    v6 = zziy.zza(v5, arr_b, v2 + 1, zziz0);
                    v7 = zziz0.zznk;
                }
                else {
                    v7 = v5;
                    v6 = v2 + 1;
                }
                int v8 = v7 >>> 3 <= v3 ? this.zzau(v7 >>> 3) : this.zzp(v7 >>> 3, v4 / 3);
                if(v8 == -1) {
                    v9 = v7 >>> 3;
                    unsafe1 = unsafe0;
                    v10 = 0;
                    v2 = zziy.zza(v7, arr_b, v6, v1, zzlu.zzo(object0), zziz0);
                }
                else {
                    int v11 = this.zzud[v8 + 1];
                    int v12 = (0xFF00000 & v11) >>> 20;
                    long v13 = (long)(0xFFFFF & v11);
                    if(v12 <= 17) {
                        boolean z = true;
                        switch(v12) {
                            case 0: {
                                v14 = v8;
                                if((v7 & 7) == 1) {
                                    zznd.zza(object0, v13, zziy.zzc(arr_b, v6));
                                    v2 = v6 + 8;
                                    v3 = v7 >>> 3;
                                    v4 = v14;
                                    continue;
                                }
                                goto label_114;
                            }
                            case 1: {
                                v14 = v8;
                                if((v7 & 7) == 5) {
                                    zznd.zza(object0, v13, zziy.zzd(arr_b, v6));
                                    v2 = v6 + 4;
                                    v3 = v7 >>> 3;
                                    v4 = v14;
                                    continue;
                                }
                                goto label_114;
                            }
                            case 2: 
                            case 3: {
                                v14 = v8;
                                if((v7 & 7) == 0) {
                                    v15 = zziy.zzb(arr_b, v6, zziz0);
                                    unsafe0.putLong(object0, v13, zziz0.zznl);
                                    v2 = v15;
                                    v3 = v7 >>> 3;
                                    v4 = v14;
                                    continue;
                                }
                                goto label_114;
                            }
                            case 7: {
                                if((v7 & 7) == 0) {
                                    int v16 = zziy.zzb(arr_b, v6, zziz0);
                                    if(zziz0.zznl == 0L) {
                                        z = false;
                                    }
                                    zznd.zza(object0, v13, z);
                                    v2 = v16;
                                    v4 = v8;
                                    v3 = v7 >>> 3;
                                    continue;
                                }
                                else {
                                    goto label_137;
                                }
                                goto label_78;
                            }
                            case 8: {
                            label_78:
                                if((v7 & 7) == 2) {
                                    v2 = (0x20000000 & v11) == 0 ? zziy.zzc(arr_b, v6, zziz0) : zziy.zzd(arr_b, v6, zziz0);
                                    unsafe0.putObject(object0, v13, zziz0.zznm);
                                    v4 = v8;
                                    v3 = v7 >>> 3;
                                    continue;
                                }
                                else {
                                    goto label_137;
                                }
                                goto label_84;
                            }
                            case 9: {
                            label_84:
                                if((v7 & 7) == 2) {
                                    v2 = zziy.zza(this.zzap(v8), arr_b, v6, v1, zziz0);
                                    Object object1 = unsafe0.getObject(object0, v13);
                                    if(object1 == null) {
                                        unsafe0.putObject(object0, v13, zziz0.zznm);
                                    }
                                    else {
                                        unsafe0.putObject(object0, v13, zzkm.zza(object1, zziz0.zznm));
                                    }
                                    v4 = v8;
                                    v3 = v7 >>> 3;
                                    continue;
                                }
                                else {
                                    goto label_137;
                                }
                                goto label_94;
                            }
                            case 10: {
                            label_94:
                                if((v7 & 7) == 2) {
                                    v2 = zziy.zze(arr_b, v6, zziz0);
                                    unsafe0.putObject(object0, v13, zziz0.zznm);
                                    v4 = v8;
                                    v3 = v7 >>> 3;
                                    continue;
                                }
                                else {
                                    goto label_137;
                                }
                                goto label_100;
                            }
                            case 4: 
                            case 11: {
                                v14 = v8;
                                if((v7 & 7) == 0) {
                                    v2 = zziy.zza(arr_b, v6, zziz0);
                                    unsafe0.putInt(object0, v13, zziz0.zznk);
                                    v3 = v7 >>> 3;
                                    v4 = v14;
                                    continue;
                                }
                                goto label_114;
                            }
                            case 12: {
                            label_100:
                                v14 = v8;
                                if((v7 & 7) == 0) {
                                    v2 = zziy.zza(arr_b, v6, zziz0);
                                    unsafe0.putInt(object0, v13, zziz0.zznk);
                                    v3 = v7 >>> 3;
                                    v4 = v14;
                                    continue;
                                }
                                goto label_114;
                            }
                            case 6: 
                            case 13: {
                            label_62:
                                if((v7 & 7) == 5) {
                                    unsafe0.putInt(object0, v13, zziy.zza(arr_b, v6));
                                    v2 = v6 + 4;
                                    v4 = v8;
                                    v3 = v7 >>> 3;
                                }
                                else {
                                    goto label_137;
                                }
                                continue;
                            }
                            case 5: 
                            case 14: {
                                if((v7 & 7) == 1) {
                                    unsafe0.putLong(object0, v13, zziy.zzb(arr_b, v6));
                                    v2 = v6 + 8;
                                    v3 = v7 >>> 3;
                                    v4 = v8;
                                    continue;
                                }
                                else {
                                    goto label_137;
                                }
                                goto label_62;
                            }
                            case 15: {
                                v14 = v8;
                                if((v7 & 7) == 0) {
                                    v2 = zziy.zza(arr_b, v6, zziz0);
                                    unsafe0.putInt(object0, v13, -(zziz0.zznk & 1) ^ zziz0.zznk >>> 1);
                                    v3 = v7 >>> 3;
                                    v4 = v14;
                                    continue;
                                }
                            label_114:
                                v9 = v7 >>> 3;
                                v17 = v6;
                                unsafe1 = unsafe0;
                                v10 = v14;
                                goto label_141;
                            }
                            case 16: {
                                if((v7 & 7) == 0) {
                                    v15 = zziy.zzb(arr_b, v6, zziz0);
                                    unsafe0.putLong(object0, v13, -(zziz0.zznl & 1L) ^ zziz0.zznl >>> 1);
                                    v2 = v15;
                                    v3 = v7 >>> 3;
                                    v4 = v8;
                                    continue;
                                }
                                else {
                                    goto label_137;
                                }
                                goto label_126;
                            }
                            default: {
                                goto label_137;
                            }
                        }
                    }
                    else {
                    label_126:
                        if(v12 == 27) {
                            if((v7 & 7) == 2) {
                                zzkp zzkp0 = (zzkp)unsafe0.getObject(object0, v13);
                                if(!zzkp0.zzbo()) {
                                    int v18 = zzkp0.size();
                                    zzkp0 = zzkp0.zzr((v18 == 0 ? 10 : v18 << 1));
                                    unsafe0.putObject(object0, v13, zzkp0);
                                }
                                v2 = zziy.zza(this.zzap(v8), v7, arr_b, v6, v1, zzkp0, zziz0);
                                v3 = v7 >>> 3;
                                v4 = v8;
                                continue;
                            }
                        label_137:
                            v10 = v8;
                            v9 = v7 >>> 3;
                            v17 = v6;
                            unsafe1 = unsafe0;
                        label_141:
                            v2 = zziy.zza(v7, arr_b, v17, v1, zzlu.zzo(object0), zziz0);
                        }
                        else {
                            v10 = v8;
                            if(v12 <= 49) {
                                v9 = v7 >>> 3;
                                unsafe1 = unsafe0;
                                v2 = this.zza(object0, arr_b, v6, v1, v7, v7 >>> 3, v7 & 7, v10, ((long)v11), v12, v13, zziz0);
                                if(v2 == v6) {
                                    v2 = zziy.zza(v7, arr_b, v2, v1, zzlu.zzo(object0), zziz0);
                                }
                            }
                            else {
                                v9 = v7 >>> 3;
                                unsafe1 = unsafe0;
                                if(v12 != 50) {
                                    v2 = this.zza(object0, arr_b, v6, v1, v7, v9, v7 & 7, v11, v12, v13, v10, zziz0);
                                    if(v2 == v6) {
                                        v2 = zziy.zza(v7, arr_b, v2, v1, zzlu.zzo(object0), zziz0);
                                    }
                                }
                                else if((v7 & 7) == 2) {
                                    v2 = this.zza(object0, arr_b, v6, v1, v10, v13, zziz0);
                                    if(v2 == v6) {
                                        v2 = zziy.zza(v7, arr_b, v2, v1, zzlu.zzo(object0), zziz0);
                                    }
                                }
                                else {
                                    v2 = zziy.zza(v7, arr_b, v6, v1, zzlu.zzo(object0), zziz0);
                                }
                            }
                        }
                    }
                }
                unsafe0 = unsafe1;
                v4 = v10;
                v3 = v9;
            }
            if(v2 != v1) {
                throw zzkq.zzdm();
            }
            return;
        }
        this.zza(object0, arr_b, v, v1, 0, zziz0);
    }

    private final zzmf zzap(int v) {
        int v1 = v / 3 << 1;
        zzmf zzmf0 = (zzmf)this.zzue[v1];
        if(zzmf0 != null) {
            return zzmf0;
        }
        zzmf zzmf1 = zzmd.zzej().zzf(((Class)this.zzue[v1 + 1]));
        this.zzue[v1] = zzmf1;
        return zzmf1;
    }

    private final Object zzaq(int v) {
        return this.zzue[v / 3 << 1];
    }

    private final zzko zzar(int v) {
        return (zzko)this.zzue[(v / 3 << 1) + 1];
    }

    private final int zzas(int v) {
        return this.zzud[v + 1];
    }

    private final int zzat(int v) {
        return this.zzud[v + 2];
    }

    private final int zzau(int v) {
        return v < this.zzuf || v > this.zzug ? -1 : this.zzq(v, 0);
    }

    private final void zzb(Object object0, int v) {
        if(this.zzuk) {
            return;
        }
        int v1 = this.zzat(v);
        zznd.zza(object0, ((long)(v1 & 0xFFFFF)), zznd.zzj(object0, ((long)(v1 & 0xFFFFF))) | 1 << (v1 >>> 20));
    }

    private final void zzb(Object object0, int v, int v1) {
        zznd.zza(object0, ((long)(this.zzat(v1) & 0xFFFFF)), v);
    }

    private final void zzb(Object object0, zzns zzns0) throws IOException {
        int v8;
        Map.Entry map$Entry0;
        Iterator iterator0;
        if(this.zzui) {
            zzkb zzkb0 = this.zzus.zzb(object0);
            if(zzkb0.zzos.isEmpty()) {
                iterator0 = null;
                map$Entry0 = null;
            }
            else {
                iterator0 = zzkb0.iterator();
                Object object1 = iterator0.next();
                map$Entry0 = (Map.Entry)object1;
            }
        }
        else {
            iterator0 = null;
            map$Entry0 = null;
        }
        Unsafe unsafe0 = zzlu.zzuc;
        int v = -1;
        int v2 = 0;
        for(int v1 = 0; v1 < this.zzud.length; v1 += 3) {
            int v3 = this.zzas(v1);
            int[] arr_v = this.zzud;
            int v4 = arr_v[v1];
            int v5 = (0xFF00000 & v3) >>> 20;
            if(this.zzuk || v5 > 17) {
                v8 = 0;
            }
            else {
                int v6 = arr_v[v1 + 2];
                int v7 = v6 & 0xFFFFF;
                if(v7 != v) {
                    v2 = unsafe0.getInt(object0, ((long)v7));
                    v = v7;
                }
                v8 = 1 << (v6 >>> 20);
            }
            while(map$Entry0 != null && this.zzus.zza(map$Entry0) <= v4) {
                this.zzus.zza(zzns0, map$Entry0);
                if(iterator0.hasNext()) {
                    Object object2 = iterator0.next();
                    map$Entry0 = (Map.Entry)object2;
                }
                else {
                    map$Entry0 = null;
                }
            }
            long v9 = (long)(v3 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if((v8 & v2) != 0) {
                        zzns0.zza(v4, zznd.zzn(object0, v9));
                    }
                    break;
                }
                case 1: {
                    if((v8 & v2) != 0) {
                        zzns0.zza(v4, zznd.zzm(object0, v9));
                    }
                    break;
                }
                case 2: {
                    if((v8 & v2) != 0) {
                        zzns0.zzi(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 3: {
                    if((v8 & v2) != 0) {
                        zzns0.zza(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 4: {
                    if((v8 & v2) != 0) {
                        zzns0.zzc(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 5: {
                    if((v8 & v2) != 0) {
                        zzns0.zzc(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 6: {
                    if((v8 & v2) != 0) {
                        zzns0.zzf(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 7: {
                    if((v8 & v2) != 0) {
                        zzns0.zzb(v4, zznd.zzl(object0, v9));
                    }
                    break;
                }
                case 8: {
                    if((v8 & v2) != 0) {
                        zzlu.zza(v4, unsafe0.getObject(object0, v9), zzns0);
                    }
                    break;
                }
                case 9: {
                    if((v8 & v2) != 0) {
                        zzns0.zza(v4, unsafe0.getObject(object0, v9), this.zzap(v1));
                    }
                    break;
                }
                case 10: {
                    if((v8 & v2) != 0) {
                        zzns0.zza(v4, ((zzjc)unsafe0.getObject(object0, v9)));
                    }
                    break;
                }
                case 11: {
                    if((v8 & v2) != 0) {
                        zzns0.zzd(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 12: {
                    if((v8 & v2) != 0) {
                        zzns0.zzn(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 13: {
                    if((v8 & v2) != 0) {
                        zzns0.zzm(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 14: {
                    if((v8 & v2) != 0) {
                        zzns0.zzj(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 15: {
                    if((v8 & v2) != 0) {
                        zzns0.zze(v4, unsafe0.getInt(object0, v9));
                    }
                    break;
                }
                case 16: {
                    if((v8 & v2) != 0) {
                        zzns0.zzb(v4, unsafe0.getLong(object0, v9));
                    }
                    break;
                }
                case 17: {
                    if((v8 & v2) != 0) {
                        zzns0.zzb(v4, unsafe0.getObject(object0, v9), this.zzap(v1));
                    }
                    break;
                }
                case 18: {
                    zzmh.zza(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 19: {
                    zzmh.zzb(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 20: {
                    zzmh.zzc(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 21: {
                    zzmh.zzd(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 22: {
                    zzmh.zzh(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 23: {
                    zzmh.zzf(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 24: {
                    zzmh.zzk(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 25: {
                    zzmh.zzn(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 26: {
                    zzmh.zza(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0);
                    break;
                }
                case 27: {
                    zzmh.zza(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, this.zzap(v1));
                    break;
                }
                case 28: {
                    zzmh.zzb(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0);
                    break;
                }
                case 29: {
                    zzmh.zzi(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 30: {
                    zzmh.zzm(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 0x1F: {
                    zzmh.zzl(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 0x20: {
                    zzmh.zzg(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 33: {
                    zzmh.zzj(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 34: {
                    zzmh.zze(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, false);
                    break;
                }
                case 35: {
                    zzmh.zza(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 36: {
                    zzmh.zzb(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 37: {
                    zzmh.zzc(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 38: {
                    zzmh.zzd(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 39: {
                    zzmh.zzh(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 40: {
                    zzmh.zzf(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 41: {
                    zzmh.zzk(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 42: {
                    zzmh.zzn(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 43: {
                    zzmh.zzi(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 44: {
                    zzmh.zzm(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 45: {
                    zzmh.zzl(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 46: {
                    zzmh.zzg(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 0x2F: {
                    zzmh.zzj(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 0x30: {
                    zzmh.zze(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, true);
                    break;
                }
                case 49: {
                    zzmh.zzb(this.zzud[v1], ((List)unsafe0.getObject(object0, v9)), zzns0, this.zzap(v1));
                    break;
                }
                case 50: {
                    this.zza(zzns0, v4, unsafe0.getObject(object0, v9), v1);
                    break;
                }
                case 51: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zza(v4, zzlu.zze(object0, v9));
                    }
                    break;
                }
                case 52: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zza(v4, zzlu.zzf(object0, v9));
                    }
                    break;
                }
                case 53: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzi(v4, zzlu.zzh(object0, v9));
                    }
                    break;
                }
                case 54: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zza(v4, zzlu.zzh(object0, v9));
                    }
                    break;
                }
                case 55: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzc(v4, zzlu.zzg(object0, v9));
                    }
                    break;
                }
                case 56: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzc(v4, zzlu.zzh(object0, v9));
                    }
                    break;
                }
                case 57: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzf(v4, zzlu.zzg(object0, v9));
                    }
                    break;
                }
                case 58: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzb(v4, zzlu.zzi(object0, v9));
                    }
                    break;
                }
                case 59: {
                    if(this.zza(object0, v4, v1)) {
                        zzlu.zza(v4, unsafe0.getObject(object0, v9), zzns0);
                    }
                    break;
                }
                case 60: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zza(v4, unsafe0.getObject(object0, v9), this.zzap(v1));
                    }
                    break;
                }
                case 61: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zza(v4, ((zzjc)unsafe0.getObject(object0, v9)));
                    }
                    break;
                }
                case 62: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzd(v4, zzlu.zzg(object0, v9));
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzn(v4, zzlu.zzg(object0, v9));
                    }
                    break;
                }
                case 0x40: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzm(v4, zzlu.zzg(object0, v9));
                    }
                    break;
                }
                case 65: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzj(v4, zzlu.zzh(object0, v9));
                    }
                    break;
                }
                case 66: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zze(v4, zzlu.zzg(object0, v9));
                    }
                    break;
                }
                case 67: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzb(v4, zzlu.zzh(object0, v9));
                    }
                    break;
                }
                case 68: {
                    if(this.zza(object0, v4, v1)) {
                        zzns0.zzb(v4, unsafe0.getObject(object0, v9), this.zzap(v1));
                    }
                }
            }
        }
        while(map$Entry0 != null) {
            this.zzus.zza(zzns0, map$Entry0);
            if(iterator0.hasNext()) {
                Object object3 = iterator0.next();
                map$Entry0 = (Map.Entry)object3;
            }
            else {
                map$Entry0 = null;
            }
        }
        zzlu.zza(this.zzur, object0, zzns0);
    }

    private final void zzb(Object object0, Object object1, int v) {
        int v1 = this.zzas(v);
        int v2 = this.zzud[v];
        if(!this.zza(object1, v2, v)) {
            return;
        }
        Object object2 = zznd.zzo(object0, ((long)(v1 & 0xFFFFF)));
        Object object3 = zznd.zzo(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 != null && object3 != null) {
            zznd.zza(object0, ((long)(v1 & 0xFFFFF)), zzkm.zza(object2, object3));
            this.zzb(object0, v2, v);
            return;
        }
        if(object3 != null) {
            zznd.zza(object0, ((long)(v1 & 0xFFFFF)), object3);
            this.zzb(object0, v2, v);
        }
    }

    private final boolean zzc(Object object0, Object object1, int v) {
        return this.zza(object0, v) == this.zza(object1, v);
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zzc(Object object0, Object object1) {
        object1.getClass();
        for(int v = 0; v < this.zzud.length; v += 3) {
            int v1 = this.zzas(v);
            long v2 = (long)(0xFFFFF & v1);
            int v3 = this.zzud[v];
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzn(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzm(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzk(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzk(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzj(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzk(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzj(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzl(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzo(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zza(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzo(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzj(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzj(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzj(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzk(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzj(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zza(object1, v)) {
                        zznd.zza(object0, v2, zznd.zzk(object1, v2));
                        this.zzb(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zza(object0, object1, v);
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
                    this.zzuq.zza(object0, object1, v2);
                    break;
                }
                case 50: {
                    zzmh.zza(this.zzut, object0, object1, v2);
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
                    if(this.zza(object1, v3, v)) {
                        zznd.zza(object0, v2, zznd.zzo(object1, v2));
                        this.zzb(object0, v3, v);
                    }
                    break;
                }
                case 60: {
                    this.zzb(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zza(object1, v3, v)) {
                        zznd.zza(object0, v2, zznd.zzo(object1, v2));
                        this.zzb(object0, v3, v);
                    }
                    break;
                }
                case 68: {
                    this.zzb(object0, object1, v);
                }
            }
        }
        if(!this.zzuk) {
            zzmh.zza(this.zzur, object0, object1);
            if(this.zzui) {
                zzmh.zza(this.zzus, object0, object1);
            }
        }
    }

    private static List zzd(Object object0, long v) {
        return (List)zznd.zzo(object0, v);
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final void zzd(Object object0) {
        int v1;
        for(int v = this.zzun; true; ++v) {
            v1 = this.zzuo;
            if(v >= v1) {
                break;
            }
            long v2 = (long)(this.zzas(this.zzum[v]) & 0xFFFFF);
            Object object1 = zznd.zzo(object0, v2);
            if(object1 != null) {
                zznd.zza(object0, v2, this.zzut.zzk(object1));
            }
        }
        while(v1 < this.zzum.length) {
            this.zzuq.zza(object0, ((long)this.zzum[v1]));
            ++v1;
        }
        this.zzur.zzd(object0);
        if(this.zzui) {
            this.zzus.zzd(object0);
        }
    }

    private static double zze(Object object0, long v) {
        return (double)(((Double)zznd.zzo(object0, v)));
    }

    private static float zzf(Object object0, long v) {
        return (float)(((Float)zznd.zzo(object0, v)));
    }

    private static int zzg(Object object0, long v) {
        return (int)(((Integer)zznd.zzo(object0, v)));
    }

    private static long zzh(Object object0, long v) {
        return (long)(((Long)zznd.zzo(object0, v)));
    }

    private static boolean zzi(Object object0, long v) {
        return ((Boolean)zznd.zzo(object0, v)).booleanValue();
    }

    @Override  // com.google.android.gms.internal.drive.zzmf
    public final int zzn(Object object0) {
        int v29;
        int v28;
        int v27;
        int v26;
        int v25;
        int v24;
        int v23;
        int v21;
        int v20;
        int v10;
        int v9;
        int v8;
        int v7;
        if(this.zzuk) {
            Unsafe unsafe0 = zzlu.zzuc;
            int v1 = 0;
            for(int v = 0; v < this.zzud.length; v += 3) {
                int v2 = this.zzas(v);
                int v3 = (v2 & 0xFF00000) >>> 20;
                int v4 = this.zzud[v];
                long v5 = (long)(v2 & 0xFFFFF);
                int v6 = v3 < zzke.zzqh.id() || v3 > zzke.zzqu.id() ? 0 : this.zzud[v + 2] & 0xFFFFF;
                switch(v3) {
                    case 0: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzb(v4, 0.0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 1: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzb(v4, 0.0f);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 2: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzd(v4, zznd.zzk(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 3: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zze(v4, zznd.zzk(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 4: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzg(v4, zznd.zzj(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 5: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzg(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 6: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzj(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 7: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzc(v4, true);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 8: {
                        if(this.zza(object0, v)) {
                            Object object1 = zznd.zzo(object0, v5);
                            v7 = object1 instanceof zzjc ? zzjr.zzc(v4, ((zzjc)object1)) : zzjr.zzb(v4, ((String)object1));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 9: {
                        if(this.zza(object0, v)) {
                            v7 = zzmh.zzc(v4, zznd.zzo(object0, v5), this.zzap(v));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 10: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzc(v4, ((zzjc)zznd.zzo(object0, v5)));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 11: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzh(v4, zznd.zzj(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 12: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzl(v4, zznd.zzj(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 13: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzk(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 14: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzh(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 15: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzi(v4, zznd.zzj(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 16: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzf(v4, zznd.zzk(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 17: {
                        if(this.zza(object0, v)) {
                            v7 = zzjr.zzc(v4, ((zzlq)zznd.zzo(object0, v5)), this.zzap(v));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 18: {
                        v7 = zzmh.zzw(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 19: {
                        v7 = zzmh.zzv(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 20: {
                        v7 = zzmh.zzo(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 21: {
                        v7 = zzmh.zzp(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 22: {
                        v7 = zzmh.zzs(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 23: {
                        v7 = zzmh.zzw(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 24: {
                        v7 = zzmh.zzv(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 25: {
                        v7 = zzmh.zzx(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 26: {
                        v7 = zzmh.zzc(v4, zzlu.zzd(object0, v5));
                        v1 += v7;
                        break;
                    }
                    case 27: {
                        v7 = zzmh.zzc(v4, zzlu.zzd(object0, v5), this.zzap(v));
                        v1 += v7;
                        break;
                    }
                    case 28: {
                        v7 = zzmh.zzd(v4, zzlu.zzd(object0, v5));
                        v1 += v7;
                        break;
                    }
                    case 29: {
                        v7 = zzmh.zzt(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 30: {
                        v7 = zzmh.zzr(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 0x1F: {
                        v7 = zzmh.zzv(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 0x20: {
                        v7 = zzmh.zzw(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 33: {
                        v7 = zzmh.zzu(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 34: {
                        v7 = zzmh.zzq(v4, zzlu.zzd(object0, v5), false);
                        v1 += v7;
                        break;
                    }
                    case 35: {
                        v8 = zzmh.zzi(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 36: {
                        v8 = zzmh.zzh(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 37: {
                        v8 = zzmh.zza(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 38: {
                        v8 = zzmh.zzb(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 39: {
                        v8 = zzmh.zze(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 40: {
                        v8 = zzmh.zzi(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 41: {
                        v8 = zzmh.zzh(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 42: {
                        v8 = zzmh.zzj(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 43: {
                        v8 = zzmh.zzf(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 44: {
                        v8 = zzmh.zzd(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 45: {
                        v8 = zzmh.zzh(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 46: {
                        v8 = zzmh.zzi(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x2F: {
                        v8 = zzmh.zzg(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v9 = zzjr.zzab(v4);
                            v10 = zzjr.zzad(v8);
                            v7 = v9 + v10 + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x30: {
                        v8 = zzmh.zzc(((List)unsafe0.getObject(object0, v5)));
                        if(v8 > 0) {
                            if(this.zzul) {
                                unsafe0.putInt(object0, ((long)v6), v8);
                            }
                            v7 = zzjr.zzab(v4) + zzjr.zzad(v8) + v8;
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 49: {
                        v7 = zzmh.zzd(v4, zzlu.zzd(object0, v5), this.zzap(v));
                        v1 += v7;
                        break;
                    }
                    case 50: {
                        Object object2 = zznd.zzo(object0, v5);
                        Object object3 = this.zzaq(v);
                        v7 = this.zzut.zzb(v4, object2, object3);
                        v1 += v7;
                        break;
                    }
                    case 51: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzb(v4, 0.0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 52: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzb(v4, 0.0f);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 53: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzd(v4, zzlu.zzh(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 54: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zze(v4, zzlu.zzh(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 55: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzg(v4, zzlu.zzg(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 56: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzg(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 57: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzj(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 58: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzc(v4, true);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 59: {
                        if(this.zza(object0, v4, v)) {
                            Object object4 = zznd.zzo(object0, v5);
                            v7 = object4 instanceof zzjc ? zzjr.zzc(v4, ((zzjc)object4)) : zzjr.zzb(v4, ((String)object4));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 60: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzmh.zzc(v4, zznd.zzo(object0, v5), this.zzap(v));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 61: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzc(v4, ((zzjc)zznd.zzo(object0, v5)));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 62: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzh(v4, zzlu.zzg(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzl(v4, zzlu.zzg(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzk(v4, 0);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 65: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzh(v4, 0L);
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 66: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzi(v4, zzlu.zzg(object0, v5));
                            v1 += v7;
                            break;
                        }
                        break;
                    }
                    case 67: {
                        if(this.zza(object0, v4, v)) {
                            v7 = zzjr.zzf(v4, zzlu.zzh(object0, v5));
                            v1 += v7;
                        }
                        break;
                    }
                    case 68: {
                        if(this.zza(object0, v4, v)) {
                            v1 += zzjr.zzc(v4, ((zzlq)zznd.zzo(object0, v5)), this.zzap(v));
                        }
                    }
                }
            }
            return v1 + zzlu.zza(this.zzur, object0);
        }
        Unsafe unsafe1 = zzlu.zzuc;
        int v11 = -1;
        int v13 = 0;
        int v14 = 0;
        for(int v12 = 0; v12 < this.zzud.length; v12 += 3) {
            int v15 = this.zzas(v12);
            int[] arr_v = this.zzud;
            int v16 = arr_v[v12];
            int v17 = (v15 & 0xFF00000) >>> 20;
            if(v17 <= 17) {
                int v18 = arr_v[v12 + 2];
                int v19 = v18 & 0xFFFFF;
                v20 = 1 << (v18 >>> 20);
                if(v19 != v11) {
                    v14 = unsafe1.getInt(object0, ((long)v19));
                    v11 = v19;
                }
                v21 = v18;
            }
            else {
                v21 = !this.zzul || v17 < zzke.zzqh.id() || v17 > zzke.zzqu.id() ? 0 : this.zzud[v12 + 2] & 0xFFFFF;
                v20 = 0;
            }
            long v22 = (long)(v15 & 0xFFFFF);
            switch(v17) {
                case 0: {
                    if((v14 & v20) != 0) {
                        v13 += zzjr.zzb(v16, 0.0);
                    }
                    break;
                }
                case 1: {
                    if((v14 & v20) != 0) {
                        v13 += zzjr.zzb(v16, 0.0f);
                    }
                    break;
                }
                case 2: {
                    if((v14 & v20) != 0) {
                        v23 = zzjr.zzd(v16, unsafe1.getLong(object0, v22));
                        v13 += v23;
                        break;
                    }
                    break;
                }
                case 3: {
                    if((v14 & v20) != 0) {
                        v23 = zzjr.zze(v16, unsafe1.getLong(object0, v22));
                        v13 += v23;
                        break;
                    }
                    break;
                }
                case 4: {
                    if((v14 & v20) != 0) {
                        v23 = zzjr.zzg(v16, unsafe1.getInt(object0, v22));
                        v13 += v23;
                    }
                    break;
                }
                case 5: {
                    if((v14 & v20) != 0) {
                        v13 += zzjr.zzg(v16, 0L);
                    }
                    break;
                }
                case 6: {
                    if((v14 & v20) != 0) {
                        v13 += zzjr.zzj(v16, 0);
                    }
                    break;
                }
                case 7: {
                    if((v14 & v20) != 0) {
                        v13 += zzjr.zzc(v16, true);
                    }
                    break;
                }
                case 8: {
                    if((v14 & v20) != 0) {
                        Object object5 = unsafe1.getObject(object0, v22);
                        v24 = object5 instanceof zzjc ? zzjr.zzc(v16, ((zzjc)object5)) : zzjr.zzb(v16, ((String)object5));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 9: {
                    if((v14 & v20) != 0) {
                        v24 = zzmh.zzc(v16, unsafe1.getObject(object0, v22), this.zzap(v12));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 10: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzc(v16, ((zzjc)unsafe1.getObject(object0, v22)));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 11: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzh(v16, unsafe1.getInt(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 12: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzl(v16, unsafe1.getInt(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 13: {
                    if((v14 & v20) != 0) {
                        v25 = zzjr.zzk(v16, 0);
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 14: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzh(v16, 0L);
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 15: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzi(v16, unsafe1.getInt(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 16: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzf(v16, unsafe1.getLong(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 17: {
                    if((v14 & v20) != 0) {
                        v24 = zzjr.zzc(v16, ((zzlq)unsafe1.getObject(object0, v22)), this.zzap(v12));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 18: {
                    v24 = zzmh.zzw(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v24;
                    break;
                }
                case 19: {
                    v26 = zzmh.zzv(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 20: {
                    v26 = zzmh.zzo(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 21: {
                    v26 = zzmh.zzp(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 22: {
                    v26 = zzmh.zzs(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 23: {
                    v26 = zzmh.zzw(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 24: {
                    v26 = zzmh.zzv(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 25: {
                    v26 = zzmh.zzx(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 26: {
                    v24 = zzmh.zzc(v16, ((List)unsafe1.getObject(object0, v22)));
                    v13 += v24;
                    break;
                }
                case 27: {
                    v24 = zzmh.zzc(v16, ((List)unsafe1.getObject(object0, v22)), this.zzap(v12));
                    v13 += v24;
                    break;
                }
                case 28: {
                    v24 = zzmh.zzd(v16, ((List)unsafe1.getObject(object0, v22)));
                    v13 += v24;
                    break;
                }
                case 29: {
                    v24 = zzmh.zzt(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v24;
                    break;
                }
                case 30: {
                    v26 = zzmh.zzr(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 0x1F: {
                    v26 = zzmh.zzv(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 0x20: {
                    v26 = zzmh.zzw(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 33: {
                    v26 = zzmh.zzu(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    v13 += v26;
                    break;
                }
                case 34: {
                    v13 += zzmh.zzq(v16, ((List)unsafe1.getObject(object0, v22)), false);
                    break;
                }
                case 35: {
                    v27 = zzmh.zzi(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 36: {
                    v27 = zzmh.zzh(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 37: {
                    v27 = zzmh.zza(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 38: {
                    v27 = zzmh.zzb(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 39: {
                    v27 = zzmh.zze(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 40: {
                    v27 = zzmh.zzi(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 41: {
                    v27 = zzmh.zzh(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 42: {
                    v27 = zzmh.zzj(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 43: {
                    v27 = zzmh.zzf(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 44: {
                    v27 = zzmh.zzd(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 45: {
                    v27 = zzmh.zzh(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 46: {
                    v27 = zzmh.zzi(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 0x2F: {
                    v27 = zzmh.zzg(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v28 = zzjr.zzab(v16);
                        v29 = zzjr.zzad(v27);
                        v25 = v28 + v29 + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 0x30: {
                    v27 = zzmh.zzc(((List)unsafe1.getObject(object0, v22)));
                    if(v27 > 0) {
                        if(this.zzul) {
                            unsafe1.putInt(object0, ((long)v21), v27);
                        }
                        v25 = zzjr.zzab(v16) + zzjr.zzad(v27) + v27;
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 49: {
                    v24 = zzmh.zzd(v16, ((List)unsafe1.getObject(object0, v22)), this.zzap(v12));
                    v13 += v24;
                    break;
                }
                case 50: {
                    Object object6 = unsafe1.getObject(object0, v22);
                    Object object7 = this.zzaq(v12);
                    v24 = this.zzut.zzb(v16, object6, object7);
                    v13 += v24;
                    break;
                }
                case 51: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzb(v16, 0.0);
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 52: {
                    if(this.zza(object0, v16, v12)) {
                        v25 = zzjr.zzb(v16, 0.0f);
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 53: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzd(v16, zzlu.zzh(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 54: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zze(v16, zzlu.zzh(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 55: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzg(v16, zzlu.zzg(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 56: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzg(v16, 0L);
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 57: {
                    if(this.zza(object0, v16, v12)) {
                        v25 = zzjr.zzj(v16, 0);
                        v13 += v25;
                        break;
                    }
                    break;
                }
                case 58: {
                    if(this.zza(object0, v16, v12)) {
                        v25 = zzjr.zzc(v16, true);
                        v13 += v25;
                    }
                    break;
                }
                case 59: {
                    if(this.zza(object0, v16, v12)) {
                        Object object8 = unsafe1.getObject(object0, v22);
                        v24 = object8 instanceof zzjc ? zzjr.zzc(v16, ((zzjc)object8)) : zzjr.zzb(v16, ((String)object8));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 60: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzmh.zzc(v16, unsafe1.getObject(object0, v22), this.zzap(v12));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 61: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzc(v16, ((zzjc)unsafe1.getObject(object0, v22)));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 62: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzh(v16, zzlu.zzg(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzl(v16, zzlu.zzg(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 0x40: {
                    if(this.zza(object0, v16, v12)) {
                        v13 += zzjr.zzk(v16, 0);
                    }
                    break;
                }
                case 65: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzh(v16, 0L);
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 66: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzi(v16, zzlu.zzg(object0, v22));
                        v13 += v24;
                        break;
                    }
                    break;
                }
                case 67: {
                    if(this.zza(object0, v16, v12)) {
                        v24 = zzjr.zzf(v16, zzlu.zzh(object0, v22));
                        v13 += v24;
                    }
                    break;
                }
                case 68: {
                    if(this.zza(object0, v16, v12)) {
                        v13 += zzjr.zzc(v16, ((zzlq)unsafe1.getObject(object0, v22)), this.zzap(v12));
                    }
                }
            }
        }
        int v30 = 0;
        int v31 = v13 + zzlu.zza(this.zzur, object0);
        if(this.zzui) {
            zzkb zzkb0 = this.zzus.zzb(object0);
            for(int v32 = 0; v32 < zzkb0.zzos.zzer(); ++v32) {
                Map.Entry map$Entry0 = zzkb0.zzos.zzaw(v32);
                v30 += zzkb.zzb(((zzkd)map$Entry0.getKey()), map$Entry0.getValue());
            }
            for(Object object9: zzkb0.zzos.zzes()) {
                v30 += zzkb.zzb(((zzkd)((Map.Entry)object9).getKey()), ((Map.Entry)object9).getValue());
            }
            return v31 + v30;
        }
        return v31;
    }

    private static zzmy zzo(Object object0) {
        zzmy zzmy0 = ((zzkk)object0).zzrq;
        if(zzmy0 == zzmy.zzfa()) {
            zzmy0 = zzmy.zzfb();
            ((zzkk)object0).zzrq = zzmy0;
        }
        return zzmy0;
    }

    private final int zzp(int v, int v1) {
        return v < this.zzuf || v > this.zzug ? -1 : this.zzq(v, v1);
    }

    // This method was un-flattened
    @Override  // com.google.android.gms.internal.drive.zzmf
    public final boolean zzp(Object object0) {
        int v8;
        int v = -1;
        int v1 = 0;
        int v2 = 0;
        while(v1 < this.zzun) {
            int v3 = this.zzum[v1];
            int v4 = this.zzud[v3];
            int v5 = this.zzas(v3);
            if(this.zzuk) {
                v8 = 0;
            }
            else {
                int v6 = this.zzud[v3 + 2];
                int v7 = v6 & 0xFFFFF;
                v8 = 1 << (v6 >>> 20);
                if(v7 != v) {
                    v2 = zzlu.zzuc.getInt(object0, ((long)v7));
                    v = v7;
                }
            }
            if((0x10000000 & v5) != 0 && !this.zza(object0, v3, v2, v8)) {
                return false;
            }
            switch((0xFF00000 & v5) >>> 20) {
                case 9: 
                case 17: {
                    if(this.zza(object0, v3, v2, v8) && !zzlu.zza(object0, v5, this.zzap(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zznd.zzo(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zzmf zzmf1 = this.zzap(v3);
                        for(int v9 = 0; v9 < list0.size(); ++v9) {
                            if(!zzmf1.zzp(list0.get(v9))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    Object object1 = zznd.zzo(object0, ((long)(v5 & 0xFFFFF)));
                    Map map0 = this.zzut.zzi(object1);
                    if(!map0.isEmpty()) {
                        Object object2 = this.zzaq(v3);
                        if(this.zzut.zzm(object2).zztw.zzfj() == zznr.zzxx) {
                            zzmf zzmf0 = null;
                            Iterator iterator0 = map0.values().iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    break;
                                }
                                Object object3 = iterator0.next();
                                if(zzmf0 == null) {
                                    zzmf0 = zzmd.zzej().zzf(object3.getClass());
                                }
                                if(zzmf0.zzp(object3)) {
                                    continue;
                                }
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zza(object0, v4, v3) && !zzlu.zza(object0, v5, this.zzap(v3))) {
                        return false;
                    }
                }
            }
            ++v1;
        }
        return !this.zzui || this.zzus.zzb(object0).isInitialized();
    }

    private final int zzq(int v, int v1) {
        int v2 = this.zzud.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = this.zzud[v4];
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
}

