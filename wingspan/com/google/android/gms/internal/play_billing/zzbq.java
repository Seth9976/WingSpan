package com.google.android.gms.internal.play_billing;

import java.io.IOException;

final class zzbq {
    static int zza(byte[] arr_b, int v, zzbp zzbp0) throws zzdn {
        int v1 = zzbq.zzh(arr_b, v, zzbp0);
        int v2 = zzbp0.zza;
        if(v2 < 0) {
            throw zzdn.zzd();
        }
        if(v2 > arr_b.length - v1) {
            throw zzdn.zzg();
        }
        if(v2 == 0) {
            zzbp0.zzc = zzcc.zzb;
            return v1;
        }
        zzbp0.zzc = zzcc.zzl(arr_b, v1, v2);
        return v1 + v2;
    }

    static int zzb(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0xFF) << 24 | ((arr_b[v + 1] & 0xFF) << 8 | arr_b[v] & 0xFF | (arr_b[v + 2] & 0xFF) << 16);
    }

    static int zzc(zzev zzev0, byte[] arr_b, int v, int v1, int v2, zzbp zzbp0) throws IOException {
        Object object0 = zzev0.zze();
        int v3 = zzbq.zzl(object0, zzev0, arr_b, v, v1, v2, zzbp0);
        zzev0.zzf(object0);
        zzbp0.zzc = object0;
        return v3;
    }

    static int zzd(zzev zzev0, byte[] arr_b, int v, int v1, zzbp zzbp0) throws IOException {
        Object object0 = zzev0.zze();
        int v2 = zzbq.zzm(object0, zzev0, arr_b, v, v1, zzbp0);
        zzev0.zzf(object0);
        zzbp0.zzc = object0;
        return v2;
    }

    static int zze(zzev zzev0, int v, byte[] arr_b, int v1, int v2, zzdk zzdk0, zzbp zzbp0) throws IOException {
        int v3 = zzbq.zzd(zzev0, arr_b, v1, v2, zzbp0);
        zzdk0.add(zzbp0.zzc);
        while(v3 < v2) {
            int v4 = zzbq.zzh(arr_b, v3, zzbp0);
            if(v != zzbp0.zza) {
                break;
            }
            v3 = zzbq.zzd(zzev0, arr_b, v4, v2, zzbp0);
            zzdk0.add(zzbp0.zzc);
        }
        return v3;
    }

    static int zzf(byte[] arr_b, int v, zzdk zzdk0, zzbp zzbp0) throws IOException {
        int v1 = zzbq.zzh(arr_b, v, zzbp0);
        int v2 = zzbp0.zza + v1;
        while(v1 < v2) {
            v1 = zzbq.zzh(arr_b, v1, zzbp0);
            ((zzde)zzdk0).zzh(zzbp0.zza);
        }
        if(v1 != v2) {
            throw zzdn.zzg();
        }
        return v1;
    }

    static int zzg(int v, byte[] arr_b, int v1, int v2, zzfn zzfn0, zzbp zzbp0) throws zzdn {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    int v3 = zzbq.zzk(arr_b, v1, zzbp0);
                    zzfn0.zzj(v, zzbp0.zzb);
                    return v3;
                }
                case 1: {
                    zzfn0.zzj(v, zzbq.zzn(arr_b, v1));
                    return v1 + 8;
                }
                case 2: {
                    int v4 = zzbq.zzh(arr_b, v1, zzbp0);
                    int v5 = zzbp0.zza;
                    if(v5 < 0) {
                        throw zzdn.zzd();
                    }
                    if(v5 > arr_b.length - v4) {
                        throw zzdn.zzg();
                    }
                    if(v5 == 0) {
                        zzfn0.zzj(v, zzcc.zzb);
                        return v4;
                    }
                    zzfn0.zzj(v, zzcc.zzl(arr_b, v4, v5));
                    return v4 + v5;
                }
                case 3: {
                    int v6 = v & -8 | 4;
                    zzfn zzfn1 = zzfn.zzf();
                    int v7 = 0;
                    while(v1 < v2) {
                        int v8 = zzbq.zzh(arr_b, v1, zzbp0);
                        int v9 = zzbp0.zza;
                        v7 = v9;
                        if(v9 == v6) {
                            v1 = v8;
                            if(true) {
                                break;
                            }
                        }
                        else {
                            int v10 = zzbq.zzg(v7, arr_b, v8, v2, zzfn1, zzbp0);
                            v7 = v9;
                            v1 = v10;
                        }
                    }
                    if(v1 > v2 || v7 != v6) {
                        throw zzdn.zze();
                    }
                    zzfn0.zzj(v, zzfn1);
                    return v1;
                }
                case 5: {
                    zzfn0.zzj(v, zzbq.zzb(arr_b, v1));
                    return v1 + 4;
                }
                default: {
                    throw zzdn.zzb();
                }
            }
        }
        throw zzdn.zzb();
    }

    static int zzh(byte[] arr_b, int v, zzbp zzbp0) {
        int v1 = arr_b[v];
        if(v1 >= 0) {
            zzbp0.zza = v1;
            return v + 1;
        }
        return zzbq.zzi(v1, arr_b, v + 1, zzbp0);
    }

    static int zzi(int v, byte[] arr_b, int v1, zzbp zzbp0) {
        int v2 = arr_b[v1];
        if(v2 >= 0) {
            zzbp0.zza = v & 0x7F | v2 << 7;
            return v1 + 1;
        }
        int v3 = v & 0x7F | (v2 & 0x7F) << 7;
        int v4 = arr_b[v1 + 1];
        if(v4 >= 0) {
            zzbp0.zza = v3 | v4 << 14;
            return v1 + 2;
        }
        int v5 = v3 | (v4 & 0x7F) << 14;
        int v6 = arr_b[v1 + 2];
        if(v6 >= 0) {
            zzbp0.zza = v5 | v6 << 21;
            return v1 + 3;
        }
        int v7 = v5 | (v6 & 0x7F) << 21;
        int v8 = v1 + 4;
        int v9 = arr_b[v1 + 3];
        if(v9 >= 0) {
            zzbp0.zza = v7 | v9 << 28;
            return v8;
        }
        while(arr_b[v8] < 0) {
            ++v8;
        }
        zzbp0.zza = v7 | (v9 & 0x7F) << 28;
        return v8 + 1;
    }

    static int zzj(int v, byte[] arr_b, int v1, int v2, zzdk zzdk0, zzbp zzbp0) {
        int v3 = zzbq.zzh(arr_b, v1, zzbp0);
        ((zzde)zzdk0).zzh(zzbp0.zza);
        while(v3 < v2) {
            int v4 = zzbq.zzh(arr_b, v3, zzbp0);
            if(v != zzbp0.zza) {
                break;
            }
            v3 = zzbq.zzh(arr_b, v4, zzbp0);
            ((zzde)zzdk0).zzh(zzbp0.zza);
        }
        return v3;
    }

    static int zzk(byte[] arr_b, int v, zzbp zzbp0) {
        long v1 = (long)arr_b[v];
        if(Long.compare(v1, 0L) >= 0) {
            zzbp0.zzb = v1;
            return v + 1;
        }
        int v2 = v + 2;
        int v3 = arr_b[v + 1];
        long v4 = v1 & 0x7FL | ((long)(v3 & 0x7F)) << 7;
        int v5 = 7;
        while(v3 < 0) {
            int v6 = arr_b[v2];
            v5 += 7;
            v4 |= ((long)(v6 & 0x7F)) << v5;
            ++v2;
            v3 = v6;
        }
        zzbp0.zzb = v4;
        return v2;
    }

    static int zzl(Object object0, zzev zzev0, byte[] arr_b, int v, int v1, int v2, zzbp zzbp0) throws IOException {
        int v3 = ((zzen)zzev0).zzc(object0, arr_b, v, v1, v2, zzbp0);
        zzbp0.zzc = object0;
        return v3;
    }

    static int zzm(Object object0, zzev zzev0, byte[] arr_b, int v, int v1, zzbp zzbp0) throws IOException {
        int v2 = v + 1;
        int v3 = arr_b[v];
        if(v3 < 0) {
            v2 = zzbq.zzi(v3, arr_b, v2, zzbp0);
            v3 = zzbp0.zza;
        }
        if(v3 < 0 || v3 > v1 - v2) {
            throw zzdn.zzg();
        }
        int v4 = v3 + v2;
        zzev0.zzh(object0, arr_b, v2, v4, zzbp0);
        zzbp0.zzc = object0;
        return v4;
    }

    static long zzn(byte[] arr_b, int v) {
        return ((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30 | (((long)arr_b[v + 7]) & 0xFFL) << 56;
    }
}

