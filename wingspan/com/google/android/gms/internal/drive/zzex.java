package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;

public final class zzex extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final DriveId zzhc;

    static {
        zzex.CREATOR = new zzey();
    }

    public zzex(DriveId driveId0) {
        this.zzhc = driveId0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzhc, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

