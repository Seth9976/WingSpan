package com.google.android.gms.internal.games;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class zzfr extends zzc {
    public static final Parcelable.Creator CREATOR;
    private final Bundle zza;
    private final IBinder zzb;

    static {
        zzfr.CREATOR = new zzfs();
    }

    zzfr(Bundle bundle0, IBinder iBinder0) {
        this.zza = bundle0;
        this.zzb = iBinder0;
    }

    public zzfr(zzfq zzfq0) {
        this.zza = zzfq0.zza();
        this.zzb = zzfq0.zza;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBundle(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel0, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

