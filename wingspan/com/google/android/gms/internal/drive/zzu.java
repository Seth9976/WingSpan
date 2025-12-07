package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zzba;
    private final DriveId zzbd;
    private final MetadataBundle zzdn;
    private final Integer zzdo;
    private final int zzj;

    static {
        zzu.CREATOR = new zzv();
    }

    public zzu(MetadataBundle metadataBundle0, int v, String s, DriveId driveId0, Integer integer0) {
        this.zzdn = metadataBundle0;
        this.zzj = v;
        this.zzba = s;
        this.zzbd = driveId0;
        this.zzdo = integer0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdn, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzj);
        SafeParcelWriter.writeString(parcel0, 4, this.zzba, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzbd, v, false);
        SafeParcelWriter.writeIntegerObject(parcel0, 6, this.zzdo, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

