package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class ScreenshotEntity extends zzc implements Parcelable, Freezable {
    public static final Parcelable.Creator CREATOR;
    private final Uri zza;
    private final int zzb;
    private final int zzc;

    static {
        ScreenshotEntity.CREATOR = new zzd();
    }

    public ScreenshotEntity(Uri uri0, int v, int v1) {
        this.zza = uri0;
        this.zzb = v;
        this.zzc = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof ScreenshotEntity) {
            return this == object0 ? true : Objects.equal(((ScreenshotEntity)object0).zza, this.zza) && Objects.equal(((ScreenshotEntity)object0).zzb, this.zzb) && Objects.equal(((ScreenshotEntity)object0).zzc, this.zzc);
        }
        return false;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("Uri", this.zza).add("Width", this.zzb).add("Height", this.zzc).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zza, v, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

