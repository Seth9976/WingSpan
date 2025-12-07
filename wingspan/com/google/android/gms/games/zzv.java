package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.games.internal.zzc;

public final class zzv extends zzc implements PlayerRelationshipInfo {
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    static {
        zzv.CREATOR = new zzw();
    }

    public zzv(int v, String s, String s1, String s2) {
        this.zza = v;
        this.zzb = s;
        this.zzc = s1;
        this.zzd = s2;
    }

    public zzv(PlayerRelationshipInfo playerRelationshipInfo0) {
        this.zza = playerRelationshipInfo0.getFriendStatus();
        this.zzb = playerRelationshipInfo0.zzb();
        this.zzc = playerRelationshipInfo0.zza();
        this.zzd = playerRelationshipInfo0.zzc();
    }

    @Override
    public final boolean equals(Object object0) {
        return zzv.zzf(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final int getFriendStatus() {
        return this.zza;
    }

    @Override
    public final int hashCode() {
        return zzv.zzd(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return zzv.zze(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzw.zza(this, parcel0, v);
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zza() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzb() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzc() {
        return this.zzd;
    }

    static int zzd(PlayerRelationshipInfo playerRelationshipInfo0) {
        return Objects.hashCode(new Object[]{playerRelationshipInfo0.getFriendStatus(), playerRelationshipInfo0.zzb(), playerRelationshipInfo0.zza(), playerRelationshipInfo0.zzc()});
    }

    static String zze(PlayerRelationshipInfo playerRelationshipInfo0) {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(playerRelationshipInfo0);
        objects$ToStringHelper0.add("FriendStatus", playerRelationshipInfo0.getFriendStatus());
        if(playerRelationshipInfo0.zzb() != null) {
            objects$ToStringHelper0.add("Nickname", playerRelationshipInfo0.zzb());
        }
        if(playerRelationshipInfo0.zza() != null) {
            objects$ToStringHelper0.add("InvitationNickname", playerRelationshipInfo0.zza());
        }
        if(playerRelationshipInfo0.zzc() != null) {
            objects$ToStringHelper0.add("NicknameAbuseReportToken", playerRelationshipInfo0.zza());
        }
        return objects$ToStringHelper0.toString();
    }

    static boolean zzf(PlayerRelationshipInfo playerRelationshipInfo0, Object object0) {
        if(!(object0 instanceof PlayerRelationshipInfo)) {
            return false;
        }
        return object0 == playerRelationshipInfo0 ? true : ((PlayerRelationshipInfo)object0).getFriendStatus() == playerRelationshipInfo0.getFriendStatus() && Objects.equal(((PlayerRelationshipInfo)object0).zzb(), playerRelationshipInfo0.zzb()) && Objects.equal(((PlayerRelationshipInfo)object0).zza(), playerRelationshipInfo0.zza()) && Objects.equal(((PlayerRelationshipInfo)object0).zzc(), playerRelationshipInfo0.zzc());
    }
}

