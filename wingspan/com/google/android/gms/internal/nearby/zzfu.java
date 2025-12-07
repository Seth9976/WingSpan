package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzfu extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private zzdz zzar;
    private zzfh zzdk;
    private String[] zzee;
    private boolean zzef;

    static {
        zzfu.CREATOR = new zzfx();
    }

    private zzfu() {
    }

    zzfu(IBinder iBinder0, String[] arr_s, zzfh zzfh0, boolean z) {
        zzdz zzdz0;
        if(iBinder0 == null) {
            zzdz0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzdz0 = iInterface0 instanceof zzdz ? ((zzdz)iInterface0) : new zzeb(iBinder0);
        }
        this(zzdz0, arr_s, zzfh0, z);
    }

    private zzfu(zzdz zzdz0, String[] arr_s, zzfh zzfh0, boolean z) {
        this.zzar = zzdz0;
        this.zzee = arr_s;
        this.zzdk = zzfh0;
        this.zzef = z;
    }

    zzfu(zzfv zzfv0) {
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzfu && Objects.equal(this.zzar, ((zzfu)object0).zzar) && Arrays.equals(this.zzee, ((zzfu)object0).zzee) && Objects.equal(this.zzdk, ((zzfu)object0).zzdk) && Objects.equal(Boolean.valueOf(this.zzef), Boolean.valueOf(((zzfu)object0).zzef));
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzar, Arrays.hashCode(this.zzee), this.zzdk, Boolean.valueOf(this.zzef)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeIBinder(parcel0, 1, (this.zzar == null ? null : this.zzar.asBinder()), false);
        SafeParcelWriter.writeStringArray(parcel0, 2, this.zzee, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzdk, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzef);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

