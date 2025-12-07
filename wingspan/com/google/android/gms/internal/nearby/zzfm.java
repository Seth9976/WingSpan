package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzfm extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private zzdz zzar;
    private String zzat;

    static {
        zzfm.CREATOR = new zzfp();
    }

    private zzfm() {
    }

    zzfm(IBinder iBinder0, String s) {
        zzdz zzdz0;
        if(iBinder0 == null) {
            zzdz0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz0 = iInterface0 instanceof zzdz ? ((zzdz)iInterface0) : new zzeb(iBinder0);
        }
        this(zzdz0, s);
    }

    private zzfm(zzdz zzdz0, String s) {
        this.zzar = zzdz0;
        this.zzat = s;
    }

    zzfm(zzfn zzfn0) {
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzfm && Objects.equal(this.zzar, ((zzfm)object0).zzar) && Objects.equal(this.zzat, ((zzfm)object0).zzat);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzar, this.zzat});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzar == null ? null : this.zzar.asBinder()), false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzat, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

