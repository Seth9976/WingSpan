package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.voxelbusters.essentialkit.socialauth.GoogleAuth;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.ConnectorFragment;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener;
import java.util.ArrayList;

public class GameLeaderboards {
    public LeaderboardsClient client;
    public Context context;
    private ArrayList leaderboards;

    public GameLeaderboards(Context context0) {
        this.leaderboards = null;
        this.context = context0;
        this.client = Games.getLeaderboardsClient(context0, GoogleSignIn.getLastSignedInAccount(context0));
        this.load(null);
    }

    public GameLeaderboard get(String s) {
        String s1 = s.trim();
        ArrayList arrayList0 = this.leaderboards;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                GameLeaderboard gameLeaderboard0 = (GameLeaderboard)object0;
                if(gameLeaderboard0.getId().equals(s1)) {
                    return gameLeaderboard0;
                }
                if(false) {
                    break;
                }
            }
        }
        return new Builder(this.context).withLeaderboardId(s1).build();
    }

    public void load(ILoadLeaderboardsListener iGameServices$ILoadLeaderboardsListener0) {
        public final class a implements OnCompleteListener {
            public final ILoadLeaderboardsListener a;
            public final GameLeaderboards b;

            public a(ILoadLeaderboardsListener iGameServices$ILoadLeaderboardsListener0) {
                this.a = iGameServices$ILoadLeaderboardsListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                if(task0.isSuccessful()) {
                    ArrayList arrayList0 = new ArrayList();
                    LeaderboardBuffer leaderboardBuffer0 = (LeaderboardBuffer)((AnnotatedData)task0.getResult()).get();
                    for(int v = 0; v < leaderboardBuffer0.getCount(); ++v) {
                        Leaderboard leaderboard0 = (Leaderboard)leaderboardBuffer0.get(v);
                        arrayList0.add(new Builder(GameLeaderboards.this.context).withLeaderboard(((Leaderboard)leaderboard0.freeze())).build());
                    }
                    leaderboardBuffer0.release();
                    GameLeaderboards.this.leaderboards = arrayList0;
                    ILoadLeaderboardsListener iGameServices$ILoadLeaderboardsListener0 = this.a;
                    if(iGameServices$ILoadLeaderboardsListener0 != null) {
                        iGameServices$ILoadLeaderboardsListener0.onSuccess(GameLeaderboards.this.leaderboards);
                    }
                }
                else {
                    String s = task0.getException().getMessage();
                    Logger.error(("Error loading leaderboards info " + s));
                    ILoadLeaderboardsListener iGameServices$ILoadLeaderboardsListener1 = this.a;
                    if(iGameServices$ILoadLeaderboardsListener1 != null) {
                        iGameServices$ILoadLeaderboardsListener1.onFailure(s);
                    }
                }
            }
        }

        this.client.loadLeaderboardMetadata(iGameServices$ILoadLeaderboardsListener0 != null).addOnCompleteListener(((Activity)this.context), new a(this, iGameServices$ILoadLeaderboardsListener0));
    }

    public void show(IViewListener iGameServices$IViewListener0) {
        public final class b implements OnCompleteListener {
            public final IViewListener a;
            public final GameLeaderboards b;

            public b(IViewListener iGameServices$IViewListener0) {
                this.a = iGameServices$IViewListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                public final class com.voxelbusters.essentialkit.gameservices.GameLeaderboards.b.a implements IFragmentResultListener {
                    public final b a;

                    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener
                    public final void onResult(int v, Intent intent0, boolean z) {
                        b.this.a.onClose((z ? "" : "Failed to launch view"));
                        if(v == 10001) {
                            GoogleAuth.getInstance(GameLeaderboards.this.context).signOut(null);
                        }
                    }
                }

                if(task0.isSuccessful()) {
                    ConnectorFragment.launchIntent(((Intent)task0.getResult()), ((Activity)GameLeaderboards.this.context), new com.voxelbusters.essentialkit.gameservices.GameLeaderboards.b.a(this));
                    return;
                }
                IViewListener iGameServices$IViewListener0 = this.a;
                if(iGameServices$IViewListener0 != null) {
                    iGameServices$IViewListener0.onClose("Failed to launch view");
                }
            }
        }

        this.client.getAllLeaderboardsIntent().addOnCompleteListener(new b(this, iGameServices$IViewListener0));
    }
}

