package com.google.android.gms.games.video;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public final class CaptureState {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final boolean zze;

    private CaptureState(boolean z, int v, int v1, boolean z1, boolean z2) {
        Preconditions.checkArgument(VideoConfiguration.isValidCaptureMode(v, true));
        Preconditions.checkArgument(VideoConfiguration.isValidQualityLevel(v1, true));
        this.zza = z;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = z1;
        this.zze = z2;
    }

    public int getCaptureMode() {
        return this.zzb;
    }

    public int getCaptureQuality() {
        return this.zzc;
    }

    public boolean isCapturing() {
        return this.zza;
    }

    public boolean isOverlayVisible() {
        return this.zzd;
    }

    public boolean isPaused() {
        return this.zze;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("IsCapturing", Boolean.valueOf(this.zza)).add("CaptureMode", this.zzb).add("CaptureQuality", this.zzc).add("IsOverlayVisible", Boolean.valueOf(this.zzd)).add("IsPaused", Boolean.valueOf(this.zze)).toString();
    }

    public static CaptureState zza(Bundle bundle0) {
        return bundle0 == null || bundle0.get("IsCapturing") == null ? null : new CaptureState(bundle0.getBoolean("IsCapturing", false), bundle0.getInt("CaptureMode", -1), bundle0.getInt("CaptureQuality", -1), bundle0.getBoolean("IsOverlayVisible", false), bundle0.getBoolean("IsPaused", false));
    }
}

