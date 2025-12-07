package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class zzu extends AbstractSafeParcelable {
    private volatile transient boolean zzbt;

    public zzu() {
        this.zzbt = false;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkState(!this.zzbt);
        this.zzbt = true;
        this.zza(parcel0, v);
    }

    protected abstract void zza(Parcel arg1, int arg2);
}

