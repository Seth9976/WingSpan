package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.OnChangeListener;
import com.google.android.gms.drive.events.zzj;

final class zzdi {
    private OnChangeListener zzgg;
    private zzee zzgh;
    private DriveId zzk;

    zzdi(zzch zzch0, OnChangeListener onChangeListener0, DriveId driveId0) {
        Preconditions.checkState(zzj.zza(1, driveId0));
        this.zzgg = onChangeListener0;
        this.zzk = driveId0;
        Looper looper0 = zzch0.getLooper();
        Context context0 = zzch0.getApplicationContext();
        onChangeListener0.getClass();
        zzee zzee0 = new zzee(looper0, context0, 1, zzdj.zza(onChangeListener0));
        this.zzgh = zzee0;
        zzee0.zzf(1);
    }
}

