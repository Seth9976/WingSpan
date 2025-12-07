package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;

public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final List zza;
    private final PendingIntent zzb;
    private final String zzc;

    static {
        zzbq.CREATOR = new zzbr();
    }

    zzbq(List list0, PendingIntent pendingIntent0, String s) {
        this.zza = list0 == null ? zzbs.zzi() : zzbs.zzj(list0);
        this.zzb = pendingIntent0;
        this.zzc = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeStringList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzbq zza(List list0) {
        Preconditions.checkNotNull(list0, "geofence can\'t be null.");
        Preconditions.checkArgument(!list0.isEmpty(), "Geofences must contains at least one id.");
        return new zzbq(list0, null, "");
    }

    public static zzbq zzb(PendingIntent pendingIntent0) {
        Preconditions.checkNotNull(pendingIntent0, "PendingIntent can not be null.");
        return new zzbq(null, pendingIntent0, "");
    }
}

