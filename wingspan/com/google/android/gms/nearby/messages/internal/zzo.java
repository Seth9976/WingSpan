package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.nearby.zza;
import com.google.android.gms.internal.nearby.zzc;
import java.util.List;

public final class zzo extends zza implements zzm {
    zzo(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(zzaf zzaf0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzaf0);
        this.transactOneway(1, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(List list0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        parcel0.writeTypedList(list0);
        this.transactOneway(4, parcel0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzb(zzaf zzaf0) throws RemoteException {
        Parcel parcel0 = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel0, zzaf0);
        this.transactOneway(2, parcel0);
    }
}

