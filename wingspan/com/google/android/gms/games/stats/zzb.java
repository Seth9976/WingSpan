package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;

public final class zzb extends DataBufferRef implements PlayerStats {
    private Bundle zza;

    zzb(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return PlayerStatsEntity.zzd(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new PlayerStatsEntity(this);
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getAverageSessionLength() {
        return this.getFloat("ave_session_length_minutes");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getChurnProbability() {
        return this.getFloat("churn_probability");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final int getDaysSinceLastPlayed() {
        return this.getInteger("days_since_last_played");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getHighSpenderProbability() {
        return this.hasColumn("high_spender_probability") ? this.getFloat("high_spender_probability") : -1.0f;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfPurchases() {
        return this.getInteger("num_purchases");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfSessions() {
        return this.getInteger("num_sessions");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getSessionPercentile() {
        return this.getFloat("num_sessions_percentile");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendPercentile() {
        return this.getFloat("spend_percentile");
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendProbability() {
        return this.hasColumn("spend_probability") ? this.getFloat("spend_probability") : -1.0f;
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final float getTotalSpendNext28Days() {
        return this.hasColumn("total_spend_next_28_days") ? this.getFloat("total_spend_next_28_days") : -1.0f;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerStatsEntity.zzb(this);
    }

    @Override
    public final String toString() {
        return PlayerStatsEntity.zzc(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        zza.zza(new PlayerStatsEntity(this), parcel0, v);
    }

    @Override  // com.google.android.gms.games.stats.PlayerStats
    public final Bundle zza() {
        Bundle bundle0 = this.zza;
        if(bundle0 != null) {
            return bundle0;
        }
        this.zza = new Bundle();
        String s = this.getString("unknown_raw_keys");
        String s1 = this.getString("unknown_raw_values");
        if(s != null && s1 != null) {
            String[] arr_s = s.split(",");
            String[] arr_s1 = s1.split(",");
            Asserts.checkState(arr_s.length <= arr_s1.length, "Invalid raw arguments!");
            for(int v = 0; v < arr_s.length; ++v) {
                this.zza.putString(arr_s[v], arr_s1[v]);
            }
        }
        return this.zza;
    }
}

