package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private zzdz zzar;
    private zzdg zzas;
    private String zzat;
    private byte[] zzau;
    private zzdw zzav;

    static {
        zzm.CREATOR = new zzp();
    }

    private zzm() {
    }

    zzm(IBinder iBinder0, IBinder iBinder1, String s, byte[] arr_b, IBinder iBinder2) {
        zzdg zzdg0;
        zzdz zzdz0;
        zzdw zzdw0 = null;
        if(iBinder0 == null) {
            zzdz0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz zzdz1 = iInterface0 instanceof zzdz ? ((zzdz)iInterface0) : new zzeb(iBinder0);
            zzdz0 = zzdz1;
        }
        if(iBinder1 == null) {
            zzdg0 = null;
        }
        else {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            zzdg zzdg1 = iInterface1 instanceof zzdg ? ((zzdg)iInterface1) : new zzdi(iBinder1);
            zzdg0 = zzdg1;
        }
        if(iBinder2 != null) {
            IInterface iInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            zzdw0 = iInterface2 instanceof zzdw ? ((zzdw)iInterface2) : new zzdy(iBinder2);
        }
        this(zzdz0, zzdg0, s, arr_b, zzdw0);
    }

    private zzm(zzdz zzdz0, zzdg zzdg0, String s, byte[] arr_b, zzdw zzdw0) {
        this.zzar = zzdz0;
        this.zzas = zzdg0;
        this.zzat = s;
        this.zzau = arr_b;
        this.zzav = zzdw0;
    }

    zzm(zzn zzn0) {
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzm && Objects.equal(this.zzar, ((zzm)object0).zzar) && Objects.equal(this.zzas, ((zzm)object0).zzas) && Objects.equal(this.zzat, ((zzm)object0).zzat) && Arrays.equals(this.zzau, ((zzm)object0).zzau) && Objects.equal(this.zzav, ((zzm)object0).zzav);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzar, this.zzas, this.zzat, Arrays.hashCode(this.zzau), this.zzav});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzar == null ? null : this.zzar.asBinder()), false);
        SafeParcelWriter.writeIBinder(parcel0, 2, (this.zzas == null ? null : this.zzas.asBinder()), false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzat, false);
        SafeParcelWriter.writeByteArray(parcel0, 4, this.zzau, false);
        zzdw zzdw0 = this.zzav;
        if(zzdw0 != null) {
            iBinder0 = zzdw0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 5, iBinder0, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

