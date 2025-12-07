package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.games.zzfl;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zza;
    private final int zzb;
    private final boolean zzc;
    private final long zzd;
    private final String zze;
    private final long zzf;
    private final String zzg;
    private final String zzh;
    private final long zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant0) {
        this.zza = leaderboardVariant0.getTimeSpan();
        this.zzb = leaderboardVariant0.getCollection();
        this.zzc = leaderboardVariant0.hasPlayerInfo();
        this.zzd = leaderboardVariant0.getRawPlayerScore();
        this.zze = leaderboardVariant0.getDisplayPlayerScore();
        this.zzf = leaderboardVariant0.getPlayerRank();
        this.zzg = leaderboardVariant0.getDisplayPlayerRank();
        this.zzh = leaderboardVariant0.getPlayerScoreTag();
        this.zzi = leaderboardVariant0.getNumScores();
        this.zzj = leaderboardVariant0.zza();
        this.zzk = leaderboardVariant0.zzc();
        this.zzl = leaderboardVariant0.zzb();
    }

    @Override
    public final boolean equals(Object object0) {
        return LeaderboardVariantEntity.zzf(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        return this.zzi;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return this.zzc;
    }

    @Override
    public final int hashCode() {
        return LeaderboardVariantEntity.zzd(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override
    public final String toString() {
        return LeaderboardVariantEntity.zze(this);
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zza() {
        return this.zzj;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzb() {
        return this.zzl;
    }

    @Override  // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzc() {
        return this.zzk;
    }

    static int zzd(LeaderboardVariant leaderboardVariant0) {
        return Objects.hashCode(new Object[]{leaderboardVariant0.getTimeSpan(), leaderboardVariant0.getCollection(), Boolean.valueOf(leaderboardVariant0.hasPlayerInfo()), leaderboardVariant0.getRawPlayerScore(), leaderboardVariant0.getDisplayPlayerScore(), leaderboardVariant0.getPlayerRank(), leaderboardVariant0.getDisplayPlayerRank(), leaderboardVariant0.getNumScores(), leaderboardVariant0.zza(), leaderboardVariant0.zzb(), leaderboardVariant0.zzc()});
    }

    static String zze(LeaderboardVariant leaderboardVariant0) {
        String s = "SOCIAL_1P";
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(leaderboardVariant0).add("TimeSpan", zzfl.zza(leaderboardVariant0.getTimeSpan()));
        int v = leaderboardVariant0.getCollection();
        switch(v) {
            case -1: {
                s = "UNKNOWN";
                break;
            }
            case 0: {
                s = "PUBLIC";
                break;
            }
            default: {
                if(v == 1) {
                    s = "SOCIAL";
                }
                else {
                    switch(v) {
                        case 3: {
                            s = "FRIENDS";
                            break;
                        }
                        case 2: 
                        case 4: {
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Unknown leaderboard collection: " + v);
                        }
                    }
                }
            }
        }
        ToStringHelper objects$ToStringHelper1 = objects$ToStringHelper0.add("Collection", s);
        String s1 = "none";
        Long long0 = leaderboardVariant0.hasPlayerInfo() ? leaderboardVariant0.getRawPlayerScore() : "none";
        ToStringHelper objects$ToStringHelper2 = objects$ToStringHelper1.add("RawPlayerScore", long0).add("DisplayPlayerScore", (leaderboardVariant0.hasPlayerInfo() ? leaderboardVariant0.getDisplayPlayerScore() : "none"));
        Long long1 = leaderboardVariant0.hasPlayerInfo() ? leaderboardVariant0.getPlayerRank() : "none";
        ToStringHelper objects$ToStringHelper3 = objects$ToStringHelper2.add("PlayerRank", long1);
        if(leaderboardVariant0.hasPlayerInfo()) {
            s1 = leaderboardVariant0.getDisplayPlayerRank();
        }
        return objects$ToStringHelper3.add("DisplayPlayerRank", s1).add("NumScores", leaderboardVariant0.getNumScores()).add("TopPageNextToken", leaderboardVariant0.zza()).add("WindowPageNextToken", leaderboardVariant0.zzb()).add("WindowPagePrevToken", leaderboardVariant0.zzc()).toString();
    }

    // 去混淆评级： 低(43)
    static boolean zzf(LeaderboardVariant leaderboardVariant0, Object object0) {
        if(!(object0 instanceof LeaderboardVariant)) {
            return false;
        }
        return leaderboardVariant0 == object0 ? true : Objects.equal(((LeaderboardVariant)object0).getTimeSpan(), leaderboardVariant0.getTimeSpan()) && Objects.equal(((LeaderboardVariant)object0).getCollection(), leaderboardVariant0.getCollection()) && Objects.equal(Boolean.valueOf(((LeaderboardVariant)object0).hasPlayerInfo()), Boolean.valueOf(leaderboardVariant0.hasPlayerInfo())) && Objects.equal(((LeaderboardVariant)object0).getRawPlayerScore(), leaderboardVariant0.getRawPlayerScore()) && Objects.equal(((LeaderboardVariant)object0).getDisplayPlayerScore(), leaderboardVariant0.getDisplayPlayerScore()) && Objects.equal(((LeaderboardVariant)object0).getPlayerRank(), leaderboardVariant0.getPlayerRank()) && Objects.equal(((LeaderboardVariant)object0).getDisplayPlayerRank(), leaderboardVariant0.getDisplayPlayerRank()) && Objects.equal(((LeaderboardVariant)object0).getNumScores(), leaderboardVariant0.getNumScores()) && Objects.equal(((LeaderboardVariant)object0).zza(), leaderboardVariant0.zza()) && Objects.equal(((LeaderboardVariant)object0).zzb(), leaderboardVariant0.zzb()) && Objects.equal(((LeaderboardVariant)object0).zzc(), leaderboardVariant0.zzc());
    }
}

