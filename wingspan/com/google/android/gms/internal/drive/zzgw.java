package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public final class zzgw extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final DriveId zzis;
    private final List zzit;

    static {
        zzgw.CREATOR = new zzgx();
    }

    public zzgw(DriveId driveId0, List list0) {
        this.zzis = driveId0;
        this.zzit = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzis, v, false);
        SafeParcelWriter.writeTypedList(parcel0, 3, this.zzit, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

