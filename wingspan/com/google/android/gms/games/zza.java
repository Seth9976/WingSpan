package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.games.internal.zzc;

public final class zza extends zzc implements CurrentPlayerInfo {
    public static final Parcelable.Creator CREATOR;
    private final int zza;

    static {
        zza.CREATOR = new zzb();
    }

    public zza(int v) {
        this.zza = v;
    }

    public zza(CurrentPlayerInfo currentPlayerInfo0) {
        this.zza = currentPlayerInfo0.getFriendsListVisibilityStatus();
    }

    @Override
    public final boolean equals(Object object0) {
        return zza.zzc(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return this.zza;
    }

    @Override
    public final int hashCode() {
        return zza.zza(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return zza.zzb(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzb.zza(this, parcel0, v);
    }

    static int zza(CurrentPlayerInfo currentPlayerInfo0) {
        return Objects.hashCode(new Object[]{currentPlayerInfo0.getFriendsListVisibilityStatus()});
    }

    static String zzb(CurrentPlayerInfo currentPlayerInfo0) {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(currentPlayerInfo0);
        objects$ToStringHelper0.add("FriendsListVisibilityStatus", currentPlayerInfo0.getFriendsListVisibilityStatus());
        return objects$ToStringHelper0.toString();
    }

    static boolean zzc(CurrentPlayerInfo currentPlayerInfo0, Object object0) {
        if(!(object0 instanceof CurrentPlayerInfo)) {
            return false;
        }
        return object0 == currentPlayerInfo0 ? true : ((CurrentPlayerInfo)object0).getFriendsListVisibilityStatus() == currentPlayerInfo0.getFriendsListVisibilityStatus();
    }
}

