package com.google.android.gms.games;

import com.google.android.gms.common.Feature;

public final class zzd {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature[] zzf;

    static {
        Feature feature0 = new Feature("games_get_account_selection_intent", 1L);
        zzd.zza = feature0;
        Feature feature1 = new Feature("games_get_privacy_settings_intent", 1L);
        zzd.zzb = feature1;
        Feature feature2 = new Feature("games_load_player_force_reload", 1L);
        zzd.zzc = feature2;
        Feature feature3 = new Feature("games_load_profile_capabilities", 2L);
        zzd.zzd = feature3;
        Feature feature4 = new Feature("games_recall", 1L);
        zzd.zze = feature4;
        zzd.zzf = new Feature[]{feature0, feature1, feature2, feature3, feature4};
    }
}

