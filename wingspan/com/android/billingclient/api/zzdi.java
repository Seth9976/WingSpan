package com.android.billingclient.api;

import android.content.Context;

final class zzdi {
    private static boolean zza;

    static {
    }

    static boolean zza(Context context0) {
        synchronized(zzdi.class) {
            if(zzdi.zza) {
                return false;
            }
            zzdi.zza = true;
        }
        return false;
    }
}

