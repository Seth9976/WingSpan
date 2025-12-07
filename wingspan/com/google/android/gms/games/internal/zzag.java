package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzag extends zza {
    private final TaskCompletionSource zza;

    zzag(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzp(DataHolder dataHolder0) {
        SnapshotMetadataEntity snapshotMetadataEntity0;
        int v = dataHolder0.getStatusCode();
        if(v != 0) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        try(SnapshotMetadataBuffer snapshotMetadataBuffer0 = new SnapshotMetadataBuffer(dataHolder0)) {
            snapshotMetadataEntity0 = snapshotMetadataBuffer0.getCount() > 0 ? new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(0)) : null;
        }
        this.zza.setResult(snapshotMetadataEntity0);
    }
}

