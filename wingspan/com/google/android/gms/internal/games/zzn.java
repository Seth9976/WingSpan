package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.tasks.Task;

public final class zzn extends zzad implements AchievementsClient {
    public static final int zza;

    public zzn(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzn(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final Task getAchievementsIntent() {
        return this.doRead(TaskApiCall.builder().run(zzk.zza).setMethodKey(6601).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final void increment(String s, int v) {
        this.doWrite(TaskApiCall.builder().run(new zzl(s, v)).setMethodKey(6607).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final Task incrementImmediate(String s, int v) {
        return this.doWrite(TaskApiCall.builder().run(new zzi(s, v)).setMethodKey(6608).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final Task load(boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzj(z)).setMethodKey(6602).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final void reveal(String s) {
        this.doWrite(TaskApiCall.builder().run(new zze(s)).setMethodKey(6603).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final Task revealImmediate(String s) {
        return this.doWrite(TaskApiCall.builder().run(new zzm(s)).setMethodKey(6604).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final void setSteps(String s, int v) {
        this.doWrite(TaskApiCall.builder().run(new zzg(s, v)).setMethodKey(6609).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final Task setStepsImmediate(String s, int v) {
        return this.doWrite(TaskApiCall.builder().run(new zzd(s, v)).setMethodKey(6610).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final void unlock(String s) {
        this.doWrite(TaskApiCall.builder().run(new zzf(s)).setMethodKey(6605).build());
    }

    @Override  // com.google.android.gms.games.AchievementsClient
    public final Task unlockImmediate(String s) {
        return this.doWrite(TaskApiCall.builder().run(new zzh(s)).setMethodKey(6606).build());
    }
}

