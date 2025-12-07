package com.google.android.play.core.review.model;

import java.util.HashMap;
import java.util.Map;

public final class zza {
    private static final Map zza;
    private static final Map zzb;

    static {
        HashMap hashMap0 = new HashMap();
        zza.zza = hashMap0;
        HashMap hashMap1 = new HashMap();
        zza.zzb = hashMap1;
        hashMap0.put(-1, "The Play Store app is either not installed or not the official version.");
        hashMap0.put(-2, "Call first requestReviewFlow to get the ReviewInfo.");
        hashMap0.put(-100, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        hashMap1.put(-1, "PLAY_STORE_NOT_FOUND");
        hashMap1.put(-2, "INVALID_REQUEST");
        hashMap1.put(-100, "INTERNAL_ERROR");
    }

    public static String zza(int v) {
        Integer integer0 = v;
        return zza.zza.containsKey(integer0) ? ((String)zza.zza.get(integer0)) + " (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#" + ((String)zza.zzb.get(integer0)) + ")" : "";
    }
}

