package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.BleSignal;

public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    private final int zzhb;
    private final int zzhc;

    static {
        zza.CREATOR = new zzb();
    }

    zza(int v, int v1, int v2) {
        this.versionCode = v;
        this.zzhb = v1;
        if(0xFFFFFF57 >= v2 || v2 >= 87) {
            v2 = 0x80000000;
        }
        this.zzhc = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof BleSignal)) {
            return false;
        }
        int v = ((BleSignal)object0).getRssi();
        if(this.zzhb == v) {
            int v1 = ((BleSignal)object0).getTxPower();
            return this.zzhc == v1;
        }
        return false;
    }

    @Override  // com.google.android.gms.nearby.messages.BleSignal
    public final int getRssi() {
        return this.zzhb;
    }

    @Override  // com.google.android.gms.nearby.messages.BleSignal
    public final int getTxPower() {
        return this.zzhc;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzhb, this.zzhc});
    }

    @Override
    public final String toString() {
        return "BleSignal{rssi=" + this.zzhb + ", txPower=" + this.zzhc + '}';
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzhb);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzhc);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

