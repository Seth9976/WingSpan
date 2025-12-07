package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    final MetadataBundle zzdn;

    static {
        zzfy.CREATOR = new zzfz();
    }

    public zzfy(MetadataBundle metadataBundle0) {
        this.zzdn = metadataBundle0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdn, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final MetadataBundle zzaw() {
        return this.zzdn;
    }
}

