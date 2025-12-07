package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String fieldName;
    private final boolean zzmc;

    static {
        zzf.CREATOR = new zzg();
    }

    public zzf(String s, boolean z) {
        this.fieldName = s;
        this.zzmc = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return String.format(Locale.US, "FieldWithSortOrder[%s %s]", this.fieldName, (this.zzmc ? "ASC" : "DESC"));
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.fieldName, false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzmc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

