package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzgr;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    public final Message zzhk;
    private final int zzje;
    public final zze zzjf;
    public final zza zzjg;
    public final zzgs zzjh;
    private final byte[] zzji;

    static {
        Update.CREATOR = new zzci();
    }

    Update(int v, int v1, Message message0, zze zze0, zza zza0, zzgs zzgs0, byte[] arr_b) {
        this.versionCode = v;
        if(Update.zza(v1, 2)) {
            zze0 = null;
            v1 = 2;
            zza0 = null;
            zzgs0 = null;
            arr_b = null;
        }
        this.zzje = v1;
        this.zzhk = message0;
        this.zzjf = zze0;
        this.zzjg = zza0;
        this.zzjh = zzgs0;
        this.zzji = arr_b;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Update ? this.zzje == ((Update)object0).zzje && Objects.equal(this.zzhk, ((Update)object0).zzhk) && Objects.equal(this.zzjf, ((Update)object0).zzjf) && Objects.equal(this.zzjg, ((Update)object0).zzjg) && Objects.equal(this.zzjh, ((Update)object0).zzjh) && Arrays.equals(this.zzji, ((Update)object0).zzji) : false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zzje, this.zzhk, this.zzjf, this.zzjg, this.zzjh, this.zzji});
    }

    @Override
    public String toString() {
        ArraySet arraySet0 = new ArraySet();
        if(this.zzg(1)) {
            arraySet0.add("FOUND");
        }
        if(this.zzg(2)) {
            arraySet0.add("LOST");
        }
        if(this.zzg(4)) {
            arraySet0.add("DISTANCE");
        }
        if(this.zzg(8)) {
            arraySet0.add("BLE_SIGNAL");
        }
        if(this.zzg(16)) {
            arraySet0.add("DEVICE");
        }
        if(this.zzg(0x20)) {
            arraySet0.add("BLE_RECORD");
        }
        String s = String.valueOf(zzgr.zzd(this.zzji));
        return "Update{types=" + arraySet0 + ", message=" + this.zzhk + ", distance=" + this.zzjf + ", bleSignal=" + this.zzjg + ", device=" + this.zzjh + ", bleRecord=" + s + "}";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzje);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzhk, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzjf, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzjg, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzjh, v, false);
        SafeParcelWriter.writeByteArray(parcel0, 7, this.zzji, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    private static boolean zza(int v, int v1) {
        return (v & v1) != 0;
    }

    public final boolean zzg(int v) {
        return Update.zza(this.zzje, v);
    }
}

