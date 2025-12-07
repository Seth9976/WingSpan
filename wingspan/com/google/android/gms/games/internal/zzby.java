package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

final class zzby implements UpdateAchievementResult {
    private final Status zza;
    private final String zzb;

    zzby(int v, String s) {
        this.zza = GamesStatusCodes.zza(v);
        this.zzb = s;
    }

    @Override  // com.google.android.gms.games.achievement.Achievements$UpdateAchievementResult
    public final String getAchievementId() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

