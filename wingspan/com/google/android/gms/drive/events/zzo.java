package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.zzu;

public final class zzo extends zzu implements DriveEvent {
    public static final Parcelable.Creator CREATOR;
    private final DataHolder zzav;
    private final boolean zzcq;
    private final int zzcr;

    static {
        zzo.CREATOR = new zzp();
    }

    public zzo(DataHolder dataHolder0, boolean z, int v) {
        this.zzav = dataHolder0;
        this.zzcq = z;
        this.zzcr = v;
    }

    @Override  // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 3;
    }

    @Override  // com.google.android.gms.drive.zzu
    public final void zza(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzav, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzcq);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzcr);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final boolean zzaa() {
        return this.zzcq;
    }

    public final int zzab() {
        return this.zzcr;
    }

    public final DataHolder zzz() {
        return this.zzav;
    }
}

