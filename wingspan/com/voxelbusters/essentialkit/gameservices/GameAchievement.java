package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;
import com.voxelbusters.essentialkit.utilities.common.interfaces.ILoadAssetListener;
import java.util.Date;

public class GameAchievement {
    public static class Builder {
        private Achievement achievement;
        private Context context;

        public GameAchievement build() {
            return new GameAchievement(this.context, this.achievement, null);
        }

        public Builder withAchievement(Context context0, Achievement achievement0) {
            this.context = context0;
            this.achievement = achievement0;
            return this;
        }
    }

    private Achievement achievement;
    private AchievementsClient client;
    private Context context;

    private GameAchievement(Context context0, Achievement achievement0) {
        this.context = context0;
        this.achievement = achievement0;
        this.client = Games.getAchievementsClient(context0, GoogleSignIn.getLastSignedInAccount(context0));
    }

    public GameAchievement(Context context0, Achievement achievement0, a gameAchievement$a0) {
        this(context0, achievement0);
    }

    @Override
    public void finalize() {
        System.out.println("Deallocating native : " + this.hashCode());
        super.finalize();
    }

    public int getCurrentSteps() {
        if(this.achievement.getType() == 1) {
            return this.achievement.getCurrentSteps();
        }
        return this.achievement.getState() == 0 ? 1 : 0;
    }

    public String getDescription() {
        return this.achievement.getDescription();
    }

    public String getId() {
        return this.achievement.getAchievementId();
    }

    public Date getLastReportedDate() {
        return this.achievement.getLastUpdatedTimestamp() == -1L ? null : new Date(this.achievement.getLastUpdatedTimestamp());
    }

    public String getName() {
        return this.achievement.getName();
    }

    public int getTotalSteps() {
        return this.achievement.getType() == 1 ? this.achievement.getTotalSteps() : 1;
    }

    @SkipInCodeGenerator
    public int getType() {
        return this.achievement.getType();
    }

    public boolean isHidden() {
        return this.achievement.getState() == 2;
    }

    public boolean isRevealed() {
        return this.achievement.getState() == 1;
    }

    public boolean isUnlocked() {
        return this.achievement.getState() == 0;
    }

    public void loadRevealedImage(ILoadAssetListener iLoadAssetListener0) {
        ImageManagerUtility.loadImage(((Activity)this.context), this.achievement.getRevealedImageUri(), iLoadAssetListener0);
    }

    public void loadUnlockedImage(ILoadAssetListener iLoadAssetListener0) {
        ImageManagerUtility.loadImage(((Activity)this.context), this.achievement.getUnlockedImageUri(), iLoadAssetListener0);
    }

    public void reportProgress(int v, IReportProgressListener iGameServices$IReportProgressListener0) {
        public final class a implements OnCompleteListener {
            public final IReportProgressListener a;
            public final GameAchievement b;

            public a(IReportProgressListener iGameServices$IReportProgressListener0) {
                this.a = iGameServices$IReportProgressListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                this.a.onSuccess();
            }
        }


        public final class b implements OnFailureListener {
            public final IReportProgressListener a;
            public final GameAchievement b;

            public b(IReportProgressListener iGameServices$IReportProgressListener0) {
                this.a = iGameServices$IReportProgressListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exception0) {
                Logger.error(exception0.getMessage());
                this.a.onFailure("Unable to report progress! Try again later.");
            }
        }


        public final class c implements OnCompleteListener {
            public final IReportProgressListener a;
            public final GameAchievement b;

            public c(IReportProgressListener iGameServices$IReportProgressListener0) {
                this.a = iGameServices$IReportProgressListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                this.a.onSuccess();
            }
        }


        public final class d implements OnFailureListener {
            public final IReportProgressListener a;
            public final GameAchievement b;

            public d(IReportProgressListener iGameServices$IReportProgressListener0) {
                this.a = iGameServices$IReportProgressListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exception0) {
                Logger.error(exception0.getMessage());
                this.a.onFailure("Failed unlocking achievement. Try again later.");
            }
        }

        b gameAchievement$b0;
        Task task0;
        if(this.achievement.getType() == 1) {
            if(v >= 0 && this.achievement.getState() == 2) {
                Logger.debug("Reveal the achievement now!");
                this.client.reveal(this.achievement.getAchievementId());
            }
            Logger.debug(("totalSteps : " + this.achievement.getTotalSteps() + " Steps to set : " + v));
            if(v == 0) {
                if(iGameServices$IReportProgressListener0 != null) {
                    iGameServices$IReportProgressListener0.onSuccess();
                }
                Logger.debug("Reported 0 steps. So, returning success instantly!");
                return;
            }
            if(iGameServices$IReportProgressListener0 != null) {
                task0 = this.client.setStepsImmediate(this.achievement.getAchievementId(), v);
                task0.addOnCompleteListener(new a(this, iGameServices$IReportProgressListener0));
                gameAchievement$b0 = new b(this, iGameServices$IReportProgressListener0);
                task0.addOnFailureListener(gameAchievement$b0);
                return;
            }
            this.client.setSteps(this.achievement.getAchievementId(), v);
            return;
        }
        if(v >= 0) {
            if(v == 0) {
                Logger.debug("This is not an incremental achievement. So just trying to reveal it as 100% progress was not sent as progress.");
                this.client.reveal(this.achievement.getAchievementId());
                return;
            }
            Logger.debug("Unlocking Achievement");
            this.client.unlockImmediate(this.achievement.getAchievementId());
            AchievementsClient achievementsClient0 = this.client;
            if(iGameServices$IReportProgressListener0 != null) {
                task0 = achievementsClient0.unlockImmediate(this.achievement.getAchievementId());
                task0.addOnCompleteListener(new c(this, iGameServices$IReportProgressListener0));
                gameAchievement$b0 = new d(this, iGameServices$IReportProgressListener0);
                task0.addOnFailureListener(gameAchievement$b0);
                return;
            }
            achievementsClient0.unlock(this.achievement.getAchievementId());
        }
        else if(iGameServices$IReportProgressListener0 != null) {
            iGameServices$IReportProgressListener0.onFailure("Reported wrong progress value. Cannot be negative!");
        }
    }

    @Override
    @SkipInCodeGenerator
    public String toString() {
        return "[" + ("Name : " + this.getName()) + "][" + ("Type : " + this.getType()) + "][" + ("Description : " + this.getDescription()) + "][" + ("Total Steps : " + this.getTotalSteps()) + "][" + ("Current Steps : " + this.getCurrentSteps()) + "][" + ("Last Reported Date : " + this.getLastReportedDate()) + "][" + ("Is Hidden : " + this.isHidden()) + "][" + ("Is Revealed : " + this.isRevealed()) + "][" + ("Is Unlocked : " + this.isUnlocked()) + "]";
    }
}

