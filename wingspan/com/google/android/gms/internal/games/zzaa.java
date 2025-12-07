package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

final class zzaa implements UpdateAchievementResult {
    final Status zza;
    final zzab zzb;

    zzaa(zzab zzab0, Status status0) {
        this.zzb = zzab0;
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.achievement.Achievements$UpdateAchievementResult
    public final String getAchievementId() {
        return this.zzb.zza;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

