package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzay extends zzad implements GamesClient {
    public static final int zza;

    public zzay(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzay(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.GamesClient
    public final Task getActivationHint() {
        return this.doRead(TaskApiCall.builder().run(zzav.zza).setMethodKey(6622).build());
    }

    @Override  // com.google.android.gms.games.GamesClient
    public final Task getAppId() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzaw this) -> ((TaskCompletionSource)object1).setResult(((zzce)((zzbz)object0).getService()).zzr())).setMethodKey(6620).build());
    }

    @Override  // com.google.android.gms.games.GamesClient
    public final Task getCurrentAccountName() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzax this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzH())).setMethodKey(6618).build());
    }

    @Override  // com.google.android.gms.games.GamesClient
    public final Task getSettingsIntent() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzat this) -> ((TaskCompletionSource)object1).setResult(((zzce)((zzbz)object0).getService()).zzn())).setMethodKey(6621).build());
    }

    @Override  // com.google.android.gms.games.GamesClient
    public final Task setGravityForPopups(int v) {
        return this.doWrite(TaskApiCall.builder().run(new zzas(v)).setMethodKey(6616).build());
    }

    @Override  // com.google.android.gms.games.GamesClient
    public final Task setViewForPopups(View view0) {
        return this.doWrite(TaskApiCall.builder().run(new zzau(view0)).setMethodKey(6617).build());
    }
}

