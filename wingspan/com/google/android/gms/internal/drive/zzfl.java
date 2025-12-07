package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;

public final class zzfl extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int status;
    private static final List zzhx;
    final long zzhy;
    final long zzhz;
    private final List zzia;

    static {
        zzfl.zzhx = Collections.emptyList();
        zzfl.CREATOR = new zzfm();
    }

    public zzfl(long v, long v1, int v2, List list0) {
        this.zzhy = v;
        this.zzhz = v1;
        this.status = v2;
        this.zzia = list0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzhy);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzhz);
        SafeParcelWriter.writeInt(parcel0, 4, this.status);
        SafeParcelWriter.writeTypedList(parcel0, 5, this.zzia, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

