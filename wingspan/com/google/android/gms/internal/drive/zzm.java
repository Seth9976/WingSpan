package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zzan;
    private final boolean zzao;
    private final boolean zzat;
    private final DriveId zzdd;
    private final MetadataBundle zzde;
    private final Contents zzdf;
    private final int zzdg;
    private final int zzdh;
    private final boolean zzdi;

    static {
        zzm.CREATOR = new zzn();
    }

    public zzm(DriveId driveId0, MetadataBundle metadataBundle0, int v, boolean z, com.google.android.gms.drive.zzn zzn0) {
        this(driveId0, metadataBundle0, null, zzn0.zzm(), zzn0.zzl(), zzn0.zzn(), v, z, zzn0.zzp());
    }

    zzm(DriveId driveId0, MetadataBundle metadataBundle0, Contents contents0, boolean z, String s, int v, int v1, boolean z1, boolean z2) {
        this.zzdd = driveId0;
        this.zzde = metadataBundle0;
        this.zzdf = contents0;
        this.zzao = z;
        this.zzan = s;
        this.zzdg = v;
        this.zzdh = v1;
        this.zzdi = z1;
        this.zzat = z2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzdd, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzde, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzdf, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zzao);
        SafeParcelWriter.writeString(parcel0, 6, this.zzan, false);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzdg);
        SafeParcelWriter.writeInt(parcel0, 8, this.zzdh);
        SafeParcelWriter.writeBoolean(parcel0, 9, this.zzdi);
        SafeParcelWriter.writeBoolean(parcel0, 10, this.zzat);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

