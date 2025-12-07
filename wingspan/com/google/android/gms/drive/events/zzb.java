package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public final class zzb extends AbstractSafeParcelable implements DriveEvent {
    public static final Parcelable.Creator CREATOR;
    private final zze zzbv;

    static {
        zzb.CREATOR = new zzc();
    }

    public zzb(zze zze0) {
        this.zzbv = zze0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzbv, ((zzb)object0).zzbv);
        }
        return false;
    }

    @Override  // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 4;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzbv});
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", this.zzbv);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzbv, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

