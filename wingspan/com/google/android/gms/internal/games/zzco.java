package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.PlayerStatsClient;
import com.google.android.gms.tasks.Task;

public final class zzco extends zzad implements PlayerStatsClient {
    public static final int zza;

    public zzco(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzco(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.PlayerStatsClient
    public final Task loadPlayerStats(boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzcn(z)).setMethodKey(0x19EF).build());
    }
}

