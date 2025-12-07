package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import jeb.synthetic.TWR;

final class zzbx extends zzao implements SubmitScoreResult {
    private final ScoreSubmissionData zza;

    zzbx(DataHolder dataHolder0) {
        super(dataHolder0);
        try {
            this.zza = new ScoreSubmissionData(dataHolder0);
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(dataHolder0, throwable0);
            throw throwable0;
        }
        dataHolder0.close();
    }

    @Override  // com.google.android.gms.games.leaderboard.Leaderboards$SubmitScoreResult
    public final ScoreSubmissionData getScoreData() {
        return this.zza;
    }
}

