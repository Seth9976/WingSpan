package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final class zzgc extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private long durationMillis;
    private zzdz zzar;
    private zzdp zzel;
    private DiscoveryOptions zzem;
    private zzdr zzen;
    private String zzu;

    static {
        zzgc.CREATOR = new zzgf();
    }

    private zzgc() {
    }

    zzgc(IBinder iBinder0, IBinder iBinder1, String s, long v, DiscoveryOptions discoveryOptions0, IBinder iBinder2) {
        zzdp zzdp0;
        zzdz zzdz0;
        zzdr zzdr0 = null;
        if(iBinder0 == null) {
            zzdz0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz zzdz1 = iInterface0 instanceof zzdz ? ((zzdz)iInterface0) : new zzeb(iBinder0);
            zzdz0 = zzdz1;
        }
        if(iBinder1 == null) {
            zzdp0 = null;
        }
        else {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzdp zzdp1 = iInterface1 instanceof zzdp ? ((zzdp)iInterface1) : new zzdq(iBinder1);
            zzdp0 = zzdp1;
        }
        if(iBinder2 != null) {
            IInterface iInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzdr0 = iInterface2 instanceof zzdr ? ((zzdr)iInterface2) : new zzdt(iBinder2);
        }
        this(zzdz0, zzdp0, s, v, discoveryOptions0, zzdr0);
    }

    private zzgc(zzdz zzdz0, zzdp zzdp0, String s, long v, DiscoveryOptions discoveryOptions0, zzdr zzdr0) {
        this.zzar = zzdz0;
        this.zzel = zzdp0;
        this.zzu = s;
        this.durationMillis = v;
        this.zzem = discoveryOptions0;
        this.zzen = zzdr0;
    }

    zzgc(zzgd zzgd0) {
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzgc && Objects.equal(this.zzar, ((zzgc)object0).zzar) && Objects.equal(this.zzel, ((zzgc)object0).zzel) && Objects.equal(this.zzu, ((zzgc)object0).zzu) && Objects.equal(this.durationMillis, ((zzgc)object0).durationMillis) && Objects.equal(this.zzem, ((zzgc)object0).zzem) && Objects.equal(this.zzen, ((zzgc)object0).zzen);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzar, this.zzel, this.zzu, this.durationMillis, this.zzem, this.zzen});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzar == null ? null : this.zzar.asBinder()), false);
        SafeParcelWriter.writeIBinder(parcel0, 2, (this.zzel == null ? null : this.zzel.asBinder()), false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzu, false);
        SafeParcelWriter.writeLong(parcel0, 4, this.durationMillis);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzem, v, false);
        zzdr zzdr0 = this.zzen;
        if(zzdr0 != null) {
            iBinder0 = zzdr0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 6, iBinder0, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

