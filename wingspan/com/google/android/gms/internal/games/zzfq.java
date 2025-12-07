package com.google.android.gms.internal.games;

import android.os.Bundle;
import android.os.IBinder;

public final class zzfq {
    public IBinder zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzfq(int v, IBinder iBinder0) {
        this.zzc = -1;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzb = v;
        this.zza = null;
    }

    public final Bundle zza() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("popupLocationInfo.gravity", this.zzb);
        bundle0.putInt("popupLocationInfo.displayId", this.zzc);
        bundle0.putInt("popupLocationInfo.left", this.zzd);
        bundle0.putInt("popupLocationInfo.top", this.zze);
        bundle0.putInt("popupLocationInfo.right", this.zzf);
        bundle0.putInt("popupLocationInfo.bottom", this.zzg);
        return bundle0;
    }
}

