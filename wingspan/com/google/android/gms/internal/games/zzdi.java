package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;

public final class zzdi implements Players {
    @Override  // com.google.android.gms.games.Players
    public final Intent getCompareProfileIntent(GoogleApiClient googleApiClient0, Player player0) {
        return Games.zzd(googleApiClient0, true).zzx(new PlayerEntity(player0));
    }

    @Override  // com.google.android.gms.games.Players
    public final Player getCurrentPlayer(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzG();
    }

    @Override  // com.google.android.gms.games.Players
    public final String getCurrentPlayerId(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzK(true);
    }

    @Override  // com.google.android.gms.games.Players
    public final Intent getPlayerSearchIntent(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzA();
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadConnectedPlayers(GoogleApiClient googleApiClient0, boolean z) {
        return googleApiClient0.enqueue(new zzdf(this, googleApiClient0, z));
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadInvitablePlayers(GoogleApiClient googleApiClient0, int v, boolean z) {
        return googleApiClient0.enqueue(new zzdb(this, googleApiClient0, v, z));
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadMoreInvitablePlayers(GoogleApiClient googleApiClient0, int v) {
        return googleApiClient0.enqueue(new zzdc(this, googleApiClient0, v));
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient0, int v) {
        return googleApiClient0.enqueue(new zzde(this, googleApiClient0, v));
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadPlayer(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.enqueue(new zzcz(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadPlayer(GoogleApiClient googleApiClient0, String s, boolean z) {
        return googleApiClient0.enqueue(new zzda(this, googleApiClient0, s, z));
    }

    @Override  // com.google.android.gms.games.Players
    public final PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient0, int v, boolean z) {
        return googleApiClient0.enqueue(new zzdd(this, googleApiClient0, v, z));
    }
}

