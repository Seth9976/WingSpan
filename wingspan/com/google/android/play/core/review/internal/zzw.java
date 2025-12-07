package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;

public final class zzw {
    private static final zzi zza;

    static {
        zzw.zza = new zzi("PhoneskyVerificationUtils");
    }

    public static boolean zza(Context context0) {
        Signature[] arr_signature;
        try {
            if(context0.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                arr_signature = context0.getPackageManager().getPackageInfo("com.android.vending", 0x40).signatures;
                if(arr_signature == null || arr_signature.length == 0) {
                    goto label_10;
                }
                else {
                    goto label_3;
                }
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    label_3:
        for(int v = 0; v < arr_signature.length; ++v) {
            String s = zzv.zza(arr_signature[v].toByteArray());
            if("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(s) || (Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(s)) {
                return true;
            label_10:
                zzw.zza.zze("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                break;
            }
        }
        try {
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

