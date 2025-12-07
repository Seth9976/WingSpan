package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final class Builder {
        private final DiscoveryOptions zzx;

        public Builder() {
            this.zzx = new DiscoveryOptions(null);
        }

        public Builder(DiscoveryOptions discoveryOptions0) {
            DiscoveryOptions discoveryOptions1 = new DiscoveryOptions(null);
            this.zzx = discoveryOptions1;
            discoveryOptions1.zzh = discoveryOptions0.zzh;
            discoveryOptions1.zzw = discoveryOptions0.zzw;
            discoveryOptions1.zzk = discoveryOptions0.zzk;
            discoveryOptions1.zzl = discoveryOptions0.zzl;
        }

        public final DiscoveryOptions build() {
            return this.zzx;
        }

        public final Builder setStrategy(Strategy strategy0) {
            this.zzx.zzh = strategy0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private Strategy zzh;
    private boolean zzk;
    private boolean zzl;
    private boolean zzw;

    static {
        DiscoveryOptions.CREATOR = new zzg();
    }

    private DiscoveryOptions() {
        this.zzw = false;
        this.zzk = true;
        this.zzl = true;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy0) {
        this.zzw = false;
        this.zzk = true;
        this.zzl = true;
        this.zzh = strategy0;
    }

    DiscoveryOptions(Strategy strategy0, boolean z, boolean z1, boolean z2) {
        this.zzh = strategy0;
        this.zzw = z;
        this.zzk = z1;
        this.zzl = z2;
    }

    DiscoveryOptions(zzf zzf0) {
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof DiscoveryOptions && Objects.equal(this.zzh, ((DiscoveryOptions)object0).zzh) && Objects.equal(Boolean.valueOf(this.zzw), Boolean.valueOf(((DiscoveryOptions)object0).zzw)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(((DiscoveryOptions)object0).zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(((DiscoveryOptions)object0).zzl));
    }

    public final Strategy getStrategy() {
        return this.zzh;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzh, Boolean.valueOf(this.zzw), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.getStrategy(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzw);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzk);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

