package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;

final class zzaj implements DeleteSnapshotResult {
    private final Status zza;
    private final String zzb;

    zzaj(int v, String s) {
        this.zza = GamesStatusCodes.zza(v);
        this.zzb = s;
    }

    @Override  // com.google.android.gms.games.snapshot.Snapshots$DeleteSnapshotResult
    public final String getSnapshotId() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

