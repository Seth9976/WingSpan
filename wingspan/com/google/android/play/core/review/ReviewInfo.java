package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public abstract class ReviewInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;

    static {
        ReviewInfo.CREATOR = new zzb();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(this.zza(), 0);
        parcel0.writeInt(((int)this.zzb()));
    }

    abstract PendingIntent zza();

    abstract boolean zzb();

    public static ReviewInfo zzc(PendingIntent pendingIntent0, boolean z) {
        return new zza(pendingIntent0, false);
    }
}

