package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.zzu;
import java.util.List;

public final class zzff extends zzu {
    public static final Parcelable.Creator CREATOR;
    private final DataHolder zzhr;
    private final List zzhs;
    private final zza zzht;
    private final boolean zzhu;

    static {
        zzff.CREATOR = new zzfg();
    }

    public zzff(DataHolder dataHolder0, List list0, zza zza0, boolean z) {
        this.zzhr = dataHolder0;
        this.zzhs = list0;
        this.zzht = zza0;
        this.zzhu = z;
    }

    @Override  // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzhr, v | 1, false);
        SafeParcelWriter.writeTypedList(parcel0, 3, this.zzhs, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzht, v | 1, false);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zzhu);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

