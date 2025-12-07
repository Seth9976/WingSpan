package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    @Deprecated
    private final String zzff;
    @Deprecated
    private final boolean zzfg;
    @Deprecated
    private final String zzfj;
    private final int zzhf;
    private final zzp zzhh;
    @Deprecated
    private final ClientAppContext zzhi;
    private final zzaf zzis;
    private final Strategy zzit;
    @Deprecated
    private final boolean zziu;
    private final zzu zziv;

    static {
        zzbz.CREATOR = new zzca();
    }

    zzbz(int v, zzaf zzaf0, Strategy strategy0, IBinder iBinder0, String s, String s1, boolean z, IBinder iBinder1, boolean z1, ClientAppContext clientAppContext0, int v1) {
        zzp zzp0;
        this.versionCode = v;
        this.zzis = zzaf0;
        this.zzit = strategy0;
        zzu zzu0 = null;
        if(iBinder0 == null) {
            zzp0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp0 = iInterface0 instanceof zzp ? ((zzp)iInterface0) : new zzr(iBinder0);
        }
        this.zzhh = zzp0;
        this.zzff = s;
        this.zzfj = s1;
        this.zziu = z;
        if(iBinder1 != null) {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zzu0 = iInterface1 instanceof zzu ? ((zzu)iInterface1) : new zzw(iBinder1);
        }
        this.zziv = zzu0;
        this.zzfg = z1;
        this.zzhi = ClientAppContext.zza(clientAppContext0, s1, s, z1);
        this.zzhf = v1;
    }

    public zzbz(zzaf zzaf0, Strategy strategy0, IBinder iBinder0, IBinder iBinder1, int v) {
        this(2, zzaf0, strategy0, iBinder0, null, null, false, iBinder1, false, null, v);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzis, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzit, v, false);
        SafeParcelWriter.writeIBinder(parcel0, 4, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.zzff, false);
        SafeParcelWriter.writeString(parcel0, 6, this.zzfj, false);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zziu);
        SafeParcelWriter.writeIBinder(parcel0, 8, (this.zziv == null ? null : this.zziv.asBinder()), false);
        SafeParcelWriter.writeBoolean(parcel0, 9, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel0, 10, this.zzhi, v, false);
        SafeParcelWriter.writeInt(parcel0, 11, this.zzhf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

