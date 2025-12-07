package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

final class zzaz extends zzao implements LoadAchievementsResult {
    private final AchievementBuffer zza;

    zzaz(DataHolder dataHolder0) {
        super(dataHolder0);
        this.zza = new AchievementBuffer(dataHolder0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievements$LoadAchievementsResult
    public final AchievementBuffer getAchievements() {
        return this.zza;
    }
}

