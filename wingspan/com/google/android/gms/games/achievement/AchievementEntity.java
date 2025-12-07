package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

public final class AchievementEntity extends zzc implements Achievement {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final Uri zze;
    private final String zzf;
    private final Uri zzg;
    private final String zzh;
    private final int zzi;
    private final String zzj;
    private final PlayerEntity zzk;
    private final int zzl;
    private final int zzm;
    private final String zzn;
    private final long zzo;
    private final long zzp;
    private final float zzq;
    private final String zzr;

    static {
        AchievementEntity.CREATOR = new zza();
    }

    public AchievementEntity(Achievement achievement0) {
        String s = achievement0.getAchievementId();
        this.zza = s;
        this.zzb = achievement0.getType();
        this.zzc = achievement0.getName();
        String s1 = achievement0.getDescription();
        this.zzd = s1;
        this.zze = achievement0.getUnlockedImageUri();
        this.zzf = achievement0.getUnlockedImageUrl();
        this.zzg = achievement0.getRevealedImageUri();
        this.zzh = achievement0.getRevealedImageUrl();
        Player player0 = achievement0.zzb();
        this.zzk = player0 == null ? null : new PlayerEntity(player0);
        this.zzl = achievement0.getState();
        this.zzo = achievement0.getLastUpdatedTimestamp();
        this.zzp = achievement0.getXpValue();
        this.zzq = achievement0.zza();
        this.zzr = achievement0.zzc();
        if(achievement0.getType() == 1) {
            this.zzi = achievement0.getTotalSteps();
            this.zzj = achievement0.getFormattedTotalSteps();
            this.zzm = achievement0.getCurrentSteps();
            this.zzn = achievement0.getFormattedCurrentSteps();
        }
        else {
            this.zzi = 0;
            this.zzj = null;
            this.zzm = 0;
            this.zzn = null;
        }
        Asserts.checkNotNull(s);
        Asserts.checkNotNull(s1);
    }

    AchievementEntity(String s, int v, String s1, String s2, Uri uri0, String s3, Uri uri1, String s4, int v1, String s5, PlayerEntity playerEntity0, int v2, int v3, String s6, long v4, long v5, float f, String s7) {
        this.zza = s;
        this.zzb = v;
        this.zzc = s1;
        this.zzd = s2;
        this.zze = uri0;
        this.zzf = s3;
        this.zzg = uri1;
        this.zzh = s4;
        this.zzi = v1;
        this.zzj = s5;
        this.zzk = playerEntity0;
        this.zzl = v2;
        this.zzm = v3;
        this.zzn = s6;
        this.zzo = v4;
        this.zzp = v5;
        this.zzq = f;
        this.zzr = s7;
    }

    @Override
    public boolean equals(Object object0) {
        return AchievementEntity.zzf(this, object0);
    }

