package com.google.android.gms.drive;

import com.google.android.gms.common.internal.Objects;

public class TransferPreferencesBuilder {
    static final class zza implements TransferPreferences {
        private final int zzbl;
        private final boolean zzbm;
        private final int zzbn;

        zza(int v, boolean z, int v1) {
            this.zzbl = v;
            this.zzbm = z;
            this.zzbn = v1;
        }

        @Override
        public final boolean equals(Object object0) {
            return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && ((zza)object0).zzbl == this.zzbl && ((zza)object0).zzbm == this.zzbm && ((zza)object0).zzbn == this.zzbn;
        }

        @Override  // com.google.android.gms.drive.TransferPreferences
        public final int getBatteryUsagePreference() {
            return this.zzbn;
        }

        @Override  // com.google.android.gms.drive.TransferPreferences
        public final int getNetworkPreference() {
            return this.zzbl;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(new Object[]{this.zzbl, Boolean.valueOf(this.zzbm), this.zzbn});
        }

        @Override  // com.google.android.gms.drive.TransferPreferences
        public final boolean isRoamingAllowed() {
            return this.zzbm;
        }

        @Override
        public final String toString() {
            return String.format("NetworkPreference: %s, IsRoamingAllowed %s, BatteryUsagePreference %s", this.zzbl, Boolean.valueOf(this.zzbm), this.zzbn);
        }
    }

    public static final TransferPreferences DEFAULT_PREFERENCES;
    private int zzbl;
    private boolean zzbm;
    private int zzbn;

    static {
        TransferPreferencesBuilder.DEFAULT_PREFERENCES = new zza(1, true, 0x100);
    }

    public TransferPreferencesBuilder() {
        this(TransferPreferencesBuilder.DEFAULT_PREFERENCES);
    }

    public TransferPreferencesBuilder(FileUploadPreferences fileUploadPreferences0) {
        this.zzbl = fileUploadPreferences0.getNetworkTypePreference();
        this.zzbm = fileUploadPreferences0.isRoamingAllowed();
        this.zzbn = fileUploadPreferences0.getBatteryUsagePreference();
    }

    public TransferPreferencesBuilder(TransferPreferences transferPreferences0) {
        this.zzbl = transferPreferences0.getNetworkPreference();
        this.zzbm = transferPreferences0.isRoamingAllowed();
        this.zzbn = transferPreferences0.getBatteryUsagePreference();
    }

    public TransferPreferences build() {
        return new zza(this.zzbl, this.zzbm, this.zzbn);
    }

    public TransferPreferencesBuilder setBatteryUsagePreference(int v) {
        this.zzbn = v;
        return this;
    }

    public TransferPreferencesBuilder setIsRoamingAllowed(boolean z) {
        this.zzbm = z;
        return this;
    }

    public TransferPreferencesBuilder setNetworkPreference(int v) {
        this.zzbl = v;
        return this;
    }
}

