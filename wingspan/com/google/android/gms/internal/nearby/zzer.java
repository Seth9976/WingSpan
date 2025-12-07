package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzer extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private String zzca;
    private String zzq;
    private String zzu;
    private BluetoothDevice zzv;

    static {
        zzer.CREATOR = new zzes();
    }

    private zzer() {
    }

    zzer(String s, String s1, String s2, BluetoothDevice bluetoothDevice0) {
        this.zzca = s;
        this.zzu = s1;
        this.zzq = s2;
        this.zzv = bluetoothDevice0;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzer && Objects.equal(this.zzca, ((zzer)object0).zzca) && Objects.equal(this.zzu, ((zzer)object0).zzu) && Objects.equal(this.zzq, ((zzer)object0).zzq) && Objects.equal(this.zzv, ((zzer)object0).zzv);
    }

    public final String getEndpointName() {
        return this.zzq;
    }

    public final String getServiceId() {
        return this.zzu;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzca, this.zzu, this.zzq, this.zzv});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zzca, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzu, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzq, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzv, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zze() {
        return this.zzca;
    }

    public final BluetoothDevice zzk() {
        return this.zzv;
    }
}

