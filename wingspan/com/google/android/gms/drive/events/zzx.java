package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import java.util.Locale;

public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final List zzby;

    static {
        zzx.CREATOR = new zzy();
    }

    zzx(List list0) {
        this.zzby = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzby, ((zzx)object0).zzby);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzby});
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", this.zzby);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzby, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

