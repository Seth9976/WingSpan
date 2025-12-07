package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.drive.zzh;

public final class zzr extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator CREATOR;
    private final zzh zzcs;

    static {
        zzr.CREATOR = new zzs();
    }

    public zzr(zzh zzh0) {
        this.zzcs = zzh0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzcs, ((zzr)object0).zzcs);
        }
        return false;
    }

    @Override  // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 8;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzcs});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzcs, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final zzh zzac() {
        return this.zzcs;
    }
}

