package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    public static final Parcelable.Creator CREATOR;
    private int zza;
    private String zzb;
    private String zzc;
    private Uri zzd;

    static {
        GameBadgeEntity.CREATOR = new zzb();
    }

    GameBadgeEntity(int v, String s, String s1, Uri uri0) {
        this.zza = v;
        this.zzb = s;
        this.zzc = s1;
        this.zzd = uri0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof zza) {
            return this == object0 ? true : Objects.equal(((zza)object0).zza(), this.zzb) && Objects.equal(((zza)object0).zzb(), this.zzd);
        }
        return false;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("Type", this.zza).add("Title", this.zzb).add("Description", this.zzc).add("IconImageUri", this.zzd).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        if(!this.shouldDowngrade()) {
            int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
            SafeParcelWriter.writeInt(parcel0, 1, this.zza);
            SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
            SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
            SafeParcelWriter.writeParcelable(parcel0, 4, this.zzd, v, false);
            SafeParcelWriter.finishObjectHeader(parcel0, v1);
            return;
        }
        parcel0.writeInt(this.zza);
        parcel0.writeString(this.zzb);
        parcel0.writeString(this.zzc);
        parcel0.writeString((this.zzd == null ? null : this.zzd.toString()));
    }

    @Override  // com.google.android.gms.games.internal.game.zza
    public final int zza() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.internal.game.zza
    public final String zzb() {
        return this.zzc;
    }
}

