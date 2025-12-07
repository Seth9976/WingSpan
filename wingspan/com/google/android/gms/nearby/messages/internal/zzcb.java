package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    @Deprecated
    private String zzff;
    private final zzp zzhh;
    @Deprecated
    private final ClientAppContext zzhi;
    private final zzx zziw;
    public boolean zzix;

    static {
        zzcb.CREATOR = new zzcc();
    }

    zzcb(int v, IBinder iBinder0, IBinder iBinder1, boolean z, String s, ClientAppContext clientAppContext0) {
        zzx zzx0;
        zzp zzp0;
        this.versionCode = v;
        if(iBinder0 == null) {
            zzp0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp0 = iInterface0 instanceof zzp ? ((zzp)iInterface0) : new zzr(iBinder0);
        }
        this.zzhh = zzp0;
        if(iBinder1 == null) {
            zzx0 = null;
        }
        else {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            zzx0 = iInterface1 instanceof zzx ? ((zzx)iInterface1) : new zzz(iBinder1);
        }
        this.zziw = zzx0;
        this.zzix = z;
        this.zzff = s;
        this.zzhi = ClientAppContext.zza(clientAppContext0, null, s, false);
    }

    public zzcb(IBinder iBinder0, IBinder iBinder1) {
        this(1, iBinder0, iBinder1, false, null, null);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeIBinder(parcel0, 2, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel0, 3, this.zziw.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzix);
        SafeParcelWriter.writeString(parcel0, 5, this.zzff, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzhi, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

