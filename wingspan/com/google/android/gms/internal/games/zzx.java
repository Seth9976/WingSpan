package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

final class zzx implements LoadAchievementsResult {
    final Status zza;

    zzx(zzz zzz0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.achievement.Achievements$LoadAchievementsResult
    public final AchievementBuffer getAchievements() {
        return new AchievementBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

