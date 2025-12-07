package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzc;

public final class VideoCapabilities extends zzc {
    public static final Parcelable.Creator CREATOR;
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;
    private final boolean[] zzd;
    private final boolean[] zze;

    static {
        VideoCapabilities.CREATOR = new zza();
    }

    public VideoCapabilities(boolean z, boolean z1, boolean z2, boolean[] arr_z, boolean[] arr_z1) {
        this.zza = z;
        this.zzb = z1;
        this.zzc = z2;
        this.zzd = arr_z;
        this.zze = arr_z1;
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof VideoCapabilities)) {
            return false;
        }
        return this == object0 ? true : Objects.equal(((VideoCapabilities)object0).getSupportedCaptureModes(), this.getSupportedCaptureModes()) && Objects.equal(((VideoCapabilities)object0).getSupportedQualityLevels(), this.getSupportedQualityLevels()) && Objects.equal(Boolean.valueOf(((VideoCapabilities)object0).isCameraSupported()), Boolean.valueOf(this.isCameraSupported())) && Objects.equal(Boolean.valueOf(((VideoCapabilities)object0).isMicSupported()), Boolean.valueOf(this.isMicSupported())) && Objects.equal(Boolean.valueOf(((VideoCapabilities)object0).isWriteStorageSupported()), Boolean.valueOf(this.isWriteStorageSupported()));
    }

    public boolean[] getSupportedCaptureModes() {
        return this.zzd;
    }

    public boolean[] getSupportedQualityLevels() {
        return this.zze;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.getSupportedCaptureModes(), this.getSupportedQualityLevels(), Boolean.valueOf(this.isCameraSupported()), Boolean.valueOf(this.isMicSupported()), Boolean.valueOf(this.isWriteStorageSupported())});
    }

    public boolean isCameraSupported() {
        return this.zza;
    }

    // 去混淆评级： 中等(50)
    public boolean isFullySupported(int v, int v1) {
        return this.zza && this.zzb && this.zzc && this.supportsCaptureMode(v) && this.supportsQualityLevel(v1);
    }

    public boolean isMicSupported() {
        return this.zzb;
    }

    public boolean isWriteStorageSupported() {
        return this.zzc;
    }

    public boolean supportsCaptureMode(int v) {
        Preconditions.checkState(VideoConfiguration.isValidCaptureMode(v, false));
        return this.zzd[v];
    }

    public boolean supportsQualityLevel(int v) {
        Preconditions.checkState(VideoConfiguration.isValidQualityLevel(v, false));
        return this.zze[v];
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("SupportedCaptureModes", this.getSupportedCaptureModes()).add("SupportedQualityLevels", this.getSupportedQualityLevels()).add("CameraSupported", Boolean.valueOf(this.isCameraSupported())).add("MicSupported", Boolean.valueOf(this.isMicSupported())).add("StorageWriteSupported", Boolean.valueOf(this.isWriteStorageSupported())).toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel0, 2, this.isMicSupported());
        SafeParcelWriter.writeBoolean(parcel0, 3, this.isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel0, 4, this.getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel0, 5, this.getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

