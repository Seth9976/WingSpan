package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class PlayerLevel extends zzc {
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final long zzb;
    private final long zzc;

    static {
        PlayerLevel.CREATOR = new zzt();
    }

    public PlayerLevel(int v, long v1, long v2) {
        boolean z = true;
        Preconditions.checkState(Long.compare(v1, 0L) >= 0, "Min XP must be positive!");
        if(v2 <= v1) {
            z = false;
        }
        Preconditions.checkState(z, "Max XP must be more than min XP!");
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
    }

    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof PlayerLevel)) {
            return false;
        }
        return this == object0 ? true : Objects.equal(((PlayerLevel)object0).getLevelNumber(), this.getLevelNumber()) && Objects.equal(((PlayerLevel)object0).getMinXp(), this.getMinXp()) && Objects.equal(((PlayerLevel)object0).getMaxXp(), this.getMaxXp());
    }

    public int getLevelNumber() {
        return this.zza;
    }

    public long getMaxXp() {
        return this.zzc;
    }

    public long getMinXp() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("LevelNumber", this.getLevelNumber()).add("MinXp", this.getMinXp()).add("MaxXp", this.getMaxXp()).toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getLevelNumber());
        SafeParcelWriter.writeLong(parcel0, 2, this.getMinXp());
        SafeParcelWriter.writeLong(parcel0, 3, this.getMaxXp());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

