package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class PlayerLevelInfo extends zzc {
    public static final Parcelable.Creator CREATOR;
    private final long zza;
    private final long zzb;
    private final PlayerLevel zzc;
    private final PlayerLevel zzd;

    static {
        PlayerLevelInfo.CREATOR = new zzu();
    }

    public PlayerLevelInfo(long v, long v1, PlayerLevel playerLevel0, PlayerLevel playerLevel1) {
        Preconditions.checkState(v != -1L);
        Preconditions.checkNotNull(playerLevel0);
        Preconditions.checkNotNull(playerLevel1);
        this.zza = v;
        this.zzb = v1;
        this.zzc = playerLevel0;
        this.zzd = playerLevel1;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof PlayerLevelInfo)) {
            return false;
        }
        return object0 == this ? true : Objects.equal(this.zza, ((PlayerLevelInfo)object0).zza) && Objects.equal(this.zzb, ((PlayerLevelInfo)object0).zzb) && Objects.equal(this.zzc, ((PlayerLevelInfo)object0).zzc) && Objects.equal(this.zzd, ((PlayerLevelInfo)object0).zzd);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzc;
    }

    public long getCurrentXpTotal() {
        return this.zza;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzb;
    }

    public PlayerLevel getNextLevel() {
        return this.zzd;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    public boolean isMaxLevel() {
        return this.zzc.equals(this.zzd);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel0, 2, this.getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel0, 3, this.getCurrentLevel(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.getNextLevel(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

