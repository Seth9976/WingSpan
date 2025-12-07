package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.LeaderboardsClient.LeaderboardScores;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.voxelbusters.essentialkit.socialauth.GoogleAuth;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.ConnectorFragment;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener;
import com.voxelbusters.essentialkit.utilities.common.interfaces.ILoadAssetListener;
import java.util.ArrayList;

public class GameLeaderboard {
    public static class Builder {
        private Context context;
        private Leaderboard leaderboard;
        private String leaderboardId;

        public Builder(Context context0) {
            this.context = context0;
        }

        public GameLeaderboard build() {
            Leaderboard leaderboard0 = this.leaderboard;
            return leaderboard0 == null ? new GameLeaderboard(this.context, this.leaderboardId, null) : new GameLeaderboard(this.context, leaderboard0, null);
        }

        public Builder withLeaderboard(Leaderboard leaderboard0) {
            this.leaderboard = leaderboard0;
            return this;
        }

        public Builder withLeaderboardId(String s) {
            this.leaderboardId = s;
            return this;
        }
    }

    public static final class d {
        public static final int[] a;
        public static final int[] b;

        static {
            int[] arr_v = new int[LeaderboardCollectionVariant.values().length];
            d.b = arr_v;
            try {
                arr_v[LeaderboardCollectionVariant.Public.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                d.b[LeaderboardCollectionVariant.Friends.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            int[] arr_v1 = new int[LeaderboardTimeVariant.values().length];
            d.a = arr_v1;
            try {
                arr_v1[LeaderboardTimeVariant.Daily.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                d.a[LeaderboardTimeVariant.Weekly.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                d.a[LeaderboardTimeVariant.AllTime.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    private LeaderboardsClient client;
    private Context context;
    private Leaderboard leaderboard;
    private String leaderboardId;
    public LeaderboardScoreBuffer leaderboardScoreBufferCache;
    public GameLeaderboardScore localPlayerScore;

    private GameLeaderboard(Context context0, Leaderboard leaderboard0) {
        this.context = context0;
        this.leaderboard = leaderboard0;
        this.client = Games.getLeaderboardsClient(context0, GoogleSignIn.getLastSignedInAccount(context0));
    }

    public GameLeaderboard(Context context0, Leaderboard leaderboard0, a gameLeaderboard$a0) {
        this(context0, leaderboard0);
    }

    private GameLeaderboard(Context context0, String s) {
        this.context = context0;
        this.leaderboardId = s;
        this.client = Games.getLeaderboardsClient(context0, GoogleSignIn.getLastSignedInAccount(context0));
    }

    public GameLeaderboard(Context context0, String s, a gameLeaderboard$a0) {
        this(context0, s);
    }

    private int getCollectionVariant(LeaderboardCollectionVariant leaderboardCollectionVariant0) {
        switch(d.b[leaderboardCollectionVariant0.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 3;
            }
            default: {
                return 2;
            }
        }
    }

    public String getId() {
        return this.leaderboard == null ? this.leaderboardId : this.leaderboard.getLeaderboardId();
    }

    public GameLeaderboardScore getLocalPlayerScore() {
        return this.localPlayerScore;
    }

    public String getName() {
        return this.leaderboard == null ? null : this.leaderboard.getDisplayName();
    }

    private int getTimeVariant(LeaderboardTimeVariant leaderboardTimeVariant0) {
        switch(d.a[leaderboardTimeVariant0.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            default: {
                return 2;
            }
        }
    }

    public void loadImage(ILoadAssetListener iLoadAssetListener0) {
        Leaderboard leaderboard0 = this.leaderboard;
        if(leaderboard0 != null) {
            ImageManagerUtility.loadImage(((Activity)this.context), leaderboard0.getIconImageUri(), iLoadAssetListener0);
            return;
        }
        iLoadAssetListener0.onFailure("Unable to load as no leaderboard instance available");
    }

    public void loadLocalPlayerScore(LeaderboardTimeVariant leaderboardTimeVariant0, LeaderboardCollectionVariant leaderboardCollectionVariant0, ILoadLocalPlayerScoreListener iGameServices$ILoadLocalPlayerScoreListener0) {
        public final class c implements OnCompleteListener {
            public final ILoadLocalPlayerScoreListener a;
            public final GameLeaderboard b;

            public c(ILoadLocalPlayerScoreListener iGameServices$ILoadLocalPlayerScoreListener0) {
                this.a = iGameServices$ILoadLocalPlayerScoreListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                GameLeaderboardScore gameLeaderboardScore0;
                if(task0.isSuccessful()) {
                    LeaderboardScore leaderboardScore0 = (LeaderboardScore)((AnnotatedData)task0.getResult()).get();
                    Logger.debug(("Loaded local player score : " + leaderboardScore0));
                    ILoadLocalPlayerScoreListener iGameServices$ILoadLocalPlayerScoreListener0 = this.a;
                    if(iGameServices$ILoadLocalPlayerScoreListener0 != null) {
                        if(leaderboardScore0 == null) {
                            gameLeaderboardScore0 = null;
                        }
                        else {
                            String s = GameLeaderboard.this.getId();
                            gameLeaderboardScore0 = new com.voxelbusters.essentialkit.gameservices.GameLeaderboardScore.Builder(GameLeaderboard.this.context, s).withScore(leaderboardScore0).build();
                            iGameServices$ILoadLocalPlayerScoreListener0 = this.a;
                        }
                        iGameServices$ILoadLocalPlayerScoreListener0.onSuccess(gameLeaderboardScore0);
                    }
                }
                else {
                    String s1 = task0.getException().getMessage();
                    ILoadLocalPlayerScoreListener iGameServices$ILoadLocalPlayerScoreListener1 = this.a;
                    if(iGameServices$ILoadLocalPlayerScoreListener1 != null) {
                        iGameServices$ILoadLocalPlayerScoreListener1.onFailure(s1);
                    }
                }
            }
        }

        this.client.loadCurrentPlayerLeaderboardScore(this.getId(), this.getTimeVariant(leaderboardTimeVariant0), this.getCollectionVariant(leaderboardCollectionVariant0)).addOnCompleteListener(new c(this, iGameServices$ILoadLocalPlayerScoreListener0));
    }

    public void loadMoreScores(int v, int v1, ILoadScoresListener iGameServices$ILoadScoresListener0) {
        LeaderboardScoreBuffer leaderboardScoreBuffer0 = this.leaderboardScoreBufferCache;
        if(leaderboardScoreBuffer0 == null) {
            Logger.warning("No previous scores buffer found. So loading top scores by default. Make sure you call either loadTopScores or loadPlayerCenteredScores before calling this method.");
            this.loadTopScores(LeaderboardTimeVariant.AllTime, LeaderboardCollectionVariant.Public, v, true, iGameServices$ILoadScoresListener0);
            return;
        }
        this.processScoresTask(this.client.loadMoreScores(leaderboardScoreBuffer0, v, (v1 == 1 ? 0 : 1)), iGameServices$ILoadScoresListener0);
    }

    public void loadPlayerCenteredScores(LeaderboardTimeVariant leaderboardTimeVariant0, LeaderboardCollectionVariant leaderboardCollectionVariant0, int v, boolean z, ILoadScoresListener iGameServices$ILoadScoresListener0) {
        this.processScoresTask(this.client.loadPlayerCenteredScores(this.getId(), this.getTimeVariant(leaderboardTimeVariant0), this.getCollectionVariant(leaderboardCollectionVariant0), v, z), iGameServices$ILoadScoresListener0);
    }

    public void loadTopScores(LeaderboardTimeVariant leaderboardTimeVariant0, LeaderboardCollectionVariant leaderboardCollectionVariant0, int v, boolean z, ILoadScoresListener iGameServices$ILoadScoresListener0) {
        this.processScoresTask(this.client.loadTopScores(this.getId(), this.getTimeVariant(leaderboardTimeVariant0), this.getCollectionVariant(leaderboardCollectionVariant0), v, z), iGameServices$ILoadScoresListener0);
    }

    private void processScoresTask(Task task0, ILoadScoresListener iGameServices$ILoadScoresListener0) {
        public final class b implements OnCompleteListener {
            public final ILoadScoresListener a;
            public final GameLeaderboard b;

            public b(ILoadScoresListener iGameServices$ILoadScoresListener0) {
                this.a = iGameServices$ILoadScoresListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                try {
                    if(task0.isSuccessful()) {
                        LeaderboardScoreBuffer leaderboardScoreBuffer0 = ((LeaderboardScores)((AnnotatedData)task0.getResult()).get()).getScores();
                        LeaderboardScoreBuffer leaderboardScoreBuffer1 = GameLeaderboard.this.leaderboardScoreBufferCache;
                        if(leaderboardScoreBuffer1 != null) {
                            leaderboardScoreBuffer1.release();
                        }
                        GameLeaderboard.this.leaderboardScoreBufferCache = leaderboardScoreBuffer0;
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object0: leaderboardScoreBuffer0) {
                            arrayList0.add(new com.voxelbusters.essentialkit.gameservices.GameLeaderboardScore.Builder(GameLeaderboard.this.context, GameLeaderboard.this.getId()).withScore(((LeaderboardScore)((LeaderboardScore)object0).freeze())).build());
                        }
                        ILoadScoresListener iGameServices$ILoadScoresListener0 = this.a;
                        if(iGameServices$ILoadScoresListener0 != null) {
                            iGameServices$ILoadScoresListener0.onSuccess(arrayList0);
                        }
                    }
                    else {
                        String s = task0.getException().getMessage();
                        ILoadScoresListener iGameServices$ILoadScoresListener1 = this.a;
                        if(iGameServices$ILoadScoresListener1 != null) {
                            iGameServices$ILoadScoresListener1.onFailure(s);
                        }
                    }
                }
                catch(Exception exception0) {
                    if(this.a != null) {
                        Log.e("GameLeaderboard", "Failed to interate through scores. ");
                        exception0.printStackTrace();
                        this.a.onFailure(exception0.getMessage());
                    }
                }
            }
        }

        task0.addOnCompleteListener(new b(this, iGameServices$ILoadScoresListener0));
    }

    @RunOnUiThread
    public void show(LeaderboardTimeVariant leaderboardTimeVariant0, IViewListener iGameServices$IViewListener0) {
        public final class a implements OnCompleteListener {
            public final IViewListener a;
            public final GameLeaderboard b;

            public a(IViewListener iGameServices$IViewListener0) {
                this.a = iGameServices$IViewListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                public final class com.voxelbusters.essentialkit.gameservices.GameLeaderboard.a.a implements IFragmentResultListener {
                    public final a a;

                    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener
                    public final void onResult(int v, Intent intent0, boolean z) {
                        a.this.a.onClose((z ? "" : "Failed to launch view"));
                        if(v == 10001) {
                            GoogleAuth.getInstance(GameLeaderboard.this.context).signOut(null);
                        }
                    }
                }

                if(task0.isSuccessful()) {
                    Intent intent0 = (Intent)task0.getResult();
                    com.voxelbusters.essentialkit.gameservices.GameLeaderboard.a.a gameLeaderboard$a$a0 = new com.voxelbusters.essentialkit.gameservices.GameLeaderboard.a.a(this);
                    ConnectorFragment.launchIntent(intent0, ((Activity)GameLeaderboard.this.context), gameLeaderboard$a$a0);
                    return;
                }
                IViewListener iGameServices$IViewListener0 = this.a;
                if(iGameServices$IViewListener0 != null) {
                    iGameServices$IViewListener0.onClose("Failed to launch view");
                }
            }
        }

        String s = this.getId();
        this.client.getLeaderboardIntent(s, this.getTimeVariant(leaderboardTimeVariant0)).addOnCompleteListener(new a(this, iGameServices$IViewListener0));
    }
}

