package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzac extends zza {
    private final TaskCompletionSource zza;

    zzac(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzc(DataHolder dataHolder0) {
        int v = dataHolder0.getStatusCode();
        if(v != 0 && v != 3) {
            GamesStatusUtils.zza(this.zza, v);
            dataHolder0.close();
            return;
        }
        AnnotatedData annotatedData0 = new AnnotatedData(new AchievementBuffer(dataHolder0), v == 3);
        this.zza.setResult(annotatedData0);
    }
}

