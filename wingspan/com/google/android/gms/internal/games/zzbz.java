package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;

final class zzbz extends zzcj {
    final LeaderboardScoreBuffer zza;
    final int zzb;
    final int zzc;

    zzbz(zzcm zzcm0, GoogleApiClient googleApiClient0, LeaderboardScoreBuffer leaderboardScoreBuffer0, int v, int v1) {
        this.zza = leaderboardScoreBuffer0;
        this.zzb = v;
        this.zzc = v1;
        super(googleApiClient0, null);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((com.google.android.gms.games.internal.zzbz)api$AnyClient0).zzat(this, this.zza, this.zzb, this.zzc);
    }
}

