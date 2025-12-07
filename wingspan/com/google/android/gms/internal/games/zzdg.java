package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players.LoadPlayersResult;

final class zzdg implements LoadPlayersResult {
    final Status zza;

    zzdg(zzdh zzdh0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.games.Players$LoadPlayersResult
    public final PlayerBuffer getPlayers() {
        return new PlayerBuffer(DataHolder.empty(14));
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}

