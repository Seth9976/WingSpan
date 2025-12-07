package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

final class zzbd implements LoadGamesResult {
    final Status zza;

    zzbd(zzbf zzbf0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.GamesMetadata$LoadGamesResult
    public final GameBuffer getGames() {
        return new GameBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

