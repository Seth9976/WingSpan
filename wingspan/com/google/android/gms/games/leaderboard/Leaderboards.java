package com.google.android.gms.games.leaderboard;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface Leaderboards {
    @Deprecated
    public interface LeaderboardMetadataResult extends Releasable, Result {
        LeaderboardBuffer getLeaderboards();
    }

    @Deprecated
    public interface LoadPlayerScoreResult extends Result {
        LeaderboardScore getScore();
    }

    @Deprecated
    public interface LoadScoresResult extends Releasable, Result {
        Leaderboard getLeaderboard();

        LeaderboardScoreBuffer getScores();
    }

    @Deprecated
    public interface SubmitScoreResult extends Releasable, Result {
        ScoreSubmissionData getScoreData();
    }

    Intent getAllLeaderboardsIntent(GoogleApiClient arg1);

    Intent getLeaderboardIntent(GoogleApiClient arg1, String arg2);

    Intent getLeaderboardIntent(GoogleApiClient arg1, String arg2, int arg3);

    Intent getLeaderboardIntent(GoogleApiClient arg1, String arg2, int arg3, int arg4);

    PendingResult loadCurrentPlayerLeaderboardScore(GoogleApiClient arg1, String arg2, int arg3, int arg4);

    PendingResult loadLeaderboardMetadata(GoogleApiClient arg1, String arg2, boolean arg3);

    PendingResult loadLeaderboardMetadata(GoogleApiClient arg1, boolean arg2);

    PendingResult loadMoreScores(GoogleApiClient arg1, LeaderboardScoreBuffer arg2, int arg3, int arg4);

    PendingResult loadPlayerCenteredScores(GoogleApiClient arg1, String arg2, int arg3, int arg4, int arg5);

    PendingResult loadPlayerCenteredScores(GoogleApiClient arg1, String arg2, int arg3, int arg4, int arg5, boolean arg6);

    PendingResult loadTopScores(GoogleApiClient arg1, String arg2, int arg3, int arg4, int arg5);

    PendingResult loadTopScores(GoogleApiClient arg1, String arg2, int arg3, int arg4, int arg5, boolean arg6);

    void submitScore(GoogleApiClient arg1, String arg2, long arg3);

    void submitScore(GoogleApiClient arg1, String arg2, long arg3, String arg4);

    PendingResult submitScoreImmediate(GoogleApiClient arg1, String arg2, long arg3);

    PendingResult submitScoreImmediate(GoogleApiClient arg1, String arg2, long arg3, String arg4);
}

