package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@Deprecated
public final class ParticipantEntity extends GamesDowngradeableSafeParcel {
    public static final Parcelable.Creator CREATOR;

    static {
        ParticipantEntity.CREATOR = new zza();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        if(!this.shouldDowngrade()) {
            SafeParcelWriter.finishObjectHeader(parcel0, SafeParcelWriter.beginObjectHeader(parcel0));
            return;
        }
        parcel0.writeString("unsupported");
        parcel0.writeString("unsupported");
        parcel0.writeString(null);
        parcel0.writeString(null);
        parcel0.writeInt(0);
        parcel0.writeString("unsupported");
        parcel0.writeInt(0);
        parcel0.writeInt(0);
    }
}

