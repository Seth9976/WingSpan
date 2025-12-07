package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzd extends zza implements zzf {
    zzd(IBinder iBinder0) {
        super(iBinder0, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override  // com.google.android.play.core.review.internal.zzf
    public final void zzc(String s, Bundle bundle0, zzh zzh0) throws RemoteException {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, bundle0);
        zzc.zzd(parcel0, zzh0);
        this.zzb(2, parcel0);
    }
}

