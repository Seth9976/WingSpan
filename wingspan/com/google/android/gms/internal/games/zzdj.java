package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdj implements RemoteCall {
    public final SnapshotMetadata zza;

    public zzdj(SnapshotMetadata snapshotMetadata0) {
        this.zza = snapshotMetadata0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzR(((TaskCompletionSource)object1), this.zza.getSnapshotId());
    }
}

