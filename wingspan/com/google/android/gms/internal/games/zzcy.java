package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcy extends zzad implements PlayersClient {
    public static final int zza;

    public zzcy(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzcy(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getCompareProfileIntent(Player player0) {
        return this.doRead(TaskApiCall.builder().run(new zzcr(player0)).setMethodKey(0x19F3).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getCompareProfileIntent(String s) {
        return this.doRead(TaskApiCall.builder().run(new zzcv(s, null, null)).setMethodKey(0x19F4).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getCompareProfileIntentWithAlternativeNameHints(String s, String s1, String s2) {
        return this.doRead(TaskApiCall.builder().run(new zzcv(s, s1, s2)).setMethodKey(0x19F4).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getCurrentPlayer() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzct this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzF())).setMethodKey(0x19F1).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getCurrentPlayer(boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzcx(z)).setMethodKey(0x19F1).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getCurrentPlayerId() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzcq this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzJ(true))).setMethodKey(0x19F0).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task getPlayerSearchIntent() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzcs this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzz())).setMethodKey(0x19F5).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task loadFriends(int v, boolean z) {
        return this.zzb("friends_all", v, z);
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task loadMoreFriends(int v) {
        return this.zza("friends_all", v);
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task loadMoreRecentlyPlayedWithPlayers(int v) {
        return this.zza("played_with", v);
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task loadPlayer(String s) {
        return this.doRead(TaskApiCall.builder().run(new zzcu(s, false)).setMethodKey(0x19F2).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task loadPlayer(String s, boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzcu(s, z)).setMethodKey(0x19F2).build());
    }

    @Override  // com.google.android.gms.games.PlayersClient
    public final Task loadRecentlyPlayedWithPlayers(int v, boolean z) {
        return this.zzb("played_with", v, z);
    }

    private final Task zza(String s, int v) {
        return this.doRead(TaskApiCall.builder().run(new zzcw(s, v)).setMethodKey(0x19F7).build());
    }

    private final Task zzb(String s, int v, boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzcp(s, v, z)).setMethodKey(0x19F6).build());
    }
}

