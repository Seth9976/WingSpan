package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private long zzaf;
    private zzdz zzar;

    static {
        zzq.CREATOR = new zzt();
    }

    private zzq() {
    }

    zzq(IBinder iBinder0, long v) {
        zzdz zzdz0;
        if(iBinder0 == null) {
            zzdz0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz0 = iInterface0 instanceof zzdz ? ((zzdz)iInterface0) : new zzeb(iBinder0);
        }
        this(zzdz0, v);
    }

    private zzq(zzdz zzdz0, long v) {
        this.zzar = zzdz0;
        this.zzaf = v;
    }

    zzq(zzr zzr0) {
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzq && Objects.equal(this.zzar, ((zzq)object0).zzar) && Objects.equal(this.zzaf, ((zzq)object0).zzaf);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzar, this.zzaf});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzar == null ? null : this.zzar.asBinder()), false);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

