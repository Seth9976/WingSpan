package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.zzy;

public class ProfileSettingsEntity extends zzc implements zzy {
    public static final Parcelable.Creator CREATOR;
    private final Status zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final StockProfileImageEntity zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;

    static {
        ProfileSettingsEntity.CREATOR = new zzg();
    }

    public ProfileSettingsEntity(Status status0, String s, boolean z, boolean z1, boolean z2, StockProfileImageEntity stockProfileImageEntity0, boolean z3, boolean z4, int v, boolean z5, boolean z6, int v1, int v2, boolean z7) {
        this.zza = status0;
        this.zzb = s;
        this.zzc = z;
        this.zzd = z1;
        this.zze = z2;
        this.zzf = stockProfileImageEntity0;
        this.zzg = z3;
        this.zzh = z4;
        this.zzi = v;
        this.zzj = z5;
        this.zzk = z6;
        this.zzl = v1;
        this.zzm = v2;
        this.zzn = z7;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof zzy)) {
            return false;
        }
        if(this == object0) {
            return true;
        }
        String s = ((zzy)object0).zze();
        if(Objects.equal(this.zzb, s)) {
            Boolean boolean0 = Boolean.valueOf(((zzy)object0).zzi());
            if(Objects.equal(Boolean.valueOf(this.zzc), boolean0)) {
                Boolean boolean1 = Boolean.valueOf(((zzy)object0).zzk());
                if(Objects.equal(Boolean.valueOf(this.zzd), boolean1)) {
                    Boolean boolean2 = Boolean.valueOf(((zzy)object0).zzm());
                    if(Objects.equal(Boolean.valueOf(this.zze), boolean2)) {
                        Status status0 = ((zzy)object0).getStatus();
                        if(Objects.equal(this.zza, status0)) {
                            StockProfileImage stockProfileImage0 = ((zzy)object0).zzd();
                            if(Objects.equal(this.zzf, stockProfileImage0)) {
                                Boolean boolean3 = Boolean.valueOf(((zzy)object0).zzj());
                                if(Objects.equal(Boolean.valueOf(this.zzg), boolean3)) {
                                    Boolean boolean4 = Boolean.valueOf(((zzy)object0).zzh());
                                    if(Objects.equal(Boolean.valueOf(this.zzh), boolean4)) {
                                        int v = ((zzy)object0).zzb();
                                        if(this.zzi == v) {
                                            boolean z = ((zzy)object0).zzl();
                                            if(this.zzj == z) {
                                                boolean z1 = ((zzy)object0).zzf();
                                                if(this.zzk == z1) {
                                                    int v1 = ((zzy)object0).zzc();
                                                    if(this.zzl == v1) {
                                                        int v2 = ((zzy)object0).zza();
                                                        if(this.zzm == v2) {
                                                            boolean z2 = ((zzy)object0).zzg();
                                                            return this.zzn == z2;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zza, this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), this.zzi, Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), this.zzl, this.zzm, Boolean.valueOf(this.zzn)});
    }

    @Override
    public final String toString() {
        return Objects.toStringHelper(this).add("GamerTag", this.zzb).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzc)).add("IsProfileVisible", Boolean.valueOf(this.zzd)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zze)).add("Status", this.zza).add("StockProfileImage", this.zzf).add("IsProfileDiscoverable", Boolean.valueOf(this.zzg)).add("AutoSignIn", Boolean.valueOf(this.zzh)).add("httpErrorCode", this.zzi).add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzj)).add("AllowFriendInvites", Boolean.valueOf(this.zzk)).add("ProfileVisibility", this.zzl).add("global_friends_list_visibility", this.zzm).add("always_auto_sign_in", Boolean.valueOf(this.zzn)).toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zza, v, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzf, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel0, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel0, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel0, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel0, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel0, 14, this.zzn);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.games.zzy
    public final int zza() {
        return this.zzm;
    }

    @Override  // com.google.android.gms.games.zzy
    public final int zzb() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.zzy
    public final int zzc() {
        return this.zzl;
    }

    @Override  // com.google.android.gms.games.zzy
    public final StockProfileImage zzd() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.zzy
    public final String zze() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzf() {
        return this.zzk;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzg() {
        return this.zzn;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzh() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzi() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzj() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzk() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzl() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.zzy
    public final boolean zzm() {
        return this.zze;
    }
}

