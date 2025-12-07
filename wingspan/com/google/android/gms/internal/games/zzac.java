package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

public final class zzac implements Achievements {
    @Override  // com.google.android.gms.games.achievement.Achievements
    public final Intent getAchievementsIntent(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzt();
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final void increment(GoogleApiClient googleApiClient0, String s, int v) {
        googleApiClient0.execute(new zzu(this, s, googleApiClient0, s, v));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final PendingResult incrementImmediate(GoogleApiClient googleApiClient0, String s, int v) {
        return googleApiClient0.execute(new zzv(this, s, googleApiClient0, s, v));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final PendingResult load(GoogleApiClient googleApiClient0, boolean z) {
        return googleApiClient0.enqueue(new zzp(this, googleApiClient0, z));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final void reveal(GoogleApiClient googleApiClient0, String s) {
        googleApiClient0.execute(new zzq(this, s, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final PendingResult revealImmediate(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.execute(new zzr(this, s, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final void setSteps(GoogleApiClient googleApiClient0, String s, int v) {
        googleApiClient0.execute(new zzw(this, s, googleApiClient0, s, v));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final PendingResult setStepsImmediate(GoogleApiClient googleApiClient0, String s, int v) {
        return googleApiClient0.execute(new zzo(this, s, googleApiClient0, s, v));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final void unlock(GoogleApiClient googleApiClient0, String s) {
        googleApiClient0.execute(new zzs(this, s, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.games.achievement.Achievements
    public final PendingResult unlockImmediate(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.execute(new zzt(this, s, googleApiClient0, s));
    }
}

