package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zzv extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator CREATOR;
    private final List zzcu;

    static {
        zzv.CREATOR = new zzw();
    }

    public zzv(List list0) {
        this.zzcu = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzcu, ((zzv)object0).zzcu);
        }
        return false;
    }

    @Override  // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 7;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzcu});
    }

    @Override
    public final String toString() {
        return String.format("TransferStateEvent[%s]", TextUtils.join("\',\'", this.zzcu));
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 3, this.zzcu, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

