package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zzan;
    private final Contents zzdf;
    private final MetadataBundle zzdn;
    private final Integer zzdo;
    private final DriveId zzdp;
    private final boolean zzdq;
    private final int zzdr;
    private final int zzds;

    static {
        zzw.CREATOR = new zzx();
    }

    public zzw(DriveId driveId0, MetadataBundle metadataBundle0, int v, int v1, ExecutionOptions executionOptions0) {
        this(driveId0, metadataBundle0, null, v1, executionOptions0.zzm(), executionOptions0.zzl(), executionOptions0.zzn(), v);
    }

    zzw(DriveId driveId0, MetadataBundle metadataBundle0, Contents contents0, int v, boolean z, String s, int v1, int v2) {
        if(contents0 != null && v2 != 0) {
            Preconditions.checkArgument(contents0.getRequestId() == v2, "inconsistent contents reference");
        }
        if(v == 0 && contents0 == null && v2 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzdp = (DriveId)Preconditions.checkNotNull(driveId0);
        this.zzdn = (MetadataBundle)Preconditions.checkNotNull(metadataBundle0);
        this.zzdf = contents0;
        this.zzdo = v;
        this.zzan = s;
        this.zzdr = v1;
        this.zzdq = z;
        this.zzds = v2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdp, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzdn, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzdf, v, false);
        SafeParcelWriter.writeIntegerObject(parcel0, 5, this.zzdo, false);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zzdq);
        SafeParcelWriter.writeString(parcel0, 7, this.zzan, false);
        SafeParcelWriter.writeInt(parcel0, 8, this.zzdr);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzds);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

