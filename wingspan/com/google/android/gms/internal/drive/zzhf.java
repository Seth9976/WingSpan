package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzhf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final DriveId zzdd;
    private final MetadataBundle zzde;

    static {
        zzhf.CREATOR = new zzhg();
    }

    public zzhf(DriveId driveId0, MetadataBundle metadataBundle0) {
        this.zzdd = driveId0;
        this.zzde = metadataBundle0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdd, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzde, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

