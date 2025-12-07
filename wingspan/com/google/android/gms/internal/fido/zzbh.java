package com.google.android.gms.internal.fido;

import java.math.RoundingMode;

public final class zzbh {
    public static int zza(int v, int v1, RoundingMode roundingMode0) {
        roundingMode0.getClass();
        if(v1 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int v2 = v / v1;
        int v3 = v - v1 * v2;
        if(v3 == 0) {
            return v2;
        }
        boolean z = true;
        int v4 = (v ^ v1) >> 0x1F | 1;
        switch(zzbg.zza[roundingMode0.ordinal()]) {
            case 1: {
                zzbi.zza(false);
                return v2;
            }
            case 2: {
                return v2;
            }
            case 3: {
                if(v4 >= 0) {
                    return v2;
                }
                break;
            }
            case 4: {
                return v2 + v4;
            }
            case 5: {
                return v4 <= 0 ? v2 : v2 + v4;
            }
            case 6: 
            case 7: 
            case 8: {
                int v5 = Math.abs(v3) * 2 - Math.abs(v1);
                if(v5 == 0) {
                    if(roundingMode0 == RoundingMode.HALF_UP || ((roundingMode0 == RoundingMode.HALF_EVEN ? 1 : 0) & (v2 & 1)) != 0) {
                        return v2 + v4;
                    }
                }
                else if(v5 > 0) {
                    return v2 + v4;
                }
                z = false;
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return z ? v2 + v4 : v2;
    }

    public static int zzb(int v, RoundingMode roundingMode0) {
        if(v <= 0) {
            throw new IllegalArgumentException("x (0) must be > 0");
        }
        switch(zzbg.zza[roundingMode0.ordinal()]) {
            case 1: {
                zzbi.zza((v - 1 & v) == 0);
                break;
            }
            case 2: 
            case 3: {
                break;
            }
            case 4: 
            case 5: {
                return 0x20 - Integer.numberOfLeadingZeros(v - 1);
            }
            case 6: 
            case 7: 
            case 8: {
                int v1 = Integer.numberOfLeadingZeros(v);
                return 0x1F - v1 + ((0xB504F333 >>> v1) - v >>> 0x1F);
            }
            default: {
                throw new AssertionError();
            }
        }
        return 0x1F - Integer.numberOfLeadingZeros(v);
    }
}

