package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzds extends zzad implements SnapshotsClient {
    public static final int zza;

    public zzds(Activity activity0, GamesOptions games$GamesOptions0) {
        super(activity0, games$GamesOptions0);
    }

    public zzds(Context context0, GamesOptions games$GamesOptions0) {
        super(context0, games$GamesOptions0);
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task commitAndClose(Snapshot snapshot0, SnapshotMetadataChange snapshotMetadataChange0) {
        return this.doWrite(TaskApiCall.builder().run(new zzdn(snapshot0, snapshotMetadataChange0)).setMethodKey(0x1A10).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task delete(SnapshotMetadata snapshotMetadata0) {
        return this.doWrite(TaskApiCall.builder().run(new zzdj(snapshotMetadata0)).setMethodKey(6674).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task discardAndClose(Snapshot snapshot0) {
        return this.doWrite(TaskApiCall.builder().run(new zzdq(snapshot0)).setMethodKey(6673).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task getMaxCoverImageSize() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzdo this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzp())).setMethodKey(0x1A0C).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task getMaxDataSize() {
        return this.doRead(TaskApiCall.builder().run((/* 缺少Lambda参数 */, zzdp this) -> ((TaskCompletionSource)object1).setResult(((zzbz)object0).zzr())).setMethodKey(0x1A0B).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task getSelectSnapshotIntent(String s, boolean z, boolean z1, int v) {
        return this.doRead(TaskApiCall.builder().run(new zzdk(s, z, z1, v)).setMethodKey(0x1A0D).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task load(boolean z) {
        return this.doRead(TaskApiCall.builder().run(new zzdr(z)).setMethodKey(6670).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task open(SnapshotMetadata snapshotMetadata0) {
        return this.open(snapshotMetadata0.getUniqueName(), false, -1);
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task open(SnapshotMetadata snapshotMetadata0, int v) {
        return this.open(snapshotMetadata0.getUniqueName(), false, v);
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task open(String s, boolean z) {
        return this.open(s, z, -1);
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task open(String s, boolean z, int v) {
        return this.doWrite(TaskApiCall.builder().run(new zzdm(s, z, v)).setMethodKey(0x1A0F).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task resolveConflict(String s, Snapshot snapshot0) {
        SnapshotMetadata snapshotMetadata0 = snapshot0.getMetadata();
        Builder snapshotMetadataChange$Builder0 = new Builder();
        snapshotMetadataChange$Builder0.fromMetadata(snapshotMetadata0);
        SnapshotMetadataChange snapshotMetadataChange0 = snapshotMetadataChange$Builder0.build();
        String s1 = snapshotMetadata0.getSnapshotId();
        SnapshotContents snapshotContents0 = snapshot0.getSnapshotContents();
        return this.doWrite(TaskApiCall.builder().run(new zzdl(s, s1, snapshotMetadataChange0, snapshotContents0)).setMethodKey(6675).build());
    }

    @Override  // com.google.android.gms.games.SnapshotsClient
    public final Task resolveConflict(String s, String s1, SnapshotMetadataChange snapshotMetadataChange0, SnapshotContents snapshotContents0) {
        return this.doWrite(TaskApiCall.builder().run(new zzdl(s, s1, snapshotMetadataChange0, snapshotContents0)).setMethodKey(6675).build());
    }
}

