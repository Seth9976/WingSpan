package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zzt;

public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzda;
    private final zzt zzdc;
    private final DriveId zzk;

    static {
        zzgs.CREATOR = new zzgt();
    }

    public zzgs(DriveId driveId0, int v) {
        this(driveId0, v, null);
    }

    zzgs(DriveId driveId0, int v, zzt zzt0) {
        this.zzk = driveId0;
        this.zzda = v;
        this.zzdc = zzt0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzk, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzdc, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

