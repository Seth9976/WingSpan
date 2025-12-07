package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzgf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final ParcelFileDescriptor zzin;
    private final IBinder zzio;
    private final String zzm;

    static {
        zzgf.CREATOR = new zzgg();
    }

    zzgf(ParcelFileDescriptor parcelFileDescriptor0, IBinder iBinder0, String s) {
        this.zzin = parcelFileDescriptor0;
        this.zzio = iBinder0;
        this.zzm = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzin, v | 1, false);
        SafeParcelWriter.writeIBinder(parcel0, 3, this.zzio, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

