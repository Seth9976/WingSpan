package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzbw;
    private final boolean zzbx;
    private final List zzby;

    static {
        zze.CREATOR = new zzf();
    }

    zze(int v, boolean z, List list0) {
        this.zzbw = v;
        this.zzbx = z;
        this.zzby = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzby, ((zze)object0).zzby) && this.zzbw == ((zze)object0).zzbw && this.zzbx == ((zze)object0).zzbx;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzby, this.zzbw, Boolean.valueOf(this.zzbx)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzbw);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzbx);
        SafeParcelWriter.writeTypedList(parcel0, 4, this.zzby, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

