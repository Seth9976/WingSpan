package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.TransferPreferences;

@Deprecated
public final class zzei extends AbstractSafeParcelable implements FileUploadPreferences {
    public static final Parcelable.Creator CREATOR;
    private int zzbn;
    private int zzgy;
    private boolean zzgz;

    static {
        zzei.CREATOR = new zzej();
    }

    public zzei(int v, int v1, boolean z) {
        this.zzgy = v;
        this.zzbn = v1;
        this.zzgz = z;
    }

    public zzei(TransferPreferences transferPreferences0) {
        this(transferPreferences0.getNetworkPreference(), transferPreferences0.getBatteryUsagePreference(), transferPreferences0.isRoamingAllowed());
    }

    @Override  // com.google.android.gms.drive.FileUploadPreferences
    public final int getBatteryUsagePreference() {
        return zzei.zzi(this.zzbn) ? this.zzbn : 0;
    }

    @Override  // com.google.android.gms.drive.FileUploadPreferences
    public final int getNetworkTypePreference() {
        return zzei.zzh(this.zzgy) ? this.zzgy : 0;
    }

    @Override  // com.google.android.gms.drive.FileUploadPreferences
    public final boolean isRoamingAllowed() {
        return this.zzgz;
    }

    @Override  // com.google.android.gms.drive.FileUploadPreferences
    public final void setBatteryUsagePreference(int v) {
        if(!zzei.zzi(v)) {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        }
        this.zzbn = v;
    }

    @Override  // com.google.android.gms.drive.FileUploadPreferences
    public final void setNetworkTypePreference(int v) {
        if(!zzei.zzh(v)) {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        }
        this.zzgy = v;
    }

    @Override  // com.google.android.gms.drive.FileUploadPreferences
    public final void setRoamingAllowed(boolean z) {
        this.zzgz = z;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzgz);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    private static boolean zzh(int v) {
        return v == 1 || v == 2;
    }

    private static boolean zzi(int v) {
        return v == 0x100 || v == 0x101;
    }
}

