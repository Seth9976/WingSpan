package com.google.android.gms.internal.drive;

import java.io.IOException;

final class zziy {
    static int zza(int v, byte[] arr_b, int v1, int v2, zziz zziz0) throws zzkq {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    return zziy.zzb(arr_b, v1, zziz0);
                }
                case 1: {
                    return v1 + 8;
                }
                case 2: {
                    return zziy.zza(arr_b, v1, zziz0) + zziz0.zznk;
                }
                case 3: {
                    int v3 = v & -8 | 4;
                    int v4 = 0;
                    while(v1 < v2) {
                        v1 = zziy.zza(arr_b, v1, zziz0);
                        v4 = zziz0.zznk;
                        if(v4 == v3) {
                            break;
                        }
                        v1 = zziy.zza(v4, arr_b, v1, v2, zziz0);
                    }
                    if(v1 > v2 || v4 != v3) {
                        throw zzkq.zzdm();
                    }
                    return v1;
                }
                case 5: {
                    return v1 + 4;
                }
                default: {
                    throw zzkq.zzdk();
                }
            }
        }
        throw zzkq.zzdk();
    }

    static int zza(int v, byte[] arr_b, int v1, int v2, zzkp zzkp0, zziz zziz0) {
        int v3 = zziy.zza(arr_b, v1, zziz0);
        ((zzkl)zzkp0).zzam(zziz0.zznk);
        while(v3 < v2) {
            int v4 = zziy.zza(arr_b, v3, zziz0);
            if(v != zziz0.zznk) {
                break;
            }
            v3 = zziy.zza(arr_b, v4, zziz0);
            ((zzkl)zzkp0).zzam(zziz0.zznk);
        }
        return v3;
    }

    static int zza(int v, byte[] arr_b, int v1, int v2, zzmy zzmy0, zziz zziz0) throws zzkq {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    int v3 = zziy.zzb(arr_b, v1, zziz0);
                    zzmy0.zzb(v, zziz0.zznl);
                    return v3;
                }
                case 1: {
                    zzmy0.zzb(v, zziy.zzb(arr_b, v1));
                    return v1 + 8;
                }
                case 2: {
                    int v4 = zziy.zza(arr_b, v1, zziz0);
                    int v5 = zziz0.zznk;
                    if(v5 < 0) {
                        throw zzkq.zzdj();
                    }
                    if(v5 > arr_b.length - v4) {
                        throw zzkq.zzdi();
                    }
                    if(v5 == 0) {
                        zzmy0.zzb(v, zzjc.zznq);
                        return v4;
                    }
                    zzmy0.zzb(v, zzjc.zzb(arr_b, v4, v5));
                    return v4 + v5;
                }
                case 3: {
                    zzmy zzmy1 = zzmy.zzfb();
                    int v6 = v & -8 | 4;
                    int v7 = 0;
                    while(v1 < v2) {
                        int v8 = zziy.zza(arr_b, v1, zziz0);
                        int v9 = zziz0.zznk;
                        v7 = v9;
                        if(v9 == v6) {
                            v1 = v8;
                            if(true) {
                                break;
                            }
                        }
                        else {
                            int v10 = zziy.zza(v7, arr_b, v8, v2, zzmy1, zziz0);
                            v7 = v9;
                            v1 = v10;
                        }
                    }
                    if(v1 > v2 || v7 != v6) {
                        throw zzkq.zzdm();
                    }
                    zzmy0.zzb(v, zzmy1);
                    return v1;
                }
                case 5: {
                    zzmy0.zzb(v, zziy.zza(arr_b, v1));
                    return v1 + 4;
                }
                default: {
                    throw zzkq.zzdk();
                }
            }
        }
        throw zzkq.zzdk();
    }

    static int zza(int v, byte[] arr_b, int v1, zziz zziz0) {
        int v2 = arr_b[v1];
        if(v2 >= 0) {
            zziz0.zznk = v & 0x7F | v2 << 7;
            return v1 + 1;
        }
        int v3 = v & 0x7F | (v2 & 0x7F) << 7;
        int v4 = arr_b[v1 + 1];
        if(v4 >= 0) {
            zziz0.zznk = v3 | v4 << 14;
            return v1 + 2;
        }
        int v5 = v3 | (v4 & 0x7F) << 14;
        int v6 = arr_b[v1 + 2];
        if(v6 >= 0) {
            zziz0.zznk = v5 | v6 << 21;
            return v1 + 3;
        }
        int v7 = v5 | (v6 & 0x7F) << 21;
        int v8 = v1 + 4;
        int v9 = arr_b[v1 + 3];
        if(v9 >= 0) {
            zziz0.zznk = v7 | v9 << 28;
            return v8;
        }
        while(arr_b[v8] < 0) {
            ++v8;
        }
        zziz0.zznk = v7 | (v9 & 0x7F) << 28;
        return v8 + 1;
    }

    static int zza(zzmf zzmf0, int v, byte[] arr_b, int v1, int v2, zzkp zzkp0, zziz zziz0) throws IOException {
        int v3 = zziy.zza(zzmf0, arr_b, v1, v2, zziz0);
        zzkp0.add(zziz0.zznm);
        while(v3 < v2) {
            int v4 = zziy.zza(arr_b, v3, zziz0);
            if(v != zziz0.zznk) {
                break;
            }
            v3 = zziy.zza(zzmf0, arr_b, v4, v2, zziz0);
            zzkp0.add(zziz0.zznm);
        }
        return v3;
    }

    static int zza(zzmf zzmf0, byte[] arr_b, int v, int v1, int v2, zziz zziz0) throws IOException {
        Object object0 = ((zzlu)zzmf0).newInstance();
        int v3 = ((zzlu)zzmf0).zza(object0, arr_b, v, v1, v2, zziz0);
        ((zzlu)zzmf0).zzd(object0);
        zziz0.zznm = object0;
        return v3;
    }

    static int zza(zzmf zzmf0, byte[] arr_b, int v, int v1, zziz zziz0) throws IOException {
        int v2 = v + 1;
        int v3 = arr_b[v];
        if(v3 < 0) {
            v2 = zziy.zza(v3, arr_b, v2, zziz0);
            v3 = zziz0.zznk;
        }
        if(v3 < 0 || v3 > v1 - v2) {
            throw zzkq.zzdi();
        }
        Object object0 = zzmf0.newInstance();
        int v4 = v3 + v2;
        zzmf0.zza(object0, arr_b, v2, v4, zziz0);
        zzmf0.zzd(object0);
        zziz0.zznm = object0;
        return v4;
    }

    static int zza(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0xFF) << 24 | (arr_b[v] & 0xFF | (arr_b[v + 1] & 0xFF) << 8 | (arr_b[v + 2] & 0xFF) << 16);
    }

    static int zza(byte[] arr_b, int v, zziz zziz0) {
        int v1 = arr_b[v];
        if(v1 >= 0) {
            zziz0.zznk = v1;
            return v + 1;
        }
        return zziy.zza(v1, arr_b, v + 1, zziz0);
    }

    static int zza(byte[] arr_b, int v, zzkp zzkp0, zziz zziz0) throws IOException {
        int v1 = zziy.zza(arr_b, v, zziz0);
        int v2 = zziz0.zznk + v1;
        while(v1 < v2) {
            v1 = zziy.zza(arr_b, v1, zziz0);
            ((zzkl)zzkp0).zzam(zziz0.zznk);
        }
        if(v1 != v2) {
            throw zzkq.zzdi();
        }
        return v1;
    }

    static int zzb(byte[] arr_b, int v, zziz zziz0) {
        long v1 = (long)arr_b[v];
        if(v1 >= 0L) {
            zziz0.zznl = v1;
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
            v3 = v6;
            ++v2;
        }
        zziz0.zznl = v4;
        return v2;
    }

    static long zzb(byte[] arr_b, int v) {
        return (((long)arr_b[v + 7]) & 0xFFL) << 56 | (((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30);
    }

    static double zzc(byte[] arr_b, int v) {
        return Double.longBitsToDouble(zziy.zzb(arr_b, v));
    }

    static int zzc(byte[] arr_b, int v, zziz zziz0) throws zzkq {
        int v1 = zziy.zza(arr_b, v, zziz0);
        int v2 = zziz0.zznk;
        if(v2 < 0) {
            throw zzkq.zzdj();
        }
        if(v2 == 0) {
            zziz0.zznm = "";
            return v1;
        }
        zziz0.zznm = new String(arr_b, v1, v2, zzkm.UTF_8);
        return v1 + v2;
    }

    static float zzd(byte[] arr_b, int v) {
        return Float.intBitsToFloat(zziy.zza(arr_b, v));
    }

    static int zzd(byte[] arr_b, int v, zziz zziz0) throws zzkq {
        int v1 = zziy.zza(arr_b, v, zziz0);
        int v2 = zziz0.zznk;
        if(v2 < 0) {
            throw zzkq.zzdj();
        }
        if(v2 == 0) {
            zziz0.zznm = "";
            return v1;
        }
        zziz0.zznm = zznf.zzg(arr_b, v1, v2);
        return v1 + v2;
    }

    static int zze(byte[] arr_b, int v, zziz zziz0) throws zzkq {
        int v1 = zziy.zza(arr_b, v, zziz0);
        int v2 = zziz0.zznk;
        if(v2 < 0) {
            throw zzkq.zzdj();
        }
        if(v2 > arr_b.length - v1) {
            throw zzkq.zzdi();
        }
        if(v2 == 0) {
            zziz0.zznm = zzjc.zznq;
            return v1;
        }
        zziz0.zznm = zzjc.zzb(arr_b, v1, v2);
        return v1 + v2;
    }
}

