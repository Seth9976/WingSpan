package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdn implements RemoteCall {
    public final Snapshot zza;
    public final SnapshotMetadataChange zzb;

    public zzdn(Snapshot snapshot0, SnapshotMetadataChange snapshotMetadataChange0) {
        this.zza = snapshot0;
        this.zzb = snapshotMetadataChange0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzP(((TaskCompletionSource)object1), this.zza, this.zzb);
    }
}

