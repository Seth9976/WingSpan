package com.voxelbusters.essentialkit.gameservices;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.Task;
import com.voxelbusters.essentialkit.socialauth.GoogleAuth;
import com.voxelbusters.essentialkit.socialauth.IAuthenticationListener;
import com.voxelbusters.essentialkit.socialauth.ISocialAuth.IFetchServerCredentials;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.StringUtil;
import com.voxelbusters.essentialkit.utilities.common.ArrayBuffer;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;
import java.util.ArrayList;
import java.util.List;

public class GameServices implements IAuthenticationListener, IFeature {
    private final String TAG;
    private GameAchievements achievements;
    private GamePlayer cachedGamePlayer;
    private Context context;
    private GameLeaderboards leaderboards;
    private IPlayerAuthenticationListener listener;

    public GameServices(Context context0) {
        this.TAG = "GameServices";
        this.context = context0;
    }

    @RunOnUiThread
    public void authenticate(IPlayerAuthenticationListener iGameServices$IPlayerAuthenticationListener0, boolean z) {
        this.listener = iGameServices$IPlayerAuthenticationListener0;
        GoogleAuth googleAuth0 = GoogleAuth.getInstance(this.context);
        googleAuth0.addListener(this);
        googleAuth0.Authenticate(z);
    }

    public GameAchievement createAchievement(String s) {
        return this.achievements.get(s);
    }

    public GameLeaderboard createLeaderboard(String s) {
        return this.leaderboards.get(s);
    }

    public GameLeaderboardScore createScore(String s) {
        return new Builder(this.context, s).build();
    }

    public GameAchievement getAchievement(String s) {
        return this.achievements.get(s);
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Game Services";
    }

    public GamePlayer getLocalPlayer() {
        Player player0 = GoogleAuth.getInstance(this.context).getCurrentPlayer();
        if(this.cachedGamePlayer != null && this.cachedGamePlayer.player != player0 || this.cachedGamePlayer == null) {
            this.cachedGamePlayer = player0 == null ? null : new com.voxelbusters.essentialkit.gameservices.GamePlayer.Builder(this.context).withPlayer(player0).build();
        }
        return this.cachedGamePlayer;
    }

    public void loadAchievements(ILoadAchievementsListener iGameServices$ILoadAchievementsListener0) {
        this.achievements.loadAchievements(iGameServices$ILoadAchievementsListener0);
    }

    public void loadLeaderboards(ILoadLeaderboardsListener iGameServices$ILoadLeaderboardsListener0) {
        this.leaderboards.load(iGameServices$ILoadLeaderboardsListener0);
    }

    public void loadPlayer(String s, ILoadPlayersListener iGameServices$ILoadPlayersListener0) {
        this.loadPlayers(new String[]{s}, iGameServices$ILoadPlayersListener0);
    }

    public void loadPlayers(String[] arr_s, ILoadPlayersListener iGameServices$ILoadPlayersListener0) {
        public final class a extends AsyncTask {
            public final ILoadPlayersListener a;
            public final GameServices b;

            public a(ILoadPlayersListener iGameServices$ILoadPlayersListener0) {
                this.a = iGameServices$ILoadPlayersListener0;
                super();
            }

            @Override  // android.os.AsyncTask
            public final Object doInBackground(Object[] arr_object) {
                String[] arr_s = ((String[][])arr_object)[0];
                ArrayList arrayList0 = new ArrayList();
                PlayersClient playersClient0 = Games.getPlayersClient(GameServices.this.context, GoogleSignIn.getLastSignedInAccount(GameServices.this.context));
                for(int v = 0; v < arr_s.length; ++v) {
                    Task task0 = playersClient0.loadPlayer(arr_s[v]);
                    while(!task0.isComplete()) {
                        try {
                            Thread.sleep(1L);
                        }
                        catch(InterruptedException interruptedException0) {
                            interruptedException0.printStackTrace();
                        }
                    }
                    if(task0.isSuccessful()) {
                        Player player0 = (Player)((AnnotatedData)task0.getResult()).get();
                        arrayList0.add(new com.voxelbusters.essentialkit.gameservices.GamePlayer.Builder(GameServices.this.context).withPlayer(player0).build());
                    }
                }
                return arrayList0;
            }

            @Override  // android.os.AsyncTask
            public final void onPostExecute(Object object0) {
                if(((ArrayList)object0) != null || ((ArrayList)object0).size() == 0) {
                    Logger.warning("Error loading user friend details.");
                }
                ILoadPlayersListener iGameServices$ILoadPlayersListener0 = this.a;
                if(iGameServices$ILoadPlayersListener0 != null) {
                    iGameServices$ILoadPlayersListener0.onSuccess(((ArrayList)object0));
                }
            }
        }

        if(GoogleAuth.getInstance(this.context).isSignedIn()) {
            new a(this, iGameServices$ILoadPlayersListener0).execute(new String[][]{arr_s});
            return;
        }
        if(iGameServices$ILoadPlayersListener0 != null) {
            iGameServices$ILoadPlayersListener0.onFailure("SIGN_IN_REQUIRED");
        }
    }

