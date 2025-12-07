package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

final class zzbb extends zzao implements LoadGamesResult {
    private final GameBuffer zza;

    zzbb(DataHolder dataHolder0) {
        super(dataHolder0);
        this.zza = new GameBuffer(dataHolder0);
    }

    @Override  // com.google.android.gms.games.GamesMetadata$LoadGamesResult
    public final GameBuffer getGames() {
        return this.zza;
    }
}

