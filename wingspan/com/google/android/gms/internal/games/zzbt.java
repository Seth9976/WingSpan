package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbt extends zzad implements LeaderboardsClient {
    public static final int zza;

    public zzbt(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzbt(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task getAllLeaderboardsIntent() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzbk this) -> ((TaskCompletionSource)object1).setResult(((zzce)((zzbz)object0).getService()).zzh())).setMethodKey(6630).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task getLeaderboardIntent(String s) {
        return this.getLeaderboardIntent(s, -1, -1);
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task getLeaderboardIntent(String s, int v) {
        return this.getLeaderboardIntent(s, v, -1);
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task getLeaderboardIntent(String s, int v, int v1) {
        return this.doRead(TaskApiCall.builder().run(new zzbh(s, v, v1)).setMethodKey(6631).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadCurrentPlayerLeaderboardScore(String s, int v, int v1) {
        return this.doRead(TaskApiCall.builder().run(new zzbl(s, v, v1)).setMethodKey(6633).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadLeaderboardMetadata(String s, boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzbp(s, z)).setMethodKey(6632).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadLeaderboardMetadata(boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzbj(z)).setMethodKey(6632).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadMoreScores(LeaderboardScoreBuffer leaderboardScoreBuffer0, int v, int v1) {
        return this.doRead(TaskApiCall.builder().run(new zzbi(leaderboardScoreBuffer0, v, v1)).setMethodKey(6636).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadPlayerCenteredScores(String s, int v, int v1, int v2) {
        return this.doRead(TaskApiCall.builder().run(new zzbn(s, v, v1, v2, false)).setMethodKey(6635).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadPlayerCenteredScores(String s, int v, int v1, int v2, boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzbn(s, v, v1, v2, z)).setMethodKey(6635).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadTopScores(String s, int v, int v1, int v2) {
        return this.doRead(TaskApiCall.builder().run(new zzbm(s, v, v1, v2, false)).setMethodKey(6634).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task loadTopScores(String s, int v, int v1, int v2, boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzbm(s, v, v1, v2, z)).setMethodKey(6634).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String s, long v) {
        this.doWrite(TaskApiCall.builder().run(new zzbr(s, v)).setMethodKey(6637).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String s, long v, String s1) {
        this.doWrite(TaskApiCall.builder().run(new zzbs(s, v, s1)).setMethodKey(6637).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task submitScoreImmediate(String s, long v) {
        return this.doWrite(TaskApiCall.builder().run(new zzbq(s, v)).setMethodKey(6638).build());
    }

    @Override  // com.google.android.gms.games.LeaderboardsClient
    public final Task submitScoreImmediate(String s, long v, String s1) {
        return this.doWrite(TaskApiCall.builder().run(new zzbo(s, v, s1)).setMethodKey(6638).build());
    }
}

