package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.internal.zzce;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzcr implements RemoteCall {
    public final Player zza;

    public zzcr(Player player0) {
        this.zza = player0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        PlayerEntity playerEntity0 = new PlayerEntity(this.zza);
        Intent intent0 = ((zzce)((zzbz)object0).getService()).zzi(playerEntity0);
        intent0.setExtrasClassLoader(playerEntity0.getClass().getClassLoader());
        ((TaskCompletionSource)object1).setResult(intent0);
    }
}

