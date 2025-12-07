package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzfq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String name;
    private zzdz zzar;
    private zzdg zzas;
    private String zzat;
    private byte[] zzau;
    private zzdm zzeb;
    private zzdj zzec;

    static {
        zzfq.CREATOR = new zzft();
    }

    private zzfq() {
    }

    zzfq(IBinder iBinder0, IBinder iBinder1, IBinder iBinder2, String s, String s1, byte[] arr_b, IBinder iBinder3) {
        zzdm zzdm0;
        zzdg zzdg0;
        zzdz zzdz0;
        zzdj zzdj0 = null;
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
        if(iBinder2 == null) {
            zzdm0 = null;
        }
        else {
            IInterface iInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            zzdm zzdm1 = iInterface2 instanceof zzdm ? ((zzdm)iInterface2) : new zzdo(iBinder2);
            zzdm0 = zzdm1;
        }
        if(iBinder3 != null) {
            IInterface iInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdj0 = iInterface3 instanceof zzdj ? ((zzdj)iInterface3) : new zzdl(iBinder3);
        }
        this(zzdz0, zzdg0, zzdm0, s, s1, arr_b, zzdj0);
    }

    private zzfq(zzdz zzdz0, zzdg zzdg0, zzdm zzdm0, String s, String s1, byte[] arr_b, zzdj zzdj0) {
        this.zzar = zzdz0;
        this.zzas = zzdg0;
        this.zzeb = zzdm0;
        this.name = s;
        this.zzat = s1;
        this.zzau = arr_b;
        this.zzec = zzdj0;
    }

    zzfq(zzfr zzfr0) {
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzfq && Objects.equal(this.zzar, ((zzfq)object0).zzar) && Objects.equal(this.zzas, ((zzfq)object0).zzas) && Objects.equal(this.zzeb, ((zzfq)object0).zzeb) && Objects.equal(this.name, ((zzfq)object0).name) && Objects.equal(this.zzat, ((zzfq)object0).zzat) && Arrays.equals(this.zzau, ((zzfq)object0).zzau) && Objects.equal(this.zzec, ((zzfq)object0).zzec);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzar, this.zzas, this.zzeb, this.name, this.zzat, Arrays.hashCode(this.zzau), this.zzec});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzar == null ? null : this.zzar.asBinder()), false);
        SafeParcelWriter.writeIBinder(parcel0, 2, (this.zzas == null ? null : this.zzas.asBinder()), false);
        SafeParcelWriter.writeIBinder(parcel0, 3, (this.zzeb == null ? null : this.zzeb.asBinder()), false);
        SafeParcelWriter.writeString(parcel0, 4, this.name, false);
        SafeParcelWriter.writeString(parcel0, 5, this.zzat, false);
        SafeParcelWriter.writeByteArray(parcel0, 6, this.zzau, false);
        zzdj zzdj0 = this.zzec;
        if(zzdj0 != null) {
            iBinder0 = zzdj0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 7, iBinder0, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

