package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.voxelbusters.essentialkit.socialauth.GoogleAuth;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.ArrayBuffer;
import com.voxelbusters.essentialkit.utilities.common.ConnectorFragment;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener;

public class GameAchievements {
    private GameAchievement[] achievements;
    private AchievementsClient client;
    private Context context;

    public GameAchievements(Context context0) {
        this.achievements = null;
        this.context = context0;
        this.client = Games.getAchievementsClient(context0, GoogleSignIn.getLastSignedInAccount(context0));
        Logger.debug("Loading achievements initially");
        this.loadAchievements(null);
    }

    public GameAchievement get(String s) {
        String s1 = s.trim();
        GameAchievement[] arr_gameAchievement = this.achievements;
        for(int v = 0; v < arr_gameAchievement.length; ++v) {
            GameAchievement gameAchievement0 = arr_gameAchievement[v];
            if(gameAchievement0.getId().trim().equals(s1)) {
                Logger.debug(("Achievement details of " + s1 + " : " + gameAchievement0));
                return gameAchievement0;
            }
        }
        Logger.error(("Failed fetching achievement info for ID : " + s1));
        return null;
    }

    public void loadAchievements(ILoadAchievementsListener iGameServices$ILoadAchievementsListener0) {
        public final class a implements OnCompleteListener {
            public final ILoadAchievementsListener a;
            public final GameAchievements b;

            public a(ILoadAchievementsListener iGameServices$ILoadAchievementsListener0) {
                this.a = iGameServices$ILoadAchievementsListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                Logger.debug("loadAchievements finished loading...");
                if(task0.isSuccessful()) {
                    AchievementBuffer achievementBuffer0 = (AchievementBuffer)((AnnotatedData)task0.getResult()).get();
                    int v = achievementBuffer0.getCount();
                    GameAchievement[] arr_gameAchievement = new GameAchievement[v];
                    for(int v1 = 0; v1 < v; ++v1) {
                        Achievement achievement0 = achievementBuffer0.get(v1);
                        arr_gameAchievement[v1] = new Builder().withAchievement(GameAchievements.this.context, ((Achievement)achievement0.freeze())).build();
                    }
                    achievementBuffer0.release();
                    Logger.debug("Deallocating old achievements...");
                    GameAchievements.this.achievements = arr_gameAchievement;
                    ILoadAchievementsListener iGameServices$ILoadAchievementsListener0 = this.a;
                    if(iGameServices$ILoadAchievementsListener0 != null) {
                        iGameServices$ILoadAchievementsListener0.onSuccess(new ArrayBuffer(GameAchievements.this.achievements));
                    }
                }
                else {
                    String s = task0.getException().getMessage();
                    Logger.error(("Error loading achievements info " + s));
                    ILoadAchievementsListener iGameServices$ILoadAchievementsListener1 = this.a;
                    if(iGameServices$ILoadAchievementsListener1 != null) {
                        iGameServices$ILoadAchievementsListener1.onFailure(s);
                    }
                }
            }
        }

        this.client.load(iGameServices$ILoadAchievementsListener0 != null).addOnCompleteListener(((Activity)this.context), new a(this, iGameServices$ILoadAchievementsListener0));
    }

    public void show(IViewListener iGameServices$IViewListener0) {
        public final class b implements OnCompleteListener {
            public final IViewListener a;
            public final GameAchievements b;

            public b(IViewListener iGameServices$IViewListener0) {
                this.a = iGameServices$IViewListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                public final class com.voxelbusters.essentialkit.gameservices.GameAchievements.b.a implements IFragmentResultListener {
                    public final b a;

                    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFragmentResultListener
                    public final void onResult(int v, Intent intent0, boolean z) {
                        IViewListener iGameServices$IViewListener0 = b.this.a;
                        if(iGameServices$IViewListener0 != null) {
                            iGameServices$IViewListener0.onClose((z ? "" : "Failed to launch view"));
                        }
                        if(v == 10001) {
                            GoogleAuth.getInstance(GameAchievements.this.context).signOut(null);
                        }
                    }
                }

                if(task0.isSuccessful()) {
                    Intent intent0 = (Intent)task0.getResult();
                    com.voxelbusters.essentialkit.gameservices.GameAchievements.b.a gameAchievements$b$a0 = new com.voxelbusters.essentialkit.gameservices.GameAchievements.b.a(this);
                    ConnectorFragment.launchIntent(intent0, ((Activity)GameAchievements.this.context), gameAchievements$b$a0);
                    return;
                }
                IViewListener iGameServices$IViewListener0 = this.a;
                if(iGameServices$IViewListener0 != null) {
                    iGameServices$IViewListener0.onClose("Failed to launch view");
                }
            }
        }

        this.client.getAchievementsIntent().addOnCompleteListener(new b(this, iGameServices$IViewListener0));
    }
}

