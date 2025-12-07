package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;

public final class zzgj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int mode;
    private final DriveId zzdd;
    private final int zzip;

    static {
        zzgj.CREATOR = new zzgk();
    }

    public zzgj(DriveId driveId0, int v, int v1) {
        this.zzdd = driveId0;
        this.mode = v;
        this.zzip = v1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdd, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.mode);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzip);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

