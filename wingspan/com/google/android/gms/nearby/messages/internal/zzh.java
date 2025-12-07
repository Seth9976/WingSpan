package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    @Deprecated
    private final String zzff;
    private final zzp zzhh;
    @Deprecated
    private final ClientAppContext zzhi;

    static {
        zzh.CREATOR = new zzi();
    }

    zzh(int v, IBinder iBinder0, String s, ClientAppContext clientAppContext0) {
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
        this.zzff = s;
        this.zzhi = ClientAppContext.zza(clientAppContext0, null, s, false);
    }

    zzh(IBinder iBinder0) {
        this(1, iBinder0, null, null);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeIBinder(parcel0, 2, this.zzhh.asBinder(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzff, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzhi, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

