package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

public final class zzc extends DataBufferRef implements zza {
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
        return MostRecentGameInfoEntity.zzi(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MostRecentGameInfoEntity.zzg(this);
    }

    @Override
    public final String toString() {
        return MostRecentGameInfoEntity.zzh(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzb.zza(new MostRecentGameInfoEntity(this), parcel0, v);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final long zza() {
        return this.getLong(this.zza.zzv);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final Uri zzb() {
        return this.parseUri(this.zza.zzy);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final Uri zzc() {
        return this.parseUri(this.zza.zzx);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final Uri zzd() {
        return this.parseUri(this.zza.zzw);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final String zze() {
        return this.getString(this.zza.zzt);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final String zzf() {
        return this.getString(this.zza.zzu);
    }
}

