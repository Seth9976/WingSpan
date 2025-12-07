package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadataClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbb extends zzad implements GamesMetadataClient {
    public static final int zza;

    public zzbb(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzbb(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.GamesMetadataClient
    public final Task getCurrentGame() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzaz this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzD())).setMethodKey(6628).build());
    }

    @Override  // com.google.android.gms.games.GamesMetadataClient
    public final Task loadGame() {
        return this.doRead(TaskApiCall.builder().run((zzba this, Object object0) -> ((zzbz)object0).zzan(((TaskCompletionSource)object1))).setMethodKey(6629).build());
    }
}

