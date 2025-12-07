package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;

public final class zzbg implements GamesMetadata {
    @Override  // com.google.android.gms.games.GamesMetadata
    public final Game getCurrentGame(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzE();
    }

    @Override  // com.google.android.gms.games.GamesMetadata
    public final PendingResult loadGame(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzbc(this, googleApiClient0));
    }
}

