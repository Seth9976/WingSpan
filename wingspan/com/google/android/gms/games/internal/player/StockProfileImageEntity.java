package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class StockProfileImageEntity extends zzc implements StockProfileImage {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final Uri zzb;

    static {
        StockProfileImageEntity.CREATOR = new zzh();
    }

    public StockProfileImageEntity(String s, Uri uri0) {
        this.zza = s;
        this.zzb = uri0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof StockProfileImage)) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        String s = ((StockProfileImage)object0).getImageUrl();
        if(Objects.equal(this.zza, s)) {
            Uri uri0 = ((StockProfileImage)object0).zza();
            return Objects.equal(this.zzb, uri0);
        }
        return false;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.internal.player.StockProfileImage
    public String getImageUrl() {
        return this.zza;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("ImageId", this.zza).add("ImageUri", this.zzb).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.internal.player.StockProfileImage
    public final Uri zza() {
        return this.zzb;
    }
}

