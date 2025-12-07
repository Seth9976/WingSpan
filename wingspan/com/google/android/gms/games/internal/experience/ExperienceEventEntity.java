package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzc;

public final class ExperienceEventEntity extends zzc implements ExperienceEvent {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final GameEntity zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final Uri zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final int zzj;
    private final int zzk;

    static {
        ExperienceEventEntity.CREATOR = new zza();
    }

    ExperienceEventEntity(String s, GameEntity gameEntity0, String s1, String s2, String s3, Uri uri0, long v, long v1, long v2, int v3, int v4) {
        this.zza = s;
        this.zzb = gameEntity0;
        this.zzc = s1;
        this.zzd = s2;
        this.zze = s3;
        this.zzf = uri0;
        this.zzg = v;
        this.zzh = v1;
        this.zzi = v2;
        this.zzj = v3;
        this.zzk = v4;
    }

    // 去混淆评级： 低(43)
    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof ExperienceEvent) {
            return this == object0 ? true : Objects.equal(((ExperienceEvent)object0).zzj(), this.zza) && Objects.equal(((ExperienceEvent)object0).zzg(), this.zzb) && Objects.equal(((ExperienceEvent)object0).zzi(), this.zzc) && Objects.equal(((ExperienceEvent)object0).zzh(), this.zzd) && Objects.equal(((ExperienceEvent)object0).getIconImageUrl(), this.getIconImageUrl()) && Objects.equal(((ExperienceEvent)object0).zzf(), this.zzf) && Objects.equal(((ExperienceEvent)object0).zzc(), this.zzg) && Objects.equal(((ExperienceEvent)object0).zze(), this.zzh) && Objects.equal(((ExperienceEvent)object0).zzd(), this.zzi) && Objects.equal(((ExperienceEvent)object0).zzb(), this.zzj) && Objects.equal(((ExperienceEvent)object0).zza(), this.zzk);
        }
        return false;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public String getIconImageUrl() {
        return this.zze;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.getIconImageUrl(), this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk});
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", this.zza).add("Game", this.zzb).add("DisplayTitle", this.zzc).add("DisplayDescription", this.zzd).add("IconImageUrl", this.getIconImageUrl()).add("IconImageUri", this.zzf).add("CreatedTimestamp", this.zzg).add("XpEarned", this.zzh).add("CurrentXp", this.zzi).add("Type", this.zzj).add("NewLevel", this.zzk).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel0, 5, this.getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzf, v, false);
        SafeParcelWriter.writeLong(parcel0, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel0, 8, this.zzh);
        SafeParcelWriter.writeLong(parcel0, 9, this.zzi);
        SafeParcelWriter.writeInt(parcel0, 10, this.zzj);
        SafeParcelWriter.writeInt(parcel0, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zza() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzb() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzc() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzd() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zze() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Uri zzf() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Game zzg() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzh() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzi() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzj() {
        return this.zza;
    }
}

