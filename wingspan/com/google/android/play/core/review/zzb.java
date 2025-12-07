package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        PendingIntent pendingIntent0 = (PendingIntent)parcel0.readParcelable(ReviewInfo.class.getClassLoader());
        return parcel0.readInt() == 0 ? new zza(pendingIntent0, false) : new zza(pendingIntent0, true);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ReviewInfo[v];
    }
}

