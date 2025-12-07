package com.google.android.gms.internal.drive;

final class zznk extends zznh {
    private static int zza(byte[] arr_b, int v, long v1, int v2) {
        switch(v2) {
            case 0: {
                return zznf.zzay(v);
            }
            case 1: {
                return zznf.zzr(v, zznd.zza(arr_b, v1));
            }
            case 2: {
                return zznf.zzc(v, zznd.zza(arr_b, v1), zznd.zza(arr_b, v1 + 1L));
            }
            default: {
                throw new AssertionError();
            }
        }
    }

    @Override  // com.google.android.gms.internal.drive.zznh
    final int zzb(int v, byte[] arr_b, int v1, int v2) {
        int v8;
        int v4;
        if((v1 | v2 | arr_b.length - v2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", ((int)arr_b.length), v1, v2));
        }
        int v3 = (int)(((long)v2) - ((long)v1));
        if(v3 < 16) {
            v4 = 0;
        }
        else {
            v4 = 0;
            for(long v5 = (long)v1; true; ++v5) {
                if(v4 >= v3) {
                    v4 = v3;
                    break;
                }
                if(zznd.zza(arr_b, v5) < 0) {
                    break;
                }
                ++v4;
            }
        }
        int v6 = v3 - v4;
        long v7 = ((long)v1) + ((long)v4);
        while(true) {
            while(true) {
            label_16:
                v8 = 0;
                while(v6 > 0) {
                    int v9 = zznd.zza(arr_b, v7);
                    if(v9 >= 0) {
                        --v6;
                        v8 = v9;
                        ++v7;
                    }
                    else {
                        v8 = v9;
                        ++v7;
                        if(true) {
                            break;
                        }
                    }
                }
                if(v6 == 0) {
                    return 0;
                }
                if(v8 < 0xFFFFFFE0) {
                    if(v6 - 1 == 0) {
                        return v8;
                    }
                    v6 -= 2;
                    if(v8 >= -62 && zznd.zza(arr_b, v7) <= -65) {
                        ++v7;
                        continue;
                    }
                    return -1;
                }
                if(v8 < -16) {
                    if(v6 - 1 < 2) {
                        return zznk.zza(arr_b, v8, v7, v6 - 1);
                    }
                    v6 -= 3;
                    long v10 = v7 + 1L;
                    int v11 = zznd.zza(arr_b, v7);
                    if(v11 <= -65 && (v8 != 0xFFFFFFE0 || v11 >= 0xFFFFFFA0) && (v8 != -19 || v11 < 0xFFFFFFA0)) {
                        v7 = v10 + 1L;
                        if(zznd.zza(arr_b, v10) <= -65) {
                            continue;
                        }
                    }
                    return -1;
                }
                break;
            }
            if(v6 - 1 < 3) {
                return zznk.zza(arr_b, v8, v7, v6 - 1);
            }
            v6 -= 4;
            int v12 = zznd.zza(arr_b, v7);
            if(v12 > -65 || (v8 << 28) + (v12 + 0x70) >> 30 != 0) {
                break;
            }
            long v13 = v7 + 2L;
            if(zznd.zza(arr_b, v7 + 1L) > -65) {
                break;
            }
            v7 = v13 + 1L;
            if(zznd.zza(arr_b, v13) <= -65) {
                goto label_16;
            }
            break;
        }
        return -1;
    }

    @Override  // com.google.android.gms.internal.drive.zznh
    final int zzb(CharSequence charSequence0, byte[] arr_b, int v, int v1) {
        long v8;
        long v2 = (long)v;
        long v3 = ((long)v1) + v2;
        int v4 = charSequence0.length();
        if(v4 > v1 || arr_b.length - v1 < v) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence0.charAt(v4 - 1) + " at index " + (v + v1));
        }
        int v5 = 0;
        while(v5 < v4) {
            int v6 = charSequence0.charAt(v5);
            if(v6 >= 0x80) {
                break;
            }
            zznd.zza(arr_b, v2, ((byte)v6));
            ++v5;
            ++v2;
        }
        if(v5 == v4) {
            return (int)v2;
        }
        while(v5 < v4) {
            int v7 = charSequence0.charAt(v5);
            if(v7 < 0x80 && v2 < v3) {
                zznd.zza(arr_b, v2, ((byte)v7));
                v8 = v2 + 1L;
            }
            else if(v7 < 0x800 && v2 <= v3 - 2L) {
                zznd.zza(arr_b, v2, ((byte)(v7 >>> 6 | 960)));
                zznd.zza(arr_b, v2 + 1L, ((byte)(v7 & 0x3F | 0x80)));
                v8 = v2 + 2L;
            }
            else if(v7 >= 0xD800 && 0xDFFF >= v7 || v2 > v3 - 3L) {
                if(v2 > v3 - 4L) {
                    goto label_47;
                }
                if(v5 + 1 == v4) {
                    throw new zznj(v5 - 1, v4);
                }
                int v9 = charSequence0.charAt(v5 + 1);
                if(!Character.isSurrogatePair(((char)v7), ((char)v9))) {
                    goto label_45;
                }
                int v10 = Character.toCodePoint(((char)v7), ((char)v9));
                zznd.zza(arr_b, v2, ((byte)(v10 >>> 18 | 0xF0)));
                zznd.zza(arr_b, v2 + 1L, ((byte)(v10 >>> 12 & 0x3F | 0x80)));
                zznd.zza(arr_b, v2 + 2L, ((byte)(v10 >>> 6 & 0x3F | 0x80)));
                v8 = v2 + 4L;
                zznd.zza(arr_b, v2 + 3L, ((byte)(v10 & 0x3F | 0x80)));
                ++v5;
            }
            else {
                zznd.zza(arr_b, v2, ((byte)(v7 >>> 12 | 480)));
                zznd.zza(arr_b, v2 + 1L, ((byte)(v7 >>> 6 & 0x3F | 0x80)));
                zznd.zza(arr_b, v2 + 2L, ((byte)(v7 & 0x3F | 0x80)));
                v8 = v2 + 3L;
            }
            ++v5;
            v2 = v8;
            continue;
        label_45:
            ++v5;
            throw new zznj(v5 - 1, v4);
        label_47:
            if(!(0xD800 <= v7 && v7 <= 0xDFFF && (v5 + 1 == v4 || !Character.isSurrogatePair(((char)v7), charSequence0.charAt(v5 + 1))))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char)v7) + " at index " + v2);
            }
            throw new zznj(v5, v4);
        }
        return (int)v2;
    }

    @Override  // com.google.android.gms.internal.drive.zznh
    final String zzg(byte[] arr_b, int v, int v1) throws zzkq {
        if((v | v1 | arr_b.length - v - v1) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v, v1));
        }
        int v2 = v + v1;
        char[] arr_c = new char[v1];
        int v3;
        for(v3 = 0; v < v2; ++v3) {
            int v4 = zznd.zza(arr_b, ((long)v));
            if(!zzng.zzd(((byte)v4))) {
                break;
            }
            ++v;
            zzng.zza(((byte)v4), arr_c, v3);
        }
        int v5 = v3;
        while(v < v2) {
            int v6 = v + 1;
            int v7 = zznd.zza(arr_b, ((long)v));
            if(zzng.zzd(((byte)v7))) {
                int v8 = v5 + 1;
                zzng.zza(((byte)v7), arr_c, v5);
                while(v6 < v2) {
                    int v9 = zznd.zza(arr_b, ((long)v6));
                    if(!zzng.zzd(((byte)v9))) {
                        break;
                    }
                    ++v6;
                    zzng.zza(((byte)v9), arr_c, v8);
                    ++v8;
                }
                v = v6;
                v5 = v8;
                continue;
            }
            if(zzng.zze(((byte)v7))) {
                if(v6 < v2) {
                    zzng.zza(((byte)v7), zznd.zza(arr_b, ((long)v6)), arr_c, v5);
                    v = v6 + 1;
                    ++v5;
                    continue;
                }
            }
            else if(!zzng.zzf(((byte)v7))) {
                if(v6 < v2 - 2) {
                    zzng.zza(((byte)v7), zznd.zza(arr_b, ((long)v6)), zznd.zza(arr_b, ((long)(v6 + 1))), zznd.zza(arr_b, ((long)(v6 + 2))), arr_c, v5);
                    v = v6 + 3;
                    v5 += 2;
                    continue;
                }
            }
            else if(v6 < v2 - 1) {
                zzng.zza(((byte)v7), zznd.zza(arr_b, ((long)v6)), zznd.zza(arr_b, ((long)(v6 + 1))), arr_c, v5);
                v = v6 + 2;
                ++v5;
                continue;
            }
            throw zzkq.zzdn();
        }
        return new String(arr_c, 0, v5);
    }
}

