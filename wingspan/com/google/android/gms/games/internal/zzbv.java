package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.SnapshotsClient.DataOrConflict;
import com.google.android.gms.games.SnapshotsClient.SnapshotConflict;
import com.google.android.gms.games.SnapshotsClient.SnapshotContentUnavailableApiException;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbv extends zza {
    private final TaskCompletionSource zza;

    zzbv(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzq(DataHolder dataHolder0, String s, Contents contents0, Contents contents1, Contents contents2) {
        SnapshotEntity snapshotEntity1;
        SnapshotEntity snapshotEntity0;
        SnapshotMetadataBuffer snapshotMetadataBuffer0 = new SnapshotMetadataBuffer(dataHolder0);
        try {
            if(snapshotMetadataBuffer0.getCount() >= 2 && s != null && contents2 != null) {
                snapshotEntity0 = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(0)), new SnapshotContentsEntity(contents0));
                snapshotEntity1 = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(1)), new SnapshotContentsEntity(contents1));
                goto label_4;
            }
            goto label_8;
        }
        catch(Throwable throwable0) {
            goto label_11;
        }
    label_4:
        snapshotMetadataBuffer0.close();
        DataOrConflict snapshotsClient$DataOrConflict0 = new DataOrConflict(null, new SnapshotConflict(snapshotEntity0, s, snapshotEntity1, new SnapshotContentsEntity(contents2)));
        this.zza.setResult(snapshotsClient$DataOrConflict0);
        return;
        try {
        label_8:
            this.zza.setResult(null);
        }
        catch(Throwable throwable0) {
            try {
            label_11:
                snapshotMetadataBuffer0.close();
            }
            catch(Throwable throwable1) {
                zzbu.zza(throwable0, throwable1);
            }
            throw throwable0;
        }
        snapshotMetadataBuffer0.close();
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzs(DataHolder dataHolder0, Contents contents0) {
        SnapshotEntity snapshotEntity0;
        int v = dataHolder0.getStatusCode();
        SnapshotMetadataBuffer snapshotMetadataBuffer0 = new SnapshotMetadataBuffer(dataHolder0);
        try {
            snapshotEntity0 = snapshotMetadataBuffer0.getCount() > 0 ? new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer0.get(0)), new SnapshotContentsEntity(contents0)) : null;
        }
        catch(Throwable throwable0) {
            try {
                snapshotMetadataBuffer0.close();
            }
            catch(Throwable throwable1) {
                zzbu.zza(throwable0, throwable1);
            }
            throw throwable0;
        }
        snapshotMetadataBuffer0.close();
        if(v == 0) {
            DataOrConflict snapshotsClient$DataOrConflict0 = new DataOrConflict(snapshotEntity0, null);
            this.zza.setResult(snapshotsClient$DataOrConflict0);
            return;
        }
        if(v == 4002) {
            if(snapshotEntity0 != null && snapshotEntity0.getMetadata() != null) {
                SnapshotContentUnavailableApiException snapshotsClient$SnapshotContentUnavailableApiException0 = new SnapshotContentUnavailableApiException(GamesStatusCodes.zza(4002), snapshotEntity0.getMetadata());
                this.zza.setException(snapshotsClient$SnapshotContentUnavailableApiException0);
                return;
            }
            v = 4002;
        }
        GamesStatusUtils.zza(this.zza, v);
    }
}

