package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzt;
import com.google.android.gms.drive.events.zzx;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final zze zzbv;
    final int zzda;
    private final zzx zzdb;
    private final zzt zzdc;
    final DriveId zzk;

    static {
        zzj.CREATOR = new zzk();
    }

    public zzj(int v, DriveId driveId0) {
        this(((DriveId)Preconditions.checkNotNull(driveId0)), 1, null, null, null);
    }

    zzj(DriveId driveId0, int v, zze zze0, zzx zzx0, zzt zzt0) {
        this.zzk = driveId0;
        this.zzda = v;
        this.zzbv = zze0;
        this.zzdb = zzx0;
        this.zzdc = zzt0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzk, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzbv, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzdb, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzdc, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