    @RunOnUiThread
    public void loadServerCredentials(ILoadServerCredentials iGameServices$ILoadServerCredentials0) {
        public final class b implements IFetchServerCredentials {
            public final ILoadServerCredentials a;

            public b(ILoadServerCredentials iGameServices$ILoadServerCredentials0) {
            }

            @Override  // com.voxelbusters.essentialkit.socialauth.ISocialAuth$IFetchServerCredentials
            public final void onFailure(String s) {
                this.a.onFailure(s);
            }

            @Override  // com.voxelbusters.essentialkit.socialauth.ISocialAuth$IFetchServerCredentials
            public final void onSuccess(String s, String s1, String s2) {
                this.a.onSuccess(StringUtil.getNonNull(s), StringUtil.getNonNull(s1), StringUtil.getNonNull(s2));
            }
        }

        GoogleAuth.getInstance(this.context).fetchServerAuthCode(new b(iGameServices$ILoadServerCredentials0));
    }

    @Override  // com.voxelbusters.essentialkit.socialauth.IAuthenticationListener
    @SkipInCodeGenerator
    public void onFailure(String s) {
        IPlayerAuthenticationListener iGameServices$IPlayerAuthenticationListener0 = this.listener;
        if(iGameServices$IPlayerAuthenticationListener0 != null) {
            iGameServices$IPlayerAuthenticationListener0.onFailure(s);
        }
    }

    @Override  // com.voxelbusters.essentialkit.socialauth.IAuthenticationListener
    @SkipInCodeGenerator
    public void onSuccess(Player player0) {
        public final class c implements ILoadAchievementsListener {
            public final GamePlayer a;
            public final GameServices b;

            public c(GamePlayer gamePlayer0) {
                this.a = gamePlayer0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.gameservices.IGameServices$ILoadAchievementsListener
            public final void onFailure(String s) {
                Logger.error(("Error when loading achievements : " + s));
                if(GameServices.this.listener != null) {
                    GameServices.this.cachedGamePlayer = null;
                    GameServices.this.listener.onFailure("Failed loading player");
                }
            }

            @Override  // com.voxelbusters.essentialkit.gameservices.IGameServices$ILoadAchievementsListener
            public final void onSuccess(ArrayBuffer arrayBuffer0) {
                public final class com.voxelbusters.essentialkit.gameservices.GameServices.c.a implements ILoadLeaderboardsListener {
                    public final c a;

                    @Override  // com.voxelbusters.essentialkit.gameservices.IGameServices$ILoadLeaderboardsListener
                    public final void onFailure(String s) {
                        Logger.error(("Error when loading leaderboards : " + s));
                        if(GameServices.this.listener != null) {
                            GameServices.this.cachedGamePlayer = null;
                            GameServices.this.listener.onFailure("Failed loading player");
                        }
                    }

                    @Override  // com.voxelbusters.essentialkit.gameservices.IGameServices$ILoadLeaderboardsListener
                    public final void onSuccess(List list0) {
                        GameServices.this.listener.onSuccess(c.this.a);
                    }
                }

                GameServices.this.leaderboards.load(new com.voxelbusters.essentialkit.gameservices.GameServices.c.a(this));
            }
        }

        if(player0 != null) {
            this.achievements = new GameAchievements(this.context);
            this.leaderboards = new GameLeaderboards(this.context);
            GamePlayer gamePlayer0 = new com.voxelbusters.essentialkit.gameservices.GamePlayer.Builder(this.context).withPlayer(player0).build();
            this.cachedGamePlayer = gamePlayer0;
            this.achievements.loadAchievements(new c(this, gamePlayer0));
            return;
        }
        this.cachedGamePlayer = null;
        IPlayerAuthenticationListener iGameServices$IPlayerAuthenticationListener0 = this.listener;
        if(iGameServices$IPlayerAuthenticationListener0 != null) {
            iGameServices$IPlayerAuthenticationListener0.onSuccess(null);
        }
    }

    @RunOnUiThread
    public void showAchievements(IViewListener iGameServices$IViewListener0) {
        this.achievements.show(iGameServices$IViewListener0);
    }

    @RunOnUiThread
    public void showLeaderboards(String s, LeaderboardTimeVariant leaderboardTimeVariant0, IViewListener iGameServices$IViewListener0) {
        if(s == null) {
            this.leaderboards.show(iGameServices$IViewListener0);
            return;
        }
        this.leaderboards.get(s).show(leaderboardTimeVariant0, iGameServices$IViewListener0);
    }

    @RunOnUiThread
    public void signout() {
        GoogleAuth.getInstance(this.context).signOut(null);
    }
}

