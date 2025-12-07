package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.games.internal.zzc;

public final class MostRecentGameInfoEntity extends zzc implements zza {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final Uri zzd;
    private final Uri zze;
    private final Uri zzf;

    static {
        MostRecentGameInfoEntity.CREATOR = new zzb();
    }

    public MostRecentGameInfoEntity(zza zza0) {
        this.zza = zza0.zze();
        this.zzb = zza0.zzf();
        this.zzc = zza0.zza();
        this.zzd = zza0.zzd();
        this.zze = zza0.zzc();
        this.zzf = zza0.zzb();
    }

    MostRecentGameInfoEntity(String s, String s1, long v, Uri uri0, Uri uri1, Uri uri2) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = v;
        this.zzd = uri0;
        this.zze = uri1;
        this.zzf = uri2;
    }

    @Override
    public final boolean equals(Object object0) {
        return MostRecentGameInfoEntity.zzi(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override
    public final int hashCode() {
        return MostRecentGameInfoEntity.zzg(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return MostRecentGameInfoEntity.zzh(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zzb.zza(this, parcel0, v);
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final long zza() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final Uri zzb() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final Uri zzc() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final Uri zzd() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final String zze() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.internal.player.zza
    public final String zzf() {
        return this.zzb;
    }

    static int zzg(zza zza0) {
        return Objects.hashCode(new Object[]{zza0.zze(), zza0.zzf(), zza0.zza(), zza0.zzd(), zza0.zzc(), zza0.zzb()});
    }

    static String zzh(zza zza0) {
        return Objects.toStringHelper(zza0).add("GameId", zza0.zze()).add("GameName", zza0.zzf()).add("ActivityTimestampMillis", zza0.zza()).add("GameIconUri", zza0.zzd()).add("GameHiResUri", zza0.zzc()).add("GameFeaturedUri", zza0.zzb()).toString();
    }

    // 去混淆评级： 低(26)
    static boolean zzi(zza zza0, Object object0) {
        if(!(object0 instanceof zza)) {
            return false;
        }
        return zza0 == object0 ? true : Objects.equal(((zza)object0).zze(), zza0.zze()) && Objects.equal(((zza)object0).zzf(), zza0.zzf()) && Objects.equal(((zza)object0).zza(), zza0.zza()) && Objects.equal(((zza)object0).zzd(), zza0.zzd()) && Objects.equal(((zza)object0).zzc(), zza0.zzc()) && Objects.equal(((zza)object0).zzb(), zza0.zzb());
    }
}

