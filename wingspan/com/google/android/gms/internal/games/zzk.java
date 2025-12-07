package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzk implements RemoteCall {
    public static final zzk zza;

    static {
        zzk.zza = new zzk();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbz zzbz0 = (zzbz)object0;
        TaskCompletionSource taskCompletionSource0 = (TaskCompletionSource)object1;
        try {
            taskCompletionSource0.setResult(((zzce)zzbz0.getService()).zzg());
        }
        catch(SecurityException securityException0) {
            GamesStatusUtils.zzb(taskCompletionSource0, securityException0);
        }
    }
}

