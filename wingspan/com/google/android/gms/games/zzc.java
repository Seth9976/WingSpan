package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zzd;

public final class zzc extends zzq implements CurrentPlayerInfo {
    private final zzd zza;

    public zzc(DataHolder dataHolder0, int v, zzd zzd0) {
        super(dataHolder0, v);
        this.zza = zzd0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return zza.zzc(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new zza(this);
    }

    @Override  // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return this.zzq(this.zza.zzL, 0);
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return zza.zza(this);
    }

    @Override
    public final String toString() {
        return zza.zzb(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzb.zza(new zza(this), parcel0, v);
    }

    // 去混淆评级： 低(20)
    public final boolean zza() {
        return this.hasColumn(this.zza.zzL) && !this.hasNull(this.zza.zzL);
    }
}

