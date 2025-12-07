package com.google.android.gms.games.achievement;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface Achievements {
    @Deprecated
    public interface LoadAchievementsResult extends Releasable, Result {
        AchievementBuffer getAchievements();
    }

    @Deprecated
    public interface UpdateAchievementResult extends Result {
        String getAchievementId();
    }

    Intent getAchievementsIntent(GoogleApiClient arg1);

    void increment(GoogleApiClient arg1, String arg2, int arg3);

    PendingResult incrementImmediate(GoogleApiClient arg1, String arg2, int arg3);

    PendingResult load(GoogleApiClient arg1, boolean arg2);

    void reveal(GoogleApiClient arg1, String arg2);

    PendingResult revealImmediate(GoogleApiClient arg1, String arg2);

    void setSteps(GoogleApiClient arg1, String arg2, int arg3);

    PendingResult setStepsImmediate(GoogleApiClient arg1, String arg2, int arg3);

    void unlock(GoogleApiClient arg1, String arg2);

    PendingResult unlockImmediate(GoogleApiClient arg1, String arg2);
}

