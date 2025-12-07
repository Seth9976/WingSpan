package com.google.android.gms.internal.games;

import com.google.android.gms.common.internal.GmsLogger;

public final class zzft {
    private static final GmsLogger zza;

    static {
        zzft.zza = new GmsLogger("Games");
    }

    public static void zza(String s, String s1) {
        String s2 = zzft.zzf(s);
        zzft.zza.e(s2, s1);
    }

    public static void zzb(String s, String s1, Throwable throwable0) {
        zzft.zza.e("PlayGamesServices[GamesGmsClientImpl]", "Is player signed out?", throwable0);
    }

    public static void zzc(String s, String s1, Throwable throwable0) {
        zzft.zza.i("PlayGamesServices[SnapshotContentsEntity]", "Failed to write snapshot data", throwable0);
    }

    public static void zzd(String s, String s1) {
        zzft.zza.w(zzft.zzf(s), s1);
    }

    public static void zze(String s, String s1, Throwable throwable0) {
        zzft.zza.w(zzft.zzf(s), s1, throwable0);
    }

    private static String zzf(String s) [...] // 潜在的解密器
}

