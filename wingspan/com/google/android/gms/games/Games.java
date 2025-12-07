package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzf;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzac;
import com.google.android.gms.internal.games.zzah;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.internal.games.zzay;
import com.google.android.gms.internal.games.zzbb;
import com.google.android.gms.internal.games.zzbg;
import com.google.android.gms.internal.games.zzbt;
import com.google.android.gms.internal.games.zzcm;
import com.google.android.gms.internal.games.zzco;
import com.google.android.gms.internal.games.zzcy;
import com.google.android.gms.internal.games.zzdi;
import com.google.android.gms.internal.games.zzds;
import com.google.android.gms.internal.games.zzek;
import com.google.android.gms.internal.games.zzep;
import com.google.android.gms.internal.games.zzex;
import com.google.android.gms.internal.games.zzfk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Games {
    public static final class GamesOptions implements GoogleSignInOptionsExtension, HasGoogleSignInAccountOptions, Optional {
        public static final class Builder {
            boolean zza;
            int zzb;
            int zzc;
            ArrayList zzd;
            GoogleSignInAccount zze;
            int zzf;
            zzf zzg;
            private static final AtomicInteger zzh;

            static {
                Builder.zzh = new AtomicInteger(0);
            }

            private Builder() {
                this.zza = true;
                this.zzb = 17;
                this.zzc = 0x1110;
                this.zzd = new ArrayList();
                this.zze = null;
                this.zzf = 9;
                this.zzg = zzf.zza;
            }

            Builder(GamesOptions games$GamesOptions0, zzm zzm0) {
                this.zza = true;
                this.zzb = 17;
                this.zzc = 0x1110;
                this.zzd = new ArrayList();
                this.zze = null;
                this.zzf = 9;
                this.zzg = zzf.zza;
                if(games$GamesOptions0 != null) {
                    this.zza = games$GamesOptions0.zzb;
                    this.zzb = games$GamesOptions0.zzc;
                    this.zzc = games$GamesOptions0.zze;
                    this.zzd = games$GamesOptions0.zzg;
                    this.zze = games$GamesOptions0.zzk;
                    this.zzf = games$GamesOptions0.zzm;
                    this.zzg = games$GamesOptions0.zzo;
                }
            }

            Builder(zzm zzm0) {
                this.zza = true;
                this.zzb = 17;
                this.zzc = 0x1110;
                this.zzd = new ArrayList();
                this.zze = null;
                this.zzf = 9;
                this.zzg = zzf.zza;
            }

            public GamesOptions build() {
                return new GamesOptions(false, this.zza, this.zzb, false, this.zzc, null, this.zzd, false, false, false, this.zze, null, 0, this.zzf, null, this.zzg, null);
            }

            public Builder setSdkVariant(int v) {
                this.zzc = v;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z) {
                this.zza = z;
                this.zzb = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z, int v) {
                this.zza = z;
                this.zzb = v;
                return this;
            }
        }

        public final boolean zza;
        public final boolean zzb;
        public final int zzc;
        public final boolean zzd;
        public final int zze;
        public final String zzf;
        public final ArrayList zzg;
        public final boolean zzh;
        public final boolean zzi;
        public final boolean zzj;
        public final GoogleSignInAccount zzk;
        public final String zzl;
        public final int zzm;
        public final String zzn;
        public zzf zzo;
        public static final int zzp;
        private final int zzq;

        GamesOptions(boolean z, boolean z1, int v, boolean z2, int v1, String s, ArrayList arrayList0, boolean z3, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount0, String s1, int v2, int v3, String s2, zzf zzf0, zzn zzn0) {
            this.zza = false;
            this.zzb = z1;
            this.zzc = v;
            this.zzd = false;
            this.zze = v1;
            this.zzf = null;
            this.zzg = arrayList0;
            this.zzh = false;
            this.zzi = false;
            this.zzj = false;
            this.zzk = googleSignInAccount0;
            this.zzl = null;
            this.zzq = 0;
            this.zzm = v3;
            this.zzn = null;
            this.zzo = zzf0;
        }

        public static Builder builder() {
            return new Builder(null);
        }

        @Override
        public final boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            if(!(object0 instanceof GamesOptions)) {
                return false;
            }
            if(this.zzb == ((GamesOptions)object0).zzb && this.zzc == ((GamesOptions)object0).zzc && this.zze == ((GamesOptions)object0).zze && this.zzg.equals(((GamesOptions)object0).zzg)) {
                GoogleSignInAccount googleSignInAccount0 = this.zzk;
                if(googleSignInAccount0 == null) {
                    return ((GamesOptions)object0).zzk == null ? TextUtils.equals(null, null) && this.zzm == ((GamesOptions)object0).zzm && Objects.equal(null, null) : false;
                }
                return googleSignInAccount0.equals(((GamesOptions)object0).zzk) ? TextUtils.equals(null, null) && this.zzm == ((GamesOptions)object0).zzm && Objects.equal(null, null) : false;
            }
            return false;
        }

        @Override  // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final int getExtensionType() {
            return 1;
        }

        @Override  // com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzk;
        }

        @Override  // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final List getImpliedScopes() {
            return Collections.singletonList(Games.SCOPE_GAMES_LITE);
        }

        @Override
        public final int hashCode() {
            int v = ((((this.zzb + 0x3FD1) * 0x1F + this.zzc) * 961 + this.zze) * 961 + this.zzg.hashCode()) * 0xE1781;
            return this.zzk == null ? (v * 0x745F + this.zzm) * 0x1F : ((v + this.zzk.hashCode()) * 0x745F + this.zzm) * 0x1F;
        }

        @Override  // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final Bundle toBundle() {
            return this.zza();
        }

        public final Bundle zza() {
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("com.google.android.gms.games.key.isHeadless", false);
            bundle0.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzb);
            bundle0.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzc);
            bundle0.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
            bundle0.putInt("com.google.android.gms.games.key.sdkVariant", this.zze);
            bundle0.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
            bundle0.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzg);
            bundle0.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
            bundle0.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
            bundle0.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
            bundle0.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzk);
            bundle0.putString("com.google.android.gms.games.key.realClientPackageName", null);
            bundle0.putInt("com.google.android.gms.games.key.API_VERSION", this.zzm);
            bundle0.putString("com.google.android.gms.games.key.gameRunToken", null);
            return bundle0;
        }
    }

    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    @Deprecated
    public static final Api API = null;
    @Deprecated
    public static final Achievements Achievements = null;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    @Deprecated
    public static final Events Events;
    @Deprecated
    public static final GamesMetadata GamesMetadata;
    @Deprecated
    public static final Leaderboards Leaderboards;
    @Deprecated
    public static final Players Players;
    public static final Scope SCOPE_GAMES;
    public static final Scope SCOPE_GAMES_LITE;
    public static final Scope SCOPE_GAMES_SNAPSHOTS;
    @Deprecated
    public static final Snapshots Snapshots;
    @Deprecated
    public static final Stats Stats;
    @Deprecated
    public static final Videos Videos;
    static final ClientKey zza;
    public static final Scope zzb;
    public static final Api zzc;
    private static final AbstractClientBuilder zzd;
    private static final AbstractClientBuilder zze;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        Games.zza = api$ClientKey0;
        zzg zzg0 = new zzg();
        Games.zzd = zzg0;
        zzh zzh0 = new zzh();
        Games.zze = zzh0;
        Games.SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
        Games.SCOPE_GAMES_LITE = new Scope("https://www.googleapis.com/auth/games_lite");
        Games.SCOPE_GAMES_SNAPSHOTS = new Scope("https://www.googleapis.com/auth/drive.appdata");
        Games.API = new Api("Games.API", zzg0, api$ClientKey0);
        Games.zzb = new Scope("https://www.googleapis.com/auth/games.firstparty");
        Games.zzc = new Api("Games.API_1P", zzh0, api$ClientKey0);
        Games.GamesMetadata = new zzbg();
        Games.Achievements = new zzac();
        Games.Events = new zzar();
        Games.Leaderboards = new zzcm();
        Games.Players = new zzdi();
        Games.Snapshots = new zzek();
        Games.Stats = new zzep();
        Games.Videos = new zzfk();
    }

    public static AchievementsClient getAchievementsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzn(activity0, Games.zza(googleSignInAccount0));
    }

    public static AchievementsClient getAchievementsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzn(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static AchievementsClient getAchievementsClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzn(context0, Games.zza(googleSignInAccount0));
    }

    public static AchievementsClient getAchievementsClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new com.google.android.gms.internal.games.zzn(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    @Deprecated
    public static String getCurrentAccountName(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzI();
    }

    public static EventsClient getEventsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzah(activity0, Games.zza(googleSignInAccount0));
    }

    public static EventsClient getEventsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzah(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static EventsClient getEventsClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzah(context0, Games.zza(googleSignInAccount0));
    }

    public static EventsClient getEventsClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzah(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static GamesClient getGamesClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzay(activity0, Games.zza(googleSignInAccount0));
    }

    public static GamesClient getGamesClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzay(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static GamesClient getGamesClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzay(context0, Games.zza(googleSignInAccount0));
    }

    public static GamesClient getGamesClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzay(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbb(activity0, Games.zza(googleSignInAccount0));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbb(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbb(context0, Games.zza(googleSignInAccount0));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbb(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbt(activity0, Games.zza(googleSignInAccount0));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbt(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbt(context0, Games.zza(googleSignInAccount0));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzbt(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzco(activity0, Games.zza(googleSignInAccount0));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzco(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzco(context0, Games.zza(googleSignInAccount0));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzco(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static PlayersClient getPlayersClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzcy(activity0, Games.zza(googleSignInAccount0));
    }

    public static PlayersClient getPlayersClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzcy(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static PlayersClient getPlayersClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzcy(context0, Games.zza(googleSignInAccount0));
    }

    public static PlayersClient getPlayersClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzcy(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzds(activity0, Games.zza(googleSignInAccount0));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzds(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    public static SnapshotsClient getSnapshotsClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzds(context0, Games.zza(googleSignInAccount0));
    }

    public static SnapshotsClient getSnapshotsClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzds(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    @Deprecated
    public static VideosClient getVideosClient(Activity activity0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzex(activity0, Games.zza(googleSignInAccount0));
    }

    @Deprecated
    public static VideosClient getVideosClient(Activity activity0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzex(activity0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    @Deprecated
    public static VideosClient getVideosClient(Context context0, GoogleSignInAccount googleSignInAccount0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzex(context0, Games.zza(googleSignInAccount0));
    }

    @Deprecated
    public static VideosClient getVideosClient(Context context0, GoogleSignInAccount googleSignInAccount0, GamesOptions games$GamesOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0, "GoogleSignInAccount must not be null");
        return new zzex(context0, Games.zzb(games$GamesOptions0, googleSignInAccount0));
    }

    @Deprecated
    public static PendingResult signOut(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzi(googleApiClient0));
    }

    public static GamesOptions zza(GoogleSignInAccount googleSignInAccount0) {
        Builder games$GamesOptions$Builder0 = new Builder(null, null);
        games$GamesOptions$Builder0.zze = googleSignInAccount0;
        games$GamesOptions$Builder0.setSdkVariant(0x101113);
        return games$GamesOptions$Builder0.build();
    }

    public static GamesOptions zzb(GamesOptions games$GamesOptions0, GoogleSignInAccount googleSignInAccount0) {
        Builder games$GamesOptions$Builder0 = new Builder(games$GamesOptions0, null);
        games$GamesOptions$Builder0.zze = googleSignInAccount0;
        games$GamesOptions$Builder0.setSdkVariant(0x101113);
        return games$GamesOptions$Builder0.build();
    }

    public static zzbz zzc(GoogleApiClient googleApiClient0, boolean z) {
        Preconditions.checkState(googleApiClient0.hasApi(Games.API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean z1 = googleApiClient0.hasConnectedApi(Games.API);
        if(z) {
            if(!z1) {
                throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
            }
            return (zzbz)googleApiClient0.getClient(Games.zza);
        }
        return z1 ? ((zzbz)googleApiClient0.getClient(Games.zza)) : null;
    }

    public static zzbz zzd(GoogleApiClient googleApiClient0, boolean z) {
        Preconditions.checkArgument(googleApiClient0 != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient0.isConnected(), "GoogleApiClient must be connected.");
        return Games.zzc(googleApiClient0, z);
    }
}