    public Achievement freeze() {
        return this;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getAchievementId() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public int getCurrentSteps() {
        Asserts.checkState(this.getType() == 1);
        return this.zzm;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getDescription() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public void getDescription(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzd, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getFormattedCurrentSteps() {
        Asserts.checkState(this.getType() == 1);
        return this.zzn;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer0) {
        Asserts.checkState(this.getType() == 1);
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getFormattedTotalSteps() {
        Asserts.checkState(this.getType() == 1);
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer0) {
        Asserts.checkState(this.getType() == 1);
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public long getLastUpdatedTimestamp() {
        return this.zzo;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getName() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public void getName(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public Player getPlayer() {
        return (Player)Preconditions.checkNotNull(this.zzk);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public Uri getRevealedImageUri() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public int getState() {
        return this.zzl;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public int getTotalSteps() {
        Asserts.checkState(this.getType() == 1);
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public int getType() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public Uri getUnlockedImageUri() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public long getXpValue() {
        return this.zzp;
    }

    @Override
    public int hashCode() {
        return AchievementEntity.zzd(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override
    public String toString() {
        return AchievementEntity.zze(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel0, 2, this.getType());
        SafeParcelWriter.writeString(parcel0, 3, this.getName(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getUnlockedImageUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 6, this.getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.getRevealedImageUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 8, this.getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzi);
        SafeParcelWriter.writeString(parcel0, 10, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel0, 11, this.zzk, v, false);
        SafeParcelWriter.writeInt(parcel0, 12, this.getState());
        SafeParcelWriter.writeInt(parcel0, 13, this.zzm);
        SafeParcelWriter.writeString(parcel0, 14, this.zzn, false);
        SafeParcelWriter.writeLong(parcel0, 15, this.getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel0, 16, this.getXpValue());
        SafeParcelWriter.writeFloat(parcel0, 17, this.zzq);
        SafeParcelWriter.writeString(parcel0, 18, this.zzr, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final float zza() {
        return this.zzq;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final Player zzb() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.games.achievement.Achievement
    public final String zzc() {
        return this.zzr;
    }

    static int zzd(Achievement achievement0) {
        if(achievement0.getType() == 1) {
            int v = achievement0.getCurrentSteps();
            int v1 = achievement0.getTotalSteps();
            return Objects.hashCode(new Object[]{achievement0.getAchievementId(), achievement0.zzc(), achievement0.getName(), achievement0.getType(), achievement0.getDescription(), achievement0.getXpValue(), achievement0.getState(), achievement0.getLastUpdatedTimestamp(), achievement0.zzb(), v, v1});
        }
        return Objects.hashCode(new Object[]{achievement0.getAchievementId(), achievement0.zzc(), achievement0.getName(), achievement0.getType(), achievement0.getDescription(), achievement0.getXpValue(), achievement0.getState(), achievement0.getLastUpdatedTimestamp(), achievement0.zzb(), 0, 0});
    }

    static String zze(Achievement achievement0) {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(achievement0).add("Id", achievement0.getAchievementId()).add("Game Id", achievement0.zzc()).add("Type", achievement0.getType()).add("Name", achievement0.getName()).add("Description", achievement0.getDescription()).add("Player", achievement0.zzb()).add("State", achievement0.getState()).add("Rarity Percent", achievement0.zza());
        if(achievement0.getType() == 1) {
            objects$ToStringHelper0.add("CurrentSteps", achievement0.getCurrentSteps());
            objects$ToStringHelper0.add("TotalSteps", achievement0.getTotalSteps());
        }
        return objects$ToStringHelper0.toString();
    }

    static boolean zzf(Achievement achievement0, Object object0) {
        if(!(object0 instanceof Achievement)) {
            return false;
        }
        if(achievement0 == object0) {
            return true;
        }
        if(((Achievement)object0).getType() != achievement0.getType()) {
            return false;
        }
        if(achievement0.getType() == 1) {
            if(((Achievement)object0).getCurrentSteps() != achievement0.getCurrentSteps()) {
                return false;
            }
            return ((Achievement)object0).getTotalSteps() == achievement0.getTotalSteps() ? ((Achievement)object0).getXpValue() == achievement0.getXpValue() && ((Achievement)object0).getState() == achievement0.getState() && ((Achievement)object0).getLastUpdatedTimestamp() == achievement0.getLastUpdatedTimestamp() && Objects.equal(((Achievement)object0).getAchievementId(), achievement0.getAchievementId()) && Objects.equal(((Achievement)object0).zzc(), achievement0.zzc()) && Objects.equal(((Achievement)object0).getName(), achievement0.getName()) && Objects.equal(((Achievement)object0).getDescription(), achievement0.getDescription()) && Objects.equal(((Achievement)object0).zzb(), achievement0.zzb()) && ((Achievement)object0).zza() == achievement0.zza() : false;
        }
        return ((Achievement)object0).getXpValue() == achievement0.getXpValue() && ((Achievement)object0).getState() == achievement0.getState() && ((Achievement)object0).getLastUpdatedTimestamp() == achievement0.getLastUpdatedTimestamp() && Objects.equal(((Achievement)object0).getAchievementId(), achievement0.getAchievementId()) && Objects.equal(((Achievement)object0).zzc(), achievement0.zzc()) && Objects.equal(((Achievement)object0).getName(), achievement0.getName()) && Objects.equal(((Achievement)object0).getDescription(), achievement0.getDescription()) && Objects.equal(((Achievement)object0).zzb(), achievement0.zzb()) && ((Achievement)object0).zza() == achievement0.zza();
    }
}

