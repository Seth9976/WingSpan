package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final MetadataBundle zzdn;
    private final DriveId zzdp;

    static {
        zzy.CREATOR = new zzz();
    }

    public zzy(DriveId driveId0, MetadataBundle metadataBundle0) {
        this.zzdp = (DriveId)Preconditions.checkNotNull(driveId0);
        this.zzdn = (MetadataBundle)Preconditions.checkNotNull(metadataBundle0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdp, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzdn, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

