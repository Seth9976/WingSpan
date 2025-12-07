package com.google.android.gms.internal.play_billing;

final class zzgb {
    public static final int zza;
    private static final zzfy zzb;

    static {
        zzgb.zzb = new zzfz();
    }

    static int zza(byte[] arr_b, int v, int v1) {
        int v2 = arr_b[v - 1];
        switch(v1 - v) {
            case 0: {
                return v2 > -12 ? -1 : v2;
            }
            case 1: {
                int v3 = arr_b[v];
                return v2 > -12 || v3 > -65 ? -1 : v3 << 8 ^ v2;
            }
            case 2: {
                int v4 = arr_b[v];
                int v5 = arr_b[v + 1];
                return v2 > -12 || v4 > -65 || v5 > -65 ? -1 : v5 << 16 ^ (v4 << 8 ^ v2);
            }
            default: {
                throw new AssertionError();
            }
        }
    }

    static int zzb(String s, byte[] arr_b, int v, int v1) {
        int v2 = s.length();
        int v3;
        for(v3 = 0; true; ++v3) {
            int v4 = v + v1;
            if(v3 >= v2) {
                break;
            }
            int v5 = v3 + v;
            if(v5 >= v4) {
                break;
            }
            int v6 = s.charAt(v3);
            if(v6 >= 0x80) {
                break;
            }
            arr_b[v5] = (byte)v6;
        }
        if(v3 == v2) {
            return v + v2;
        }
        int v7 = v + v3;
        while(v3 < v2) {
            int v8 = s.charAt(v3);
            if(v8 < 0x80 && v7 < v4) {
                arr_b[v7] = (byte)v8;
                ++v7;
            }
            else if(v8 < 0x800 && v7 <= v4 - 2) {
                arr_b[v7] = (byte)(v8 >>> 6 | 960);
                arr_b[v7 + 1] = (byte)(v8 & 0x3F | 0x80);
                v7 += 2;
            }
            else if(v8 >= 0xD800 && v8 <= 0xDFFF || v7 > v4 - 3) {
                if(v7 > v4 - 4) {
                    goto label_47;
                }
                if(v3 + 1 == s.length()) {
                    throw new zzga(v3 - 1, v2);
                }
                int v9 = s.charAt(v3 + 1);
                if(!Character.isSurrogatePair(((char)v8), ((char)v9))) {
                    goto label_45;
                }
                int v10 = v7 + 2;
                int v11 = Character.toCodePoint(((char)v8), ((char)v9));
                arr_b[v7] = (byte)(v11 >>> 18 | 0xF0);
                arr_b[v7 + 1] = (byte)(v11 >>> 12 & 0x3F | 0x80);
                arr_b[v10] = (byte)(v11 >>> 6 & 0x3F | 0x80);
                v7 = v10 + 2;
                arr_b[v10 + 1] = (byte)(v11 & 0x3F | 0x80);
                ++v3;
            }
            else {
                arr_b[v7] = (byte)(v8 >>> 12 | 480);
                arr_b[v7 + 1] = (byte)(v8 >>> 6 & 0x3F | 0x80);
                arr_b[v7 + 2] = (byte)(v8 & 0x3F | 0x80);
                v7 += 3;
            }
            ++v3;
            continue;
        label_45:
            ++v3;
            throw new zzga(v3 - 1, v2);
        label_47:
            if(!(v8 >= 0xD800 && v8 <= 0xDFFF && (v3 + 1 == s.length() || !Character.isSurrogatePair(((char)v8), s.charAt(v3 + 1))))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char)v8) + " at index " + v7);
            }
            throw new zzga(v3, v2);
        }
        return v7;
    }

    static int zzc(String s) {
        int v = s.length();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < v && s.charAt(v2) < 0x80; ++v2) {
        }
        int v3 = v;
        while(v2 < v) {
            int v4 = s.charAt(v2);
            if(v4 < 0x800) {
                v3 += 0x7F - v4 >>> 0x1F;
                ++v2;
            }
            else {
                int v5 = s.length();
                while(v2 < v5) {
                    int v6 = s.charAt(v2);
                    if(v6 < 0x800) {
                        v1 += 0x7F - v6 >>> 0x1F;
                    }
                    else {
                        v1 += 2;
                        if(v6 >= 0xD800 && v6 <= 0xDFFF) {
                            if(Character.codePointAt(s, v2) < 0x10000) {
                                throw new zzga(v2, v5);
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

    static boolean zzd(byte[] arr_b) {
        return zzgb.zzb.zzb(arr_b, 0, arr_b.length);
    }

    static boolean zze(byte[] arr_b, int v, int v1) {
        return zzgb.zzb.zzb(arr_b, v, v1);
    }
}

