package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.TransferPreferences;

public final class zzgo extends AbstractSafeParcelable implements TransferPreferences {
    public static final Parcelable.Creator CREATOR;
    private final boolean zzbm;
    private final int zzbn;
    private final int zzgy;

    static {
        zzgo.CREATOR = new zzgp();
    }

    zzgo(int v, int v1, boolean z) {
        this.zzgy = v;
        this.zzbn = v1;
        this.zzbm = z;
    }

    @Override  // com.google.android.gms.drive.TransferPreferences
    public final int getBatteryUsagePreference() {
        return this.zzbn;
    }

    @Override  // com.google.android.gms.drive.TransferPreferences
    public final int getNetworkPreference() {
        return this.zzgy;
    }

    @Override  // com.google.android.gms.drive.TransferPreferences
    public final boolean isRoamingAllowed() {
        return this.zzbm;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzbm);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

