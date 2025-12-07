package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games.zzfn;
import com.google.android.gms.internal.games.zzft;

final class zzam extends zzfn {
    final zzbz zza;

    zzam(zzbz zzbz0) {
        this.zza = zzbz0;
        super(zzbz0.getContext().getMainLooper(), 1000);
    }

    @Override  // com.google.android.gms.internal.games.zzfn
    protected final void zza(String s, int v) {
        try {
            if(this.zza.isConnected()) {
                ((zzce)this.zza.getService()).zzD(s, v);
                return;
            }
            zzft.zza("GamesGmsClientImpl", "Unable to increment event " + s + " by " + v + " because the games client is no longer connected");
        }
        catch(RemoteException remoteException0) {
            zzbz.zzbf(remoteException0);
        }
        catch(SecurityException securityException0) {
            zzft.zzb("GamesGmsClientImpl", "Is player signed out?", securityException0);
        }
    }
}

