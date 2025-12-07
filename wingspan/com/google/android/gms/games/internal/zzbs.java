package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.TaskCompletionSource;
import jeb.synthetic.TWR;

final class zzbs extends zza {
    private final TaskCompletionSource zza;

    zzbs(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzn(DataHolder dataHolder0) {
        int v = dataHolder0.getStatusCode();
        if(v != 0 && v != 5) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        try {
            ScoreSubmissionData scoreSubmissionData0 = new ScoreSubmissionData(dataHolder0);
            this.zza.setResult(scoreSubmissionData0);
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(dataHolder0, throwable0);
            throw throwable0;
        }
        dataHolder0.close();
    }
}

