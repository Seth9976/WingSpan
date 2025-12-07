package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.EventsClient;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.tasks.Task;

public final class zzah extends zzad implements EventsClient {
    public static final int zza;

    public zzah(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzah(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.EventsClient
    public final void increment(String s, int v) {
        this.doWrite(TaskApiCall.builder().run(new zzae(s, v)).setMethodKey(6615).build());
    }

    @Override  // com.google.android.gms.games.EventsClient
    public final Task load(boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzaf(z)).setMethodKey(6613).build());
    }

    @Override  // com.google.android.gms.games.EventsClient
    public final Task loadByIds(boolean z, String[] arr_s) {
        return this.doRead(TaskApiCall.builder().run(new zzag(z, arr_s)).setMethodKey(6614).build());
    }
}

