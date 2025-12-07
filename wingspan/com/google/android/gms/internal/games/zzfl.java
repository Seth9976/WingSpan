package com.google.android.gms.internal.games;

public final class zzfl {
    public static String zza(int v) {
        switch(v) {
            case 0: {
                return "DAILY";
            }
            case 1: {
                return "WEEKLY";
            }
            case 2: {
                return "ALL_TIME";
            }
            default: {
                throw new IllegalArgumentException("Unknown time span " + v);
            }
        }
    }
}

