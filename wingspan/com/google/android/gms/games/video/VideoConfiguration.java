package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VideoConfiguration extends AbstractSafeParcelable {
    public static final class Builder {
        private int zza;
        private int zzb;
        private boolean zzc;
        private boolean zzd;
        private boolean zze;

        public Builder(int v, int v1) {
            this.zza = v;
            this.zzb = v1;
            this.zzd = true;
            this.zze = true;
            this.zzc = true;
        }

        public VideoConfiguration build() {
            return new VideoConfiguration(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder setCameraEnabled(boolean z) {
            this.zzd = z;
            return this;
        }

        public Builder setCaptureMode(int v) {
            this.zzb = v;
            return this;
        }

        public Builder setMicEnabled(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setQualityLevel(int v) {
            this.zza = v;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ValidCaptureModes {
    }

    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;
    public static final Parcelable.Creator CREATOR = null;
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;
    private final int zza;
    private final int zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;

    static {
        VideoConfiguration.CREATOR = new zzb();
    }

    public VideoConfiguration(int v, int v1, boolean z, boolean z1, boolean z2) {
        Preconditions.checkArgument(VideoConfiguration.isValidQualityLevel(v, false));
        Preconditions.checkArgument(VideoConfiguration.isValidCaptureMode(v1, false));
        this.zza = v;
        this.zzb = v1;
        this.zzc = z;
        this.zzd = z1;
        this.zze = z2;
    }

    public boolean getCameraEnabled() {
        return this.zzd;
    }

    public int getCaptureMode() {
        return this.zzb;
    }

    public boolean getMicEnabled() {
        return this.zze;
    }

    public int getQualityLevel() {
        return this.zza;
    }

    public static boolean isValidCaptureMode(int v, boolean z) {
        return v == -1 ? z : v == 0 || v == 1;
    }

    public static boolean isValidQualityLevel(int v, boolean z) {
        return v == -1 ? z : v == 0 || v == 1 || (v == 2 || v == 3);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getQualityLevel());
        SafeParcelWriter.writeInt(parcel0, 2, this.getCaptureMode());
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zzc);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.getCameraEnabled());
        SafeParcelWriter.writeBoolean(parcel0, 9, this.getMicEnabled());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

