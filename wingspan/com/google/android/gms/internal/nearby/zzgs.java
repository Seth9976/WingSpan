package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzex;
    private static final String zzgu;
    public static final zzgs zzgv;
    private final String zzgw;
    private final String zzgx;

    static {
        zzgs.CREATOR = new zzgt();
        zzgs.zzgu = null;
        zzgs.zzgv = new zzgs("", null);
    }

    zzgs(int v, String s, String s1) {
        this.zzex = (int)(((Integer)Preconditions.checkNotNull(v)));
        if(s == null) {
            s = "";
        }
        this.zzgw = s;
        this.zzgx = s1;
    }

    private zzgs(String s, String s1) {
        this(1, s, null);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzgs ? Objects.equal(this.zzgw, ((zzgs)object0).zzgw) && Objects.equal(this.zzgx, ((zzgs)object0).zzgx) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzgw, this.zzgx});
    }

    @Override
    public final String toString() {
        return "NearbyDevice{handle=" + this.zzgw + ", bluetoothAddress=" + this.zzgx + "}";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 3, this.zzgw, false);
        SafeParcelWriter.writeString(parcel0, 6, this.zzgx, false);
        SafeParcelWriter.writeInt(parcel0, 1000, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

