package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

public final class zzx extends zzq implements PlayerRelationshipInfo {
    private final zzd zza;

    public zzx(DataHolder dataHolder0, int v, zzd zzd0) {
        super(dataHolder0, v);
        this.zza = zzd0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return zzv.zzf(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new zzv(this);
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final int getFriendStatus() {
        return this.zzq(this.zza.zzH, -1);
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return zzv.zzd(this);
    }

    @Override
    public final String toString() {
        return zzv.zze(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzw.zza(new zzv(this), parcel0, v);
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zza() {
        return this.zzr(this.zza.zzJ, null);
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzb() {
        return this.zzr(this.zza.zzI, null);
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzc() {
        return this.zzr(this.zza.zzK, null);
    }
}

