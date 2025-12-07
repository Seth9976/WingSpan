package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    @Deprecated
    private final String zzff;
    @Deprecated
    private final boolean zzfg;
    @Deprecated
    private final String zzfj;
    private final zzp zzhh;
    @Deprecated
    private final ClientAppContext zzhi;
    private final zzm zziy;
    private final PendingIntent zzja;
    @Deprecated
    private final int zzjb;

    static {
        zzcg.CREATOR = new zzch();
    }

    public zzcg(int v, IBinder iBinder0, IBinder iBinder1, PendingIntent pendingIntent0, int v1, String s, String s1, boolean z, ClientAppContext clientAppContext0) {
        zzm zzm0;
        this.versionCode = v;
        zzp zzp0 = null;
        if(iBinder0 == null) {
            zzm0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzm0 = iInterface0 instanceof zzm ? ((zzm)iInterface0) : new zzo(iBinder0);
        }
        this.zziy = zzm0;
        if(iBinder1 != null) {
            IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzp0 = iInterface1 instanceof zzp ? ((zzp)iInterface1) : new zzr(iBinder1);
        }
        this.zzhh = zzp0;
        this.zzja = pendingIntent0;
        this.zzjb = v1;
        this.zzff = s;
        this.zzfj = s1;
        this.zzfg = z;
        this.zzhi = ClientAppContext.zza(clientAppContext0, s1, s, z);
    }

    public zzcg(IBinder iBinder0, IBinder iBinder1, PendingIntent pendingIntent0) {
        this(1, iBinder0, iBinder1, pendingIntent0, 0, null, null, false, null);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeIBinder(parcel0, 2, (this.zziy == null ? null : this.zziy.asBinder()), false);
        SafeParcelWriter.writeIBinder(parcel0, 3, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzja, v, false);
        SafeParcelWriter.writeInt(parcel0, 5, this.zzjb);
        SafeParcelWriter.writeString(parcel0, 6, this.zzff, false);
        SafeParcelWriter.writeString(parcel0, 7, this.zzfj, false);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.zzfg);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.zzhi, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

