package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class zzfy extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private long durationMillis;
    private String name;
    private zzdj zzec;
    private zzec zzeh;
    private zzdd zzei;
    private AdvertisingOptions zzej;
    private String zzu;

    static {
        zzfy.CREATOR = new zzgb();
    }

    private zzfy() {
    }

    zzfy(IBinder iBinder0, IBinder iBinder1, String s, String s1, long v, AdvertisingOptions advertisingOptions0, IBinder iBinder2) {
        zzdd zzdd0;
        zzec zzec0;
        zzdj zzdj0 = null;
        if(iBinder0 == null) {
            zzec0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzec zzec1 = iInterface0 instanceof zzec ? ((zzec)iInterface0) : new zzee(iBinder0);
            zzec0 = zzec1;
        }
        if(iBinder1 == null) {
            zzdd0 = null;
        }
        else {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzdd zzdd1 = iInterface1 instanceof zzdd ? ((zzdd)iInterface1) : new zzdf(iBinder1);
            zzdd0 = zzdd1;
        }
        if(iBinder2 != null) {
            IInterface iInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzdj0 = iInterface2 instanceof zzdj ? ((zzdj)iInterface2) : new zzdl(iBinder2);
        }
        this(zzec0, zzdd0, s, s1, v, advertisingOptions0, zzdj0);
    }

    private zzfy(zzec zzec0, zzdd zzdd0, String s, String s1, long v, AdvertisingOptions advertisingOptions0, zzdj zzdj0) {
        this.zzeh = zzec0;
        this.zzei = zzdd0;
        this.name = s;
        this.zzu = s1;
        this.durationMillis = v;
        this.zzej = advertisingOptions0;
        this.zzec = zzdj0;
    }

    zzfy(zzfz zzfz0) {
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzfy && Objects.equal(this.zzeh, ((zzfy)object0).zzeh) && Objects.equal(this.zzei, ((zzfy)object0).zzei) && Objects.equal(this.name, ((zzfy)object0).name) && Objects.equal(this.zzu, ((zzfy)object0).zzu) && Objects.equal(this.durationMillis, ((zzfy)object0).durationMillis) && Objects.equal(this.zzej, ((zzfy)object0).zzej) && Objects.equal(this.zzec, ((zzfy)object0).zzec);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzeh, this.zzei, this.name, this.zzu, this.durationMillis, this.zzej, this.zzec});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzeh == null ? null : this.zzeh.asBinder()), false);
        SafeParcelWriter.writeIBinder(parcel0, 2, (this.zzei == null ? null : this.zzei.asBinder()), false);
        SafeParcelWriter.writeString(parcel0, 3, this.name, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzu, false);
        SafeParcelWriter.writeLong(parcel0, 5, this.durationMillis);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzej, v, false);
        zzdj zzdj0 = this.zzec;
        if(zzdj0 != null) {
            iBinder0 = zzdj0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 7, iBinder0, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

