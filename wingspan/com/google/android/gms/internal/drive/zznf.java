package com.google.android.gms.internal.drive;

final class zznf {
    private static final zznh zzwt;

    // 去混淆评级： 低(45)
    static {
        zznf.zzwt = new zznk();
    }

    static int zza(CharSequence charSequence0) {
        int v = charSequence0.length();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < v && charSequence0.charAt(v2) < 0x80; ++v2) {
        }
        int v3 = v;
        while(v2 < v) {
            int v4 = charSequence0.charAt(v2);
            if(v4 < 0x800) {
                v3 += 0x7F - v4 >>> 0x1F;
                ++v2;
            }
            else {
                int v5 = charSequence0.length();
                while(v2 < v5) {
                    int v6 = charSequence0.charAt(v2);
                    if(v6 < 0x800) {
                        v1 += 0x7F - v6 >>> 0x1F;
                    }
                    else {
                        v1 += 2;
                        if(0xD800 <= v6 && v6 <= 0xDFFF) {
                            if(Character.codePointAt(charSequence0, v2) < 0x10000) {
                                throw new zznj(v2, v5);
                            }
                            ++v2;
                        }
                    }
                    ++v2;
                }
                v3 += v1;
                if(true) {
                    break;
                }
            }
        }
        if(v3 < v) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long)v3) + 0x100000000L));
        }
        return v3;
    }

    static int zza(CharSequence charSequence0, byte[] arr_b, int v, int v1) {
        return zznf.zzwt.zzb(charSequence0, arr_b, v, v1);
    }

    private static int zzay(int v) {
        return v <= -12 ? v : -1;
    }

    private static int zzc(int v, int v1, int v2) {
        return v > -12 || v1 > -65 || v2 > -65 ? -1 : v ^ v1 << 8 ^ v2 << 16;
    }

    public static boolean zzd(byte[] arr_b) {
        return zznf.zzwt.zze(arr_b, 0, arr_b.length);
    }

    public static boolean zze(byte[] arr_b, int v, int v1) {
        return zznf.zzwt.zze(arr_b, v, v1);
    }

    private static int zzf(byte[] arr_b, int v, int v1) {
        int v2 = arr_b[v - 1];
        switch(v1 - v) {
            case 0: {
                return zznf.zzay(v2);
            }
            case 1: {
                return zznf.zzr(v2, arr_b[v]);
            }
            case 2: {
                return zznf.zzc(v2, arr_b[v], arr_b[v + 1]);
            }
            default: {
                throw new AssertionError();
            }
        }
    }

    static String zzg(byte[] arr_b, int v, int v1) throws zzkq {
        return zznf.zzwt.zzg(arr_b, v, v1);
    }

    private static int zzr(int v, int v1) {
        return v > -12 || v1 > -65 ? -1 : v ^ v1 << 8;
    }
}

