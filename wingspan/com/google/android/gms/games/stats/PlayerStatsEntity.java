package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.games.internal.zzc;

public class PlayerStatsEntity extends zzc implements PlayerStats {
    public static final Parcelable.Creator CREATOR;
    private final float zza;
    private final float zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final float zzf;
    private final float zzg;
    private final Bundle zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;

    static {
        PlayerStatsEntity.CREATOR = new zza();
    }

    PlayerStatsEntity(float f, float f1, int v, int v1, int v2, float f2, float f3, Bundle bundle0, float f4, float f5, float f6) {
        this.zza = f;
        this.zzb = f1;
        this.zzc = v;
        this.zzd = v1;
        this.zze = v2;
        this.zzf = f2;
        this.zzg = f3;
        this.zzh = bundle0;
        this.zzi = f4;
        this.zzj = f5;
        this.zzk = f6;
    }

    public PlayerStatsEntity(PlayerStats playerStats0) {
        this.zza = playerStats0.getAverageSessionLength();
        this.zzb = playerStats0.getChurnProbability();
        this.zzc = playerStats0.getDaysSinceLastPlayed();
        this.zzd = playerStats0.getNumberOfPurchases();
        this.zze = playerStats0.getNumberOfSessions();
        this.zzf = playerStats0.getSessionPercentile();
        this.zzg = playerStats0.getSpendPercentile();
        this.zzi = playerStats0.getSpendProbability();
        this.zzj = playerStats0.getHighSpenderProbability();
        this.zzk = playerStats0.getTotalSpendNext28Days();
        this.zzh = playerStats0.zza();
    }

    @Override
    public final boolean equals(Object object0) {
        return PlayerStatsEntity.zzd(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getAverageSessionLength() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getChurnProbability() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final int getDaysSinceLastPlayed() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getHighSpenderProbability() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfPurchases() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfSessions() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getSessionPercentile() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendPercentile() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendProbability() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getTotalSpendNext28Days() {
        return this.zzk;
    }

    @Override
    public final int hashCode() {
        return PlayerStatsEntity.zzb(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return PlayerStatsEntity.zzc(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zza.zza(this, parcel0, v);
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final Bundle zza() {
        return this.zzh;
    }

    static int zzb(PlayerStats playerStats0) {
        return Objects.hashCode(new Object[]{playerStats0.getAverageSessionLength(), playerStats0.getChurnProbability(), playerStats0.getDaysSinceLastPlayed(), playerStats0.getNumberOfPurchases(), playerStats0.getNumberOfSessions(), playerStats0.getSessionPercentile(), playerStats0.getSpendPercentile(), playerStats0.getSpendProbability(), playerStats0.getHighSpenderProbability(), playerStats0.getTotalSpendNext28Days()});
    }

    static String zzc(PlayerStats playerStats0) {
        return Objects.toStringHelper(playerStats0).add("AverageSessionLength", playerStats0.getAverageSessionLength()).add("ChurnProbability", playerStats0.getChurnProbability()).add("DaysSinceLastPlayed", playerStats0.getDaysSinceLastPlayed()).add("NumberOfPurchases", playerStats0.getNumberOfPurchases()).add("NumberOfSessions", playerStats0.getNumberOfSessions()).add("SessionPercentile", playerStats0.getSessionPercentile()).add("SpendPercentile", playerStats0.getSpendPercentile()).add("SpendProbability", playerStats0.getSpendProbability()).add("HighSpenderProbability", playerStats0.getHighSpenderProbability()).add("TotalSpendNext28Days", playerStats0.getTotalSpendNext28Days()).toString();
    }

    // 去混淆评级： 低(40)
    static boolean zzd(PlayerStats playerStats0, Object object0) {
        if(!(object0 instanceof PlayerStats)) {
            return false;
        }
        return playerStats0 == object0 ? true : Objects.equal(((PlayerStats)object0).getAverageSessionLength(), playerStats0.getAverageSessionLength()) && Objects.equal(((PlayerStats)object0).getChurnProbability(), playerStats0.getChurnProbability()) && Objects.equal(((PlayerStats)object0).getDaysSinceLastPlayed(), playerStats0.getDaysSinceLastPlayed()) && Objects.equal(((PlayerStats)object0).getNumberOfPurchases(), playerStats0.getNumberOfPurchases()) && Objects.equal(((PlayerStats)object0).getNumberOfSessions(), playerStats0.getNumberOfSessions()) && Objects.equal(((PlayerStats)object0).getSessionPercentile(), playerStats0.getSessionPercentile()) && Objects.equal(((PlayerStats)object0).getSpendPercentile(), playerStats0.getSpendPercentile()) && Objects.equal(((PlayerStats)object0).getSpendProbability(), playerStats0.getSpendProbability()) && Objects.equal(((PlayerStats)object0).getHighSpenderProbability(), playerStats0.getHighSpenderProbability()) && Objects.equal(((PlayerStats)object0).getTotalSpendNext28Days(), playerStats0.getTotalSpendNext28Days());
    }
}

