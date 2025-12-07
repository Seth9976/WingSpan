package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.IInterface;

public final class zzip extends zzb implements zzio {
    public static zzio zzb(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        return iInterface0 instanceof zzio ? ((zzio)iInterface0) : new zziq(iBinder0);
    }
}

