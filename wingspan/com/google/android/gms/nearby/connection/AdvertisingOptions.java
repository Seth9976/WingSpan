package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class AdvertisingOptions extends AbstractSafeParcelable {
    public static final class Builder {
        private final AdvertisingOptions zzn;

        public Builder() {
            this.zzn = new AdvertisingOptions(null);
        }

        public Builder(AdvertisingOptions advertisingOptions0) {
            AdvertisingOptions advertisingOptions1 = new AdvertisingOptions(null);
            this.zzn = advertisingOptions1;
            advertisingOptions1.zzh = advertisingOptions0.zzh;
            advertisingOptions1.zzi = advertisingOptions0.zzi;
            advertisingOptions1.zzj = advertisingOptions0.zzj;
            advertisingOptions1.zzk = advertisingOptions0.zzk;
            advertisingOptions1.zzl = advertisingOptions0.zzl;
            advertisingOptions1.zzm = advertisingOptions0.zzm;
        }

        public final AdvertisingOptions build() {
            return this.zzn;
        }

        public final Builder setStrategy(Strategy strategy0) {
            this.zzn.zzh = strategy0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private Strategy zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private byte[] zzm;

    static {
        AdvertisingOptions.CREATOR = new zzb();
    }

    private AdvertisingOptions() {
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = true;
    }

    @Deprecated
    public AdvertisingOptions(Strategy strategy0) {
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = true;
        this.zzh = strategy0;
    }

    AdvertisingOptions(Strategy strategy0, boolean z, boolean z1, boolean z2, boolean z3, byte[] arr_b) {
        this.zzh = strategy0;
        this.zzi = z;
        this.zzj = z1;
        this.zzk = z2;
        this.zzl = z3;
        this.zzm = arr_b;
    }

    AdvertisingOptions(zza zza0) {
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof AdvertisingOptions && Objects.equal(this.zzh, ((AdvertisingOptions)object0).zzh) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(((AdvertisingOptions)object0).zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(((AdvertisingOptions)object0).zzj)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(((AdvertisingOptions)object0).zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(((AdvertisingOptions)object0).zzl)) && Arrays.equals(this.zzm, ((AdvertisingOptions)object0).zzm);
    }

    public final Strategy getStrategy() {
        return this.zzh;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzh, Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Arrays.hashCode(this.zzm)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.getStrategy(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzi);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzj);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzk);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zzl);
        SafeParcelWriter.writeByteArray(parcel0, 6, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

