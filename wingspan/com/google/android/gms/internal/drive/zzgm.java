package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public final class zzgm extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zzba;
    private final String[] zzbb;
    private final DriveId zzbd;
    private final FilterHolder zzbe;

    static {
        zzgm.CREATOR = new zzgn();
    }

    public zzgm(String s, String[] arr_s, DriveId driveId0, FilterHolder filterHolder0) {
        this.zzba = s;
        this.zzbb = arr_s;
        this.zzbd = driveId0;
        this.zzbe = filterHolder0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zzba, false);
        SafeParcelWriter.writeStringArray(parcel0, 3, this.zzbb, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzbd, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzbe, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

