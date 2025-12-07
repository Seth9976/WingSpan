package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players.LoadPlayersResult;

final class zzbe extends zzao implements LoadPlayersResult {
    private final PlayerBuffer zza;

    zzbe(DataHolder dataHolder0) {
        super(dataHolder0);
        this.zza = new PlayerBuffer(dataHolder0);
    }

    @Override  // com.google.android.gms.games.Players$LoadPlayersResult
    public final PlayerBuffer getPlayers() {
        return this.zza;
    }
}

