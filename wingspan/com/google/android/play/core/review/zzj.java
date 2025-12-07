package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.review.internal.zzi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzj {
    private static final Set zza;
    private static final Map zzb;
    private static final zzi zzc;

    static {
        zzj.zza = new HashSet(Arrays.asList(new String[]{"native", "unity"}));
        zzj.zzb = new HashMap();
        zzj.zzc = new zzi("PlayCoreVersion");
    }

    public static Bundle zza() {
        Bundle bundle0 = new Bundle();
        Map map0 = zzj.zzb();
        bundle0.putInt("playcore_version_code", ((int)(((Integer)map0.get("java")))));
        if(map0.containsKey("native")) {
            bundle0.putInt("playcore_native_version", ((int)(((Integer)map0.get("native")))));
        }
        if(map0.containsKey("unity")) {
            bundle0.putInt("playcore_unity_version", ((int)(((Integer)map0.get("unity")))));
        }
        return bundle0;
    }

    public static Map zzb() {
        synchronized(zzj.class) {
            zzj.zzb.put("java", 11004);
            return zzj.zzb;
        }
    }
}

