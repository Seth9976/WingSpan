package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzdl implements RemoteCall {
    public final String zza;
    public final String zzb;
    public final SnapshotMetadataChange zzc;
    public final SnapshotContents zzd;

    public zzdl(String s, String s1, SnapshotMetadataChange snapshotMetadataChange0, SnapshotContents snapshotContents0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = snapshotMetadataChange0;
        this.zzd = snapshotContents0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzbz)object0).zzaN(((TaskCompletionSource)object1), this.zza, this.zzb, this.zzc, this.zzd);
    }
}

