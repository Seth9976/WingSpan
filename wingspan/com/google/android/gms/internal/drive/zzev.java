package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzev extends zzb implements zzeu {
    public static zzeu zza(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
        return iInterface0 instanceof zzeu ? ((zzeu)iInterface0) : new zzew(iBinder0);
    }
}

